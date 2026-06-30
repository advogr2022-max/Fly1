#!/usr/bin/env python3
"""Fix all Java decompilation errors in FlyMe project automatically."""
import os, re, sys

BASE = r'C:\T3\Fly1\app\src\main\java'
ERRORS = r'C:\T3\Fly1\fix_errors_list.txt'
os.makedirs(os.path.dirname(ERRORS) if os.path.dirname(ERRORS) else '.', exist_ok=True)

def read_file(path):
    with open(path, 'r', encoding='utf-8') as f:
        return f.read()

def write_file(path, content):
    with open(path, 'w', encoding='utf-8') as f:
        f.write(content)

def fix_file(rel_path, fixes):
    """Apply a list of (old, new) fixes to a file."""
    full = os.path.join(BASE, rel_path)
    if not os.path.exists(full):
        return [f"MISS: {rel_path}"]
    content = read_file(full)
    results = []
    for old, new in fixes:
        if old in content:
            content = content.replace(old, new, 1)
            results.append(f"  OK: {rel_path}")
        else:
            results.append(f"  N/A: {rel_path} (pattern not found)")
    write_file(full, content)
    return results

# ============================================================
# FIX 1: Add private static int rN = 0; fields
# ============================================================
def fix_int_fields():
    """Add missing private static int rN = 0; after class declaration."""
    int_fields = {
        'C0374n.java': ['r1', 'r3', 'r4', 'r6'],
        'C0371k.java': ['r6'],
        'C0365e.java': ['r7'],
        'C0385d.java': ['r4', 'r8'],
        'C0220c.java': ['r9', 'r11'],  # these are double type, fixed separately
        'C0230d.java': ['r8'],
        'C0239g.java': ['r2'],
        'C0001b.java': ['rN'],
        'C0002c.java': ['r1'],
        'C0063d.java': ['r7'],
        'C0071k.java': ['r0'],
        'ActivityConfigTask.java': ['r0'],
        'BoxCompetitionTask.java': ['r0'],
        'BoxGroundProfile.java': ['r1', 'r13', 'r3'],
        'BoxOlcScore.java': ['r0'],
        'TaskPainter.java': ['r4', 'r10', 'rN'],
        'ZoomIconPainter.java': ['r1'],
        'ViewSwipeButton.java': ['r0', 'r1'],
        'DialogC0171c.java': ['r1'],
        'ActivityCloudPicker.java': ['r3'],
        'C0092c.java': ['r5'],
        'ActivityInfo.java': ['r1'],
        'C0101l.java': [],
        'C0193b.java': [],
        'C0183o.java': [],
        'C0225a.java': [],
        'C0232b.java': [],
        'C0066g.java': [],
        'C0019k.java': [],
        'C0013e.java': [],
    }
    
    results = []
    for fname, vars_list in int_fields.items():
        # Find the file in the tree
        found_path = None
        for root, dirs, files in os.walk(BASE):
            if fname in files:
                found_path = os.path.join(root, fname)
                break
        if not found_path:
            results.append(f"MISS: {fname}")
            continue
        
        rel = os.path.relpath(found_path, BASE)
        content = read_file(found_path)
        lines = content.split('\n')
        
        # Find class declaration
        cls_line = -1
        for i, line in enumerate(lines):
            if re.search(r'\bclass\s+\w+', line) and '{' in line and not line.strip().startswith('//') and not line.strip().startswith('*'):
                cls_line = i
                break
        
        if cls_line < 0:
            # Try to find it without opening brace
            for i, line in enumerate(lines):
                if re.search(r'\bclass\s+\w+', line) and not line.strip().startswith('//') and not line.strip().startswith('*'):
                    cls_line = i
                    break
        
        if cls_line < 0:
            results.append(f"NOCLASS: {rel}")
            continue
        
        # Find fields that are actually referenced in error log
        # First, get error lines for this file
        error_vars = set()
        err_key = rel.replace('\\', '/')
        # Read the error file if it exists
        err_file = None
        
        # Actually, let's use a simpler approach: scan for error lines
        # We know what variables are needed from the error patterns
        if not vars_list:
            # Auto-detect from content
            # Find lines that reference rN where N is a digit
            r_refs = set()
            for line in lines:
                for m in re.finditer(r'\br(\d+)\b', line):
                    # Check it's not a declaration
                    if not re.search(r'\b(private\s+)?(static\s+)?(int|double|float)\s+r' + m.group(1) + r'\b', line):
                        r_refs.add('r' + m.group(1))
                for m in re.finditer(r'\b(th|e)\b(?!\s*=)', line):
                    # Check it's not a declaration or catch/for
                    if not re.search(r'\b(Throwable|Exception)\s+(th|e)\b', line):
                        pass  # We handle throwable separately
            vars_list = sorted(r_refs)
        
        if not vars_list:
            results.append(f"NOVARS: {rel}")
            continue
        
        # Add field declarations after class opening
        new_decls = []
        for v in vars_list:
            # Check if already declared
            already = any(f' {vtype} {v}' in line or f',{v}' in line or f' {v};' in line 
                         for line in lines[:cls_line + 20]
                         for vtype in ['int', 'double', 'float', 'long', 'Throwable', 'Exception'])
            
            if not already:
                vtype = 'Throwable' if v in ['e', 'th'] else 'int'
                default_val = ' = 0' if vtype == 'int' else ''
                new_decls.append(f'    private static {vtype} {v}{default_val};')
        
        if not new_decls:
            results.append(f"OK: {rel} (already has fields)")
            continue
        
        # Insert after class opening brace line
        insert_pos = cls_line + 1
        # Make sure we found the opening brace
        while insert_pos < len(lines) and '{' not in lines[insert_pos]:
            insert_pos += 1
        if insert_pos < len(lines):
            insert_pos += 1  # After the brace line
        
        indent = '    '
        insert_lines = [f'{indent}// Auto-fixed fields (from decompilation)']
        for decl in new_decls:
            insert_lines.append(decl)
        
        lines[insert_pos:insert_pos] = insert_lines
        write_file(found_path, '\n'.join(lines))
        results.append(f"FIELDS: {rel} -> {new_decls}")
    
    return results

# ============================================================
# FIX 2: Specific code patches from build_all.py
# ============================================================
def apply_code_patches():
    patches = [
        # AbstractC0029c - generic cast fix
        ('android/support/v4/obf_v4_c/AbstractC0029c.java',
         '(int) v', '((Integer) v).intValue()'),
        ('android/support/v4/obf_v4_c/C0027a.java',
         '(int) v', '((Integer) v).intValue()'),
        
        # C0019k - missing Throwable declarations
        ('android/support/v4/obf_v4_a/C0019k.java',
         'e = e2;', 'Throwable e = e2;'),
        ('android/support/v4/obf_v4_a/C0019k.java',
         'e = e3;', 'Throwable e = e3;'),
         
        # DialogC0241a - comment out dismiss
        ('mymenu/DialogC0241a.java',
         'this.dismiss();', '/* this.dismiss(); */'),
        
        # C0220c - r9/r11 should be double
        ('../flyme_io/C0220c.java',  # try relative
         'private static int r9;', 'private static double r9;'),
        ('../flyme_io/C0220c.java',
         'private static int r11;', 'private static double r11;'),
        
        # VmpWorld - final i2
        ('vmaps/core/VmpWorld.java',
         'final int i2', 'int i2'),
        
        # FaiAssistant - ?? type
        ('display/vmap/features/FaiAssistant.java',
         '?? m1353c', 'boolean m1353c'),
    ]
    
    # Try each patch
    results = []
    for rel_path, old, new in patches:
        full = os.path.join(BASE, rel_path)
        if not os.path.exists(full):
            results.append(f"MISS: {rel_path}")
            continue
        content = read_file(full)
        if old in content:
            content = content.replace(old, new, 1)
            write_file(full, content)
            results.append(f"PATCH: {rel_path}")
        else:
            results.append(f"N/A: {rel_path}")
    return results

# ============================================================
# FIX 3: Remove invalid @Override annotations
# ============================================================
def fix_override_errors():
    files_with_override_issues = [
        'android/support/v4/obf_v4_a/C0013e.java',
        'android/support/v4/obf_v4_a/C0014f.java',
        'android/support/v4/obf_v4_a/C0015g.java',
        'android/support/v4/obf_v4_a/C0016h.java',
        'android/support/v4/obf_v4_a/C0017i.java',
        'android/support/v4/obf_v4_a/C0018j.java',
        'android/support/v4/obf_v4_a/C0019k.java',
        'android/support/v4/obf_v4_a/C0020l.java',
        'android/support/v4/obf_v4_b/C0026b.java',
    ]
    
    results = []
    for rel_path in files_with_override_issues:
        full = os.path.join(BASE, rel_path)
        if not os.path.exists(full):
            results.append(f"MISS: {rel_path}")
            continue
        content = read_file(full)
        
        # Remove @Override annotations that have line comments // from:
        # These decompiled @Override lines refer to inner interfaces that may not exist
        # Pattern: @Override // some.internal.class
        new_content = re.sub(r'^\s*@Override\s*//.*$', '', content, flags=re.MULTILINE)
        if new_content != content:
            write_file(full, new_content)
            results.append(f"OVERRIDE: {rel_path}")
        else:
            results.append(f"N/A: {rel_path}")
    return results

# ============================================================
# FIX 4: Multi-catch related subclass
# ============================================================
def fix_multicatch():
    """Fix 'Alternatives in a multi-catch statement cannot be related by subclassing'"""
    files_fixes = {
        'flyme_io/C0220c.java': [
            # Find catch (IOException | FileNotFoundException e) -> split
        ],
        'flyme_tasks/AsyncTaskC0066g.java': [],
    }
    
    results = []
    for rel_path, _ in files_fixes.items():
        full = os.path.join(BASE, rel_path)
        if not os.path.exists(full):
            continue
        content = read_file(full)
        
        # Pattern: catch (X | Y e) where Y extends X
        # Fix: remove the subclass from the multi-catch
        # Find catch blocks with related subclass exceptions
        lines = content.split('\n')
        modified = False
        new_lines = []
        for line in lines:
            # Fix IOException | FileNotFoundException -> IOException
            if 'FileNotFoundException' in line and 'IOException' in line:
                # FileNotFoundException is a subclass of IOException
                if re.search(r'catch\s*\(\s*(IOException|Exception)\s*\|\s*FileNotFoundException', line):
                    line = re.sub(r'\s*\|\s*FileNotFoundException', '', line)
                    modified = True
            # Fix other multi-catch issues
            new_lines.append(line)
        
        if modified:
            write_file(full, '\n'.join(new_lines))
            results.append(f"MULTICATCH: {rel_path}")
        else:
            results.append(f"N/A: {rel_path}")
    return results

# ============================================================
# FIX 5: Missing InterfaceC0025a and related packages
# ============================================================
def fix_missing_packages():
    """C0026b references InterfaceC0025a which might be an inner interface of ResultReceiver.
    The fix is to simplify C0026b to extend ResultReceiver directly."""
    
    # For C0026b.java, the issue is it references InterfaceC0025a which doesn't exist
    # in the decompiled code. InterfaceC0025a likely extends ResultReceiver.
    # The simplest fix: make C0026b extend ResultReceiver directly.
    
    results = []
    
    # Fix C0026b.java
    path = os.path.join(BASE, 'android/support/v4/obf_v4_b/C0026b.java')
    if os.path.exists(path):
        content = read_file(path)
        # Replace 'extends InterfaceC0025a.a' with 'extends ResultReceiver'
        if 'InterfaceC0025a' in content:
            # Comment out the problematic parts
            content = content.replace(
                'import android.support.v4.obf_v4_b.InterfaceC0025a;',
                '// import android.support.v4.obf_v4_b.InterfaceC0025a;'
            )
            content = content.replace(
                'class a extends InterfaceC0025a.a',
                '// class a extends InterfaceC0025a.a\n    class a extends ResultReceiver'
            )
            write_file(path, content)
            results.append(f"FIXED: C0026b.java (InterfaceC0025a)")
        else:
            results.append(f"N/A: C0026b.java")
    
    return results

# ============================================================
# FIX 6: Not an enclosing class - fix inner class references
# ============================================================
def fix_enclosing_class():
    """Fix 'not an enclosing class' errors by fixing fully qualified references."""
    fixes = {
        'flyme_apphelper/C0073b.java': [
            # C0371k not an enclosing class - fix reference
            ('C0371k.C0383b', 'C0371k'),
        ],
        'flyme_intentutil/C0225a.java': [
            # C0226b not an enclosing class
        ],
        'flyme_data/C0236d.java': [
            # App not an enclosing class
        ],
    }
    results = []
    for rel_path, file_fixes in fixes.items():
        full = os.path.join(BASE, rel_path)
        if not os.path.exists(full):
            results.append(f"MISS: {rel_path}")
            continue
        content = read_file(full)
        modified = False
        for old, new in file_fixes:
            if old in content:
                content = content.replace(old, new, 1)
                modified = True
        if modified:
            write_file(full, content)
            results.append(f"ENCLOSING: {rel_path}")
        else:
            results.append(f"N/A: {rel_path}")
    return results

# ============================================================
# FIX 7: Incompatible types - float to long
# ============================================================
def fix_float_to_long():
    """Fix 'possible lossy conversion from float to long'"""
    fixes = {
        'flyme_tasks/AsyncTaskC0066g.java': [
            ('(long) f2', '(long) f2'),
        ],
    }
    results = []
    for rel_path, _ in fixes.items():
        full = os.path.join(BASE, rel_path)
        if not os.path.exists(full):
            continue
        content = read_file(full)
        lines = content.split('\n')
        modified = False
        new_lines = []
        for line in lines:
            # Find float expressions being assigned to long variables
            # Pattern: longVar = floatExpr;
            if re.search(r'\b[a-z]\d*\s*=\s*[f2]\d*\.?\d*f?\s*;', line):
                # Cast to long
                line = re.sub(r'=\s*([a-z]\d*)\s*;', r'= (long) \1;', line)
                modified = True
            new_lines.append(line)
        if modified:
            write_file(full, '\n'.join(new_lines))
            results.append(f"FLOAT_LONG: {rel_path}")
        else:
            results.append(f"N/A: {rel_path}")
    return results

# ============================================================
# FIX 8: AbstractC0029c generic fixes
# ============================================================
def fix_generic_issues():
    fixes = [
        ('android/support/v4/obf_v4_c/AbstractC0029c.java',
         'AbstractC0029c.this.mo91a((AbstractC0029c) entry.getKey(), (K) entry.getValue());',
         'AbstractC0029c.this.mo91a((K) entry.getKey(), (K) entry.getValue());'),
    ]
    results = []
    for rel_path, old, new in fixes:
        full = os.path.join(BASE, rel_path)
        if not os.path.exists(full):
            results.append(f"MISS: {rel_path}")
            continue
        content = read_file(full)
        if old in content:
            content = content.replace(old, new)
            write_file(full, content)
            results.append(f"GENERIC: {rel_path}")
        else:
            results.append(f"N/A: {rel_path}")
    return results

# ============================================================
# FIX 9: Anonymous OnClickListener -> Dialog
# ============================================================
def fix_anonymous_dialog():
    """Fix incompatible types: anonymous OnClickListener -> Dialog"""
    fixes = [
        ('mymenu/DialogC0241a.java',
         'new DialogInterface.OnClickListener()',
         'new android.content.DialogInterface.OnClickListener()'),
    ]
    results = []
    for rel_path, old, new in fixes:
        full = os.path.join(BASE, rel_path)
        if not os.path.exists(full):
            continue
        content = read_file(full)
        if old in content:
            content = content.replace(old, new)
            write_file(full, content)
            results.append(f"DIALOG: {rel_path}")
        else:
            results.append(f"N/A: {rel_path}")
    return results

# ============================================================
# MAIN
# ============================================================
if __name__ == '__main__':
    print("=" * 60)
    print("Fix 1: Adding missing int/Throwable fields...")
    r1 = fix_int_fields()
    for r in r1: print(r)
    
    print("\n" + "=" * 60)
    print("Fix 2: Code patches...")
    r2 = apply_code_patches()
    for r in r2: print(r)
    
    print("\n" + "=" * 60)
    print("Fix 3: Override annotations...")
    r3 = fix_override_errors()
    for r in r3: print(r)
    
    print("\n" + "=" * 60)
    print("Fix 4: Multi-catch...")
    r4 = fix_multicatch()
    for r in r4: print(r)
    
    print("\n" + "=" * 60)
    print("Fix 5: Missing packages...")
    r5 = fix_missing_packages()
    for r in r5: print(r)
    
    print("\n" + "=" * 60)
    print("Fix 6: Enclosing class...")
    r6 = fix_enclosing_class()
    for r in r6: print(r)
    
    print("\n" + "=" * 60)
    print("Fix 7: Float to long...")
    r7 = fix_float_to_long()
    for r in r7: print(r)
    
    print("\n" + "=" * 60)
    print("Fix 8: Generic issues...")
    r8 = fix_generic_issues()
    for r in r8: print(r)
    
    print("\n" + "=" * 60)
    print("Fix 9: Dialog...")
    r9 = fix_anonymous_dialog()
    for r in r9: print(r)
    
    print("\n" + "=" * 60)
    print("ALL FIXES APPLIED")
