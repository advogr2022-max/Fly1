package vmaps.core;

import java.util.ArrayList;
import vmaps.C0381c;

/* renamed from: vmaps.core.f */
/* loaded from: classes.dex */
public class C0387f {

    /* renamed from: a */
    public int f2197a;

    /* renamed from: b */
    private int[] f2198b;

    /* renamed from: c */
    private int f2199c = 5000;

    public C0387f(int i2) {
        m1393b(i2);
    }

    /* renamed from: a */
    private static int m1392a(int i2, int i3, int i4) {
        return ((i2 & 255) << 16) | ((i3 & 255) << 8) | (i4 & 255) | (-16777216);
    }

    /* renamed from: b */
    private void m1393b(int i2) {
        this.f2197a = i2;
        ArrayList<Integer> arrayList = new C0381c().m1321a(i2).f2111a;
        this.f2198b = new int[(arrayList.size() / 3) + 1];
        int i3 = 0;
        for (int i4 = 0; i4 < arrayList.size(); i4 += 3) {
            this.f2198b[i3] = m1392a(arrayList.get(i4).intValue(), arrayList.get(i4 + 1).intValue(), arrayList.get(i4 + 2).intValue());
            i3++;
        }
        this.f2198b[i3] = m1392a(0, 0, 255);
    }

    /* renamed from: a */
    public int m1394a() {
        return this.f2198b[this.f2198b.length - 1];
    }

    /* renamed from: a */
    public int m1395a(int i2) {
        if (i2 < 0) {
            return this.f2198b[this.f2198b.length - 1];
        }
        if (i2 >= this.f2199c) {
            i2 = this.f2199c - 1;
        }
        return this.f2198b[(i2 * this.f2198b.length) / this.f2199c];
    }
}
