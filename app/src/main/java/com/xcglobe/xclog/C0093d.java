package com.xcglobe.xclog;

import android.util.Log;
import java.lang.Thread;

/* renamed from: com.xcglobe.xclog.d */
/* loaded from: classes.dex */
public class C0093d implements Thread.UncaughtExceptionHandler {

    /* renamed from: a */
    private Thread.UncaughtExceptionHandler f487a = Thread.getDefaultUncaughtExceptionHandler();

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        C0101l.m547a("crash", Log.getStackTraceString(th));
        C0101l.m547a("crash", "lifeCycle: " + App.f461b);
        try {
            App.m442a(true);
        } catch (Exception unused) {
        }
        this.f487a.uncaughtException(thread, th);
    }
}
