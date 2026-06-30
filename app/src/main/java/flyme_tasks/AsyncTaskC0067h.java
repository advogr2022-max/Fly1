package flyme_tasks;

import android.media.SoundPool;
import android.os.AsyncTask;
import com.xcglobe.xclog.App;

/* renamed from: b.h */
/* loaded from: classes.dex */
public class AsyncTaskC0067h extends AsyncTask<Void, String, Boolean> {

    /* renamed from: a */
    static float f307a = 1.0f;

    /* renamed from: b */
    int f308b;

    /* renamed from: a */
    public static void m353a(int i2) {
        AsyncTaskC0067h asyncTaskC0067h = new AsyncTaskC0067h();
        asyncTaskC0067h.f308b = i2;
        asyncTaskC0067h.execute(new Void[0]);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.os.AsyncTask
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(Void... voidArr) {
        try {
            SoundPool soundPool = new SoundPool(1, 3, 0);
            int load = soundPool.load(App.m443b(), this.f308b, 1);
            for (int i2 = 0; i2 < 3; i2++) {
                Thread.sleep(100L);
                if (soundPool.play(load, f307a, f307a, 0, 0, 1.0f) != 0) {
                    break;
                }
            }
            Thread.sleep(2000L);
            soundPool.release();
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
