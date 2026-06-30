package configs.prefitems;

import android.content.Context;
import android.graphics.Color;
import android.preference.Preference;
import android.view.View;
import android.view.ViewGroup;
import com.xcglobe.flyme.R;

/* renamed from: configs.prefitems.a */
/* loaded from: classes.dex */
public class C0167a extends Preference {

    /* renamed from: a */
    public boolean f717a;

    public C0167a(Context context) {
        super(context);
        this.f717a = false;
        setLayoutResource(R.layout.pref_task);
    }

    @Override // android.preference.Preference
    public View getView(View view, ViewGroup viewGroup) {
        return super.getView(view, viewGroup);
    }

    @Override // android.preference.Preference
    protected void onBindView(View view) {
        super.onBindView(view);
        if (this.f717a) {
            view.setBackgroundColor(Color.parseColor("#500000"));
        }
    }
}
