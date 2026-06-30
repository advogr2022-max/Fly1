package configs.prefitems;

import android.content.Context;
import android.preference.Preference;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.xcglobe.flyme.R;
import flyme_data.C0238f;

/* loaded from: classes.dex */
public class IconPreference extends Preference {

    /* renamed from: a */
    int f714a;

    public IconPreference(Context context) {
        super(context);
        this.f714a = 0;
        setLayoutResource(R.layout.pref_icon);
        m631a();
    }

    public IconPreference(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f714a = 0;
        setLayoutResource(R.layout.pref_icon);
        m631a();
    }

    public IconPreference(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f714a = 0;
        setLayoutResource(R.layout.pref_icon);
        m631a();
    }

    /* renamed from: a */
    private void m631a() {
        int[] iArr = {R.drawable.pref_test, R.drawable.pref_maps, R.drawable.pref_disp, R.drawable.pref_powe, R.drawable.pref_tasks, R.drawable.pref_live, R.drawable.pref_adva, R.drawable.pref_abou};
        int order = getOrder();
        if (order <= 0 || order > iArr.length) {
            return;
        }
        this.f714a = iArr[order - 1];
    }

    @Override // android.preference.Preference
    public View getView(View view, ViewGroup viewGroup) {
        View view2 = super.getView(view, viewGroup);
        ImageView imageView = (ImageView) view2.findViewById(R.id.img);
        if (imageView != null) {
            if (this.f714a != 0) {
                imageView.setVisibility(0);
                imageView.setImageResource((this.f714a == R.drawable.pref_test && C0238f.m1059d()) ? R.drawable.pref_test_off : this.f714a);
            } else {
                imageView.setVisibility(4);
            }
        }
        return view2;
    }

    @Override // android.preference.Preference
    protected void onBindView(View view) {
        super.onBindView(view);
    }
}
