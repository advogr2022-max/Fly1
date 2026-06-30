package display.vmap.boxes;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0096g;
import com.xcglobe.xclog.C0101l;
import flyme_data.C0239g;
import types.C0377q;

/* loaded from: classes.dex */
public class BoxWind extends InfoBox {
    int northY;
    Path pathPointer;
    int pointerX;
    int pointerY;
    int radius;
    private RectF recPointer = new RectF();
    boolean showN;
    int value;

    public BoxWind() {
        this.textLength = 0;
    }

    private void drawPointer(Canvas canvas, int i2) {
        canvas.save();
        canvas.translate(this.pointerX, this.pointerY);
        canvas.drawArc(this.recPointer, -75.0f, 330.0f, false, C0096g.m499c());
        if (this.showN) {
            canvas.drawText("N", (-C0101l.f579d) / 2, this.northY, C0096g.m500c(C0101l.f578c, C0101l.f585j));
        }
        canvas.rotate(i2);
        canvas.drawPath(this.pathPointer, C0096g.m500c(0.0f, C0101l.f585j));
        canvas.restore();
    }

    @Override // display.vmap.boxes.InfoBox
    protected void draw(Canvas canvas) {
        canvas.drawText(this.text, this.textX, this.textY, paintText);
        drawPointer(canvas, C0239g.f1392W.f1116i);
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getCaption() {
        return App.m435a(R.string.wind) + " " + C0377q.f2084c;
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getText() {
        this.value = (int) C0377q.m1281b(C0239g.f1392W.f1115h + 0.5f);
        return Integer.toString(this.value);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // display.vmap.boxes.InfoBox
    public void onPosition() {
        int height;
        if (this.captionVisible) {
            double height2 = this.rec.height() - MARGIN_BOTTOM;
            double d2 = this.captionHeight;
            Double.isNaN(d2);
            Double.isNaN(height2);
            height = (int) (height2 - (d2 * 1.2d));
        } else {
            height = (this.rec.height() - MARGIN_BOTTOM) - (C0101l.f578c / 2);
        }
        this.radius = height / 2;
        this.recPointer.set(-this.radius, -this.radius, this.radius, this.radius);
        this.showN = ((float) this.radius) > ((float) C0101l.f578c) * 1.3f;
        float f2 = this.radius;
        if (this.showN) {
            f2 -= C0101l.f578c * 0.5f;
        }
        this.pathPointer = createPointerPath(f2);
        this.pointerX = this.rec.left + this.radius + MARGIN_LEFT;
        this.pointerY = (this.rec.bottom - this.radius) - MARGIN_BOTTOM;
        this.textX = this.rec.left + (MARGIN_LEFT * 2) + (this.radius * 2);
        this.maxTextWidth = (this.rec.right - this.textX) - MARGIN_LEFT;
        this.textY -= this.radius / 4;
        this.textSize *= 0.8f;
        this.northY = (-this.radius) + (C0101l.f578c / 2);
    }
}
