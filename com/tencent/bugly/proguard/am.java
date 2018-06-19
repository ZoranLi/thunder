package com.tencent.bugly.proguard;

import com.tencent.bugly.b;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* compiled from: BUGLY */
public class am {
    static am a;
    private ScheduledExecutorService b;

    protected am() {
        this.b = null;
        this.b = Executors.newScheduledThreadPool(3, new ThreadFactory(this) {
            final /* synthetic */ am a;

            {
                this.a = r1;
            }

            public Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable);
                thread.setName("BUGLY_THREAD");
                return thread;
            }
        });
        if (this.b == null || this.b.isShutdown()) {
            an.d("[AsyncTaskHandler] ScheduledExecutorService is not valiable!", new Object[0]);
        }
    }

    public static synchronized am a() {
        am amVar;
        synchronized (am.class) {
            if (a == null) {
                a = new am();
            }
            amVar = a;
        }
        return amVar;
    }

    public synchronized boolean a(Runnable runnable, long j) {
        if (!c()) {
            an.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        } else if (runnable == null) {
            an.d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        } else {
            if (j <= 0) {
                j = 0;
            }
            an.c("[AsyncTaskHandler] Post a delay(time: %dms) task: %s", Long.valueOf(j), runnable.getClass().getName());
            try {
                this.b.schedule(runnable, j, TimeUnit.MILLISECONDS);
                return true;
            } catch (Runnable runnable2) {
                if (b.c != null) {
                    runnable2.printStackTrace();
                }
                return false;
            }
        }
    }

    public synchronized boolean a(Runnable runnable) {
        if (!c()) {
            an.d("[AsyncTaskHandler] Async handler was closed, should not post task.", new Object[0]);
            return false;
        } else if (runnable == null) {
            an.d("[AsyncTaskHandler] Task input is null.", new Object[0]);
            return false;
        } else {
            an.c("[AsyncTaskHandler] Post a normal task: %s", runnable.getClass().getName());
            try {
                this.b.execute(runnable);
                return true;
            } catch (Runnable runnable2) {
                if (b.c) {
                    runnable2.printStackTrace();
                }
                return false;
            }
        }
    }

    public synchronized void b() {
        if (!(this.b == null || this.b.isShutdown())) {
            an.c("[AsyncTaskHandler] Close async handler.", new Object[0]);
            this.b.shutdownNow();
        }
    }

    public synchronized boolean c() {
        boolean z;
        z = (this.b == null || this.b.isShutdown()) ? false : true;
        return z;
    }
}
