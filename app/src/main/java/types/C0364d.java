package types;

/* renamed from: types.d */
/* loaded from: classes.dex */
public class C0364d {

    /* renamed from: a */
    public static float f1997a = 6371.0f;

    /* renamed from: b */
    public float f1998b;

    /* renamed from: c */
    public float f1999c;

    /* renamed from: d */
    public float f2000d;

    /* renamed from: e */
    public float f2001e;

    /* renamed from: f */
    public float f2002f;

    public C0364d(float f2, float f3) {
        m1190c(f2, f3);
    }

    /* renamed from: b */
    public static float m1189b(float f2, float f3, float f4, float f5) {
        double d2 = f2;
        Double.isNaN(d2);
        double d3 = (d2 * 3.141592653589793d) / 180.0d;
        double d4 = f4;
        Double.isNaN(d4);
        double d5 = (d4 * 3.141592653589793d) / 180.0d;
        double d6 = f3;
        Double.isNaN(d6);
        double d7 = f5;
        Double.isNaN(d7);
        double asin = Math.asin(Math.sqrt(Math.pow(Math.sin((d3 - d5) / 2.0d), 2.0d) + (Math.cos(d3) * Math.cos(d5) * Math.pow(Math.sin((((d6 * 3.141592653589793d) / 180.0d) - ((d7 * 3.141592653589793d) / 180.0d)) / 2.0d), 2.0d)))) * 2.0d;
        double d8 = f1997a;
        Double.isNaN(d8);
        return (float) (asin * d8);
    }

    /* renamed from: c */
    private void m1190c(float f2, float f3) {
        this.f1998b = f2;
        this.f1999c = f3;
        float m1189b = 100.0f / m1189b(f2, 0.0f, f2, 1.0f);
        this.f2000d = m1191e(f2);
        this.f2001e = 100.0f / m1189b;
        this.f2002f = this.f2001e * this.f2000d;
    }

    /* renamed from: e */
    public static float m1191e(float f2) {
        return m1189b(f2, 0.0f, f2 + 1.0f, 0.0f) / m1189b(f2, 0.0f, f2, 1.0f);
    }

    /* renamed from: a */
    public float m1192a(float f2) {
        return (f2 - this.f1999c) * this.f2001e;
    }

    /* renamed from: a */
    public float m1193a(float f2, float f3, float f4, float f5) {
        return C0365e.m1202a(m1192a((f3 - f5) + this.f1999c), m1198b((f2 - f4) + this.f1998b));
    }

    /* renamed from: a */
    public void m1194a(float f2, float f3) {
        this.f1998b = f2;
        this.f1999c = f3;
    }

    /* renamed from: a */
    public void m1195a(float f2, float f3, Coord coord) {
        coord.f1970a = m1192a(f3);
        coord.f1971b = m1198b(f2);
    }

    /* renamed from: a */
    public void m1196a(Coord coord, C0372l c0372l) {
        c0372l.f2053a = m1200c(coord.f1971b);
        c0372l.f2054b = m1201d(coord.f1970a);
    }

    /* renamed from: a */
    public void m1197a(C0372l c0372l, Coord coord) {
        coord.f1970a = m1192a(c0372l.f2054b);
        coord.f1971b = m1198b(c0372l.f2053a);
    }

    /* renamed from: b */
    public float m1198b(float f2) {
        return (f2 - this.f1998b) * this.f2002f;
    }

    /* renamed from: b */
    public float m1199b(float f2, float f3) {
        return C0365e.m1202a(m1192a(f3), m1198b(f2));
    }

    /* renamed from: c */
    public float m1200c(float f2) {
        return this.f1998b + (f2 / this.f2002f);
    }

    /* renamed from: d */
    public float m1201d(float f2) {
        return this.f1999c + (f2 / this.f2001e);
    }
}
