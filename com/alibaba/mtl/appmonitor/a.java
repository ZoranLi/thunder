package com.alibaba.mtl.appmonitor;

/* compiled from: AppMonitor */
final class a implements Runnable {
    final /* synthetic */ int a;

    a(int i) {
        this.a = i;
    }

    public final void run() {
        try {
            AppMonitor.a.a(this.a);
        } catch (Exception e) {
            AppMonitor.a(e);
        }
    }
}
