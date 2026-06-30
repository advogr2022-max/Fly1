package display.vmap.boxes;

import android.graphics.Canvas;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0101l;
import flyme_data.C0235c;
import flyme_data.C0239g;

/* loaded from: classes.dex */
public class BoxFinesse extends InfoBox {
    private static final String UNAVAILABLE = "\u221e";

    @Override // display.vmap.boxes.InfoBox
    protected void draw(Canvas canvas) {
        if (this.text != null) {
            if (!C0239g.f1392W.m896b()) {
                canvas.drawText(this.text, this.textX, this.textY, paintText);
                return;
            }
            paintText.setColor(C0101l.f594s);
            canvas.drawText(this.text, this.textX, this.textY, paintText);
            paintText.setColor(C0101l.f591p);
        }
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getCaption() {
        return App.m435a(R.string.finesse);
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getText() {
        C0235c.m1038a();
        float m892a = C0239g.f1392W.m892a();
        return m892a > 0.0f ? C0101l.f520E.format(m892a) : UNAVAILABLE;
    }
}
