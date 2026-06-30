package display.vmap.boxes;

import android.graphics.Canvas;
import android.graphics.Path;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0097h;
import com.xcglobe.xclog.C0101l;
import flyme_data.C0239g;
import types.C0369i;
import types.C0377q;
import types.GpsVal;
import types.PoiPoint;

/* loaded from: classes.dex */
public class BoxNearThermal extends InfoBox {
    int direction;
    float distance;
    Path pathPointer;
    int pointerX;
    int pointerY;
    int radius;
    PoiPoint thermal;
    float prevLat = 0.0f;
    float prevLng = 0.0f;
    int poiAge = 0;

    public BoxNearThermal() {
        this.textLength = 0;
        this.aspectRatio = 1.7f;
    }

    private void drawPointer(Canvas canvas, int i2) {
        canvas.save();
        canvas.translate(this.pointerX, this.pointerY);
        canvas.rotate(i2);
        paintText.setColor(C0101l.f588m);
        canvas.drawPath(this.pathPointer, paintText);
        canvas.restore();
        paintText.setColor(C0101l.f591p);
    }

    private void findNearest() {
        GpsVal m1073d = C0239g.m1073d();
        if (this.poiAge != C0097h.f496c) {
            this.poiAge = C0097h.f496c;
        } else if (world.f2122e.m1193a(m1073d.f1972a, m1073d.f1973b, this.prevLat, this.prevLng) < 0.05f) {
            return;
        }
        this.prevLat = m1073d.f1972a;
        this.prevLng = m1073d.f1973b;
        float f2 = 99999.0f;
        PoiPoint[] poiPointArr = C0101l.f568ar.f498b;
        this.thermal = null;
        for (PoiPoint poiPoint : poiPointArr) {
            if (poiPoint.f1980m == 't') {
                float m1193a = world.f2122e.m1193a(m1073d.f1972a, m1073d.f1973b, poiPoint.f1976i, poiPoint.f1977j);
                if (m1193a < f2) {
                    this.thermal = poiPoint;
                    f2 = m1193a;
                }
            }
        }
        if (this.thermal != null) {
            this.distance = f2;
            this.direction = C0369i.m1243a(m1073d.f1972a, m1073d.f1973b, this.thermal.f1976i, this.thermal.f1977j);
        }
    }

    @Override // display.vmap.boxes.InfoBox
    protected void draw(Canvas canvas) {
        if (this.text == null) {
            return;
        }
        canvas.drawText(this.text, this.textX, this.textY - (this.radius / 4), paintText);
        drawPointer(canvas, this.direction - C0239g.f1420m);
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getCaption() {
        return App.m435a(R.string.near_thermal) + " " + C0377q.f2083b;
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getText() {
        findNearest();
        if (this.thermal != null) {
            return this.distance < 10.0f ? C0101l.f520E.format(this.distance) : Integer.toString(Math.round(this.distance));
        }
        return null;
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
        this.pointerX = this.rec.left + this.radius + MARGIN_LEFT;
        this.pointerY = (this.rec.bottom - this.radius) - MARGIN_BOTTOM;
        this.textX = this.pointerX + this.radius;
        this.maxTextWidth = (this.rec.right - this.textX) - MARGIN_LEFT;
    }
}
