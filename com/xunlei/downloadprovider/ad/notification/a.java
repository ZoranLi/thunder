package com.xunlei.downloadprovider.ad.notification;

import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.d.d;
import com.xunlei.downloadprovider.h.f;

/* compiled from: NotificationADConfig */
public final class a {
    private static boolean a = true;
    private static boolean b = false;

    public static boolean b() {
        if (!b) {
            b = true;
            a = f.b(BrothersApplication.getApplicationInstance(), "isGetuiNotiADEnabled", true);
        }
        return a;
    }

    public static void a() {
        f.a(BrothersApplication.getApplicationInstance(), "isGetuiNotiADEnabled", d.a().p.p());
    }
}
