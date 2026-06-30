package flyme_device;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.Build;
import com.xcglobe.xclog.C0101l;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;
import flyme_misc.C0203a;
import flyme_io.C0220c;
import flyme_data.C0239g;

/* renamed from: d.g */
/* loaded from: classes.dex */
public class C0175g extends AbstractC0174f {

    /* renamed from: c */
    public static final UUID f784c = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    /* renamed from: f */
    private String f787f;

    /* renamed from: h */
    private float f789h;

    /* renamed from: i */
    private int f790i;

    /* renamed from: d */
    private int f785d = 0;

    /* renamed from: e */
    private boolean f786e = false;

    /* renamed from: g */
    private boolean f788g = true;

    /* renamed from: j */
    private long f791j = 0;

    /* renamed from: k */
    private final C0203a f792k = new C0203a(1000, 0.1f);

    /* renamed from: l */
    private int f793l = 0;

    /* renamed from: m */
    private int f794m = 0;

    /* renamed from: n */
    private long f795n = 0;

    public C0175g(Context context, InterfaceC0182n interfaceC0182n) {
        this.f782a = interfaceC0182n;
    }

    /* renamed from: a */
    private void m696a(final BluetoothDevice bluetoothDevice) {
        this.f785d = 2;
        m685a(2);
        new Thread(new Runnable() { // from class: d.g.1
            @Override // java.lang.Runnable
            public void run() {
                C0172d.m666a("runDevice: " + bluetoothDevice.toString());
                BluetoothSocket m702b = C0175g.this.m702b(bluetoothDevice);
                C0172d.m666a("socket=" + m702b);
                if (m702b != null) {
                    C0175g.this.f785d = 3;
                    C0175g.this.m697a(m702b);
                    C0175g.this.f785d = 0;
                    C0175g.this.m685a(0);
                    C0175g.this.f794m = 0;
                } else {
                    C0175g.this.m707i();
                }
                C0172d.m666a("finish running.");
                if (C0175g.this.f786e) {
                    return;
                }
                C0175g.this.m703b(bluetoothDevice.getAddress());
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0060, code lost:
    
        if (r12 != null) goto L42;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x006c, code lost:
    
        r12.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x006a, code lost:
    
        if (r12 == null) goto L30;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m697a(BluetoothSocket bluetoothSocket) {
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bluetoothSocket.getInputStream()), 256);
                long j2 = 0;
                while (!this.f786e) {
                    try {
                        String readLine = bufferedReader.readLine();
                        long currentTimeMillis = System.currentTimeMillis();
                        if (readLine != null) {
                            if (!m706d(readLine)) {
                                m705c(readLine);
                            } else if (currentTimeMillis - j2 >= 50) {
                                float f2 = this.f789h;
                                this.f792k.mo866a(f2, currentTimeMillis);
                                float f3 = this.f792k.f1046c;
                                this.f782a.mo679a(C0239g.f1370A.m1053a(f2), f3, currentTimeMillis);
                                if (this.f785d != 4) {
                                    this.f785d = 4;
                                    m685a(3);
                                }
                                j2 = currentTimeMillis;
                            }
                        }
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            } catch (IOException unused) {
                C0172d.m666a("temp sockets not created");
            }
            this.f785d = 0;
        } catch (Throwable th) {
            if (bluetoothSocket != null) {
                try {
                    bluetoothSocket.close();
                } catch (IOException unused2) {
                }
            }
            this.f785d = 0;
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:5:0x0021  */
    @SuppressLint({"NewApi"})
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public BluetoothSocket m702b(BluetoothDevice bluetoothDevice) {
        BluetoothSocket bluetoothSocket;
        BluetoothSocket bluetoothSocket2;
        if (this.f788g) {
            try {
                bluetoothSocket = bluetoothDevice.createRfcommSocketToServiceRecord(f784c);
                if (bluetoothSocket != null) {
                    try {
                        bluetoothSocket.connect();
                    } catch (IOException unused) {
                        if (bluetoothSocket != null) {
                            try {
                                bluetoothSocket.close();
                            } catch (Exception unused2) {
                            }
                        }
                        C0172d.m666a("socket pairing failed");
                        bluetoothSocket = null;
                        if (bluetoothSocket == null) {
                        }
                        bluetoothSocket2 = bluetoothSocket;
                        if (bluetoothSocket2 != null) {
                        }
                        return bluetoothSocket2;
                    }
                }
            } catch (IOException unused3) {
                bluetoothSocket = null;
            }
            if (bluetoothSocket == null || Build.VERSION.SDK_INT < 10) {
                bluetoothSocket2 = bluetoothSocket;
            } else {
                try {
                    bluetoothSocket2 = bluetoothDevice.createInsecureRfcommSocketToServiceRecord(f784c);
                    if (bluetoothSocket2 != null) {
                        try {
                            bluetoothSocket2.connect();
                        } catch (IOException unused4) {
                            bluetoothSocket = bluetoothSocket2;
                            if (bluetoothSocket != null) {
                                try {
                                    bluetoothSocket.close();
                                } catch (Exception unused5) {
                                }
                            }
                            C0172d.m666a("secket no-pairing failed");
                            bluetoothSocket2 = null;
                            if (bluetoothSocket2 != null) {
                            }
                            return bluetoothSocket2;
                        }
                    }
                } catch (IOException unused6) {
                }
            }
            if (bluetoothSocket2 != null) {
                C0172d.m666a("secket created");
            }
            return bluetoothSocket2;
        }
        bluetoothSocket = null;
        if (bluetoothSocket == null) {
        }
        bluetoothSocket2 = bluetoothSocket;
        if (bluetoothSocket2 != null) {
        }
        return bluetoothSocket2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m703b(final String str) {
        new Thread(new Runnable() { // from class: d.g.2
            @Override // java.lang.Runnable
            public void run() {
                C0172d.m666a("wait to reconnect...");
                synchronized (C0172d.f769a) {
                    try {
                        C0172d.f769a.wait(60000L);
                    } catch (InterruptedException unused) {
                    }
                }
                if (C0175g.this.f786e) {
                    C0172d.m666a("no more reconnect.");
                } else {
                    C0175g.this.mo686a(str);
                }
            }
        }).start();
    }

    /* renamed from: c */
    private boolean m705c(String str) {
        if (!str.startsWith("$GPGGA") || str.length() < 11) {
            if (!str.startsWith("$GPRMC") || str.length() < 9) {
                return false;
            }
            String[] split = str.split(",");
            if (split.length >= 8 && split[7].length() > 0) {
                this.f790i = (int) (C0101l.m573i(split[7]) * 1.852f);
                this.f791j = System.currentTimeMillis();
            }
            return true;
        }
        String[] split2 = str.split(",");
        if (split2.length < 10) {
            return true;
        }
        float m944a = C0220c.m944a(split2[2], 0, 2) + (C0101l.m573i(split2[2].substring(2)) / 60.0f);
        if (split2[3].equals("S")) {
            m944a = -m944a;
        }
        float f2 = m944a;
        float m944a2 = C0220c.m944a(split2[4], split2[4].charAt(0) == '0' ? 1 : 0, 3) + (C0101l.m573i(split2[4].substring(3)) / 60.0f);
        if (split2[5].equals("W")) {
            m944a2 -= m944a2;
        }
        float f3 = m944a2;
        float m573i = split2[9].length() > 0 ? C0101l.m573i(split2[9]) + C0101l.m573i(split2[11]) : 0.0f;
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f791j > 3000) {
            this.f790i = -1;
        }
        this.f782a.mo680a(f2, f3, (short) m573i, currentTimeMillis, this.f790i);
        return true;
    }

    /* renamed from: d */
    private boolean m706d(String str) {
        float f2 = 0.0f;
        if (str.startsWith("PRS") && str.length() >= 9) {
            f2 = Integer.parseInt(str.substring(4, 9), 16);
            this.f793l = 0;
        } else if (str.startsWith("_PRS") && str.length() >= 10) {
            f2 = Integer.parseInt(str.substring(5, 10), 16);
            this.f793l = 3;
        } else {
            if (!str.startsWith("$LK8EX1,")) {
                if (str.startsWith("$LXWP0,")) {
                    String[] split = str.split(",");
                    if (split.length >= 4) {
                        this.f789h = C0101l.m573i(split[3]);
                        this.f793l = 2;
                        return true;
                    }
                }
                return false;
            }
            int indexOf = str.indexOf(44, 8);
            if (indexOf != -1) {
                f2 = Integer.parseInt(str.substring(8, indexOf), 10);
                this.f793l = 1;
            }
        }
        double d2 = f2;
        Double.isNaN(d2);
        this.f789h = (float) ((1.0d - Math.pow(d2 / 101325.0d, 0.190295d)) * 44330.0d);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m707i() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || !defaultAdapter.isEnabled()) {
            m685a(4);
        } else if (this.f794m <= 0 || System.currentTimeMillis() - this.f795n >= this.f794m * 60000) {
            this.f794m++;
            this.f795n = System.currentTimeMillis();
            defaultAdapter.startDiscovery();
        }
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: a */
    public void mo684a() {
        this.f786e = true;
        synchronized (C0172d.f769a) {
            C0172d.f769a.notify();
        }
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: a */
    public void mo686a(String str) {
        this.f787f = str;
        this.f790i = -1;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || !defaultAdapter.isEnabled()) {
            m685a(4);
        }
        if (defaultAdapter == null) {
            mo684a();
        } else {
            m696a(defaultAdapter.getRemoteDevice(str));
        }
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: b */
    public boolean mo687b() {
        return this.f785d == 4;
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: c */
    public String mo688c() {
        return this.f787f;
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: d */
    public int mo689d() {
        return 2;
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: e */
    public String mo690e() {
        switch (this.f793l) {
            case 0:
                return "BlueFlyVario";
            case 1:
                return "LK8EX1";
            case 2:
                return "LXWP0";
            case 3:
                return "FlyNet";
            default:
                return "External";
        }
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: f */
    public boolean mo691f() {
        return true;
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: g */
    public boolean mo692g() {
        return false;
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: h */
    public boolean mo693h() {
        return false;
    }
}
