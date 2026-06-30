package flyme_data;

import com.xcglobe.xclog.C0101l;
import flyme_apphelper.C0072a;
import types.GpsVal;

/* renamed from: m.f */
/* loaded from: classes.dex */
public class C0238f {

    /* renamed from: c */
    private static float f1359c;

    /* renamed from: d */
    private static float f1360d;

    /* renamed from: e */
    private static int f1361e;

    /* renamed from: b */
    private static final int[] f1358b = {8, 4, 4000, 15, 5, 3000, 3, 1, 10000, 40, 7, 4000};

    /* renamed from: f */
    private static long f1362f = 0;

    /* renamed from: g */
    private static long f1363g = 0;

    /* renamed from: h */
    private static int f1364h = 0;

    /* renamed from: i */
    private static int f1365i = 0;

    /* renamed from: j */
    private static boolean f1366j = false;

    /* renamed from: a */
    public static a f1357a = a.FLY;

    /* renamed from: m.f$a */
    /* loaded from: classes.dex */
    public enum a {
        STAND,
        FLY
    }

    /* renamed from: a */
    public static void m1055a() {
        f1363g = 0L;
        f1362f = 0L;
        f1365i = 0;
        f1364h = 0;
        f1366j = false;
        m1058c();
        f1357a = a.STAND;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x004c, code lost:
    
        if (flyme_data.C0239g.f1433z != false) goto L25;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m1056a(GpsVal gpsVal) {
        if (f1357a == a.STAND) {
            if (f1366j || (C0239g.f1418k > f1359c && C0101l.f559ai != 4)) {
                if (f1362f == 0) {
                    f1362f = gpsVal.f1975d;
                }
                if (!f1366j && !C0072a.m378a()) {
                    int i2 = f1364h + 1;
                    f1364h = i2;
                    if (i2 >= 3) {
                        if (gpsVal.f1975d - f1362f > f1361e) {
                        }
                    }
                }
                f1357a = a.FLY;
                f1363g = 0L;
                f1365i = 0;
                f1366j = false;
                return true;
            }
            f1362f = 0L;
            f1364h = 0;
        } else {
            if (C0101l.f559ai == 4) {
                return false;
            }
            if (C0239g.f1418k < f1360d) {
                if (f1363g == 0) {
                    f1363g = gpsVal.f1975d;
                }
                int i3 = f1365i + 1;
                f1365i = i3;
                if (i3 >= 3 && gpsVal.f1975d - f1363g > 180000 && !C0072a.m378a()) {
                    f1357a = a.STAND;
                    f1362f = 0L;
                    f1364h = 0;
                    return true;
                }
            } else {
                f1365i = 0;
                f1363g = 0L;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static void m1057b() {
        f1366j = true;
    }

    /* renamed from: c */
    public static void m1058c() {
        int i2 = C0101l.f559ai * 3;
        if (C0101l.f559ai == 4) {
            i2 = 0;
        }
        f1359c = f1358b[i2];
        f1360d = f1358b[i2 + 1];
        f1361e = f1358b[i2 + 2];
    }

    /* renamed from: d */
    public static boolean m1059d() {
        return f1357a == a.FLY;
    }

    /* renamed from: e */
    public static void m1060e() {
        f1357a = a.STAND;
    }
}
