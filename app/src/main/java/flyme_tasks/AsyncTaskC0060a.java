package flyme_tasks;

import android.os.AsyncTask;
import com.xcglobe.xclog.C0099j;
import com.xcglobe.xclog.C0101l;
import java.io.File;
import java.util.ArrayList;
import flyme_fileutil.C0000a;
import flyme_data.C0239g;
import types.GpsVal;

/* renamed from: b.a */
/* loaded from: classes.dex */
public class AsyncTaskC0060a extends AsyncTask<Void, Void, Integer> {

    /* renamed from: a */
    public static int f252a;

    /* renamed from: a */
    public static void m304a() {
        AsyncTaskC0060a asyncTaskC0060a = new AsyncTaskC0060a();
        f252a++;
        asyncTaskC0060a.execute(new Void[0]);
    }

    /* renamed from: a */
    public static void m305a(String str) {
        new File(C0101l.m537a("Openair/" + str)).delete();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Integer doInBackground(Void... voidArr) {
        String m537a = C0101l.m537a("Openair");
        File file = new File(m537a);
        if (!file.isDirectory()) {
            return 0;
        }
        File[] listFiles = file.listFiles();
        ArrayList<String> arrayList = new ArrayList<>();
        for (File file2 : listFiles) {
            String name = file2.getName();
            if (C0099j.f512a.getBoolean("openair_checked_" + name, false)) {
                arrayList.add(m537a + "/" + name);
            }
        }
        new C0000a(null).m3a(arrayList, C0101l.m537a("air/openair-"));
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(Integer num) {
        GpsVal m1073d = C0239g.m1073d();
        AsyncTaskC0061b.m308a(m1073d.f1972a, m1073d.f1973b, true);
        f252a--;
    }
}
