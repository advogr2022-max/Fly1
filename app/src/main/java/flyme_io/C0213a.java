package flyme_io;

import java.util.Locale;

/* renamed from: i.a */
/* loaded from: classes.dex */
public class C0213a {

    /* renamed from: a */
    public String f1138a;

    /* renamed from: b */
    public String f1139b;

    /* renamed from: c */
    public String f1140c;

    /* renamed from: d */
    public String f1141d;

    /* renamed from: e */
    public int f1142e;

    /* renamed from: f */
    public boolean f1143f;

    /* renamed from: g */
    public int f1144g;

    /* renamed from: h */
    public long f1145h;

    /* renamed from: a */
    public boolean m900a(String str) {
        if (str.startsWith("B")) {
            return false;
        }
        String upperCase = str.toUpperCase(Locale.US);
        if (str.startsWith("HOKMLURL: ")) {
            this.f1141d = str.substring(10);
        } else if (str.startsWith("HOKMLTIME: local")) {
            this.f1143f = true;
        } else {
            int indexOf = str.indexOf("PILOT:");
            if (indexOf != -1) {
                this.f1138a = str.substring(indexOf + 6).replace('\t', ' ').trim();
            } else {
                int indexOf2 = str.indexOf("GLIDERTYPE:");
                if (indexOf2 != -1) {
                    this.f1140c = str.substring(indexOf2 + 11).replace('\t', ' ').trim();
                } else {
                    try {
                        if (upperCase.indexOf("UTCOFFSET") != -1) {
                            String[] split = str.split(":");
                            if (split.length == 2) {
                                this.f1142e = Integer.parseInt(split[1].trim());
                            }
                        } else if (upperCase.indexOf("TIMEZONE") != -1) {
                            String[] split2 = str.split(":");
                            if (split2.length == 2) {
                                this.f1144g = Integer.parseInt(split2[1].trim());
                            }
                        } else {
                            int indexOf3 = str.indexOf("Site:");
                            if (indexOf3 != -1) {
                                this.f1139b = str.substring(indexOf3 + 5).replace('\t', ' ').trim();
                            }
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
        return true;
    }
}
