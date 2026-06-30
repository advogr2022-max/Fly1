package configs;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0099j;
import com.xcglobe.xclog.C0101l;

/* loaded from: classes.dex */
public class ActivityConfigGlider extends C0166a {

    /* renamed from: a */
    EditTextPreference f628a;

    /* renamed from: b */
    EditTextPreference f629b;

    /* renamed from: c */
    EditTextPreference f630c;

    /* renamed from: d */
    EditTextPreference f631d;

    /* renamed from: e */
    EditTextPreference f632e;

    /* renamed from: f */
    EditTextPreference f633f;

    /* renamed from: g */
    ListPreference f634g;

    /* renamed from: h */
    EditTextPreference f635h;

    /* renamed from: a */
    public void m583a() {
        this.f628a.setSummary(C0099j.m515a("glider_min_speed") + " km/h");
        this.f629b.setSummary(C0099j.m515a("glider_min_speed_sink") + " m/s");
        this.f630c.setSummary(C0099j.m515a("glider_optimal_speed") + " km/h");
        this.f631d.setSummary(C0099j.m515a("glider_optimal_speed_sink") + " m/s");
        this.f632e.setSummary(C0099j.m515a("glider_max_speed") + " km/h");
        this.f633f.setSummary(C0099j.m515a("glider_max_speed_sink") + " m/s");
        this.f634g.setSummary(C0101l.m535a(R.array.gtypes_entries, R.array.gtypes_values, "" + C0099j.m521b("user.gtype")));
        this.f635h.setSummary(C0099j.m515a("user.glider"));
    }

    @Override // configs.C0166a, android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.preferences_glider);
        this.f628a = (EditTextPreference) findPreference("glider_min_speed");
        this.f629b = (EditTextPreference) findPreference("glider_min_speed_sink");
        this.f630c = (EditTextPreference) findPreference("glider_optimal_speed");
        this.f631d = (EditTextPreference) findPreference("glider_optimal_speed_sink");
        this.f632e = (EditTextPreference) findPreference("glider_max_speed");
        this.f633f = (EditTextPreference) findPreference("glider_max_speed_sink");
        this.f634g = (ListPreference) findPreference("user.gtype");
        this.f635h = (EditTextPreference) findPreference("user.glider");
        this.f628a.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: configs.ActivityConfigGlider.1
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                C0099j.m527d("glider_min_speed", (String) obj);
                ActivityConfigGlider.this.m583a();
                return true;
            }
        });
        this.f629b.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: configs.ActivityConfigGlider.2
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                C0099j.m527d("glider_min_speed_sink", (String) obj);
                ActivityConfigGlider.this.m583a();
                return true;
            }
        });
        this.f630c.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: configs.ActivityConfigGlider.3
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                C0099j.m527d("glider_optimal_speed", (String) obj);
                ActivityConfigGlider.this.m583a();
                return true;
            }
        });
        this.f631d.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: configs.ActivityConfigGlider.4
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                C0099j.m527d("glider_optimal_speed_sink", (String) obj);
                ActivityConfigGlider.this.m583a();
                return true;
            }
        });
        this.f632e.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: configs.ActivityConfigGlider.5
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                C0099j.m527d("glider_max_speed", (String) obj);
                ActivityConfigGlider.this.m583a();
                return true;
            }
        });
        this.f633f.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: configs.ActivityConfigGlider.6
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                C0099j.m527d("glider_max_speed_sink", (String) obj);
                ActivityConfigGlider.this.m583a();
                return true;
            }
        });
        this.f634g.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: configs.ActivityConfigGlider.7
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                C0099j.m527d("user.gtype", (String) obj);
                ActivityConfigGlider.this.m583a();
                return true;
            }
        });
        this.f635h.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: configs.ActivityConfigGlider.8
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                C0099j.m527d("user.glider", (String) obj);
                ActivityConfigGlider.this.m583a();
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // configs.C0166a, android.app.Activity
    public void onPause() {
        super.onPause();
        App.m440a("glider");
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // configs.C0166a, android.app.Activity
    public void onResume() {
        super.onResume();
        m583a();
    }
}
