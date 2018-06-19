package com.ali.auth.third.core.g.a;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.UUID;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public final class a implements com.ali.auth.third.core.g.b {
    private Map<Class<?>, List<b>> a = new HashMap();
    private Map<com.ali.auth.third.core.g.a, b> b = new HashMap();
    private ReadWriteLock c = new ReentrantReadWriteLock();

    static class b {
        public Class<?>[] a;
        public Object b;
        public Map<String, String> c;

        b() {
        }
    }

    static class a implements com.ali.auth.third.core.g.a {
        private final String a = UUID.randomUUID().toString();
        private com.ali.auth.third.core.g.b b;
        private Map<String, String> c;

        public a(com.ali.auth.third.core.g.b bVar, Map<String, String> map) {
            this.b = bVar;
            this.c = map;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.a.equals(((a) obj).a);
        }

        public final int hashCode() {
            return 31 + (this.a == null ? 0 : this.a.hashCode());
        }
    }

    public final com.ali.auth.third.core.g.a a(Class<?>[] clsArr, Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("service types and instance must not be null");
        }
        b bVar = new b();
        bVar.b = obj;
        bVar.a = clsArr;
        bVar.c = Collections.synchronizedMap(new HashMap());
        this.c.writeLock().lock();
        int i = 0;
        while (i <= 0) {
            try {
                Object obj2 = clsArr[0];
                List list = (List) this.a.get(obj2);
                if (list == null) {
                    list = new ArrayList(2);
                    this.a.put(obj2, list);
                }
                list.add(bVar);
                i++;
            } catch (Throwable th) {
                this.c.writeLock().unlock();
            }
        }
        com.ali.auth.third.core.g.a aVar = new a(this, bVar.c);
        this.b.put(aVar, bVar);
        this.c.writeLock().unlock();
        return aVar;
    }

    public final <T> T a(Class<T> cls, Map<String, String> map) {
        this.c.readLock().lock();
        try {
            List<b> list = (List) this.a.get(cls);
            if (list != null) {
                if (list.size() != 0) {
                    Object obj;
                    T cast;
                    if (map != null) {
                        if (map.size() != 0) {
                            for (b bVar : list) {
                                int i = 1;
                                for (Entry entry : map.entrySet()) {
                                    String str = (String) bVar.c.get(entry.getKey());
                                    if (str != null) {
                                        if (!str.equals(entry.getValue())) {
                                        }
                                    }
                                    i = 0;
                                    continue;
                                }
                                if (i != 0) {
                                    obj = bVar.b;
                                    cast = cls.cast(obj);
                                    this.c.readLock().unlock();
                                    return cast;
                                }
                            }
                        }
                    }
                    obj = ((b) list.get(0)).b;
                    cast = cls.cast(obj);
                    this.c.readLock().unlock();
                    return cast;
                }
            }
            this.c.readLock().unlock();
            return null;
        } catch (Throwable th) {
            this.c.readLock().unlock();
        }
    }
}
