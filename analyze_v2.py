import re

with open(r'C:\t3\Fly1\errors_v3.txt') as f:
    text = f.read()

# Split by file paths
blocks = re.split(r'^([A-Z]:\\.+?\.java:\d+: error:)', text, flags=re.MULTILINE)

errors_by_file = {}
current_file = None

for block in blocks:
    m = re.match(r'^([A-Z]:\\.+?\.java):', block)
    if m:
        current_file = m.group(1)
        if current_file not in errors_by_file:
            errors_by_file[current_file] = {'cannot_find': [], 'other': []}
        continue
    
    if current_file and block.strip():
        if 'cannot find symbol' in block:
            # Extract variable name
            for line in block.split('\n'):
                m2 = re.search(r'symbol:\s+variable\s+(\w+)', line)
                if m2:
                    errors_by_file[current_file]['cannot_find'].append(m2.group(1))
        else:
            err_type = '???'
            for line in block.split('\n'):
                m2 = re.search(r'error: (.*)', line)
                if m2:
                    err_type = m2.group(1)[:80]
                    break
            errors_by_file[current_file]['other'].append(err_type)

for fpath in sorted(errors_by_file.keys()):
    short = fpath.split(chr(92) + 'java' + chr(92))[1] if chr(92) + 'java' + chr(92) in fpath else fpath
    info = errors_by_file[fpath]
    vars_list = info['cannot_find']
    others = info['other']
    if vars_list:
        vars_str = ', '.join(sorted(set(vars_list)))
        print(f'{short} [vars: {vars_str}]')
    for o in others:
        print(f'    {o}')
