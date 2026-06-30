package flyme_tasks;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.ActivityMain;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0101l;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/* renamed from: b.e */
/* loaded from: classes.dex */
public class AsyncTaskC0064e extends AsyncTask<Void, String, Void> {

    /* renamed from: a */
    ProgressDialog f282a;

    /* renamed from: b */
    boolean f283b = false;

    /* renamed from: c */
    String f284c = null;

    /* renamed from: d */
    String f285d;

    /* renamed from: e */
    String f286e;

    /* renamed from: f */
    String f287f;

    /* renamed from: g */
    boolean f288g;

    /* renamed from: a */
    private static String m328a(String str) {
        int indexOf = str.indexOf(63);
        int indexOf2 = str.indexOf(35);
        if (indexOf2 != -1 && indexOf2 < indexOf) {
            indexOf = indexOf2;
        }
        if (indexOf != -1) {
            str = str.substring(0, indexOf);
        }
        return str.substring(str.lastIndexOf(47) + 1);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        try {
            URLConnection openConnection = new URL(this.f285d).openConnection();
            openConnection.connect();
            this.f287f = this.f286e + m328a(this.f285d);
            new File(this.f287f).getParentFile().mkdirs();
            int contentLength = openConnection.getContentLength();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(openConnection.getInputStream());
            FileOutputStream fileOutputStream = new FileOutputStream(this.f287f);
            byte[] bArr = new byte[1024];
            long j2 = 0;
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    bufferedInputStream.close();
                    publishProgress("0", App.m435a(R.string.uploaded));
                    this.f284c = App.m435a(R.string.uploaded_ok);
                    this.f288g = true;
                    return null;
                }
                j2 += read;
                publishProgress("" + ((int) ((100 * j2) / contentLength)));
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (IOException unused) {
            this.f284c = App.m435a(R.string.net_error);
            return null;
        }
    }

    /* renamed from: a */
    public void m330a(String str, String str2) {
        this.f288g = false;
        this.f286e = str;
        this.f285d = str2;
        this.f282a = new ProgressDialog(App.m434a());
        this.f282a.setMessage(App.m435a(R.string.downloading));
        this.f282a.setButton(-2, App.m435a(R.string.cancel), new DialogInterface.OnClickListener() { // from class: b.e.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                // this.f283b = true;
                // this.f282a.dismiss();
                // this.cancel(true);
            }
        });
        this.f282a.show();
        execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r4) {
        C0101l.m545a(App.m434a(), App.m435a(R.string.download), this.f284c, false);
        // this.f282a.dismiss();
        if (this.f288g) {
            Bundle bundle = new Bundle();
            bundle.putString("url", this.f285d);
            bundle.putString("file", this.f287f);
            ActivityMain.m415a(26, bundle);
        }
    }
}
