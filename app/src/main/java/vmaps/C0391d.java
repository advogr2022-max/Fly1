package vmaps;

import com.xcglobe.xclog.ActivityMain;
import flyme_apphelper.C0073b;
import types.C0366f;
import types.C0371k;

/* renamed from: vmaps.d */
/* loaded from: classes.dex */
public class C0391d {

    /* renamed from: a */
    public static float f2240a = 20.0f;

    /* renamed from: b */
    private static C0371k f2241b = new C0371k(400, 400);

    /* renamed from: c */
    private static boolean f2242c = false;

    /* renamed from: a */
    public static int m1412a(float f2, float f3) {
        int m1255a = f2242c ? f2241b.m1255a(f2, f3, true) : 0;
        if (m1255a == 0 || f2241b.f2036l > f2240a * 2.0f) {
            new C0073b(f2, f3);
        }
        return m1255a;
    }

    /* renamed from: a */
    public static void m1413a() {
        f2242c = false;
    }

    /* renamed from: a */
    public static void m1414a(float f2) {
        if (f2 < 10.0f) {
            f2 = 10.0f;
        }
        f2240a = f2;
    }

    /* renamed from: a */
    public static void m1415a(C0371k c0371k) {
        int m1255a;
        f2241b.f2025a = null;
        f2241b = null;
        f2241b = c0371k;
        f2242c = true;
        if (C0366f.f2003a != null && C0366f.f2003a.f1978k == 0 && (m1255a = f2241b.m1255a(C0366f.f2003a.f1976i, C0366f.f2003a.f1977j, true)) != 0) {
            C0366f.f2003a.f1978k = (short) m1255a;
        }
        ActivityMain.m413a(16);
    }

    /* renamed from: b */
    public static int m1416b(float f2, float f3) {
        int m1255a = f2242c ? f2241b.m1255a(f2, f3, false) : 0;
        if (m1255a == 0 || f2241b.f2036l > f2240a * 2.0f) {
            new C0073b(f2, f3);
        }
        return m1255a;
    }
}
