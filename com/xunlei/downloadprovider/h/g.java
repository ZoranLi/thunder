package com.xunlei.downloadprovider.h;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: PollingScheduler */
public class g {
    private static final String b = "g";
    private static g c;
    ScheduledExecutorService a = Executors.newSingleThreadScheduledExecutor();

    private g() {
    }

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (c == null) {
                c = new g();
            }
            if (c.a.isShutdown()) {
                c.a = Executors.newSingleThreadScheduledExecutor();
            }
            gVar = c;
        }
        return gVar;
    }
}
