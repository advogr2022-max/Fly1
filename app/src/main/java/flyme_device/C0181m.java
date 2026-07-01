package flyme_device;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Handler;
import java.util.UUID;

@SuppressLint({"NewApi"})
/* renamed from: d.m */
/* loaded from: classes.dex */
public class C0181m extends AbstractC0174f {

    /* renamed from: i */
    private static final UUID f896i = UUID.fromString("0000ffe0-0000-1000-8000-00805f9b34fb");

    /* renamed from: j */
    private static final UUID f897j = UUID.fromString("0000ffe1-0000-1000-8000-00805f9b34fb");

    /* renamed from: k */
    private static final UUID f898k = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");

    /* renamed from: m */
    private static int f899m = 0;

    /* renamed from: v */
    private static C0170b f900v = new C0170b();

    /* renamed from: n */
    private BluetoothGattCharacteristic f908n;

    /* renamed from: o */
    private BluetoothGatt f909o;

    /* renamed from: p */
    private String f910p;

    /* renamed from: t */
    private Context f914t;

    /* renamed from: d */
    private final long f902d = 10000;

    /* renamed from: e */
    private final long f903e = 1000;

    /* renamed from: f */
    private final long f904f = 5000;

    /* renamed from: g */
    private final long f905g = 10000;

    /* renamed from: h */
    private final long f906h = 10000;

    /* renamed from: l */
    private boolean f907l = false;

    /* renamed from: q */
    private long f911q = 0;

    /* renamed from: r */
    private long f912r = 0;

    /* renamed from: s */
    private final Handler f913s = new Handler();

    /* renamed from: u */
    private StringBuilder f915u = new StringBuilder();

    /* renamed from: c */
    a f901c = new a();

    /* renamed from: w */
    private Runnable f916w = new Runnable() { // from class: d.m.1
        @Override // java.lang.Runnable
        public void run() {
            String str;
            C0172d.m666a("starting looper..., state=" + C0181m.f899m);
            if (C0181m.this.f907l) {
                C0172d.m666a("terminating");
                return;
            }
            long j2 = 10000;
            if (C0181m.f899m == 3) {
                if (C0181m.this.f912r != 0 && System.currentTimeMillis() - C0181m.this.f912r > 10000) {
                    str = "disconnecting (timeLastUpdate>MAX_UNRESPONSIVE_TIME";
                    C0172d.m666a(str);
                    C0181m.this.m807l();
                }
                C0172d.m666a("waiting for: " + j2 + " state=" + C0181m.f899m);
                C0181m.this.f913s.postDelayed(this, j2);
            }
            if (C0181m.f899m == 1 || C0181m.f899m == 2) {
                C0172d.m666a("state=" + C0181m.f899m);
                long currentTimeMillis = System.currentTimeMillis();
                if (C0181m.this.f911q <= 0 || currentTimeMillis - C0181m.this.f911q <= 10000) {
                    j2 = 1000;
                } else {
                    str = "disconnecting (timeStartSearching>MAX_SEARCHING_TIME";
                    C0172d.m666a(str);
                    C0181m.this.m807l();
                }
            } else if (C0181m.f899m == 0) {
                C0172d.m666a("state=" + C0181m.f899m + "  t=" + (System.currentTimeMillis() / 1000));
                C0181m.this.m795a(C0181m.this.f910p, false);
                j2 = 60000;
            } else {
                j2 = 200;
            }
            C0172d.m666a("waiting for: " + j2 + " state=" + C0181m.f899m);
            C0181m.this.f913s.postDelayed(this, j2);
        }
    };

    /* renamed from: x */
    private int f917x = 0;

    /* renamed from: y */
    private long f918y = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d.m$a */
    /* loaded from: classes.dex */
    public class a extends BluetoothGattCallback {
        a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            C0181m.this.m790a(bluetoothGatt, bluetoothGattCharacteristic);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
            if (i2 == 0) {
                BluetoothGattCharacteristic unused = C0181m.this.f908n;
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
            C0172d.m666a("GATTCBACK onCharacteristicWrite");
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i2, int i3) {
            C0181m.this.m789a(bluetoothGatt, i2, i3);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i2) {
            C0181m.this.m788a(bluetoothGatt, i2);
        }
    }

    public C0181m(Context context, InterfaceC0182n interfaceC0182n) {
        this.f782a = interfaceC0182n;
        this.f914t = context;
        f899m = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m788a(BluetoothGatt bluetoothGatt, int i2) {
        if (i2 != 0) {
            return;
        }
        for (BluetoothGattService bluetoothGattService : bluetoothGatt.getServices()) {
            C0172d.m666a("GATTCBACK Service discovered: " + bluetoothGattService.toString());
            BluetoothGattCharacteristic characteristic = bluetoothGattService.getCharacteristic(f897j);
            if (characteristic != null) {
                C0172d.m666a("CHAR: " + characteristic.toString());
                if (bluetoothGatt.setCharacteristicNotification(characteristic, true)) {
                    this.f909o = bluetoothGatt;
                    this.f908n = characteristic;
                    BluetoothGattDescriptor descriptor = characteristic.getDescriptor(f898k);
                    descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                    bluetoothGatt.writeDescriptor(descriptor);
                    f899m = 3;
                    return;
                }
            }
        }
        bluetoothGatt.close();
        f899m = 5;
        C0172d.m666a("Service discovery: unknown");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m789a(BluetoothGatt bluetoothGatt, int i2, int i3) {
        String str = null;
        C0172d.m666a("GATTCBACK Connection state: " + i3);
        if (i3 == 2) {
            f899m = 2;
            m685a(2);
            bluetoothGatt.discoverServices();
            str = "Connected to GATT server.";
        } else if (i3 == 0) {
            m807l();
            str = "Disconnected from GATT server.";
        }
        C0172d.m666a(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m790a(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
        for (byte b2 : bluetoothGattCharacteristic.getValue()) {
            int intValue = Integer.valueOf(b2 & 255).intValue();
            if (intValue != 13 && intValue != 10) {
                if (intValue == 36 && this.f915u.length() > 0) {
                    m799b(this.f915u.toString());
                    this.f915u.setLength(0);
                }
                this.f915u.append((char) intValue);
            } else if (this.f915u.length() > 0) {
                m799b(this.f915u.toString());
                this.f915u.setLength(0);
            }
        }
        C0172d.m666a("GATTCBACK CharacteristicChanged, len=" + bluetoothGattCharacteristic.getValue().length + " / " + this.f915u.length());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m795a(String str, boolean z) {
        this.f910p = str;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || !defaultAdapter.isEnabled()) {
            m685a(4);
            C0172d.m666a("BT disabled");
            return;
        }
        this.f911q = System.currentTimeMillis();
        BluetoothGatt bluetoothGatt = null;
        BluetoothDevice remoteDevice = defaultAdapter.getRemoteDevice(str);
        if (remoteDevice != null) {
            bluetoothGatt = remoteDevice.connectGatt(this.f914t, false, this.f901c);
            if (bluetoothGatt == null) {
                m808m();
            } else {
                this.f917x = 0;
                if (!m796a(bluetoothGatt, this.f909o)) {
                    m809i();
                }
                this.f909o = bluetoothGatt;
            }
        }
        C0172d.m666a("connecting. device=" + remoteDevice + "  gatt=" + bluetoothGatt);
        if (bluetoothGatt == null) {
            m685a(0);
            return;
        }
        m685a(2);
        f899m = 1;
        if (z) {
            m806k();
        }
    }

    /* renamed from: a */
    private boolean m796a(BluetoothGatt bluetoothGatt, BluetoothGatt bluetoothGatt2) {
        String address;
        if (bluetoothGatt == bluetoothGatt2) {
            return true;
        }
        if (bluetoothGatt == null || bluetoothGatt2 == null || (address = bluetoothGatt.getDevice().getAddress()) == null) {
            return false;
        }
        return address.equals(bluetoothGatt2.getDevice().getAddress());
    }

    /* renamed from: b */
    private void m799b(String str) {
        if (f900v.m649a(str)) {
            if (f900v.f743m) {
                this.f782a.mo679a(f900v.f734d, f900v.f737g, f900v.f738h);
            }
            if (f900v.f742l) {
                this.f782a.mo680a(f900v.f732b, f900v.f733c, (short) f900v.f735e, f900v.f738h, f900v.f736f);
            }
            this.f912r = f900v.f738h;
            m685a(3);
        }
    }

    /* renamed from: k */
    private void m806k() {
        this.f913s.removeCallbacks(this.f916w);
        this.f913s.postDelayed(this.f916w, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public void m807l() {
        f899m = 0;
        m809i();
        this.f908n = null;
        this.f912r = 0L;
        this.f911q = 0L;
        m685a(0);
    }

    /* renamed from: m */
    private void m808m() {
        if (this.f917x <= 0 || System.currentTimeMillis() - this.f918y >= this.f917x * 60000) {
            this.f917x++;
            this.f918y = System.currentTimeMillis();
            C0172d.m666a("start scan devices: " + new C0169a(null).m636a(5000L, false));
        }
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: a */
    public synchronized void mo684a() {
        m807l();
        this.f907l = true;
        f899m = 4;
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: a */
    public void mo686a(String str) {
        m795a(str, true);
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: b */
    public boolean mo687b() {
        return f899m == 3;
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: c */
    public String mo688c() {
        return this.f910p;
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: d */
    public int mo689d() {
        return 3;
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: e */
    public String mo690e() {
        return "XCTracer";
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

    /* renamed from: i */
    public void m809i() {
        if (this.f909o != null) {
            C0172d.m666a("closing GATT");
            if (this.f908n != null) {
                this.f909o.setCharacteristicNotification(this.f908n, false);
            }
            try {
                this.f909o.disconnect();
                this.f909o.close();
            } catch (Exception unused) {
            }
            this.f909o = null;
        }
    }
}
