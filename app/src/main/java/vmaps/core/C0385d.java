package vmaps.core;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import types.C0367g;
import types.C0369i;
import types.C0375o;
import vmaps.C0380b;

/* renamed from: vmaps.core.d */
/* loaded from: classes.dex */
public class C0385d {
    private static int r4 = 0;
    private static int r8 = 0;

    /* renamed from: b */
    public short[] f2169b;

    /* renamed from: c */
    public int f2170c;

    /* renamed from: d */
    public int f2171d;

    /* renamed from: e */
    public int f2172e;

    /* renamed from: f */
    public float f2173f;

    /* renamed from: g */
    public float f2174g;

    /* renamed from: h */
    public float f2175h;

    /* renamed from: i */
    public float f2176i;

    /* renamed from: j */
    public float f2177j;

    /* renamed from: k */
    public float f2178k;

    /* renamed from: l */
    public float f2179l;

    /* renamed from: m */
    public float f2180m;

    /* renamed from: n */
    public C0387f f2181n;

    /* renamed from: p */
    public int f2183p;

    /* renamed from: r */
    private int f2185r;

    /* renamed from: s */
    private boolean f2186s;

    /* renamed from: o */
    public boolean f2182o = true;

    /* renamed from: q */
    ArrayList<a> f2184q = new ArrayList<>();

    /* renamed from: a */
    public C0367g f2168a = new C0367g();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: vmaps.core.d$a */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a */
        int f2187a;

        /* renamed from: b */
        int[] f2188b;

        /* renamed from: c */
        int[] f2189c;

        /* renamed from: d */
        int f2190d;

        a() {
        }
    }

    public C0385d(C0367g c0367g, int i2, int i3, int i4) {
        this.f2168a.m1229b(c0367g);
        this.f2170c = i2;
        this.f2171d = i3;
        this.f2172e = i4;
        m1374b();
    }

    /* renamed from: a */
    private int m1366a(int i2, int i3, int i4, int i5) {
        int i6 = (((i2 >> 16) & 255) * i4) + (((i3 >> 16) & 255) * i5);
        int i7 = i4 + i5;
        int i8 = ((((i2 >> 8) & 255) * i4) + (((i3 >> 8) & 255) * i5)) / i7;
        return ((i6 / i7) << 16) | (-16777216) | (i8 << 8) | (((i4 * (i2 & 255)) + (i5 * (i3 & 255))) / i7);
    }

    /* renamed from: a */
    private static short m1367a(int i2) {
        int i3 = i2 & 255;
        return (short) (((short) (((short) (((((((i2 >> 16) & 255) + 1) / 4) * 1024) | (((((i2 >> 8) & 255) + 1) / 4) * 32)) | ((i3 + 1) / 4))) - 1000)) & 65535);
    }

    /* renamed from: a */
    private void m1368a(String str, AbstractC0386e abstractC0386e, C0385d c0385d) {
        C0390i c0390i = null;
        int m1373b = 0;
        int[] iArr = null;
        int[] iArr2 = null;
        int i2 = 0;
        int i3 = 0;
        AbstractC0386e abstractC0386e2 = null;
        ArrayList<String> m1271a = C0375o.m1271a(this.f2168a);
        AbstractC0386e mo1381a = abstractC0386e.mo1381a();
        mo1381a.mo1382a(this.f2170c, this.f2171d, this.f2168a);
        if (this.f2169b == null) {
            this.f2169b = new short[this.f2170c * this.f2171d];
        }
        for (int i4 = 0; i4 < m1271a.size(); i4++) {
            String str2 = str + m1271a.get(i4) + ".vmp";
            C0390i c0390i2 = new C0390i(5);
            c0390i2.m1409b(3);
            c0390i2.m1407a(this.f2170c, this.f2171d, this.f2168a.f2012a, this.f2168a.f2014c, mo1381a.f2195m, mo1381a.f2196n);
            try {
                c0390i2.m1408a(str2);
                c0390i2.m1406a((int) (this.f2173f * this.f2170c));
                this.f2185r = c0390i2.m1411c();
                this.f2183p = c0390i2.f2223i;
                while (c0390i2.m1410b()) {
                    if (c0390i2.f2220f > 0) {
                        if (c0390i2.f2218d >= 0) {
                            c0390i = c0390i2;
                            m1373b = m1373b(c0390i.f2218d);
                            iArr = c0390i.f2215a;
                            iArr2 = c0390i.f2216b;
                            i2 = c0390i.f2220f;
                            i3 = c0390i.f2218d;
                            abstractC0386e2 = mo1381a;
                        } else if (c0385d == null) {
                            int m1373b2 = m1373b(c0390i2.f2218d);
                            iArr = c0390i2.f2215a;
                            iArr2 = c0390i2.f2216b;
                            i2 = c0390i2.f2220f;
                            i3 = c0390i2.f2218d;
                            abstractC0386e2 = mo1381a;
                            c0390i = c0390i2;
                            m1373b = m1373b2;
                        } else if (!this.f2186s || c0390i2.f2218d == -3) {
                            c0385d.m1370a(c0390i2);
                        }
                        abstractC0386e2.mo1387a(iArr, iArr2, i2, i3, m1373b);
                        c0390i2 = c0390i;
                    }
                }
            } catch (Exception unused) {
            }
        }
        int[] mo1391c = mo1381a.mo1391c();
        for (int i5 = 0; i5 < mo1391c.length; i5++) {
            short m1367a = m1367a(mo1391c[i5]);
            this.f2169b[i5] = (short) (m1367a >= 0 ? m1367a + 1000 : 0);
        }
    }

    /* renamed from: a */
    private void m1369a(AbstractC0386e abstractC0386e) {
        Iterator<a> it = this.f2184q.iterator();
        while (it.hasNext()) {
            a next = it.next();
            abstractC0386e.mo1387a(next.f2188b, next.f2189c, next.f2190d, next.f2187a, this.f2181n.m1395a(next.f2187a));
        }
    }

    /* renamed from: a */
    private void m1370a(C0390i c0390i) {
        a aVar = new a();
        aVar.f2187a = c0390i.f2218d;
        aVar.f2190d = c0390i.f2220f;
        aVar.f2188b = new int[aVar.f2190d];
        aVar.f2189c = new int[aVar.f2190d];
        for (int i2 = 0; i2 < aVar.f2190d; i2++) {
            aVar.f2188b[i2] = m1375a(c0390i.f2215a[i2] * 0.001f);
            aVar.f2189c[i2] = m1380b(c0390i.f2216b[i2] * 0.001f);
        }
        this.f2184q.add(aVar);
    }

    /* renamed from: a */
    private void m1371a(int[] iArr, int i2, int i3) {
        for (int i4 = 1; i4 < this.f2171d - 1; i4++) {
            int i5 = this.f2170c * i4;
            for (int i6 = 1; i6 < this.f2170c - 1; i6++) {
                i5++;
                int i7 = this.f2169b[i5 - this.f2170c] / i3;
                int i8 = this.f2169b[i5 - 1] / i3;
                int i9 = (this.f2169b[i5] - 1000) / i2;
                int i10 = this.f2169b[i5] / i3;
                int i11 = this.f2169b[i5 + 1] / i3;
                int i12 = this.f2169b[this.f2170c + i5] / i3;
                int i13 = iArr[i5];
                if (i2 > 1) {
                    i13 = m1366a(i13, this.f2181n.m1395a(i9 * i2), 1, 1);
                }
                if (i3 > 1 && (i10 > i7 || i10 > i8 || i10 > i11 || i10 > i12)) {
                    i13 = m1366a(i13, 0, 10, 1);
                }
                iArr[i5] = i13;
            }
        }
    }

    /* renamed from: a */
    private int[] m1372a() {
        int[] iArr = new int[this.f2169b.length];
        for (int i2 = 0; i2 < this.f2169b.length; i2++) {
            iArr[i2] = m1376a(this.f2169b[i2]);
        }
        return iArr;
    }

    /* renamed from: b */
    private static int m1373b(int i2) {
        int i3 = i2 + 1000;
        int i4 = i3 / 1024;
        int i5 = i3 - (i4 * 1024);
        int i6 = i5 / 32;
        return ((i5 - (i6 * 32)) * 4) | ((i4 * 4) << 16) | (-16777216) | ((i6 * 4) << 8);
    }

    /* renamed from: b */
    private void m1374b() {
        this.f2175h = this.f2170c / this.f2168a.m1238g();
        this.f2176i = this.f2171d / this.f2168a.m1237f();
        float m1248b = C0369i.m1248b(this.f2168a.f2012a, this.f2168a.f2014c, this.f2168a.f2012a, this.f2168a.f2015d);
        float m1248b2 = C0369i.m1248b(this.f2168a.f2012a, this.f2168a.f2014c, this.f2168a.f2013b, this.f2168a.f2014c);
        this.f2173f = m1248b / this.f2170c;
        this.f2174g = m1248b2 / this.f2171d;
        this.f2177j = this.f2168a.m1237f() / this.f2171d;
        this.f2178k = this.f2168a.m1238g() / this.f2170c;
        this.f2179l = this.f2171d / this.f2168a.m1237f();
        this.f2180m = this.f2170c / this.f2168a.m1238g();
    }

    /* renamed from: a */
    public int m1375a(float f2) {
        return (int) ((f2 - this.f2168a.f2014c) * this.f2175h);
    }

    /* renamed from: a */
    public int m1376a(short s) {
        return this.f2181n.m1395a((short) (s - 1000));
    }

    /* renamed from: a */
    public void m1377a(int i2, int i3) {
        short[] sArr = new short[this.f2169b.length];
        for (int i4 = 0; i4 < sArr.length; i4++) {
            short s = this.f2169b[i4];
            if (s >= 1000) {
                if (i3 != 0) {
                    double d2 = i3;
                    double random = Math.random();
                    Double.isNaN(d2);
                    double d3 = d2 * random;
                    Double.isNaN(i3 / 2);
                    Double.isNaN(s);
                    s = (short) (r4 + (d3 - r8));
                    if (s < 1000) {
                        s = 1000;
                    }
                }
                s = (short) (((s + i2) / i2) * i2);
            }
            sArr[i4] = s;
        }
        this.f2169b = null;
        this.f2169b = sArr;
    }

    /* renamed from: a */
    public void m1378a(String str, AbstractC0386e abstractC0386e, boolean z, int i2, boolean z2) {
        int i3;
        int[] m1372a;
        int[] m1372a2;
        short[] sArr;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        C0380b c0380b;
        short[] sArr2;
        int i9;
        int i10;
        int i11 = i2;
        boolean z3 = this.f2170c <= 100;
        int[] iArr = {2000, 800, 500, 250, 100, 40, 16, 5, 2, 1, 0};
        int[][] iArr2 = {new int[]{6, 5, 5, 3, 2, 2, 2, 2, 2, 2, 2}, new int[]{7, 6, 6, 4, 3, 2, 2, 2, 2, 2, 2}};
        int[][] iArr3 = {new int[]{0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1}, new int[]{4, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}};
        int[][] iArr4 = {new int[]{7, 4, 3, 3, 2, 0, 0, 0, 0, 0, 0}, new int[]{8, 8, 4, 5, 3, 1, 0, 0, 0, 0, 0}};
        int[][] iArr5 = {new int[]{10, 40, 50, 60, 0, 0, 0, 0, 0, 0, 0}, new int[]{20, 30, 40, 50, 80, 50, 0, 0, 0, 0, 0}};
        double[][] dArr = {new double[]{12.0d, 6.0d, 3.0d, 2.0d, 1.0d, 0.4d, 0.3d, 0.3d, 0.3d, 0.3d, 0.3d}, new double[]{12.0d, 7.0d, 4.0d, 3.5d, 1.5d, 0.4d, 0.3d, 0.25d, 0.2d, 0.2d, 0.2d}};
        int i12 = (int) (10.0f / this.f2173f);
        int length = iArr.length - 1;
        int i13 = 0;
        while (true) {
            if (i13 >= iArr.length) {
                break;
            }
            if (i12 > iArr[i13]) {
                length = i13;
                break;
            }
            i13++;
        }
        if (z3 && (length = length + 2) >= iArr2[0].length) {
            length = iArr2[0].length - 1;
        }
        int i14 = !z ? 1 : 0;
        int i15 = iArr2[i14][length];
        int i16 = iArr3[i14][length];
        int i17 = iArr4[i14][length];
        int i18 = iArr5[i14][length];
        float f2 = (float) dArr[i14][length];
        if (z3 && i12 < 100) {
            i15 = 1;
            i16 = 1;
            i17 = 0;
        }
        if (this.f2173f * this.f2170c < 9.0f && i11 != 4 && i11 != 3) {
            i11 = 20;
        }
        if (this.f2182o || i12 < 100) {
            i3 = 2;
        } else {
            i3 = 2;
            i18 = 50;
        }
        if (i11 == i3 || i11 == 20 || i11 == 3) {
            i18 = 0;
        }
        this.f2181n = new C0387f(i11);
        C0385d c0385d = new C0385d(this.f2168a, this.f2170c / i15, this.f2171d / i15, this.f2172e);
        c0385d.f2181n = this.f2181n;
        c0385d.f2186s = length > 9;
        c0385d.m1368a(str, abstractC0386e, this);
        this.f2183p = c0385d.f2183p;
        C0380b c0380b2 = new C0380b((short) 1000);
        if (c0385d.f2185r > 1) {
            c0385d.m1377a(50, 400);
            c0380b2.m1305a(c0385d.f2169b, c0385d.f2170c, c0385d.f2171d, 3);
        }
        for (int i19 = 0; i19 < i16; i19++) {
            if (length < 4) {
                i6 = 5;
                i7 = 3;
                i8 = 2;
                c0380b = c0380b2;
                sArr2 = c0385d.f2169b;
                i9 = c0385d.f2170c;
                i10 = c0385d.f2171d;
            } else {
                if (length < 6) {
                    sArr = c0385d.f2169b;
                    i4 = c0385d.f2170c;
                    i5 = c0385d.f2171d;
                    i6 = 8;
                } else {
                    sArr = c0385d.f2169b;
                    i4 = c0385d.f2170c;
                    i5 = c0385d.f2171d;
                    i6 = 20;
                }
                i7 = 1;
                i8 = 1;
                c0380b = c0380b2;
                sArr2 = sArr;
                i9 = i4;
                i10 = i5;
            }
            c0385d.f2169b = c0380b.m1306a(sArr2, i9, i10, i6, i7, i8);
        }
        if (i17 > 0) {
            c0380b2.m1305a(c0385d.f2169b, c0385d.f2170c, c0385d.f2171d, i17 * 2);
        }
        if (z2) {
            if (this.f2182o) {
                float f3 = (float) new double[]{4.0d, 3.0d, 1.5d, 1.0d, 0.5d, 0.3d, 0.2d, 0.15d, 0.1d, 0.1d, 0.1d, 0.1d}[length];
                C0382a c0382a = new C0382a(c0385d);
                if (z3) {
                    c0382a.m1360a(f3, 20).m1359a(315.0d, 45.0d, 2);
                } else {
                    c0382a.m1360a(f3, 20).m1359a(0.0d, 90.0d, 1);
                }
                if (i11 == 3) {
                    c0382a.f2149g = 6;
                } else {
                    if (i11 == 10) {
                        c0382a.f2150h = 30;
                    } else if (length < 3) {
                        c0382a.f2150h = 20;
                    }
                    m1372a = c0382a.m1361a();
                }
                c0382a.f2150h = 10;
                m1372a = c0382a.m1361a();
            } else {
                m1372a = c0385d.m1372a();
            }
            abstractC0386e.mo1382a(this.f2170c, this.f2171d, this.f2168a);
            abstractC0386e.mo1386a(m1372a, c0385d.f2170c, c0385d.f2171d);
        } else {
            m1379a(c0385d);
            if (this.f2182o) {
                C0382a c0382a2 = new C0382a(this);
                if (z3) {
                    c0382a2.m1360a(f2, 20).m1359a(315.0d, 45.0d, 2);
                } else {
                    c0382a2.m1360a(f2, 20).m1359a(0.0d, 90.0d, 1);
                }
                if (i11 == 3) {
                    c0382a2.f2149g = 6;
                } else if (i11 == 10) {
                    c0382a2.f2150h = 30;
                } else {
                    c0382a2.f2150h = 10;
                }
                m1372a2 = c0382a2.m1361a();
            } else {
                m1372a2 = m1372a();
            }
            if (i18 != 0) {
                m1371a(m1372a2, 1, i18);
            }
            abstractC0386e.mo1382a(this.f2170c, this.f2171d, this.f2168a);
            abstractC0386e.mo1385a(m1372a2);
        }
        m1369a(abstractC0386e);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0096  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    void m1379a(C0385d c0385d) {
        short s;
        int i2 = 0;
        if (this.f2169b == null) {
            this.f2169b = new short[this.f2170c * this.f2171d];
        }
        C0383b c0383b = new C0383b(c0385d.f2170c, c0385d.f2171d, c0385d.f2169b);
        short[] sArr = c0385d.f2169b;
        short[] sArr2 = this.f2169b;
        int i3 = c0385d.f2170c;
        int i4 = c0385d.f2171d;
        float f2 = c0385d.f2175h;
        int i5 = 0;
        int i6 = 0;
        while (i5 < this.f2171d) {
            float f3 = i4;
            float f4 = f3 - (((((this.f2171d - (i5 - 1.0f)) / this.f2176i) + this.f2168a.f2012a) - c0385d.f2168a.f2012a) * c0385d.f2176i);
            if (f4 < 0.0f) {
                f4 = 0.0f;
            } else if (f4 >= f3) {
                f4 = f3 - 0.001f;
            }
            int i7 = ((int) f4) * i3;
            int i8 = 0;
            while (i8 < this.f2170c) {
                float f5 = ((this.f2168a.f2014c + (i8 / this.f2175h)) - c0385d.f2168a.f2014c) * f2;
                if (f5 < 0.0f) {
                    f5 = 0.0f;
                } else {
                    float f6 = i3;
                    if (f5 >= f6) {
                        f5 = f6 - 0.001f;
                        s = sArr[((int) f5) + i7];
                        if (s <= 0) {
                            i2 = i5;
                            s = (short) c0383b.m1362a(f5, f4);
                        } else {
                            i2 = i5;
                        }
                        sArr2[i6 + i8] = s;
                        i8++;
                        i5 = i2;
                    }
                }
                s = sArr[((int) f5) + i7];
                if (s <= 0) {
                }
                sArr2[i6 + i8] = s;
                i8++;
                i5 = i2;
            }
            i6 += this.f2170c;
            i5++;
        }
    }

    /* renamed from: b */
    public int m1380b(float f2) {
        return (int) (this.f2171d - ((f2 - this.f2168a.f2012a) * this.f2176i));
    }
}
