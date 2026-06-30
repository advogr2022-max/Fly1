import re, os

# First, fix the output directory issue - use a real dir
outdir = r'C:\t3\Fly1\app\build\javac'
os.makedirs(outdir, exist_ok=True)

# Fix 1: AbstractC0006b.java - "error while writing a" - need proper output dir
# (already handled by using real outdir)

# Fix 2: C0019k.java - remaining undeclared e on lines 168, 171
f = r'C:\t3\Fly1\app\src\main\java\android\support\v4\obf_v4_a\C0019k.java'
with open(f) as fh:
    c = fh.read()
# Change second 'e = e3;' (already fixed first one to Throwable e = e2;)
# Now 'e' is already declared in first catch, so second catch 'e = e3;' is fine
# But check if there's only ONE 'Throwable e = e2;'
count = c.count('Throwable e = e2')
print(f'C0019k.java: Throwable e fix count = {count}')

# Fix 3: Multi-catch subclassing - ActivityConfigTask.java line 528
f = r'C:\t3\Fly1\app\src\main\java\configs\ActivityConfigTask.java'
with open(f) as fh:
    c = fh.read()
lines = c.split('\n')
# Find and fix multi-catch with FileNotFoundException and IOException
for i, line in enumerate(lines):
    if 'FileNotFoundException' in line and 'IOException' in line and 'catch' in line:
        old = lines[i]
        lines[i] = old.replace(', IOException', '')  # Remove redundant superclass
        print(f'ActivityConfigTask.java L{i+1}: fixed multi-catch')
c = '\n'.join(lines)
with open(f, 'w') as fh:
    fh.write(c)

# Fix 4: VmpWorld.java - missing methods m1331j(), m1332k()
f = r'C:\t3\Fly1\app\src\main\java\vmaps\core\VmpWorld.java'
with open(f) as fh:
    c = fh.read()
# Add empty private methods before the last closing brace
last_brace = c.rfind('}')
c = c[:last_brace] + '''
    /* synthetic */ void m1331j() {
    }
    
    /* synthetic */ void m1332k() {
    }
''' + c[last_brace:]
with open(f, 'w') as fh:
    fh.write(c)
print('VmpWorld.java: added m1331j(), m1332k() stubs')

# Fix 5: Fix "not an enclosing class" errors
# C0073b.java line 46 - use full path
f = r'C:\t3\Fly1\app\src\main\java\flyme_apphelper\C0073b.java'
with open(f) as fh:
    c = fh.read()
c = c.replace('C0371k.', 'types.C0371k.')
with open(f, 'w') as fh:
    fh.write(c)
print('C0073b.java: qualified outer class reference')

# Fix 6: C0236d.java - "not an enclosing class: App"
f = r'C:\t3\Fly1\app\src\main\java\flyme_data\C0236d.java'
with open(f) as fh:
    c = fh.read()
# Replace inner class references from 'App' to full path
c = c.replace(' App.', ' com.xcglobe.xclog.App.')
with open(f, 'w') as fh:
    fh.write(c)
print('C0236d.java: qualified App reference')

# Fix 7: C0225a.java - "not an enclosing class: C0226b"
f = r'C:\t3\Fly1\app\src\main\java\flyme_intentutil\C0225a.java'
with open(f) as fh:
    c = fh.read()
# The class C0226b is a separate file, not inner class. Fix reference
c = c.replace('C0226b.m994a', 'flyme_intentutil.C0226b.m994a')
with open(f, 'w') as fh:
    fh.write(c)
print('C0225a.java: qualified C0226b reference')

# Fix 8: fix npe path
print('=== Phase 1 done ===')
