package configs;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceManager;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;

/* loaded from: classes.dex */
public class ActivityConfigVario extends C0166a {

    /* renamed from: a */
    ListPreference f701a;

    /* renamed from: b */
    ListPreference f702b;

    /* renamed from: c */
    EditTextPreference f703c;

    /* renamed from: a */
    protected void m629a() {
        final SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        new Handler().postDelayed(new Runnable() { // from class: configs.ActivityConfigVario.4
            @Override // java.lang.Runnable
            public void run() {
                String str;
                String string = defaultSharedPreferences.getString("vario_interval", "0");
                if ("0".equals(string)) {
                    str = ": AUTO";
                } else {
                    str = ": " + (Integer.parseInt(string) / 1000) + " sec";
                }
                ActivityConfigVario.this.f701a.setSummary(App.m435a(R.string.vario_interval_desc) + str);
                ActivityConfigVario.this.f702b.setSummary((App.m435a(R.string.vario_volume_desc) + ": ") + defaultSharedPreferences.getString("vario_volume", "0") + "%%");
                ActivityConfigVario.this.f703c.setSummary(defaultSharedPreferences.getString("sink_tone", "-") + " m/s");
            }
        }, 100L);
    }

    @Override // configs.C0166a, android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.preferences_vario);
        this.f702b = (ListPreference) findPreference("vario_volume");
        this.f701a = (ListPreference) findPreference("vario_interval");
        this.f703c = (EditTextPreference) findPreference("sink_tone");
        this.f702b.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: configs.ActivityConfigVario.1
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                ActivityConfigVario.this.m629a();
                return true;
            }
        });
        this.f701a.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: configs.ActivityConfigVario.2
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                ActivityConfigVario.this.m629a();
                return true;
            }
        });
        this.f703c.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: configs.ActivityConfigVario.3
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                ActivityConfigVario.this.m629a();
                return true;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // configs.C0166a, android.app.Activity
    public void onPause() {
        super.onPause();
        App.m440a("vario");
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // configs.C0166a, android.app.Activity
    public void onResume() {
        super.onResume();
        m629a();
    }
}
