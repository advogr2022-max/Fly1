package configs;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0091b;
import com.xcglobe.xclog.C0099j;
import com.xcglobe.xclog.C0101l;
import java.io.File;
import flyme_tasks.AsyncTaskC0063d;
import flyme_tasks.AsyncTaskC0066g;
import flyme_tasks.AsyncTaskC0071l;

/* loaded from: classes.dex */
public class ActivityConfigDataSources extends C0166a {

    /* renamed from: a */
    Activity f621a;

    /* renamed from: a */
    private String m578a() {
        String m537a = C0101l.m537a("data-sources.txt");
        if (!new File(m537a).isFile()) {
            C0091b.m461a("data-sources.txt", "", true);
        }
        return C0101l.m567f(m537a);
    }

    /* renamed from: a */
    public static String m579a(int i2) {
        return "region_stored" + i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m581b() {
        ((ListPreference) findPreference("mapset")).setTitle(App.m435a(R.string.mapset) + ": " + AsyncTaskC0063d.m320c(C0099j.m521b("mapset")));
    }

    /* renamed from: a */
    void m582a(final int i2, final CheckBoxPreference checkBoxPreference) {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle(App.m435a(R.string.delete)).setMessage(App.m435a(R.string.sure_delete_region)).setPositiveButton("Yes", new DialogInterface.OnClickListener() { // from class: configs.ActivityConfigDataSources.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i3) {
                AsyncTaskC0063d.m318b(i2);
                checkBoxPreference.setChecked(false);
                AsyncTaskC0066g.f302b = true;
            }
        }).setNegativeButton("No", (DialogInterface.OnClickListener) null).show();
    }

    @Override // configs.C0166a, android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f621a = this;
        addPreferencesFromResource(R.xml.preferences_data_sources);
        boolean booleanExtra = getIntent().getBooleanExtra("unmarkall", false);
        String m322d = AsyncTaskC0063d.m322d();
        String m515a = C0099j.m515a("mapset_managed");
        if (!m322d.equals(m515a)) {
            if (m515a.length() != 0) {
                booleanExtra = true;
            }
            C0099j.m527d("mapset_managed", m322d);
        }
        if (booleanExtra) {
            AsyncTaskC0063d.m321c();
            C0091b.m461a("data-sources.txt", "", false);
        }
        String[] split = m578a().split("\n");
        final PreferenceCategory preferenceCategory = (PreferenceCategory) findPreference("targetCategory");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        for (int i2 = 0; i2 < split.length; i2++) {
            if (!split[i2].startsWith(";")) {
                String[] split2 = split[i2].split("#");
                if (split2.length >= 2) {
                    String str = split2[1];
                    String str2 = "";
                    if (split2.length > 2 && split2[2].length() > 0) {
                        str2 = split2[2];
                    }
                    int parseInt = Integer.parseInt(split2[0]);
                    boolean z = defaultSharedPreferences.getBoolean(m579a(parseInt), false);
                    CheckBoxPreference checkBoxPreference = new CheckBoxPreference(this);
                    checkBoxPreference.setKey(m579a(parseInt));
                    checkBoxPreference.setChecked(z);
                    checkBoxPreference.setTitle(str);
                    checkBoxPreference.setSummary(str2);
                    checkBoxPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: configs.ActivityConfigDataSources.1
                        @Override // android.preference.Preference.OnPreferenceChangeListener
                        public boolean onPreferenceChange(Preference preference, Object obj) {
                            CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) preference;
                            String key = checkBoxPreference2.getKey();
                            int m532a = C0101l.m532a(key, 13, key.length());
                            if (checkBoxPreference2.isChecked()) {
                                ActivityConfigDataSources.this.m582a(m532a, checkBoxPreference2);
                                return false;
                            }
                            AsyncTaskC0063d.m316a(m532a, ActivityConfigDataSources.this.f621a, checkBoxPreference2, ActivityConfigDataSources.m579a(m532a));
                            return false;
                        }
                    });
                    preferenceCategory.addPreference(checkBoxPreference);
                }
            }
        }
        ((ListPreference) findPreference("mapset")).setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: configs.ActivityConfigDataSources.2
            @Override // android.preference.Preference.OnPreferenceChangeListener
            public boolean onPreferenceChange(Preference preference, Object obj) {
                C0099j.m527d("mapset", (String) obj);
                ActivityConfigDataSources.this.m581b();
                int preferenceCount = preferenceCategory.getPreferenceCount();
                for (int i3 = 0; i3 < preferenceCount; i3++) {
                    ((CheckBoxPreference) preferenceCategory.getPreference(i3)).setChecked(false);
                }
                return true;
            }
        });
        m581b();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // configs.C0166a, android.app.Activity
    public void onPause() {
        super.onPause();
        App.m440a("datasources");
        C0099j.m527d("mapset_managed", "");
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // configs.C0166a, android.app.Activity
    public void onResume() {
        super.onResume();
        AsyncTaskC0071l.m372a();
    }
}
