package flyme_dialogs.flyme_dialogs_b;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.C0101l;
import java.util.ArrayList;
import java.util.Iterator;
import types.C0377q;
import types.PoiPoint;

/* renamed from: f.b.c */
/* loaded from: classes.dex */
public class C0199c extends ArrayAdapter<PoiPoint> implements Filterable {

    /* renamed from: a */
    DialogC0198b f1003a;

    /* renamed from: b */
    Context f1004b;

    /* renamed from: c */
    int f1005c;

    /* renamed from: d */
    PoiPoint[] f1006d;

    /* renamed from: e */
    int[] f1007e;

    /* renamed from: f */
    int[] f1008f;

    public C0199c(Context context, int i2, PoiPoint[] poiPointArr, int[] iArr, DialogC0198b dialogC0198b) {
        super(context, i2, poiPointArr);
        this.f1005c = i2;
        this.f1004b = context;
        this.f1006d = poiPointArr;
        this.f1007e = iArr;
        this.f1003a = dialogC0198b;
        this.f1008f = new int[poiPointArr.length];
        for (int i3 = 0; i3 < poiPointArr.length; i3++) {
            this.f1008f[i3] = i3;
        }
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public PoiPoint getItem(int i2) {
        return this.f1006d[this.f1008f[i2]];
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public int getCount() {
        return this.f1008f.length;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Filterable
    public Filter getFilter() {
        return new Filter() { // from class: f.b.c.1
            @Override // android.widget.Filter
            protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                Filter.FilterResults filterResults = new Filter.FilterResults();
                String lowerCase = charSequence.toString().toLowerCase();
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < C0199c.this.f1006d.length; i2++) {
                    if (C0199c.this.f1006d[i2].f1979l.toLowerCase().contains(lowerCase)) {
                        arrayList.add(Integer.valueOf(i2));
                    }
                }
                filterResults.count = arrayList.size();
                filterResults.values = arrayList;
                return filterResults;
            }

            @Override // android.widget.Filter
            protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                ArrayList arrayList = (ArrayList) filterResults.values;
                C0199c.this.f1008f = new int[arrayList.size()];
                Iterator it = arrayList.iterator();
                int i2 = 0;
                while (it.hasNext()) {
                    C0199c.this.f1008f[i2] = ((Integer) it.next()).intValue();
                    i2++;
                }
                C0199c.this.notifyDataSetChanged();
            }
        };
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        C0197a c0197a;
        TextView textView;
        int i3;
        if (view == null) {
            view = ((Activity) this.f1004b).getLayoutInflater().inflate(this.f1005c, viewGroup, false);
            c0197a = new C0197a();
            c0197a.f967a = (TextView) view.findViewById(R.id.dlg_goal_row_title);
            c0197a.f968b = (TextView) view.findViewById(R.id.dlg_goal_row_distance);
            c0197a.f969c = (ImageView) view.findViewById(R.id.img);
            view.setTag(c0197a);
        } else {
            c0197a = (C0197a) view.getTag();
        }
        PoiPoint item = getItem(i2);
        c0197a.f967a.setText(item.f1979l);
        c0197a.f968b.setText(C0101l.f520E.format(C0377q.m1278a(this.f1007e[i2] / 1000.0f)));
        int i4 = R.drawable.wp_label;
        char c2 = item.f1980m;
        if (c2 == 'c') {
            i4 = R.drawable.geo_label;
        } else if (c2 == 'l') {
            i4 = R.drawable.livetrack_label;
        } else if (c2 == 's') {
            i4 = R.drawable.site_label;
        }
        c0197a.f969c.setImageResource(i4);
        if (item.m1172b(this.f1003a.f982i)) {
            c0197a.f967a.setTextColor(C0101l.f585j);
            textView = c0197a.f968b;
            i3 = C0101l.f585j;
        } else {
            c0197a.f967a.setTextColor(C0101l.f591p);
            textView = c0197a.f968b;
            i3 = C0101l.f591p;
        }
        textView.setTextColor(i3);
        return view;
    }
}
