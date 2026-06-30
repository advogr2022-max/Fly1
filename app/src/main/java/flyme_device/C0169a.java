package flyme_device;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Handler;
import java.util.HashSet;
import java.util.Set;

@SuppressLint({"NewApi"})
/* renamed from: d.a */
/* loaded from: classes.dex */
public class C0169a {

    /* renamed from: b */
    public static int f719b;

    /* renamed from: a */
    BluetoothAdapter f720a;

    /* renamed from: c */
    DialogC0171c f721c;

    /* renamed from: d */
    private final long f722d = 10000;

    /* renamed from: e */
    private final Handler f723e = new Handler();

    /* renamed from: f */
    private Set<String> f724f = new HashSet();

    /* renamed from: g */
    private BluetoothAdapter.LeScanCallback f725g = new BluetoothAdapter.LeScanCallback() { // from class: d.a.2
        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(final BluetoothDevice bluetoothDevice, int i2, byte[] bArr) {
            String address = bluetoothDevice.getAddress();
            C0172d.m666a("LESCAN FOUND: : " + address);
            if (C0169a.this.f724f.contains(address)) {
                return;
            }
            C0169a.this.f724f.add(address);
            if (C0169a.this.f721c != null) {
                C0169a.this.f723e.post(new Runnable() { // from class: d.a.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        C0169a.this.f721c.m662b(bluetoothDevice);
                    }
                });
            }
        }
    };

    public C0169a(DialogC0171c dialogC0171c) {
        this.f721c = dialogC0171c;
    }

    /* renamed from: a */
    private boolean m633a() {
        this.f720a = BluetoothAdapter.getDefaultAdapter();
        return this.f720a != null && this.f720a.isEnabled();
    }

    /* renamed from: a */
    public void m635a(boolean z) {
        this.f720a.stopLeScan(this.f725g);
        if (z) {
            this.f720a.startDiscovery();
        }
    }

    /* renamed from: a */
    public boolean m636a(long j2, final boolean z) {
        if (!m633a()) {
            return false;
        }
        this.f723e.postDelayed(new Runnable() { // from class: d.a.1
            @Override // java.lang.Runnable
            public void run() {
                C0169a.this.m635a(z);
            }
        }, 10000L);
        f719b++;
        return this.f720a.startLeScan(this.f725g);
    }
}
