package flyme_dialogs;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import com.xcglobe.xclog.ActivityFlights;
import com.xcglobe.xclog.ActivityPocket;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0099j;
import com.xcglobe.xclog.C0101l;
import com.xcglobe.xclog.FlyMeService;
import configs.ActivityConfig;
import display.ViewSwipeButton;
import display.vmap.ViewVmp;
import display.vmap.VmpEditor;
import flyme_apphelper.C0072a;
import flyme_dialogs.flyme_dialogs_b.DialogC0198b;
import flyme_data.C0238f;
import flyme_data.C0239g;
import types.C0366f;
import types.PoiPoint;

/* renamed from: f.c */
/* loaded from: classes.dex */
public class DialogC0200c extends Dialog {

    /* renamed from: a */
    Activity f1010a;

    /* renamed from: b */
    App f1011b;

    /* renamed from: c */
    Dialog f1012c;

    public DialogC0200c(Context context) {
        super(context);
    }

    /* renamed from: a */
    public static void m856a(Activity activity, ViewVmp viewVmp) {
        DialogC0200c dialogC0200c = new DialogC0200c(activity);
        dialogC0200c.f1011b = (App) activity.getApplication();
        dialogC0200c.f1012c = dialogC0200c;
        dialogC0200c.f1010a = activity;
        dialogC0200c.m859b(viewVmp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m858b() {
        if (C0238f.m1059d()) {
            new AlertDialog.Builder(this.f1010a).setIcon(R.drawable.ic_dialog_alert).setTitle(com.xcglobe.flyme.R.string.stop_recording).setMessage(com.xcglobe.flyme.R.string.sure_stop_recording).setPositiveButton(com.xcglobe.flyme.R.string.yes, new DialogInterface.OnClickListener() { // from class: f.c.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i2) {
                    C0239g.m1066a((String) null);
                    App app = DialogC0200c.this.f1011b;
                    App.m445b((Dialog) dialogInterface);
                    App.m442a(false);
                    DialogC0200c.this.f1010a.finish();
                }
            }).setNegativeButton(com.xcglobe.flyme.R.string.no, (DialogInterface.OnClickListener) null).show();
        } else {
            App.m442a(false);
            this.f1010a.finish();
        }
    }

    /* renamed from: b */
    private void m859b(final ViewVmp viewVmp) {
        requestWindowFeature(1);
        setContentView(com.xcglobe.flyme.R.layout.dialog_flymenu);
        setCanceledOnTouchOutside(true);
        ViewSwipeButton viewSwipeButton = (ViewSwipeButton) findViewById(com.xcglobe.flyme.R.id.swipeBoxes);
        viewSwipeButton.title = App.m435a(com.xcglobe.flyme.R.string.info_boxes);
        viewSwipeButton.changeDimensions();
        ViewSwipeButton viewSwipeButton2 = (ViewSwipeButton) findViewById(com.xcglobe.flyme.R.id.swipe2);
        viewSwipeButton2.add(1, "1", com.xcglobe.flyme.R.drawable.size1);
        viewSwipeButton2.add(2, "2", com.xcglobe.flyme.R.drawable.size2);
        viewSwipeButton2.add(3, "3", com.xcglobe.flyme.R.drawable.size3);
        viewSwipeButton2.add(4, "4", com.xcglobe.flyme.R.drawable.size4);
        viewSwipeButton2.add(5, "5", com.xcglobe.flyme.R.drawable.size5);
        viewSwipeButton2.title = App.m435a(com.xcglobe.flyme.R.string.infoboxes_size);
        viewSwipeButton2.select(C0101l.f561ak);
        viewSwipeButton2.changeDimensions();
        viewSwipeButton2.setCallback(new ViewSwipeButton.Callback() { // from class: f.c.1
            @Override // display.ViewSwipeButton.Callback
            public void call(int i2) {
                C0101l.f561ak = i2;
                C0099j.m517a("infoboxes_size", i2);
                viewVmp.initDisplay();
            }
        });
        findViewById(com.xcglobe.flyme.R.id.btnAddBox).setOnClickListener(new View.OnClickListener() { // from class: f.c.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                new VmpEditor(viewVmp).addBox();
            }
        });
        findViewById(com.xcglobe.flyme.R.id.btnRemoveBoxes).setOnClickListener(new View.OnClickListener() { // from class: f.c.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogC0200c.this.m861a(viewVmp);
            }
        });
        findViewById(com.xcglobe.flyme.R.id.buttonSettings).setOnClickListener(new View.OnClickListener() { // from class: f.c.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogC0200c.this.f1010a.startActivity(new Intent(DialogC0200c.this.f1010a, (Class<?>) ActivityConfig.class));
                App app = DialogC0200c.this.f1011b;
                App.m445b(DialogC0200c.this.f1012c);
                DialogC0200c.this.dismiss();
            }
        });
        findViewById(com.xcglobe.flyme.R.id.buttonPocket).setOnClickListener(new View.OnClickListener() { // from class: f.c.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogC0200c.this.f1010a.startActivity(new Intent(DialogC0200c.this.f1010a, (Class<?>) ActivityPocket.class));
                App app = DialogC0200c.this.f1011b;
                App.m445b(DialogC0200c.this.f1012c);
                DialogC0200c.this.dismiss();
            }
        });
        findViewById(com.xcglobe.flyme.R.id.buttonGoal).setOnClickListener(new View.OnClickListener() { // from class: f.c.9
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogC0200c.this.m860a();
                App app = DialogC0200c.this.f1011b;
                App.m445b(DialogC0200c.this.f1012c);
                DialogC0200c.this.dismiss();
            }
        });
        findViewById(com.xcglobe.flyme.R.id.btnQuit).setOnClickListener(new View.OnClickListener() { // from class: f.c.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogC0200c.this.m858b();
            }
        });
        Button button = (Button) findViewById(com.xcglobe.flyme.R.id.btnStartRecording);
        if (C0101l.f559ai != 4 || C0238f.m1059d()) {
            button.setVisibility(8);
        } else {
            if (!C0239g.m1076g() || !C0239g.f1433z) {
                button.setText(FlyMeService.f467c);
                button.setEnabled(false);
            }
            button.setOnClickListener(new View.OnClickListener() { // from class: f.c.11
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    C0238f.m1057b();
                    App app = DialogC0200c.this.f1011b;
                    App.m445b(DialogC0200c.this.f1012c);
                    DialogC0200c.this.dismiss();
                }
            });
        }
        Button button2 = (Button) findViewById(com.xcglobe.flyme.R.id.buttonMulti);
        final boolean m1059d = true ^ C0238f.m1059d();
        button2.setText(m1059d ? com.xcglobe.flyme.R.string.saved_flights : C0072a.m378a() ? com.xcglobe.flyme.R.string.stop_player : com.xcglobe.flyme.R.string.stop_recording);
        button2.setOnClickListener(new View.OnClickListener() { // from class: f.c.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (m1059d) {
                    DialogC0200c.this.f1010a.startActivity(new Intent(DialogC0200c.this.f1010a, (Class<?>) ActivityFlights.class));
                } else if (C0072a.m378a()) {
                    C0072a.m380b();
                } else {
                    C0101l.m554b(DialogC0200c.this.f1010a);
                }
                App app = DialogC0200c.this.f1011b;
                App.m445b(DialogC0200c.this.f1012c);
                DialogC0200c.this.dismiss();
            }
        });
        App app = this.f1011b;
        App.m437a(this, -90);
    }

    /* renamed from: a */
    void m860a() {
        DialogC0198b.m833a(this.f1010a, C0239g.m1073d(), C0366f.f2003a, true, new DialogC0198b.a() { // from class: f.c.2
            @Override // flyme_dialogs.flyme_dialogs_b.DialogC0198b.a
            public void call(PoiPoint poiPoint) {
                C0366f.m1222a(poiPoint, false);
            }
        });
    }

    /* renamed from: a */
    void m861a(final ViewVmp viewVmp) {
        AlertDialog create = new AlertDialog.Builder(this.f1010a).setIcon(R.drawable.ic_dialog_alert).setMessage(com.xcglobe.flyme.R.string.sure_remove_boxes).setPositiveButton(com.xcglobe.flyme.R.string.yes, new DialogInterface.OnClickListener() { // from class: f.c.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i2) {
                new VmpEditor(viewVmp).removeAllBoxes();
                App app = DialogC0200c.this.f1011b;
                App.m445b((Dialog) dialogInterface);
            }
        }).setNegativeButton(com.xcglobe.flyme.R.string.no, (DialogInterface.OnClickListener) null).create();
        App app = this.f1011b;
        App.m436a(create);
    }

    @Override // android.app.Dialog
    public boolean onPrepareOptionsMenu(Menu menu) {
        App app = this.f1011b;
        App.m445b(this.f1012c);
        return false;
    }
}
