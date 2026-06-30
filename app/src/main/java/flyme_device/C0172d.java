package flyme_device;

import android.app.Activity;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0101l;
import flyme_collection.C0193b;
import types.C0378r;

/* renamed from: d.d */
/* loaded from: classes.dex */
public class C0172d {

    /* renamed from: a */
    static final Object f769a = new Object();

    /* renamed from: b */
    private static final Handler f770b = new Handler();

    /* renamed from: c */
    private static int f771c = 0;

    /* renamed from: d */
    private static AbstractC0174f f772d = null;

    /* renamed from: a */
    public static void m663a() {
        if (f772d != null) {
            f772d.mo684a();
            f772d = null;
        }
    }

    /* renamed from: a */
    private static void m664a(Activity activity) {
        final App app = (App) activity.getApplicationContext();
        final ProgressDialog progressDialog = new ProgressDialog(activity);
        progressDialog.setMessage("Connecting...");
        progressDialog.setProgressStyle(0);
        progressDialog.setCancelable(false);
        App.m436a(progressDialog);
        final long currentTimeMillis = System.currentTimeMillis();
        f770b.post(new Runnable() { // from class: d.d.1
            @Override // java.lang.Runnable
            public void run() {
                boolean z = true;
                if (System.currentTimeMillis() - currentTimeMillis <= 5000 && C0172d.f772d != null && !C0172d.f772d.mo687b()) {
                    z = false;
                }
                Log.i("xxx:", "close=" + z);
                if (!z) {
                    C0172d.f770b.postDelayed(this, 300L);
                } else {
                    App app2 = app;
                    App.m445b(progressDialog);
                }
            }
        });
    }

    /* renamed from: a */
    public static void m665a(Context context, int i2, String str, InterfaceC0182n interfaceC0182n, Activity activity) {
        m666a("Starting external device: " + i2);
        f771c = i2;
        if (!m667a(context, interfaceC0182n, str) || activity == null || f772d.mo693h()) {
            return;
        }
        m664a(activity);
    }

    /* renamed from: a */
    public static void m666a(String str) {
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000a. Please report as an issue. */
    /* renamed from: a */
    private static boolean m667a(Context context, InterfaceC0182n interfaceC0182n, String str) {
        AbstractC0174f c0178j;
        m666a("createDevice()");
        m663a();
        switch (f771c) {
            case 1:
                c0178j = new C0178j(context, interfaceC0182n);
                f772d = c0178j;
                f772d.mo686a(str);
                return true;
            case 2:
                c0178j = new C0175g(context, interfaceC0182n);
                f772d = c0178j;
                f772d.mo686a(str);
                return true;
            case 3:
                c0178j = new C0181m(context, interfaceC0182n);
                f772d = c0178j;
                f772d.mo686a(str);
                return true;
            case 4:
                c0178j = new C0177i(context, interfaceC0182n);
                f772d = c0178j;
                f772d.mo686a(str);
                return true;
            case 5:
                c0178j = new C0180l(context, interfaceC0182n);
                f772d = c0178j;
                f772d.mo686a(str);
                return true;
            case 6:
                c0178j = new C0179k(context, interfaceC0182n);
                f772d = c0178j;
                f772d.mo686a(str);
                return true;
            case 7:
                c0178j = new C0176h(context, interfaceC0182n);
                f772d = c0178j;
                f772d.mo686a(str);
                return true;
            default:
                return false;
        }
    }

    /* renamed from: b */
    public static boolean m668b() {
        return f772d != null && f772d.mo687b();
    }

    /* renamed from: c */
    public static String m669c() {
        return f772d != null ? f772d.mo690e() : "-";
    }

    /* renamed from: d */
    public static boolean m670d() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        return defaultAdapter != null && defaultAdapter.isEnabled();
    }

    /* renamed from: e */
    public static boolean m671e() {
        return m668b() && f772d.mo691f();
    }

    /* renamed from: f */
    public static boolean m672f() {
        return m668b() && f772d.mo692g();
    }

    /* renamed from: g */
    public static void m673g() {
        for (String str : C0193b.m826b(C0101l.m537a("config/external.cfg")).split("\n")) {
            if (str.startsWith("btCfgUseEgm96=")) {
                C0101l.f563am = C0378r.m1289a(str, 14, str.length()) == 1;
            }
            if (str.startsWith("btCfgIgnoreGeoid=")) {
                C0101l.f564an = C0378r.m1289a(str, 17, str.length()) == 1;
            }
        }
    }
}
