package android.support.v4.obf_v4_a;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.obf_v4_a.C0018j;
import android.widget.RemoteViews;
import java.util.ArrayList;

/* renamed from: android.support.v4.a.f */
/* loaded from: classes.dex */
class C0014f {

    /* renamed from: android.support.v4.a.f$a */
    /* loaded from: classes.dex */
    public static class a /* implements removed interfaces */ {

        /* renamed from: a */
        private Notification.Builder f91a;

        /* renamed from: b */
        private Bundle f92b;

        /* renamed from: c */
        private RemoteViews f93c;

        /* renamed from: d */
        private RemoteViews f94d;

        /* renamed from: e */
        private int f95e;

        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i2, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i3, int i4, boolean z, boolean z2, boolean z3, int i5, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3, int i6) {
            PendingIntent pendingIntent3;
            boolean z6 = false;
            Notification.Builder deleteIntent = new Notification.Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                pendingIntent3 = pendingIntent2;
                z6 = true;
            } else {
                pendingIntent3 = pendingIntent2;
            }
            this.f91a = deleteIntent.setFullScreenIntent(pendingIntent3, z6).setLargeIcon(bitmap).setNumber(i2).setUsesChronometer(z3).setPriority(i5).setProgress(i3, i4, z).setLocalOnly(z4).setGroup(str).setGroupSummary(z5).setSortKey(str2);
            this.f92b = new Bundle();
            if (bundle != null) {
                this.f92b.putAll(bundle);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                this.f92b.putStringArray("android.people", (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            this.f93c = remoteViews2;
            this.f94d = remoteViews3;
            this.f95e = i6;
        }

        /* renamed from: a */
        private void m64a(Notification notification) {
            notification.sound = null;
            notification.vibrate = null;
            notification.defaults &= -2;
            notification.defaults &= -3;
        }

        /* renamed from: a */
        public Notification mo34a() {
            this.f91a.setExtras(this.f92b);
            Notification build = this.f91a.build();
            if (this.f93c != null) {
                build.contentView = this.f93c;
            }
            if (this.f94d != null) {
                build.bigContentView = this.f94d;
            }
            if (this.f95e != 0) {
                if (build.getGroup() != null && (build.flags & 512) != 0 && this.f95e == 2) {
                    m64a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f95e == 1) {
                    m64a(build);
                }
            }
            return build;
        }

        /* renamed from: a */
        public void mo33a(C0018j.a aVar) {
            C0014f.m63a(this.f91a, aVar);
        }
    }

    /* renamed from: a */
    public static void m63a(Notification.Builder builder, C0018j.a aVar) {
        Notification.Action.Builder builder2 = new Notification.Action.Builder(aVar.mo37a(), aVar.mo38b(), aVar.mo39c());
        if (aVar.mo45i() != null) {
            for (RemoteInput remoteInput : C0022n.m77a(aVar.mo45i())) {
                builder2.addRemoteInput(remoteInput);
            }
        }
        Bundle bundle = aVar.mo40d() != null ? new Bundle(aVar.mo40d()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.mo41e());
        builder2.addExtras(bundle);
        builder.addAction(builder2.build());
    }
}
