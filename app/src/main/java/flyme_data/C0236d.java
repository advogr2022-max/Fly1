package flyme_data;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.ActivityMain;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0101l;
import com.xcglobe.xclog.FlyMeService;
import java.util.List;
import flyme_apphelper.C0072a;
import flyme_misc.C0205c;

/* renamed from: m.d */
/* loaded from: classes.dex */
public class C0236d {

    /* renamed from: a */
    public static int f1339a = 0;

    /* renamed from: b */
    public static boolean f1340b = false;

    /* renamed from: c */
    public static int f1341c = 0;

    /* renamed from: g */
    private static boolean f1345g = false;

    /* renamed from: h */
    private static boolean f1346h = false;

    /* renamed from: i */
    private static C0205c f1347i = new C0205c(1.0f);

    /* renamed from: d */
    public static boolean f1342d = true;

    /* renamed from: e */
    public static boolean f1343e = false;

    /* renamed from: f */
    public static boolean f1344f = false;

    /* renamed from: j */
    private static LocationListener f1348j = new LocationListener() { // from class: m.d.1
        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            float f2;
            float f3;
            int i2;
            if (C0072a.m378a()) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            C0239g.f1419l = location.hasAccuracy() ? location.getAccuracy() : 0.0f;
            float latitude = (float) location.getLatitude();
            float longitude = (float) location.getLongitude();
            if (C0236d.f1343e) {
                C0236d.f1347i.m871a(latitude, longitude, C0239g.f1419l, currentTimeMillis);
                float m870a = C0236d.f1347i.m870a();
                f3 = C0236d.f1347i.m872b();
                f2 = m870a;
            } else {
                f2 = latitude;
                f3 = longitude;
            }
            if (!C0236d.f1340b) {
                C0236d.f1339a = C0234b.m1036a(f2, f3);
            }
            int altitude = ((int) (location.getAltitude() + 0.5d)) - C0236d.f1339a;
            C0236d.f1341c = location.getExtras().getInt("satellites");
            if (C0236d.f1342d && location.hasSpeed()) {
                double speed = location.getSpeed();
                Double.isNaN(speed);
                i2 = (int) ((speed * 3.6d) + 0.5d);
            } else {
                i2 = -1;
            }
            C0239g.m1063a(f2, f3, (short) altitude, currentTimeMillis, i2);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            boolean unused = C0236d.f1345g = false;
            ActivityMain.m413a(8);
            FlyMeService.m457a();
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            boolean unused = C0236d.f1345g = true;
            ActivityMain.m413a(8);
            FlyMeService.m457a();
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i2, Bundle bundle) {
            if (i2 != 2) {
                return;
            }
            boolean unused = C0236d.f1345g = true;
        }
    };

    /* renamed from: a */
    public static void m1041a() {
        m1048e();
        FlyMeService.m457a();
    }

    /* renamed from: a */
    public static void m1042a(Activity activity) {
        f1345g = false;
        f1346h = false;
        f1339a = 0;
        f1340b = false;
        if (m1052i()) {
            f1345g = true;
        } else {
            m1045b(activity);
        }
    }

    /* renamed from: b */
    public static void m1044b() {
        m1049f();
    }

    /* renamed from: b */
    public static void m1045b(final Activity activity) {
        final App app = (App) activity.getApplicationContext();
        App.m436a(new AlertDialog.Builder(activity).setTitle(R.string.gps_settings).setMessage(R.string.gps_settings_ask).setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() { // from class: m.d.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                App app2 = app;
                App.m445b((Dialog) dialogInterface);
                Intent intent = new Intent("android.settings.LOCATION_SOURCE_SETTINGS");
                intent.addFlags(268435456);
                activity.startActivity(intent);
            }
        }).setNegativeButton(R.string.no, new DialogInterface.OnClickListener() { // from class: m.d.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                App app2 = app;
                App.m445b((Dialog) dialogInterface);
            }
        }).create());
    }

    /* renamed from: c */
    public static boolean m1046c() {
        return f1346h && f1345g;
    }

    /* renamed from: d */
    public static void m1047d() {
        m1049f();
        m1048e();
        f1340b = false;
    }

    /* renamed from: e */
    static void m1048e() {
        LocationManager locationManager;
        if (!f1344f || C0239g.f1382M || (locationManager = (LocationManager) App.m443b().getSystemService("location")) == null) {
            return;
        }
        long j2 = 1000;
        int i2 = 0;
        if (C0101l.f565ao) {
            j2 = C0101l.f558ah;
            i2 = 10;
        }
        locationManager.requestLocationUpdates("gps", j2, i2, f1348j);
        f1346h = true;
    }

    /* renamed from: f */
    static void m1049f() {
        if (f1346h) {
            ((LocationManager) App.m443b().getSystemService("location")).removeUpdates(f1348j);
        }
        f1346h = false;
    }

    /* renamed from: g */
    public static float[] m1050g() {
        float[] fArr = {45.95f, 13.7f};
        if (!f1344f) {
            return fArr;
        }
        LocationManager locationManager = (LocationManager) App.m443b().getSystemService("location");
        List<String> providers = locationManager.getProviders(true);
        Location location = null;
        for (int size = providers.size() - 1; size >= 0; size--) {
            location = locationManager.getLastKnownLocation(providers.get(size));
            if (location != null) {
                break;
            }
        }
        if (location != null) {
            fArr[0] = (float) location.getLatitude();
            fArr[1] = (float) location.getLongitude();
        }
        return fArr;
    }

    /* renamed from: i */
    private static boolean m1052i() {
        LocationManager locationManager = (LocationManager) App.m443b().getSystemService("location");
        return locationManager != null && locationManager.isProviderEnabled("gps");
    }
}
