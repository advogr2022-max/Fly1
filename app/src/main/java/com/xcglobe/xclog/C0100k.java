package com.xcglobe.xclog;

import android.content.Context;
import android.preference.Preference;
import android.view.View;
import android.widget.TextView;
import com.xcglobe.flyme.R;

/* renamed from: com.xcglobe.xclog.k */
/* loaded from: classes.dex */
public class C0100k extends Preference {

    /* renamed from: a */
    public String f513a;

    /* renamed from: b */
    public String f514b;

    /* renamed from: c */
    public String f515c;

    public C0100k(Context context) {
        super(context);
        setLayoutResource(R.layout.pref_task_point);
    }

    @Override // android.preference.Preference
    protected void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(R.id.ss);
        TextView textView2 = (TextView) view.findViewById(R.id.radius);
        TextView textView3 = (TextView) view.findViewById(R.id.dist);
        textView.setText(this.f513a);
        textView2.setText(this.f514b);
        textView3.setText(this.f515c);
    }
}
