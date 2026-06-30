package mymenu;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.C0101l;
import java.util.ArrayList;

/* renamed from: mymenu.a */
/* loaded from: classes.dex */
public class DialogC0241a extends Dialog {

    /* renamed from: c */
    Context f1490c;

    /* renamed from: d */
    String f1491d;

    /* renamed from: e */
    MenuListView f1492e;

    /* renamed from: f */
    public int f1493f;

    /* renamed from: g */
    ArrayList<C0243c> f1494g;

    /* renamed from: h */
    int f1495h;

    /* renamed from: i */
    int f1496i;

    /* renamed from: j */
    int f1497j;

    public DialogC0241a(Context context, String str) {
        super(context);
        this.f1491d = "Menu";
        this.f1493f = R.layout.dialog_menu_row_simple;
        this.f1494g = new ArrayList<>();
        this.f1495h = (int) (C0101l.f574ax * 0.9f);
        this.f1496i = -2;
        this.f1497j = 0;
        this.f1490c = context;
        this.f1491d = str;
        if (str == null) {
            requestWindowFeature(1);
        }
        setContentView(R.layout.dialog_menu);
        m1097b();
    }

    /* renamed from: b */
    private void m1097b() {
        setCanceledOnTouchOutside(true);
        this.f1492e = (MenuListView) findViewById(R.id.listView1);
    }

    /* renamed from: a */
    public void m1098a() {
        final C0242b c0242b = new C0242b(this.f1490c, this.f1493f, (C0243c[]) this.f1494g.toArray(new C0243c[0]));
        c0242b.f1504d = this;
        this.f1492e.m1096a(c0242b);
        this.f1492e.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: mymenu.a.1
            @Override // android.widget.AdapterView.OnItemClickListener
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                if (c0242b.f1503c[i2].f1505a != 0) {
                    /* this.dismiss(); */
                }
            }
        });
        setTitle(this.f1491d);
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        layoutParams.copyFrom(getWindow().getAttributes());
        layoutParams.width = this.f1495h;
        layoutParams.height = this.f1496i;
        show();
        getWindow().setAttributes(layoutParams);
        this.f1492e.m1095a();
    }

    /* renamed from: a */
    public void m1099a(int i2, int i3) {
        if (i2 != 0) {
            this.f1495h = i2;
        }
        if (i3 != 0) {
            this.f1496i = i3;
        }
    }

    /* renamed from: a */
    public void m1100a(int i2, String str) {
        C0243c c0243c = new C0243c();
        c0243c.f1505a = i2;
        c0243c.f1506b = str;
        this.f1494g.add(c0243c);
    }

    /* renamed from: a */
    public boolean mo588a(int i2) {
        return true;
    }

    /* renamed from: b */
    public void m1101b(int i2) {
        this.f1492e.f1487d = i2;
    }
}
