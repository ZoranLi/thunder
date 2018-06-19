package com.xunlei.downloadprovider.personal.message.chat.chatengine.b;

import com.xunlei.downloadprovider.personal.message.chat.b;
import com.xunlei.downloadprovider.personal.message.chat.c;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ChatManager */
public final class q {
    private static final int a;
    private static final int b;
    private static final int c = ((a * 2) + 1);
    private static Executor d;

    /* compiled from: ChatManager */
    public static class a<T> implements c<T> {
        public final void a(b bVar) {
        }

        public final void a(T t) {
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        a = availableProcessors;
        b = availableProcessors + 1;
    }

    public static synchronized Executor a() {
        Executor executor;
        synchronized (q.class) {
            if (d == null) {
                d = new ThreadPoolExecutor(b, c, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
            }
            executor = d;
        }
        return executor;
    }
}
