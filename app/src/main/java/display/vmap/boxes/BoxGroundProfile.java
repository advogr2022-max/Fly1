package display.vmap.boxes;

import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import com.xcglobe.xclog.C0096g;
import com.xcglobe.xclog.C0101l;
import display.vmap.ViewVmp;
import display.vmap.features.RingPainter;
import display.vmap.features.StatusMsg;
import display.vmap.features.ZoomIconPainter;
import flyme_data.C0239g;
import types.C0377q;
import types.GpsVal;
import vmaps.C0379a;
import vmaps.C0391d;

/* loaded from: classes.dex */
public class BoxGroundProfile extends InfoBox {
    private static int r1 = 0;
    private static int r13 = 0;
    private static int r3 = 0;
    static final short ELEV_STEP_HALF = 50;
    public static int behindPix = 0;
    private static boolean defaultCustomPosition = false;
    static boolean disabled = false;
    public static int recHeightOnCustomPosition;
    int height;
    int maxAlt;
    int minAlt;
    Paint paintDashed;
    Paint paintGround;
    Paint paintGroundStroke;
    private float point2PixDistance;
    private float point2kmDist;
    private short[] predictAir;
    private int predictAirSize;
    private int predictGroundMax;
    private int predictGroundMin;
    private int predictGroundSize;
    int prevDirection;
    int prevKmPerWidth;
    float prevLat;
    float prevLng;
    int width;
    Rect gliderRec = new Rect();
    Rect clipRec = new Rect();
    Path gPath = new Path();
    Path aPath = new Path();
    private short[] predictGround = null;

    public BoxGroundProfile() {
        this.width = 0;
        this.height = 0;
        this.customWidth = true;
        if (!ViewVmp.isRotating() || ViewVmp.isThermailing()) {
            this.customPosition = false;
        } else {
            this.customPosition = defaultCustomPosition;
        }
        int i2 = (C0101l.f575ay / 470) + 1;
        CornerPathEffect cornerPathEffect = new CornerPathEffect(C0101l.f575ay / 50);
        this.paintGround = new Paint();
        this.paintGround.setColor(C0101l.f597v);
        this.paintGround.setStyle(Paint.Style.FILL);
        this.paintGround.setStrokeJoin(Paint.Join.ROUND);
        this.paintGround.setPathEffect(cornerPathEffect);
        this.paintGround.setStrokeWidth(1.0f);
        this.paintGround.setAlpha(190);
        this.paintGroundStroke = new Paint();
        this.paintGroundStroke.setColor(C0101l.f594s);
        this.paintGroundStroke.setStyle(Paint.Style.STROKE);
        this.paintGroundStroke.setStrokeJoin(Paint.Join.ROUND);
        this.paintGroundStroke.setPathEffect(cornerPathEffect);
        this.paintGroundStroke.setStrokeWidth(i2);
        this.paintGroundStroke.setAntiAlias(true);
        this.paintGroundStroke.setAlpha(200);
        this.paintDashed = new Paint();
        this.paintDashed.setStyle(Paint.Style.STROKE);
        float f2 = C0101l.f575ay / 48;
        this.paintDashed.setPathEffect(new DashPathEffect(new float[]{f2, r3 / 2}, f2));
        this.paintDashed.setAntiAlias(true);
        this.paintDashed.setStrokeWidth(i2 * 2);
        this.paintDashed.setColor(C0101l.f591p);
        behindPix = C0101l.f578c;
        this.width = RingPainter.setPosition(world) / 2;
        if (this.customPosition) {
            this.height = (this.width * 5) / 8;
            recHeightOnCustomPosition = this.height;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x015b  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0161  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void createPredict(Canvas canvas) {
        GpsVal m1073d = C0239g.m1073d();
        float f2 = m1073d.f1972a;
        float f3 = m1073d.f1973b;
        int m1352c = (int) world.m1352c();
        if (this.predictGroundSize <= 2 || this.prevDirection != C0239g.f1420m || m1352c != this.prevKmPerWidth || world.f2122e.m1193a(f2, f3, this.prevLat, this.prevLng) >= 0.1f) {
            this.prevKmPerWidth = m1352c;
            this.prevLat = f2;
            this.prevLng = f3;
            C0391d.m1414a(this.prevKmPerWidth);
            float f4 = C0239g.f1420m != 0 ? C0239g.f1420m : 0.1f;
            if (f4 == 180.0f) {
                f4 = 180.1f;
            }
            float radians = (float) Math.toRadians(f4);
            this.point2PixDistance = this.width - behindPix;
            double d2 = this.point2PixDistance;
            double d3 = radians;
            double sin = Math.sin(d3);
            Double.isNaN(d2);
            float f5 = (float) (d2 * sin);
            double d4 = this.point2PixDistance;
            double cos = Math.cos(d3);
            Double.isNaN(d4);
            float[] fArr = {0.0f, 0.0f};
            world.m1337a(f5, (float) (d4 * cos), fArr);
            float f6 = fArr[0] + f3;
            float f7 = fArr[1] + f2;
            float f8 = f3 - f6;
            this.point2kmDist = world.f2122e.m1193a(f2, f3, f7, f6);
            float f9 = (f2 - f7) / f8;
            float f10 = f8 / this.point2PixDistance;
            float f11 = f2 - (f9 * f3);
            float f12 = 1.0f;
            byte[] bArr = {0, 0};
            int i2 = -behindPix;
            int i3 = this.width + i2;
            byte b2 = -1;
            int i4 = 0;
            short s = -1;
            int i5 = 0;
            int i6 = 0;
            int i7 = -1;
            while (i2 < i3) {
                float f13 = i2;
                int i8 = i3;
                int i9 = ((int) (f13 * f12)) + behindPix;
                float f14 = f3 - (f13 * f10);
                float f15 = (f9 * f14) + f11;
                float f16 = f3;
                short m1416b = (short) C0391d.m1416b(f15, f14);
                float f17 = f11;
                byte m1177a = C0379a.f2109b.m1177a(f15, f14, bArr);
                if (m1177a != b2 && i6 == 0) {
                    if (i2 > 0) {
                        i6++;
                    }
                    if (m1177a != -1) {
                        int i10 = i5 + 1;
                        this.predictAir[i5] = (short) i9;
                        i5 = i10 + 1;
                        this.predictAir[i10] = m1177a;
                    }
                    b2 = m1177a;
                }
                if (m1416b != 0) {
                    if (i4 == 0) {
                        int i11 = i4 + 1;
                        this.predictGround[i4] = -10;
                        i4 = i11 + 1;
                        this.predictGround[i11] = m1416b;
                    }
                    if (m1416b > s) {
                        int i12 = i9 - i7;
                        if (i12 > 4) {
                            int i13 = i4 + 1;
                            this.predictGround[i4] = (short) (i7 + (i12 / 2));
                            int i14 = i13 + 1;
                            this.predictGround[i13] = (short) (s + ELEV_STEP_HALF);
                            int i15 = i14 + 1;
                            this.predictGround[i14] = (short) i9;
                            this.predictGround[i15] = m1416b;
                            i4 = i15 + 1;
                            i7 = i9;
                        }
                        if (m1416b < this.predictGroundMin) {
                            this.predictGroundMin = m1416b;
                        }
                        if (m1416b > this.predictGroundMax) {
                            this.predictGroundMax = m1416b;
                        }
                        s = m1416b;
                    } else {
                        if (m1416b < s) {
                            int i16 = i9 - i7;
                            if (i16 > 40) {
                                int i17 = i4 + 1;
                                this.predictGround[i4] = (short) (i7 + (i16 / 2));
                                i4 = i17 + 1;
                                this.predictGround[i17] = (short) (s + ELEV_STEP_HALF);
                            }
                            int i18 = i4 + 1;
                            this.predictGround[i4] = (short) (i9 - 1);
                            i4 = i18 + 1;
                            this.predictGround[i18] = s;
                            i7 = i9;
                        }
                        if (m1416b < this.predictGroundMin) {
                        }
                        if (m1416b > this.predictGroundMax) {
                        }
                        s = m1416b;
                    }
                }
                i2++;
                i3 = i8;
                f3 = f16;
                f11 = f17;
                f12 = 1.0f;
            }
            int i19 = i4 + 1;
            this.predictGround[i4] = (short) (this.width + 10);
            this.predictGround[i19] = s;
            this.predictAirSize = i5;
            this.predictGroundSize = i19 + 1;
        }
    }

    private void drawPredict(Canvas canvas) {
        int i2 = this.rec.left;
        int i3 = this.rec.top;
        int i4 = this.predictGroundSize;
        if (i4 < 2) {
            return;
        }
        this.minAlt = this.predictGroundMin;
        this.maxAlt = this.predictGroundMax;
        if (C0239g.f1426s + 400 > this.maxAlt) {
            this.maxAlt = C0239g.f1426s + 400;
        }
        if (C0239g.f1426s < this.minAlt) {
            this.minAlt = C0239g.f1426s;
        }
        this.minAlt -= 100;
        this.maxAlt += 100;
        int i5 = this.height - (MARGIN_TOP * 2);
        int i6 = 0;
        int i7 = (this.maxAlt - this.minAlt) + 0;
        float f2 = i7 != 0 ? i5 / i7 : 0.0f;
        this.gPath.rewind();
        int i8 = this.minAlt;
        this.gPath.moveTo(i2, (this.height - (((int) ((this.predictGround[1] - i8) * f2)) + MARGIN_TOP)) + i3);
        int i9 = 0;
        int i10 = 0;
        while (i9 < i4) {
            short s = this.predictGround[i9];
            this.gPath.lineTo(i2 + s, (this.height - (((int) ((this.predictGround[i9 + 1] - i8) * f2)) + MARGIN_TOP)) + i3);
            i9 += 2;
            i10 = s;
        }
        this.gPath.lineTo(i10 + i2, this.height + MARGIN_TOP + i3);
        this.gPath.lineTo(i2 - 10, this.height + MARGIN_TOP + i3);
        this.gPath.close();
        canvas.drawPath(this.gPath, this.paintGround);
        canvas.drawPath(this.gPath, this.paintGroundStroke);
        if (this.predictAirSize > 1) {
            this.aPath.rewind();
            float f3 = i3 - 1;
            this.aPath.moveTo(i2 + 0, f3);
            int i11 = -1;
            int i12 = i10;
            while (i6 < this.predictAirSize) {
                short s2 = this.predictAir[i6];
                if (this.predictAir[i6 + 1] != -1) {
                    float f4 = s2 + i2;
                    this.aPath.lineTo(f4, i11 + i3);
                    i11 = this.height - (((int) (((r13 * ELEV_STEP_HALF) - i8) * f2)) + MARGIN_TOP);
                    this.aPath.lineTo(f4, i11 + i3);
                } else {
                    this.aPath.lineTo(s2 + i2, i11 + i3);
                }
                i6 += 2;
                i12 = s2;
            }
            int i13 = i12;
            if (i12 < behindPix * 2) {
                i13 = behindPix * 2;
            }
            Path path = this.aPath;
            float f5 = i13 + behindPix + i2;
            path.lineTo(f5, i11 + i3);
            canvas.drawPath(this.aPath, C0096g.m495a(1.0f, C0101l.f585j));
            this.aPath.lineTo(f5, f3);
            this.aPath.close();
            Paint m500c = C0096g.m500c(0.0f, C0101l.f589n);
            m500c.setAlpha(200);
            canvas.drawPath(this.aPath, m500c);
            m500c.setAlpha(255);
        }
        int i14 = this.height - (((int) ((C0239g.f1426s - i8) * f2)) + MARGIN_TOP);
        int i15 = behindPix;
        int i16 = C0101l.f578c;
        float f6 = i14 + i3;
        canvas.drawRect((this.rec.left + behindPix) - i16, r1 - (i16 / 2), this.rec.left + behindPix, f6, C0096g.m500c(0.0f, C0101l.f590o));
        if (C0239g.m1080k() > 0.5d) {
            canvas.drawLine(i15 + i2, f6, ((int) this.point2PixDistance) + i15 + i2, (this.height - (((int) (((C0239g.f1426s - ((int) ((this.point2kmDist / r1) * 1000.0f))) - i8) * f2)) + MARGIN_TOP)) + i3, this.paintDashed);
        }
        int i17 = (this.height - (((int) (f2 * (this.maxAlt - i8))) + MARGIN_TOP)) + C0101l.f578c;
        canvas.drawText(String.valueOf(C0377q.m1287e((this.maxAlt / 100) * 100)) + " " + C0377q.f2083b, this.clipRec.right - (C0101l.f578c * 4), i17 + i3, C0096g.m501d());
    }

    private void fixSize() {
        this.rec.right = this.rec.left + this.width;
        if (this.customPosition) {
            this.rec.bottom = this.rec.top + this.height;
        }
    }

    @Override // display.vmap.boxes.InfoBox
    protected void draw(Canvas canvas) {
        if (this.width == 0) {
            return;
        }
        if (C0239g.f1431x < 20 || C0239g.f1418k < 1.0f) {
            createPredict(canvas);
        }
        Rect clipBounds = canvas.getClipBounds();
        canvas.clipRect(this.clipRec);
        drawPredict(canvas);
        canvas.clipRect(clipBounds, Region.Op.REPLACE);
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
    public void initSize(float f2) {
        super.initSize(f2);
        fixSize();
    }

    @Override // display.vmap.boxes.InfoBox
    public boolean isInside(int i2, int i3) {
        return !disabled && this.rec.contains(i2, i3);
    }

    @Override // display.vmap.boxes.InfoBox
    public boolean isTimeRotatable() {
        return !this.customPosition;
    }

    @Override // display.vmap.boxes.InfoBox
    public boolean onClick() {
        if (!this.customPosition && ViewVmp.isRotating() && ViewVmp.isThermailing()) {
            return true;
        }
        boolean z = !this.customPosition;
        if (z && ViewVmp.isThermailing()) {
            return true;
        }
        if (z != defaultCustomPosition || z != this.customPosition) {
            defaultCustomPosition = z;
            if (z && !ViewVmp.isRotating()) {
                ViewVmp.setFlag(64);
            }
            ViewVmp.setFlag(1);
        }
        return true;
    }

    @Override // display.vmap.boxes.InfoBox
    public void onFinalized(LayoutManager layoutManager) {
        this.width = RingPainter.setPosition(world) / 2;
        fixSize();
        if (this.customPosition) {
            int[] center = RingPainter.getCenter();
            int i2 = center[0];
            int i3 = (int) (world.f2123f - (ZoomIconPainter.zoomIconSize * 2));
            int radius = RingPainter.getRadius() + i2;
            if (i3 < radius) {
                i3 = radius;
            }
            this.width = ((radius + ((i3 - radius) / 2)) - i2) + behindPix;
            this.rec.right = this.rec.left + this.width;
            int width = this.rec.width();
            int height = this.rec.height();
            int i4 = center[0] - behindPix;
            int i5 = StatusMsg.height;
            this.rec.set(i4, i5, width + i4, height + i5);
        }
        this.width = this.rec.width();
        this.height = this.rec.height();
        this.predictGround = new short[(this.width * 2) + 8];
        this.predictAir = new short[(this.width * 2) + 8];
        resetAltitude();
        this.prevLng = 0.0f;
        this.prevLat = 0.0f;
        this.prevDirection = 0;
        this.prevKmPerWidth = 0;
        this.clipRec.set(this.rec);
        this.clipRec.right = this.clipRec.left + this.width;
    }

    @Override // display.vmap.boxes.InfoBox
    public void onModeChanged(boolean z, boolean z2) {
        boolean z3 = this.customPosition;
        if (z3 && !z) {
            z3 = false;
        }
        if (z3 && z2 && z) {
            z3 = false;
        }
        if (z3 != defaultCustomPosition) {
            ViewVmp.setFlag(1);
        }
    }

    public void resetAltitude() {
        this.maxAlt = 0;
        this.minAlt = 0;
        this.predictGroundMin = 9999;
        this.predictGroundMax = -9999;
    }

    @Override // display.vmap.boxes.InfoBox
    public void update(Canvas canvas) {
        if (disabled) {
            return;
        }
        super.update(canvas);
    }
}
