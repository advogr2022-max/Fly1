package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.obf_v4_b.C0026b;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class MediaBrowserCompat {

    /* renamed from: a */
    static final boolean f169a = Log.isLoggable("MediaBrowserCompat", 3);

    /* loaded from: classes.dex */
    private static class CustomActionResultReceiver extends Object {

        /* renamed from: d */
        private final String f170d;

        /* renamed from: e */
        private final Bundle f171e;

        /* renamed from: f */
        private final AbstractC0035a f172f;

        @Override
        /* renamed from: a */
        protected void mo82a(int i2, Bundle bundle) {
            if (this.f172f == null) {
                return;
            }
            switch (i2) {
                case -1:
                    this.f172f.m137c(this.f170d, this.f171e, bundle);
                    return;
                case 0:
                    this.f172f.m136b(this.f170d, this.f171e, bundle);
                    return;
                case 1:
                    this.f172f.m135a(this.f170d, this.f171e, bundle);
                    return;
                default:
                    Log.w("MediaBrowserCompat", "Unknown result code: " + i2 + " (extras=" + this.f171e + ", resultData=" + bundle + ")");
                    return;
            }
        }
    }

    /* loaded from: classes.dex */
    private static class ItemReceiver extends Object {

        /* renamed from: d */
        private final String f173d;

        /* renamed from: e */
        private final AbstractC0036b f174e;

        @Override
        /* renamed from: a */
        protected void mo82a(int i2, Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }
            if (i2 != 0 || bundle == null || !bundle.containsKey("media_item")) {
                this.f174e.m139a(this.f173d);
                return;
            }
            Parcelable parcelable = bundle.getParcelable("media_item");
            if (parcelable == null || (parcelable instanceof MediaItem)) {
                this.f174e.m138a((MediaItem) parcelable);
            } else {
                this.f174e.m139a(this.f173d);
            }
        }
    }

    /* loaded from: classes.dex */
    public static class MediaItem implements Parcelable {
        public static final Parcelable.Creator<MediaItem> CREATOR = new Parcelable.Creator<MediaItem>() { // from class: android.support.v4.media.MediaBrowserCompat.MediaItem.1
            @Override
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public MediaItem createFromParcel(Parcel parcel) {
                return new MediaItem(parcel);
            }

            @Override
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public MediaItem[] newArray(int i2) {
                return new MediaItem[i2];
            }
        };

        /* renamed from: a */
        private final int f175a;

        /* renamed from: b */
        private final MediaDescriptionCompat f176b;

        MediaItem(Parcel parcel) {
            this.f175a = parcel.readInt();
            this.f176b = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "MediaItem{mFlags=" + this.f175a + ", mDescription=" + this.f176b + '}';
        }

        @Override
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f175a);
            this.f176b.writeToParcel(parcel, i2);
        }
    }

    /* loaded from: classes.dex */
    private static class SearchResultReceiver extends Object {

        /* renamed from: d */
        private final String f177d;

        /* renamed from: e */
        private final Bundle f178e;

        /* renamed from: f */
        private final AbstractC0037c f179f;

        @Override
        /* renamed from: a */
        protected void mo82a(int i2, Bundle bundle) {
            if (bundle != null) {
                bundle.setClassLoader(MediaBrowserCompat.class.getClassLoader());
            }
            if (i2 != 0 || bundle == null || !bundle.containsKey("search_results")) {
                this.f179f.m140a(this.f177d, this.f178e);
                return;
            }
            Parcelable[] parcelableArray = bundle.getParcelableArray("search_results");
            ArrayList arrayList = null;
            if (parcelableArray != null) {
                arrayList = new ArrayList();
                for (Parcelable parcelable : parcelableArray) {
                    arrayList.add((MediaItem) parcelable);
                }
            }
            this.f179f.m141a(this.f177d, this.f178e, arrayList);
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$a */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0035a {
        /* renamed from: a */
        public void m135a(String str, Bundle bundle, Bundle bundle2) {
        }

        /* renamed from: b */
        public void m136b(String str, Bundle bundle, Bundle bundle2) {
        }

        /* renamed from: c */
        public void m137c(String str, Bundle bundle, Bundle bundle2) {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$b */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0036b {
        /* renamed from: a */
        public void m138a(MediaItem mediaItem) {
        }

        /* renamed from: a */
        public void m139a(String str) {
        }
    }

    /* renamed from: android.support.v4.media.MediaBrowserCompat$c */
    /* loaded from: classes.dex */
    public static abstract class AbstractC0037c {
        /* renamed from: a */
        public void m140a(String str, Bundle bundle) {
        }

        /* renamed from: a */
        public void m141a(String str, Bundle bundle, List<MediaItem> list) {
        }
    }
}
