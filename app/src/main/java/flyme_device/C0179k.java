package flyme_device;

import android.content.Context;

/* renamed from: d.k */
/* loaded from: classes.dex */
public class C0179k extends AbstractC0174f {

    /* renamed from: f */
    private static C0170b f879f = new C0170b();

    /* renamed from: c */
    Context f880c;

    /* renamed from: d */
    protected int f881d;

    /* renamed from: e */
    private boolean f882e;

    public C0179k(Context context, InterfaceC0182n interfaceC0182n) {
        this.f881d = 0;
        this.f882e = false;
        this.f881d = 0;
        this.f882e = false;
        this.f782a = interfaceC0182n;
        this.f880c = context;
    }

    /* renamed from: c */
    private void m775c(String str) {
        if (f879f.m649a(str)) {
            if (f879f.f743m) {
                this.f782a.mo679a(f879f.f735e, f879f.f737g, f879f.f738h);
            }
            if (f879f.f742l) {
                this.f782a.mo680a(f879f.f732b, f879f.f733c, (short) f879f.f735e, f879f.f738h, f879f.f736f);
            }
            m685a(3);
        }
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: a */
    public void mo684a() {
        this.f882e = true;
        C0183o.m810a();
        this.f881d = 0;
        m685a(0);
        C0172d.m666a("Terminating tcp device.");
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: a */
    public void mo686a(String str) {
        C0183o.m811a(this, 4353);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m776b(String str) {
        int i2 = 0;
        while (true) {
            int indexOf = str.indexOf(36, i2 + 2);
            if (indexOf == -1) {
                m775c(str.substring(i2));
                return;
            } else {
                m775c(str.substring(i2, indexOf - 2));
                i2 = indexOf;
            }
        }
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: b */
    public boolean mo687b() {
        return C0183o.f923c;
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: c */
    public String mo688c() {
        return "tcp";
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: d */
    public int mo689d() {
        return 6;
    }

    @Override // flyme_device.AbstractC0174f
    /* renamed from: e */
    public String mo690e() {
        return "TCP device";
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
        return true;
    }
}
