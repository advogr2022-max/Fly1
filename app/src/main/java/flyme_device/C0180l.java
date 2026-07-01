package flyme_device;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbInterface;
import android.hardware.usb.UsbManager;
import android.os.Build;
import android.os.Handler;
import com.xcglobe.xclog.App;

@SuppressLint({"NewApi"})
/* renamed from: d.l */
/* loaded from: classes.dex */
public class C0180l extends AbstractC0174f {

    /* renamed from: m */
    private static C0170b f883m = new C0170b();

    /* renamed from: c */
    Context f884c;

    /* renamed from: d */
    protected int f885d;

    /* renamed from: e */
    UsbEndpoint f886e;

    /* renamed from: f */
    UsbDeviceConnection f887f;

    /* renamed from: h */
    private boolean f889h;

    /* renamed from: j */
    private UsbManager f891j;

    /* renamed from: k */
    private UsbDevice f892k;

    /* renamed from: l */
    private UsbInterface f893l;

    /* renamed from: g */
    private final long f888g = 1000000;

    /* renamed from: i */
    private final Handler f890i = new Handler();

    /* renamed from: n */
    private final BroadcastReceiver f894n = new BroadcastReceiver() { // from class: d.l.1
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("com.xcglobe.USB_PERMISSION".equals(intent.getAction())) {
                synchronized (this) {
                    UsbDevice usbDevice = (UsbDevice) intent.getParcelableExtra("device");
                    if (!intent.getBooleanExtra("permission", false)) {
                        C0172d.m666a("Permission denied for device " + usbDevice);
                    } else if (usbDevice != null) {
                        C0180l.this.m785m();
                        C0184p.m815b(C0180l.this.m784l());
                    }
                    context.unregisterReceiver(this);
                }
            }
        }
    };

    public C0180l(Context context, InterfaceC0182n interfaceC0182n) {
        this.f885d = 0;
        this.f889h = false;
        this.f885d = 0;
        this.f889h = false;
        this.f782a = interfaceC0182n;
        this.f884c = context;
    }

    /* renamed from: a */
    private UsbEndpoint m777a(UsbInterface usbInterface) {
        int endpointCount = usbInterface.getEndpointCount();
        for (int i2 = 0; i2 < endpointCount; i2++) {
            UsbEndpoint endpoint = usbInterface.getEndpoint(i2);
            if (endpoint.getType() == 2 && endpoint.getDirection() == 128) {
                return endpoint;
            }
        }
        return null;
    }

    /* renamed from: a */
    private UsbInterface m778a(UsbDevice usbDevice) {
        int interfaceCount = usbDevice.getInterfaceCount();
        for (int i2 = 0; i2 < interfaceCount; i2++) {
            UsbInterface usbInterface = usbDevice.getInterface(i2);
            if (usbInterface.getInterfaceClass() == 10) {
                return usbInterface;
            }
        }
        return null;
    }

    /* renamed from: c */
    private void m781c(String str) {
        if (f883m.m649a(str)) {
            if (f883m.f743m) {
                this.f782a.mo679a(f883m.f734d, f883m.f737g, f883m.f738h);
            }
            if (f883m.f742l) {
                this.f782a.mo680a(f883m.f732b, f883m.f733c, (short) f883m.f735e, f883m.f738h, f883m.f736f);
            }
            m685a(3);
        }
    }

    /* renamed from: j */
    private void m782j() {
        this.f892k = null;
        this.f886e = null;
        if (this.f887f != null) {
            try {
                this.f887f.releaseInterface(this.f893l);
                this.f887f.close();
                this.f887f = null;
                C0172d.m666a("bt: ###Close device");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: k */
    private UsbDevice m783k() {
        String str = null;
        for (UsbDevice usbDevice : this.f891j.getDeviceList().values()) {
            int vendorId = usbDevice.getVendorId();
            int productId = usbDevice.getProductId();
            C0172d.m666a("Found USB device " + vendorId + "/" + productId);
            if (vendorId == 5840 && productId == 2985) {
                str = "Found GpdBipBip";
            } else if (vendorId == 5824 && productId == 1155) {
                str = "Found XCTracer";
            } else if (vendorId == 6991 && productId == 8) {
                str = "Found IOIO-OTG board";
            } else if (vendorId == 4617 && productId == 26215) {
                str = "Found XCTracer II";
            }
            C0172d.m666a(str);
            return usbDevice;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public C0180l m784l() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: m */
    public void m785m() {
        this.f887f = this.f891j.openDevice(this.f892k);
        C0172d.m666a("bt: ###Open device " + this.f887f);
        if (this.f887f == null) {
            return;
        }
        this.f893l = m778a(this.f892k);
        if (this.f893l != null && this.f887f.claimInterface(this.f893l, true)) {
            this.f886e = m777a(this.f893l);
            if (this.f886e == null) {
                return;
            }
            this.f885d = 3;
        }
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: a */
    public void mo684a() {
        C0184p.m812a();
        this.f889h = true;
        m787i();
        C0172d.m666a("Terminating usb device.");
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: a */
    public void mo686a(String str) {
        App m443b = App.m443b();
        this.f891j = (UsbManager) m443b.getSystemService("usb");
        this.f892k = m783k();
        if (this.f892k == null) {
            this.f885d = 0;
            C0184p.m813a(this);
        } else if (this.f891j.hasPermission(this.f892k)) {
            m785m();
            C0184p.m815b(this);
        } else {
            PendingIntent broadcast = PendingIntent.getBroadcast(m443b, 0, new Intent("com.xcglobe.USB_PERMISSION"), PendingIntent.FLAG_IMMUTABLE);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                m443b.registerReceiver(this.f894n, new IntentFilter("com.xcglobe.USB_PERMISSION"), Context.RECEIVER_NOT_EXPORTED);
            } else {
                m443b.registerReceiver(this.f894n, new IntentFilter("com.xcglobe.USB_PERMISSION"));
            }
            this.f891j.requestPermission(this.f892k, broadcast);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m786b(String str) {
        int i2 = 0;
        while (true) {
            int indexOf = str.indexOf(36, i2 + 2);
            if (indexOf == -1) {
                m781c(str.substring(i2));
                return;
            } else {
                m781c(str.substring(i2, indexOf - 2));
                i2 = indexOf;
            }
        }
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: b */
    public boolean mo687b() {
        return this.f885d == 3 && C0184p.f929c;
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: c */
    public String mo688c() {
        return "usb";
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: d */
    public int mo689d() {
        return 5;
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: e */
    public String mo690e() {
        return "USB device";
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: f */
    public boolean mo691f() {
        return false;
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: g */
    public boolean mo692g() {
        return true;
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: h */
    public boolean mo693h() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: i */
    public void m787i() {
        this.f885d = 0;
        m782j();
        m685a(0);
    }
}
