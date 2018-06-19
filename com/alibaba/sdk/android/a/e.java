package com.alibaba.sdk.android.a;

import java.util.concurrent.ThreadFactory;

public class e implements ThreadFactory {
    public Thread newThread(Runnable runnable) {
        Thread thread = new Thread(runnable);
        thread.setUncaughtExceptionHandler(new f());
        return thread;
    }
}
