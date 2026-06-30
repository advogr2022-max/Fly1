package display.vmap.boxes;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0094e;
import com.xcglobe.xclog.C0101l;
import flyme_dialogs.flyme_dialogs_a.DialogC0195a;
import flyme_dialogs.flyme_dialogs_b.DialogC0198b;
import flyme_intentutil.C0225a;
import flyme_data.C0239g;
import types.C0366f;
import types.C0377q;
import types.PoiPoint;

/* loaded from: classes.dex */
public class BoxBuddy extends InfoBox {
    private int buddyDirection;
    private String clickSelect;
    int dist;
    private Path pathPointer;
    private int radius;
    int xBmp;
    int xBmpText;
    int xPointer;
    int yBmp;
    int yPointer;
    private int buddyId = 0;
    private String buddyName = "-";
    private int visibleBuddyId = -1;
    private PoiPoint visibleGoal = null;

    public BoxBuddy() {
        this.aspectRatio = 2.0f;
        this.textLength = 0;
        this.clickSelect = App.m435a(R.string.click_to_select);
    }

    private void calculateBitmapPosition() {
        this.xBmp = this.rec.left + C0101l.f579d;
        this.yBmp = (this.rec.top + (this.rec.height() / 2)) - (C0094e.f488a.getHeight() / 2);
        this.xBmpText = this.xBmp + C0094e.f488a.getWidth();
    }

    private void drawPointer(Canvas canvas, int i2) {
        canvas.save();
        canvas.translate(this.xPointer, this.yPointer);
        canvas.rotate(i2);
        paintText.setColor(C0101l.f590o);
        canvas.drawPath(this.pathPointer, paintText);
        canvas.restore();
        paintText.setColor(C0101l.f591p);
    }

    @Override // display.vmap.boxes.InfoBox
    protected void draw(Canvas canvas) {
        String str;
        int i2;
        if (this.buddyId != this.visibleBuddyId) {
            this.caption = getCaption();
            intCaptionVisibility(this.rec.width(), this.rec.height());
            this.visibleBuddyId = this.buddyId;
        }
        if (this.buddyId == 0) {
            if (this.xBmp == 0) {
                calculateBitmapPosition();
            }
            canvas.drawBitmap(C0094e.f488a, this.xBmp, this.yBmp, (Paint) null);
            paintText.setTextSize(C0101l.f578c);
            str = this.text;
            i2 = this.xBmpText;
        } else {
            drawPointer(canvas, this.buddyDirection - C0239g.f1420m);
            paintText.setStyle(Paint.Style.FILL_AND_STROKE);
            paintText.setColor(C0101l.f591p);
            canvas.drawText(this.text, this.textX, this.textY, paintText);
            paintText.setStyle(Paint.Style.FILL);
            paintText.setColor(C0101l.f585j);
            str = this.text;
            i2 = this.textX;
        }
        canvas.drawText(str, i2, this.textY, paintText);
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getCaption() {
        StringBuilder sb;
        String m435a;
        this.visibleGoal = C0366f.f2003a;
        if (this.buddyId != 0) {
            sb = new StringBuilder();
            m435a = this.buddyName;
        } else {
            sb = new StringBuilder();
            m435a = App.m435a(R.string.goal);
        }
        sb.append(m435a);
        sb.append(" ");
        sb.append(C0377q.f2082a);
        return sb.toString();
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getText() {
        return this.buddyId != 0 ? this.clickSelect : C0225a.m978a(this.buddyId) == null ? "-" : "xxx";
    }

    @Override // display.vmap.boxes.InfoBox
    public boolean onClick() {
        DialogC0195a.m829a(App.m434a(), C0239g.m1073d(), null);
        DialogC0198b.m833a(App.m434a(), C0239g.m1073d(), C0366f.f2003a, true, new DialogC0198b.a() { // from class: display.vmap.boxes.BoxBuddy.1
            @Override // flyme_dialogs.flyme_dialogs_b.DialogC0198b.a
            public void call(PoiPoint poiPoint) {
                C0366f.m1222a(poiPoint, false);
            }
        });
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // display.vmap.boxes.InfoBox
    public void onPosition() {
        int height;
        int i2;
        if (this.captionVisible) {
            height = this.rec.height();
            i2 = this.captionHeight;
        } else {
            height = this.rec.height();
            i2 = C0101l.f578c / 2;
        }
        this.radius = ((height - i2) / 2) - MARGIN_TOP;
        this.pathPointer = createArrowPath(this.radius);
        this.xPointer = this.rec.left + this.radius + MARGIN_LEFT;
        this.yPointer = (this.rec.bottom - this.radius) - MARGIN_BOTTOM;
        this.textX = this.xPointer + this.radius;
        this.maxTextWidth = (this.rec.width() - (this.radius * 2)) - (MARGIN_LEFT * 2);
    }
}
