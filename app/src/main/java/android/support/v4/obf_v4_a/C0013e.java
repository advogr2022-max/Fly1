package android.support.v4.obf_v4_a;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.obf_v4_a.C0014f;
import android.support.v4.obf_v4_a.C0015g;
import android.support.v4.obf_v4_a.C0016h;
import android.support.v4.obf_v4_a.C0017i;
import android.support.v4.obf_v4_a.C0018j;
import android.support.v4.obf_v4_a.C0019k;
import android.support.v4.obf_v4_a.C0020l;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: android.support.v4.a.e */
/* loaded from: classes.dex */
public class C0013e {

    /* renamed from: a */
    static final k f41a;

    /* renamed from: android.support.v4.a.e$a */
    /* loaded from: classes.dex */
    public static class a extends C0018j.a {

        /* renamed from: e */
        public static final C0018j.a.InterfaceC0393a f42e = new C0018j.a.InterfaceC0393a() { // from class: android.support.v4.a.e.a.1
        };

        /* renamed from: a */
        final Bundle f43a;

        /* renamed from: b */
        public int f44b;

        /* renamed from: c */
        public CharSequence f45c;

        /* renamed from: d */
        public PendingIntent f46d;

        /* renamed from: f */
        private final Object[] f47f;

        /* renamed from: g */
        private final Object[] f48g;

        /* renamed from: h */
        private boolean f49h;

        /* renamed from: a */
        public int mo37a() {
            return this.f44b;
        }

        /* renamed from: b */
        public CharSequence mo38b() {
            return this.f45c;
        }

        /* renamed from: c */
        public PendingIntent mo39c() {
            return this.f46d;
        }

        /* renamed from: d */
        public Bundle mo40d() {
            return this.f43a;
        }

        /* renamed from: e */
        public boolean mo41e() {
            return this.f49h;
        }

        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public Object[] mo45i() {
            return this.f47f;
        }

        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public Object[] mo44h() {
            return this.f48g;
        }
    }

    /* renamed from: android.support.v4.a.e$b */
    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: A */
        Bundle f50A;

        /* renamed from: B */
        int f51B;

        /* renamed from: C */
        int f52C;

        /* renamed from: D */
        Notification f53D;

        /* renamed from: E */
        RemoteViews f54E;

        /* renamed from: F */
        RemoteViews f55F;

        /* renamed from: G */
        RemoteViews f56G;

        /* renamed from: H */
        String f57H;

        /* renamed from: I */
        int f58I;

        /* renamed from: J */
        String f59J;

        /* renamed from: K */
        long f60K;

        /* renamed from: L */
        public Notification f61L;

        /* renamed from: M */
        public ArrayList<String> f62M;

        /* renamed from: N */
        private int f63N;

        /* renamed from: a */
        public Context f64a;

        /* renamed from: b */
        public CharSequence f65b;

        /* renamed from: c */
        public CharSequence f66c;

        /* renamed from: d */
        PendingIntent f67d;

        /* renamed from: e */
        PendingIntent f68e;

        /* renamed from: f */
        RemoteViews f69f;

        /* renamed from: g */
        public Bitmap f70g;

        /* renamed from: h */
        public CharSequence f71h;

        /* renamed from: i */
        public int f72i;

        /* renamed from: j */
        int f73j;

        /* renamed from: k */
        boolean f74k;

        /* renamed from: l */
        public boolean f75l;

        /* renamed from: m */
        public l f76m;

        /* renamed from: n */
        public CharSequence f77n;

        /* renamed from: o */
        public CharSequence[] f78o;

        /* renamed from: p */
        int f79p;

        /* renamed from: q */
        int f80q;

        /* renamed from: r */
        boolean f81r;

        /* renamed from: s */
        String f82s;

        /* renamed from: t */
        boolean f83t;

        /* renamed from: u */
        String f84u;

        /* renamed from: v */
        public ArrayList<a> f85v;

        /* renamed from: w */
        boolean f86w;

        /* renamed from: x */
        boolean f87x;

        /* renamed from: y */
        boolean f88y;

        /* renamed from: z */
        String f89z;

        @Deprecated
        public b(Context context) {
            this(context, null);
        }

        public b(Context context, String str) {
            this.f74k = true;
            this.f85v = new ArrayList<>();
            this.f86w = false;
            this.f51B = 0;
            this.f52C = 0;
            this.f58I = 0;
            this.f63N = 0;
            this.f61L = new Notification();
            this.f64a = context;
            this.f57H = str;
            this.f61L.when = System.currentTimeMillis();
            this.f61L.audioStreamType = -1;
            this.f73j = 0;
            this.f62M = new ArrayList<>();
        }

        /* renamed from: a */
        private void m47a(int i2, boolean z) {
            Notification notification;
            int i3;
            if (z) {
                notification = this.f61L;
                i3 = i2 | notification.flags;
            } else {
                notification = this.f61L;
                i3 = (i2 ^ (-1)) & notification.flags;
            }
            notification.flags = i3;
        }

        /* renamed from: c */
        protected static CharSequence m48c(CharSequence charSequence) {
            return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
        }

        /* renamed from: a */
        public Notification m49a() {
            return C0013e.f41a.mo57a(this, m55b());
        }

        /* renamed from: a */
        public b m50a(int i2) {
            this.f61L.icon = i2;
            return this;
        }

        /* renamed from: a */
        public b m51a(PendingIntent pendingIntent) {
            this.f67d = pendingIntent;
            return this;
        }

        /* renamed from: a */
        public b m52a(CharSequence charSequence) {
            this.f65b = m48c(charSequence);
            return this;
        }

        /* renamed from: a */
        public b m53a(boolean z) {
            m47a(2, z);
            return this;
        }

        /* renamed from: b */
        public b m54b(CharSequence charSequence) {
            this.f66c = m48c(charSequence);
            return this;
        }

        /* renamed from: b */
        protected c m55b() {
            return new c();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: android.support.v4.a.e$c */
    /* loaded from: classes.dex */
    public static class c {
        protected c() {
        }

        /* renamed from: a */
        public Notification m56a(b bVar, InterfaceC0012d interfaceC0012d) {
            RemoteViews m62d;
            RemoteViews m61c;
            RemoteViews m60b = bVar.f76m != null ? bVar.f76m.m60b(interfaceC0012d) : null;
            Notification mo34a = interfaceC0012d.mo34a();
            if (m60b == null) {
                if (bVar.f54E != null) {
                    m60b = bVar.f54E;
                }
                if (Build.VERSION.SDK_INT >= 16 && bVar.f76m != null && (m61c = bVar.f76m.m61c(interfaceC0012d)) != null) {
                    mo34a.bigContentView = m61c;
                }
                if (Build.VERSION.SDK_INT >= 21 && bVar.f76m != null && (m62d = bVar.f76m.m62d(interfaceC0012d)) != null) {
                    mo34a.headsUpContentView = m62d;
                }
                return mo34a;
            }
            mo34a.contentView = m60b;
            if (Build.VERSION.SDK_INT >= 16) {
                mo34a.bigContentView = m61c;
            }
            if (Build.VERSION.SDK_INT >= 21) {
                mo34a.headsUpContentView = m62d;
            }
            return mo34a;
        }
    }

    /* renamed from: android.support.v4.a.e$d */
    /* loaded from: classes.dex */
    static class d extends j {
        d() {
        }

        /* renamed from: a */
        public Notification mo57a(b bVar, c cVar) {
            Bundle m35a;
            C0019k.a aVar = new C0019k.a(bVar.f64a, bVar.f61L, bVar.f65b, bVar.f66c, bVar.f71h, bVar.f69f, bVar.f72i, bVar.f67d, bVar.f68e, bVar.f70g, bVar.f79p, bVar.f80q, bVar.f81r, bVar.f75l, bVar.f73j, bVar.f77n, bVar.f86w, bVar.f50A, bVar.f82s, bVar.f83t, bVar.f84u, bVar.f54E, bVar.f55F);
            C0013e.m36a(aVar, bVar.f85v);
            if (bVar.f76m != null) {
                bVar.f76m.m59a(aVar);
            }
            Notification m56a = cVar.m56a(bVar, aVar);
            if (bVar.f76m != null && (m35a = C0013e.m35a(m56a)) != null) {
                bVar.f76m.m58a(m35a);
            }
            return m56a;
        }
    }

    /* renamed from: android.support.v4.a.e$e */
    /* loaded from: classes.dex */
    static class e extends d {
        e() {
        }

        /* renamed from: a */
        public Notification mo57a(b bVar, c cVar) {
            C0020l.a aVar = new C0020l.a(bVar.f64a, bVar.f61L, bVar.f65b, bVar.f66c, bVar.f71h, bVar.f69f, bVar.f72i, bVar.f67d, bVar.f68e, bVar.f70g, bVar.f79p, bVar.f80q, bVar.f81r, bVar.f74k, bVar.f75l, bVar.f73j, bVar.f77n, bVar.f86w, bVar.f62M, bVar.f50A, bVar.f82s, bVar.f83t, bVar.f84u, bVar.f54E, bVar.f55F);
            C0013e.m36a(aVar, bVar.f85v);
            if (bVar.f76m != null) {
                bVar.f76m.m59a(aVar);
            }
            return cVar.m56a(bVar, aVar);
        }
    }

    /* renamed from: android.support.v4.a.e$f */
    /* loaded from: classes.dex */
    static class f extends e {
        f() {
        }

        /* renamed from: a */
        public Notification mo57a(b bVar, c cVar) {
            C0014f.a aVar = new C0014f.a(bVar.f64a, bVar.f61L, bVar.f65b, bVar.f66c, bVar.f71h, bVar.f69f, bVar.f72i, bVar.f67d, bVar.f68e, bVar.f70g, bVar.f79p, bVar.f80q, bVar.f81r, bVar.f74k, bVar.f75l, bVar.f73j, bVar.f77n, bVar.f86w, bVar.f62M, bVar.f50A, bVar.f82s, bVar.f83t, bVar.f84u, bVar.f54E, bVar.f55F, bVar.f63N);
            C0013e.m36a(aVar, bVar.f85v);
            if (bVar.f76m != null) {
                bVar.f76m.m59a(aVar);
            }
            Notification m56a = cVar.m56a(bVar, aVar);
            if (bVar.f76m != null) {
                bVar.f76m.m58a(C0013e.m35a(m56a));
            }
            return m56a;
        }
    }

    /* renamed from: android.support.v4.a.e$g */
    /* loaded from: classes.dex */
    static class g extends f {
        g() {
        }

        /* renamed from: a */
        public Notification mo57a(b bVar, c cVar) {
            C0015g.a aVar = new C0015g.a(bVar.f64a, bVar.f61L, bVar.f65b, bVar.f66c, bVar.f71h, bVar.f69f, bVar.f72i, bVar.f67d, bVar.f68e, bVar.f70g, bVar.f79p, bVar.f80q, bVar.f81r, bVar.f74k, bVar.f75l, bVar.f73j, bVar.f77n, bVar.f86w, bVar.f89z, bVar.f62M, bVar.f50A, bVar.f51B, bVar.f52C, bVar.f53D, bVar.f82s, bVar.f83t, bVar.f84u, bVar.f54E, bVar.f55F, bVar.f56G, bVar.f63N);
            C0013e.m36a(aVar, bVar.f85v);
            if (bVar.f76m != null) {
                bVar.f76m.m59a(aVar);
            }
            Notification m56a = cVar.m56a(bVar, aVar);
            if (bVar.f76m != null) {
                bVar.f76m.m58a(C0013e.m35a(m56a));
            }
            return m56a;
        }
    }

    /* renamed from: android.support.v4.a.e$h */
    /* loaded from: classes.dex */
    static class h extends g {
        h() {
        }

        /* renamed from: a */
        public Notification mo57a(b bVar, c cVar) {
            C0016h.a aVar = new C0016h.a(bVar.f64a, bVar.f61L, bVar.f65b, bVar.f66c, bVar.f71h, bVar.f69f, bVar.f72i, bVar.f67d, bVar.f68e, bVar.f70g, bVar.f79p, bVar.f80q, bVar.f81r, bVar.f74k, bVar.f75l, bVar.f73j, bVar.f77n, bVar.f86w, bVar.f89z, bVar.f62M, bVar.f50A, bVar.f51B, bVar.f52C, bVar.f53D, bVar.f82s, bVar.f83t, bVar.f84u, bVar.f78o, bVar.f54E, bVar.f55F, bVar.f56G, bVar.f63N);
            C0013e.m36a(aVar, bVar.f85v);
            if (bVar.f76m != null) {
                bVar.f76m.m59a(aVar);
            }
            Notification m56a = cVar.m56a(bVar, aVar);
            if (bVar.f76m != null) {
                bVar.f76m.m58a(C0013e.m35a(m56a));
            }
            return m56a;
        }
    }

    /* renamed from: android.support.v4.a.e$i */
    /* loaded from: classes.dex */
    static class i extends h {
        i() {
        }

        /* renamed from: a */
        public Notification mo57a(b bVar, c cVar) {
            C0017i.a aVar = new C0017i.a(bVar.f64a, bVar.f61L, bVar.f65b, bVar.f66c, bVar.f71h, bVar.f69f, bVar.f72i, bVar.f67d, bVar.f68e, bVar.f70g, bVar.f79p, bVar.f80q, bVar.f81r, bVar.f74k, bVar.f75l, bVar.f73j, bVar.f77n, bVar.f86w, bVar.f89z, bVar.f62M, bVar.f50A, bVar.f51B, bVar.f52C, bVar.f53D, bVar.f82s, bVar.f83t, bVar.f84u, bVar.f78o, bVar.f54E, bVar.f55F, bVar.f56G, bVar.f57H, bVar.f58I, bVar.f59J, bVar.f60K, bVar.f87x, bVar.f88y, bVar.f63N);
            C0013e.m36a(aVar, bVar.f85v);
            if (bVar.f76m != null) {
                bVar.f76m.m59a(aVar);
            }
            Notification m56a = cVar.m56a(bVar, aVar);
            if (bVar.f76m != null) {
                bVar.f76m.m58a(C0013e.m35a(m56a));
            }
            return m56a;
        }
    }

    /* renamed from: android.support.v4.a.e$j */
    /* loaded from: classes.dex */
    static class j implements k {

        /* renamed from: android.support.v4.a.e$j$a */
        /* loaded from: classes.dex */
        public static class a /* implements removed */ {

            /* renamed from: a */
            private Notification.Builder f90a;

            a(Context context, Notification notification, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, RemoteViews remoteViews, int i2, PendingIntent pendingIntent, PendingIntent pendingIntent2, Bitmap bitmap, int i3, int i4, boolean z) {
                boolean z2 = false;
                Notification.Builder deleteIntent = new Notification.Builder(context).setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, remoteViews).setSound(notification.sound, notification.audioStreamType).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(charSequence).setContentText(charSequence2).setContentInfo(charSequence3).setContentIntent(pendingIntent).setDeleteIntent(notification.deleteIntent);
                if ((notification.flags & 128) != 0) {
                    z2 = true;
                }
                this.f90a = deleteIntent.setFullScreenIntent(pendingIntent2, z2).setLargeIcon(bitmap).setNumber(i2).setProgress(i3, i4, z);
            }

            /* renamed from: a */
            public Notification mo34a() {
                return this.f90a.getNotification();
            }
        }

        j() {
        }

        /* renamed from: a */
        public Notification mo57a(b bVar, c cVar) {
            return cVar.m56a(bVar, new a(bVar.f64a, bVar.f61L, bVar.f65b, bVar.f66c, bVar.f71h, bVar.f69f, bVar.f72i, bVar.f67d, bVar.f68e, bVar.f70g, bVar.f79p, bVar.f80q, bVar.f81r));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: android.support.v4.a.e$k */
    /* loaded from: classes.dex */
    public interface k {
        /* renamed from: a */
        Notification mo57a(b bVar, c cVar);
    }

    /* renamed from: android.support.v4.a.e$l */
    /* loaded from: classes.dex */
    public static abstract class l {
        /* renamed from: a */
        public void m58a(Bundle bundle) {
        }

        /* renamed from: a */
        public void m59a(InterfaceC0012d interfaceC0012d) {
        }

        /* renamed from: b */
        public RemoteViews m60b(InterfaceC0012d interfaceC0012d) {
            return null;
        }

        /* renamed from: c */
        public RemoteViews m61c(InterfaceC0012d interfaceC0012d) {
            return null;
        }

        /* renamed from: d */
        public RemoteViews m62d(InterfaceC0012d interfaceC0012d) {
            return null;
        }
    }

    static {
        f41a = Build.VERSION.SDK_INT >= 26 ? new i() : Build.VERSION.SDK_INT >= 24 ? new h() : Build.VERSION.SDK_INT >= 21 ? new g() : Build.VERSION.SDK_INT >= 20 ? new f() : Build.VERSION.SDK_INT >= 19 ? new e() : Build.VERSION.SDK_INT >= 16 ? new d() : new j();
    }

    /* renamed from: a */
    public static Bundle m35a(Notification notification) {
        if (Build.VERSION.SDK_INT >= 19) {
            return notification.extras;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return C0019k.m69a(notification);
        }
        return null;
    }

    /* renamed from: a */
    static void m36a(Object interfaceC0011c, ArrayList<a> arrayList) {
        Iterator<a> it = arrayList.iterator();
        while (it.hasNext()) {
            interfaceC0011c.mo33a(it.next());
        }
    }
}
