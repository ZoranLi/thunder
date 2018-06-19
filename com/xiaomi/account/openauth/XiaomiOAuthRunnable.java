package com.xiaomi.account.openauth;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

abstract class XiaomiOAuthRunnable<V> implements Runnable {
    private static ExecutorService sTaskExecutor = Executors.newCachedThreadPool();
    protected XiaomiOAuthFutureImpl<V> mFuture = new XiaomiOAuthFutureImpl();

    protected abstract void doRun();

    XiaomiOAuthRunnable() {
    }

    XiaomiOAuthFutureImpl<V> start() {
        sTaskExecutor.execute(this);
        return this.mFuture;
    }

    public final void run() {
        doRun();
    }
}
