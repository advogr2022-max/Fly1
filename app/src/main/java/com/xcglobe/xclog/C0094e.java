package com.xcglobe.xclog;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.xcglobe.flyme.R;

/* renamed from: com.xcglobe.xclog.e */
/* loaded from: classes.dex */
public class C0094e {

    /* renamed from: a */
    public static Bitmap f488a;

    /* renamed from: b */
    public static Bitmap f489b;

    /* renamed from: c */
    public static Bitmap f490c;

    /* renamed from: a */
    public static void m462a() {
        f488a = BitmapFactory.decodeResource(App.m443b().getResources(), R.drawable.goal_map);
        f490c = BitmapFactory.decodeResource(App.m443b().getResources(), R.drawable.turning_circling);
        f489b = BitmapFactory.decodeResource(App.m443b().getResources(), R.drawable.turning_straight);
    }
}
