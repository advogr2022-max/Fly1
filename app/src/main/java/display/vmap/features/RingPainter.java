package display.vmap.features;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0101l;
import display.vmap.ViewVmp;
import flyme_data.C0239g;
import types.C0366f;
import vmaps.core.VmpWorld;

/* loaded from: classes.dex */
public class RingPainter {
    private static RectF arcRectangle;
    public static Bitmap bmpGoal;
    private static Bitmap bmpWindsock;
    private static int boldLetterWidthHalf;
    private static int borderOffset;
    private static Paint paintBold;
    private static Paint paintCircles;
    private static float ringBorder;
    private static int ringCenterX;
    private static int ringCenterY;
    private static int ringDiameter;
    private static int ringR;
    private static float textSize;
    private static int windsockRadius;

    public static void create(ViewVmp viewVmp) {
        borderOffset = C0101l.f578c / 8;
        paintCircles = new Paint();
        paintBold = new Paint();
        setPosition(viewVmp.world);
        paintCircles.setAntiAlias(true);
        paintCircles.setDither(true);
        paintCircles.setStyle(Paint.Style.STROKE);
        paintCircles.setColor(C0101l.f588m);
        paintBold.setTextSize(textSize);
        boldLetterWidthHalf = ((int) (paintBold.measureText("N") / 2.0f)) + 1;
        int i2 = ringCenterX;
        int i3 = ringCenterY;
        ringR = (int) ((ringDiameter / 2) - textSize);
        arcRectangle = new RectF(i2 - ringR, i3 - ringR, i2 + ringR, i3 + ringR);
        bmpWindsock = BitmapFactory.decodeResource(App.m443b().getResources(), R.drawable.windsock_white);
        windsockRadius = bmpWindsock.getWidth() / 2;
        bmpGoal = BitmapFactory.decodeResource(App.m443b().getResources(), R.drawable.goal_white);
    }

    public static void drawGoal(Canvas canvas) {
        if (C0366f.f2003a == null || PoiPainter.isGoalVisible()) {
            return;
        }
        float f2 = ringCenterX;
        float f3 = ringCenterY;
        float f4 = (ringDiameter / 2) - textSize;
        float width = bmpGoal.getWidth() / 2;
        double radians = (float) Math.toRadians(C0366f.f2005c - C0239g.f1420m);
        canvas.drawBitmap(bmpGoal, f2 + ((((float) Math.sin(radians)) * f4) - width), f3 - ((f4 * ((float) Math.cos(radians))) + width), (Paint) null);
    }

    public static void drawRing(Canvas canvas) {
        float f2 = ringCenterX;
        float f3 = ringCenterY;
        float f4 = ringR;
        paintCircles.setStrokeWidth(ringBorder);
        paintCircles.setColor(C0101l.f585j);
        canvas.drawArc(arcRectangle, -135.0f, 90.0f, false, paintCircles);
        paintCircles.setColor(C0101l.f593r);
        canvas.drawArc(arcRectangle, -225.0f, 90.0f, false, paintCircles);
        canvas.drawArc(arcRectangle, -45.0f, 90.0f, false, paintCircles);
        paintCircles.setColor(C0101l.f594s);
        canvas.drawArc(arcRectangle, 45.0f, 90.0f, false, paintCircles);
        paintBold.setColor(C0101l.f591p);
        int i2 = (int) (textSize / 12.0f);
        canvas.save();
        canvas.rotate(90.0f, f2, f3);
        float f5 = f3 - f4;
        float f6 = i2;
        canvas.drawText("E", f2 - boldLetterWidthHalf, ((textSize / 2.0f) + f5) - f6, paintBold);
        canvas.rotate(180.0f, f2, f3);
        canvas.drawText("W", f2 - boldLetterWidthHalf, ((textSize / 2.0f) + f5) - f6, paintBold);
        canvas.rotate(-90.0f, f2, f3);
        paintBold.setColor(C0101l.f592q);
        canvas.drawText("S", f2 - boldLetterWidthHalf, ((textSize / 2.0f) + f5) - f6, paintBold);
        canvas.restore();
        canvas.drawText("N", f2 - boldLetterWidthHalf, (f5 + (textSize / 2.0f)) - f6, paintBold);
    }

    public static void drawSock(Canvas canvas) {
        float f2 = ringCenterX;
        float f3 = ringCenterY;
        float f4 = (ringDiameter / 2) - textSize;
        double radians = (float) Math.toRadians((C0239g.f1392W.f1116i + 180) - C0239g.f1420m);
        float sin = ((float) Math.sin(radians)) * f4;
        float cos = f4 * ((float) Math.cos(radians));
        paintCircles.setStyle(Paint.Style.FILL);
        paintCircles.setColor(C0101l.f593r);
        canvas.drawCircle(f2 + sin, f3 - cos, windsockRadius, paintCircles);
        paintCircles.setStyle(Paint.Style.STROKE);
        canvas.drawBitmap(bmpWindsock, f2 + (sin - windsockRadius), f3 - (cos + windsockRadius), (Paint) null);
    }

    public static int[] getCenter() {
        return new int[]{ringCenterX, ringCenterY};
    }

    public static int getRadius() {
        return ringDiameter / 2;
    }

    public static int setPosition(VmpWorld vmpWorld) {
        ringDiameter = (int) ((Math.min((int) vmpWorld.f2123f, (int) vmpWorld.f2124g) - borderOffset) - (ringBorder / 2.0f));
        int[] iArr = {0, 0};
        vmpWorld.m1351b(iArr);
        ringCenterX = iArr[0];
        ringCenterY = iArr[1];
        int i2 = ringCenterY * 2;
        if (ringDiameter > i2) {
            ringDiameter = i2;
        }
        textSize = C0101l.f580e * 1.3f;
        if (textSize < C0101l.f575ay / 20) {
            textSize = C0101l.f575ay / 20;
        }
        ringBorder = textSize + 1.0f;
        return ringDiameter;
    }
}
