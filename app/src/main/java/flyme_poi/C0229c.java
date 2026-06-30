package flyme_poi;

import types.C0372l;
import types.PoiPoint;

/* renamed from: k.c */
/* loaded from: classes.dex */
public class C0229c extends PoiPoint {

    /* renamed from: a */
    public float f1311a;

    /* renamed from: b */
    public float f1312b;

    /* renamed from: c */
    public float f1313c;

    /* renamed from: d */
    public float f1314d;

    /* renamed from: e */
    public boolean f1315e = false;

    /* renamed from: f */
    public boolean f1316f = false;

    /* renamed from: g */
    public boolean f1317g = false;

    /* renamed from: h */
    public C0372l f1318h = null;

    /* renamed from: a */
    public String m1014a() {
        return this.f1979l + '#' + this.f1980m + '#' + this.f1976i + '#' + this.f1977j + '#' + ((int) this.f1978k) + '#' + ((int) (this.f1311a * 1000.0f));
    }

    /* renamed from: a */
    public void m1015a(C0229c c0229c) {
        m1171a((PoiPoint) c0229c);
        this.f1311a = c0229c.f1311a;
        this.f1312b = c0229c.f1312b;
        this.f1315e = c0229c.f1315e;
        if (c0229c.f1318h != null) {
            this.f1318h = new C0372l(c0229c.f1318h);
        }
    }

    /* renamed from: b */
    public C0372l m1016b() {
        if (this.f1318h == null) {
            this.f1318h = new C0372l(this.f1976i, this.f1977j);
        }
        return this.f1318h;
    }
}
