package com.qihoo360.replugin.utils.a;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: MapCollections */
abstract class g<K, V> {
    b b;
    c c;
    e d;

    /* compiled from: MapCollections */
    final class a<T> implements Iterator<T> {
        final int a;
        int b;
        int c;
        boolean d = false;
        final /* synthetic */ g e;

        a(g gVar, int i) {
            this.e = gVar;
            this.a = i;
            this.b = gVar.a();
        }

        public final boolean hasNext() {
            return this.c < this.b;
        }

        public final T next() {
            T a = this.e.a(this.c, this.a);
            this.c++;
            this.d = true;
            return a;
        }

        public final void remove() {
            if (this.d) {
                this.c--;
                this.b--;
                this.d = false;
                this.e.a(this.c);
                return;
            }
            throw new IllegalStateException();
        }
    }

    /* compiled from: MapCollections */
    final class b implements Set<Entry<K, V>> {
        final /* synthetic */ g a;

        b(g gVar) {
            this.a = gVar;
        }

        public final boolean addAll(Collection<? extends Entry<K, V>> collection) {
            int a = this.a.a();
            for (Entry entry : collection) {
                this.a.a(entry.getKey(), entry.getValue());
            }
            return a != this.a.a() ? true : null;
        }

        public final void clear() {
            this.a.c();
        }

        public final boolean contains(Object obj) {
            if (!(obj instanceof Entry)) {
                return false;
            }
            Entry entry = (Entry) obj;
            int a = this.a.a(entry.getKey());
            if (a < 0) {
                return false;
            }
            return f.a(this.a.a(a, 1), entry.getValue());
        }

        public final boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return null;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return this.a.a() == 0;
        }

        public final Iterator<Entry<K, V>> iterator() {
            return new d(this.a);
        }

        public final boolean remove(Object obj) {
            throw new UnsupportedOperationException();
        }

        public final boolean removeAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public final boolean retainAll(Collection<?> collection) {
            throw new UnsupportedOperationException();
        }

        public final int size() {
            return this.a.a();
        }

        public final Object[] toArray() {
            throw new UnsupportedOperationException();
        }

        public final <T> T[] toArray(T[] tArr) {
            throw new UnsupportedOperationException();
        }

        public final boolean equals(Object obj) {
            return g.a((Set) this, obj);
        }

        public final int hashCode() {
            int i = 0;
            for (int a = this.a.a() - 1; a >= 0; a--) {
                int i2;
                int i3;
                Object a2 = this.a.a(a, 0);
                Object a3 = this.a.a(a, 1);
                if (a2 == null) {
                    i2 = 0;
                } else {
                    i2 = a2.hashCode();
                }
                if (a3 == null) {
                    i3 = 0;
                } else {
                    i3 = a3.hashCode();
                }
                i += i2 ^ i3;
            }
            return i;
        }

        public final /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException();
        }
    }

    /* compiled from: MapCollections */
    final class c implements Set<K> {
        final /* synthetic */ g a;

        c(g gVar) {
            this.a = gVar;
        }

        public final boolean add(K k) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends K> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            this.a.c();
        }

        public final boolean contains(Object obj) {
            return this.a.a(obj) >= null ? true : null;
        }

        public final boolean containsAll(Collection<?> collection) {
            Map b = this.a.b();
            for (Object containsKey : collection) {
                if (!b.containsKey(containsKey)) {
                    return null;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return this.a.a() == 0;
        }

        public final Iterator<K> iterator() {
            return new a(this.a, 0);
        }

        public final boolean remove(Object obj) {
            int a = this.a.a(obj);
            if (a < null) {
                return null;
            }
            this.a.a(a);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            Map b = this.a.b();
            int size = b.size();
            for (Object remove : collection) {
                b.remove(remove);
            }
            return size != b.size() ? true : null;
        }

        public final boolean retainAll(Collection<?> collection) {
            Map b = this.a.b();
            int size = b.size();
            Iterator it = b.keySet().iterator();
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                }
            }
            return size != b.size() ? true : null;
        }

        public final int size() {
            return this.a.a();
        }

        public final Object[] toArray() {
            return this.a.b(0);
        }

        public final <T> T[] toArray(T[] tArr) {
            return this.a.a((Object[]) tArr, 0);
        }

        public final boolean equals(Object obj) {
            return g.a((Set) this, obj);
        }

        public final int hashCode() {
            int i = 0;
            for (int a = this.a.a() - 1; a >= 0; a--) {
                int i2;
                Object a2 = this.a.a(a, 0);
                if (a2 == null) {
                    i2 = 0;
                } else {
                    i2 = a2.hashCode();
                }
                i += i2;
            }
            return i;
        }
    }

    /* compiled from: MapCollections */
    final class d implements Iterator<Entry<K, V>>, Entry<K, V> {
        int a;
        int b;
        boolean c = false;
        final /* synthetic */ g d;

        d(g gVar) {
            this.d = gVar;
            this.a = gVar.a() - 1;
            this.b = -1;
        }

        public final boolean hasNext() {
            return this.b < this.a;
        }

        public final void remove() {
            if (this.c) {
                this.d.a(this.b);
                this.b--;
                this.a--;
                this.c = false;
                return;
            }
            throw new IllegalStateException();
        }

        public final K getKey() {
            if (this.c) {
                return this.d.a(this.b, 0);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V getValue() {
            if (this.c) {
                return this.d.a(this.b, 1);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final V setValue(V v) {
            if (this.c) {
                return this.d.a(this.b, (Object) v);
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final boolean equals(Object obj) {
            if (!this.c) {
                throw new IllegalStateException("This container does not support retaining Map.Entry objects");
            } else if (!(obj instanceof Entry)) {
                return false;
            } else {
                Entry entry = (Entry) obj;
                if (!f.a(entry.getKey(), this.d.a(this.b, 0)) || f.a(entry.getValue(), this.d.a(this.b, 1)) == null) {
                    return false;
                }
                return true;
            }
        }

        public final int hashCode() {
            if (this.c) {
                int i;
                int i2 = 0;
                Object a = this.d.a(this.b, 0);
                Object a2 = this.d.a(this.b, 1);
                if (a == null) {
                    i = 0;
                } else {
                    i = a.hashCode();
                }
                if (a2 != null) {
                    i2 = a2.hashCode();
                }
                return i ^ i2;
            }
            throw new IllegalStateException("This container does not support retaining Map.Entry objects");
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getKey());
            stringBuilder.append("=");
            stringBuilder.append(getValue());
            return stringBuilder.toString();
        }

        public final /* bridge */ /* synthetic */ Object next() {
            this.b++;
            this.c = true;
            return this;
        }
    }

    /* compiled from: MapCollections */
    final class e implements Collection<V> {
        final /* synthetic */ g a;

        e(g gVar) {
            this.a = gVar;
        }

        public final boolean add(V v) {
            throw new UnsupportedOperationException();
        }

        public final boolean addAll(Collection<? extends V> collection) {
            throw new UnsupportedOperationException();
        }

        public final void clear() {
            this.a.c();
        }

        public final boolean contains(Object obj) {
            return this.a.b(obj) >= null ? true : null;
        }

        public final boolean containsAll(Collection<?> collection) {
            for (Object contains : collection) {
                if (!contains(contains)) {
                    return null;
                }
            }
            return true;
        }

        public final boolean isEmpty() {
            return this.a.a() == 0;
        }

        public final Iterator<V> iterator() {
            return new a(this.a, 1);
        }

        public final boolean remove(Object obj) {
            int b = this.a.b(obj);
            if (b < null) {
                return null;
            }
            this.a.a(b);
            return true;
        }

        public final boolean removeAll(Collection<?> collection) {
            int a = this.a.a();
            int i = 0;
            boolean z = false;
            while (i < a) {
                if (collection.contains(this.a.a(i, 1))) {
                    this.a.a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public final boolean retainAll(Collection<?> collection) {
            int a = this.a.a();
            int i = 0;
            boolean z = false;
            while (i < a) {
                if (!collection.contains(this.a.a(i, 1))) {
                    this.a.a(i);
                    i--;
                    a--;
                    z = true;
                }
                i++;
            }
            return z;
        }

        public final int size() {
            return this.a.a();
        }

        public final Object[] toArray() {
            return this.a.b(1);
        }

        public final <T> T[] toArray(T[] tArr) {
            return this.a.a((Object[]) tArr, 1);
        }
    }

    protected abstract int a();

    protected abstract int a(Object obj);

    protected abstract Object a(int i, int i2);

    protected abstract V a(int i, V v);

    protected abstract void a(int i);

    protected abstract void a(K k, V v);

    protected abstract int b(Object obj);

    protected abstract Map<K, V> b();

    protected abstract void c();

    g() {
    }

    public final Object[] b(int i) {
        int a = a();
        Object[] objArr = new Object[a];
        for (int i2 = 0; i2 < a; i2++) {
            objArr[i2] = a(i2, i);
        }
        return objArr;
    }

    public final <T> T[] a(T[] tArr, int i) {
        int a = a();
        if (tArr.length < a) {
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), a);
        }
        for (int i2 = 0; i2 < a; i2++) {
            tArr[i2] = a(i2, i);
        }
        if (tArr.length > a) {
            tArr[a] = 0;
        }
        return tArr;
    }

    public static <T> boolean a(java.util.Set<T> r4, java.lang.Object r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 1;
        if (r4 != r5) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r5 instanceof java.util.Set;
        r2 = 0;
        if (r1 == 0) goto L_0x001f;
    L_0x0009:
        r5 = (java.util.Set) r5;
        r1 = r4.size();	 Catch:{ NullPointerException -> 0x001e, ClassCastException -> 0x001d }
        r3 = r5.size();	 Catch:{ NullPointerException -> 0x001e, ClassCastException -> 0x001d }
        if (r1 != r3) goto L_0x001c;	 Catch:{ NullPointerException -> 0x001e, ClassCastException -> 0x001d }
    L_0x0015:
        r4 = r4.containsAll(r5);	 Catch:{ NullPointerException -> 0x001e, ClassCastException -> 0x001d }
        if (r4 == 0) goto L_0x001c;
    L_0x001b:
        return r0;
    L_0x001c:
        return r2;
    L_0x001d:
        return r2;
    L_0x001e:
        return r2;
    L_0x001f:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qihoo360.replugin.utils.a.g.a(java.util.Set, java.lang.Object):boolean");
    }

    public final Set<K> d() {
        if (this.c == null) {
            this.c = new c(this);
        }
        return this.c;
    }
}
