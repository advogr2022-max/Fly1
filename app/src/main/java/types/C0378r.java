package types;

import android.annotation.SuppressLint;

/* renamed from: types.r */
/* loaded from: classes.dex */
public class C0378r {

    /* renamed from: a */
    public String f2103a;

    /* renamed from: b */
    String f2104b;

    /* renamed from: c */
    boolean f2105c;

    /* renamed from: d */
    public int f2106d;

    /* renamed from: e */
    private int f2107e;

    public C0378r() {
        this.f2103a = null;
        this.f2104b = null;
        this.f2105c = false;
    }

    public C0378r(String str) {
        this.f2103a = null;
        this.f2104b = null;
        this.f2105c = false;
        m1297a(str);
    }

    public C0378r(String str, boolean z) {
        this.f2103a = null;
        this.f2104b = null;
        this.f2105c = false;
        this.f2105c = z;
        m1297a(str);
    }

    /* renamed from: a */
    public static int m1289a(String str, int i2, int i3) {
        char charAt;
        boolean z;
        int i4;
        int i5 = 0;
        if (str == null) {
            return 0;
        }
        char charAt2 = str.charAt(i2);
        if (charAt2 < '0' || charAt2 > '9') {
            boolean z2 = charAt2 == '-';
            if (!z2 || (i2 = i2 + 1) == i3 || (charAt = str.charAt(i2)) < '0' || charAt > '9') {
                return 0;
            }
            z = z2;
            charAt2 = charAt;
        } else {
            z = false;
        }
        while (true) {
            i4 = i5 + ('0' - charAt2);
            i2++;
            if (i2 == i3) {
                return z ? i4 : -i4;
            }
            charAt2 = str.charAt(i2);
            if (charAt2 < '0' || charAt2 > '9') {
                break;
            }
            i5 = i4 * 10;
        }
        return z ? i4 : -i4;
    }

    /* renamed from: a */
    public static int m1290a(String str, int i2, String str2) {
        if (str2 != null) {
            while (i2 < str.length()) {
                if (str2.indexOf(str.charAt(i2)) != -1) {
                    return i2;
                }
                i2++;
            }
        }
        return str.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:12:0x003b, code lost:
    
        if (r7 != (-1)) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x003d, code lost:
    
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003e, code lost:
    
        r7 = r7 + r8.length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0043, code lost:
    
        r8 = r6.charAt(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0049, code lost:
    
        if (r8 == ' ') goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x004d, code lost:
    
        if (r8 == '\r') goto L61;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0051, code lost:
    
        if (r8 == '\t') goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0055, code lost:
    
        if (r8 != '\n') goto L59;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
    
        r8 = r6.charAt(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
    
        if (r8 == '\'') goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x0062, code lost:
    
        if (r8 == '\"') goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0064, code lost:
    
        r8 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0069, code lost:
    
        if (r8 >= r6.length()) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006b, code lost:
    
        r1 = r6.charAt(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x006f, code lost:
    
        if (r1 == ' ') goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0071, code lost:
    
        if (r1 == '\n') goto L64;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0073, code lost:
    
        if (r1 == '\r') goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0075, code lost:
    
        if (r1 != '\t') goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0078, code lost:
    
        r8 = r8 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x007f, code lost:
    
        return r6.substring(r7, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0084, code lost:
    
        return r6.substring(r7, r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0085, code lost:
    
        r7 = r7 + 1;
        r8 = r6.indexOf(r8, r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x008b, code lost:
    
        if (r8 == (-1)) goto L51;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0091, code lost:
    
        return r6.substring(r7, r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0096, code lost:
    
        return r6.substring(r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x0097, code lost:
    
        r7 = r7 + 1;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String m1291a(String str, int i2, String str2, String str3) {
        int i3;
        int m1290a = m1290a(str, i2, str3);
        String str4 = str2 + "=";
        while (true) {
            if (i2 >= m1290a) {
                i3 = -1;
                break;
            }
            i3 = str.indexOf(str4, i2);
            if (i3 != -1 && i3 <= m1290a) {
                if (i3 == 0 || m1292a(str.charAt(i3 - 1))) {
                    break;
                }
                i2 = str.indexOf(61, i3);
            } else {
                break;
            }
        }
        return null;
    }

    /* renamed from: a */
    public static boolean m1292a(char c2) {
        return c2 == ' ' || c2 == '\r' || c2 == '\n' || c2 == '\t';
    }

    /* renamed from: d */
    public static String m1293d(String str) {
        int indexOf;
        int indexOf2 = str.indexOf(62);
        if (indexOf2 == -1 || (indexOf = str.indexOf(60, indexOf2)) == -1) {
            return null;
        }
        return str.substring(indexOf2 + 1, indexOf);
    }

    /* renamed from: e */
    public static int m1294e(String str) {
        int length = str.length();
        int i2 = 0;
        while (str.charAt(i2) == ' ') {
            i2++;
            if (i2 == length) {
                return 0;
            }
        }
        return m1289a(str, i2, str.length());
    }

    /* renamed from: a */
    public String m1295a() {
        char charAt;
        int i2 = this.f2106d;
        int length = this.f2103a.length();
        while (i2 < length && (charAt = this.f2103a.charAt(i2)) != 0 && ((charAt < '0' || charAt > '9') && charAt != '-')) {
            i2++;
        }
        int i3 = i2 + 1;
        if (i3 > length) {
            i3 = length;
        }
        while (i3 < length) {
            char charAt2 = this.f2103a.charAt(i3);
            if ((charAt2 == 0 || charAt2 < '0' || charAt2 > '9') && charAt2 != '.') {
                break;
            }
            i3++;
        }
        this.f2106d = i3;
        return m1296a(i2, i3);
    }

    /* renamed from: a */
    public String m1296a(int i2, int i3) {
        return (this.f2104b != null ? this.f2104b : this.f2103a).substring(i2, i3);
    }

    @SuppressLint({"DefaultLocale"})
    /* renamed from: a */
    public final C0378r m1297a(String str) {
        if (this.f2105c) {
            this.f2104b = str;
            str = str.toLowerCase();
        } else {
            this.f2104b = null;
        }
        this.f2103a = str;
        this.f2106d = 0;
        return this;
    }

    /* renamed from: a */
    public void m1298a(int i2) {
        this.f2106d = i2;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r8v5 int, still in use, count: 2, list:
          (r8v5 int) from 0x0074: IF  (r8v5 int) != (-1 int)  -> B:18:0x005e A[HIDDEN]
          (r8v5 int) from 0x005e: PHI (r8v6 int) = (r8v5 int) binds: [B:22:0x0074] A[DONT_GENERATE, DONT_INLINE]
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:151)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:116)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:125)
        	at jadx.core.dex.visitors.regions.TernaryMod.processRegion(TernaryMod.java:62)
        	at jadx.core.dex.visitors.regions.TernaryMod.enterRegion(TernaryMod.java:45)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:67)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.TernaryMod.process(TernaryMod.java:35)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.process(IfRegionVisitor.java:34)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:30)
        */
    /* renamed from: b */
    public java.lang.String m1299b(java.lang.String r8) {
        /*
            r7 = this;
            int r0 = r7.f2106d
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "<"
            r1.append(r2)
            r1.append(r8)
            java.lang.String r1 = r1.toString()
            int r2 = r1.length()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "</"
            r3.append(r4)
            r3.append(r8)
            java.lang.String r8 = ">"
            r3.append(r8)
            java.lang.String r8 = r3.toString()
        L2d:
            java.lang.String r3 = r7.f2103a
            int r0 = r3.indexOf(r1, r0)
            r3 = 0
            r4 = -1
            if (r0 == r4) goto L77
            r7.f2107e = r0
            java.lang.String r5 = r7.f2103a
            int r0 = r0 + r2
            char r5 = r5.charAt(r0)
            r6 = 32
            if (r5 == r6) goto L55
            r6 = 9
            if (r5 == r6) goto L55
            r6 = 10
            if (r5 == r6) goto L55
            r6 = 13
            if (r5 == r6) goto L55
            r6 = 62
            if (r5 == r6) goto L55
            goto L2d
        L55:
            java.lang.String r1 = r7.f2103a
            int r8 = r1.indexOf(r8, r0)
            if (r8 == r4) goto L6c
            int r8 = r8 + r2
        L5e:
            int r8 = r8 + 2
            r7.f2106d = r8
            r7.f2107e = r0
            int r0 = r0 - r2
            int r8 = r7.f2106d
            java.lang.String r8 = r7.m1296a(r0, r8)
            return r8
        L6c:
            java.lang.String r8 = r7.f2103a
            java.lang.String r1 = "/>"
            int r8 = r8.indexOf(r1, r0)
            if (r8 == r4) goto L77
            goto L5e
        L77:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: types.C0378r.m1299b(java.lang.String):java.lang.String");
    }

    /* renamed from: b */
    public void m1300b(int i2) {
        this.f2106d += i2;
    }

    /* renamed from: c */
    public String m1301c(String str) {
        String m1299b = m1299b(str);
        return m1299b == null ? m1299b : m1293d(m1299b);
    }
}
