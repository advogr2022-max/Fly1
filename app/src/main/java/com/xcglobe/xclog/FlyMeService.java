package com.xcglobe.xclog;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
// import android.support.v4.obf_v4_a.C0013e;
import com.xcglobe.flyme.R;
import flyme_tasks.AsyncTaskC0060a;
import flyme_data.C0236d;
import flyme_data.C0238f;
import flyme_data.C0239g;

/* loaded from: classes.dex */
public class FlyMeService extends Service {

    /* renamed from: a */
    public static final String f465a = App.m435a(R.string.recording);

    /* renamed from: b */
    public static final String f466b = App.m435a(R.string.waiting_movement);

    /* renamed from: c */
    public static final String f467c = App.m435a(R.string.gps_unavailable);

    /* renamed from: d */
    public static final String f468d = App.m435a(R.string.waiting_gps);

    /* renamed from: e */
    public static final String f469e = App.m435a(R.string.building_airspace);

    /* renamed from: f */
    private static FlyMeService f470f;

    /* renamed from: g */
    private Handler f471g;

    /* renamed from: h */
    private Runnable f472h;

    /* renamed from: a */
    public static String m456a(boolean z) {
        if (AsyncTaskC0060a.f252a > 0) {
            return f469e;
        }
        if (!C0238f.m1059d()) {
            return C0239g.m1076g() ? f466b : !C0236d.m1046c() ? f467c : f468d;
        }
        if (!z) {
            return f465a;
        }
        return "REC: " + C0101l.m534a(C0239g.m1074e(), 1);
    }

    /* renamed from: a */
    public static void m457a() {
        if (f470f != null) {
            f470f.f471g.postDelayed(f470f.f472h, 100L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public Notification m458b() {
        int flags = Build.VERSION.SDK_INT >= Build.VERSION_CODES.M
                ? PendingIntent.FLAG_IMMUTABLE : 0;
        PendingIntent activity = PendingIntent.getActivity(this, 0, new Intent(this, (Class<?>) ActivityMain.class), flags);
        String m456a = m456a(false);
        if (Build.VERSION.SDK_INT >= 26) {
            ((NotificationManager) getSystemService("notification")).createNotificationChannel(new NotificationChannel("my_channel_01", "FlyMe", 3));
            return new Notification.Builder(this, "my_channel_01").setContentTitle(m456a).setSmallIcon(android.R.drawable.ic_menu_mylocation).setContentIntent(activity).build();
        }
        // C0013e.b bVar = new C0013e.b(this);
        NotificationCompat.Builder bVar = new NotificationCompat.Builder(this);
        // bVar.m53a(true);
        bVar.setContentTitle(getString(R.string.app_name)).setContentText(m456a).setContentIntent(activity).setSmallIcon(android.R.drawable.ic_menu_mylocation);
        return bVar.build();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        C0101l.m570g("Service binding...");
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        C0101l.m570g("FlyMeService.onCreate()");
    }

    @Override // android.app.Service
    public void onDestroy() {
        C0101l.m570g("FlyMeService.onDestroy()");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        f470f = this;
        String action = intent != null ? intent.getAction() : null;
        if ("com.xcglobe.action.startservice".equals(action)) {
            // startForeground НЕМЕДЛЕННО — Android 8+ требует в течение 5 секунд после startForegroundService()
            startForeground(101, m458b());
            if (this.f471g == null) {
                this.f471g = new Handler();
            }
        } else if ("com.xcglobe.action.stopservice".equals(action)) {
            if (this.f471g != null) {
                this.f471g.removeCallbacks(this.f472h);
            }
            stopForeground(STOP_FOREGROUND_REMOVE);
            stopSelf();
        }
        // Если intent == null (перезапуск системой) — оставляем service в foreground
        return START_STICKY;
    }
}
