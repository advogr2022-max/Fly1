package com.xcglobe.xclog;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.widget.Toast;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.channels.FileChannel;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import flyme_tasks.C0062c;
import flyme_apphelper.C0072a;
import flyme_intentutil.C0225a;
import flyme_data.C0236d;
import flyme_data.C0239g;
import types.C0377q;

/* renamed from: com.xcglobe.xclog.l */
/* loaded from: classes.dex */
public class C0101l {
    private static Throwable th;
    private static Throwable e;

    /* renamed from: A */
    public static int f516A;

    /* renamed from: B */
    public static int f517B;

    /* renamed from: C */
    public static int f518C;

    /* renamed from: D */
    public static int f519D;

    /* renamed from: a */
    public static String f542a;

    /* renamed from: aA */
    public static boolean f543aA;

    /* renamed from: aB */
    public static int f544aB;

    /* renamed from: aC */
    public static int f545aC;

    /* renamed from: aD */
    public static int f546aD;

    /* renamed from: aj */
    public static boolean f560aj;

    /* renamed from: aq */
    public static float f567aq;

    /* renamed from: aw */
    public static int f573aw;

    /* renamed from: ax */
    public static int f574ax;

    /* renamed from: ay */
    public static int f575ay;

    /* renamed from: az */
    public static int f576az;

    /* renamed from: c */
    public static int f578c;

    /* renamed from: d */
    public static int f579d;

    /* renamed from: e */
    public static int f580e;

    /* renamed from: j */
    public static int f585j;

    /* renamed from: k */
    public static int f586k;

    /* renamed from: l */
    public static int f587l;

    /* renamed from: m */
    public static int f588m;

    /* renamed from: n */
    public static int f589n;

    /* renamed from: o */
    public static int f590o;

    /* renamed from: p */
    public static int f591p;

    /* renamed from: q */
    public static int f592q;

    /* renamed from: r */
    public static int f593r;

    /* renamed from: s */
    public static int f594s;

    /* renamed from: t */
    public static int f595t;

    /* renamed from: u */
    public static int f596u;

    /* renamed from: v */
    public static int f597v;

    /* renamed from: w */
    public static int f598w;

    /* renamed from: x */
    public static int f599x;

    /* renamed from: y */
    public static int f600y;

    /* renamed from: z */
    public static int f601z;

    /* renamed from: b */
    public static final SimpleDateFormat f577b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    /* renamed from: f */
    public static String f581f = "";

    /* renamed from: g */
    public static String f582g = "Waypoint ";

    /* renamed from: h */
    public static int f583h = 0;

    /* renamed from: i */
    public static long f584i = 4000;

    /* renamed from: E */
    public static DecimalFormat f520E = new DecimalFormat("0.0");

    /* renamed from: F */
    public static DecimalFormat f521F = new DecimalFormat("0.00");

    /* renamed from: G */
    public static DecimalFormat f522G = new DecimalFormat("0.00000");

    /* renamed from: aG */
    private static String f549aG = null;

    /* renamed from: H */
    public static boolean f523H = false;

    /* renamed from: I */
    public static boolean f524I = true;

    /* renamed from: J */
    public static boolean f525J = false;

    /* renamed from: K */
    public static float f526K = 25.0f;

    /* renamed from: L */
    public static float f527L = 1.0f;

    /* renamed from: M */
    public static float f528M = 38.0f;

    /* renamed from: N */
    public static float f529N = 1.1f;

    /* renamed from: O */
    public static float f530O = 55.0f;

    /* renamed from: P */
    public static float f531P = 3.0f;

    /* renamed from: Q */
    public static boolean f532Q = false;

    /* renamed from: R */
    public static boolean f533R = true;

    /* renamed from: S */
    public static int f534S = 0;

    /* renamed from: T */
    public static float f535T = -2.0f;

    /* renamed from: U */
    public static boolean f536U = true;

    /* renamed from: V */
    public static boolean f537V = true;

    /* renamed from: W */
    public static int f538W = 0;

    /* renamed from: X */
    public static boolean f539X = false;

    /* renamed from: Y */
    public static int f540Y = 0;

    /* renamed from: Z */
    public static boolean f541Z = false;

    /* renamed from: aa */
    public static long f551aa = 300;

    /* renamed from: ab */
    public static boolean f552ab = false;

    /* renamed from: ac */
    public static boolean f553ac = false;

    /* renamed from: ad */
    public static int f554ad = 0;

    /* renamed from: ae */
    public static boolean f555ae = false;

    /* renamed from: af */
    public static int f556af = 0;

    /* renamed from: ag */
    public static long f557ag = 60000;

    /* renamed from: ah */
    public static long f558ah = 4000;

    /* renamed from: ai */
    public static int f559ai = 0;

    /* renamed from: ak */
    public static int f561ak = 3;

    /* renamed from: al */
    public static boolean f562al = false;

    /* renamed from: am */
    public static boolean f563am = false;

    /* renamed from: an */
    public static boolean f564an = true;

    /* renamed from: ao */
    public static boolean f565ao = false;

    /* renamed from: ap */
    public static int f566ap = 0;

    /* renamed from: ar */
    public static C0097h f568ar = new C0097h();

    /* renamed from: as */
    public static boolean f569as = true;

    /* renamed from: at */
    public static boolean f570at = true;

    /* renamed from: au */
    public static boolean f571au = true;

    /* renamed from: av */
    public static boolean f572av = true;

    /* renamed from: aE */
    public static NumberFormat f547aE = NumberFormat.getInstance(Locale.ENGLISH);

    /* renamed from: aF */
    public static Handler f548aF = new Handler();

    /* renamed from: aH */
    private static final String[] f550aH = {"waypoints", "poi", "kml", "config"};

    /* renamed from: a */
    public static int m531a(int i2, String str) {
        String[] stringArray = App.m443b().getResources().getStringArray(i2);
        for (int i3 = 0; i3 < stringArray.length; i3++) {
            if (stringArray[i3].equals(str)) {
                return i3;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static int m532a(String str, int i2, int i3) {
        char charAt;
        boolean z;
        int i4;
        int i5 = 0;
        if (str == null) {
            return 0;
        }
        char charAt2 = str.charAt(i2);
        if (charAt2 < '0' || charAt2 > '9') {
            boolean z2 = charAt2 == '-';
            if (!z2 || (i2 = i2 + 1) == i3 || (charAt = str.charAt(i2)) < '0' || charAt > '9') {
                return 0;
            }
            z = z2;
            charAt2 = charAt;
        } else {
            z = false;
        }
        while (true) {
            i4 = i5 + ('0' - charAt2);
            i2++;
            if (i2 == i3) {
                return z ? i4 : -i4;
            }
            charAt2 = str.charAt(i2);
            if (charAt2 < '0' || charAt2 > '9') {
                break;
            }
            i5 = i4 * 10;
        }
        return z ? i4 : -i4;
    }

    /* renamed from: a */
    public static String m533a(double d2, boolean z) {
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

    /* renamed from: a */
    public static String m534a(int i2, int i3) {
        boolean z = false;
        boolean z2 = (i3 & 4) != 0;
        boolean z3 = (i3 & 1) != 0;
        if ((i3 & 2) != 0 && i2 < 3600) {
            z = true;
        }
        StringBuilder sb = new StringBuilder();
        if (i2 < 0) {
            i2 = -i2;
            sb.append("-");
        }
        int i4 = i2 / 3600;
        int i5 = i4 * 3600;
        int i6 = (i2 - i5) / 60;
        int i7 = i2 - (i5 + (i6 * 60));
        if (!z || i4 > 0) {
            if (i4 < 10) {
                sb.append("0");
            }
            sb.append(i4);
            if (!z2) {
                sb.append(":");
            }
        }
        if (i6 < 10) {
            sb.append("0");
        }
        sb.append(i6);
        if (z3) {
            if (!z2) {
                sb.append(":");
            }
            if (i7 < 10) {
                sb.append("0");
            }
            sb.append(i7);
        }
        return sb.toString();
    }

    /* renamed from: a */
    public static String m535a(int i2, int i3, String str) {
        return m536a(i2, m531a(i3, str), true);
    }

    /* renamed from: a */
    public static String m536a(int i2, int i3, boolean z) {
        String[] stringArray = App.m443b().getResources().getStringArray(i2);
        return (i3 < 0 || i3 >= stringArray.length) ? (!z || stringArray.length <= 0) ? "" : stringArray[0] : stringArray[i3];
    }

    /* renamed from: a */
    public static String m537a(String str) {
        String m569g;
        if (!m574j(str) || (m569g = m562d()) == null) {
            m569g = m569g();
        }
        return m569g + "/" + str;
    }

    /* renamed from: a */
    public static String m538a(String str, int i2) {
        if (str.length() <= i2) {
            return str;
        }
        for (int i3 = i2; i3 > i2 / 2; i3--) {
            char charAt = str.charAt(i3);
            if (charAt == ' ' || charAt == '.' || charAt == '-' || charAt == '_' || charAt == '/' || charAt == ',') {
                return str.substring(0, i3);
            }
        }
        return str.substring(0, i2);
    }

    /* renamed from: a */
    public static String m539a(String str, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        OutputStream outputStream;
        PrintWriter printWriter;
        String hexString = Long.toHexString(System.currentTimeMillis());
        try {
            URLConnection openConnection = new URL(str).openConnection();
            openConnection.setDoOutput(true);
            openConnection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + hexString);
            try {
                outputStream = openConnection.getOutputStream();
                try {
                    printWriter = new PrintWriter((Writer) new OutputStreamWriter(outputStream, "UTF-8"), true);
                    if (hashMap != null) {
                        try {
                            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                                printWriter.append((CharSequence) ("--" + hexString)).append((CharSequence) "\r\n");
                                printWriter.append((CharSequence) ("Content-Disposition: form-data; name=\"" + entry.getKey() + "\"")).append((CharSequence) "\r\n");
                                StringBuilder sb = new StringBuilder();
                                sb.append("Content-Type: text/plain; charset=");
                                sb.append("UTF-8");
                                printWriter.append((CharSequence) sb.toString()).append((CharSequence) "\r\n");
                                printWriter.append((CharSequence) "\r\n").append((CharSequence) entry.getValue()).append((CharSequence) "\r\n").flush();
                            }
                        } catch (Throwable th) {
                            th = th;
                            if (outputStream != null) {
                                outputStream.close();
                            }
                            if (printWriter != null) {
                                printWriter.close();
                            }
                            throw th;
                        }
                    }
                    if (hashMap2 != null) {
                        for (Map.Entry<String, String> entry2 : hashMap2.entrySet()) {
                            File file = new File(entry2.getValue());
                            printWriter.append((CharSequence) ("--" + hexString)).append((CharSequence) "\r\n");
                            printWriter.append((CharSequence) ("Content-Disposition: form-data; name=\"" + entry2.getKey() + "\"; filename=\"" + file.getName() + "\"")).append((CharSequence) "\r\n");
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("Content-Type: ");
                            sb2.append(URLConnection.guessContentTypeFromName(file.getName()));
                            printWriter.append((CharSequence) sb2.toString()).append((CharSequence) "\r\n");
                            printWriter.append((CharSequence) "Content-Transfer-Encoding: binary").append((CharSequence) "\r\n");
                            printWriter.append((CharSequence) "\r\n").flush();
                            FileInputStream fileInputStream = new FileInputStream(file);
                            byte[] bArr = new byte[1024];
                            while (true) {
                                int read = fileInputStream.read(bArr);
                                if (read > 0) {
                                    outputStream.write(bArr, 0, read);
                                }
                            }
                            fileInputStream.close();
                            outputStream.flush();
                            printWriter.append((CharSequence) "\r\n").flush();
                        }
                    }
                    printWriter.append((CharSequence) ("--" + hexString + "--")).append((CharSequence) "\r\n").flush();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    printWriter.close();
                    InputStream inputStream = openConnection.getInputStream();
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        try {
                            int read2 = inputStream.read();
                            if (read2 == -1) {
                                String stringBuffer2 = stringBuffer.toString();
                                try {
                                    return stringBuffer2;
                                } catch (Exception unused) {
                                    return stringBuffer2;
                                }
                            }
                            stringBuffer.append((char) read2);
                        } finally {
                            inputStream.close();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    printWriter = null;
                }
            } catch (Throwable th3) {
                th = th3;
                outputStream = null;
                printWriter = null;
            }
        } catch (Exception unused2) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m540a(String str, byte[] bArr) {
        String str2;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            httpURLConnection.setDoInput(true);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("User-Agent", "XCglobe logger");
            httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
            httpURLConnection.setFixedLengthStreamingMode(bArr.length);
            new DataOutputStream(httpURLConnection.getOutputStream()).write(bArr);
            InputStream inputStream = httpURLConnection.getInputStream();
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                try {
                    int read = inputStream.read();
                    if (read == -1) {
                        break;
                    }
                    stringBuffer.append((char) read);
                } finally {
                    inputStream.close();
                }
            }
            str2 = stringBuffer.toString();
        } catch (IOException e2) {
            e = e2;
            str2 = null;
        }
        try {
        } catch (IOException e3) {
            e = e3;
            e.printStackTrace();
            return str2;
        }
        return str2;
    }

    /* renamed from: a */
    public static void m541a() {
        m555b("igc");
        m555b("kml");
        m555b("tasks");
        m555b("mpt");
        m555b("vmp");
        m555b("poi");
        m555b("waypoints");
        m555b("config");
    }

    /* renamed from: a */
    public static void m542a(int i2, int i3, Activity activity) {
        String m435a = App.m435a(i2);
        String m435a2 = App.m435a(i3);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setIcon(R.drawable.ic_dialog_alert).setTitle(m435a).setMessage(m435a2).setPositiveButton(com.xcglobe.flyme.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.xcglobe.xclog.l.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i4) {
            }
        });
        builder.show();
    }

    /* renamed from: a */
    public static void m543a(int i2, boolean z) {
    }

    /* renamed from: a */
    public static void m544a(Activity activity) {
        Intent intent = new Intent(activity, (Class<?>) ActivityMain.class);
        intent.addFlags(67108864);
        activity.startActivity(intent);
    }

    /* renamed from: a */
    public static void m545a(final Activity activity, String str, String str2, final boolean z) {
        AlertDialog create = new AlertDialog.Builder(activity).setIcon(R.drawable.ic_dialog_info).setTitle(str).setMessage(str2).setPositiveButton(com.xcglobe.flyme.R.string.ok, new DialogInterface.OnClickListener() { // from class: com.xcglobe.xclog.l.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (z) {
                    activity.finish();
                }
            }
        }).create();
        App.m436a(create);
    }

    /* renamed from: a */
    public static void m546a(String str, Activity activity) {
        Bundle bundle = new Bundle();
        bundle.putString("igc", str);
        Intent intent = new Intent(activity, (Class<?>) ActivityInfo.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    /* renamed from: a */
    public static void m547a(String str, String str2) {
        m570g(str2);
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(m537a("error.log")), true));
            String str3 = "#" + f577b.format(new Date(System.currentTimeMillis())) + "\t" + str + " Dev:" + C0095f.m463a() + " / " + C0095f.m466a(true);
            if (str2 != null) {
                str3 = str3 + "\t" + str2;
            }
            bufferedWriter.append((CharSequence) (str3 + "\n"));
            bufferedWriter.close();
        } catch (IOException unused) {
        }
    }

    /* renamed from: a */
    public static void m548a(String str, boolean z) {
        String m562d = m562d();
        if (m562d == null) {
            return;
        }
        String m537a = m537a(str);
        File[] listFiles = new File(m562d + "/" + str).listFiles();
        if (listFiles != null) {
            try {
                for (File file : listFiles) {
                    File file2 = new File(m537a + "/" + file.getName());
                    if (!file2.exists()) {
                        if (z) {
                            m560c(file.getAbsolutePath(), file2.getAbsolutePath());
                        } else {
                            m564d(file.getAbsolutePath(), file2.getAbsolutePath());
                        }
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m549a(boolean z) {
        f565ao = z;
        C0236d.m1047d();
        C0062c.m312a(App.m443b());
        if (!f541Z || C0072a.m378a()) {
            return;
        }
        C0225a.m982a(false);
    }

    /* renamed from: a */
    public static void m550a(String[] strArr, String str) {
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(str)));
        try {
            byte[] bArr = new byte[10000];
            for (int i2 = 0; i2 < strArr.length; i2++) {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(strArr[i2]), 10000);
                try {
                    zipOutputStream.putNextEntry(new ZipEntry(strArr[i2].substring(strArr[i2].lastIndexOf("/") + 1)));
                    while (true) {
                        int read = bufferedInputStream.read(bArr, 0, 10000);
                        if (read != -1) {
                            zipOutputStream.write(bArr, 0, read);
                        }
                    }
                    bufferedInputStream.close();
                } finally {
                }
            }
        } finally {
            zipOutputStream.close();
        }
    }

    /* renamed from: b */
    public static Bitmap m551b(int i2, int i3) {
        try {
            return Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        } catch (Exception e2) {
            m547a("createBmp", e2.getMessage());
            return Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_4444);
        }
    }

    /* renamed from: b */
    public static void m552b() {
        new Thread(new Runnable() { // from class: com.xcglobe.xclog.-$$Lambda$l$0_wlavHtJarW3vy_SXtV84qA9OA
            @Override // java.lang.Runnable
            public final void run() {
                C0101l.m548a("igc", false);
            }
        }).start();
    }

    /* renamed from: b */
    public static void m553b(int i2, boolean z) {
        Toast.makeText(App.m443b(), App.m435a(i2), z ? 1 : 0).show();
    }

    /* renamed from: b */
    public static void m554b(Activity activity) {
        new AlertDialog.Builder(activity).setIcon(R.drawable.ic_dialog_alert).setTitle(com.xcglobe.flyme.R.string.stop_recording).setMessage(com.xcglobe.flyme.R.string.sure_stop_recording).setPositiveButton(com.xcglobe.flyme.R.string.yes, new DialogInterface.OnClickListener() { // from class: com.xcglobe.xclog.l.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                C0239g.m1066a((String) null);
            }
        }).setNegativeButton(com.xcglobe.flyme.R.string.no, (DialogInterface.OnClickListener) null).show();
    }

    /* renamed from: b */
    public static void m555b(String str) {
        File file = new File(m537a(str));
        if (file.isDirectory()) {
            return;
        }
        file.mkdirs();
    }

    /* renamed from: b */
    public static void m556b(String str, boolean z) {
    }

    /* renamed from: b */
    public static boolean m557b(String str, String str2) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(m537a(str2)), false));
            bufferedWriter.write(str);
            bufferedWriter.close();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: c */
    public static String m558c() {
        return m537a("igc");
    }

    /* renamed from: c */
    public static void m559c(String str) {
        new File(m558c() + "/" + str).delete();
        SharedPreferences.Editor edit = App.m443b().getSharedPreferences("tracks", 0).edit();
        edit.remove(str + ".duration");
        edit.remove(str + ".kmmaxtype");
        edit.remove(str + ".kmmax");
        edit.remove(str + ".km1");
        edit.remove(str + ".km2");
        edit.remove(str + ".km3");
        edit.remove(str + ".altmax");
        edit.remove(str + ".altmax");
        edit.remove(str + ".altmax");
        edit.remove(str + ".uploaded");
        edit.commit();
        String m562d = m562d();
        if (m562d != null) {
            new File(m562d + "/igc/" + str).delete();
        }
    }

    /* renamed from: c */
    public static void m560c(String str, String str2) {
        m564d(str, str2);
        new File(str).delete();
    }

    /* renamed from: c */
    public static void m561c(String str, boolean z) {
        Toast.makeText(App.m443b(), str, z ? 1 : 0).show();
    }

    /* renamed from: d */
    public static String m562d() {
        String absolutePath;
        if (!f523H) {
            return null;
        }
        if (Environment.getExternalStorageState().equals("mounted")) {
            absolutePath = Environment.getExternalStorageDirectory().getPath() + "/xcglobe";
        } else {
            absolutePath = App.m443b().getDir("xcglobe", 1).getAbsolutePath();
        }
        File file = new File(absolutePath);
        if (file.isDirectory()) {
            return absolutePath;
        }
        file.mkdirs();
        return absolutePath;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public static String m563d(String str) {
        int length = str.length();
        if (length < 8) {
            return "";
        }
        String str2 = "" + m532a(str, 6, 8) + "." + m532a(str, 4, 6) + "." + m532a(str, 0, 4);
        if (length < 12) {
            return str2;
        }
        return str2 + " at " + str.substring(8, 10) + ":" + str.substring(10, 12);
    }

    /* renamed from: d */
    public static void m564d(String str, String str2) {
        FileOutputStream fileOutputStream;
        FileInputStream fileInputStream;
        FileChannel fileChannel;
        File file = new File(str);
        File file2 = new File(str2);
        FileChannel fileChannel2 = null;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    FileChannel channel = fileInputStream.getChannel();
                    try {
                        fileChannel = fileOutputStream.getChannel();
                        try {
                            fileChannel.transferFrom(channel, 0L, channel.size());
                            channel.close();
                            fileChannel.close();
                            fileInputStream.close();
                            fileOutputStream.close();
                        } catch (Throwable th) {
                            fileChannel2 = channel;
                            th = th;
                            fileChannel2.close();
                            fileChannel.close();
                            fileInputStream.close();
                            fileOutputStream.close();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        fileChannel = null;
                        fileChannel2 = channel;
                        th = th2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileChannel = null;
                }
            } catch (Throwable th4) {
                th = th4;
                fileOutputStream = null;
                fileChannel = null;
            }
        } catch (Throwable th5) {
            th = th5;
            fileOutputStream = null;
            fileInputStream = null;
            fileChannel = null;
        }
    }

    /* renamed from: e */
    public static String m565e(String str) {
        String lowerCase = str.toLowerCase(Locale.US);
        StringBuilder sb = new StringBuilder();
        int i2 = 0;
        for (int i3 = 0; i3 < lowerCase.length(); i3++) {
            char charAt = lowerCase.charAt(i3);
            if ((charAt >= 'a' && charAt <= 'z') || ((charAt >= '0' && charAt <= '9') || charAt == '.' || charAt == '-')) {
                sb.append(charAt);
                i2 = 0;
            } else if (i2 == 0) {
                sb.append("-");
                i2++;
            }
        }
        return sb.toString();
    }

    /* renamed from: e */
    public static void m566e() {
        m544a(App.m434a());
    }

    public static boolean exportIgc(String str) {
        String str2 = m558c() + "/" + str;
        String m562d = m562d();
        if (m562d == null) {
            return false;
        }
        new File(m562d + "/igc").mkdirs();
        try {
            m564d(str2, m562d + "/igc/" + str);
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: f */
    public static String m567f(String str) {
        try {
            File file = new File(str);
            char[] cArr = new char[4096];
            StringBuffer stringBuffer = new StringBuffer();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            while (true) {
                try {
                    int read = bufferedReader.read(cArr);
                    if (read <= 0) {
                        bufferedReader.close();
                        return stringBuffer.toString();
                    }
                    stringBuffer.append(cArr, 0, read);
                } catch (Throwable th) {
                    bufferedReader.close();
                    throw th;
                }
            }
        } catch (IOException unused) {
            return "";
        }
    }

    /* renamed from: f */
    public static void m568f() {
        C0377q.m1282b(C0099j.m521b("unit_altitude"));
        C0377q.m1280a(C0099j.m521b("unit_distance"));
        C0377q.m1285c(C0099j.m521b("unit_speed"));
        C0377q.m1286d(C0099j.m521b("unit_vario"));
        C0377q.m1279a();
    }

    /* renamed from: g */
    private static String m569g() {
        if (f549aG == null) {
            f549aG = App.m443b().getFilesDir().getAbsolutePath();
        }
        return f549aG;
    }

    /* renamed from: g */
    public static void m570g(String str) {
    }

    /* renamed from: h */
    public static int m571h(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: i */
    public static float m573i(String str) {
        try {
            return f547aE.parse(str).floatValue();
        } catch (ParseException unused) {
            return 0.0f;
        }
    }

    /* renamed from: j */
    private static boolean m574j(String str) {
        int length;
        int length2 = str.length();
        for (String str2 : f550aH) {
            if (str.startsWith(str2) && (length2 == (length = str2.length()) || str.charAt(length) == '/')) {
                return true;
            }
        }
        return false;
    }
}
