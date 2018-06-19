package com.xunlei.downloadprovider.cardslide.a;

/* compiled from: CardSlideCacheHelper */
public class a {
    private static a a;

    private a() {
    }

    public static a a() {
        if (a == null) {
            synchronized (a.class) {
                if (a == null) {
                    a = new a();
                }
            }
        }
        return a;
    }
}
