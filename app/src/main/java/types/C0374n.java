package types;

/* renamed from: types.n */
/* loaded from: classes.dex */
public class C0374n {
    private static int r1 = 0;
    private static int r3 = 0;
    private static int r4 = 0;
    private static int r6 = 0;

    /* renamed from: a */
    public static float f2057a = 2.0f;

    /* renamed from: b */
    public static float f2058b = 4.0f;

    /* renamed from: d */
    public float f2060d;

    /* renamed from: e */
    public float f2061e;

    /* renamed from: f */
    public int f2062f;

    /* renamed from: g */
    public int f2063g;

    /* renamed from: h */
    public String f2064h;

    /* renamed from: i */
    public char f2065i;

    /* renamed from: k */
    private int f2067k;

    /* renamed from: l */
    private int f2068l;

    /* renamed from: c */
    String[] f2059c = new String[9];

    /* renamed from: j */
    private boolean f2066j = false;

    /* renamed from: a */
    public static int m1259a(String str, int i2, int i3) {
        char charAt;
        boolean z;
        int i4;
        int i5 = 0;
        if (str == null) {
            return 0;
        }
        char charAt2 = str.charAt(i2);
        if (charAt2 < '0' || charAt2 > '9') {
            boolean z2 = charAt2 == '-';
            if (!z2 || (i2 = i2 + 1) == i3 || (charAt = str.charAt(i2)) < '0' || charAt > '9') {
                return 0;
            }
            z = z2;
            charAt2 = charAt;
        } else {
            z = false;
        }
        while (true) {
            i4 = i5 + ('0' - charAt2);
            i2++;
            if (i2 == i3) {
                return z ? i4 : -i4;
            }
            charAt2 = str.charAt(i2);
            if (charAt2 < '0' || charAt2 > '9') {
                break;
            }
            i5 = i4 * 10;
        }
        return z ? i4 : -i4;
    }

    /* renamed from: a */
    public static String m1260a(float f2, float f3) {
        StringBuilder sb;
        StringBuilder sb2;
        int i2 = (int) (f2 / f2057a);
        int i3 = (int) (f3 / f2058b);
        StringBuilder sb3 = new StringBuilder();
        if (i2 < 0) {
            sb = new StringBuilder();
            sb.append("s");
            i2 = -i2;
        } else {
            sb = new StringBuilder();
            sb.append("n");
        }
        sb.append(i2);
        sb3.append(sb.toString());
        if (i3 < 0) {
            sb2 = new StringBuilder();
            sb2.append("w");
            i3 = -i3;
        } else {
            sb2 = new StringBuilder();
            sb2.append("e");
        }
        sb2.append(i3);
        sb3.append(sb2.toString());
        return sb3.toString();
    }

    /* renamed from: a */
    private static boolean m1261a(String str, String[] strArr) {
        int i2;
        if (str.length() < 8) {
            return false;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < 7; i4++) {
            if (str.charAt(i3) == ',') {
                i3++;
                strArr[i4] = "";
            } else {
                int length = str.length();
                if (i3 == -1) {
                    return false;
                }
                while (i3 < length) {
                    char charAt = str.charAt(i3);
                    if (charAt != ' ' && charAt != '\t') {
                        break;
                    }
                    i3++;
                }
                if (str.charAt(i3) == '\"') {
                    int i5 = i3 + 1;
                    int indexOf = str.indexOf(34, i5);
                    if (indexOf == -1) {
                        return false;
                    }
                    i2 = str.indexOf(44, indexOf);
                    if (i2 != -1) {
                        i2++;
                    }
                    strArr[i4] = str.substring(i5, indexOf);
                } else {
                    int indexOf2 = str.indexOf(44, i3);
                    if (indexOf2 == -1) {
                        if (i4 < 5) {
                            return false;
                        }
                        strArr[i4] = str.substring(i3);
                        return true;
                    }
                    i2 = indexOf2 + 1;
                    strArr[i4] = str.substring(i3, indexOf2);
                }
                i3 = i2;
            }
        }
        return true;
    }

    /* renamed from: b */
    private float m1262b(String str) {
        if (str.length() < 9) {
            return 0.0f;
        }
        float m1259a = m1259a(str, 0, 2);
        Double.isNaN(r1);
        Double.isNaN(r4);
        float f2 = m1259a + (((float) (r4 + (r1 / 1000.0d))) / 60.0f);
        return str.charAt(8) == 'S' ? f2 * (-1.0f) : f2;
    }

    /* renamed from: c */
    private float m1263c(String str) {
        float m1259a = m1259a(str, 0, 3);
        Double.isNaN(r6);
        Double.isNaN(r4);
        float f2 = m1259a + (((float) (r4 + (r6 / 1000.0d))) / 60.0f);
        return str.charAt(9) == 'W' ? f2 * (-1.0f) : f2;
    }

    /* renamed from: a */
    public int m1264a() {
        this.f2067k = (this.f2067k * 1103515245) + 12345;
        return this.f2067k % (this.f2068l + 100000);
    }

    /* renamed from: a */
    public void m1265a(int i2) {
        this.f2067k = 1103515244;
        this.f2068l = i2;
    }

    /* renamed from: a */
    public boolean m1266a(String str) {
        int m1259a = 0;
        if (str.charAt(0) == '#') {
            char charAt = str.charAt(1);
            if (charAt == '+') {
                this.f2066j = true;
                m1265a(m1259a(str, 2, str.length()));
            } else if (charAt == '-') {
                this.f2066j = false;
            } else {
                this.f2065i = charAt;
            }
            return false;
        }
        this.f2064h = "";
        this.f2062f = 0;
        int indexOf = str.indexOf(124);
        this.f2060d = m1259a(str, 0, indexOf);
        int indexOf2 = str.indexOf(124, indexOf + 1);
        if (indexOf2 == -1) {
            this.f2061e = m1259a(str, r3, str.length());
        } else {
            this.f2061e = m1259a(str, r3, indexOf2);
            if (this.f2065i != 't') {
                int i2 = indexOf2 + 1;
                int indexOf3 = str.indexOf(124, i2);
                if (indexOf3 == -1) {
                    this.f2064h = str.substring(i2);
                } else {
                    this.f2064h = str.substring(i2, indexOf3);
                    m1259a = m1259a(str, indexOf3 + 1, str.length());
                }
            } else {
                m1259a = m1259a(str, indexOf2 + 1, str.length());
            }
            this.f2062f = m1259a;
        }
        if (this.f2066j) {
            this.f2060d -= m1264a();
            this.f2061e -= m1264a();
        }
        float f2 = this.f2065i == 'c' ? 1000.0f : 10000.0f;
        this.f2060d /= f2;
        this.f2061e /= f2;
        return true;
    }

    /* renamed from: a */
    public boolean m1267a(String str, char c2) {
        if (!m1261a(str, this.f2059c)) {
            return false;
        }
        this.f2065i = c2;
        this.f2064h = c2 == 't' ? "" : this.f2059c[0];
        this.f2060d = m1262b(this.f2059c[3]);
        this.f2061e = m1263c(this.f2059c[4]);
        String str2 = this.f2059c[5];
        if (str2.length() > 1) {
            int indexOf = str2.indexOf(46);
            if (indexOf == -1) {
                indexOf = str2.length();
            }
            this.f2062f = m1259a(str2, 0, indexOf);
            char charAt = str2.charAt(str2.length() - 1);
            if (charAt != 'm' && charAt != 'M' && charAt != ',') {
                double d2 = this.f2062f;
                Double.isNaN(d2);
                this.f2062f = (int) (d2 * 0.3048d);
            }
        } else {
            this.f2062f = 0;
        }
        return true;
    }
}
