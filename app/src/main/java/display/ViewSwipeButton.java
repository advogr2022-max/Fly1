package display;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0096g;
import com.xcglobe.xclog.C0101l;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class ViewSwipeButton extends View {
    // private static int r0 = 0;
    // private static int r1 = 0;
    int ITEM_MARGIN_X;
    int ITEM_MARGIN_Y;
    int backColor;
    Callback callback;
    final GestureDetector gdt;
    int height;
    int highlightColor;
    int itemHeight;
    ArrayList<Item> items;
    int itemsWidth;
    Paint paintFill;
    Paint paintGray;
    Paint paintTextShadow;
    int scrollOffset;
    boolean selectedCentered;
    int selectedIndex;
    int swipeOffset;
    boolean swiped;
    float textSize;
    public String title;
    int titleHeight;
    int width;
    int xLeft;
    int xRight;
    int yTop;

    /* loaded from: classes.dex */
    public interface Callback {
        void call(int i2);
    }

    /* loaded from: classes.dex */
    private class GestureListener implements GestureDetector.OnGestureListener {
        private GestureListener() {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            ViewSwipeButton.this.swipeOffset = 0;
            ViewSwipeButton.this.swiped = false;
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            ViewSwipeButton.this.invalidate();
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (ViewSwipeButton.this.itemsWidth > ViewSwipeButton.this.width) {
                int i2 = ViewSwipeButton.this.scrollOffset;
                // ViewSwipeButton.this.scrollOffset = ...;
                ViewSwipeButton.this.swipeOffset = (int) (motionEvent.getX() - motionEvent2.getX());
                if (Math.abs(ViewSwipeButton.this.swipeOffset) > C0101l.f578c * 2 || Math.abs(ViewSwipeButton.this.scrollOffset) > C0101l.f578c * 2) {
                    ViewSwipeButton.this.swiped = true;
                }
                int i3 = ViewSwipeButton.this.itemsWidth - ViewSwipeButton.this.width;
                if (ViewSwipeButton.this.scrollOffset < 0) {
                    ViewSwipeButton.this.scrollOffset = 0;
                } else if (ViewSwipeButton.this.scrollOffset > i3) {
                    ViewSwipeButton.this.scrollOffset = i3;
                }
                if (i2 != ViewSwipeButton.this.scrollOffset) {
                    ViewSwipeButton.this.invalidate();
                }
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            ViewSwipeButton.this.invalidate();
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class Item {
        Bitmap bmp;

        /* renamed from: id */
        int f933id;
        String title;
        int width;
        int xLast;

        private Item() {
        }
    }

    public ViewSwipeButton(Context context) {
        super(context);
        this.gdt = new GestureDetector(new GestureListener());
        this.items = new ArrayList<>();
        this.selectedIndex = 0;
        this.itemsWidth = 0;
        this.scrollOffset = 0;
        this.swipeOffset = 0;
        this.swiped = false;
        this.callback = null;
        this.title = "title";
        this.textSize = C0101l.f580e;
        this.selectedCentered = false;
        this.paintFill = new Paint();
        this.paintTextShadow = new Paint();
        this.backColor = C0101l.f593r;
        this.highlightColor = Color.parseColor("#004080");
        this.paintGray = new Paint();
        init();
    }

    public ViewSwipeButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gdt = new GestureDetector(new GestureListener());
        this.items = new ArrayList<>();
        this.selectedIndex = 0;
        this.itemsWidth = 0;
        this.scrollOffset = 0;
        this.swipeOffset = 0;
        this.swiped = false;
        this.callback = null;
        this.title = "title";
        this.textSize = C0101l.f580e;
        this.selectedCentered = false;
        this.paintFill = new Paint();
        this.paintTextShadow = new Paint();
        this.backColor = C0101l.f593r;
        this.highlightColor = Color.parseColor("#004080");
        this.paintGray = new Paint();
        init();
    }

    public ViewSwipeButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.gdt = new GestureDetector(new GestureListener());
        this.items = new ArrayList<>();
        this.selectedIndex = 0;
        this.itemsWidth = 0;
        this.scrollOffset = 0;
        this.swipeOffset = 0;
        this.swiped = false;
        this.callback = null;
        this.title = "title";
        this.textSize = C0101l.f580e;
        this.selectedCentered = false;
        this.paintFill = new Paint();
        this.paintTextShadow = new Paint();
        this.backColor = C0101l.f593r;
        this.highlightColor = Color.parseColor("#004080");
        this.paintGray = new Paint();
        init();
    }

    private void drawItems(Canvas canvas) {
        int size = this.items.size();
        if (size == 0) {
            return;
        }
        for (int i2 = 0; i2 < size; i2++) {
            Item item = this.items.get(i2);
            int i3 = this.xLeft + (item.width * i2);
            int i4 = this.yTop + this.ITEM_MARGIN_Y;
            int i5 = i3 - this.scrollOffset;
            item.xLast = i5;
            if (i2 == this.selectedIndex) {
                canvas.drawBitmap(item.bmp, i5, i4, (Paint) null);
                highlightSelected(canvas, item, i4);
            } else {
                canvas.drawBitmap(item.bmp, i5, i4, this.paintGray);
            }
        }
        if (this.selectedCentered || this.selectedIndex == -1) {
            return;
        }
        centerSelected(this.items.get(this.selectedIndex));
    }

    public void add(int i2, String str, int i3) {
        Item item = new Item();
        item.title = str;
        item.bmp = BitmapFactory.decodeResource(App.m443b().getResources(), i3);
        item.f933id = i2;
        item.width = item.bmp.getWidth() + (this.ITEM_MARGIN_X * 3);
        this.items.add(item);
        this.itemsWidth += item.width;
        this.selectedCentered = false;
    }

    public void centerSelected(Item item) {
        int i2 = 0;
        if (this.itemsWidth < this.width) {
            this.scrollOffset = ((-(this.width - this.itemsWidth)) / 2) - (this.ITEM_MARGIN_X / 2);
        } else {
            if (item.xLast < this.ITEM_MARGIN_X) {
                i2 = this.scrollOffset + (item.xLast - this.ITEM_MARGIN_X);
            } else if (item.xLast + item.width > this.width) {
                i2 = this.scrollOffset + (((item.xLast + item.width) - this.width) - (this.ITEM_MARGIN_X * 2));
            }
            this.scrollOffset = i2;
        }
        invalidate();
        this.selectedCentered = true;
    }

    public void changeDimensions() {
        LinearLayout.LayoutParams layoutParams;
        int i2;
        int height;
        int i3 = 0;
        for (int i4 = 0; i4 < this.items.size(); i4++) {
            Item item = this.items.get(i4);
            if (item.bmp != null && (height = item.bmp.getHeight()) > i3) {
                i3 = height;
            }
        }
        if (i3 != 0) {
            i2 = i3 + this.titleHeight + (this.ITEM_MARGIN_Y * 2);
            layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
        } else {
            if (this.items.size() != 0) {
                return;
            }
            layoutParams = (LinearLayout.LayoutParams) getLayoutParams();
            i2 = this.titleHeight;
        }
        layoutParams.height = i2;
        setLayoutParams(layoutParams);
    }

    void clickItem(int i2) {
        if (i2 != -1) {
            this.selectedIndex = i2;
            Item item = this.items.get(this.selectedIndex);
            centerSelected(item);
            if (this.callback != null) {
                this.callback.call(item.f933id);
            }
        }
    }

    protected int findPressedItem(int i2) {
        for (int i3 = 0; i3 < this.items.size(); i3++) {
            Item item = this.items.get(i3);
            if (i2 > item.xLast && i2 < item.xLast + item.width) {
                return i3;
            }
        }
        return -1;
    }

    void highlightSelected(Canvas canvas, Item item, int i2) {
        int i3 = this.ITEM_MARGIN_X;
        int width = item.bmp.getWidth() + item.xLast;
        int height = item.bmp.getHeight() + i2;
        int i4 = i3 / 2;
        Paint m495a = C0096g.m495a(i3, this.highlightColor);
        m495a.setAlpha(100);
        // canvas.drawRect(r1...);
        m495a.setAlpha(255);
    }

    protected void init() {
        this.ITEM_MARGIN_X = (int) (this.textSize / 3.0f);
        this.ITEM_MARGIN_Y = (int) ((this.textSize * 3.0f) / 4.0f);
        this.titleHeight = (int) (this.textSize * 1.5f);
        this.paintTextShadow.set(C0096g.m501d());
        this.paintTextShadow.setTextSize(this.textSize);
        this.paintTextShadow.setColor(this.highlightColor);
        this.paintGray.setAlpha(100);
        this.paintFill.setColor(Color.parseColor("#d0d0d0"));
        setOnTouchListener(new View.OnTouchListener() { // from class: display.ViewSwipeButton.1
            @Override // android.view.View.OnTouchListener
            @SuppressLint({"ClickableViewAccessibility"})
            public boolean onTouch(View view, MotionEvent motionEvent) {
                int findPressedItem;
                if (motionEvent.getAction() == 1) {
                    if (!ViewSwipeButton.this.swiped && (findPressedItem = ViewSwipeButton.this.findPressedItem((int) motionEvent.getX())) != ViewSwipeButton.this.selectedIndex && findPressedItem != -1) {
                        ViewSwipeButton.this.clickItem(findPressedItem);
                    }
                    ViewSwipeButton.this.swipeOffset = 0;
                    ViewSwipeButton.this.swiped = false;
                }
                return ViewSwipeButton.this.gdt.onTouchEvent(motionEvent);
            }
        });
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        String str;
        canvas.drawColor(this.backColor);
        canvas.drawRect(0.0f, 0.0f, this.width, this.titleHeight, this.paintFill);
        drawItems(canvas);
        if (this.items.size() > 0) {
            str = this.title + ": ";
        } else {
            str = this.title;
        }
        float f2 = (int) (((this.titleHeight - this.textSize) / 2.0f) + (this.textSize * 0.9f));
        canvas.drawText(str, this.xLeft, f2, C0096g.m500c(this.textSize, -16777216));
        if (this.items.size() > 0) {
            canvas.drawText(this.items.get(this.selectedIndex).title, this.xLeft + this.paintTextShadow.measureText(str) + this.textSize, f2, this.paintTextShadow);
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        this.width = View.MeasureSpec.getSize(i2);
        this.height = View.MeasureSpec.getSize(i3);
        setMeasuredDimension(this.width, this.height);
        this.xLeft = this.ITEM_MARGIN_X;
        this.xRight = this.width;
        this.itemHeight = (this.height - this.ITEM_MARGIN_Y) - (((int) this.textSize) + this.ITEM_MARGIN_Y);
        this.yTop = this.titleHeight;
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public boolean select(int i2) {
        for (int i3 = 0; i3 < this.items.size(); i3++) {
            if (this.items.get(i3).f933id == i2) {
                this.selectedIndex = i3;
                invalidate();
                return true;
            }
        }
        return false;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }
}
