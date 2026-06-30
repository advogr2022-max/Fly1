package configs;

import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.widget.BaseAdapter;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0100k;
import com.xcglobe.xclog.C0101l;
import configs.prefitems.TaskPointSummaryPreference;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import mymenu.DialogC0241a;
import flyme_dialogs.DialogC0201d;
import flyme_dialogs.DialogC0202e;
import flyme_dialogs.flyme_dialogs_b.DialogC0198b;
import flyme_poi.C0227a;
import flyme_poi.C0229c;
import flyme_poi.C0230d;
import flyme_data.C0239g;
import types.GpsVal;
import types.PoiPoint;

/* loaded from: classes.dex */
public class ActivityConfigTask extends C0166a {
    // private static int r0 = 0;

    /* renamed from: a */
    ActivityConfigTask f664a;

    /* renamed from: b */
    C0227a f665b;

    /* renamed from: c */
    PreferenceCategory f666c;

    /* renamed from: d */
    public int f667d = 400;

    /* renamed from: e */
    Preference f668e = null;

    /* renamed from: f */
    C0229c f669f = null;

    /* renamed from: g */
    int f670g = -1;

    /* renamed from: h */
    Preference f671h;

    /* renamed from: i */
    Preference f672i;

    /* renamed from: j */
    CheckBoxPreference f673j;

    /* renamed from: k */
    String f674k;

    /* renamed from: a */
    C0229c m589a(PoiPoint poiPoint, float f2) {
        C0229c c0229c = new C0229c();
        c0229c.m1171a(poiPoint);
        c0229c.f1311a = f2;
        this.f665b.f1279c.add(c0229c);
        return c0229c;
    }

    /* renamed from: a */
    public void m590a() {
        this.f671h.setSummary((this.f665b.f1280d ? "ENTER" : "EXIT") + ", " + this.f665b.f1281e.format("%H:%M"));
        this.f672i.setSummary((this.f665b.f1289m ? "LINE" : "CYLINDER") + ", " + this.f665b.f1282f.format("%H:%M"));
    }

    /* renamed from: a */
    void m591a(int i2) {
        C0229c c0229c = this.f665b.f1279c.get(i2);
        C0100k c0100k = new C0100k(this);
        c0100k.setKey(c0229c.m1014a());
        m592a(i2, c0100k);
        c0100k.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: configs.ActivityConfigTask.8
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                ActivityConfigTask.this.f668e = preference;
                ActivityConfigTask.this.f670g = ActivityConfigTask.this.m604l();
                ActivityConfigTask.this.f669f = ActivityConfigTask.this.f665b.f1279c.get(ActivityConfigTask.this.f670g);
                ActivityConfigTask.this.m596d();
                return true;
            }
        });
        this.f666c.addPreference(c0100k);
    }

    /* renamed from: a */
    void m592a(int i2, C0100k c0100k) {
        C0229c c0229c = this.f665b.f1279c.get(i2);
        String str = " ";
        if (this.f665b.f1290n) {
            if (c0229c.f1316f) {
                str = "SSS";
            } else if (c0229c.f1317g) {
                str = "ESS";
            } else if (i2 == this.f665b.f1279c.size() - 1) {
                str = "Goal";
            }
        }
        c0100k.f513a = str;
        c0100k.f514b = "R: " + (((int) ((c0229c.f1311a * 10000.0f) + 1.0f)) / 10) + " m";
        c0100k.f515c = "Leg: " + C0101l.f520E.format((double) c0229c.f1313c) + " km";
        c0100k.setTitle(c0229c.f1979l);
    }

    /* renamed from: a */
    void m593a(boolean z) {
        PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference("titleCategory");
        if (!z) {
            preferenceCategory.removePreference(this.f671h);
            preferenceCategory.removePreference(this.f672i);
            return;
        }
        preferenceCategory.addPreference(this.f671h);
        preferenceCategory.addPreference(this.f672i);
        if (m599g() != -1 || this.f665b.f1279c.size() <= 0) {
            return;
        }
        this.f665b.f1279c.get(0).f1316f = true;
    }

    /* renamed from: b */
    public void m594b() {
        this.f665b.m1007i();
        if (this.f665b.f1290n) {
            m608p();
        }
        this.f666c.removeAll();
        for (int i2 = 0; i2 < this.f665b.f1279c.size(); i2++) {
            m591a(i2);
        }
        m602j();
        m603k();
        m595c();
    }

    /* renamed from: c */
    void m595c() {
        int preferenceCount = this.f666c.getPreferenceCount();
        for (int i2 = 0; i2 < preferenceCount; i2++) {
            m592a(i2, (C0100k) this.f666c.getPreference(i2));
        }
        ((BaseAdapter) getPreferenceScreen().getRootAdapter()).notifyDataSetChanged();
    }

    /* renamed from: d */
    void m596d() {
        if (this.f669f == null) {
            return;
        }
        DialogC0241a dialogC0241a = new DialogC0241a(this, this.f669f.f1979l) { // from class: configs.ActivityConfigTask.6
            @Override // mymenu.DialogC0241a
            /* renamed from: a */
            public boolean mo588a(int i2) {
                if (i2 == 10) {
                    ActivityConfigTask.this.m605m();
                    return true;
                }
                if (i2 == 20) {
                    ActivityConfigTask.this.m606n();
                    return true;
                }
                if (i2 == 30) {
                    ActivityConfigTask.this.m607o();
                    return true;
                }
                switch (i2) {
                    case 50:
                        ActivityConfigTask.this.m601i();
                        return true;
                    case 51:
                        ActivityConfigTask.this.m597e();
                        return true;
                    case 52:
                        ActivityConfigTask.this.m598f();
                        return true;
                    default:
                        return false;
                }
            }
        };
        dialogC0241a.m1100a(20, App.m435a(R.string.up));
        dialogC0241a.m1100a(30, App.m435a(R.string.down));
        dialogC0241a.m1100a(50, App.m435a(R.string.radius) + ": " + ((int) (this.f669f.f1311a * 1000.0f)) + " m");
        if (this.f665b.f1290n) {
            dialogC0241a.m1100a(51, App.m435a(R.string.sss_menu));
            dialogC0241a.m1100a(52, App.m435a(R.string.ess_menu));
        }
        dialogC0241a.m1100a(10, App.m435a(R.string.delete));
        dialogC0241a.m1098a();
    }

    /* renamed from: e */
    void m597e() {
        int m599g = m599g();
        int m600h = m600h();
        if (m599g == this.f670g) {
            return;
        }
        if (m600h != -1 && this.f670g >= m600h) {
            this.f665b.f1279c.get(m600h).f1317g = false;
        }
        if (m599g != -1) {
            this.f665b.f1279c.get(m599g).f1316f = false;
        }
        this.f665b.f1279c.get(this.f670g).f1316f = true;
        m594b();
    }

    /* renamed from: f */
    void m598f() {
        int m599g = m599g();
        int m600h = m600h();
        if (m600h == this.f670g) {
            // this.f665b.f1279c.get(this.f670g).f1317g = ...;
        } else {
            if (m599g != -1 && this.f670g <= m599g) {
                if (this.f670g == 0) {
                    return;
                }
                this.f665b.f1279c.get(m599g).f1316f = false;
                this.f665b.f1279c.get(0).f1316f = true;
            }
            if (m600h != -1) {
                this.f665b.f1279c.get(m600h).f1317g = false;
            }
            this.f665b.f1279c.get(this.f670g).f1317g = true;
        }
        m594b();
    }

    /* renamed from: g */
    int m599g() {
        int size = this.f665b.f1279c.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f665b.f1279c.get(i2).f1316f) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: h */
    int m600h() {
        int size = this.f665b.f1279c.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (this.f665b.f1279c.get(i2).f1317g) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: i */
    void m601i() {
        DialogC0241a dialogC0241a = new DialogC0241a(this, App.m435a(R.string.radius)) { // from class: configs.ActivityConfigTask.7
            @Override // mymenu.DialogC0241a
            /* renamed from: a */
            public boolean mo588a(int i2) {
                ActivityConfigTask.this.f669f.f1311a = i2 / 1000.0f;
                if (ActivityConfigTask.this.f669f.f1311a < 3.0f) {
                    ActivityConfigTask.this.f667d = (int) (ActivityConfigTask.this.f669f.f1311a * 1000.0f);
                }
                ActivityConfigTask.this.m594b();
                ActivityConfigTask.this.m603k();
                return true;
            }
        };
        for (int i2 = 100; i2 <= 100000; i2 += 100) {
            dialogC0241a.m1100a(i2, String.valueOf(i2));
        }
        dialogC0241a.m1099a((int) (C0101l.f574ax * 0.7f), (int) (C0101l.f573aw * 0.95f));
        dialogC0241a.m1101b((int) (this.f669f.f1311a * 1000.0f));
        dialogC0241a.f1493f = R.layout.dialog_menu_row_thin;
        dialogC0241a.m1098a();
    }

    /* renamed from: j */
    void m602j() {
        TaskPointSummaryPreference taskPointSummaryPreference = (TaskPointSummaryPreference) findPreference("point_summary");
        taskPointSummaryPreference.f716b = C0101l.f520E.format(this.f665b.f1301y) + " km";
        taskPointSummaryPreference.f715a = C0101l.f520E.format((double) this.f665b.f1300x) + " km";
    }

    /* renamed from: k */
    void m603k() {
        this.f668e = null;
        this.f670g = -1;
        this.f669f = null;
    }

    /* renamed from: l */
    int m604l() {
        int preferenceCount = this.f666c.getPreferenceCount();
        for (int i2 = 0; i2 < preferenceCount; i2++) {
            if (this.f666c.getPreference(i2) == this.f668e) {
                return i2;
            }
        }
        return -1;
    }

    /* renamed from: m */
    void m605m() {
        if (this.f670g != -1) {
            this.f665b.f1279c.remove(this.f670g);
            m594b();
        }
        m603k();
    }

    /* renamed from: n */
    void m606n() {
        if (this.f670g > 0) {
            C0229c c0229c = this.f665b.f1279c.get(this.f670g);
            this.f665b.f1279c.remove(this.f670g);
            this.f665b.f1279c.add(this.f670g - 1, c0229c);
            m603k();
            m594b();
        }
    }

    /* renamed from: o */
    void m607o() {
        if (this.f670g < 0 || this.f670g >= this.f665b.f1279c.size() - 1) {
            return;
        }
        C0229c c0229c = this.f665b.f1279c.get(this.f670g);
        this.f665b.f1279c.remove(this.f670g);
        this.f665b.f1279c.add(this.f670g + 1, c0229c);
        m603k();
        m594b();
    }

    @Override // configs.C0166a, android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f664a = this;
        addPreferencesFromResource(R.xml.preferences_task);
        this.f674k = getIntent().getStringExtra("taskname");
        if (this.f674k == null || this.f674k.length() < 1) {
            finish();
            return;
        }
        this.f665b = C0230d.m1017a(this.f674k);
        if (this.f665b == null) {
            this.f665b = new C0227a();
            this.f665b.f1278b = this.f674k;
        }
        EditTextPreference editTextPreference = (EditTextPreference) findPreference("task_name");
        editTextPreference.setText(this.f665b.f1278b);
        editTextPreference.setSummary(this.f665b.f1278b);
        editTextPreference.setDefaultValue(this.f665b.f1278b);
        editTextPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: configs.ActivityConfigTask.1
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                ActivityConfigTask.this.f665b.f1278b = C0101l.m538a((String) obj, 16);
                preference.setSummary(ActivityConfigTask.this.f665b.f1278b);
                ((EditTextPreference) preference).setText(ActivityConfigTask.this.f665b.f1278b);
                return false;
            }
        });
        this.f671h = findPreference("task_start");
        this.f672i = findPreference("task_end");
        this.f673j = (CheckBoxPreference) findPreference("competition_task");
        this.f673j.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: configs.ActivityConfigTask.2
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                ActivityConfigTask activityConfigTask = ActivityConfigTask.this;
                C0227a c0227a = ActivityConfigTask.this.f665b;
                boolean booleanValue = ((Boolean) obj).booleanValue();
                c0227a.f1290n = booleanValue;
                activityConfigTask.m593a(booleanValue);
                ActivityConfigTask.this.m594b();
                return true;
            }
        });
        this.f673j.setChecked(this.f665b.f1290n);
        m590a();
        this.f671h.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: configs.ActivityConfigTask.3
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                DialogC0202e.m865a(ActivityConfigTask.this.f664a, ActivityConfigTask.this.f665b);
                return false;
            }
        });
        this.f672i.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: configs.ActivityConfigTask.4
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                DialogC0201d.m863a(ActivityConfigTask.this.f664a, ActivityConfigTask.this.f665b);
                return false;
            }
        });
        Preference findPreference = findPreference("task_insert_point");
        findPreference.setTitle(R.string.add_task_point);
        findPreference.setSummary(R.string.add_task_point_desc);
        findPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: configs.ActivityConfigTask.5
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                GpsVal gpsVal = new GpsVal();
                if (ActivityConfigTask.this.f665b.f1279c.size() > 0) {
                    C0229c c0229c = ActivityConfigTask.this.f665b.f1279c.get(ActivityConfigTask.this.f665b.f1279c.size() - 1);
                    gpsVal.f1972a = c0229c.f1976i;
                    gpsVal.f1973b = c0229c.f1977j;
                } else {
                    gpsVal.m1169a(C0239g.m1073d());
                }
                DialogC0198b.m839b(ActivityConfigTask.this.f664a, gpsVal, null, false, new DialogC0198b.a() { // from class: configs.ActivityConfigTask.5.1
                    @Override // flyme_dialogs.flyme_dialogs_b.DialogC0198b.a
                    public void call(PoiPoint poiPoint) {
                        if (poiPoint != null) {
                            ActivityConfigTask.this.m589a(poiPoint, ActivityConfigTask.this.f667d / 1000.0f);
                            ActivityConfigTask.this.m594b();
                        }
                    }
                });
                return false;
            }
        });
        this.f666c = (PreferenceCategory) findPreference("targetCategory");
        m593a(this.f665b.f1290n);
        m594b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // configs.C0166a, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.f665b != null && m609q() && C0227a.f1276a != null && this.f665b.f1278b.equals(C0227a.f1276a.f1278b)) {
            C0227a.m988a(this.f665b.f1278b);
        }
        finish();
    }

    /* renamed from: p */
    void m608p() {
        int size = this.f665b.f1279c.size();
        if (size == 0) {
            return;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < size; i2++) {
            C0229c c0229c = this.f665b.f1279c.get(i2);
            if (c0229c.f1316f) {
                z2 = true;
            }
            if (c0229c.f1317g) {
                z = true;
            }
        }
        if (!z) {
            this.f665b.f1279c.get(size - 1).f1317g = true;
        }
        if (z2) {
            return;
        }
        this.f665b.f1279c.get(0).f1316f = true;
    }

    /* renamed from: q */
    boolean m609q() {
        if (!this.f665b.f1278b.equals(this.f674k) || this.f665b.f1279c.size() == 0) {
            try {
                new File(C0101l.m537a("tasks") + "/" + this.f674k + ".cup").delete();
            } catch (Exception unused) {
            }
        }
        if (this.f665b.f1279c.size() == 0) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        sb2.append("\"" + this.f665b.f1278b + "\",\"\",");
        sb.append("name,code,country,lat,lon,elev,style,rwdir,rwlen,freq,desc\n");
        for (int i2 = 0; i2 < this.f665b.f1279c.size(); i2++) {
            C0229c c0229c = this.f665b.f1279c.get(i2);
            int i3 = ((int) (c0229c.f1311a * 10000.0f)) / 10;
            sb.append("\"" + c0229c.f1979l + "\",,," + C0101l.m533a(c0229c.f1976i, true) + "," + C0101l.m533a(c0229c.f1977j, false) + "," + ((int) c0229c.f1978k) + "m,,,,,\n");
            StringBuilder sb4 = new StringBuilder();
            sb4.append("\"");
            sb4.append(c0229c.f1979l);
            sb4.append("\",");
            sb2.append(sb4.toString());
            sb3.append("ObsZone=" + i2 + ",R1=" + i3 + "m");
            if (c0229c.f1316f) {
                sb3.append(",sss=True");
            }
            if (c0229c.f1317g) {
                sb3.append(",ess=True");
            }
            sb3.append("\n");
        }
        sb.append("-----Related Tasks-----\n");
        sb.append((CharSequence) sb2);
        sb.append("\"\"");
        sb.append("\nOptions");
        if (this.f665b.f1280d) {
            sb.append(",StartOnEntry=True");
        }
        if (this.f665b.f1289m) {
            sb.append(",GoalIsLine=True");
        }
        if (this.f665b.f1290n) {
            sb.append(",Competition=True");
            sb.append(",NoStart=" + this.f665b.f1281e.format("%H:%M"));
            sb.append(",NoEnd=" + this.f665b.f1282f.format("%H:%M"));
        }
        sb.append("\n");
        sb.append((CharSequence) sb3);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(C0101l.m537a("tasks") + "/" + C0101l.m565e(this.f665b.f1278b) + ".cup"));
            fileOutputStream.write(sb.toString().getBytes());
            fileOutputStream.close();
        } catch (IOException unused2) {
        }
        return true;
    }
}
