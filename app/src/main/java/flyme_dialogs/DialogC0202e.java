package flyme_dialogs;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TimePicker;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import configs.ActivityConfigTask;
import flyme_poi.C0227a;

/* renamed from: f.e */
/* loaded from: classes.dex */
public class DialogC0202e extends Dialog {

    /* renamed from: a */
    C0227a f1037a;

    /* renamed from: b */
    ActivityConfigTask f1038b;

    public DialogC0202e(Context context) {
        super(context);
    }

    /* renamed from: a */
    private void m864a() {
        setContentView(R.layout.dialog_task_start);
        setTitle(R.string.task_start);
        final TimePicker timePicker = (TimePicker) findViewById(R.id.dlg_task_start_time);
        timePicker.setIs24HourView(true);
        timePicker.setCurrentHour(Integer.valueOf(this.f1037a.f1281e.hour));
        timePicker.setCurrentMinute(Integer.valueOf(this.f1037a.f1281e.minute));
        final Spinner spinner = (Spinner) findViewById(R.id.dlg_task_start_mode);
        spinner.setSelection(1 ^ (this.f1037a.f1280d ? 1 : 0));
        final App app = (App) this.f1038b.getApplication();
        ((Button) findViewById(R.id.dialogTaskStartOK)).setOnClickListener(new View.OnClickListener() { // from class: f.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    DialogC0202e.this.f1037a.f1281e.hour = timePicker.getCurrentHour().intValue();
                    DialogC0202e.this.f1037a.f1281e.minute = timePicker.getCurrentMinute().intValue();
                    DialogC0202e.this.f1037a.f1280d = spinner.getSelectedItemPosition() == 0;
                    DialogC0202e.this.f1038b.m590a();
                    DialogC0202e.this.f1038b.m594b();
                } catch (Exception unused) {
                }
                App app2 = app;
                App.m445b(DialogC0202e.this);
            }
        });
        App.m437a(this, 80);
    }

    /* renamed from: a */
    public static void m865a(ActivityConfigTask activityConfigTask, C0227a c0227a) {
        DialogC0202e dialogC0202e = new DialogC0202e(activityConfigTask);
        dialogC0202e.f1037a = c0227a;
        dialogC0202e.f1038b = activityConfigTask;
        dialogC0202e.m864a();
    }
}
