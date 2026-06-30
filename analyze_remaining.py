import re, os

# Phase 4: Fix remaining issues

with open(r'C:\t3\Fly1\errors_v5.txt') as f:
    text = f.read()

# 1. "cannot find symbol" - still undeclared variables
# Let's find which variables are still missing
print("=== Still missing symbols ===")
for line in text.split('\n'):
    m = re.search(r'symbol:\s+variable\s+(\w+)', line)
    if m:
        print(f'  {m.group(1)}')

# 2. "int cannot be dereferenced" - called .method() on an int
# Usually means a field was declared as int but should be an object
print("\n=== int cannot be dereferenced locations ===")
for line in text.split('\n'):
    m = re.match(r'^([A-Z]:\\.+?\.java):(\d+):', line)
    if m:
        cf = m.group(1)
        cl = m.group(2)
    if 'int cannot be dereferenced' in line and cf:
        print(f'  {cf}:{cl}')

# 3. "already defined" - duplicate field declarations
print("\n=== Already defined ===")
for line in text.split('\n'):
    if 'already defined' in line:
        print(f'  {line[:100]}')

# 4. "not an enclosing class" - remaining
print("\n=== Not an enclosing class ===")
for line in text.split('\n'):
    if 'not an enclosing class' in line:
        m = re.match(r'^([A-Z]:\\.+?\.java):(\d+):', line)
        f = m.group(1) if m else '?'
        print(f'  {f}: {line[:100]}')

# 5. "cannot assign a value to final variable"
print("\n=== Final variable ===")
for line in text.split('\n'):
    if 'cannot assign a value to final variable' in line:
        m = re.match(r'^([A-Z]:\\.+?\.java):(\d+):', line)
        f = m.group(1) if m else '?'
        print(f'  {f}: {line[:100]}')

# 6. isTimeRotatable override issue
print("\n=== Override issues ===")
for line in text.split('\n'):
    if 'cannot override' in line:
        print(f'  {line[:120]}')
