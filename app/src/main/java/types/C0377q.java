package types;

/* renamed from: types.q */
/* loaded from: classes.dex */
public class C0377q {

    /* renamed from: a */
    public static String f2082a;

    /* renamed from: b */
    public static String f2083b;

    /* renamed from: c */
    public static String f2084c;

    /* renamed from: d */
    public static String f2085d;

    /* renamed from: f */
    private static int f2087f;

    /* renamed from: g */
    private static int f2088g;

    /* renamed from: h */
    private static int f2089h;

    /* renamed from: i */
    private static int f2090i;

    /* renamed from: j */
    private static float f2091j;

    /* renamed from: k */
    private static float f2092k;

    /* renamed from: l */
    private static float f2093l;

    /* renamed from: m */
    private static float f2094m;

    /* renamed from: n */
    private static final float[] f2095n = {1.0f, 0.6213712f, 0.539957f};

    /* renamed from: o */
    private static final float[] f2096o = {1.0f, 3.28084f};

    /* renamed from: p */
    private static final float[] f2097p = {1.0f, 0.6213712f, 0.5396118f};

    /* renamed from: q */
    private static final float[] f2098q = {1.0f, 196.85039f, 1.9438444f};

    /* renamed from: r */
    private static final String[] f2099r = {"km", "mi", "nmi"};

    /* renamed from: s */
    private static final String[] f2100s = {"m", "ft"};

    /* renamed from: t */
    private static final String[] f2101t = {"km/h", "mph", "knots"};

    /* renamed from: u */
    private static final String[] f2102u = {"m/s", "fpm", "knots"};

    /* renamed from: e */
    public static int f2086e = 0;

    /* renamed from: a */
    public static float m1278a(float f2) {
        return f2 * f2091j;
    }

    /* renamed from: a */
    public static void m1279a() {
        f2082a = f2099r[f2087f];
        f2083b = f2100s[f2088g];
        f2084c = f2101t[f2089h];
        f2085d = f2102u[f2090i];
        f2091j = f2095n[f2087f];
        f2092k = f2096o[f2088g];
        f2093l = f2097p[f2089h];
        f2094m = f2098q[f2090i];
    }

    /* renamed from: a */
    public static void m1280a(int i2) {
        f2087f = i2;
        f2086e++;
    }

    /* renamed from: b */
    public static float m1281b(float f2) {
        return f2 * f2093l;
    }

    /* renamed from: b */
    public static void m1282b(int i2) {
        f2088g = i2;
        f2086e++;
    }

    /* renamed from: b */
    public static boolean m1283b() {
        return f2090i == 1;
    }

    /* renamed from: c */
    public static float m1284c(float f2) {
        float f3;
        if (f2090i == 1) {
            f3 = 5.0f;
            f2 = (int) ((f2 * f2094m) / 5.0f);
        } else {
            f3 = f2094m;
        }
        return f2 * f3;
    }

    /* renamed from: c */
    public static void m1285c(int i2) {
        f2089h = i2;
        f2086e++;
    }

    /* renamed from: d */
    public static void m1286d(int i2) {
        f2090i = i2;
        f2086e++;
    }

    /* renamed from: e */
    public static int m1287e(int i2) {
        return (int) (i2 * f2092k);
    }

    /* renamed from: f */
    public static int m1288f(int i2) {
        return (int) ((i2 / f2092k) + 0.5f);
    }
}
