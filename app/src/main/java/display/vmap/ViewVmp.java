package display.vmap;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.xcglobe.flyme.R;
import com.xcglobe.xclog.ActivityMain;
import com.xcglobe.xclog.App;
import com.xcglobe.xclog.C0096g;
import com.xcglobe.xclog.C0099j;
import com.xcglobe.xclog.C0101l;
import display.vmap.boxes.BoxGroundProfile;
import display.vmap.boxes.InfoBox;
import display.vmap.boxes.LayoutManager;
import display.vmap.features.AirspacePainter;
import display.vmap.features.FaiAssistant;
import display.vmap.features.PoiPainter;
import display.vmap.features.RingPainter;
import display.vmap.features.StatusMsg;
import display.vmap.features.TaskPainter;
import display.vmap.features.ThermalPainter;
import display.vmap.features.TrackPainter;
import display.vmap.features.ZoomIconPainter;
import java.util.ArrayList;
import flyme_poi.C0227a;
import flyme_data.C0239g;
import types.C0363c;
import types.C0366f;
import types.C0367g;
import types.GpsVal;
import vmaps.C0392e;
import vmaps.core.InterfaceC0388g;
import vmaps.core.VmpWorld;

@SuppressLint({"ClickableViewAccessibility"})
/* loaded from: classes.dex */
public class ViewVmp extends View implements InterfaceC0388g {
    public static final int FLAG_EMULATOR_START = 4;
    public static final int FLAG_NORTH_UP = 32;
    public static final int FLAG_POI_RELOAD = 2;
    public static final int FLAG_REINIT = 1;
    public static final int FLAG_ROTATING = 64;
    public static final int FLAG_STATIC_MAP = 8;
    public static final int FLAG_TOGGLE = 16;
    public static final int MODE_NORTH_UP = 2;
    public static final int MODE_PREVIOUS = 0;
    public static final int MODE_ROTATING = 1;
    public static final int MODE_STATIC = 3;
    public static final int MODE_TOGGLE = 4;
    private static final int RECENTER_CHANGE_MODE = 4;
    private static final int RECENTER_GONE_OUTSIDE = 1;
    private static final int RECENTER_ZOOMIN = 2;
    private static final int RECENTER_ZOOMOUT = 3;
    public static Bitmap bmpGlider;
    private static boolean thermalingMode;
    int bmpGliderCenterX;
    int bmpGliderCenterY;
    private Rect bottomPanelRect;
    ArrayList<InfoBox> boxes;
    public int directionAngle;
    VmpEventManager eventManager;
    public Matrix gMatrix;
    int[] gPoint;
    Handler handler;
    boolean isWholeTrackZoomed;
    protected Rect mapClip;
    public Matrix matrix;
    boolean optCenter;
    boolean optDraggable;
    boolean optRotate;
    boolean optRotateBeforeThermaling;
    boolean optStatic;
    Paint paintPath;
    public Rect poiRecDst;
    Rect recDst;
    Rect recSrc;
    private Rect rightPanelRect;
    private C0363c safeWindow;
    int viewRealHeight;
    int viewRealWidth;
    public VmpWorld world;

    /* renamed from: xy */
    int[] f934xy;
    private static int panelBkColor = C0101l.f592q;
    private static int reqFlag = 0;
    public static Paint paintOutline = new Paint();
    static ViewVmp registeredView = null;
    public static long lastTouchTimeMs = 0;
    private static final boolean ENABLE_AUTO_CENTER_AFTER_ZOOM = false;
    private static boolean oldrotation = ENABLE_AUTO_CENTER_AFTER_ZOOM;
    private static boolean oldthermailing = ENABLE_AUTO_CENTER_AFTER_ZOOM;

    public ViewVmp(Context context) {
        super(context);
        this.gPoint = new int[]{0, 0};
        this.f934xy = new int[]{0, 0};
        this.optRotate = true;
        this.optCenter = true;
        this.optStatic = ENABLE_AUTO_CENTER_AFTER_ZOOM;
        this.optDraggable = true;
        this.directionAngle = 90;
        this.paintPath = new Paint();
        this.poiRecDst = new Rect();
        this.recSrc = new Rect();
        this.recDst = new Rect();
        this.matrix = new Matrix();
        this.gMatrix = new Matrix();
        this.mapClip = new Rect();
        this.safeWindow = new C0363c();
        this.boxes = new ArrayList<>();
        this.rightPanelRect = null;
        this.bottomPanelRect = null;
        this.handler = new Handler();
        init();
    }

    public ViewVmp(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gPoint = new int[]{0, 0};
        this.f934xy = new int[]{0, 0};
        this.optRotate = true;
        this.optCenter = true;
        this.optStatic = ENABLE_AUTO_CENTER_AFTER_ZOOM;
        this.optDraggable = true;
        this.directionAngle = 90;
        this.paintPath = new Paint();
        this.poiRecDst = new Rect();
        this.recSrc = new Rect();
        this.recDst = new Rect();
        this.matrix = new Matrix();
        this.gMatrix = new Matrix();
        this.mapClip = new Rect();
        this.safeWindow = new C0363c();
        this.boxes = new ArrayList<>();
        this.rightPanelRect = null;
        this.bottomPanelRect = null;
        this.handler = new Handler();
        init();
    }

    public ViewVmp(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.gPoint = new int[]{0, 0};
        this.f934xy = new int[]{0, 0};
        this.optRotate = true;
        this.optCenter = true;
        this.optStatic = ENABLE_AUTO_CENTER_AFTER_ZOOM;
        this.optDraggable = true;
        this.directionAngle = 90;
        this.paintPath = new Paint();
        this.poiRecDst = new Rect();
        this.recSrc = new Rect();
        this.recDst = new Rect();
        this.matrix = new Matrix();
        this.gMatrix = new Matrix();
        this.mapClip = new Rect();
        this.safeWindow = new C0363c();
        this.boxes = new ArrayList<>();
        this.rightPanelRect = null;
        this.bottomPanelRect = null;
        this.handler = new Handler();
        init();
    }

    private void calcIsWholeTrackZoomed(float f2) {
        C0367g c0367g = C0239g.f1413f;
        boolean z = ENABLE_AUTO_CENTER_AFTER_ZOOM;
        if (c0367g != null && !C0239g.f1413f.m1230b()) {
            this.world.m1338a(C0239g.f1413f.f2012a, C0239g.f1413f.f2014c, this.f934xy);
            int i2 = this.f934xy[0];
            int i3 = this.f934xy[1];
            this.world.m1338a(C0239g.f1413f.f2013b, C0239g.f1413f.f2015d, this.f934xy);
            int i4 = this.f934xy[0] - i2;
            int i5 = this.f934xy[1] - i3;
            if (i4 * f2 < this.world.f2123f && f2 * i5 < this.world.f2124g) {
                z = true;
            }
        }
        this.isWholeTrackZoomed = z;
    }

    private void changeThermalingMode(boolean z) {
        boolean z2;
        thermalingMode = z;
        if (z) {
            ThermalPainter.setWorld(this.world);
            this.optRotateBeforeThermaling = this.optRotate;
            z2 = true;
        } else if (!this.optRotate) {
            return;
        } else {
            z2 = this.optRotateBeforeThermaling;
        }
        setRotation(z2);
    }

    private void changeZoom(float f2) {
        int i2 = (f2 > this.world.m1352c() ? 1 : (f2 == this.world.m1352c() ? 0 : -1));
        this.world.m1334a(f2);
        calcIsWholeTrackZoomed(1.3f);
        ZoomIconPainter.initZoomIcons(true);
        setFlag(2);
        invalidate();
    }

    private void drawBoxes(Canvas canvas) {
        InfoBox.paintBack.setColor(panelBkColor);
        if (this.rightPanelRect != null) {
            canvas.drawRect(this.rightPanelRect, InfoBox.paintBack);
        }
        if (this.bottomPanelRect != null) {
            canvas.drawRect(this.bottomPanelRect, InfoBox.paintBack);
        }
        InfoBox.paintBack.setColor(C0101l.f592q);
        InfoBox.timeMs = System.currentTimeMillis();
        for (int i2 = 0; i2 < this.boxes.size(); i2++) {
            this.boxes.get(i2).update(canvas);
        }
    }

    private void handleReqFlag() {
        if ((reqFlag & 2) != 0) {
            PoiPainter.reloadLocalPoints();
        }
        if ((reqFlag & 4) != 0) {
            this.optStatic = ENABLE_AUTO_CENTER_AFTER_ZOOM;
            this.optRotate = ENABLE_AUTO_CENTER_AFTER_ZOOM;
            this.optCenter = ENABLE_AUTO_CENTER_AFTER_ZOOM;
            TrackPainter.recreate();
            this.world.m1334a(3.0f);
        }
        if ((reqFlag & 8) != 0) {
            this.optStatic = true;
            this.optCenter = ENABLE_AUTO_CENTER_AFTER_ZOOM;
            this.optRotate = ENABLE_AUTO_CENTER_AFTER_ZOOM;
            initDisplay();
            this.world.m1340a(C0239g.f1413f, 1.1f);
        }
        if ((reqFlag & 16) != 0) {
            setRotation(!this.optRotate);
        }
        if ((reqFlag & 32) != 0) {
            setRotation(ENABLE_AUTO_CENTER_AFTER_ZOOM);
        }
        if ((reqFlag & 64) != 0) {
            setRotation(true);
        }
        if ((reqFlag & 1) != 0) {
            initDisplay();
        }
        reqFlag = 0;
    }

    private void informBoxesOnModeChanged() {
        for (int i2 = 0; i2 < this.boxes.size(); i2++) {
            this.boxes.get(i2).onModeChanged(this.optRotate, thermalingMode);
        }
    }

    @SuppressLint({"NewApi", "InlinedApi"})
    private void init() {
        this.world = new VmpWorld(true);
        reqFlag = 0;
        thermalingMode = ENABLE_AUTO_CENTER_AFTER_ZOOM;
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        float f2 = C0101l.f578c / 7.0f;
        paintOutline.set(C0096g.m501d());
        paintOutline.setColor(Color.parseColor("#f0fff0"));
        paintOutline.setStyle(Paint.Style.STROKE);
        paintOutline.setStrokeWidth(f2);
        paintOutline.setShadowLayer(f2 * 1.0f, 0.0f, 0.0f, -1);
        bmpGlider = BitmapFactory.decodeResource(App.m443b().getResources(), R.drawable.arrow_white);
        this.bmpGliderCenterX = bmpGlider.getWidth() / 2;
        this.bmpGliderCenterY = bmpGlider.getHeight() / 4;
        this.eventManager = new VmpEventManager(this);
    }

    private void initBoxes(int i2, int i3) {
        if (this.optStatic) {
            this.boxes.clear();
            return;
        }
        InfoBox.initStatic(this.world);
        Rect rect = null;
        String m516a = C0099j.m516a("boxes", (String) null);
        if (m516a == null) {
            m516a = "BoxSpeed BoxSet BoxAirspace-BoxNearThermal-BoxWind-BoxOlcScore BoxVario BoxAltitude BoxGroundProfile";
        }
        try {
            this.boxes = new VmpEditor(this).loadBoxes(m516a);
        } catch (Exception unused) {
            this.boxes = new VmpEditor(this).loadBoxes("");
        }
        LayoutManager layoutManager = new LayoutManager();
        layoutManager.create(this.boxes, i2, i3);
        int i4 = layoutManager.bottomPanelNeeded ? i3 - layoutManager.bottomPanelHeight : i3;
        if (layoutManager.isHorizontalTerrainMode()) {
            layoutManager.pivotDx = -(((i2 - layoutManager.rightPanelWidth) / 2) - (ZoomIconPainter.zoomIconSize * 2));
            layoutManager.pivotDy = (BoxGroundProfile.recHeightOnCustomPosition + (((i3 - layoutManager.bottomPanelHeight) - BoxGroundProfile.recHeightOnCustomPosition) / 2)) - (i4 / 2);
            this.directionAngle = 90;
        } else {
            this.directionAngle = 0;
        }
        if (i2 > i3) {
            layoutManager.pivotDy -= (i3 - i4) / 2;
            i4 = i3;
        }
        initWorld(i2 - layoutManager.rightPanelWidth, i4, layoutManager.pivotDx, layoutManager.pivotDy);
        int i5 = this.bmpGliderCenterX * 2;
        this.safeWindow.m1182a();
        this.safeWindow.m1183a(i5, i5);
        this.safeWindow.m1183a((i2 - i5) - layoutManager.rightPanelWidth, (i3 - i5) - layoutManager.bottomPanelExtendedHeight);
        this.world.m1351b(this.f934xy);
        this.safeWindow.m1183a(this.f934xy[0] + i5, this.f934xy[1] + i5);
        layoutManager.finalize(this.boxes);
        if (layoutManager.rightPanelWidth > 0) {
            this.rightPanelRect = new Rect(i2 - layoutManager.rightPanelWidth, 0, i2, i3);
        } else {
            this.rightPanelRect = null;
        }
        if (layoutManager.bottomPanelNeeded && i3 > i2) {
            rect = new Rect(0, i3 - layoutManager.bottomPanelHeight, i2, i3);
        }
        this.bottomPanelRect = rect;
        invalidate();
    }

    private void initFeatures() {
        PoiPainter.create(this);
        ZoomIconPainter.create(this);
        RingPainter.create(this);
        ThermalPainter.create(this);
        TrackPainter.create(this, C0239g.f1414g, 0);
        TaskPainter.create(this);
        AirspacePainter.create(this);
        FaiAssistant.create(this);
        StatusMsg.create(this);
    }

    private void initWorld(int i2, int i3, int i4, int i5) {
        this.world.m1339a(i2, i3, new C0392e(), i4, i5);
        GpsVal m1073d = C0239g.m1073d();
        float m1352c = this.world.m1352c();
        if (m1352c < 0.5d) {
            m1352c = 10.0f;
        }
        this.world.m1336a(m1073d.f1972a, m1073d.f1973b, m1352c);
        this.mapClip.set(0, 0, (int) this.world.f2123f, (int) this.world.f2124g);
    }

    public static boolean isRotating() {
        if (registeredView == null || !registeredView.optRotate) {
            return ENABLE_AUTO_CENTER_AFTER_ZOOM;
        }
        return true;
    }

    public static boolean isThermailing() {
        return thermalingMode;
    }

    private void reCenterWorld(GpsVal gpsVal, int i2) {
        float f2;
        if (this.eventManager == null || !this.eventManager.isDraggingMap()) {
            if (!this.isWholeTrackZoomed || C0239g.f1413f.m1230b()) {
                this.world.m1335a(gpsVal.f1972a, gpsVal.f1973b);
                return;
            }
            this.world.m1335a(C0239g.f1413f.m1235d(), C0239g.f1413f.m1236e());
            if (i2 == 1) {
                float m1352c = this.world.m1352c();
                if (m1352c < 2.0f) {
                    f2 = m1352c * 2.0f;
                } else {
                    double d2 = m1352c;
                    Double.isNaN(d2);
                    f2 = (float) (d2 * 1.5d);
                }
                this.world.m1334a(f2);
            }
        }
    }

    public static void setFlag(int i2) {
        reqFlag = i2 | reqFlag;
        if (registeredView != null) {
            registeredView.invalidate();
        }
    }

    private void setRotation(boolean z) {
        this.optRotate = z;
        this.optCenter = z;
        if (this.optRotate) {
            return;
        }
        calcIsWholeTrackZoomed(1.0f);
        reCenterWorld(C0239g.m1073d(), 4);
    }

    private void stopThermalAssistant() {
        changeThermalingMode(ENABLE_AUTO_CENTER_AFTER_ZOOM);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void clickZoomIcon(boolean z) {
        float m1352c = this.world.m1352c();
        float f2 = m1352c < 5.0f ? 2.0f : 1.5f;
        float f3 = 5320.0f;
        if (z) {
            f3 = m1352c / f2;
            if (f3 < 0.1f) {
                f3 = 0.1f;
            }
        } else {
            float f4 = m1352c * f2;
            if (f4 <= 5320.0f) {
                f3 = f4;
            }
        }
        changeZoom(f3);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        Matrix matrix;
        float f2;
        int i2;
        super.draw(canvas);
        if (reqFlag != 0) {
            handleReqFlag();
        }
        boolean z = (thermalingMode && this.optRotate) ? true : ENABLE_AUTO_CENTER_AFTER_ZOOM;
        if (z) {
            drawBoxes(canvas);
        }
        Rect clipBounds = canvas.getClipBounds();
        canvas.clipRect(this.mapClip);
        this.matrix.reset();
        GpsVal m1073d = C0239g.m1073d();
        if (this.optStatic) {
            m1073d = C0239g.f1413f.m1233c();
            if (this.optDraggable) {
                m1073d.f1972a = this.world.f2122e.f1998b;
                m1073d.f1973b = this.world.f2122e.f1999c;
            }
        }
        if (this.optCenter) {
            this.world.m1335a(m1073d.f1972a, m1073d.f1973b);
        }
        this.world.m1338a(m1073d.f1972a, m1073d.f1973b, this.gPoint);
        if (C0239g.f1418k > 1.0f && !this.safeWindow.m1184a(this.gPoint)) {
            reCenterWorld(m1073d, 1);
            this.world.m1338a(m1073d.f1972a, m1073d.f1973b, this.gPoint);
        }
        if (this.optRotate) {
            canvas.save();
            this.matrix.preRotate((-C0239g.f1420m) + this.directionAngle, this.gPoint[0], this.gPoint[1]);
            canvas.rotate((-C0239g.f1420m) + this.directionAngle, this.gPoint[0], this.gPoint[1]);
        }
        if (thermalingMode && C0239g.f1372C.f1446a == 0) {
            stopThermalAssistant();
        }
        if (!z) {
            drawMap(canvas);
        }
        if (this.optRotate) {
            RingPainter.drawRing(canvas);
            if (thermalingMode) {
                ThermalPainter.draw(canvas);
            }
        }
        if (!this.optStatic) {
            TrackPainter.moveTo(m1073d);
        }
        if (!z) {
            TrackPainter.draw(canvas, this.optStatic);
        }
        if (this.optRotate) {
            canvas.restore();
        }
        if (!z) {
            if (C0227a.f1276a == null) {
                FaiAssistant.draw(canvas);
            }
            PoiPainter.drawPoi(canvas);
            AirspacePainter.draw(canvas);
        }
        if (this.optStatic) {
            TrackPainter.drawEndPoints(canvas);
            if (C0227a.f1276a != null) {
                TaskPainter.drawTask(canvas);
            }
        } else {
            if (this.optRotate) {
                if (C0239g.f1392W.m897c()) {
                    RingPainter.drawSock(canvas);
                }
                if (C0366f.f2003a != null) {
                    if (!C0227a.m992g() || thermalingMode) {
                        RingPainter.drawGoal(canvas);
                    } else {
                        TaskPainter.drawGoalLine(canvas);
                    }
                }
                this.gMatrix.setRotate(this.directionAngle, this.bmpGliderCenterX, this.bmpGliderCenterY);
                matrix = this.gMatrix;
                f2 = this.gPoint[0] - this.bmpGliderCenterX;
                i2 = this.gPoint[1];
            } else {
                if (C0366f.f2003a != null && C0227a.m992g()) {
                    TaskPainter.drawGoalLine(canvas);
                }
                this.gMatrix.setRotate(C0239g.f1420m, this.bmpGliderCenterX, this.bmpGliderCenterY);
                matrix = this.gMatrix;
                f2 = this.gPoint[0] - this.bmpGliderCenterX;
                i2 = this.gPoint[1];
            }
            matrix.postTranslate(f2, i2 - this.bmpGliderCenterY);
            canvas.drawBitmap(bmpGlider, this.gMatrix, null);
        }
        canvas.clipRect(clipBounds, Region.Op.REPLACE);
        if (!this.optStatic && !z) {
            drawBoxes(canvas);
        }
        if (!z) {
            ZoomIconPainter.draw(canvas);
        }
        if (oldrotation != this.optRotate || oldthermailing != thermalingMode) {
            oldrotation = this.optRotate;
            oldthermailing = thermalingMode;
            informBoxesOnModeChanged();
        }
        StatusMsg.draw(canvas);
    }

    void drawMap(Canvas canvas) {
        C0392e c0392e = (C0392e) this.world.m1347b();
        if (c0392e.f2245b == null) {
            return;
        }
        this.recSrc.set(this.world.f2130m.f1992a, this.world.f2130m.f1993b, this.world.f2130m.f1994c, this.world.f2130m.f1995d);
        this.recDst.set(this.world.f2131n.f1992a, this.world.f2131n.f1993b, this.world.f2131n.f1994c, this.world.f2131n.f1995d);
        canvas.drawBitmap(c0392e.f2245b, this.recSrc, this.recDst, (Paint) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean fingerMove(float f2, float f3, float f4, float f5) {
        float f6 = C0101l.f578c;
        if (Math.abs(f2) < f6 && Math.abs(f3) < f6) {
            return ENABLE_AUTO_CENTER_AFTER_ZOOM;
        }
        if (this.optRotate) {
            setRotation(ENABLE_AUTO_CENTER_AFTER_ZOOM);
        }
        float m1352c = this.world.m1352c() / this.world.f2123f;
        float m1200c = this.world.f2122e.m1200c(f3 * m1352c) - this.world.f2122e.f1998b;
        this.world.m1335a(f4 + m1200c, f5 - (this.world.f2122e.m1201d(f2 * m1352c) - this.world.f2122e.f1999c));
        TrackPainter.recreate();
        return true;
    }

    public void initDisplay() {
        initWorld(this.viewRealWidth, this.viewRealHeight, 0, 0);
        initBoxes(this.viewRealWidth, this.viewRealHeight);
        initFeatures();
    }

    @Override // vmaps.core.InterfaceC0388g
    public void onMapUpdate() {
        TrackPainter.recreate();
        PoiPainter.reloadLocalPoints();
        ActivityMain.m413a(11);
    }

    @Override // android.view.View
    protected void onMeasure(int i2, int i3) {
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        setMeasuredDimension(size, size2);
        if (size > 0) {
            if (this.viewRealWidth == size && this.viewRealHeight == size2) {
                return;
            }
            this.viewRealWidth = size;
            this.viewRealHeight = size2;
            initDisplay();
            if (C0239g.f1372C.f1446a > 1) {
                startThermalAssistant();
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean action;
        return (this.eventManager == null || !(action = this.eventManager.action(motionEvent))) ? super.onTouchEvent(motionEvent) : action;
    }

    @Override // vmaps.core.InterfaceC0388g
    public void onZoom() {
        TrackPainter.recreate();
    }

    public void pause() {
        registeredView = null;
        this.world.m1349b(this);
    }

    @Override // android.view.View
    public boolean performClick() {
        return super.performClick();
    }

    public void resume() {
        registeredView = this;
        this.world.m1343a(this);
        setFlag(1);
    }

    public void startThermalAssistant() {
        changeThermalingMode(true);
    }
}
