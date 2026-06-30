package vmaps;

/* renamed from: vmaps.b */
/* loaded from: classes.dex */
public class C0380b {

    /* renamed from: a */
    public short f2110a;

    public C0380b(short s) {
        this.f2110a = (short) 1;
        this.f2110a = s;
    }

    /* renamed from: b */
    private void m1303b(short[] sArr, int i2, int i3, int i4) {
        int i5 = i4 / 2;
        short[] sArr2 = new short[i2];
        int i6 = 0;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            int i9 = 0;
            for (int i10 = -i5; i10 < i2; i10++) {
                int i11 = (i10 - i5) - 1;
                if (i11 >= 0) {
                    short s = sArr[i11 + i6];
                    if (s != 0) {
                        i8 -= s;
                    }
                    i9--;
                }
                int i12 = i10 + i5;
                if (i12 < i2) {
                    short s2 = sArr[i12 + i6];
                    if (s2 != 0) {
                        i8 += s2;
                    }
                    i9++;
                }
                if (i10 >= 0) {
                    sArr2[i10] = (short) (i8 / i9);
                }
            }
            for (int i13 = 0; i13 < i2; i13++) {
                short s3 = sArr2[i13];
                if (s3 < this.f2110a) {
                    s3 = sArr[i6 + i13] < this.f2110a ? (short) 0 : this.f2110a;
                }
                int i14 = i6 + i13;
                if (sArr[i14] >= this.f2110a) {
                    sArr[i14] = s3;
                }
            }
            i6 += i2;
        }
    }

    /* renamed from: c */
    private void m1304c(short[] sArr, int i2, int i3, int i4) {
        int i5 = i4 / 2;
        short[] sArr2 = new short[i3];
        int i6 = (-(i5 + 1)) * i2;
        int i7 = i5 * i2;
        for (int i8 = 0; i8 < i2; i8++) {
            int i9 = -i5;
            int i10 = (i9 * i2) + i8;
            int i11 = 0;
            int i12 = 0;
            while (i9 < i3) {
                if ((i9 - i5) - 1 >= 0) {
                    short s = sArr[i10 + i6];
                    if (s != 0) {
                        i11 -= s;
                    }
                    i12--;
                }
                if (i9 + i5 < i3) {
                    short s2 = sArr[i10 + i7];
                    if (s2 != 0) {
                        i11 += s2;
                    }
                    i12++;
                }
                if (i9 >= 0) {
                    sArr2[i9] = (short) (i11 / i12);
                }
                i10 += i2;
                i9++;
            }
            for (int i13 = 0; i13 < i3; i13++) {
                short s3 = sArr2[i13];
                if (s3 < this.f2110a) {
                    s3 = sArr[(i13 * i2) + i8] < this.f2110a ? (short) 0 : this.f2110a;
                }
                int i14 = (i13 * i2) + i8;
                if (sArr[i14] >= this.f2110a) {
                    sArr[i14] = s3;
                }
            }
        }
    }

    /* renamed from: a */
    public void m1305a(short[] sArr, int i2, int i3, int i4) {
        m1303b(sArr, i2, i3, i4);
        m1304c(sArr, i2, i3, i4);
    }

    /* renamed from: a */
    public short[] m1306a(short[] sArr, int i2, int i3, int i4, int i5, int i6) {
        short s;
        short s2;
        short s3;
        short s4;
        short s5;
        short s6;
        short[] sArr2 = new short[sArr.length];
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = i7 * i2;
            sArr2[i8] = sArr[i8];
            int i9 = i2 - 1;
            int i10 = i8 + i9;
            sArr2[i10] = sArr[i10];
            int i11 = 1;
            int i12 = 1;
            while (i12 < i9) {
                int i13 = i8 + i12;
                if (i7 > 0) {
                    int i14 = i13 - i2;
                    short s7 = sArr[i14 - 1];
                    short s8 = sArr[i14];
                    s3 = sArr[i14 + i11];
                    s2 = s7;
                    s = s8;
                } else {
                    s = sArr[i13];
                    s2 = s;
                    s3 = s2;
                }
                short s9 = sArr[i13 - 1];
                short s10 = sArr[i13];
                short s11 = sArr[i13 + 1];
                int i15 = i8;
                if (i7 < i3 - 1) {
                    int i16 = i13 + i2;
                    s5 = sArr[i16 - 1];
                    s6 = sArr[i16];
                    s4 = sArr[i16 + 1];
                } else {
                    s4 = s10;
                    s5 = s4;
                    s6 = s5;
                }
                if (s10 <= 0 || s <= 0 || s6 <= 0 || s11 <= 0 || s9 <= 0 || s2 <= 0 || s3 <= 0 || s5 <= 0 || s4 <= 0) {
                    sArr2[i13] = s10;
                } else {
                    sArr2[i13] = (short) ((((s10 * i4) + ((((s + s9) + s11) + s6) * i5)) + (i6 * (((s2 + s3) + s5) + s4))) / (((i4 * 1) + (i5 * 4)) + (i6 * 4)));
                }
                i12++;
                i8 = i15;
                i11 = 1;
            }
        }
        return sArr2;
    }
}
