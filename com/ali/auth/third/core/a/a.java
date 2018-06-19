package com.ali.auth.third.core.a;

import android.os.Build.VERSION;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.ali.auth.third.core.b;

public class a implements b {
    private static volatile a a;

    private a() {
    }

    public static a d() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }

    public final void a() {
        if (VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().flush();
        } else {
            CookieSyncManager.createInstance(com.ali.auth.third.core.c.a.c).sync();
        }
    }

    public final void a(String str, String str2) {
        CookieManager.getInstance().setCookie(str, str2);
    }

    public final void b() {
        CookieManager.getInstance().removeSessionCookie();
    }

    public final void c() {
        CookieManager.getInstance().removeExpiredCookie();
    }
}
