package display.vmap.features;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.xcglobe.xclog.ActivityMain;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0096g;
import com.xcglobe.xclog.C0101l;
import display.vmap.ViewVmp;
import flyme_data.C0238f;
import types.C0377q;
import vmaps.core.VmpWorld;

/* loaded from: classes.dex */
public class ZoomIconPainter {
    private static int r1 = 0;
    public static final float KM_PER_WIDTH_MAX = 5320.0f;
    public static final float KM_PER_WIDTH_MIN = 0.1f;
    private static int height = 0;
    private static long scaleHideTime = 0;
    private static int scaleTextSize = 0;
    private static int scaleTextY = 0;
    private static boolean scaleVisible = false;
    private static int width;
    private static VmpWorld world;
    private static int zoomIconMarginX;
    private static int zoomIconMarginY;
    public static int zoomIconSize;
    private static Path pathZoomPlus = new Path();
    private static Path pathZoomMinus = new Path();
    private static Path pathScale = new Path();
    private static Paint paintScaleFill = new Paint();
    public static Paint paintOutline = new Paint();
    private static long SCALE_TIMEOUT_MS = 1500;

    public static void create(ViewVmp viewVmp) {
        world = viewVmp.world;
        width = (int) world.f2123f;
        height = (int) world.f2124g;
        initZoomIcons(true);
    }

    private static void createZoomPaths(boolean z, int i2, int i3) {
        zoomIconMarginX = C0101l.f578c / 3;
        zoomIconMarginY = C0101l.f578c / 3;
        paintScaleFill.setColor(C0101l.f592q);
        paintScaleFill.setStyle(Paint.Style.FILL);
        paintScaleFill.setAlpha(128);
        scaleVisible = z;
        int[] iArr = {0, 1, 1, 1, 1, 0, 2, 0, 2, 1, 3, 1, 3, 2, 2, 2, 2, 3, 1, 3, 1, 2, 0, 2, 0, 1};
        int[] iArr2 = {0, 1, 3, 1, 3, 2, 0, 2, 0, 1};
        int i4 = zoomIconMarginY;
        int i5 = zoomIconSize / 3;
        int i6 = i5 / 2;
        int i7 = zoomIconMarginY + (i5 * 2) + i6;
        int i8 = width - (zoomIconMarginX * 2);
        int i9 = zoomIconMarginX;
        if (z) {
            i2 = i9 + (i6 * 2);
            i3 = (i9 + i8) - (i6 * 5);
            i4 = (i7 - i6) - (i6 / 2);
            i5 = i6;
        }
        pathZoomMinus.rewind();
        pathZoomMinus.moveTo((iArr2[0] * i5) + i2, (iArr2[1] * i5) + i4);
        for (int i10 = 2; i10 < iArr2.length; i10 += 2) {
            pathZoomMinus.lineTo((iArr2[i10] * i5) + i2, (iArr2[i10 + 1] * i5) + i4);
        }
        pathZoomPlus.rewind();
        pathZoomPlus.moveTo((iArr[0] * i5) + i3, (iArr[1] * i5) + i4);
        for (int i11 = 2; i11 < iArr.length; i11 += 2) {
            pathZoomPlus.lineTo((iArr[i11] * i5) + i3, (iArr[i11 + 1] * i5) + i4);
        }
        int i12 = zoomIconSize / 3;
        int[] iArr3 = {0, 0, 2, -2, 2, -1, 98, -1, 98, -2, 100, 0, 98, 2, 98, 1, 2, 1, 2, 2, 0, 0};
        int i13 = (i12 * 8) / 6;
        pathScale.rewind();
        pathScale.moveTo((iArr3[0] * i12) + i9, (iArr3[1] * i13) + i7);
        for (int i14 = 2; i14 < iArr3.length; i14 += 2) {
            float f2 = iArr3[i14];
            pathScale.lineTo(f2 > 50.0f ? i9 + i8 + ((f2 - 100.0f) * i12) : i9 + (i12 * f2), (iArr3[i14 + 1] * i13) + i7);
        }
        scaleTextSize = i13 * 2;
        scaleTextY = i7 + i12;
    }

    public static void draw(Canvas canvas) {
        if (scaleHideTime > 0) {
            drawScale(canvas);
        }
        canvas.drawPath(pathZoomMinus, paintScaleFill);
        canvas.drawPath(pathZoomPlus, paintScaleFill);
        Paint m497b = C0096g.m497b();
        float m1352c = world.m1352c();
        if (m1352c < 5320.0f) {
            canvas.drawPath(pathZoomMinus, m497b);
        }
        if (m1352c > 0.1f) {
            canvas.drawPath(pathZoomPlus, m497b);
        }
    }

    private static void drawScale(Canvas canvas) {
        StringBuilder sb;
        if (System.currentTimeMillis() > scaleHideTime) {
            initZoomIcons(false);
            return;
        }
        if (!scaleVisible) {
            initZoomIcons(true);
        }
        canvas.drawPath(pathScale, paintScaleFill);
        canvas.drawPath(pathScale, C0096g.m497b());
        Paint m500c = C0096g.m500c(scaleTextSize, C0101l.f591p);
        double m1352c = world.m1352c();
        Double.isNaN(m1352c);
        int i2 = (int) (m1352c + 0.5d);
        if (i2 < 5) {
            sb = new StringBuilder();
            sb.append(C0101l.f520E.format(C0377q.m1278a(r1)));
        } else {
            double m1278a = C0377q.m1278a(i2);
            Double.isNaN(m1278a);
            int i3 = (int) (m1278a + 0.5d);
            if (i3 > 100) {
                i3 = ((i3 + 4) / 10) * 10;
            } else if (i3 > 30) {
                i3 = ((i3 + 2) / 5) * 5;
            }
            sb = new StringBuilder();
            sb.append(i3);
        }
        sb.append(" ");
        sb.append(C0377q.f2082a);
        canvas.drawText(sb.toString(), width / 3, scaleTextY, m500c);
        if (C0238f.m1059d()) {
            return;
        }
        App.f462c.postDelayed(new Runnable() { // from class: display.vmap.features.-$$Lambda$ZoomIconPainter$o5JUd1wBVGoWjPV_8Mx6Wc3JSMs
            @Override // java.lang.Runnable
            public final void run() {
                ActivityMain.m413a(2);
            }
        }, SCALE_TIMEOUT_MS + 100);
    }

    public static void initZoomIcons(boolean z) {
        zoomIconSize = (width < height ? width : height) / 8;
        createZoomPaths(z, zoomIconMarginX, (width - zoomIconSize) - zoomIconMarginX);
        if (z) {
            setScaleVisible();
        }
    }

    private static void setScaleVisible() {
        scaleHideTime = System.currentTimeMillis() + SCALE_TIMEOUT_MS;
        ActivityMain.m414a(11, SCALE_TIMEOUT_MS + 10);
    }
}
