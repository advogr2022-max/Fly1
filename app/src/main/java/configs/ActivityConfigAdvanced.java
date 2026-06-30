package configs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.ActivityDataList;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0099j;
import flyme_device.C0172d;
import flyme_device.DialogC0171c;
import flyme_data.C0239g;

/* loaded from: classes.dex */
public class ActivityConfigAdvanced extends C0166a {

    /* renamed from: a */
    ListPreference f612a;

    /* renamed from: b */
    boolean f613b = true;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m575a() {
        String m435a;
        if (C0172d.m668b()) {
            m435a = "Connected: " + C0172d.m669c();
        } else {
            m435a = App.m435a(!C0172d.m670d() ? R.string.bt_disabled : R.string.none);
        }
        this.f612a.setSummary(m435a);
    }

    @Override // configs.C0166a
    /* renamed from: a */
    protected void mo577a(int i2, Intent intent) {
        switch (i2) {
            case 20:
                break;
            case 21:
                this.f612a.setValue("0");
                break;
            default:
                return;
        }
        m575a();
    }

    @Override // configs.C0166a, android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.preferences_advanced);
        this.f712n = true;
        findPreference("openair_options").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: configs.ActivityConfigAdvanced.1
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                App.m439a((Class<?>) ActivityConfigOpenair.class);
                return true;
            }
        });
        findPreference("glider_options").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: configs.ActivityConfigAdvanced.2
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                App.m439a((Class<?>) ActivityConfigGlider.class);
                return true;
            }
        });
        findPreference("igc_options").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: configs.ActivityConfigAdvanced.3
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                App.m439a((Class<?>) ActivityConfigIgc.class);
                return true;
            }
        });
        findPreference("units_options").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: configs.ActivityConfigAdvanced.4
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                App.m439a((Class<?>) ActivityConfigUnits.class);
                return true;
            }
        });
        findPreference("vario_options").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: configs.ActivityConfigAdvanced.5
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                App.m439a((Class<?>) ActivityConfigVario.class);
                return true;
            }
        });
        findPreference("show_datalist").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: configs.ActivityConfigAdvanced.6
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                App.m439a((Class<?>) ActivityDataList.class);
                return true;
            }
        });
        this.f612a = (ListPreference) findPreference("external_devmodel");
        m575a();
        this.f612a.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: configs.ActivityConfigAdvanced.7
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                Context applicationContext;
                String str;
                String obj2 = obj != null ? obj.toString() : "0";
                if (obj2.length() == 0) {
                    obj2 = "0";
                }
                int parseInt = Integer.parseInt(obj2);
                if (parseInt != 0) {
                    C0099j.m517a("external_devmodel", parseInt);
                    Activity m434a = App.m434a();
                    if (parseInt == 5) {
                        applicationContext = m434a.getApplicationContext();
                        str = "usb";
                    } else if (parseInt == 6) {
                        applicationContext = m434a.getApplicationContext();
                        str = "tcp";
                    } else {
                        DialogC0171c.m652a(App.m434a(), C0239g.f1384O);
                    }
                    C0172d.m665a(applicationContext, parseInt, str, C0239g.f1384O, null);
                } else {
                    C0099j.m527d("external_device_address", null);
                    C0099j.m517a("external_devmodel", 0);
                    C0172d.m663a();
                }
                ActivityConfigAdvanced.this.m575a();
                return true;
            }
        });
        if (this.f613b) {
            PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference("advCategory");
            preferenceCategory.removePreference(findPreference("optimizer_interval"));
            preferenceCategory.removePreference(findPreference("enable_map_view"));
            preferenceCategory.removePreference(findPreference("sd_card"));
            preferenceCategory.removePreference(findPreference("gps_use_filter"));
        }
    }

    @Override // configs.C0166a, android.preference.PreferenceActivity, android.app.ListActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // configs.C0166a, android.app.Activity
    public void onPause() {
        super.onPause();
        App.m440a("advanced");
    }
}
