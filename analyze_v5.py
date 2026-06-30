import re

with open(r'C:\t3\Fly1\errors_v5.txt') as f:
    text = f.read()

# Group by error message
err_counts = {}
lines = text.split('\n')
for i, line in enumerate(lines):
    m = re.search(r'error: (.*)', line)
    if m:
        err = m.group(1).strip()[:120]
        err_counts[err] = err_counts.get(err, 0) + 1

for err, count in sorted(err_counts.items(), key=lambda x: -x[1]):
    print(f'{count:3d}x {err}')
