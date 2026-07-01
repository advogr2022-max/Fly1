package flyme_tasks;

import android.os.AsyncTask;
import com.xcglobe.xclog.ActivityMain;
import com.xcglobe.xclog.C0091b;
import com.xcglobe.xclog.C0097h;
import com.xcglobe.xclog.C0099j;
import com.xcglobe.xclog.C0101l;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import flyme_intentutil.C0225a;
import flyme_writer.C0231a;
import flyme_writer.C0232b;
import flyme_data.C0239g;
import types.C0361a;
import types.C0367g;
import types.C0369i;
import types.C0373m;
import types.C0374n;
import types.C0375o;
import types.GpsVal;
import types.PoiPoint;
import vmaps.C0379a;

/* renamed from: b.g */
/* loaded from: classes.dex */
public class AsyncTaskC0066g extends AsyncTask<GpsVal, Void, Integer> {
    private static Throwable th;

    /* renamed from: a */
    public static int f301a = 0;

    /* renamed from: b */
    public static boolean f302b = false;

    /* renamed from: e */
    private static long f303e;

    /* renamed from: c */
    private List<PoiPoint> f304c = new ArrayList();

    /* renamed from: d */
    private GpsVal f305d = new GpsVal();

    /* renamed from: f */
    private C0361a f306f = null;

    private AsyncTaskC0066g() {
    }

    /* renamed from: a */
    private static long m339a(float f2, float f3) {
        return (long) ((f2 * 1000.0f * 500000) + (f3 * 1000.0f));
    }

    /* renamed from: a */
    public static void m340a() {
        String m537a = C0101l.m537a("waypoints");
        String m537a2 = C0101l.m537a("poi");
        List asList = Arrays.asList(C0099j.m525c("active_wpfiles"));
        HashSet hashSet = new HashSet();
        ArrayList arrayList = new ArrayList();
        File[] listFiles = new File(m537a).listFiles();
        for (int i2 = 0; i2 < listFiles.length; i2++) {
            if (asList.contains(listFiles[i2].getName())) {
                try {
                    List<PoiPoint> m1025a = new C0231a().m1025a(listFiles[i2].getAbsolutePath());
                    for (int i3 = 0; i3 < m1025a.size(); i3++) {
                        PoiPoint poiPoint = m1025a.get(i3);
                        long m339a = m339a(poiPoint.f1976i, poiPoint.f1977j);
                        if (!hashSet.contains(Long.valueOf(m339a))) {
                            hashSet.add(Long.valueOf(m339a));
                            arrayList.add(poiPoint);
                        }
                    }
                } catch (Exception unused) {
                }
            }
        }
        C0232b.m1027a(arrayList, m537a2 + "/imported-waypoints.cup");
    }

    /* renamed from: a */
    public static void m341a(C0097h c0097h, GpsVal gpsVal, boolean z) {
        ArrayList arrayList = new ArrayList();
        m349a(gpsVal, arrayList, z);
        m347a(arrayList);
        c0097h.f498b = (PoiPoint[]) arrayList.toArray(new PoiPoint[0]);
        C0369i.m1246a(37.5f, gpsVal.f1972a, gpsVal.f1973b, c0097h.f497a);
    }

    /* renamed from: a */
    private static void m342a(BufferedReader bufferedReader, C0367g c0367g, List<PoiPoint> list) throws IOException {
        C0374n c0374n = new C0374n();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return;
            }
            try {
                if (c0374n.m1266a(readLine) && c0367g.m1231b(c0374n.f2060d, c0374n.f2061e)) {
                    PoiPoint poiPoint = new PoiPoint();
                    poiPoint.f1978k = (short) c0374n.f2062f;
                    poiPoint.f1976i = c0374n.f2060d;
                    poiPoint.f1977j = c0374n.f2061e;
                    poiPoint.f1979l = c0374n.f2064h;
                    poiPoint.f1980m = c0374n.f2065i;
                    list.add(poiPoint);
                }
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    private static void m343a(BufferedReader bufferedReader, C0367g c0367g, List<PoiPoint> list, HashSet<Long> hashSet, char c2) throws IOException {
        int length;
        int length2;
        int m532a;
        if (bufferedReader.readLine() == null) {
            return;
        }
        C0374n c0374n = new C0374n();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return;
            }
            try {
                if (c0374n.m1267a(readLine, c2) && (c0367g == null || c0367g.m1231b(c0374n.f2060d, c0374n.f2061e))) {
                    if (hashSet != null) {
                        long m339a = m339a(c0374n.f2060d, c0374n.f2061e);
                        if (!hashSet.contains(Long.valueOf(m339a))) {
                            hashSet.add(Long.valueOf(m339a));
                        }
                    }
                    PoiPoint poiPoint = new PoiPoint();
                    poiPoint.f1978k = (short) c0374n.f2062f;
                    poiPoint.f1976i = c0374n.f2060d;
                    poiPoint.f1977j = c0374n.f2061e;
                    poiPoint.f1979l = c0374n.f2064h;
                    poiPoint.f1980m = c2;
                    list.add(poiPoint);
                    if (c0374n.f2064h.startsWith(C0101l.f582g) && (length2 = c0374n.f2064h.length()) > (length = C0101l.f582g.length()) && (m532a = C0101l.m532a(c0374n.f2064h, length, length2)) > C0101l.f583h) {
                        C0101l.f583h = m532a;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00af A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m344a(String str, float f2, float f3) {
        BufferedReader bufferedReader;
        FileReader fileReader = null;
        int i2 = 0;
        int i3 = 0;
        StringBuilder sb = null;
        String readLine = null;
        String m537a = C0101l.m537a("poi/waypoints.cup");
        if (m537a == null) {
            return;
        }
        try {
            fileReader = new FileReader(m537a);
            bufferedReader = new BufferedReader(fileReader);
            i2 = (int) (f2 * 1000.0f);
            i3 = (int) (f3 * 1000.0f);
            try {
                sb = new StringBuilder();
                readLine = bufferedReader.readLine();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (FileNotFoundException e4) {
            Throwable e = e4;
            bufferedReader = null;
        } catch (Exception e5) {
            Throwable e = e5;
            bufferedReader = null;
        }
        if (sb == null) sb = new StringBuilder();
        if (readLine == null) {
            return;
        }
        sb.append(readLine);
        sb.append("\n");
        C0374n c0374n = new C0374n();
        while (true) {
            String readLine2 = null;
            try { readLine2 = bufferedReader.readLine(); } catch (IOException e) { }
            if (readLine2 == null) {
                break;
            }
            try {
                if (c0374n.m1267a(readLine2, 'w') && (((int) (c0374n.f2060d * 1000.0f)) != i2 || ((int) (c0374n.f2061e * 1000.0f)) != i3 || !c0374n.f2064h.equals(str))) {
                    sb.append(readLine2);
                    sb.append("\n");
                }
            } catch (Exception unused) {
            }
        }
        try { fileReader.close(); } catch (IOException e) { }
        String str2 = m537a + ".new";
        try { PrintStream printStream = new PrintStream(new FileOutputStream(str2));
        printStream.print(sb.toString());
        printStream.flush();
        printStream.close(); } catch (Exception e) { }
        File file = new File(str2);
        m350a(file, new File(m537a));
        file.delete();
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
            }
        }
    }

    /* renamed from: a */
    private static void m345a(String str, C0367g c0367g, List<PoiPoint> list) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(C0101l.m537a(str)));
            try {
                m342a(bufferedReader, c0367g, list);
            } catch (Exception unused) {
            }
        } catch (IOException unused2) {
            bufferedReader = null;
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException unused3) {
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0057 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void m346a(String str, C0367g c0367g, List<PoiPoint> list, char c2) {
        BufferedReader bufferedReader;
        FileReader fileReader = null;
        String m537a = C0101l.m537a("poi/" + str);
        if (!new File(m537a).isFile()) {
            if (!str.equals("waypoints.cup")) {
                return;
            } else {
                C0091b.m461a("waypoints.cup", "poi", true);
            }
        }
        try {
            fileReader = new FileReader(m537a);
            bufferedReader = new BufferedReader(fileReader);
        } catch (FileNotFoundException e2) {
            Throwable e = e2;
            bufferedReader = null;
        } catch (IOException e3) {
            Throwable e = e3;
            bufferedReader = null;
        }
        try {
            m343a(bufferedReader, c0367g, list, null, c2);
            fileReader.close();
        } catch (FileNotFoundException e4) {
            Throwable e = e4;
            e.printStackTrace();
            if (bufferedReader != null) {
            }
        } catch (Exception e5) {
            Throwable e = e5;
            e.printStackTrace();
            if (bufferedReader != null) {
            }
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: a */
    private static void m347a(List<PoiPoint> list) {
        for (int i2 = 0; i2 < C0225a.f1256a.size(); i2++) {
            C0373m c0373m = C0225a.f1256a.get(i2);
            C0373m c0373m2 = new C0373m();
            c0373m2.m1171a(c0373m);
            c0373m2.f2055a = c0373m.f2055a;
            list.add(c0373m2);
        }
    }

    /* renamed from: a */
    public static void m348a(GpsVal gpsVal) {
        f301a++;
        f302b = false;
        new AsyncTaskC0066g().execute(gpsVal);
    }

    /* renamed from: a */
    private static void m349a(GpsVal gpsVal, List<PoiPoint> list, boolean z) {
        C0367g c0367g = new C0367g();
        C0369i.m1246a(50.0f, gpsVal.f1972a, gpsVal.f1973b, c0367g);
        ArrayList<String> m1269a = C0375o.m1269a(c0367g.f2012a, c0367g.f2014c, c0367g.f2013b, c0367g.f2015d);
        for (int i2 = 0; i2 < m1269a.size(); i2++) {
            m345a("mpt/" + m1269a.get(i2) + ".mpt", c0367g, list);
        }
        m346a("waypoints.cup", z ? null : c0367g, list, 'w');
        if (z) {
            c0367g = null;
        }
        m346a("imported-waypoints.cup", c0367g, list, 'w');
    }

    /* renamed from: a */
    private static boolean m350a(File file, File file2) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        FileChannel fileChannel;
        FileOutputStream fileOutputStream2;
        FileChannel fileChannel2 = null;
        try {
            if (!file2.exists()) {
                file2.createNewFile();
            }
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream2 = new FileOutputStream(file2);
                try {
                    FileChannel channel = fileInputStream.getChannel();
                    try {
                        fileChannel = fileOutputStream2.getChannel();
                        try {
                            long size = channel.size();
                            long j2 = 0;
                            do {
                                j2 += fileChannel.transferFrom(channel, j2, size - j2);
                            } while (j2 < size);
                            channel.close();
                            try {
                                fileChannel.close();
                            } catch (Exception unused) {
                            }
                            try {
                                fileInputStream.close();
                            } catch (Exception unused2) {
                            }
                            try {
                                fileOutputStream2.close();
                            } catch (Exception unused3) {
                            }
                            return true;
                        } catch (Exception unused4) {
                            fileChannel2 = channel;
                            try {
                                fileChannel2.close();
                            } catch (Exception unused5) {
                            }
                            try {
                                fileChannel.close();
                            } catch (Exception unused6) {
                            }
                            try {
                                fileInputStream.close();
                            } catch (Exception unused7) {
                            }
                            try {
                                fileOutputStream2.close();
                            } catch (Exception unused8) {
                            }
                            return false;
                        } catch (Throwable th) {
                            fileOutputStream = fileOutputStream2;
                            th = th;
                            fileChannel2 = channel;
                            try {
                                fileChannel2.close();
                            } catch (Exception unused9) {
                            }
                            try {
                                fileChannel.close();
                            } catch (Exception unused10) {
                            }
                            try {
                                fileInputStream.close();
                            } catch (Exception unused11) {
                            }
                            try {
                                fileOutputStream.close();
                                throw th;
                            } catch (Exception unused12) {
                                throw th;
                            }
                        }
                    } catch (Exception unused13) {
                        fileChannel = null;
                    } catch (Throwable th2) {
                        fileChannel = null;
                        fileChannel2 = channel;
                        fileOutputStream = fileOutputStream2;
                        th = th2;
                    }
                } catch (Exception unused14) {
                    fileChannel = null;
                } catch (Throwable th3) {
                    fileChannel = null;
                    fileOutputStream = fileOutputStream2;
                    th = th3;
                }
            } catch (Exception unused15) {
                fileOutputStream2 = null;
                fileChannel = null;
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                fileChannel = null;
            }
        } catch (Exception unused16) {
            fileOutputStream2 = null;
            fileInputStream = null;
            fileChannel = null;
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            fileInputStream = null;
            fileChannel = null;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(GpsVal... gpsValArr) {
        try {
            this.f305d.m1169a(gpsValArr[0]);
            long currentTimeMillis = System.currentTimeMillis();
            m349a(this.f305d, this.f304c, false);
            f303e = System.currentTimeMillis() - currentTimeMillis;
        } catch (Exception e2) {
            C0101l.m547a("PoiLoader.doInBackground", e2.getMessage());
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        m347a(this.f304c);
        C0101l.f568ar.f498b = (PoiPoint[]) this.f304c.toArray(new PoiPoint[0]);
        if (this.f306f != null) {
            C0379a.m1302a(this.f306f);
        }
        C0369i.m1246a(37.5f, this.f305d.f1972a, this.f305d.f1973b, C0101l.f568ar.f497a);
        C0101l.f568ar.m504a(C0101l.f568ar.f501f, C0239g.m1073d(), true, false);
        C0097h.f496c++;
        ActivityMain.m413a(10);
    }
}
