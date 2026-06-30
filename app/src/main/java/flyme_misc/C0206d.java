package flyme_misc;

/* renamed from: g.d */
/* loaded from: classes.dex */
public class C0206d implements InterfaceC0204b {

    /* renamed from: a */
    public float f1065a;

    /* renamed from: b */
    private float f1066b;

    /* renamed from: c */
    private float f1067c;

    /* renamed from: d */
    private float f1068d;

    /* renamed from: e */
    private float f1069e;

    /* renamed from: f */
    private float f1070f;

    /* renamed from: g */
    private float f1071g;

    /* renamed from: h */
    private long f1072h;

    public C0206d() {
        this.f1072h = 0L;
        this.f1065a = 1.0f;
        m874a(1.0f);
        m873a();
    }

    public C0206d(float f2, float f3) {
        this.f1072h = 0L;
        this.f1065a = 1.0f;
        m874a(f2);
        m873a();
        this.f1065a = f3;
    }

    @Override // flyme_misc.InterfaceC0204b
    /* renamed from: a */
    public float mo866a(float f2, long j2) {
        m876a(f2, this.f1065a, this.f1072h == 0 ? 1.0f : ((float) (j2 - this.f1072h)) / 1000.0f);
        this.f1072h = j2;
        return this.f1066b;
    }

    /* renamed from: a */
    public void m873a() {
        m875a(0.0f, 0.0f);
    }

    /* renamed from: a */
    public void m874a(float f2) {
        this.f1071g = f2;
    }

    /* renamed from: a */
    public void m875a(float f2, float f3) {
        this.f1066b = f2;
        this.f1067c = f3;
        this.f1068d = 1.0E10f;
        this.f1069e = 0.0f;
        this.f1070f = this.f1071g;
        this.f1072h = 0L;
    }

    /* renamed from: a */
    public void m876a(float f2, float f3, float f4) {
        this.f1066b += this.f1067c * f4;
        double d2 = this.f1068d;
        double d3 = f4;
        Double.isNaN(d3);
        double d4 = this.f1069e;
        Double.isNaN(d4);
        double d5 = d3 * 2.0d * d4;
        double d6 = f4 * f4 * this.f1070f;
        Double.isNaN(d6);
        double d7 = d5 + d6;
        double d8 = this.f1071g * f4 * f4 * f4 * f4;
        Double.isNaN(d8);
        Double.isNaN(d2);
        this.f1068d = (float) (d2 + d7 + (d8 / 4.0d));
        double d9 = this.f1069e;
        double d10 = this.f1070f * f4;
        double d11 = this.f1071g * f4 * f4 * f4;
        Double.isNaN(d11);
        Double.isNaN(d10);
        Double.isNaN(d9);
        this.f1069e = (float) (d9 + d10 + (d11 / 2.0d));
        this.f1070f += this.f1071g * f4 * f4;
        float f5 = f2 - this.f1066b;
        float f6 = 1.0f / (this.f1068d + f3);
        float f7 = this.f1068d * f6;
        float f8 = this.f1069e * f6;
        this.f1066b += f7 * f5;
        this.f1067c += f5 * f8;
        this.f1070f -= this.f1069e * f8;
        this.f1069e -= this.f1069e * f7;
        this.f1068d -= this.f1068d * f7;
    }
}
