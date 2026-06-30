package com.xcglobe.xclog;

import android.content.SharedPreferences;
import java.util.regex.Pattern;

/* renamed from: com.xcglobe.xclog.j */
/* loaded from: classes.dex */
public class C0099j {

    /* renamed from: a */
    public static SharedPreferences f512a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static float m514a(SharedPreferences sharedPreferences, String str, String str2) {
        String string = sharedPreferences.getString(str, str2);
        if (string == null || string.length() == 0) {
            string = str2;
        }
        return Integer.parseInt(string);
    }

    /* renamed from: a */
    public static String m515a(String str) {
        return f512a.getString(str, "");
    }

    /* renamed from: a */
    public static String m516a(String str, String str2) {
        return f512a.getString(str, str2);
    }

    /* renamed from: a */
    public static void m517a(String str, int i2) {
        f512a.edit().putString(str, String.valueOf(i2)).commit();
    }

    /* renamed from: a */
    public static void m518a(String str, String str2, String str3) {
        if (str2 == null || str2.length() <= 0) {
            return;
        }
        App.m443b().getSharedPreferences(str, 0).edit().putString(str2, str3).commit();
    }

    /* renamed from: a */
    public static boolean m519a(String str, boolean z) {
        return f512a.getBoolean(str, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static float m520b(SharedPreferences sharedPreferences, String str, String str2) {
        String string = sharedPreferences.getString(str, str2);
        if (string == null || string.length() == 0) {
            string = str2;
        }
        return C0101l.m573i(string);
    }

    /* renamed from: b */
    public static int m521b(String str) {
        String string = f512a.getString(str, "");
        try {
            if (string.length() == 0) {
                return 0;
            }
            return Integer.parseInt(string);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: b */
    public static void m522b(String str, String str2) {
        String[] m525c = m525c(str);
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < m525c.length; i2++) {
            if (!m525c[i2].equals(str2)) {
                if (sb.length() != 0) {
                    sb.append("|~|");
                }
                sb.append(m525c[i2]);
            }
        }
        m527d(str, sb.toString());
    }

    /* renamed from: b */
    public static void m523b(String str, String str2, String str3) {
        m518a("tracks", str + "." + str2, str3);
    }

    /* renamed from: c */
    public static void m524c(String str, String str2) {
        String string = f512a.getString(str, "");
        if (("|~|" + string + "|~|").indexOf("|~|" + str2 + "|~|") != -1) {
            return;
        }
        if (string.length() > 0) {
            string = string + "|~|";
        }
        m527d(str, string + str2);
    }

    /* renamed from: c */
    public static String[] m525c(String str) {
        return f512a.getString(str, "").split(Pattern.quote("|~|"));
    }

    /* renamed from: d */
    public static long m526d(String str) {
        String string = f512a.getString(str, "");
        if (string.length() == 0) {
            return 0L;
        }
        return Long.parseLong(string);
    }

    /* renamed from: d */
    public static void m527d(String str, String str2) {
        f512a.edit().putString(str, str2).commit();
    }

    /* renamed from: e */
    public static String m528e(String str, String str2) {
        return (str2 == null || str2.length() == 0) ? "" : App.m443b().getSharedPreferences(str, 0).getString(str2, "");
    }

    /* renamed from: f */
    public static String m529f(String str, String str2) {
        return m528e("tracks", str + "." + str2);
    }

    /* renamed from: g */
    public static int m530g(String str, String str2) {
        String m529f = m529f(str, str2);
        if (m529f.length() == 0) {
            return 0;
        }
        return Integer.parseInt(m529f);
    }
}
