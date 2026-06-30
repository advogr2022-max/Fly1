package types;

/* renamed from: types.i */
/* loaded from: classes.dex */
public class C0369i {

    /* renamed from: a */
    public static float f2020a = 1.5f;

    /* renamed from: b */
    public static float f2021b = 6371.0f;

    /* renamed from: a */
    public static int m1243a(float f2, float f3, float f4, float f5) {
        double d2 = f4 - f2;
        double d3 = f2020a;
        Double.isNaN(d2);
        Double.isNaN(d3);
        double degrees = Math.toDegrees(Math.atan2(f5 - f3, d2 * d3));
        if (degrees < 0.0d) {
            degrees += 360.0d;
        }
        return (int) degrees;
    }

    /* renamed from: a */
    public static int m1244a(GpsVal gpsVal, GpsVal gpsVal2) {
        double d2 = gpsVal2.f1973b - gpsVal.f1973b;
        double d3 = gpsVal2.f1972a - gpsVal.f1972a;
        double d4 = f2020a;
        Double.isNaN(d3);
        Double.isNaN(d4);
        double degrees = Math.toDegrees(Math.atan2(d2, d3 * d4));
        if (degrees < 0.0d) {
            degrees += 360.0d;
        }
        return (int) degrees;
    }

    /* renamed from: a */
    public static void m1245a(float f2) {
        f2020a = m1248b(f2, 0.0f, f2 + 1.0f, 0.0f) / m1248b(f2, 0.0f, f2, 1.0f);
    }

    /* renamed from: a */
    public static void m1246a(float f2, float f3, float f4, C0367g c0367g) {
        float m1248b = f2 / m1248b(f3, 0.0f, f3, 1.0f);
        float f5 = m1248b / f2020a;
        c0367g.f2012a = f3 - f5;
        c0367g.f2013b = f3 + f5;
        c0367g.f2014c = f4 - m1248b;
        c0367g.f2015d = f4 + m1248b;
    }

    /* renamed from: b */
    public static float m1247b(float f2) {
        return m1248b(f2, 0.0f, f2 + 1.0f, 0.0f) / m1248b(f2, 0.0f, f2, 1.0f);
    }

    /* renamed from: b */
    public static float m1248b(float f2, float f3, float f4, float f5) {
        double d2 = f2;
        Double.isNaN(d2);
        double d3 = (d2 * 3.141592653589793d) / 180.0d;
        double d4 = f4;
        Double.isNaN(d4);
        double d5 = (d4 * 3.141592653589793d) / 180.0d;
        double d6 = f3;
        Double.isNaN(d6);
        double d7 = f5;
        Double.isNaN(d7);
        double asin = Math.asin(Math.sqrt(Math.pow(Math.sin((d3 - d5) / 2.0d), 2.0d) + (Math.cos(d3) * Math.cos(d5) * Math.pow(Math.sin((((d6 * 3.141592653589793d) / 180.0d) - ((d7 * 3.141592653589793d) / 180.0d)) / 2.0d), 2.0d)))) * 2.0d;
        double d8 = f2021b;
        Double.isNaN(d8);
        return (float) (asin * d8);
    }

    /* renamed from: b */
    public static float m1249b(GpsVal gpsVal, GpsVal gpsVal2) {
        double d2 = gpsVal.f1972a;
        Double.isNaN(d2);
        double d3 = (d2 * 3.141592653589793d) / 180.0d;
        double d4 = gpsVal2.f1972a;
        Double.isNaN(d4);
        double d5 = (d4 * 3.141592653589793d) / 180.0d;
        double d6 = gpsVal.f1973b;
        Double.isNaN(d6);
        double d7 = gpsVal2.f1973b;
        Double.isNaN(d7);
        double asin = Math.asin(Math.sqrt(Math.pow(Math.sin((d3 - d5) / 2.0d), 2.0d) + (Math.cos(d3) * Math.cos(d5) * Math.pow(Math.sin((((d6 * 3.141592653589793d) / 180.0d) - ((d7 * 3.141592653589793d) / 180.0d)) / 2.0d), 2.0d)))) * 2.0d;
        double d8 = f2021b;
        Double.isNaN(d8);
        return (float) (asin * d8);
    }
}
