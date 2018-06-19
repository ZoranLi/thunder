package com.sina.weibo.sdk.statistic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class WBAgentExecutor {
    private static long TIMEOUT = 5;
    private static ExecutorService mExecutor = Executors.newSingleThreadExecutor();

    WBAgentExecutor() {
    }

    public static synchronized void execute(Runnable runnable) {
        synchronized (WBAgentExecutor.class) {
            if (mExecutor.isShutdown()) {
                mExecutor = Executors.newSingleThreadExecutor();
            }
            mExecutor.execute(runnable);
        }
    }

    public static synchronized void shutDownExecutor() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.sina.weibo.sdk.statistic.WBAgentExecutor.class;
        monitor-enter(r0);
        r1 = mExecutor;	 Catch:{ Exception -> 0x001e, all -> 0x001b }
        r1 = r1.isShutdown();	 Catch:{ Exception -> 0x001e, all -> 0x001b }
        if (r1 != 0) goto L_0x0010;	 Catch:{ Exception -> 0x001e, all -> 0x001b }
    L_0x000b:
        r1 = mExecutor;	 Catch:{ Exception -> 0x001e, all -> 0x001b }
        r1.shutdown();	 Catch:{ Exception -> 0x001e, all -> 0x001b }
    L_0x0010:
        r1 = mExecutor;	 Catch:{ Exception -> 0x001e, all -> 0x001b }
        r2 = TIMEOUT;	 Catch:{ Exception -> 0x001e, all -> 0x001b }
        r4 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ Exception -> 0x001e, all -> 0x001b }
        r1.awaitTermination(r2, r4);	 Catch:{ Exception -> 0x001e, all -> 0x001b }
        monitor-exit(r0);
        return;
    L_0x001b:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
    L_0x001e:
        monitor-exit(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.statistic.WBAgentExecutor.shutDownExecutor():void");
    }
}
