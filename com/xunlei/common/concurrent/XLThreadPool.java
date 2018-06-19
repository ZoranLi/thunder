package com.xunlei.common.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

public abstract class XLThreadPool {
    private static ExecutorService sExecutorService = Executors.newFixedThreadPool(8);
    private static ScheduledExecutorService sScheduledExecutorService = Executors.newScheduledThreadPool(2);
    private static ExecutorService sSingleThreadExecutorService = Executors.newSingleThreadExecutor();

    public static ExecutorService getExecutorService() {
        return sExecutorService;
    }

    public static ExecutorService getSingleThreadExecutorService() {
        return sSingleThreadExecutorService;
    }

    public static ScheduledExecutorService getScheduledExecutorService() {
        return sScheduledExecutorService;
    }

    public static void execute(Runnable runnable) {
        sExecutorService.execute(runnable);
    }

    public static <T> Future<T> submit(Callable<T> callable) {
        return sExecutorService.submit(callable);
    }

    public static <T> Future<T> submit(Runnable runnable, T t) {
        return sExecutorService.submit(runnable, t);
    }

    public static Future<?> submit(Runnable runnable) {
        return sExecutorService.submit(runnable);
    }

    public static void sendCommand(XLCommand xLCommand, XLCommandListener xLCommandListener) {
        if (xLCommand != null && xLCommandListener != null) {
            xLCommand.setResponse(xLCommandListener);
            sExecutorService.submit(xLCommand);
        }
    }

    public static void sendCommand(Runnable runnable, ExecutorService executorService) {
        if (executorService != null) {
            executorService.execute(runnable);
        }
    }
}
