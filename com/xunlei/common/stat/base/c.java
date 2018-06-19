package com.xunlei.common.stat.base;

/* compiled from: XLLocker */
public final class c {
    private Object a;

    public c() {
        this.a = null;
        this.a = new Object();
    }

    public final void a(long j) {
        synchronized (this.a) {
            try {
                this.a.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public final void a() {
        synchronized (this.a) {
            this.a.notify();
        }
    }
}
