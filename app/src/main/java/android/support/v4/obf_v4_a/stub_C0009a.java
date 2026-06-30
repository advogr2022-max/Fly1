package android.support.v4.obf_v4_a;

import android.content.Context;
import android.app.Activity;

public class stub_C0009a {
    public static int m132b(Context context, String permission) {
        return android.support.v4.content.ContextCompat.checkSelfPermission(context, permission);
    }
    public static void m28a(Activity activity, String[] permissions, int requestCode) {
        activity.requestPermissions(permissions, requestCode);
    }
}
