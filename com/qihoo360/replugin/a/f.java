package com.qihoo360.replugin.a;

import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: ThreadUtils */
final class f implements Runnable {
    final /* synthetic */ AtomicReference a;
    final /* synthetic */ Callable b;
    final /* synthetic */ AtomicReference c;
    final /* synthetic */ CountDownLatch d;

    f(AtomicReference atomicReference, Callable callable, AtomicReference atomicReference2, CountDownLatch countDownLatch) {
        this.a = atomicReference;
        this.b = callable;
        this.c = atomicReference2;
        this.d = countDownLatch;
    }

    public final void run() {
        try {
            this.a.set(this.b.call());
        } catch (Throwable th) {
            this.c.set(th);
        }
        this.d.countDown();
    }
}
