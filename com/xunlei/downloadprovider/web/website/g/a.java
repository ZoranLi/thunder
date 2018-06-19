package com.xunlei.downloadprovider.web.website.g;

import com.xunlei.downloadprovider.web.website.b.b;

/* compiled from: WebsiteDataCache */
public final class a {
    private static a c;
    public b a;
    public b b;

    private a() {
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (c == null) {
                c = new a();
            }
            aVar = c;
        }
        return aVar;
    }
}
