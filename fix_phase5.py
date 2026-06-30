import re, os

# Phase 5: Fix "int cannot be dereferenced" and "cannot find symbol e" issues
# For each file with these errors, analyze and fix

# Known type mappings for variables that should NOT be int
# (decompiler got the type wrong)
TYPE_OVERRIDES = {
    'ActivityCloudPicker.java:r3': 'String',     # used with .length()
    'ViewSwipeButton.java:r0': 'String',          # used with methods
    'ViewSwipeButton.java:r1': 'String',
    'DialogC0171c.java:r1': 'String',
}

# Files where 'e' is still missing (from earlier analysis)
# These files have catch blocks using 'e' but we added it as static field
# Fix: add Throwable e declaration at method start
E_MISSING_FILES = [
    'C0001b.java', 'C0002c.java', 'C0220c.java', 'C0193b.java',
    'C0183o.java', 'C0230d.java', 'C0239g.java'
]

# 1. Fix ActivityCloudPicker r3 type (int -> String)
f = r'C:\t3\Fly1\app\src\main\java\com\xcglobe\xclog\ActivityCloudPicker.java'
with open(f) as fh:
    c = fh.read()
# Find and fix the field declaration
c = re.sub(r'private static int r3;', 'private static String r3;', c)
with open(f, 'w') as fh:
    fh.write(c)
print('ActivityCloudPicker: r3 int -> String')

# 2. Fix VmpWorld.java - remove final from i2
f = r'C:\t3\Fly1\app\src\main\java\vmaps\core\VmpWorld.java'
with open(f) as fh:
    c = fh.read()
# Remove 'final' from 'final int i2' on line 196
c = c.replace('final int i2', 'int i2')
# Fix r5: change type from int to Object (since r5.f1993b is called)
# r5 was used as some object type (has fields f1992a, f1993b)
# We don't know the actual type, so use Object with cast
c = re.sub(r'private static int r5;', 'private static Object r5 = null;', c)
with open(f, 'w') as fh:
    fh.write(c)
print('VmpWorld: removed final from i2, r5 int -> Object')

# 3. Fix ViewSwipeButton.java - r0, r1 should be String
f = r'C:\t3\Fly1\app\src\main\java\display\ViewSwipeButton.java'
with open(f) as fh:
    c = fh.read()
c = re.sub(r'private static int r0;', 'private static String r0 = null;', c)
c = re.sub(r'private static int r1;', 'private static String r1 = null;', c)
with open(f, 'w') as fh:
    fh.write(c)
print('ViewSwipeButton: r0, r1 int -> String')

# 4. Fix DialogC0171c.java - r1 should be String
f = r'C:\t3\Fly1\app\src\main\java\flyme_device\DialogC0171c.java'
with open(f) as fh:
    c = fh.read()
c = re.sub(r'private static int r1;', 'private static String r1 = null;', c)
with open(f, 'w') as fh:
    fh.write(c)
print('DialogC0171c: r1 int -> String')

# 5. Fix ActivityConfigTask.java - r0 type, line 227-228
f = r'C:\t3\Fly1\app\src\main\java\configs\ActivityConfigTask.java'
with open(f) as fh:
    c = fh.read()
c = re.sub(r'private static int r0;', 'private static String r0 = null;', c)
with open(f, 'w') as fh:
    fh.write(c)
print('ActivityConfigTask: r0 int -> String')

# 6. Fix BoxGroundProfile isTimeRotatable override
# Change return type from boolean to void or fix the override
f = r'C:\t3\Fly1\app\src\main\java\display\vmap\boxes\BoxGroundProfile.java'
with open(f) as fh:
    c = fh.read()
# The method isTimeRotatable() returns boolean in parent but we need to match
# Change the override to match parent signature
c = c.replace('isTimeRotatable(', 'isTimeRotatable(boolean ')
with open(f, 'w') as fh:
    fh.write(c)
print('BoxGroundProfile: fixed isTimeRotatable signature')

# 7. Fix FaiAssistant.java - boolean cannot be converted to int at line 212
f = r'C:\t3\Fly1\app\src\main\java\display\vmap\features\FaiAssistant.java'
with open(f) as fh:
    c = fh.read()
# Line 212: int m1353c = view.world.m1353c(xyBase1); but m1353c returns boolean
# Fix: change to boolean
c = c.replace('int m1353c = view.world.m1353c(xyBase1);', 
              'boolean m1353cBool = view.world.m1353c(xyBase1);\n            int m1353c = m1353cBool ? 1 : 0;')
with open(f, 'w') as fh:
    fh.write(c)
print('FaiAssistant: fixed boolean/int mismatch')

print('\n=== Phase 5 complete ===')
