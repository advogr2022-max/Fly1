package flyme_misc;

/* renamed from: g.h */
/* loaded from: classes.dex */
public class C0210h {

    /* renamed from: a */
    private float f1102a = 0.0f;

    /* renamed from: b */
    private float f1103b = 0.0f;

    /* renamed from: c */
    private float f1104c;

    /* renamed from: d */
    private float f1105d;

    public C0210h(boolean z) {
        this.f1105d = 0.3f;
        this.f1104c = z ? 0.5f : 0.2f;
        this.f1105d = z ? 0.3f : 0.1f;
        m885a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0039, code lost:
    
        if (r7 < 0.1d) goto L6;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public float m884a(float f2, float f3) {
        if (Math.abs(this.f1102a - f3) >= this.f1104c || Math.abs(this.f1103b) >= 0.1d) {
            this.f1103b = f2;
            float abs = Math.abs(this.f1103b);
            if (abs >= this.f1105d) {
                f3 = 0.0f;
            }
            this.f1102a = f3;
        }
        this.f1103b = 1.0E-4f;
        return this.f1103b;
    }

    /* renamed from: a */
    public void m885a() {
        this.f1102a = 0.0f;
        this.f1103b = 0.0f;
    }
}
