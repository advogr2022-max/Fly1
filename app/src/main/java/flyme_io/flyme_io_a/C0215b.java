package flyme_io.flyme_io_a;

/* renamed from: i.a.b */
/* loaded from: classes.dex */
public class C0215b {

    /* renamed from: a */
    public C0214a[] f1154a;

    /* renamed from: b */
    public int f1155b;

    /* renamed from: c */
    public int f1156c;

    public C0215b(int i2, int i3) {
        this.f1154a = new C0214a[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            this.f1154a[i4] = new C0214a();
            this.f1154a[i4].f1147b = i3;
        }
    }

    /* renamed from: a */
    private int m902a(int i2, int i3, int i4, int i5, int i6) {
        int i7 = (i3 - i2) / 4;
        int min = Math.min(i7, (i4 - i3) / 4);
        int min2 = Math.min(min, (i5 - i4) / 4);
        int i8 = (i6 - i5) / 4;
        int min3 = Math.min(min2, i8);
        int i9 = i6 / 10;
        if (i9 > 50) {
            i9 = 50;
        }
        if (i7 < i9) {
            i7 = i9;
        }
        if (min < i9) {
            min = i9;
        }
        if (min2 < i9) {
            min2 = i9;
        }
        if (min3 < i9) {
            min3 = i9;
        }
        if (i8 < i9) {
            i8 = i9;
        }
        for (int i10 = 0; i10 < this.f1154a.length; i10++) {
            C0214a c0214a = this.f1154a[i10];
            if (Math.abs(c0214a.f1146a[0] - i2) < i7 && Math.abs(c0214a.f1146a[1] - i3) < min && Math.abs(c0214a.f1146a[2] - i4) < min2 && Math.abs(c0214a.f1146a[3] - i5) < min3 && Math.abs(c0214a.f1146a[4] - i6) < i8) {
                return i10;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public C0214a m903a() {
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f1154a.length; i4++) {
            C0214a c0214a = this.f1154a[i4];
            if (c0214a.f1148c > i2) {
                i2 = c0214a.f1148c;
                i3 = i4;
            }
        }
        return this.f1154a[i3];
    }

    /* renamed from: a */
    public void m904a(int i2, int i3, int i4, int i5, int i6, int i7) {
        int m902a = m902a(i3, i4, i5, i6, i7);
        if (m902a == -1) {
            m905b(i2, i3, i4, i5, i6, i7);
            return;
        }
        if (i2 > this.f1154a[m902a].f1148c) {
            this.f1154a[m902a].m901a(i2, i3, i4, i5, i6, i7);
            for (int i8 = m902a - 1; i8 >= 0 && this.f1154a[i8].f1148c < i2; i8--) {
                C0214a c0214a = this.f1154a[i8];
                int i9 = i8 + 1;
                this.f1154a[i8] = this.f1154a[i9];
                this.f1154a[i9] = c0214a;
            }
            if (i2 > this.f1155b) {
                this.f1155b = i2;
            }
        }
    }

    /* renamed from: b */
    public void m905b(int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = 0;
        while (true) {
            if (i8 >= this.f1154a.length) {
                break;
            }
            if (this.f1154a[i8].f1148c < i2) {
                C0214a c0214a = this.f1154a[this.f1154a.length - 1];
                for (int length = this.f1154a.length - 1; length > i8; length--) {
                    this.f1154a[length] = this.f1154a[length - 1];
                }
                this.f1154a[i8] = c0214a;
                c0214a.m901a(i2, i3, i4, i5, i6, i7);
            } else {
                i8++;
            }
        }
        this.f1155b = this.f1154a[0].f1148c;
        this.f1156c = this.f1154a[this.f1154a.length - 1].f1148c;
    }
}
