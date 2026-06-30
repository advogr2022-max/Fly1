package display.vmap.features;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.xcglobe.xclog.C0096g;
import com.xcglobe.xclog.C0101l;
import display.vmap.ViewVmp;
import java.util.ArrayList;
import flyme_data.C0239g;
import types.C0364d;
import types.C0365e;
import types.C0367g;
import types.C0372l;
import types.C0377q;
import types.Coord;
import types.GpsVal;
import vmaps.core.VmpWorld;

/* loaded from: classes.dex */
public class FaiAssistant {
    private static int MIN_SIDE_KM = 1;
    private static boolean cfgDrawTriangle = true;
    static int lineWidth;
    private static int textFaiSize;
    private static float triangleMaxHeightKm;
    private static float triangleMinHeightKm;
    static ViewVmp view;
    static Line longestLine = new Line();
    static Line baseLine = new Line();
    static Path path = new Path();
    private static Paint paint = new Paint();

    /* renamed from: fa */
    private static C0364d f938fa = null;
    static C0367g currentBounds = new C0367g();
    private static long lastUpdateTimeMs = 0;
    public static boolean isReady = false;
    private static Coord pointGlider = new Coord();
    private static Coord baseCenter = new Coord();
    private static Coord triangleHi = new Coord();
    private static Coord triangleLo = new Coord();
    private static Coord triangleEqu = new Coord();
    private static Coord triangleWing1 = new Coord();
    private static Coord triangleWing2 = new Coord();
    private static Coord triangleHiExtended = new Coord();
    private static Coord wing1TopArcPoint = new Coord();
    private static Coord wing2TopArcPoint = new Coord();
    private static C0372l baseCenterGps = new C0372l();
    private static C0372l triangleHiGps = new C0372l();
    private static C0372l triangleLoGps = new C0372l();
    private static C0372l triangleEquGps = new C0372l();
    private static C0372l triangleWing1Gps = new C0372l();
    private static C0372l triangleWing2Gps = new C0372l();
    private static C0372l triangleHiExtendedGps = new C0372l();
    private static C0372l wing1TopArcPointGps = new C0372l();
    private static C0372l wing2TopArcPointGps = new C0372l();
    private static C0372l testPointGps = new C0372l();
    private static float[] xyTriLo = {0.0f, 0.0f};
    private static float[] xyTriHi = {0.0f, 0.0f};
    private static float[] xyWing1 = {0.0f, 0.0f};
    private static float[] xyWing2 = {0.0f, 0.0f};
    private static float[] xyBase1 = {0.0f, 0.0f};
    private static float[] xyBase2 = {0.0f, 0.0f};

    /* renamed from: cc */
    private static Coord f937cc = new Coord();
    private static Coord[] cc2 = new Coord[2];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes.dex */
    public static class Line {

        /* renamed from: c1 */
        Coord f939c1 = new Coord();

        /* renamed from: c2 */
        Coord f940c2 = new Coord();
        float distKm;

        /* renamed from: i1 */
        int f941i1;

        /* renamed from: i2 */
        int f942i2;
        float lat1;
        float lat2;
        float lng1;
        float lng2;

        Line() {
        }

        void set(int i2, int i3, float f2) {
            setIndex(i2, i3);
            GpsVal gpsVal = C0239g.f1414g.get(i2);
            GpsVal gpsVal2 = C0239g.f1414g.get(i3);
            setGps(gpsVal.f1972a, gpsVal.f1973b, gpsVal2.f1972a, gpsVal2.f1973b);
            this.distKm = f2;
        }

        void set(Line line) {
            set(line.f941i1, line.f942i2, line.distKm);
        }

        void setGps(float f2, float f3, float f4, float f5) {
            this.lat1 = f2;
            this.lng1 = f3;
            this.lat2 = f4;
            this.lng2 = f5;
        }

        void setIndex(int i2, int i3) {
            this.f941i1 = i2;
            this.f942i2 = i3;
        }
    }

    private static float calcMaxSymmetricSide(float f2) {
        return f2 * 1.2857144f;
    }

    private static float calcMaxUnsymmetricSide(float f2) {
        return f2 * 1.5714285f;
    }

    private static float calcMinSide(float f2) {
        return f2 / 1.5714285f;
    }

    private static void calcTriangleFrameKm(float f2, float f3, float f4) {
        Coord m1216b = C0365e.m1216b(baseLine.f939c1, baseCenter);
        f938fa.m1196a(m1216b, testPointGps);
        C0365e.m1214a(baseCenter, m1216b, baseCenter, triangleMaxHeightKm, cc2, false);
        triangleHi.m1168a(cc2[findNearPoint(pointGlider, cc2)]);
        C0365e.m1214a(baseCenter, m1216b, baseCenter, triangleMinHeightKm, cc2, false);
        triangleLo.m1168a(cc2[findNearPoint(triangleHi, cc2)]);
        C0365e.m1214a(baseCenter, m1216b, baseCenter, baseLine.distKm * 0.866f, cc2, false);
        triangleEqu.m1168a(cc2[findNearPoint(triangleHi, cc2)]);
        C0365e.m1211a(baseLine.f940c2, f4, baseLine.f939c1, baseLine.distKm, cc2);
        triangleWing1.m1168a(cc2[findNearPoint(triangleHi, cc2)]);
        C0365e.m1211a(baseLine.f939c1, f4, baseLine.f940c2, baseLine.distKm, cc2);
        triangleWing2.m1168a(cc2[findNearPoint(triangleHi, cc2)]);
        C0365e.m1214a(baseCenter, m1216b, baseCenter, triangleMaxHeightKm * 1.18f, cc2, false);
        triangleHiExtended.m1168a(cc2[findNearPoint(triangleHi, cc2)]);
        C0365e.m1217b(triangleLo, triangleWing1, f937cc);
        C0365e.m1214a(C0365e.m1216b(triangleLo, f937cc), f937cc, f937cc, f2 * 0.46f, cc2, false);
        wing1TopArcPoint.m1168a(cc2[findNearPoint(triangleHi, cc2)]);
        C0365e.m1207a(wing1TopArcPoint, baseCenter, triangleHi, wing2TopArcPoint);
    }

    private static void calcTriangleHeightsKm(float f2, float f3) {
        float f4 = baseLine.distKm / 2.0f;
        float f5 = f4 * f4;
        triangleMaxHeightKm = (float) Math.sqrt((f3 * f3) - f5);
        triangleMinHeightKm = (float) Math.sqrt((f2 * f2) - f5);
    }

    private static void convertKmToGps() {
        f938fa.m1196a(triangleHi, triangleHiGps);
        f938fa.m1196a(triangleLo, triangleLoGps);
        f938fa.m1196a(triangleEqu, triangleEquGps);
        f938fa.m1196a(baseCenter, baseCenterGps);
        f938fa.m1196a(triangleWing1, triangleWing1Gps);
        f938fa.m1196a(triangleWing2, triangleWing2Gps);
        f938fa.m1196a(triangleHiExtended, triangleHiExtendedGps);
        f938fa.m1196a(wing1TopArcPoint, wing1TopArcPointGps);
        f938fa.m1196a(wing2TopArcPoint, wing2TopArcPointGps);
    }

    public static void create(ViewVmp viewVmp) {
        view = viewVmp;
        f938fa = new C0364d(viewVmp.world.f2122e.f1998b, viewVmp.world.f2122e.f1999c);
        cc2[0] = new Coord();
        cc2[1] = new Coord();
        paint.setColor(C0101l.f585j);
        paint.setStyle(Paint.Style.FILL);
        paint.setAlpha(64);
        textFaiSize = (int) (C0101l.f578c * 1.3f);
        isReady = false;
    }

    private static float dist(GpsVal gpsVal) {
        return f938fa.m1199b(gpsVal.f1972a, gpsVal.f1973b);
    }

    /* JADX WARN: Type inference failed for: r6v35, types: [int, boolean] */
    public static void draw(Canvas canvas) {
        if (C0101l.f537V) {
            update();
            if (isReady) {
                f938fa = view.world.f2122e;
                VmpWorld vmpWorld = view.world;
                float[] fArr = {0.0f, 0.0f};
                vmpWorld.m1348b(triangleHiExtendedGps.f2053a, triangleHiExtendedGps.f2054b, fArr);
                view.matrix.mapPoints(fArr);
                float f2 = fArr[0];
                float f3 = fArr[1];
                vmpWorld.m1348b(triangleLoGps.f2053a, triangleLoGps.f2054b, xyTriLo);
                view.matrix.mapPoints(xyTriLo);
                vmpWorld.m1348b(triangleHiGps.f2053a, triangleHiGps.f2054b, xyTriHi);
                view.matrix.mapPoints(xyTriHi);
                vmpWorld.m1348b(triangleWing1Gps.f2053a, triangleWing1Gps.f2054b, xyWing1);
                view.matrix.mapPoints(xyWing1);
                vmpWorld.m1348b(triangleWing2Gps.f2053a, triangleWing2Gps.f2054b, xyWing2);
                view.matrix.mapPoints(xyWing2);
                if (cfgDrawTriangle) {
                    vmpWorld.m1348b(baseLine.lat1, baseLine.lng1, xyBase1);
                    view.matrix.mapPoints(xyBase1);
                    vmpWorld.m1348b(baseLine.lat2, baseLine.lng2, xyBase2);
                    view.matrix.mapPoints(xyBase2);
                    int m1353c = view.world.m1353c(xyBase1) ? 1 : 0;
                    int i2 = m1353c;
                    if (view.world.m1353c(xyBase2)) {
                        i2 = m1353c + 1;
                    }
                    int i3 = i2;
                    if (view.world.m1353c(xyTriLo)) {
                        i3 = i2 + 1;
                    }
                    if (i3 > 1) {
                        Paint m495a = C0096g.m495a(0.0f, C0101l.f585j);
                        canvas.drawLine(xyBase1[0], xyBase1[1], xyBase2[0], xyBase2[1], m495a);
                        canvas.drawLine(xyBase2[0], xyBase2[1], xyTriLo[0], xyTriLo[1], m495a);
                        canvas.drawLine(xyTriLo[0], xyTriLo[1], xyBase1[0], xyBase1[1], m495a);
                    }
                }
                path.rewind();
                vmpWorld.m1348b(wing1TopArcPointGps.f2053a, wing1TopArcPointGps.f2054b, fArr);
                view.matrix.mapPoints(fArr);
                path.moveTo(xyTriLo[0], xyTriLo[1]);
                path.quadTo(fArr[0], fArr[1], xyWing1[0], xyWing1[1]);
                path.quadTo(f2, f3, xyWing2[0], xyWing2[1]);
                vmpWorld.m1348b(wing2TopArcPointGps.f2053a, wing2TopArcPointGps.f2054b, fArr);
                view.matrix.mapPoints(fArr);
                path.quadTo(fArr[0], fArr[1], xyTriLo[0], xyTriLo[1]);
                canvas.drawPath(path, paint);
                drawKmText(canvas);
            }
        }
    }

    private static void drawKmText(Canvas canvas) {
        float f2 = baseLine.distKm / 0.28f;
        float f3 = baseLine.distKm / 0.44f;
        StringBuilder sb = new StringBuilder();
        double m1278a = C0377q.m1278a(f3);
        Double.isNaN(m1278a);
        sb.append(String.valueOf((int) (m1278a + 0.5d)));
        sb.append(" ");
        sb.append(C0377q.f2082a);
        String sb2 = sb.toString();
        StringBuilder sb3 = new StringBuilder();
        double m1278a2 = C0377q.m1278a(f2);
        Double.isNaN(m1278a2);
        sb3.append(String.valueOf((int) (m1278a2 + 0.5d)));
        sb3.append(" ");
        sb3.append(C0377q.f2082a);
        String sb4 = sb3.toString();
        Paint paint2 = PoiPainter.paintOutline;
        paint2.setTextSize(textFaiSize);
        canvas.drawText(sb2, xyTriLo[0], xyTriLo[1], paint2);
        canvas.drawText(sb4, xyTriHi[0], xyTriHi[1], paint2);
        paint2.setTextSize(C0101l.f578c);
        Paint m500c = C0096g.m500c(textFaiSize, C0101l.f586k);
        canvas.drawText(sb2, xyTriLo[0], xyTriLo[1], m500c);
        canvas.drawText(sb4, xyTriHi[0], xyTriHi[1], m500c);
    }

    private static void findBaseLine() {
        ArrayList<GpsVal> arrayList = C0239g.f1414g;
        int i2 = 1;
        int i3 = 0;
        float f2 = 0.0f;
        int i4 = 0;
        while (i2 <= longestLine.f941i1) {
            moveFa(arrayList.get(i2));
            int i5 = i4;
            int i6 = i3;
            int i7 = 0;
            while (i7 < i2) {
                float dist = dist(arrayList.get(i7));
                if (dist > f2) {
                    i5 = i2;
                    i6 = i7;
                    f2 = dist;
                } else if (dist < f2 / 2.0f) {
                    i7 += 8;
                }
                i7++;
            }
            i2++;
            i3 = i6;
            i4 = i5;
        }
        moveFa(arrayList.get(i3));
        float dist2 = dist(arrayList.get(longestLine.f942i2));
        double d2 = f2;
        double d3 = longestLine.distKm;
        Double.isNaN(d3);
        if (d2 <= d3 * 0.6d || dist2 <= longestLine.distKm / 2.0f) {
            baseLine.set(longestLine);
        } else {
            int i8 = ((longestLine.f941i1 - i4) / 3) + i4;
            int i9 = i3;
            while (i9 < i8) {
                float dist3 = dist(arrayList.get(i9));
                if (dist3 > f2) {
                    i4 = i9;
                    f2 = dist3;
                } else if (dist3 < f2 / 2.0f) {
                    i9 += 8;
                }
                i9++;
            }
            baseLine.set(i3, i4, f2);
        }
        restoreFa();
    }

    private static boolean findLongestLine() {
        C0367g c0367g = new C0367g();
        c0367g.m1226a(currentBounds, -0.001f, -0.001f);
        ArrayList<GpsVal> arrayList = C0239g.f1414g;
        int size = arrayList.size();
        boolean z = true;
        int i2 = 0;
        int i3 = 0;
        float f2 = 0.0f;
        for (int i4 = 1; i4 < size; i4++) {
            GpsVal gpsVal = arrayList.get(i4);
            if (!c0367g.m1232b(gpsVal)) {
                f938fa.m1194a(gpsVal.f1972a, gpsVal.f1973b);
                float f3 = f2;
                int i5 = i3;
                int i6 = i2;
                for (int i7 = 0; i7 < i4; i7++) {
                    GpsVal gpsVal2 = arrayList.get(i7);
                    if (!c0367g.m1232b(gpsVal2)) {
                        float m1199b = f938fa.m1199b(gpsVal2.f1972a, gpsVal2.f1973b);
                        if (m1199b > f3) {
                            i5 = i4;
                            i6 = i7;
                            f3 = m1199b;
                        }
                    }
                }
                i2 = i6;
                i3 = i5;
                f2 = f3;
            }
        }
        if (i2 == longestLine.f941i1 && i3 == longestLine.f942i2) {
            z = false;
        }
        longestLine.set(i2, i3, f2);
        restoreFa();
        return z;
    }

    private static int findNearPoint(Coord coord, Coord[] coordArr) {
        return C0365e.m1204a(coord, coordArr[0]) < C0365e.m1204a(coord, coordArr[1]) ? 0 : 1;
    }

    private static void moveFa(GpsVal gpsVal) {
        f938fa.m1194a(gpsVal.f1972a, gpsVal.f1973b);
    }

    private static void restoreFa() {
        f938fa.m1194a(view.world.f2122e.f1998b, view.world.f2122e.f1999c);
    }

    private static boolean update() {
        long j2 = C0239g.m1073d().f1975d;
        if (currentBounds.m1228a(C0239g.f1413f) && j2 - lastUpdateTimeMs < 60000) {
            return true;
        }
        if (C0239g.f1414g.size() < 2) {
            isReady = false;
            return false;
        }
        isReady = true;
        currentBounds.m1229b(C0239g.f1413f);
        f938fa = new C0364d(view.world.f2122e.f1998b, view.world.f2122e.f1999c);
        updateFrame();
        if (longestLine.distKm < MIN_SIDE_KM) {
            isReady = false;
            return false;
        }
        if (C0239g.f1414g.get(baseLine.f941i1).f1973b > C0239g.f1414g.get(baseLine.f942i2).f1973b) {
            int i2 = baseLine.f941i1;
            int i3 = baseLine.f942i2;
        }
        f938fa.m1195a(baseLine.lat1, baseLine.lng1, baseLine.f939c1);
        f938fa.m1195a(baseLine.lat2, baseLine.lng2, baseLine.f940c2);
        GpsVal m1073d = C0239g.m1073d();
        f938fa.m1195a(m1073d.f1972a, m1073d.f1973b, pointGlider);
        C0365e.m1217b(baseLine.f939c1, baseLine.f940c2, baseCenter);
        float calcMinSide = calcMinSide(baseLine.distKm);
        float calcMaxSymmetricSide = calcMaxSymmetricSide(baseLine.distKm);
        float calcMaxUnsymmetricSide = calcMaxUnsymmetricSide(baseLine.distKm);
        calcTriangleHeightsKm(calcMinSide, calcMaxSymmetricSide);
        calcTriangleFrameKm(calcMinSide, calcMaxSymmetricSide, calcMaxUnsymmetricSide);
        convertKmToGps();
        return false;
    }

    private static void updateFrame() {
        if (findLongestLine()) {
            findBaseLine();
        }
    }
}
