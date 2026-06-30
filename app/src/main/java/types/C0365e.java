package types;

/* renamed from: types.e */
/* loaded from: classes.dex */
public class C0365e {
    private static int r7 = 0;
    /* renamed from: a */
    public static float m1202a(float f2, float f3) {
        return (float) Math.sqrt((f2 * f2) + (f3 * f3));
    }

    /* renamed from: a */
    public static float m1203a(float f2, float f3, float f4, float f5) {
        float f6 = f4 - f2;
        float f7 = f5 - f3;
        return (float) Math.sqrt((f6 * f6) + (f7 * f7));
    }

    /* renamed from: a */
    public static float m1204a(Coord coord, Coord coord2) {
        float f2 = coord2.f1970a - coord.f1970a;
        float f3 = coord2.f1971b - coord.f1971b;
        return (float) Math.sqrt((f2 * f2) + (f3 * f3));
    }

    /* renamed from: a */
    public static int m1205a(int[] iArr, int[] iArr2, int[] iArr3, int i2) {
        int length = iArr.length;
        if (length < 10) {
            for (int i3 = 0; i3 < length; i3++) {
                iArr3[i3] = i3;
            }
            return length;
        }
        int[] iArr4 = new int[length];
        int[] iArr5 = new int[length];
        double d2 = i2 * i2;
        iArr4[0] = 0;
        int i4 = 1;
        int i5 = length - 1;
        iArr5[0] = i5;
        int i6 = 1;
        int i7 = 0;
        while (i6 > 0) {
            int i8 = i6 - 1;
            int i9 = iArr4[i8];
            int i10 = iArr5[i8];
            i6--;
            if (i10 - i9 > i4) {
                double d3 = iArr2[i10] - iArr2[i9];
                int i11 = i7;
                double d4 = iArr[i10] - iArr[i9];
                Double.isNaN(d3);
                Double.isNaN(d3);
                Double.isNaN(d4);
                Double.isNaN(d4);
                double d5 = (d3 * d3) + (d4 * d4);
                double d6 = -1.0d;
                int i12 = i5;
                int i13 = i9 + 1;
                int i14 = i9;
                while (i13 < i10) {
                    int[] iArr6 = iArr5;
                    int[] iArr7 = iArr4;
                    double d7 = iArr2[i13] - iArr2[i9];
                    int i15 = i6;
                    double d8 = d2;
                    double d9 = iArr[i13] - iArr[i9];
                    double d10 = iArr2[i13] - iArr2[i10];
                    int i16 = i10;
                    int i17 = i9;
                    double d11 = iArr[i13] - iArr[i10];
                    Double.isNaN(d7);
                    Double.isNaN(d7);
                    Double.isNaN(d9);
                    Double.isNaN(d9);
                    double d12 = (d7 * d7) + (d9 * d9);
                    Double.isNaN(d10);
                    Double.isNaN(d10);
                    Double.isNaN(d11);
                    Double.isNaN(d11);
                    double d13 = (d10 * d10) + (d11 * d11);
                    if (d12 >= d5 + d13) {
                        d12 = d13;
                    } else if (d13 < d5 + d12) {
                        Double.isNaN(d7);
                        Double.isNaN(d4);
                        Double.isNaN(d9);
                        Double.isNaN(d3);
                        double d14 = (d7 * d4) - (d9 * d3);
                        d12 = (d14 * d14) / d5;
                    }
                    if (d12 > d6) {
                        i14 = i13;
                        d6 = d12;
                    }
                    i13++;
                    iArr5 = iArr6;
                    iArr4 = iArr7;
                    i6 = i15;
                    d2 = d8;
                    i9 = i17;
                    i10 = i16;
                }
                int i18 = i6;
                int[] iArr8 = iArr4;
                int[] iArr9 = iArr5;
                double d15 = d2;
                int i19 = i10;
                int i20 = i9;
                if (d6 < d15) {
                    i7 = i11 + 1;
                    iArr3[i11] = i20;
                    i5 = i12;
                    iArr5 = iArr9;
                    iArr4 = iArr8;
                    i6 = i18;
                } else {
                    int i21 = i18 + 1;
                    int i22 = i21 - 1;
                    iArr8[i22] = i14;
                    iArr9[i22] = i19;
                    i6 = i21 + 1;
                    int i23 = i6 - 1;
                    iArr8[i23] = i20;
                    iArr9[i23] = i14;
                    i7 = i11;
                    i5 = i12;
                    iArr5 = iArr9;
                    iArr4 = iArr8;
                }
                d2 = d15;
            } else {
                int i24 = i7;
                i7 = i24 + 1;
                iArr3[i24] = i9;
            }
            i4 = 1;
        }
        int i25 = i7;
        int i26 = i25 + 1;
        iArr3[i25] = i5;
        return i26;
    }

    /* renamed from: a */
    public static void m1206a(float f2, float f3, float f4, float f5, float f6, float f7, Coord coord) {
        float f8 = f5 - f3;
        float f9 = f4 - f2;
        if (f8 != (-f9)) {
            float f10 = (((f6 - f2) * f8) - ((f7 - f3) * f9)) / ((f8 * f8) + (f9 * f9));
            coord.f1970a = f6 - (f8 * f10);
            f7 += f10 * f9;
        } else {
            coord.f1970a = f6;
        }
        coord.f1971b = f7;
    }

    /* renamed from: a */
    public static void m1207a(Coord coord, Coord coord2, Coord coord3, Coord coord4) {
        float[] fArr = {0.0f, 0.0f};
        m1218b(coord.f1970a, coord.f1971b, coord2.f1970a, coord2.f1971b, coord3.f1970a, coord3.f1971b, fArr);
        coord4.f1970a = fArr[0];
        coord4.f1971b = fArr[1];
    }

    /* renamed from: a */
    public static boolean m1208a(float f2, float f3, float f4, float f5, float f6, float f7) {
        return (((f2 > f4 ? 1 : (f2 == f4 ? 0 : -1)) >= 0) == ((f2 > f6 ? 1 : (f2 == f6 ? 0 : -1)) <= 0)) && (((f3 > f5 ? 1 : (f3 == f5 ? 0 : -1)) >= 0) == ((f3 > f7 ? 1 : (f3 == f7 ? 0 : -1)) <= 0));
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0084, code lost:
    
        if (m1208a(r8, r9, r16, r17, r18, r19) != false) goto L15;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean m1209a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, float[] fArr, boolean z) {
        int i2;
        float[] fArr2;
        float f9 = f4 - f2;
        float f10 = f5 - f3;
        float f11 = (f9 * f9) + (f10 * f10);
        if (f11 == 0.0f) {
            return false;
        }
        float f12 = (((f2 - f6) * f9) + ((f3 - f7) * f10)) * 2.0f;
        float f13 = (f12 * f12) - ((4.0f * f11) * (((((f6 * f6) + (f7 * f7)) + ((f2 * f2) + (f3 * f3))) - (((f6 * f2) + (f7 * f3)) * 2.0f)) - (f8 * f8)));
        if (f13 < 0.0f) {
            return false;
        }
        double d2 = -f12;
        double d3 = f13;
        double sqrt = Math.sqrt(d3);
        Double.isNaN(d2);
        float f14 = f11 * 2.0f;
        float f15 = ((float) (d2 + sqrt)) / f14;
        float f16 = (f15 * f9) + f2;
        float f17 = f3 + (f15 * f10);
        double sqrt2 = Math.sqrt(d3);
        Double.isNaN(d2);
        float f18 = ((float) (d2 - sqrt2)) / f14;
        float f19 = f2 + (f9 * f18);
        float f20 = f3 + (f18 * f10);
        if (z) {
            i2 = 4;
        } else {
            i2 = 4;
        }
        if (m1203a(f2, f3, f16, f17) < m1203a(f2, f3, f19, f20)) {
            fArr[0] = f16;
            fArr[1] = f17;
            if (fArr.length >= i2) {
                fArr[2] = f19;
                fArr[3] = f20;
            }
            return true;
        }
        if (z) {
            fArr2 = fArr;
            if (!m1208a(f19, f20, f2, f3, f4, f5)) {
                return false;
            }
        } else {
            fArr2 = fArr;
        }
        fArr2[0] = f19;
        fArr2[1] = f20;
        if (fArr2.length >= i2) {
            fArr2[2] = f16;
            fArr2[3] = f17;
        }
        return true;
    }

    /* renamed from: a */
    public static boolean m1210a(float f2, float f3, float f4, float f5, float f6, float f7, float[] fArr) {
        float f8 = f5 - f2;
        float f9 = f6 - f3;
        float sqrt = (float) Math.sqrt((f9 * f9) + (f8 * f8));
        if (sqrt > f4 + f7 || sqrt < Math.abs(f4 - f7)) {
            return false;
        }
        float f10 = (((f4 * f4) - (f7 * f7)) + (sqrt * sqrt)) / (2.0f * sqrt);
        float f11 = f2 + ((f8 * f10) / sqrt);
        float f12 = f3 + ((f9 * f10) / sqrt);
        float sqrt2 = ((float) Math.sqrt(r7 - (f10 * f10))) / sqrt;
        float f13 = (-f9) * sqrt2;
        float f14 = f8 * sqrt2;
        fArr[0] = f11 + f13;
        fArr[1] = f12 + f14;
        fArr[2] = f11 - f13;
        fArr[3] = f12 - f14;
        return true;
    }

    /* renamed from: a */
    public static boolean m1211a(Coord coord, float f2, Coord coord2, float f3, Coord[] coordArr) {
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        if (!m1210a(coord.f1970a, coord.f1971b, f2, coord2.f1970a, coord2.f1971b, f3, fArr)) {
            return false;
        }
        coordArr[0].m1167a(fArr[0], fArr[1]);
        coordArr[1].m1167a(fArr[2], fArr[3]);
        return true;
    }

    /* renamed from: a */
    public static boolean m1212a(Coord coord, Coord coord2, Coord coord3) {
        return m1208a(coord.f1970a, coord.f1971b, coord2.f1970a, coord2.f1971b, coord3.f1970a, coord3.f1971b);
    }

    /* renamed from: a */
    public static boolean m1213a(Coord coord, Coord coord2, Coord coord3, float f2, Coord coord4, boolean z) {
        float[] fArr = {0.0f, 0.0f};
        if (!m1209a(coord.f1970a, coord.f1971b, coord2.f1970a, coord2.f1971b, coord3.f1970a, coord3.f1971b, f2, fArr, z)) {
            return false;
        }
        coord4.f1970a = fArr[0];
        coord4.f1971b = fArr[1];
        return true;
    }

    /* renamed from: a */
    public static boolean m1214a(Coord coord, Coord coord2, Coord coord3, float f2, Coord[] coordArr, boolean z) {
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        if (!m1209a(coord.f1970a, coord.f1971b, coord2.f1970a, coord2.f1971b, coord3.f1970a, coord3.f1971b, f2, fArr, z)) {
            return false;
        }
        coordArr[0].m1167a(fArr[0], fArr[1]);
        coordArr[1].m1167a(fArr[2], fArr[3]);
        return true;
    }

    /* renamed from: a */
    public static Coord[] m1215a(float f2, float f3, float f4, float f5, float f6, float f7, float f8, boolean z) {
        float[] fArr = new float[4];
        if (m1209a(f2, f3, f4, f5, f6, f7, f8, fArr, z)) {
            return new Coord[]{new Coord(fArr[0], fArr[1]), new Coord(fArr[2], fArr[3])};
        }
        return null;
    }

    /* renamed from: b */
    public static Coord m1216b(Coord coord, Coord coord2) {
        Coord coord3 = new Coord();
        m1220d(coord, coord2, coord3);
        return coord3;
    }

    /* renamed from: b */
    public static Coord m1217b(Coord coord, Coord coord2, Coord coord3) {
        coord3.f1970a = (coord.f1970a + coord2.f1970a) / 2.0f;
        coord3.f1971b = (coord.f1971b + coord2.f1971b) / 2.0f;
        return coord3;
    }

    /* renamed from: b */
    public static void m1218b(float f2, float f3, float f4, float f5, float f6, float f7, float[] fArr) {
        float f8 = f6 - f4;
        float f9 = f7 - f5;
        float f10 = f8 * f8;
        float f11 = f9 * f9;
        float f12 = f10 - f11;
        float f13 = f10 + f11;
        float f14 = f12 / f13;
        float f15 = ((f8 * 2.0f) * f9) / f13;
        float f16 = f2 - f4;
        float f17 = f3 - f5;
        fArr[0] = (f14 * f16) + (f15 * f17) + f4;
        fArr[1] = ((f15 * f16) - (f14 * f17)) + f5;
    }

    /* renamed from: c */
    public static void m1219c(Coord coord, Coord coord2, Coord coord3) {
        m1206a(coord.f1970a, coord.f1971b, coord2.f1970a, coord2.f1971b, coord3.f1970a, coord3.f1971b, coord3);
    }

    /* renamed from: d */
    public static void m1220d(Coord coord, Coord coord2, Coord coord3) {
        float f2 = (coord.f1971b - coord2.f1971b) / (coord.f1970a - coord2.f1970a);
        if (f2 == 0.0f) {
            f2 = 1.0E-6f;
        }
        float f3 = coord2.f1971b + (coord2.f1970a / f2);
        coord3.f1970a = coord.f1970a;
        coord3.f1971b = (((-1.0f) / f2) * coord3.f1970a) + f3;
    }
}
