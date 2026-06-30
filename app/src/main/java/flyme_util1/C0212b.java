package flyme_util1;

/* renamed from: h.b */
/* loaded from: classes.dex */
public class C0212b {

    /* renamed from: b */
    public float f1133b;

    /* renamed from: c */
    public float f1134c;

    /* renamed from: d */
    public float f1135d;

    /* renamed from: e */
    private final int f1136e;

    /* renamed from: a */
    protected float[] f1132a = new float[8];

    /* renamed from: f */
    private int[] f1137f = new int[8];

    public C0212b(int i2) {
        this.f1136e = i2;
    }

    /* renamed from: a */
    public float m898a(int i2) {
        float f2;
        float f3 = (i2 * 8.0f) / 360.0f;
        int round = Math.round(f3);
        if (round == 8) {
            return this.f1132a[0];
        }
        if (this.f1137f[round] < 3) {
            return 0.0f;
        }
        float f4 = this.f1132a[round];
        float f5 = f3 - round;
        if (f5 > 0.0f) {
            int i3 = round + 1;
            if (i3 == 8) {
                i3 = 0;
            }
            f2 = this.f1132a[i3];
            if (f2 == 0.0f) {
                return f4;
            }
        } else {
            f5 = -f5;
            int i4 = round - 1;
            if (i4 <= 0) {
                i4 = 7;
            }
            f2 = this.f1132a[i4];
            if (f2 == 0.0f) {
                return f4;
            }
        }
        return (f4 + (f2 * f5)) / (f5 + 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m899a(int i2, float f2) {
        float f3 = this.f1132a[i2];
        int i3 = this.f1137f[i2];
        this.f1132a[i2] = ((f3 * i3) + f2) / (i3 + 1);
        if (i3 < this.f1136e) {
            int[] iArr = this.f1137f;
            iArr[i2] = iArr[i2] + 1;
        }
        int i4 = 0;
        float f4 = 0.0f;
        float f5 = 99999.0f;
        float f6 = 0.0f;
        for (int i5 = 0; i5 < 8; i5++) {
            float f7 = this.f1132a[i5];
            if (f7 != 0.0f) {
                if (f7 >= f4) {
                    f4 = f7;
                }
                if (f7 <= f5) {
                    f5 = f7;
                }
                f6 += f7;
                i4++;
            }
        }
        if (i4 > 0) {
            this.f1134c = f5;
            this.f1133b = f4;
            this.f1135d = f6 / i4;
        }
    }
}
