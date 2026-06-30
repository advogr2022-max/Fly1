package flyme_device;

/* renamed from: d.f */
/* loaded from: classes.dex */
public abstract class AbstractC0174f {

    /* renamed from: a */
    protected InterfaceC0182n f782a;

    /* renamed from: b */
    protected int f783b = 0;

    /* renamed from: a */
    public abstract void mo684a();

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public void m685a(int i2) {
        if (this.f783b == i2) {
            return;
        }
        C0172d.m666a("updateStatus: " + this.f783b + " -> " + i2);
        if (i2 == 3) {
            this.f782a.mo682a(mo689d(), mo688c());
        } else if (this.f783b == 3) {
            this.f782a.mo681a(mo689d());
        }
        InterfaceC0182n interfaceC0182n = this.f782a;
        this.f783b = i2;
        interfaceC0182n.mo683b(i2);
    }

    /* renamed from: a */
    public abstract void mo686a(String str);

    /* renamed from: b */
    public abstract boolean mo687b();

    /* renamed from: c */
    public abstract String mo688c();

    /* renamed from: d */
    public abstract int mo689d();

    /* renamed from: e */
    public abstract String mo690e();

    /* renamed from: f */
    public abstract boolean mo691f();

    /* renamed from: g */
    public abstract boolean mo692g();

    /* renamed from: h */
    public abstract boolean mo693h();
}
