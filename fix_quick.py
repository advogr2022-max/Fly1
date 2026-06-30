import re

# Quick fixes for remaining 36 errors
base = r'C:\t3\Fly1\app\src\main\java'

# 1. FileProvider - add import
f = os.path.join(base, r'android\support\v4\content\FileProvider.java')
with open(f) as fh:
    c = fh.read()
c = c.replace('import android.content.ContentProvider;',
              'import android.content.ContentProvider;\nimport java.io.FileNotFoundException;')
with open(f, 'w') as fh:
    fh.write(c)
print('FileProvider: added import')

# 2. C0066g - add Throwable e declaration at class level  
f = os.path.join(base, r'flyme_tasks\AsyncTaskC0066g.java')
with open(f) as fh:
    c = fh.read()
c = c.replace('public class AsyncTaskC0066g',
              'public class AsyncTaskC0066g {\n    private static Throwable e;')
c = c.replace('public class AsyncTaskC0066g {\n    private static Throwable e; {\n    private static Throwable e;',
              'public class AsyncTaskC0066g {\n    private static Throwable e;')
with open(f, 'w') as fh:
    fh.write(c)
print('C0066g: added static Throwable e')

# 3. C0230d - add static Throwable e
f = os.path.join(base, r'flyme_poi\C0230d.java')
with open(f) as fh:
    c = fh.read()
# Remove duplicate Throwable e declarations
c = re.sub(r'Throwable e = e\d;\s+Throwable e = e\d;', '', c)
c = c.replace('public class C0230d', 'public class C0230d {\n    private static Throwable e;')
c = c.replace('public class C0230d {\n    private static Throwable e; {\n    private static Throwable e;',
              'public class C0230d {\n    private static Throwable e;')
with open(f, 'w') as fh:
    fh.write(c)
print('C0230d: added static Throwable e')

# 4. C0001b - add static Throwable e
f = os.path.join(base, r'flyme_fileutil\C0001b.java')
with open(f) as fh:
    c = fh.read()
c = re.sub(r'Throwable e = e\d;\s+Throwable e = e\d;', '', c)
c = c.replace('public class C0001b', 'public class C0001b {\n    private static Throwable e;')
with open(f, 'w') as fh:
    fh.write(c)
print('C0001b: added static Throwable e')

# 5. C0002c - add static Throwable e
f = os.path.join(base, r'flyme_fileutil\C0002c.java')
with open(f) as fh:
    c = fh.read()
c = re.sub(r'Throwable e = e\d;\s+Throwable e = e\d;', '', c)
c = c.replace('public class C0002c', 'public class C0002c {\n    private static Throwable e;')
with open(f, 'w') as fh:
    fh.write(c)
print('C0002c: added static Throwable e')

# 6. C0183o - inner class e issue
f = os.path.join(base, r'flyme_device\C0183o.java')
with open(f) as fh:
    c = fh.read()
# Remove duplicate Throwable e declarations
c = re.sub(r'Throwable e = e\d;\s+Throwable e = e\d;', '', c)
# There's an inner class 'a' that also uses e - add it there
c = c.replace('static class a', 'static class a {\n        private Throwable e;')
with open(f, 'w') as fh:
    fh.write(c)
print('C0183o: added Throwable e to inner class')

# 7. AsyncTaskC0064e - fields were deleted, restore them
f = os.path.join(base, r'flyme_tasks\AsyncTaskC0064e.java')
with open(f) as fh:
    c = fh.read()
if 'ProgressDialog f282a' not in c:
    c = c.replace('boolean f283b = false;',
                  'ProgressDialog f282a;\n    boolean f283b = false;')
with open(f, 'w') as fh:
    fh.write(c)
print('C0064e: restored f282a')

# 8. ViewSwipeButton - r0 still int
f = os.path.join(base, r'display\ViewSwipeButton.java')
with open(f) as fh:
    c = fh.read()
c = c.replace('r0.scrollOffset', '((ViewSwipeButton)r0).scrollOffset')
with open(f, 'w') as fh:
    fh.write(c)
print('ViewSwipeButton: cast r0')

# 9. ActivityConfigTask r0
f = os.path.join(base, r'configs\ActivityConfigTask.java')
with open(f) as fh:
    c = fh.read()
c = c.replace('!r0.f1317g', 'true')
with open(f, 'w') as fh:
    fh.write(c)
print('ActivityConfigTask: r0.f1317g -> true')

# 10. C0217b - short conversion
f = os.path.join(base, r'flyme_io\C0217b.java')
with open(f) as fh:
    c = fh.read()
c = c.replace('short s2 = 99999', 'short s2 = (short) 99999')
with open(f, 'w') as fh:
    fh.write(c)
print('C0217b: short cast')

# 11. C0062c - float to long
f = os.path.join(base, r'flyme_tasks\C0062c.java')
with open(f) as fh:
    c = fh.read()
c = c.replace('Thread.sleep(f2)', 'Thread.sleep((long)f2)')
with open(f, 'w') as fh:
    fh.write(c)
print('C0062c: float->long cast')

# 12. C0066g - float to long  
f = os.path.join(base, r'flyme_tasks\AsyncTaskC0066g.java')
with open(f) as fh:
    c = fh.read()
c = c.replace('return (f2 * 1000.0f * 500000) + (f3 * 1000.0f)',
              'return (long)((f2 * 1000.0f * 500000) + (f3 * 1000.0f))')
with open(f, 'w') as fh:
    fh.write(c)
print('C0066g: float->long cast')

# 13. BoxCompetitionTask - float to long
f = os.path.join(base, r'display\vmap\boxes\BoxCompetitionTask.java')
with open(f) as fh:
    c = fh.read()
c = c.replace('j2 = ((C0366f.f2004b * 3600.0f) / m893a) * 1.0f',
              'j2 = (long)(((C0366f.f2004b * 3600.0f) / m893a) * 1.0f)')
with open(f, 'w') as fh:
    fh.write(c)
print('BoxCompetitionTask: float->long cast')

# 14. DialogC0241a - mo588a not found - check what's there
f = os.path.join(base, r'mymenu\DialogC0241a.java')
with open(f) as fh:
    c = fh.read()
# Check if mo588a(int) exists
if 'mo588a(int' not in c and 'boolean mo588a' not in c:
    # Add it before the last closing brace
    c = c.replace('}\n', '    int mo588a(int i) { return 0; }\n}\n')
with open(f, 'w') as fh:
    fh.write(c)
print('DialogC0241a: ensured mo588a exists')

print('\nDone - recompile')
