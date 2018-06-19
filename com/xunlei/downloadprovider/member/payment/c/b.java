package com.xunlei.downloadprovider.member.payment.c;

import java.lang.Thread.UncaughtExceptionHandler;
import java.util.Locale;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* compiled from: ThreadFactoryBuilder */
final class b implements ThreadFactory {
    final /* synthetic */ ThreadFactory a;
    final /* synthetic */ String b;
    final /* synthetic */ AtomicLong c;
    final /* synthetic */ Boolean d;
    final /* synthetic */ Integer e;
    final /* synthetic */ UncaughtExceptionHandler f;

    b(ThreadFactory threadFactory, String str, AtomicLong atomicLong, Boolean bool, Integer num, UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.a = threadFactory;
        this.b = str;
        this.c = atomicLong;
        this.d = bool;
        this.e = num;
        this.f = uncaughtExceptionHandler;
    }

    public final Thread newThread(Runnable runnable) {
        runnable = this.a.newThread(runnable);
        if (this.b != null) {
            runnable.setName(String.format(Locale.ROOT, this.b, new Object[]{Long.valueOf(this.c.getAndIncrement())}));
        }
        if (this.d != null) {
            runnable.setDaemon(this.d.booleanValue());
        }
        if (this.e != null) {
            runnable.setPriority(this.e.intValue());
        }
        if (this.f != null) {
            runnable.setUncaughtExceptionHandler(this.f);
        }
        return runnable;
    }
}
