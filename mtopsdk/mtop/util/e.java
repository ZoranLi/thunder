package mtopsdk.mtop.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import mtopsdk.common.util.j;

public class e {
    private static int a = 10;
    private static volatile ThreadPoolExecutor b;
    private static volatile ThreadPoolExecutor c;
    private static volatile ExecutorService[] d;

    public static Future a(int i, Runnable runnable) {
        try {
            return c()[Math.abs(i % c().length)].submit(runnable);
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("[submitCallbackTask]submit runnable to Mtop Callback ThreadPool error ---");
            stringBuilder.append(th.toString());
            j.e(stringBuilder.toString());
            return null;
        }
    }

    public static Future a(Runnable runnable) {
        try {
            return b().submit(runnable);
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("[submit]submit runnable to Mtop Default ThreadPool error ---");
            stringBuilder.append(th.toString());
            j.e(stringBuilder.toString());
            return null;
        }
    }

    public static ThreadPoolExecutor a() {
        if (c == null) {
            synchronized (e.class) {
                if (c == null) {
                    c = a(4, 4, 0, new f(a, "RequestPool"));
                }
            }
        }
        return c;
    }

    private static ThreadPoolExecutor a(int i, int i2, int i3, ThreadFactory threadFactory) {
        return new ThreadPoolExecutor(i, i2, 1, TimeUnit.SECONDS, i3 > 0 ? new LinkedBlockingQueue(i3) : new LinkedBlockingQueue(), threadFactory);
    }

    private static ThreadPoolExecutor b() {
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    b = a(3, 3, 128, new f(a));
                }
            }
        }
        return b;
    }

    private static ExecutorService[] c() {
        if (d == null) {
            synchronized (e.class) {
                if (d == null) {
                    d = new ExecutorService[2];
                    for (int i = 0; i < 2; i++) {
                        ExecutorService[] executorServiceArr = d;
                        int i2 = a;
                        StringBuilder stringBuilder = new StringBuilder("CallbackPool");
                        stringBuilder.append(i);
                        executorServiceArr[i] = Executors.newSingleThreadExecutor(new f(i2, stringBuilder.toString()));
                    }
                }
            }
        }
        return d;
    }
}
