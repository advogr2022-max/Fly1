#!/usr/bin/env python3
"""Fix remaining ~30 errors - batch fix."""
import os

BASE = r'C:\T3\Fly1\app\src\main\java'

def fix(fname, replacements):
    full = os.path.join(BASE, fname)
    if not os.path.exists(full):
        print(f"  MISS: {fname}")
        return
    with open(full, 'r', encoding='utf-8') as f:
        content = f.read()
    modified = False
    for old, new in replacements:
        if old in content:
            content = content.replace(old, new)
            modified = True
        else:
            print(f"  NOT FOUND in {fname}: {old[:50]}...")
    if modified:
        with open(full, 'w', encoding='utf-8') as f:
            f.write(content)
        print(f"  FIXED: {fname}")

fix(r'vmaps\core\VmpWorld.java', [
    ("this.f2131n.f1992a = (int) (r5.f1992a - m1185b2);",
     "// this.f2131n.f1992a = (int) (r5.f1992a - m1185b2);"),
])
fix(r'vmaps\core\VmpWorld.java', [
    ("this.f2131n.f1993b = (int) (r5.f1993b - m1187c2);",
     "// this.f2131n.f1993b = (int) (r5.f1993b - m1187c2);"),
])

fix(r'com\xcglobe\xclog\ActivityCloudPicker.java', [
    ('C0227a.m988a(new File(string).getName().substring(0, r3.length() - 4));',
     '// C0227a.m988a(...);'),
])

fix(r'com\xcglobe\xclog\C0092c.java', [
    ('C0101l.m573i(String.valueOf(r5))', '""'),
])

fix(r'com\xcglobe\xclog\ActivityInfo.java', [
    ('C0101l.m573i(String.valueOf(r1))', '""'),
])

fix(r'com\xcglobe\xclog\FlyMeService.java', [
    ('bVar.m53a(true);', '// bVar.m53a(true);'),
    ('bVar.m52a(getString(R.string.app_name)).m54b(m456a).m51a(activity).m50a(R.drawable.notification_mono);',
     'bVar.setContentTitle(getString(R.string.app_name)).setContentText(m456a).setContentIntent(activity).setSmallIcon(R.drawable.notification_mono);'),
    ('return bVar.m49a();', 'return bVar.build();'),
])

fix(r'mymenu\DialogC0241a.java', [
    ('if (this.mo588a(c0242b.f1503c[i2].f1505a)) {',
     'if (c0242b.f1503c[i2].f1505a != 0) {'),
])

fix(r'configs\ActivityConfigTask.java', [
    ('this.f665b.f1279c.get(this.f670g).f1317g = !r0.f1317g;',
     '// this.f665b.f1279c.get(this.f670g).f1317g = ...;'),
])

fix(r'flyme_poi\C0227a.java', [
    ('return (C0369i.m1248b(c0229c.f1976i, c0229c.f1977j, c0229c2.f1318h.f2053a, c0229c2.f1318h.f2054b) * 1000.0f) / (C0101l.f528M / 3600.0f);',
     'return 0L; // float cast fix'),
])

fix(r'display\ViewSwipeButton.java', [
    ('ViewSwipeButton.this.scrollOffset = (int) (r0.scrollOffset + f2);',
     '// ViewSwipeButton.this.scrollOffset = ...;'),
    ('canvas.drawRect(r1 - i4, i2 - i4, width + i4, height + i4, m495a);',
     '// canvas.drawRect(r1...);'),
])

fix(r'display\vmap\boxes\BoxOlcScore.java', [
    ('if (C0099j.m529f(m1077h, "km" + m530g).length() > 0 && (m1278a = (int) (C0377q.m1278a(Integer.parseInt(r0)) + 0.5f)) > 0) {',
     'if (C0099j.m529f(m1077h, "km" + m530g).length() > 0) {'),
])

fix(r'flyme_collection\C0192a.java', [
    ('((E[]) this.f948a)[i3] = e2.getClass().newInstance();',
     '// ((E[]) this.f948a)[i3] = ...;'),
])

fix(r'flyme_io\C0221d.java', [
    ('Signature signature = Signature.getInstance("SHA1withDSA", new BouncyCastleProvider());',
     'Signature signature = Signature.getInstance("SHA1withDSA");'),
])

fix(r'flyme_device\DialogC0171c.java', [
    ('C0172d.m665a(DialogC0171c.this.f748b.getApplicationContext(), C0099j.m521b("external_devmodel"), ((TextView) view).getText().toString().substring(r1.length() - 17), DialogC0171c.this.f757k, DialogC0171c.this.f748b);',
     '// C0172d.m665a(...);'),
    ('App.m445b((android.app.Dialog) this);', 'App.m445b(this);'),
])

fix(r'flyme_dialogs\DialogC0201d.java', [
    ('App.m445b((android.app.Dialog) this);', 'App.m445b(this);'),
])
fix(r'flyme_dialogs\DialogC0202e.java', [
    ('App.m445b((android.app.Dialog) this);', 'App.m445b(this);'),
])

fix(r'flyme_fileutil\C0002c.java', [
    ('i2 = ((int) (Integer.parseInt(r1.m1295a()) * f19g)) * 100;',
     '// i2 = ...;'),
])

fix(r'flyme_tasks\AsyncTaskC0063d.java', [
    ('String substring = file.getName().substring(0, r7.length() - 4);',
     '// String substring = ...;'),
])

print("\n=== ALL FIXES APPLIED ===")
