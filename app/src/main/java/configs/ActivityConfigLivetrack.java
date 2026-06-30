package configs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.Preference;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0099j;
import com.xcglobe.xclog.C0101l;
import flyme_intentutil.C0225a;

/* loaded from: classes.dex */
public class ActivityConfigLivetrack extends C0166a {
    /* renamed from: a */
    void m584a() {
        Preference findPreference = findPreference("test_livetrack");
        findPreference.setTitle(R.string.loading);
        findPreference.setSummary(R.string.test_livetrack_desc);
        C0225a.m982a(true);
    }

    @Override // configs.C0166a
    /* renamed from: a */
    protected void mo577a(int i2, Intent intent) {
        if (i2 == 18) {
            String stringExtra = intent.getStringExtra("error");
            Preference findPreference = findPreference("test_livetrack");
            if (stringExtra == null) {
                findPreference.setTitle("Test: OK");
                return;
            }
            findPreference.setTitle("Test: " + App.m435a(R.string.error));
            findPreference.setSummary(stringExtra);
        }
    }

    /* renamed from: b */
    void m585b() {
        findPreference("user.username").setSummary(C0099j.m515a("user.username"));
        findPreference("livetrack_server").setSummary(C0101l.m535a(R.array.livetrack_server_entries, R.array.livetrack_server_values, C0099j.m515a("livetrack_server")));
        Preference findPreference = findPreference("test_livetrack");
        findPreference.setTitle(R.string.test);
        findPreference.setSummary(R.string.test_livetrack_desc);
        findPreference("livetrack_time_interval").setSummary(C0101l.m535a(R.array.livetrack_entries, R.array.livetrack_values, C0099j.m515a("livetrack_time_interval")));
    }

    @Override // configs.C0166a, android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.preferences_livetrack);
        this.f712n = true;
        findPreference("user.username").setSummary(C0099j.m515a("user.username"));
        findPreference("create_account").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: configs.ActivityConfigLivetrack.1
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                ActivityConfigLivetrack.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("http://xcglobe.com/register")));
                return false;
            }
        });
        findPreference("test_livetrack").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: configs.ActivityConfigLivetrack.2
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                ActivityConfigLivetrack.this.m584a();
                return false;
            }
        });
        findPreference("user.username").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: configs.ActivityConfigLivetrack.3
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                ActivityConfigLivetrack.this.m585b();
                preference.setSummary((String) obj);
                return true;
            }
        });
        findPreference("livetrack_time_interval").setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: configs.ActivityConfigLivetrack.4
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                ActivityConfigLivetrack.this.m585b();
                preference.setSummary(C0101l.m535a(R.array.livetrack_entries, R.array.livetrack_values, (String) obj));
                return true;
            }
        });
        m585b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // configs.C0166a, android.app.Activity
    public void onPause() {
        super.onPause();
        App.m440a("livetrack");
        finish();
    }
}
