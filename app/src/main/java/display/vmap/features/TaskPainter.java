package display.vmap.features;

import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import com.xcglobe.xclog.C0096g;
import com.xcglobe.xclog.C0101l;
import display.vmap.ViewVmp;
import flyme_poi.C0227a;
import flyme_poi.C0229c;
import flyme_data.C0239g;
import types.C0362b;
import types.C0365e;
import types.C0366f;
import types.GpsVal;

/* loaded from: classes.dex */
public class TaskPainter {
    private static int r4 = 0;
    private static int r10 = 0;
    private static int rN = 0;
    static DashPathEffect dashPathEffect;

    /* renamed from: pp */
    private static float[] f944pp = {0.0f, 0.0f};
    static float[] pps = {0.0f, 0.0f, 0.0f, 0.0f};
    static C0362b rec = new C0362b();
    private static ViewVmp view;

    public static void create(ViewVmp viewVmp) {
        view = viewVmp;
        float f2 = C0101l.f575ay / 48;
        dashPathEffect = new DashPathEffect(new float[]{f2, (r4 * 3) / 4}, f2);
    }

    private static void drawFinishLine(Canvas canvas, Paint paint) {
        C0227a c0227a = C0227a.f1276a;
        pps[0] = c0227a.f1291o[0].f2053a;
        pps[1] = c0227a.f1291o[0].f2054b;
        pps[2] = c0227a.f1291o[1].f2053a;
        pps[3] = c0227a.f1291o[1].f2054b;
        view.world.m1344a(pps);
        view.matrix.mapPoints(pps);
        canvas.drawLine(pps[0], pps[1], pps[2], pps[3], paint);
    }

    public static void drawGoalLine(Canvas canvas) {
        GpsVal m1073d = C0239g.m1073d();
        float[] fArr = {m1073d.f1972a, m1073d.f1973b, C0366f.f2003a.f1976i, C0366f.f2003a.f1977j};
        view.world.m1344a(fArr);
        view.matrix.mapPoints(fArr);
        Paint m497b = C0096g.m497b();
        m497b.setPathEffect(dashPathEffect);
        int i2 = C0101l.f578c / 4;
        m497b.setStrokeWidth(i2 * 2);
        m497b.setColor(C0101l.f588m);
        canvas.drawLine(fArr[0], fArr[1], fArr[2], fArr[3], m497b);
        m497b.setStrokeWidth(i2);
        m497b.setColor(C0101l.f519D);
        canvas.drawLine(fArr[0], fArr[1], fArr[2], fArr[3], m497b);
        if (C0366f.f2009g) {
            m497b.setColor(C0101l.f594s);
            m497b.setAlpha(200);
            C0229c m1008j = C0227a.f1276a.m1008j();
            if (m1008j != null) {
                view.world.m1348b(m1008j.f1318h.f2053a, m1008j.f1318h.f2054b, f944pp);
                view.matrix.mapPoints(f944pp);
                canvas.drawLine(fArr[2], fArr[3], f944pp[0], f944pp[1], m497b);
            }
            m497b.setPathEffect(null);
            if (C0227a.f1276a.f1296t && C0227a.f1276a.f1289m && C0227a.f1276a.f1291o != null) {
                m497b.setColor(-65536);
                drawFinishLine(canvas, m497b);
            } else {
                C0229c c0229c = C0227a.f1276a.f1284h;
                f944pp[0] = c0229c.f1976i;
                f944pp[1] = c0229c.f1977j;
                view.world.m1350b(f944pp);
                view.matrix.mapPoints(f944pp);
                canvas.drawCircle(f944pp[0], f944pp[1], C0365e.m1203a(f944pp[0], f944pp[1], fArr[2], fArr[3]), m497b);
            }
        }
        m497b.setPathEffect(null);
        m497b.setStrokeWidth(0.0f);
        m497b.setColor(C0101l.f516A);
    }

    public static void drawTask(Canvas canvas) {
        int i2;
        int i3;
        Paint paint;
        C0229c c0229c;
        int i4;
        int i5;
        Canvas canvas2;
        Paint paint2;
        Canvas canvas3 = canvas;
        int size = C0227a.f1276a.f1279c.size();
        C0227a c0227a = C0227a.f1276a;
        if (c0227a == null) {
            return;
        }
        Paint m499c = C0096g.m499c();
        float f2 = C0101l.f578c / 4;
        m499c.setStrokeWidth(f2);
        m499c.setColor(C0101l.f594s);
        m499c.setAlpha(128);
        int i6 = C0101l.f578c / 2;
        int i7 = (C0101l.f578c * 5) / 4;
        Paint m500c = C0096g.m500c(0.0f, C0101l.f588m);
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i10 < size) {
            C0229c c0229c2 = c0227a.f1279c.get(i10);
            if (c0229c2 == null) {
                i2 = i8;
                canvas2 = canvas3;
                Paint paint3 = m500c;
                i4 = i9;
                i5 = i10;
                paint2 = paint3;
            } else {
                view.world.m1348b(c0229c2.f1318h.f2053a, c0229c2.f1318h.f2054b, f944pp);
                view.matrix.mapPoints(f944pp);
                i2 = (int) f944pp[0];
                int i11 = (int) f944pp[1];
                if (i10 > 0) {
                    m499c.setPathEffect(dashPathEffect);
                    m499c.setColor(C0101l.f588m);
                    m499c.setStrokeWidth(r10 * 2);
                    float f3 = i8;
                    float f4 = i9;
                    float f5 = i2;
                    float f6 = i11;
                    paint = m500c;
                    c0229c = c0229c2;
                    i4 = i11;
                    i3 = i10;
                    canvas.drawLine(f3, f4, f5, f6, m499c);
                    m499c.setColor(C0101l.f519D);
                    m499c.setStrokeWidth(f2);
                    canvas.drawLine(f3, f4, f5, f6, m499c);
                    m499c.setPathEffect(null);
                } else {
                    i3 = i10;
                    paint = m500c;
                    c0229c = c0229c2;
                    i4 = i11;
                    m499c.setColor(C0101l.f590o);
                    m499c.setStrokeWidth(r10 / 2);
                    float f7 = i2;
                    float f8 = i4;
                    float f9 = i2 - i6;
                    float f10 = i4 - i7;
                    canvas.drawLine(f7, f8, f9, f10, m499c);
                    float f11 = i2 + i6;
                    canvas.drawLine(f9, f10, f11, f10, m499c);
                    canvas.drawLine(f11, f10, f7, f8, m499c);
                }
                i5 = i3;
                if (i5 == size - 1 && c0227a.f1289m) {
                    m499c.setColor(-65536);
                    canvas2 = canvas;
                    drawFinishLine(canvas2, m499c);
                } else {
                    canvas2 = canvas;
                    C0229c c0229c3 = c0229c;
                    f944pp[0] = c0229c3.f1976i;
                    f944pp[1] = c0229c3.f1977j;
                    view.world.m1350b(f944pp);
                    view.matrix.mapPoints(f944pp);
                    float m1203a = C0365e.m1203a(f944pp[0], f944pp[1], i2, i4);
                    m499c.setColor(C0101l.f586k);
                    m499c.setStrokeWidth(r10 / 2);
                    canvas2.drawCircle(f944pp[0], f944pp[1], m1203a, m499c);
                }
                paint2 = paint;
                canvas2.drawCircle(i2, i4, f2, paint2);
            }
            canvas3 = canvas2;
            i8 = i2;
            Paint paint4 = paint2;
            i10 = i5 + 1;
            i9 = i4;
            m500c = paint4;
        }
        m499c.setPathEffect(null);
    }
}
