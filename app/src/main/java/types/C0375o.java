package types;

import java.util.ArrayList;

/* renamed from: types.o */
/* loaded from: classes.dex */
public class C0375o {

    /* renamed from: a */
    static final float[] f2069a = {48.0f, 70.0f, -16.0f, 12.0f, 48.0f, 70.0f, 12.0f, 36.0f, 34.0f, 48.0f, 12.0f, 36.0f, 34.0f, 48.0f, -16.0f, 12.0f, -40.0f, -24.0f, 140.0f, 154.0f, -48.0f, -32.0f, 164.0f, 180.0f, -35.0f, 0.0f, 8.0f, 44.0f, -40.0f, 12.0f, -56.0f, -32.0f, -40.0f, 12.0f, -84.0f, -56.0f, 28.0f, 56.0f, -128.0f, -104.0f, 24.0f, 32.0f, 72.0f, 96.0f, 32.0f, 52.0f, 36.0f, 92.0f, 32.0f, 52.0f, 92.0f, 144.0f, -10.0f, 32.0f, 92.0f, 144.0f, -10.0f, 32.0f, 36.0f, 92.0f, 4.0f, 28.0f, -116.0f, -74.0f, 24.0f, 34.0f, -15.0f, 34.0f, 24.0f, 52.0f, -104.0f, -52.0f, 60.0f, 68.0f, -28.0f, -12.0f};

    /* renamed from: a */
    public static int m1268a() {
        return f2069a.length / 4;
    }

    /* renamed from: a */
    public static ArrayList<String> m1269a(float f2, float f3, float f4, float f5) {
        ArrayList<String> arrayList = new ArrayList<>();
        float f6 = C0374n.f2057a;
        float f7 = C0374n.f2058b;
        if (f2 < 0.0f) {
            f2 -= f6;
        }
        if (f3 < 0.0f) {
            f3 -= f7;
        }
        float f8 = ((int) (f2 / C0374n.f2057a)) * C0374n.f2057a;
        for (float f9 = ((int) (f3 / C0374n.f2058b)) * C0374n.f2058b; f9 < f5; f9 += f7) {
            for (float f10 = f8; f10 < f4; f10 += f6) {
                arrayList.add(C0374n.m1260a(f10, f9));
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    public static ArrayList<String> m1270a(int i2) {
        int i3 = (i2 - 1) * 4;
        int i4 = i3 + 1;
        int i5 = i4 + 1;
        return m1269a(f2069a[i3], f2069a[i5], f2069a[i4], f2069a[i5 + 1]);
    }

    /* renamed from: a */
    public static ArrayList<String> m1271a(C0367g c0367g) {
        return m1269a(c0367g.f2012a, c0367g.f2014c, c0367g.f2013b, c0367g.f2015d);
    }

    /* renamed from: a */
    public static C0367g m1272a(String str) {
        int length = str.length();
        int i2 = 1;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i2++;
        }
        if (i2 >= length - 1) {
            return null;
        }
        int m1259a = C0374n.m1259a(str, 1, i2);
        int m1259a2 = C0374n.m1259a(str, i2 + 1, length);
        if (str.charAt(0) == 's') {
            m1259a = -m1259a;
        }
        if (str.charAt(i2) == 'w') {
            m1259a2 = -m1259a2;
        }
        float f2 = C0374n.f2057a * m1259a;
        float f3 = C0374n.f2058b * m1259a2;
        C0367g c0367g = new C0367g();
        c0367g.m1224a(f2, f3);
        c0367g.m1224a(f2 + C0374n.f2057a, f3 + C0374n.f2058b);
        return c0367g;
    }

    /* renamed from: b */
    public static ArrayList<Integer> m1273b(C0367g c0367g) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int m1268a = m1268a();
        for (int i2 = 1; i2 <= m1268a; i2++) {
            if (m1274b(i2).m1234c(c0367g)) {
                arrayList.add(Integer.valueOf(i2));
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    public static C0367g m1274b(int i2) {
        int i3 = (i2 - 1) * 4;
        int i4 = i3 + 1;
        int i5 = i4 + 1;
        return new C0367g(f2069a[i3], f2069a[i5], f2069a[i4], f2069a[i5 + 1]);
    }
}
