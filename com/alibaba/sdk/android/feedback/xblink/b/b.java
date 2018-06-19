package com.alibaba.sdk.android.feedback.xblink.b;

import android.app.Application;

public class b {
    public static boolean a = true;
    public static String b = a.ONLINE.a();
    public static String c = a.ONLINE.b();
    public static Application d;
    private static b h;
    private String e;
    private String f;
    private String g;

    private b() {
    }

    public static synchronized b a() {
        b bVar;
        synchronized (b.class) {
            if (h == null) {
                h = new b();
            }
            bVar = h;
        }
        return bVar;
    }

    public String b() {
        return this.e;
    }

    public String c() {
        return this.f;
    }

    public String d() {
        return this.g;
    }
}
