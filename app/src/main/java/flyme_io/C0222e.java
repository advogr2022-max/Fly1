package flyme_io;

import com.xcglobe.xclog.C0101l;
import java.util.ArrayList;
import types.C0367g;
import types.GpsVal;

/* renamed from: i.e */
/* loaded from: classes.dex */
public class C0222e {

    /* renamed from: a */
    public C0220c f1244a = null;

    /* renamed from: i.e$a */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a */
        public float[] f1245a;

        /* renamed from: b */
        public float[] f1246b;

        /* renamed from: c */
        public short[] f1247c;

        /* renamed from: d */
        public long[] f1248d;

        /* renamed from: e */
        public int f1249e;

        /* renamed from: f */
        public int f1250f;

        /* renamed from: g */
        public int f1251g;

        public a() {
        }
    }

    /* renamed from: a */
    public C0217b m966a(String str) {
        int i2;
        this.f1244a = new C0220c(C0101l.m558c() + "/" + str);
        C0217b c0217b = new C0217b();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        ArrayList arrayList4 = new ArrayList();
        boolean z = true;
        while (true) {
            if (!this.f1244a.m949b()) {
                break;
            }
            if (z) {
                c0217b.f1196g = this.f1244a.f1218h;
                c0217b.f1197h = this.f1244a.f1219i;
                c0217b.f1190a = this.f1244a.f1216f;
                z = false;
            }
            arrayList.add(Integer.valueOf(((int) (this.f1244a.f1216f - c0217b.f1190a)) / 1000));
            arrayList2.add(Float.valueOf(this.f1244a.f1218h));
            arrayList3.add(Float.valueOf(this.f1244a.f1219i));
            arrayList4.add(Short.valueOf(this.f1244a.f1220j));
        }
        int size = arrayList2.size();
        c0217b.f1194e = new int[size];
        c0217b.f1195f = new short[size];
        c0217b.f1192c = new float[size];
        c0217b.f1193d = new float[size];
        for (i2 = 0; i2 < size; i2++) {
            c0217b.f1194e[i2] = ((Integer) arrayList.get(i2)).intValue();
            c0217b.f1192c[i2] = ((Float) arrayList2.get(i2)).floatValue();
            c0217b.f1193d[i2] = ((Float) arrayList3.get(i2)).floatValue();
            c0217b.f1195f[i2] = ((Short) arrayList4.get(i2)).shortValue();
        }
        c0217b.m931c();
        return c0217b;
    }

    /* renamed from: a */
    public a m967a(ArrayList<GpsVal> arrayList, boolean z) {
        a aVar = new a();
        int size = arrayList.size();
        aVar.f1245a = new float[size];
        aVar.f1246b = new float[size];
        if (!z) {
            aVar.f1247c = new short[size];
            aVar.f1248d = new long[size];
        }
        short s = size > 0 ? arrayList.get(0).f1974c : (short) 0;
        aVar.f1251g = s;
        aVar.f1249e = s;
        aVar.f1250f = s;
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            GpsVal gpsVal = arrayList.get(i3);
            aVar.f1245a[i3] = gpsVal.f1972a;
            aVar.f1246b[i3] = gpsVal.f1973b;
            if (!z) {
                aVar.f1247c[i3] = gpsVal.f1974c;
                aVar.f1248d[i3] = gpsVal.f1975d;
            }
            if (gpsVal.f1974c > aVar.f1249e) {
                aVar.f1249e = gpsVal.f1974c;
            } else if (gpsVal.f1974c < aVar.f1250f) {
                aVar.f1250f = gpsVal.f1974c;
            }
            i2 += gpsVal.f1974c;
        }
        if (size > 0) {
            aVar.f1251g = i2 / size;
        }
        return aVar;
    }

    /* renamed from: b */
    public C0217b m968b(ArrayList<GpsVal> arrayList, boolean z) {
        C0217b c0217b = new C0217b();
        int size = arrayList.size();
        c0217b.f1192c = new float[size];
        c0217b.f1193d = new float[size];
        if (!z) {
            c0217b.f1195f = new short[size];
            c0217b.f1194e = new int[size];
        }
        if (size > 0) {
            c0217b.f1190a = arrayList.get(0).f1975d;
        }
        C0367g c0367g = new C0367g();
        for (int i2 = 0; i2 < size; i2++) {
            GpsVal gpsVal = arrayList.get(i2);
            c0367g.m1225a(gpsVal);
            c0217b.f1192c[i2] = gpsVal.f1972a;
            c0217b.f1193d[i2] = gpsVal.f1973b;
            int i3 = ((int) (gpsVal.f1975d - c0217b.f1190a)) / 1000;
            if (i2 == 0) {
                c0217b.f1196g = gpsVal.f1972a;
                c0217b.f1197h = gpsVal.f1973b;
            }
            if (!z) {
                c0217b.f1195f[i2] = gpsVal.f1974c;
                c0217b.f1194e[i2] = i3;
            }
        }
        return c0217b;
    }
}
