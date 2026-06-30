package configs;

import android.os.Bundle;
import android.preference.Preference;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.C0099j;
import com.xcglobe.xclog.C0101l;
import types.C0377q;

/* loaded from: classes.dex */
public class ActivityConfigUnits extends C0166a {
    /* renamed from: a */
    protected void m627a() {
        findPreference("unit_distance").setSummary(C0377q.f2082a);
        findPreference("unit_speed").setSummary(C0377q.f2084c);
        findPreference("unit_altitude").setSummary(C0377q.f2083b);
        findPreference("unit_vario").setSummary(C0377q.f2085d);
    }

    /* renamed from: a */
    protected void m628a(String str, String str2) {
        C0099j.m527d(str, str2);
        C0101l.m568f();
        m627a();
    }

    @Override // configs.C0166a, android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.preferences_units);
        findPreference("unit_distance").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: configs.ActivityConfigUnits.1
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                ActivityConfigUnits.this.m628a("unit_distance", (String) obj);
                return true;
            }
        });
        findPreference("unit_speed").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: configs.ActivityConfigUnits.2
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                ActivityConfigUnits.this.m628a("unit_speed", (String) obj);
                return true;
            }
        });
        findPreference("unit_altitude").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: configs.ActivityConfigUnits.3
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                ActivityConfigUnits.this.m628a("unit_altitude", (String) obj);
                return true;
            }
        });
        findPreference("unit_vario").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: configs.ActivityConfigUnits.4
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                ActivityConfigUnits.this.m628a("unit_vario", (String) obj);
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // configs.C0166a, android.app.Activity
    public void onPause() {
        super.onPause();
        C0101l.m568f();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // configs.C0166a, android.app.Activity
    public void onResume() {
        super.onResume();
        m627a();
    }
}
