package flyme_intentutil;

import android.content.Intent;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0095f;
import com.xcglobe.xclog.C0099j;
import com.xcglobe.xclog.C0101l;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import flyme_tasks.AsyncTaskC0071l;
import flyme_data.C0239g;
import types.C0373m;
import types.GpsVal;

/* renamed from: j.a */
/* loaded from: classes.dex */
public class C0225a {
    private static Throwable e;
    private static Throwable th;

    /* renamed from: h */
    private static HashMap<Integer, C0373m> f1263h = new HashMap<>();

    /* renamed from: a */
    public static ArrayList<C0373m> f1256a = new ArrayList<>();

    /* renamed from: i */
    private static int f1264i = 0;

    /* renamed from: j */
    private static String f1265j = null;

    /* renamed from: b */
    public static long f1257b = 0;

    /* renamed from: k */
    private static GpsVal f1266k = new GpsVal();

    /* renamed from: c */
    public static long f1258c = 0;

    /* renamed from: d */
    public static String f1259d = null;

    /* renamed from: e */
    public static int f1260e = 0;

    /* renamed from: f */
    public static int f1261f = 0;

    /* renamed from: g */
    public static int f1262g = 0;

    /* renamed from: l */
    private static int f1267l = 0;

    /* renamed from: m */
    private static boolean f1268m = false;

    /* renamed from: n */
    private static int f1269n = 0;

    /* renamed from: o */
    private static boolean f1270o = false;

    /* renamed from: a */
    private static String m976a(String str, C0226b c0226b) {
        if (!c0226b.f1273c) {
            f1262g++;
        }
        try {
            URLConnection openConnection = new URL(str).openConnection();
            openConnection.connect();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(openConnection.getInputStream());
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    byteArrayOutputStream.flush();
                    byteArrayOutputStream.close();
                    bufferedInputStream.close();
                    return byteArrayOutputStream.toString();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (Exception e2) {
            if (!f1270o) {
                App.m441a("livetrack", e2);
                f1270o = true;
            }
            c0226b.f1272b = App.m435a(R.string.net_error);
            c0226b.f1275e = true;
            return null;
        }
    }

    /* renamed from: a */
    private static String m977a(boolean z, C0226b c0226b) {
        String str;
        if (z) {
            String m515a = C0099j.m515a("user.username");
            String m515a2 = C0099j.m515a("user.password");
            if (m515a.length() == 0 || m515a2.length() == 0) {
                c0226b.f1272b = App.m435a(R.string.wrong_usr_psw);
                f1268m = true;
                return null;
            }
            str = C0095f.m486o() + "livetrack/login?usr=" + URLEncoder.encode(m515a) + "&psw=" + URLEncoder.encode(m515a2);
        } else {
            str = ((C0095f.m486o() + "livetrack/save?uid=" + f1264i + "&h=" + f1265j) + "&lat=" + C0101l.f522G.format(c0226b.f1271a.f1972a).replace(',', '.') + "&lng=" + C0101l.f522G.format(c0226b.f1271a.f1973b).replace(',', '.') + "&alt=" + ((int) c0226b.f1271a.f1974c)) + "&r=30";
        }
        if (!c0226b.f1273c) {
            return str;
        }
        return str + "&test=1";
    }

    /* renamed from: a */
    public static C0373m m978a(int i2) {
        return f1263h.get(Integer.valueOf(i2));
    }

    /* renamed from: a */
    public static void m979a() {
        f1268m = false;
        f1264i = 0;
        f1265j = null;
        f1257b = 0L;
    }

    /* renamed from: a */
    private static void m980a(C0226b c0226b) {
        if (f1264i == 0 || c0226b.f1273c) {
            String m977a = m977a(true, c0226b);
            if (m977a == null) {
                m985b("error:2", c0226b);
                return;
            }
            c0226b.f1274d = m976a(m977a, c0226b);
            if (c0226b.f1274d == null || !m986c(c0226b)) {
                return;
            }
            AsyncTaskC0071l.m372a();
            if (c0226b.f1273c) {
                return;
            }
        }
        c0226b.f1274d = m976a(m977a(false, c0226b), c0226b);
        if (c0226b.f1274d == null || !c0226b.f1274d.startsWith("error:")) {
            return;
        }
        m985b(c0226b.f1274d, c0226b);
    }

    /* renamed from: a */
    private static void m981a(String str) {
        int m571h;
        f1256a.clear();
        String[] split = str.replace("\r", "").split("\n");
        long currentTimeMillis = System.currentTimeMillis();
        for (String str2 : split) {
            if (!str2.startsWith("ok:")) {
                if (str2.startsWith("error:")) {
                    return;
                }
                String[] split2 = str2.split(",");
                if (split2.length >= 5 && (m571h = C0101l.m571h(split2[0])) != f1264i) {
                    C0373m c0373m = new C0373m();
                    c0373m.m1170a(C0101l.m573i(split2[1]), C0101l.m573i(split2[2]), (short) C0101l.m571h(split2[3]), split2[4], 'l');
                    c0373m.f2055a = m571h;
                    c0373m.f2056b = currentTimeMillis;
                    f1256a.add(c0373m);
                    f1263h.put(Integer.valueOf(m571h), c0373m);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m982a(boolean z) {
        if (!z && f1268m) {
            f1257b = System.currentTimeMillis() + 600000;
            return;
        }
        if (f1269n > 0) {
            f1257b = System.currentTimeMillis() + C0101l.f551aa;
            return;
        }
        f1257b = System.currentTimeMillis() + 60000;
        final C0226b c0226b = new C0226b();
        c0226b.f1273c = z;
        c0226b.f1271a.m1169a(C0239g.m1073d());
        f1269n++;
        new Thread(new Runnable() { // from class: j.-$$Lambda$a$s5M9O9oH83fWe5aVl0rPGfbNLig
            @Override // java.lang.Runnable
            public final void run() {
                // C0225a.m987d();
            }
        }).start();
    }

    /* renamed from: b */
    public static void m983b() {
        f1257b = 0L;
    }

    /* renamed from: b */
    private static void m984b(C0226b c0226b) {
        if (c0226b.f1273c) {
            Intent intent = new Intent("com.xcglobe.action.main");
            intent.putExtra("event", 18);
            if (c0226b.f1272b != null) {
                intent.putExtra("error", c0226b.f1272b);
            }
            App.m443b().sendBroadcast(intent);
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (c0226b.f1272b == null) {
            f1266k.m1169a(c0226b.f1271a);
            f1258c = currentTimeMillis;
            f1260e++;
            m981a(c0226b.f1274d);
            if (!c0226b.f1273c) {
                C0101l.f568ar.m508c();
            }
            Intent intent2 = new Intent("com.xcglobe.action.main");
            intent2.putExtra("event", 19);
            App.m443b().sendBroadcast(intent2);
        } else if (c0226b.f1275e) {
            f1267l++;
        }
        if (c0226b.f1272b != null) {
            f1261f++;
        }
        if (!c0226b.f1275e) {
            f1267l = 0;
        }
        f1259d = c0226b.f1272b;
        long j2 = C0101l.f551aa;
        if (f1267l > 10) {
            j2 += 60000;
        }
        f1257b = currentTimeMillis + j2;
    }

    /* renamed from: b */
    private static void m985b(String str, C0226b c0226b) {
        if (str == null || !str.startsWith("error:")) {
            return;
        }
        String substring = str.substring(6);
        int i2 = R.string.error;
        try {
            int parseInt = Integer.parseInt(substring);
            if (parseInt == 2 || parseInt == 4) {
                i2 = R.string.wrong_usr_psw;
            } else if (parseInt == 5) {
                i2 = R.string.livetrack_interval_too_short;
            }
        } catch (Exception unused) {
        }
        c0226b.f1272b = App.m435a(i2);
    }

    /* renamed from: c */
    private static boolean m986c(C0226b c0226b) {
        f1264i = 0;
        String[] split = c0226b.f1274d.replace("\r", "").split("\n");
        int length = split.length;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                break;
            }
            String str = split[i2];
            if (str.startsWith("h=")) {
                f1265j = str.substring(2);
            } else if (str.startsWith("u=")) {
                f1264i = Integer.parseInt(str.substring(2));
            } else if (str.startsWith("error:")) {
                m985b(str, c0226b);
                if (str.startsWith("error:2")) {
                    f1268m = true;
                }
            }
            i2++;
        }
        if (f1265j != null && f1264i != 0) {
            return true;
        }
        f1264i = 0;
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static /* synthetic */ void m987d(C0226b c0226b) {
        try {
            m980a(c0226b);
            m984b(c0226b);
        } finally {
            f1269n--;
        }
    }
}
