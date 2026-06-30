package android.support.v4.obf_v4_a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.obf_v4_a.C0018j;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.v4.a.g */
/* loaded from: classes.dex */
class C0015g {

    /* renamed from: android.support.v4.a.g$a */
    /* loaded from: classes.dex */
    public static class a /* implements removed interfaces */ {

        /* renamed from: a */
        private Notification.Builder f96a;

        /* renamed from: b */
        private Bundle f97b;

        /* renamed from: c */
        private RemoteViews f98c;

        /* renamed from: d */
        private RemoteViews f99d;

        /* renamed from: e */
        private RemoteViews f100e;

        /* renamed from: f */
        private int f101f;

        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i2, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i3, int i4, boolean z, boolean z2, boolean z3, int i5, CharSequence charSequence4, boolean z4, String str, ArrayList<String> arrayList, Bundle bundle, int i6, int i7, Notification notification2, String str2, boolean z5, String str3, RemoteViews remoteViews2, RemoteViews remoteViews3, RemoteViews remoteViews4, int i8) {
            PendingIntent pendingIntent3;
            boolean z6 = false;
            Notification.Builder deleteIntent = new Notification.Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                pendingIntent3 = pendingIntent2;
                z6 = true;
            } else {
                pendingIntent3 = pendingIntent2;
            }
            this.f96a = deleteIntent.setFullScreenIntent(pendingIntent3, z6).setLargeIcon(bitmap).setNumber(i2).setUsesChronometer(z3).setPriority(i5).setProgress(i3, i4, z).setLocalOnly(z4).setGroup(str2).setGroupSummary(z5).setSortKey(str3).setCategory(str).setColor(i6).setVisibility(i7).setPublicVersion(notification2);
            this.f97b = new Bundle();
            if (bundle != null) {
                this.f97b.putAll(bundle);
            }
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                this.f96a.addPerson(it.next());
            }
            this.f98c = remoteViews2;
            this.f99d = remoteViews3;
            this.f100e = remoteViews4;
            this.f101f = i8;
        }

        /* renamed from: a */
        private void m65a(Notification notification) {
            notification.sound = null;
            notification.vibrate = null;
            notification.defaults &= -2;
            notification.defaults &= -3;
        }

        /* renamed from: a */
        public Notification mo34a() {
            this.f96a.setExtras(this.f97b);
            Notification build = this.f96a.build();
            if (this.f98c != null) {
                build.contentView = this.f98c;
            }
            if (this.f99d != null) {
                build.bigContentView = this.f99d;
            }
            if (this.f100e != null) {
                build.headsUpContentView = this.f100e;
            }
            if (this.f101f != 0) {
                if (build.getGroup() != null && (build.flags & 512) != 0 && this.f101f == 2) {
                    m65a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f101f == 1) {
                    m65a(build);
                }
            }
            return build;
        }

        /* renamed from: a */
        public void mo33a(C0018j.a aVar) {
            C0014f.m63a(this.f96a, aVar);
        }
    }
}
