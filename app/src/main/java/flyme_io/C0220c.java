package flyme_io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.zip.CRC32;

/* renamed from: i.c */
/* loaded from: classes.dex */
public class C0220c {
    private static double r9 = 0;
    private static double r11 = 0;
    private static Throwable e;
    private static Throwable th;

    /* renamed from: a */
    public long f1211a;

    /* renamed from: b */
    public float f1212b;

    /* renamed from: c */
    public float f1213c;

    /* renamed from: d */
    public float f1214d;

    /* renamed from: e */
    public float f1215e;

    /* renamed from: f */
    public long f1216f;

    /* renamed from: g */
    public int f1217g;

    /* renamed from: h */
    public float f1218h;

    /* renamed from: i */
    public float f1219i;

    /* renamed from: j */
    public short f1220j;

    /* renamed from: k */
    public int f1221k;

    /* renamed from: l */
    public int f1222l;

    /* renamed from: m */
    public String f1223m;

    /* renamed from: n */
    C0213a f1224n;

    /* renamed from: o */
    BufferedReader f1225o;

    /* renamed from: p */
    long f1226p;

    /* renamed from: q */
    CRC32 f1227q;

    /* renamed from: r */
    private int f1228r;

    /* renamed from: s */
    private int f1229s;

    /* renamed from: t */
    private int f1230t;

    /* renamed from: u */
    private int f1231u;

    /* renamed from: v */
    private short f1232v;

    public C0220c(String str) {
        this.f1211a = 0L;
        this.f1228r = 0;
        this.f1229s = 0;
        this.f1230t = 0;
        this.f1231u = 9999;
        this.f1232v = (short) 0;
        this.f1212b = 999.0f;
        this.f1213c = -999.0f;
        this.f1214d = 999.0f;
        this.f1215e = -999.0f;
        this.f1221k = 0;
        this.f1222l = 0;
        this.f1224n = null;
        this.f1225o = null;
        this.f1227q = null;
        m946a(str, 0L);
    }

    public C0220c(String str, long j2) {
        this.f1211a = 0L;
        this.f1228r = 0;
        this.f1229s = 0;
        this.f1230t = 0;
        this.f1231u = 9999;
        this.f1232v = (short) 0;
        this.f1212b = 999.0f;
        this.f1213c = -999.0f;
        this.f1214d = 999.0f;
        this.f1215e = -999.0f;
        this.f1221k = 0;
        this.f1222l = 0;
        this.f1224n = null;
        this.f1225o = null;
        this.f1227q = null;
        m946a(str, j2);
    }

    public C0220c(String str, long j2, CRC32 crc32) {
        this.f1211a = 0L;
        this.f1228r = 0;
        this.f1229s = 0;
        this.f1230t = 0;
        this.f1231u = 9999;
        this.f1232v = (short) 0;
        this.f1212b = 999.0f;
        this.f1213c = -999.0f;
        this.f1214d = 999.0f;
        this.f1215e = -999.0f;
        this.f1221k = 0;
        this.f1222l = 0;
        this.f1224n = null;
        this.f1225o = null;
        this.f1227q = null;
        this.f1227q = crc32;
        m946a(str, j2);
    }

    public C0220c(String str, long j2, CRC32 crc32, C0213a c0213a) {
        this.f1211a = 0L;
        this.f1228r = 0;
        this.f1229s = 0;
        this.f1230t = 0;
        this.f1231u = 9999;
        this.f1232v = (short) 0;
        this.f1212b = 999.0f;
        this.f1213c = -999.0f;
        this.f1214d = 999.0f;
        this.f1215e = -999.0f;
        this.f1221k = 0;
        this.f1222l = 0;
        this.f1224n = null;
        this.f1225o = null;
        this.f1227q = null;
        this.f1227q = crc32;
        this.f1224n = c0213a;
        m946a(str, j2);
    }

    /* renamed from: a */
    public static int m944a(String str, int i2, int i3) {
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
    public static String m945a(int i2, int i3, int i4) {
        String str = "" + i2;
        if (i3 < 10) {
            str = str + "0";
        }
        String str2 = str + i3;
        if (i4 < 10) {
            str2 = str2 + "0";
        }
        return str2 + i4;
    }

    /* renamed from: a */
    private void m946a(String str, long j2) {
        String readLine;
        this.f1226p = j2;
        try {
            this.f1225o = new BufferedReader(new FileReader(str));
            while (true) {
                readLine = this.f1225o.readLine();
                if (readLine == null) {
                    return;
                }
                if (this.f1227q != null) {
                    this.f1227q.update((readLine + "\n").getBytes());
                }
                if (readLine.startsWith("HFDTE") || readLine.startsWith("HPDTE")) {
                    break;
                } else if (this.f1224n != null) {
                    this.f1224n.m900a(readLine);
                }
            }
            m948a(readLine.substring(5));
        } catch (IOException unused) {
        }
    }

    /* renamed from: a */
    public void m947a() {
        if (this.f1225o != null) {
            try {
                this.f1225o.close();
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: a */
    public void m948a(String str) {
        int parseInt = Integer.parseInt(str.substring(4));
        int i2 = parseInt + (parseInt < 60 ? 2000 : 1900);
        int m944a = m944a(str, 2, 4);
        int m944a2 = m944a(str, 0, 2);
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.clear();
        calendar.set(i2, m944a - 1, m944a2);
        this.f1211a = calendar.getTimeInMillis();
        this.f1223m = m945a(i2, m944a, m944a2);
        if (this.f1224n != null) {
            this.f1224n.f1145h = this.f1211a;
        }
    }

    /* renamed from: b */
    public boolean m949b() {
        if (this.f1225o == null) {
            return false;
        }
        try {
            boolean z = this.f1224n != null;
            while (true) {
                String readLine = this.f1225o.readLine();
                if (readLine == null) {
                    break;
                }
                if (readLine.length() > 0) {
                    if (this.f1227q != null && readLine.charAt(0) != 'G') {
                        this.f1227q.update((readLine + "\n").getBytes());
                    }
                    if (readLine.charAt(0) == 'B') {
                        if (m950b(readLine)) {
                            return true;
                        }
                    } else if (z) {
                        z = this.f1224n.m900a(readLine);
                    }
                }
            }
        } catch (IOException unused) {
        }
        return false;
    }

    /* renamed from: b */
    public boolean m950b(String str) {
        try {
            if (str.length() < 23 || str.charAt(0) != 'B') {
                return false;
            }
            this.f1217g = (m944a(str, 1, 3) * 3600) + (m944a(str, 3, 5) * 60) + m944a(str, 5, 7) + (this.f1228r * 60 * 60);
            long j2 = this.f1211a + (this.f1217g * 1000);
            if (j2 - this.f1216f < this.f1226p) {
                return false;
            }
            this.f1216f = j2;
            if (this.f1221k == 0) {
                this.f1221k = this.f1217g;
            }
            this.f1222l = this.f1217g;
            float m944a = m944a(str, 7, 9);
            Double.isNaN(r11);
            Double.isNaN(r9);
            this.f1218h = m944a + (((float) (r9 + (r11 / 1000.0d))) / 60.0f);
            if (str.charAt(14) == 'S') {
                this.f1218h *= -1.0f;
            }
            if (this.f1218h < this.f1212b) {
                this.f1212b = this.f1218h;
            }
            if (this.f1218h > this.f1213c) {
                this.f1213c = this.f1218h;
            }
            float m944a2 = m944a(str, 15, 18);
            Double.isNaN(r9);
            Double.isNaN(r11);
            this.f1219i = m944a2 + (((float) (r11 + (r9 / 1000.0d))) / 60.0f);
            if (str.charAt(23) == 'W') {
                this.f1219i *= -1.0f;
            }
            if (this.f1219i < this.f1214d) {
                this.f1214d = this.f1219i;
            }
            if (this.f1219i > this.f1215e) {
                this.f1215e = this.f1219i;
            }
            if (str.length() < 25) {
                return true;
            }
            char charAt = str.charAt(24);
            if (charAt == 'A' || charAt == 'V') {
                int m944a3 = str.length() > 30 ? m944a(str, 25, 30) : 0;
                int m944a4 = (str.length() <= 30 || str.length() < 35) ? 0 : m944a(str, 30, 35);
                int abs = Math.abs(m944a3 - this.f1229s);
                int abs2 = Math.abs(m944a4 - this.f1230t);
                if (abs - abs2 > 20 && m944a3 != 0 && m944a4 != 0) {
                    if (abs > abs2) {
                        m944a3 = 0;
                    } else {
                        m944a4 = 0;
                    }
                }
                if (m944a3 == 0) {
                    short s = (short) m944a4;
                    this.f1220j = s;
                    this.f1230t = s;
                } else {
                    if (m944a4 != 0) {
                        int i2 = m944a4 - m944a3;
                        if (this.f1231u < 9999) {
                            i2 = (i2 + this.f1231u) / 4;
                        }
                        this.f1231u = i2;
                        this.f1230t = m944a4;
                    }
                    this.f1220j = (short) m944a3;
                    if (this.f1231u < 9999) {
                        this.f1220j = (short) (this.f1220j + this.f1231u);
                    }
                    this.f1229s = m944a3;
                }
                if (this.f1220j <= 0) {
                    this.f1220j = this.f1232v;
                } else {
                    this.f1232v = this.f1220j;
                }
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: c */
    public int m951c() {
        return this.f1222l - this.f1221k;
    }
}
