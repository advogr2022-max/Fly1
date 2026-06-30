package flyme_io;

import types.C0362b;
import types.C0363c;
import types.C0364d;

/* renamed from: i.b */
/* loaded from: classes.dex */
public class C0217b {

    /* renamed from: a */
    public long f1190a;

    /* renamed from: b */
    public long f1191b;

    /* renamed from: c */
    public float[] f1192c;

    /* renamed from: d */
    public float[] f1193d;

    /* renamed from: e */
    public int[] f1194e;

    /* renamed from: f */
    public short[] f1195f;

    /* renamed from: g */
    public float f1196g;

    /* renamed from: h */
    public float f1197h;

    /* renamed from: i */
    public int[] f1198i;

    /* renamed from: j */
    public int[] f1199j;

    /* renamed from: k */
    public int f1200k;

    /* renamed from: l */
    public int f1201l;

    /* renamed from: m */
    public int f1202m;

    /* renamed from: n */
    public C0363c f1203n = new C0363c();

    /* renamed from: o */
    public C0362b f1204o = new C0362b();

    /* renamed from: p */
    public float[] f1205p = null;

    /* renamed from: q */
    public float[] f1206q = null;

    /* renamed from: a */
    public int m929a() {
        if (this.f1194e == null) {
            return 0;
        }
        return this.f1194e[this.f1194e.length - 1] - this.f1194e[0];
    }

    /* renamed from: b */
    public float m930b() {
        int length = this.f1192c.length;
        if (length != 0) {
            return m929a() / length;
        }
        return 0.0f;
    }

    /* renamed from: c */
    public void m931c() {
        int length = this.f1192c.length;
        if ((this.f1198i == null || this.f1199j == null || this.f1198i.length != length) && length != 0) {
            this.f1203n.m1182a();
            this.f1204o.m1180a();
            this.f1196g = this.f1192c[0];
            this.f1197h = this.f1193d[0];
            C0364d c0364d = new C0364d(this.f1196g, this.f1197h);
            this.f1198i = new int[length];
            this.f1199j = new int[length];
            short s = 0;
            int s2 = 99999;
            int i2 = 0;
            for (int i3 = 0; i3 < length; i3++) {
                this.f1198i[i3] = (int) (c0364d.m1192a(this.f1193d[i3]) * 1000.0f);
                this.f1199j[i3] = (int) (c0364d.m1198b(this.f1192c[i3]) * 1000.0f);
                this.f1203n.m1183a(this.f1198i[i3], this.f1199j[i3]);
                this.f1204o.m1181a(this.f1192c[i3], this.f1193d[i3]);
                if (this.f1195f != null) {
                    short s3 = this.f1195f[i3];
                    if (s3 > s) {
                        s = s3;
                    }
                    if (s3 < s2) {
                        s2 = s3;
                    }
                    i2 += s3;
                }
            }
            if (s != 0) {
                this.f1200k = s;
                this.f1201l = s2;
                this.f1202m = i2 / length;
            }
        }
    }
}
