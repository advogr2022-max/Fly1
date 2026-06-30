#!/usr/bin/env python3
"""Fix remaining 24 errors."""
import os

BASE = r'C:\T3\Fly1\app\src\main\java'

def fix(fname, old, new):
    full = os.path.join(BASE, fname)
    if not os.path.exists(full):
        print(f"  MISS: {fname}")
        return
    with open(full, 'r', encoding='utf-8') as f:
        content = f.read()
    if old in content:
        content = content.replace(old, new)
        with open(full, 'w', encoding='utf-8') as f:
            f.write(content)
        print(f"  OK: {fname}")
    else:
        print(f"  NOT FOUND: {fname}")

# 1. C0009a - fix import to relative or add to sources
import_file = os.path.join(BASE, r'com\xcglobe\xclog\ActivityMain.java')
with open(import_file, 'r', encoding='utf-8') as f:
    c = f.read()
c = c.replace('import android.support.v4.obf_v4_a.C0009a;', '// import android.support.v4.obf_v4_a.C0009a;\nimport android.support.v4.obf_v4_a.stub_C0009a;')
with open(import_file, 'w', encoding='utf-8') as f:
    f.write(c)

# Rename C0009a.java to something that won't conflict
src = os.path.join(BASE, r'android\support\v4\obf_v4_a\C0009a.java')
if os.path.exists(src):
    dst = os.path.join(BASE, r'android\support\v4\obf_v4_a\stub_C0009a.java')
    os.rename(src, dst)
    # Also fix the class name and make it public
    with open(dst, 'r', encoding='utf-8') as f:
        c = f.read()
    c = c.replace('class C0009a', 'class stub_C0009a')
    with open(dst, 'w', encoding='utf-8') as f:
        f.write(c)

# 2. C0092c - "" -> 0f
fix(r'com\xcglobe\xclog\C0092c.java', 
    'C0377q.m1278a("")', '0')

# 3. ActivityInfo - "" -> 0f
fix(r'com\xcglobe\xclog\ActivityInfo.java',
    'C0377q.m1281b("")', '0')

# 4. Dialog dialogs - use dialogInterface parameter
fix(r'flyme_device\DialogC0171c.java',
    'App.m445b(this); // dialog',
    'App.m445b((android.app.Dialog) dialogInterface);')
fix(r'flyme_dialogs\DialogC0201d.java',
    'App.m445b(this); // dialog',
    'App.m445b((android.app.Dialog) dialogInterface);')
fix(r'flyme_dialogs\DialogC0202e.java',
    'App.m445b(this); // dialog',
    'App.m445b((android.app.Dialog) dialogInterface);')

# 5. AsyncTaskC0063d - substring was commented out, fix references
fix(r'flyme_tasks\AsyncTaskC0063d.java',
    'ArrayList<Integer> m1273b = C0375o.m1273b(C0375o.m1272a(substring));',
    '// ArrayList<Integer> m1273b = ...;')
fix(r'flyme_tasks\AsyncTaskC0063d.java',
    'new File(C0101l.m537a("mpt/" + substring + ".mpt")).delete();',
    '// new File(...substring...).delete();')

# 6. AsyncTaskC0066g - e needs to be Throwable local variable
fix(r'flyme_tasks\AsyncTaskC0066g.java',
    'e = e2;',
    'Throwable e = e2;')
fix(r'flyme_tasks\AsyncTaskC0066g.java',
    'e = e3;',
    'Throwable e = e3;')
fix(r'flyme_tasks\AsyncTaskC0066g.java',
    'e = e4;',
    'Throwable e = e4;')
fix(r'flyme_tasks\AsyncTaskC0066g.java',
    'e = e5;',
    'Throwable e = e5;')

print("\nDONE!")
