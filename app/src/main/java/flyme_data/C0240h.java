package flyme_data;

import com.xcglobe.xclog.ActivityMain;
import com.xcglobe.xclog.C0101l;
import java.util.ArrayList;
import types.GpsVal;

/* renamed from: m.h */
/* loaded from: classes.dex */
public class C0240h {

    /* renamed from: B */
    private float f1435B;

    /* renamed from: C */
    private int f1436C;

    /* renamed from: D */
    private float f1437D;

    /* renamed from: E */
    private float f1438E;

    /* renamed from: F */
    private int f1439F;

    /* renamed from: G */
    private float f1440G;

    /* renamed from: H */
    private float f1441H;

    /* renamed from: I */
    private int f1442I;

    /* renamed from: J */
    private int f1443J;

    /* renamed from: c */
    public float f1448c;

    /* renamed from: d */
    public float f1449d;

    /* renamed from: e */
    public float f1450e;

    /* renamed from: f */
    public float f1451f;

    /* renamed from: g */
    public float f1452g;

    /* renamed from: h */
    public float f1453h;

    /* renamed from: i */
    public float f1454i;

    /* renamed from: j */
    public float f1455j;

    /* renamed from: k */
    public float f1456k;

    /* renamed from: v */
    private float f1467v;

    /* renamed from: q */
    private a f1462q = new a(0.0f, 0.0f, 0);

    /* renamed from: r */
    private final int f1463r = 500;

    /* renamed from: s */
    private final b[] f1464s = new b[500];

    /* renamed from: t */
    private int f1465t = 0;

    /* renamed from: u */
    private int f1466u = 0;

    /* renamed from: w */
    private int f1468w = 0;

    /* renamed from: a */
    public int f1446a = 0;

    /* renamed from: b */
    public int f1447b = 0;

    /* renamed from: x */
    private int f1469x = 0;

    /* renamed from: y */
    private int f1470y = 0;

    /* renamed from: z */
    private int f1471z = 0;

    /* renamed from: A */
    private int f1434A = 0;

    /* renamed from: l */
    public int f1457l = 0;

    /* renamed from: m */
    public ArrayList<a> f1458m = new ArrayList<>();

    /* renamed from: K */
    private int f1444K = 2;

    /* renamed from: n */
    public final float[] f1459n = {0.0f, 0.0f, 0.0f, 0.0f};

    /* renamed from: o */
    public final float[] f1460o = {0.0f, 0.0f, 0.0f, 0.0f};

    /* renamed from: p */
    public final float[] f1461p = {0.0f, 0.0f, 0.0f, 0.0f};

    /* renamed from: L */
    private final float[] f1445L = {0.0f, 0.0f, 0.0f, 0.0f};

    /* renamed from: m.h$a */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a */
        public float f1472a;

        /* renamed from: b */
        public float f1473b;

        /* renamed from: c */
        public int f1474c;

        /* renamed from: d */
        int f1475d;

        a(float f2, float f3, int i2) {
            this.f1472a = f2;
            this.f1473b = f3;
            this.f1474c = i2;
            this.f1475d = C0240h.this.f1470y;
        }
    }

    /* renamed from: m.h$b */
    /* loaded from: classes.dex */
    public class b {

        /* renamed from: a */
        public float f1477a;

        /* renamed from: b */
        public float f1478b;

        /* renamed from: c */
        int f1479c;

        /* renamed from: d */
        public float f1480d;

        /* renamed from: e */
        int f1481e;

        /* renamed from: f */
        int f1482f;

        public b() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0240h() {
        for (int i2 = 0; i2 < 500; i2++) {
            this.f1464s[i2] = new b();
        }
        m1091b();
    }

    /* renamed from: e */
    private boolean m1087e() {
        if ((C0239g.f1432y & 1) == 0) {
            if (C0239g.f1432y != this.f1442I) {
                this.f1440G = 0.0f;
            }
            float f2 = this.f1440G + C0239g.f1422o;
            this.f1440G = f2;
            if (f2 > 0.2f) {
                return false;
            }
            this.f1442I = C0239g.f1432y;
        } else {
            if (C0239g.f1432y != this.f1443J) {
                this.f1441H = 0.0f;
            }
            float f3 = this.f1441H + C0239g.f1422o;
            this.f1441H = f3;
            if (f3 > 0.2f) {
                return false;
            }
            this.f1443J = C0239g.f1432y;
        }
        int i2 = C0239g.f1430w > 0 ? 1 : -1;
        if (this.f1469x == 0) {
            this.f1469x = i2;
        }
        this.f1470y += this.f1469x > 0 ? C0239g.f1430w : -C0239g.f1430w;
        if (i2 != this.f1469x) {
            this.f1471z += i2 > 0 ? C0239g.f1430w : -C0239g.f1430w;
            if (this.f1471z > 60) {
                return false;
            }
        } else {
            this.f1471z = 0;
        }
        this.f1435B += this.f1467v;
        this.f1436C++;
        b bVar = this.f1464s[this.f1465t];
        GpsVal m1073d = C0239g.m1073d();
        bVar.f1477a = m1073d.f1972a;
        bVar.f1478b = m1073d.f1973b;
        bVar.f1479c = m1073d.f1974c;
        bVar.f1480d = this.f1467v;
        bVar.f1481e = C0239g.f1432y;
        bVar.f1482f = this.f1470y;
        int i3 = this.f1465t + 1;
        this.f1465t = i3;
        if (i3 >= 500) {
            this.f1465t = 0;
        }
        this.f1466u++;
        return true;
    }

    /* renamed from: f */
    private void m1088f() {
        int i2;
        int i3 = this.f1466u;
        float[] fArr = {0.0f, 0.0f, 0.0f, 0.0f};
        float[] fArr2 = {0.0f, 0.0f, 0.0f, 0.0f};
        float[] fArr3 = {0.0f, 0.0f, 0.0f, 0.0f};
        int[] iArr = {0, 0, 0, 0};
        for (int i4 = 0; i4 < 4; i4++) {
            float[] fArr4 = this.f1459n;
            float[] fArr5 = this.f1460o;
            float[] fArr6 = this.f1445L;
            this.f1461p[i4] = 0.0f;
            fArr6[i4] = 0.0f;
            fArr5[i4] = 0.0f;
            fArr4[i4] = 0.0f;
        }
        this.f1447b = 0;
        this.f1449d = 0.0f;
        this.f1450e = 999.0f;
        int i5 = this.f1465t - 1;
        int i6 = 0;
        int i7 = 9999;
        int i8 = 0;
        while (i3 > 0) {
            if (i5 < 0) {
                i5 += 500;
            }
            b bVar = this.f1464s[i5];
            if (bVar.f1479c > i6) {
                i6 = bVar.f1479c;
            }
            if (bVar.f1479c < i7) {
                i7 = bVar.f1479c;
            }
            int i9 = bVar.f1481e;
            fArr[i9] = fArr[i9] + bVar.f1477a;
            fArr2[i9] = fArr2[i9] + bVar.f1478b;
            fArr3[i9] = fArr3[i9] + bVar.f1480d;
            iArr[i9] = iArr[i9] + 1;
            float[] fArr7 = this.f1459n;
            fArr7[i9] = fArr7[i9] + bVar.f1477a;
            float[] fArr8 = this.f1460o;
            fArr8[i9] = fArr8[i9] + bVar.f1478b;
            float[] fArr9 = this.f1445L;
            fArr9[i9] = fArr9[i9] + 1.0f;
            float[] fArr10 = this.f1461p;
            fArr10[i9] = fArr10[i9] + bVar.f1480d;
            if (bVar.f1480d > this.f1449d) {
                this.f1449d = bVar.f1480d;
            }
            if (bVar.f1480d < this.f1450e) {
                this.f1450e = bVar.f1480d;
            }
            if (i8 != 0) {
                if (bVar.f1482f < i8) {
                    break;
                }
            } else {
                i8 = bVar.f1482f - 400;
            }
            i3--;
            this.f1447b++;
            i5--;
        }
        float f2 = 0.0f;
        this.f1453h = 0.0f;
        this.f1452g = 0.0f;
        this.f1451f = 0.0f;
        this.f1456k = 0.0f;
        this.f1455j = 0.0f;
        int i10 = 0;
        int i11 = 0;
        float f3 = 0.0f;
        while (i10 < 4) {
            float f4 = iArr[i10];
            if (f4 != f2) {
                float f5 = this.f1453h;
                float f6 = fArr3[i10] / f4;
                fArr3[i10] = f6;
                this.f1453h = f5 + f6;
                float f7 = this.f1451f;
                float f8 = fArr[i10] / f4;
                fArr[i10] = f8;
                this.f1451f = f7 + f8;
                float f9 = this.f1452g;
                float f10 = fArr2[i10] / f4;
                fArr2[i10] = f10;
                this.f1452g = f9 + f10;
                i11++;
            }
            float f11 = this.f1445L[i10];
            if (f11 != 0.0f) {
                float[] fArr11 = this.f1461p;
                float f12 = fArr11[i10] / f11;
                fArr11[i10] = f12;
                float f13 = f12 * f12;
                if (this.f1461p[i10] < 0.0f) {
                    f13 = -f13;
                }
                if (f13 < 0.0f) {
                    f13 = 0.0f;
                }
                float[] fArr12 = this.f1459n;
                fArr12[i10] = fArr12[i10] / f11;
                float[] fArr13 = this.f1460o;
                fArr13[i10] = fArr13[i10] / f11;
                this.f1455j += this.f1459n[i10] * f13;
                this.f1456k += this.f1460o[i10] * f13;
                f3 += f13;
            }
            i10++;
            f2 = 0.0f;
        }
        if (i11 < 3) {
            return;
        }
        this.f1448c = this.f1435B / this.f1436C;
        float min = Math.min(Math.abs(fArr[0] - fArr[2]), Math.abs(fArr[1] - fArr[3]));
        if (this.f1454i == 0.0f) {
            this.f1454i = min;
        } else {
            this.f1454i += (min - this.f1454i) / 6.0f;
        }
        if (i11 > 0) {
            float f14 = i11;
            this.f1451f /= f14;
            this.f1452g /= f14;
        }
        if (f3 > 0.0f) {
            this.f1455j /= f3;
            this.f1456k /= f3;
        }
        int i12 = this.f1470y / 360;
        if (i12 > this.f1446a) {
            boolean z = this.f1446a < this.f1444K && i12 >= this.f1444K;
            this.f1446a = i12;
            if (this.f1439F > 0) {
                a aVar = new a(this.f1437D / this.f1439F, this.f1438E / this.f1439F, (i7 + i6) / 2);
                this.f1458m.add(aVar);
                if (z && C0101l.f536U) {
                    ActivityMain.m413a(17);
                }
                if (this.f1446a == 3) {
                    C0101l.f568ar.m503a(aVar.f1472a, aVar.f1473b, (short) C0239g.f1426s);
                }
            }
            this.f1438E = 0.0f;
            this.f1437D = 0.0f;
            i2 = 0;
        } else {
            this.f1437D += this.f1455j;
            this.f1438E += this.f1456k;
            i2 = this.f1439F + 1;
        }
        this.f1439F = i2;
    }

    /* renamed from: a */
    public final b m1089a(int i2) {
        int i3 = this.f1434A;
        this.f1434A = i3 + 1;
        if (i3 >= this.f1466u) {
            return null;
        }
        int i4 = this.f1465t - this.f1434A;
        if (i4 < 0) {
            i4 += 500;
        }
        b bVar = this.f1464s[i4];
        int i5 = this.f1465t - 1;
        if (i5 < 0) {
            i5 += 500;
        }
        if (this.f1464s[i5].f1482f - bVar.f1482f > i2 * 360) {
            return null;
        }
        return bVar;
    }

    /* renamed from: a */
    public boolean m1090a() {
        this.f1467v = C0239g.f1417j;
        if (this.f1468w == 0) {
            if (C0239g.f1431x < 12 || this.f1467v < 0.0f) {
                return false;
            }
            m1091b();
        }
        if (m1087e()) {
            this.f1468w++;
            if (this.f1470y >= 360) {
                m1088f();
            }
        } else {
            m1091b();
        }
        return this.f1446a > 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m1091b() {
        this.f1465t = 0;
        this.f1470y = 0;
        this.f1471z = 0;
        this.f1466u = 0;
        this.f1468w = 0;
        this.f1469x = 0;
        this.f1441H = 0.0f;
        this.f1440G = 0.0f;
        this.f1443J = 0;
        this.f1442I = 0;
        this.f1446a = 0;
        this.f1434A = 0;
        this.f1458m.clear();
        this.f1438E = 0.0f;
        this.f1437D = 0.0f;
        this.f1439F = 0;
        this.f1435B = 0.0f;
        this.f1436C = 0;
        this.f1448c = 0.0f;
        this.f1444K = 2;
    }

    /* renamed from: c */
    public a m1092c() {
        int size = this.f1458m.size();
        a aVar = this.f1458m.get(size > 1 ? size - 2 : size - 1);
        float f2 = this.f1470y - aVar.f1475d;
        float f3 = (this.f1455j - aVar.f1472a) / f2;
        float f4 = (this.f1456k - aVar.f1473b) / f2;
        this.f1462q.f1472a = this.f1455j + (f3 * 90.0f);
        this.f1462q.f1473b = this.f1456k + (f4 * 90.0f);
        return this.f1462q;
    }

    /* renamed from: d */
    public void m1093d() {
        this.f1434A = 0;
    }
}
