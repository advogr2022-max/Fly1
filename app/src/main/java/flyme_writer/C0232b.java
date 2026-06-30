package flyme_writer;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import types.C0368h;
import types.PoiPoint;

/* renamed from: l.b */
/* loaded from: classes.dex */
public class C0232b {
    private static Throwable th;

    /* renamed from: a */
    private static String f1321a = "\r\n";

    /* renamed from: a */
    public static void m1027a(List<PoiPoint> list, String str) {
        BufferedWriter bufferedWriter;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(str, false));
            try {
                bufferedWriter.write("name,code,country,lat,lon,elev,style,rwdir,rwlen,freq,desc" + f1321a);
                for (int i2 = 0; i2 < list.size(); i2++) {
                    PoiPoint poiPoint = list.get(i2);
                    String str2 = poiPoint.f1979l;
                    bufferedWriter.write("\"" + str2 + "\",");
                    StringBuilder sb = new StringBuilder();
                    sb.append(str2.replaceAll("\\W", ""));
                    sb.append(",,");
                    bufferedWriter.write(sb.toString());
                    bufferedWriter.write(C0368h.m1240a(poiPoint.f1976i, true) + ",");
                    bufferedWriter.write(C0368h.m1240a((double) poiPoint.f1977j, false) + ",");
                    bufferedWriter.write(((int) poiPoint.f1978k) + "m,1,,,," + f1321a);
                }
            } catch (IOException unused) {
            } catch (Throwable th) {
                th = th;
                try {
                    bufferedWriter.close();
                } catch (IOException unused2) {
                }
                throw th;
            }
        } catch (IOException unused3) {
            bufferedWriter = null;
        } catch (Throwable th2) {
            th = th2;
            bufferedWriter = null;
        }
        try {
            bufferedWriter.close();
        } catch (IOException unused4) {
        }
    }
}
