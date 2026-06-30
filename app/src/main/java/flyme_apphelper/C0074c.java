package flyme_apphelper;

import android.content.Intent;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0099j;
import com.xcglobe.xclog.C0101l;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import flyme_io.C0217b;
import flyme_io.C0222e;
import flyme_io.flyme_io_a.C0214a;
import flyme_io.flyme_io_a.C0216c;
import flyme_data.C0239g;

/* renamed from: c.c */
/* loaded from: classes.dex */
public class C0074c {

    /* renamed from: b */
    private static boolean f344b = false;

    /* renamed from: c */
    private static C0074c f345c;

    /* renamed from: d */
    private String f347d;

    /* renamed from: o */
    private String f358o;

    /* renamed from: r */
    private C0217b f360r;

    /* renamed from: t */
    private C0216c f362t;

    /* renamed from: q */
    private static float[] f346q = new float[10];

    /* renamed from: a */
    public static int f343a = 0;

    /* renamed from: e */
    private float f348e = 0.0f;

    /* renamed from: f */
    private float f349f = 0.0f;

    /* renamed from: g */
    private float f350g = 0.0f;

    /* renamed from: h */
    private float f351h = 0.0f;

    /* renamed from: i */
    private int f352i = 0;

    /* renamed from: j */
    private int f353j = 0;

    /* renamed from: k */
    private float f354k = 0.0f;

    /* renamed from: l */
    private int f355l = 0;

    /* renamed from: m */
    private int f356m = 0;

    /* renamed from: n */
    private boolean f357n = false;

    /* renamed from: p */
    private float[] f359p = new float[10];

    /* renamed from: s */
    private int f361s = 0;

    /* renamed from: u */
    private long f363u = 0;

    public C0074c(final String str, final boolean z) {
        App.f462c.post(new Runnable() { // from class: c.-$$Lambda$c$JRRut6aqCB3zlgHYOEzMVj67PWM
            @Override // java.lang.Runnable
            public final void run() {
                C0074c.this.m393b(str, z);
            }
        });
    }

    /* renamed from: a */
    private void m389a(C0216c c0216c) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < 5) {
            int i4 = c0216c.f1177s.f1146a[i2];
            int i5 = i3 + 1;
            this.f359p[i3] = this.f360r.f1192c[i4];
            this.f359p[i5] = this.f360r.f1193d[i4];
            i2++;
            i3 = i5 + 1;
        }
    }

    /* renamed from: a */
    private void m390a(String str, boolean z) {
        if (f344b) {
            return;
        }
        if (!z || C0239g.f1414g.size() >= 10) {
            f344b = true;
            this.f358o = str;
            this.f357n = z;
            if (z) {
                this.f360r = new C0222e().m968b(C0239g.f1414g, false);
                this.f353j = this.f360r.m929a();
                this.f347d = new SimpleDateFormat("yyyyMMddHHmm", Locale.US).format(new Date(C0239g.f1414g.get(0).f1975d));
            }
            this.f362t = new C0216c(true);
            if (C0072a.m378a()) {
                this.f362t.f1179u = true;
            }
            this.f362t.f1161c = true;
            f345c = this;
            this.f361s = C0072a.f327a;
            new Thread(new Runnable() { // from class: c.-$$Lambda$c$RyZxJN0-4yMdN1zeGCqouVVy2d8
                @Override // java.lang.Runnable
                public final void run() {
                    C0074c.this.m396c();
                }
            }).start();
        }
    }

    /* renamed from: a */
    private void m391a(final boolean z) {
        App.f462c.post(new Runnable() { // from class: c.-$$Lambda$c$W6LZWR8qXgdqbInwwhIB9mdU5dk
            @Override // java.lang.Runnable
            public final void run() {
                C0074c.this.m397c(z);
            }
        });
    }

    /* renamed from: a */
    public static boolean m392a() {
        return f344b;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m393b(String str, boolean z) {
        try {
            m390a(str, z);
        } catch (Exception e2) {
            f344b = false;
            App.m441a("ScorerTask", e2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public void m397c(boolean z) {
        C0101l.m556b("igc time: " + (System.currentTimeMillis() - this.f363u), true);
        long j2 = (this.f362t.f1176r * 10) + 60000;
        if (C0072a.m378a()) {
            j2 = this.f362t.f1176r < 300 ? 1000L : this.f362t.f1176r + 1000;
        }
        C0239g.f1374E = C0239g.m1073d().f1975d + j2;
        if (!this.f358o.equals("demo-track.igc") || this.f361s == C0072a.f327a) {
            if (z) {
                if (this.f356m > this.f355l) {
                    this.f355l = 0;
                    this.f356m = 0;
                }
                C0099j.m523b(this.f358o, "duration", C0101l.m534a(this.f353j, 0));
                C0099j.m523b(this.f358o, "starttime", this.f347d);
                C0099j.m523b(this.f358o, "kmmaxtype", "" + this.f352i);
                C0099j.m523b(this.f358o, "kmmax", String.format("%.0f", Float.valueOf(this.f351h)));
                C0099j.m523b(this.f358o, "km1", String.format("%.0f", Float.valueOf(this.f348e)));
                C0099j.m523b(this.f358o, "km2", this.f349f == 0.0f ? "" : String.format("%.0f", Float.valueOf(this.f349f)));
                C0099j.m523b(this.f358o, "km3", this.f350g == 0.0f ? "" : String.format("%.0f", Float.valueOf(this.f350g)));
                C0099j.m523b(this.f358o, "altmax", "" + this.f355l);
                C0099j.m523b(this.f358o, "altmin", "" + this.f356m);
                C0099j.m523b(this.f358o, "speed", "" + String.format("%.0f", Float.valueOf(this.f354k)));
                StringBuilder sb = new StringBuilder();
                for (int i2 = 0; i2 < 10; i2++) {
                    f346q[i2] = this.f359p[i2];
                    if (i2 > 0) {
                        sb.append(" ");
                    }
                    sb.append((int) (f346q[i2] * 10000.0f));
                }
                C0099j.m523b(this.f358o, "optpoints", sb.toString());
            } else {
                C0099j.m523b(this.f358o, "kmmax", "?");
            }
            Intent intent = new Intent("com.xcglobe.action.main");
            intent.putExtra("event", 6);
            App.m443b().sendBroadcast(intent);
            if (f345c == this) {
                f345c = null;
            }
        }
    }

    /* renamed from: b */
    private boolean m395b() {
        try {
            C0222e c0222e = new C0222e();
            if (this.f357n) {
                this.f360r.m931c();
                if (C0072a.m378a() && this.f360r.f1203n.m1188d() < 3) {
                    return false;
                }
            } else {
                this.f360r = c0222e.m966a(this.f358o);
                this.f353j = c0222e.f1244a.m951c();
                this.f347d = c0222e.f1244a.f1223m + C0101l.m534a(c0222e.f1244a.f1221k, 4);
            }
            f343a = this.f362t.f1163e;
            this.f363u = System.currentTimeMillis();
            if (!this.f362t.m928a(this.f360r)) {
                return false;
            }
            this.f348e = this.f362t.f1172n.m903a().f1149d;
            this.f349f = this.f362t.f1173o.m903a().f1149d;
            this.f350g = this.f362t.f1174p.m903a().f1149d;
            C0214a c0214a = this.f362t.f1177s;
            this.f352i = c0214a.f1147b;
            this.f351h = c0214a.f1149d;
            this.f355l = this.f360r.f1200k;
            this.f356m = this.f360r.f1201l;
            this.f354k = c0214a.f1152g;
            m389a(this.f362t);
            this.f360r = null;
            return true;
        } catch (Exception e2) {
            App.m441a("ScorerTask.doInBackground", e2);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m396c() {
        m391a(m395b());
        f344b = false;
    }
}
