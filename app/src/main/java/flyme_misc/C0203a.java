package flyme_misc;

/* renamed from: g.a */
/* loaded from: classes.dex */
public class C0203a implements InterfaceC0204b {

    /* renamed from: b */
    public float f1045b;

    /* renamed from: c */
    public float f1046c;

    /* renamed from: e */
    private int f1048e;

    /* renamed from: g */
    private float[] f1050g;

    /* renamed from: h */
    private long[] f1051h;

    /* renamed from: i */
    private float[] f1052i;

    /* renamed from: n */
    private long f1057n;

    /* renamed from: o */
    private float f1058o;

    /* renamed from: a */
    public int f1044a = 2000;

    /* renamed from: f */
    private float f1049f = 0.7f;

    /* renamed from: j */
    private int f1053j = 0;

    /* renamed from: k */
    private int f1054k = 0;

    /* renamed from: l */
    private float f1055l = 0.0f;

    /* renamed from: m */
    private int f1056m = 0;

    /* renamed from: d */
    public boolean f1047d = false;

    public C0203a(int i2, float f2) {
        m868a(i2, f2);
    }

    @Override // flyme_misc.InterfaceC0204b
    /* renamed from: a */
    public float mo866a(float f2, long j2) {
        long j3;
        float f3;
        float f4;
        if (Math.abs(f2 - this.f1045b) < this.f1049f) {
            f2 = this.f1045b;
        }
        this.f1050g[this.f1054k] = f2;
        this.f1051h[this.f1054k] = j2;
        this.f1055l += f2;
        this.f1056m++;
        long j4 = j2 - this.f1044a;
        while (this.f1051h[this.f1053j] < j4) {
            this.f1055l -= this.f1050g[this.f1053j];
            this.f1056m--;
            int i2 = this.f1053j + 1;
            this.f1053j = i2;
            if (i2 == this.f1048e) {
                this.f1053j = 0;
            }
        }
        if (this.f1056m > 0) {
            f2 = this.f1055l / this.f1056m;
        }
        this.f1045b = f2;
        this.f1052i[this.f1054k] = this.f1045b;
        if (this.f1056m > 1) {
            j3 = j2 - this.f1051h[this.f1053j];
            if (j3 > 0) {
                f3 = this.f1045b;
                f4 = this.f1052i[this.f1053j];
                this.f1046c = ((f3 - f4) * 1000.0f) / ((float) j3);
            }
            this.f1046c = 0.0f;
        } else {
            j3 = j2 - this.f1057n;
            if (j3 > 100) {
                f3 = this.f1045b;
                f4 = this.f1058o;
                this.f1046c = ((f3 - f4) * 1000.0f) / ((float) j3);
            }
            this.f1046c = 0.0f;
        }
        int i3 = this.f1054k + 1;
        this.f1054k = i3;
        if (i3 == this.f1048e) {
            this.f1054k = 0;
        }
        if (this.f1054k == this.f1053j) {
            this.f1055l -= this.f1050g[this.f1053j];
            this.f1056m--;
            int i4 = this.f1053j + 1;
            this.f1053j = i4;
            if (i4 == this.f1048e) {
                this.f1053j = 0;
            }
        }
        this.f1057n = j2;
        this.f1058o = this.f1045b;
        return this.f1045b;
    }

    /* renamed from: a */
    public void m867a() {
        this.f1053j = 0;
        this.f1054k = 0;
        this.f1055l = 0.0f;
        this.f1056m = 0;
        this.f1045b = 0.0f;
        this.f1046c = 0.0f;
        this.f1057n = 0L;
        this.f1058o = 0.0f;
    }

    /* renamed from: a */
    public void m868a(int i2, float f2) {
        this.f1044a = i2;
        this.f1048e = i2 / 10;
        if (this.f1048e < 100) {
            this.f1048e = 100;
        }
        this.f1049f = f2;
        this.f1050g = new float[this.f1048e];
        this.f1051h = new long[this.f1048e];
        this.f1052i = new float[this.f1048e];
        m867a();
    }

    /* renamed from: b */
    public int m869b() {
        return this.f1056m;
    }
}
