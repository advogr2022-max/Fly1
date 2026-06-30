package flyme_data;

import android.os.Bundle;
import com.xcglobe.xclog.ActivityMain;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0098i;
import com.xcglobe.xclog.C0099j;
import com.xcglobe.xclog.C0101l;
import com.xcglobe.xclog.FlyMeService;
import java.util.ArrayList;
import java.util.zip.CRC32;
import flyme_tasks.C0062c;
import flyme_apphelper.C0072a;
import flyme_apphelper.C0074c;
import flyme_device.C0172d;
import flyme_device.C0173e;
import flyme_collection.C0192a;
import flyme_misc.C0203a;
import flyme_misc.C0206d;
import flyme_misc.C0209g;
import flyme_misc.C0210h;
import flyme_misc.InterfaceC0204b;
import flyme_util1.C0211a;
import flyme_io.C0220c;
import flyme_io.C0221d;
import flyme_io.C0222e;
import flyme_io.flyme_io_b.C0219b;
import flyme_intentutil.C0225a;
import flyme_poi.C0227a;
import types.C0366f;
import types.C0367g;
import types.C0369i;
import types.C0370j;
import types.GpsVal;
import vmaps.C0391d;

/* renamed from: m.g */
/* loaded from: classes.dex */
public class C0239g {
    private static int r2 = 0;

    /* renamed from: C */
    public static C0240h f1372C;

    /* renamed from: D */
    protected static C0221d f1373D;

    /* renamed from: E */
    public static long f1374E;

    /* renamed from: J */
    public static int f1379J;

    /* renamed from: K */
    public static int f1380K;

    /* renamed from: O */
    public static C0173e f1384O;

    /* renamed from: P */
    public static C0203a f1385P;

    /* renamed from: R */
    static C0206d f1387R;

    /* renamed from: Z */
    private static boolean f1395Z;

    /* renamed from: aa */
    private static long f1397aa;

    /* renamed from: ab */
    private static long f1398ab;

    /* renamed from: ac */
    private static GpsVal f1399ac;

    /* renamed from: ad */
    private static long f1400ad;

    /* renamed from: ae */
    private static long f1401ae;

    /* renamed from: af */
    private static C0210h f1402af;

    /* renamed from: b */
    public static float f1409b;

    /* renamed from: c */
    public static float f1410c;

    /* renamed from: d */
    public static int f1411d;

    /* renamed from: f */
    public static C0367g f1413f;

    /* renamed from: g */
    public static ArrayList<GpsVal> f1414g;

    /* renamed from: i */
    public static volatile float f1416i;

    /* renamed from: j */
    public static float f1417j;

    /* renamed from: k */
    public static float f1418k;

    /* renamed from: m */
    public static int f1420m;

    /* renamed from: n */
    public static float f1421n;

    /* renamed from: q */
    public static long f1424q;

    /* renamed from: r */
    public static long f1425r;

    /* renamed from: s */
    public static int f1426s;

    /* renamed from: t */
    public static float f1427t;

    /* renamed from: u */
    public static int f1428u;

    /* renamed from: v */
    public static int f1429v;

    /* renamed from: w */
    public static int f1430w;

    /* renamed from: x */
    public static int f1431x;

    /* renamed from: y */
    public static int f1432y;

    /* renamed from: a */
    public static final int[] f1396a = {8, 4, 4000, 15, 5, 3000, 3, 1, 10000, 40, 7, 4000};

    /* renamed from: e */
    public static long f1412e = 3000;

    /* renamed from: h */
    public static final C0192a<C0370j> f1415h = new C0192a<>(500, new C0370j());

    /* renamed from: l */
    public static float f1419l = 0.0f;

    /* renamed from: o */
    public static float f1422o = 0.0f;

    /* renamed from: p */
    public static float f1423p = 0.0f;

    /* renamed from: z */
    public static boolean f1433z = false;

    /* renamed from: A */
    public static final C0237e f1370A = new C0237e();

    /* renamed from: B */
    public static int f1371B = 0;

    /* renamed from: F */
    public static String f1375F = null;

    /* renamed from: G */
    public static String f1376G = null;

    /* renamed from: H */
    public static long f1377H = 300;

    /* renamed from: I */
    public static boolean f1378I = true;

    /* renamed from: L */
    public static boolean f1381L = false;

    /* renamed from: M */
    public static boolean f1382M = false;

    /* renamed from: N */
    public static boolean f1383N = false;

    /* renamed from: Q */
    public static InterfaceC0204b f1386Q = null;

    /* renamed from: S */
    static C0206d f1388S = null;

    /* renamed from: T */
    public static long f1389T = 0;

    /* renamed from: U */
    public static long f1390U = 0;

    /* renamed from: V */
    public static long f1391V = 0;

    /* renamed from: W */
    public static C0211a f1392W = new C0211a();

    /* renamed from: ag */
    private static long f1403ag = 0;

    /* renamed from: ah */
    private static long f1404ah = 0;

    /* renamed from: ai */
    private static long f1405ai = 0;

    /* renamed from: aj */
    private static int f1406aj = 0;

    /* renamed from: ak */
    private static int f1407ak = 0;

    /* renamed from: al */
    private static GpsVal f1408al = null;

    /* renamed from: X */
    public static long f1393X = 0;

    /* renamed from: Y */
    public static int f1394Y = 0;

    /* renamed from: a */
    public static void m1061a() {
        f1381L = false;
        f1382M = false;
        f1419l = 0.0f;
        f1433z = false;
        f1371B = 0;
        f1414g = new ArrayList<>();
        f1387R = new C0206d(1.0f, 100.0f);
        f1402af = new C0210h(C0101l.f533R);
        f1385P = new C0203a(1000, 0.1f);
        f1384O = new C0173e();
        f1413f = new C0367g();
        f1372C = new C0240h();
        f1373D = new C0221d();
        f1399ac = new GpsVal();
        C0233a.m1028a();
        C0233a.m1030b();
        f1370A.m1054a();
        m1068b();
    }

    /* renamed from: a */
    public static void m1062a(float f2, float f3, long j2) {
        f1425r = j2;
        C0370j m823e = f1415h.m823e();
        if (m823e != null && j2 - m823e.f1975d < 500) {
            m823e.f2023f = (short) (10.0f * f3);
        }
        f1427t = f2;
        double d2 = f2;
        Double.isNaN(d2);
        f1426s = (int) (d2 + 0.5d);
        f1417j = f3;
        if (f1388S != null) {
            f3 = f1388S.mo866a(f3, j2);
        }
        if (f1386Q != null) {
            f3 = f1386Q.mo866a(f3, j2);
        }
        if (f1402af != null) {
            f3 = f1402af.m884a(f3, f2);
        } else if (Math.abs(f3) < 0.1d) {
            f3 = 1.0E-4f;
        }
        f1416i = f3;
        f1390U = j2;
        f1391V = j2;
        m1069b(j2);
    }

    /* renamed from: a */
    public static void m1063a(float f2, float f3, short s, long j2, int i2) {
        long j3;
        boolean z;
        if (App.m452g()) {
            int m819b = f1415h.m819b();
            if (!f1395Z) {
                if (f1397aa <= 0 || System.currentTimeMillis() <= f1397aa) {
                    return;
                } else {
                    m1072c();
                }
            }
            if (m819b == 0) {
                C0369i.m1245a(f2);
                j3 = 0;
            } else {
                j3 = j2 - f1415h.m823e().f1975d;
                if (j3 < 300) {
                    return;
                }
            }
            C0370j m821c = f1415h.m821c();
            m821c.f1975d = j2;
            m821c.f1974c = s;
            m821c.f1972a = f2;
            m821c.f1973b = f3;
            m821c.f2022e = (short) C0391d.m1416b(f2, f3);
            f1415h.m822d();
            f1389T = j2;
            m821c.f1975d = j2;
            f1424q = j2;
            if (j3 > 300000) {
                C0101l.f566ap++;
            }
            boolean m1032d = C0233a.m1032d();
            boolean m378a = C0072a.m378a();
            if (!C0172d.m668b() || m378a) {
                if (!m1032d || m378a) {
                    m1064a(s, j2);
                }
            } else if (m1032d) {
                C0233a.m1033e();
            }
            m821c.f2023f = (short) (f1417j * 10.0f);
            Double.isNaN(f1427t);
            m821c.f2024g = (short) (r2 + 0.5d);
            if (i2 < 0) {
                m1084o();
            } else {
                f1418k = i2;
            }
            if (m819b > 1) {
                m1067a(m821c);
            }
            if (!f1433z) {
                m1085p();
            }
            boolean m1056a = C0238f.m1056a(m821c);
            if (m1056a) {
                ActivityMain.m413a(4);
                if (C0238f.m1059d()) {
                    m1083n();
                }
            }
            f1428u = C0391d.m1416b(f2, f3);
            m821c.f2022e = (short) f1428u;
            int i3 = f1426s - f1428u;
            f1429v = i3;
            if (i3 < 0) {
                f1429v = 0;
            }
            if (C0238f.m1059d()) {
                if (j2 - f1373D.f1235c.f1975d >= C0101l.f558ah) {
                    f1373D.m958a(m821c, m821c.f2024g);
                    if (C0101l.f565ao && j2 > f1400ad) {
                        ActivityMain.m413a(2);
                        f1400ad = 60000 + j2;
                    }
                    z = true;
                } else {
                    z = false;
                }
                if (f1414g.isEmpty() || j2 - f1414g.get(f1414g.size() - 1).f1975d >= 4000) {
                    f1414g.add(new GpsVal(f2, f3, s, j2));
                    f1413f.m1225a(m821c);
                }
                if (!C0101l.f565ao) {
                    f1372C.m1090a();
                    f1392W.m895a(m821c.f1972a, m821c.f1973b, m821c.f1974c, m821c.f1975d);
                    if (C0098i.f509a != 0) {
                        C0098i.m512a(j2);
                    }
                    if (j2 > f1374E && C0101l.f557ag != 0 && !C0074c.m392a()) {
                        if (C0369i.m1249b(f1399ac, m821c) > 0.3f) {
                            f1399ac.m1169a(m821c);
                            new C0074c(f1373D.m962b(), true);
                        } else {
                            f1374E = (C0101l.f557ag / 2) + j2;
                        }
                    }
                }
            } else {
                if (m1056a) {
                    m1066a((String) null);
                }
                z = false;
            }
            if (C0366f.f2003a != null && !C0101l.f565ao) {
                C0366f.m1221a();
            }
            if (C0227a.f1276a != null && C0227a.f1276a.m1005d()) {
                if (!z) {
                    f1373D.m958a(m821c, m821c.f2024g);
                }
                ActivityMain.m413a(2);
            }
            if (C0101l.f541Z && ((j2 > C0225a.f1257b || C0225a.f1262g == 0) && !C0072a.m378a() && (!C0101l.f565ao || C0101l.f553ac))) {
                C0225a.m982a(false);
            }
            int size = f1414g.size();
            if (size > 800 && f1394Y < (size * 3) / 4) {
                m1078i();
            }
            m1069b(j2);
        }
    }

    /* renamed from: a */
    private static void m1064a(int i2, long j2) {
        f1425r = j2;
        f1426s = i2;
        f1385P.mo866a(i2, j2);
        float f2 = f1385P.f1046c;
        f1417j = f2;
        if (f1386Q != null) {
            f2 = f1386Q.mo866a(f2, j2);
        }
        f1416i = f2;
        f1390U = j2;
    }

    /* renamed from: a */
    public static void m1065a(long j2) {
        f1395Z = false;
        f1397aa = j2 > 0 ? System.currentTimeMillis() + j2 : 0L;
    }

    /* renamed from: a */
    public static void m1066a(String str) {
        C0238f.m1060e();
        C0062c.m314b(App.m443b());
        if (C0227a.f1276a != null) {
            C0227a.f1276a.m1003b();
        }
        String m962b = f1373D.m962b();
        if (m962b != null) {
            Bundle bundle = null;
            C0099j.m523b(m962b, "kmmax", (String) null);
            if (f1373D.m963c()) {
                if (str == null && C0099j.m519a("auto_export_igc", false)) {
                    C0101l.exportIgc(m962b);
                }
                if (str != null) {
                    bundle = new Bundle();
                    bundle.putString("igc", str);
                }
                ActivityMain.m415a(5, bundle);
            }
        }
        ActivityMain.m413a(8);
        m1068b();
        FlyMeService.m457a();
    }

    /* renamed from: a */
    private static void m1067a(C0370j c0370j) {
        short s;
        short s2;
        long j2 = c0370j.f1975d - 1000;
        int i2 = 3;
        C0370j m820b = f1415h.m820b(3);
        if (m820b == null || m820b.f1975d < j2) {
            i2 = 2;
            m820b = f1415h.m820b(2);
        }
        if (m820b == null || m820b.f1975d < j2) {
            m820b = f1415h.m820b(i2 - 1);
        }
        if (m820b == null) {
            return;
        }
        f1398ab = c0370j.f1975d - m820b.f1975d;
        float f2 = (float) f1398ab;
        f1422o = C0369i.m1249b(m820b, c0370j);
        f1421n = (f1422o * 3600000.0f) / f2;
        if ((f1418k > 3.0f || f1421n > 5.0f) && f1403ag != 0) {
            int i3 = (int) (c0370j.f1975d - f1403ag);
            int i4 = f1420m;
            f1420m = C0369i.m1244a(m820b, c0370j);
            int i5 = f1420m - i4;
            if (i5 > 180) {
                i5 = 360 - i5;
            } else if (i5 < -180) {
                i5 += 360;
            }
            f1430w = i5;
            f1431x = Math.abs((i5 * 1000) / i3);
            if (f1431x <= 90 || f1421n >= 5.0f) {
                f1432y = f1420m / 90;
            } else {
                f1421n = 0.0f;
                f1420m = i4;
                f1430w = 0;
                f1431x = 0;
            }
        } else {
            f1430w = 0;
            f1431x = 0;
            f1421n = 0.0f;
        }
        f1383N = c0370j.f1975d - f1391V < 5000;
        if (f1383N) {
            s = c0370j.f2024g;
            s2 = m820b.f2024g;
        } else {
            s = c0370j.f1974c;
            s2 = m820b.f1974c;
        }
        f1423p = s - s2;
        f1403ag = c0370j.f1975d;
    }

    /* renamed from: b */
    public static void m1068b() {
        C0238f.m1055a();
        f1415h.m818a();
        f1395Z = true;
        f1397aa = 0L;
        f1416i = 0.0f;
        f1418k = 0.0f;
        f1414g.clear();
        f1413f.m1223a();
        f1422o = 0.0f;
        f1423p = 0.0f;
        f1424q = 0L;
        f1425r = 0L;
        f1432y = 0;
        f1430w = 0;
        f1420m = 0;
        f1398ab = 0L;
        f1421n = 0.0f;
        f1403ag = 0L;
        f1374E = 0L;
        f1373D.m963c();
        f1372C.m1091b();
        f1392W = new C0211a();
        C0062c.m314b(App.m443b());
        m1081l();
        f1375F = null;
        f1408al = null;
        f1394Y = 0;
        C0101l.f566ap++;
        f1400ad = 0L;
        f1401ae = 0L;
        C0236d.f1340b = false;
        f1379J = 0;
        f1380K = 0;
        f1389T = 0L;
        f1390U = 0L;
        f1391V = 0L;
        f1383N = false;
        if (C0227a.f1276a != null) {
            C0227a.f1276a.m1003b();
        }
        FlyMeService.m457a();
    }

    /* renamed from: b */
    private static void m1069b(long j2) {
        if (C0101l.f565ao || j2 <= f1401ae) {
            return;
        }
        ActivityMain.m413a(2);
        f1401ae = j2 + ((!f1378I || f1372C.f1446a <= 0) ? f1377H : 300L);
    }

    /* renamed from: b */
    private static boolean m1070b(float f2, float f3, long j2) {
        String m515a;
        if (C0072a.m378a() || f1408al == null) {
            return false;
        }
        long m526d = C0099j.m526d("igc_recording_time");
        if (m526d <= j2 && m526d >= j2 - 600000 && (m515a = C0099j.m515a("igc_recording_name")) != null && m515a.length() >= 2) {
            CRC32 crc32 = new CRC32();
            ArrayList<GpsVal> arrayList = new ArrayList<>();
            C0367g c0367g = new C0367g();
            C0220c c0220c = new C0220c(C0101l.m558c() + "/" + m515a, 0L, crc32);
            GpsVal gpsVal = null;
            while (c0220c.m949b()) {
                gpsVal = new GpsVal(c0220c.f1218h, c0220c.f1219i, c0220c.f1220j, c0220c.f1216f);
                arrayList.add(gpsVal);
                c0367g.m1225a(gpsVal);
            }
            if (gpsVal == null || gpsVal.f1975d < j2 - 60000 || gpsVal.f1975d > j2 + 60000 || C0369i.m1248b(gpsVal.f1972a, gpsVal.f1973b, f2, f3) > 1.0f || !f1373D.m961a(m515a, crc32)) {
                return false;
            }
            f1408al.f1972a = gpsVal.f1972a;
            f1408al.f1973b = gpsVal.f1973b;
            f1408al.f1975d = gpsVal.f1975d;
            f1414g = arrayList;
            f1413f = c0367g;
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public static boolean m1071b(String str) {
        long j2 = 0;
        m1065a(0L);
        m1068b();
        f1375F = str;
        C0220c c0220c = new C0220c(C0101l.m558c() + "/" + str, 10000L);
        while (c0220c.m949b()) {
            GpsVal gpsVal = new GpsVal(c0220c.f1218h, c0220c.f1219i, c0220c.f1220j, c0220c.f1216f);
            if (f1414g.isEmpty() || j2 - f1414g.get(f1414g.size() - 1).f1975d >= 4000) {
                f1414g.add(gpsVal);
                f1413f.m1225a(gpsVal);
            }
            j2 = gpsVal.f1975d;
        }
        if (f1414g.size() <= 0) {
            return false;
        }
        GpsVal m1233c = f1413f.m1233c();
        if (f1408al == null) {
            f1408al = new GpsVal();
        }
        f1408al.f1972a = m1233c.f1972a;
        f1408al.f1973b = m1233c.f1973b;
        f1408al.f1975d = System.currentTimeMillis();
        C0369i.m1245a(m1233c.f1972a);
        return true;
    }

    /* renamed from: c */
    public static void m1072c() {
        f1395Z = true;
        f1397aa = 0L;
    }

    /* renamed from: d */
    public static final GpsVal m1073d() {
        C0370j m823e = f1415h.m823e();
        if (m823e != null) {
            return m823e;
        }
        if (f1408al == null) {
            f1408al = new GpsVal();
            float[] m1050g = C0236d.m1050g();
            f1408al.f1972a = m1050g[0];
            f1408al.f1973b = m1050g[1];
            f1408al.f1975d = System.currentTimeMillis();
        }
        return f1408al;
    }

    /* renamed from: e */
    public static int m1074e() {
        int size = f1414g.size();
        if (size == 0) {
            return 0;
        }
        long j2 = m1073d().f1975d;
        long j3 = f1414g.get(0).f1975d;
        if (size == 0) {
            return 0;
        }
        return (int) ((j2 - j3) / 1000);
    }

    /* renamed from: f */
    public static void m1075f() {
        m1068b();
        C0233a.m1033e();
        C0062c.m311a();
        C0236d.m1044b();
    }

    /* renamed from: g */
    public static boolean m1076g() {
        C0370j m823e = f1415h.m823e();
        return m823e != null && System.currentTimeMillis() - m823e.f1975d < 30000;
    }

    /* renamed from: h */
    public static final String m1077h() {
        return f1375F != null ? f1375F : f1376G;
    }

    /* renamed from: i */
    static void m1078i() {
        C0222e.a m967a = new C0222e().m967a(f1414g, false);
        int length = m967a.f1245a.length;
        float m1248b = ((C0369i.m1248b(f1413f.f2012a, f1413f.f2014c, f1413f.f2013b, f1413f.f2015d) / 10.0f) + 1.0f) * 2.0E-8f;
        if (m1248b > 1.0E-7f) {
            m1248b = 1.0E-7f;
        }
        if (m1248b < 4.0E-8f) {
            m1248b = 4.0E-8f;
        }
        C0219b c0219b = new C0219b();
        c0219b.m943a(m967a.f1245a, m967a.f1246b, length, m1248b);
        int size = c0219b.f1210a.size();
        f1394Y = size;
        for (int i2 = 0; i2 < size; i2++) {
            int intValue = c0219b.f1210a.get(i2).intValue();
            GpsVal gpsVal = f1414g.get(i2);
            gpsVal.f1972a = m967a.f1245a[intValue];
            gpsVal.f1973b = m967a.f1246b[intValue];
            gpsVal.f1974c = m967a.f1247c[intValue];
            gpsVal.f1975d = m967a.f1248d[intValue];
        }
        f1414g.subList(size, f1414g.size()).clear();
    }

    /* renamed from: j */
    public static boolean m1079j() {
        C0227a c0227a = C0227a.f1276a;
        if (c0227a == null) {
            return false;
        }
        m1065a(0L);
        m1068b();
        c0227a.m1003b();
        f1413f.m1229b(c0227a.f1292p);
        GpsVal m1233c = f1413f.m1233c();
        if (f1408al == null) {
            f1408al = new GpsVal();
        }
        f1408al.f1972a = m1233c.f1972a;
        f1408al.f1973b = m1233c.f1973b;
        f1408al.f1975d = System.currentTimeMillis();
        C0369i.m1245a(m1233c.f1972a);
        return true;
    }

    /* renamed from: k */
    public static float m1080k() {
        if (f1418k == 0.0f) {
            return 0.1f;
        }
        return 1000.0f / (C0101l.f529N * (3600.0f / f1418k));
    }

    /* renamed from: l */
    public static void m1081l() {
        C0209g c0209g;
        int i2 = C0101l.f534S == 0 ? (C0233a.m1031c() || C0172d.m668b()) ? 1000 : 8000 : C0101l.f534S;
        f1388S = null;
        f1386Q = null;
        f1402af = null;
        if (C0101l.f532Q && !C0172d.m671e()) {
            f1388S = new C0206d(1.0f, 5.0f);
            if (i2 > 1999) {
                c0209g = new C0209g(i2 - 1000);
                f1386Q = c0209g;
            }
        } else if (i2 > 1000) {
            c0209g = new C0209g(i2);
            f1386Q = c0209g;
        }
        f1385P.m868a(1000, 0.1f);
        if (C0172d.m672f()) {
            return;
        }
        f1402af = new C0210h(C0101l.f533R);
    }

    /* renamed from: m */
    public static void m1082m() {
        int i2 = C0101l.f559ai * 3;
        if (C0101l.f559ai == 4) {
            i2 = 0;
        }
        f1409b = f1396a[i2];
        f1410c = f1396a[i2 + 1];
        f1411d = f1396a[i2 + 2];
    }

    /* renamed from: n */
    private static void m1083n() {
        int m819b;
        C0236d.f1340b = true;
        f1376G = f1373D.m962b();
        ActivityMain.m413a(9);
        if (!f1373D.m960a() && (m819b = f1415h.m819b()) >= 3) {
            f1375F = null;
            long j2 = f1415h.m824f().f1975d;
            f1374E = C0101l.f557ag + j2;
            if (C0227a.f1276a != null) {
                C0227a.f1276a.m1003b();
            }
            int i2 = 1;
            while (true) {
                if (i2 >= m819b) {
                    break;
                }
                C0370j m817a = f1415h.m817a(i2);
                long j3 = j2 - m817a.f1975d;
                if (j3 < 0 || j3 > 70000) {
                    i2++;
                } else if (!m1070b(m817a.f1972a, m817a.f1973b, m817a.f1975d)) {
                    f1373D.m958a(m817a, m817a.f2024g);
                    f1414g.clear();
                    f1413f.m1223a();
                    long j4 = m817a.f1975d;
                    for (int i3 = i2 + 1; i3 <= m819b - 1; i3++) {
                        C0370j m817a2 = f1415h.m817a(i3);
                        if (m817a2.f1975d - j4 >= C0101l.f558ah) {
                            f1373D.m958a(m817a2, m817a2.f2024g);
                            j4 = m817a2.f1975d;
                            f1414g.add(new GpsVal(m817a2.f1972a, m817a2.f1973b, m817a2.f1974c, m817a2.f1975d));
                            f1413f.m1225a(m817a2);
                        }
                    }
                }
            }
            f1376G = f1373D.m962b();
            FlyMeService.m457a();
        }
    }

    /* renamed from: o */
    private static void m1084o() {
        int m819b = f1415h.m819b();
        if (m819b < 3) {
            return;
        }
        C0370j m817a = f1415h.m817a(m819b - 1);
        long j2 = m817a.f1975d - f1412e;
        for (int i2 = m819b - 2; i2 > 0; i2--) {
            C0370j m817a2 = f1415h.m817a(i2);
            if (m817a2.f1975d < j2) {
                f1418k = (C0369i.m1249b(m817a, m817a2) * 3600000.0f) / ((float) (m817a.f1975d - m817a2.f1975d));
                return;
            }
        }
    }

    /* renamed from: p */
    private static void m1085p() {
        if (C0072a.m378a()) {
            return;
        }
        f1371B = ((f1431x >= 20 || f1421n <= 0.0f || f1421n >= 50.0f) && (f1431x >= 50 || f1421n <= 15.0f || f1421n >= 80.0f) && ((f1431x >= 10 || f1421n >= 160.0f) && (f1431x >= 120 || f1421n >= 10.0f))) ? f1371B / 2 : f1371B + 1;
        if (f1371B > 12) {
            m1068b();
            f1433z = true;
        }
    }
}
