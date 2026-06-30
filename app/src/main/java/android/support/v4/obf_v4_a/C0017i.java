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

/* renamed from: android.support.v4.a.i */
/* loaded from: classes.dex */
class C0017i {

    /* renamed from: android.support.v4.a.i$a */
    /* loaded from: classes.dex */
    public static class a /* implements removed interfaces */ {

        /* renamed from: a */
        private Notification.Builder f104a;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i2, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i3, int i4, boolean z, boolean z2, boolean z3, int i5, CharSequence charSequence4, boolean z4, String str, ArrayList<String> arrayList, Bundle bundle, int i6, int i7, Notification notification2, String str2, boolean z5, String str3, CharSequence[] charSequenceArr, RemoteViews remoteViews2, RemoteViews remoteViews3, RemoteViews remoteViews4, String str4, int i8, String str5, long j2, boolean z6, boolean z7, int i9) {
            PendingIntent pendingIntent3;
            boolean z8 = false;
            Notification.Builder deleteIntent = new Notification.Builder(context, str4).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                pendingIntent3 = pendingIntent2;
                z8 = true;
            } else {
                pendingIntent3 = pendingIntent2;
            }
            this.f104a = deleteIntent.setFullScreenIntent(pendingIntent3, z8).setLargeIcon(bitmap).setNumber(i2).setUsesChronometer(z3).setPriority(i5).setProgress(i3, i4, z).setLocalOnly(z4).setExtras(bundle).setGroup(str2).setGroupSummary(z5).setSortKey(str3).setCategory(str).setColor(i6).setVisibility(i7).setPublicVersion(notification2).setRemoteInputHistory(charSequenceArr).setChannelId(str4).setBadgeIconType(i8).setShortcutId(str5).setTimeoutAfter(j2).setGroupAlertBehavior(i9);
            if (z7) {
                this.f104a.setColorized(z6);
            }
            if (remoteViews2 != null) {
                this.f104a.setCustomContentView(remoteViews2);
            }
            if (remoteViews3 != null) {
                this.f104a.setCustomBigContentView(remoteViews3);
            }
            if (remoteViews4 != null) {
                this.f104a.setCustomHeadsUpContentView(remoteViews4);
            }
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                this.f104a.addPerson(it.next());
            }
        }

        /* renamed from: a */
        public Notification mo34a() {
            return this.f104a.build();
        }

        /* renamed from: a */
        public void mo33a(C0018j.a aVar) {
            C0016h.m66a(this.f104a, aVar);
        }
    }
}
