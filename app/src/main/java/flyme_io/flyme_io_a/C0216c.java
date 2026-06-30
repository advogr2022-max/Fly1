package flyme_io.flyme_io_a;

import java.util.ArrayList;
import flyme_io.C0217b;
import types.C0365e;
import types.C0369i;

/* renamed from: i.a.c */
/* loaded from: classes.dex */
public class C0216c {

    /* renamed from: d */
    public int[] f1162d;

    /* renamed from: e */
    public int f1163e;

    /* renamed from: h */
    public C0217b f1166h;

    /* renamed from: i */
    int f1167i;

    /* renamed from: j */
    a[] f1168j;

    /* renamed from: k */
    int f1169k;

    /* renamed from: l */
    int f1170l;

    /* renamed from: m */
    int f1171m;

    /* renamed from: n */
    public C0215b f1172n;

    /* renamed from: o */
    public C0215b f1173o;

    /* renamed from: p */
    public C0215b f1174p;

    /* renamed from: q */
    public C0215b f1175q;

    /* renamed from: r */
    public long f1176r;

    /* renamed from: t */
    boolean f1178t;

    /* renamed from: v */
    public int f1180v;

    /* renamed from: w */
    public int f1181w;

    /* renamed from: x */
    public int f1182x;

    /* renamed from: a */
    final float f1159a = 1.2f;

    /* renamed from: b */
    final float f1160b = 1.4f;

    /* renamed from: c */
    public boolean f1161c = false;

    /* renamed from: f */
    short[] f1164f = null;

    /* renamed from: g */
    int[] f1165g = null;

    /* renamed from: y */
    private int f1183y = 0;

    /* renamed from: z */
    private int f1184z = 0;

    /* renamed from: A */
    private int f1157A = 0;

    /* renamed from: B */
    private int f1158B = 0;

    /* renamed from: s */
    public C0214a f1177s = null;

    /* renamed from: u */
    public boolean f1179u = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i.a.c$a */
    /* loaded from: classes.dex */
    public class a {

        /* renamed from: a */
        int f1185a;

        /* renamed from: b */
        int f1186b;

        /* renamed from: c */
        int f1187c;

        /* renamed from: d */
        int f1188d = 0;

        a(int i2, int i3, int i4) {
            this.f1185a = i2;
            this.f1186b = i3;
            this.f1187c = i4;
        }
    }

    public C0216c(boolean z) {
        this.f1178t = z;
    }

    /* renamed from: a */
    private a m906a(int i2, int i3) {
        int length = this.f1168j.length;
        int i4 = 0;
        int i5 = -1;
        int i6 = 99999;
        while (i4 < length) {
            a aVar = this.f1168j[i4];
            if (aVar.f1185a > i2) {
                break;
            }
            if (aVar.f1186b < i3) {
                if (aVar.f1188d > i4) {
                    i4 = aVar.f1188d - 1;
                }
            } else if (aVar.f1187c < i6) {
                i6 = aVar.f1187c;
                i5 = i4;
            }
            i4++;
        }
        return i5 != -1 ? this.f1168j[i5] : new a(i2, i3, 99999);
    }

    /* renamed from: a */
    private void m907a() {
        int m1188d = this.f1166h.f1203n.m1188d() / 1000;
        int i2 = 500;
        if (!this.f1179u) {
            int m930b = (int) this.f1166h.m930b();
            i2 = (this.f1166h.f1198i.length >= 500 || m930b <= 8) ? ((this.f1166h.f1198i.length >= 800 || m930b <= 6) && m1188d > 5) ? 100 : 50 : 10;
            if (this.f1178t) {
                i2 *= 2;
            }
        } else if (m1188d <= 50) {
            i2 = 400;
        }
        this.f1162d = new int[this.f1166h.f1198i.length];
        this.f1163e = C0365e.m1205a(this.f1166h.f1199j, this.f1166h.f1198i, this.f1162d, i2);
        if (this.f1163e < 12) {
            for (int i3 = 0; i3 < 3 && (!this.f1179u || this.f1163e <= 5); i3++) {
                i2 /= 3;
                int m1205a = C0365e.m1205a(this.f1166h.f1199j, this.f1166h.f1198i, this.f1162d, i2);
                this.f1163e = m1205a;
                if (m1205a > 6) {
                    break;
                }
            }
        } else if (this.f1179u && this.f1163e > 100) {
            this.f1163e = C0365e.m1205a(this.f1166h.f1199j, this.f1166h.f1198i, this.f1162d, i2 + (i2 / 4));
        }
        this.f1167i = this.f1163e * this.f1163e;
        this.f1164f = new short[this.f1167i];
        this.f1165g = new int[this.f1167i];
    }

    /* renamed from: a */
    private void m908a(C0214a c0214a, int i2) {
        int i3 = c0214a.f1146a[i2];
        boolean z = i2 == c0214a.f1146a.length - 1;
        boolean z2 = i2 == 0;
        int i4 = !z ? c0214a.f1146a[i2 + 1] : 0;
        int i5 = !z2 ? c0214a.f1146a[i2 - 1] : 0;
        int i6 = i4 - i3;
        int i7 = i6 / 4;
        if (i7 < 50) {
            i7 = Math.min(50, i6);
        }
        int length = z ? this.f1166h.f1198i.length : i3 + i7;
        if (z2) {
            length = i4 - 1;
        }
        int i8 = i3;
        int i9 = i8;
        int i10 = 0;
        int i11 = 0;
        while (i8 < length) {
            int m924f = !z ? m924f(i8, i4) + 0 : 0;
            if (!z2) {
                m924f += m924f(i8, i5);
            }
            if (m924f > i10) {
                i9 = i8;
                i11 = (m924f * 3) / 4;
                i10 = m924f;
            } else if (m924f < i11) {
                break;
            }
            i8++;
        }
        int i12 = i3 - i5;
        int i13 = i12 / 4;
        if (i13 < 50) {
            Math.min(50, i12);
        }
        int i14 = z2 ? 0 : i3 - i13;
        if (z) {
            i14 = i5 + 1;
        }
        while (i3 >= i14) {
            int m924f2 = !z2 ? m924f(i3, i5) + 0 : 0;
            if (!z) {
                m924f2 += m924f(i3, i4);
            }
            if (m924f2 > i10) {
                i9 = i3;
                i10 = m924f2;
                i11 = (m924f2 * 3) / 4;
            } else if (m924f2 < i11) {
                break;
            }
            i3--;
        }
        c0214a.f1146a[i2] = i9;
    }

    /* renamed from: a */
    private void m909a(C0215b c0215b) {
        for (int i2 = 0; i2 < c0215b.f1154a.length; i2++) {
            C0214a c0214a = c0215b.f1154a[i2];
            int i3 = c0214a.f1147b == 3 ? this.f1184z : this.f1183y;
            if (c0214a.f1148c > i3 * 0.9f) {
                if (!this.f1178t) {
                    m921d(c0214a);
                }
                m911a(c0214a);
                if (c0214a.f1148c > i3) {
                    if (c0214a.f1147b == 3) {
                        this.f1184z = c0214a.f1148c;
                    } else {
                        this.f1183y = c0214a.f1148c;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m910a(String str) {
        if (this.f1161c) {
            return;
        }
        System.out.println(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01da  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private boolean m911a(C0214a c0214a) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        C0216c c0216c = this;
        c0214a.f1151f = true;
        if (c0214a.f1146a[2] - c0214a.f1146a[0] < 10) {
            return false;
        }
        boolean z = c0214a.f1147b == 3;
        int i17 = z ? c0216c.f1184z : c0216c.f1183y;
        if (c0214a.f1148c < i17 * 0.9f) {
            return false;
        }
        int i18 = c0214a.f1146a[0];
        int i19 = c0214a.f1146a[1];
        int i20 = c0214a.f1146a[2];
        double m930b = c0216c.f1166h.m930b();
        Double.isNaN(m930b);
        int i21 = (int) (m930b + 0.5d);
        if (i21 < 1) {
            i21 = 1;
        }
        int i22 = 360 / i21;
        if (i22 < 10) {
            i22 = 10;
        }
        int i23 = i22 / c0216c.f1180v;
        if (i23 == 0) {
            i23 = 1;
        }
        int i24 = i18 - i22;
        if (i24 < 0) {
            i24 = 0;
        }
        int i25 = i18 + i22;
        if (i25 > i19) {
            i25 = i19;
        }
        int i26 = i19 - i22;
        int i27 = i19 + i22;
        if (i27 > i20) {
        }
        int i28 = i20 - i22;
        int i29 = i22 + i20;
        if (i29 > c0216c.f1166h.f1198i.length) {
            i29 = c0216c.f1166h.f1198i.length;
        }
        a m913b = c0216c.m913b(i18, i20);
        int i30 = m913b.f1187c;
        int i31 = i17;
        char c2 = 2;
        int[] iArr = {i18, i19, i20, m913b.f1185a, m913b.f1186b};
        int i32 = i23 + 1;
        int m924f = c0216c.m924f(i18, i20);
        int m924f2 = c0216c.m924f(i18, i19);
        int m924f3 = c0216c.m924f(i19, i20);
        int i33 = i30;
        a aVar = m913b;
        int i34 = 0;
        boolean z2 = false;
        int i35 = 0;
        boolean z3 = false;
        boolean z4 = false;
        int i36 = m924f3;
        int i37 = i31;
        while (i25 >= i24) {
            boolean z5 = z2;
            if (m924f - c0216c.m924f(i25, iArr[c2]) <= 100 || m924f2 - c0216c.m924f(i25, iArr[1]) <= 100) {
                int i38 = i28 < i25 ? i25 : i28;
                int i39 = m924f2;
                int i40 = i33;
                int i41 = 0;
                int i42 = 0;
                a aVar2 = aVar;
                int i43 = i34;
                a aVar3 = aVar2;
                while (i38 < i29) {
                    int i44 = i28;
                    if (m924f - c0216c.m924f(i25, iArr[2]) > 0) {
                        i8 = i39;
                        if (i36 - c0216c.m924f(i38, iArr[1]) > 0) {
                            i10 = i26;
                            i12 = i27;
                            i13 = i29;
                            i14 = i23;
                            i15 = i24;
                            i39 = i8;
                            i38 += !z3 ? 1 : i14;
                            i28 = i44;
                            i26 = i10;
                            i27 = i12;
                            i29 = i13;
                            i23 = i14;
                            i24 = i15;
                            c0216c = this;
                        }
                    } else {
                        i8 = i39;
                    }
                    if (i25 < aVar3.f1185a || i38 > aVar3.f1186b) {
                        aVar3 = c0216c.m913b(i25, i38);
                        i9 = aVar3.f1187c;
                    } else {
                        i9 = i40;
                    }
                    int m924f4 = c0216c.m924f(i25, i38);
                    int i45 = i26 < i25 ? i25 : i26;
                    if (i27 > i38) {
                        i10 = i26;
                        i11 = i38;
                    } else {
                        i10 = i26;
                        i11 = i27;
                    }
                    boolean z6 = z4;
                    i12 = i27;
                    int i46 = i37;
                    i13 = i29;
                    int i47 = 0;
                    int i48 = i41;
                    int i49 = i45;
                    int i50 = i36;
                    boolean z7 = false;
                    while (i49 < i11) {
                        int i51 = i11;
                        int m924f5 = c0216c.m924f(i25, i49);
                        int i52 = i23;
                        int m924f6 = c0216c.m924f(i49, i38);
                        int i53 = i24;
                        int i54 = m924f5 + m924f6 + m924f4;
                        int i55 = i47;
                        if (i9 <= i54 * 0.2f) {
                            int i56 = i54 - i9;
                            if (i56 > i46) {
                                int i57 = m924f5 < m924f6 ? m924f5 : m924f6;
                                if (m924f4 < i57) {
                                    i57 = m924f4;
                                }
                                if (!z || i57 * 1000 >= i54 * 280) {
                                    iArr[0] = i25;
                                    iArr[1] = i49;
                                    iArr[2] = i38;
                                    iArr[3] = aVar3.f1185a;
                                    iArr[4] = aVar3.f1186b;
                                    i43++;
                                    i46 = i56;
                                    i8 = m924f5;
                                    m924f = m924f4;
                                    i50 = m924f6;
                                    z7 = true;
                                }
                            } else if (i42 - i56 > 0 && i56 > i46 - 500) {
                                i49 += i32;
                            }
                            if (i56 > i48) {
                                i48 = i56;
                            }
                            i16 = i55;
                            if (i56 > i16) {
                                i47 = i56;
                                i49 += !z6 ? 1 : i52;
                                i11 = i51;
                                i23 = i52;
                                i24 = i53;
                                c0216c = this;
                            }
                        } else {
                            i16 = i55;
                        }
                        i47 = i16;
                        i49 += !z6 ? 1 : i52;
                        i11 = i51;
                        i23 = i52;
                        i24 = i53;
                        c0216c = this;
                    }
                    int i58 = i47;
                    i14 = i23;
                    i15 = i24;
                    if (i58 < i46 - 500 && i42 - i58 > 10) {
                        i38 += i32;
                    }
                    if (z7) {
                        i42 = i58;
                        i37 = i46;
                        i40 = i9;
                        i41 = i48;
                        z4 = z7;
                        i36 = i50;
                        i39 = i8;
                        z3 = true;
                    } else {
                        i42 = i58;
                        i37 = i46;
                        i40 = i9;
                        i41 = i48;
                        z4 = z7;
                        i36 = i50;
                        i39 = i8;
                        z3 = false;
                    }
                    i38 += !z3 ? 1 : i14;
                    i28 = i44;
                    i26 = i10;
                    i27 = i12;
                    i29 = i13;
                    i23 = i14;
                    i24 = i15;
                    c0216c = this;
                }
                i2 = i26;
                i3 = i27;
                i4 = i28;
                int i59 = i39;
                i5 = i29;
                i6 = i23;
                i7 = i24;
                if (i41 < i37 - 500 && i35 - i41 > 10) {
                    i25 -= i32;
                }
                i35 = i41;
                z2 = z3;
                i33 = i40;
                m924f2 = i59;
                int i60 = i43;
                aVar = aVar3;
                i34 = i60;
            } else {
                i2 = i26;
                i3 = i27;
                i4 = i28;
                i5 = i29;
                i6 = i23;
                i7 = i24;
                z2 = z5;
            }
            i25 -= z2 ? 1 : i6;
            i28 = i4;
            i26 = i2;
            i27 = i3;
            i29 = i5;
            i23 = i6;
            i24 = i7;
            c0216c = this;
            c2 = 2;
        }
        if (i34 <= 0) {
            return false;
        }
        c0214a.m901a(i37, iArr[0], iArr[1], iArr[2], iArr[3], iArr[4]);
        if (z) {
            this.f1184z = i37;
            return true;
        }
        this.f1183y = i37;
        return true;
    }

    /* renamed from: b */
    private C0214a m912b(C0215b c0215b) {
        C0214a m903a = c0215b.m903a();
        if (m903a.f1148c > 0) {
            m915b(m903a);
        }
        return m903a;
    }

    /* renamed from: b */
    private a m913b(int i2, int i3) {
        a m906a = m906a(i2, i3);
        int i4 = m906a.f1185a;
        int i5 = m906a.f1186b;
        int i6 = m906a.f1187c;
        int i7 = this.f1181w;
        if (m906a.f1187c < 1000) {
            i7 *= 2;
        }
        int i8 = (i2 - m906a.f1185a) / i7;
        if (i8 == 0) {
            i8 = 1;
        }
        int i9 = (m906a.f1186b - i3) / i7;
        if (i9 == 0) {
            i9 = 1;
        }
        int i10 = m906a.f1185a;
        while (i10 <= i2) {
            int i11 = i5;
            int i12 = i4;
            for (int i13 = i3; i13 <= m906a.f1186b; i13 += i9) {
                int m924f = m924f(i10, i13);
                if (m924f < i6) {
                    i11 = i13;
                    i12 = i10;
                    i6 = m924f;
                }
            }
            i10 += i8;
            i4 = i12;
            i5 = i11;
        }
        return new a(i4, i5, i6);
    }

    /* renamed from: b */
    private void m914b() {
        int i2 = 0;
        this.f1157A = 0;
        int i3 = this.f1163e;
        int i4 = i3 / 10;
        if (i4 < 2) {
            i4 = 2;
        }
        int m1188d = this.f1166h.f1203n.m1188d() / 6;
        int i5 = i4;
        int i6 = 0;
        while (true) {
            int i7 = i3 - 1;
            if (i5 >= i7) {
                return;
            }
            int m919d = m919d(i5, i7);
            int m922e = m922e(i5, m919d);
            int i8 = i6;
            int i9 = 2;
            while (i9 < i5) {
                int m922e2 = m922e(i9, i5);
                int i10 = i8;
                int i11 = 1;
                while (i11 < i9) {
                    int m922e3 = m922e(i11, i9);
                    int m919d2 = m919d(i11 - 1, i2);
                    int m922e4 = m922e(m919d2, i11) + m922e3 + m922e2 + m922e;
                    if (m922e4 > i10) {
                        this.f1172n.m904a(m922e4, this.f1162d[m919d2], this.f1162d[i11], this.f1162d[i9], this.f1162d[i5], this.f1162d[m919d]);
                        int i12 = this.f1172n.f1156c;
                        this.f1157A = this.f1172n.f1155b;
                        i10 = i12;
                    } else if (m922e4 < m1188d || m922e4 < this.f1157A / 4) {
                        i11 += i4;
                    }
                    i11++;
                    i2 = 0;
                }
                i9++;
                i8 = i10;
                i2 = 0;
            }
            i5++;
            i6 = i8;
            i2 = 0;
        }
    }

    /* renamed from: b */
    private void m915b(C0214a c0214a) {
        int i2;
        int i3;
        if (c0214a.f1147b == 1) {
            c0214a.f1149d = m926g(c0214a.f1146a[0], c0214a.f1146a[1]) + m926g(c0214a.f1146a[1], c0214a.f1146a[2]) + m926g(c0214a.f1146a[2], c0214a.f1146a[3]) + m926g(c0214a.f1146a[3], c0214a.f1146a[4]);
            i2 = this.f1166h.f1194e[c0214a.f1146a[4]];
            i3 = this.f1166h.f1194e[c0214a.f1146a[0]];
        } else {
            a m916c = m916c(c0214a.f1146a[0], c0214a.f1146a[2]);
            c0214a.f1146a[3] = m916c.f1185a;
            c0214a.f1146a[4] = m916c.f1186b;
            float m926g = m926g(m916c.f1185a, m916c.f1186b);
            c0214a.f1149d = m926g(c0214a.f1146a[0], c0214a.f1146a[1]) + m926g(c0214a.f1146a[1], c0214a.f1146a[2]) + m926g(c0214a.f1146a[2], c0214a.f1146a[0]);
            c0214a.f1149d -= m926g;
            i2 = this.f1166h.f1194e[c0214a.f1146a[4]];
            i3 = this.f1166h.f1194e[c0214a.f1146a[3]];
        }
        c0214a.f1153h = i2 - i3;
        if (c0214a.f1153h > 0) {
            c0214a.f1152g = (c0214a.f1149d * 3600.0f) / c0214a.f1153h;
        }
        m918c(c0214a);
    }

    /* renamed from: c */
    private a m916c(int i2, int i3) {
        if (this.f1179u) {
            return m913b(i2, i3);
        }
        int i4 = 0;
        int i5 = i2;
        int i6 = i3;
        int i7 = 99999;
        while (i4 <= i2) {
            int i8 = i6;
            int i9 = i5;
            for (int i10 = i3; i10 < this.f1166h.f1198i.length; i10++) {
                int m924f = m924f(i4, i10);
                if (m924f < i7) {
                    i8 = i10;
                    i9 = i4;
                    i7 = m924f;
                }
            }
            i4++;
            i5 = i9;
            i6 = i8;
        }
        return new a(i5, i6, i7);
    }

    /* renamed from: c */
    private void m917c() {
        C0215b c0215b = this.f1172n;
        for (int i2 = 0; i2 < c0215b.f1154a.length; i2++) {
            C0214a c0214a = c0215b.f1154a[i2];
            if (c0214a.f1148c > this.f1157A * 0.9f) {
                m908a(c0214a, 1);
                m908a(c0214a, 2);
                m908a(c0214a, 3);
                m908a(c0214a, 0);
                m908a(c0214a, 4);
                c0214a.f1148c = m924f(c0214a.f1146a[0], c0214a.f1146a[1]) + m924f(c0214a.f1146a[1], c0214a.f1146a[2]) + m924f(c0214a.f1146a[2], c0214a.f1146a[3]) + m924f(c0214a.f1146a[3], c0214a.f1146a[4]);
                if (c0214a.f1148c > this.f1157A) {
                    this.f1157A = c0214a.f1148c;
                }
                c0214a.f1151f = true;
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
    /* renamed from: c */
    private void m918c(C0214a c0214a) {
        float f2;
        float f3;
        c0214a.f1150e = c0214a.f1149d;
        switch (c0214a.f1147b) {
            case 2:
                f2 = c0214a.f1150e;
                f3 = 1.2f;
                c0214a.f1150e = f2 * f3;
                return;
            case 3:
                f2 = c0214a.f1150e;
                f3 = 1.4f;
                c0214a.f1150e = f2 * f3;
                return;
            default:
                return;
        }
    }

    /* renamed from: d */
    private int m919d(int i2, int i3) {
        int i4;
        short s;
        int i5 = (this.f1163e * i2) + i3;
        if (this.f1164f != null && (s = this.f1164f[i5]) != 0) {
            return s;
        }
        if (i3 > i2) {
            int i6 = i2;
            i4 = i6;
            int i7 = 0;
            while (i6 <= i3) {
                int m922e = m922e(i2, i6);
                if (m922e > i7) {
                    i4 = i6;
                    i7 = m922e;
                }
                i6++;
            }
        } else {
            int i8 = i2;
            i4 = i8;
            int i9 = 0;
            while (i8 >= i3) {
                int m922e2 = m922e(i8, i2);
                if (m922e2 > i9) {
                    i4 = i8;
                    i9 = m922e2;
                }
                i8--;
            }
        }
        if (this.f1164f != null) {
            this.f1164f[i5] = (short) i4;
        }
        return i4;
    }

    /* renamed from: d */
    private void m920d() {
        ArrayList arrayList = new ArrayList();
        int m1188d = this.f1166h.f1203n.m1188d();
        int i2 = this.f1163e;
        int i3 = 0;
        while (i3 < i2) {
            ArrayList arrayList2 = new ArrayList();
            int i4 = m1188d / 2;
            int i5 = i2 - 1;
            int i6 = i4;
            int i7 = i5;
            int i8 = 0;
            while (i7 > i3 && m922e(i7, i5) <= (m1188d * 3) / 4) {
                int m922e = m922e(i3, i7);
                if (m922e > i8) {
                    i8 = m922e;
                }
                if (m922e > i4 && m922e > i6 * 2) {
                    break;
                }
                double d2 = m922e;
                int i9 = i3;
                double d3 = m1188d;
                Double.isNaN(d3);
                if (d2 <= d3 * 0.5d && m922e < i6) {
                    arrayList2.add(new a(this.f1162d[i9], this.f1162d[i7], m922e));
                    i6 = m922e;
                }
                i7--;
                i3 = i9;
            }
            int i10 = i3;
            if (i8 > m1188d / 3) {
                int size = arrayList.size() + arrayList2.size();
                for (int i11 = 0; i11 < arrayList2.size(); i11++) {
                    ((a) arrayList2.get(i11)).f1188d = size;
                    arrayList.add(arrayList2.get(i11));
                }
            }
            i3 = i10 + 1;
        }
        this.f1168j = (a[]) arrayList.toArray(new a[0]);
        m910a("MinGaps arr. length: " + this.f1168j.length);
    }

    /* renamed from: d */
    private void m921d(C0214a c0214a) {
        a m916c = m916c(c0214a.f1146a[0], c0214a.f1146a[2]);
        c0214a.f1146a[3] = m916c.f1185a;
        c0214a.f1146a[4] = m916c.f1186b;
        float m924f = m924f(m916c.f1185a, m916c.f1186b);
        c0214a.f1148c = m924f(c0214a.f1146a[0], c0214a.f1146a[1]) + m924f(c0214a.f1146a[1], c0214a.f1146a[2]) + m924f(c0214a.f1146a[2], c0214a.f1146a[0]);
        c0214a.f1148c = (int) (c0214a.f1148c - m924f);
    }

    /* renamed from: e */
    private int m922e(int i2, int i3) {
        return this.f1165g[(i2 * this.f1163e) + i3];
    }

    /* renamed from: e */
    private void m923e() {
        int i2 = this.f1163e;
        this.f1170l = 0;
        this.f1171m = 0;
        this.f1169k = 0;
        for (int i3 = 1; i3 < i2; i3++) {
            for (int i4 = 0; i4 < i3; i4++) {
                int m924f = m924f(this.f1162d[i4], this.f1162d[i3]);
                int i5 = (this.f1163e * i4) + i3;
                if (this.f1165g != null) {
                    this.f1165g[i5] = m924f;
                }
                if (m924f > this.f1169k) {
                    this.f1169k = m924f;
                    this.f1171m = i4;
                    this.f1170l = i3;
                }
            }
        }
    }

    /* renamed from: f */
    private int m924f(int i2, int i3) {
        double d2 = this.f1166h.f1198i[i2] - this.f1166h.f1198i[i3];
        double d3 = this.f1166h.f1199j[i2] - this.f1166h.f1199j[i3];
        Double.isNaN(d2);
        Double.isNaN(d2);
        Double.isNaN(d3);
        Double.isNaN(d3);
        return (int) (Math.sqrt((d2 * d2) + (d3 * d3)) + 0.5d);
    }

    /* renamed from: f */
    private void m925f() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        a aVar;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15 = this.f1157A;
        if (this.f1157A == 0) {
            return;
        }
        this.f1158B = 0;
        this.f1183y = 0;
        this.f1184z = 0;
        int i16 = 1;
        double m922e = m922e(0, this.f1163e - 1);
        double d2 = this.f1157A;
        Double.isNaN(d2);
        if (m922e > d2 * 0.6d) {
            return;
        }
        m920d();
        int i17 = this.f1163e / 12;
        if (i17 < 1) {
            i17 = 1;
        }
        int i18 = this.f1163e - i17;
        if (i18 > this.f1170l + this.f1163e) {
            i18 = this.f1170l + this.f1163e;
        }
        int i19 = 0;
        boolean z = false;
        int i20 = 0;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        while (i19 < i18 && !z) {
            int i25 = i19 + i17;
            int i26 = i25 < this.f1171m ? this.f1171m : i25;
            if (i26 >= this.f1163e - i16) {
                i26 = this.f1163e - i16;
            }
            int i27 = this.f1163e - i16;
            int i28 = i22;
            int i29 = i23;
            int i30 = i24;
            int i31 = 0;
            int i32 = 0;
            int i33 = 0;
            boolean z2 = z;
            int i34 = i21;
            double d3 = 0.0d;
            int i35 = 0;
            while (i27 > i26) {
                int m922e2 = m922e(i19, i27);
                a aVar2 = null;
                int i36 = i17;
                int i37 = i18;
                int i38 = i35;
                double d4 = d3;
                boolean z3 = z2;
                int i39 = i34;
                int i40 = i25;
                int i41 = i26;
                int i42 = i31;
                int i43 = i33;
                int i44 = i28;
                int i45 = i29;
                int i46 = i30;
                int i47 = i19 + 1;
                int i48 = 0;
                int i49 = 0;
                int i50 = 0;
                while (i47 < i27) {
                    int i51 = i20;
                    int m922e3 = m922e(i19, i47);
                    int i52 = i46;
                    int m922e4 = m922e(i47, i27);
                    int i53 = i45;
                    int i54 = m922e3 + m922e4 + m922e2;
                    if (m922e3 > i38) {
                        i38 = m922e3;
                    }
                    if (m922e4 > i48) {
                        i48 = m922e4;
                    }
                    if (m922e3 > i49) {
                        i49 = m922e3;
                    }
                    if (m922e4 > i49) {
                        i49 = m922e4;
                    }
                    int i55 = i38;
                    if (i54 < i15 / 5) {
                        i47++;
                        i9 = i15;
                        i14 = m922e2;
                        i6 = i48;
                    } else {
                        int i56 = i54 * 100;
                        i6 = i48;
                        if ((i56 >= this.f1183y * 80 || i56 >= this.f1184z * 80) && i54 + 500 >= i15 / 3) {
                            if (i54 > i42) {
                                i42 = i54;
                            }
                            if (aVar2 == null) {
                                a m906a = m906a(this.f1162d[i19], this.f1162d[i27]);
                                int i57 = m906a.f1187c;
                                if (i57 > this.f1169k * 0.6f) {
                                    i9 = i15;
                                    i14 = m922e2;
                                    i7 = i49;
                                    i46 = i52;
                                    i45 = i53;
                                    aVar2 = m906a;
                                    i32 = i57;
                                    i47++;
                                    i20 = i51;
                                    i38 = i55;
                                    i48 = i6;
                                    i49 = i7;
                                    i15 = i9;
                                    m922e2 = i14;
                                } else {
                                    i7 = i49;
                                    aVar = m906a;
                                    i8 = i57;
                                }
                            } else {
                                i7 = i49;
                                i8 = i32;
                                aVar = aVar2;
                            }
                            int i58 = i54 - i8;
                            if (i58 > i50) {
                                i11 = i50;
                                i12 = i42;
                                double d5 = i8;
                                i9 = i15;
                                i10 = m922e2;
                                double d6 = i54;
                                Double.isNaN(d6);
                                if (d5 < d6 * 0.3d) {
                                    i11 = i58;
                                }
                            } else {
                                i9 = i15;
                                i10 = m922e2;
                                i11 = i50;
                                i12 = i42;
                            }
                            if (i8 <= i54 * 0.2f) {
                                if (i58 > i43) {
                                    i43 = i58;
                                }
                                if (i58 > i44) {
                                    this.f1173o.m905b(i58, this.f1162d[i19], this.f1162d[i47], this.f1162d[i27], aVar.f1185a, aVar.f1186b);
                                    i44 = this.f1173o.f1156c;
                                    this.f1183y = this.f1173o.f1155b;
                                }
                                int i59 = i10;
                                double d7 = m922e3 < i59 ? m922e3 : i59;
                                i14 = i59;
                                double d8 = m922e4;
                                if (d8 >= d7) {
                                    d8 = d7;
                                }
                                double d9 = d8 * 1000.0d;
                                if (d9 >= ((double) (i54 * 280))) {
                                    i13 = i53;
                                    if (i58 > i13) {
                                        this.f1174p.m905b(i58, this.f1162d[i19], this.f1162d[i47], this.f1162d[i27], aVar.f1185a, aVar.f1186b);
                                        this.f1184z = this.f1174p.f1155b;
                                        i45 = this.f1174p.f1156c;
                                        i32 = i8;
                                        aVar2 = aVar;
                                        i46 = i52;
                                        i50 = i11;
                                        i42 = i12;
                                        i47++;
                                        i20 = i51;
                                        i38 = i55;
                                        i48 = i6;
                                        i49 = i7;
                                        i15 = i9;
                                        m922e2 = i14;
                                    }
                                } else {
                                    i13 = i53;
                                }
                                if (i58 > this.f1184z) {
                                    i46 = i52;
                                    if (i58 > i46 && d9 >= i54 * 270) {
                                        this.f1175q.m905b(i58, this.f1162d[i19], this.f1162d[i47], this.f1162d[i27], aVar.f1185a, aVar.f1186b);
                                        this.f1158B = this.f1175q.f1155b;
                                        i46 = this.f1175q.f1156c;
                                    }
                                } else {
                                    i46 = i52;
                                }
                            } else {
                                i46 = i52;
                                i13 = i53;
                                i14 = i10;
                            }
                            i32 = i8;
                            aVar2 = aVar;
                            i45 = i13;
                            i50 = i11;
                            i42 = i12;
                            i47++;
                            i20 = i51;
                            i38 = i55;
                            i48 = i6;
                            i49 = i7;
                            i15 = i9;
                            m922e2 = i14;
                        } else {
                            i9 = i15;
                            i14 = m922e2;
                        }
                    }
                    i7 = i49;
                    i46 = i52;
                    i45 = i53;
                    i47++;
                    i20 = i51;
                    i38 = i55;
                    i48 = i6;
                    i49 = i7;
                    i15 = i9;
                    m922e2 = i14;
                }
                int i60 = i15;
                int i61 = i20;
                int i62 = i50;
                int i63 = i45;
                if (i38 > i61) {
                    i61 = i38;
                }
                int i64 = i39;
                if (i48 > i64) {
                    i64 = i48;
                }
                if (i49 < this.f1157A / 5) {
                    i27 -= i36;
                    i4 = i61;
                    i5 = i64;
                    z2 = z3;
                } else {
                    if (i62 > 0 || i49 < i60 / 5) {
                        i3 = i62;
                        if (i3 < this.f1183y / 2 || i3 < i60 / 4) {
                            if (i27 > this.f1163e - i36 && i3 > 0) {
                                z3 = true;
                            }
                            i27 -= i36;
                        }
                    } else {
                        i3 = i62;
                    }
                    i4 = i61;
                    i5 = i64;
                    z2 = z3;
                    double d10 = i3;
                    if (d10 > d4) {
                        d4 = d10;
                    }
                }
                i27--;
                i35 = i38;
                i29 = i63;
                i33 = i43;
                i28 = i44;
                i30 = i46;
                i31 = i42;
                i18 = i37;
                i25 = i40;
                i26 = i41;
                d3 = d4;
                i17 = i36;
                i15 = i60;
                i20 = i4;
                i34 = i5;
            }
            int i65 = i15;
            int i66 = i17;
            int i67 = i18;
            int i68 = i20;
            double d11 = d3;
            boolean z4 = z2;
            int i69 = i34;
            int i70 = i25;
            if (i35 < i68 / 8) {
                return;
            }
            if (d11 <= 0.0d || (d11 >= this.f1183y / 2 && d11 >= i65 / 4)) {
                z = z4;
                i2 = 1;
            } else {
                i19 = i70;
                i2 = 1;
                z = true;
            }
            i19 += i2;
            i20 = i68;
            i21 = i69;
            i22 = i28;
            i23 = i29;
            i24 = i30;
            i18 = i67;
            i17 = i66;
            i15 = i65;
            i16 = 1;
        }
    }

    /* renamed from: g */
    private float m926g(int i2, int i3) {
        return C0369i.m1248b(this.f1166h.f1192c[i2], this.f1166h.f1193d[i2], this.f1166h.f1192c[i3], this.f1166h.f1193d[i3]);
    }

    /* renamed from: g */
    private void m927g() {
        for (int i2 = 0; i2 < this.f1175q.f1154a.length; i2++) {
            C0214a c0214a = this.f1175q.f1154a[i2];
            if (c0214a.f1148c > this.f1184z && m911a(c0214a)) {
                this.f1174p.m905b(c0214a.f1148c, c0214a.f1146a[0], c0214a.f1146a[1], c0214a.f1146a[2], c0214a.f1146a[3], c0214a.f1146a[4]);
            }
        }
    }

    /* renamed from: a */
    public boolean m928a(C0217b c0217b) {
        this.f1166h = c0217b;
        if (this.f1166h.f1192c.length < 5) {
            return false;
        }
        c0217b.m931c();
        long currentTimeMillis = System.currentTimeMillis();
        m907a();
        if (this.f1178t) {
            this.f1181w = 71;
            this.f1180v = 51;
            this.f1182x = 6;
            if (this.f1179u) {
                this.f1182x = 1;
                this.f1181w /= 2;
                this.f1180v /= 2;
            }
        } else {
            this.f1181w = 80;
            this.f1180v = 61;
            this.f1182x = 10;
        }
        this.f1172n = new C0215b(this.f1182x, 1);
        this.f1173o = new C0215b(this.f1182x, 2);
        this.f1174p = new C0215b(this.f1182x, 3);
        this.f1175q = new C0215b(this.f1182x, 3);
        m923e();
        m914b();
        if (!this.f1179u) {
            m917c();
        }
        C0214a m912b = m912b(this.f1172n);
        m910a("FreeFlight: " + m912b.f1148c + "\t / " + m912b.f1149d);
        this.f1177s = m912b;
        m925f();
        if (((float) this.f1184z) > ((float) this.f1157A) * 0.5f || ((float) this.f1183y) > ((float) this.f1157A) * 0.6f || ((float) this.f1158B) > ((float) this.f1157A) * 0.6f) {
            if (!this.f1179u) {
                if (this.f1178t) {
                    m911a(this.f1173o.m903a());
                } else {
                    m909a(this.f1173o);
                }
            }
            C0214a m912b2 = m912b(this.f1173o);
            m910a("Triangle: " + m912b2.f1148c + "\t / " + m912b2.f1149d);
            if (!this.f1179u) {
                m927g();
            }
            C0214a m903a = this.f1174p.m903a();
            if (m903a.f1148c > 0) {
                if (!m903a.f1151f && !this.f1179u) {
                    m911a(m903a);
                }
                m915b(m903a);
                m910a("FAI: " + m903a.f1148c + "\t / " + m903a.f1149d);
            }
            if (m903a != null && m903a.f1150e > m912b2.f1150e) {
                m912b2 = m903a;
            }
            if (m912b2.f1150e > this.f1177s.f1150e) {
                this.f1177s = m912b2;
            }
        }
        this.f1176r = System.currentTimeMillis() - currentTimeMillis;
        return true;
    }
}
