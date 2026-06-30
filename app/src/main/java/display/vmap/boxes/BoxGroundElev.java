package display.vmap.boxes;

import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import flyme_data.C0239g;
import types.C0377q;

/* loaded from: classes.dex */
public class BoxGroundElev extends InfoBox {
    public BoxGroundElev() {
        this.textLength = 3;
        this.aspectRatio = 1.7f;
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getCaption() {
        return App.m435a(R.string.elevation) + " " + C0377q.f2083b;
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getText() {
        return Integer.toString(C0377q.m1287e(C0239g.f1428u));
    }
}
