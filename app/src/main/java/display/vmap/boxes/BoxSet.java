package display.vmap.boxes;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import com.xcglobe.xclog.C0096g;
import com.xcglobe.xclog.C0101l;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class BoxSet extends InfoBox {
    private static final long ROTATE_TIME = 3000;
    public ArrayList<InfoBox> boxes = new ArrayList<>();
    int index = 0;
    Rect outRec = new Rect();
    boolean takeChildSize = false;
    long nextRotateTimeMs = 0;

    public BoxSet() {
        this.showCaption = false;
    }

    private void rotateIndex() {
        this.nextRotateTimeMs = System.currentTimeMillis() + ROTATE_TIME;
        int i2 = this.index + 1;
        this.index = i2;
        if (i2 >= this.boxes.size()) {
            this.index = 0;
        }
        setIndex(this.index);
    }

    private void setIndex(int i2) {
        this.index = i2;
        setRec();
    }

    private void setRec() {
        if (this.boxes.size() == 0) {
            return;
        }
        Rect rect = this.takeChildSize ? this.boxes.get(this.index).rec : this.rec;
        this.outRec.set(rect.left - 2, rect.top - 2, rect.right + 2, rect.bottom + 2);
        if (this.takeChildSize) {
            this.rec.set(rect);
        }
    }

    private void timeRotation() {
        if (!this.boxes.get(this.index).isTimeRotatable()) {
            this.nextRotateTimeMs = System.currentTimeMillis() + ROTATE_TIME;
            return;
        }
        int i2 = this.index;
        for (int i3 = 0; i3 < this.boxes.size(); i3++) {
            i2++;
            if (i2 >= this.boxes.size()) {
                i2 = 0;
            }
            if (this.boxes.get(i2).isTimeRotatable()) {
                rotateIndex();
                return;
            }
        }
    }

    public void add(InfoBox infoBox) {
        this.boxes.add(infoBox);
        setIndex(this.boxes.size() - 1);
        if (infoBox.customWidth) {
            this.customWidth = true;
        }
        infoBox.parentSet = this;
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getCaption() {
        return null;
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getText() {
        return null;
    }

    @Override // display.vmap.boxes.InfoBox
    public InfoBox getVisibleBox() {
        return this.index < this.boxes.size() ? this.boxes.get(this.index) : this;
    }

    @Override // display.vmap.boxes.InfoBox
    public boolean hasCustomPosition() {
        for (int i2 = 0; i2 < this.boxes.size(); i2++) {
            if (this.boxes.get(i2).customPosition) {
                return true;
            }
        }
        return false;
    }

    @Override // display.vmap.boxes.InfoBox
    public void initPosition(int i2, int i3) {
        super.initPosition(i2, i3);
        int width = this.rec.width();
        int height = this.rec.height();
        for (int i4 = 0; i4 < this.boxes.size(); i4++) {
            InfoBox infoBox = this.boxes.get(i4);
            int width2 = infoBox.rec.width();
            int height2 = infoBox.rec.height();
            if (this.takeChildSize) {
                infoBox.initPosition(this.rec.left, this.rec.bottom - height2);
            } else {
                infoBox.initPosition(((width - width2) / 2) + i2, ((height - height2) / 2) + i3);
            }
        }
    }

    @Override // display.vmap.boxes.InfoBox
    public void initSize(float f2) {
        super.initSize(f2);
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.boxes.size(); i4++) {
            InfoBox infoBox = this.boxes.get(i4);
            infoBox.initSize(f2);
            int width = infoBox.rec.width();
            int height = infoBox.rec.height();
            if (width > i2) {
                i2 = width;
            }
            if (height > i3) {
                i3 = height;
            }
        }
        this.rec.set(0, 0, i2, i3);
    }

    @Override // display.vmap.boxes.InfoBox
    public boolean isInside(int i2, int i3) {
        if (this.rec.contains(i2, i3)) {
            return true;
        }
        return this.boxes.get(this.index).rec.contains(i2, i3);
    }

    @Override // display.vmap.boxes.InfoBox
    public boolean onClick() {
        if (!this.boxes.get(this.index).onClick()) {
            rotateIndex();
        }
        this.nextRotateTimeMs = System.currentTimeMillis() + 15000;
        return true;
    }

    @Override // display.vmap.boxes.InfoBox
    public void onFinalized(LayoutManager layoutManager) {
        for (int i2 = 0; i2 < this.boxes.size(); i2++) {
            this.boxes.get(i2).onFinalized(layoutManager);
        }
        super.onFinalized(layoutManager);
        setRec();
    }

    @Override // display.vmap.boxes.InfoBox
    public void onModeChanged(boolean z, boolean z2) {
        for (int i2 = 0; i2 < this.boxes.size(); i2++) {
            this.boxes.get(i2).onModeChanged(z, z2);
        }
    }

    @Override // display.vmap.boxes.InfoBox
    public void onPosition() {
        super.onPosition();
        for (int i2 = 0; i2 < this.boxes.size(); i2++) {
            this.boxes.get(i2).onPosition();
        }
        setRec();
    }

    @Override // display.vmap.boxes.InfoBox
    public void setState(int i2) {
        for (int i3 = 0; i3 < this.boxes.size(); i3++) {
            this.boxes.get(i3).setState(i2);
        }
        this.state = i2;
    }

    @Override // display.vmap.boxes.InfoBox
    public void update(Canvas canvas) {
        if (System.currentTimeMillis() > this.nextRotateTimeMs) {
            timeRotation();
        }
        if (this.index >= this.boxes.size()) {
            return;
        }
        InfoBox infoBox = this.boxes.get(this.index);
        paintBack.setColor(this.state == STATE_PRESSED ? C0101l.f585j : Color.parseColor("#ffffe8"));
        canvas.drawRect(this.rec, paintBack);
        infoBox.update(canvas);
        drawFrame(canvas);
        if (alwaysDrawRect) {
            canvas.drawRect(this.rec, C0096g.m497b());
        }
    }
}
