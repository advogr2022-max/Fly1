package display.vmap.features;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import com.xcglobe.xclog.C0096g;
import com.xcglobe.xclog.C0101l;
import com.xcglobe.xclog.FlyMeService;
import display.vmap.ViewVmp;
import flyme_device.C0172d;

/* loaded from: classes.dex */
public class StatusMsg {
    private static int textX;
    private static int textX2;
    private static int textY;
    protected static Rect rec = new Rect();
    private static final int MARGIN_LEFT = C0101l.f579d / 2;
    public static final int height = (int) (C0101l.f578c * 1.1f);
    private static ViewVmp view = null;

    public static void create(ViewVmp viewVmp) {
        view = viewVmp;
        rec.set(0, 0, height * 10, height);
        textY = rec.bottom - ((int) (C0101l.f578c * 0.2f));
        textX = MARGIN_LEFT;
    }

    public static void draw(Canvas canvas) {
        String str;
        String m456a = FlyMeService.m456a(true);
        if (view.world.m1346a()) {
            m456a = m456a + " [updating]";
        }
        Paint m501d = C0096g.m501d();
        int measureText = ((int) m501d.measureText(m456a)) + MARGIN_LEFT;
        if (C0172d.m668b()) {
            textX2 = measureText;
            str = " (" + C0172d.m669c() + ")";
            measureText = (int) (measureText + m501d.measureText(str) + MARGIN_LEFT);
        } else {
            str = null;
        }
        rec.right = rec.left + measureText;
        m501d.setColor(C0101l.f592q);
        m501d.setAlpha(160);
        canvas.drawRect(rec, m501d);
        m501d.setAlpha(255);
        m501d.setColor(C0101l.f591p);
        canvas.drawText(m456a, textX, textY, m501d);
        if (str != null) {
            m501d.setColor(C0101l.f590o);
            canvas.drawText(str, textX2, textY, m501d);
        }
    }
}
