package types;

/* renamed from: types.b */
/* loaded from: classes.dex */
public class C0362b {

    /* renamed from: a */
    public float f1987a;

    /* renamed from: b */
    public float f1988b;

    /* renamed from: c */
    public float f1989c;

    /* renamed from: d */
    public float f1990d;

    /* renamed from: e */
    int f1991e = 0;

    /* renamed from: a */
    public void m1180a() {
        this.f1991e = 0;
        this.f1990d = 0.0f;
        this.f1989c = 0.0f;
        this.f1988b = 0.0f;
        this.f1987a = 0.0f;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0024  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean m1181a(float f2, float f3) {
        boolean z;
        int i2 = this.f1991e;
        this.f1991e = i2 + 1;
        if (i2 != 0) {
            if (f2 < this.f1987a) {
                this.f1987a = f2;
            } else if (f2 > this.f1989c) {
                this.f1989c = f2;
            } else {
                z = false;
                if (f3 >= this.f1988b) {
                    if (f3 <= this.f1990d) {
                        return z;
                    }
                    this.f1990d = f3;
                    return true;
                }
            }
            z = true;
            if (f3 >= this.f1988b) {
            }
        } else {
            this.f1987a = f2;
            this.f1989c = f2;
            this.f1990d = f3;
        }
        this.f1988b = f3;
        return true;
    }
}
