package android.support.v4.media.session;

import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.session.C0058e;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new Parcelable.Creator<PlaybackStateCompat>() { // from class: android.support.v4.media.session.PlaybackStateCompat.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public PlaybackStateCompat[] newArray(int i2) {
            return new PlaybackStateCompat[i2];
        }
    };

    /* renamed from: a */
    final int f232a;

    /* renamed from: b */
    final long f233b;

    /* renamed from: c */
    final long f234c;

    /* renamed from: d */
    final float f235d;

    /* renamed from: e */
    final long f236e;

    /* renamed from: f */
    final int f237f;

    /* renamed from: g */
    final CharSequence f238g;

    /* renamed from: h */
    final long f239h;

    /* renamed from: i */
    List<CustomAction> f240i;

    /* renamed from: j */
    final long f241j;

    /* renamed from: k */
    final Bundle f242k;

    /* renamed from: l */
    private Object f243l;

    /* loaded from: classes.dex */
    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new Parcelable.Creator<CustomAction>() { // from class: android.support.v4.media.session.PlaybackStateCompat.CustomAction.1
            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public CustomAction createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }

            @Override // android.os.Parcelable.Creator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public CustomAction[] newArray(int i2) {
                return new CustomAction[i2];
            }
        };

        /* renamed from: a */
        private final String f244a;

        /* renamed from: b */
        private final CharSequence f245b;

        /* renamed from: c */
        private final int f246c;

        /* renamed from: d */
        private final Bundle f247d;

        /* renamed from: e */
        private Object f248e;

        CustomAction(Parcel parcel) {
            this.f244a = parcel.readString();
            this.f245b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f246c = parcel.readInt();
            this.f247d = parcel.readBundle();
        }

        CustomAction(String str, CharSequence charSequence, int i2, Bundle bundle) {
            this.f244a = str;
            this.f245b = charSequence;
            this.f246c = i2;
            this.f247d = bundle;
        }

        /* renamed from: a */
        public static CustomAction m230a(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            CustomAction customAction = new CustomAction(C0058e.a.m299a(obj), C0058e.a.m300b(obj), C0058e.a.m301c(obj), C0058e.a.m302d(obj));
            customAction.f248e = obj;
            return customAction;
        }

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        public String toString() {
            return "Action:mName='" + ((Object) this.f245b) + ", mIcon=" + this.f246c + ", mExtras=" + this.f247d;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.f244a);
            TextUtils.writeToParcel(this.f245b, parcel, i2);
            parcel.writeInt(this.f246c);
            parcel.writeBundle(this.f247d);
        }
    }

    PlaybackStateCompat(int i2, long j2, long j3, float f2, long j4, int i3, CharSequence charSequence, long j5, List<CustomAction> list, long j6, Bundle bundle) {
        this.f232a = i2;
        this.f233b = j2;
        this.f234c = j3;
        this.f235d = f2;
        this.f236e = j4;
        this.f237f = i3;
        this.f238g = charSequence;
        this.f239h = j5;
        this.f240i = new ArrayList(list);
        this.f241j = j6;
        this.f242k = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f232a = parcel.readInt();
        this.f233b = parcel.readLong();
        this.f235d = parcel.readFloat();
        this.f239h = parcel.readLong();
        this.f234c = parcel.readLong();
        this.f236e = parcel.readLong();
        this.f238g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f240i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.f241j = parcel.readLong();
        this.f242k = parcel.readBundle();
        this.f237f = parcel.readInt();
    }

    /* renamed from: a */
    public static PlaybackStateCompat m227a(Object obj) {
        ArrayList arrayList;
        if (obj == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        List<Object> m297h = C0058e.m297h(obj);
        if (m297h != null) {
            ArrayList arrayList2 = new ArrayList(m297h.size());
            Iterator<Object> it = m297h.iterator();
            while (it.hasNext()) {
                arrayList2.add(CustomAction.m230a(it.next()));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(C0058e.m290a(obj), C0058e.m291b(obj), C0058e.m292c(obj), C0058e.m293d(obj), C0058e.m294e(obj), 0, C0058e.m295f(obj), C0058e.m296g(obj), arrayList, C0058e.m298i(obj), Build.VERSION.SDK_INT >= 22 ? null : null);
        playbackStateCompat.f243l = obj;
        return playbackStateCompat;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "PlaybackState {state=" + this.f232a + ", position=" + this.f233b + ", buffered position=" + this.f234c + ", speed=" + this.f235d + ", updated=" + this.f239h + ", actions=" + this.f236e + ", error code=" + this.f237f + ", error message=" + this.f238g + ", custom actions=" + this.f240i + ", active item id=" + this.f241j + "}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f232a);
        parcel.writeLong(this.f233b);
        parcel.writeFloat(this.f235d);
        parcel.writeLong(this.f239h);
        parcel.writeLong(this.f234c);
        parcel.writeLong(this.f236e);
        TextUtils.writeToParcel(this.f238g, parcel, i2);
        parcel.writeTypedList(this.f240i);
        parcel.writeLong(this.f241j);
        parcel.writeBundle(this.f242k);
        parcel.writeInt(this.f237f);
    }
}
