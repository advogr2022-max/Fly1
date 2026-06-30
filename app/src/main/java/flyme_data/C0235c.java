package flyme_data;

import com.xcglobe.xclog.C0101l;

/* renamed from: m.c */
/* loaded from: classes.dex */
public class C0235c {

    /* renamed from: e */
    private static int f1335e;

    /* renamed from: f */
    private static int f1336f;

    /* renamed from: b */
    private static short[] f1332b = new short[300];

    /* renamed from: c */
    private static short[] f1333c = new short[300];

    /* renamed from: d */
    private static long[] f1334d = new long[300];

    /* renamed from: g */
    private static int f1337g = 0;

    /* renamed from: h */
    private static int f1338h = 0;

    /* renamed from: a */
    public static float f1331a = 0.0f;

    /* renamed from: a */
    public static void m1038a() {
        if (C0239g.f1431x <= 32) {
            if (C0239g.f1423p < 0.0f) {
                long j2 = C0239g.f1425r;
                if (j2 == 0 || j2 - f1334d[f1337g] < 900) {
                    return;
                }
                f1334d[f1337g] = j2;
                int i2 = f1335e;
                short s = (short) (C0239g.f1422o * 1000.0f);
                f1332b[f1337g] = s;
                f1335e = i2 + s;
                int i3 = f1336f;
                short s2 = (short) C0239g.f1423p;
                f1333c[f1337g] = s2;
                f1336f = i3 + s2;
                long j3 = j2 - 20000;
                int i4 = f1338h;
                while (i4 <= f1337g && f1334d[i4] < j3) {
                    f1335e -= f1332b[i4];
                    f1336f -= f1333c[i4];
                    i4++;
                }
                f1338h = i4;
                f1331a = f1336f < 0 ? (-f1335e) / f1336f : 0.0f;
                int i5 = f1337g + 1;
                f1337g = i5;
                if (i5 == 300) {
                    m1040c();
                }
            }
        }
    }

    /* renamed from: b */
    public static String m1039b() {
        return f1337g + "/" + f1338h + "[" + C0101l.f520E.format(f1335e) + "/" + C0101l.f520E.format(f1336f) + "]";
    }

    /* renamed from: c */
    private static void m1040c() {
        int i2 = 0;
        for (int i3 = f1338h; i3 < f1337g; i3++) {
            f1332b[i2] = f1332b[i3];
            f1333c[i2] = f1333c[i3];
            f1334d[i2] = f1334d[i3];
            i2++;
        }
        f1337g = i2;
        f1338h = 0;
    }
}
