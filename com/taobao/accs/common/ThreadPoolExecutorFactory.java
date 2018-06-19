package com.taobao.accs.common;

import com.taobao.accs.utl.ALog;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
public class ThreadPoolExecutorFactory {
    private static final String TAG = "ThreadPoolExecutorFactory";
    private static final AtomicInteger integer = new AtomicInteger();
    private static volatile ScheduledThreadPoolExecutor scheduleThreadPoolExecutor;
    private static volatile ScheduledThreadPoolExecutor sendThreadPoolExecutor;

    /* compiled from: Taobao */
    static class a implements ThreadFactory {
        private String a;

        public a(String str) {
            this.a = str;
        }

        public Thread newThread(Runnable runnable) {
            int andIncrement = ThreadPoolExecutorFactory.integer.getAndIncrement();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.a);
            stringBuilder.append(andIncrement);
            Thread thread = new Thread(runnable, stringBuilder.toString());
            thread.setPriority(5);
            return thread;
        }
    }

    public static ScheduledThreadPoolExecutor getScheduledExecutor() {
        if (scheduleThreadPoolExecutor == null) {
            synchronized (ThreadPoolExecutorFactory.class) {
                if (scheduleThreadPoolExecutor == null) {
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new a("ACCS"));
                    scheduleThreadPoolExecutor = scheduledThreadPoolExecutor;
                    scheduledThreadPoolExecutor.setKeepAliveTime(60, TimeUnit.SECONDS);
                    scheduleThreadPoolExecutor.allowCoreThreadTimeOut(true);
                }
            }
        }
        return scheduleThreadPoolExecutor;
    }

    public static ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        try {
            return getScheduledExecutor().schedule(runnable, j, timeUnit);
        } catch (Runnable runnable2) {
            ALog.e(TAG, "ThreadPoolExecutorFactory schedule", runnable2, new Object[null]);
            return null;
        }
    }

    public static void execute(Runnable runnable) {
        try {
            getScheduledExecutor().execute(runnable);
        } catch (Runnable runnable2) {
            ALog.e(TAG, "ThreadPoolExecutorFactory execute", runnable2, new Object[0]);
        }
    }

    public static ScheduledThreadPoolExecutor getSendScheduledExecutor() {
        if (sendThreadPoolExecutor == null) {
            synchronized (ThreadPoolExecutorFactory.class) {
                if (sendThreadPoolExecutor == null) {
                    ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, new a("ACCS-SEND"));
                    sendThreadPoolExecutor = scheduledThreadPoolExecutor;
                    scheduledThreadPoolExecutor.setKeepAliveTime(60, TimeUnit.SECONDS);
                    sendThreadPoolExecutor.allowCoreThreadTimeOut(true);
                }
            }
        }
        return sendThreadPoolExecutor;
    }
}
