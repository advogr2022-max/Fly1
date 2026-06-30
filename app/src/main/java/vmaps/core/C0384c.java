package vmaps.core;

/* renamed from: vmaps.core.c */
/* loaded from: classes.dex */
public class C0384c {

    /* renamed from: a */
    int f2164a;

    /* renamed from: b */
    private int f2165b;

    /* renamed from: c */
    private int f2166c;

    /* renamed from: d */
    private boolean f2167d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C0384c(int i2) {
        this.f2164a = i2;
        if (this.f2164a < 2) {
            throw new IllegalArgumentException("locate size error");
        }
        this.f2165b = 0;
        this.f2167d = false;
        this.f2166c = Math.min(1, (int) Math.pow(this.f2164a, 0.25d));
    }

    /* renamed from: b */
    private int m1363b(double d2) {
        boolean z = true;
        boolean z2 = this.f2164a - 1 >= 0;
        int i2 = this.f2164a - 1;
        int i3 = 0;
        while (i2 - i3 > 1) {
            int i4 = (i2 + i3) >> 1;
            if ((d2 >= ((double) i4)) == z2) {
                i3 = i4;
            } else {
                i2 = i4;
            }
        }
        if (i3 < this.f2165b ? this.f2165b - i3 > this.f2166c : i3 - this.f2165b > this.f2166c) {
            z = false;
        }
        this.f2167d = z;
        this.f2165b = i3;
        if (this.f2164a - 2 < i3) {
            if (this.f2164a - 2 < 0) {
                return 0;
            }
            return this.f2164a - 2;
        }
        if (i3 < 0) {
            return 0;
        }
        return i3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:66:0x0053, code lost:
    
        r0 = r4;
     */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0094  */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private int m1364c(double d2) {
        int i2;
        int i3;
        int i4 = this.f2165b;
        boolean z = true;
        boolean z2 = this.f2164a - 1 >= 0;
        if (i4 >= 0 && i4 <= this.f2164a - 1) {
            if ((d2 >= ((double) i4)) == z2) {
                int i5 = 1;
                while (true) {
                    i2 = i4 + i5;
                    if (i2 >= this.f2164a - 1) {
                        i2 = this.f2164a - 1;
                        break;
                    }
                    if ((d2 < ((double) i2)) == z2) {
                        break;
                    }
                    i5 += i5;
                    i4 = i2;
                }
            } else {
                i2 = i4;
                int i6 = 1;
                while (true) {
                    int i7 = i2 - i6;
                    if (i7 <= 0) {
                        break;
                    }
                    if ((d2 >= ((double) i7)) != z2) {
                        i6 += i6;
                        i2 = i7;
                    }
                    i4 = i3;
                }
            }
            while (i2 - i4 > 1) {
                i3 = (i2 + i4) >> 1;
                if ((d2 >= ((double) i3)) == z2) {
                    i4 = i3;
                } else {
                    i2 = i3;
                }
            }
            if (i4 >= this.f2165b ? this.f2165b - i4 > this.f2166c : i4 - this.f2165b > this.f2166c) {
            }
            this.f2167d = z;
            this.f2165b = i4;
            if (this.f2164a - 2 >= i4) {
                if (this.f2164a - 2 < 0) {
                    return 0;
                }
                return this.f2164a - 2;
            }
            if (i4 < 0) {
                return 0;
            }
            return i4;
        }
        i2 = this.f2164a - 1;
        i4 = 0;
        while (i2 - i4 > 1) {
        }
        z = i4 >= this.f2165b ? false : false;
        this.f2167d = z;
        this.f2165b = i4;
        if (this.f2164a - 2 >= i4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public int m1365a(double d2) {
        return this.f2167d ? m1364c(d2) : m1363b(d2);
    }
}
