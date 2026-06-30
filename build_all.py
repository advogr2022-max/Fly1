import zipfile, os, re

base = r'C:\t3\Fly1\app\src\main\java'

# Extract ALL files from ZIP (fresh)
z = zipfile.ZipFile(r'C:\t3\FlyMe_3.12_Beta_Source.zip')
for name in z.namelist():
    if name.endswith('.java') and 'src/main/java/' in name:
        rel = name.split('java/', 1)[1]
        data = z.read(name)
        dest = os.path.join(base, rel)
        os.makedirs(os.path.dirname(dest), exist_ok=True)
        with open(dest, 'wb') as f:
            f.write(data)

# Remove BouncyCastle source
for root, dirs, files in os.walk(os.path.join(base, 'org', 'bouncycastle')):
    for f in files:
        os.remove(os.path.join(root, f))

# NOW: apply fixes using DIRECT string replacement (no regex)
# Each fix is a tuple: (relative_path, old_string, new_string)
patches = [
    # C0218a.java - Tnaf.POW_2_WIDTH -> 16
    (r'flyme_io\flyme_io_b\C0218a.java',
     'import org.bouncycastle.math.ec.Tnaf;', ''),
    (r'flyme_io\flyme_io_b\C0218a.java',
     'Tnaf.POW_2_WIDTH', '16'),

    # FileProvider - add throws & fix
    (r'android\support\v4\content\FileProvider.java',
     'private static InterfaceC0031a m122a(Context context, String str) {',
     'private static InterfaceC0031a m122a(Context context, String str) throws IOException, XmlPullParserException {'),
    (r'android\support\v4\content\FileProvider.java',
     'private static int m120a(String str) {',
     'private static int m120a(String str) throws FileNotFoundException {'),
    (r'android\support\v4\content\FileProvider.java',
     'int i2;', 'int i2 = 0;'),

    # AbstractC0029c - generic fix
    (r'android\support\v4\obf_v4_c\AbstractC0029c.java',
     '(int) v', '((Integer) v).intValue()'),

    # C0027a - generic fix
    (r'android\support\v4\obf_v4_c\C0027a.java',
     '(int) v', '((Integer) v).intValue()'),

    # C0019k - e variable
    (r'android\support\v4\obf_v4_a\C0019k.java',
     '            e = e2;', '            Throwable e = e2;'),

    # FaiAssistant - ?? fix
    (r'display\vmap\features\FaiAssistant.java',
     '                    ?? m1353c = view.world.m1353c(xyBase1);',
     '                    boolean m1353c = view.world.m1353c(xyBase1);'),

    # DialogC0241a - dismiss
    (r'mymenu\DialogC0241a.java',
     'this.dismiss();', '/* this.dismiss(); */'),

    # C0220c - r9/r11
    (r'flyme_io\C0220c.java',
     'private static int r9;', 'private static double r9;'),
    (r'flyme_io\C0220c.java',
     'private static int r11;', 'private static double r11;'),

    # VmpWorld - final i2 + missing methods
    (r'vmaps\core\VmpWorld.java',
     'final int i2', 'int i2'),
]

# Apply patches
for rel_path, old, new in patches:
    full = os.path.join(base, rel_path)
    if not os.path.exists(full):
        print(f'MISS: {rel_path}')
        continue
    with open(full) as f:
        c = f.read()
    if old in c:
        c = c.replace(old, new, 1)
        with open(full, 'w') as f:
            f.write(c)
        print(f'PATCH: {rel_path}')
    else:
        print(f'N/A:   {rel_path} (pattern not found)')

print('\nPatches applied. Now add field declarations...')

# Add missing field declarations for rN, e, th variables
# Strategy: for each file that has 'cannot find symbol' for these,
# add 'private static int rN = 0;' or 'private static Throwable e;' etc

# Files needing int rN fields
int_fields = {
    'C0374n.java': ['r1', 'r3', 'r4', 'r6'],
    'C0371k.java': ['r6'],
    'C0365e.java': ['r7'],
    'C0385d.java': ['r4', 'r8'],
    'C0220c.java': [],
    'C0230d.java': ['r8'],
    'C0239g.java': ['r2'],
    'C0001b.java': [],
    'C0002c.java': ['r1'],
    'C0063d.java': ['r7'],
    'C0071k.java': ['r0'],
    'ActivityConfigTask.java': ['r0'],
    'BoxCompetitionTask.java': ['r0'],
    'BoxGroundProfile.java': ['r1', 'r13', 'r3'],
    'BoxOlcScore.java': ['r0'],
    'TaskPainter.java': ['r4', 'r10'],
    'ZoomIconPainter.java': ['r1'],
    'ViewSwipeButton.java': ['r0', 'r1'],
    'DialogC0171c.java': ['r1'],
    'ActivityCloudPicker.java': ['r3'],
    'C0092c.java': ['r5'],
    'ActivityInfo.java': ['r1'],
    'C0101l.java': [],
    'C0193b.java': [],
    'C0183o.java': [],
    'C0225a.java': [],
    'C0232b.java': [],
    'C0066g.java': [],
}

# Files needing Throwable e/th fields  
throwable_fields = {
    'C0101l.java': ['th', 'e'],
    'C0001b.java': ['e'],
    'C0002c.java': ['e', 'th'],
    'C0066g.java': ['e', 'th'],
    'C0230d.java': ['e'],
    'C0193b.java': ['th'],
    'C0183o.java': ['e', 'th'],
    'C0232b.java': ['th'],
    'C0225a.java': ['th'],
    'C0220c.java': ['th'],
    'C0217b.java': ['th'],
    'C0064e.java': ['th'],
    'C0065f.java': ['th'],
    'C0062c.java': ['th'],
    'BoxGroundProfile.java': ['th'],
}

# Apply field declarations
for fname, vars in list(int_fields.items()) + list(throwable_fields.items()):
    if not vars:
        continue
    # Find the file
    found = False
    for root, dirs, files in os.walk(base):
        if fname in files:
            fp = os.path.join(root, fname)
            found = True
            break
    if not found:
        continue
    
    with open(fp) as f:
        lines = f.readlines()
    
    # Find class opening and add field declarations
    cls_line = -1
    for i, line in enumerate(lines):
        if ' class ' in line and '{' in line:
            cls_line = i
            break
    
    if cls_line < 0:
        print(f'SKIP: {fname} - no class found')
        continue
    
    # Skip lines that already have these fields
    new_decls = []
    for v in vars:
        vtype = 'Throwable' if v in ['e', 'th'] else 'int'
        # Check if field already exists
        already = False
        for line in lines:
            if v in line and (f' {vtype} ' in line or f',{v}' in line or f' {v};' in line):
                already = True
                break
        if not already:
            default_val = ' = 0' if vtype == 'int' else ''
            new_decls.append(f'    private static {vtype} {v}{default_val};\n')
    
    if new_decls:
        insert_pos = cls_line + 1
        # Skip past opening brace line
        while insert_pos < len(lines) and '{' not in lines[insert_pos] and insert_pos < cls_line + 5:
            insert_pos += 1
        for decl in reversed(new_decls):
            lines.insert(insert_pos + 1, decl)
        
        with open(fp, 'w') as f:
            f.writelines(lines)
        print(f'FIELDS: {fname} -> {[v for v in vars]}')
    else:
        print(f'OK:    {fname} (already has fields)')

print('\nAll fixes complete!')
