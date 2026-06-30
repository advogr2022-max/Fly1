package flyme_data;

/* renamed from: m.e */
/* loaded from: classes.dex */
public class C0237e {

    /* renamed from: a */
    public static boolean f1352a = true;

    /* renamed from: b */
    private int f1353b = 0;

    /* renamed from: c */
    private float f1354c = 0.0f;

    /* renamed from: d */
    private float f1355d = 0.0f;

    /* renamed from: e */
    private boolean f1356e;

    public C0237e() {
        m1054a();
    }

    /* renamed from: a */
    public float m1053a(float f2) {
        if (!f1352a) {
            return f2;
        }
        if (!this.f1356e && ((C0239g.f1433z && Math.abs(C0239g.f1416i) < 1.0f) || C0238f.m1059d())) {
            short s = C0239g.m1073d().f1974c;
            this.f1353b++;
            this.f1354c = s != 0 ? s - f2 : 0.0f;
            if (C0238f.m1059d() || this.f1353b > 50) {
                this.f1355d = this.f1354c;
                this.f1356e = true;
            } else if (this.f1353b % 5 == 0) {
                this.f1355d = this.f1354c;
            }
        }
        return f2 + this.f1355d;
    }

    /* renamed from: a */
    public void m1054a() {
        this.f1356e = false;
        this.f1354c = 0.0f;
        this.f1355d = 0.0f;
        this.f1353b = 0;
        this.f1356e = false;
        f1352a = true;
    }
}
