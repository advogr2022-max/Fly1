package vmaps.core;

import android.graphics.Path;
import android.util.Log;
import com.xcglobe.xclog.C0099j;
import com.xcglobe.xclog.C0101l;
import java.io.IOException;
import java.util.ArrayList;
import flyme_tasks.AsyncTaskC0063d;
import types.C0367g;
import types.C0375o;
import vmaps.C0392e;

/* renamed from: vmaps.core.h */
/* loaded from: classes.dex */
public class C0389h {

    /* renamed from: a */
    private static Path f2200a = new Path();

    /* renamed from: b */
    private static long[] f2201b = {0, 0, 0};

    /* renamed from: c */
    private static final int[] f2202c = {6, 2, 1};

    /* renamed from: d */
    private static final boolean[] f2203d = {true, true, true};

    /* renamed from: e */
    private static final boolean[] f2204e = {false, false, false};

    /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int m1396a(AbstractC0386e abstractC0386e, int i2, C0367g c0367g, int i3, int i4) {
        int i5;
        int i6;
        long j2 = f2201b[1];
        long j3 = f2201b[2];
        if (j2 > 0 && j3 > 0) {
            int i7 = j3 > 3000 ? 1 : 2;
            long j4 = j3 - j2;
            if (i7 == 1) {
                if (j4 < 1500) {
                    i6 = 2;
                    if (i4 == 0 || f2201b[i6] < 2000) {
                        i5 = i6;
                    }
                }
                i6 = i7;
                if (i4 == 0) {
                }
                i5 = i6;
            } else {
                if (j4 > 2000) {
                    i6 = 1;
                    if (i4 == 0) {
                    }
                    i5 = i6;
                }
                i6 = i7;
                if (i4 == 0) {
                }
                i5 = i6;
            }
            if (i5 == 1 && j2 != 0 && j2 < 5000 && j3 == 0) {
                i5 = 2;
            }
            long j5 = f2201b[i5];
            if (i5 <= 0 && j5 > 5000) {
                return -1;
            }
            int i8 = f2202c[i5];
            boolean z = f2203d[i5];
            boolean z2 = f2204e[i5];
            long currentTimeMillis = System.currentTimeMillis();
            m1398a(abstractC0386e, i2, i2, c0367g, i3, z, i8, z2);
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            f2201b[i5] = currentTimeMillis2;
            int i9 = currentTimeMillis2 > 4000 ? 1 : 0;
            if (i5 != 2) {
                return 1;
            }
            return i9;
        }
        i5 = i4;
        if (i5 == 1) {
            i5 = 2;
        }
        long j52 = f2201b[i5];
        if (i5 <= 0) {
        }
        int i82 = f2202c[i5];
        boolean z3 = f2203d[i5];
        boolean z22 = f2204e[i5];
        long currentTimeMillis3 = System.currentTimeMillis();
        m1398a(abstractC0386e, i2, i2, c0367g, i3, z3, i82, z22);
        long currentTimeMillis22 = System.currentTimeMillis() - currentTimeMillis3;
        f2201b[i5] = currentTimeMillis22;
        if (currentTimeMillis22 > 4000) {
        }
        if (i5 != 2) {
        }
    }

    /* renamed from: a */
    public static void m1397a(AbstractC0386e abstractC0386e, int i2, int i3, C0367g c0367g, int i4) {
        ArrayList<String> m1271a = C0375o.m1271a(c0367g);
        abstractC0386e.mo1382a(i2, i3, c0367g);
        float m1238g = abstractC0386e.f2192j / c0367g.m1238g();
        float m1237f = abstractC0386e.f2193k / c0367g.m1237f();
        for (int i5 = 0; i5 < m1271a.size(); i5++) {
            String m537a = C0101l.m537a("vmp/" + m1271a.get(i5) + ".vmp");
            C0390i c0390i = new C0390i(true);
            c0390i.m1407a(abstractC0386e.f2192j, abstractC0386e.f2193k, c0367g.f2012a, c0367g.f2014c, m1238g, m1237f);
            try {
                c0390i.m1408a(m537a);
                c0390i.m1406a(i4);
                while (c0390i.m1410b()) {
                    try {
                        if (c0390i.f2220f > 0) {
                            abstractC0386e.mo1387a(c0390i.f2215a, c0390i.f2216b, c0390i.f2220f, c0390i.f2218d, ((C0392e) abstractC0386e).f2244a.m1395a(c0390i.f2218d));
                        }
                    } catch (IOException e2) {
                        C0101l.m547a("crash", Log.getStackTraceString(e2));
                    }
                }
            } catch (IOException unused) {
            }
        }
    }

    /* renamed from: a */
    private static void m1398a(AbstractC0386e abstractC0386e, int i2, int i3, C0367g c0367g, int i4, boolean z, int i5, boolean z2) {
        int i6;
        int i7;
        boolean z3 = true;
        if (i5 > 1) {
            i6 = i2 / i5;
            i7 = i3 / i5;
        } else {
            i6 = i2;
            i7 = i3;
        }
        if (!z) {
            m1397a(abstractC0386e, i6, i7, c0367g, i4);
            return;
        }
        boolean z4 = C0099j.m521b("mapset") > 0;
        int i8 = C0101l.f554ad;
        try {
            C0385d c0385d = new C0385d(c0367g, i6, i7, 50);
            c0385d.m1378a(C0101l.m537a("vmp/"), abstractC0386e, z4, i8, z2);
            if (i5 > 1) {
                ((C0392e) abstractC0386e).m1417a(i6 * i5, i7 * i5);
            }
            if (c0385d.f2183p >= 100) {
                z3 = false;
            }
            if (z4 != z3) {
                C0099j.m517a("mapset", z3 ? 2 : 0);
                AsyncTaskC0063d.m321c();
            }
        } catch (IOException e2) {
            C0101l.m547a("crash", Log.getStackTraceString(e2));
        }
    }
}
