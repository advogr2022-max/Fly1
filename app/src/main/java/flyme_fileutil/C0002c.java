package flyme_fileutil;

import com.xcglobe.xclog.C0101l;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;
import types.C0369i;
import types.C0378r;
import types.GpsVal;

/* renamed from: a.c */
/* loaded from: classes.dex */
public class C0002c {
    private static Throwable th;
    // private static int r1 = 0;
    private static Throwable e;

    /* renamed from: g */
    private static float f19g = 0.3f;

    /* renamed from: h */
    private static float f20h = 1.852f;

    /* renamed from: i */
    private static float f21i = 16.0f;

    /* renamed from: j */
    private static int f22j;

    /* renamed from: a */
    int f23a = 1000;

    /* renamed from: b */
    ArrayList<C0001b> f24b = new ArrayList<>();

    /* renamed from: c */
    ArrayList<GpsVal> f25c = new ArrayList<>();

    /* renamed from: d */
    GpsVal f26d = new GpsVal();

    /* renamed from: e */
    int f27e = 1;

    /* renamed from: f */
    String f28f;

    /* renamed from: a */
    static float m6a(GpsVal gpsVal, GpsVal gpsVal2) {
        double atan2 = (float) Math.atan2((gpsVal2.f1972a - gpsVal.f1972a) * C0369i.m1247b(gpsVal.f1972a), -(gpsVal2.f1973b - gpsVal.f1973b));
        Double.isNaN(atan2);
        float f2 = (float) (atan2 - 1.5707963267948966d);
        if (f2 >= 0.0f) {
            return f2;
        }
        double d2 = f2;
        Double.isNaN(d2);
        return (float) (d2 + 6.283185307179586d);
    }

    /* renamed from: h */
    private int m7h(String str) {
        String upperCase = str.toUpperCase(Locale.getDefault());
        boolean contains = upperCase.contains("AGL");
        int i2 = 0;
        if (upperCase.startsWith("FL")) {
            new C0378r(upperCase).m1300b(2);
            // i2 = ...;
        } else if (!upperCase.startsWith("SFC") && !upperCase.startsWith("GND")) {
            if (upperCase.startsWith("UNLIM")) {
                i2 = 9999;
            } else {
                C0378r c0378r = new C0378r(upperCase);
                String m1295a = c0378r.m1295a();
                if (m1295a.length() == 0) {
                    return 0;
                }
                i2 = Integer.parseInt(m1295a);
                String replace = upperCase.substring(c0378r.f2106d).replace("MSL", "");
                if (replace.contains("FT") || (!replace.startsWith("M") && !replace.startsWith(" M"))) {
                    i2 = ((((int) (i2 * f19g)) + 5) / 10) * 10;
                }
            }
        }
        return contains ? -i2 : i2;
    }

    /* renamed from: i */
    private void m8i(String str) throws Exception {
        throw new Exception(str);
    }

    /* renamed from: j */
    private void m9j(String str) {
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0059 A[Catch: IOException -> 0x00a1, all -> 0x00a4, TryCatch #0 {all -> 0x00a4, blocks: (B:5:0x002b, B:8:0x002f, B:10:0x0036, B:16:0x0059, B:18:0x005d, B:20:0x0063, B:22:0x0067, B:24:0x006c, B:25:0x0071, B:28:0x007f, B:36:0x0048, B:41:0x0089, B:43:0x008f, B:45:0x0093, B:47:0x0098), top: B:4:0x002b }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public ArrayList<C0001b> m10a(String str) {
        BufferedReader bufferedReader;
        int i2 = 0;
        boolean startsWith;
        BufferedReader bufferedReader2 = null;
        try {
            try {
                this.f28f = new File(str).getName();
                m9j("Parsing OpenAir: " + str);
                bufferedReader = new BufferedReader(new FileReader(str));
                try {
                    try {
                        f22j = 0;
                        C0001b c0001b = null;
                        i2 = 0;
                        while (true) {
                            try {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                f22j++;
                                if (this.f25c.size() <= 0 && c0001b != null) {
                                    startsWith = false;
                                    if (startsWith) {
                                        i2++;
                                        if (c0001b != null && m18b(c0001b) && c0001b.f5b != null && c0001b.f5b.length > 1) {
                                            this.f24b.add(c0001b);
                                        }
                                        c0001b = new C0001b();
                                        this.f27e = 1;
                                        this.f25c.clear();
                                    }
                                    if (c0001b != null && !m14a(readLine, c0001b)) {
                                        c0001b = null;
                                    }
                                }
                                startsWith = readLine.startsWith("AC ");
                                if (readLine.startsWith("AN ")) {
                                    startsWith = true;
                                }
                                if (startsWith) {
                                }
                                if (c0001b != null) {
                                    c0001b = null;
                                }
                            } catch (IOException e2) {
                                e = e2;
                                bufferedReader2 = bufferedReader;
                                e.printStackTrace();
                                bufferedReader2.close();
                                m9j("  " + i2 + " / " + this.f24b.size());
                                return this.f24b;
                            }
                        }
                        if (c0001b != null && m18b(c0001b) && c0001b.f5b != null && c0001b.f5b.length > 1) {
                            this.f24b.add(c0001b);
                        }
                        bufferedReader.close();
                    } catch (Throwable th) {
                        th = th;
                        bufferedReader.close();
                        throw th;
                    }
                } catch (IOException e3) {
                    e = e3;
                    bufferedReader2 = bufferedReader;
                    i2 = 0;
                    e.printStackTrace();
                    bufferedReader2.close();
                    m9j("  " + i2 + " / " + this.f24b.size());
                    return this.f24b;
                }
            } catch (Throwable th2) {
                th = th2;
                bufferedReader = bufferedReader2;
            }
        } catch (Exception e4) {
            e = e4;
        }
        m9j("  " + i2 + " / " + this.f24b.size());
        return this.f24b;
    }

    /* renamed from: a */
    void m11a(float f2, float f3, float f4, float f5) {
        boolean z;
        float f6;
        float f7 = this.f27e;
        float f8 = f3 - f2;
        float f9 = 0.0f;
        if (f8 < 0.0f) {
            double d2 = f8;
            Double.isNaN(d2);
            f8 = (float) (d2 + 6.283185307179586d);
        }
        if (this.f27e < 0) {
            double d3 = f8;
            Double.isNaN(d3);
            f8 = (float) (6.283185307179586d - d3);
        }
        boolean z2 = false;
        float f10 = 0.0f;
        while (!z2) {
            float f11 = f2 + f10;
            if (Math.abs(f10) >= f8) {
                f11 = f3;
                f6 = f4;
                z = true;
            } else {
                z = z2;
                f6 = f4;
            }
            double d4 = f6;
            double d5 = f11 + f9;
            double sin = Math.sin(d5);
            Double.isNaN(d4);
            float f12 = (float) (d4 * sin);
            double d6 = f5;
            double cos = Math.cos(d5);
            Double.isNaN(d6);
            GpsVal gpsVal = new GpsVal();
            gpsVal.f1972a = this.f26d.f1972a + ((float) (d6 * cos));
            gpsVal.f1973b = this.f26d.f1973b + f12;
            this.f25c.add(gpsVal);
            double d7 = f10;
            double d8 = f7;
            Double.isNaN(d8);
            double d9 = f21i;
            Double.isNaN(d9);
            Double.isNaN(d7);
            f10 = (float) (d7 + ((d8 * 3.141592653589793d) / d9));
            z2 = z;
            f9 = 0.0f;
        }
    }

    /* renamed from: a */
    void m12a(C0001b c0001b) {
        String str = c0001b.f18o;
        char c2 = '0';
        if (str.length() == 1) {
            char charAt = str.charAt(0);
            if ("RQPABCDEFGW".indexOf(charAt) != -1) {
                c2 = charAt;
            }
        } else if (str.contains("GP")) {
            c2 = '1';
        } else if (str.contains("CTR")) {
            c2 = '2';
            if (!c0001b.f4a.contains("CTR")) {
                c0001b.f4a = "CTR " + c0001b.f4a;
            }
        }
        c0001b.f10g = c2;
    }

    /* renamed from: a */
    void m13a(String str, float[] fArr) {
        float m573i = C0101l.m573i(new C0378r(str).m1295a()) * f20h;
        float m1248b = m573i / C0369i.m1248b(this.f26d.f1972a, this.f26d.f1973b, this.f26d.f1972a, this.f26d.f1973b + 1.0f);
        float m1248b2 = m573i / C0369i.m1248b(this.f26d.f1972a, this.f26d.f1973b, this.f26d.f1972a + 1.0f, this.f26d.f1973b);
        fArr[0] = m1248b;
        fArr[1] = m1248b2;
    }

    /* renamed from: a */
    boolean m14a(String str, C0001b c0001b) {
        try {
            if (str.startsWith("AN ")) {
                c0001b.f4a = str.substring(3);
                return true;
            }
            if (str.startsWith("AC ")) {
                c0001b.f18o = str.substring(3).trim();
                return true;
            }
            if (str.startsWith("AL ")) {
                c0001b.f15l = m7h(str.substring(3));
                return true;
            }
            if (str.startsWith("AH ")) {
                c0001b.f16m = m7h(str.substring(3));
                return true;
            }
            if (str.startsWith("DP ")) {
                m22f(str.substring(3));
                return true;
            }
            if (str.startsWith("V ")) {
                m21e(str.substring(2));
                return true;
            }
            if (str.startsWith("DC ")) {
                m20d(str.substring(3));
                return true;
            }
            if (str.startsWith("DA ")) {
                m17b(str.substring(3));
                return true;
            }
            if (!str.startsWith("DB ")) {
                return true;
            }
            m19c(str.substring(3));
            return true;
        } catch (Exception unused) {
            m9j("Error parsing #" + c0001b.f4a + " (line " + f22j + ")");
            return false;
        }
    }

    /* renamed from: a */
    String[] m15a(String str, int[] iArr) {
        char charAt;
        int length = str.length();
        int i2 = 0;
        while (i2 < length && ((charAt = str.charAt(i2)) == ' ' || charAt == ',')) {
            i2++;
        }
        int i3 = i2;
        int i4 = 0;
        while (true) {
            if (i3 < length) {
                char charAt2 = str.charAt(i3);
                if (charAt2 == 'N' || charAt2 == 'S') {
                    i4 = i3;
                }
                if (charAt2 == 'E' || charAt2 == 'W') {
                    break;
                }
                i3++;
            } else {
                i3 = 0;
                break;
            }
        }
        if (i4 == 0 || i3 == 0 || i3 < i4) {
            return null;
        }
        String[] strArr = new String[4];
        strArr[0] = str.substring(i2, i4).trim();
        int i5 = i4 + 1;
        strArr[1] = str.substring(i4, i5);
        while (true) {
            char charAt3 = str.charAt(i5);
            if (charAt3 != ' ' && charAt3 != ',') {
                break;
            }
            i5++;
        }
        strArr[2] = str.substring(i5, i3);
        int i6 = i3 + 1;
        strArr[3] = str.substring(i3, i6).trim();
        if (iArr != null) {
            iArr[0] = i6;
        }
        return strArr;
    }

    /* renamed from: b */
    GpsVal m16b(String str, int[] iArr) {
        String[] m15a = m15a(str, iArr);
        if (m15a == null) {
            return null;
        }
        String[] split = m15a[0].split(":");
        float parseInt = Integer.parseInt(m23g(split[0]));
        float m573i = C0101l.m573i(m23g(split[1]));
        float m573i2 = split.length > 2 ? (((C0101l.m573i(m23g(split[2])) / 60.0f) + m573i) / 60.0f) + parseInt : (m573i / 60.0f) + parseInt;
        if (m15a[1].equals("S")) {
            m573i2 = -m573i2;
        }
        String[] split2 = m15a[2].split(":");
        float parseInt2 = Integer.parseInt(m23g(split2[0]));
        float m573i3 = C0101l.m573i(m23g(split2[1]));
        float m573i4 = split2.length > 2 ? (((C0101l.m573i(m23g(split2[2])) / 60.0f) + m573i3) / 60.0f) + parseInt2 : (m573i3 / 60.0f) + parseInt2;
        if (m15a[3].equals("W")) {
            m573i4 = -m573i4;
        }
        GpsVal gpsVal = new GpsVal();
        gpsVal.f1972a = m573i2;
        gpsVal.f1973b = m573i4;
        return gpsVal;
    }

    /* renamed from: b */
    void m17b(String str) {
        String[] split = str.split(",");
        if (split.length < 3) {
            try { m8i("Error parsing arc " + str); } catch (Exception e) { }
        }
        float[] fArr = {0.0f, 0.0f};
        m13a(m23g(split[0].trim()), fArr);
        m11a((float) Math.toRadians(C0378r.m1294e(split[1])), (float) Math.toRadians(C0378r.m1294e(split[2])), fArr[0], fArr[1]);
    }

    /* renamed from: b */
    boolean m18b(C0001b c0001b) {
        int size = this.f25c.size();
        if (size < 3 || c0001b.f18o == null || c0001b.f4a == null) {
            return false;
        }
        c0001b.f7d = c0001b.f15l;
        if (c0001b.f15l < 0) {
            c0001b.f7d = -c0001b.f15l;
            c0001b.f8e = true;
        }
        if (c0001b.f7d >= 3600) {
            return false;
        }
        m12a(c0001b);
        c0001b.f5b = new int[size];
        c0001b.f6c = new int[size];
        int i2 = 0;
        for (int i3 = 0; i3 < this.f25c.size(); i3++) {
            GpsVal gpsVal = this.f25c.get(i3);
            c0001b.f5b[i3] = (int) (gpsVal.f1972a * this.f23a);
            c0001b.f6c[i3] = (int) (gpsVal.f1973b * this.f23a);
            c0001b.f9f.m1224a(gpsVal.f1972a, gpsVal.f1973b);
            i2 += c0001b.f6c[i3] + c0001b.f5b[i3];
        }
        this.f25c.clear();
        c0001b.f12i = (c0001b.f4a + "-" + c0001b.f5b.length + "-" + i2).hashCode();
        return true;
    }

    /* renamed from: c */
    void m19c(String str) {
        int[] iArr = {0};
        GpsVal m16b = m16b(str, iArr);
        GpsVal m16b2 = m16b(str.substring(iArr[0]), null);
        float m6a = m6a(this.f26d, m16b);
        float m6a2 = m6a(this.f26d, m16b2);
        float m1249b = C0369i.m1249b(this.f26d, m16b);
        m11a(m6a, m6a2, m1249b / C0369i.m1248b(this.f26d.f1972a, this.f26d.f1973b, this.f26d.f1972a, this.f26d.f1973b + 1.0f), m1249b / C0369i.m1248b(this.f26d.f1972a, this.f26d.f1973b, this.f26d.f1972a + 1.0f, this.f26d.f1973b));
    }

    /* renamed from: d */
    void m20d(String str) {
        float[] fArr = {0.0f, 0.0f};
        m13a(str, fArr);
        float f2 = 0.0f;
        while (true) {
            double d2 = f2;
            if (d2 >= 6.283185307179586d) {
                return;
            }
            double d3 = fArr[0];
            double sin = Math.sin(d2);
            Double.isNaN(d3);
            float f3 = (float) (d3 * sin);
            double d4 = fArr[1];
            double cos = Math.cos(d2);
            Double.isNaN(d4);
            GpsVal gpsVal = new GpsVal();
            gpsVal.f1972a = this.f26d.f1972a + ((float) (d4 * cos));
            gpsVal.f1973b = this.f26d.f1973b + f3;
            this.f25c.add(gpsVal);
            double d5 = f21i;
            Double.isNaN(d5);
            Double.isNaN(d2);
            f2 = (float) (d2 + (3.141592653589793d / d5));
        }
    }

    /* renamed from: e */
    void m21e(String str) {
        int i2 = 0;
        int i3 = 0;
        while (str.charAt(i3) == ' ') {
            i3++;
        }
        if (str.startsWith("X=", i3)) {
            GpsVal m16b = m16b(str.substring(i3 + 2), null);
            if (m16b != null) {
                this.f26d.m1169a(m16b);
                return;
            }
            return;
        }
        if (str.startsWith("D=")) {
            String trim = str.substring(2).trim();
            if (trim.startsWith("-")) {
                i2 = -1;
            } else if (!trim.startsWith("+")) {
                return;
            } else {
                i2 = 1;
            }
            this.f27e = i2;
        }
    }

    /* renamed from: f */
    void m22f(String str) {
        GpsVal m16b = m16b(str, null);
        if (m16b != null) {
            this.f25c.add(m16b);
        }
    }

    /* renamed from: g */
    String m23g(String str) {
        int length = str.length();
        int i2 = 0;
        do {
            char charAt = str.charAt(i2);
            if (charAt != '0' && charAt != ' ') {
                return str.substring(i2);
            }
            i2++;
        } while (i2 != length);
        return "0";
    }
}
