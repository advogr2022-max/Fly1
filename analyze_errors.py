import re
with open(r'C:\t3\Fly1\errors_v2.txt') as f:
    lines = f.readlines()

# Group errors by file
errors_by_file = {}
for i, line in enumerate(lines):
    m = re.match(r'^([A-Z]:\\.+?\.java):(\d+): error: (.*)', line)
    if m:
        fname = m.group(1)
        lineno = int(m.group(2))
        errmsg = m.group(3)
        context = lines[i+1].strip() if i+1 < len(lines) else ''
        key = (fname, errmsg)
        if key not in errors_by_file:
            errors_by_file[key] = {'lines': [], 'context': context}
        errors_by_file[key]['lines'].append(lineno)

files_only = {}
for (fname, errmsg), info in errors_by_file.items():
    marker = r'java' + chr(92)
    if marker in fname:
        short = fname.split(marker)[1]
    else:
        short = fname
    if short not in files_only:
        files_only[short] = []
    files_only[short].append((errmsg, info['lines'], info['context']))

for fname in sorted(files_only.keys()):
    print(f'=== {fname} ===')
    for errmsg, lines_list, ctx in files_only[fname]:
        print(f'  {errmsg[:120]}')
        print(f'    lines: {lines_list[:5]}')
print(f'\nTotal files with errors: {len(files_only)}')
print(f'Total unique error types: {sum(len(v) for v in files_only.values())}')
