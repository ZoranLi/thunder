package com.igexin.b.a.d;

import com.igexin.b.a.c.a;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

final class h implements Runnable {
    final BlockingQueue<e> a = new LinkedBlockingQueue();
    e b;
    e c;
    volatile int d;
    final /* synthetic */ g e;

    public h(g gVar, e eVar) {
        this.e = gVar;
        this.b = eVar;
    }

    public final void a() {
        this.a.clear();
        this.c = null;
    }

    public final void a(e eVar) {
        StringBuilder stringBuilder;
        if (this.d == 0) {
            this.d = eVar.z;
        }
        e eVar2 = eVar;
        boolean z = true;
        while (z) {
            StringBuilder stringBuilder2;
            try {
                eVar2.b_();
                eVar2.t();
                eVar2.v();
                if (!eVar2.t) {
                    eVar2.c();
                }
                stringBuilder2 = new StringBuilder("TaskService|Worker|runTask = ");
                stringBuilder2.append(eVar2);
                stringBuilder2.append("|isDone = ");
                stringBuilder2.append(eVar2.k);
                stringBuilder2.append("|isCycle = ");
                stringBuilder2.append(eVar2.o);
                stringBuilder2.append("|doTime = ");
                stringBuilder2.append(eVar2.u);
                a.b(stringBuilder2.toString());
                if (!(eVar2.k || !eVar2.o || eVar2.u == 0)) {
                }
            } catch (Exception e) {
                stringBuilder = new StringBuilder("TaskService");
                stringBuilder.append(e.toString());
                a.b(stringBuilder.toString());
                eVar2.t = true;
                eVar2.B = e;
                eVar2.w();
                eVar2.p();
                this.e.i.a((Object) eVar2);
                this.e.i.f();
                if (!eVar2.t) {
                    eVar2.c();
                }
                stringBuilder2 = new StringBuilder("TaskService|Worker|runTask = ");
                stringBuilder2.append(eVar2);
                stringBuilder2.append("|isDone = ");
                stringBuilder2.append(eVar2.k);
                stringBuilder2.append("|isCycle = ");
                stringBuilder2.append(eVar2.o);
                stringBuilder2.append("|doTime = ");
                stringBuilder2.append(eVar2.u);
                a.b(stringBuilder2.toString());
                if (!eVar2.k && eVar2.o) {
                    if (eVar2.u == 0) {
                    }
                }
            } catch (Throwable th) {
                if (!eVar2.t) {
                    eVar2.c();
                }
                stringBuilder = new StringBuilder("TaskService|Worker|runTask = ");
                stringBuilder.append(eVar2);
                stringBuilder.append("|isDone = ");
                stringBuilder.append(eVar2.k);
                stringBuilder.append("|isCycle = ");
                stringBuilder.append(eVar2.o);
                stringBuilder.append("|doTime = ");
                stringBuilder.append(eVar2.u);
                a.b(stringBuilder.toString());
                if (eVar2.k || !eVar2.o || eVar2.u == 0) {
                }
            }
            eVar2 = null;
            z = false;
        }
    }

    final com.igexin.b.a.d.e b() {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r5 = this;
    L_0x0000:
        r0 = r5.d;
        r1 = 0;
        if (r0 == 0) goto L_0x004f;
    L_0x0005:
        r0 = r5.a;	 Catch:{ InterruptedException -> 0x0000 }
        r2 = r5.e;	 Catch:{ InterruptedException -> 0x0000 }
        r2 = r2.e;	 Catch:{ InterruptedException -> 0x0000 }
        r4 = java.util.concurrent.TimeUnit.NANOSECONDS;	 Catch:{ InterruptedException -> 0x0000 }
        r0 = r0.poll(r2, r4);	 Catch:{ InterruptedException -> 0x0000 }
        r0 = (com.igexin.b.a.d.e) r0;	 Catch:{ InterruptedException -> 0x0000 }
        if (r0 == 0) goto L_0x0016;	 Catch:{ InterruptedException -> 0x0000 }
    L_0x0015:
        return r0;	 Catch:{ InterruptedException -> 0x0000 }
    L_0x0016:
        r0 = r5.a;	 Catch:{ InterruptedException -> 0x0000 }
        r0 = r0.isEmpty();	 Catch:{ InterruptedException -> 0x0000 }
        if (r0 == 0) goto L_0x0000;	 Catch:{ InterruptedException -> 0x0000 }
    L_0x001e:
        r0 = r5.e;	 Catch:{ InterruptedException -> 0x0000 }
        r0 = r0.c;	 Catch:{ InterruptedException -> 0x0000 }
        r0.lock();	 Catch:{ InterruptedException -> 0x0000 }
        r2 = r5.a;	 Catch:{ all -> 0x004a }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x004a }
        if (r2 != 0) goto L_0x0031;
    L_0x002d:
        r0.unlock();	 Catch:{ InterruptedException -> 0x0000 }
        goto L_0x0000;
    L_0x0031:
        r2 = r5.e;	 Catch:{ all -> 0x004a }
        r2 = r2.b;	 Catch:{ all -> 0x004a }
        r3 = r5.d;	 Catch:{ all -> 0x004a }
        r3 = java.lang.Integer.valueOf(r3);	 Catch:{ all -> 0x004a }
        r2.remove(r3);	 Catch:{ all -> 0x004a }
        r2 = r5.c;	 Catch:{ all -> 0x004a }
        r2.e();	 Catch:{ all -> 0x004a }
        r2 = 0;	 Catch:{ all -> 0x004a }
        r5.d = r2;	 Catch:{ all -> 0x004a }
        r0.unlock();	 Catch:{ InterruptedException -> 0x0000 }
        return r1;	 Catch:{ InterruptedException -> 0x0000 }
    L_0x004a:
        r1 = move-exception;	 Catch:{ InterruptedException -> 0x0000 }
        r0.unlock();	 Catch:{ InterruptedException -> 0x0000 }
        throw r1;	 Catch:{ InterruptedException -> 0x0000 }
    L_0x004f:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.d.h.b():com.igexin.b.a.d.e");
    }

    public final void run() {
        boolean z = true;
        while (z) {
            try {
                e eVar = this.b;
                this.b = null;
                while (true) {
                    if (eVar == null) {
                        eVar = b();
                        if (eVar == null) {
                            eVar = this.e.a();
                            if (eVar == null) {
                                break;
                            }
                        }
                    }
                    this.c = null;
                    a(eVar);
                    this.c = eVar;
                    eVar = null;
                }
                z = this.e.a(this);
                if (z) {
                }
            } catch (Exception e) {
                StringBuilder stringBuilder = new StringBuilder("TaskService|Worker|run()|error");
                stringBuilder.append(e.toString());
                a.b(stringBuilder.toString());
                z = this.e.a(this);
                if (z) {
                }
            } catch (Throwable th) {
                if (!this.e.a(this)) {
                    a();
                }
            }
            a();
        }
    }
}
