package com.xunlei.downloadprovider.personal.message.chat.chatengine.b;

import java.util.HashMap;

/* compiled from: ChatModule */
public final class u {
    private static final HashMap<Class<?>, Object> a = new HashMap();
    private ag b = null;
    private ae c = null;

    /* compiled from: ChatModule */
    static class a {
        public static u a = new u();
    }

    public static u a() {
        return a.a;
    }

    public final synchronized void b() {
        a.put(aa.class, b.a());
        a.put(ac.class, s.a());
        a.put(ad.class, v.a());
        a.put(a.class, a.a());
        a.put(ab.class, n.a());
    }

    public static <T> T a(Class<T> cls) {
        cls = a.get(cls);
        return cls != null ? cls : null;
    }

    public final synchronized ag c() {
        if (this.b == null) {
            this.b = new ag();
        }
        return this.b;
    }

    public final synchronized ae d() {
        if (this.c == null) {
            this.c = new ae();
        }
        return this.c;
    }
}
