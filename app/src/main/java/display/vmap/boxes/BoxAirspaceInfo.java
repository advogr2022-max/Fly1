package display.vmap.boxes;

import android.graphics.Canvas;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0101l;
import flyme_fileutil.C0001b;
import flyme_data.C0239g;
import types.C0377q;
import types.GpsVal;
import vmaps.C0379a;

/* loaded from: classes.dex */
public class BoxAirspaceInfo extends InfoBox {
    C0001b air;
    int dist;
    int smallDigitWidth;
    float smallTextSize;
    int textY1;
    int textY2;

    public BoxAirspaceInfo() {
        this.aspectRatio = 2.0f;
        this.textLength = 0;
    }

    @Override // display.vmap.boxes.InfoBox
    protected void draw(Canvas canvas) {
        canvas.drawText(this.text, this.textX, this.textY1, paintText);
        if (this.air != null) {
            paintText.setTextSize(this.smallTextSize);
            paintText.setColor(C0101l.f594s);
            StringBuilder sb = new StringBuilder();
            sb.append(this.air.f8e ? "AGL " : "MSL ");
            sb.append(C0377q.f2083b);
            canvas.drawText(sb.toString(), this.textX + this.measuredText + (this.smallDigitWidth / 4), this.textY1, paintText);
            paintText.setColor(C0101l.f591p);
            canvas.drawText(this.air.f4a, this.textX, this.textY2, paintText);
        }
        paintText.setColor(C0101l.f591p);
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getCaption() {
        return App.m435a(R.string.box_air_info);
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getText() {
        byte[] bArr = {0, 0};
        GpsVal m1073d = C0239g.m1073d();
        if (C0379a.f2109b.m1177a(m1073d.f1972a, m1073d.f1973b, bArr) == -1) {
            return "-";
        }
        this.air = C0379a.f2109b.f1981a.get(bArr[1]);
        return Integer.toString(C0377q.m1287e(this.air.f7d));
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
