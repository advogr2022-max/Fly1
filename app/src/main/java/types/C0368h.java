package types;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/* renamed from: types.h */
/* loaded from: classes.dex */
public class C0368h {

    /* renamed from: a */
    private static DecimalFormat f2017a = new DecimalFormat("00.00");

    /* renamed from: b */
    private static DecimalFormat f2018b = new DecimalFormat(".00000000");

    /* renamed from: c */
    private static NumberFormat f2019c = NumberFormat.getInstance(Locale.ENGLISH);

    /* renamed from: a */
    public static float m1239a(String str) {
        char charAt = str.charAt(0);
        boolean z = charAt == 'N' || charAt == 'S';
        int i2 = z ? 3 : 4;
        if (!z && str.charAt(4) == ' ') {
            i2 = 3;
        }
        String replace = str.replace(" ", "");
        float m1289a = C0378r.m1289a(replace, 1, i2);
        int i3 = i2 + 2;
        float m1289a2 = C0378r.m1289a(replace, i2, i3);
        String substring = replace.substring(i3);
        if (substring.length() > 3) {
            substring = substring.substring(0, 3);
        }
        float m1294e = C0378r.m1294e(substring);
        if (substring.length() == 3) {
            double d2 = m1294e;
            Double.isNaN(d2);
            m1294e = (float) (d2 / 10.0d);
        }
        float f2 = m1289a + (m1289a2 / 60.0f) + (m1294e / 3600.0f);
        return (charAt == 'S' || charAt == 'W') ? -f2 : f2;
    }

    /* renamed from: a */
    public static String m1240a(double d2, boolean z) {
        StringBuilder sb;
        String str;
        StringBuilder sb2;
        int i2;
        boolean z2 = d2 < 0.0d;
        double abs = Math.abs(d2);
        int i3 = (int) abs;
        String str2 = i3 < 10 ? "0" : "";
        if (!z && i3 < 100) {
            str2 = str2 + "0";
        }
        String str3 = str2 + i3;
        double d3 = i3;
        Double.isNaN(d3);
        double d4 = (abs - d3) * 60.0d;
        int i4 = (int) d4;
        if (i4 < 10) {
            str3 = str3 + "0";
        }
        String str4 = str3 + i4;
        double d5 = i4;
        Double.isNaN(d5);
        int i5 = (int) ((d4 - d5) * 1000.0d);
        if (i5 < 100) {
            str4 = str4 + "0";
        }
        if (i5 < 10) {
            str4 = str4 + "0";
        }
        String str5 = str4 + i5;
        if (z) {
            if (str5.length() > 7) {
                str5 = str5.substring(0, 7);
            }
            if (z2) {
                sb = new StringBuilder();
                sb.append(str5);
                str = "S";
            } else {
                sb = new StringBuilder();
                sb.append(str5);
                str = "N";
            }
        } else {
            if (str5.length() > 8) {
                str5 = str5.substring(0, 8);
            }
            if (z2) {
                sb = new StringBuilder();
                sb.append(str5);
                str = "W";
            } else {
                sb = new StringBuilder();
                sb.append(str5);
                str = "E";
            }
        }
        sb.append(str);
        String sb3 = sb.toString();
        if (z) {
            sb2 = new StringBuilder();
            i2 = 4;
        } else {
            sb2 = new StringBuilder();
            i2 = 5;
        }
        sb2.append(sb3.substring(0, i2));
        sb2.append(".");
        sb2.append(sb3.substring(i2));
        return sb2.toString();
    }

    /* renamed from: b */
    public static float m1241b(String str) {
        int length = str.length() - 1;
        char charAt = str.charAt(length);
        float m1242c = m1242c(str.substring(0, length));
        return (charAt == 'S' || charAt == 'W') ? -m1242c : m1242c;
    }

    /* renamed from: c */
    public static float m1242c(String str) {
        try {
            return f2019c.parse(str).floatValue();
        } catch (ParseException unused) {
            return 0.0f;
        }
    }
}
