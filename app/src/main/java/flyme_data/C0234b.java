package flyme_data;

import android.annotation.SuppressLint;
import com.xcglobe.xclog.App;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.util.HashMap;

@SuppressLint({"UseSparseArrays"})
/* renamed from: m.b */
/* loaded from: classes.dex */
public class C0234b {

    /* renamed from: a */
    public static boolean f1327a = true;

    /* renamed from: b */
    static HashMap<Integer, Integer> f1328b = new HashMap<>();

    /* renamed from: c */
    private static int f1329c;

    /* renamed from: d */
    private static int f1330d;

    /* renamed from: a */
    public static int m1036a(float f2, float f3) {
        if (!f1327a) {
            return 0;
        }
        float f4 = 360.0f - ((f2 + 90.0f) * 2.0f);
        if (f3 < 0.0f) {
            f3 += 360.0f;
        }
        int i2 = (((int) f4) * 720) + ((int) (f3 * 2.0f));
        if (i2 == f1329c) {
            return f1330d;
        }
        Integer num = f1328b.get(Integer.valueOf(i2));
        if (num == null) {
            num = Integer.valueOf(m1037a(i2));
            f1328b.put(Integer.valueOf(i2), num);
        }
        f1329c = i2;
        int intValue = num.intValue();
        f1330d = intValue;
        return intValue;
    }

    /* renamed from: a */
    private static int m1037a(int i2) {
        try {
            BufferedInputStream bufferedInputStream = new BufferedInputStream(App.m443b().getAssets().open("egm96.dat"));
            DataInputStream dataInputStream = new DataInputStream(bufferedInputStream);
            if (i2 > 0) {
                dataInputStream.skipBytes(i2);
            }
            byte readByte = dataInputStream.readByte();
            bufferedInputStream.close();
            return readByte;
        } catch (Exception unused) {
            return 0;
        }
    }
}
