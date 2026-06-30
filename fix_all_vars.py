import re, os

# Comprehensive fixer for all decompilation errors

# Map: variable -> type for undeclared variables
VAR_TYPES = {}
for i in range(0, 100):
    VAR_TYPES[f'r{i}'] = 'int'
for v in ['r0', 'r1', 'r3', 'r4', 'r5', 'r6', 'r7', 'r8', 'r9', 'r10', 'r11', 'r12', 'r13']:
    VAR_TYPES[v] = 'int'
VAR_TYPES['e'] = 'Throwable'  
VAR_TYPES['th'] = 'Throwable'
VAR_TYPES['f282a'] = 'int'  # field reference
VAR_TYPES['f283b'] = 'int'

fixes = []

def fix_file(fpath, undeclared_vars):
    """Fix undeclared variables in a file"""
    if not os.path.exists(fpath):
        return []
    
    with open(fpath) as f:
        lines = f.readlines()
    
    applied = []
    
    # For simple catch-block patterns like 'e = e2;' where e should be Throwable e = e2
    for i, line in enumerate(lines):
        stripped = line.strip()
        
        # Fix: e = eN; -> Throwable e = eN; (first occurrence)
        m = re.match(r'^(\s*)e\s*=\s*(e\d)\s*;\s*$', stripped)
        if m and 'e' in undeclared_vars:
            indent = m.group(1)
            var_name = m.group(2)
            # Check if 'Throwable e' already exists in the file
            if not any('Throwable e' in l for l in lines):
                lines[i] = f'{indent}Throwable e = {var_name};\n'
                applied.append(f'L{i+1}: e = {var_name} -> Throwable e = {var_name}')
                undeclared_vars.discard('e')
                continue
        
        # Fix: th = thN; -> Throwable th = thN;
        m = re.match(r'^(\s*)th\s*=\s*(th\d+)\s*;\s*$', stripped)
        if m and 'th' in undeclared_vars:
            indent = m.group(1)
            var_name = m.group(2)
            if not any('Throwable th' in l for l in lines):
                lines[i] = f'{indent}Throwable th = {var_name};\n'
                applied.append(f'L{i+1}: th = {var_name} -> Throwable th = {var_name}')
                undeclared_vars.discard('th')
                continue
        
        # Fix: e = eN; (after Throwable e already declared) - keep as is, declaration already exists
        m = re.match(r'^\s*e\s*=\s*(e\d)\s*;\s*$', stripped)
        if m and 'e' not in undeclared_vars:
            pass  # e already declared, keep
    
    # For each undeclared rN variable, find the method body and add declaration
    # Strategy: find the first method in which the variable is used
    if undeclared_vars:
        # Add declarations at class level or method level
        # Most rN vars are local variables, add at first usage method level
        # Since we can't easily determine method boundaries, add them as class fields
        # Or better: replace first 'implements' or 'extends' or before first method
        
        # Simpler approach: add field declarations after the class opening
        for i, line in enumerate(lines):
            if re.match(r'^\s*public class\s', line) or re.match(r'^\s*class\s', line):
                # Find the opening brace
                for j in range(i, min(i+5, len(lines))):
                    if '{' in lines[j]:
                        insert_pos = j + 1
                        declarations = []
                        for var in sorted(undeclared_vars):
                            vtype = VAR_TYPES.get(var, 'int')
                            declarations.append(f'    private {vtype} {var};\n')
                        for decl in reversed(declarations):
                            lines.insert(insert_pos, decl)
                        applied.append(f'Added field decls: {", ".join(sorted(undeclared_vars))}')
                        undeclared_vars.clear()
                        break
                break
        
        if undeclared_vars:
            # Fallback: add at top of file after imports
            for i, line in enumerate(lines):
                if line.strip().startswith('package ') or line.strip().startswith('import '):
                    continue
                if line.strip() and not line.strip().startswith('/*') and not line.strip().startswith('*'):
                    declarations = []
                    for var in sorted(undeclared_vars):
                        vtype = VAR_TYPES.get(var, 'int')
                        declarations.append(f'    private {vtype} {var};\n')
                    lines[i:i] = declarations
                    applied.append(f'Added field decls (fallback): {", ".join(sorted(undeclared_vars))}')
                    undeclared_vars.clear()
                    break
    
    # Write back
    if applied:
        with open(fpath, 'w') as f:
            f.writelines(lines)
    
    return applied


# Process all files from the error log
with open(r'C:\t3\Fly1\errors_v3.txt') as f:
    text = f.read()

# Parse files and their undeclared variables
blocks = re.split(r'^([A-Z]:\\.+?\.java:\d+: error:)', text, flags=re.MULTILINE)
current_file = None
all_vars_by_file = {}

for block in blocks:
    m = re.match(r'^([A-Z]:\\.+?\.java):', block)
    if m:
        current_file = m.group(1)
        if current_file not in all_vars_by_file:
            all_vars_by_file[current_file] = set()
        continue
    
    if current_file and 'cannot find symbol' in block:
        for line in block.split('\n'):
            m2 = re.search(r'symbol:\s+variable\s+(\w+)', line)
            if m2:
                all_vars_by_file[current_file].add(m2.group(1))

total_fixes = 0
for fpath, vars_set in sorted(all_vars_by_file.items()):
    if vars_set:
        applied = fix_file(fpath, vars_set)
        if applied:
            short = fpath.split(chr(92) + 'java' + chr(92))[1]
            for a in applied:
                print(f'{short}: {a}')
                total_fixes += 1

print(f'\nTotal fix actions: {total_fixes}')
print(f'Files processed: {len(all_vars_by_file)}')
