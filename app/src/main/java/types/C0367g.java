package types;

/* renamed from: types.g */
/* loaded from: classes.dex */
public class C0367g {

    /* renamed from: a */
    public float f2012a;

    /* renamed from: b */
    public float f2013b;

    /* renamed from: c */
    public float f2014c;

    /* renamed from: d */
    public float f2015d;

    /* renamed from: e */
    private final float f2016e = 9999.0f;

    public C0367g() {
        m1223a();
    }

    public C0367g(float f2, float f3, float f4, float f5) {
        this.f2012a = Math.min(f2, f4);
        this.f2014c = Math.min(f3, f5);
        this.f2013b = Math.max(f2, f4);
        this.f2015d = Math.max(f3, f5);
    }

    /* renamed from: a */
    public void m1223a() {
        this.f2013b = -19998.0f;
        this.f2015d = -19998.0f;
        this.f2012a = 19998.0f;
        this.f2014c = 19998.0f;
    }

    /* renamed from: a */
    public void m1224a(float f2, float f3) {
        if (f2 > this.f2013b) {
            this.f2013b = f2;
        }
        if (f2 < this.f2012a) {
            this.f2012a = f2;
        }
        if (f3 > this.f2015d) {
            this.f2015d = f3;
        }
        if (f3 < this.f2014c) {
            this.f2014c = f3;
        }
    }

    /* renamed from: a */
    public void m1225a(GpsVal gpsVal) {
        if (gpsVal.f1972a > this.f2013b) {
            this.f2013b = gpsVal.f1972a;
        }
        if (gpsVal.f1972a < this.f2012a) {
            this.f2012a = gpsVal.f1972a;
        }
        if (gpsVal.f1973b > this.f2015d) {
            this.f2015d = gpsVal.f1973b;
        }
        if (gpsVal.f1973b < this.f2014c) {
            this.f2014c = gpsVal.f1973b;
        }
    }

    /* renamed from: a */
    public void m1226a(C0367g c0367g, float f2, float f3) {
        this.f2012a = c0367g.f2012a - f2;
        this.f2013b = c0367g.f2013b + f2;
        this.f2014c = c0367g.f2014c - f3;
        this.f2015d = c0367g.f2015d + f3;
    }

    /* renamed from: a */
    public boolean m1227a(PoiPoint poiPoint) {
        return poiPoint.f1976i > this.f2012a && poiPoint.f1976i < this.f2013b && poiPoint.f1977j > this.f2014c && poiPoint.f1977j < this.f2015d;
    }

    /* renamed from: a */
    public boolean m1228a(C0367g c0367g) {
        return this.f2012a == c0367g.f2012a && this.f2014c == c0367g.f2014c && this.f2013b == c0367g.f2013b && this.f2015d == c0367g.f2015d;
    }

    /* renamed from: b */
    public void m1229b(C0367g c0367g) {
        this.f2012a = c0367g.f2012a;
        this.f2013b = c0367g.f2013b;
        this.f2014c = c0367g.f2014c;
        this.f2015d = c0367g.f2015d;
    }

    /* renamed from: b */
    public boolean m1230b() {
        return this.f2012a > 9999.0f;
    }

    /* renamed from: b */
    public boolean m1231b(float f2, float f3) {
        return f2 > this.f2012a && f2 < this.f2013b && f3 > this.f2014c && f3 < this.f2015d;
    }

    /* renamed from: b */
    public boolean m1232b(GpsVal gpsVal) {
        return gpsVal.f1972a > this.f2012a && gpsVal.f1972a < this.f2013b && gpsVal.f1973b > this.f2014c && gpsVal.f1973b < this.f2015d;
    }

    /* renamed from: c */
    public GpsVal m1233c() {
        GpsVal gpsVal = new GpsVal();
        gpsVal.f1972a = (this.f2013b + this.f2012a) / 2.0f;
        gpsVal.f1973b = (this.f2015d + this.f2014c) / 2.0f;
        return gpsVal;
    }

    /* renamed from: c */
    public boolean m1234c(C0367g c0367g) {
        if (c0367g.f2012a < this.f2012a) {
            if (c0367g.f2013b < this.f2012a) {
                return false;
            }
        } else if (c0367g.f2012a > this.f2013b) {
            return false;
        }
        return c0367g.f2014c < this.f2014c ? c0367g.f2015d >= this.f2014c : c0367g.f2014c <= this.f2015d;
    }

    /* renamed from: d */
    public float m1235d() {
        return (this.f2013b + this.f2012a) / 2.0f;
    }

    /* renamed from: e */
    public float m1236e() {
        return (this.f2015d + this.f2014c) / 2.0f;
    }

    /* renamed from: f */
    public float m1237f() {
        return this.f2013b - this.f2012a;
    }

    /* renamed from: g */
    public float m1238g() {
        return this.f2015d - this.f2014c;
    }
}
