package flyme_misc;

/* renamed from: g.g */
/* loaded from: classes.dex */
public class C0209g implements InterfaceC0204b {

    /* renamed from: b */
    public float f1092b;

    /* renamed from: c */
    private int f1093c;

    /* renamed from: d */
    private float[] f1094d;

    /* renamed from: e */
    private long[] f1095e;

    /* renamed from: f */
    private float[] f1096f;

    /* renamed from: k */
    private float f1101k;

    /* renamed from: a */
    public int f1091a = 1000;

    /* renamed from: g */
    private int f1097g = 0;

    /* renamed from: h */
    private int f1098h = 0;

    /* renamed from: i */
    private float f1099i = 0.0f;

    /* renamed from: j */
    private int f1100j = 0;

    public C0209g(int i2) {
        m883a(i2);
    }

    @Override // flyme_misc.InterfaceC0204b
    /* renamed from: a */
    public float mo866a(float f2, long j2) {
        this.f1100j++;
        this.f1092b = (this.f1099i + f2) / this.f1100j;
        long j3 = this.f1091a;
        float f3 = this.f1092b - this.f1101k;
        if ((f2 < this.f1092b && f3 > 0.0f) || (f2 > this.f1092b && f3 < 0.0f)) {
            this.f1092b = this.f1101k;
            j3 /= 2;
        }
        long j4 = j2 - j3;
        this.f1094d[this.f1098h] = f2;
        this.f1095e[this.f1098h] = j2;
        while (this.f1095e[this.f1097g] < j4) {
            this.f1099i -= this.f1094d[this.f1097g];
            this.f1100j--;
            int i2 = this.f1097g + 1;
            this.f1097g = i2;
            if (i2 == this.f1093c) {
                this.f1097g = 0;
            }
        }
        this.f1099i += f2;
        this.f1096f[this.f1098h] = this.f1092b;
        int i3 = this.f1098h + 1;
        this.f1098h = i3;
        if (i3 == this.f1093c) {
            this.f1098h = 0;
        }
        if (this.f1098h == this.f1097g) {
            this.f1099i -= this.f1094d[this.f1097g];
            this.f1100j--;
            int i4 = this.f1097g + 1;
            this.f1097g = i4;
            if (i4 == this.f1093c) {
                this.f1097g = 0;
            }
        }
        this.f1101k = this.f1092b;
        return this.f1092b;
    }

    /* renamed from: a */
    public void m882a() {
        this.f1097g = 0;
        this.f1098h = 0;
        this.f1099i = 0.0f;
        this.f1100j = 0;
        this.f1092b = 0.0f;
        this.f1101k = 0.0f;
    }

    /* renamed from: a */
    public void m883a(int i2) {
        this.f1091a = i2;
        this.f1093c = i2 / 10;
        if (this.f1093c < 100) {
            this.f1093c = 100;
        }
        this.f1094d = new float[this.f1093c];
        this.f1095e = new long[this.f1093c];
        this.f1096f = new float[this.f1093c];
        m882a();
    }
}
