package configs;

import android.os.Bundle;
import android.preference.Preference;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.ActivityAbout;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0101l;
import display.vmap.ViewVmp;
import flyme_apphelper.C0072a;
import flyme_data.C0238f;

/* loaded from: classes.dex */
public class ActivityConfig extends C0166a {
    @Override // android.preference.PreferenceActivity, android.app.Activity
    public void onBackPressed() {
        C0101l.m566e();
    }

    @Override // configs.C0166a, android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.preferences);
        Preference findPreference = findPreference("demo_flight");
        if (C0238f.m1059d()) {
            findPreference.setEnabled(false);
        }
        findPreference.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: configs.ActivityConfig.1
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                ViewVmp.setFlag(32);
                C0072a.m377a("demo.igc");
                C0101l.m566e();
                return true;
            }
        });
        findPreference("display").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: configs.ActivityConfig.2
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                App.m439a((Class<?>) ActivityConfigDisplay.class);
                return true;
            }
        });
        findPreference("advanced").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: configs.ActivityConfig.3
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                App.m439a((Class<?>) ActivityConfigAdvanced.class);
                return true;
            }
        });
        findPreference("data_sources").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: configs.ActivityConfig.4
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                App.m439a((Class<?>) ActivityConfigDataSources.class);
                return true;
            }
        });
        findPreference("livetrack_options").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: configs.ActivityConfig.5
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                App.m439a((Class<?>) ActivityConfigLivetrack.class);
                return true;
            }
        });
        findPreference("power_options").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: configs.ActivityConfig.6
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                App.m439a((Class<?>) ActivityConfigPower.class);
                return true;
            }
        });
        findPreference("tasks").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: configs.ActivityConfig.7
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                App.m439a((Class<?>) ActivityConfigTasks.class);
                return true;
            }
        });
        findPreference("about").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: configs.ActivityConfig.8
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                App.m439a((Class<?>) ActivityAbout.class);
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // configs.C0166a, android.app.Activity
    public void onPause() {
        super.onPause();
        App.m440a("general");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // configs.C0166a, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
