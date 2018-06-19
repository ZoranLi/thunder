package android.arch.a.a;

import android.support.annotation.NonNull;
import android.support.annotation.RestrictTo;
import android.support.annotation.RestrictTo.Scope;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.WeakHashMap;

@RestrictTo({Scope.LIBRARY_GROUP})
/* compiled from: SafeIterableMap */
public class b<K, V> implements Iterable<Entry<K, V>> {
    public c<K, V> b;
    public c<K, V> c;
    public WeakHashMap<Object<K, V>, Boolean> d = new WeakHashMap();
    public int e = 0;

    /* compiled from: SafeIterableMap */
    static class c<K, V> implements Entry<K, V> {
        @NonNull
        final K a;
        @NonNull
        final V b;
        c<K, V> c;
        public c<K, V> d;

        c(@NonNull K k, @NonNull V v) {
            this.a = k;
            this.b = v;
        }

        @NonNull
        public final K getKey() {
            return this.a;
        }

        @NonNull
        public final V getValue() {
            return this.b;
        }

        public final V setValue(V v) {
            throw new UnsupportedOperationException("An entry modification is not supported");
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append("=");
            stringBuilder.append(this.b);
            return stringBuilder.toString();
        }

        public final boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof c)) {
                return false;
            }
            c cVar = (c) obj;
            return this.a.equals(cVar.a) && this.b.equals(cVar.b) != null;
        }
    }

    /* compiled from: SafeIterableMap */
    private class d implements Iterator<Entry<K, V>> {
        final /* synthetic */ b a;
        private c<K, V> b;
        private boolean c;

        private d(b bVar) {
            this.a = bVar;
            this.c = true;
        }

        public final boolean hasNext() {
            return this.c ? this.a.b != null : (this.b == null || this.b.c == null) ? false : true;
        }

        public final /* synthetic */ Object next() {
            c a;
            if (this.c) {
                this.c = false;
                a = this.a.b;
            } else {
                a = this.b != null ? this.b.c : null;
            }
            this.b = a;
            return this.b;
        }
    }

    /* compiled from: SafeIterableMap */
    private static abstract class e<K, V> implements Iterator<Entry<K, V>> {
        c<K, V> a;
        c<K, V> b;

        abstract c<K, V> a(c<K, V> cVar);

        e(c<K, V> cVar, c<K, V> cVar2) {
            this.a = cVar2;
            this.b = cVar;
        }

        public boolean hasNext() {
            return this.b != null;
        }

        public /* synthetic */ Object next() {
            c a;
            c cVar = this.b;
            if (this.b != this.a) {
                if (this.a != null) {
                    a = a(this.b);
                    this.b = a;
                    return cVar;
                }
            }
            a = null;
            this.b = a;
            return cVar;
        }
    }

    /* compiled from: SafeIterableMap */
    static class a<K, V> extends e<K, V> {
        a(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        final c<K, V> a(c<K, V> cVar) {
            return cVar.c;
        }
    }

    /* compiled from: SafeIterableMap */
    private static class b<K, V> extends e<K, V> {
        public b(c<K, V> cVar, c<K, V> cVar2) {
            super(cVar, cVar2);
        }

        final c<K, V> a(c<K, V> cVar) {
            return cVar.d;
        }
    }

    protected c<K, V> a(K k) {
        c<K, V> cVar = this.b;
        while (cVar != null && !cVar.a.equals(k)) {
            cVar = cVar.c;
        }
        return cVar;
    }

    public V a(@NonNull K k, @NonNull V v) {
        c a = a((Object) k);
        if (a != null) {
            return a.b;
        }
        b(k, v);
        return null;
    }

    protected final c<K, V> b(@NonNull K k, @NonNull V v) {
        c<K, V> cVar = new c(k, v);
        this.e++;
        if (this.c == null) {
            this.b = cVar;
            this.c = this.b;
            return cVar;
        }
        this.c.c = cVar;
        cVar.d = this.c;
        this.c = cVar;
        return cVar;
    }

    @NonNull
    public Iterator<Entry<K, V>> iterator() {
        Iterator aVar = new a(this.b, this.c);
        this.d.put(aVar, Boolean.valueOf(false));
        return aVar;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        if (this.e != bVar.e) {
            return false;
        }
        Iterator it = iterator();
        obj = bVar.iterator();
        while (it.hasNext() && obj.hasNext()) {
            Entry entry = (Entry) it.next();
            Object next = obj.next();
            if ((entry == null && next != null) || (entry != null && !entry.equals(next))) {
                return false;
            }
        }
        return !it.hasNext() && obj.hasNext() == null;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        Iterator it = iterator();
        while (it.hasNext()) {
            stringBuilder.append(((Entry) it.next()).toString());
            if (it.hasNext()) {
                stringBuilder.append(", ");
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
