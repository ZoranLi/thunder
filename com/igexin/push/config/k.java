package com.igexin.push.config;

import com.igexin.push.core.g;

public class k {
    private static k a;

    private k() {
    }

    public static synchronized k a() {
        k kVar;
        synchronized (k.class) {
            if (a == null) {
                a = new k();
            }
            kVar = a;
        }
        return kVar;
    }

    public boolean b() {
        p.a();
        n.a();
        n.b(g.f);
        n.a(g.f);
        return true;
    }
}
