package android.support.v4.obf_v4_a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.obf_v4_a.C0018j;
import android.util.Log;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.a.k */
/* loaded from: classes.dex */
class C0019k {

    /* renamed from: b */
    private static Field f106b;

    /* renamed from: c */
    private static boolean f107c;

    /* renamed from: a */
    private static final Object f105a = new Object();

    /* renamed from: d */
    private static final Object f108d = new Object();

    /* renamed from: android.support.v4.a.k$a */
    /* loaded from: classes.dex */
    public static class a /* implements removed interfaces */ {

        /* renamed from: a */
        private Notification.Builder f109a;

        /* renamed from: b */
        private final Bundle f110b;

        /* renamed from: c */
        private List<Bundle> f111c = new ArrayList();

        /* renamed from: d */
        private RemoteViews f112d;

        /* renamed from: e */
        private RemoteViews f113e;

        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i2, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i3, int i4, boolean z, boolean z2, int i5, CharSequence charSequence4, boolean z3, Bundle bundle, String str, boolean z4, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3) {
            PendingIntent pendingIntent3;
            Bundle bundle2;
            String str3;
            boolean z5 = false;
            Notification.Builder deleteIntent = new Notification.Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                pendingIntent3 = pendingIntent2;
                z5 = true;
            } else {
                pendingIntent3 = pendingIntent2;
            }
            this.f109a = deleteIntent.setFullScreenIntent(pendingIntent3, z5).setLargeIcon(bitmap).setNumber(i2).setUsesChronometer(z2).setPriority(i5).setProgress(i3, i4, z);
            this.f110b = new Bundle();
            if (bundle != null) {
                this.f110b.putAll(bundle);
            }
            if (z3) {
                this.f110b.putBoolean("android.support.localOnly", true);
            }
            if (str != null) {
                this.f110b.putString("android.support.groupKey", str);
                if (z4) {
                    bundle2 = this.f110b;
                    str3 = "android.support.isGroupSummary";
                } else {
                    bundle2 = this.f110b;
                    str3 = "android.support.useSideChannel";
                }
                bundle2.putBoolean(str3, true);
            }
            if (str2 != null) {
                this.f110b.putString("android.support.sortKey", str2);
            }
            this.f112d = remoteViews2;
            this.f113e = remoteViews3;
        }

        /* renamed from: a */
        public Notification mo34a() {
            Notification build = this.f109a.build();
            Bundle m69a = C0019k.m69a(build);
            Bundle bundle = new Bundle(this.f110b);
            for (String str : this.f110b.keySet()) {
                if (m69a.containsKey(str)) {
                    bundle.remove(str);
                }
            }
            m69a.putAll(bundle);
            SparseArray<Bundle> m70a = C0019k.m70a(this.f111c);
            if (m70a != null) {
                C0019k.m69a(build).putSparseParcelableArray("android.support.actionExtras", m70a);
            }
            if (this.f112d != null) {
                build.contentView = this.f112d;
            }
            if (this.f113e != null) {
                build.bigContentView = this.f113e;
            }
            return build;
        }

        /* renamed from: a */
        public void mo33a(C0018j.a aVar) {
            this.f111c.add(C0019k.m68a(this.f109a, aVar));
        }
    }

    /* renamed from: a */
    public static Bundle m68a(Notification.Builder builder, C0018j.a aVar) {
        builder.addAction(aVar.mo37a(), aVar.mo38b(), aVar.mo39c());
        Bundle bundle = new Bundle(aVar.mo40d());
        if (aVar.mo45i() != null) {
            bundle.putParcelableArray("android.support.remoteInputs", C0024p.m79a(aVar.mo45i()));
        }
        if (aVar.mo44h() != null) {
            bundle.putParcelableArray("android.support.dataRemoteInputs", C0024p.m79a(aVar.mo44h()));
        }
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.mo41e());
        return bundle;
    }

    /* renamed from: a */
    public static Bundle m69a(Notification notification) {
        String str;
        String str2;
        synchronized (f105a) {
            if (f107c) {
                return null;
            }
            try {
                if (f106b == null) {
                    Field declaredField = Notification.class.getDeclaredField("extras");
                    if (!Bundle.class.isAssignableFrom(declaredField.getType())) {
                        Log.e("NotificationCompat", "Notification.extras field is not of type Bundle");
                        f107c = true;
                        return null;
                    }
                    declaredField.setAccessible(true);
                    f106b = declaredField;
                }
                Bundle bundle = (Bundle) f106b.get(notification);
                if (bundle == null) {
                    bundle = new Bundle();
                    f106b.set(notification, bundle);
                }
                return bundle;
            } catch (IllegalAccessException e2) {
                Throwable e = e2;
                str = "NotificationCompat";
                str2 = "Unable to access notification extras";
                Log.e(str, str2, e);
                f107c = true;
                return null;
            } catch (NoSuchFieldException e3) {
                Throwable e = e3;
                str = "NotificationCompat";
                str2 = "Unable to access notification extras";
                Log.e(str, str2, e);
                f107c = true;
                return null;
            }
        }
    }

    /* renamed from: a */
    public static SparseArray<Bundle> m70a(List<Bundle> list) {
        int size = list.size();
        SparseArray<Bundle> sparseArray = null;
        for (int i2 = 0; i2 < size; i2++) {
            Bundle bundle = list.get(i2);
            if (bundle != null) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray<>();
                }
                sparseArray.put(i2, bundle);
            }
        }
        return sparseArray;
    }
}
