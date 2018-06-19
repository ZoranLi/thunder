package com.xunlei.downloadprovider.personal.lixianspace;

import com.xunlei.downloadprovider.member.payment.c.c;
import java.util.concurrent.ExecutorService;

/* compiled from: LXThreadPool */
public final class b {
    private ExecutorService a;

    /* compiled from: LXThreadPool */
    private static class a {
        private static final b a = new b();
    }

    private b() {
        this.a = c.a("lx-common");
    }

    public final void a(Runnable runnable) {
        this.a.execute(runnable);
    }
}
