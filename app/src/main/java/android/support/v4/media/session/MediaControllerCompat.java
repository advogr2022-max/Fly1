package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
// import ...C0056c;
// import ...InterfaceC0054a;
// import ...InterfaceC0055b;
import android.support.v4.media.session.MediaSessionCompat;
// import ...C0010b;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* loaded from: classes.dex */
public final class MediaControllerCompat {

    /* loaded from: classes.dex */
    static class MediaControllerImplApi21 {

        /* renamed from: a */
        private final List<AbstractC0046a> f205a;

        /* renamed from: b */
        private // InterfaceC0055b f206b
        Object f206b;

        /* renamed from: c */
        private HashMap<AbstractC0046a, BinderC0045a> f207c;

        /* loaded from: classes.dex */
        private static class ExtraBinderRequestResultReceiver extends android.os.ResultReceiver {

            /* renamed from: a */
            private WeakReference<MediaControllerImplApi21> f208a;
        @Override
            protected void onReceiveResult(int i2, Bundle bundle) {
                MediaControllerImplApi21 mediaControllerImplApi21 = this.f208a.get();
                if (mediaControllerImplApi21 == null || bundle == null) {
                    return;
                }
                mediaControllerImplApi21.f206b = null;
                mediaControllerImplApi21.m182a();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$a */
        /* loaded from: classes.dex */
        public static class BinderC0045a extends AbstractC0046a.c {
            BinderC0045a(AbstractC0046a abstractC0046a) {
                super(abstractC0046a);
            }
        @Override
            /* renamed from: a */
            public void mo184a() {
                throw new AssertionError();
            }
        @Override
            /* renamed from: a */
            public void mo185a(Bundle bundle) {
                throw new AssertionError();
            }
        @Override
            /* renamed from: a */
            public void mo186a(MediaMetadataCompat mediaMetadataCompat) {
                throw new AssertionError();
            }
        @Override
            /* renamed from: a */
            public void mo187a(ParcelableVolumeInfo parcelableVolumeInfo) {
                throw new AssertionError();
            }
        @Override
            /* renamed from: a */
            public void mo188a(CharSequence charSequence) {
                throw new AssertionError();
            }
        @Override
            /* renamed from: a */
            public void mo189a(List<MediaSessionCompat.QueueItem> list) {
                throw new AssertionError();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m182a() {
            if (this.f206b == null) {
                return;
            }
            synchronized (this.f205a) {
                for (AbstractC0046a abstractC0046a : this.f205a) {
                    BinderC0045a binderC0045a = new BinderC0045a(abstractC0046a);
                    this.f207c.put(abstractC0046a, binderC0045a);
                    abstractC0046a.f210b = true;
                    try {
                        this.f206b.mo242a(binderC0045a);
                    } catch (RemoteException e2) {
                        Log.e("MediaControllerCompat", "Dead object in registerCallback.", e2);
                    }
                }
                this.f205a.clear();
            }
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0046a implements IBinder.DeathRecipient {

        /* renamed from: a */
        a f209a;

        /* renamed from: b */
        boolean f210b;

        /* renamed from: c */
        private final Object f211c;

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$a */
        /* loaded from: classes.dex */
        public class a extends Handler {

            /* renamed from: a */
            boolean f212a;

            /* renamed from: b */
            final /* synthetic */ AbstractC0046a f213b;
        @Override
            public void handleMessage(Message message) {
                if (this.f212a) {
                    switch (message.what) {
                        case 1:
                            this.f213b.m198a((String) message.obj, message.getData());
                            return;
                        case 2:
                            this.f213b.m196a((PlaybackStateCompat) message.obj);
                            return;
                        case 3:
                            this.f213b.m194a((MediaMetadataCompat) message.obj);
                            return;
                        case 4:
                            this.f213b.m195a((C0047b) message.obj);
                            return;
                        case 5:
                            this.f213b.m199a((List<MediaSessionCompat.QueueItem>) message.obj);
                            return;
                        case 6:
                            this.f213b.m197a((CharSequence) message.obj);
                            return;
                        case 7:
                            this.f213b.m193a((Bundle) message.obj);
                            return;
                        case 8:
                            this.f213b.m190a();
                            return;
                        case 9:
                            this.f213b.m191a(((Integer) message.obj).intValue());
                            return;
                        case 10:
                            this.f213b.m202b(((Boolean) message.obj).booleanValue());
                            return;
                        case 11:
                            this.f213b.m200a(((Boolean) message.obj).booleanValue());
                            return;
                        case 12:
                            this.f213b.m201b(((Integer) message.obj).intValue());
                            return;
                        default:
                            return;
                    }
                }
            }
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$b */
        /* loaded from: classes.dex */
        private static class b /* implements C0056c.a */ {

            /* renamed from: a */
            private final WeakReference<AbstractC0046a> f214a;

            b(AbstractC0046a abstractC0046a) {
                this.f214a = new WeakReference<>(abstractC0046a);
            }
        @Override
            /* renamed from: a */
            public void mo203a() {
                AbstractC0046a abstractC0046a = this.f214a.get();
                if (abstractC0046a != null) {
                    abstractC0046a.m190a();
                }
            }
        @Override
            /* renamed from: a */
            public void mo204a(int i2, int i3, int i4, int i5, int i6) {
                AbstractC0046a abstractC0046a = this.f214a.get();
                if (abstractC0046a != null) {
                    abstractC0046a.m195a(new C0047b(i2, i3, i4, i5, i6));
                }
            }
        @Override
            /* renamed from: a */
            public void mo205a(Bundle bundle) {
                AbstractC0046a abstractC0046a = this.f214a.get();
                if (abstractC0046a != null) {
                    abstractC0046a.m193a(bundle);
                }
            }
        @Override
            /* renamed from: a */
            public void mo206a(CharSequence charSequence) {
                AbstractC0046a abstractC0046a = this.f214a.get();
                if (abstractC0046a != null) {
                    abstractC0046a.m197a(charSequence);
                }
            }
        @Override
            /* renamed from: a */
            public void mo207a(Object obj) {
                AbstractC0046a abstractC0046a = this.f214a.get();
                if (abstractC0046a == null || abstractC0046a.f210b) {
                    return;
                }
                abstractC0046a.m196a(PlaybackStateCompat.m227a(obj));
            }
        @Override
            /* renamed from: a */
            public void mo208a(String str, Bundle bundle) {
                AbstractC0046a abstractC0046a = this.f214a.get();
                if (abstractC0046a != null) {
                    if (!abstractC0046a.f210b || Build.VERSION.SDK_INT >= 23) {
                        abstractC0046a.m198a(str, bundle);
                    }
                }
            }
        @Override
            /* renamed from: a */
            public void mo209a(List<?> list) {
                AbstractC0046a abstractC0046a = this.f214a.get();
                if (abstractC0046a != null) {
                    abstractC0046a.m199a(MediaSessionCompat.QueueItem.m218a(list));
                }
            }
        @Override
            /* renamed from: b */
            public void mo210b(Object obj) {
                AbstractC0046a abstractC0046a = this.f214a.get();
                if (abstractC0046a != null) {
                    abstractC0046a.m194a(MediaMetadataCompat.m155a(obj));
                }
            }
        }

        /* renamed from: android.support.v4.media.session.MediaControllerCompat$a$c */
        /* loaded from: classes.dex */
        private static class c /* extends InterfaceC0054a.a */ {

            /* renamed from: a */
            private final WeakReference<AbstractC0046a> f215a;

            c(AbstractC0046a abstractC0046a) {
                this.f215a = new WeakReference<>(abstractC0046a);
            }

            /* renamed from: a */
            public void mo184a() {
                AbstractC0046a abstractC0046a = this.f215a.get();
                if (abstractC0046a != null) {
                    abstractC0046a.m192a(8, null, null);
                }
            }
        @Override
            /* renamed from: a */
            public void mo211a(int i2) {
                AbstractC0046a abstractC0046a = this.f215a.get();
                if (abstractC0046a != null) {
                    abstractC0046a.m192a(9, Integer.valueOf(i2), null);
                }
            }

            /* renamed from: a */
            public void mo185a(Bundle bundle) {
                AbstractC0046a abstractC0046a = this.f215a.get();
                if (abstractC0046a != null) {
                    abstractC0046a.m192a(7, bundle, null);
                }
            }

            /* renamed from: a */
            public void mo186a(MediaMetadataCompat mediaMetadataCompat) {
                AbstractC0046a abstractC0046a = this.f215a.get();
                if (abstractC0046a != null) {
                    abstractC0046a.m192a(3, mediaMetadataCompat, null);
                }
            }

            /* renamed from: a */
            public void mo187a(ParcelableVolumeInfo parcelableVolumeInfo) {
                AbstractC0046a abstractC0046a = this.f215a.get();
                if (abstractC0046a != null) {
                    abstractC0046a.m192a(4, parcelableVolumeInfo != null ? new C0047b(parcelableVolumeInfo.f227a, parcelableVolumeInfo.f228b, parcelableVolumeInfo.f229c, parcelableVolumeInfo.f230d, parcelableVolumeInfo.f231e) : null, null);
                }
            }
        @Override
            /* renamed from: a */
            public void mo212a(PlaybackStateCompat playbackStateCompat) {
                AbstractC0046a abstractC0046a = this.f215a.get();
                if (abstractC0046a != null) {
                    abstractC0046a.m192a(2, playbackStateCompat, null);
                }
            }

            /* renamed from: a */
            public void mo188a(CharSequence charSequence) {
                AbstractC0046a abstractC0046a = this.f215a.get();
                if (abstractC0046a != null) {
                    abstractC0046a.m192a(6, charSequence, null);
                }
            }
        @Override
            /* renamed from: a */
            public void mo213a(String str, Bundle bundle) {
                AbstractC0046a abstractC0046a = this.f215a.get();
                if (abstractC0046a != null) {
                    abstractC0046a.m192a(1, str, bundle);
                }
            }

            /* renamed from: a */
            public void mo189a(List<MediaSessionCompat.QueueItem> list) {
                AbstractC0046a abstractC0046a = this.f215a.get();
                if (abstractC0046a != null) {
                    abstractC0046a.m192a(5, list, null);
                }
            }
        @Override
            /* renamed from: a */
            public void mo214a(boolean z) {
                AbstractC0046a abstractC0046a = this.f215a.get();
                if (abstractC0046a != null) {
                    abstractC0046a.m192a(10, Boolean.valueOf(z), null);
                }
            }
        @Override
            /* renamed from: b */
            public void mo215b(int i2) {
                AbstractC0046a abstractC0046a = this.f215a.get();
                if (abstractC0046a != null) {
                    abstractC0046a.m192a(12, Integer.valueOf(i2), null);
                }
            }
        @Override
            /* renamed from: b */
            public void mo216b(boolean z) {
                AbstractC0046a abstractC0046a = this.f215a.get();
                if (abstractC0046a != null) {
                    abstractC0046a.m192a(11, Boolean.valueOf(z), null);
                }
            }
        }

        public AbstractC0046a() {
            this.f211c = Build.VERSION.SDK_INT >= 21 ? C0056c.m284a(new b(this)) : new c(this);
        }

        /* renamed from: a */
        public void m190a() {
        }

        /* renamed from: a */
        public void m191a(int i2) {
        }

        /* renamed from: a */
        void m192a(int i2, Object obj, Bundle bundle) {
            if (this.f209a != null) {
                Message obtainMessage = this.f209a.obtainMessage(i2, obj);
                obtainMessage.setData(bundle);
                obtainMessage.sendToTarget();
            }
        }

        /* renamed from: a */
        public void m193a(Bundle bundle) {
        }

        /* renamed from: a */
        public void m194a(MediaMetadataCompat mediaMetadataCompat) {
        }

        /* renamed from: a */
        public void m195a(C0047b c0047b) {
        }

        /* renamed from: a */
        public void m196a(PlaybackStateCompat playbackStateCompat) {
        }

        /* renamed from: a */
        public void m197a(CharSequence charSequence) {
        }

        /* renamed from: a */
        public void m198a(String str, Bundle bundle) {
        }

        /* renamed from: a */
        public void m199a(List<MediaSessionCompat.QueueItem> list) {
        }

        /* renamed from: a */
        public void m200a(boolean z) {
        }

        /* renamed from: b */
        public void m201b(int i2) {
        }

        @Deprecated
        /* renamed from: b */
        public void m202b(boolean z) {
        }
    }

    /* renamed from: android.support.v4.media.session.MediaControllerCompat$b */
    /* loaded from: classes.dex */
    public static final class C0047b {

        /* renamed from: a */
        private final int f216a;

        /* renamed from: b */
        private final int f217b;

        /* renamed from: c */
        private final int f218c;

        /* renamed from: d */
        private final int f219d;

        /* renamed from: e */
        private final int f220e;

        C0047b(int i2, int i3, int i4, int i5, int i6) {
            this.f216a = i2;
            this.f217b = i3;
            this.f218c = i4;
            this.f219d = i5;
            this.f220e = i6;
        }
    }
}
