package com.xcglobe.xclog;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import com.xcglobe.flyme.R;
import display.ViewDataList;
import java.util.Timer;
import java.util.TimerTask;
import flyme_tasks.AsyncTaskC0061b;
import flyme_tasks.AsyncTaskC0066g;
import flyme_apphelper.C0073b;
import flyme_apphelper.C0074c;
import flyme_intentutil.C0225a;
import flyme_data.C0235c;
import flyme_data.C0236d;
import flyme_data.C0239g;
import types.GpsVal;

/* loaded from: classes.dex */
public class ActivityDataList extends ActivityC0090a {

    /* renamed from: A */
    ViewDataList f368A;

    /* renamed from: B */
    ViewDataList f369B;

    /* renamed from: C */
    ViewDataList f370C;

    /* renamed from: D */
    ViewDataList f371D;

    /* renamed from: E */
    ViewDataList f372E;

    /* renamed from: F */
    ViewDataList f373F;

    /* renamed from: G */
    ViewDataList f374G;

    /* renamed from: H */
    ViewDataList f375H;

    /* renamed from: I */
    ViewDataList f376I;

    /* renamed from: J */
    ViewDataList f377J;

    /* renamed from: K */
    ViewDataList f378K;

    /* renamed from: L */
    ViewDataList f379L;

    /* renamed from: M */
    ViewDataList f380M;

    /* renamed from: N */
    ViewDataList f381N;

    /* renamed from: O */
    Timer f382O;

    /* renamed from: P */
    TimerTask f383P;

    /* renamed from: a */
    Activity f384a = this;

    /* renamed from: b */
    boolean f385b = true;

    /* renamed from: c */
    ViewDataList f386c;

    /* renamed from: d */
    ViewDataList f387d;

    /* renamed from: e */
    ViewDataList f388e;

    /* renamed from: f */
    ViewDataList f389f;

    /* renamed from: g */
    ViewDataList f390g;

    /* renamed from: h */
    ViewDataList f391h;

    /* renamed from: i */
    ViewDataList f392i;

    /* renamed from: j */
    ViewDataList f393j;

    /* renamed from: k */
    ViewDataList f394k;

    /* renamed from: l */
    ViewDataList f395l;

    /* renamed from: m */
    ViewDataList f396m;

    /* renamed from: n */
    ViewDataList f397n;

    /* renamed from: o */
    ViewDataList f398o;

    /* renamed from: p */
    ViewDataList f399p;

    /* renamed from: q */
    ViewDataList f400q;

    /* renamed from: r */
    ViewDataList f401r;

    /* renamed from: s */
    ViewDataList f402s;

    /* renamed from: t */
    ViewDataList f403t;

    /* renamed from: u */
    ViewDataList f404u;

    /* renamed from: v */
    ViewDataList f405v;

    /* renamed from: w */
    ViewDataList f406w;

    /* renamed from: x */
    ViewDataList f407x;

    /* renamed from: y */
    ViewDataList f408y;

    /* renamed from: z */
    ViewDataList f409z;

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m401b() {
        ViewDataList viewDataList;
        String str;
        GpsVal m1073d = C0239g.m1073d();
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = (currentTimeMillis - m1073d.f1975d) / 1000;
        this.f374G.update(C0235c.m1039b());
        this.f386c.update(C0239g.f1416i, 2);
        this.f387d.update((int) m1073d.f1974c);
        this.f388e.update(C0239g.f1427t);
        this.f389f.update(C0239g.f1429v);
        this.f390g.update(C0239g.f1428u);
        this.f393j.update(C0239g.f1421n);
        this.f394k.update(C0239g.f1418k);
        if (this.f377J.stateOpened) {
            this.f391h.update(m1073d.f1972a, 5);
            this.f392i.update(m1073d.f1973b, 5);
            this.f396m.update(C0239g.f1419l);
            if (C0239g.f1380K > 0) {
                this.f398o.update((C0239g.f1379J / C0239g.f1380K) / 1000.0f);
            }
            if (j2 < 1000) {
                this.f395l.update((float) j2);
            } else {
                this.f395l.update("-");
            }
            if (C0236d.f1340b) {
                this.f397n.update("[b] " + String.valueOf(C0236d.f1339a));
            } else {
                this.f397n.update(C0236d.f1339a);
            }
            if (C0239g.f1433z) {
                viewDataList = this.f399p;
                str = "Yes";
            } else {
                viewDataList = this.f399p;
                str = "No:" + C0239g.f1371B;
            }
            viewDataList.update(str);
            this.f400q.update(C0236d.f1341c);
        }
        if (this.f378K.stateOpened) {
            this.f403t.update(C0239g.f1385P.m869b());
        }
        this.f408y.update(C0225a.f1256a.size());
        long j3 = (currentTimeMillis - C0225a.f1258c) / 1000;
        if (j3 < 1000) {
            this.f404u.update((int) j3);
        } else {
            this.f404u.update("-");
        }
        if (C0225a.f1259d != null) {
            if (!this.f385b) {
                this.f405v.setVisibility(0);
                this.f385b = true;
            }
            this.f405v.update(C0225a.f1259d);
        } else if (this.f385b) {
            this.f405v.setVisibility(8);
            this.f385b = false;
        }
        this.f406w.update(Integer.toString(C0225a.f1260e) + "/" + C0225a.f1261f);
        long currentTimeMillis2 = (C0225a.f1257b - System.currentTimeMillis()) / 1000;
        if (currentTimeMillis2 > 0) {
            this.f407x.update((int) currentTimeMillis2);
        } else {
            this.f407x.update("-");
        }
        this.f409z.update(C0239g.f1414g.size());
        this.f368A.update(C0074c.f343a);
        this.f370C.update(C0073b.f341a);
        this.f371D.update(AsyncTaskC0061b.f253d);
        this.f373F.update(C0101l.f566ap);
        this.f372E.update(AsyncTaskC0066g.f301a);
    }

    /* renamed from: a */
    public void m402a() {
        this.f382O = new Timer();
        this.f383P = new TimerTask() { // from class: com.xcglobe.xclog.ActivityDataList.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                ActivityDataList.this.runOnUiThread(new Runnable() { // from class: com.xcglobe.xclog.ActivityDataList.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        ActivityDataList.this.m401b();
                    }
                });
            }
        };
        this.f382O.scheduleAtFixedRate(this.f383P, 0L, 1000L);
    }

    @Override // com.xcglobe.xclog.ActivityC0090a
    /* renamed from: a */
    protected void mo399a(int i2, Intent intent) {
        if (i2 == 5) {
            C0101l.m546a(C0239g.m1077h(), this.f384a);
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
        m401b();
    }

    /* renamed from: a */
    public void m403a(ViewDataList viewDataList) {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.datalist_cntainer);
        int i2 = viewDataList.stateOpened ? 0 : 8;
        boolean z = false;
        for (int i3 = 0; i3 < linearLayout.getChildCount(); i3++) {
            View childAt = linearLayout.getChildAt(i3);
            if (childAt.getClass() == ViewDataList.class) {
                ViewDataList viewDataList2 = (ViewDataList) childAt;
                if (viewDataList2.isTitle) {
                    if (z) {
                        return;
                    }
                    if (viewDataList2 == viewDataList) {
                        z = true;
                    }
                } else if (z) {
                    viewDataList2.setVisibility(i2);
                }
            }
        }
    }

    @Override // com.xcglobe.xclog.ActivityC0090a, android.app.Activity
    public void onCreate(Bundle bundle) {
        setTheme(R.style.AppThemeWhite);
        super.onCreate(bundle);
        this.f476S = true;
        setContentView(R.layout.activity_datalist);
        TypedArray obtainStyledAttributes = getTheme().obtainStyledAttributes(new int[]{android.R.attr.colorBackground, android.R.attr.textColorPrimary, android.R.attr.textColorTertiary, android.R.attr.textColorTertiary});
        int color = obtainStyledAttributes.getColor(0, 16711935);
        int color2 = obtainStyledAttributes.getColor(1, 16711935);
        int color3 = obtainStyledAttributes.getColor(2, 16711935);
        int color4 = obtainStyledAttributes.getColor(3, 16711935);
        obtainStyledAttributes.recycle();
        ViewDataList.colorText = color3;
        ViewDataList.colorDivider = color4;
        ViewDataList.colorTextValue = color2;
        ViewDataList.colorBack = color;
        ViewDataList.colorText = C0101l.f594s;
        ViewDataList.colorDivider = C0101l.f594s;
        ViewDataList.colorTextValue = C0101l.f591p;
        ViewDataList.colorBack = C0101l.f592q;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.datalist_cntainer);
        ViewDataList viewDataList = new ViewDataList(this, "Vario", "m/s");
        this.f386c = viewDataList;
        linearLayout.addView(viewDataList);
        ViewDataList viewDataList2 = new ViewDataList(this, "Alt. GPS", "m");
        this.f387d = viewDataList2;
        linearLayout.addView(viewDataList2);
        ViewDataList viewDataList3 = new ViewDataList(this, "Alt. Baro", "m");
        this.f388e = viewDataList3;
        linearLayout.addView(viewDataList3);
        ViewDataList viewDataList4 = new ViewDataList(this, "Alt. AGL", "m");
        this.f389f = viewDataList4;
        linearLayout.addView(viewDataList4);
        ViewDataList viewDataList5 = new ViewDataList(this, "Elevation", "m");
        this.f390g = viewDataList5;
        linearLayout.addView(viewDataList5);
        ViewDataList viewDataList6 = new ViewDataList(this, "Speed point", "km/h");
        this.f393j = viewDataList6;
        linearLayout.addView(viewDataList6);
        ViewDataList viewDataList7 = new ViewDataList(this, "Speed avg.", "km/h");
        this.f394k = viewDataList7;
        linearLayout.addView(viewDataList7);
        ViewDataList viewDataList8 = new ViewDataList(this, "Debug");
        this.f374G = viewDataList8;
        linearLayout.addView(viewDataList8);
        ViewDataList viewDataList9 = new ViewDataList(this, "#GPS");
        this.f377J = viewDataList9;
        linearLayout.addView(viewDataList9);
        ViewDataList viewDataList10 = new ViewDataList(this, "Latitude");
        this.f391h = viewDataList10;
        linearLayout.addView(viewDataList10);
        ViewDataList viewDataList11 = new ViewDataList(this, "Longitude");
        this.f392i = viewDataList11;
        linearLayout.addView(viewDataList11);
        ViewDataList viewDataList12 = new ViewDataList(this, "Accuracy");
        this.f396m = viewDataList12;
        linearLayout.addView(viewDataList12);
        ViewDataList viewDataList13 = new ViewDataList(this, "AVG interval", "s");
        this.f398o = viewDataList13;
        linearLayout.addView(viewDataList13);
        ViewDataList viewDataList14 = new ViewDataList(this, "Idle", "s");
        this.f395l = viewDataList14;
        linearLayout.addView(viewDataList14);
        ViewDataList viewDataList15 = new ViewDataList(this, "EGM96", "m");
        this.f397n = viewDataList15;
        linearLayout.addView(viewDataList15);
        ViewDataList viewDataList16 = new ViewDataList(this, "Is steady", "");
        this.f399p = viewDataList16;
        linearLayout.addView(viewDataList16);
        ViewDataList viewDataList17 = new ViewDataList(this, "Satellites", "");
        this.f400q = viewDataList17;
        linearLayout.addView(viewDataList17);
        ViewDataList viewDataList18 = new ViewDataList(this, "#Vario");
        this.f378K = viewDataList18;
        linearLayout.addView(viewDataList18);
        ViewDataList viewDataList19 = new ViewDataList(this, "AVG interval", "s");
        this.f401r = viewDataList19;
        linearLayout.addView(viewDataList19);
        ViewDataList viewDataList20 = new ViewDataList(this, "Range points", "");
        this.f402s = viewDataList20;
        linearLayout.addView(viewDataList20);
        ViewDataList viewDataList21 = new ViewDataList(this, "Alt. range points", "");
        this.f403t = viewDataList21;
        linearLayout.addView(viewDataList21);
        ViewDataList viewDataList22 = new ViewDataList(this, "#LiveTrack");
        this.f376I = viewDataList22;
        linearLayout.addView(viewDataList22);
        ViewDataList viewDataList23 = new ViewDataList(this, "Pilots", "");
        this.f408y = viewDataList23;
        linearLayout.addView(viewDataList23);
        ViewDataList viewDataList24 = new ViewDataList(this, "Livetrack idle", "s");
        this.f404u = viewDataList24;
        linearLayout.addView(viewDataList24);
        ViewDataList viewDataList25 = new ViewDataList(this, "Next update", "s");
        this.f407x = viewDataList25;
        linearLayout.addView(viewDataList25);
        ViewDataList viewDataList26 = new ViewDataList(this, "Success/Error", "");
        this.f406w = viewDataList26;
        linearLayout.addView(viewDataList26);
        ViewDataList viewDataList27 = new ViewDataList(this, "", "");
        this.f405v = viewDataList27;
        linearLayout.addView(viewDataList27);
        ViewDataList viewDataList28 = new ViewDataList(this, "#Speed Ring");
        this.f379L = viewDataList28;
        linearLayout.addView(viewDataList28);
        ViewDataList viewDataList29 = new ViewDataList(this, "Turn/Strght");
        this.f375H = viewDataList29;
        linearLayout.addView(viewDataList29);
        ViewDataList viewDataList30 = new ViewDataList(this, "#Counters");
        this.f380M = viewDataList30;
        linearLayout.addView(viewDataList30);
        ViewDataList viewDataList31 = new ViewDataList(this, "Vmp");
        this.f369B = viewDataList31;
        linearLayout.addView(viewDataList31);
        ViewDataList viewDataList32 = new ViewDataList(this, "Ground");
        this.f370C = viewDataList32;
        linearLayout.addView(viewDataList32);
        ViewDataList viewDataList33 = new ViewDataList(this, "Air");
        this.f371D = viewDataList33;
        linearLayout.addView(viewDataList33);
        ViewDataList viewDataList34 = new ViewDataList(this, "POI");
        this.f372E = viewDataList34;
        linearLayout.addView(viewDataList34);
        ViewDataList viewDataList35 = new ViewDataList(this, "Session");
        this.f373F = viewDataList35;
        linearLayout.addView(viewDataList35);
        ViewDataList viewDataList36 = new ViewDataList(this, "#Number of points");
        this.f381N = viewDataList36;
        linearLayout.addView(viewDataList36);
        ViewDataList viewDataList37 = new ViewDataList(this, "Track");
        this.f409z = viewDataList37;
        linearLayout.addView(viewDataList37);
        ViewDataList viewDataList38 = new ViewDataList(this, "Optimizer");
        this.f368A = viewDataList38;
        linearLayout.addView(viewDataList38);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.xcglobe.xclog.ActivityC0090a, android.app.Activity
    public void onPause() {
        super.onPause();
        this.f382O.cancel();
        this.f382O.purge();
    }

    @Override // com.xcglobe.xclog.ActivityC0090a, android.app.Activity
    public void onResume() {
        super.onResume();
        m401b();
        m402a();
    }
}
