package types;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import com.xcglobe.xclog.C0101l;
import java.util.ArrayList;
import java.util.HashSet;
import flyme_fileutil.C0001b;
import vmaps.C0379a;

/* renamed from: types.a */
/* loaded from: classes.dex */
public class C0361a {

    /* renamed from: d */
    public float f1984d;

    /* renamed from: e */
    public float f1985e;

    /* renamed from: a */
    public ArrayList<C0001b> f1981a = new ArrayList<>();

    /* renamed from: f */
    private C0367g f1986f = new C0367g();

    /* renamed from: b */
    public byte[] f1982b = new byte[10000];

    /* renamed from: c */
    public byte[] f1983c = new byte[10000];

    /* renamed from: a */
    public static int m1173a(int i2) {
        return Color.rgb(((i2 >> 6) & 3) * 2, ((i2 >> 2) & 15) * 2, (i2 & 3) * 2);
    }

    /* renamed from: a */
    private void m1174a(float f2, float f3, int i2) {
        C0371k m1252a = C0371k.m1252a(25, 25, f2, f3, i2);
        for (int i3 = 0; i3 < 100; i3++) {
            int i4 = i3 * 100;
            for (int i5 = 0; i5 < 100; i5++) {
                int m1256a = m1252a.m1256a(i5 / 4, i3 / 4);
                byte b2 = this.f1983c[i4];
                if (b2 != -1) {
                    C0001b c0001b = this.f1981a.get(b2);
                    if (c0001b.f8e) {
                        this.f1982b[i4] = (byte) ((c0001b.f7d + m1256a) / 50);
                    } else {
                        this.f1982b[i4] = (byte) (c0001b.f7d / 50);
                    }
                } else {
                    this.f1982b[i4] = -1;
                }
                i4++;
            }
        }
    }

    /* renamed from: a */
    private void m1175a(Bitmap bitmap) {
        int[] iArr = new int[10000];
        bitmap.getPixels(iArr, 0, 100, 0, 0, 100, 100);
        for (int i2 = 0; i2 < 100; i2++) {
            int i3 = i2 * 100;
            for (int i4 = 0; i4 < 100; i4++) {
                int i5 = iArr[i3];
                int i6 = (i5 >> 8) & 255;
                this.f1983c[i3] = (byte) (((((i5 >> 16) & 255) / 2) << 6) | ((i6 / 2) << 2) | ((i5 & 255) / 2));
                i3++;
            }
        }
    }

    /* renamed from: a */
    private boolean m1176a(Canvas canvas, Paint paint, Bitmap bitmap) {
        canvas.drawColor(m1173a(-1));
        Path path = new Path();
        boolean z = false;
        for (int i2 = 0; i2 < this.f1981a.size(); i2++) {
            C0001b c0001b = this.f1981a.get(i2);
            if (c0001b.f8e) {
                z = true;
            }
            path.reset();
            for (int i3 = 0; i3 < c0001b.f5b.length; i3++) {
                int i4 = (int) (((c0001b.f6c[i3] / 1000.0f) - this.f1986f.f2014c) * this.f1984d);
                int i5 = (int) (100.0f - (((c0001b.f5b[i3] / 1000.0f) - this.f1986f.f2012a) * this.f1985e));
                if (i3 == 0) {
                    path.moveTo(i4, i5);
                } else {
                    path.lineTo(i4, i5);
                }
            }
            paint.setColor(m1173a(i2));
            canvas.drawPath(path, paint);
        }
        m1175a(bitmap);
        return z;
    }

    /* renamed from: a */
    public byte m1177a(float f2, float f3, byte[] bArr) {
        float f4 = (f3 - this.f1986f.f2014c) * this.f1984d;
        float f5 = 100.0f - ((f2 - this.f1986f.f2012a) * this.f1985e);
        int i2 = (int) f4;
        int i3 = (int) f5;
        if (i2 < 0 || i3 < 0 || i2 >= 100 || i3 >= 100) {
            return (byte) -1;
        }
        int i4 = (i3 * 100) + i2;
        byte b2 = this.f1983c[i4];
        bArr[1] = b2;
        if (b2 == -1) {
            return (byte) -1;
        }
        byte b3 = this.f1982b[i4];
        bArr[0] = b3;
        return b3;
    }

    /* renamed from: a */
    void m1178a() {
        for (int i2 = 0; i2 < 10000; i2++) {
            byte b2 = this.f1983c[i2];
            if (b2 != -1) {
                this.f1982b[i2] = (byte) (this.f1981a.get(b2).f7d / 50);
            } else {
                this.f1982b[i2] = -1;
            }
        }
    }

    /* renamed from: a */
    public void m1179a(float f2, float f3) {
        Paint paint = new Paint();
        paint.setAntiAlias(false);
        paint.setDither(false);
        paint.setStyle(Paint.Style.FILL);
        C0376p c0376p = new C0376p();
        c0376p.m1276a(100, f2, 100, (int) (C0369i.f2020a * 100.0f));
        c0376p.m1277a(f2, f3, this.f1986f);
        ArrayList<Integer> m1273b = C0375o.m1273b(this.f1986f);
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < m1273b.size(); i2++) {
            this.f1981a.addAll(C0001b.m5a(C0101l.m537a("air/" + C0379a.f2108a + "-" + m1273b.get(i2) + ".air"), this.f1986f, hashSet));
        }
        c0376p.m1276a(20, f2, 100, (int) (C0369i.f2020a * 100.0f));
        c0376p.m1277a(f2, f3, this.f1986f);
        this.f1984d = c0376p.f2077h;
        this.f1985e = c0376p.f2078i;
        Bitmap createBitmap = Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888);
        if (m1176a(new Canvas(createBitmap), paint, createBitmap)) {
            m1174a(f2, f3, 10);
        } else {
            m1178a();
        }
    }
}
