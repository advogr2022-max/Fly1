package flyme_misc;

/* renamed from: g.c */
/* loaded from: classes.dex */
public class C0205c {

    /* renamed from: b */
    private float f1060b;

    /* renamed from: c */
    private long f1061c;

    /* renamed from: d */
    private float f1062d;

    /* renamed from: e */
    private float f1063e;

    /* renamed from: a */
    private final float f1059a = 1.0f;

    /* renamed from: f */
    private float f1064f = -1.0f;

    public C0205c(float f2) {
        this.f1060b = f2;
    }

    /* renamed from: a */
    public float m870a() {
        return this.f1062d;
    }

    /* renamed from: a */
    public void m871a(float f2, float f3, float f4, long j2) {
        if (f4 < 1.0f) {
            f4 = 1.0f;
        }
        if (this.f1064f < 0.0f) {
            this.f1061c = j2;
            this.f1062d = f2;
            this.f1063e = f3;
            this.f1064f = f4 * f4;
            return;
        }
        long j3 = j2 - this.f1061c;
        if (j3 > 0) {
            this.f1064f += ((((float) j3) * this.f1060b) * this.f1060b) / 1000.0f;
            this.f1061c = j2;
        }
        float f5 = this.f1064f / (this.f1064f + (f4 * f4));
        this.f1062d += (f2 - this.f1062d) * f5;
        this.f1063e += (f3 - this.f1063e) * f5;
        this.f1064f = (1.0f - f5) * this.f1064f;
    }

    /* renamed from: b */
    public float m872b() {
        return this.f1063e;
    }
}
