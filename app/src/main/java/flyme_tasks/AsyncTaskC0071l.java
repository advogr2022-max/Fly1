package flyme_tasks;

import android.content.Intent;
import android.os.AsyncTask;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0095f;
import com.xcglobe.xclog.C0099j;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/* renamed from: b.l */
/* loaded from: classes.dex */
public class AsyncTaskC0071l extends AsyncTask<Void, Void, Integer> {

    /* renamed from: c */
    private static long f323c = 0;

    /* renamed from: d */
    private static boolean f324d = false;

    /* renamed from: a */
    String f325a = null;

    /* renamed from: b */
    String f326b;

    /* renamed from: a */
    public static String m371a(String str) {
        byte[] bArr = new byte[str.length() / 2];
        int i2 = 0;
        int i3 = 1103515244;
        int i4 = 0;
        while (i2 < str.length()) {
            i3 = (i3 * 1103515245) + 12345;
            int i5 = i2 + 2;
            bArr[i4] = (byte) (Integer.parseInt(str.substring(i2, i5), 16) ^ (i3 % 255));
            i4++;
            i2 = i5;
        }
        return new String(bArr);
    }

    /* renamed from: a */
    public static void m372a() {
        if (f324d || System.currentTimeMillis() - f323c <= 86400000) {
            return;
        }
        new AsyncTaskC0071l().execute(new Void[0]);
    }

    /* renamed from: b */
    public static void m373b() {
        f323c = 0L;
        f324d = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(Void... voidArr) {
        this.f326b = C0095f.m486o() + "flyme/vercheck?" + C0095f.m465a(null, true);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            URLConnection openConnection = new URL(this.f326b).openConnection();
            openConnection.connect();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(openConnection.getInputStream());
            byte[] bArr = new byte[1024];
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
            bufferedInputStream.close();
            this.f325a = byteArrayOutputStream.toString();
            byteArrayOutputStream.close();
            f323c = System.currentTimeMillis();
        } catch (IOException unused) {
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        String str;
        String str2;
        String m371a;
        f324d = false;
        if (this.f325a == null) {
            return;
        }
        String[] split = this.f325a.split("\n");
        for (int i2 = 0; i2 < split.length; i2++) {
            if (split[i2].startsWith("first_run_time:")) {
                Long valueOf = Long.valueOf(Long.parseLong(split[i2].substring(15)));
                if (valueOf.longValue() > 0) {
                    C0095f.m467a(valueOf.longValue());
                }
            } else {
                int i3 = 12;
                if (split[i2].startsWith("save_serial:")) {
                    C0095f.m468a(split[i2].substring(12));
                } else {
                    if (split[i2].startsWith("licence_release_time:")) {
                        str = "install_licence_release_time";
                        str2 = split[i2];
                        i3 = 21;
                    } else if (split[i2].startsWith("licence_ready:")) {
                        str = "install_licence_ready";
                        str2 = split[i2];
                        i3 = 14;
                    } else {
                        if (split[i2].startsWith("latest_version:")) {
                            str = "install_latest_version";
                            m371a = split[i2].substring(15);
                        } else if (split[i2].startsWith("flyme_email_psw:")) {
                            str = "flyme_email_psw";
                            m371a = m371a(split[i2].substring(16));
                        } else if (split[i2].startsWith("flyme_email:")) {
                            str = "flyme_email";
                            str2 = split[i2];
                        } else if (split[i2].startsWith("use_private_dir:")) {
                            C0099j.m517a("use_private_dir", split[i2].substring(16).equals("1") ? 1 : 0);
                        }
                        C0099j.m527d(str, m371a);
                    }
                    m371a = str2.substring(i3);
                    C0099j.m527d(str, m371a);
                }
            }
        }
        Intent intent = new Intent("com.xcglobe.action.main");
        intent.putExtra("event", 15);
        App.m443b().sendBroadcast(intent);
    }
}
