package display.vmap;

import android.os.Handler;
import android.view.MotionEvent;
import com.xcglobe.xclog.ActivityMain;
import display.vmap.boxes.InfoBox;
import display.vmap.features.ZoomIconPainter;

/* loaded from: classes.dex */
public class VmpEventManager {
    public static int ZOOM_MINUS = 1;
    public static int ZOOM_PLUS = 2;
    private float downX;
    private float downY;
    private boolean fingerDragging = false;
    private float[] fingerGps = null;
    Handler handler = new Handler();
    InfoBox pressedBox = null;
    private boolean touchEmptySpace;
    ViewVmp view;

    public VmpEventManager(ViewVmp viewVmp) {
        this.view = viewVmp;
    }

    private void cancelTouch() {
        this.handler.removeCallbacksAndMessages(null);
        this.fingerGps = null;
        this.fingerDragging = false;
        if (this.pressedBox != null) {
            this.pressedBox.setState(InfoBox.STATE_NONE);
            this.pressedBox = null;
        }
        this.view.invalidate();
    }

    private InfoBox getBox(int i2, int i3) {
        int size = this.view.boxes.size();
        for (int i4 = 0; i4 < size; i4++) {
            InfoBox infoBox = this.view.boxes.get(i4);
            if (infoBox.isInside(i2, i3)) {
                return infoBox;
            }
        }
        return null;
    }

    private int getZoomIcon(int i2, int i3) {
        double d2 = i3;
        double d3 = ZoomIconPainter.zoomIconSize;
        Double.isNaN(d3);
        if (d2 >= d3 * 1.5d) {
            return 0;
        }
        double d4 = i2;
        double d5 = ZoomIconPainter.zoomIconSize;
        Double.isNaN(d5);
        if (d4 < d5 * 1.5d) {
            return ZOOM_MINUS;
        }
        float f2 = i2;
        if (f2 <= this.view.world.f2123f - (ZoomIconPainter.zoomIconSize * 2) || f2 >= this.view.world.f2123f) {
            return 0;
        }
        return ZOOM_PLUS;
    }

    public boolean action(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            this.fingerDragging = false;
            this.downX = motionEvent.getX();
            this.downY = motionEvent.getY();
            int i2 = (int) this.downX;
            int i3 = (int) this.downY;
            this.touchEmptySpace = false;
            int zoomIcon = getZoomIcon(i2, i3);
            if (zoomIcon != 0) {
                this.view.clickZoomIcon(zoomIcon == ZOOM_PLUS);
                return true;
            }
            InfoBox box = getBox(i2, i3);
            this.pressedBox = box;
            if (box != null) {
                this.handler.removeCallbacksAndMessages(null);
                this.pressedBox.setState(InfoBox.STATE_PRESSED);
            } else {
                this.touchEmptySpace = true;
                ZoomIconPainter.initZoomIcons(true);
                this.fingerGps = new float[]{this.view.world.f2122e.f1998b, this.view.world.f2122e.f1999c};
            }
            this.view.invalidate();
            startLongPress();
            return true;
        }
        if (action != 1) {
            if (action == 2) {
                if (this.pressedBox != null) {
                    this.pressedBox.setState(this.pressedBox.isInside((int) motionEvent.getX(), (int) motionEvent.getY()) ? InfoBox.STATE_PRESSED : InfoBox.STATE_NONE);
                    return true;
                }
                if (this.view.optDraggable && this.fingerGps != null && this.view.fingerMove(motionEvent.getX() - this.downX, motionEvent.getY() - this.downY, this.fingerGps[0], this.fingerGps[1])) {
                    this.handler.removeCallbacksAndMessages(null);
                    this.fingerDragging = true;
                    this.view.invalidate();
                }
            } else if (action == 3 || action == 1) {
                if (this.fingerDragging && this.fingerGps != null) {
                    this.view.world.m1336a(this.view.world.f2122e.f1998b, this.view.world.f2122e.f1999c, this.view.world.m1352c());
                    this.view.invalidate();
                }
            }
            return false;
        }
        if (this.pressedBox != null) {
            this.pressedBox.onClick();
        } else if (this.touchEmptySpace && !this.fingerDragging) {
            if (!this.view.optStatic) {
                ViewVmp.setFlag(16);
            }
            this.view.performClick();
        }
        cancelTouch();
        return false;
    }

    public boolean isDraggingMap() {
        return this.fingerDragging;
    }

    protected void longClick() {
        if (this.pressedBox == null) {
            ActivityMain.m413a(23);
        } else if (this.pressedBox.getState() == InfoBox.STATE_PRESSED) {
            new VmpEditor(this.view).editBox(this.pressedBox);
        }
        cancelTouch();
    }

    public void startLongPress() {
        this.handler.postDelayed(new Runnable() { // from class: display.vmap.VmpEventManager.1
            @Override // java.lang.Runnable
            public void run() {
                VmpEventManager.this.longClick();
            }
        }, 500L);
    }
}
