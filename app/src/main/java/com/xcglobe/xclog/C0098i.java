package com.xcglobe.xclog;

import android.app.KeyguardManager;
import android.os.PowerManager;
import flyme_data.C0239g;

/* renamed from: com.xcglobe.xclog.i */
/* loaded from: classes.dex */
public class C0098i {

    /* renamed from: a */
    public static int f509a = 0;

    /* renamed from: b */
    static long f510b = 0;

    /* renamed from: c */
    private static int f511c = 2;

    /* renamed from: a */
    private static void m511a() {
        ((KeyguardManager) App.m443b().getSystemService("keyguard")).newKeyguardLock("MyKeyguardLock").disableKeyguard();
        PowerManager.WakeLock newWakeLock = ((PowerManager) App.m443b().getSystemService("power")).newWakeLock(805306394, "MyWakeLock");
        newWakeLock.acquire();
        newWakeLock.release();
        f511c = 2;
        ActivityMain.m413a(13);
    }

    /* renamed from: a */
    public static void m512a(long j2) {
        if (f511c != 2) {
            if (f509a != 1 || C0239g.f1372C.f1446a <= 0) {
                return;
            }
            m511a();
            return;
        }
        if (f510b == 0) {
            f510b = j2 + 10000;
        } else if (j2 > f510b) {
            m513b();
        }
    }

    /* renamed from: b */
    private static void m513b() {
        f511c = 1;
        ActivityMain.m413a(14);
    }
}
