package com.taobao.accs.net;

import anet.channel.appmonitor.AppMonitor;
import com.taobao.accs.ut.monitor.NetPerformanceMonitor;
import com.taobao.accs.ut.monitor.SessionMonitor;
import com.taobao.accs.ut.monitor.TrafficsMonitor;

/* compiled from: Taobao */
class c implements Runnable {
    final /* synthetic */ b a;

    c(b bVar) {
        this.a = bVar;
    }

    public void run() {
        AppMonitor.getInstance().register(NetPerformanceMonitor.class);
        AppMonitor.getInstance().register(TrafficsMonitor.class);
        AppMonitor.getInstance().register(SessionMonitor.class);
    }
}
