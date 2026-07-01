package flyme_device;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.os.Handler;
import java.util.UUID;

@SuppressLint({"NewApi"})
/* renamed from: d.j */
/* loaded from: classes.dex */
public class C0178j extends AbstractC0174f {

    /* renamed from: c */
    public static int f838c = 1;

    /* renamed from: d */
    public static int f839d = 2;

    /* renamed from: e */
    public static int f840e = 3;

    /* renamed from: f */
    public static int f841f = 4;

    /* renamed from: i */
    public static float f844i;

    /* renamed from: j */
    public static float f845j;

    /* renamed from: k */
    public static int f846k;

    /* renamed from: l */
    public static float f847l;

    /* renamed from: m */
    public static float f848m;

    /* renamed from: A */
    private BluetoothGattCharacteristic f856A;

    /* renamed from: B */
    private BluetoothGattCharacteristic f857B;

    /* renamed from: C */
    private BluetoothGattCharacteristic f858C;

    /* renamed from: D */
    private BluetoothGatt f859D;

    /* renamed from: E */
    private String f860E;

    /* renamed from: J */
    private Context f865J;

    /* renamed from: t */
    private static final UUID f850t = UUID.fromString("aba27100-143b-4b81-a444-edcd0000f020");

    /* renamed from: u */
    private static final UUID f851u = UUID.fromString("aba27100-143b-4b81-a444-edcd0000f010");

    /* renamed from: v */
    private static final UUID f852v = UUID.fromString("aba27100-143b-4b81-a444-edcd0000f022");

    /* renamed from: w */
    private static final UUID f853w = UUID.fromString("aba27100-143b-4b81-a444-edcd0000f023");

    /* renamed from: x */
    private static final UUID f854x = UUID.fromString("aba27100-143b-4b81-a444-edcd0000f012");

    /* renamed from: z */
    private static int f855z = 0;

    /* renamed from: g */
    public static int f842g = 0;

    /* renamed from: L */
    private static int f837L = 0;

    /* renamed from: h */
    public static int f843h = 0;

    /* renamed from: n */
    public static long f849n = 0;

    /* renamed from: o */
    private final long f871o = 10000;

    /* renamed from: p */
    private final long f872p = 1000;

    /* renamed from: q */
    private final long f873q = 5000;

    /* renamed from: r */
    private final long f874r = 10000;

    /* renamed from: s */
    private final long f875s = 10000;

    /* renamed from: y */
    private boolean f876y = false;

    /* renamed from: F */
    private int f861F = 0;

    /* renamed from: G */
    private long f862G = 0;

    /* renamed from: H */
    private long f863H = 0;

    /* renamed from: I */
    private final Handler f864I = new Handler();

    /* renamed from: K */
    private boolean f866K = false;

    /* renamed from: M */
    private Runnable f867M = new Runnable() { // from class: d.j.1
        /* JADX WARN: Code restructure failed: missing block: B:29:0x006c, code lost:
        
            if (r12.f877a.m774j() == false) goto L22;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            String str;
            C0178j c0178j = null;
            String str2 = null;
            C0172d.m666a("starting looper...");
            if (C0178j.this.f876y) {
                C0172d.m666a("terminating");
                return;
            }
            long j2 = 1000;
            long j3 = 10000;
            if (C0178j.f855z == 3) {
                if (C0178j.this.f861F != 3) {
                    if ((C0178j.this.f861F & 1) == 0) {
                        c0178j = C0178j.this;
                        str2 = "BLE_UseQNH_Nav=1";
                    } else {
                        if ((C0178j.this.f861F & 2) == 0) {
                            c0178j = C0178j.this;
                            str2 = "BLE_UseQNH_Mov=1";
                        }
                        C0172d.m666a("Writting setings: " + C0178j.this.f861F);
                    }
                    c0178j.m772b(str2);
                    C0172d.m666a("Writting setings: " + C0178j.this.f861F);
                }
                j2 = 200;
                if (C0178j.this.f863H != 0 && System.currentTimeMillis() - C0178j.this.f863H > 10000) {
                    str = "disconnecting (timeLastUpdate>MAX_UNRESPONSIVE_TIME";
                    C0172d.m666a(str);
                    C0178j.this.m770r();
                }
                j3 = j2;
            } else if (C0178j.f855z == 1 || C0178j.f855z == 2) {
                C0172d.m666a("state=" + C0178j.f855z);
                long currentTimeMillis = System.currentTimeMillis();
                if (C0178j.this.f862G > 0 && currentTimeMillis - C0178j.this.f862G > 10000) {
                    str = "disconnecting (timeStartSearching>MAX_SEARCHING_TIME";
                    C0172d.m666a(str);
                    C0178j.this.m770r();
                }
                j3 = j2;
            } else if (C0178j.f855z == 0) {
                C0172d.m666a("state=" + C0178j.f855z + "  t=" + (System.currentTimeMillis() / 1000));
                C0178j.this.m745a(C0178j.this.f860E, false);
                j3 = 60000;
            } else {
                C0172d.m666a("state=" + C0178j.f855z);
                j3 = 200L;
            }
            C0172d.m666a("waiting for: " + j3);
            C0178j.this.f864I.postDelayed(this, j3);
        }
    };

    /* renamed from: N */
    private final BluetoothGattCallback f868N = new BluetoothGattCallback() { // from class: d.j.2
        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            C0172d.m666a("CARACTERISTIC Changed....");
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
            C0178j c0178j;
            boolean z;
            if (i2 == 0) {
                if (bluetoothGattCharacteristic == C0178j.this.f856A) {
                    C0178j.f848m = bluetoothGattCharacteristic.getIntValue(34, 16).intValue() / 100.0f;
                    C0178j.f849n = System.currentTimeMillis();
                    C0178j.f847l = bluetoothGattCharacteristic.getIntValue(34, 14).intValue();
                    C0178j.this.f782a.mo679a(C0178j.f847l, C0178j.f848m, C0178j.f849n);
                    if (C0178j.this.f866K) {
                        C0178j.f844i = bluetoothGattCharacteristic.getIntValue(36, 4).intValue() / 1.0E7f;
                        C0178j.f845j = bluetoothGattCharacteristic.getIntValue(36, 8).intValue() / 1.0E7f;
                        C0178j.f846k = bluetoothGattCharacteristic.getIntValue(34, 12).intValue();
                        C0178j.this.f782a.mo680a(C0178j.f844i, C0178j.f845j, (short) C0178j.f846k, C0178j.f849n, C0178j.f837L);
                    }
                    C0178j.this.f859D.readCharacteristic(C0178j.this.f857B);
                    C0178j.this.f863H = C0178j.f849n;
                    C0178j.this.m685a(3);
                    return;
                }
                if (bluetoothGattCharacteristic != C0178j.this.f857B) {
                    BluetoothGattCharacteristic unused = C0178j.this.f858C;
                    return;
                }
                if ((bluetoothGattCharacteristic.getIntValue(33, 18).intValue() & 6) != 0) {
                    int unused2 = C0178j.f837L = (bluetoothGattCharacteristic.getIntValue(34, 6).intValue() * 36) / 100;
                    C0178j.f843h = bluetoothGattCharacteristic.getIntValue(34, 8).intValue() / 10;
                    if (C0178j.this.f866K) {
                        return;
                    }
                    c0178j = C0178j.this;
                    z = true;
                } else {
                    c0178j = C0178j.this;
                    z = false;
                }
                c0178j.f866K = z;
            }
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
            if (i2 == 0 && bluetoothGattCharacteristic == C0178j.this.f858C) {
                String stringValue = bluetoothGattCharacteristic.getStringValue(2);
                if (stringValue != null) {
                    if (stringValue.startsWith("BLE_UseQNH_Nav")) {
                        C0178j.this.f861F |= 1;
                    } else if (stringValue.startsWith("BLE_UseQNH_Mov")) {
                        C0178j.this.f861F = 2 | C0178j.this.f861F;
                    }
                }
                C0172d.m666a(stringValue + "  \t sw=" + C0178j.this.f861F);
            }
            C0178j.this.f859D.readCharacteristic(bluetoothGattCharacteristic);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i2, int i3) {
            String str;
            C0172d.m666a("GATT Connection state: " + i3);
            if (i3 == 2) {
                int unused = C0178j.f855z = 2;
                C0178j.this.m685a(2);
                bluetoothGatt.discoverServices();
                str = "Connected to GATT server.";
            } else {
                if (i3 != 0) {
                    return;
                }
                C0178j.this.m770r();
                str = "Disconnected from GATT server.";
            }
            C0172d.m666a(str);
        }

        @Override // android.bluetooth.BluetoothGattCallback
        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i2) {
            C0172d.m666a("Service discovered: " + i2);
            if (i2 == 0) {
                BluetoothGattService service = bluetoothGatt.getService(C0178j.f850t);
                if (service != null) {
                    C0178j.this.f856A = service.getCharacteristic(C0178j.f852v);
                    C0178j.this.f857B = service.getCharacteristic(C0178j.f853w);
                    C0178j.this.f858C = service.getCharacteristic(C0178j.f854x);
                    if (C0178j.this.f856A != null || C0178j.this.f857B != null) {
                        C0178j.this.f859D = bluetoothGatt;
                        int unused = C0178j.f855z = 3;
                        return;
                    }
                }
                bluetoothGatt.close();
                int unused2 = C0178j.f855z = 5;
            } else {
                C0172d.m666a("onServicesDiscovered status: " + i2);
            }
            C0172d.m666a("Service discovery: unknown");
        }
    };

    /* renamed from: O */
    private int f869O = 0;

    /* renamed from: P */
    private long f870P = 0;

    public C0178j(Context context, InterfaceC0182n interfaceC0182n) {
        this.f782a = interfaceC0182n;
        this.f865J = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m745a(String str, boolean z) {
        this.f860E = str;
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter == null || !defaultAdapter.isEnabled()) {
            m685a(4);
            C0172d.m666a("BT disabled");
            return;
        }
        this.f862G = System.currentTimeMillis();
        BluetoothGatt bluetoothGatt = null;
        BluetoothDevice remoteDevice = defaultAdapter.getRemoteDevice(str);
        if (remoteDevice != null) {
            bluetoothGatt = remoteDevice.connectGatt(this.f865J, false, this.f868N);
            if (bluetoothGatt == null) {
                m771s();
            } else {
                this.f869O = 0;
                if (bluetoothGatt != this.f859D) {
                    m773i();
                }
                this.f859D = bluetoothGatt;
            }
        }
        C0172d.m666a("connecting. device=" + remoteDevice + "  gatt=" + bluetoothGatt);
        if (bluetoothGatt == null) {
            m685a(0);
            return;
        }
        m685a(2);
        if (z) {
            m769q();
        }
    }

    /* renamed from: q */
    private void m769q() {
        this.f864I.removeCallbacks(this.f867M);
        this.f864I.postDelayed(this.f867M, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: r */
    public void m770r() {
        f855z = 0;
        m773i();
        this.f857B = null;
        this.f856A = null;
        this.f858C = null;
        this.f861F = 0;
        this.f863H = 0L;
        this.f862G = 0L;
        m685a(0);
    }

    /* renamed from: s */
    private void m771s() {
        if (this.f869O <= 0 || System.currentTimeMillis() - this.f870P >= this.f869O * 60000) {
            this.f869O++;
            this.f870P = System.currentTimeMillis();
            C0172d.m666a("start scan devices: " + new C0169a(null).m636a(5000L, false));
        }
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: a */
    public void mo684a() {
        m770r();
        this.f876y = true;
        f855z = 4;
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: a */
    public void mo686a(String str) {
        m745a(str, true);
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: b */
    public boolean mo687b() {
        return f855z == 3;
    }

    /* renamed from: b */
    public boolean m772b(String str) {
        if (this.f859D == null) {
            return false;
        }
        if (this.f858C == null) {
            this.f858C = this.f859D.getService(f851u).getCharacteristic(f854x);
        }
        byte[] bytes = str.getBytes();
        byte[] bArr = new byte[bytes.length + 3];
        bArr[0] = 3;
        bArr[1] = 2;
        for (int i2 = 0; i2 < bytes.length; i2++) {
            bArr[i2 + 2] = bytes[i2];
        }
        bArr[bArr.length - 1] = 0;
        this.f858C.setValue(bArr);
        return this.f859D.writeCharacteristic(this.f858C);
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: c */
    public String mo688c() {
        return this.f860E;
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: d */
    public int mo689d() {
        return 1;
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: e */
    public String mo690e() {
        return "SensBox";
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
    public void m773i() {
        if (this.f859D != null) {
            C0172d.m666a("closing GATT");
            this.f859D.close();
            this.f859D = null;
        }
    }

    /* renamed from: j */
    public boolean m774j() {
        if (this.f856A == null || this.f859D == null || f855z != 3) {
            return false;
        }
        this.f859D.readCharacteristic(this.f856A);
        return true;
    }
}
