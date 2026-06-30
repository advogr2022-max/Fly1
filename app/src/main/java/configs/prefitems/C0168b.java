package configs.prefitems;

import android.content.Context;
import android.preference.Preference;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.xcglobe.flyme.R;

/* renamed from: configs.prefitems.b */
/* loaded from: classes.dex */
public class C0168b extends Preference {

    /* renamed from: a */
    public boolean f718a;

    public C0168b(Context context) {
        super(context);
        this.f718a = false;
        setLayoutResource(R.layout.pref_waypoint);
    }

    @Override // android.preference.Preference
    public View getView(View view, ViewGroup viewGroup) {
        return super.getView(view, viewGroup);
    }

    @Override // android.preference.Preference
    protected void onBindView(View view) {
        super.onBindView(view);
        ((ImageView) view.findViewById(R.id.img)).setImageResource(this.f718a ? android.R.drawable.checkbox_on_background : android.R.drawable.checkbox_off_background);
    }
}
