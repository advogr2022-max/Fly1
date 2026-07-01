package flyme_poi;

import com.xcglobe.xclog.C0101l;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import types.C0374n;

/* renamed from: k.d */
/* loaded from: classes.dex */
public class C0230d {
    private static int r8 = 0;
    private static Throwable e;
    /* JADX WARN: Removed duplicated region for block: B:105:0x01c3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static C0227a m1017a(String str) {
        BufferedReader bufferedReader;
        ArrayList arrayList = new ArrayList();
        C0227a c0227a = new C0227a();
        c0227a.f1278b = str;
        String str2 = C0101l.m537a("tasks") + "/" + str + ".cup";
        if (!new File(str2).isFile()) {
            return null;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(str2));
        } catch (FileNotFoundException e4) {
            e = e4;
            bufferedReader = null;
            return c0227a;
        } catch (IOException e5) {
            e = e5;
            bufferedReader = null;
            return c0227a;
        }
        if (bufferedReader == null) return c0227a;
        try {
        if (bufferedReader.readLine() == null) {
            return null;
        }
        C0374n c0374n = new C0374n();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || readLine.startsWith("---")) {
                break;
            }
            if (c0374n.m1267a(readLine, 'w')) {
                C0229c c0229c = new C0229c();
                c0229c.f1979l = c0374n.f2064h;
                c0229c.f1978k = (short) c0374n.f2062f;
                c0229c.f1976i = c0374n.f2060d;
                c0229c.f1977j = c0374n.f2061e;
                c0229c.f1311a = (c0374n.f2063g * 10) / 10000.0f;
                arrayList.add(c0229c);
            }
        }
        c0227a.f1278b = str;
        if (arrayList.size() < 2) {
            return null;
        }
        while (true) {
            String readLine2 = bufferedReader.readLine();
            if (readLine2 == null) {
                break;
            }
            if (readLine2.length() >= 3) {
                String[] split = readLine2.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)");
                for (int i2 = 2; i2 < split.length - 1; i2++) {
                    C0229c m1018a = m1018a(arrayList, split[i2].replace("\"", ""));
                    if (m1018a != null) {
                        c0227a.f1279c.add(m1018a);
                    }
                }
            }
        }
        if (c0227a.f1279c.size() <= 1) {
            return null;
        }
        boolean z = false;
        while (true) {
            String readLine3 = bufferedReader.readLine();
            if (readLine3 == null) {
                break;
            }
            if (readLine3.startsWith("ObsZone=")) {
                int m532a = C0101l.m532a(readLine3, 8, readLine3.length());
                if (m532a < c0227a.f1279c.size()) {
                    C0229c c0229c2 = c0227a.f1279c.get(m532a);
                    if (readLine3.indexOf("R1=") != -1) {
                        c0229c2.f1311a = ((C0101l.m532a(readLine3, r8 + 3, readLine3.length()) * 10) + 1) / 10000.0f;
                    }
                    if (readLine3.indexOf("sss=True") != -1) {
                        c0229c2.f1316f = true;
                        z = true;
                    } else if (readLine3.indexOf("ess=True") != -1) {
                        c0229c2.f1317g = true;
                    }
                }
            } else if (readLine3.startsWith("Options")) {
                c0227a.f1289m = readLine3.indexOf("GoalIsLine=True") != -1;
                if (readLine3.indexOf("StartOnEntry=True") != -1) {
                    c0227a.f1280d = true;
                }
                if (readLine3.indexOf("Competition=True") != -1) {
                    c0227a.f1290n = true;
                }
                int indexOf = readLine3.indexOf("NoStart=");
                if (indexOf != -1) {
                    c0227a.f1281e.setToNow();
                    c0227a.f1281e.hour = C0101l.m532a(readLine3, indexOf + 8, indexOf + 10);
                    c0227a.f1281e.minute = C0101l.m532a(readLine3, indexOf + 11, indexOf + 13);
                }
                int indexOf2 = readLine3.indexOf("NoEnd=");
                if (indexOf2 != -1) {
                    c0227a.f1282f.setToNow();
                    c0227a.f1282f.hour = C0101l.m532a(readLine3, indexOf2 + 6, indexOf2 + 8);
                    c0227a.f1282f.minute = C0101l.m532a(readLine3, indexOf2 + 9, indexOf2 + 11);
                }
            }
        }
        if (c0227a.f1290n && !z) {
            c0227a.f1279c.get(0).f1316f = true;
        }
        c0227a.m1004c();
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException unused) {
            }
        }
        return c0227a;
    } catch (IOException e6) {
        e = e6;
        e.printStackTrace();
        return c0227a;
    }
    }

    /* renamed from: a */
    static C0229c m1018a(ArrayList<C0229c> arrayList, String str) {
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            C0229c c0229c = arrayList.get(i2);
            if (c0229c.f1979l.equals(str)) {
                C0229c c0229c2 = new C0229c();
                c0229c2.m1015a(c0229c);
                return c0229c2;
            }
        }
        return null;
    }
}
