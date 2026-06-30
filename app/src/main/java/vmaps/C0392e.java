package vmaps;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Handler;
import com.xcglobe.xclog.C0101l;
import types.C0363c;
import types.C0367g;
import vmaps.core.AbstractC0386e;
import vmaps.core.C0387f;

/* renamed from: vmaps.e */
/* loaded from: classes.dex */
public class C0392e extends AbstractC0386e {

    /* renamed from: i */
    static Handler f2243i = new Handler();

    /* renamed from: b */
    public Bitmap f2245b;

    /* renamed from: c */
    Canvas f2246c;

    /* renamed from: d */
    Paint f2247d;

    /* renamed from: e */
    Paint f2248e;

    /* renamed from: o */
    private boolean f2252o;

    /* renamed from: a */
    public C0387f f2244a = null;

    /* renamed from: f */
    Path f2249f = new Path();

    /* renamed from: g */
    Rect f2250g = new Rect();

    /* renamed from: h */
    Rect f2251h = new Rect();

    @Override // vmaps.core.AbstractC0386e
    /* renamed from: a */
    public AbstractC0386e mo1381a() {
        return new C0392e();
    }

    /* renamed from: a */
    public void m1417a(int i2, int i3) {
        this.f2245b = Bitmap.createScaledBitmap(this.f2245b, i2, i3, true);
        this.f2246c = new Canvas(this.f2245b);
        m1389b(i2, i3, this.f2194l);
        this.f2250g.set(0, 0, i2, i3);
    }

    @Override // vmaps.core.AbstractC0386e
    /* renamed from: a */
    public void mo1382a(int i2, int i3, C0367g c0367g) {
        m1389b(i2, i3, c0367g);
        this.f2250g.set(0, 0, i2, i3);
        if (this.f2244a == null) {
            this.f2244a = new C0387f(C0101l.f554ad);
        }
        if (this.f2245b == null || this.f2245b.getWidth() != i2 || this.f2245b.getHeight() != i3) {
            this.f2245b = C0101l.m551b(this.f2192j, this.f2193k);
        }
        this.f2246c = new Canvas(this.f2245b);
        this.f2246c.drawColor(this.f2244a.m1394a());
        float f2 = this.f2195m > 800.0f ? 2.0f : 1.0f;
        if (this.f2195m < 300.0f) {
            f2 = 0.0f;
        }
        this.f2248e = new Paint();
        this.f2248e.setAntiAlias(true);
        this.f2248e.setColor(this.f2244a.m1394a());
        this.f2248e.setStyle(Paint.Style.STROKE);
        this.f2248e.setStrokeWidth(f2);
        if (this.f2195m > 300.0f) {
            this.f2248e.setStrokeJoin(Paint.Join.ROUND);
            this.f2248e.setPathEffect(new CornerPathEffect(C0101l.f575ay / 30));
        }
        this.f2247d = new Paint();
        this.f2247d.setAntiAlias(false);
        this.f2247d.setStyle(Paint.Style.FILL);
        this.f2247d.setStrokeWidth(0.0f);
        this.f2252o = false;
    }

    @Override // vmaps.core.AbstractC0386e
    /* renamed from: a */
    public void mo1384a(AbstractC0386e abstractC0386e, C0363c c0363c) {
        this.f2251h.set(c0363c.f1992a, c0363c.f1993b, c0363c.f1994c, c0363c.f1995d);
        Paint paint = new Paint();
        paint.setFilterBitmap(false);
        this.f2246c.drawBitmap(((C0392e) abstractC0386e).f2245b, this.f2251h, this.f2250g, paint);
    }

    @Override // vmaps.core.AbstractC0386e
    /* renamed from: a */
    public void mo1385a(int[] iArr) {
        this.f2245b.setPixels(iArr, 0, this.f2192j, 0, 0, this.f2192j, this.f2193k);
    }

    @Override // vmaps.core.AbstractC0386e
    /* renamed from: a */
    public void mo1386a(int[] iArr, int i2, int i3) {
        Bitmap m551b = C0101l.m551b(i2, i3);
        m551b.setPixels(iArr, 0, i2, 0, 0, i2, i3);
        Rect rect = new Rect(0, 0, i2, i3);
        Rect rect2 = new Rect(0, 0, this.f2192j, this.f2193k);
        Paint paint = new Paint();
        paint.setFilterBitmap(false);
        this.f2246c.drawBitmap(m551b, rect, rect2, paint);
        m551b.recycle();
    }

    @Override // vmaps.core.AbstractC0386e
    /* renamed from: a */
    public void mo1387a(int[] iArr, int[] iArr2, int i2, int i3, int i4) {
        Canvas canvas;
        Path path;
        Paint paint;
        this.f2249f.reset();
        this.f2249f.moveTo(iArr[0], iArr2[0]);
        for (int i5 = 1; i5 < i2; i5++) {
            this.f2249f.lineTo(iArr[i5], iArr2[i5]);
        }
        if (i3 == -2) {
            canvas = this.f2246c;
            path = this.f2249f;
            paint = this.f2248e;
        } else {
            this.f2247d.setColor(i4);
            canvas = this.f2246c;
            path = this.f2249f;
            paint = this.f2247d;
        }
        canvas.drawPath(path, paint);
    }

    @Override // vmaps.core.AbstractC0386e
    /* renamed from: b */
    public void mo1388b() {
        this.f2245b.recycle();
        this.f2245b = null;
        this.f2246c = null;
        this.f2247d = null;
    }

    @Override // vmaps.core.AbstractC0386e
    /* renamed from: c */
    public int[] mo1391c() {
        int[] iArr = new int[this.f2192j * this.f2193k];
        this.f2245b.getPixels(iArr, 0, this.f2192j, 0, 0, this.f2193k, this.f2193k);
        return iArr;
    }
}
