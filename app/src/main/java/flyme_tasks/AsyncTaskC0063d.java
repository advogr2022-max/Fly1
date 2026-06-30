package flyme_tasks;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.CheckBoxPreference;
import android.preference.PreferenceManager;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0095f;
import com.xcglobe.xclog.C0099j;
import com.xcglobe.xclog.C0101l;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import types.C0375o;

/* renamed from: b.d */
/* loaded from: classes.dex */
public class AsyncTaskC0063d extends AsyncTask<Integer, String, String> {

    /* renamed from: a */
    String f271a;

    /* renamed from: b */
    String f272b;

    /* renamed from: c */
    String f273c;

    /* renamed from: g */
    @SuppressLint({"StaticFieldLeak"})
    private Activity f277g;

    /* renamed from: h */
    private CheckBoxPreference f278h;

    /* renamed from: k */
    private String f281k;

    /* renamed from: e */
    private final int f275e = -1;

    /* renamed from: f */
    private final int f276f = 1;

    /* renamed from: d */
    int f274d = 0;

    /* renamed from: i */
    private ProgressDialog f279i = null;

    /* renamed from: j */
    private int f280j = 0;

    /* renamed from: a */
    public static String m315a(int i2) {
        return "region_stored" + i2;
    }

    /* renamed from: a */
    public static void m316a(int i2, Activity activity, CheckBoxPreference checkBoxPreference, String str) {
        AsyncTaskC0063d asyncTaskC0063d = new AsyncTaskC0063d();
        asyncTaskC0063d.f278h = checkBoxPreference;
        asyncTaskC0063d.f277g = activity;
        asyncTaskC0063d.f274d = i2;
        asyncTaskC0063d.f281k = str;
        asyncTaskC0063d.f272b = "points-reg" + i2 + ".zip";
        asyncTaskC0063d.f273c = C0101l.m537a(asyncTaskC0063d.f272b);
        asyncTaskC0063d.f271a = C0095f.m486o() + "files/flyme/maps/" + m322d() + "/points-reg" + i2 + ".zip";
        asyncTaskC0063d.m324a();
        asyncTaskC0063d.execute(0);
    }

    /* renamed from: a */
    private void m317a(ZipInputStream zipInputStream, String str) {
        String parent = new File(str).getParent();
        if (parent != null) {
            File file = new File(parent);
            if (!file.isDirectory()) {
                file.mkdirs();
            }
        }
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(str));
        byte[] bArr = new byte[4096];
        while (true) {
            int read = zipInputStream.read(bArr);
            if (read == -1) {
                bufferedOutputStream.close();
                return;
            }
            bufferedOutputStream.write(bArr, 0, read);
        }
    }

    /* renamed from: b */
    public static void m318b(int i2) {
        ArrayList<String> m1270a = C0375o.m1270a(i2);
        for (int i3 = 0; i3 < m1270a.size(); i3++) {
            File file = new File(C0101l.m537a("mpt/" + m1270a.get(i3) + ".mpt"));
            if (file.isFile()) {
                file.delete();
            }
            File file2 = new File(C0101l.m537a("vmp/" + m1270a.get(i3) + ".vmp"));
            if (file2.isFile()) {
                file2.delete();
            }
        }
        File file3 = new File(C0101l.m537a("air/legal-" + i2 + ".air"));
        if (file3.isFile()) {
            file3.delete();
        }
        File file4 = new File(C0101l.m537a("air/xcglobe-" + i2 + ".air"));
        if (file4.isFile()) {
            file4.delete();
        }
        C0099j.m527d(m315a(i2), null);
    }

    /* renamed from: b */
    private void m319b(String str) {
        try {
            ZipFile zipFile = new ZipFile(str);
            int size = zipFile.size();
            ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(str));
            int i2 = 0;
            while (true) {
                ZipEntry nextEntry = zipInputStream.getNextEntry();
                if (nextEntry == null) {
                    zipInputStream.close();
                    zipFile.close();
                    return;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("");
                i2++;
                sb.append((i2 * 100) / size);
                publishProgress(sb.toString());
                String m537a = C0101l.m537a(nextEntry.getName());
                if (nextEntry.isDirectory()) {
                    File file = new File(m537a);
                    if (!file.isDirectory()) {
                        file.mkdirs();
                    }
                } else {
                    m317a(zipInputStream, m537a);
                }
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: c */
    public static String m320c(int i2) {
        int i3;
        if (i2 == 0) {
            i3 = R.string.mapset_0;
        } else {
            if (i2 == 1) {
                return "-";
            }
            if (i2 != 2) {
                return "?";
            }
            i3 = R.string.mapset_1;
        }
        return App.m435a(i3);
    }

    /* renamed from: c */
    public static void m321c() {
        for (int i2 = 1; i2 <= C0375o.m1268a(); i2++) {
            C0099j.m527d(m315a(i2), null);
        }
    }

    /* renamed from: d */
    public static String m322d() {
        int m521b = C0099j.m521b("mapset");
        return m521b == 1 ? "mapsv1-20" : m521b == 2 ? "mapsv1-50" : "mapsv1-100";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public String doInBackground(Integer... numArr) {
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(this.f271a).openConnection();
            httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
            httpURLConnection.connect();
            int contentLength = httpURLConnection.getContentLength();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(httpURLConnection.getInputStream());
            FileOutputStream fileOutputStream = new FileOutputStream(this.f273c);
            byte[] bArr = new byte[8192];
            long j2 = 0;
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                j2 += read;
                publishProgress("" + ((int) ((100 * j2) / contentLength)));
                fileOutputStream.write(bArr, 0, read);
            }
            fileOutputStream.flush();
            fileOutputStream.close();
            bufferedInputStream.close();
            if (this.f273c.indexOf(".zip") > 0) {
                publishProgress("0", App.m435a(R.string.unzipping));
                m319b(this.f273c);
                new File(this.f273c).delete();
            }
            this.f280j = 1;
            return null;
        } catch (IOException unused) {
            this.f280j = -1;
            return null;
        }
    }

    /* renamed from: a */
    public void m324a() {
        this.f279i = new ProgressDialog(this.f277g);
        this.f279i.setMessage(App.m435a(R.string.downloading));
        this.f279i.setProgressStyle(1);
        this.f279i.setCancelable(false);
        this.f279i.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(String str) {
        try {
            if (this.f279i != null) {
                this.f279i.dismiss();
            }
        } catch (Exception unused) {
            C0101l.m543a(R.string.error, true);
        }
        App.m449d(this.f277g);
        if (this.f280j == -1) {
            C0101l.m542a(R.string.error, R.string.net_error, this.f277g != null ? this.f277g : App.m434a());
        }
        if (this.f280j >= 0) {
            if (this.f281k != null) {
                PreferenceManager.getDefaultSharedPreferences(this.f277g).edit().putBoolean(this.f281k, true).apply();
                this.f278h.setChecked(true);
            }
            if (this.f274d > 0) {
                m327b();
            }
            AsyncTaskC0066g.f302b = true;
        }
        this.f277g = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(String... strArr) {
        if (this.f279i == null) {
            return;
        }
        this.f279i.setProgress(Integer.parseInt(strArr[0]));
        if (strArr.length > 1) {
            this.f279i.setMessage(strArr[1]);
        }
    }

    /* renamed from: b */
    public void m327b() {
        HashSet hashSet = new HashSet();
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.f277g);
        for (int i2 = 1; i2 <= C0375o.m1268a(); i2++) {
            if (defaultSharedPreferences.getBoolean(m315a(i2), false)) {
                hashSet.add(Integer.valueOf(i2));
            }
        }
        File[] listFiles = new File(C0101l.m537a("vmp")).listFiles();
        if (listFiles != null) {
            for (File file : listFiles) {
                // String substring = ...;
                // ArrayList<Integer> m1273b = ...;
                boolean z = true;
                if (z) {
                    file.delete();
                    // new File(...substring...).delete();
                }
            }
        }
    }

    @Override // android.os.AsyncTask
    protected void onPreExecute() {
        super.onPreExecute();
        App.m447c(this.f277g);
    }
}
