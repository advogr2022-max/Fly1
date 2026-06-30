package flyme_fileutil;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import types.C0367g;
import types.C0375o;

/* renamed from: a.a */
/* loaded from: classes.dex */
public class C0000a {

    /* renamed from: a */
    private ArrayList<C0001b> f0a = new ArrayList<>();

    /* renamed from: b */
    private String f1b;

    public C0000a(String str) {
        this.f1b = null;
        this.f1b = str;
    }

    /* renamed from: a */
    private void m0a() {
        for (int i2 = 0; i2 < this.f0a.size(); i2++) {
            m1a(this.f0a.get(i2));
        }
        Collections.sort(this.f0a, new Comparator<C0001b>() { // from class: a.a.1
            @Override // java.util.Comparator
            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public int compare(C0001b c0001b, C0001b c0001b2) {
                if (c0001b.f14k > c0001b2.f14k) {
                    return -1;
                }
                if (c0001b.f14k < c0001b2.f14k) {
                    return 1;
                }
                return Float.compare(c0001b2.f9f.m1237f() * c0001b2.f9f.m1238g(), c0001b.f9f.m1237f() * c0001b.f9f.m1238g());
            }
        });
    }

    /* renamed from: a */
    private void m1a(C0001b c0001b) {
        int i2 = c0001b.f7d;
        if (!c0001b.f13j) {
            i2 += 100000;
        }
        c0001b.f14k = i2;
    }

    /* renamed from: b */
    private void m2b() {
        new File(new File(this.f1b).getParent()).mkdirs();
        m0a();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(this.f1b));
            for (int i2 = 0; i2 < this.f0a.size(); i2++) {
                C0001b c0001b = this.f0a.get(i2);
                fileOutputStream.write(("#" + c0001b.f4a + "|" + c0001b.f12i + "\n").getBytes());
                StringBuilder sb = new StringBuilder();
                sb.append(c0001b.f10g);
                sb.append(" ");
                sb.append(c0001b.f13j ? "1 " : "0 ");
                sb.append(c0001b.f7d);
                sb.append(" * ");
                sb.append(c0001b.f8e ? "G " : "S ");
                sb.append(c0001b.f11h != null ? c0001b.f11h : "XX");
                sb.append(" ");
                sb.append(c0001b.f15l);
                sb.append(" ");
                sb.append(c0001b.f16m);
                sb.append(" ");
                sb.append(c0001b.f17n ? "1" : "0");
                sb.append(" ");
                sb.append(c0001b.f14k);
                sb.append(" ");
                sb.append(c0001b.f18o.replace(' ', '-'));
                sb.append("\n");
                fileOutputStream.write(sb.toString().getBytes());
                StringBuilder sb2 = new StringBuilder();
                for (int i3 = 0; i3 < c0001b.f5b.length; i3++) {
                    if (i3 > 0) {
                        sb2.append(" ");
                    }
                    sb2.append(c0001b.f5b[i3]);
                    sb2.append(" ");
                    sb2.append(c0001b.f6c[i3]);
                }
                sb2.append("\n");
                fileOutputStream.write(sb2.toString().getBytes());
            }
            fileOutputStream.close();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m3a(ArrayList<String> arrayList, String str) {
        ArrayList<C0001b> arrayList2;
        ArrayList arrayList3 = new ArrayList();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            try {
                arrayList2 = new C0002c().m10a(arrayList.get(i2));
            } catch (Exception unused) {
                arrayList2 = null;
            }
            if (arrayList2 != null) {
                arrayList3.addAll(arrayList2);
            }
        }
        int m1268a = C0375o.m1268a();
        int i3 = 0;
        while (i3 < m1268a) {
            i3++;
            C0367g m1274b = C0375o.m1274b(i3);
            this.f0a.clear();
            for (int i4 = 0; i4 < arrayList3.size(); i4++) {
                C0001b c0001b = (C0001b) arrayList3.get(i4);
                if (c0001b.f9f.m1234c(m1274b)) {
                    this.f0a.add(c0001b);
                }
            }
            this.f1b = str + i3 + ".air";
            m2b();
        }
    }
}
