package types;

/* renamed from: types.c */
/* loaded from: classes.dex */
public class C0363c {

    /* renamed from: a */
    public int f1992a;

    /* renamed from: b */
    public int f1993b;

    /* renamed from: c */
    public int f1994c;

    /* renamed from: d */
    public int f1995d;

    /* renamed from: e */
    int f1996e = 0;

    /* renamed from: a */
    public void m1182a() {
        this.f1996e = 0;
        this.f1995d = 0;
        this.f1994c = 0;
        this.f1993b = 0;
        this.f1992a = 0;
    }

    /* renamed from: a */
    public void m1183a(int i2, int i3) {
        int i4 = this.f1996e;
        this.f1996e = i4 + 1;
        if (i4 != 0) {
            if (i2 < this.f1992a) {
                this.f1992a = i2;
            } else if (i2 > this.f1994c) {
                this.f1994c = i2;
            }
            if (i3 >= this.f1993b) {
                if (i3 > this.f1995d) {
                    this.f1995d = i3;
                    return;
                }
                return;
            }
        } else {
            this.f1992a = i2;
            this.f1994c = i2;
            this.f1995d = i3;
        }
        this.f1993b = i3;
    }

    /* renamed from: a */
    public boolean m1184a(int[] iArr) {
        return iArr[0] >= this.f1992a && iArr[0] <= this.f1994c && iArr[1] >= this.f1993b && iArr[1] <= this.f1995d;
    }

    /* renamed from: b */
    public int m1185b() {
        return this.f1994c - this.f1992a;
    }

    /* renamed from: b */
    public void m1186b(int i2, int i3) {
        this.f1992a += i2;
        this.f1994c += i2;
        this.f1993b += i3;
        this.f1995d += i3;
    }

    /* renamed from: c */
    public int m1187c() {
        return this.f1995d - this.f1993b;
    }

    /* renamed from: d */
    public int m1188d() {
        double d2 = this.f1994c - this.f1992a;
        double d3 = this.f1995d - this.f1993b;
        Double.isNaN(d2);
        Double.isNaN(d2);
        Double.isNaN(d3);
        Double.isNaN(d3);
        return (int) Math.sqrt((d2 * d2) + (d3 * d3));
    }
}
