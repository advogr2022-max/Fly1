package flyme_device;

import android.annotation.SuppressLint;
import com.xcglobe.xclog.ActivityMain;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0099j;
import flyme_data.C0239g;

@SuppressLint({"NewApi"})
/* renamed from: d.p */
/* loaded from: classes.dex */
public class C0184p {

    /* renamed from: a */
    static a f927a = null;

    /* renamed from: b */
    static Thread f928b = null;

    /* renamed from: c */
    static boolean f929c = false;

    /* renamed from: d */
    static boolean f930d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d.p$a */
    /* loaded from: classes.dex */
    public static class a implements Runnable {

        /* renamed from: a */
        final byte[] f931a = new byte[4096];

        /* renamed from: b */
        C0180l f932b;

        a(C0180l c0180l) {
            this.f932b = c0180l;
        }

        @Override // java.lang.Runnable
        public void run() {
            C0172d.m666a("Starting looper");
            while (!App.m451f() && C0184p.f930d) {
                try {
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (this.f932b == null) {
                    Thread.sleep(5000L);
                    if (this.f932b == null) {
                        C0184p.m816c();
                    }
                } else {
                    if (this.f932b.f885d == 3) {
                        int bulkTransfer = this.f932b.f887f.bulkTransfer(this.f932b.f886e, this.f931a, this.f931a.length, 5000);
                        if (bulkTransfer > 0) {
                            this.f932b.m786b(new String(this.f931a, 0, bulkTransfer, "UTF-8"));
                            C0184p.f929c = true;
                        } else {
                            C0172d.m666a("bulkTransfer failed");
                            this.f932b.m787i();
                        }
                    } else if (this.f932b.f885d == 0) {
                        C0172d.m666a("state=disconnected");
                        Thread.sleep(5000L);
                        C0184p.m816c();
                    } else {
                        C0172d.m666a("state=terminated");
                    }
                    C0184p.f929c = false;
                }
            }
            C0184p.f929c = false;
            C0172d.m666a("Terminating looper");
            this.f932b = null;
            C0184p.f927a = null;
        }
    }

    /* renamed from: a */
    public static void m812a() {
        f930d = false;
        try {
            if (f928b != null) {
                f928b.interrupt();
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public static void m813a(C0180l c0180l) {
        f930d = C0099j.m521b("external_devmodel") == 5;
        if (f927a == null && f930d) {
            f927a = new a(c0180l);
            f928b = new Thread(f927a);
            f928b.start();
        }
    }

    /* renamed from: b */
    public static void m815b(C0180l c0180l) {
        m813a(c0180l);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m816c() {
        ActivityMain.m412a().runOnUiThread(new Runnable() { // from class: d.p.1
            @Override // java.lang.Runnable
            public void run() {
                C0172d.m665a(App.m443b(), 5, "usb", C0239g.f1384O, null);
            }
        });
    }
}
