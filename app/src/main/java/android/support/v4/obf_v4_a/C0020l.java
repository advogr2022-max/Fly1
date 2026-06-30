package android.support.v4.obf_v4_a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.obf_v4_a.C0018j;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.List;

/* renamed from: android.support.v4.a.l */
/* loaded from: classes.dex */
class C0020l {

    /* renamed from: android.support.v4.a.l$a */
    /* loaded from: classes.dex */
    public static class a /* implements removed interfaces */ {

        /* renamed from: a */
        private Notification.Builder f114a;

        /* renamed from: b */
        private Bundle f115b;

        /* renamed from: c */
        private List<Bundle> f116c = new ArrayList();

        /* renamed from: d */
        private RemoteViews f117d;

        /* renamed from: e */
        private RemoteViews f118e;

        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i2, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i3, int i4, boolean z, boolean z2, boolean z3, int i5, CharSequence charSequence4, boolean z4, ArrayList<String> arrayList, Bundle bundle, String str, boolean z5, String str2, RemoteViews remoteViews2, RemoteViews remoteViews3) {
            PendingIntent pendingIntent3;
            Bundle bundle2;
            String str3;
            boolean z6 = false;
            Notification.Builder deleteIntent = new Notification.Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                pendingIntent3 = pendingIntent2;
                z6 = true;
            } else {
                pendingIntent3 = pendingIntent2;
            }
            this.f114a = deleteIntent.setFullScreenIntent(pendingIntent3, z6).setLargeIcon(bitmap).setNumber(i2).setUsesChronometer(z3).setPriority(i5).setProgress(i3, i4, z);
            this.f115b = new Bundle();
            if (bundle != null) {
                this.f115b.putAll(bundle);
            }
            if (arrayList != null && !arrayList.isEmpty()) {
                this.f115b.putStringArray("android.people", (String[]) arrayList.toArray(new String[arrayList.size()]));
            }
            if (z4) {
                this.f115b.putBoolean("android.support.localOnly", true);
            }
            if (str != null) {
                this.f115b.putString("android.support.groupKey", str);
                if (z5) {
                    bundle2 = this.f115b;
                    str3 = "android.support.isGroupSummary";
                } else {
                    bundle2 = this.f115b;
                    str3 = "android.support.useSideChannel";
                }
                bundle2.putBoolean(str3, true);
            }
            if (str2 != null) {
                this.f115b.putString("android.support.sortKey", str2);
            }
            this.f117d = remoteViews2;
            this.f118e = remoteViews3;
        }

        /* renamed from: a */
        public Notification mo34a() {
            SparseArray<Bundle> m70a = C0019k.m70a(this.f116c);
            if (m70a != null) {
                this.f115b.putSparseParcelableArray("android.support.actionExtras", m70a);
            }
            this.f114a.setExtras(this.f115b);
            Notification build = this.f114a.build();
            if (this.f117d != null) {
                build.contentView = this.f117d;
            }
            if (this.f118e != null) {
                build.bigContentView = this.f118e;
            }
            return build;
        }

        /* renamed from: a */
        public void mo33a(C0018j.a aVar) {
            this.f116c.add(C0019k.m68a(this.f114a, aVar));
        }
    }
}
