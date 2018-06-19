package com.alibaba.mtl.appmonitor;

/* compiled from: AppMonitor */
final class e implements Runnable {
    e() {
    }

    public final void run() {
        try {
            AppMonitor.a.c();
        } catch (Exception e) {
            AppMonitor.a(e);
        }
    }
}
