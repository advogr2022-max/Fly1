package flyme_tasks;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import androidx.core.content.FileProvider;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0101l;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;

/* renamed from: b.j */
/* loaded from: classes.dex */
public class AsyncTaskC0069j extends AsyncTask<Void, String, Boolean> {

    /* renamed from: a */
    String f310a;

    /* renamed from: b */
    String f311b;

    /* renamed from: c */
    private Activity f312c;

    /* renamed from: d */
    private ProgressDialog f313d;

    /* renamed from: a */
    public static void m359a(final Activity activity) {
        App.m436a(new AlertDialog.Builder(activity).setIcon(R.drawable.ic_dialog_alert).setTitle(com.xcglobe.flyme.R.string.ask_upgrade).setMessage("Since version 3.01 FlyMe is available on Google Play Store. Please uninstall this version and install the latest release from Play Store").setPositiveButton(com.xcglobe.flyme.R.string.yes, new DialogInterface.OnClickListener() { // from class: b.j.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                App.m445b((Dialog) dialogInterface);
                AsyncTaskC0069j.m360a((Context) activity);
            }
        }).setNegativeButton(com.xcglobe.flyme.R.string.no, (DialogInterface.OnClickListener) null).create());
    }

    /* renamed from: a */
    public static void m360a(Context context) {
        String packageName = context.getPackageName();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=" + packageName));
        boolean z = false;
        Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent, 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            ResolveInfo next = it.next();
            if (next.activityInfo.applicationInfo.packageName.equals("com.android.vending")) {
                ActivityInfo activityInfo = next.activityInfo;
                ComponentName componentName = new ComponentName(activityInfo.applicationInfo.packageName, activityInfo.name);
                intent.addFlags(268435456);
                intent.addFlags(2097152);
                intent.addFlags(67108864);
                intent.setComponent(componentName);
                context.startActivity(intent);
                z = true;
                break;
            }
        }
        if (z) {
            return;
        }
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)));
    }

    /* renamed from: a */
    public static void m361a(Context context, String str) {
        Intent intent;
        if (Build.VERSION.SDK_INT >= 24) {
            Uri m121a = Uri.fromFile( new File(str));
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.addFlags(1);
            intent2.setFlags(268435456);
            intent2.setDataAndType(m121a, "application/vnd.android.package-archive");
            Iterator<ResolveInfo> it = context.getPackageManager().queryIntentActivities(intent2, 65536).iterator();
            while (it.hasNext()) {
                context.grantUriPermission(it.next().activityInfo.packageName, m121a, 3);
            }
            intent = intent2;
        } else {
            File file = new File(str);
            intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(268435456);
            intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
        }
        context.startActivity(intent);
    }

    /* renamed from: a */
    private boolean m362a() {
        try {
            URLConnection openConnection = new URL(this.f310a).openConnection();
            openConnection.connect();
            int contentLength = openConnection.getContentLength();
            BufferedInputStream bufferedInputStream = new BufferedInputStream(openConnection.getInputStream());
            FileOutputStream fileOutputStream = new FileOutputStream(this.f311b);
            byte[] bArr = new byte[1024];
            long j2 = 0;
            while (true) {
                int read = bufferedInputStream.read(bArr);
                if (read == -1) {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    bufferedInputStream.close();
                    System.out.println("xxx: " + this.f311b + "\t isfile1: " + new File(this.f311b).isFile());
                    return true;
                }
                j2 += read;
                publishProgress("" + ((int) ((100 * j2) / contentLength)));
                fileOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Void... voidArr) {
        return Boolean.valueOf(m362a());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        try {
            if (this.f313d != null) {
                this.f313d.dismiss();
            }
        } catch (Exception unused) {
            C0101l.m543a(com.xcglobe.flyme.R.string.error, true);
        }
        if (bool.booleanValue()) {
            m361a(App.m443b(), this.f311b);
        } else {
            C0101l.m542a(com.xcglobe.flyme.R.string.error, com.xcglobe.flyme.R.string.net_error, this.f312c);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onProgressUpdate(String... strArr) {
        if (this.f313d == null) {
            return;
        }
        this.f313d.setProgress(Integer.parseInt(strArr[0]));
        if (strArr.length > 1) {
            this.f313d.setMessage(strArr[1]);
        }
    }
}
