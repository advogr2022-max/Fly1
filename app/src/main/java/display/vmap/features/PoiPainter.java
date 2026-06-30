package display.vmap.features;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0094e;
import com.xcglobe.xclog.C0096g;
import com.xcglobe.xclog.C0101l;
import display.vmap.ViewVmp;
import java.util.ArrayList;
import java.util.Arrays;
import types.C0366f;
import types.PoiPoint;
import vmaps.core.VmpWorld;

/* loaded from: classes.dex */
public class PoiPainter {
    private static Bitmap bmpPoiMap;
    static Paint paintOutline;
    private static Paint paintThermal;
    private static PoiPoint[] poiList;
    private static byte[] poiMask;
    private static int poiMaskBlockHeight;
    private static int poiMaskBlockWidth;
    private static int poiMaskHeight;
    private static int poiMaskSize;
    private static int poiMaskWidth;
    private static Rect poiRecDst;
    private static ViewVmp view;
    private static VmpWorld world;
    private static float[] pts = {0.0f, 0.0f};

    /* renamed from: xy */
    private static int[] f943xy = {0, 0};
    private static Rect[] poiRecSrc = new Rect[4];
    private static boolean cfgEnabled = true;
    private static boolean goalVisible = false;
    private static boolean goalOnFirstPosition = false;

    public static void create(ViewVmp viewVmp) {
        view = viewVmp;
        world = viewVmp.world;
        if (bmpPoiMap == null) {
            createOnce();
        }
    }

    private static void createOnce() {
        poiRecDst = new Rect();
        paintOutline = new Paint();
        paintThermal = new Paint();
        poiList = new PoiPoint[0];
        bmpPoiMap = BitmapFactory.decodeResource(App.m443b().getResources(), R.drawable.poimap);
        int width = bmpPoiMap.getWidth() / 4;
        int height = bmpPoiMap.getHeight();
        int i2 = 0;
        while (i2 < 4) {
            int i3 = i2 + 1;
            poiRecSrc[i2] = new Rect(i2 * width, 0, i3 * width, height);
            i2 = i3;
        }
        paintThermal.setStyle(Paint.Style.FILL);
        paintThermal.setColor(C0101l.f585j);
        paintThermal.setAlpha(128);
        paintThermal.setAntiAlias(false);
        paintThermal.setDither(false);
        float f2 = C0101l.f578c / 7.0f;
        paintOutline.set(C0096g.m501d());
        paintOutline.setColor(Color.parseColor("#f0fff0"));
        paintOutline.setStyle(Paint.Style.STROKE);
        paintOutline.setStrokeWidth(f2);
        paintOutline.setShadowLayer(f2 * 1.0f, 0.0f, 0.0f, -1);
    }

    public static void drawPoi(Canvas canvas) {
        int i2;
        int i3;
        int i4;
        float f2;
        int i5;
        Object obj;
        char c2;
        if (cfgEnabled) {
            int i6 = (int) world.f2123f;
            int i7 = (int) world.f2124g;
            Paint m500c = C0096g.m500c(C0101l.f578c, C0101l.f595t);
            int length = poiList.length;
            float f3 = C0101l.f578c / 2;
            int i8 = C0101l.f578c / 8;
            int width = bmpPoiMap.getWidth() / 4;
            int height = bmpPoiMap.getHeight();
            float m1352c = world.m1352c();
            if (m1352c > 18.0f) {
                f3 /= 2.0f;
            }
            if (m1352c > 25.0f) {
                f3 /= 2.0f;
            }
            if (m1352c > 32.0f) {
                f3 /= 2.0f;
            }
            Object obj2 = null;
            char c3 = 0;
            if (C0366f.f2003a != null && goalOnFirstPosition) {
                pts[0] = C0366f.f2003a.f1976i;
                pts[1] = C0366f.f2003a.f1977j;
                world.m1350b(pts);
                view.matrix.mapPoints(pts);
                int i9 = (int) pts[0];
                int i10 = (int) pts[1];
                float width2 = RingPainter.bmpGoal.getWidth() / 2;
                canvas.drawBitmap(C0094e.f488a, i9 - width2, i10 - width2, (Paint) null);
            }
            goalVisible = false;
            float[] fArr = {0.0f, 0.0f};
            int i11 = 0;
            while (i11 < length) {
                PoiPoint poiPoint = poiList[i11];
                fArr[c3] = poiPoint.f1976i;
                fArr[1] = poiPoint.f1977j;
                world.m1350b(fArr);
                view.matrix.mapPoints(fArr);
                int i12 = (int) fArr[c3];
                int i13 = (int) fArr[1];
                if (i12 <= 0 || i12 >= i6 || i13 <= 0 || i13 >= i7) {
                    i2 = i6;
                    i3 = i7;
                    i4 = length;
                    f2 = f3;
                    i5 = i8;
                    obj = obj2;
                } else {
                    char c4 = poiPoint.f1980m;
                    if (c4 == 'l') {
                        c2 = 1;
                    } else if (c4 != 'w') {
                        switch (c4) {
                            case 's':
                                c2 = 2;
                                break;
                            case 't':
                                canvas.drawCircle(i12, i13, f3, paintThermal);
                                i2 = i6;
                                i3 = i7;
                                i4 = length;
                                f2 = f3;
                                i5 = i8;
                                obj = null;
                                continue;
                            default:
                                c2 = 0;
                                break;
                        }
                    } else {
                        c2 = 3;
                    }
                    i2 = i6;
                    float f4 = i13;
                    i3 = i7;
                    canvas.drawCircle(i12, f4, i8, m500c);
                    int i14 = i13 - ((height - (height / 8)) - 1);
                    int i15 = width / 2;
                    int i16 = i12 - i15;
                    i4 = length;
                    f2 = f3;
                    i5 = i8;
                    poiRecDst.set(i16, i14, i16 + width, i14 + height);
                    obj = null;
                    canvas.drawBitmap(bmpPoiMap, poiRecSrc[c2], poiRecDst, (Paint) null);
                    float f5 = i12 + i15;
                    canvas.drawText(poiPoint.f1979l, f5, f4, paintOutline);
                    canvas.drawText(poiPoint.f1979l, f5, f4, m500c);
                    if (i11 == 0 && goalOnFirstPosition) {
                        goalVisible = true;
                        i11++;
                        obj2 = obj;
                        i6 = i2;
                        i7 = i3;
                        length = i4;
                        f3 = f2;
                        i8 = i5;
                        c3 = 0;
                    }
                }
                i11++;
                obj2 = obj;
                i6 = i2;
                i7 = i3;
                length = i4;
                f3 = f2;
                i8 = i5;
                c3 = 0;
            }
        }
    }

    public static boolean isGoalVisible() {
        return goalVisible;
    }

    public static void reloadLocalPoints() {
        if (world == null) {
            return;
        }
        world.m1338a(world.f2129l.f2012a, world.f2129l.f2014c, f943xy);
        int i2 = f943xy[0];
        int i3 = f943xy[1];
        world.m1338a(world.f2129l.f2013b, world.f2129l.f2015d, f943xy);
        int abs = Math.abs(f943xy[0] - i2);
        int abs2 = Math.abs(f943xy[1] - i3);
        poiMaskBlockWidth = C0101l.f579d * 10;
        poiMaskBlockHeight = poiMaskBlockWidth;
        poiMaskWidth = (abs / poiMaskBlockWidth) + 1;
        poiMaskHeight = (abs2 / poiMaskBlockHeight) + 1;
        poiMaskSize = poiMaskWidth * poiMaskHeight;
        if (poiMask == null || poiMaskSize != poiMask.length) {
            poiMask = new byte[poiMaskSize];
        }
        PoiPoint[] poiPointArr = C0101l.f568ar.f498b;
        Arrays.fill(poiMask, (byte) 0);
        ArrayList arrayList = new ArrayList();
        if (C0366f.f2003a != null) {
            pts[0] = C0366f.f2003a.f1976i;
            pts[1] = C0366f.f2003a.f1977j;
            world.m1350b(pts);
            view.matrix.mapPoints(pts);
            int i4 = (poiMaskWidth * (((int) pts[1]) / poiMaskBlockHeight)) + (((int) pts[0]) / poiMaskBlockWidth);
            if (i4 > 0 && i4 < poiMaskSize) {
                poiMask[i4] = 1;
                arrayList.add(C0366f.f2003a);
            }
        }
        goalOnFirstPosition = arrayList.size() > 0;
        boolean z = world.m1352c() < 50.0f;
        for (PoiPoint poiPoint : poiPointArr) {
            if (z || poiPoint.f1980m != 't') {
                pts[0] = poiPoint.f1976i;
                pts[1] = poiPoint.f1977j;
                world.m1350b(pts);
                view.matrix.mapPoints(pts);
                int i5 = (poiMaskWidth * (((int) pts[1]) / poiMaskBlockHeight)) + (((int) pts[0]) / poiMaskBlockWidth);
                if (i5 > 0 && i5 < poiMaskSize && (poiMask[i5] == 0 || poiPoint.f1980m == 'l' || poiPoint.f1980m == 't')) {
                    poiMask[i5] = 1;
                    arrayList.add(poiPoint);
                }
            }
        }
        poiList = (PoiPoint[]) arrayList.toArray(new PoiPoint[0]);
    }
}
