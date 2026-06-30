package flyme_dialogs.flyme_dialogs_a;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import types.GpsVal;
import types.PoiPoint;

/* renamed from: f.a.a */
/* loaded from: classes.dex */
public class DialogC0195a extends Dialog {
    public DialogC0195a(Context context) {
        super(context);
    }

    /* renamed from: a */
    public static void m829a(Activity activity, GpsVal gpsVal, PoiPoint poiPoint) {
        m830b(activity, gpsVal, poiPoint);
    }

    /* renamed from: b */
    private static DialogC0195a m830b(Activity activity, GpsVal gpsVal, PoiPoint poiPoint) {
        return new DialogC0195a(activity);
    }
}
