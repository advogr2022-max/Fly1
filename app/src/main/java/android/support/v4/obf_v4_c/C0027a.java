package android.support.v4.obf_v4_c;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* renamed from: android.support.v4.c.a */
/* loaded from: classes.dex */
public class C0027a<K, V> /* extends C0030d */ implements Map<K, V> {

    /* renamed from: a */
    AbstractC0029c<K, V> f135a;

    /* renamed from: b */
    private AbstractC0029c<K, V> m85b() {
        if (this.f135a == null) {
            this.f135a = new AbstractC0029c<K, V>() { // from class: android.support.v4.c.a.1
                @Override // android.support.v4.obf_v4_c.AbstractC0029c
                /* renamed from: a */
                protected int mo86a() {
                    return 0;
                }

                @Override // android.support.v4.obf_v4_c.AbstractC0029c
                /* renamed from: a */
                protected int mo87a(Object obj) {
                    return 0;
                }

                @Override // android.support.v4.obf_v4_c.AbstractC0029c
                /* renamed from: a */
                protected Object mo88a(int i2, int i3) {
                    return null;
                }

                @Override // android.support.v4.obf_v4_c.AbstractC0029c
                /* renamed from: a */
                protected V mo89a(int i2, V v) {
                    return null;
                }

                @Override // android.support.v4.obf_v4_c.AbstractC0029c
                /* renamed from: a */
                protected void mo90a(int i2) {
                    // C0027a.this.m119d()
                }

                @Override // android.support.v4.obf_v4_c.AbstractC0029c
                /* renamed from: a */
                protected void mo91a(K k2, V v) {
                    C0027a.this.put(k2, v);
                }

                @Override // android.support.v4.obf_v4_c.AbstractC0029c
                /* renamed from: b */
                protected int mo92b(Object obj) {
                    return 0;
                }

                @Override // android.support.v4.obf_v4_c.AbstractC0029c
                /* renamed from: b */
                protected Map<K, V> mo93b() {
                    return C0027a.this;
                }

                @Override // android.support.v4.obf_v4_c.AbstractC0029c
                /* renamed from: c */
                protected void mo94c() {
                    C0027a.this.clear();
                }
            };
        }
        return this.f135a;
    }

    @Override // java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return m85b().m103d();
    }

    @Override // java.util.Map
    public Set<K> keySet() {
        return m85b().m104e();
    }

    @Override // java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        /* m115a(map.size()) - parent class method not available */
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map
    public Collection<V> values() {
        return m85b().m105f();
    }
}
