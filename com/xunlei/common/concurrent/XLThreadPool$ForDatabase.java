package com.xunlei.common.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class XLThreadPool$ForDatabase {
    private static ExecutorService sSingleReadThreadExecutor = Executors.newSingleThreadExecutor();
    private static ExecutorService sSingleWriteThreadExecutor = Executors.newSingleThreadExecutor();

    private XLThreadPool$ForDatabase() {
    }

    public static void executeRead(Runnable runnable) {
        sSingleReadThreadExecutor.execute(runnable);
    }

    public static void executeWrite(Runnable runnable) {
        sSingleWriteThreadExecutor.execute(runnable);
    }
}
