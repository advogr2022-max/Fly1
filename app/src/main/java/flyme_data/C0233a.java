package flyme_data;

import android.annotation.TargetApi;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0101l;
import flyme_apphelper.C0072a;
import flyme_misc.C0203a;

/* renamed from: m.a */
/* loaded from: classes.dex */
public class C0233a {

    /* renamed from: a */
    public static long f1322a = 0;

    /* renamed from: b */
    private static boolean f1323b = false;

    /* renamed from: c */
    private static boolean f1324c;

    /* renamed from: d */
    private static a f1325d;

    /* renamed from: e */
    private static final C0203a f1326e = new C0203a(1000, 0.1f);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: m.a$a */
    /* loaded from: classes.dex */
    public static class a implements SensorEventListener {
        a() {
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // android.hardware.SensorEventListener
        @TargetApi(9)
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (C0072a.m378a()) {
                return;
            }
            boolean unused = C0233a.f1323b = true;
            C0233a.f1322a = System.currentTimeMillis();
            float f2 = sensorEvent.values[0];
            C0239g.m1062a(C0239g.f1370A.m1053a(C0233a.f1326e.mo866a(f2 != 0.0f ? SensorManager.getAltitude(1013.25f, f2) : 0.0f, C0233a.f1322a)), C0233a.f1326e.f1046c, C0233a.f1322a);
        }
    }

    /* renamed from: a */
    public static void m1028a() {
        f1324c = Build.VERSION.SDK_INT >= 9;
    }

    /* renamed from: b */
    public static void m1030b() {
        C0203a c0203a;
        int i2;
        float f2;
        if (C0101l.f533R) {
            c0203a = f1326e;
            i2 = 1000;
            f2 = 0.1f;
        } else {
            c0203a = f1326e;
            i2 = 500;
            f2 = 0.05f;
        }
        c0203a.m868a(i2, f2);
        if (!f1324c || f1325d != null || !C0101l.f524I || C0239g.f1381L) {
            if (C0101l.f524I) {
                return;
            }
            m1033e();
            return;
        }
        SensorManager sensorManager = (SensorManager) App.m443b().getSystemService("sensor");
        Sensor defaultSensor = sensorManager.getDefaultSensor(6);
        if (defaultSensor != null) {
            f1325d = new a();
            if (sensorManager.registerListener(f1325d, defaultSensor, 3)) {
                return;
            }
            f1325d = null;
        }
    }

    /* renamed from: c */
    public static boolean m1031c() {
        return f1325d != null;
    }

    /* renamed from: d */
    public static boolean m1032d() {
        return f1323b && f1325d != null;
    }

    /* renamed from: e */
    public static void m1033e() {
        if (f1325d != null) {
            ((SensorManager) App.m443b().getSystemService("sensor")).unregisterListener(f1325d);
        }
        f1325d = null;
        f1323b = false;
    }

    /* renamed from: f */
    public static void m1034f() {
        m1033e();
        m1030b();
    }
}
