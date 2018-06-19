package anet.channel.a;

import anet.channel.monitor.a;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Taobao */
class d {
    private static volatile ThreadPoolExecutor a;
    private static volatile ThreadPoolExecutor b;

    d() {
    }

    static ThreadPoolExecutor a() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 6, 60, TimeUnit.SECONDS, new ArrayBlockingQueue(8), new a("AWCN Worker(H)"));
                    a = threadPoolExecutor;
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    c();
                }
            }
        }
        return a;
    }

    static ThreadPoolExecutor b() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingDeque(), new a("AWCN Worker(L)"));
                    b = threadPoolExecutor;
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
            }
        }
        return b;
    }

    private static void c() {
        a.a().a(new e(), new f());
    }
}
