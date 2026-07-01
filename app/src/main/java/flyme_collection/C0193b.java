package flyme_collection;

import java.io.BufferedReader;
import java.io.FileReader;

/* renamed from: e.b */
/* loaded from: classes.dex */
public class C0193b {
    private static Throwable th;

    /* renamed from: a */
    public static String f952a;

    /* renamed from: a */
    static String m825a(String str) {
        if (f952a == null) {
            return str;
        }
        return f952a + str;
    }

    /* renamed from: b */
    public static String m826b(String str) {
        BufferedReader bufferedReader;
        FileReader fileReader;
        String m825a = m825a(str);
        StringBuilder sb = new StringBuilder();
        String property = System.getProperty("line.separator");
        try {
            try {
                fileReader = new FileReader(m825a);
                try {
                    bufferedReader = new BufferedReader(fileReader);
                    while (true) {
                        try {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                String sb2 = sb.toString();
                                fileReader.close();
                                bufferedReader.close();
                                return sb2;
                            }
                            if (sb.length() > 0) {
                                sb.append(property);
                            }
                            sb.append(readLine);
                        } catch (Throwable th) {
                            th = th;
                            if (fileReader != null) {
                                fileReader.close();
                            }
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = null;
                }
            } catch (Exception unused) {
                return "";
            }
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            fileReader = null;
        }
        return "";
    }
}
