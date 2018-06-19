package anet.channel.a;

import anet.channel.util.ALog;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
public class c {
    private static volatile ScheduledExecutorService a;
    private static volatile b b;

    /* compiled from: Taobao */
    static class a implements ThreadFactory {
        AtomicInteger a = new AtomicInteger(0);
        String b;

        a(String str) {
            this.b = str;
        }

        public Thread newThread(Runnable runnable) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.b);
            stringBuilder.append(this.a.incrementAndGet());
            Thread thread = new Thread(runnable, stringBuilder.toString());
            ALog.i("awcn.ThreadPoolExecutorFactory", "thread created!", null, com.alipay.sdk.cons.c.e, thread.getName());
            thread.setPriority(5);
            return thread;
        }
    }

    public static Future<?> a(Runnable runnable) {
        return a().submit(runnable);
    }

    public static Future<?> a(Runnable runnable, long j, TimeUnit timeUnit) {
        return a().schedule(runnable, j, timeUnit);
    }

    public static Future<?> b(Runnable runnable) {
        return a(runnable, 0);
    }

    public static Future<?> a(Runnable runnable, int i) {
        if (ALog.isPrintLog(1)) {
            ALog.d("awcn.ThreadPoolExecutorFactory", "submit priority task", null, "priority", Integer.valueOf(i));
        }
        Object aVar = new a(runnable, i);
        b().submit(aVar);
        return aVar;
    }

    static ScheduledExecutorService a() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new ScheduledThreadPoolExecutor(1, new a("AWCN Scheduler"));
                }
            }
        }
        return a;
    }

    static ThreadPoolExecutor b() {
        if (b == null) {
            synchronized (c.class) {
                if (b == null) {
                    b bVar = new b(1, new a("AWCN Dispatcher"));
                    b = bVar;
                    bVar.allowCoreThreadTimeOut(true);
                }
            }
        }
        return b;
    }
}
