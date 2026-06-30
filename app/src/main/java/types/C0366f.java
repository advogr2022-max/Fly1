package types;

import android.content.Intent;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0101l;
import display.vmap.features.PoiPainter;
import flyme_poi.C0227a;
import flyme_poi.C0229c;
import flyme_data.C0239g;
import vmaps.C0391d;

/* renamed from: types.f */
/* loaded from: classes.dex */
public class C0366f {

    /* renamed from: a */
    public static PoiPoint f2003a = null;

    /* renamed from: b */
    public static float f2004b = 0.0f;

    /* renamed from: c */
    public static int f2005c = 0;

    /* renamed from: d */
    public static int f2006d = 0;

    /* renamed from: e */
    public static float f2007e = 0.0f;

    /* renamed from: f */
    public static int f2008f = 0;

    /* renamed from: g */
    public static boolean f2009g = false;

    /* renamed from: h */
    private static int f2010h;

    /* renamed from: i */
    private static C0364d f2011i = new C0364d(0.0f, 0.0f);

    /* renamed from: a */
    public static void m1221a() {
        GpsVal m1073d = C0239g.m1073d();
        if (f2009g) {
            int i2 = f2010h - 1;
            f2010h = i2;
            if (i2 < 0) {
                C0372l m997a = C0227a.f1276a.m997a(m1073d.f1972a, m1073d.f1973b);
                if (m997a != null) {
                    f2003a.f1976i = m997a.f2053a;
                    f2003a.f1977j = m997a.f2054b;
                }
                f2010h = 0;
            }
        }
        f2004b = f2011i.m1199b(m1073d.f1972a, m1073d.f1973b);
        f2005c = C0369i.m1243a(m1073d.f1972a, m1073d.f1973b, f2003a.f1976i, f2003a.f1977j);
        f2007e = C0239g.f1392W.m894a(f2005c, C0101l.f528M);
        f2006d = (int) ((f2004b * 3600.0f) / f2007e);
        f2008f = (C0239g.f1426s - ((int) (C0101l.f529N * f2006d))) - f2003a.f1978k;
    }

    /* renamed from: a */
    public static void m1222a(PoiPoint poiPoint, boolean z) {
        int m1412a;
        PoiPoint poiPoint2 = poiPoint;
        if (poiPoint == null) {
            poiPoint2 = poiPoint;
            if (C0227a.m991f()) {
                C0229c c0229c = new C0229c();
                c0229c.m1015a(C0227a.f1276a.f1284h);
                c0229c.f1976i = C0227a.f1276a.f1284h.f1318h.f2053a;
                c0229c.f1977j = C0227a.f1276a.f1284h.f1318h.f2054b;
                if (c0229c.f1978k == 0) {
                    C0391d.m1416b(c0229c.f1976i, c0229c.f1977j);
                }
                z = true;
                poiPoint2 = c0229c;
            }
        }
        if (poiPoint2 != null) {
            if (poiPoint2.f1980m == 'l') {
                f2003a = new C0373m();
                ((C0373m) f2003a).f2055a = ((C0373m) poiPoint2).f2055a;
            } else {
                f2003a = new PoiPoint();
                if (poiPoint2.f1978k == 0 && (m1412a = C0391d.m1412a(poiPoint2.f1976i, poiPoint2.f1977j)) != 0) {
                    poiPoint2.f1978k = (short) m1412a;
                }
            }
            f2003a.m1171a(poiPoint2);
            PoiPainter.reloadLocalPoints();
            f2011i = new C0364d(poiPoint2.f1976i, poiPoint2.f1977j);
            m1221a();
        } else {
            f2003a = null;
        }
        f2009g = z && poiPoint2 != null;
        int i2 = (!f2009g || C0227a.f1276a.f1295s) ? 7 : 8;
        if (!f2009g || C0227a.f1276a.f1295s) {
            Intent intent = new Intent("com.xcglobe.action.main");
            intent.putExtra("event", i2);
            App.m443b().sendBroadcast(intent);
        }
    }
}
