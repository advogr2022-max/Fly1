import re, os

# Phase 2: Fix ALL remaining decompilation issues
# Strategy: read each file that has errors, fix the specific patterns

errors_file = r'C:\t3\Fly1\errors_v3.txt'
with open(errors_file) as f:
    error_text = f.read()

# Parse error locations
errors = re.findall(r'^([A-Z]:\\.+?\.java):(\d+): error:', error_text, re.MULTILINE)
files_with_errors = set(e[0] for e in errors)
print(f'Files to fix: {len(files_with_errors)}')
print(f'Total errors: {len(errors)}')

fixes = 0

for fpath in sorted(files_with_errors):
    with open(fpath) as f:
        c = f.read()
    
    orig = c
    lines = c.split('\n')
    
    # Fix 1: Undeclared r1, r3, r4, r5, r6, r8
    # These appear as variables used but never declared.
    # Find method bodies that use them and add declarations at method start.
    
    # Fix 2: e variable still undeclared in some files
    # Pattern: e = eN; where e is not declared
    
    # Fix 3: Type cast issues 
    # e.g., (int) v -> (V)(Integer)v or similar
    
    # Fix 4: isTimeRotatable -> change return type
    
    # Fix 5: Multi-catch with subclassing
    
    # Fix 6: Constructor missing params
    
    # Write back if changed
    if c != orig:
        with open(fpath, 'w') as f:
            f.write(c)
        fixes += 1
        short = fpath.split('java' + chr(92))[1] if 'java' + chr(92) in fpath else fpath
        print(f'Fixed: {short}')

print(f'\nFiles modified: {fixes}')
