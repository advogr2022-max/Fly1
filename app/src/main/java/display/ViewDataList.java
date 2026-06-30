package display;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.xcglobe.xclog.ActivityDataList;
import com.xcglobe.xclog.C0096g;
import com.xcglobe.xclog.C0101l;

/* loaded from: classes.dex */
public class ViewDataList extends View {
    private static final int MAX_CLICK_DURATION = 200;
    public static int colorBack;
    public static int colorDivider;
    public static int colorText;
    public static int colorTextValue;
    static int itemHeight;
    public static Paint paint = new Paint();
    public static int sideOffset;
    static int textSize;
    static int width;
    ActivityDataList activityDataList;
    public boolean isTitle;
    String label;
    private long startClickTime;
    public boolean stateOpened;
    String unit;
    String value;

    public ViewDataList(Context context) {
        super(context);
        this.value = null;
        this.unit = null;
        this.isTitle = false;
        this.stateOpened = true;
        this.activityDataList = (ActivityDataList) context;
    }

    public ViewDataList(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.value = null;
        this.unit = null;
        this.isTitle = false;
        this.stateOpened = true;
    }

    public ViewDataList(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.value = null;
        this.unit = null;
        this.isTitle = false;
        this.stateOpened = true;
    }

    public ViewDataList(Context context, String str) {
        super(context);
        this.value = null;
        this.unit = null;
        this.isTitle = false;
        this.stateOpened = true;
        this.activityDataList = (ActivityDataList) context;
        init(str);
    }

    public ViewDataList(Context context, String str, String str2) {
        super(context);
        this.value = null;
        this.unit = null;
        this.isTitle = false;
        this.stateOpened = true;
        this.activityDataList = (ActivityDataList) context;
        init(str);
        this.unit = str2;
    }

    void init(String str) {
        if (str.length() <= 0 || str.charAt(0) != '#') {
            this.label = str;
        } else {
            this.label = str.substring(1);
            this.isTitle = true;
        }
        paint.set(C0096g.m501d());
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Paint paint2;
        int i2;
        int i3;
        Paint paint3;
        int i4;
        paint.setTextAlign(Paint.Align.LEFT);
        if (this.isTitle) {
            canvas.drawColor(colorDivider);
            paint2 = paint;
            i2 = colorBack;
        } else {
            paint2 = paint;
            i2 = colorText;
        }
        paint2.setColor(i2);
        float f2 = (int) ((itemHeight / 2) + (textSize * 0.4f));
        canvas.drawText(this.label, sideOffset, f2, paint);
        if (this.value != null) {
            paint.setTextAlign(Paint.Align.RIGHT);
            paint.setColor(colorTextValue);
            canvas.drawText(this.value, width, f2, paint);
        }
        if (this.isTitle) {
            i3 = itemHeight - 1;
            paint3 = paint;
            i4 = C0101l.f599x;
        } else {
            i3 = itemHeight - 1;
            paint3 = paint;
            i4 = colorDivider;
        }
        paint3.setColor(i4);
        float f3 = i3;
        canvas.drawLine(0.0f, f3, width - sideOffset, f3, paint);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        width = size;
        View.MeasureSpec.getSize(i3);
        textSize = size / 16;
        if (textSize > C0101l.f578c * 2) {
            textSize = C0101l.f578c * 2;
        }
        itemHeight = (int) ((textSize + 2) * 1.5f);
        paint.setTextSize(textSize);
        sideOffset = width / 100;
        setMeasuredDimension(width, itemHeight);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.isTitle) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 0:
                this.startClickTime = System.currentTimeMillis();
                break;
            case 1:
                if (System.currentTimeMillis() - this.startClickTime < 200) {
                    this.stateOpened = !this.stateOpened;
                    this.activityDataList.m403a(this);
                    break;
                }
                break;
        }
        return true;
    }

    public void update(float f2) {
        update(C0101l.f520E.format(f2));
    }

    public void update(float f2, int i2) {
        update((i2 == 2 ? C0101l.f521F : i2 == 5 ? C0101l.f522G : C0101l.f520E).format(f2));
    }

    public void update(int i2) {
        update(String.valueOf(i2));
    }

    public void update(String str) {
        this.value = str;
        if (this.unit != null) {
            this.value += " " + this.unit;
        }
        invalidate();
    }
}
