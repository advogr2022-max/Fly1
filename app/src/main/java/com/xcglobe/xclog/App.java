package com.xcglobe.xclog;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import android.widget.Button;
import com.xcglobe.flyme.R;
import display.vmap.ViewVmp;
import java.io.File;
import java.util.ArrayList;
import flyme_tasks.AsyncTaskC0061b;
import flyme_tasks.AsyncTaskC0066g;
import flyme_tasks.AsyncTaskC0071l;
import flyme_tasks.C0062c;
import flyme_apphelper.C0072a;
import flyme_device.C0172d;
import flyme_intentutil.C0225a;
import flyme_poi.C0227a;
import flyme_data.C0233a;
import flyme_data.C0236d;
import flyme_data.C0239g;
import vmaps.C0379a;
import vmaps.C0391d;

/* loaded from: classes.dex */
public class App extends Application {

    /* renamed from: a */
    static App f460a;

    /* renamed from: b */
    public static int f461b;

    /* renamed from: d */
    private static Activity f463d;

    /* renamed from: e */
    private static ArrayList<Dialog> f464e = new ArrayList<>();

    /* renamed from: c */
    public static final Handler f462c = new Handler() { // from class: com.xcglobe.xclog.App.1
    };

    /* renamed from: a */
    public static Activity m434a() {
        return f463d;
    }

    /* renamed from: a */
    public static String m435a(int i2) {
        return f460a.getResources().getString(i2);
    }

    /* renamed from: a */
    public static void m436a(Dialog dialog) {
        try {
            m437a(dialog, 0);
        } catch (Exception e) {
            e.printStackTrace();
            f464e.remove(dialog);
        }
    }

    /* renamed from: a */
    public static void m437a(Dialog dialog, int i2) {
        f464e.add(dialog);
        if (i2 == 0) {
            dialog.show();
            return;
        }
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(dialog.getWindow().getAttributes());
        layoutParams.width = i2 < 0 ? -((int) ((C0101l.f575ay * i2) / 100.0f)) : (int) ((C0101l.f574ax * i2) / 100.0f);
        dialog.show();
        dialog.getWindow().setAttributes(layoutParams);
    }

    /* renamed from: a */
    public static void m438a(ActivityMain activityMain) {
        C0101l.f567aq = TypedValue.applyDimension(1, 1.0f, activityMain.getResources().getDisplayMetrics());
        activityMain.setTheme(R.style.AppThemeWhite);
        Resources resources = m443b().getResources();
        C0101l.f588m = resources.getColor(R.color.green2);
        C0101l.f589n = resources.getColor(R.color.yellow2);
        C0101l.f590o = resources.getColor(R.color.blue2);
        C0101l.f592q = resources.getColor(R.color.back2);
        C0101l.f591p = resources.getColor(R.color.text2);
        C0101l.f595t = resources.getColor(R.color.poi2);
        C0101l.f585j = resources.getColor(R.color.red2);
        C0101l.f593r = resources.getColor(R.color.backgray2);
        C0101l.f594s = resources.getColor(R.color.textgray2);
        C0101l.f596u = resources.getColor(R.color.back);
        C0101l.f597v = resources.getColor(R.color.ground);
        C0101l.f516A = C0101l.f594s;
        C0101l.f598w = resources.getColor(R.color.sky);
        C0101l.f599x = resources.getColor(R.color.black);
        C0101l.f600y = resources.getColor(R.color.textgray);
        C0101l.f586k = resources.getColor(R.color.darkred);
        C0101l.f587l = resources.getColor(R.color.lightred);
        C0101l.f601z = resources.getColor(R.color.greenblue);
        C0101l.f517B = C0101l.f585j;
        C0101l.f518C = Color.parseColor("#ff8000");
        C0101l.f519D = Color.parseColor("#ffe040");
        C0101l.f580e = (int) new Button(activityMain).getTextSize();
        Display defaultDisplay = activityMain.getWindowManager().getDefaultDisplay();
        C0101l.f573aw = defaultDisplay.getHeight();
        C0101l.f574ax = defaultDisplay.getWidth();
        if (C0101l.f574ax < C0101l.f573aw) {
            C0101l.f575ay = C0101l.f574ax;
            C0101l.f576az = C0101l.f573aw;
            C0101l.f543aA = true;
        } else {
            C0101l.f575ay = C0101l.f573aw;
            C0101l.f576az = C0101l.f574ax;
            C0101l.f543aA = false;
        }
        m446c();
        C0096g.m496a();
    }

    /* renamed from: a */
    public static void m439a(Class<?> cls) {
        f463d.startActivity(new Intent(f463d, cls));
    }

    /* renamed from: a */
    public static void m440a(String str) {
        boolean z = str == null;
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(f460a);
        if (z || str.equals("datasources")) {
            C0391d.m1413a();
            ActivityMain.f431b = true;
        }
        if (z || str.equals("display")) {
            C0101l.f555ae = defaultSharedPreferences.getBoolean("full_screen", false);
            C0101l.f556af = Integer.parseInt(defaultSharedPreferences.getString("screen_orientation", "0"));
            C0101l.f560aj = defaultSharedPreferences.getBoolean("display_vario_helpers", false);
            C0101l.f555ae = defaultSharedPreferences.getBoolean("full_screen", false);
            C0101l.f552ab = defaultSharedPreferences.getBoolean("enable_custombox", false);
            C0101l.f539X = defaultSharedPreferences.getBoolean("enable_gfx_vario", false);
            C0101l.f538W = Integer.parseInt(defaultSharedPreferences.getString("vario_volume", "100"));
            C0101l.f562al = defaultSharedPreferences.getBoolean("show_contours", false);
            C0101l.f554ad = Integer.parseInt(defaultSharedPreferences.getString("maps_colors", "0"));
            if (C0101l.f554ad == 1) {
                C0101l.f554ad = 0;
            }
        }
        if (z || str.equals("vario")) {
            C0101l.f538W = Integer.parseInt(defaultSharedPreferences.getString("vario_volume", "100"));
            C0101l.f532Q = defaultSharedPreferences.getBoolean("barometer_kalman_vario", true);
            C0101l.f534S = Integer.parseInt(defaultSharedPreferences.getString("vario_interval", "0"));
            C0101l.f533R = defaultSharedPreferences.getBoolean("barometer_stabilize_vario", true);
            C0101l.f535T = C0099j.m520b(defaultSharedPreferences, "sink_tone", "-3.0");
            if (C0101l.f535T > 0.0f) {
                C0101l.f535T = -C0101l.f535T;
            }
        }
        if (z || str.equals("advanced")) {
            C0101l.f540Y = Integer.parseInt(defaultSharedPreferences.getString("font_size", "0"));
            C0101l.f561ak = Integer.parseInt(defaultSharedPreferences.getString("infoboxes_size", "3"));
            C0101l.f558ah = Integer.parseInt(defaultSharedPreferences.getString("logging_interval", "4")) * 1000;
            C0101l.f557ag = Integer.parseInt(defaultSharedPreferences.getString("optimizer_interval", "1")) * 60000;
            C0101l.f559ai = Integer.parseInt(defaultSharedPreferences.getString("movement_detection_type", "0"));
            C0101l.f524I = defaultSharedPreferences.getBoolean("use_barometer", true);
            C0101l.f525J = C0099j.m514a(defaultSharedPreferences, "external_devmodel", "0") != 0.0f;
            C0236d.f1343e = defaultSharedPreferences.getBoolean("gps_use_filter", false);
            C0236d.f1342d = defaultSharedPreferences.getBoolean("use_gps_speed", false);
            C0101l.f537V = defaultSharedPreferences.getBoolean("enable_fai_assistant", true);
            C0101l.f536U = defaultSharedPreferences.getBoolean("enable_thermal_view", true);
            String string = defaultSharedPreferences.getString("airspace_set", "legal");
            if (!string.equals(C0379a.f2108a)) {
                C0379a.f2108a = string;
                AsyncTaskC0061b.m308a(C0239g.m1073d().f1972a, C0239g.m1073d().f1973b, true);
            }
        }
        if (z || str.equals("glider")) {
            C0101l.f526K = C0099j.m520b(defaultSharedPreferences, "glider_min_speed", "25");
            C0101l.f527L = C0099j.m520b(defaultSharedPreferences, "glider_min_speed_sink", "1.0");
            C0101l.f528M = C0099j.m520b(defaultSharedPreferences, "glider_optimal_speed", "38");
            C0101l.f529N = C0099j.m520b(defaultSharedPreferences, "glider_optimal_speed_sink", "1.1");
            C0101l.f530O = C0099j.m520b(defaultSharedPreferences, "glider_max_speed", "55");
            C0101l.f531P = C0099j.m520b(defaultSharedPreferences, "glider_max_speed_sink", "3.0");
            if (C0101l.f528M < 5.0f) {
                C0101l.f528M = 5.0f;
            }
        }
        if (z || str.equals("power")) {
            C0239g.f1377H = Long.parseLong(defaultSharedPreferences.getString("event_refresh_rate", "300"));
            C0239g.f1378I = defaultSharedPreferences.getBoolean("real_time_refresh_rate_thermaling", false);
            C0098i.f509a = Integer.parseInt(defaultSharedPreferences.getString("screen_power_mode", "0"));
            C0101l.f553ac = defaultSharedPreferences.getBoolean("enable_pocket_livetrack", true);
        }
        if (z || str.equals("livetrack")) {
            C0101l.f541Z = defaultSharedPreferences.getBoolean("enable_livetrack", false);
            C0101l.f551aa = Integer.parseInt(defaultSharedPreferences.getString("livetrack_time_interval", "60000"));
        }
        m450e();
    }

    /* renamed from: a */
    public static void m441a(String str, Exception exc) {
        exc.printStackTrace();
    }

    /* renamed from: a */
    public static void m442a(boolean z) {
        f461b = 2;
        C0172d.m663a();
        C0072a.m380b();
        C0239g.m1075f();
        C0099j.m527d("dirty_stop", null);
        m443b().stopService(new Intent(m443b(), (Class<?>) FlyMeService.class));
    }

    /* renamed from: b */
    public static App m443b() {
        return f460a;
    }

    /* renamed from: b */
    public static void m444b(Activity activity) {
        Thread.setDefaultUncaughtExceptionHandler(new C0093d());
        C0091b.m460a();
        C0239g.m1061a();
        C0236d.m1042a(activity);
        C0236d.m1041a();
        AsyncTaskC0066g.m348a(C0239g.m1073d());
        C0391d.m1413a();
        C0227a.m990e();
        String m480i = C0095f.m480i();
        String m515a = C0099j.m515a("last_run_version");
        m448d();
        if (!m480i.equals(m515a)) {
            C0091b.m461a("external.cfg", "config", true);
            C0091b.m461a("demo-task.cup", "tasks", false);
            C0091b.m461a("leonardo-glider-brand.txt", "", false);
            String str = C0101l.m558c() + "/demo.igc";
            C0091b.m461a("demo.igc", "igc", true);
        }
        C0099j.m527d("last_run_version", m480i);
        new File(C0101l.m537a("waypoints")).mkdirs();
        C0095f.m474c();
        AsyncTaskC0071l.m373b();
        AsyncTaskC0071l.m372a();
        C0172d.m673g();
        if (C0101l.f525J) {
            try {
                C0172d.m665a(activity.getApplicationContext(), C0099j.m521b("external_device_model"), C0099j.m515a("external_device_address"), C0239g.f1384O, activity);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        C0101l.m568f();
        Intent intent = new Intent(activity, (Class<?>) FlyMeService.class);
        intent.setAction("com.xcglobe.action.startservice");
        try {
            androidx.core.content.ContextCompat.startForegroundService(activity, intent);
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        f461b = 1;
        C0101l.m552b();
    }

    /* renamed from: b */
    public static void m445b(Dialog dialog) {
        try {
            dialog.dismiss();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        f464e.remove(dialog);
    }

    /* renamed from: c */
    public static void m446c() {
        float f2;
        C0101l.f578c = (int) (C0101l.f575ay / 26.0f);
        int i2 = (int) (C0101l.f580e / 1.5f);
        int i3 = (int) (C0101l.f580e * 1.5f);
        if (C0101l.f578c < i2) {
            C0101l.f578c = i2;
        } else if (C0101l.f578c > i3) {
            C0101l.f578c = i3;
        }
        if (C0101l.f540Y != -1) {
            if (C0101l.f540Y == 1) {
                f2 = C0101l.f578c * 1.4f;
            }
            C0101l.f579d = (int) (C0096g.m500c(C0101l.f578c, C0101l.f591p).measureText("N") + 0.5f);
            C0101l.f544aB = (C0101l.f575ay / 470) + 1;
            C0101l.f545aC = C0101l.f544aB * 2;
            C0101l.f546aD = C0101l.f545aC * 2;
        }
        f2 = C0101l.f578c / 1.4f;
        C0101l.f578c = (int) f2;
        C0101l.f579d = (int) (C0096g.m500c(C0101l.f578c, C0101l.f591p).measureText("N") + 0.5f);
        C0101l.f544aB = (C0101l.f575ay / 470) + 1;
        C0101l.f545aC = C0101l.f544aB * 2;
        C0101l.f546aD = C0101l.f545aC * 2;
    }

    /* renamed from: c */
    public static void m447c(Activity activity) {
        if (activity.getResources().getConfiguration().orientation == 1) {
            activity.setRequestedOrientation(1);
        } else {
            activity.setRequestedOrientation(0);
        }
    }

    /* renamed from: d */
    public static void m448d() {
        C0091b.m461a("external.cfg", "config", true);
        C0091b.m461a("demo-task.cup", "tasks", true);
        C0091b.m461a("leonardo-glider-brand.txt", "", true);
        String str = C0101l.m558c() + "/demo.igc";
        C0091b.m461a("demo.igc", "igc", true);
    }

    /* renamed from: d */
    public static void m449d(Activity activity) {
        activity.setRequestedOrientation(4);
    }

    /* renamed from: e */
    public static void m450e() {
        if (f461b >= 1) {
            m446c();
            C0239g.m1082m();
            AsyncTaskC0061b.m308a(C0239g.m1073d().f1972a, C0239g.m1073d().f1973b, false);
            C0233a.m1034f();
            C0239g.m1081l();
            C0062c.m312a(m443b());
            C0225a.m979a();
            ViewVmp.setFlag(1);
        }
    }

    /* renamed from: f */
    public static boolean m451f() {
        return f461b == 2;
    }

    /* renamed from: g */
    public static boolean m452g() {
        return f461b >= 1 && f461b < 2;
    }

    /* renamed from: h */
    public static void m453h() {
        for (int i2 = 0; i2 < f464e.size(); i2++) {
            Dialog dialog = f464e.get(i2);
            try {
                dialog.dismiss();
            } catch (Exception unused) {
            }
            dialog.dismiss();
        }
        f464e.clear();
    }

    /* renamed from: a */
    public void m454a(Activity activity) {
        f463d = activity;
    }

    @Override // android.app.Application
    public final void onCreate() {
        super.onCreate();
        f461b = 0;
        f460a = this;
        f464e.clear();
        PreferenceManager.setDefaultValues(this, R.xml.preferences_advanced, false);
        C0099j.f512a = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        C0101l.m570g("App create");
        C0239g.m1061a();
    }
}
