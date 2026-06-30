package flyme_tasks;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0101l;
import display.vmap.ViewVmp;
import flyme_apphelper.C0072a;
import flyme_poi.C0227a;
import flyme_poi.C0228b;

/* renamed from: b.i */
/* loaded from: classes.dex */
public class AsyncTaskC0068i extends AsyncTask<Void, String, Boolean> {

    /* renamed from: a */
    private ProgressDialog f309a;

    /* renamed from: a */
    public static void m355a(Activity activity) {
        AsyncTaskC0068i asyncTaskC0068i = new AsyncTaskC0068i();
        asyncTaskC0068i.m357a();
        asyncTaskC0068i.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Void... voidArr) {
        Thread.currentThread().setPriority(10);
        C0227a.f1276a.m998a(new C0228b().m1011a(C0227a.f1276a));
        return null;
    }

    /* renamed from: a */
    public void m357a() {
        this.f309a = new ProgressDialog(App.m434a());
        this.f309a.setMessage(App.m435a(R.string.building_task_demo));
        this.f309a.setProgressStyle(0);
        this.f309a.setCancelable(false);
        this.f309a.show();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Boolean bool) {
        this.f309a.dismiss();
        C0072a.m377a("demo-task.igc");
        ViewVmp.setFlag(32);
        C0101l.m566e();
    }
}
