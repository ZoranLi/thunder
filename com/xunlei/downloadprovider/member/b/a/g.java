package com.xunlei.downloadprovider.member.b.a;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: VipRenewalUpdateSchedule */
public final class g {
    public boolean a;
    final ScheduledExecutorService b;

    /* compiled from: VipRenewalUpdateSchedule */
    private static class a {
        public static final g a = new g();
    }

    private g() {
        this.b = Executors.newScheduledThreadPool(1);
    }
}
