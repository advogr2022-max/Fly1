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
/* renamed from: d.i */
/* loaded from: classes.dex */
public class C0177i extends AbstractC0174f {

    /* renamed from: j */
    private static int f815j;

    /* renamed from: q */
    private static C0170b f816q = new C0170b();

    /* renamed from: c */
    Context f817c;

    /* renamed from: h */
    private String f822h;

    /* renamed from: i */
    private BluetoothGatt f823i;

    /* renamed from: m */
    private boolean f826m;

    /* renamed from: o */
    private BluetoothGattCharacteristic f828o;

    /* renamed from: e */
    private final long f819e = 5000;

    /* renamed from: f */
    private final long f820f = 10000;

    /* renamed from: g */
    private final long f821g = 10000;

    /* renamed from: d */
    a f818d = new a();

    /* renamed from: k */
    private long f824k = 0;

    /* renamed from: l */
    private final Handler f825l = new Handler();

    /* renamed from: n */
    private long f827n = 0;

    /* renamed from: p */
    private StringBuilder f829p = new StringBuilder();

    /* renamed from: r */
    private int f830r = 0;

    /* renamed from: s */
    private long f831s = 0;

    /* renamed from: t */
    private Runnable f832t = new Runnable() { // from class: d.i.1

        /* renamed from: a */
        long f833a = 10000;

        /* renamed from: b */
        long f834b = 1000;

        @Override // java.lang.Runnable
        public void run() {
            String str = null;
            C0172d.m666a("starting looper..., state=" + C0177i.f815j);
            long j2 = this.f834b;
            if (C0177i.this.f826m) {
                C0172d.m666a("terminating, mTerminate=true!!!!!!!!!!!!!!!!!!!!!!!");
                return;
            }
            if (C0177i.f815j == 3) {
                str = (C0177i.this.f827n != 0 && System.currentTimeMillis() - C0177i.this.f827n > 10000) ? "disconnecting (timeLastUpdate>MAX_UNRESPONSIVE_TIME" : "disconnecting (timeStartSearching>MAX_SEARCHING_TIME";
                j2 = this.f833a;
                C0172d.m666a("waiting for: " + j2 + " state=" + C0177i.f815j);
                C0177i.this.f825l.postDelayed(this, j2);
            }
            if (C0177i.f815j == 1 || C0177i.f815j == 2) {
                C0172d.m666a("state=" + C0177i.f815j);
                j2 = this.f834b;
                long currentTimeMillis = System.currentTimeMillis();
                if (C0177i.this.f824k > 0 && currentTimeMillis - C0177i.this.f824k > 10000) {
                }
            } else if (C0177i.f815j == 0) {
                C0172d.m666a("state=" + C0177i.f815j + "  t=" + (System.currentTimeMillis() / 1000));
                C0177i.this.m723a(C0177i.this.f822h, false);
                j2 = 60000;
            }
            C0172d.m666a("waiting for: " + j2 + " state=" + C0177i.f815j);
            C0177i.this.f825l.postDelayed(this, j2);
            C0172d.m666a(str);
            C0177i.this.m738m();
            j2 = this.f833a;
            C0172d.m666a("waiting for: " + j2 + " state=" + C0177i.f815j);
            C0177i.this.f825l.postDelayed(this, j2);
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d.i$a */
    /* loaded from: classes.dex */
    public class a extends BluetoothGattCallback {
        a() {
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            for (byte b2 : bluetoothGattCharacteristic.getValue()) {
                int intValue = Integer.valueOf(b2 & 255).intValue();
                if (intValue != 13 && intValue != 10) {
                    if (intValue == 36 && C0177i.this.f829p.length() > 0) {
                        C0177i.this.m726b(C0177i.this.f829p.toString());
                        C0177i.this.f829p.setLength(0);
                    }
                    C0177i.this.f829p.append((char) intValue);
                } else if (C0177i.this.f829p.length() > 0) {
                    C0177i.this.m726b(C0177i.this.f829p.toString());
                    C0177i.this.f829p.setLength(0);
                }
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i2, int i3) {
            String str;
            C0172d.m666a("GATT Connection state: " + i3);
            if (i3 == 2) {
                int unused = C0177i.f815j = 2;
                C0177i.this.m685a(2);
                bluetoothGatt.discoverServices();
                str = "Connected to GATT server.";
            } else {
                if (i3 != 0) {
                    return;
                }
                C0177i.this.m738m();
                str = "Disconnected from GATT server.";
            }
            C0172d.m666a(str);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i2) {
            C0172d.m666a("Service discovered: " + i2);
            if (i2 != 0 || C0177i.this.f823i == null) {
                return;
            }
            for (BluetoothGattService bluetoothGattService : C0177i.this.f823i.getServices()) {
                if (bluetoothGattService.getUuid().toString().equals("00035b03-58e6-07dd-021a-08123a000300".toString())) {
                    for (BluetoothGattCharacteristic bluetoothGattCharacteristic : bluetoothGattService.getCharacteristics()) {
                        String uuid = bluetoothGattCharacteristic.getUuid().toString();
                        if (uuid.equals("00035b03-58e6-07dd-021a-08123a000301")) {
                            C0177i.this.f828o = bluetoothGattCharacteristic;
                            C0172d.m666a("  Found MLDP data characteristics");
                        } else {
                            uuid.equals("00035b03-58e6-07dd-021a-08123a0003ff");
                        }
                        int properties = bluetoothGattCharacteristic.getProperties();
                        if ((properties & 16) > 0) {
                            C0177i.this.f823i.setCharacteristicNotification(bluetoothGattCharacteristic, true);
                            BluetoothGattDescriptor descriptor = bluetoothGattCharacteristic.getDescriptor(UUID.fromString("00002902-0000-1000-8000-00805f9b34fb"));
                            descriptor.setValue(BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE);
                            C0177i.this.f823i.writeDescriptor(descriptor);
                        }
                        if ((properties & 32) > 0) {
                            C0177i.this.f823i.setCharacteristicNotification(bluetoothGattCharacteristic, true);
                            BluetoothGattDescriptor descriptor2 = bluetoothGattCharacteristic.getDescriptor(UUID.fromString("00002902-0000-1000-8000-00805f9b34fb"));
                            descriptor2.setValue(BluetoothGattDescriptor.ENABLE_INDICATION_VALUE);
                            C0177i.this.f823i.writeDescriptor(descriptor2);
                        }
                        if ((properties & 8) > 0) {
                            bluetoothGattCharacteristic.setWriteType(2);
                        }
                        if ((properties & 4) > 0) {
                            bluetoothGattCharacteristic.setWriteType(1);
                        }
                    }
                }
            }
            if (C0177i.this.f828o == null) {
                bluetoothGatt.close();
                int unused = C0177i.f815j = 5;
            } else {
                int unused2 = C0177i.f815j = 3;
                C0177i.this.m736k();
            }
        }
    }

    public C0177i(Context context, InterfaceC0182n interfaceC0182n) {
        this.f826m = false;
        this.f826m = false;
        C0172d.m666a("constructor SensDeviceFlysys");
        this.f782a = interfaceC0182n;
        this.f817c = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m723a(String str, boolean z) {
        this.f822h = str;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || !defaultAdapter.isEnabled()) {
            m685a(4);
            C0172d.m666a("BT disabled");
            return;
        }
        this.f824k = System.currentTimeMillis();
        BluetoothGatt bluetoothGatt = null;
        BluetoothDevice remoteDevice = defaultAdapter.getRemoteDevice(str);
        if (remoteDevice != null) {
            bluetoothGatt = remoteDevice.connectGatt(this.f817c, false, this.f818d);
            if (bluetoothGatt == null) {
                m737l();
            } else {
                this.f830r = 0;
                if (this.f823i != bluetoothGatt) {
                    m739i();
                }
                this.f823i = bluetoothGatt;
            }
        }
        C0172d.m666a("connecting. device=" + remoteDevice + "  gatt=" + bluetoothGatt);
        if (bluetoothGatt == null) {
            m685a(0);
        } else {
            m685a(2);
            f815j = 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m726b(String str) {
        C0172d.m666a("PROCESSING LINE: " + str);
        if (f816q.m649a(str)) {
            if (f816q.f743m) {
                this.f782a.mo679a(f816q.f734d, f816q.f737g, f816q.f738h);
            }
            this.f827n = f816q.f738h;
            m685a(3);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m736k() {
        this.f825l.removeCallbacks(this.f832t);
        this.f825l.postDelayed(this.f832t, 800L);
    }

    /* renamed from: l */
    private void m737l() {
        if (this.f830r <= 0 || System.currentTimeMillis() - this.f831s >= this.f830r * 60000) {
            this.f830r++;
            this.f831s = System.currentTimeMillis();
            C0172d.m666a("start scan devices: " + new C0169a(null).m636a(5000L, false));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m738m() {
        f815j = 0;
        m739i();
        this.f828o = null;
        this.f827n = 0L;
        this.f824k = 0L;
        m685a(0);
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: a */
    public void mo684a() {
        C0172d.m666a("Terminating ble device.");
        m738m();
        this.f826m = true;
        f815j = 4;
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: a */
    public void mo686a(String str) {
        m723a(str, false);
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: b */
    public boolean mo687b() {
        return f815j == 3;
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: c */
    public String mo688c() {
        return this.f822h;
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: d */
    public int mo689d() {
        return 4;
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: e */
    public String mo690e() {
        return "FlySys";
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
    public void m739i() {
        if (this.f823i != null) {
            C0172d.m666a("closing GATT");
            this.f823i.close();
            this.f823i = null;
        }
    }
}
