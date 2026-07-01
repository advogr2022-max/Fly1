package flyme_io;

import android.util.Log;
import com.xcglobe.xclog.C0095f;
import com.xcglobe.xclog.C0099j;
import com.xcglobe.xclog.C0101l;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.zip.CRC32;
import java.util.zip.Checksum;
import flyme_apphelper.C0072a;
import flyme_io.flyme_io_b.C0218a;
import flyme_data.C0233a;
import types.GpsVal;

/* renamed from: i.d */
/* loaded from: classes.dex */
public class C0221d {

    /* renamed from: a */
    public final int f1233a;

    /* renamed from: b */
    public final int f1234b;

    /* renamed from: c */
    public GpsVal f1235c;

    /* renamed from: d */
    private final SimpleDateFormat f1236d;

    /* renamed from: e */
    private String f1237e;

    /* renamed from: f */
    private String f1238f;

    /* renamed from: g */
    private OutputStream f1239g;

    /* renamed from: h */
    private long f1240h;

    /* renamed from: i */
    private Checksum f1241i;

    /* renamed from: j */
    private PrivateKey f1242j;

    /* renamed from: k */
    private long f1243k;

    public C0221d() {
        this.f1233a = 0;
        this.f1234b = 2;
        this.f1236d = new SimpleDateFormat("HHmmss", Locale.US);
        this.f1238f = null;
        this.f1239g = null;
        this.f1243k = 0L;
        m955f();
    }

    public C0221d(String str) {
        this.f1233a = 0;
        this.f1234b = 2;
        this.f1236d = new SimpleDateFormat("HHmmss", Locale.US);
        this.f1238f = null;
        this.f1239g = null;
        this.f1243k = 0L;
        this.f1238f = str;
        m955f();
    }

    /* renamed from: a */
    private String m952a(String str) {
        return str.replace('\r', ' ').replace('\n', ' ').trim();
    }

    /* renamed from: a */
    private boolean m953a(long j2) {
        String str;
        String message;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH-mm", Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        this.f1237e = simpleDateFormat.format(Calendar.getInstance().getTime()) + ".igc";
        String str2 = this.f1237e.substring(8, 10) + this.f1237e.substring(5, 7) + this.f1237e.substring(2, 4);
        if (C0072a.m378a()) {
            this.f1237e = "demo-track.igc";
            C0101l.m559c(this.f1237e);
        }
        if (this.f1238f != null) {
            this.f1237e = this.f1238f;
            C0101l.m559c(this.f1237e);
        }
        try {
            this.f1239g = new FileOutputStream(new File(C0101l.m558c() + "/" + this.f1237e));
            C0099j.m527d("igc_recording_name", this.f1237e);
            StringBuilder sb = new StringBuilder();
            sb.append("AXFLXCglobe FlyMe for Android\n");
            sb.append("HFDTE" + str2 + "\n");
            sb.append("HFRFW:" + C0095f.m466a(true) + "\n");
            sb.append("HFRHW:" + C0095f.m463a() + "\n");
            sb.append("HFPRS:Baro/" + C0233a.m1031c() + "/" + C0233a.m1032d() + "\n");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("HFFTY:");
            sb2.append(C0095f.m469b());
            sb2.append("\n");
            sb.append(sb2.toString());
            sb.append("HFPLTPILOT:" + m952a(C0099j.m515a("user.fullname")) + "\n");
            sb.append("HFGTYGLIDERTYPE:" + m952a(C0099j.m515a("user.glider")) + "\n");
            sb.append("HFGIDGLIDERID:" + m952a(C0099j.m515a("user.civlid")) + "\n");
            sb.append("HFDTM100GPSDATUM:WGS-84\n");
            byte[] bytes = sb.toString().getBytes();
            this.f1239g.write(bytes);
            this.f1241i = new CRC32();
            this.f1241i.update(bytes, 0, bytes.length);
            this.f1240h = 0L;
            this.f1235c.f1975d = 0L;
            return true;
        } catch (FileNotFoundException e2) {
            C0101l.m556b(e2.getMessage(), true);
            str = "openIgc";
            message = e2.getMessage();
            C0101l.m547a(str, message);
            return false;
        } catch (IOException e3) {
            C0101l.m556b(e3.getMessage(), true);
            str = "openIgc";
            message = e3.getMessage();
            C0101l.m547a(str, message);
            return false;
        }
    }

    /* renamed from: b */
    private void m954b(GpsVal gpsVal, int i2) {
        String format;
        if (this.f1239g == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("B");
        sb.append(this.f1236d.format(new Date(gpsVal.f1975d)));
        sb.append(m959a(gpsVal.f1972a, true));
        sb.append(m959a(gpsVal.f1973b, false));
        if (i2 == 0) {
            format = "A00000";
        } else {
            sb.append("A");
            format = String.format(Locale.US, "%05d", Integer.valueOf(i2));
        }
        sb.append(format);
        sb.append(String.format(Locale.US, "%05d", Short.valueOf(gpsVal.f1974c)));
        sb.append("\n");
        try {
            byte[] bytes = sb.toString().getBytes();
            this.f1239g.write(bytes);
            this.f1241i.update(bytes, 0, bytes.length);
        } catch (IOException e2) {
            C0101l.m547a("crash", Log.getStackTraceString(e2));
        }
    }

    /* renamed from: f */
    private void m955f() {
        this.f1235c = new GpsVal();
        m956g();
        m965e();
        this.f1236d.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    /* renamed from: g */
    private void m956g() {
        this.f1235c.f1972a = 0.0f;
        this.f1235c.f1973b = 0.0f;
        this.f1235c.f1975d = 0L;
        this.f1240h = 0L;
    }

    /* renamed from: h */
    private boolean m957h() {
        boolean z = false;
        if (this.f1239g != null) {
            try {
                StringBuilder sb = new StringBuilder();
                new SimpleDateFormat("yyyy-MM-dd-HH-mm", Locale.US).setTimeZone(TimeZone.getTimeZone("UTC"));
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm", Locale.US);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
                sb.append("LXFLHFUTCTIME:" + simpleDateFormat.format(new Date()) + "\n");
                simpleDateFormat.setTimeZone(TimeZone.getDefault());
                sb.append("LXFLHFLOCALTIME:" + simpleDateFormat.format(new Date()) + "\n");
                sb.append("LXFLHFCHK:" + this.f1241i.getValue() + "\n");
                byte[] bytes = sb.toString().getBytes();
                this.f1239g.write(bytes);
                this.f1241i.update(bytes, 0, bytes.length);
                m964d();
                this.f1239g.close();
                long j2 = (this.f1235c.f1975d - this.f1240h) / 1000;
                if (j2 > 60) {
                    C0099j.m523b(this.f1237e, "duration", C0101l.m534a((int) j2, 0));
                    z = true;
                } else {
                    C0101l.m559c(this.f1237e);
                }
            } catch (Exception e2) {
                C0101l.m556b(e2.getMessage(), true);
            }
        }
        this.f1239g = null;
        return z;
    }

    /* renamed from: a */
    public int m958a(GpsVal gpsVal, int i2) {
        int i3;
        if (this.f1239g == null) {
            m953a(gpsVal.f1975d);
            this.f1240h = gpsVal.f1975d;
            i3 = 2;
        } else {
            i3 = 0;
        }
        m954b(gpsVal, i2);
        this.f1235c.f1972a = gpsVal.f1972a;
        this.f1235c.f1973b = gpsVal.f1973b;
        GpsVal gpsVal2 = this.f1235c;
        long j2 = gpsVal.f1975d;
        gpsVal2.f1975d = j2;
        if (j2 > this.f1243k) {
            C0099j.m527d("igc_recording_time", "" + gpsVal.f1975d);
            this.f1243k = gpsVal.f1975d + 540000;
        }
        return i3;
    }

    /* renamed from: a */
    String m959a(double d2, boolean z) {
        StringBuilder sb;
        String str;
        boolean z2 = d2 < 0.0d;
        double abs = Math.abs(d2);
        int i2 = (int) abs;
        String str2 = i2 < 10 ? "0" : "";
        if (!z && i2 < 100) {
            str2 = str2 + "0";
        }
        String str3 = str2 + i2;
        double d3 = i2;
        Double.isNaN(d3);
        double d4 = (abs - d3) * 60.0d;
        int i3 = (int) d4;
        if (i3 < 10) {
            str3 = str3 + "0";
        }
        String str4 = str3 + i3;
        double d5 = i3;
        Double.isNaN(d5);
        int i4 = (int) ((d4 - d5) * 1000.0d);
        if (i4 < 100) {
            str4 = str4 + "0";
        }
        if (i4 < 10) {
            str4 = str4 + "0";
        }
        String str5 = str4 + i4;
        if (z) {
            if (str5.length() > 7) {
                str5 = str5.substring(0, 7);
            }
            if (z2) {
                sb = new StringBuilder();
                sb.append(str5);
                str = "S";
            } else {
                sb = new StringBuilder();
                sb.append(str5);
                str = "N";
            }
        } else {
            if (str5.length() > 8) {
                str5 = str5.substring(0, 8);
            }
            if (z2) {
                sb = new StringBuilder();
                sb.append(str5);
                str = "W";
            } else {
                sb = new StringBuilder();
                sb.append(str5);
                str = "E";
            }
        }
        sb.append(str);
        return sb.toString();
    }

    /* renamed from: a */
    public boolean m960a() {
        return this.f1239g != null;
    }

    /* renamed from: a */
    public boolean m961a(String str, CRC32 crc32) {
        this.f1237e = str;
        String str2 = C0101l.m558c() + "/" + this.f1237e;
        if (!new File(str2).isFile()) {
            return false;
        }
        try {
            this.f1239g = new FileOutputStream(str2, true);
            if (this.f1239g == null) {
                return false;
            }
            this.f1241i = crc32;
            return true;
        } catch (FileNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: b */
    public final String m962b() {
        return this.f1237e;
    }

    /* renamed from: c */
    public boolean m963c() {
        boolean m957h = m957h();
        m956g();
        this.f1237e = null;
        return m957h;
    }

    /* renamed from: d */
    void m964d() {
        if ("demo-track.igc".equals(this.f1237e) || "demo-task.igc".equals(this.f1237e)) {
            return;
        }
        try {
            String str = "G" + this.f1241i.getValue() + "\n";
            Signature signature = Signature.getInstance("SHA1withDSA");
            signature.initSign(this.f1242j);
            signature.update(str.getBytes());
            String m933a = C0218a.m933a(signature.sign());
            this.f1239g.write(("G" + m933a + "\n").getBytes());
        } catch (Exception e2) {
            try { this.f1239g.write("LXFLCANTSIGN\n".getBytes()); } catch (IOException e3) { }
            C0101l.m547a("grecord", e2.getMessage());
        }
    }

    /* renamed from: e */
    public void m965e() {
        try {
            byte[] m936a = C0218a.m936a("MIHGAgEAMIGoBgcqhkjOOAQBMIGcAkEA/KaCzo4Syrom78z3EQ5SbbB4sF7ey80etKII864WF64B81uRpH5t9jQTxeEu0ImbzRMqzVDZkVG9xD7nN1kuFwIVAJYu3cw2nLqOuyYO5rahJtk0bjjFAkBnhHGyepz0TukaScUUfbGpqvJE8FpDTWSGkx0tFCcbnjUDC3H9c9oXkGmzLik1Yw4cIGI1TQ2iCmxBblC+eUykBBYCFEXbB+xzx0/P8X5tRAWUf3G+9YDZ");
            this.f1242j = KeyFactory.getInstance("DSA").generatePrivate(new PKCS8EncodedKeySpec(m936a));
            Arrays.fill(m936a, (byte) 0);
        } catch (Exception unused) {
        }
    }
}
