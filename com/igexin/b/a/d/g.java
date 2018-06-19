package com.igexin.b.a.d;

import java.util.HashMap;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

final class g {
    final BlockingQueue<e> a = new SynchronousQueue();
    final HashMap<Integer, h> b = new HashMap();
    final ReentrantLock c = new ReentrantLock();
    ThreadFactory d = new i(this);
    volatile long e = TimeUnit.SECONDS.toNanos(60);
    volatile int f = 0;
    volatile int g;
    volatile int h = Integer.MAX_VALUE;
    final /* synthetic */ f i;

    public g(f fVar) {
        this.i = fVar;
    }

    final com.igexin.b.a.d.e a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r4 = this;
    L_0x0000:
        r0 = r4.g;	 Catch:{ InterruptedException -> 0x0000 }
        r1 = r4.f;	 Catch:{ InterruptedException -> 0x0000 }
        if (r0 <= r1) goto L_0x0013;	 Catch:{ InterruptedException -> 0x0000 }
    L_0x0006:
        r0 = r4.a;	 Catch:{ InterruptedException -> 0x0000 }
        r1 = r4.e;	 Catch:{ InterruptedException -> 0x0000 }
        r3 = java.util.concurrent.TimeUnit.NANOSECONDS;	 Catch:{ InterruptedException -> 0x0000 }
        r0 = r0.poll(r1, r3);	 Catch:{ InterruptedException -> 0x0000 }
    L_0x0010:
        r0 = (com.igexin.b.a.d.e) r0;	 Catch:{ InterruptedException -> 0x0000 }
        goto L_0x001a;	 Catch:{ InterruptedException -> 0x0000 }
    L_0x0013:
        r0 = r4.a;	 Catch:{ InterruptedException -> 0x0000 }
        r0 = r0.take();	 Catch:{ InterruptedException -> 0x0000 }
        goto L_0x0010;	 Catch:{ InterruptedException -> 0x0000 }
    L_0x001a:
        if (r0 == 0) goto L_0x001d;	 Catch:{ InterruptedException -> 0x0000 }
    L_0x001c:
        return r0;	 Catch:{ InterruptedException -> 0x0000 }
    L_0x001d:
        r0 = r4.a;	 Catch:{ InterruptedException -> 0x0000 }
        r0 = r0.isEmpty();	 Catch:{ InterruptedException -> 0x0000 }
        if (r0 == 0) goto L_0x0000;
    L_0x0025:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.d.g.a():com.igexin.b.a.d.e");
    }

    final void a(e eVar) {
        if (eVar == null) {
            throw new NullPointerException();
        }
        if (eVar.z != 0) {
            ReentrantLock reentrantLock = this.c;
            reentrantLock.lock();
            try {
                h hVar = (h) this.b.get(Integer.valueOf(eVar.z));
                if (hVar != null) {
                    hVar.a.offer(eVar);
                    return;
                }
                reentrantLock.unlock();
            } finally {
                reentrantLock.unlock();
            }
        }
        b(eVar);
    }

    final boolean a(h hVar) {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            int i = this.g - 1;
            this.g = i;
            if (i == 0 && !this.a.isEmpty()) {
                Thread f = f(null);
                if (f != null) {
                    f.start();
                }
            } else if (!hVar.a.isEmpty()) {
                reentrantLock.unlock();
                return true;
            }
            this.b.remove(Integer.valueOf(hVar.d));
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    final void b(e eVar) {
        if (this.g >= this.f || !c(eVar)) {
            if (this.a.offer(eVar)) {
                if (this.g == 0) {
                    e(eVar);
                }
            } else if (!d(eVar)) {
            }
        }
    }

    final boolean c(e eVar) {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            Thread f = this.g < this.f ? f(eVar) : null;
            reentrantLock.unlock();
            if (f == null) {
                return false;
            }
            f.start();
            return true;
        } catch (Throwable th) {
            reentrantLock.unlock();
        }
    }

    final boolean d(e eVar) {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            Thread f = this.g < this.h ? f(eVar) : null;
            reentrantLock.unlock();
            if (f == null) {
                return false;
            }
            f.start();
            return true;
        } catch (Throwable th) {
            reentrantLock.unlock();
        }
    }

    final void e(e eVar) {
        ReentrantLock reentrantLock = this.c;
        reentrantLock.lock();
        try {
            Thread thread = null;
            if (this.g < Math.max(this.f, 1) && !this.a.isEmpty()) {
                thread = f(null);
            }
            reentrantLock.unlock();
            if (thread != null) {
                thread.start();
            }
        } catch (Throwable th) {
            reentrantLock.unlock();
        }
    }

    final Thread f(e eVar) {
        Runnable hVar = new h(this, eVar);
        if (!(eVar == null || eVar.z == 0)) {
            this.b.put(Integer.valueOf(eVar.z), hVar);
        }
        Thread newThread = this.d.newThread(hVar);
        if (newThread != null) {
            this.g++;
        }
        return newThread;
    }
}
