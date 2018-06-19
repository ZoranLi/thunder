package com.alibaba.mtl.appmonitor;

/* compiled from: AppMonitor */
public final class o implements Runnable {
    final /* synthetic */ int a;

    public o(int i) {
        this.a = i;
    }

    public final void run() {
        try {
            AppMonitor.a.j(this.a);
        } catch (Exception e) {
            AppMonitor.a(e);
        }
    }
}
