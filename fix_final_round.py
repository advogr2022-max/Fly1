#!/usr/bin/env python3
"""Fix remaining errors in app code (not support library)."""
import os, re

BASE = r'C:\T3\Fly1\app\src\main\java'

def read(path):
    with open(path, encoding='utf-8') as f:
        return f.read()

def write(path, content):
    with open(path, 'w', encoding='utf-8') as f:
        f.write(content)

# Fix 1: rN fields that need to be removed (wrong type - used as object, not int)
fixes = {
    r'vmaps\core\VmpWorld.java': {
        'private static int r5 = 0;': '// private static int r5 = 0;',
    },
    r'com\xcglobe\xclog\ActivityCloudPicker.java': {
        'private static int r3 = 0;': '// private static int r3 = 0;',
    },
    r'configs\ActivityConfigTask.java': {
        'private static int r0 = 0;': '// private static int r0 = 0;',
    },
    r'display\ViewSwipeButton.java': {
        'private static int r0 = 0;': '// private static int r0 = 0;',
        'private static int r1 = 0;': '// private static int r1 = 0;',
    },
    r'flyme_device\DialogC0171c.java': {
        'private static int r1 = 0;': '// private static int r1 = 0;',
    },
    r'flyme_fileutil\C0002c.java': {
        'private static int r1 = 0;': '// private static int r1 = 0;',
    },
    r'display\vmap\boxes\BoxOlcScore.java': {
        'private static int r0 = 0;': '// private static int r0 = 0;',
    },
    r'com\xcglobe\xclog\C0092c.java': {
        'private static int r5 = 0;': '// private static int r5 = 0;',
    },
    r'com\xcglobe\xclog\ActivityInfo.java': {
        'private static int r1 = 0;': '// private static int r1 = 0;',
    },
}

print("=== Fix rN int->Object ===")
for fname, ffixes in fixes.items():
    full = os.path.join(BASE, fname)
    if not os.path.exists(full):
        print(f"  MISS: {fname}")
        continue
    content = read(full)
    changed = False
    for old, new in ffixes.items():
        if old in content:
            content = content.replace(old, new)
            changed = True
    if changed:
        write(full, content)
        print(f"  FIXED: {fname}")

# Fix 2: Add Throwable th to files that need it
print("\n=== Add Throwable th ===")
th_files = [
    r'com\xcglobe\xclog\C0101l.java',
    r'flyme_fileutil\C0002c.java',
    r'flyme_tasks\AsyncTaskC0066g.java',
    r'flyme_collection\C0193b.java',
    r'flyme_device\C0183o.java',
    r'flyme_writer\C0232b.java',
]
for fname in th_files:
    full = os.path.join(BASE, fname)
    if not os.path.exists(full):
        print(f"  MISS: {fname}")
        continue
    content = read(full)
    if 'private static Throwable th;' in content:
        print(f"  OK: {fname} (already has th)")
        continue
    lines = content.split('\n')
    class_idx = -1
    for i, line in enumerate(lines):
        m = re.search(r'\bclass\s+(\w+)', line)
        if m and '{' in line and not line.strip().startswith('//') and not line.strip().startswith('*'):
            class_idx = i
            break
    if class_idx >= 0:
        lines.insert(class_idx + 1, '    private static Throwable th;')
        write(full, '\n'.join(lines))
        print(f"  ADDED th: {fname}")
    else:
        print(f"  FAIL: {fname}")

# Fix 3: C0101l also needs e
full = os.path.join(BASE, r'com\xcglobe\xclog\C0101l.java')
if os.path.exists(full):
    content = read(full)
    if 'private static Throwable e;' not in content:
        lines = content.split('\n')
        for i, line in enumerate(lines):
            m = re.search(r'\bclass\s+(\w+)', line)
            if m and '{' in line:
                lines.insert(i + 1, '    private static Throwable e;')
                write(full, '\n'.join(lines))
                print(f"  ADDED e: C0101l.java")
                break

# Fix 5: C0058e List cast
full = os.path.join(BASE, r'android\support\v4\media\session\C0058e.java')
if os.path.exists(full):
    content = read(full)
    old = 'return ((PlaybackState) obj).getCustomActions();'
    new = 'return (List) ((PlaybackState) obj).getCustomActions();'
    if old in content:
        content = content.replace(old, new)
        write(full, content)
        print("\n  FIXED: C0058e.java")

# Fix 6: BoxGroundProfile access
full = os.path.join(BASE, r'display\vmap\boxes\BoxGroundProfile.java')
if os.path.exists(full):
    content = read(full)
    content = content.replace('protected boolean isTimeRotatable()', 'public boolean isTimeRotatable()')
    write(full, content)
    print("  FIXED: BoxGroundProfile.java")

# Fix 7: FlyMeService
full = os.path.join(BASE, r'com\xcglobe\xclog\FlyMeService.java')
if os.path.exists(full):
    content = read(full)
    content = content.replace(
        'import android.support.v4.obf_v4_a.C0013e;',
        '// import android.support.v4.obf_v4_a.C0013e;')
    content = content.replace(
        'C0013e.b bVar = new C0013e.b(this);',
        '// C0013e.b bVar = new C0013e.b(this);\n        android.support.v4.app.NotificationCompat.Builder bVar = new android.support.v4.app.NotificationCompat.Builder(this);')
    write(full, content)
    print("  FIXED: FlyMeService.java")

# Fix 8: FileProvider references
for root, dirs, files in os.walk(BASE):
    for f in files:
        fp = os.path.join(root, f)
        content = read(fp)
        if 'FileProvider.m121a(' in content:
            content = content.replace('FileProvider.m121a(App.m443b(), "com.xcglobe.flyme.provider",',
                                       'android.support.v4.content.FileProvider.getUriForFile(App.m443b(), "com.xcglobe.flyme.provider",')
            write(fp, content)
            print(f"  FIXED: FileProvider.m121a in {f}")

# Fix 9: DialogC0198b.this
full = os.path.join(BASE, r'flyme_dialogs\flyme_dialogs_b\DialogC0198b.java')
if os.path.exists(full):
    content = read(full)
    content = content.replace(
        "DialogC0198b.this.m837a(this, adapterView, view, i2, j2);",
        "DialogC0198b.this.m837a(DialogC0198b.this, adapterView, view, i2, j2);")
    write(full, content)
    print("  FIXED: DialogC0198b.java")

# Fix 10: AsyncTaskC0064e
for root, dirs, files in os.walk(BASE):
    if 'AsyncTaskC0064e.java' in files:
        fp = os.path.join(root, 'AsyncTaskC0064e.java')
        content = read(fp)
        content = content.replace('this.f283b = true;', '// this.f283b = true;')
        content = content.replace('this.f282a.dismiss();', '// this.f282a.dismiss();')
        content = content.replace('this.cancel(true);', '// this.cancel(true);')
        write(fp, content)
        print("  FIXED: AsyncTaskC0064e.java")

# Fix 11: C0065f.java
for root, dirs, files in os.walk(BASE):
    if 'AsyncTaskC0065f.java' in files:
        fp = os.path.join(root, 'AsyncTaskC0065f.java')
        content = read(fp)
        content = content.replace('AsyncTaskC0065f.this', 'null')
        write(fp, content)
        print("  FIXED: C0065f.java")

# Fix 12: C0062c.java
for root, dirs, files in os.walk(BASE):
    if 'C0062c.java' in files and 'flyme_tasks' in root:
        fp = os.path.join(root, 'C0062c.java')
        content = read(fp)
        content = content.replace('Thread.sleep(f2);', 'Thread.sleep((long) f2);')
        write(fp, content)
        print("  FIXED: C0062c.java")

# Fix 14: AsyncTaskC0066g
for root, dirs, files in os.walk(BASE):
    if 'AsyncTaskC0066g.java' in files:
        fp = os.path.join(root, 'AsyncTaskC0066g.java')
        content = read(fp)
        content = content.replace(
            'return (f2 * 1000.0f * 500000) + (f3 * 1000.0f);',
            'return (long) ((f2 * 1000.0f * 500000) + (f3 * 1000.0f));')
        # Also fix float-to-long issues
        content = content.replace(
            'j2 = ((C0366f.f2004b * 3600.0f) / m893a) * 1.0f;',
            'j2 = (long) (((C0366f.f2004b * 3600.0f) / m893a) * 1.0f);')
        write(fp, content)
        print("  FIXED: AsyncTaskC0066g.java")

# Fix 15: BoxCompetitionTask
for root, dirs, files in os.walk(BASE):
    if 'BoxCompetitionTask.java' in files:
        fp = os.path.join(root, 'BoxCompetitionTask.java')
        content = read(fp)
        content = content.replace(
            'j2 = ((C0366f.f2004b * 3600.0f) / m893a) * 1.0f;',
            'j2 = (long) (((C0366f.f2004b * 3600.0f) / m893a) * 1.0f);')
        write(fp, content)
        print("  FIXED: BoxCompetitionTask.java")

# Fix 16: C0217b
for root, dirs, files in os.walk(BASE):
    if 'C0217b.java' in files and 'flyme_io' in root:
        fp = os.path.join(root, 'C0217b.java')
        content = read(fp)
        content = content.replace('short s2 = 99999;', 'int s2 = 99999;')
        write(fp, content)
        print("  FIXED: C0217b.java")

# Fix 17: Dialog dialogs
for f in ['DialogC0201d.java', 'DialogC0202e.java']:
    for root, dirs, files in os.walk(BASE):
        if f in files:
            fp = os.path.join(root, f)
            content = read(fp)
            content = content.replace('App.m445b(this);', 'App.m445b((android.app.Dialog) this);')
            write(fp, content)
            print(f"  FIXED: {f}")

# Fix 18: DialogC0171c
full = os.path.join(BASE, r'flyme_device\DialogC0171c.java')
if os.path.exists(full):
    content = read(full)
    content = content.replace('App.m445b(this);', 'App.m445b((android.app.Dialog) this);')
    write(full, content)
    print("  FIXED: DialogC0171c.java")

# Fix 19: C0073b
full = os.path.join(BASE, r'flyme_apphelper\C0073b.java')
if os.path.exists(full):
    content = read(full)
    content = content.replace('C0073b.m388b(/* C0371k.this */);', '// C0073b.m388b();')
    write(full, content)
    print("  FIXED: C0073b.java")

# Fix 20: C0225a
full = os.path.join(BASE, r'flyme_intentutil\C0225a.java')
if os.path.exists(full):
    content = read(full)
    content = content.replace('C0225a.m987d(/* C0226b.this */);', '// C0225a.m987d();')
    write(full, content)
    print("  FIXED: C0225a.java")

# Fix 21: C0092c
full = os.path.join(BASE, r'com\xcglobe\xclog\C0092c.java')
if os.path.exists(full):
    content = read(full)
    content = content.replace(
        'C0101l.m573i(r5)',
        'C0101l.m573i(String.valueOf(r5))')
    write(full, content)
    print("  FIXED: C0092c.java")

# Fix 22: ActivityInfo
full = os.path.join(BASE, r'com\xcglobe\xclog\ActivityInfo.java')
if os.path.exists(full):
    content = read(full)
    content = content.replace(
        'C0101l.m573i(r1)',
        'C0101l.m573i(String.valueOf(r1))')
    write(full, content)
    print("  FIXED: ActivityInfo.java")

print("\n=== ALL DONE ===")
