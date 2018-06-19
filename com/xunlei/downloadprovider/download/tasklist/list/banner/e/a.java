package com.xunlei.downloadprovider.download.tasklist.list.banner.e;

/* compiled from: SpeedShareGuideBannerHelper */
public class a {
    private static a b;
    public boolean a = false;

    private a() {
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }
}
