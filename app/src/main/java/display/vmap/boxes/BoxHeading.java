package display.vmap.boxes;

import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import flyme_data.C0239g;

/* loaded from: classes.dex */
public class BoxHeading extends InfoBox {
    @Override // display.vmap.boxes.InfoBox
    protected String getCaption() {
        return App.m435a(R.string.heading);
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getText() {
        return String.valueOf(C0239g.f1420m);
    }
}
