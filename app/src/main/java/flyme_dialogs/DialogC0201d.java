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

/* renamed from: f.d */
/* loaded from: classes.dex */
public class DialogC0201d extends Dialog {

    /* renamed from: a */
    C0227a f1030a;

    /* renamed from: b */
    ActivityConfigTask f1031b;

    public DialogC0201d(Context context) {
        super(context);
    }

    /* renamed from: a */
    private void m862a() {
        setContentView(R.layout.dialog_task_end);
        setTitle(R.string.task_end);
        final TimePicker timePicker = (TimePicker) findViewById(R.id.dlg_task_end_time);
        timePicker.setIs24HourView(true);
        timePicker.setCurrentHour(Integer.valueOf(this.f1030a.f1282f.hour));
        timePicker.setCurrentMinute(Integer.valueOf(this.f1030a.f1282f.minute));
        final Spinner spinner = (Spinner) findViewById(R.id.dlg_task_goal_type);
        spinner.setSelection(1 ^ (this.f1030a.f1289m ? 1 : 0));
        final App app = (App) this.f1031b.getApplication();
        ((Button) findViewById(R.id.dialogTaskStartOK)).setOnClickListener(new View.OnClickListener() { // from class: f.d.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    DialogC0201d.this.f1030a.f1282f.hour = timePicker.getCurrentHour().intValue();
                    DialogC0201d.this.f1030a.f1282f.minute = timePicker.getCurrentMinute().intValue();
                    DialogC0201d.this.f1030a.f1289m = spinner.getSelectedItemPosition() == 0;
                    DialogC0201d.this.f1031b.m590a();
                    DialogC0201d.this.f1031b.m594b();
                } catch (Exception unused) {
                }
                App app2 = app;
                App.m445b(DialogC0201d.this);
                DialogC0201d.this.dismiss();
            }
        });
        App.m437a(this, 80);
    }

    /* renamed from: a */
    public static void m863a(ActivityConfigTask activityConfigTask, C0227a c0227a) {
        DialogC0201d dialogC0201d = new DialogC0201d(activityConfigTask);
        dialogC0201d.f1030a = c0227a;
        dialogC0201d.f1031b = activityConfigTask;
        dialogC0201d.m862a();
    }
}
