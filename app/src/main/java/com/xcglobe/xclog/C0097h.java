package com.xcglobe.xclog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import flyme_tasks.AsyncTaskC0061b;
import flyme_intentutil.C0225a;
import flyme_data.C0239g;
import types.C0366f;
import types.C0367g;
import types.C0369i;
import types.C0373m;
import types.GpsVal;
import types.PoiPoint;

/* renamed from: com.xcglobe.xclog.h */
/* loaded from: classes.dex */
public class C0097h {

    /* renamed from: c */
    public static int f496c;

    /* renamed from: a */
    public C0367g f497a = new C0367g();

    /* renamed from: b */
    public PoiPoint[] f498b = new PoiPoint[0];

    /* renamed from: g */
    private GpsVal f502g = new GpsVal();

    /* renamed from: h */
    private C0367g f503h = new C0367g();

    /* renamed from: d */
    public PoiPoint[] f499d = new PoiPoint[0];

    /* renamed from: e */
    public int[] f500e = new int[0];

    /* renamed from: f */
    public float f501f = 10.0f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.xcglobe.xclog.h$a */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a */
        int f506a;

        /* renamed from: b */
        int f507b;

        a() {
        }
    }

    /* renamed from: a */
    public void m502a() {
        int length = this.f499d.length;
        a[] aVarArr = new a[length];
        for (int i2 = 0; i2 < length; i2++) {
            PoiPoint poiPoint = this.f499d[i2];
            aVarArr[i2] = new a();
            aVarArr[i2].f506a = i2;
            aVarArr[i2].f507b = (int) (C0369i.m1248b(poiPoint.f1976i, poiPoint.f1977j, this.f502g.f1972a, this.f502g.f1973b) * 1000.0f);
        }
        Arrays.sort(aVarArr, new Comparator<a>() { // from class: com.xcglobe.xclog.h.1
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(a aVar, a aVar2) {
                int i3 = aVar.f507b;
                int i4 = aVar2.f507b;
                if (i3 > i4) {
                    return 1;
                }
                return i3 == i4 ? 0 : -1;
            }
        });
        PoiPoint[] poiPointArr = new PoiPoint[length];
        this.f500e = null;
        this.f500e = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            poiPointArr[i3] = this.f499d[aVarArr[i3].f506a];
            this.f500e[i3] = aVarArr[i3].f507b;
        }
        for (int i4 = 0; i4 < length; i4++) {
            this.f499d[i4] = poiPointArr[i4];
        }
    }

    /* renamed from: a */
    public void m503a(float f2, float f3, short s) {
        C0367g c0367g = new C0367g();
        C0369i.m1246a(0.5f, f2, f3, c0367g);
        PoiPoint poiPoint = null;
        float f4 = 9999.0f;
        for (int i2 = 0; i2 < this.f498b.length; i2++) {
            if (c0367g.m1227a(this.f498b[i2])) {
                float m1248b = C0369i.m1248b(f2, f3, this.f498b[i2].f1976i, this.f498b[i2].f1977j);
                if (m1248b < f4) {
                    poiPoint = this.f498b[i2];
                    f4 = m1248b;
                }
            }
        }
        if (poiPoint != null) {
            poiPoint.f1976i = f2;
            poiPoint.f1977j = f3;
            poiPoint.f1978k = s;
        } else {
            PoiPoint poiPoint2 = new PoiPoint();
            poiPoint2.m1170a(f2, f3, s, "", 't');
            ArrayList arrayList = new ArrayList(Arrays.asList(this.f498b));
            arrayList.add(poiPoint2);
            this.f498b = (PoiPoint[]) arrayList.toArray(this.f498b);
            m505a(this.f501f, C0239g.m1073d(), true, false, false);
        }
    }

    /* renamed from: a */
    public boolean m504a(float f2, GpsVal gpsVal, boolean z, boolean z2) {
        return m505a(f2, gpsVal, z, z2, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0078  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m505a(float f2, GpsVal gpsVal, boolean z, boolean z2, boolean z3) {
        boolean z4 = false;
        int length = this.f498b.length;
        this.f502g.f1972a = gpsVal.f1972a;
        this.f502g.f1973b = gpsVal.f1973b;
        this.f501f = f2;
        AsyncTaskC0061b.m308a(gpsVal.f1972a, gpsVal.f1973b, false);
        ArrayList arrayList = new ArrayList();
        C0367g c0367g = new C0367g();
        C0369i.m1246a(f2, gpsVal.f1972a, gpsVal.f1973b, c0367g);
        for (int i2 = 0; i2 < length; i2++) {
            PoiPoint poiPoint = this.f498b[i2];
            if (z || poiPoint.f1980m != 't') {
                char c2 = poiPoint.f1980m;
                if (c2 == 'c') {
                    if (!C0101l.f570at) {
                    }
                    if (z3) {
                    }
                    if (!z4) {
                    }
                    if (z2) {
                    }
                    arrayList.add(poiPoint);
                } else if (c2 == 'l') {
                    if (!C0101l.f571au) {
                    }
                    if (z3) {
                    }
                    if (!z4) {
                    }
                    if (z2) {
                    }
                    arrayList.add(poiPoint);
                } else if (c2 != 's') {
                    if (c2 == 'w' && !C0101l.f572av) {
                    }
                    z4 = !z3 && poiPoint.f1980m == 'w';
                    if (!z4 || c0367g.m1227a(poiPoint)) {
                        if (z2) {
                            float m1248b = C0369i.m1248b(poiPoint.f1976i, poiPoint.f1977j, gpsVal.f1972a, gpsVal.f1973b);
                            if (!z4 && m1248b > f2) {
                            }
                        }
                        arrayList.add(poiPoint);
                    }
                } else {
                    if (!C0101l.f569as) {
                    }
                    if (z3) {
                    }
                    if (!z4) {
                    }
                    if (z2) {
                    }
                    arrayList.add(poiPoint);
                }
            }
        }
        this.f499d = null;
        this.f499d = (PoiPoint[]) arrayList.toArray(new PoiPoint[0]);
        C0369i.m1246a(f2 * 0.75f, gpsVal.f1972a, gpsVal.f1973b, this.f503h);
        return this.f497a.m1231b(gpsVal.f1972a, gpsVal.f1973b);
    }

    /* renamed from: a */
    public boolean m506a(GpsVal gpsVal) {
        return this.f503h.m1232b(gpsVal);
    }

    /* renamed from: b */
    public void m507b() {
        Arrays.sort(this.f499d, new Comparator<PoiPoint>() { // from class: com.xcglobe.xclog.h.2
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(PoiPoint poiPoint, PoiPoint poiPoint2) {
                return poiPoint.f1979l.compareTo(poiPoint2.f1979l);
            }
        });
        int length = this.f499d.length;
        this.f500e = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            PoiPoint poiPoint = this.f499d[i2];
            this.f500e[i2] = (int) (C0369i.m1248b(poiPoint.f1976i, poiPoint.f1977j, this.f502g.f1972a, this.f502g.f1973b) * 1000.0f);
        }
    }

    /* renamed from: c */
    public void m508c() {
        ArrayList arrayList = new ArrayList();
        C0373m c0373m = (C0366f.f2003a == null || C0366f.f2003a.f1980m != 'l') ? null : (C0373m) C0366f.f2003a;
        for (int i2 = 0; i2 < C0225a.f1256a.size(); i2++) {
            C0373m c0373m2 = C0225a.f1256a.get(i2);
            C0373m c0373m3 = new C0373m();
            c0373m3.m1171a(c0373m2);
            c0373m3.f2055a = c0373m2.f2055a;
            arrayList.add(c0373m3);
            if (c0373m != null && c0373m.f2055a == c0373m3.f2055a) {
                c0373m.m1171a(c0373m3);
            }
        }
        for (int i3 = 0; i3 < this.f498b.length; i3++) {
            PoiPoint poiPoint = this.f498b[i3];
            if (poiPoint.f1980m != 'l') {
                arrayList.add(poiPoint);
            }
        }
        this.f498b = null;
        this.f498b = (PoiPoint[]) arrayList.toArray(new PoiPoint[0]);
        m505a(this.f501f, C0239g.m1073d(), true, false, false);
    }
}
