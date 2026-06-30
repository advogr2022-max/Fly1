package mymenu;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.xcglobe.flyme.R;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: mymenu.b */
/* loaded from: classes.dex */
public class C0242b extends ArrayAdapter<C0243c> {

    /* renamed from: a */
    Context f1501a;

    /* renamed from: b */
    int f1502b;

    /* renamed from: c */
    C0243c[] f1503c;

    /* renamed from: d */
    DialogC0241a f1504d;

    public C0242b(Context context, int i2, C0243c[] c0243cArr) {
        super(context, i2, c0243cArr);
        this.f1503c = null;
        this.f1502b = i2;
        this.f1501a = context;
        this.f1503c = c0243cArr;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C0243c c0243c = this.f1503c[i2];
        if (view == null || c0243c.f1505a != ((Integer) view.getTag()).intValue()) {
            view = ((Activity) this.f1501a).getLayoutInflater().inflate(this.f1502b, viewGroup, false);
            view.setTag(Integer.valueOf(c0243c.f1505a));
        }
        TextView textView = (TextView) view.findViewById(R.id.dlg_menu_item_title);
        textView.setText(c0243c.f1506b);
        textView.setTag(Integer.valueOf(c0243c.f1505a));
        if (c0243c.f1505a == this.f1504d.f1492e.f1487d) {
            view.setBackgroundColor(-16711681);
        }
        return view;
    }
}
