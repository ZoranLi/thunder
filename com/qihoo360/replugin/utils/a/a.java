package com.qihoo360.replugin.utils.a;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/* compiled from: ArrayMap */
public class a<K, V> extends i<K, V> implements Map<K, V> {
    g<K, V> a;

    private g<K, V> a() {
        if (this.a == null) {
            this.a = new b(this);
        }
        return this.a;
    }

    public void putAll(Map<? extends K, ? extends V> map) {
        int size = this.h + map.size();
        if (this.f.length < size) {
            Object obj = this.f;
            Object obj2 = this.g;
            super.a(size);
            if (this.h > 0) {
                System.arraycopy(obj, 0, this.f, 0, this.h);
                System.arraycopy(obj2, 0, this.g, 0, this.h << 1);
            }
            i.a(obj, obj2, this.h);
        }
        map = map.entrySet().iterator();
        while (map.hasNext()) {
            Entry entry = (Entry) map.next();
            put(entry.getKey(), entry.getValue());
        }
    }

    public Set<Entry<K, V>> entrySet() {
        g a = a();
        if (a.b == null) {
            a.b = new b(a);
        }
        return a.b;
    }

    public Set<K> keySet() {
        return a().d();
    }

    public Collection<V> values() {
        g a = a();
        if (a.d == null) {
            a.d = new e(a);
        }
        return a.d;
    }
}
