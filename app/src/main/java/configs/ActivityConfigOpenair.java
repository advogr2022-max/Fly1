package configs;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceCategory;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.ActivityCloudPicker;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0099j;
import com.xcglobe.xclog.C0101l;
import java.io.File;
import mymenu.DialogC0241a;
import flyme_tasks.AsyncTaskC0060a;
import flyme_tasks.AsyncTaskC0071l;

/* loaded from: classes.dex */
public class ActivityConfigOpenair extends C0166a {

    /* renamed from: a */
    Activity f653a;

    /* renamed from: b */
    boolean f654b = false;

    /* renamed from: c */
    long f655c = 0;

    /* renamed from: d */
    PreferenceCategory f656d;

    /* renamed from: a */
    public static String m586a(String str) {
        return "openair_checked_" + str;
    }

    /* renamed from: a */
    private void m587a() {
        this.f656d.removeAll();
        final SharedPreferences sharedPreferences = C0099j.f512a;
        String[] list = new File(C0101l.m537a("Openair")).list();
        if (list != null) {
            for (String str : list) {
                if (!str.startsWith(".")) {
                    boolean z = sharedPreferences.getBoolean(m586a(str), false);
                    CheckBoxPreference checkBoxPreference = new CheckBoxPreference(this);
                    checkBoxPreference.setKey(str);
                    checkBoxPreference.setChecked(z);
                    checkBoxPreference.setTitle(str);
                    checkBoxPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() { // from class: configs.ActivityConfigOpenair.2
                        @Override // android.preference.Preference.OnPreferenceChangeListener
                        public boolean onPreferenceChange(Preference preference, Object obj) {
                            SharedPreferences.Editor putBoolean;
                            CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) preference;
                            if (ActivityConfigOpenair.this.f655c != 0 && System.currentTimeMillis() - ActivityConfigOpenair.this.f655c < 1000) {
                                ActivityConfigOpenair.this.f655c = 0L;
                                return false;
                            }
                            String key = checkBoxPreference2.getKey();
                            if (checkBoxPreference2.isChecked()) {
                                ActivityConfigOpenair.this.f654b = true;
                                putBoolean = C0099j.f512a.edit().putBoolean(ActivityConfigOpenair.m586a(key), false);
                            } else {
                                ActivityConfigOpenair.this.f654b = true;
                                putBoolean = sharedPreferences.edit().putBoolean(ActivityConfigOpenair.m586a(key), true);
                            }
                            putBoolean.commit();
                            return true;
                        }
                    });
                    this.f656d.addPreference(checkBoxPreference);
                }
            }
        }
        final ListView listView = getListView();
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() { // from class: configs.ActivityConfigOpenair.3
            @Override // android.widget.AdapterView.OnItemLongClickListener
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                if (i2 < 2) {
                    return false;
                }
                ActivityConfigOpenair.this.f655c = System.currentTimeMillis();
                final CheckBoxPreference checkBoxPreference2 = (CheckBoxPreference) listView.getItemAtPosition(i2);
                DialogC0241a dialogC0241a = new DialogC0241a(ActivityConfigOpenair.this.f653a, checkBoxPreference2.getKey()) { // from class: configs.ActivityConfigOpenair.3.1
                    @Override // mymenu.DialogC0241a
                    /* renamed from: a */
                    public boolean mo588a(int i3) {
                        if (i3 == 10) {
                            String key = checkBoxPreference2.getKey();
                            ActivityConfigOpenair.this.f654b = true;
                            C0099j.f512a.edit().putBoolean(ActivityConfigOpenair.m586a(key), false).commit();
                            AsyncTaskC0060a.m305a(key);
                            ActivityConfigOpenair.this.f656d.removePreference(checkBoxPreference2);
                        }
                        return true;
                    }
                };
                dialogC0241a.m1100a(10, App.m435a(R.string.delete));
                dialogC0241a.m1098a();
                return false;
            }
        });
    }

    @Override // configs.C0166a, android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f653a = this;
        addPreferencesFromResource(R.xml.preferences_openair);
        this.f656d = (PreferenceCategory) findPreference("targetCategory");
        findPreference("load_airspace_cloud").setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() { // from class: configs.ActivityConfigOpenair.1
            @Override // android.preference.Preference.OnPreferenceClickListener
            public boolean onPreferenceClick(Preference preference) {
                Intent intent = new Intent(ActivityConfigOpenair.this.f711m, (Class<?>) ActivityCloudPicker.class);
                intent.putExtra("type", 1);
                ActivityConfigOpenair.this.f711m.startActivity(intent);
                return false;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // configs.C0166a, android.app.Activity
    public void onPause() {
        super.onPause();
        if (this.f654b) {
            C0099j.m527d("airspace_set", "openair");
            AsyncTaskC0060a.m304a();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // configs.C0166a, android.app.Activity
    public void onResume() {
        super.onResume();
        AsyncTaskC0071l.m372a();
        m587a();
    }
}
