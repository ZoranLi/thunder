package com.alibaba.mtl.log.c;

import com.alibaba.mtl.log.e.i;
import com.alibaba.mtl.log.e.r;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: LogStoreMgr */
public final class c {
    private static c d;
    public a a = new b(com.alibaba.mtl.log.a.c());
    public List<com.alibaba.mtl.log.model.a> b = new CopyOnWriteArrayList();
    public Runnable c = new d(this);

    /* compiled from: LogStoreMgr */
    class a implements Runnable {
        final /* synthetic */ c a;

        a(c cVar) {
            this.a = cVar;
        }

        public final void run() {
            c cVar = this.a;
            Calendar instance = Calendar.getInstance();
            instance.add(5, -3);
            cVar.a.a("time", String.valueOf(instance.getTimeInMillis()));
            if (this.a.a.a() > 9000) {
                this.a.a.c();
            }
        }
    }

    private c() {
        com.alibaba.mtl.log.d.a.a().b();
        r.a();
        r.a(new a(this));
    }

    public static synchronized c a() {
        c cVar;
        synchronized (c.class) {
            if (d == null) {
                d = new c();
            }
            cVar = d;
        }
        return cVar;
    }

    public final List<com.alibaba.mtl.log.model.a> a(String str, int i) {
        i.a("LogStoreMgr", "[get]", this.a.a(str, i));
        return this.a.a(str, i);
    }

    public final synchronized void b() {
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
        r4 = this;
        monitor-enter(r4);
        r0 = "LogStoreMgr";	 Catch:{ all -> 0x003b }
        r1 = 1;	 Catch:{ all -> 0x003b }
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x003b }
        r2 = 0;	 Catch:{ all -> 0x003b }
        r3 = "[store]";	 Catch:{ all -> 0x003b }
        r1[r2] = r3;	 Catch:{ all -> 0x003b }
        com.alibaba.mtl.log.e.i.a(r0, r1);	 Catch:{ all -> 0x003b }
        r0 = 0;
        r1 = r4.b;	 Catch:{ Throwable -> 0x0039 }
        monitor-enter(r1);	 Catch:{ Throwable -> 0x0039 }
        r2 = r4.b;	 Catch:{ all -> 0x0036 }
        r2 = r2.size();	 Catch:{ all -> 0x0036 }
        if (r2 <= 0) goto L_0x0026;	 Catch:{ all -> 0x0036 }
    L_0x001a:
        r0 = new java.util.ArrayList;	 Catch:{ all -> 0x0036 }
        r2 = r4.b;	 Catch:{ all -> 0x0036 }
        r0.<init>(r2);	 Catch:{ all -> 0x0036 }
        r2 = r4.b;	 Catch:{ all -> 0x0036 }
        r2.clear();	 Catch:{ all -> 0x0036 }
    L_0x0026:
        monitor-exit(r1);	 Catch:{ all -> 0x0036 }
        if (r0 == 0) goto L_0x0034;
    L_0x0029:
        r1 = r0.size();	 Catch:{ Throwable -> 0x0039 }
        if (r1 <= 0) goto L_0x0034;	 Catch:{ Throwable -> 0x0039 }
    L_0x002f:
        r1 = r4.a;	 Catch:{ Throwable -> 0x0039 }
        r1.a(r0);	 Catch:{ Throwable -> 0x0039 }
    L_0x0034:
        monitor-exit(r4);
        return;
    L_0x0036:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0036 }
        throw r0;	 Catch:{ Throwable -> 0x0039 }
    L_0x0039:
        monitor-exit(r4);
        return;
    L_0x003b:
        r0 = move-exception;
        monitor-exit(r4);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.c.c.b():void");
    }
}
