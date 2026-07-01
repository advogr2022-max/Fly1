package flyme_collection;

/* renamed from: e.a */
/* loaded from: classes.dex */
public class C0192a<E> {

    /* renamed from: a */
    final E[] f948a;

    /* renamed from: b */
    final int f949b;

    /* renamed from: c */
    int f950c = -1;

    /* renamed from: d */
    boolean f951d = false;

    public C0192a(int i2, E e2) {
        this.f948a = (E[]) new Object[i2];
        this.f949b = i2;
        for (int i3 = 0; i3 < i2; i3++) {
                // ((E[]) this.f948a)[i3] = ...;
                this.f948a[i3] = null;
        }
    }

    /* renamed from: a */
    public E m817a(int i2) {
        if (!this.f951d) {
            return this.f948a[i2];
        }
        int i3 = this.f950c + 1 + i2;
        if (i3 >= this.f949b) {
            i3 -= this.f949b;
        }
        return this.f948a[i3];
    }

    /* renamed from: a */
    public void m818a() {
        this.f951d = false;
        this.f950c = -1;
    }

    /* renamed from: b */
    public int m819b() {
        return this.f951d ? this.f949b : this.f950c + 1;
    }

    /* renamed from: b */
    public E m820b(int i2) {
        if (i2 <= this.f950c) {
            return this.f948a[this.f950c - i2];
        }
        if (!this.f951d) {
            return null;
        }
        int i3 = this.f950c - i2;
        if (i3 < 0) {
            i3 += this.f949b;
        }
        return this.f948a[i3];
    }

    /* renamed from: c */
    public E m821c() {
        int i2 = this.f950c + 1;
        if (i2 >= this.f949b) {
            i2 -= this.f949b;
        }
        return this.f948a[i2];
    }

    /* renamed from: d */
    public void m822d() {
        int i2 = this.f950c + 1;
        if (i2 >= this.f949b) {
            i2 -= this.f949b;
            if (!this.f951d) {
                this.f951d = true;
            }
        }
        this.f950c = i2;
    }

    /* renamed from: e */
    public E m823e() {
        if (this.f950c >= 0) {
            return this.f948a[this.f950c];
        }
        return null;
    }

    /* renamed from: f */
    public E m824f() {
        return this.f948a[this.f950c];
    }
}
