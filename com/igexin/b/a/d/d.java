package com.igexin.b.a.d;

import com.igexin.b.a.c.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class d<E extends e> {
    static final /* synthetic */ boolean i = true;
    public String a = getClass().getName();
    final transient ReentrantLock b = new ReentrantLock();
    final transient Condition c = this.b.newCondition();
    final TreeSet<E> d;
    final AtomicInteger e = new AtomicInteger(0);
    int f;
    f g;
    public final AtomicLong h = new AtomicLong(-1);

    public d(Comparator<? super E> comparator, f fVar) {
        this.d = new TreeSet(comparator);
        this.g = fVar;
    }

    private E e() {
        E a = a();
        return (a != null && this.d.remove(a)) ? a : null;
    }

    public final int a(E e, long j, TimeUnit timeUnit) {
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            if (!this.d.contains(e)) {
                return -1;
            }
            this.d.remove(e);
            e.u = System.currentTimeMillis() + TimeUnit.MILLISECONDS.convert(j, timeUnit);
            int i = a((e) e) ? 1 : -2;
            reentrantLock.unlock();
            return i;
        } finally {
            reentrantLock.unlock();
        }
    }

    E a() {
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
        r1 = this;
        r0 = r1.d;	 Catch:{ NoSuchElementException -> 0x0009 }
        r0 = r0.first();	 Catch:{ NoSuchElementException -> 0x0009 }
        r0 = (com.igexin.b.a.d.e) r0;	 Catch:{ NoSuchElementException -> 0x0009 }
        return r0;
    L_0x0009:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.d.d.a():E");
    }

    public final boolean a(E r6) {
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
        r5 = this;
        r0 = 0;
        if (r6 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = r5.b;
        r1.lock();
        r2 = r5.a();	 Catch:{ Exception -> 0x0042 }
        r3 = r5.f;	 Catch:{ Exception -> 0x0042 }
        r4 = 1;	 Catch:{ Exception -> 0x0042 }
        r3 = r3 + r4;	 Catch:{ Exception -> 0x0042 }
        r5.f = r3;	 Catch:{ Exception -> 0x0042 }
        r6.v = r3;	 Catch:{ Exception -> 0x0042 }
        r3 = r5.d;	 Catch:{ Exception -> 0x0042 }
        r3 = r3.add(r6);	 Catch:{ Exception -> 0x0042 }
        if (r3 != 0) goto L_0x0026;	 Catch:{ Exception -> 0x0042 }
    L_0x001d:
        r2 = r6.v;	 Catch:{ Exception -> 0x0042 }
        r2 = r2 - r4;	 Catch:{ Exception -> 0x0042 }
        r6.v = r2;	 Catch:{ Exception -> 0x0042 }
        r1.unlock();
        return r0;
    L_0x0026:
        r6.n();	 Catch:{ Exception -> 0x0042 }
        if (r2 == 0) goto L_0x0037;	 Catch:{ Exception -> 0x0042 }
    L_0x002b:
        r3 = r5.d;	 Catch:{ Exception -> 0x0042 }
        r3 = r3.comparator();	 Catch:{ Exception -> 0x0042 }
        r6 = r3.compare(r6, r2);	 Catch:{ Exception -> 0x0042 }
        if (r6 >= 0) goto L_0x003c;	 Catch:{ Exception -> 0x0042 }
    L_0x0037:
        r6 = r5.c;	 Catch:{ Exception -> 0x0042 }
        r6.signalAll();	 Catch:{ Exception -> 0x0042 }
    L_0x003c:
        r1.unlock();
        return r4;
    L_0x0040:
        r6 = move-exception;
        goto L_0x004b;
    L_0x0042:
        r6 = "ScheduleQueue|offer|error";	 Catch:{ all -> 0x0040 }
        com.igexin.b.a.c.a.b(r6);	 Catch:{ all -> 0x0040 }
        r1.unlock();
        return r0;
    L_0x004b:
        r1.unlock();
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.d.d.a(com.igexin.b.a.d.e):boolean");
    }

    public final boolean a(Class cls) {
        if (cls == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            Collection arrayList = new ArrayList();
            Iterator it = this.d.iterator();
            while (it.hasNext()) {
                e eVar = (e) it.next();
                if (eVar.getClass() == cls) {
                    arrayList.add(eVar);
                }
            }
            this.d.removeAll(arrayList);
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    final boolean b() {
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lock();
        try {
            boolean isEmpty = this.d.isEmpty();
            return isEmpty;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final E c() {
        ReentrantLock reentrantLock = this.b;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                e a = a();
                int i = 0;
                if (a == null) {
                    this.e.set(1);
                    this.f = 0;
                    this.c.await();
                } else {
                    long a2 = a.a(TimeUnit.NANOSECONDS);
                    if (a.k || a.m) {
                        i = 1;
                    }
                    if (a2 <= 0) {
                        break;
                    } else if (i != 0) {
                        break;
                    } else {
                        this.h.set(a.u);
                        StringBuilder stringBuilder = new StringBuilder("schedule take|needAlarm = ");
                        stringBuilder.append(this.g.t);
                        stringBuilder.append("|");
                        stringBuilder.append(a.getClass().getName());
                        stringBuilder.append("@");
                        stringBuilder.append(a.hashCode());
                        a.b(stringBuilder.toString());
                        if (this.g.t) {
                            this.g.a(a.u);
                        }
                        this.c.awaitNanos(a2);
                    }
                }
            } finally {
                reentrantLock.unlock();
            }
        }
        E e = e();
        if (i || e != null) {
            if (!b()) {
                this.c.signalAll();
            }
            this.h.set(-1);
            return e;
        }
        throw new AssertionError();
    }

    public final void d() {
        this.d.clear();
    }
}
