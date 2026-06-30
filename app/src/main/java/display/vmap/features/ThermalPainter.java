package display.vmap.features;

import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import com.xcglobe.xclog.C0101l;
import display.vmap.ViewVmp;
import flyme_data.C0239g;
import flyme_data.C0240h;
import types.C0370j;
import types.GpsVal;
import vmaps.core.VmpWorld;

/* loaded from: classes.dex */
public class ThermalPainter {
    static float radiusPx;
    static Paint paintCircles = new Paint();

    /* renamed from: pp */
    private static float[] f945pp = {0.0f, 0.0f};

    /* renamed from: xy */
    private static int[] f946xy = {0, 0};
    private static Path path = new Path();
    private static Paint trackPaint = new Paint();
    public static boolean optCirclinkgPath = false;
    public static boolean optQuadHelpers = false;
    private static VmpWorld terWorld = null;

    public static void create(ViewVmp viewVmp) {
        paintCircles.setStyle(Paint.Style.STROKE);
        terWorld = new VmpWorld(false);
        setWorld(viewVmp.world);
        trackPaint.setStrokeWidth(C0101l.f546aD);
        trackPaint.setStyle(Paint.Style.STROKE);
        trackPaint.setAntiAlias(true);
        trackPaint.setColor(C0101l.f591p);
        trackPaint.setAlpha(64);
        trackPaint.setStrokeJoin(Paint.Join.ROUND);
        trackPaint.setPathEffect(new CornerPathEffect(C0101l.f575ay / 30));
    }

    public static void draw(Canvas canvas) {
        GpsVal m1073d = C0239g.m1073d();
        terWorld.m1335a(m1073d.f1972a, m1073d.f1973b);
        zoomCorrection();
        radiusPx = C0239g.f1372C.f1454i * terWorld.m1354d();
        showTrackPath(canvas);
        if (C0101l.f560aj) {
            showVarioHelpers(canvas);
        }
        if (optCirclinkgPath) {
            shovCirclingPath(canvas);
        }
        if (optQuadHelpers) {
            showQuadHelpers(canvas);
        }
        showThermal(canvas);
    }

    private static void drawThermal3d(Canvas canvas, float f2, float f3) {
        paintCircles.setColor(C0101l.f585j);
        paintCircles.setStrokeWidth(C0101l.f544aB);
        float f4 = radiusPx;
        int size = C0239g.f1372C.f1458m.size();
        C0240h.a aVar = C0239g.f1372C.f1458m.get(size > 2 ? size - 2 : 0);
        terWorld.m1348b(aVar.f1472a, aVar.f1473b, f945pp);
        float f5 = 7;
        float f6 = (((int) f945pp[0]) - f2) / f5;
        float f7 = (((int) f945pp[1]) - f3) / f5;
        float f8 = (radiusPx / 2.0f) / f5;
        float f9 = f3;
        float f10 = f4;
        int i2 = 250;
        float f11 = f2;
        for (int i3 = 0; i3 < 7; i3++) {
            f11 += f6;
            f9 += f7;
            f10 -= f8;
            i2 -= 31;
            paintCircles.setAlpha(i2);
            canvas.drawCircle(f11, f9, f10, paintCircles);
        }
        paintCircles.setAlpha(255);
        paintCircles.setStrokeWidth(C0101l.f546aD);
        canvas.drawCircle(f2, f3, radiusPx, paintCircles);
    }

    private static float getIdealKmPerWidthForThermalMode() {
        return terWorld.m1352c() * ((C0239g.f1372C.f1454i * terWorld.m1354d()) / ((C0101l.f543aA ? terWorld.f2123f : terWorld.f2124g) / 8.0f));
    }

    public static void setWorld(VmpWorld vmpWorld) {
        terWorld.m1341a(vmpWorld);
        terWorld.m1334a(getIdealKmPerWidthForThermalMode());
    }

    private static void shovCirclingPath(Canvas canvas) {
        paintCircles.setStrokeWidth(C0101l.f546aD);
        paintCircles.setColor(C0101l.f588m);
        f945pp[0] = C0239g.f1372C.f1451f;
        f945pp[1] = C0239g.f1372C.f1452g;
        terWorld.m1350b(f945pp);
        canvas.drawCircle(f945pp[0], f945pp[1], radiusPx, paintCircles);
    }

    private static void showCore(Canvas canvas) {
        paintCircles.setStrokeWidth(C0101l.f546aD);
        paintCircles.setColor(C0101l.f585j);
        terWorld.m1348b(C0239g.f1372C.f1455j, C0239g.f1372C.f1456k, f945pp);
        canvas.drawCircle(f945pp[0], f945pp[1], radiusPx, paintCircles);
    }

    private static void showQuadHelpers(Canvas canvas) {
        paintCircles.setStyle(Paint.Style.FILL);
        float f2 = radiusPx / 4.0f;
        float f3 = radiusPx / 10.0f;
        float f4 = f2 / ((C0239g.f1372C.f1448c + C0239g.f1372C.f1449d) / 2.0f);
        for (int i2 = 0; i2 < 4; i2++) {
            terWorld.m1348b(C0239g.f1372C.f1459n[i2], C0239g.f1372C.f1460o[i2], f945pp);
            float f5 = C0239g.f1372C.f1461p[i2] * f4;
            paintCircles.setColor(f5 > 0.0f ? -16776961 : -65536);
            paintCircles.setAlpha(127);
            float abs = Math.abs(f5);
            if (abs > f2) {
                abs = f2;
            }
            canvas.drawCircle(f945pp[0], f945pp[1], abs + f3, paintCircles);
        }
        paintCircles.setStyle(Paint.Style.STROKE);
        paintCircles.setAlpha(255);
    }

    private static void showThermal(Canvas canvas) {
        if (C0239g.f1372C.f1458m.size() <= 0) {
            showCore(canvas);
            return;
        }
        C0240h.a m1092c = C0239g.f1372C.m1092c();
        terWorld.m1348b(m1092c.f1472a, m1092c.f1473b, f945pp);
        drawThermal3d(canvas, f945pp[0], f945pp[1]);
    }

    private static void showTrackPath(Canvas canvas) {
        int m819b = C0239g.f1415h.m819b() - 1;
        if (m819b < 2) {
            return;
        }
        int i2 = C0239g.f1372C.f1447b;
        if (i2 < 10) {
            i2 = 10;
        }
        path.rewind();
        int i3 = i2;
        for (int i4 = m819b; i4 > 0; i4--) {
            C0370j m817a = C0239g.f1415h.m817a(i4);
            i3--;
            if (i3 < 0) {
                break;
            }
            terWorld.m1338a(m817a.f1972a, m817a.f1973b, f946xy);
            float f2 = f946xy[0];
            float f3 = f946xy[1];
            if (i4 == m819b) {
                path.moveTo(f2, f3);
            } else {
                path.lineTo(f2, f3);
            }
        }
        canvas.drawPath(path, trackPaint);
    }

    private static void showVarioHelpers(Canvas canvas) {
        paintCircles.setColor(C0101l.f601z);
        paintCircles.setStyle(Paint.Style.FILL);
        paintCircles.setAlpha(200);
        int i2 = C0239g.f1372C.f1447b;
        float f2 = C0239g.f1372C.f1449d;
        float f3 = C0239g.f1372C.f1450e;
        float f4 = radiusPx / 3.0f;
        if (f4 > C0101l.f578c * 2) {
            f4 = C0101l.f578c * 2;
        }
        if (f3 < 0.0f) {
            f3 = 0.0f;
        }
        if (f2 > f3) {
            C0239g.f1372C.m1093d();
            do {
                C0240h.b m1089a = C0239g.f1372C.m1089a(1);
                if (m1089a == null) {
                    break;
                }
                if (m1089a.f1480d > 0.0f) {
                    f945pp[0] = m1089a.f1477a;
                    f945pp[1] = m1089a.f1478b;
                    terWorld.m1350b(f945pp);
                    canvas.drawCircle(f945pp[0], f945pp[1], Math.abs(((m1089a.f1480d - f3) * f4) / f2), paintCircles);
                }
                i2--;
            } while (i2 >= 0);
        }
        paintCircles.setStyle(Paint.Style.STROKE);
        paintCircles.setAlpha(255);
    }

    private static void zoomCorrection() {
        float m1354d = C0239g.f1372C.f1454i * terWorld.m1354d();
        float f2 = C0101l.f543aA ? terWorld.f2123f : terWorld.f2124g;
        if (m1354d > f2 / 5.0f || m1354d < f2 / 12.0f) {
            terWorld.m1334a((getIdealKmPerWidthForThermalMode() + terWorld.m1352c()) / 2.0f);
        }
    }
}
