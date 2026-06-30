package flyme_device;

import android.content.Intent;
import android.os.Handler;
import android.preference.PreferenceManager;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0099j;
import com.xcglobe.xclog.C0101l;
import com.xcglobe.xclog.FlyMeService;
import flyme_apphelper.C0072a;
import flyme_data.C0233a;
import flyme_data.C0234b;
import flyme_data.C0236d;
import flyme_data.C0238f;
import flyme_data.C0239g;

/* renamed from: d.e */
/* loaded from: classes.dex */
public class C0173e implements InterfaceC0182n {

    /* renamed from: a */
    public static int f776a = 0;

    /* renamed from: b */
    private static boolean f777b = false;

    /* renamed from: a */
    private static void m676a(final boolean z, final boolean z2) {
        if (App.m451f()) {
            return;
        }
        if (z2) {
            C0239g.f1381L = false;
        }
        if (z) {
            C0239g.f1382M = false;
        }
        new Handler(App.m443b().getMainLooper()).post(new Runnable() { // from class: d.e.1
            @Override // java.lang.Runnable
            public void run() {
                if (z2) {
                    C0233a.m1034f();
                    C0239g.m1081l();
                }
                if (z) {
                    C0236d.m1041a();
                }
            }
        });
    }

    /* renamed from: b */
    private static void m677b(final boolean z, final boolean z2) {
        if (z2) {
            C0239g.f1381L = true;
        }
        if (z) {
            C0239g.f1382M = true;
        }
        new Handler(App.m443b().getMainLooper()).post(new Runnable() { // from class: d.e.2
            @Override // java.lang.Runnable
            public void run() {
                if (z2) {
                    C0233a.m1033e();
                }
                if (z) {
                    C0236d.m1044b();
                }
            }
        });
    }

    @Override // flyme_device.InterfaceC0182n
    /* renamed from: a */
    public void mo678a() {
        C0101l.f525J = false;
        PreferenceManager.getDefaultSharedPreferences(App.m443b()).edit().putString("external_devmode", "0").commit();
        Intent intent = new Intent("com.xcglobe.action.main");
        intent.putExtra("event", 21);
        App.m443b().sendBroadcast(intent);
    }

    @Override // flyme_device.InterfaceC0182n
    /* renamed from: a */
    public void mo679a(float f2, float f3, long j2) {
        if (C0072a.m378a()) {
            return;
        }
        C0239g.m1062a(f2, f3, j2);
    }

    @Override // flyme_device.InterfaceC0182n
    /* renamed from: a */
    public void mo680a(float f2, float f3, short s, long j2, int i2) {
        if (C0072a.m378a()) {
            return;
        }
        if (!f777b) {
            f776a = C0234b.m1036a(f2, f3);
            if (C0238f.m1059d()) {
                f777b = true;
            }
        }
        C0239g.m1063a(f2, f3, s, j2, i2);
    }

    @Override // flyme_device.InterfaceC0182n
    /* renamed from: a */
    public void mo681a(int i2) {
        switch (i2) {
            case 1:
            case 3:
            case 5:
            case 6:
            case 7:
                m676a(true, true);
                break;
            case 2:
            case 4:
                m676a(false, true);
                break;
        }
        C0239g.m1081l();
    }

    @Override // flyme_device.InterfaceC0182n
    /* renamed from: a */
    public void mo682a(int i2, String str) {
        C0099j.m527d("external_device_address", str);
        C0099j.m517a("external_device_model", i2);
        switch (i2) {
            case 1:
            case 3:
            case 5:
            case 6:
            case 7:
                m677b(true, true);
                break;
            case 2:
            case 4:
                m677b(false, true);
                break;
        }
        C0239g.m1081l();
    }

    @Override // flyme_device.InterfaceC0182n
    /* renamed from: b */
    public void mo683b(int i2) {
        if (App.m451f()) {
            return;
        }
        f777b = false;
        FlyMeService.m457a();
        Intent intent = new Intent("com.xcglobe.action.main");
        intent.putExtra("event", 20);
        App.m443b().sendBroadcast(intent);
    }
}
