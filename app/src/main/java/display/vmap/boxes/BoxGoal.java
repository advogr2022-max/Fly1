package display.vmap.boxes;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0101l;
import display.vmap.features.RingPainter;
import flyme_dialogs.flyme_dialogs_b.DialogC0198b;
import flyme_data.C0239g;
import types.C0366f;
import types.C0377q;
import types.PoiPoint;

/* loaded from: classes.dex */
public class BoxGoal extends InfoBox {
    private String clickSelect;
    int dist;
    private Path pathPointer;
    private int radius;
    private PoiPoint visibleGoal = null;
    int xBmp;
    int xBmpText;
    int xPointer;
    int yBmp;
    int yPointer;

    public BoxGoal() {
        this.aspectRatio = 2.0f;
        this.textLength = 0;
        this.clickSelect = App.m435a(R.string.click_to_select);
    }

    private void calculateBitmapPosition() {
        this.xBmp = this.rec.left + C0101l.f579d;
        this.yBmp = (this.rec.top + (this.rec.height() / 2)) - (RingPainter.bmpGoal.getHeight() / 2);
        this.xBmpText = this.xBmp + RingPainter.bmpGoal.getWidth();
    }

    private void drawPointer(Canvas canvas, int i2) {
        canvas.save();
        canvas.translate(this.xPointer, this.yPointer);
        canvas.rotate(i2);
        paintText.setColor(C0101l.f590o);
        canvas.drawPath(this.pathPointer, paintText);
        canvas.restore();
        paintText.setColor(C0101l.f591p);
    }

    @Override // display.vmap.boxes.InfoBox
    protected void draw(Canvas canvas) {
        if (C0366f.f2003a != this.visibleGoal) {
            this.caption = getCaption();
            intCaptionVisibility(this.rec.width(), this.rec.height());
        }
        if (C0366f.f2003a == null) {
            if (RingPainter.bmpGoal != null) {
                if (this.xBmp == 0) {
                    calculateBitmapPosition();
                }
                canvas.drawBitmap(RingPainter.bmpGoal, this.xBmp, this.yBmp, (Paint) null);
                paintText.setTextSize(C0101l.f578c);
                canvas.drawText(this.text, this.xBmpText, this.textY, paintText);
                return;
            }
            return;
        }
        drawPointer(canvas, C0366f.f2005c - C0239g.f1420m);
        paintText.setStyle(Paint.Style.FILL_AND_STROKE);
        paintText.setColor(C0101l.f591p);
        canvas.drawText(this.text, this.textX, this.textY, paintText);
        paintText.setStyle(Paint.Style.FILL);
        paintText.setColor(C0366f.f2008f > 0 ? C0101l.f588m : C0101l.f585j);
        canvas.drawText(this.text, this.textX, this.textY, paintText);
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getCaption() {
        this.visibleGoal = C0366f.f2003a;
        if (C0366f.f2003a == null) {
            return App.m435a(R.string.goal) + " " + C0377q.f2082a;
        }
        String str = C0366f.f2003a.f1979l;
        if (str.length() > 10) {
            str = str.substring(0, 10) + "...";
        }
        return str + " " + C0377q.f2082a;
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getText() {
        return C0366f.f2003a != null ? C0101l.f520E.format(C0377q.m1278a(C0366f.f2004b)) : this.clickSelect;
    }

    @Override // display.vmap.boxes.InfoBox
    public boolean onClick() {
        DialogC0198b.m833a(App.m434a(), C0239g.m1073d(), C0366f.f2003a, true, new DialogC0198b.a() { // from class: display.vmap.boxes.BoxGoal.1
            @Override // flyme_dialogs.flyme_dialogs_b.DialogC0198b.a
            public void call(PoiPoint poiPoint) {
                C0366f.m1222a(poiPoint, false);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // display.vmap.boxes.InfoBox
    public void onPosition() {
        int height;
        int i2;
        if (this.captionVisible) {
            height = this.rec.height();
            i2 = this.captionHeight;
        } else {
            height = this.rec.height();
            i2 = C0101l.f578c / 2;
        }
        this.radius = ((height - i2) / 2) - MARGIN_TOP;
        this.pathPointer = createArrowPath(this.radius);
        this.xPointer = this.rec.left + this.radius + MARGIN_LEFT;
        this.yPointer = (this.rec.bottom - this.radius) - MARGIN_BOTTOM;
        this.textX = this.xPointer + this.radius;
        this.maxTextWidth = (this.rec.width() - (this.radius * 2)) - (MARGIN_LEFT * 2);
    }
}
