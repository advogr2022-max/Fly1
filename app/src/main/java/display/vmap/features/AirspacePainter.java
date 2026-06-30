package display.vmap.features;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.xcglobe.xclog.C0096g;
import com.xcglobe.xclog.C0101l;
import display.vmap.ViewVmp;
import flyme_fileutil.C0001b;
import vmaps.C0379a;

/* loaded from: classes.dex */
public class AirspacePainter {
    public static boolean cfgEnabled = true;
    static Path pathAir;
    static ViewVmp view;

    public static void create(ViewVmp viewVmp) {
        pathAir = new Path();
        view = viewVmp;
    }

    public static void draw(Canvas canvas) {
        if (cfgEnabled) {
            Paint m495a = C0096g.m495a(C0101l.f545aC, C0101l.f516A);
            int size = C0379a.f2109b.f1981a.size();
            float[] fArr = {0.0f, 0.0f};
            for (int i2 = 0; i2 < size; i2++) {
                C0001b c0001b = C0379a.f2109b.f1981a.get(i2);
                m495a.setColor(c0001b.f7d == 0 ? C0101l.f517B : C0101l.f518C);
                m495a.setAlpha(160);
                pathAir.rewind();
                for (int i3 = 0; i3 < c0001b.f5b.length; i3++) {
                    fArr[0] = c0001b.f5b[i3] / 1000.0f;
                    fArr[1] = c0001b.f6c[i3] / 1000.0f;
                    view.world.m1350b(fArr);
                    view.matrix.mapPoints(fArr);
                    int i4 = (int) fArr[0];
                    int i5 = (int) fArr[1];
                    if (i3 == 0) {
                        pathAir.moveTo(i4, i5);
                    } else {
                        pathAir.lineTo(i4, i5);
                    }
                }
                canvas.drawPath(pathAir, m495a);
            }
        }
    }
}
