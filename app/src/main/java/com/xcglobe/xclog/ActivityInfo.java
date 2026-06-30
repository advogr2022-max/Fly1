package com.xcglobe.xclog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.FileProvider;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.xcglobe.flyme.R;
import display.vmap.ViewVmp;
import java.io.File;
import java.io.IOException;
import flyme_apphelper.C0072a;
import flyme_apphelper.C0074c;
import flyme_io.C0223f;
import flyme_io.C0224g;
import flyme_data.C0238f;
import types.C0377q;

/* loaded from: classes.dex */
public class ActivityInfo extends ActivityC0090a {
    // private static int r1 = 0;

    /* renamed from: a */
    static Activity f417a;

    /* renamed from: b */
    int f418b = 0;

    /* renamed from: c */
    TextView f419c;

    /* renamed from: d */
    TextView f420d;

    /* renamed from: e */
    TextView f421e;

    /* renamed from: f */
    ImageView f422f;

    /* renamed from: g */
    ImageView f423g;

    /* renamed from: h */
    ImageView f424h;

    /* renamed from: i */
    TextView f425i;

    /* renamed from: j */
    TextView f426j;

    /* renamed from: k */
    TextView f427k;

    /* renamed from: l */
    String f428l;

    /* JADX WARN: Failed to find 'out' block for switch in B:16:0x01d0. Please report as an issue. */
    /* renamed from: a */
    public void m408a() {
        String str;
        TextView textView;
        String str2 = "-";
        String str3 = "-";
        String str4 = "-";
        String m529f = C0099j.m529f(this.f428l, "km1");
        String m529f2 = C0099j.m529f(this.f428l, "km2");
        String m529f3 = C0099j.m529f(this.f428l, "km3");
        int m530g = C0099j.m530g(this.f428l, "kmmaxtype");
        if (m529f.length() > 0) {
            StringBuilder sb = new StringBuilder();
            double m1278a = C0377q.m1278a(C0101l.m573i(m529f));
            Double.isNaN(m1278a);
            sb.append(String.valueOf((int) (m1278a + 0.5d)));
            sb.append(" ");
            sb.append(C0377q.f2082a);
            str = sb.toString();
            this.f422f.setVisibility(0);
        } else {
            this.f422f.setVisibility(8);
            str = "-";
        }
        if (m529f2.length() > 0) {
            StringBuilder sb2 = new StringBuilder();
            double m1278a2 = C0377q.m1278a(C0101l.m573i(m529f2));
            Double.isNaN(m1278a2);
            sb2.append(String.valueOf((int) (m1278a2 + 0.5d)));
            sb2.append(" ");
            sb2.append(C0377q.f2082a);
            m529f2 = sb2.toString();
            this.f423g.setVisibility(0);
        } else {
            this.f423g.setVisibility(8);
        }
        if (m529f3.length() > 0) {
            StringBuilder sb3 = new StringBuilder();
            double m1278a3 = C0377q.m1278a(C0101l.m573i(m529f3));
            Double.isNaN(m1278a3);
            sb3.append(String.valueOf((int) (m1278a3 + 0.5d)));
            sb3.append(" ");
            sb3.append(C0377q.f2082a);
            m529f3 = sb3.toString();
            this.f424h.setVisibility(0);
        } else {
            this.f424h.setVisibility(8);
        }
        if (C0074c.m392a() && C0099j.m529f(this.f428l, "kmmax").length() == 0) {
            str = getString(R.string.calculating);
        } else {
            int m530g2 = C0099j.m530g(this.f428l, "altmin");
            if (m530g2 != 0) {
                String valueOf = String.valueOf(C0377q.m1287e(m530g2));
                int m530g3 = C0099j.m530g(this.f428l, "altmax");
                if (m530g3 > 0) {
                    valueOf = valueOf + " / " + C0377q.m1287e(m530g3);
                }
                str2 = valueOf + " " + C0377q.f2083b + " [min/max]";
            }
            if (C0099j.m529f(this.f428l, "speed").length() > 0) {
                str3 = C0101l.f520E.format(0) + " " + C0377q.f2084c + " [OLC task]";
            } else {
                str3 = "-";
            }
            String m563d = C0101l.m563d(C0099j.m529f(this.f428l, "starttime"));
            if (m563d.length() > 0) {
                str4 = m563d + " [" + C0099j.m529f(this.f428l, "duration") + "]";
            }
        }
        this.f419c.setText(str);
        this.f420d.setText(m529f2);
        this.f421e.setText(m529f3);
        this.f425i.setText(str2);
        this.f426j.setText(str3);
        this.f427k.setText(str4);
        switch (m530g) {
            case 1:
                textView = this.f419c;
                textView.setTextColor(C0101l.f588m);
                return;
            case 2:
                textView = this.f420d;
                textView.setTextColor(C0101l.f588m);
                return;
            case 3:
                textView = this.f421e;
                textView.setTextColor(C0101l.f588m);
                return;
            default:
                return;
        }
    }

    @Override // com.xcglobe.xclog.ActivityC0090a
    /* renamed from: a */
    protected void mo399a(int i2, Intent intent) {
        if (i2 == 6) {
            m410b();
        } else {
            if (i2 != 9) {
                return;
            }
            C0101l.m566e();
        }
    }

    /* renamed from: a */
    public void m409a(String str) {
        try {
            String[] split = str.split("\\.");
            String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(split.length >= 2 ? split[split.length - 1] : "");
            File file = new File(str);
            Uri fromFile = Build.VERSION.SDK_INT < 24 ? Uri.fromFile(file) : Uri.fromFile( file);
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(fromFile, mimeTypeFromExtension);
            intent.setFlags(268435456);
            intent.addFlags(1);
            startActivity(intent);
        } catch (IllegalArgumentException e2) {
            C0101l.m561c(e2.getLocalizedMessage(), true);
        }
    }

    /* renamed from: b */
    public void m410b() {
        this.f428l = null;
        ((Button) findViewById(R.id.buttonMap)).setText(getString(R.string.button_map));
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f428l = extras.getString("igc");
        }
        if (this.f428l == null || this.f428l.length() == 0) {
            finish();
            return;
        }
        boolean m477f = C0095f.m477f();
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.expired_note);
        if (m477f) {
            linearLayout.setVisibility(0);
        } else {
            linearLayout.setVisibility(8);
        }
        ((TextView) findViewById(R.id.textIgcName)).setText(this.f428l);
        m408a();
        if (C0238f.m1059d()) {
            findViewById(R.id.buttonMap).setEnabled(false);
            findViewById(R.id.buttonUpload).setEnabled(false);
            findViewById(R.id.buttonSimulation).setEnabled(false);
        } else if (C0099j.m529f(this.f428l, "kmmax").length() == 0) {
            new C0074c(this.f428l, false);
        }
        if (this.f428l.equals("demo.igc")) {
            findViewById(R.id.buttonUpload).setEnabled(false);
            findViewById(R.id.buttonDeleteIgc).setEnabled(false);
            findViewById(R.id.buttonExportIgc).setEnabled(false);
            findViewById(R.id.buttonSendToMail).setEnabled(false);
        }
        if (m477f) {
            findViewById(R.id.buttonUpload).setEnabled(false);
        }
    }

    /* renamed from: b */
    void m411b(final String str) {
        new AlertDialog.Builder(this).setIcon(android.R.drawable.ic_dialog_alert).setTitle(R.string.delete_track).setMessage(App.m435a(R.string.sure_delete_track) + str + "?").setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() { // from class: com.xcglobe.xclog.ActivityInfo.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                C0101l.m559c(str);
                ActivityInfo.this.finish();
            }
        }).setNegativeButton(R.string.no, (DialogInterface.OnClickListener) null).show();
    }

    public void clickBack(View view) {
        finish();
    }

    public void clickDelete(View view) {
        m411b(this.f428l);
    }

    public void clickMap(View view) {
        ((Button) view).setText(getString(R.string.loading));
        Bundle bundle = new Bundle();
        bundle.putString("igc", this.f428l);
        Intent intent = new Intent(this, (Class<?>) ActivityMap.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void clickSimulation(View view) {
        C0072a.m377a(this.f428l);
        C0101l.m566e();
        ViewVmp.setFlag(32);
    }

    public void clickUpload(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("igc", this.f428l);
        Intent intent = new Intent(this, (Class<?>) ActivityUpload.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }

    public void exportIgc(View view) {
        String str = C0101l.m558c() + "/" + this.f428l;
        String m562d = C0101l.m562d();
        if (m562d == null) {
            C0101l.m561c(App.m435a(R.string.cant_access_external_files), true);
            return;
        }
        new File(m562d + "/igc").mkdirs();
        try {
            C0101l.m564d(str, m562d + "/igc/" + this.f428l);
            C0101l.m561c(App.m435a(R.string.exported_to) + "/xcglobe/igc/" + this.f428l, true);
        } catch (IOException unused) {
            C0101l.m561c(App.m435a(R.string.cant_access_external_files), true);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        finish();
    }

    @Override // com.xcglobe.xclog.ActivityC0090a, android.app.Activity
    public void onCreate(Bundle bundle) {
        setTheme(R.style.AppThemeBlack);
        f417a = this;
        super.onCreate(bundle);
        setContentView(R.layout.activity_info);
        this.f476S = true;
        this.f419c = (TextView) findViewById(R.id.ttxtKm1);
        this.f420d = (TextView) findViewById(R.id.ttxtKm2);
        this.f421e = (TextView) findViewById(R.id.ttxtKm3);
        this.f422f = (ImageView) findViewById(R.id.timgKm1);
        this.f423g = (ImageView) findViewById(R.id.timgKm2);
        this.f424h = (ImageView) findViewById(R.id.timgKm3);
        this.f425i = (TextView) findViewById(R.id.ttxtAlt);
        this.f426j = (TextView) findViewById(R.id.ttxtSpd);
        this.f427k = (TextView) findViewById(R.id.ttxtTimeinfo);
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        setIntent(intent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xcglobe.xclog.ActivityC0090a, android.app.Activity
    public void onPause() {
        super.onPause();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xcglobe.xclog.ActivityC0090a, android.app.Activity
    public void onResume() {
        super.onResume();
        m410b();
    }

    @Override // android.app.Activity
    protected void onStart() {
        super.onStart();
    }

    public void openEarth(View view) {
        String localizedMessage;
        C0101l.m543a(R.string.creating_kml, true);
        if (C0101l.m557b(new C0224g().m971a(C0223f.m969a(C0101l.m558c() + "/" + this.f428l, null), this.f428l), "kml/flyme.kml")) {
            try {
                m409a(C0101l.m537a("kml/flyme.kml"));
                return;
            } catch (Exception e2) {
                localizedMessage = e2.getLocalizedMessage();
            }
        } else {
            localizedMessage = App.m435a(R.string.cant_access_external_files);
        }
        C0101l.m561c(localizedMessage, true);
    }

    public void sendToMail(View view) {
        Bundle bundle = new Bundle();
        bundle.putString("igc", this.f428l);
        Intent intent = new Intent(this, (Class<?>) ActivityUploadEmail.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
