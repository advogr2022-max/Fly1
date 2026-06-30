package flyme_tasks;

import android.os.AsyncTask;
import com.xcglobe.xclog.ActivityMain;
import com.xcglobe.xclog.C0101l;
import types.C0361a;
import types.C0369i;
import vmaps.C0379a;

/* renamed from: b.b */
/* loaded from: classes.dex */
public class AsyncTaskC0061b extends AsyncTask<Void, Void, Integer> {

    /* renamed from: d */
    public static int f253d;

    /* renamed from: e */
    static int f254e;

    /* renamed from: f */
    static float f255f;

    /* renamed from: g */
    static float f256g;

    /* renamed from: a */
    float f257a;

    /* renamed from: b */
    float f258b;

    /* renamed from: c */
    C0361a f259c = new C0361a();

    protected AsyncTaskC0061b(float f2, float f3) {
        this.f257a = f2;
        this.f258b = f3;
    }

    /* renamed from: a */
    public static void m308a(float f2, float f3, boolean z) {
        if (z || C0369i.m1248b(f2, f3, f255f, f256g) >= 1.0f) {
            f255f = f2;
            f256g = f3;
            new AsyncTaskC0061b(f2, f3).execute(new Void[0]);
            f253d++;
            f254e++;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(Void... voidArr) {
        try {
            this.f259c.m1179a(this.f257a, this.f258b);
        } catch (Exception e2) {
            this.f259c = null;
            C0101l.m547a("AirLoader.doInBackground", e2.getMessage());
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        if (this.f259c != null) {
            C0379a.m1302a(this.f259c);
            this.f259c = null;
            ActivityMain.m413a(10);
        }
        f254e--;
    }
}
