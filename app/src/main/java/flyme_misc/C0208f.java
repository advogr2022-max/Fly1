package flyme_misc;

/* renamed from: g.f */
/* loaded from: classes.dex */
public class C0208f {

    /* renamed from: b */
    public float f1083b;

    /* renamed from: c */
    private int f1084c;

    /* renamed from: d */
    private float[] f1085d;

    /* renamed from: e */
    private long[] f1086e;

    /* renamed from: a */
    public int f1082a = 2000;

    /* renamed from: f */
    private int f1087f = 0;

    /* renamed from: g */
    private int f1088g = 0;

    /* renamed from: h */
    private float f1089h = 0.0f;

    /* renamed from: i */
    private int f1090i = 0;

    public C0208f(int i2) {
        m881a(i2);
    }

    /* renamed from: a */
    public float m879a(float f2, long j2) {
        this.f1085d[this.f1088g] = f2;
        this.f1086e[this.f1088g] = j2;
        this.f1089h += f2;
        this.f1090i++;
        long j3 = j2 - this.f1082a;
        while (this.f1086e[this.f1087f] < j3) {
            this.f1089h -= this.f1085d[this.f1087f];
            this.f1090i--;
            int i2 = this.f1087f + 1;
            this.f1087f = i2;
            if (i2 == this.f1084c) {
                this.f1087f = 0;
            }
        }
        int i3 = this.f1088g + 1;
        this.f1088g = i3;
        if (i3 == this.f1084c) {
            this.f1088g = 0;
        }
        if (this.f1088g == this.f1087f) {
            this.f1089h -= this.f1085d[this.f1087f];
            this.f1090i--;
            int i4 = this.f1087f + 1;
            this.f1087f = i4;
            if (i4 == this.f1084c) {
                this.f1087f = 0;
            }
        }
        this.f1083b = (this.f1089h + f2) / (this.f1090i + 1);
        return this.f1083b;
    }

    /* renamed from: a */
    public void m880a() {
        this.f1087f = 0;
        this.f1088g = 0;
        this.f1089h = 0.0f;
        this.f1090i = 0;
    }

    /* renamed from: a */
    public void m881a(int i2) {
        this.f1082a = i2;
        this.f1084c = i2 / 10;
        if (this.f1084c < 100) {
            this.f1084c = 100;
        }
        this.f1085d = new float[this.f1084c];
        this.f1086e = new long[this.f1084c];
        m880a();
    }
}
