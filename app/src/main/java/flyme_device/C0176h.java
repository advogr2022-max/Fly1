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

/* renamed from: d.h */
/* loaded from: classes.dex */
public class C0176h extends AbstractC0174f {

    /* renamed from: c */
    public static final UUID f800c = UUID.fromString("00001101-0000-1000-8000-00805F9B34FB");

    /* renamed from: e */
    private String f802e;

    /* renamed from: g */
    private int f804g;

    /* renamed from: d */
    private boolean f801d = false;

    /* renamed from: f */
    private boolean f803f = true;

    /* renamed from: h */
    private long f805h = 0;

    /* renamed from: i */
    private final C0203a f806i = new C0203a(1000, 0.1f);

    /* renamed from: j */
    private C0170b f807j = null;

    /* renamed from: k */
    private int f808k = 0;

    /* renamed from: l */
    private int f809l = 0;

    /* renamed from: m */
    private long f810m = 0;

    public C0176h(Context context, InterfaceC0182n interfaceC0182n) {
        this.f782a = interfaceC0182n;
    }

    /* renamed from: a */
    private void m710a(final BluetoothDevice bluetoothDevice) {
        m685a(2);
        new Thread(new Runnable() { // from class: d.h.1
            @Override // java.lang.Runnable
            public void run() {
                C0172d.m666a("runDevice: " + bluetoothDevice.toString());
                BluetoothSocket m715b = C0176h.this.m715b(bluetoothDevice);
                C0172d.m666a("socket=" + m715b);
                if (m715b != null) {
                    C0176h.this.m711a(m715b);
                    C0176h.this.m685a(0);
                    C0176h.this.f809l = 0;
                } else {
                    C0176h.this.m718i();
                }
                C0172d.m666a("finish running.");
                if (C0176h.this.f801d) {
                    return;
                }
                C0176h.this.m716b(bluetoothDevice.getAddress());
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00a3, code lost:
    
        if (r11 != null) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00af, code lost:
    
        r11.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00ad, code lost:
    
        if (r11 == null) goto L34;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m711a(BluetoothSocket bluetoothSocket) {
        try {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bluetoothSocket.getInputStream()), 256);
                this.f807j = new C0170b(C0101l.f564an);
                while (!this.f801d) {
                    try {
                        String readLine = bufferedReader.readLine();
                        System.currentTimeMillis();
                        if (readLine != null) {
                            C0172d.m666a("@ " + readLine);
                            if (this.f807j.m649a(readLine)) {
                                if (this.f807j.f743m) {
                                    this.f782a.mo679a(this.f807j.f734d, this.f807j.f737g, this.f807j.f738h);
                                }
                                if (this.f807j.f742l) {
                                    int i2 = this.f807j.f735e;
                                    if (C0101l.f563am) {
                                        i2 -= C0173e.f776a;
                                    }
                                    this.f782a.mo680a(this.f807j.f732b, this.f807j.f733c, (short) i2, this.f807j.f738h, this.f807j.f736f);
                                }
                                m685a(3);
                            }
                        }
                    } catch (IOException e2) {
                        C0172d.m666a(e2.getMessage());
                        e2.printStackTrace();
                    } catch (Exception e3) {
                        C0172d.m666a(e3.getMessage());
                        e3.printStackTrace();
                    }
                }
                C0172d.m666a("Finishing readingLoop");
            } catch (IOException unused) {
                C0172d.m666a("temp sockets not created");
            }
            m685a(0);
        } catch (Throwable th) {
            if (bluetoothSocket != null) {
                try {
                    bluetoothSocket.close();
                } catch (IOException unused2) {
                }
            }
            m685a(0);
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
    public BluetoothSocket m715b(BluetoothDevice bluetoothDevice) {
        BluetoothSocket bluetoothSocket;
        BluetoothSocket bluetoothSocket2;
        if (this.f803f) {
            try {
                bluetoothSocket = bluetoothDevice.createRfcommSocketToServiceRecord(f800c);
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
                    bluetoothSocket2 = bluetoothDevice.createInsecureRfcommSocketToServiceRecord(f800c);
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
    public void m716b(final String str) {
        new Thread(new Runnable() { // from class: d.h.2
            @Override // java.lang.Runnable
            public void run() {
                C0172d.m666a("wait to reconnect...");
                synchronized (C0172d.f769a) {
                    try {
                        C0172d.f769a.wait(60000L);
                    } catch (InterruptedException unused) {
                    }
                }
                if (C0176h.this.f801d) {
                    C0172d.m666a("no more reconnect.");
                } else {
                    C0176h.this.mo686a(str);
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public void m718i() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || !defaultAdapter.isEnabled()) {
            m685a(4);
        } else if (this.f809l <= 0 || System.currentTimeMillis() - this.f810m >= this.f809l * 60000) {
            this.f809l++;
            this.f810m = System.currentTimeMillis();
            defaultAdapter.startDiscovery();
        }
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: a */
    public void mo684a() {
        this.f801d = true;
        synchronized (C0172d.f769a) {
            C0172d.f769a.notify();
        }
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: a */
    public void mo686a(String str) {
        this.f802e = str;
        this.f804g = -1;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || !defaultAdapter.isEnabled()) {
            m685a(4);
        }
        if (defaultAdapter == null) {
            mo684a();
        } else {
            m710a(defaultAdapter.getRemoteDevice(str));
        }
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: b */
    public boolean mo687b() {
        return this.f783b == 3;
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: c */
    public String mo688c() {
        return this.f802e;
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: d */
    public int mo689d() {
        return 7;
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: e */
    public String mo690e() {
        return "External BT";
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: f */
    public boolean mo691f() {
        return true;
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: g */
    public boolean mo692g() {
        return true;
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: h */
    public boolean mo693h() {
        return false;
    }
}
