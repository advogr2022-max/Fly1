package types;

/* renamed from: types.p */
/* loaded from: classes.dex */
public class C0376p {

    /* renamed from: a */
    public float f2070a;

    /* renamed from: b */
    public float f2071b;

    /* renamed from: c */
    public float f2072c;

    /* renamed from: d */
    public float f2073d;

    /* renamed from: e */
    public float f2074e;

    /* renamed from: f */
    public int f2075f;

    /* renamed from: g */
    public float f2076g;

    /* renamed from: h */
    public float f2077h;

    /* renamed from: i */
    public float f2078i;

    /* renamed from: j */
    public float f2079j;

    /* renamed from: l */
    private float f2081l = 1.0f;

    /* renamed from: k */
    public float f2080k = 50000.0f;

    /* renamed from: a */
    private void m1275a() {
        float f2 = this.f2071b / 2.0f;
        this.f2075f = (int) f2;
        this.f2076g = f2 * this.f2074e;
    }

    /* renamed from: a */
    public void m1276a(float f2, float f3, int i2, int i3) {
        int i4 = (int) (i3 / C0369i.f2020a);
        float f4 = i2;
        this.f2071b = f4;
        this.f2070a = i4;
        this.f2081l = f4 / (f2 / C0369i.m1248b(f3, 0.0f, f3, 1.0f));
        this.f2072c = f2;
        this.f2073d = this.f2071b / this.f2072c;
        this.f2074e = 1.0f / this.f2073d;
        this.f2077h = this.f2081l;
        this.f2078i = this.f2081l * C0369i.f2020a;
        this.f2079j = (this.f2077h + this.f2078i) / 2.0f;
        m1275a();
    }

    /* renamed from: a */
    public void m1277a(float f2, float f3, C0367g c0367g) {
        float m1248b = (this.f2072c / C0369i.m1248b(f2, 0.0f, f2, 1.0f)) / 2.0f;
        float f4 = m1248b / C0369i.f2020a;
        c0367g.f2012a = f2 - f4;
        c0367g.f2014c = f3 - m1248b;
        c0367g.f2013b = f2 + f4;
        c0367g.f2015d = f3 + m1248b;
        c0367g.f2013b = c0367g.f2012a + (this.f2070a / this.f2078i);
        c0367g.f2015d = c0367g.f2014c + (this.f2071b / this.f2077h);
    }
}
