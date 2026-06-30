package com.xcglobe.xclog;

import android.graphics.Paint;

/* renamed from: com.xcglobe.xclog.g */
/* loaded from: classes.dex */
public class C0096g {

    /* renamed from: a */
    public static Paint f493a;

    /* renamed from: b */
    public static Paint f494b;

    /* renamed from: c */
    public static Paint f495c;

    /* renamed from: a */
    public static Paint m495a(float f2, int i2) {
        f495c.setStrokeWidth(f2);
        f495c.setColor(i2);
        return f495c;
    }

    /* renamed from: a */
    public static void m496a() {
        f493a = new Paint();
        f493a.setColor(C0101l.f591p);
        f493a.setTextSize(C0101l.f578c);
        f493a.setAntiAlias(true);
        f493a.setStyle(Paint.Style.FILL);
        f493a.setStrokeWidth(0.0f);
        f493a.setDither(false);
        f494b = new Paint();
        f494b.set(f493a);
        f494b.setStyle(Paint.Style.STROKE);
        f495c = new Paint();
        f495c.set(f493a);
        f495c.setStyle(Paint.Style.STROKE);
        f495c.setAntiAlias(true);
        f495c.setColor(C0101l.f516A);
    }

    /* renamed from: b */
    public static Paint m497b() {
        return m495a(0.0f, C0101l.f516A);
    }

    /* renamed from: b */
    public static Paint m498b(float f2, int i2) {
        f494b.setStrokeWidth(f2);
        f494b.setColor(i2);
        return f494b;
    }

    /* renamed from: c */
    public static Paint m499c() {
        f494b.setStrokeWidth(0.0f);
        f494b.setColor(C0101l.f591p);
        return f494b;
    }

    /* renamed from: c */
    public static Paint m500c(float f2, int i2) {
        f493a.setTextSize(f2);
        f493a.setColor(i2);
        return f493a;
    }

    /* renamed from: d */
    public static Paint m501d() {
        return m500c(C0101l.f578c, C0101l.f591p);
    }
}
