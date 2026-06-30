package flyme_writer;

import android.annotation.SuppressLint;
import com.xcglobe.xclog.C0101l;
import java.io.BufferedReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import types.C0368h;
import types.C0374n;
import types.C0378r;
import types.PoiPoint;

/* renamed from: l.a */
/* loaded from: classes.dex */
public class C0231a {

    /* renamed from: a */
    private List<PoiPoint> f1319a = new ArrayList();

    /* renamed from: b */
    private int f1320b;

    @SuppressLint({"DefaultLocale"})
    /* renamed from: a */
    public static int m1019a(String str, String str2) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.endsWith(".cup")) {
            return 1;
        }
        if (lowerCase.endsWith(".json")) {
            return 6;
        }
        if (lowerCase.endsWith(".gpx")) {
            return 2;
        }
        if (lowerCase.endsWith(".lkt")) {
            return 7;
        }
        if (str2.startsWith("OziExplorer")) {
            return 5;
        }
        if (lowerCase.endsWith(".wpt")) {
            if (str2.startsWith("G ") && str2.substring(0, 100).indexOf("WGS") != -1) {
                return 4;
            }
            if (str2.startsWith("$FormatGEO")) {
                return 3;
            }
        }
        throw new RuntimeException("Unknown waypoints file format");
    }

    /* renamed from: b */
    private void m1020b(String str) {
        BufferedReader bufferedReader = new BufferedReader(new StringReader(str));
        for (int i2 = 0; i2 < 4; i2++) {
            try {
                if (bufferedReader.readLine() == null) {
                    return;
                }
            } finally {
                bufferedReader.close();
            }
        }
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return;
            }
            String[] split = readLine.split(",");
            if (split.length >= 8) {
                PoiPoint poiPoint = new PoiPoint();
                poiPoint.f1979l = split[1];
                poiPoint.f1976i = C0101l.m573i(split[2]);
                poiPoint.f1977j = C0101l.m573i(split[3]);
                if (split.length > 14) {
                    poiPoint.f1978k = (short) C0378r.m1294e(split[14]);
                }
                this.f1319a.add(poiPoint);
            }
        }
    }

    /* renamed from: c */
    private void m1021c(String str) {
        BufferedReader bufferedReader = new BufferedReader(new StringReader(str));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return;
                }
                if (readLine.startsWith("W")) {
                    String[] split = readLine.split(" ");
                    if (split.length >= 8) {
                        PoiPoint poiPoint = new PoiPoint();
                        poiPoint.f1979l = split[1];
                        poiPoint.f1976i = C0368h.m1241b(split[3]);
                        poiPoint.f1977j = C0368h.m1241b(split[4]);
                        poiPoint.f1978k = (short) C0378r.m1294e(split[7]);
                        this.f1319a.add(poiPoint);
                    }
                }
            } finally {
                bufferedReader.close();
            }
        }
    }

    /* renamed from: d */
    private void m1022d(String str) {
        BufferedReader bufferedReader = new BufferedReader(new StringReader(str));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return;
                }
                if (!readLine.startsWith("$")) {
                    String replaceAll = readLine.trim().replaceAll(" +", " ");
                    int indexOf = replaceAll.indexOf(32) + 1;
                    if (indexOf != 0) {
                        PoiPoint poiPoint = new PoiPoint();
                        int i2 = 0;
                        poiPoint.f1979l = replaceAll.substring(0, indexOf);
                        int i3 = indexOf;
                        while (true) {
                            if (indexOf >= replaceAll.length()) {
                                break;
                            }
                            if (replaceAll.charAt(indexOf) == ' ') {
                                i2++;
                                if (i2 == 4) {
                                    poiPoint.f1976i = C0368h.m1239a(replaceAll.substring(i3, indexOf));
                                    i3 = indexOf + 1;
                                } else if (i2 == 8) {
                                    poiPoint.f1977j = C0368h.m1239a(replaceAll.substring(i3, indexOf));
                                    int i4 = indexOf + 1;
                                    int indexOf2 = replaceAll.indexOf(32, i4);
                                    poiPoint.f1978k = (short) (indexOf2 == -1 ? C0378r.m1289a(replaceAll, i4, replaceAll.length()) : C0378r.m1289a(replaceAll, i4, indexOf2));
                                    this.f1319a.add(poiPoint);
                                }
                            }
                            indexOf++;
                        }
                    }
                }
            } finally {
                bufferedReader.close();
            }
        }
    }

    /* renamed from: e */
    private void m1023e(String str) {
        C0378r c0378r = new C0378r(str, true);
        while (true) {
            String m1299b = c0378r.m1299b("wpt");
            if (m1299b == null) {
                return;
            }
            PoiPoint poiPoint = new PoiPoint();
            poiPoint.f1976i = C0101l.m573i(C0378r.m1291a(m1299b, 0, "lat", ">"));
            poiPoint.f1977j = C0101l.m573i(C0378r.m1291a(m1299b, 0, "lon", ">"));
            C0378r c0378r2 = new C0378r(m1299b, true);
            poiPoint.f1978k = (short) C0378r.m1294e(c0378r2.m1301c("ele"));
            c0378r2.m1298a(0);
            poiPoint.f1979l = c0378r2.m1301c("name");
            this.f1319a.add(poiPoint);
        }
    }

    /* renamed from: f */
    private void m1024f(String str) {
        C0374n c0374n = new C0374n();
        BufferedReader bufferedReader = new BufferedReader(new StringReader(str));
        try {
            if (bufferedReader.readLine() == null) {
                return;
            }
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null || readLine.startsWith("-----Related Tasks-----")) {
                    break;
                }
                if (c0374n.m1267a(readLine, 'w')) {
                    PoiPoint poiPoint = new PoiPoint();
                    poiPoint.m1170a(c0374n.f2060d, c0374n.f2061e, (short) c0374n.f2062f, c0374n.f2064h, c0374n.f2065i);
                    this.f1319a.add(poiPoint);
                }
            }
        } finally {
            bufferedReader.close();
        }
    }

    /* renamed from: a */
    public List<PoiPoint> m1025a(String str) {
        String m567f = C0101l.m567f(str);
        this.f1320b = m1019a(str, m567f);
        return m1026a(m567f, this.f1320b);
    }

    /* renamed from: a */
    public List<PoiPoint> m1026a(String str, int i2) {
        switch (i2) {
            case 1:
                m1024f(str);
                break;
            case 2:
                m1023e(str);
                break;
            case 3:
                m1022d(str);
                break;
            case 4:
                m1021c(str);
                break;
            case 5:
                m1020b(str);
                break;
            default:
                throw new RuntimeException("Unsupported waypoints format: " + i2);
        }
        return this.f1319a;
    }
}
