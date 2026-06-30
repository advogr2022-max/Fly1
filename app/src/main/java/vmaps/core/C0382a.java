package vmaps.core;

/* renamed from: vmaps.core.a */
/* loaded from: classes.dex */
public class C0382a {

    /* renamed from: f */
    C0385d f2148f;

    /* renamed from: i */
    private int f2151i;

    /* renamed from: j */
    private final int f2152j;

    /* renamed from: k */
    private final int f2153k;

    /* renamed from: l */
    private final short[] f2154l;

    /* renamed from: n */
    private double f2156n;

    /* renamed from: o */
    private double f2157o;

    /* renamed from: p */
    private double f2158p;

    /* renamed from: q */
    private double[] f2159q;

    /* renamed from: a */
    public double f2143a = 315.0d;

    /* renamed from: b */
    public double f2144b = 65.0d;

    /* renamed from: c */
    public int f2145c = 2;

    /* renamed from: d */
    public int f2146d = 270 / this.f2145c;

    /* renamed from: m */
    private double f2155m = 240.0d;

    /* renamed from: e */
    public float f2147e = 2.0f;

    /* renamed from: r */
    private boolean f2160r = false;

    /* renamed from: g */
    public int f2149g = 4;

    /* renamed from: h */
    public int f2150h = 0;

    public C0382a(C0385d c0385d) {
        this.f2151i = 0;
        this.f2152j = c0385d.f2170c;
        this.f2153k = c0385d.f2171d;
        this.f2154l = c0385d.f2169b;
        this.f2148f = c0385d;
        this.f2151i = 1000;
    }

    /* renamed from: b */
    private void m1357b() {
        this.f2156n = ((90.0d - this.f2144b) * 3.141592653589793d) / 180.0d;
        this.f2157o = Math.sin(this.f2156n);
        this.f2158p = Math.cos(this.f2156n);
        this.f2159q = new double[this.f2145c];
        for (int i2 = 0; i2 < this.f2145c; i2++) {
            double d2 = this.f2143a;
            double d3 = this.f2146d * i2;
            Double.isNaN(d3);
            double d4 = (360.0d - ((d2 + d3) % 360.0d)) + 90.0d;
            if (d4 >= 360.0d) {
                d4 -= 360.0d;
            }
            this.f2159q[i2] = (d4 * 3.141592653589793d) / 180.0d;
        }
        this.f2160r = Math.abs(this.f2144b - 90.0d) < 1.0d;
    }

    /* renamed from: a */
    public int m1358a(int i2) {
        double cos;
        int i3;
        int i4 = (i2 - this.f2152j) - 1;
        short s = this.f2154l[i4];
        int i5 = i4 + 1;
        short s2 = this.f2154l[i5];
        int i6 = i5 + 1;
        short s3 = this.f2154l[i6];
        int i7 = i6 + (this.f2152j - 2);
        short s4 = this.f2154l[i7];
        int i8 = i7 + 1;
        if (this.f2154l[i8] < this.f2151i) {
            return 0;
        }
        int i9 = i8 + 1;
        short s5 = this.f2154l[i9];
        int i10 = i9 + (this.f2152j - 2);
        short s6 = this.f2154l[i10];
        int i11 = i10 + 1;
        short s7 = this.f2154l[i11];
        short s8 = this.f2154l[i11 + 1];
        double d2 = (((s5 * 2) + s3) + s8) - (((s4 * 2) + s) + s6);
        double d3 = this.f2155m;
        Double.isNaN(d2);
        double d4 = d2 / d3;
        double d5 = ((s6 + (s7 * 2)) + s8) - ((s + (s2 * 2)) + s3);
        double d6 = this.f2155m;
        Double.isNaN(d5);
        double d7 = d5 / d6;
        double d8 = this.f2147e;
        double sqrt = Math.sqrt((d4 * d4) + (d7 * d7));
        Double.isNaN(d8);
        double atan = Math.atan(d8 * sqrt);
        double d9 = 6.283185307179586d;
        double d10 = 0.0d;
        if (d4 != 0.0d) {
            double atan2 = Math.atan2(d7, -d4);
            d9 = atan2 < 0.0d ? 6.283185307179586d + atan2 : atan2;
        } else if (d7 <= 0.0d) {
            d9 = d7 < 0.0d ? 4.71238898038469d : 0.0d;
        }
        if (this.f2160r) {
            cos = this.f2158p * Math.cos(atan);
        } else {
            if (this.f2145c > 1) {
                for (int i12 = 0; i12 < this.f2145c; i12++) {
                    d10 += ((this.f2158p * Math.cos(atan)) + (this.f2157o * Math.sin(atan) * Math.cos(this.f2159q[i12] - d9))) * 255.0d;
                }
                double d11 = this.f2145c;
                Double.isNaN(d11);
                i3 = (int) (d10 / d11);
                return 255 - i3;
            }
            cos = (this.f2158p * Math.cos(atan)) + (this.f2157o * Math.sin(atan) * Math.cos(this.f2159q[0] - d9));
        }
        i3 = (int) (cos * 255.0d);
        return 255 - i3;
    }

    /* renamed from: a */
    public C0382a m1359a(double d2, double d3, int i2) {
        this.f2143a = d2;
        this.f2144b = d3;
        this.f2145c = i2;
        this.f2146d = 270 / this.f2145c;
        return this;
    }

    /* renamed from: a */
    public C0382a m1360a(float f2, int i2) {
        this.f2147e = f2;
        this.f2155m = i2 * 8;
        return this;
    }

    /* renamed from: a */
    public int[] m1361a() {
        int i2;
        m1357b();
        int i3 = this.f2152j * this.f2153k;
        int[] iArr = new int[i3];
        int i4 = this.f2152j + 1;
        int i5 = (i3 - this.f2152j) - 1;
        int i6 = this.f2150h;
        int i7 = this.f2149g;
        C0387f c0387f = this.f2148f.f2181n;
        for (int i8 = 0; i8 < i3; i8++) {
            short s = this.f2154l[i8];
            int m1395a = c0387f.m1395a(s - 1000);
            if (s >= this.f2151i && i8 > i4 && i8 < i5) {
                int m1358a = m1358a(i8);
                int i9 = ((m1395a >> 16) & 255) + i6;
                int i10 = ((m1395a >> 8) & 255) + i6;
                int i11 = (m1395a & 255) + i6;
                if (m1358a > 0) {
                    float f2 = (m1358a / 255.0f) * (((i9 + i10) + i11) / i7);
                    i9 = (int) (i9 - f2);
                    if (i9 < 0) {
                        i9 = 0;
                    }
                    i10 = (int) (i10 - f2);
                    if (i10 < 0) {
                        i10 = 0;
                    }
                    i2 = (int) (i11 - f2);
                    if (i2 < 0) {
                        i2 = 0;
                    }
                } else {
                    i2 = i11;
                }
                if (i9 > 255) {
                    i9 = 255;
                }
                if (i10 > 255) {
                    i10 = 255;
                }
                if (i2 > 255) {
                    i2 = 255;
                }
                m1395a = (-16777216) | ((i9 & 255) << 16) | ((i10 & 255) << 8) | (i2 & 255);
            }
            iArr[i8] = m1395a;
        }
        return iArr;
    }
}
