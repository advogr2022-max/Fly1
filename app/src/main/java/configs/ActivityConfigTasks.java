package configs;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.view.Menu;
import android.view.MenuItem;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.ActivityCloudPicker;
import com.xcglobe.xclog.ActivityMap;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0099j;
import com.xcglobe.xclog.C0101l;
import configs.prefitems.C0167a;
import configs.prefitems.C0168b;
import java.io.File;
import java.util.Arrays;
import mymenu.DialogC0241a;
import flyme_tasks.AsyncTaskC0066g;
import flyme_tasks.AsyncTaskC0068i;
import flyme_poi.C0227a;
import flyme_poi.C0230d;
import types.C0377q;

/* loaded from: classes.dex */
public class ActivityConfigTasks extends C0166a {

    /* renamed from: a */
    public static int f684a;

    /* renamed from: b */
    String f685b = null;

    /* renamed from: c */
    String f686c = null;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m610a(int i2) {
        Intent intent = new Intent(this.f711m, (Class<?>) ActivityCloudPicker.class);
        intent.putExtra("type", i2);
        this.f711m.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m614a(C0168b c0168b) {
        int i2;
        int i3;
        if (this.f686c == null) {
            return;
        }
        DialogC0241a dialogC0241a = new DialogC0241a(this, this.f686c) { // from class: configs.ActivityConfigTasks.7
            @Override // mymenu.DialogC0241a
            /* renamed from: a */
            public boolean mo588a(int i4) {
                if (i4 == 10) {
                    C0099j.m522b("active_wpfiles", ActivityConfigTasks.this.f686c);
                } else {
                    if (i4 != 20) {
                        if (i4 == 30) {
                            ActivityConfigTasks.this.m623i();
                            return true;
                        }
                        return true;
                    }
                    C0099j.m524c("active_wpfiles", ActivityConfigTasks.this.f686c);
                }
                ActivityConfigTasks.this.m624a();
                return true;
            }
        };
        if (c0168b.f718a) {
            i2 = 10;
            i3 = R.string.deactivate;
        } else {
            i2 = 20;
            i3 = R.string.activate;
        }
        dialogC0241a.m1100a(i2, App.m435a(i3));
        dialogC0241a.m1100a(30, App.m435a(R.string.delete));
        dialogC0241a.m1098a();
    }

    /* renamed from: d */
    private void m617d() {
        String[] m525c = C0099j.m525c("active_wpfiles");
        String[] m626c = m626c();
        PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference("wpfilesCategory");
        preferenceCategory.removeAll();
        for (int i2 = 0; i2 < m626c.length; i2++) {
            C0168b c0168b = new C0168b(this);
            c0168b.setKey(m626c[i2]);
            c0168b.setTitle(m626c[i2]);
            c0168b.f718a = Arrays.asList(m525c).contains(m626c[i2]);
            c0168b.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: configs.ActivityConfigTasks.1
                @Override // android.preference.Preference.OnPreferenceClickListener
                public boolean onPreferenceClick(Preference preference) {
                    ActivityConfigTasks.this.f686c = preference.getKey();
                    ActivityConfigTasks.this.m614a((C0168b) preference);
                    return false;
                }
            });
            preferenceCategory.addPreference(c0168b);
        }
    }

    /* renamed from: e */
    private void m619e() {
        String[] m625b = m625b();
        PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference("targetCategory");
        preferenceCategory.removeAll();
        for (int i2 = 0; i2 < m625b.length; i2++) {
            C0227a m1017a = C0230d.m1017a(m625b[i2]);
            if (m1017a != null && m1017a.f1279c.size() != 0) {
                C0167a c0167a = new C0167a(this);
                c0167a.setKey(m625b[i2]);
                if (C0227a.f1276a != null && m625b[i2].equals(C0227a.f1276a.f1278b)) {
                    c0167a.f717a = true;
                }
                c0167a.setTitle(m625b[i2]);
                c0167a.setSummary(m1017a.f1279c.get(0).f1979l + ", " + C0101l.f520E.format(C0377q.m1278a(m1017a.m1006h())) + " " + C0377q.f2082a);
                c0167a.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: configs.ActivityConfigTasks.2
                    @Override // android.preference.Preference.OnPreferenceClickListener
                    public boolean onPreferenceClick(Preference preference) {
                        ActivityConfigTasks.this.f685b = preference.getKey();
                        ActivityConfigTasks.this.m620f();
                        return false;
                    }
                });
                preferenceCategory.addPreference(c0167a);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m620f() {
        if (this.f685b == null) {
            return;
        }
        DialogC0241a dialogC0241a = new DialogC0241a(this, this.f685b) { // from class: configs.ActivityConfigTasks.6
            @Override // mymenu.DialogC0241a
            /* renamed from: a */
            public boolean mo588a(int i2) {
                if (i2 == 10) {
                    Intent intent = new Intent(ActivityConfigTasks.this.f711m, (Class<?>) ActivityConfigTask.class);
                    intent.putExtra("taskname", ActivityConfigTasks.this.f685b);
                    ActivityConfigTasks.this.f711m.startActivity(intent);
                    return true;
                }
                if (i2 == 20) {
                    C0227a.m988a((C0227a.f1276a == null || !C0227a.f1276a.f1278b.equals(ActivityConfigTasks.this.f685b)) ? ActivityConfigTasks.this.f685b : null);
                    ActivityConfigTasks.this.m624a();
                    return true;
                }
                if (i2 == 30) {
                    ActivityConfigTasks.this.m622h();
                    return true;
                }
                if (i2 != 40) {
                    if (i2 == 50) {
                        C0227a.m988a(ActivityConfigTasks.this.f685b);
                        if (C0227a.f1276a != null) {
                            AsyncTaskC0068i.m355a(ActivityConfigTasks.this.f711m);
                        }
                    }
                    return true;
                }
                C0227a.m988a(ActivityConfigTasks.this.f685b);
                Intent intent2 = new Intent(ActivityConfigTasks.this.f711m, (Class<?>) ActivityMap.class);
                intent2.putExtra("task", true);
                ActivityConfigTasks.this.f711m.startActivity(intent2);
                return true;
            }
        };
        dialogC0241a.m1100a(20, App.m435a(C0227a.f1276a != null && C0227a.f1276a.f1278b.equals(this.f685b) ? R.string.deactivate : R.string.activate));
        dialogC0241a.m1100a(10, App.m435a(R.string.edit));
        dialogC0241a.m1100a(50, App.m435a(R.string.demo));
        dialogC0241a.m1100a(30, App.m435a(R.string.delete));
        dialogC0241a.m1100a(40, App.m435a(R.string.map_display));
        dialogC0241a.m1098a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m621g() {
        Intent intent = new Intent(this.f711m, (Class<?>) ActivityConfigTask.class);
        StringBuilder sb = new StringBuilder();
        sb.append("task-");
        int i2 = f684a + 1;
        f684a = i2;
        sb.append(i2);
        intent.putExtra("taskname", sb.toString());
        this.f711m.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public void m622h() {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle(R.string.delete).setMessage(App.m435a(R.string.sure_delete_task) + this.f685b + "?").setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() { // from class: configs.ActivityConfigTasks.8
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (ActivityConfigTasks.this.f685b != null) {
                    try {
                        new File(C0101l.m537a("tasks") + "/" + ActivityConfigTasks.this.f685b + ".cup").delete();
                    } catch (Exception unused) {
                    }
                    if (C0227a.f1276a != null && ActivityConfigTasks.this.f685b.equals(C0227a.f1276a.f1278b)) {
                        C0227a.m988a((String) null);
                    }
                    ActivityConfigTasks.this.f685b = null;
                    ActivityConfigTasks.this.m624a();
                }
            }
        }).setNegativeButton(R.string.no, (DialogInterface.OnClickListener) null).show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m623i() {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle(R.string.delete).setMessage(App.m435a(R.string.sure_delete_file) + this.f686c + "?").setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() { // from class: configs.ActivityConfigTasks.9
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (ActivityConfigTasks.this.f686c != null) {
                    try {
                        new File(C0101l.m537a("waypoints/" + ActivityConfigTasks.this.f686c)).delete();
                    } catch (Exception unused) {
                    }
                    C0099j.m522b("active_wpfiles", ActivityConfigTasks.this.f686c);
                    ActivityConfigTasks.this.f686c = null;
                    ActivityConfigTasks.this.m624a();
                }
            }
        }).setNegativeButton(R.string.no, (DialogInterface.OnClickListener) null).show();
    }

    /* renamed from: a */
    void m624a() {
        m619e();
        m617d();
        PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference("settingsCategory");
        preferenceCategory.removeAll();
        Preference preference = new Preference(this);
        preference.setKey(null);
        preference.setTitle(R.string.new_task);
        preference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: configs.ActivityConfigTasks.3
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference2) {
                ActivityConfigTasks.this.m621g();
                return true;
            }
        });
        preferenceCategory.addPreference(preference);
        Preference preference2 = new Preference(this);
        preference2.setTitle(R.string.load_task_cloud);
        preference2.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: configs.ActivityConfigTasks.4
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference3) {
                ActivityConfigTasks.this.m610a(9);
                return true;
            }
        });
        preferenceCategory.addPreference(preference2);
        Preference preference3 = new Preference(this);
        preference3.setTitle(R.string.load_waypoints_cloud);
        preference3.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: configs.ActivityConfigTasks.5
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference4) {
                ActivityConfigTasks.this.m610a(2);
                return true;
            }
        });
        preferenceCategory.addPreference(preference3);
    }

    @Override // configs.C0166a
    /* renamed from: a */
    protected void mo577a(int i2, Intent intent) {
        if (i2 == 26) {
            C0227a.m988a(new File(intent.getExtras().getString("file")).getName());
            m624a();
        }
    }

    /* renamed from: b */
    String[] m625b() {
        File[] listFiles = new File(C0101l.m537a("tasks")).listFiles();
        String[] strArr = new String[listFiles.length];
        for (int i2 = 0; i2 < listFiles.length; i2++) {
            String name = listFiles[i2].getName();
            if (name.endsWith(".cup")) {
                strArr[i2] = name.substring(0, name.length() - 4);
            } else {
                strArr[i2] = name;
            }
            if (strArr[i2].startsWith("task-")) {
                try {
                    int parseInt = Integer.parseInt(strArr[i2].substring("task-".length()));
                    if (parseInt > f684a) {
                        f684a = parseInt;
                    }
                } catch (Exception unused) {
                }
            }
        }
        return strArr;
    }

    /* renamed from: c */
    String[] m626c() {
        File[] listFiles = new File(C0101l.m537a("waypoints")).listFiles();
        String[] strArr = new String[listFiles.length];
        for (int i2 = 0; i2 < listFiles.length; i2++) {
            strArr[i2] = listFiles[i2].getName();
        }
        return strArr;
    }

    @Override // configs.C0166a, android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.preferences_tasks);
        this.f712n = true;
    }

    @Override // android.preference.PreferenceActivity, android.app.Activity
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int i2;
        int itemId = menuItem.getItemId();
        if (itemId != 40) {
            if (itemId != 50) {
                i2 = itemId == 60 ? 2 : 9;
            }
            m610a(i2);
        } else {
            m621g();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // configs.C0166a, android.app.Activity
    public void onPause() {
        super.onPause();
        AsyncTaskC0066g.m340a();
    }

    @Override // android.app.Activity
    public boolean onPrepareOptionsMenu(Menu menu) {
        menu.clear();
        menu.add(1, 40, 4, App.m435a(R.string.new_task));
        menu.add(1, 50, 5, App.m435a(R.string.load_task_cloud));
        menu.add(1, 60, 6, App.m435a(R.string.load_waypoints_cloud));
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // configs.C0166a, android.app.Activity
    public void onResume() {
        super.onResume();
        m624a();
    }
}
