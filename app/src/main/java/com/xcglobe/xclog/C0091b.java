package com.xcglobe.xclog;

import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* renamed from: com.xcglobe.xclog.b */
/* loaded from: classes.dex */
public class C0091b {

    /* renamed from: a */
    private static String f479a;

    /* renamed from: a */
    public static void m460a() {
        Environment.getExternalStorageState();
        f479a = App.m443b().getDir("xcglobe", 0).getAbsolutePath();
        File file = new File(f479a);
        if (file.isDirectory()) {
            return;
        }
        file.mkdirs();
    }

    /* renamed from: a */
    public static boolean m461a(String str, String str2, boolean z) {
        File file = new File(new File(C0101l.m537a(str2)).getAbsolutePath() + "/" + str);
        if (z && file.isFile()) {
            return false;
        }
        try {
            InputStream open = App.m443b().getAssets().open(str);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[4024];
            while (true) {
                int read = open.read(bArr);
                if (read <= 0) {
                    fileOutputStream.close();
                    return true;
                }
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (IOException unused) {
            return false;
        }
    }
}
