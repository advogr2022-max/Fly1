package vmaps.core;

import types.C0363c;
import types.C0367g;

/* renamed from: vmaps.core.e */
/* loaded from: classes.dex */
public abstract class AbstractC0386e {

    /* renamed from: j */
    public int f2192j;

    /* renamed from: k */
    public int f2193k;

    /* renamed from: l */
    protected C0367g f2194l;

    /* renamed from: m */
    public float f2195m;

    /* renamed from: n */
    public float f2196n;

    /* renamed from: a */
    public abstract AbstractC0386e mo1381a();

    /* renamed from: a */
    public abstract void mo1382a(int i2, int i3, C0367g c0367g);

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m1383a(AbstractC0386e abstractC0386e) {
        mo1382a(abstractC0386e.f2192j, abstractC0386e.f2193k, abstractC0386e.f2194l);
        C0363c c0363c = new C0363c();
        c0363c.m1183a(0, 0);
        c0363c.m1183a(abstractC0386e.f2192j, abstractC0386e.f2193k);
        mo1384a(abstractC0386e, c0363c);
    }

    /* renamed from: a */
    public abstract void mo1384a(AbstractC0386e abstractC0386e, C0363c c0363c);

    /* renamed from: a */
    public abstract void mo1385a(int[] iArr);

    /* renamed from: a */
    public abstract void mo1386a(int[] iArr, int i2, int i3);

    /* renamed from: a */
    public abstract void mo1387a(int[] iArr, int[] iArr2, int i2, int i3, int i4);

    /* renamed from: b */
    public abstract void mo1388b();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: b */
    public void m1389b(int i2, int i3, C0367g c0367g) {
        this.f2192j = i2;
        this.f2193k = i3;
        this.f2194l = new C0367g();
        if (c0367g != null) {
            this.f2194l.m1229b(c0367g);
            this.f2195m = i2 / c0367g.m1238g();
            this.f2196n = i3 / c0367g.m1237f();
        }
    }

    /* renamed from: c */
    public boolean m1390c(int i2, int i3, C0367g c0367g) {
        if (Math.abs(i2 - this.f2192j) < 10 && Math.abs(i3 - this.f2193k) < 10) {
            float f2 = 10000;
            if (((int) (this.f2194l.f2012a * f2)) == ((int) (c0367g.f2012a * f2)) && ((int) (this.f2194l.f2014c * f2)) == ((int) (c0367g.f2014c * f2)) && ((int) (this.f2194l.f2013b * f2)) == ((int) (c0367g.f2013b * f2)) && ((int) (this.f2194l.f2015d * f2)) == ((int) (c0367g.f2015d * f2))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: c */
    public abstract int[] mo1391c();
}
