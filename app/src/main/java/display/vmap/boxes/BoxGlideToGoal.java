package display.vmap.boxes;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0101l;
import flyme_dialogs.flyme_dialogs_b.DialogC0198b;
import flyme_data.C0239g;
import types.C0366f;
import types.C0377q;
import types.PoiPoint;
import vmaps.C0391d;

/* loaded from: classes.dex */
public class BoxGlideToGoal extends InfoBox {
    private static final String UNKNOWN = "\u221e";
    private float glideToGoal;
    private int goalElev;
    int smallDigitWidth;
    float smallTextSize;
    int textY1;
    int textY2;
    private PoiPoint visibleGoal = null;
    private String clickSelect = App.m435a(R.string.click_to_select);

    private void calcState() {
        this.glideToGoal = (C0366f.f2004b * 1000.0f) / (C0239g.f1426s - this.goalElev);
    }

    private void changedGoal() {
        int i2;
        if (C0366f.f2003a != null) {
            i2 = C0366f.f2003a.f1978k;
            if (i2 == 0) {
                i2 = C0391d.m1416b(C0366f.f2003a.f1976i, C0366f.f2003a.f1977j);
            }
            if (i2 == 0) {
                App.f462c.postDelayed(new Runnable() { // from class: display.vmap.boxes.-$$Lambda$BoxGlideToGoal$UUUoiNyzOYQ9Kf5W_OI7W2NGMQs
                    @Override // java.lang.Runnable
                    public final void run() {
                        BoxGlideToGoal.this.goalElev = C0391d.m1416b(C0366f.f2003a.f1976i, C0366f.f2003a.f1977j);
                    }
                }, 1000L);
            }
        } else {
            i2 = 0;
        }
        this.goalElev = i2;
        this.visibleGoal = C0366f.f2003a;
    }

    @Override // display.vmap.boxes.InfoBox
    protected void draw(Canvas canvas) {
        String str;
        float f2;
        int i2;
        if (C0366f.f2003a != this.visibleGoal) {
            changedGoal();
        }
        if (C0366f.f2003a == null) {
            str = this.clickSelect;
            f2 = this.rec.left + C0101l.f579d;
            i2 = this.textY;
        } else {
            paintText.setStyle(Paint.Style.FILL_AND_STROKE);
            paintText.setColor(C0101l.f591p);
            canvas.drawText(this.text, this.textX, this.textY1, paintText);
            paintText.setStyle(Paint.Style.FILL);
            paintText.setColor(C0366f.f2008f > 0 ? C0101l.f588m : C0101l.f585j);
            canvas.drawText(this.text, this.textX, this.textY1, paintText);
            paintText.setTextSize(this.smallTextSize);
            paintText.setColor(C0101l.f591p);
            str = C0101l.f520E.format(C0377q.m1278a(C0366f.f2004b)) + ' ' + C0377q.f2082a + " / " + C0377q.m1287e(C0239g.f1426s - this.goalElev) + ' ' + C0377q.f2083b;
            f2 = this.textX;
            i2 = this.textY2;
        }
        canvas.drawText(str, f2, i2, paintText);
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getCaption() {
        return App.m435a(R.string.glide_to_goal);
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getText() {
        if (C0366f.f2003a == null) {
            return App.m435a(R.string.click_to_select);
        }
        calcState();
        return this.glideToGoal < 0.0f ? UNKNOWN : this.glideToGoal > 20.0f ? String.valueOf((int) this.glideToGoal) : C0101l.f520E.format(this.glideToGoal);
    }

    @Override // display.vmap.boxes.InfoBox
    public boolean onClick() {
        DialogC0198b.m833a(App.m434a(), C0239g.m1073d(), C0366f.f2003a, true, (DialogC0198b.a) new DialogC0198b.a() { // from class: display.vmap.boxes.-$$Lambda$BoxGlideToGoal$ZkOhAni4CcZ6aKCbszrq_25390I
            @Override // flyme_dialogs.flyme_dialogs_b.DialogC0198b.a
            public final void call(PoiPoint poiPoint) {
                C0366f.m1222a(poiPoint, false);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // display.vmap.boxes.InfoBox
    public void onPosition() {
        this.textSize *= 0.65f;
        this.smallTextSize = this.textSize * 0.35f;
        if (this.smallTextSize < C0101l.f578c) {
            this.smallTextSize = C0101l.f578c;
        }
        this.textSize = (((this.rec.height() - MARGIN_TOP) - MARGIN_BOTTOM) - (this.smallTextSize * 0.8f)) - (this.captionVisible ? this.captionHeight : 0);
        double d2 = this.rec.top + (this.captionVisible ? this.captionHeight : 0);
        double d3 = this.textSize;
        Double.isNaN(d3);
        Double.isNaN(d2);
        double d4 = d2 + (d3 * 0.89d);
        double d5 = MARGIN_TOP;
        Double.isNaN(d5);
        this.textY1 = (int) (d4 + d5);
        this.textY2 = this.rec.bottom - MARGIN_TOP;
        paintText.setTextSize(this.smallTextSize);
        this.smallDigitWidth = Math.round(paintText.measureText("9999") / 4.0f);
        this.maxTextWidth -= this.smallDigitWidth * 2;
    }
}
