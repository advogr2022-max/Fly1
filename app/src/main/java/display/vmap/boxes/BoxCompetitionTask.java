package display.vmap.boxes;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0101l;
import configs.ActivityConfigTasks;
import flyme_apphelper.C0072a;
import flyme_poi.C0227a;
import flyme_poi.C0229c;
import flyme_data.C0238f;
import flyme_data.C0239g;
import types.C0366f;
import types.C0369i;
import types.C0372l;
import types.C0377q;

/* loaded from: classes.dex */
public class BoxCompetitionTask extends InfoBox {
    private static int r0 = 0;
    private static final int MODE_BLACK = 0;
    private static final int MODE_GREEN = 2;
    private static final int MODE_RED = 1;
    private static final float SMALL_TEXT_SIZE_FACTOR = 0.6f;
    private static final long UPDATE_INTERVAL_MS = 1000;
    private static String msg;
    private static String msgRight;
    private static String msgRightUnit;
    private static String msgUnit;
    private static int picHeight;
    private static int picWidth;
    private String clickTask;
    private int measuredBigTextWidth;
    private int measuredMsgWidth;
    private int measuredRightUnit;
    private int picY;
    private int prevMsgRightLength;
    private boolean markerOpened = false;
    private int currentFlag = 0;
    private int colorMode = 0;
    private long nextUpdateTimeMs = 0;
    private Bitmap picBmp = null;
    private long previousNeededTimeToSSS = 0;
    private long previousNeededTimeToSSSPerfTimeMs = 0;

    public BoxCompetitionTask() {
        this.showCaption = false;
        this.sizeFactor = 0.7f;
        this.aspectRatio = 7.0f;
        this.clickTask = App.m435a(R.string.click_to_select);
    }

    private void measure() {
        if (msgRight != null && msgRight.length() != this.prevMsgRightLength) {
            this.prevMsgRightLength = msgRight.length();
            this.measuredBigTextWidth = (int) paintText.measureText(msgRight);
        }
        if (this.measuredRightUnit == 0 && msgRightUnit != null) {
            this.measuredRightUnit = (int) (paintText.measureText(msgRightUnit) * SMALL_TEXT_SIZE_FACTOR * 1.1f);
        }
        if (msg != null) {
            this.measuredMsgWidth = (int) (paintText.measureText(msg) * SMALL_TEXT_SIZE_FACTOR * 1.1f);
        }
    }

    private void updateAfterStart() {
        int i2 = 1;
        this.markerOpened = true;
        if (C0366f.f2003a == null) {
            if (C0227a.f1276a == null || !C0227a.f1276a.f1288l) {
                return;
            }
            msg = App.m435a(R.string.task_finished);
            msgRight = null;
            msgRightUnit = null;
            msgUnit = null;
            this.prevMsgRightLength = 0;
            loadFlag(0);
            return;
        }
        loadFlag(R.drawable.horizon);
        short s = C0366f.f2003a.f1978k;
        if (s == 0 && C0072a.m378a()) {
            s = C0227a.f1276a.f1284h.f1978k;
        }
        if (s == 0) {
            msgRight = null;
            msgRightUnit = null;
        } else {
            float m893a = C0239g.f1392W.m893a(C0366f.f2005c);
            if (m893a == 0.0f) {
                m893a = 0.001f;
            }
            int i3 = (C0239g.f1426s - ((int) (C0101l.f529N * ((C0366f.f2004b * 3600.0f) / m893a)))) - s;
            if (i3 > 0) {
                msgRight = "+" + Integer.toString(C0377q.m1287e(i3));
                i2 = 2;
            } else if (i3 > -1000) {
                msgRight = Integer.toString(C0377q.m1287e(i3));
            } else {
                loadFlag(R.drawable.agl_icon);
                this.colorMode = 0;
                msgRight = Integer.toString(C0377q.m1287e(s));
                msgRightUnit = C0377q.f2083b;
            }
            this.colorMode = i2;
            msgRightUnit = C0377q.f2083b;
        }
        msg = C0101l.f520E.format(C0377q.m1278a(C0366f.f2004b));
        msgUnit = C0377q.f2082a;
    }

    private void updateBeforeStat() {
        long j2;
        String m534a;
        msgRightUnit = null;
        msgUnit = null;
        long currentTimeMillis = (C0227a.f1276a.f1297u - (C0238f.m1059d() ? C0239g.f1424q : System.currentTimeMillis())) / UPDATE_INTERVAL_MS;
        this.markerOpened = currentTimeMillis < 0;
        msg = C0101l.m534a((int) currentTimeMillis, 1);
        loadFlag(this.markerOpened ? R.drawable.green_flag : R.drawable.red_flag);
        if (C0227a.f1276a.f1287k > C0227a.f1276a.f1283g) {
            j2 = calcNeededTimeSecToSSS();
        } else {
            float m893a = C0239g.f1392W.m893a(C0366f.f2005c);
            if (m893a < 1.0f) {
                m893a = 1.0f;
            }
            j2 = (long) (((C0366f.f2004b * 3600.0f) / m893a) * 1.0f);
        }
        long j3 = currentTimeMillis - j2;
        if (j3 > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("+");
            sb.append(C0101l.m534a((int) j3, j3 < 3600 ? 3 : 1));
            msgRight = sb.toString();
            this.colorMode = 2;
            return;
        }
        if (j3 < -10800) {
            m534a = Long.toString(j3 / 3600) + "h";
        } else {
            m534a = C0101l.m534a((int) j3, j3 >= 3600 ? 1 : 3);
        }
        msgRight = m534a;
        this.colorMode = 1;
    }

    private void updateContent() {
        this.captionVisible = false;
        if (C0227a.f1276a.f1295s || !C0227a.f1276a.f1290n) {
            updateAfterStart();
        } else {
            updateBeforeStat();
        }
        measure();
    }

    long calcNeededTimeSecToSSS() {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.previousNeededTimeToSSSPerfTimeMs < 10000) {
            return this.previousNeededTimeToSSS;
        }
        this.previousNeededTimeToSSSPerfTimeMs = currentTimeMillis;
        C0372l c0372l = new C0372l(C0239g.m1073d().f1972a, C0239g.m1073d().f1973b);
        long j2 = 0;
        for (int i2 = C0227a.f1276a.f1283g; i2 <= C0227a.f1276a.f1286j; i2++) {
            C0229c c0229c = C0227a.f1276a.f1279c.get(i2);
            int m1243a = C0369i.m1243a(c0372l.f2053a, c0372l.f2054b, c0229c.f1976i, c0229c.f1977j);
            float m1248b = C0369i.m1248b(c0372l.f2053a, c0372l.f2054b, c0229c.f1976i, c0229c.f1977j);
            float m893a = C0239g.f1392W.m893a(m1243a);
            if (m893a < 1.0f) {
                m893a = 1.0f;
            }
            j2 += ((m1248b * 3600.0f) / m893a) * 1.0f;
            c0372l.m1258a(c0229c.f1976i, c0229c.f1977j);
        }
        this.previousNeededTimeToSSS = j2;
        return j2;
    }

    @Override // display.vmap.boxes.InfoBox
    protected void draw(Canvas canvas) {
        if (C0227a.f1276a == null) {
            this.captionVisible = true;
            paintText.setTextSize(paintText.getTextSize() * SMALL_TEXT_SIZE_FACTOR);
            canvas.drawText(this.clickTask, this.textX, this.textY, paintText);
            return;
        }
        if (timeMs > this.nextUpdateTimeMs) {
            updateContent();
            this.nextUpdateTimeMs = timeMs + UPDATE_INTERVAL_MS;
        }
        int i2 = this.rec.right - (C0101l.f579d / 2);
        if (msgRight != null) {
            paintText.setTextAlign(Paint.Align.RIGHT);
            if (msgRightUnit != null) {
                i2 -= this.measuredRightUnit;
            }
            if (this.colorMode == 0) {
                canvas.drawText(msgRight, i2, this.textY, paintText);
            } else {
                paintText.setStyle(Paint.Style.STROKE);
                paintText.setStrokeWidth((this.textSize * 0.05f) + 1.0f);
                float f2 = i2;
                canvas.drawText(msgRight, f2, this.textY, paintText);
                paintText.setStrokeWidth(0.0f);
                paintText.setStyle(Paint.Style.FILL);
                paintText.setColor(this.colorMode == 1 ? C0101l.f587l : C0101l.f588m);
                canvas.drawText(msgRight, f2, this.textY, paintText);
                paintText.setColor(C0101l.f591p);
            }
            i2 -= this.measuredBigTextWidth;
        }
        if (this.picBmp != null) {
            canvas.drawBitmap(this.picBmp, (i2 - picWidth) - (picWidth / 3), this.picY, (Paint) null);
        }
        float textSize = paintText.getTextSize();
        Paint paint = paintText;
        float f3 = textSize * SMALL_TEXT_SIZE_FACTOR;
        paint.setTextSize(f3);
        if (msgRightUnit != null) {
            canvas.drawText(msgRightUnit, this.rec.right - r0, this.textY, paintText);
        }
        paintText.setTextAlign(Paint.Align.LEFT);
        if (msg != null) {
            canvas.drawText(msg, this.textX, this.textY, paintText);
            if (msgUnit != null) {
                paintText.setTextSize(f3 * 0.7f);
                canvas.drawText(msgUnit, this.textX + this.measuredMsgWidth, this.textY, paintText);
            }
        }
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getCaption() {
        return App.m435a(R.string.competition_task);
    }

    @Override // display.vmap.boxes.InfoBox
    protected String getText() {
        return msgRight;
    }

    void loadFlag(int i2) {
        if (i2 != this.currentFlag) {
            if (i2 == 0) {
                if (this.picBmp != null) {
                    this.picBmp.recycle();
                    this.picBmp = null;
                }
                this.currentFlag = 0;
                return;
            }
            Bitmap decodeResource = BitmapFactory.decodeResource(App.m443b().getResources(), i2);
            this.picBmp = decodeResource;
            if (decodeResource != null) {
                this.currentFlag = i2;
                picWidth = this.picBmp.getWidth();
                picHeight = this.picBmp.getHeight();
                this.picY = (this.rec.top + (this.rec.height() / 2)) - (picHeight / 2);
            }
        }
    }

    @Override // display.vmap.boxes.InfoBox
    public boolean onClick() {
        if (C0227a.f1276a != null) {
            return false;
        }
        App.m439a((Class<?>) ActivityConfigTasks.class);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // display.vmap.boxes.InfoBox
    public void onPosition() {
        this.nextUpdateTimeMs = 0L;
        this.measuredBigTextWidth = 0;
        this.measuredRightUnit = 0;
    }
}
