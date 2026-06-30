package flyme_io;

import java.util.ArrayList;

/* renamed from: i.f */
/* loaded from: classes.dex */
public class C0223f {

    /* renamed from: a */
    public static float f1253a = 6371.0f;

    /* renamed from: a */
    public static C0217b m969a(String str, C0213a c0213a) {
        return m970a(str, c0213a, false);
    }

    /* renamed from: a */
    private static C0217b m970a(String str, C0213a c0213a, boolean z) {
        C0220c c0220c = z ? new C0220c(str) : new C0220c(str, 0L, null, c0213a);
        C0217b c0217b = new C0217b();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        boolean z2 = true;
        int i2 = 0;
        while (c0220c.m949b()) {
            if (z2) {
                c0217b.f1196g = c0220c.f1218h;
                c0217b.f1197h = c0220c.f1219i;
                c0217b.f1190a = c0220c.f1216f;
                c0217b.f1191b = c0220c.f1211a;
                z2 = false;
            }
            int i3 = ((int) (c0220c.f1216f - c0217b.f1190a)) / 1000;
            if (i3 != i2 || arrayList.size() <= 0) {
                arrayList.add(Integer.valueOf(i3));
                arrayList2.add(Float.valueOf(c0220c.f1218h));
                arrayList3.add(Float.valueOf(c0220c.f1219i));
                arrayList4.add(Short.valueOf(c0220c.f1220j));
            } else {
                int size = arrayList.size() - 1;
                arrayList2.set(size, Float.valueOf(c0220c.f1218h));
                arrayList3.set(size, Float.valueOf(c0220c.f1219i));
                arrayList4.set(size, Short.valueOf(c0220c.f1220j));
            }
            i2 = i3;
        }
        c0220c.m947a();
        int size2 = arrayList2.size();
        c0217b.f1194e = new int[size2];
        c0217b.f1195f = new short[size2];
        c0217b.f1192c = new float[size2];
        c0217b.f1193d = new float[size2];
        for (int i4 = 0; i4 < size2; i4++) {
            c0217b.f1194e[i4] = ((Integer) arrayList.get(i4)).intValue();
            c0217b.f1192c[i4] = ((Float) arrayList2.get(i4)).floatValue();
            c0217b.f1193d[i4] = ((Float) arrayList3.get(i4)).floatValue();
            c0217b.f1195f[i4] = ((Short) arrayList4.get(i4)).shortValue();
        }
        return c0217b;
    }
}
