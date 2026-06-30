package flyme_util1;

import flyme_misc.C0208f;
import types.C0364d;
import types.C0365e;

/* renamed from: h.a */
/* loaded from: classes.dex */
public class C0211a {

    /* renamed from: m */
    private static final float[] f1106m = new float[8];

    /* renamed from: n */
    private static final float[] f1107n = new float[8];

    /* renamed from: a */
    public C0212b f1108a;

    /* renamed from: b */
    public C0212b f1109b;

    /* renamed from: c */
    public int f1110c;

    /* renamed from: d */
    public float f1111d;

    /* renamed from: e */
    public float f1112e;

    /* renamed from: f */
    public float f1113f;

    /* renamed from: g */
    public float f1114g;

    /* renamed from: h */
    public float f1115h;

    /* renamed from: i */
    public int f1116i;

    /* renamed from: k */
    public int f1118k;

    /* renamed from: l */
    public int f1119l;

    /* renamed from: o */
    private C0364d f1120o;

    /* renamed from: p */
    private float f1121p;

    /* renamed from: q */
    private float f1122q;

    /* renamed from: s */
    private long f1124s;

    /* renamed from: t */
    private float f1125t;

    /* renamed from: u */
    private float f1126u;

    /* renamed from: v */
    private float f1127v;

    /* renamed from: r */
    private long f1123r = 0;

    /* renamed from: w */
    private boolean f1128w = false;

    /* renamed from: x */
    private C0208f[] f1129x = new C0208f[8];

    /* renamed from: y */
    private C0208f f1130y = new C0208f(20000);

    /* renamed from: z */
    private long f1131z = 0;

    /* renamed from: j */
    public int f1117j = 0;

    public C0211a() {
        for (int i2 = 0; i2 < 8; i2++) {
            double radians = (float) Math.toRadians(i2 * 45.0f);
            f1106m[i2] = (float) Math.sin(radians);
            f1107n[i2] = (float) Math.cos(radians);
            this.f1129x[i2] = new C0208f(10000);
        }
        m890b(0.0f, 0.0f, 0.0f, 0L);
    }

    /* renamed from: a */
    private int m886a(float f2, float f3) {
        int degrees = (int) Math.toDegrees(Math.atan2(f2, f3));
        return degrees < 0 ? degrees + 360 : degrees;
    }

    /* renamed from: a */
    private void m887a(int i2, long j2) {
        if (this.f1114g >= 0.0f) {
            return;
        }
        this.f1129x[i2].m879a((-(this.f1113f * 0.27778f)) / this.f1114g, j2);
    }

    /* renamed from: a */
    private void m888a(C0212b c0212b) {
        int i2 = 0;
        float f2 = 0.0f;
        float f3 = 0.0f;
        for (int i3 = 0; i3 < 4; i3++) {
            float f4 = c0212b.f1132a[i3];
            float f5 = c0212b.f1132a[i3 + 4];
            if (f4 != 0.0f && f5 != 0.0f) {
                float f6 = f4 - f5;
                double d2 = i3 * 0.7853982f;
                f2 += ((float) Math.sin(d2)) * f6;
                f3 += f6 * ((float) Math.cos(d2));
                i2++;
            }
        }
        if (i2 != 0) {
            float f7 = i2;
            this.f1125t = f2 / f7;
            this.f1126u = f3 / f7;
            int degrees = (int) Math.toDegrees(Math.atan2(this.f1125t, this.f1126u));
            if (degrees < 0) {
                degrees += 360;
            }
            this.f1116i = degrees;
            this.f1115h = (float) Math.sqrt((this.f1125t * this.f1125t) + (this.f1126u * this.f1126u));
            if (this.f1128w) {
                return;
            }
            this.f1128w = true;
        }
    }

    /* renamed from: b */
    private int m889b(int i2) {
        int round = Math.round((i2 * 8) / 360.0f);
        if (round == 8) {
            return 0;
        }
        return round;
    }

    /* renamed from: b */
    private void m890b(float f2, float f3, float f4, long j2) {
        this.f1108a = new C0212b(10);
        this.f1109b = new C0212b(10);
        this.f1120o = new C0364d(f2, f3);
        this.f1112e = f4;
        this.f1123r = j2;
        this.f1121p = 0.0f;
        this.f1122q = 0.0f;
        this.f1117j = 0;
        this.f1131z = 0L;
        this.f1118k = 0;
        this.f1119l = 0;
        this.f1127v = 0.0f;
        this.f1124s = 0L;
        this.f1128w = false;
    }

    /* renamed from: b */
    private void m891b(int i2, long j2) {
        if (this.f1117j != i2) {
            this.f1131z = j2;
            this.f1117j = i2;
            this.f1119l = 0;
            this.f1118k = 0;
        }
    }

    /* renamed from: a */
    public float m892a() {
        if (this.f1117j == 0) {
            float f2 = this.f1129x[m889b(this.f1110c)].f1083b;
            if (f2 != 0.0f) {
                this.f1127v = f2;
            }
        }
        return this.f1127v;
    }

    /* renamed from: a */
    public float m893a(int i2) {
        return this.f1108a.m898a(i2);
    }

    /* renamed from: a */
    public float m894a(int i2, float f2) {
        int m889b = m889b(i2);
        float f3 = f1107n[m889b] * f2;
        float f4 = f2 * f1106m[m889b];
        float f5 = f3 + this.f1125t;
        float f6 = f4 + this.f1126u;
        return (float) Math.sqrt((f5 * f5) + (f6 * f6));
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0106  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m895a(float f2, float f3, float f4, long j2) {
        int i2;
        long j3 = j2 - this.f1123r;
        if (j3 < 1000) {
            return;
        }
        if (j3 > 1000000) {
            m890b(f2, f3, f4, j2 - 1000);
            j3 = j2 - this.f1123r;
        }
        int i3 = (int) j3;
        float m1192a = this.f1120o.m1192a(f3);
        float m1198b = this.f1120o.m1198b(f2);
        float f5 = m1192a - this.f1121p;
        float f6 = m1198b - this.f1122q;
        float m1203a = C0365e.m1203a(m1192a, m1198b, this.f1121p, this.f1122q);
        int m886a = m886a(f5, f6);
        this.f1121p = m1192a;
        this.f1122q = m1198b;
        if (Math.abs(m1192a) > 10.0f || Math.abs(m1198b) > 10.0f) {
            this.f1120o = new C0364d(f2, f3);
        }
        float f7 = i3;
        this.f1113f = (m1203a * 3600000.0f) / f7;
        this.f1114g = ((f4 - this.f1112e) * 1000.0f) / f7;
        int i4 = m886a - this.f1110c;
        if (i4 > 180) {
            i4 = 360 - i4;
        } else if (i4 < -180) {
            i4 += 360;
        }
        int i5 = (i4 * 1000) / i3;
        this.f1111d = Math.abs(i5);
        float m879a = this.f1130y.m879a(i5 < -10 ? -1.0f : i5 > 10 ? 1.0f : 0.0f, j2);
        if (this.f1117j == 0) {
            if (m879a >= -0.3f) {
                if (m879a > 0.3f) {
                    i2 = 1;
                }
                this.f1112e = f4;
                this.f1110c = m886a;
                this.f1123r = j2;
                int m889b = m889b(m886a);
                if (this.f1117j != 0) {
                    this.f1119l = (int) ((j2 - this.f1131z) / 1000);
                    if (this.f1119l > 5) {
                        this.f1108a.m899a(m889b, this.f1113f);
                        m887a(m889b, j2);
                        return;
                    }
                    return;
                }
                this.f1118k = (int) ((j2 - this.f1131z) / 1000);
                this.f1109b.m899a(m889b, this.f1113f);
                if (j2 - this.f1124s > 10000) {
                    m888a(this.f1109b);
                    this.f1124s = j2;
                    return;
                }
                return;
            }
            i2 = -1;
            m891b(i2, j2);
            this.f1112e = f4;
            this.f1110c = m886a;
            this.f1123r = j2;
            int m889b2 = m889b(m886a);
            if (this.f1117j != 0) {
            }
        } else {
            if (Math.abs(m879a) < 0.05d) {
                i2 = 0;
            } else {
                if (this.f1117j * i5 < 0) {
                    i2 = -this.f1117j;
                }
                this.f1112e = f4;
                this.f1110c = m886a;
                this.f1123r = j2;
                int m889b22 = m889b(m886a);
                if (this.f1117j != 0) {
                }
            }
            m891b(i2, j2);
            this.f1112e = f4;
            this.f1110c = m886a;
            this.f1123r = j2;
            int m889b222 = m889b(m886a);
            if (this.f1117j != 0) {
            }
        }
    }

    /* renamed from: b */
    public boolean m896b() {
        return this.f1117j != 0;
    }

    /* renamed from: c */
    public boolean m897c() {
        return this.f1128w;
    }
}
