package com.xcglobe.xclog;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import com.xcglobe.flyme.R;
import flyme_tasks.AsyncTaskC0065f;

/* loaded from: classes.dex */
public class ActivityUploadEmail extends ActivityC0090a {

    /* renamed from: a */
    String f457a;

    /* renamed from: b */
    ProgressDialog f458b = null;

    /* renamed from: c */
    Activity f459c;

    /* renamed from: a */
    public void m432a() {
        String str;
        String m515a = C0099j.m515a("user.civlid");
        if (m515a.length() > 0) {
            str = this.f457a.substring(0, 10) + "." + m515a + ".igc";
        } else {
            str = this.f457a;
        }
        ((TextView) findViewById(R.id.igc_filename)).setText(str);
        ((TextView) findViewById(R.id.email_igc)).setText(C0099j.m515a("user.email_igc"));
    }

    /* renamed from: b */
    public void m433b() {
        C0099j.m527d("user.email_igc", ((EditText) findViewById(R.id.email_igc)).getText().toString());
    }

    public void clickCancel(View view) {
        finish();
    }

    public void clickOk(View view) {
        m433b();
        AsyncTaskC0065f.m332a(this, C0099j.m515a("user.email_igc"), ((EditText) findViewById(R.id.igc_comment)).getText().toString(), this.f457a, ((EditText) findViewById(R.id.igc_filename)).getText().toString(), ((CheckBox) findViewById(R.id.igc_zipit)).isChecked());
    }

    @Override // com.xcglobe.xclog.ActivityC0090a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_upload_email);
        this.f459c = this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xcglobe.xclog.ActivityC0090a, android.app.Activity
    public void onPause() {
        super.onPause();
        finish();
    }

    @Override // com.xcglobe.xclog.ActivityC0090a, android.app.Activity
    public void onResume() {
        super.onResume();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f457a = extras.getString("igc");
        } else {
            finish();
        }
        m432a();
    }
}
