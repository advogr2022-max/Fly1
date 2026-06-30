package vmaps.core;

import android.os.Handler;
import display.vmap.ViewVmp;
import java.util.ArrayList;
import java.util.Iterator;
import types.C0363c;
import types.C0364d;
import types.C0367g;

/* loaded from: classes.dex */
public class VmpWorld {
    // private static int r5 = 0;

    /* renamed from: p */
    private static final Handler f2112p = new Handler();

    /* renamed from: C */
    private byte f2115C;

    /* renamed from: d */
    AbstractC0386e f2121d;

    /* renamed from: e */
    public C0364d f2122e;

    /* renamed from: f */
    public float f2123f;

    /* renamed from: g */
    public float f2124g;

    /* renamed from: h */
    public float f2125h;

    /* renamed from: i */
    public float f2126i;

    /* renamed from: j */
    public int f2127j;

    /* renamed from: k */
    public int f2128k;

    /* renamed from: q */
    private boolean f2133q;

    /* renamed from: r */
    private float f2134r;

    /* renamed from: s */
    private float f2135s;

    /* renamed from: t */
    private float f2136t;

    /* renamed from: u */
    private float f2137u;

    /* renamed from: v */
    private int f2138v;

    /* renamed from: w */
    private int f2139w;

    /* renamed from: x */
    private int f2140x;

    /* renamed from: y */
    private int f2141y;

    /* renamed from: a */
    public float f2118a = 1.3f;

    /* renamed from: b */
    float f2119b = 2.0f;

    /* renamed from: c */
    public float f2120c = 3.0f;

    /* renamed from: z */
    private float f2142z = 10.0f;

    /* renamed from: l */
    public C0367g f2129l = new C0367g();

    /* renamed from: m */
    public C0363c f2130m = new C0363c();

    /* renamed from: n */
    public C0363c f2131n = new C0363c();

    /* renamed from: A */
    private float f2113A = 0.0f;

    /* renamed from: o */
    ArrayList<InterfaceC0388g> f2132o = new ArrayList<>();

    /* renamed from: B */
    private boolean f2114B = false;

    /* renamed from: D */
    private long f2116D = 0;

    /* renamed from: E */
    private boolean f2117E = false;

    public VmpWorld(boolean z) {
        this.f2133q = false;
        this.f2115C = (byte) 0;
        this.f2133q = z;
        this.f2115C = (byte) 0;
    }

    /* renamed from: a */
    private void m1323a(float f2, C0367g c0367g) {
        float f3 = (-f2) / 2.0f;
        c0367g.f2012a = this.f2122e.m1200c(f3);
        c0367g.f2014c = this.f2122e.m1201d(f3);
        float f4 = f2 / 2.0f;
        c0367g.f2013b = this.f2122e.m1200c(f4);
        c0367g.f2015d = this.f2122e.m1201d(f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m1324a(int i2, final C0367g c0367g) {
        this.f2115C = (byte) (this.f2115C + 1);
        f2112p.removeCallbacksAndMessages(null);
        this.f2114B = false;
        this.f2117E = false;
        new Thread(new Runnable() { // from class: vmaps.core.-$$Lambda$VmpWorld$TOyqxK26eFLduRlZfy-PQLzc7tw
            @Override // java.lang.Runnable
            public final void run() {
                VmpWorld.this.m1326b(i2, c0367g);
            }
        }).start();
    }

    /* renamed from: b */
    private void m1325b(float f2) {
        m1323a(f2, this.f2129l);
        this.f2136t = this.f2129l.m1237f() / 2.0f;
        this.f2137u = this.f2129l.m1238g() / 2.0f;
        this.f2134r = this.f2125h / this.f2129l.m1238g();
        this.f2135s = this.f2126i / this.f2129l.m1237f();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m1326b(int i2, C0367g c0367g) {
        int i3 = 0;
        while (true) {
            if (i3 <= 2) {
                final AbstractC0386e mo1381a = this.f2121d.mo1381a();
                int m1396a = C0389h.m1396a(mo1381a, i2, c0367g, (int) this.f2142z, i3);
                if (m1396a != -1) {
                    f2112p.post(new Runnable() { // from class: vmaps.core.-$$Lambda$VmpWorld$Gas6_6kji9g6vZtOr65EqSAAeig
                        @Override // java.lang.Runnable
                        public final void run() {
                            VmpWorld.this.m1327b(mo1381a);
                        }
                    });
                }
                if (m1396a == 1) {
                    break;
                }
                if (this.f2114B) {
                    f2112p.postDelayed(new Runnable() { // from class: vmaps.core.-$$Lambda$VmpWorld$fuByZBVTWCgIRjnRntFMr7tdXtA
                        @Override // java.lang.Runnable
                        public final void run() {
                            VmpWorld.this.m1331j();
                        }
                    }, 100L);
                    this.f2117E = true;
                    break;
                }
                i3++;
            } else {
                break;
            }
        }
        this.f2115C = (byte) (this.f2115C - 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public void m1333l() {
        if (this.f2133q) {
            if (ViewVmp.isThermailing() && ViewVmp.isRotating()) {
                return;
            }
            float f2 = (this.f2142z > this.f2119b ? this.f2142z : this.f2119b) * (this.f2125h / this.f2123f) * this.f2118a;
            final C0367g c0367g = new C0367g();
            m1323a(f2, c0367g);
            int i2 = (int) ((this.f2123f + this.f2124g) / 2.0f);
            if (this.f2140x != 0 || this.f2141y != 0) {
                i2 = (int) Math.max(this.f2123f, this.f2124g);
            }
            if (this.f2117E || !this.f2121d.m1390c(i2, i2, c0367g)) {
                if (this.f2115C > 0) {
                    f2112p.removeCallbacksAndMessages(null);
                    this.f2114B = true;
                    f2112p.postDelayed(new Runnable() { // from class: vmaps.core.-$$Lambda$VmpWorld$mwDqz2CqTieHQjYhf5C1-pXzJS4
                        @Override // java.lang.Runnable
                        public final void run() {
                            VmpWorld.this.m1333l();
                        }
                    }, 300L);
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - this.f2116D >= 100) {
                    this.f2116D = currentTimeMillis;
                    final int finalI2 = i2;
                    f2112p.postDelayed(new Runnable() {
                        @Override // java.lang.Runnable
                        public final void run() {
                            VmpWorld.this.m1324a(finalI2, c0367g);
                        }
                    }, 200L);
                } else {
                    f2112p.removeCallbacksAndMessages(null);
                    this.f2114B = true;
                    f2112p.postDelayed(new Runnable() { // from class: vmaps.core.-$$Lambda$VmpWorld$zaaQqw4YATPn4ILfrL6s770YSqo
                        @Override // java.lang.Runnable
                        public final void run() {
                            VmpWorld.this.m1332k();
                        }
                    }, 100L);
                }
            }
        }
    }

    /* renamed from: h */
    private void m1329h() {
        if (this.f2121d == null || this.f2121d.f2194l == null || !this.f2133q) {
            return;
        }
        float f2 = this.f2129l.f2014c - this.f2121d.f2194l.f2014c;
        float f3 = -(this.f2129l.f2013b - this.f2121d.f2194l.f2013b);
        float f4 = f2 * this.f2121d.f2195m;
        float f5 = f3 * this.f2121d.f2196n;
        this.f2130m.f1992a = (int) f4;
        this.f2130m.f1993b = (int) f5;
        this.f2130m.f1994c = (int) (f4 + (this.f2137u * 2.0f * this.f2121d.f2195m));
        this.f2130m.f1995d = (int) (f5 + (this.f2136t * 2.0f * this.f2121d.f2196n));
        this.f2131n.f1992a = -this.f2138v;
        this.f2131n.f1993b = -this.f2139w;
        this.f2131n.f1994c = (-this.f2138v) + ((int) this.f2125h);
        this.f2131n.f1995d = (-this.f2139w) + ((int) this.f2126i);
        boolean z = this.f2130m.f1992a < 0 || this.f2130m.f1993b < 0 || this.f2130m.f1994c > this.f2121d.f2192j || this.f2130m.f1995d > this.f2121d.f2193k;
        float m1185b = this.f2125h / (this.f2130m.m1185b() / this.f2131n.m1185b());
        float m1187c = this.f2126i / (this.f2130m.m1187c() / this.f2131n.m1187c());
        float m1185b2 = this.f2131n.m1185b() * (this.f2130m.f1992a / this.f2130m.m1185b());
        float m1187c2 = this.f2131n.m1187c() * (this.f2130m.f1993b / this.f2130m.m1187c());
        // this.f2131n.f1992a = (int) (r5.f1992a - m1185b2);
        // this.f2131n.f1993b = (int) (r5.f1993b - m1187c2);
        this.f2131n.f1994c = (int) (this.f2131n.f1992a + m1185b);
        this.f2131n.f1995d = (int) (this.f2131n.f1993b + m1187c);
        this.f2130m.f1992a = 0;
        this.f2130m.f1993b = 0;
        this.f2130m.f1994c = (int) this.f2125h;
        this.f2130m.f1995d = (int) this.f2126i;
        this.f2131n.m1186b(this.f2140x, this.f2141y);
        if (z) {
            m1333l();
        }
    }

    /* renamed from: i */
    private void m1330i() {
        if (this.f2125h < 1.0f) {
            return;
        }
        this.f2113A = this.f2131n.m1185b() / this.f2125h;
        float m1187c = this.f2131n.m1187c() / this.f2126i;
        if (m1187c > this.f2113A) {
            this.f2113A = m1187c;
        }
        if (this.f2113A <= this.f2120c || this.f2142z <= this.f2119b) {
            return;
        }
        m1333l();
    }

    /* renamed from: a */
    public void m1334a(float f2) {
        this.f2142z = f2;
        m1325b(f2 * (this.f2125h / this.f2123f));
        m1329h();
        m1330i();
        Iterator<InterfaceC0388g> it = this.f2132o.iterator();
        while (it.hasNext()) {
            it.next().onZoom();
        }
    }

    /* renamed from: a */
    public void m1335a(float f2, float f3) {
        this.f2122e.m1194a(f2, f3);
        this.f2129l.f2012a = f2 - this.f2136t;
        this.f2129l.f2013b = f2 + this.f2136t;
        this.f2129l.f2014c = f3 - this.f2137u;
        this.f2129l.f2015d = f3 + this.f2137u;
        m1329h();
    }

    /* renamed from: a */
    public void m1336a(float f2, float f3, float f4) {
        this.f2142z = f4;
        float f5 = (this.f2125h / this.f2123f) * f4;
        this.f2122e = new C0364d(f2, f3);
        m1325b(f5);
        m1335a(f2, f3);
        m1334a(f4);
        m1333l();
    }

    /* renamed from: a */
    public void m1337a(float f2, float f3, float[] fArr) {
        fArr[0] = f2 / this.f2134r;
        fArr[1] = f3 / this.f2135s;
    }

    /* renamed from: a */
    public void m1338a(float f2, float f3, int[] iArr) {
        float f4 = f3 - this.f2129l.f2014c;
        float f5 = f2 - this.f2129l.f2012a;
        iArr[0] = (int) (((f4 * this.f2134r) - this.f2138v) + this.f2140x);
        iArr[1] = (int) (((this.f2126i - (f5 * this.f2135s)) - this.f2139w) + this.f2141y);
    }

    /* renamed from: a */
    public void m1339a(int i2, int i3, AbstractC0386e abstractC0386e, int i4, int i5) {
        float f2 = i2;
        this.f2123f = f2;
        float f3 = i3;
        this.f2124g = f3;
        if (this.f2121d == null) {
            this.f2121d = abstractC0386e;
        }
        int i6 = i3 / 2;
        float abs = Math.abs(i5) + i6;
        int i7 = i2 / 2;
        float f4 = i7;
        float sqrt = (float) Math.sqrt((abs * abs) + (f4 * f4));
        float abs2 = i7 + Math.abs(i4);
        float f5 = i6;
        float max = Math.max((float) Math.sqrt((abs2 * abs2) + (f5 * f5)), sqrt) * 2.0f;
        this.f2125h = max;
        this.f2126i = max;
        this.f2138v = Math.round((max - f2) / 2.0f);
        this.f2139w = Math.round((max - f3) / 2.0f);
        this.f2140x = i4;
        this.f2141y = i5;
        this.f2127j = this.f2138v + this.f2140x;
        this.f2128k = this.f2139w + this.f2141y;
    }

    /* renamed from: a */
    public void m1340a(C0367g c0367g, float f2) {
        this.f2122e.m1194a(c0367g.f2012a, c0367g.f2014c);
        float m1199b = this.f2122e.m1199b(c0367g.f2012a, c0367g.f2015d) * f2;
        float m1199b2 = this.f2122e.m1199b(c0367g.f2013b, c0367g.f2014c) * f2;
        m1336a(c0367g.m1235d(), c0367g.m1236e(), m1199b);
        float f3 = (this.f2124g / this.f2123f) * m1199b;
        if (f3 < m1199b2) {
            m1334a(m1199b * (m1199b2 / f3));
        }
    }

    /* renamed from: a */
    public void m1341a(VmpWorld vmpWorld) {
        this.f2123f = vmpWorld.f2123f;
        this.f2124g = vmpWorld.f2124g;
        this.f2121d = null;
        this.f2125h = vmpWorld.f2125h;
        this.f2126i = vmpWorld.f2126i;
        this.f2138v = vmpWorld.f2138v;
        this.f2139w = vmpWorld.f2139w;
        this.f2140x = vmpWorld.f2140x;
        this.f2141y = vmpWorld.f2141y;
        this.f2127j = vmpWorld.f2127j;
        this.f2128k = vmpWorld.f2128k;
        m1336a(vmpWorld.f2122e.f1998b, vmpWorld.f2122e.f1999c, vmpWorld.m1352c());
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public void m1327b(AbstractC0386e abstractC0386e) {
        this.f2121d.m1383a(abstractC0386e);
        abstractC0386e.mo1388b();
        m1329h();
        m1330i();
        Iterator<InterfaceC0388g> it = this.f2132o.iterator();
        while (it.hasNext()) {
            it.next().onMapUpdate();
        }
    }

    /* renamed from: a */
    public void m1343a(InterfaceC0388g interfaceC0388g) {
        this.f2132o.add(interfaceC0388g);
    }

    /* renamed from: a */
    public void m1344a(float[] fArr) {
        for (int i2 = 0; i2 < fArr.length; i2 += 2) {
            float f2 = fArr[i2] - this.f2129l.f2012a;
            int i3 = i2 + 1;
            fArr[i2] = (((fArr[i3] - this.f2129l.f2014c) * this.f2134r) - this.f2138v) + this.f2140x;
            fArr[i3] = ((this.f2126i - (f2 * this.f2135s)) - this.f2139w) + this.f2141y;
        }
    }

    /* renamed from: a */
    public void m1345a(int[] iArr) {
        float f2 = this.f2122e.f1999c - this.f2129l.f2014c;
        float f3 = this.f2122e.f1998b - this.f2129l.f2012a;
        iArr[0] = (int) (((f2 * this.f2134r) - this.f2138v) + this.f2140x);
        iArr[1] = (int) (((this.f2126i - (f3 * this.f2135s)) - this.f2139w) + this.f2141y);
    }

    /* renamed from: a */
    public boolean m1346a() {
        return this.f2115C > 0;
    }

    /* renamed from: b */
    public AbstractC0386e m1347b() {
        return this.f2121d;
    }

    /* renamed from: b */
    public void m1348b(float f2, float f3, float[] fArr) {
        float f4 = f3 - this.f2129l.f2014c;
        float f5 = f2 - this.f2129l.f2012a;
        fArr[0] = ((f4 * this.f2134r) - this.f2138v) + this.f2140x;
        fArr[1] = ((this.f2126i - (f5 * this.f2135s)) - this.f2139w) + this.f2141y;
    }

    /* renamed from: b */
    public void m1349b(InterfaceC0388g interfaceC0388g) {
        int indexOf = this.f2132o.indexOf(interfaceC0388g);
        if (indexOf != -1) {
            this.f2132o.remove(indexOf);
        }
    }

    /* renamed from: b */
    public void m1350b(float[] fArr) {
        float f2 = fArr[1] - this.f2129l.f2014c;
        float f3 = fArr[0] - this.f2129l.f2012a;
        fArr[0] = ((f2 * this.f2134r) - this.f2138v) + this.f2140x;
        fArr[1] = ((this.f2126i - (f3 * this.f2135s)) - this.f2139w) + this.f2141y;
    }

    /* renamed from: b */
    public void m1351b(int[] iArr) {
        int i2 = (int) this.f2123f;
        int i3 = (int) this.f2124g;
        int m1355e = (i2 / 2) + m1355e();
        int m1356f = (i3 - (i3 / 2)) + m1356f();
        iArr[0] = m1355e;
        iArr[1] = m1356f;
    }

    /* renamed from: c */
    public float m1352c() {
        return this.f2142z;
    }

    /* renamed from: c */
    public boolean m1353c(float[] fArr) {
        float f2 = fArr[0];
        float f3 = fArr[1];
        return f2 >= 0.0f && f2 <= this.f2123f && f3 >= 0.0f && f3 <= this.f2124g;
    }

    /* renamed from: d */
    public float m1354d() {
        return (this.f2134r + this.f2135s) / 2.0f;
    }

    /* renamed from: e */
    public int m1355e() {
        return this.f2140x;
    }

    /* renamed from: f */
    public int m1356f() {
        return this.f2141y;
    }

    void m1331j() {}
    void m1332k() {}
}
