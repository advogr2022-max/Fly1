package flyme_poi;

import com.xcglobe.xclog.C0101l;
import flyme_io.C0221d;
import types.C0364d;
import types.C0365e;
import types.C0372l;
import types.Coord;
import types.GpsVal;

/* renamed from: k.b */
/* loaded from: classes.dex */
public class C0228b {

    /* renamed from: b */
    int f1303b;

    /* renamed from: e */
    long f1306e;

    /* renamed from: a */
    C0221d f1302a = null;

    /* renamed from: c */
    C0372l f1304c = new C0372l();

    /* renamed from: d */
    GpsVal f1305d = new GpsVal();

    /* renamed from: f */
    long f1307f = 4000;

    /* renamed from: g */
    float f1308g = 23.0f;

    /* renamed from: h */
    float f1309h = C0101l.f528M;

    /* renamed from: i */
    long f1310i = 0;

    /* renamed from: a */
    private void m1010a() {
        this.f1305d.f1974c = (short) this.f1303b;
        this.f1305d.f1972a = this.f1304c.f2053a;
        this.f1305d.f1973b = this.f1304c.f2054b;
        this.f1305d.f1975d += this.f1307f;
        this.f1302a.m958a(this.f1305d, 0);
    }

    /* renamed from: a */
    public long m1011a(C0227a c0227a) {
        GpsVal gpsVal = this.f1305d;
        this.f1306e = 36000000L;
        gpsVal.f1975d = 36000000L;
        this.f1302a = new C0221d("demo-task.igc");
        int size = c0227a.f1279c.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0229c c0229c = c0227a.f1279c.get(i2);
            if (i2 == 0) {
                this.f1304c.m1258a(c0229c.f1976i, c0229c.f1977j);
                this.f1303b = c0229c.f1978k;
                m1010a();
                if (this.f1303b < 1000) {
                    this.f1303b = 1000;
                }
                if (c0227a.f1280d && c0229c.f1316f) {
                    m1012a(c0229c.f1318h.f2053a, c0229c.f1318h.f2054b, false);
                    this.f1310i = this.f1305d.f1975d - this.f1306e;
                    m1013a(200, 180000L);
                    m1012a(c0229c.f1318h.f2053a, c0229c.f1318h.f2054b, false);
                } else {
                    m1013a(200, 180000L);
                    double d2 = this.f1305d.f1975d - this.f1306e;
                    Double.isNaN(d2);
                    this.f1310i = (long) (d2 * 0.5d);
                }
            } else if (i2 < size - 1) {
                m1012a(((c0229c.f1318h.f2053a * 7.0f) + c0229c.f1976i) / 8.0f, ((c0229c.f1318h.f2054b * 7.0f) + c0229c.f1977j) / 8.0f, false);
            } else {
                m1012a(c0229c.f1976i, c0229c.f1977j, true);
                m1013a(-15, 300000L);
            }
        }
        this.f1302a.m963c();
        return this.f1310i;
    }

    /* renamed from: a */
    public void m1012a(float f2, float f3, boolean z) {
        double d2;
        C0364d c0364d = new C0364d(this.f1304c.f2053a, this.f1304c.f2054b);
        Coord coord = new Coord();
        c0364d.m1195a(f2, f3, coord);
        Coord coord2 = new Coord();
        c0364d.m1197a(this.f1304c, coord2);
        double m1204a = C0365e.m1204a(coord, coord2);
        if (m1204a < 0.001d) {
            return;
        }
        double d3 = this.f1309h;
        Double.isNaN(m1204a);
        Double.isNaN(d3);
        double d4 = (m1204a / d3) * 3600.0d;
        double d5 = this.f1307f / 1000;
        Double.isNaN(d5);
        double d6 = d4 / d5;
        double d7 = coord.f1970a - coord2.f1970a;
        double d8 = coord.f1971b - coord2.f1971b;
        Double.isNaN(d7);
        double d9 = d7 / d6;
        Double.isNaN(d8);
        double d10 = d8 / d6;
        if (z) {
            double d11 = this.f1307f;
            Double.isNaN(d11);
            d2 = (30000.0d / d11) + d6;
        } else {
            d2 = d6;
        }
        int i2 = this.f1303b;
        double d12 = d2 / 4.0d;
        double random = Math.random() * d12;
        double random2 = Math.random() * d12;
        double d13 = 0.0d;
        double d14 = 0.0d;
        double d15 = 0.0d;
        int i3 = 0;
        while (true) {
            double d16 = i3;
            if (d16 > d2) {
                return;
            }
            Double.isNaN(d16);
            double sin = Math.sin((3.141592653589793d * d16) / d6);
            if (d16 >= d6) {
                sin = 0.0d;
            }
            Double.isNaN(d16);
            double d17 = d9;
            coord2.f1970a = (float) (d16 * (d9 + (d13 * sin)));
            Double.isNaN(d16);
            coord2.f1971b = (float) (d16 * (d10 + (sin * d14)));
            if (d16 < d6) {
                Math.random();
                Math.random();
                Double.isNaN(d16);
                double sin2 = Math.sin(((d16 + random) * 3.14d) / d12) * 0.001d;
                Double.isNaN(d16);
                d14 = Math.sin(((d16 + random2) * 3.14d) / d12) * 0.001d;
                d13 = sin2;
            } else {
                d13 /= 10.0d;
                d14 /= 10.0d;
            }
            c0364d.m1196a(coord2, this.f1304c);
            this.f1303b = i2 + ((int) (200.0d * Math.sin(d15)));
            d15 += 0.015700001269578934d;
            m1010a();
            i3++;
            d9 = d17;
        }
    }

    /* renamed from: a */
    public void m1013a(int i2, long j2) {
        C0364d c0364d = new C0364d(this.f1304c.f2053a, this.f1304c.f2054b);
        c0364d.m1197a(this.f1304c, new Coord());
        Coord coord = new Coord();
        long j3 = this.f1305d.f1975d + j2;
        double d2 = 0.05f;
        double random = ((float) Math.random()) * 6.0f;
        double sin = Math.sin(random);
        Double.isNaN(d2);
        coord.f1970a = (float) (sin * d2);
        double cos = Math.cos(random);
        Double.isNaN(d2);
        coord.f1971b = (float) (cos * d2);
        C0372l c0372l = new C0372l();
        c0364d.m1196a(coord, c0372l);
        m1012a(c0372l.f2053a, c0372l.f2054b, false);
        Double.isNaN(d2);
        double d3 = this.f1308g;
        Double.isNaN(d3);
        float f2 = (float) (((long) ((22619.46710584651d * d2) / d3)) / (this.f1307f / 1000));
        if (f2 < 2.0f) {
            f2 = 2.0f;
        }
        double d4 = f2;
        Double.isNaN(d4);
        float f3 = (float) (6.283185307179586d / d4);
        if (f3 < 0.3d) {
            f3 = 0.3f;
        }
        float f4 = i2 / f2;
        float f5 = 0.0f;
        while (this.f1305d.f1975d <= j3) {
            double d5 = f5;
            double random2 = Math.random() / 4.0d;
            Double.isNaN(d5);
            double sin2 = Math.sin(random2 + d5);
            Double.isNaN(d2);
            coord.f1970a = (float) (sin2 * d2);
            double random3 = Math.random() / 4.0d;
            Double.isNaN(d5);
            double cos2 = Math.cos(d5 + random3);
            Double.isNaN(d2);
            coord.f1971b = (float) (cos2 * d2);
            c0364d.m1196a(coord, this.f1304c);
            int i3 = (int) (this.f1303b + f4);
            this.f1303b = i3;
            if (i3 < 100) {
                this.f1303b = 100;
            } else if (this.f1303b > 3000) {
                f4 = -2.0f;
            }
            m1010a();
            f5 += f3;
        }
    }
}
