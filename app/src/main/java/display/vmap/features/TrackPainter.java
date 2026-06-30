package display.vmap.features;

import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import com.xcglobe.xclog.C0096g;
import com.xcglobe.xclog.C0101l;
import display.vmap.ViewVmp;
import java.util.ArrayList;
import flyme_data.C0239g;
import types.C0370j;
import types.GpsVal;
import vmaps.core.VmpWorld;

/* loaded from: classes.dex */
public class TrackPainter {
    private static CornerPathEffect cornerEffect;
    private static int fastMovedPoints;
    private static float lastCenterLat;
    private static float lastCenterLng;
    private static int lastX;
    private static int lastY;
    private static long nextAllowedTimeMs;
    private static int ofsX;
    private static int ofsY;
    private static int pathSize;
    private static int pathWidth;
    private static ArrayList<GpsVal> points;
    private static VmpWorld world;
    private static Path path = new Path();
    private static Paint trackPaint = new Paint();
    private static int[] worldOfs = {0, 0};

    /* renamed from: xy */
    private static int[] f947xy = {0, 0};

    public static void create(ViewVmp viewVmp, ArrayList<GpsVal> arrayList, int i2) {
        world = viewVmp.world;
        points = arrayList;
        int i3 = (C0101l.f575ay / 470) + 1;
        Paint paint = trackPaint;
        int i4 = i3 * 2;
        pathWidth = i4;
        paint.setStrokeWidth(i4);
        trackPaint.setStyle(Paint.Style.STROKE);
        trackPaint.setAntiAlias(true);
        trackPaint.setColor(C0101l.f591p);
        trackPaint.setAlpha(128);
        trackPaint.setStrokeJoin(Paint.Join.ROUND);
        cornerEffect = new CornerPathEffect(C0101l.f575ay / 30);
        trackPaint.setPathEffect(cornerEffect);
        recreate();
    }

    public static void draw(Canvas canvas, boolean z) {
        canvas.save();
        canvas.translate(-ofsX, -ofsY);
        if (z) {
            trackPaint.setColor(-1);
            trackPaint.setStrokeWidth(pathWidth + 3);
            canvas.drawPath(path, trackPaint);
            trackPaint.setColor(C0101l.f591p);
            trackPaint.setStrokeWidth(pathWidth);
        }
        canvas.drawPath(path, trackPaint);
        canvas.restore();
    }

    private static void drawEndPoint(Canvas canvas, float f2, float f3) {
        Paint m500c = C0096g.m500c(C0101l.f578c, C0101l.f590o);
        m500c.setStrokeWidth(pathWidth);
        float f4 = C0101l.f578c / 3;
        float f5 = f2 - f4;
        float f6 = f3 - ((C0101l.f578c * 3) / 4);
        canvas.drawLine(f2, f3, f5, f6, m500c);
        float f7 = f4 + f2;
        canvas.drawLine(f5, f6, f7, f6, m500c);
        canvas.drawLine(f7, f6, f2, f3, m500c);
        m500c.setStrokeWidth(0.0f);
    }

    public static void drawEndPoints(Canvas canvas) {
        if (points.size() > 2) {
            canvas.save();
            canvas.translate(-ofsX, -ofsY);
            GpsVal gpsVal = points.get(0);
            world.m1338a(gpsVal.f1972a, gpsVal.f1973b, f947xy);
            drawEndPoint(canvas, f947xy[0], f947xy[1]);
            GpsVal gpsVal2 = points.get(points.size() - 1);
            world.m1338a(gpsVal2.f1972a, gpsVal2.f1973b, f947xy);
            drawEndPoint(canvas, f947xy[0], f947xy[1]);
            canvas.restore();
        }
    }

    public static void moveTo(GpsVal gpsVal) {
        if (pathSize < 10 || fastMovedPoints > 200) {
            recreate();
            return;
        }
        world.m1338a(lastCenterLat, lastCenterLng, f947xy);
        ofsX = worldOfs[0] - f947xy[0];
        ofsY = worldOfs[1] - f947xy[1];
        world.m1338a(gpsVal.f1972a, gpsVal.f1973b, f947xy);
        int i2 = f947xy[0] + ofsX;
        int i3 = f947xy[1] + ofsY;
        if (i2 == lastX && i3 == lastY) {
            return;
        }
        if (gpsVal.f1975d < nextAllowedTimeMs) {
            path.setLastPoint(i2, i3);
        } else {
            path.lineTo(i2, i3);
            nextAllowedTimeMs = gpsVal.f1975d + 1000;
            fastMovedPoints++;
            pathSize++;
        }
        lastX = i2;
        lastY = i3;
    }

    public static void recreate() {
        int size;
        Paint paint;
        CornerPathEffect cornerPathEffect;
        if (world == null) {
            return;
        }
        if (world.m1352c() <= 1.0f) {
            recreateFine();
            return;
        }
        pathSize = 0;
        path.rewind();
        nextAllowedTimeMs = 0L;
        fastMovedPoints = 0;
        ofsY = 0;
        ofsX = 0;
        if (points != null && (size = points.size()) >= 3) {
            GpsVal gpsVal = points.get(0);
            world.m1338a(gpsVal.f1972a, gpsVal.f1973b, f947xy);
            path.moveTo(f947xy[0], f947xy[1]);
            int i2 = f947xy[0];
            int i3 = f947xy[0];
            int i4 = C0101l.f578c / 4;
            int i5 = ((int) world.f2123f) * 4;
            int i6 = ((int) world.f2124g) * 4;
            int i7 = i3;
            int i8 = i2;
            int i9 = 1;
            while (i9 < size) {
                GpsVal gpsVal2 = points.get(i9);
                world.m1338a(gpsVal2.f1972a, gpsVal2.f1973b, f947xy);
                if (i9 == size - 1 || Math.abs(i8 - f947xy[0]) > i4 || Math.abs(i7 - f947xy[1]) > i4) {
                    i8 = f947xy[0];
                    i7 = f947xy[1];
                    path.lineTo(i8, i7);
                    pathSize++;
                    if (i8 <= (-i5) || i8 >= i5 || i7 <= (-i6) || i7 >= i6) {
                        i9 += 5;
                    }
                }
                i9++;
            }
            lastX = i8;
            lastY = i7;
            lastCenterLat = world.f2122e.f1998b;
            lastCenterLng = world.f2122e.f1999c;
            world.m1345a(worldOfs);
            if (world.m1352c() > 4.0f) {
                paint = trackPaint;
                cornerPathEffect = null;
            } else {
                paint = trackPaint;
                cornerPathEffect = cornerEffect;
            }
            paint.setPathEffect(cornerPathEffect);
        }
    }

    public static void recreateFine() {
        Paint paint;
        CornerPathEffect cornerPathEffect;
        pathSize = 0;
        path.rewind();
        nextAllowedTimeMs = 0L;
        fastMovedPoints = 0;
        ofsY = 0;
        ofsX = 0;
        int m819b = C0239g.f1415h.m819b();
        if (m819b < 3) {
            return;
        }
        long j2 = C0239g.f1415h.m823e().f1975d - 60000;
        int i2 = C0101l.f578c / 4;
        long j3 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = true;
        for (int i5 = 2; i5 < m819b; i5++) {
            C0370j m817a = C0239g.f1415h.m817a(i5);
            if (m817a.f1975d >= j2 && m817a.f1975d - j3 >= 1000) {
                world.m1338a(m817a.f1972a, m817a.f1973b, f947xy);
                if (z) {
                    path.moveTo(f947xy[0], f947xy[1]);
                    i3 = f947xy[0];
                    i4 = f947xy[1];
                    j3 = m817a.f1975d;
                    z = false;
                } else if (i5 == m819b || Math.abs(i3 - f947xy[0]) > i2 || Math.abs(i4 - f947xy[1]) > i2) {
                    i3 = f947xy[0];
                    i4 = f947xy[1];
                    path.lineTo(i3, i4);
                    pathSize++;
                    j3 = m817a.f1975d;
                }
            }
        }
        lastX = i3;
        lastY = i4;
        lastCenterLat = world.f2122e.f1998b;
        lastCenterLng = world.f2122e.f1999c;
        world.m1345a(worldOfs);
        if (world.m1352c() > 4.0f) {
            paint = trackPaint;
            cornerPathEffect = null;
        } else {
            paint = trackPaint;
            cornerPathEffect = cornerEffect;
        }
        paint.setPathEffect(cornerPathEffect);
    }
}
