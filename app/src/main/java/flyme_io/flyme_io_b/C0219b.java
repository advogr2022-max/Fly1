package flyme_io.flyme_io_b;

import java.util.ArrayList;

/* renamed from: i.b.b */
/* loaded from: classes.dex */
public class C0219b {

    /* renamed from: a */
    public ArrayList<Integer> f1210a = new ArrayList<>();

    /* renamed from: a */
    static double m942a(double d2) {
        return d2 * d2;
    }

    /* renamed from: a */
    public void m943a(float[] fArr, float[] fArr2, int i2, double d2) {
        int i3;
        int[] iArr;
        int[] iArr2;
        double d3;
        int i4;
        C0219b c0219b = this;
        c0219b.f1210a.clear();
        if (i2 < 3) {
            return;
        }
        int[] iArr3 = new int[i2];
        int[] iArr4 = new int[i2];
        double m942a = m942a(0.008993205922597803d * d2);
        iArr3[0] = 0;
        int i5 = 1;
        int i6 = i2 - 1;
        iArr4[0] = i6;
        int i7 = 1;
        while (i7 > 0) {
            int i8 = i7 - 1;
            int i9 = iArr3[i8];
            int i10 = iArr4[i8];
            int i11 = i7 - 1;
            if (i10 - i9 > i5) {
                double d4 = fArr2[i10] - fArr2[i9];
                Double.isNaN(d4);
                double d5 = d4 * 1.0E-6d;
                if (Math.abs(d5) > 180.0d) {
                    d5 = 360.0d - Math.abs(d5);
                }
                i3 = i6;
                iArr = iArr3;
                double d6 = fArr[i10] - fArr[i9];
                Double.isNaN(d6);
                double d7 = d6 * 1.0E-6d;
                double d8 = fArr[i10] + fArr[i9];
                Double.isNaN(d8);
                double cos = d5 * Math.cos(d8 * 8.726646259971647E-9d);
                double m942a2 = m942a(cos) + m942a(d7);
                int i12 = i9 + 1;
                double d9 = -1.0d;
                int i13 = i9;
                while (i12 < i10) {
                    int[] iArr5 = iArr4;
                    double d10 = m942a;
                    double d11 = fArr2[i12] - fArr2[i9];
                    Double.isNaN(d11);
                    double d12 = d11 * 1.0E-6d;
                    int i14 = i11;
                    double d13 = fArr[i12] - fArr[i9];
                    Double.isNaN(d13);
                    double d14 = d13 * 1.0E-6d;
                    if (Math.abs(d12) > 180.0d) {
                        d12 = 360.0d - Math.abs(d12);
                    }
                    int i15 = i9;
                    double d15 = cos;
                    double d16 = fArr[i12] + fArr[i9];
                    Double.isNaN(d16);
                    double cos2 = d12 * Math.cos(d16 * 8.726646259971647E-9d);
                    double d17 = fArr2[i12] - fArr2[i10];
                    Double.isNaN(d17);
                    double d18 = d17 * 1.0E-6d;
                    double d19 = d7;
                    double d20 = fArr[i12] - fArr[i10];
                    Double.isNaN(d20);
                    double d21 = d20 * 1.0E-6d;
                    if (Math.abs(d18) > 180.0d) {
                        d18 = 360.0d - Math.abs(d18);
                    }
                    double d22 = fArr[i12] + fArr[i10];
                    Double.isNaN(d22);
                    double cos3 = d18 * Math.cos(d22 * 8.726646259971647E-9d);
                    double m942a3 = m942a(cos2) + m942a(d14);
                    double m942a4 = m942a(d21) + m942a(cos3);
                    if (m942a3 >= m942a2 + m942a4) {
                        m942a3 = m942a4;
                    } else if (m942a4 < m942a2 + m942a3) {
                        m942a3 = m942a((cos2 * d19) - (d14 * d15)) / m942a2;
                    }
                    if (m942a3 > d9) {
                        d9 = m942a3;
                        i13 = i12;
                    }
                    i12++;
                    iArr4 = iArr5;
                    m942a = d10;
                    i11 = i14;
                    i9 = i15;
                    cos = d15;
                    d7 = d19;
                }
                iArr2 = iArr4;
                d3 = m942a;
                i4 = i11;
                int i16 = i9;
                if (d9 < d3) {
                    c0219b = this;
                    c0219b.f1210a.add(Integer.valueOf(i16));
                } else {
                    c0219b = this;
                    int i17 = i4 + 1;
                    int i18 = i17 - 1;
                    iArr[i18] = i13;
                    iArr2[i18] = i10;
                    i7 = i17 + 1;
                    int i19 = i7 - 1;
                    iArr[i19] = i16;
                    iArr2[i19] = i13;
                    iArr3 = iArr;
                    i6 = i3;
                    iArr4 = iArr2;
                    m942a = d3;
                    i5 = 1;
                }
            } else {
                i3 = i6;
                iArr = iArr3;
                iArr2 = iArr4;
                d3 = m942a;
                i4 = i11;
                c0219b.f1210a.add(Integer.valueOf(i9));
            }
            iArr3 = iArr;
            i6 = i3;
            iArr4 = iArr2;
            m942a = d3;
            i7 = i4;
            i5 = 1;
        }
        c0219b.f1210a.add(Integer.valueOf(i6));
    }
}
