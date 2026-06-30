package com.xcglobe.xclog;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import com.xcglobe.flyme.R;
import flyme_intentutil.C0225a;
import flyme_data.C0236d;
import flyme_data.C0238f;
import flyme_data.C0239g;

/* loaded from: classes.dex */
public class ActivityPocket extends ActivityC0090a {

    /* renamed from: a */
    public static final String f444a = App.m435a(R.string.recording);

    /* renamed from: b */
    public static final String f445b = App.m435a(R.string.waiting_movement);

    /* renamed from: c */
    public static final String f446c = App.m435a(R.string.waiting_gps);

    /* renamed from: d */
    public static final String f447d = App.m435a(R.string.gps_unavailable);

    /* renamed from: e */
    private TextView f448e;

    /* renamed from: a */
    public void m425a() {
        String str;
        if (C0238f.m1059d()) {
            str = f444a + ": " + C0101l.m534a(C0239g.m1074e(), 0);
        } else {
            str = C0239g.m1076g() ? f445b : !C0236d.m1046c() ? f447d : f446c;
        }
        this.f448e.setText(str);
    }

    @Override // com.xcglobe.xclog.ActivityC0090a
    /* renamed from: a */
    protected void mo399a(int i2, Intent intent) {
        if (i2 == 5) {
            C0101l.m546a(C0239g.m1077h(), this.f475R);
            finish();
            return;
        }
        if (i2 != 8 && i2 != 10) {
            switch (i2) {
                case 1:
                case 2:
                case 3:
                    break;
                default:
                    return;
            }
        }
        m425a();
    }

    public void btnNormalMode(View view) {
        C0101l.m566e();
        finish();
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        C0101l.m566e();
        finish();
    }

    @Override // com.xcglobe.xclog.ActivityC0090a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f476S = true;
        setContentView(R.layout.activity_pocket);
        this.f448e = (TextView) findViewById(R.id.pocket_status);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xcglobe.xclog.ActivityC0090a, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.xcglobe.xclog.ActivityC0090a, android.app.Activity
    public void onResume() {
        super.onResume();
        C0101l.m549a(true);
        m425a();
        CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox1);
        if (!C0101l.f541Z) {
            checkBox.setVisibility(8);
            return;
        }
        checkBox.setVisibility(0);
        checkBox.setChecked(C0101l.f553ac);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.xcglobe.xclog.ActivityPocket.1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                C0101l.f553ac = z;
                PreferenceManager.getDefaultSharedPreferences(ActivityPocket.this.f475R).edit().putBoolean("enable_pocket_livetrack", z).commit();
                if (z) {
                    C0225a.m983b();
                }
            }
        });
    }
}
