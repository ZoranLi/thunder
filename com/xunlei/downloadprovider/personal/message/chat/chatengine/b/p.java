package com.xunlei.downloadprovider.personal.message.chat.chatengine.b;

/* compiled from: ChatEngine */
public final class p {
    private static boolean a = false;

    public static synchronized void a() {
        synchronized (p.class) {
            if (!a) {
                u.a().b();
                a.a();
                a = true;
            }
        }
    }

    public static boolean b() {
        return a;
    }

    public static <T> T a(Class<T> cls) {
        if (!a) {
            a();
        }
        u.a();
        return u.a(cls);
    }
}
