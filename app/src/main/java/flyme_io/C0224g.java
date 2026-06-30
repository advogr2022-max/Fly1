package flyme_io;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

/* renamed from: i.g */
/* loaded from: classes.dex */
public class C0224g {

    /* renamed from: a */
    C0217b f1254a;

    /* renamed from: b */
    int f1255b = 3;

    /* renamed from: a */
    public String m971a(C0217b c0217b, String str) {
        this.f1254a = c0217b;
        return m975a(str, m972a(), m973a(0), m973a(c0217b.f1192c.length - 1)).toString();
    }

    /* renamed from: a */
    StringBuilder m972a() {
        int length = this.f1254a.f1192c.length;
        DecimalFormat decimalFormat = new DecimalFormat("#.00000", new DecimalFormatSymbols(Locale.US));
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.f1254a.f1194e[i3] - i2 >= 4) {
                i2 = this.f1254a.f1194e[i3];
                sb.append(decimalFormat.format(this.f1254a.f1193d[i3]));
                sb.append(",");
                sb.append(decimalFormat.format(this.f1254a.f1192c[i3]));
                sb.append(",");
                sb.append((int) this.f1254a.f1195f[i3]);
                sb.append(" ");
            }
        }
        return sb;
    }

    /* renamed from: a */
    StringBuilder m973a(int i2) {
        DecimalFormat decimalFormat = new DecimalFormat("#.00000", new DecimalFormatSymbols(Locale.US));
        StringBuilder sb = new StringBuilder();
        sb.append(decimalFormat.format(this.f1254a.f1193d[i2]));
        sb.append(",");
        sb.append(decimalFormat.format(this.f1254a.f1192c[i2]));
        sb.append(",");
        sb.append((int) this.f1254a.f1195f[i2]);
        return sb;
    }

    /* renamed from: a */
    StringBuilder m974a(String str, StringBuilder sb) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<Placemark><name>" + str + "</name><Style><IconStyle><scale>0.6</scale>\n");
        sb2.append("<Icon><href>http://www.pgweb.cz/img/maps/cil.png</href></Icon></IconStyle></Style>\n");
        sb2.append("<Point><altitudeMode>absolute</altitudeMode>");
        sb2.append("<coordinates>" + ((Object) sb) + "</coordinates></Point></Placemark>\n");
        return sb2;
    }

    /* renamed from: a */
    StringBuilder m975a(String str, StringBuilder sb, StringBuilder sb2, StringBuilder sb3) {
        StringBuilder sb4 = new StringBuilder();
        sb4.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        sb4.append("<kml xmlns=\"http://earth.google.com/kml/2.0\">\n");
        sb4.append("<Folder><name>XC flight by XCGlobe</name>\n");
        sb4.append("<description>" + str + "</description>\n");
        sb4.append("<Placemark><name>GPS track</name><description></description>");
        sb4.append("<visibility>1</visibility><open>0</open>\n");
        sb4.append("<Style><LineStyle><color>ff00a5ff</color><width>" + this.f1255b + "</width></LineStyle>\n");
        sb4.append("<PolyStyle><color>00ff8080</color><colorMode>normal</colorMode><fill>1</fill><outline>0</outline></PolyStyle></Style>\n");
        sb4.append("<LineString><altitudeMode>absolute</altitudeMode><extrude>1</extrude><tessellate>1</tessellate>\n");
        sb4.append("<coordinates>");
        sb4.append((CharSequence) sb);
        sb4.append("</coordinates></LineString></Placemark>\n");
        sb4.append((CharSequence) m974a("Landing", sb3));
        sb4.append((CharSequence) m974a("Start", sb2));
        sb4.append("</Folder></kml>");
        return sb4;
    }
}
