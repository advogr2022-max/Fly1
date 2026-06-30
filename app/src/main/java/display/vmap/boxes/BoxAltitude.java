package display.vmap.boxes;

import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import flyme_data.C0239g;
import types.C0377q;

/* loaded from: classes.dex */
public class BoxAltitude extends InfoBox {
    public BoxAltitude() {
        this.textLength = 3;
        this.aspectRatio = 1.7f;
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getCaption() {
        return App.m435a(R.string.altitude) + " " + C0377q.f2083b;
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getText() {
        int m1287e = C0377q.m1287e(C0239g.f1426s);
        if (m1287e >= 10000) {
            paintText.setTextSize(this.textSize * 0.8f);
        }
        return Integer.toString(m1287e);
    }
}
