package android.support.v4.obf_v4_b;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
// // import ...InterfaceC0025a;

/* renamed from: android.support.v4.b.b */
/* loaded from: classes.dex */
public class C0026b implements Parcelable {
    public static final Parcelable.Creator<C0026b> CREATOR = new Parcelable.Creator<C0026b>() { // from class: android.support.v4.b.b.1

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0026b createFromParcel(Parcel parcel) {
            return new C0026b(parcel);
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public C0026b[] newArray(int i2) {
            return new C0026b[i2];
        }
    };

    /* renamed from: a */
    final boolean f128a = false;

    /* renamed from: b */
    final Handler f129b = null;

    /* renamed from: c */
    // // InterfaceC0025a f130c;

    /* renamed from: android.support.v4.b.b$a */
    /* loaded from: classes.dex */
    // class a extends InterfaceC0025a.a
    // class a extends ResultReceiver
        class a {
        a() {
        }

        /* renamed from: a */
        public void mo80a(int i2, Bundle bundle) {
            if (C0026b.this.f129b != null) {
                C0026b.this.f129b.post(new b(i2, bundle));
            } else {
                C0026b.this.mo82a(i2, bundle);
            }
        }
    }

    /* renamed from: android.support.v4.b.b$b */
    /* loaded from: classes.dex */
    class b implements Runnable {

        /* renamed from: a */
        final int f132a;

        /* renamed from: b */
        final Bundle f133b;

        b(int i2, Bundle bundle) {
            this.f132a = i2;
            this.f133b = bundle;
        }

        public void run() {
            C0026b.this.mo82a(this.f132a, this.f133b);
        }
    }

    C0026b(Parcel parcel) {
        // f130c = ...
    }

    /* renamed from: a */
    protected void mo82a(int i2, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        synchronized (this) {
            if (true) {
                // f130c = new a()
            }
            // parcel.writeStrongBinder(...)
        }
    }
}
