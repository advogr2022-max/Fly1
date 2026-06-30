package com.xcglobe.xclog;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xcglobe.flyme.R;
import flyme_tasks.AsyncTaskC0069j;
import flyme_tasks.AsyncTaskC0071l;
import flyme_dialogs.DialogC0196b;

/* loaded from: classes.dex */
public class ActivityAbout extends ActivityC0090a {
    /* renamed from: a */
    private void m398a() {
        int i2;
        String str;
        String m466a = C0095f.m466a(true);
        String m489r = C0095f.m489r();
        if (m489r != null && !m489r.isEmpty()) {
            m466a = m466a + " [" + m489r + "]";
        }
        ((TextView) findViewById(R.id.ab_version)).setText(m466a);
        Button button = (Button) findViewById(R.id.ab_but_upgrade);
        if (!C0095f.m485n() && !C0095f.m488q()) {
            button.setText(App.m435a(R.string.upgrade_version) + " (" + C0095f.m484m() + ")");
            button.setVisibility(0);
        }
        ((TextView) findViewById(R.id.ab_actkey)).setText(C0095f.m469b());
        Button button2 = (Button) findViewById(R.id.ab_buy_licence);
        Button button3 = (Button) findViewById(R.id.ab_enter_licence);
        TextView textView = (TextView) findViewById(R.id.ab_licence);
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ab_layout_licence);
        if (C0095f.m479h()) {
            App.m435a(R.string.licence_full);
            linearLayout.setVisibility(8);
            return;
        }
        linearLayout.setVisibility(0);
        if (C0095f.m483l()) {
            button2.setVisibility(0);
            button3.setVisibility(0);
            int m476e = C0095f.m476e();
            if (m476e > 0) {
                str = App.m435a(R.string.licence_trial_days) + " " + m476e + " " + App.m435a(R.string.days);
                textView.setText(str);
            }
            i2 = R.string.licence_expired;
        } else {
            i2 = R.string.licence_trial_not_ready;
        }
        str = App.m435a(i2);
        textView.setText(str);
    }

    @Override // com.xcglobe.xclog.ActivityC0090a
    /* renamed from: a */
    protected void mo399a(int i2, Intent intent) {
        if (i2 == 15) {
            m398a();
        }
    }

    public void clickBuyLicence(View view) {
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse((C0095f.m486o() + "flyme/buy?") + C0095f.m465a(null, false))));
    }

    public void clickEnterLicence(View view) {
        DialogC0196b.m832a(this);
    }

    public void clickUpgrade(View view) {
        AsyncTaskC0069j.m359a((Activity) this);
    }

    @Override // com.xcglobe.xclog.ActivityC0090a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f476S = true;
        setContentView(R.layout.activity_about);
        AsyncTaskC0071l.m372a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xcglobe.xclog.ActivityC0090a, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    @Override // com.xcglobe.xclog.ActivityC0090a, android.app.Activity
    public void onResume() {
        super.onResume();
        m398a();
    }
}
