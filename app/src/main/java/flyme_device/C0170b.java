package flyme_device;

import com.xcglobe.xclog.C0101l;
import flyme_misc.C0203a;
import flyme_io.C0220c;
import flyme_data.C0239g;

/* renamed from: d.b */
/* loaded from: classes.dex */
public class C0170b {

    /* renamed from: a */
    public final boolean f731a;

    /* renamed from: b */
    public float f732b;

    /* renamed from: c */
    public float f733c;

    /* renamed from: d */
    public float f734d;

    /* renamed from: e */
    public int f735e;

    /* renamed from: f */
    public int f736f;

    /* renamed from: g */
    public float f737g;

    /* renamed from: h */
    public long f738h;

    /* renamed from: i */
    public int f739i;

    /* renamed from: j */
    public int f740j;

    /* renamed from: k */
    public long f741k;

    /* renamed from: l */
    public boolean f742l;

    /* renamed from: m */
    public boolean f743m;

    /* renamed from: n */
    public long f744n;

    /* renamed from: o */
    private long f745o;

    /* renamed from: p */
    private final C0203a f746p;

    public C0170b() {
        this.f740j = 0;
        this.f742l = false;
        this.f743m = false;
        this.f744n = 0L;
        this.f745o = 0L;
        this.f746p = new C0203a(1000, 0.1f);
        this.f731a = false;
    }

    public C0170b(boolean z) {
        this.f740j = 0;
        this.f742l = false;
        this.f743m = false;
        this.f744n = 0L;
        this.f745o = 0L;
        this.f746p = new C0203a(1000, 0.1f);
        this.f731a = z;
    }

    /* renamed from: a */
    private float m637a(float f2) {
        double d2 = f2;
        Double.isNaN(d2);
        return (float) ((1.0d - Math.pow(d2 / 101325.0d, 0.190295d)) * 44330.0d);
    }

    /* renamed from: a */
    private void m638a() {
        this.f746p.mo866a(this.f734d, this.f738h);
        this.f737g = this.f746p.f1046c;
    }

    /* renamed from: a */
    private boolean m639a(String str, boolean z) {
        String[] split = str.split(",");
        if (split.length < 10 || split[9].length() == 0 || split[2].length() == 0) {
            return false;
        }
        this.f735e = (int) C0101l.m573i(split[9]);
        if (z && !this.f731a) {
            this.f735e += (int) C0101l.m573i(split[11]);
        }
        this.f732b = C0220c.m944a(split[2], 0, 2) + (C0101l.m573i(split[2].substring(2)) / 60.0f);
        if (split[3].equals("S")) {
            this.f732b = -this.f732b;
        }
        this.f733c = C0220c.m944a(split[4], split[4].charAt(0) == '0' ? 1 : 0, 3) + (C0101l.m573i(split[4].substring(3)) / 60.0f);
        if (split[5].equals("W")) {
            this.f733c -= this.f733c;
        }
        if (this.f738h - this.f745o > 2000) {
            this.f736f = -1;
        }
        this.f742l = true;
        this.f740j = 5;
        return true;
    }

    /* renamed from: b */
    private boolean m640b(String str) {
        String[] split = str.split(",");
        if (split.length < 17) {
            return false;
        }
        this.f734d = C0101l.m573i(split[10]);
        this.f737g = C0101l.m573i(split[13]);
        if (split[8].length() > 0) {
            this.f732b = C0101l.m573i(split[8]);
            this.f733c = C0101l.m573i(split[9]);
            if (this.f732b != 0.0f && this.f733c != 0.0f) {
                this.f736f = (int) (C0101l.m573i(split[11]) * 3.6f);
                this.f735e = (int) this.f734d;
                this.f742l = true;
            }
        }
        this.f743m = true;
        this.f739i = 4;
        return true;
    }

    /* renamed from: c */
    private boolean m641c(String str) {
        String[] split = str.split(",");
        if (split.length < 10 || split[4].length() < 1) {
            return false;
        }
        this.f737g = C0101l.m573i(split[4]);
        this.f734d = C0101l.m573i(split[3]);
        this.f734d = C0239g.f1370A.m1053a(this.f734d);
        this.f743m = true;
        this.f739i = 2;
        return true;
    }

    /* renamed from: d */
    private boolean m642d(String str) {
        if (str.length() < 9) {
            return false;
        }
        this.f734d = m637a(Integer.parseInt(str.substring(4, 9), 16));
        m638a();
        this.f734d = C0239g.f1370A.m1053a(this.f734d);
        this.f743m = true;
        this.f739i = 0;
        return true;
    }

    /* renamed from: e */
    private boolean m643e(String str) {
        if (str.length() < 10) {
            return false;
        }
        this.f734d = m637a(Integer.parseInt(str.substring(5, 10), 16));
        m638a();
        this.f734d = C0239g.f1370A.m1053a(this.f734d);
        this.f743m = true;
        this.f739i = 3;
        return true;
    }

    /* renamed from: f */
    private boolean m644f(String str) {
        float m944a;
        String[] split = str.split(",");
        if (split.length < 4) {
            return false;
        }
        float parseInt = Integer.parseInt(split[1]);
        if (parseInt != 999999.0f) {
            m944a = m637a(parseInt);
        } else {
            if (split[2].length() <= 0 || split[2].equals("999999")) {
                return false;
            }
            m944a = C0220c.m944a(split[2], 0, split[2].length());
        }
        this.f734d = m944a;
        if (split[3].length() <= 0 || split[3].equals("9999")) {
            m638a();
        } else {
            this.f737g = C0220c.m944a(split[3], 0, split[3].length()) / 100.0f;
        }
        this.f734d = C0239g.f1370A.m1053a(this.f734d);
        this.f743m = true;
        this.f739i = 1;
        return true;
    }

    /* renamed from: g */
    private boolean m645g(String str) {
        if (str.length() < 9) {
            return false;
        }
        String[] split = str.split(",");
        if (split.length < 8 || split[7].length() == 0 || split[2].equals("V")) {
            return false;
        }
        this.f736f = (int) (C0101l.m573i(split[7]) * 1.852f);
        this.f745o = this.f738h;
        return true;
    }

    /* renamed from: h */
    private boolean m646h(String str) {
        String[] split = str.split(",");
        if (split.length < 7) {
            return false;
        }
        double m573i = C0101l.m573i(split[2]);
        Double.isNaN(m573i);
        this.f734d = (float) (m573i * 0.3048d);
        this.f734d = C0239g.f1370A.m1053a(this.f734d);
        this.f737g = (C0101l.m573i(split[6]) * 0.3048f) / 60.0f;
        this.f743m = true;
        return true;
    }

    /* renamed from: i */
    private boolean m647i(String str) {
        this.f742l = false;
        String[] split = str.split(";");
        if (split.length < 3) {
            return false;
        }
        this.f737g = C0101l.m573i(split[4]);
        this.f734d = m637a(C0101l.m573i(split[2]) * 100.0f);
        this.f734d = C0239g.f1370A.m1053a(this.f734d);
        this.f743m = true;
        this.f739i = 7;
        return true;
    }

    /* renamed from: j */
    private boolean m648j(String str) {
        this.f737g = C0101l.m573i(str.substring(7, str.indexOf(42, 7)));
        this.f743m = true;
        this.f739i = 8;
        return true;
    }

    /* renamed from: a */
    public boolean m649a(String str) {
        long currentTimeMillis = System.currentTimeMillis();
        this.f741k = currentTimeMillis - this.f738h;
        if (this.f741k < this.f744n) {
            return false;
        }
        this.f738h = currentTimeMillis;
        this.f740j = -1;
        this.f739i = -1;
        this.f742l = false;
        this.f743m = false;
        if (str.startsWith("$XCTRC,")) {
            return m640b(str);
        }
        if (str.startsWith("$LXWP0,")) {
            return m641c(str);
        }
        if (str.startsWith("$LK8EX1,")) {
            return m644f(str);
        }
        if (str.startsWith("PRS")) {
            return m642d(str);
        }
        if (str.startsWith("_PRS")) {
            return m643e(str);
        }
        if (str.startsWith("$GPGGA")) {
            return m639a(str, true);
        }
        if (str.startsWith("$GPRMC")) {
            return m645g(str);
        }
        if (str.startsWith("$GNGGA")) {
            return m639a(str, false);
        }
        if (str.startsWith("$GNRMC")) {
            return m645g(str);
        }
        if (str.startsWith("$POV,E,")) {
            return m648j(str);
        }
        if (str.startsWith("$APENV1")) {
            return m646h(str);
        }
        if (str.startsWith("$FLYSYS;")) {
            return m647i(str);
        }
        return false;
    }
}
