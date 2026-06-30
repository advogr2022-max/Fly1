package flyme_misc;

/* renamed from: g.e */
/* loaded from: classes.dex */
public class C0207e implements InterfaceC0204b {

    /* renamed from: b */
    public float f1074b;

    /* renamed from: c */
    private int f1075c;

    /* renamed from: d */
    private float[] f1076d;

    /* renamed from: e */
    private long[] f1077e;

    /* renamed from: a */
    public int f1073a = 2000;

    /* renamed from: f */
    private int f1078f = 0;

    /* renamed from: g */
    private int f1079g = 0;

    /* renamed from: h */
    private float f1080h = 0.0f;

    /* renamed from: i */
    private int f1081i = 0;

    public C0207e(int i2) {
        m878a(i2);
    }

    @Override // flyme_misc.InterfaceC0204b
    /* renamed from: a */
    public float mo866a(float f2, long j2) {
        this.f1076d[this.f1079g] = f2;
        this.f1077e[this.f1079g] = j2;
        this.f1080h += f2;
        this.f1081i++;
        long j3 = j2 - this.f1073a;
        while (this.f1077e[this.f1078f] < j3) {
            this.f1080h -= this.f1076d[this.f1078f];
            this.f1081i--;
            int i2 = this.f1078f + 1;
            this.f1078f = i2;
            if (i2 == this.f1075c) {
                this.f1078f = 0;
            }
        }
        int i3 = this.f1079g + 1;
        this.f1079g = i3;
        if (i3 == this.f1075c) {
            this.f1079g = 0;
        }
        if (this.f1079g == this.f1078f) {
            this.f1080h -= this.f1076d[this.f1078f];
            this.f1081i--;
            int i4 = this.f1078f + 1;
            this.f1078f = i4;
            if (i4 == this.f1075c) {
                this.f1078f = 0;
            }
        }
        this.f1074b = (this.f1080h + f2) / (this.f1081i + 1);
        return this.f1074b;
    }

    /* renamed from: a */
    public void m877a() {
        this.f1078f = 0;
        this.f1079g = 0;
        this.f1080h = 0.0f;
        this.f1081i = 0;
    }

    /* renamed from: a */
    public void m878a(int i2) {
        this.f1073a = i2;
        this.f1075c = i2 / 10;
        if (this.f1075c < 100) {
            this.f1075c = 100;
        }
        this.f1076d = new float[this.f1075c];
        this.f1077e = new long[this.f1075c];
        m877a();
    }
}
