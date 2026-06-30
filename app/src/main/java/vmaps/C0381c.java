package vmaps;

import java.util.ArrayList;

/* renamed from: vmaps.c */
/* loaded from: classes.dex */
public class C0381c {

    /* renamed from: a */
    public ArrayList<Integer> f2111a = new ArrayList<>();

    /* renamed from: a */
    private int m1307a(int[] iArr) {
        return ((iArr[0] + iArr[1]) + iArr[2]) / 3;
    }

    /* renamed from: a */
    private C0381c m1308a() {
        for (int i2 = 0; i2 < this.f2111a.size(); i2 += 3) {
            int[] m1320c = m1320c(i2);
            m1312a(m1320c, 100.0f);
            int i3 = m1320c[1] + 16;
            m1320c[1] = i3;
            if (i3 > 255) {
                m1320c[1] = 255;
            }
            int i4 = m1320c[0] + 10;
            m1320c[0] = i4;
            if (i4 > 255) {
                m1320c[0] = 255;
            }
            m1309a(i2, m1320c);
        }
        return this;
    }

    /* renamed from: a */
    private void m1309a(int i2, int[] iArr) {
        m1310a(i2, iArr, this.f2111a);
    }

    /* renamed from: a */
    private void m1310a(int i2, int[] iArr, ArrayList<Integer> arrayList) {
        int i3 = i2 + 1;
        arrayList.set(i2, Integer.valueOf(iArr[0]));
        arrayList.set(i3, Integer.valueOf(iArr[1]));
        arrayList.set(i3 + 1, Integer.valueOf(iArr[2]));
    }

    /* renamed from: a */
    private void m1311a(ArrayList<Integer> arrayList, boolean z) {
        int size = this.f2111a.size() / 3;
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 % 2 == 0) {
                int i3 = i2 * 3;
                int[] m1317a = m1317a(i3, arrayList);
                if (z) {
                    m1316a(m1317a, m1320c(i3), 10, 10);
                }
                m1309a(i3, m1317a);
            }
        }
    }

    /* renamed from: a */
    private void m1312a(int[] iArr, float f2) {
        int m1307a = m1307a(iArr);
        for (int i2 = 0; i2 < 3; i2++) {
            iArr[i2] = (int) (((m1307a * f2) + iArr[i2]) / (1.0f + f2));
        }
    }

    /* renamed from: a */
    private void m1313a(int[] iArr, int i2) {
        int size = this.f2111a.size();
        if (size > 0) {
            m1315a(new int[]{this.f2111a.get(size - 3).intValue(), this.f2111a.get(size - 2).intValue(), this.f2111a.get(size - 1).intValue()}, iArr, i2);
        } else {
            m1314a(iArr, this.f2111a);
        }
    }

    /* renamed from: a */
    private void m1314a(int[] iArr, ArrayList<Integer> arrayList) {
        arrayList.add(Integer.valueOf(iArr[0]));
        arrayList.add(Integer.valueOf(iArr[1]));
        arrayList.add(Integer.valueOf(iArr[2]));
    }

    /* renamed from: a */
    private void m1315a(int[] iArr, int[] iArr2, int i2) {
        int[] m1319b = m1319b(iArr, iArr2, i2);
        for (int i3 : m1319b) {
            this.f2111a.add(Integer.valueOf(i3));
        }
    }

    /* renamed from: a */
    private void m1316a(int[] iArr, int[] iArr2, int i2, int i3) {
        for (int i4 = 0; i4 < 3; i4++) {
            iArr[i4] = ((iArr[i4] * i2) + (iArr2[i4] * i3)) / (i2 + i3);
        }
    }

    /* renamed from: a */
    private int[] m1317a(int i2, ArrayList<Integer> arrayList) {
        int i3 = i2 + 1;
        return new int[]{arrayList.get(i2).intValue(), arrayList.get(i3).intValue(), arrayList.get(i3 + 1).intValue()};
    }

    /* renamed from: b */
    private ArrayList<Integer> m1318b(int i2) {
        int size = this.f2111a.size();
        ArrayList<Integer> arrayList = new ArrayList<>(size);
        for (int i3 = 0; i3 < size; i3 += 3) {
            int i4 = i3 - (i2 * 3);
            if (i4 < 0) {
                i4 = i3;
            }
            m1314a(m1320c(i4), arrayList);
        }
        return arrayList;
    }

    /* renamed from: b */
    private int[] m1319b(int[] iArr, int[] iArr2, int i2) {
        float f2 = i2;
        int[] iArr3 = new int[(int) (3.0f * f2)];
        for (int i3 = 0; i3 < 3; i3++) {
            float f3 = (iArr2[i3] - iArr[i3]) / f2;
            int i4 = 0;
            while (i4 < i2) {
                int i5 = i4 + 1;
                iArr3[(i4 * 3) + i3] = iArr[i3] + ((int) (i5 * f3));
                i4 = i5;
            }
        }
        return iArr3;
    }

    /* renamed from: c */
    private int[] m1320c(int i2) {
        return m1317a(i2, this.f2111a);
    }

    /* renamed from: a */
    public C0381c m1321a(int i2) {
        if (i2 == 10) {
            m1313a(new int[]{90, 150, 70}, 0);
            m1313a(new int[]{240, 240, 156}, 40);
            m1313a(new int[]{156, 105, 58}, 40);
            m1313a(new int[]{190, 190, 190}, 40);
            m1313a(new int[]{255, 255, 255}, 132);
            m1322a(10, 0);
        } else if (i2 != 20) {
            switch (i2) {
                case 0:
                case 1:
                    m1313a(new int[]{160, 200, 140}, 0);
                    m1313a(new int[]{255, 255, 166}, 48);
                    m1313a(new int[]{183, 135, 84}, 48);
                    m1313a(new int[]{200, 200, 200}, 24);
                    m1313a(new int[]{255, 255, 255}, 140);
                    break;
                case 2:
                    m1313a(new int[]{130, 190, 100}, 0);
                    m1313a(new int[]{255, 255, 166}, 48);
                    m1313a(new int[]{183, 135, 84}, 48);
                    m1313a(new int[]{200, 200, 200}, 24);
                    m1313a(new int[]{255, 255, 255}, 140);
                    m1311a(m1318b(((this.f2111a.size() / 3) / 26) + 1), false);
                    break;
                case 3:
                    m1313a(new int[]{200, 230, 170}, 0);
                    m1313a(new int[]{255, 255, 166}, 48);
                    m1313a(new int[]{183, 135, 84}, 48);
                    m1313a(new int[]{200, 200, 200}, 24);
                    m1313a(new int[]{255, 255, 255}, 140);
                    m1311a(m1318b(((this.f2111a.size() / 3) / 26) + 1), false);
                    m1308a();
                    break;
                case 4:
                    m1313a(new int[]{200, 230, 170}, 0);
                    m1313a(new int[]{255, 255, 166}, 48);
                    m1313a(new int[]{183, 135, 84}, 48);
                    m1313a(new int[]{200, 200, 200}, 24);
                    m1313a(new int[]{255, 255, 255}, 140);
                    m1308a();
                    break;
                case 5:
                    m1313a(new int[]{91, 130, 85}, 0);
                    m1313a(new int[]{255, 255, 156}, 40);
                    m1313a(new int[]{156, 105, 58}, 40);
                    m1313a(new int[]{190, 190, 190}, 40);
                    m1313a(new int[]{255, 255, 255}, 132);
                    break;
            }
        } else {
            m1313a(new int[]{170, 220, 120}, 0);
            m1313a(new int[]{255, 255, 166}, 48);
            m1313a(new int[]{183, 135, 84}, 48);
            m1313a(new int[]{200, 200, 200}, 24);
            m1313a(new int[]{255, 255, 255}, 140);
            m1311a(m1318b(((this.f2111a.size() / 3) / 26) + 1), true);
        }
        return this;
    }

    /* renamed from: a */
    public C0381c m1322a(int i2, int i3) {
        for (int i4 = 0; i4 < this.f2111a.size(); i4 += 3) {
            int[] m1320c = m1320c(i4);
            if (i3 != 0) {
                m1312a(m1320c, i3);
            }
            for (int i5 = 0; i5 < 3; i5++) {
                int i6 = m1320c[i5] + i2;
                if (i6 > 255) {
                    i6 = 255;
                }
                m1320c[i5] = i6;
            }
            m1309a(i4, m1320c);
        }
        return this;
    }
}
