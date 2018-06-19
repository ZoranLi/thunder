package com.ali.auth.third.core.h.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class c implements ThreadFactory {
    final /* synthetic */ b a;
    private final AtomicInteger b = new AtomicInteger(1);

    c(b bVar) {
        this.a = bVar;
    }

    public final Thread newThread(Runnable runnable) {
        StringBuilder stringBuilder = new StringBuilder("ExecutorTask #");
        stringBuilder.append(this.b.getAndIncrement());
        return new Thread(runnable, stringBuilder.toString());
    }
}
