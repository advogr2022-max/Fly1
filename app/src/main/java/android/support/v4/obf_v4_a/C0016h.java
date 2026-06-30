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
import java.util.Iterator;

/* renamed from: android.support.v4.a.h */
/* loaded from: classes.dex */
class C0016h {

    /* renamed from: android.support.v4.a.h$a */
    /* loaded from: classes.dex */
    public static class a /* implements removed interfaces */ {

        /* renamed from: a */
        private Notification.Builder f102a;

        /* renamed from: b */
        private int f103b;

        public a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i2, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i3, int i4, boolean z, boolean z2, boolean z3, int i5, CharSequence charSequence4, boolean z4, String str, ArrayList<String> arrayList, Bundle bundle, int i6, int i7, Notification notification2, String str2, boolean z5, String str3, CharSequence[] charSequenceArr, RemoteViews remoteViews2, RemoteViews remoteViews3, RemoteViews remoteViews4, int i8) {
            PendingIntent pendingIntent3;
            boolean z6 = false;
            Notification.Builder deleteIntent = new Notification.Builder(context).setWhen(notification.when).setShowWhen(z2).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setSubText(charSequence4).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
            if ((notification.flags & 128) != 0) {
                pendingIntent3 = pendingIntent2;
                z6 = true;
            } else {
                pendingIntent3 = pendingIntent2;
            }
            this.f102a = deleteIntent.setFullScreenIntent(pendingIntent3, z6).setLargeIcon(bitmap).setNumber(i2).setUsesChronometer(z3).setPriority(i5).setProgress(i3, i4, z).setLocalOnly(z4).setExtras(bundle).setGroup(str2).setGroupSummary(z5).setSortKey(str3).setCategory(str).setColor(i6).setVisibility(i7).setPublicVersion(notification2).setRemoteInputHistory(charSequenceArr);
            if (remoteViews2 != null) {
                this.f102a.setCustomContentView(remoteViews2);
            }
            if (remoteViews3 != null) {
                this.f102a.setCustomBigContentView(remoteViews3);
            }
            if (remoteViews4 != null) {
                this.f102a.setCustomHeadsUpContentView(remoteViews4);
            }
            Iterator<String> it = arrayList.iterator();
            while (it.hasNext()) {
                this.f102a.addPerson(it.next());
            }
            this.f103b = i8;
        }

        /* renamed from: a */
        private void m67a(Notification notification) {
            notification.sound = null;
            notification.vibrate = null;
            notification.defaults &= -2;
            notification.defaults &= -3;
        }

        /* renamed from: a */
        public Notification mo34a() {
            Notification build = this.f102a.build();
            if (this.f103b != 0) {
                if (build.getGroup() != null && (build.flags & 512) != 0 && this.f103b == 2) {
                    m67a(build);
                }
                if (build.getGroup() != null && (build.flags & 512) == 0 && this.f103b == 1) {
                    m67a(build);
                }
            }
            return build;
        }

        /* renamed from: a */
        public void mo33a(C0018j.a aVar) {
            C0016h.m66a(this.f102a, aVar);
        }
    }

    /* renamed from: a */
    public static void m66a(Notification.Builder builder, C0018j.a aVar) {
        Notification.Action.Builder builder2 = new Notification.Action.Builder(aVar.mo37a(), aVar.mo38b(), aVar.mo39c());
        if (aVar.mo45i() != null) {
            for (RemoteInput remoteInput : C0022n.m77a(aVar.mo45i())) {
                builder2.addRemoteInput(remoteInput);
            }
        }
        Bundle bundle = aVar.mo40d() != null ? new Bundle(aVar.mo40d()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", aVar.mo41e());
        builder2.setAllowGeneratedReplies(aVar.mo41e());
        builder2.addExtras(bundle);
        builder.addAction(builder2.build());
    }
}
