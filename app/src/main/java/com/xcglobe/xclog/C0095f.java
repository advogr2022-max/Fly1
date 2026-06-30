package com.xcglobe.xclog;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import com.xcglobe.flyme.R;
import java.io.File;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.UUID;
import java.util.zip.CRC32;

/* renamed from: com.xcglobe.xclog.f */
/* loaded from: classes.dex */
public class C0095f {

    /* renamed from: a */
    private static String f491a;

    /* renamed from: b */
    private static String f492b;

    /* renamed from: a */
    public static String m463a() {
        return Build.MANUFACTURER + "|" + Build.MODEL + "|" + Build.VERSION.RELEASE;
    }

    /* renamed from: a */
    private static String m464a(File file) {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
        byte[] bArr = new byte[(int) randomAccessFile.length()];
        randomAccessFile.readFully(bArr);
        randomAccessFile.close();
        return new String(bArr);
    }

    /* renamed from: a */
    public static String m465a(String str, boolean z) {
        String str2;
        if (str == null || str.equals("xcglobe")) {
            str = "";
        } else if (str.startsWith("leo_")) {
            str = str + C0099j.m515a("user.leo_server_id");
        }
        String str3 = ((("fmid=" + URLEncoder.encode(m469b())) + "&frt=" + m475d()) + "&ver=" + URLEncoder.encode(m480i())) + "&ser=" + URLEncoder.encode(m478g());
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append(str3);
            sb.append("&username=");
            sb.append(URLEncoder.encode(C0099j.m515a("user.username" + str)));
            String sb2 = sb.toString();
            StringBuilder sb3 = new StringBuilder();
            sb3.append(sb2);
            sb3.append("&password=");
            sb3.append(URLEncoder.encode(C0099j.m515a("user.password" + str)));
            str2 = sb3.toString();
        } else {
            String str4 = C0099j.m515a("user.username" + str) + "|" + C0099j.m515a("user.password" + str);
            CRC32 crc32 = new CRC32();
            crc32.update(str4.getBytes(), 0, str4.length());
            str2 = str3 + "&pers=" + crc32.getValue();
        }
        return str2 + "&rid=" + C0099j.m515a("install_rid");
    }

    /* renamed from: a */
    public static String m466a(boolean z) {
        StringBuilder sb;
        int i2;
        if (!z) {
            return "FlyMe " + m480i();
        }
        String str = (("FlyMe " + m481j()) + m482k()) + " (";
        if (m479h()) {
            sb = new StringBuilder();
            sb.append(str);
            i2 = R.string.licence_full;
        } else {
            sb = new StringBuilder();
            sb.append(str);
            i2 = R.string.licence_trial;
        }
        sb.append(App.m435a(i2));
        return sb.toString() + ")";
    }

    /* renamed from: a */
    public static void m467a(long j2) {
        C0099j.m527d("install_first_run_time", "" + j2);
    }

    /* renamed from: a */
    public static void m468a(String str) {
        C0099j.m527d("install_serial", str);
    }

    /* renamed from: b */
    public static String m469b() {
        if (f492b != null) {
            return f492b;
        }
        f492b = C0099j.m515a("fmid");
        if (f492b == null || f492b.length() == 0) {
            f492b = m492u();
            C0099j.m527d("fmid", f492b);
        }
        return f492b;
    }

    /* renamed from: b */
    private static void m470b(File file) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(UUID.randomUUID().toString().getBytes());
        fileOutputStream.close();
    }

    /* renamed from: b */
    public static boolean m471b(String str) {
        return str.length() > 0 && str.equals(m473c(m469b()));
    }

    /* renamed from: c */
    private static long m472c(File file) {
        File[] listFiles = file.listFiles();
        long j2 = 0;
        for (int i2 = 0; i2 < listFiles.length; i2++) {
            long m472c = listFiles[i2].isDirectory() ? m472c(listFiles[i2]) : listFiles[i2].lastModified();
            if (j2 == 0 || m472c < j2) {
                j2 = m472c;
            }
        }
        return j2;
    }

    /* renamed from: c */
    private static String m473c(String str) {
        int[] iArr = new int[9];
        String str2 = str + "xcglobe.com";
        CRC32 crc32 = new CRC32();
        crc32.update(str2.getBytes(), 0, str2.length());
        String str3 = "" + crc32.getValue();
        int i2 = 0;
        for (int i3 = 0; i3 < str3.length(); i3++) {
            iArr[i2] = iArr[i2] + str3.charAt(i3);
            i2++;
            if (i2 >= 9) {
                i2 = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < 9; i4++) {
            char c2 = (char) ((iArr[i4] % 25) + 65);
            if (i4 == 3 || i4 == 6) {
                sb.append("-");
            }
            sb.append(c2);
        }
        return sb.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x002a  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m474c() {
        long j2;
        File file;
        if (C0099j.m515a("install_first_run_time").length() < 3) {
            try {
                file = new File(C0101l.m537a(""));
            } catch (Exception unused) {
            }
            if (file.isDirectory()) {
                j2 = m472c(file);
                if (j2 == 0) {
                    j2 = System.currentTimeMillis();
                }
                C0099j.m527d("install_first_run_time", "" + (j2 / 1000));
                C0099j.m527d("install_rid", "" + new Random().nextInt(1000));
            }
            j2 = 0;
            if (j2 == 0) {
            }
            C0099j.m527d("install_first_run_time", "" + (j2 / 1000));
            C0099j.m527d("install_rid", "" + new Random().nextInt(1000));
        }
    }

    /* renamed from: d */
    public static String m475d() {
        return C0099j.m515a("install_first_run_time");
    }

    /* renamed from: e */
    public static int m476e() {
        return 30 - m494w();
    }

    /* renamed from: f */
    public static boolean m477f() {
        return m483l() && !m479h() && m476e() < 0;
    }

    /* renamed from: g */
    public static String m478g() {
        return C0099j.m515a("install_serial");
    }

    /* renamed from: h */
    public static boolean m479h() {
        return m471b(m478g());
    }

    /* renamed from: i */
    public static String m480i() {
        try {
            return App.m443b().getPackageManager().getPackageInfo(App.m443b().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "???";
        }
    }

    /* renamed from: j */
    public static String m481j() {
        try {
            PackageInfo packageInfo = App.m443b().getPackageManager().getPackageInfo(App.m443b().getPackageName(), 0);
            return packageInfo.versionName + "/" + packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return "???/???";
        }
    }

    /* renamed from: k */
    public static String m482k() {
        if (C0101l.f542a == null) {
            return "";
        }
        return "-" + C0101l.f542a;
    }

    /* renamed from: l */
    public static boolean m483l() {
        return C0099j.m521b("install_licence_ready") == 1;
    }

    /* renamed from: m */
    public static String m484m() {
        return C0099j.m515a("install_latest_version");
    }

    /* renamed from: n */
    public static boolean m485n() {
        String m480i = m480i();
        String m515a = C0099j.m515a("install_latest_version");
        return m515a.length() == 0 || m480i.equals(m515a);
    }

    /* renamed from: o */
    public static String m486o() {
        return "http://xcglobe.com/";
    }

    /* renamed from: p */
    public static boolean m487p() {
        String[] list = new File(C0101l.m537a("vmp")).list();
        if (list == null) {
            return false;
        }
        for (String str : list) {
            if (str.endsWith(".vmp")) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: q */
    public static boolean m488q() {
        String m489r = m489r();
        if (m489r == null || m489r.isEmpty()) {
            return false;
        }
        return new ArrayList(Arrays.asList("com.android.vending", "com.google.android.feedback")).contains(m489r);
    }

    /* renamed from: r */
    public static String m489r() {
        try {
            App m443b = App.m443b();
            return m443b.getPackageManager().getInstallerPackageName(m443b.getPackageName());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: s */
    private static synchronized String m490s() {
        String str;
        synchronized (C0095f.class) {
            if (f491a == null) {
                File file = new File(App.m443b().getFilesDir(), "install.xcg");
                try {
                    if (!file.exists()) {
                        m470b(file);
                    }
                    f491a = m464a(file);
                } catch (Exception e2) {
                    throw new RuntimeException(e2);
                }
            }
            str = f491a;
        }
        return str;
    }

    /* renamed from: t */
    private static String m491t() {
        return Settings.Secure.getString(App.m443b().getContentResolver(), "android_id");
    }

    /* renamed from: u */
    private static String m492u() {
        String str = m493v() + m491t();
        if (str == null || str.length() < 8) {
            str = m490s();
        }
        CRC32 crc32 = new CRC32();
        crc32.update(str.getBytes(), 0, str.length());
        String str2 = "" + crc32.getValue();
        int[] iArr = new int[8];
        int i2 = 0;
        for (int i3 = 0; i3 < str2.length(); i3++) {
            iArr[i2] = iArr[i2] + str2.charAt(i3);
            i2++;
            if (i2 >= 8) {
                i2 = 0;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < 8; i4++) {
            sb.append((char) ((iArr[i4] % 10) + 48));
            if (i4 == 3) {
                sb.append('-');
            }
        }
        return sb.toString();
    }

    /* renamed from: v */
    private static String m493v() {
        return Build.BOARD + Build.BRAND + Build.CPU_ABI + Build.DEVICE + Build.DISPLAY + Build.ID + Build.MANUFACTURER + Build.MODEL + Build.PRODUCT + Build.TAGS + Build.TYPE + Build.USER;
    }

    /* renamed from: w */
    private static int m494w() {
        long m526d = C0099j.m526d("install_licence_release_time");
        long m526d2 = C0099j.m526d("install_first_run_time");
        if (m526d2 > m526d) {
            m526d = m526d2;
        }
        return (int) (((System.currentTimeMillis() / 1000) - m526d) / 86400);
    }
}
