package flyme_dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0095f;
import com.xcglobe.xclog.C0101l;

/* renamed from: f.b */
/* loaded from: classes.dex */
public class DialogC0196b extends Dialog {

    /* renamed from: a */
    App f962a;

    /* renamed from: b */
    Dialog f963b;

    /* renamed from: c */
    Activity f964c;

    public DialogC0196b(Context context) {
        super(context);
    }

    /* renamed from: a */
    private void m831a() {
        setContentView(R.layout.dialog_enter_licence);
        setTitle(R.string.enter_licence);
        final EditText editText = (EditText) findViewById(R.id.licence_key);
        ((Button) findViewById(R.id.butOk)).setOnClickListener(new View.OnClickListener() { // from class: f.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    String trim = editText.getText().toString().trim();
                    if (C0095f.m471b(trim)) {
                        C0095f.m468a(trim);
                        Intent intent = new Intent("com.xcglobe.action.main");
                        intent.putExtra("event", 15);
                        DialogC0196b.this.f964c.sendBroadcast(intent);
                    } else {
                        C0101l.m545a(DialogC0196b.this.f964c, App.m435a(R.string.error), App.m435a(R.string.wrong_serial), false);
                    }
                } catch (Exception unused) {
                }
                App app = DialogC0196b.this.f962a;
                App.m445b(DialogC0196b.this.f963b);
            }
        });
        App app = this.f962a;
        App.m437a(this, 80);
    }

    /* renamed from: a */
    public static void m832a(Activity activity) {
        DialogC0196b dialogC0196b = new DialogC0196b(activity);
        dialogC0196b.f962a = (App) activity.getApplication();
        dialogC0196b.f963b = dialogC0196b;
        dialogC0196b.f964c = activity;
        dialogC0196b.m831a();
    }
}
