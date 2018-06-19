package com.alibaba.mtl.appmonitor;

import java.util.Map;

/* compiled from: AppMonitor */
final class d implements Runnable {
    final /* synthetic */ Map a;

    d(Map map) {
        this.a = map;
    }

    public final void run() {
        try {
            AppMonitor.a.a(this.a);
        } catch (Exception e) {
            AppMonitor.a(e);
        }
    }
}
