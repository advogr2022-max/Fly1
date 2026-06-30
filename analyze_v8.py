import re

with open(r'C:\t3\Fly1\errors_v8.txt') as f:
    text = f.read()

# Group by file
blocks = re.findall(r'^([A-Z]:\\.+?\.java):(\d+): error: (.*?)$', text, re.MULTILINE)

files = {}
for fpath, lineno, errmsg in blocks:
    short = fpath.split('java' + chr(92))[1] if 'java' + chr(92) in fpath else fpath
    if short not in files:
        files[short] = []
    files[short].append((lineno, errmsg[:100]))

for fname, errs in sorted(files.items()):
    print(f'\n=== {fname} ===')
    for ln, msg in errs:
        print(f'  L{ln}: {msg}')
