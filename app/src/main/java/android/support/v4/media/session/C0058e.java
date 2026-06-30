package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

/* renamed from: android.support.v4.media.session.e */
/* loaded from: classes.dex */
class C0058e {

    /* renamed from: android.support.v4.media.session.e$a */
    /* loaded from: classes.dex */
    static final class a {
        /* renamed from: a */
        public static String m299a(Object obj) {
            return ((PlaybackState.CustomAction) obj).getAction();
        }

        /* renamed from: b */
        public static CharSequence m300b(Object obj) {
            return ((PlaybackState.CustomAction) obj).getName();
        }

        /* renamed from: c */
        public static int m301c(Object obj) {
            return ((PlaybackState.CustomAction) obj).getIcon();
        }

        /* renamed from: d */
        public static Bundle m302d(Object obj) {
            return ((PlaybackState.CustomAction) obj).getExtras();
        }
    }

    /* renamed from: a */
    public static int m290a(Object obj) {
        return ((PlaybackState) obj).getState();
    }

    /* renamed from: b */
    public static long m291b(Object obj) {
        return ((PlaybackState) obj).getPosition();
    }

    /* renamed from: c */
    public static long m292c(Object obj) {
        return ((PlaybackState) obj).getBufferedPosition();
    }

    /* renamed from: d */
    public static float m293d(Object obj) {
        return ((PlaybackState) obj).getPlaybackSpeed();
    }

    /* renamed from: e */
    public static long m294e(Object obj) {
        return ((PlaybackState) obj).getActions();
    }

    /* renamed from: f */
    public static CharSequence m295f(Object obj) {
        return ((PlaybackState) obj).getErrorMessage();
    }

    /* renamed from: g */
    public static long m296g(Object obj) {
        return ((PlaybackState) obj).getLastPositionUpdateTime();
    }

    /* renamed from: h */
    public static List<Object> m297h(Object obj) {
        return (List) ((PlaybackState) obj).getCustomActions();
    }

    /* renamed from: i */
    public static long m298i(Object obj) {
        return ((PlaybackState) obj).getActiveQueueItemId();
    }
}
