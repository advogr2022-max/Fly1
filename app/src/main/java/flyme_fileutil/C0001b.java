package flyme_fileutil;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import flyme_io.C0220c;
import types.C0367g;

/* renamed from: a.b */
/* loaded from: classes.dex */
public class C0001b {
    private static int rN = 0;
    private static Throwable e;

    /* renamed from: p */
    private static boolean f3p = false;

    /* renamed from: b */
    public int[] f5b;

    /* renamed from: c */
    public int[] f6c;

    /* renamed from: d */
    public int f7d;

    /* renamed from: e */
    public boolean f8e;

    /* renamed from: i */
    public int f12i;

    /* renamed from: k */
    public int f14k;

    /* renamed from: l */
    public int f15l;

    /* renamed from: m */
    public int f16m;

    /* renamed from: a */
    public String f4a = null;

    /* renamed from: f */
    public C0367g f9f = new C0367g();

    /* renamed from: g */
    public char f10g = 0;

    /* renamed from: h */
    public String f11h = null;

    /* renamed from: j */
    public boolean f13j = false;

    /* renamed from: n */
    public boolean f17n = false;

    /* renamed from: o */
    public String f18o = null;

    /* JADX WARN: Removed duplicated region for block: B:62:0x0199 A[Catch: IOException -> 0x01d2, FileNotFoundException -> 0x01d4, LOOP:2: B:60:0x0193->B:62:0x0199, LOOP_END, TryCatch #5 {FileNotFoundException -> 0x01d4, IOException -> 0x01d2, blocks: (B:9:0x0022, B:10:0x0027, B:12:0x002d, B:15:0x0036, B:17:0x003f, B:18:0x005d, B:21:0x0068, B:23:0x0070, B:24:0x0079, B:26:0x0085, B:29:0x00b1, B:31:0x00b7, B:32:0x00bb, B:34:0x00bf, B:36:0x00fc, B:37:0x0102, B:39:0x010a, B:40:0x0113, B:43:0x0128, B:50:0x0152, B:53:0x015b, B:55:0x0168, B:59:0x018a, B:60:0x0193, B:62:0x0199, B:64:0x01bc, B:65:0x0178, B:81:0x0075, B:85:0x004a), top: B:8:0x0022 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ArrayList<C0001b> m5a(String str, C0367g c0367g, HashSet<Integer> hashSet) {
        BufferedReader bufferedReader;
        int hashCode;
        int i2;
        String str2 = str;
        ArrayList<C0001b> arrayList = new ArrayList<>();
        if (!new File(str2).isFile()) {
            return arrayList;
        }
        try {
            bufferedReader = new BufferedReader(new FileReader(str2));
            try {
                ArrayList arrayList2 = new ArrayList();
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    if (readLine.startsWith("#")) {
                        int indexOf = readLine.indexOf(124);
                        int i3 = -1;
                        if (indexOf != -1) {
                            hashCode = C0220c.m944a(readLine, indexOf + 1, readLine.length());
                        } else {
                            hashCode = (str2 + readLine).hashCode();
                        }
                        if (!hashSet.contains(Integer.valueOf(hashCode))) {
                            C0001b c0001b = new C0001b();
                            c0001b.f4a = indexOf != -1 ? readLine.substring(1, indexOf) : readLine.substring(1);
                            c0001b.f12i = hashCode;
                            String readLine2 = bufferedReader.readLine();
                            if (readLine2 == null) {
                                break;
                            }
                            String[] split = readLine2.split(" ");
                            c0001b.f10g = split[0].charAt(0);
                            c0001b.f7d = C0220c.m944a(split[2], 0, split[2].length());
                            c0001b.f8e = split[4].charAt(0) == 'G';
                            if (split.length > 5) {
                                c0001b.f11h = split[5];
                            }
                            if (split.length > 6) {
                                c0001b.f15l = C0220c.m944a(split[6], 0, split[6].length());
                                c0001b.f16m = C0220c.m944a(split[7], 0, split[7].length());
                                c0001b.f17n = "1".equals(split[8]);
                                c0001b.f14k = C0220c.m944a(split[9], 0, split[9].length());
                                if (!f3p) {
                                    c0001b.f18o = split[10];
                                }
                            }
                            String readLine3 = bufferedReader.readLine();
                            if (readLine3 == null) {
                                break;
                            }
                            int length = readLine3.length();
                            arrayList2.clear();
                            int i4 = 0;
                            int i5 = 0;
                            while (true) {
                                int indexOf2 = readLine3.indexOf(32, i4);
                                int m944a = C0220c.m944a(readLine3, i4, indexOf2);
                                int i6 = indexOf2 + 1;
                                int indexOf3 = readLine3.indexOf(32, i6);
                                int m944a2 = C0220c.m944a(readLine3, i6, indexOf3 != i3 ? indexOf3 : length);
                                int i7 = indexOf3 + 1;
                                c0001b.f9f.m1224a(m944a / 1000.0f, m944a2 / 1000.0f);
                                arrayList2.add(Integer.valueOf(m944a));
                                arrayList2.add(Integer.valueOf(m944a2));
                                i5++;
                                if (i7 == 0) {
                                    break;
                                }
                                i4 = i7;
                                i3 = -1;
                            }
                            if (i5 >= 3 && (c0367g == null || c0367g.m1234c(c0001b.f9f))) {
                                if (arrayList2.get(0) == arrayList2.get(i5 - 2) && arrayList2.get(1) == arrayList2.get(i5 - 1)) {
                                    i2 = 0;
                                    c0001b.f5b = new int[i5];
                                    c0001b.f6c = new int[i5];
                                    int i8 = 0;
                                    while (i2 < arrayList2.size()) {
                                        c0001b.f5b[i8] = ((Integer) arrayList2.get(i2)).intValue();
                                        c0001b.f6c[i8] = ((Integer) arrayList2.get(i2 + 1)).intValue();
                                        i8++;
                                        i2 += 2;
                                    }
                                    hashSet.add(Integer.valueOf(hashCode));
                                    arrayList.add(c0001b);
                                }
                                i2 = 0;
                                arrayList2.add(arrayList2.get(0));
                                arrayList2.add(arrayList2.get(1));
                                i5++;
                                c0001b.f5b = new int[i5];
                                c0001b.f6c = new int[i5];
                                int i82 = 0;
                                while (i2 < arrayList2.size()) {
                                }
                                hashSet.add(Integer.valueOf(hashCode));
                                arrayList.add(c0001b);
                            }
                            str2 = str;
                        }
                    }
                }
            } catch (FileNotFoundException e2) {
                e = e2;
                e.printStackTrace();
                if (bufferedReader != null) {
                }
                return arrayList;
            } catch (IOException e3) {
                e = e3;
                e.printStackTrace();
                if (bufferedReader != null) {
                }
                return arrayList;
            }
        } catch (FileNotFoundException e4) {
            e = e4;
            bufferedReader = null;
        } catch (IOException e5) {
            e = e5;
            bufferedReader = null;
        }
        if (bufferedReader != null) {
            try {
                bufferedReader.close();
            } catch (IOException unused) {
            }
        }
        return arrayList;
    }
}
