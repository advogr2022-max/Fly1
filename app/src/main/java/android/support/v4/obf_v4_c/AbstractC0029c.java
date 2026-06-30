package android.support.v4.obf_v4_c;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: android.support.v4.c.c */
/* loaded from: classes.dex */
public abstract class AbstractC0029c<K, V> {

    /* renamed from: b */
    AbstractC0029c<K, V>.b f140b;

    /* renamed from: c */
    AbstractC0029c<K, V>.c f141c;

    /* renamed from: d */
    AbstractC0029c<K, V>.e f142d;

    /* renamed from: android.support.v4.c.c$a */
    /* loaded from: classes.dex */
    final class a<T> implements Iterator<T> {

        /* renamed from: a */
        final int f143a;

        /* renamed from: b */
        int f144b;

        /* renamed from: c */
        int f145c;

        /* renamed from: d */
        boolean f146d = false;

        a(int i2) {
            this.f143a = i2;
            this.f144b = AbstractC0029c.this.mo86a();
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f145c < this.f144b;
        }

        @Override // java.util.Iterator
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T t = (T) AbstractC0029c.this.mo88a(this.f145c, this.f143a);
            this.f145c++;
            this.f146d = true;
            return t;
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f146d) {
                throw new IllegalStateException();
            }
            this.f145c--;
            this.f144b--;
            this.f146d = false;
            AbstractC0029c.this.mo90a(this.f145c);
        }
    }

    /* renamed from: android.support.v4.c.c$b */
    /* loaded from: classes.dex */
    final class b implements Set<Map.Entry<K, V>> {
        b() {
        }

        @Override // java.util.Set, java.util.Collection
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean add(Map.Entry<K, V> entry) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends Map.Entry<K, V>> collection) {
            int mo86a = AbstractC0029c.this.mo86a();
            for (Map.Entry<K, V> entry : collection) {
                AbstractC0029c.this.mo91a((K) entry.getKey(), (V) entry.getValue());
            }
            return mo86a != AbstractC0029c.this.mo86a();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            AbstractC0029c.this.mo94c();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            int mo87a = AbstractC0029c.this.mo87a(entry.getKey());
            if (mo87a < 0) {
                return false;
            }
            return false /* C0028b */;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return AbstractC0029c.m98a((Set) this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i2 = 0;
            for (int mo86a = AbstractC0029c.this.mo86a() - 1; mo86a >= 0; mo86a--) {
                Object mo88a = AbstractC0029c.this.mo88a(mo86a, 0);
                Object mo88a2 = AbstractC0029c.this.mo88a(mo86a, 1);
                i2 += (mo88a == null ? 0 : mo88a.hashCode()) ^ (mo88a2 == null ? 0 : mo88a2.hashCode());
            }
            return i2;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return AbstractC0029c.this.mo86a() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<Map.Entry<K, V>> iterator() {
            return new d();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return AbstractC0029c.this.mo86a();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }
    }

    /* renamed from: android.support.v4.c.c$c */
    /* loaded from: classes.dex */
    final class c implements Set<K> {
        c() {
        }

        @Override // java.util.Set, java.util.Collection
        public boolean add(K k2) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Set, java.util.Collection
        public void clear() {
            AbstractC0029c.this.mo94c();
        }

        @Override // java.util.Set, java.util.Collection
        public boolean contains(Object obj) {
            return AbstractC0029c.this.mo87a(obj) >= 0;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            return AbstractC0029c.m97a((Map) AbstractC0029c.this.mo93b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean equals(Object obj) {
            return AbstractC0029c.m98a((Set) this, obj);
        }

        @Override // java.util.Set, java.util.Collection
        public int hashCode() {
            int i2 = 0;
            for (int mo86a = AbstractC0029c.this.mo86a() - 1; mo86a >= 0; mo86a--) {
                Object mo88a = AbstractC0029c.this.mo88a(mo86a, 0);
                i2 += mo88a == null ? 0 : mo88a.hashCode();
            }
            return i2;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean isEmpty() {
            return AbstractC0029c.this.mo86a() == 0;
        }

        @Override // java.util.Set, java.util.Collection, java.lang.Iterable
        public Iterator<K> iterator() {
            return new a(0);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean remove(Object obj) {
            int mo87a = AbstractC0029c.this.mo87a(obj);
            if (mo87a < 0) {
                return false;
            }
            AbstractC0029c.this.mo90a(mo87a);
            return true;
        }

        @Override // java.util.Set, java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            return AbstractC0029c.m99b(AbstractC0029c.this.mo93b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            return AbstractC0029c.m100c(AbstractC0029c.this.mo93b(), collection);
        }

        @Override // java.util.Set, java.util.Collection
        public int size() {
            return AbstractC0029c.this.mo86a();
        }

        @Override // java.util.Set, java.util.Collection
        public Object[] toArray() {
            return AbstractC0029c.this.m102b(0);
        }

        @Override // java.util.Set, java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) AbstractC0029c.this.m101a(tArr, 0);
        }
    }

    /* renamed from: android.support.v4.c.c$d */
    /* loaded from: classes.dex */
    final class d implements Iterator<Map.Entry<K, V>>, Map.Entry<K, V> {

        /* renamed from: a */
        int f150a;

        /* renamed from: c */
        boolean f152c = false;

        /* renamed from: b */
        int f151b = -1;

        d() {
            this.f150a = AbstractC0029c.this.mo86a() - 1;
        }

        @Override // java.util.Iterator
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Map.Entry<K, V> next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            this.f151b++;
            this.f152c = true;
            return this;
        }

        @Override // java.util.Map.Entry
        public final boolean equals(Object obj) {
            if (!this.f152c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return false /* C0028b */;
        }

        @Override // java.util.Map.Entry
        public K getKey() {
            if (this.f152c) {
                return (K) AbstractC0029c.this.mo88a(this.f151b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Map.Entry
        public V getValue() {
            if (this.f152c) {
                return (V) AbstractC0029c.this.mo88a(this.f151b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f151b < this.f150a;
        }

        @Override // java.util.Map.Entry
        public final int hashCode() {
            if (!this.f152c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            }
            Object mo88a = AbstractC0029c.this.mo88a(this.f151b, 0);
            Object mo88a2 = AbstractC0029c.this.mo88a(this.f151b, 1);
            return (mo88a == null ? 0 : mo88a.hashCode()) ^ (mo88a2 != null ? mo88a2.hashCode() : 0);
        }

        @Override // java.util.Iterator
        public void remove() {
            if (!this.f152c) {
                throw new IllegalStateException();
            }
            AbstractC0029c.this.mo90a(this.f151b);
            this.f151b--;
            this.f150a--;
            this.f152c = false;
        }

        @Override // java.util.Map.Entry
        public V setValue(V v) {
            if (this.f152c) {
                return null; /* generic fix */
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            return getKey() + "=" + getValue();
        }
    }

    /* renamed from: android.support.v4.c.c$e */
    /* loaded from: classes.dex */
    final class e implements Collection<V> {
        e() {
        }

        @Override // java.util.Collection
        public boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        @Override // java.util.Collection
        public void clear() {
            AbstractC0029c.this.mo94c();
        }

        @Override // java.util.Collection
        public boolean contains(Object obj) {
            return AbstractC0029c.this.mo92b(obj) >= 0;
        }

        @Override // java.util.Collection
        public boolean containsAll(Collection<?> collection) {
            Iterator<?> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.Collection
        public boolean isEmpty() {
            return AbstractC0029c.this.mo86a() == 0;
        }

        @Override // java.util.Collection, java.lang.Iterable
        public Iterator<V> iterator() {
            return new a(1);
        }

        @Override // java.util.Collection
        public boolean remove(Object obj) {
            int mo92b = AbstractC0029c.this.mo92b(obj);
            if (mo92b < 0) {
                return false;
            }
            AbstractC0029c.this.mo90a(mo92b);
            return true;
        }

        @Override // java.util.Collection
        public boolean removeAll(Collection<?> collection) {
            int mo86a = AbstractC0029c.this.mo86a();
            int i2 = 0;
            boolean z = false;
            while (i2 < mo86a) {
                if (collection.contains(AbstractC0029c.this.mo88a(i2, 1))) {
                    AbstractC0029c.this.mo90a(i2);
                    i2--;
                    mo86a--;
                    z = true;
                }
                i2++;
            }
            return z;
        }

        @Override // java.util.Collection
        public boolean retainAll(Collection<?> collection) {
            int mo86a = AbstractC0029c.this.mo86a();
            int i2 = 0;
            boolean z = false;
            while (i2 < mo86a) {
                if (!collection.contains(AbstractC0029c.this.mo88a(i2, 1))) {
                    AbstractC0029c.this.mo90a(i2);
                    i2--;
                    mo86a--;
                    z = true;
                }
                i2++;
            }
            return z;
        }

        @Override // java.util.Collection
        public int size() {
            return AbstractC0029c.this.mo86a();
        }

        @Override // java.util.Collection
        public Object[] toArray() {
            return AbstractC0029c.this.m102b(1);
        }

        @Override // java.util.Collection
        public <T> T[] toArray(T[] tArr) {
            return (T[]) AbstractC0029c.this.m101a(tArr, 1);
        }
    }

    /* renamed from: a */
    public static <K, V> boolean m97a(Map<K, V> map, Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!map.containsKey(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static <T> boolean m98a(Set<T> set, Object obj) {
        if (set == obj) {
            return true;
        }
        if (obj instanceof Set) {
            Set set2 = (Set) obj;
            try {
                if (set.size() == set2.size()) {
                    if (set.containsAll(set2)) {
                        return true;
                    }
                }
                return false;
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    /* renamed from: b */
    public static <K, V> boolean m99b(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            map.remove(it.next());
        }
        return size != map.size();
    }

    /* renamed from: c */
    public static <K, V> boolean m100c(Map<K, V> map, Collection<?> collection) {
        int size = map.size();
        Iterator<K> it = map.keySet().iterator();
        while (it.hasNext()) {
            if (!collection.contains(it.next())) {
                it.remove();
            }
        }
        return size != map.size();
    }

    /* renamed from: a */
    protected abstract int mo86a();

    /* renamed from: a */
    protected abstract int mo87a(Object obj);

    /* renamed from: a */
    protected abstract Object mo88a(int i2, int i3);

    /* renamed from: a */
    protected abstract V mo89a(int i2, V v);

    /* renamed from: a */
    protected abstract void mo90a(int i2);

    /* renamed from: a */
    protected abstract void mo91a(K k2, V v);

    /* renamed from: a */
    public <T> T[] m101a(T[] tArr, int i2) {
        int mo86a = mo86a();
        if (tArr.length < mo86a) {
            tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), mo86a));
        }
        for (int i3 = 0; i3 < mo86a; i3++) {
            /* tArr fix */
        }
        if (tArr.length > mo86a) {
            tArr[mo86a] = null;
        }
        return tArr;
    }

    /* renamed from: b */
    protected abstract int mo92b(Object obj);

    /* renamed from: b */
    protected abstract Map<K, V> mo93b();

    /* renamed from: b */
    public Object[] m102b(int i2) {
        int mo86a = mo86a();
        Object[] objArr = new Object[mo86a];
        for (int i3 = 0; i3 < mo86a; i3++) {
            objArr[i3] = mo88a(i3, i2);
        }
        return objArr;
    }

    /* renamed from: c */
    protected abstract void mo94c();

    /* renamed from: d */
    public Set<Map.Entry<K, V>> m103d() {
        if (this.f140b == null) {
            this.f140b = new b();
        }
        return this.f140b;
    }

    /* renamed from: e */
    public Set<K> m104e() {
        if (this.f141c == null) {
            this.f141c = new c();
        }
        return this.f141c;
    }

    /* renamed from: f */
    public Collection<V> m105f() {
        if (this.f142d == null) {
            this.f142d = new e();
        }
        return this.f142d;
    }
}
