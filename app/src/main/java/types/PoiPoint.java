package types;

/* loaded from: classes.dex */
public class PoiPoint {

    /* renamed from: i */
    public float f1976i;

    /* renamed from: j */
    public float f1977j;

    /* renamed from: k */
    public short f1978k;

    /* renamed from: l */
    public String f1979l;

    /* renamed from: m */
    public char f1980m;

    /* renamed from: a */
    public void m1170a(float f2, float f3, short s, String str, char c2) {
        this.f1976i = f2;
        this.f1977j = f3;
        this.f1978k = s;
        this.f1979l = str;
        this.f1980m = c2;
    }

    /* renamed from: a */
    public void m1171a(PoiPoint poiPoint) {
        this.f1976i = poiPoint.f1976i;
        this.f1977j = poiPoint.f1977j;
        this.f1978k = poiPoint.f1978k;
        this.f1979l = poiPoint.f1979l;
        this.f1980m = poiPoint.f1980m;
    }

    /* renamed from: b */
    public boolean m1172b(PoiPoint poiPoint) {
        return poiPoint != null && ((int) ((poiPoint.f1976i - this.f1976i) * 100000.0f)) == 0 && ((int) ((poiPoint.f1977j - this.f1977j) * 100000.0f)) == 0 && poiPoint.f1979l.equals(this.f1979l);
    }
}
