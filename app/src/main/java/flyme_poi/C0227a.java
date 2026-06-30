package flyme_poi;

import android.content.Intent;
import android.text.format.Time;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0099j;
import com.xcglobe.xclog.C0101l;
import java.util.ArrayList;
import flyme_tasks.AsyncTaskC0067h;
import flyme_data.C0238f;
import flyme_data.C0239g;
import types.C0364d;
import types.C0365e;
import types.C0366f;
import types.C0367g;
import types.C0369i;
import types.C0372l;
import types.Coord;
import types.GpsVal;

/* renamed from: k.a */
/* loaded from: classes.dex */
public class C0227a {

    /* renamed from: a */
    public static C0227a f1276a = null;

    /* renamed from: z */
    public static boolean f1277z = false;

    /* renamed from: b */
    public String f1278b;

    /* renamed from: j */
    public int f1286j;

    /* renamed from: k */
    public int f1287k;

    /* renamed from: q */
    int f1293q;

    /* renamed from: s */
    public boolean f1295s;

    /* renamed from: u */
    public long f1297u;

    /* renamed from: v */
    boolean f1298v;

    /* renamed from: x */
    public float f1300x;

    /* renamed from: y */
    public float f1301y;

    /* renamed from: c */
    public ArrayList<C0229c> f1279c = new ArrayList<>();

    /* renamed from: d */
    public boolean f1280d = false;

    /* renamed from: e */
    public Time f1281e = new Time();

    /* renamed from: f */
    public Time f1282f = new Time();

    /* renamed from: g */
    public int f1283g = 0;

    /* renamed from: h */
    public C0229c f1284h = null;

    /* renamed from: i */
    C0367g f1285i = new C0367g();

    /* renamed from: l */
    public boolean f1288l = false;

    /* renamed from: m */
    public boolean f1289m = true;

    /* renamed from: n */
    public boolean f1290n = false;

    /* renamed from: o */
    public C0372l[] f1291o = null;

    /* renamed from: p */
    public C0367g f1292p = new C0367g();

    /* renamed from: r */
    boolean f1294r = false;

    /* renamed from: t */
    public boolean f1296t = false;

    /* renamed from: w */
    public C0364d f1299w = null;

    public C0227a() {
        this.f1281e.setToNow();
        this.f1282f.setToNow();
    }

    /* renamed from: a */
    public static void m988a(String str) {
        f1277z = false;
        if (str == null) {
            f1276a = null;
            C0366f.m1222a(null, false);
        } else {
            f1276a = C0230d.m1017a(str);
            if (f1276a != null) {
                f1276a.m1003b();
            } else {
                str = null;
            }
        }
        C0099j.m527d("active_task_name", str);
    }

    /* renamed from: b */
    private void m989b(C0229c c0229c, C0229c c0229c2) {
        this.f1291o = null;
        Coord coord = new Coord();
        Coord coord2 = new Coord();
        C0364d c0364d = new C0364d(c0229c2.f1976i, c0229c2.f1977j);
        c0364d.m1195a(c0229c.f1976i, c0229c.f1977j, coord);
        c0364d.m1195a(c0229c2.f1976i, c0229c2.f1977j, coord2);
        Coord m1216b = C0365e.m1216b(coord, coord2);
        Coord[] m1215a = C0365e.m1215a(m1216b.f1970a, m1216b.f1971b, coord2.f1970a, coord2.f1971b, coord2.f1970a, coord2.f1971b, c0229c2.f1311a, false);
        if (m1215a != null) {
            this.f1291o = new C0372l[2];
            this.f1291o[0] = new C0372l();
            this.f1291o[1] = new C0372l();
            c0364d.m1196a(m1215a[0], this.f1291o[0]);
            c0364d.m1196a(m1215a[1], this.f1291o[1]);
        }
    }

    /* renamed from: e */
    public static void m990e() {
        m988a(C0099j.m515a("active_task_name"));
        if (m991f()) {
            long currentTimeMillis = (f1276a.f1297u - (C0238f.m1059d() ? C0239g.f1424q : System.currentTimeMillis())) / 1000;
            if (currentTimeMillis < -7200 || currentTimeMillis > 7200) {
                m988a((String) null);
            }
        }
    }

    /* renamed from: f */
    public static boolean m991f() {
        return (f1276a == null || f1276a.f1288l) ? false : true;
    }

    /* renamed from: g */
    public static boolean m992g() {
        return f1276a != null && f1276a.f1290n;
    }

    /* renamed from: l */
    private void m993l() {
        this.f1292p.m1223a();
        for (int i2 = 0; i2 < this.f1279c.size(); i2++) {
            C0229c c0229c = this.f1279c.get(i2);
            this.f1292p.m1224a(c0229c.f1976i, c0229c.f1977j);
        }
    }

    /* renamed from: m */
    private C0229c m994m() {
        int size = this.f1279c.size();
        if (size == 0) {
            return null;
        }
        C0229c c0229c = this.f1279c.get(size - 1);
        float f2 = c0229c.f1976i;
        float f3 = c0229c.f1977j;
        for (int i2 = size - 2; i2 >= 0; i2--) {
            C0229c c0229c2 = this.f1279c.get(i2);
            if (((int) ((c0229c2.f1976i - f2) * 100000.0f)) != 0 || ((int) ((c0229c2.f1977j - f3) * 100000.0f)) != 0) {
                return c0229c2;
            }
        }
        return null;
    }

    /* renamed from: n */
    private void m995n() {
        int size = this.f1279c.size();
        if (size < 2) {
            return;
        }
        Coord coord = new Coord();
        Coord coord2 = new Coord();
        Coord coord3 = new Coord();
        int i2 = 0;
        while (i2 < size) {
            C0229c c0229c = this.f1279c.get(i2);
            C0364d c0364d = new C0364d(c0229c.f1976i, c0229c.f1977j);
            if (i2 > 0) {
                c0364d.m1197a(this.f1279c.get(i2 - 1).m1016b(), coord);
            }
            int i3 = size - 1;
            if (i2 < i3) {
                c0364d.m1197a(this.f1279c.get(i2 + 1).m1016b(), coord2);
            }
            c0364d.m1195a(c0229c.f1976i, c0229c.f1977j, coord3);
            m1000a(i2 > 0 ? coord : null, coord3, c0229c.f1311a, i2 < i3 ? coord2 : null, c0364d);
            c0364d.m1196a(coord3, c0229c.m1016b());
            i2++;
        }
    }

    /* renamed from: a */
    int m996a(float f2, float f3, float f4, float f5, float f6, float f7) {
        return ((f4 - f2) * (f7 - f3)) - ((f5 - f3) * (f6 - f2)) < 0.0f ? -1 : 1;
    }

    /* renamed from: a */
    public C0372l m997a(float f2, float f3) {
        Coord coord;
        Coord coord2 = new Coord();
        this.f1299w.m1195a(f2, f3, coord2);
        C0372l c0372l = new C0372l(this.f1284h.f1976i, this.f1284h.f1977j);
        Coord coord3 = new Coord();
        this.f1299w.m1197a(c0372l, coord3);
        if (this.f1283g < this.f1279c.size() - 1) {
            coord = new Coord();
            this.f1299w.m1197a(this.f1279c.get(this.f1283g + 1).f1318h, coord);
        } else {
            coord = null;
        }
        m1000a(coord2, coord3, this.f1284h.f1311a, coord, this.f1299w);
        this.f1299w.m1196a(coord3, c0372l);
        return c0372l;
    }

    /* renamed from: a */
    public void m998a(long j2) {
        this.f1297u = System.currentTimeMillis();
        this.f1297u += m1009k() + j2;
        this.f1281e.set(this.f1297u);
    }

    /* renamed from: a */
    void m999a(C0229c c0229c, C0229c c0229c2) {
        this.f1293q = -m996a(this.f1291o[0].f2054b, this.f1291o[0].f2053a, this.f1291o[1].f2054b, this.f1291o[1].f2053a, c0229c.f1977j, c0229c.f1976i);
    }

    /* renamed from: a */
    void m1000a(Coord coord, Coord coord2, float f2, Coord coord3, C0364d c0364d) {
        float f3 = f2 * 0.999f;
        Coord coord4 = new Coord();
        if (coord == null) {
            if (C0365e.m1213a(coord3, coord2, coord2, f3, coord4, true)) {
                coord2.m1168a(coord4);
                return;
            }
            return;
        }
        if (coord3 != null) {
            if (!C0365e.m1213a(coord, coord3, coord2, f3, coord4, true)) {
                Coord coord5 = new Coord(coord2.f1970a, coord2.f1971b);
                C0365e.m1217b(coord, coord3, coord5);
                if (!C0365e.m1213a(coord5, coord2, coord2, f3, coord4, true)) {
                    return;
                }
                float m1204a = C0365e.m1204a(coord, coord4) + C0365e.m1204a(coord4, coord3);
                Coord coord6 = new Coord();
                coord5.m1168a(coord2);
                C0365e.m1219c(coord, coord3, coord5);
                if (C0365e.m1213a(coord5, coord2, coord2, f3, coord6, true) && C0365e.m1204a(coord, coord6) + C0365e.m1204a(coord6, coord3) < m1204a) {
                    coord4 = coord6;
                }
            }
            coord2.m1168a(coord4);
            return;
        }
        if (!this.f1289m || this.f1291o == null) {
            if (C0365e.m1213a(coord, coord2, coord2, f3, coord4, true)) {
                coord2.m1168a(coord4);
                return;
            }
            return;
        }
        Coord coord7 = new Coord();
        c0364d.m1197a(this.f1291o[0], coord7);
        Coord coord8 = new Coord();
        c0364d.m1197a(this.f1291o[1], coord8);
        Coord coord9 = new Coord(coord);
        C0365e.m1219c(coord7, coord8, coord9);
        if (C0365e.m1212a(coord9, coord7, coord8)) {
            coord2.m1168a(coord9);
        } else if (C0365e.m1204a(coord, coord7) < C0365e.m1204a(coord, coord8)) {
            coord2.m1168a(coord7);
        } else {
            coord2.m1168a(coord8);
        }
    }

    /* renamed from: a */
    public void m1001a(boolean z) {
        if (this.f1284h == null) {
            C0366f.m1222a(null, true);
            return;
        }
        C0229c c0229c = new C0229c();
        c0229c.m1015a(this.f1284h);
        c0229c.f1976i = this.f1284h.f1318h.f2053a;
        c0229c.f1977j = this.f1284h.f1318h.f2054b;
        if (!z) {
            c0229c.f1978k = (short) 0;
        }
        C0366f.m1222a(c0229c, true);
    }

    /* renamed from: a */
    public boolean m1002a() {
        GpsVal m1073d = C0239g.m1073d();
        boolean z = this.f1284h != null && this.f1285i.m1232b(m1073d) && C0369i.m1248b(m1073d.f1972a, m1073d.f1973b, this.f1284h.f1976i, this.f1284h.f1977j) < this.f1284h.f1311a;
        if (this.f1290n) {
            if (m1073d.f1975d < this.f1297u) {
                return false;
            }
            if (this.f1284h.f1316f) {
                if (!z) {
                    this.f1298v = true;
                }
                if (this.f1280d && !this.f1298v) {
                    return false;
                }
            } else if (this.f1296t && this.f1289m && z) {
                int m996a = m996a(this.f1291o[0].f2054b, this.f1291o[0].f2053a, this.f1291o[1].f2054b, this.f1291o[1].f2053a, m1073d.f1973b, m1073d.f1972a);
                if (m996a != this.f1293q) {
                    this.f1294r = true;
                }
                if (m996a != this.f1293q || !this.f1294r) {
                    return false;
                }
            }
        }
        return z;
    }

    /* renamed from: b */
    public void m1003b() {
        this.f1296t = false;
        this.f1291o = null;
        int size = this.f1279c.size();
        this.f1286j = 0;
        this.f1287k = size - 1;
        for (int i2 = 0; i2 < size; i2++) {
            C0229c c0229c = this.f1279c.get(i2);
            c0229c.f1315e = false;
            c0229c.f1318h = null;
            if (c0229c.f1316f) {
                this.f1286j = i2;
            }
            if (c0229c.f1317g) {
                this.f1287k = i2;
            }
        }
        ArrayList<C0229c> arrayList = this.f1279c;
        int i3 = this.f1286j > 0 ? 1 : 0;
        this.f1283g = i3;
        this.f1284h = arrayList.get(i3);
        this.f1288l = false;
        this.f1293q = 0;
        this.f1294r = false;
        this.f1298v = false;
        this.f1281e.normalize(false);
        this.f1297u = this.f1281e.toMillis(false);
        this.f1295s = false;
        f1277z = this.f1290n;
        m1007i();
        GpsVal m1233c = this.f1292p.m1233c();
        this.f1299w = new C0364d(m1233c.f1972a, m1233c.f1973b);
        C0369i.m1246a(this.f1284h.f1311a * 1.2f, this.f1284h.f1976i, this.f1284h.f1977j, this.f1285i);
        m1001a(false);
    }

    /* renamed from: c */
    public void m1004c() {
        for (int i2 = 0; i2 < this.f1279c.size(); i2++) {
            C0229c c0229c = this.f1279c.get(i2);
            if (c0229c.f1316f) {
                this.f1286j = i2;
            }
            if (c0229c.f1317g) {
                this.f1287k = i2;
            }
        }
    }

    /* renamed from: d */
    public boolean m1005d() {
        if (this.f1288l || !m1002a()) {
            return false;
        }
        this.f1284h.f1315e = true;
        AsyncTaskC0067h.m353a(R.raw.goal);
        if (this.f1284h.f1316f || !this.f1290n) {
            this.f1295s = true;
        }
        int size = this.f1279c.size();
        int i2 = this.f1283g + 1;
        this.f1283g = i2;
        if (i2 < size) {
            this.f1284h = this.f1279c.get(this.f1283g);
            C0369i.m1246a(this.f1284h.f1311a * 1.2f, this.f1284h.f1976i, this.f1284h.f1977j, this.f1285i);
            this.f1296t = this.f1283g == size + (-1);
            if (this.f1296t && this.f1290n && this.f1289m) {
                m999a(this.f1279c.get(this.f1283g - 1), this.f1284h);
            }
        } else {
            this.f1284h = null;
            this.f1288l = true;
        }
        m1001a(this.f1283g == size - 1);
        Intent intent = new Intent("com.xcglobe.action.main");
        intent.putExtra("event", 6);
        App.m443b().sendBroadcast(intent);
        return true;
    }

    /* renamed from: h */
    public float m1006h() {
        float f2 = 0.0f;
        for (int i2 = 1; i2 < this.f1279c.size(); i2++) {
            C0229c c0229c = this.f1279c.get(i2);
            C0229c c0229c2 = this.f1279c.get(i2 - 1);
            f2 += C0369i.m1248b(c0229c.f1976i, c0229c.f1977j, c0229c2.f1976i, c0229c2.f1977j);
        }
        return f2;
    }

    /* renamed from: i */
    public void m1007i() {
        float f2;
        float f3;
        this.f1301y = 0.0f;
        this.f1300x = 0.0f;
        int size = this.f1279c.size();
        if (size == 0) {
            return;
        }
        C0229c m994m = m994m();
        if (!this.f1289m || size < 2 || m994m == null) {
            this.f1291o = null;
        } else {
            m989b(m994m, this.f1279c.get(size - 1));
        }
        m993l();
        m995n();
        m995n();
        for (int i2 = 1; i2 < size; i2++) {
            C0229c c0229c = this.f1279c.get(i2 - 1);
            C0229c c0229c2 = this.f1279c.get(i2);
            float m1248b = C0369i.m1248b(c0229c.f1976i, c0229c.f1977j, c0229c2.f1976i, c0229c2.f1977j);
            if (i2 == 1) {
                f2 = c0229c.f1976i;
                f3 = c0229c.f1977j;
            } else {
                f2 = c0229c.f1318h.f2053a;
                f3 = c0229c.f1318h.f2054b;
            }
            float m1248b2 = C0369i.m1248b(f2, f3, c0229c2.f1318h.f2053a, c0229c2.f1318h.f2054b);
            c0229c2.f1313c = m1248b2;
            c0229c2.f1314d = m1248b;
            c0229c2.f1312b += m1248b2;
            this.f1300x += m1248b2;
            this.f1301y += m1248b;
        }
    }

    /* renamed from: j */
    public C0229c m1008j() {
        if (this.f1283g < this.f1279c.size() - 1) {
            return this.f1279c.get(this.f1283g + 1);
        }
        return null;
    }

    /* renamed from: k */
    public long m1009k() {
        C0229c c0229c = this.f1279c.get(0);
        C0229c c0229c2 = this.f1279c.get(this.f1286j);
        return 0L; // float cast fix
    }
}
