package com.xcglobe.xclog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import com.xcglobe.flyme.R;
import flyme_tasks.AsyncTaskC0070k;
import flyme_tasks.AsyncTaskC0071l;

/* loaded from: classes.dex */
public class ActivityUpload extends ActivityC0090a {

    /* renamed from: a */
    String f450a;

    /* renamed from: b */
    ProgressDialog f451b = null;

    /* renamed from: c */
    Activity f452c;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m427a(boolean z) {
        String str;
        if (z) {
            str = C0101l.m536a(R.array.server_values, ((Spinner) findViewById(R.id.server)).getSelectedItemPosition(), true);
        } else {
            String m515a = C0099j.m515a("user.server_id");
            ((Spinner) findViewById(R.id.server)).setSelection(C0101l.m531a(R.array.server_values, m515a));
            str = m515a;
        }
        String str2 = "";
        Spinner spinner = (Spinner) findViewById(R.id.leonardo_server);
        if (str.equals("leo_")) {
            spinner.setVisibility(0);
            str2 = C0099j.m515a("user.leo_server_id");
            int m531a = C0101l.m531a(R.array.leonardo_server_values, str2);
            if (m531a >= 0 && !z) {
                spinner.setSelection(m531a);
            }
        } else {
            spinner.setVisibility(8);
        }
        String m515a2 = C0099j.m515a("user.glider");
        ((Spinner) findViewById(R.id.glidertype)).setSelection(C0099j.m521b("user.gtype"));
        ((EditText) findViewById(R.id.glider)).setText(m515a2);
        ((TextView) findViewById(R.id.uplIgcName)).setText(this.f450a);
        String m430a = m430a();
        String m535a = C0101l.m535a(R.array.server_entries, R.array.server_values, str);
        if (str.equals("leo_")) {
            m535a = m535a + " (" + C0101l.m535a(R.array.leonardo_server_entries, R.array.leonardo_server_values, str2) + ")";
        }
        ((TextView) findViewById(R.id.upl_txt_server)).setText(m535a);
        ((TextView) findViewById(R.id.upl_txt_username)).setText(App.m435a(R.string.username) + " " + m430a);
        ((TextView) findViewById(R.id.upl_txt_gmodel)).setText(App.m435a(R.string.gmodel) + " " + m515a2);
        if (m430a.length() == 0 || m515a2.length() == 0) {
            clickChangeData(null);
        }
    }

    /* renamed from: b */
    private void m428b() {
        String m536a = C0101l.m536a(R.array.server_values, ((Spinner) findViewById(R.id.server)).getSelectedItemPosition(), true);
        C0099j.m527d("user.server_id", "" + m536a);
        String str = "";
        if (m536a.equals("leo_")) {
            str = C0101l.m536a(R.array.leonardo_server_values, ((Spinner) findViewById(R.id.leonardo_server)).getSelectedItemPosition(), true);
            C0099j.m527d("user.leo_server_id", str);
        }
        int selectedItemPosition = ((Spinner) findViewById(R.id.glidertype)).getSelectedItemPosition();
        String str2 = "";
        if (!m536a.equals("xcglobe")) {
            str2 = "" + m536a + str;
        }
        C0099j.m527d("user.gtype", "" + selectedItemPosition);
        C0099j.m527d("user.username" + str2, ((EditText) findViewById(R.id.username)).getText().toString());
        C0099j.m527d("user.password" + str2, ((EditText) findViewById(R.id.password)).getText().toString());
        C0099j.m527d("user.glider", ((EditText) findViewById(R.id.glider)).getText().toString());
    }

    /* renamed from: c */
    private void m429c() {
        this.f451b = ProgressDialog.show(this, App.m435a(R.string.upload), App.m435a(R.string.uploading), true, false);
        new AsyncTaskC0070k().execute(new AsyncTaskC0070k.a(this, this.f450a, ((EditText) findViewById(R.id.upl_comment)).getText().toString(), ((CheckBox) findViewById(R.id.upl_private)).isChecked()));
    }

    /* renamed from: a */
    String m430a() {
        String m536a = C0101l.m536a(R.array.server_values, ((Spinner) findViewById(R.id.server)).getSelectedItemPosition(), true);
        String m536a2 = m536a.equals("leo_") ? C0101l.m536a(R.array.leonardo_server_values, ((Spinner) findViewById(R.id.leonardo_server)).getSelectedItemPosition(), true) : "";
        String str = "";
        if (!m536a.equals("xcglobe")) {
            str = "" + m536a + m536a2;
        }
        String m515a = C0099j.m515a("user.username" + str);
        ((EditText) findViewById(R.id.password)).setText(C0099j.m515a("user.password" + str));
        ((EditText) findViewById(R.id.username)).setText(m515a);
        return m515a;
    }

    /* renamed from: a */
    public void m431a(String str, String str2, String str3, final String str4) {
        String str5;
        try {
            this.f451b.dismiss();
        } catch (Exception unused) {
        }
        if (str.length() == 0) {
            str5 = App.m435a(R.string.uploaded_ok);
            C0099j.m523b(this.f450a, "uploaded", "1");
        } else {
            str5 = str;
        }
        C0101l.m545a(this, App.m435a(R.string.upload), str5, str.length() == 0);
        if (str3.length() > 0) {
            new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_info).setTitle(str2).setMessage(str3).setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() { // from class: com.xcglobe.xclog.ActivityUpload.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    if (str4.length() > 0) {
                        ActivityUpload.this.startActivity(new Intent("android.intent.action.VIEW", Uri.parse(str4)));
                    }
                }
            }).setNegativeButton(R.string.no, (DialogInterface.OnClickListener) null).show();
        }
        C0101l.m556b(str5, true);
    }

    public void clickCancel(View view) {
        finish();
    }

    public void clickChangeData(View view) {
        ((LinearLayout) findViewById(R.id.upl_layout_short)).setVisibility(8);
        ((LinearLayout) findViewById(R.id.upl_layout_long)).setVisibility(0);
    }

    public void clickOk(View view) {
        m428b();
        m429c();
    }

    @Override // com.xcglobe.xclog.ActivityC0090a, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_upload);
        this.f452c = this;
        ((Spinner) findViewById(R.id.server)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.xcglobe.xclog.ActivityUpload.1
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
                ActivityUpload.this.m427a(true);
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        ((Spinner) findViewById(R.id.leonardo_server)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { // from class: com.xcglobe.xclog.ActivityUpload.2
            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onItemSelected(AdapterView<?> adapterView, View view, int i2, long j2) {
                ActivityUpload.this.m430a();
            }

            @Override // android.widget.AdapterView.OnItemSelectedListener
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
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
            this.f450a = extras.getString("igc");
        } else {
            finish();
        }
        m427a(false);
        AsyncTaskC0071l.m372a();
    }
}
