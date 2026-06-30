package flyme_apphelper;

import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0099j;
import com.xcglobe.xclog.C0101l;
import display.vmap.ViewVmp;
import flyme_io.C0220c;
import flyme_poi.C0227a;
import flyme_data.C0237e;
import flyme_data.C0239g;

/* renamed from: c.a */
/* loaded from: classes.dex */
public class C0072a {

    /* renamed from: a */
    static int f327a = 0;

    /* renamed from: b */
    private static boolean f328b = false;

    /* renamed from: c */
    private static boolean f329c = false;

    /* renamed from: f */
    private static boolean f330f = false;

    /* renamed from: d */
    private long f331d;

    /* renamed from: e */
    private String f332e;

    private C0072a(String str) {
        if (f328b) {
            return;
        }
        this.f332e = str;
        f327a++;
        f328b = true;
        f329c = false;
        C0239g.m1068b();
        C0099j.m523b("demo-track.igc", "kmmaxtype", "0");
        C0237e.f1352a = false;
        ViewVmp.setFlag(4);
        new Thread(new Runnable() { // from class: c.a.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C0072a.this.m383c();
                } catch (Exception e2) {
                    App.m441a("GpsPlayer", e2);
                }
                C0072a.this.m384d();
            }
        }).start();
    }

    /* renamed from: a */
    public static void m377a(final String str) {
        App.f462c.post(new Runnable() { // from class: c.a.2
            @Override // java.lang.Runnable
            public void run() {
                new C0072a(str);
            }
        });
    }

    /* renamed from: a */
    public static boolean m378a() {
        return f328b;
    }

    /* renamed from: b */
    public static void m380b() {
        f329c = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m383c() {
        long j2;
        long j3;
        C0220c c0220c = new C0220c(C0101l.m558c() + "/" + this.f332e);
        boolean equals = this.f332e.equals("demo-task.igc");
        long currentTimeMillis = System.currentTimeMillis();
        long j4 = 0;
        boolean z = equals;
        long j5 = 0;
        long j6 = 50;
        int i2 = 0;
        while (c0220c.m949b()) {
            int i3 = i2 + 1;
            long j7 = j5 == j4 ? c0220c.f1216f : j5;
            this.f331d = c0220c.f1216f - j7;
            if (f329c || App.m451f()) {
                break;
            }
            final long j8 = currentTimeMillis + this.f331d;
            final float f2 = c0220c.f1218h;
            final float f3 = c0220c.f1219i;
            final short s = c0220c.f1220j;
            App.f462c.post(new Runnable() { // from class: c.a.3
                @Override // java.lang.Runnable
                public void run() {
                    if (App.m451f()) {
                        return;
                    }
                    C0239g.m1063a(f2, f3, s, j8, -1);
                }
            });
            long j9 = (this.f331d / i3) / 1000;
            if (i3 % 10 == 0) {
                long j10 = (j9 * 2) + 50;
                j6 = j10 < 50 ? 50L : j10;
            }
            boolean isRotating = ViewVmp.isRotating();
            if (ViewVmp.isThermailing() && isRotating) {
                j3 = 150;
            } else if (isRotating) {
                j3 = 100;
            } else {
                j2 = j6;
                if (z && (C0227a.f1276a == null || C0227a.f1276a.f1295s)) {
                    z = false;
                }
                Thread.sleep(j2);
                i2 = i3;
                j5 = j7;
                j4 = 0;
            }
            j2 = j6 + j3;
            if (z) {
                z = false;
            }
            Thread.sleep(j2);
            i2 = i3;
            j5 = j7;
            j4 = 0;
        }
        c0220c.m947a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m384d() {
        App.f462c.post(new Runnable() { // from class: c.a.4
            @Override // java.lang.Runnable
            public void run() {
                C0239g.m1066a(C0072a.this.f332e);
                if ("demo-task.igc".equals(C0072a.this.f332e) && C0227a.f1276a != null) {
                    C0227a.m988a(C0227a.f1276a.f1278b);
                }
                C0237e.f1352a = true;
                boolean unused = C0072a.f328b = false;
            }
        });
    }
}
