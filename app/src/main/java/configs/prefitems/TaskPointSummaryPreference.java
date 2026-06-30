package configs.prefitems;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import com.xcglobe.flyme.R;

/* loaded from: classes.dex */
public class TaskPointSummaryPreference extends Preference {

    /* renamed from: a */
    public String f715a;

    /* renamed from: b */
    public String f716b;

    public TaskPointSummaryPreference(Context context) {
        super(context);
        this.f715a = "";
        this.f716b = "";
        setLayoutResource(R.layout.pref_task_point_summary);
    }

    public TaskPointSummaryPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f715a = "";
        this.f716b = "";
        setLayoutResource(R.layout.pref_task_point_summary);
    }

    public TaskPointSummaryPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f715a = "";
        this.f716b = "";
        setLayoutResource(R.layout.pref_task_point_summary);
    }

    @Override // android.preference.Preference
    protected void onBindView(View view) {
        super.onBindView(view);
        TextView textView = (TextView) view.findViewById(R.id.dist_min);
        TextView textView2 = (TextView) view.findViewById(R.id.dist_center);
        textView.setText(this.f715a);
        textView2.setText(this.f716b);
    }
}
