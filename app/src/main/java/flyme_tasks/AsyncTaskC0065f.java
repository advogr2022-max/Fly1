package flyme_tasks;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0095f;
import com.xcglobe.xclog.C0099j;
import com.xcglobe.xclog.C0101l;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

/* renamed from: b.f */
/* loaded from: classes.dex */
public class AsyncTaskC0065f extends AsyncTask<Void, Void, Void> {

    /* renamed from: a */
    private ProgressDialog f291a;

    /* renamed from: c */
    private String f293c;

    /* renamed from: d */
    private String f294d;

    /* renamed from: e */
    private String f295e;

    /* renamed from: f */
    private String f296f;

    /* renamed from: g */
    private boolean f297g;

    /* renamed from: h */
    private String f298h;

    /* renamed from: i */
    @SuppressLint({"StaticFieldLeak"})
    private Activity f299i;

    /* renamed from: b */
    private boolean f292b = false;

    /* renamed from: j */
    private boolean f300j = false;

    /* renamed from: a */
    public static void m332a(Activity activity, String str, String str2, String str3, String str4, boolean z) {
        final AsyncTaskC0065f asyncTaskC0065f = new AsyncTaskC0065f();
        asyncTaskC0065f.f299i = activity;
        asyncTaskC0065f.f293c = str;
        asyncTaskC0065f.f294d = str2;
        asyncTaskC0065f.f295e = str3;
        asyncTaskC0065f.f296f = str4;
        asyncTaskC0065f.f297g = z;
        asyncTaskC0065f.f291a = new ProgressDialog(activity);
        asyncTaskC0065f.f291a.setMessage(App.m435a(R.string.sending_mail));
        asyncTaskC0065f.f291a.setButton(-2, App.m435a(R.string.cancel), new DialogInterface.OnClickListener() { // from class: b.-$$Lambda$f$g3OIEic_fbYioHIe2Pxf7RypXwU
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i2) {
                AsyncTaskC0065f.m333a(null, dialogInterface, i2);
            }
        });
        App.m447c(activity);
        asyncTaskC0065f.f291a.show();
        asyncTaskC0065f.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m333a(AsyncTaskC0065f asyncTaskC0065f, DialogInterface dialogInterface, int i2) {
        asyncTaskC0065f.f292b = true;
        asyncTaskC0065f.f291a.dismiss();
        asyncTaskC0065f.cancel(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Void doInBackground(Void... voidArr) {
        try {
            this.f300j = m336a();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        } catch (Throwable e3) {
            e3.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Void r4) {
        if (this.f298h != null) {
            new File(this.f298h).delete();
        }
        try {
            this.f291a.dismiss();
            C0101l.m545a(this.f299i, App.m435a(R.string.send_to_email), App.m435a(this.f300j ? R.string.mail_sent_ok : R.string.mail_sent_err), this.f300j);
        } catch (Exception unused) {
            C0101l.m543a(R.string.error, true);
        }
        AsyncTaskC0071l.m372a();
        App.m449d(this.f299i);
        this.f299i = null;
    }

    /* renamed from: a */
    boolean m336a() {
        this.f298h = this.f297g ? m338c() : m337b();
        HashMap hashMap = new HashMap();
        hashMap.put("igc", this.f298h);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("message", this.f294d + "\n\n" + C0099j.m515a("user.fullname"));
        hashMap2.put("mailto", this.f293c);
        return "ok".equals(C0101l.m539a(C0095f.m486o() + "fly/mail-igc", (HashMap<String, String>) hashMap2, (HashMap<String, String>) hashMap));
    }

    /* renamed from: b */
    String m337b() {
        String str = C0101l.m558c() + "/" + this.f295e;
        String m537a = C0101l.m537a("temp");
        new File(m537a).mkdirs();
        String str2 = m537a + "/" + this.f296f;
        C0101l.m564d(str, str2);
        return str2;
    }

    /* renamed from: c */
    String m338c() {
        String str = C0101l.m558c() + "/" + this.f295e;
        String m537a = C0101l.m537a("temp");
        new File(m537a).mkdirs();
        String str2 = m537a + "/" + this.f296f + ".zip";
        try { C0101l.m550a(new String[]{str}, str2); } catch (IOException e) { }
        return str2;
    }
}
