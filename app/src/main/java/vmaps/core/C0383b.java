package vmaps.core;

/* renamed from: vmaps.core.b */
/* loaded from: classes.dex */
public class C0383b {

    /* renamed from: a */
    private short[] f2161a;

    /* renamed from: b */
    private C0384c f2162b;

    /* renamed from: c */
    private C0384c f2163c;

    public C0383b(int i2, int i3, short[] sArr) {
        this.f2161a = sArr;
        this.f2162b = new C0384c(i2);
        this.f2163c = new C0384c(i3);
    }

    /* renamed from: a */
    public double m1362a(double d2, double d3) {
        int m1365a = this.f2162b.m1365a(d2);
        int m1365a2 = this.f2163c.m1365a(d3);
        double d4 = m1365a;
        Double.isNaN(d4);
        double d5 = d2 - d4;
        double d6 = (m1365a + 1) - m1365a;
        Double.isNaN(d6);
        double d7 = d5 / d6;
        double d8 = m1365a2;
        Double.isNaN(d8);
        double d9 = d3 - d8;
        double d10 = (m1365a2 + 1) - m1365a2;
        Double.isNaN(d10);
        double d11 = d9 / d10;
        int i2 = (m1365a2 * this.f2162b.f2164a) + m1365a;
        double d12 = 1.0d - d7;
        double d13 = 1.0d - d11;
        double d14 = this.f2161a[i2];
        Double.isNaN(d14);
        double d15 = d12 * d13 * d14;
        double d16 = this.f2161a[i2 + 1];
        Double.isNaN(d16);
        double d17 = d15 + (d13 * d7 * d16);
        double d18 = this.f2161a[this.f2162b.f2164a + i2];
        Double.isNaN(d18);
        double d19 = d17 + (d12 * d11 * d18);
        double d20 = d7 * d11;
        double d21 = this.f2161a[i2 + this.f2162b.f2164a + 1];
        Double.isNaN(d21);
        return d19 + (d20 * d21);
    }
}
