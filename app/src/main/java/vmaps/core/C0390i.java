package vmaps.core;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import types.C0367g;
import types.C0369i;

/* renamed from: vmaps.core.i */
/* loaded from: classes.dex */
public class C0390i {

    /* renamed from: r */
    public static boolean f2205r = false;

    /* renamed from: A */
    private int f2206A;

    /* renamed from: B */
    private C0367g f2207B;

    /* renamed from: C */
    private float f2208C;

    /* renamed from: D */
    private float f2209D;

    /* renamed from: E */
    private DataInputStream f2210E;

    /* renamed from: F */
    private FileInputStream f2211F;

    /* renamed from: G */
    private int f2212G;

    /* renamed from: H */
    private boolean f2213H;

    /* renamed from: I */
    private int[] f2214I;

    /* renamed from: a */
    public int[] f2215a;

    /* renamed from: b */
    public int[] f2216b;

    /* renamed from: c */
    public int f2217c;

    /* renamed from: d */
    public int f2218d;

    /* renamed from: e */
    public int f2219e;

    /* renamed from: f */
    public int f2220f;

    /* renamed from: g */
    public int f2221g;

    /* renamed from: h */
    public int f2222h;

    /* renamed from: i */
    public int f2223i;

    /* renamed from: j */
    public int f2224j;

    /* renamed from: k */
    public int f2225k;

    /* renamed from: l */
    public int f2226l;

    /* renamed from: m */
    public float f2227m;

    /* renamed from: n */
    public float f2228n;

    /* renamed from: o */
    public float f2229o;

    /* renamed from: p */
    public float f2230p;

    /* renamed from: q */
    public int f2231q;

    /* renamed from: s */
    private int f2232s;

    /* renamed from: t */
    private int f2233t;

    /* renamed from: u */
    private int f2234u;

    /* renamed from: v */
    private int f2235v;

    /* renamed from: w */
    private int f2236w;

    /* renamed from: x */
    private int f2237x;

    /* renamed from: y */
    private int f2238y;

    /* renamed from: z */
    private int f2239z;

    protected C0390i() {
        this.f2234u = 0;
        this.f2235v = 6;
        this.f2215a = null;
        this.f2216b = null;
        this.f2231q = 0;
        this.f2211F = null;
        this.f2212G = 0;
        this.f2213H = false;
        this.f2214I = new int[8];
    }

    public C0390i(int i2) {
        this.f2234u = 0;
        this.f2235v = 6;
        this.f2215a = null;
        this.f2216b = null;
        this.f2231q = 0;
        this.f2211F = null;
        this.f2212G = 0;
        this.f2213H = false;
        this.f2214I = new int[8];
        this.f2235v = i2;
    }

    public C0390i(boolean z) {
        this.f2234u = 0;
        this.f2235v = 6;
        this.f2215a = null;
        this.f2216b = null;
        this.f2231q = 0;
        this.f2211F = null;
        this.f2212G = 0;
        this.f2213H = false;
        this.f2214I = new int[8];
        this.f2235v = z ? 6 : 0;
    }

    /* renamed from: a */
    private int m1399a(DataInputStream dataInputStream) {
        short readShort = dataInputStream.readShort();
        return readShort == -1 ? dataInputStream.readInt() : readShort < 0 ? readShort + 65536 : readShort;
    }

    /* renamed from: a */
    private void m1400a(int i2, int i3) {
        if (!this.f2213H) {
            int i4 = this.f2206A;
            this.f2206A = i4 + 1;
            this.f2216b[i4] = i2;
            this.f2215a[i4] = i3;
            return;
        }
        int i5 = (int) (((i3 * 0.001f) - this.f2207B.f2014c) * this.f2208C);
        int i6 = (int) (this.f2233t - (((i2 * 0.001f) - this.f2207B.f2012a) * this.f2209D));
        if (this.f2206A > 0 && i5 == this.f2215a[this.f2206A - 1] && i6 == this.f2216b[this.f2206A - 1]) {
            return;
        }
        if (this.f2234u <= 0 || this.f2206A <= 0 || this.f2218d <= 200 || Math.abs(i5 - this.f2215a[this.f2206A - 1]) >= 3 || Math.abs(i6 - this.f2216b[this.f2206A - 1]) >= 3) {
            if (i5 < this.f2236w) {
                this.f2236w = i5;
            } else if (i5 > this.f2237x) {
                this.f2237x = i5;
            }
            if (i6 < this.f2238y) {
                this.f2238y = i6;
            } else if (i6 > this.f2239z) {
                this.f2239z = i6;
            }
            int i7 = this.f2206A;
            this.f2206A = i7 + 1;
            this.f2215a[i7] = i5;
            this.f2216b[i7] = i6;
        }
    }

    /* renamed from: c */
    private boolean m1401c(int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            int m1399a = m1399a(this.f2210E);
            if (m1399a == 0) {
                m1405a();
                return false;
            }
            this.f2210E.readShort();
            m1399a(this.f2210E);
            this.f2210E.skipBytes(m1399a);
        }
        return true;
    }

    /* renamed from: d */
    private void m1402d() {
        if (this.f2207B == null) {
            return;
        }
        m1406a((int) C0369i.m1248b(this.f2207B.f2012a, this.f2207B.f2014c, this.f2207B.f2013b, this.f2207B.f2015d));
        m1404e();
    }

    /* renamed from: d */
    private boolean m1403d(int i2) {
        if (this.f2218d == this.f2222h) {
            return true;
        }
        int i3 = this.f2214I[this.f2234u];
        if (this.f2218d > 500) {
            i3 *= 2;
        }
        switch (this.f2234u) {
            case 1:
                return this.f2218d < 0 || this.f2218d % i3 == 0;
            case 2:
                return this.f2218d < 0 || this.f2218d % i3 == 0;
            case 3:
                return this.f2218d > 2000 ? this.f2218d % (this.f2214I[2] * 2) == 0 : this.f2218d < 0 || this.f2218d % i3 == 0;
            case 4:
                if (this.f2218d >= 600) {
                    return this.f2218d < 2000 ? this.f2218d % i3 == 0 : this.f2218d % 3000 == 0;
                }
                if (this.f2218d != -3 || i2 <= 200) {
                    return this.f2218d == 400 && i2 > 100;
                }
                return true;
            case 5:
                return this.f2218d == -3 ? i2 > 200 : this.f2218d % i3 == 0 && i2 > 100;
            case 6:
                return this.f2218d >= 0 && this.f2218d % i3 == 0 && i2 > 100;
            default:
                return this.f2218d == 0;
        }
    }

    /* renamed from: e */
    private void m1404e() {
        int i2 = this.f2223i != 0 ? this.f2223i : 100;
        this.f2214I[1] = i2 * 2;
        int i3 = i2 * 4;
        this.f2214I[2] = i3;
        this.f2214I[3] = i2 * 6;
        this.f2214I[4] = i2 * 8;
        this.f2214I[5] = i3;
        this.f2214I[6] = i2 * 20;
        if (this.f2214I[1] > 200) {
            this.f2214I[1] = 200;
        }
        if (this.f2214I[2] > 800) {
            this.f2214I[2] = 800;
        }
        if (this.f2214I[3] > 1000) {
            this.f2214I[3] = 1000;
        }
        if (this.f2214I[4] > 1500) {
            this.f2214I[4] = 1500;
        }
        if (this.f2214I[5] > 2000) {
            this.f2214I[5] = 2000;
        }
        if (this.f2214I[6] > 4000) {
            this.f2214I[6] = 4000;
        }
    }

    /* renamed from: a */
    public void m1405a() {
        if (this.f2211F != null) {
            try {
                this.f2211F.close();
            } catch (IOException unused) {
            }
            this.f2211F = null;
            this.f2210E = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0043  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m1406a(int i2) {
        int i3;
        this.f2234u = 0;
        if (this.f2235v != 0 && i2 >= 300) {
            if (i2 >= 500) {
                if (i2 < 900) {
                    this.f2234u = 2;
                } else if (i2 < 2000) {
                    this.f2234u = 3;
                } else {
                    i3 = i2 < 3500 ? 4 : i2 < 5000 ? 5 : 6;
                }
                if (this.f2234u > this.f2235v) {
                    this.f2234u = this.f2235v;
                }
                if (this.f2223i >= 80) {
                    this.f2234u -= 2;
                    if (this.f2234u <= 0) {
                        this.f2234u = 0;
                        return;
                    } else if (this.f2234u > 3) {
                        this.f2234u = 3;
                    }
                }
                m1404e();
            }
            i3 = 1;
            this.f2234u = i3;
            if (this.f2234u > this.f2235v) {
            }
            if (this.f2223i >= 80) {
            }
            m1404e();
        }
    }

    /* renamed from: a */
    public void m1407a(int i2, int i3, float f2, float f3, float f4, float f5) {
        if (this.f2212G == 0) {
            this.f2213H = true;
        }
        this.f2232s = i2;
        this.f2233t = i3;
        this.f2207B = new C0367g();
        this.f2207B.f2012a = f2;
        this.f2207B.f2014c = f3;
        this.f2208C = f4;
        this.f2209D = f5;
        this.f2207B.f2015d = this.f2207B.f2014c + (i2 * this.f2208C);
        this.f2207B.f2013b = this.f2207B.f2012a + (i3 * this.f2209D);
    }

    /* renamed from: a */
    public void m1408a(String str) {
        this.f2223i = 100;
        this.f2211F = new FileInputStream(str);
        this.f2210E = new DataInputStream(new BufferedInputStream(this.f2211F, 80000));
        this.f2217c = this.f2210E.readByte();
        this.f2225k = this.f2210E.readInt();
        this.f2226l = this.f2210E.readInt();
        this.f2227m = this.f2225k / 1000.0f;
        this.f2228n = this.f2226l / 1000.0f;
        this.f2229o = this.f2210E.readInt() / 1000.0f;
        this.f2230p = this.f2210E.readInt() / 1000.0f;
        this.f2222h = this.f2210E.readShort();
        this.f2221g = this.f2210E.readShort();
        this.f2224j = 0;
        int i2 = this.f2217c - 20;
        if (i2 > 0) {
            this.f2231q = this.f2210E.readByte();
            f2205r = this.f2231q < 2;
            this.f2223i = this.f2210E.readByte();
            i2 = (i2 - 1) - 1;
            if (this.f2223i == 0) {
                this.f2223i = 100;
            }
        }
        while (i2 > 0) {
            i2 -= this.f2210E.skipBytes(i2);
        }
        m1402d();
    }

    /* renamed from: b */
    public void m1409b(int i2) {
        this.f2212G = i2;
        this.f2213H = i2 == 2 || i2 == 3;
    }

    /* renamed from: b */
    public boolean m1410b() {
        int m1399a;
        while (!f2205r && (m1399a = m1399a(this.f2210E)) != 0) {
            this.f2224j++;
            this.f2206A = 0;
            this.f2238y = 99999;
            this.f2236w = 99999;
            this.f2239z = -99999;
            this.f2237x = -99999;
            this.f2218d = this.f2210E.readShort();
            this.f2219e = m1399a(this.f2210E);
            if (this.f2234u == 0 || m1403d(m1399a)) {
                int readShort = this.f2225k + this.f2210E.readShort();
                int readShort2 = this.f2226l + this.f2210E.readShort();
                int i2 = 4;
                int i3 = (m1399a * 3) / 4;
                if (this.f2215a == null || this.f2215a.length < i3) {
                    this.f2215a = new int[i3];
                    this.f2216b = new int[i3];
                }
                if (this.f2212G == 3) {
                    this.f2213H = this.f2218d >= 0;
                }
                m1400a(readShort, readShort2);
                int i4 = readShort;
                int i5 = readShort2;
                while (i2 < m1399a) {
                    byte readByte = this.f2210E.readByte();
                    if (readByte == 0) {
                        i4 += this.f2210E.readShort();
                        i5 += this.f2210E.readShort();
                        i2 += 5;
                        m1400a(i4, i5);
                    } else {
                        int readByte2 = (readByte & 255) | ((this.f2210E.readByte() & 255) << 8) | ((this.f2210E.readByte() & 255) << 16);
                        int i6 = (readByte2 & 31) - 16;
                        int i7 = ((readByte2 >>> 6) & 31) - 16;
                        int i8 = ((readByte2 >>> 12) & 31) - 16;
                        int i9 = ((readByte2 >>> 18) & 31) - 16;
                        int i10 = i4 + i6;
                        int i11 = i5 + i7;
                        if (this.f2234u == 0) {
                            m1400a(i10, i11);
                        }
                        i4 = i10 + i8;
                        i5 = i11 + i9;
                        if (this.f2234u < 2 || (i2 & 7) == 0) {
                            m1400a(i4, i5);
                        }
                        i2 += 3;
                    }
                }
                if (this.f2218d != -2) {
                    m1400a(readShort, readShort2);
                }
                this.f2220f = this.f2206A;
                if (!(this.f2213H && (this.f2237x < 0 || this.f2236w > this.f2232s || this.f2239z < 0 || this.f2238y > this.f2233t))) {
                    return true;
                }
                if (!m1401c(this.f2219e)) {
                    return false;
                }
            } else {
                this.f2210E.skipBytes(m1399a);
            }
        }
        m1405a();
        return false;
    }

    /* renamed from: c */
    public int m1411c() {
        return this.f2234u;
    }
}
