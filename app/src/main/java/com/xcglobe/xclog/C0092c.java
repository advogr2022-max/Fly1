package com.xcglobe.xclog;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.xcglobe.flyme.R;
import java.util.List;
import types.C0377q;

/* renamed from: com.xcglobe.xclog.c */
/* loaded from: classes.dex */
public class C0092c extends ArrayAdapter<String> {
    // private static int r5 = 0;

    /* renamed from: a */
    Context f480a;

    /* renamed from: b */
    int f481b;

    /* renamed from: c */
    List<String> f482c;

    /* renamed from: com.xcglobe.xclog.c$a */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        TextView f483a;

        /* renamed from: b */
        TextView f484b;

        /* renamed from: c */
        TextView f485c;

        /* renamed from: d */
        TextView f486d;
    }

    public C0092c(Context context, int i2, List<String> list) {
        super(context, i2, list);
        this.f482c = null;
        this.f481b = i2;
        this.f480a = context;
        this.f482c = list;
    }

    @Override // android.widget.ArrayAdapter, android.widget.Adapter
    public View getView(int i2, View view, ViewGroup viewGroup) {
        a aVar;
        TextView textView;
        int i3;
        String str;
        if (view == null) {
            view = ((Activity) this.f480a).getLayoutInflater().inflate(this.f481b, viewGroup, false);
            aVar = new a();
            aVar.f483a = (TextView) view.findViewById(R.id.frowTxtTitle);
            aVar.f484b = (TextView) view.findViewById(R.id.frowTxtUploaded);
            aVar.f485c = (TextView) view.findViewById(R.id.frowTxtTime);
            aVar.f486d = (TextView) view.findViewById(R.id.frowTxtKmMax);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        String str2 = this.f482c.get(i2);
        aVar.f483a.setText(str2);
        if (str2.equals(C0101l.f581f)) {
            aVar.f484b.setText("recording");
            textView = aVar.f484b;
            i3 = C0101l.f585j;
        } else if (C0099j.m529f(str2, "uploaded").equals("1")) {
            aVar.f484b.setText("uploaded");
            textView = aVar.f484b;
            i3 = C0101l.f588m;
        } else {
            aVar.f484b.setText("not uploaded");
            textView = aVar.f484b;
            i3 = C0101l.f591p;
        }
        textView.setTextColor(i3);
        aVar.f485c.setText(C0099j.m529f(str2, "duration"));
        if (C0099j.m529f(str2, "kmmax").length() > 0) {
            try {
                str = String.valueOf(C0101l.f520E.format(0)) + " " + C0377q.f2082a;
            } catch (Exception unused) {
            }
            aVar.f486d.setText(str);
            return view;
        }
        str = "-";
        aVar.f486d.setText(str);
        return view;
    }
}
