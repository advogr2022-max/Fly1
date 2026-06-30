package configs;

import android.os.Bundle;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;

/* loaded from: classes.dex */
public class ActivityConfigDisplay extends C0166a {
    @Override // configs.C0166a, android.preference.PreferenceActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.preferences_display);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // configs.C0166a, android.app.Activity
    public void onPause() {
        super.onPause();
        App.m440a("display");
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // configs.C0166a, android.app.Activity
    public void onResume() {
        super.onResume();
    }
}
