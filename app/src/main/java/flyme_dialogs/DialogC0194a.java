package flyme_dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0101l;
import java.text.DecimalFormat;
import flyme_data.C0239g;
import types.C0377q;
import types.GpsVal;
import types.PoiPoint;

/* renamed from: f.a */
/* loaded from: classes.dex */
public class DialogC0194a extends Dialog {

    /* renamed from: a */
    Activity f953a;

    /* renamed from: b */
    PoiPoint f954b;

    /* renamed from: c */
    a f955c;

    /* renamed from: d */
    EditText f956d;

    /* renamed from: e */
    EditText f957e;

    /* renamed from: f */
    EditText f958f;

    /* renamed from: g */
    EditText f959g;

    /* renamed from: f.a$a */
    /* loaded from: classes.dex */
    public interface a {
        void call(PoiPoint poiPoint);
    }

    private DialogC0194a(Context context) {
        super(context);
        this.f954b = new PoiPoint();
        this.f953a = (Activity) context;
    }

    /* renamed from: a */
    private void m827a() {
        setContentView(R.layout.dialog_editpoint);
        setTitle(R.string.point_editor);
        ((TextView) findViewById(R.id.dlg_editpoint_elev_label)).setText(App.m435a(R.string.elevation) + " [" + C0377q.f2083b + "]");
        this.f956d = (EditText) findViewById(R.id.dlg_editpoint_latitude);
        this.f957e = (EditText) findViewById(R.id.dlg_editpoint_longitude);
        this.f958f = (EditText) findViewById(R.id.dlg_editpoint_altitude);
        this.f959g = (EditText) findViewById(R.id.dlg_editpoint_point_name);
        DecimalFormat decimalFormat = new DecimalFormat("0.00000");
        this.f956d.setText(decimalFormat.format(this.f954b.f1976i));
        this.f957e.setText(decimalFormat.format(this.f954b.f1977j));
        this.f958f.setText(String.valueOf(C0377q.m1287e(this.f954b.f1978k)));
        this.f959g.setText(this.f954b.f1979l);
        ((Button) findViewById(R.id.dialogPointEditButtonOK)).setOnClickListener(new View.OnClickListener() { // from class: f.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                try {
                    DialogC0194a.this.f954b.f1979l = DialogC0194a.this.f959g.getText().toString();
                    DialogC0194a.this.f954b.f1978k = (short) C0377q.m1288f(Short.parseShort(DialogC0194a.this.f958f.getText().toString()));
                    DialogC0194a.this.f954b.f1976i = C0101l.m573i(DialogC0194a.this.f956d.getText().toString().replace(',', '.'));
                    DialogC0194a.this.f954b.f1977j = C0101l.m573i(DialogC0194a.this.f957e.getText().toString().replace(',', '.'));
                    DialogC0194a.this.f955c.call(DialogC0194a.this.f954b);
                } catch (Exception unused) {
                }
                DialogC0194a.this.dismiss();
            }
        });
        ((Button) findViewById(R.id.dialogPointEditButtonCancel)).setOnClickListener(new View.OnClickListener() { // from class: f.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogC0194a.this.dismiss();
            }
        });
        show();
    }

    /* renamed from: a */
    public static void m828a(Activity activity, PoiPoint poiPoint, a aVar) {
        DialogC0194a dialogC0194a = new DialogC0194a(activity);
        dialogC0194a.f955c = aVar;
        if (poiPoint != null) {
            dialogC0194a.f954b.m1171a(poiPoint);
        } else {
            GpsVal m1073d = C0239g.m1073d();
            dialogC0194a.f954b.f1976i = m1073d.f1972a;
            dialogC0194a.f954b.f1977j = m1073d.f1973b;
            dialogC0194a.f954b.f1978k = (short) C0239g.f1426s;
            PoiPoint poiPoint2 = dialogC0194a.f954b;
            StringBuilder sb = new StringBuilder();
            sb.append(C0101l.f582g);
            int i2 = C0101l.f583h + 1;
            C0101l.f583h = i2;
            sb.append(i2);
            poiPoint2.f1979l = sb.toString();
        }
        dialogC0194a.m827a();
    }
}
