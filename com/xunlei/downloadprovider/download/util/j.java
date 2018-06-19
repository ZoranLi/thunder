package com.xunlei.downloadprovider.download.util;

/* compiled from: TaskDetailUtil */
public class j {
    private static j c;
    public boolean a;
    public long b;

    private j() {
    }

    public static j a() {
        if (c == null) {
            synchronized (j.class) {
                if (c == null) {
                    c = new j();
                }
            }
        }
        return c;
    }
}
