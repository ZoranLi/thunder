package anet.channel.strategy.utils;

import anet.channel.util.ALog;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
public class a {
    private static AtomicInteger a = new AtomicInteger(0);
    private static ScheduledThreadPoolExecutor b;

    static ScheduledThreadPoolExecutor a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(2, new b());
                    b = scheduledThreadPoolExecutor;
                    scheduledThreadPoolExecutor.setKeepAliveTime(60, TimeUnit.SECONDS);
                    b.allowCoreThreadTimeOut(true);
                }
            }
        }
        return b;
    }

    public static void a(Runnable runnable) {
        try {
            a().submit(runnable);
        } catch (Runnable runnable2) {
            ALog.e(b.TAG, "submit task failed", null, runnable2, new Object[0]);
        }
    }

    public static void a(Runnable runnable, long j) {
        try {
            a().schedule(runnable, j, TimeUnit.MILLISECONDS);
        } catch (Runnable runnable2) {
            ALog.e(b.TAG, "schedule task failed", null, runnable2, new Object[0]);
        }
    }
}
