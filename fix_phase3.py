import re, os

# Fix: change private fields to private static when used in static context
# Also fix all remaining "non-static variable X cannot be referenced from a static context"

errors_file = r'C:\t3\Fly1\errors_v4.txt'
with open(errors_file) as f:
    text = f.read()

# Find all "non-static variable X cannot be referenced from a static context" errors
static_errors = re.findall(r'non-static variable (\w+) cannot be referenced from a static context', text)
static_vars_per_file = {}
for line in text.split('\n'):
    m = re.match(r'^([A-Z]:\\.+?\.java):', line)
    if m:
        current_file = m.group(1)
    m2 = re.search(r'non-static variable (\w+) cannot be referenced from a static context', line)
    if m2 and current_file:
        if current_file not in static_vars_per_file:
            static_vars_per_file[current_file] = set()
        static_vars_per_file[current_file].add(m2.group(1))

print('=== Fixing static context issues ===')
fixes = 0
for fpath, vars_set in static_vars_per_file.items():
    if not os.path.exists(fpath):
        continue
    with open(fpath) as f:
        c = f.read()
    orig = c
    for var in vars_set:
        # Change 'private int var;' to 'private static int var;'
        c = re.sub(rf'private\s+(int|Throwable)\s+{re.escape(var)}\s*;', 
                    lambda m: f'private static {m.group(1)} {var};', c)
    if c != orig:
        with open(fpath, 'w') as f:
            f.write(c)
        short = fpath.split('java' + chr(92))[1]
        print(f'{short}: static-fixed {vars_set}')
        fixes += 1

print(f'\nFixed {fixes} files for static context')

# Fix multi-catch errors (subclassing in same catch)
print('\n=== Fixing multi-catch subclassing ===')
catch_fixes = 0
for line in text.split('\n'):
    m = re.match(r'^([A-Z]:\\.+?\.java):(\d+):', line)
    if m and 'multi-catch' in text:
        # We need to find the exact lines, let's do it file by file
        pass

# Find files with multi-catch errors
multi_catch_files = set()
for line in text.split('\n'):
    m = re.match(r'^([A-Z]:\\.+?\.java):', line)
    if m:
        current_file = m.group(1)
    if 'multi-catch' in line and current_file:
        multi_catch_files.add(current_file)

for fpath in multi_catch_files:
    if not os.path.exists(fpath):
        continue
    with open(fpath) as f:
        lines = f.readlines()
    orig = ''.join(lines)
    new_lines = []
    for line in lines:
        # Replace 'FileNotFoundException | IOException' with just 'IOException' (superclass)
        new_line = re.sub(r'\bFileNotFoundException\s*\|\s*', '', line)
        # Replace 'EOFException | IOException' with 'IOException' (superclass)
        new_line = re.sub(r'EOFException\s*\|\s*', '', new_line)
        new_lines.append(new_line)
    new_c = ''.join(new_lines)
    if new_c != orig:
        with open(fpath, 'w') as f:
            f.write(new_c)
        short = fpath.split('java' + chr(92))[1]
        print(f'{short}: multi-catch fixed')
        catch_fixes += 1

print(f'Fixed {catch_fixes} multi-catch files')
