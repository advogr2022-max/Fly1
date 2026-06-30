package configs;

import android.os.Bundle;
import android.preference.Preference;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0099j;
import com.xcglobe.xclog.C0101l;

/* loaded from: classes.dex */
public class ActivityConfigIgc extends C0166a {
    @Override // configs.C0166a, android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.preferences_igc);
        findPreference("user.fullname").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: configs.ActivityConfigIgc.1
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                preference.setSummary(obj.toString());
                return true;
            }
        });
        findPreference("user.civlid").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: configs.ActivityConfigIgc.2
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                preference.setSummary(obj.toString());
                return true;
            }
        });
        findPreference("user.email_igc").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: configs.ActivityConfigIgc.3
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                String str = (String) obj;
                if (str.length() == 0) {
                    str = App.m435a(R.string.target_email_desc);
                }
                preference.setSummary(str);
                return true;
            }
        });
        findPreference("logging_interval").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: configs.ActivityConfigIgc.4
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                preference.setSummary(obj.toString() + " sec");
                return true;
            }
        });
        findPreference("movement_detection_type").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: configs.ActivityConfigIgc.5
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                preference.setSummary(App.m435a(R.string.movement_detection_type_desc) + " (" + C0101l.m535a(R.array.movement_detection_type_entries, R.array.movement_detection_type_values, (String) obj) + ")");
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // configs.C0166a, android.app.Activity
    public void onPause() {
        super.onPause();
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // configs.C0166a, android.app.Activity
    public void onResume() {
        super.onResume();
        findPreference("user.fullname").setSummary(C0099j.m515a("user.fullname"));
        findPreference("user.civlid").setSummary(C0099j.m515a("user.civlid"));
        String m515a = C0099j.m515a("user.email_igc");
        if (m515a.length() == 0) {
            m515a = App.m435a(R.string.target_email_desc);
        }
        findPreference("user.email_igc").setSummary(m515a);
        findPreference("logging_interval").setSummary(C0099j.m515a("logging_interval") + " sec");
        String m535a = C0101l.m535a(R.array.movement_detection_type_entries, R.array.movement_detection_type_values, C0099j.m515a("movement_detection_type"));
        findPreference("movement_detection_type").setSummary(App.m435a(R.string.movement_detection_type_desc) + " (" + m535a + ")");
    }
}
