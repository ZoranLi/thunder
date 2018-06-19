package com.alibaba.mtl.appmonitor.c;

import com.alibaba.mtl.appmonitor.b.b;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BalancedPool */
public final class a {
    private static a b = new a();
    private Map<Class<? extends b>, c<? extends b>> a = new HashMap();

    public static a a() {
        return b;
    }

    private a() {
    }

    public final <T extends b> T a(Class<T> cls, Object... objArr) {
        c a = a((Class) cls);
        c.c.getAndIncrement();
        a.a.getAndIncrement();
        b bVar = (b) a.e.poll();
        if (bVar != null) {
            a.f.remove(Integer.valueOf(System.identityHashCode(bVar)));
            a.b.getAndIncrement();
            c.d.getAndIncrement();
        }
        if (bVar == null) {
            try {
                cls = (b) cls.newInstance();
            } catch (Class<T> cls2) {
                b.a(cls2);
            }
            if (cls2 != null) {
                cls2.a(objArr);
            }
            return cls2;
        }
        cls2 = bVar;
        if (cls2 != null) {
            cls2.a(objArr);
        }
        return cls2;
    }

    public final <T extends b> void a(T t) {
        if (!(t == null || (t instanceof e))) {
            if (!(t instanceof d)) {
                c a = a(t.getClass());
                t.d();
                if (a.e.size() < 20) {
                    synchronized (a.f) {
                        int identityHashCode = System.identityHashCode(t);
                        if (!a.f.contains(Integer.valueOf(identityHashCode))) {
                            a.f.add(Integer.valueOf(identityHashCode));
                            a.e.offer(t);
                        }
                    }
                }
            }
        }
    }

    private synchronized <T extends b> c<T> a(Class<T> cls) {
        c<T> cVar;
        cVar = (c) this.a.get(cls);
        if (cVar == null) {
            cVar = new c();
            this.a.put(cls, cVar);
        }
        return cVar;
    }
}
