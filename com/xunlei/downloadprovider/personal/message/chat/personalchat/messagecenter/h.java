package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter;

import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.pushmessage.l;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: MessageCenterHelper */
public final class h {
    private static AtomicInteger a = new AtomicInteger();

    public static void a() {
        l.a(BrothersApplication.getApplicationInstance());
        com.xunlei.downloadprovider.notification.h.a();
    }

    public static void b() {
        a.incrementAndGet();
    }

    public static void c() {
        a.decrementAndGet();
    }

    public static boolean d() {
        return a.get() != 0;
    }
}
