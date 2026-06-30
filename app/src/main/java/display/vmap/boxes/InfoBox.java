package display.vmap.boxes;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import com.xcglobe.xclog.C0096g;
import com.xcglobe.xclog.C0101l;
import vmaps.core.VmpWorld;

/* loaded from: classes.dex */
public abstract class InfoBox {
    public static int MARGIN_BOTTOM = 0;
    public static int MARGIN_LEFT = 0;
    public static int MARGIN_TOP = 0;
    public static int STATE_NONE = 0;
    public static int STATE_PRESSED = 1;
    static boolean alwaysDrawRect = false;
    public static Paint paintBack;
    public static Paint paintText;
    public static long timeMs;
    protected static VmpWorld world;
    protected String caption;
    protected int captionHeight;
    int captionY;
    protected float maxTextWidth;
    protected float measuredText;
    private int prevTextLength;
    protected String text;
    protected float textSize;
    int textX;
    int textY;
    public float unitSize;
    public float aspectRatio = 1.5f;
    protected int textLength = 3;
    boolean textIsDecimal = false;
    public boolean customPosition = false;
    public boolean customWidth = false;
    public float sizeFactor = 1.0f;
    protected Rect rec = new Rect();
    protected boolean showCaption = true;
    protected boolean captionVisible = true;
    private float prevMeasuredText = 0.0f;
    protected int state = 0;
    BoxSet parentSet = null;
    boolean docked = false;
    boolean isRightmost = false;
    boolean isBottommost = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Path createArrowPath(float f2) {
        float f3 = (int) (f2 / 5.0f);
        float f4 = 5.0f * f3;
        int i2 = (int) f2;
        Path path = new Path();
        path.rewind();
        float f5 = -i2;
        path.moveTo(0.0f, f5);
        float f6 = (3.0f * f3) + f3;
        float f7 = f5 + f4;
        path.lineTo(f6, f7);
        float f8 = f5 + (f4 * 0.8f);
        path.lineTo(f3, f8);
        float f9 = i2;
        path.lineTo(f3, f9);
        float f10 = -f3;
        path.lineTo(f10, f9);
        path.lineTo(f10, f8);
        path.lineTo(-f6, f7);
        path.close();
        return path;
    }

    public static void initStatic(VmpWorld vmpWorld) {
        world = vmpWorld;
        paintBack = new Paint();
        paintBack.setColor(C0101l.f592q);
        paintBack.setStyle(Paint.Style.FILL);
        paintText = new Paint();
        paintText.setColor(C0101l.f591p);
        paintText.setAntiAlias(true);
        paintText.setStyle(Paint.Style.FILL);
        paintText.setFakeBoldText(true);
        paintText.setStrokeWidth(C0101l.f578c / 6.0f);
        MARGIN_LEFT = (C0101l.f578c * 1) / 2;
        MARGIN_TOP = (C0101l.f578c * 1) / 4;
        MARGIN_BOTTOM = MARGIN_TOP * 2;
    }

    public Path createPointerPath(float f2) {
        Path path = new Path();
        float f3 = (18.0f * f2) / 10.0f;
        float tan = ((float) Math.tan(0.3141592653589793d)) * f3;
        float f4 = -f2;
        path.moveTo(0.0f, f4);
        float f5 = f3 - f2;
        path.lineTo(-tan, f5);
        path.lineTo(0.0f, f3 - ((f2 * 4.0f) / 3.0f));
        path.lineTo(tan, f5);
        path.lineTo(0.0f, f4);
        return path;
    }

    protected void draw(Canvas canvas) {
        if (this.text != null) {
            canvas.drawText(this.text, this.textX, this.textY, paintText);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void drawFrame(Canvas canvas) {
        if (this.parentSet == null || this.parentSet.takeChildSize) {
            Paint m497b = C0096g.m497b();
            if (!this.docked || alwaysDrawRect || this.customPosition) {
                canvas.drawRect(this.rec, m497b);
                return;
            }
            int i2 = LayoutManager.BORDER / 2;
            if (!this.isBottommost) {
                canvas.drawLine(this.rec.left + i2, this.rec.bottom + i2, this.rec.right - i2, this.rec.bottom + i2, m497b);
            }
            if (this.isRightmost) {
                return;
            }
            canvas.drawLine(this.rec.right + i2, this.rec.top + i2, this.rec.right + i2, this.rec.bottom - i2, m497b);
        }
    }

    protected abstract String getCaption();

    public int getState() {
        return this.state;
    }

    protected abstract String getText();

    public InfoBox getVisibleBox() {
        return this;
    }

    public boolean hasCustomPosition() {
        return this.customPosition;
    }

    public void initPosition(int i2, int i3) {
        this.rec.set(i2, i3, this.rec.width() + i2, this.rec.height() + i3);
        this.textY = this.rec.bottom - MARGIN_BOTTOM;
        this.textX = this.rec.left + MARGIN_LEFT;
        this.captionY = this.rec.top + C0101l.f578c;
        this.caption = getCaption();
        this.prevTextLength = 0;
    }

    public void initSize(float f2) {
        this.unitSize = f2;
        float f3 = f2 * this.sizeFactor;
        int i2 = (int) (this.aspectRatio * f3);
        int i3 = (int) f3;
        this.rec.set(0, 0, i2, i3);
        intCaptionVisibility(i2, i3);
        if (this.captionVisible) {
            i3 -= C0101l.f578c;
        }
        float f4 = (i3 - (MARGIN_TOP + MARGIN_BOTTOM)) * 1.2f;
        Paint paint = paintText;
        this.textSize = f4;
        paint.setTextSize(f4);
        this.maxTextWidth = i2 - (MARGIN_LEFT * 2);
        float measureText = (paintText.measureText(this.textIsDecimal ? "88.8" : "8888") / 4.0f) * this.textLength;
        if (measureText > this.maxTextWidth) {
            this.textSize = f4 * (this.maxTextWidth / measureText);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void intCaptionVisibility(int i2, int i3) {
        int measureText;
        if (!this.showCaption) {
            this.captionVisible = false;
            return;
        }
        String caption = getCaption();
        if (caption == null) {
            measureText = (int) ((caption != null ? caption.length() : 10) * C0101l.f579d * 0.8f);
        } else {
            measureText = ((int) C0096g.m500c(C0101l.f578c, C0101l.f591p).measureText(caption)) + (C0101l.f579d * 2);
        }
        this.captionVisible = i2 > measureText;
        if (i3 < C0101l.f578c * 4) {
            this.captionVisible = false;
        }
        this.captionHeight = this.captionVisible ? C0101l.f578c : 0;
    }

    public boolean isInside(int i2, int i3) {
        return this.rec.contains(i2, i3);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isTimeRotatable() {
        return true;
    }

    public boolean onClick() {
        return false;
    }

    public void onFinalized(LayoutManager layoutManager) {
    }

    public void onLayoutStart() {
    }

    public void onLongClick() {
    }

    public void onModeChanged(boolean z, boolean z2) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void onPosition() {
    }

    public void setState(int i2) {
        this.state = i2;
    }

    public void update(Canvas canvas) {
        int length;
        if (this.parentSet == null || this.customPosition) {
            paintBack.setColor(this.state == STATE_PRESSED ? C0101l.f587l : C0101l.f592q);
            canvas.drawRect(this.rec, paintBack);
        }
        if (this.captionVisible && this.caption != null) {
            paintText.setTextSize(C0101l.f578c);
            paintText.setTextAlign(Paint.Align.RIGHT);
            paintText.setColor(C0101l.f594s);
            canvas.drawText(this.caption, this.rec.right - MARGIN_LEFT, this.captionY, paintText);
            paintText.setTextAlign(Paint.Align.LEFT);
        }
        paintText.setColor(C0101l.f591p);
        paintText.setTextSize(this.textSize);
        this.text = getText();
        if (this.text != null && (length = this.text.length()) > this.textLength) {
            if (length != this.prevTextLength) {
                float measureText = paintText.measureText(this.text);
                this.prevMeasuredText = measureText;
                this.measuredText = measureText;
            }
            this.prevTextLength = length;
            if (this.prevMeasuredText > this.maxTextWidth) {
                float f2 = this.maxTextWidth / this.prevMeasuredText;
                paintText.setTextSize(this.textSize * f2);
                this.measuredText = this.prevMeasuredText * f2;
            }
        }
        draw(canvas);
        drawFrame(canvas);
    }
}
