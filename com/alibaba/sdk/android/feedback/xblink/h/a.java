package com.alibaba.sdk.android.feedback.xblink.h;

import com.alibaba.sdk.android.feedback.xblink.i.g;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class a {
    private static final int a;
    private static final int b;
    private static final int c = ((a * 2) + 1);
    private static a d;
    private ExecutorService e = null;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        a = availableProcessors;
        b = availableProcessors + 1;
    }

    private a() {
        if (this.e == null) {
            this.e = new ThreadPoolExecutor(b, c, 500, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
        }
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (d == null) {
                d = new a();
            }
            aVar = d;
        }
        return aVar;
    }

    public void a(Runnable runnable) {
        if (runnable == null) {
            g.e("WVThreadPool", "execute task is null.");
        } else {
            this.e.execute(runnable);
        }
    }
}
