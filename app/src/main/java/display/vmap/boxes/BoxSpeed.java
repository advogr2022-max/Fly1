package display.vmap.boxes;

import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import flyme_data.C0239g;
import types.C0377q;

/* loaded from: classes.dex */
public class BoxSpeed extends InfoBox {
    @Override // display.vmap.boxes.InfoBox
    protected String getCaption() {
        return App.m435a(R.string.speed) + " " + C0377q.f2084c;
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getText() {
        int m1281b = (int) C0377q.m1281b(C0239g.f1418k + 0.5f);
        if (m1281b >= 100) {
            paintText.setTextSize(this.textSize * 0.8f);
        }
        return Integer.toString(m1281b);
    }
}
