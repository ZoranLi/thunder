package com.alibaba.sdk.android.a;

import java.lang.Thread.UncaughtExceptionHandler;

public class f implements UncaughtExceptionHandler {
    public void uncaughtException(Thread thread, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder("Catch an uncaught exception, ");
        stringBuilder.append(thread.getName());
        stringBuilder.append(", error message: ");
        stringBuilder.append(th.getMessage());
        th.printStackTrace();
    }
}
