package com.alipay.apmobilesecuritysdk.g;

import java.util.LinkedList;

public final class b {
    private static b a = new b();
    private Thread b = null;
    private LinkedList<Runnable> c = new LinkedList();

    public static b a() {
        return a;
    }

    public final synchronized void a(Runnable runnable) {
        this.c.add(runnable);
        if (this.b == null) {
            this.b = new Thread(new c(this));
            this.b.start();
        }
    }
}
