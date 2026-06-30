package display.vmap.boxes;

import android.graphics.Canvas;
import android.graphics.Paint;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0094e;
import com.xcglobe.xclog.C0096g;
import com.xcglobe.xclog.C0101l;
import flyme_util1.C0212b;
import flyme_data.C0239g;
import types.C0377q;

/* loaded from: classes.dex */
public class BoxSpeedCircle extends InfoBox {

    /* renamed from: cX */
    private int f935cX;

    /* renamed from: cY */
    private int f936cY;
    int imgX;
    int imgY;
    private float radius;
    private float radiusText;

    public BoxSpeedCircle() {
        this.aspectRatio = 1.5f;
    }

    private void drawCircleAndLines(Canvas canvas) {
        canvas.drawCircle(this.f935cX, this.f936cY, this.radius, C0096g.m498b(C0101l.f544aB, C0101l.f597v));
        int i2 = 0;
        boolean z = C0239g.f1392W.f1117j != 0;
        C0212b c0212b = z ? C0239g.f1392W.f1109b : C0239g.f1392W.f1108a;
        float f2 = 12;
        double d2 = f2;
        Double.isNaN(d2);
        float f3 = (float) (6.283185307179586d / d2);
        float f4 = c0212b.f1133b;
        Paint m498b = C0096g.m498b(C0101l.f544aB, z ? C0101l.f590o : C0101l.f591p);
        float f5 = 360.0f / f2;
        if (f4 > 1.0f) {
            float f6 = -1.5707964f;
            int i3 = 0;
            for (int i4 = 12; i2 < i4; i4 = 12) {
                double m898a = this.radius * (c0212b.m898a(i3) / f4);
                double d3 = f6;
                double cos = Math.cos(d3);
                Double.isNaN(m898a);
                double sin = Math.sin(d3);
                Double.isNaN(m898a);
                canvas.drawLine(this.f935cX, this.f936cY, this.f935cX + ((int) (m898a * cos)), this.f936cY + ((int) (m898a * sin)), m498b);
                f6 += f3;
                i3 = (int) (i3 + f5);
                i2++;
                c0212b = c0212b;
            }
        }
    }

    private void drawLabelsAndImage(Canvas canvas) {
        int i2 = C0101l.f578c;
        float f2 = this.radiusText + (C0101l.f578c / 4);
        Paint m501d = C0096g.m501d();
        int i3 = 0;
        boolean z = C0239g.f1392W.f1117j != 0;
        C0212b c0212b = z ? C0239g.f1392W.f1109b : C0239g.f1392W.f1108a;
        while (i3 < 360) {
            float m898a = c0212b.m898a(i3);
            float radians = (-1.5707964f) + ((float) Math.toRadians(i3));
            float f3 = (i3 == 0 || i3 == 180) ? this.radiusText : f2;
            int i4 = this.f935cX;
            double d2 = f3;
            double d3 = radians;
            double cos = Math.cos(d3);
            Double.isNaN(d2);
            int i5 = i4 + ((int) (cos * d2));
            int i6 = this.f936cY;
            double sin = Math.sin(d3);
            Double.isNaN(d2);
            canvas.drawText(Integer.toString((int) C0377q.m1281b(m898a + 0.5f)), i5 - (m898a > 9.0f ? (C0101l.f579d * 7) / 8 : C0101l.f579d / 2), i6 + ((int) (d2 * sin)) + (i2 / 3), m501d);
            i3 += 45;
        }
        canvas.drawBitmap(z ? C0094e.f490c : C0094e.f489b, this.imgX, this.imgY, (Paint) null);
    }

    @Override // display.vmap.boxes.InfoBox
    protected void draw(Canvas canvas) {
        drawCircleAndLines(canvas);
        drawLabelsAndImage(canvas);
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getCaption() {
        return App.m435a(R.string.speed_circle);
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getText() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // display.vmap.boxes.InfoBox
    public void onPosition() {
        int height;
        if (this.rec.height() < C0101l.f578c * 7) {
            this.captionVisible = false;
        }
        if (this.captionVisible) {
            this.radius = ((this.rec.height() - this.captionHeight) - (C0101l.f578c * 1.5f)) / 2.0f;
            height = (int) ((this.rec.bottom - this.radius) - C0101l.f578c);
        } else {
            this.radius = (this.rec.height() - (C0101l.f578c * 2)) / 2;
            height = this.rec.top + (this.rec.height() / 2);
        }
        this.f936cY = height;
        this.radiusText = this.radius + (C0101l.f578c / 3);
        this.f935cX = (int) (this.rec.left + this.radius + MARGIN_LEFT + C0101l.f579d);
        this.rec.width();
        float f2 = this.radius;
        int i2 = C0101l.f579d;
        this.imgX = (int) (this.f935cX + ((((this.radius * 2.0f) + (C0101l.f579d * 2)) + C0094e.f490c.getWidth()) / 2.0f));
        this.imgY = this.f936cY - (C0094e.f489b.getHeight() / 2);
    }
}
