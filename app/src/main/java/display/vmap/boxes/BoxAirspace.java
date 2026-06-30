package display.vmap.boxes;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0101l;
import flyme_fileutil.C0001b;
import flyme_data.C0239g;
import types.C0377q;
import types.GpsVal;
import vmaps.C0379a;

/* loaded from: classes.dex */
public class BoxAirspace extends InfoBox {
    C0001b air;
    int dist;
    int smallDigitWidth;
    float smallTextSize;
    int textY1;
    int textY2;

    public BoxAirspace() {
        this.aspectRatio = 2.0f;
        this.textLength = 0;
    }

    @Override // display.vmap.boxes.InfoBox
    protected void draw(Canvas canvas) {
        paintText.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawText(this.text, this.textX, this.textY1, paintText);
        paintText.setStyle(Paint.Style.FILL);
        paintText.setColor(this.dist < 0 ? C0101l.f587l : C0101l.f588m);
        canvas.drawText(this.text, this.textX, this.textY1, paintText);
        if (this.air != null) {
            paintText.setTextSize(this.smallTextSize);
            paintText.setColor(C0101l.f594s);
            canvas.drawText(C0377q.f2083b, this.textX + this.measuredText + (this.smallDigitWidth / 4), this.textY1, paintText);
            paintText.setColor(C0101l.f591p);
            canvas.drawText(this.air.f4a, this.textX, this.textY2, paintText);
        }
        paintText.setColor(C0101l.f591p);
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getCaption() {
        return App.m435a(R.string.box_air_violation);
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getText() {
        byte[] bArr = {0, 0};
        GpsVal m1073d = C0239g.m1073d();
        if (C0379a.f2109b.m1177a(m1073d.f1972a, m1073d.f1973b, bArr) == -1) {
            this.dist = 99999;
            this.air = null;
            return "-";
        }
        this.air = C0379a.f2109b.f1981a.get(bArr[1]);
        this.dist = C0377q.m1287e((bArr[0] * 50) - C0239g.f1426s);
        if (this.dist < 0) {
            return Integer.toString(this.dist);
        }
        return "+" + this.dist;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // display.vmap.boxes.InfoBox
    public void onPosition() {
        this.textSize *= 0.6f;
        this.smallTextSize = this.textSize * 0.4f;
        double d2 = this.rec.top + this.captionHeight;
        double d3 = this.textSize;
        Double.isNaN(d3);
        Double.isNaN(d2);
        double d4 = d2 + (d3 * 0.9d);
        double d5 = MARGIN_TOP;
        Double.isNaN(d5);
        this.textY1 = (int) (d4 + d5);
        this.textY2 = (int) (this.textY1 + this.smallTextSize + MARGIN_TOP);
        paintText.setTextSize(this.smallTextSize);
        this.smallDigitWidth = Math.round(paintText.measureText("9999") / 4.0f);
        this.maxTextWidth -= this.smallDigitWidth * 2;
    }
}
