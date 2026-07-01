package display.vmap.boxes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0099j;
import com.xcglobe.xclog.C0101l;
import flyme_data.C0238f;
import flyme_data.C0239g;
import types.C0377q;

/* loaded from: classes.dex */
public class BoxOlcScore extends InfoBox {
    // private static int r0 = 0;
    private static final long UPDATE_INTERVAL_MS = 3000;
    private int measuredTextSize;
    private float smallTextSize;
    private static final int[] picBigIds = {R.drawable.stype1_big, R.drawable.stype2_big, R.drawable.stype3_big};
    private static final int[] picIds = {R.drawable.stype1, R.drawable.stype2, R.drawable.stype3};
    private static int BIG_PIC_MIN_REC_HEIGHT = 0;
    private long nextUpdateTimeMs = 0;
    private int kmMaxType = 0;
    private int picType = 0;
    private int picWidth = 0;
    private int picHeight = 0;
    private Bitmap bmpStype = null;
    private String distanceStr = null;

    public BoxOlcScore() {
        this.aspectRatio = 1.7f;
        this.textLength = 0;
    }

    private void updateContent() {
        int m530g;
        int m1278a = 0;
        if (BIG_PIC_MIN_REC_HEIGHT == 0) {
            calcpicMinRecHeight();
        }
        String m1077h = C0239g.m1077h();
        this.distanceStr = null;
        this.kmMaxType = 0;
        if (m1077h != null && C0238f.m1059d() && (m530g = C0099j.m530g(m1077h, "kmmaxtype")) != 0) {
            if (m530g != this.picType) {
                this.bmpStype = BitmapFactory.decodeResource(App.m443b().getResources(), this.rec.height() < BIG_PIC_MIN_REC_HEIGHT ? picIds[m530g - 1] : picBigIds[m530g - 1]);
                this.picType = m530g;
                this.picWidth = this.bmpStype.getWidth();
                this.picHeight = this.bmpStype.getHeight();
            }
            if (C0099j.m529f(m1077h, "km" + m530g).length() > 0) {
                this.distanceStr = String.valueOf(m1278a);
                this.measuredTextSize = (int) (paintText.measureText(this.distanceStr) + (C0101l.f579d / 2));
                this.kmMaxType = m530g;
            }
        }
        if (this.distanceStr == null) {
            this.measuredTextSize = 0;
            this.distanceStr = "---";
        }
    }

    void calcpicMinRecHeight() {
        BIG_PIC_MIN_REC_HEIGHT = (int) (BitmapFactory.decodeResource(App.m443b().getResources(), picBigIds[0]).getHeight() * 1.9f);
    }

    @Override // display.vmap.boxes.InfoBox
    protected void draw(Canvas canvas) {
        if (timeMs > this.nextUpdateTimeMs) {
            updateContent();
            this.nextUpdateTimeMs = timeMs + UPDATE_INTERVAL_MS;
        }
        if (this.kmMaxType != 0) {
            canvas.drawBitmap(this.bmpStype, this.textX, this.textY - this.picHeight, (Paint) null);
        }
        int i2 = this.textX + this.picWidth + (C0101l.f579d / 2);
        if (this.text != null) {
            canvas.drawText(this.text, i2, this.textY, paintText);
            if (this.measuredTextSize > 0) {
                paintText.setTextSize(this.smallTextSize);
                paintText.setColor(C0101l.f594s);
                canvas.drawText(C0377q.f2082a, i2 + this.measuredTextSize, this.textY, paintText);
                paintText.setColor(C0101l.f591p);
            }
        }
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getCaption() {
        return "OLC";
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getText() {
        return this.distanceStr;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // display.vmap.boxes.InfoBox
    public void onPosition() {
        this.textSize *= 0.6f;
        this.smallTextSize = this.textSize * 0.3f;
        this.picType = 0;
        this.nextUpdateTimeMs = 0L;
    }
}
