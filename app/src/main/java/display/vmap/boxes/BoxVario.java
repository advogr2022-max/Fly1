package display.vmap.boxes;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0101l;
import flyme_data.C0239g;
import types.C0377q;

/* loaded from: classes.dex */
public class BoxVario extends InfoBox {
    Paint paintTextOutline = new Paint();
    float value;
    boolean varioIsInteger;

    public BoxVario() {
        this.textIsDecimal = !C0377q.m1283b();
    }

    @Override // display.vmap.boxes.InfoBox
    protected void draw(Canvas canvas) {
        this.paintTextOutline.setTextSize(paintText.getTextSize());
        canvas.drawText(this.text, this.textX, this.textY, this.paintTextOutline);
        paintText.setColor(C0239g.f1416i < 0.0f ? C0101l.f587l : C0101l.f588m);
        canvas.drawText(this.text, this.textX, this.textY, paintText);
        paintText.setColor(C0101l.f591p);
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getCaption() {
        return App.m435a(R.string.vario) + " " + C0377q.f2085d;
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getText() {
        this.value = C0377q.m1284c(C0239g.f1416i);
        return C0239g.f1390U > System.currentTimeMillis() - C0101l.f584i ? this.varioIsInteger ? String.valueOf((int) this.value) : C0101l.f520E.format(this.value) : "0";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // display.vmap.boxes.InfoBox
    public void onPosition() {
        this.varioIsInteger = C0377q.m1283b();
        this.paintTextOutline.set(paintText);
        this.paintTextOutline.setStyle(Paint.Style.FILL_AND_STROKE);
        this.paintTextOutline.setColor(C0101l.f591p);
        this.paintTextOutline.setStrokeWidth(C0101l.f578c / 6.0f);
    }
}
