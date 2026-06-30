package flyme_tasks;

import android.content.Context;
import android.media.SoundPool;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0101l;
import flyme_misc.C0207e;
import flyme_data.C0239g;

/* renamed from: b.c */
/* loaded from: classes.dex */
public class C0062c extends Thread {

    /* renamed from: a */
    private static SoundPool f260a = null;

    /* renamed from: b */
    private static int f261b = 0;

    /* renamed from: c */
    private static int f262c = 0;

    /* renamed from: d */
    private static int f263d = 0;

    /* renamed from: e */
    private static C0062c f264e = null;

    /* renamed from: f */
    private static float f265f = 0.0f;

    /* renamed from: g */
    private static float f266g = 0.0f;

    /* renamed from: h */
    private static float f267h = 1.0f;

    /* renamed from: i */
    private static float f268i = 0.0f;

    /* renamed from: j */
    private static float f269j = -3.0f;

    /* renamed from: k */
    private static C0207e f270k = new C0207e(1000);

    /* renamed from: a */
    public static void m311a() {
        f264e = null;
    }

    /* renamed from: a */
    public static void m312a(Context context) {
        f269j = C0101l.f535T;
        if (f269j > 0.0f) {
            f269j = 0.0f;
        }
        int i2 = C0101l.f538W;
        if (i2 <= 0 || C0101l.f565ao) {
            m311a();
            return;
        }
        f267h = i2 / 100.0f;
        if (f260a == null) {
            f260a = new SoundPool(1, 3, 0);
            f262c = f260a.load(context, R.raw.b200, 1);
            f261b = f260a.load(context, R.raw.b100, 1);
            f263d = f260a.load(context, R.raw.sink, 1);
        }
        if (f264e == null) {
            f264e = new C0062c();
            f264e.start();
        }
    }

    /* renamed from: b */
    private void m313b() {
        f266g = f270k.mo866a(C0239g.f1416i, System.currentTimeMillis());
    }

    /* renamed from: b */
    public static void m314b(Context context) {
        m312a(context);
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        float f2;
        while (f264e == this && !App.m451f()) {
            try {
                m313b();
                if (f266g > 0.1f) {
                    f265f = ((f266g < 2.0f ? f266g * 2.0f : ((f266g - 2.0f) * 1.1f) + 5.0f) * 1.2f) + 1.2f;
                    f2 = 1000.0f / f265f;
                    f268i = 1.0f;
                    if (f266g > 2.0f) {
                        f268i += ((float) Math.exp((f266g - 2.0f) + 0.0f)) / 100.0f;
                        if (f268i > 2.0f) {
                            f268i = 2.0f;
                        }
                    }
                    f260a.play(f2 > 350.0f ? f262c : f261b, f267h, f267h, 0, 0, f268i);
                } else if (f266g < f269j) {
                    int i2 = f263d;
                    float f3 = -(f266g - f269j);
                    if (f3 > 5.0f) {
                        f3 = 5.0f;
                    }
                    f268i = 1.0f - (f3 / 10.0f);
                    f260a.play(i2, f267h, f267h, 0, 0, f268i);
                    f2 = 200.0f;
                } else {
                    f2 = 500.0f;
                }
                try {
                    Thread.sleep((long) f2);
                } catch (InterruptedException unused) {
                }
            } catch (Exception unused2) {
                return;
            }
        }
    }
}
