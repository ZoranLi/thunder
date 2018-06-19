package com.alibaba.mtl.appmonitor;

/* compiled from: AppMonitor */
final class b implements Runnable {
    final /* synthetic */ boolean a = true;

    b() {
    }

    public final void run() {
        try {
            AppMonitor.a.a(this.a);
        } catch (Exception e) {
            AppMonitor.a(e);
        }
    }
}
