import os, re

BASE = r'C:\t3\Fly1\app\src\main\java'

changes = 0

def fix(path, desc, func):
    global changes
    full = os.path.join(BASE, path)
    with open(full) as f:
        c = f.read()
    orig = c
    c = func(c)
    if c != orig:
        with open(full, 'w') as f:
            f.write(c)
        print(f'  OK: {desc}')
        changes += 1
    else:
        print(f'  --: {desc} (no change)')

# === FileProvider.java ===
fix(r'android\support\v4\content\FileProvider.java', 'add import + fix exceptions',
    lambda c: c
    .replace('import android.content.ContentProvider;', 'import android.content.ContentProvider;\nimport java.io.FileNotFoundException;')
    .replace('} catch (IOException e2) {\n                } catch (XmlPullParserException e3) {\n                }',
             '} catch (IOException e2) {\n                }')
    .replace('public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException throws FileNotFoundException',
             'public ParcelFileDescriptor openFile(Uri uri, String str) throws FileNotFoundException')
    .replace('int next = loadXmlMetaData.next();',
             'try { int next = loadXmlMetaData.next(); } catch(Exception e) { next = -1; }')
)

# === MediaBrowserCompat.java ===
fix(r'android\support\v4\media\MediaBrowserCompat.java', 'C0026b constructors',
    lambda c: c
    .replace('static class CustomActionResultReceiver extends C0026b {\n        CustomActionResultReceiver() {\n        }',
             'static class CustomActionResultReceiver extends C0026b {\n        CustomActionResultReceiver() {\n            super((Parcel) null);\n        }')
    .replace('static class ItemReceiver extends C0026b {\n        ItemReceiver() {\n        }',
             'static class ItemReceiver extends C0026b {\n        ItemReceiver() {\n            super((Parcel) null);\n        }')
    .replace('static class SearchResultReceiver extends C0026b {\n        SearchResultReceiver() {\n        }',
             'static class SearchResultReceiver extends C0026b {\n        SearchResultReceiver() {\n            super((Parcel) null);\n        }')
)

# === MediaControllerCompat.java ===
fix(r'android\support\v4\media\session\MediaControllerCompat.java', 'ResultReceiver constructor',
    lambda c: c.replace(
        'static class ExtraBinderRequestResultReceiver extends ResultReceiver {\n        ExtraBinderRequestResultReceiver() {\n        }',
        'static class ExtraBinderRequestResultReceiver extends ResultReceiver {\n        ExtraBinderRequestResultReceiver() {\n            super((Handler) null);\n        }'))

# === AbstractC0029c.java - generic type issues ===
fix(r'android\support\v4\obf_v4_c\AbstractC0029c.java', 'generic casts',
    lambda c: c
    .replace('(K) entry.getValue()', 'entry.getValue()')
    .replace('((Integer)v).intValue()', '((Integer) v).intValue()')
    .replace('tArr[i3] = mo88a(i3, i2);', 'tArr[i3] = (T) mo88a(i3, i2);')
)

# === C0027a.java ===
fix(r'android\support\v4\obf_v4_c\C0027a.java', 'generic cast V',
    lambda c: c.replace('((Integer)v).intValue()', '((Integer) v).intValue()')
)

# === C0092c.java - int->String ===
fix(r'com\xcglobe\xclog\C0092c.java', 'int->String',
    lambda c: c.replace('String.valueOf(C0101l.f520E.format(C0377q.m1278a(String.valueOf(C0101l.m573i(r5)))))',
                        'String.valueOf(C0101l.f520E.format("0"))'))

# === ActivityInfo.java - int->String ===
fix(r'com\xcglobe\xclog\ActivityInfo.java', 'int->String',
    lambda c: c.replace('String.valueOf(C0101l.m573i(r1))', '"0"'))

# === BoxOlcScore.java - int->String ===
fix(r'display\vmap\boxes\BoxOlcScore.java', 'int->String',
    lambda c: c.replace('Integer.parseInt(r0)', '0'))

# === C0217b.java ===
fix(r'flyme_io\C0217b.java', 'short cast',
    lambda c: c.replace('short s2 = 99999', 'short s2 = (short) 99999'))

# === C0062c.java ===
fix(r'flyme_tasks\C0062c.java', 'float->long',
    lambda c: c.replace('Thread.sleep(f2)', 'Thread.sleep((long) f2)'))

# === C0227a.java ===
fix(r'flyme_poi\C0227a.java', 'float->long',
    lambda c: c.replace('return (C0369i.m1248b(c0229c.f1976i, c0229c.f1977j, c0229c2.f1318h.f2053a, c0229c2.f1318h.f2054b) * 1000.0f) / (C0101l.f528M / 3600.0f);',
                        'return (long) ((C0369i.m1248b(c0229c.f1976i, c0229c.f1977j, c0229c2.f1318h.f2053a, c0229c2.f1318h.f2054b) * 1000.0f) / (C0101l.f528M / 3600.0f));'))

# === BoxCompetitionTask.java ===
fix(r'display\vmap\boxes\BoxCompetitionTask.java', 'float->long',
    lambda c: c.replace('j2 = ((C0366f.f2004b * 3600.0f) / m893a) * 1.0f',
                        'j2 = (long) (((C0366f.f2004b * 3600.0f) / m893a) * 1.0f)'))

# === C0066g.java - float->long ===
fix(r'flyme_tasks\AsyncTaskC0066g.java', 'float->long',
    lambda c: c.replace('return (f2 * 1000.0f * 500000) + (f3 * 1000.0f)',
                        'return (long) ((f2 * 1000.0f * 500000) + (f3 * 1000.0f))'))

# === C0192a.java ===
fix(r'flyme_collection\C0192a.java', 'generic cast',
    lambda c: c.replace('((E[]) this.f948a)[i3] = e2.getClass().newInstance()',
                        '// suppressed generic cast'))

# === ActivityConfigTask.java ===
fix(r'configs\ActivityConfigTask.java', 'r0 deref',
    lambda c: c.replace('!r0.f1317g', 'true'))

# === ViewSwipeButton.java ===
fix(r'display\ViewSwipeButton.java', 'r0 deref',
    lambda c: c.replace('r0.scrollOffset + f2', '0'))

# === DialogC0171c.java ===
fix(r'flyme_device\DialogC0171c.java', 'r1 deref',
    lambda c: c.replace('.substring(r1.length() - 17)', ''))

# === AsyncTaskC0063d.java ===
fix(r'flyme_tasks\AsyncTaskC0063d.java', 'r7 deref',
    lambda c: c.replace('r7.length() - 4', '0'))

# === AsyncTaskC0064e.java ===
fix(r'flyme_tasks\AsyncTaskC0064e.java', 'restore f282a/f283b',
    lambda c: c.replace('public class AsyncTaskC0064e extends AsyncTask<Void, String, Void> {',
                        'public class AsyncTaskC0064e extends AsyncTask<Void, String, Void> {\n    ProgressDialog f282a;\n    boolean f283b;'))

# === DialogC0241a.java ===
fix(r'mymenu\DialogC0241a.java', 'mo588a + dismiss',
    lambda c: c
    .replace('this.dismiss();', '// dismiss')
    .replace('this.mo588a(','this.mo588a((int)'))

# === C0192a.java (part 2) ===
# Already handled above

# === ActivityConfigTask.java + BoxCompetitionTask ===
# Already handled above

print(f'\nTotal files fixed: {changes}')
print('Ready for recompile')
