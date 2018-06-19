package com.igexin.b.a.d;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

final class i implements ThreadFactory {
    final AtomicInteger a = new AtomicInteger(0);
    final /* synthetic */ g b;

    public i(g gVar) {
        this.b = gVar;
    }

    public final Thread newThread(Runnable runnable) {
        StringBuilder stringBuilder = new StringBuilder("TS-pool-");
        stringBuilder.append(this.a.incrementAndGet());
        return new Thread(runnable, stringBuilder.toString());
    }
}
