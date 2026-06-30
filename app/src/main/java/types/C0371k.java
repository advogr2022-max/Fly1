package types;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import com.xcglobe.xclog.C0101l;
import java.io.IOException;
import java.util.ArrayList;
import vmaps.core.C0390i;

/* renamed from: types.k */
/* loaded from: classes.dex */
public class C0371k {
    private static int r6 = 0;

    /* renamed from: a */
    public byte[] f2025a;

    /* renamed from: b */
    int f2026b;

    /* renamed from: c */
    int f2027c;

    /* renamed from: d */
    int f2028d;

    /* renamed from: e */
    public float f2029e;

    /* renamed from: f */
    public float f2030f;

    /* renamed from: g */
    public float f2031g;

    /* renamed from: h */
    public float f2032h;

    /* renamed from: i */
    public float f2033i;

    /* renamed from: j */
    public float f2034j;

    /* renamed from: l */
    public int f2036l;

    /* renamed from: k */
    public int f2035k = 0;

    /* renamed from: m */
    private int f2037m = 10;

    /* renamed from: n */
    private a f2038n = new a();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: types.k$a */
    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: a */
        int f2039a;

        /* renamed from: b */
        float f2040b;

        /* renamed from: c */
        float f2041c;

        /* renamed from: d */
        float f2042d;

        /* renamed from: e */
        float f2043e;

        /* renamed from: f */
        int f2044f;

        /* renamed from: g */
        int f2045g;

        /* renamed from: h */
        int f2046h;

        /* renamed from: i */
        int f2047i;

        /* renamed from: j */
        int f2048j;

        /* renamed from: k */
        int f2049k;

        /* renamed from: l */
        int f2050l;

        /* renamed from: m */
        int f2051m;

        /* renamed from: n */
        int f2052n;

        private a() {
        }
    }

    public C0371k(int i2, int i3) {
        this.f2026b = i2;
        this.f2027c = i3;
        this.f2028d = this.f2026b * this.f2027c;
        this.f2025a = new byte[this.f2028d];
    }

    /* renamed from: a */
    public static int m1250a(int i2) {
        int i3;
        int i4;
        int i5 = 0;
        if (i2 < 3200) {
            int i6 = i2 / 100;
            i3 = (i6 * 10) & 255;
            i4 = i6 * 8;
        } else {
            int i7 = (i2 - 3200) / 150;
            i3 = i7 > 255 ? 255 : i7;
            i4 = 0;
            i5 = 255;
        }
        return Color.rgb(i3, i4, i5);
    }

    /* renamed from: a */
    private int m1251a(int i2, int i3, int i4, int i5, int i6) {
        int i7 = this.f2038n.f2048j;
        if (i7 >= i2 && i7 >= i3 && i7 >= i4 && i7 > 0) {
            i7 += 50;
        }
        int i8 = i5 < i6 ? i5 : i6;
        return ((((i7 * 100) + (i2 * i5)) + (i3 * i6)) + (i4 * i8)) / (((i5 + i6) + i8) + 100);
    }

    /* renamed from: a */
    public static C0371k m1252a(int i2, int i3, float f2, float f3, int i4) {
        Paint paint = new Paint();
        paint.setAntiAlias(false);
        paint.setDither(false);
        paint.setStyle(Paint.Style.FILL);
        C0367g c0367g = new C0367g();
        C0376p c0376p = new C0376p();
        c0376p.m1276a(i4 * 2, f2, i2, (int) (i3 * C0369i.f2020a));
        c0376p.m1277a(f2, f3, c0367g);
        ArrayList<String> m1271a = C0375o.m1271a(c0367g);
        C0390i c0390i = new C0390i(false);
        c0390i.m1407a(i2, i3, c0367g.f2012a, c0367g.f2014c, c0376p.f2077h, c0376p.f2078i);
        Bitmap createBitmap = Bitmap.createBitmap(i2, i3, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Path path = new Path();
        for (int i5 = 0; i5 < m1271a.size(); i5++) {
            try {
                c0390i.m1408a(C0101l.m537a("vmp/" + m1271a.get(i5) + ".vmp"));
                while (c0390i.m1410b()) {
                    if (c0390i.f2218d >= 0 && c0390i.f2220f != 0) {
                        path.reset();
                        path.moveTo(c0390i.f2215a[0], c0390i.f2216b[0]);
                        for (int i6 = 1; i6 < c0390i.f2220f; i6++) {
                            path.lineTo(c0390i.f2215a[i6], c0390i.f2216b[i6]);
                        }
                        paint.setColor(m1250a(c0390i.f2218d));
                        canvas.drawPath(path, paint);
                    }
                }
            } catch (IOException unused) {
            }
        }
        C0371k c0371k = new C0371k(i2, i3);
        c0371k.m1257a(i4, createBitmap, c0367g);
        return c0371k;
    }

    /* renamed from: a */
    private void m1253a(Bitmap bitmap) {
        int[] iArr = new int[this.f2028d];
        bitmap.getPixels(iArr, 0, this.f2026b, 0, 0, this.f2026b, this.f2027c);
        for (int i2 = 0; i2 < this.f2028d; i2++) {
            int i3 = iArr[i2];
            this.f2025a[i2] = (byte) (((i3 & 255) < 128 ? (((i3 >> 8) & 255) / 8) * 100 : (((i3 >> 16) & 255) * 150) + 3200) / 50);
        }
    }

    /* renamed from: b */
    private void m1254b(int i2, int i3) {
        int i4 = (this.f2026b * i3) + i2;
        this.f2038n.f2039a = i4;
        this.f2038n.f2040b = this.f2031g + (i3 / this.f2034j);
        this.f2038n.f2041c = this.f2032h + (i2 / this.f2033i);
        a aVar = this.f2038n;
        int i5 = this.f2025a[i4] * 50;
        aVar.f2048j = i5;
        int i6 = (i4 - this.f2026b) - 1;
        int i7 = i6 + 1;
        this.f2038n.f2044f = this.f2025a[i6] * 50;
        a aVar2 = this.f2038n;
        int i8 = i7 + 1;
        int i9 = this.f2025a[i7] * 50;
        aVar2.f2045g = i9;
        int i10 = i9 <= i5 ? 1 : 0;
        this.f2038n.f2046h = this.f2025a[i8] * 50;
        int i11 = i4 - 1;
        a aVar3 = this.f2038n;
        int i12 = i11 + 1;
        int i13 = this.f2025a[i11] * 50;
        aVar3.f2047i = i13;
        if (i13 <= i5) {
            i10++;
        }
        a aVar4 = this.f2038n;
        int i14 = this.f2025a[i12] * 50;
        aVar4.f2049k = i14;
        if (i14 <= i5) {
            i10++;
        }
        int i15 = (i4 + this.f2026b) - 1;
        int i16 = i15 + 1;
        this.f2038n.f2050l = this.f2025a[i15] * 50;
        a aVar5 = this.f2038n;
        int i17 = i16 + 1;
        int i18 = this.f2025a[i16] * 50;
        aVar5.f2051m = i18;
        if (i18 <= i5) {
            i10++;
        }
        this.f2038n.f2052n = this.f2025a[i17] * 50;
        if (i10 == 4) {
            this.f2038n.f2048j += 50;
        }
        this.f2038n.f2042d = 1.0f / this.f2034j;
        this.f2038n.f2043e = 1.0f / this.f2033i;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00ae  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public int m1255a(float f2, float f3, boolean z) {
        int i2;
        int i3;
        int i4;
        int i5 = (int) ((f3 - this.f2032h) * this.f2033i);
        int i6 = (int) (this.f2027c - ((f2 - this.f2031g) * this.f2034j));
        if (i5 >= this.f2037m && i5 <= this.f2026b - this.f2037m && i6 >= this.f2037m && i6 <= this.f2027c - this.f2037m) {
            int i7 = (this.f2026b * i6) + i5;
            if (!z) {
                int i8 = this.f2025a[i7] * 50;
                this.f2035k = i8;
                return i8 + 50 + 1;
            }
            if (this.f2038n.f2039a != i7) {
                m1254b(i5, i6);
            }
            int i9 = (int) (((f3 - this.f2038n.f2041c) / this.f2038n.f2043e) * 100.0f);
            int i10 = (int) (((f2 - this.f2038n.f2040b) / this.f2038n.f2042d) * 100.0f);
            if (i9 > 0) {
                if (i10 > 0) {
                    i2 = this.f2038n.f2049k;
                    i3 = this.f2038n.f2045g;
                    i4 = this.f2038n.f2046h;
                    int m1251a = m1251a(i2, i3, i4, i9, i10);
                    r6 = m1251a != 0 ? m1251a + 50 + 1 : 0;
                    this.f2035k = r6;
                } else {
                    i2 = this.f2038n.f2049k;
                    i3 = this.f2038n.f2051m;
                    i4 = this.f2038n.f2052n;
                    i10 = -i10;
                    int m1251a2 = m1251a(i2, i3, i4, i9, i10);
                    if (m1251a2 != 0) {
                    }
                    this.f2035k = r6;
                }
            } else if (i10 > 0) {
                i2 = this.f2038n.f2047i;
                i3 = this.f2038n.f2045g;
                i4 = this.f2038n.f2044f;
                i9 = -i9;
                int m1251a22 = m1251a(i2, i3, i4, i9, i10);
                if (m1251a22 != 0) {
                }
                this.f2035k = r6;
            } else {
                i2 = this.f2038n.f2047i;
                i3 = this.f2038n.f2051m;
                i4 = this.f2038n.f2050l;
                i9 = -i9;
                i10 = -i10;
                int m1251a222 = m1251a(i2, i3, i4, i9, i10);
                if (m1251a222 != 0) {
                }
                this.f2035k = r6;
            }
        }
        return r6;
    }

    /* renamed from: a */
    public int m1256a(int i2, int i3) {
        return (this.f2025a[(i3 * this.f2026b) + i2] * 50) + 50 + 1;
    }

    /* renamed from: a */
    public void m1257a(int i2, Bitmap bitmap, C0367g c0367g) {
        this.f2036l = i2;
        this.f2029e = c0367g.f2012a + (c0367g.m1237f() / 2.0f);
        this.f2030f = c0367g.f2014c + (c0367g.m1238g() / 2.0f);
        this.f2031g = c0367g.f2012a;
        this.f2032h = c0367g.f2014c;
        this.f2033i = this.f2026b / c0367g.m1238g();
        this.f2034j = this.f2027c / c0367g.m1237f();
        m1253a(bitmap);
    }
}
