package com.xunlei.downloadprovider.personal.message.chat.personalchat.messagecenter;

import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.h.f;

/* compiled from: MessageCenterConfig */
public final class d {
    private static boolean a = true;
    private static boolean b = false;
    private static boolean c = true;
    private static boolean d = false;

    public static boolean b() {
        if (!b) {
            b = true;
            a = f.b(BrothersApplication.getApplicationInstance(), "isChatSwitchOn", true);
        }
        return a;
    }

    public static boolean c() {
        if (!d) {
            d = true;
            c = f.b(BrothersApplication.getApplicationInstance(), "isChatEnabled", true);
        }
        return c;
    }

    public static void a() {
        f.a(BrothersApplication.getApplicationInstance(), "isChatSwitchOn", com.xunlei.downloadprovider.d.d.a().q.a());
        f.a(BrothersApplication.getApplicationInstance(), "isChatEnabled", com.xunlei.downloadprovider.d.d.a().q.b());
    }
}
