package com.igexin.b.a.b.a.a;

import android.text.TextUtils;
import com.igexin.b.a.b.a.a.a.c;
import com.igexin.b.a.b.b;
import com.igexin.b.a.b.d;
import com.igexin.b.a.c.a;
import org.android.spdy.TnetStatusCode;

public final class l extends a {
    private c L;
    private d M;
    public b i;
    n j;

    public l(n nVar, b bVar, d dVar) {
        super(TnetStatusCode.EASY_REASON_SPDYINIT_ERROR, null, bVar);
        this.i = bVar;
        this.M = dVar;
        this.j = nVar;
    }

    public final void a(c cVar) {
        this.L = cVar;
    }

    public final int b() {
        return TnetStatusCode.EASY_REASON_SPDYINIT_ERROR;
    }

    public final void b_() {
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
        r8 = this;
        super.b_();
        r0 = java.lang.Thread.currentThread();
        r1 = new java.lang.StringBuilder;
        r2 = "S-SWT|";
        r1.<init>(r2);
        r1.append(r0);
        r2 = " running";
        r1.append(r2);
        r1 = r1.toString();
        com.igexin.b.a.c.a.b(r1);
        r1 = com.igexin.b.a.b.a.a.d.a();
    L_0x0021:
        r2 = r8.h;
        if (r2 == 0) goto L_0x00ce;
    L_0x0025:
        r2 = r0.isInterrupted();
        if (r2 != 0) goto L_0x00ce;
    L_0x002b:
        r2 = r8.e;
        if (r2 != 0) goto L_0x00ce;
    L_0x002f:
        r2 = r1.a;	 Catch:{ Throwable -> 0x00b3 }
        r2.lock();	 Catch:{ Throwable -> 0x00b3 }
        r2 = r1.c;	 Catch:{ Throwable -> 0x00b3 }
        r2 = r2.isEmpty();	 Catch:{ Throwable -> 0x00b3 }
        if (r2 == 0) goto L_0x0041;	 Catch:{ Throwable -> 0x00b3 }
    L_0x003c:
        r2 = r1.b;	 Catch:{ Throwable -> 0x00b3 }
        r2.await();	 Catch:{ Throwable -> 0x00b3 }
    L_0x0041:
        r2 = r1.c;	 Catch:{ Throwable -> 0x00b3 }
        r2 = r2.poll();	 Catch:{ Throwable -> 0x00b3 }
        r2 = (com.igexin.b.a.b.a.a.k) r2;	 Catch:{ Throwable -> 0x00b3 }
        if (r2 == 0) goto L_0x00aa;	 Catch:{ Throwable -> 0x00b3 }
    L_0x004b:
        r3 = r8.M;	 Catch:{ Throwable -> 0x00b3 }
        r2.d = r3;	 Catch:{ Throwable -> 0x00b3 }
        r3 = r8.M;	 Catch:{ Throwable -> 0x00b3 }
        if (r3 == 0) goto L_0x00aa;	 Catch:{ Throwable -> 0x00b3 }
    L_0x0053:
        r3 = r8.j;	 Catch:{ Throwable -> 0x00b3 }
        if (r3 == 0) goto L_0x00aa;	 Catch:{ Throwable -> 0x00b3 }
    L_0x0057:
        r3 = r8.e;	 Catch:{ Throwable -> 0x00b3 }
        if (r3 != 0) goto L_0x00aa;	 Catch:{ Throwable -> 0x00b3 }
    L_0x005b:
        r3 = com.igexin.b.a.b.a.a.b.NORMAL;	 Catch:{ Throwable -> 0x00b3 }
        r8.f = r3;	 Catch:{ Throwable -> 0x00b3 }
        r3 = r8.j;	 Catch:{ Throwable -> 0x00b3 }
        r4 = r8.i;	 Catch:{ Throwable -> 0x00b3 }
        r5 = 0;	 Catch:{ Throwable -> 0x00b3 }
        r6 = r8.M;	 Catch:{ Throwable -> 0x00b3 }
        r7 = r2.c;	 Catch:{ Throwable -> 0x00b3 }
        r4 = r4.d(r5, r6, r7);	 Catch:{ Throwable -> 0x00b3 }
        r4 = (byte[]) r4;	 Catch:{ Throwable -> 0x00b3 }
        r3.a(r4);	 Catch:{ Throwable -> 0x00b3 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00b3 }
        r4 = "S-SWT|";	 Catch:{ Throwable -> 0x00b3 }
        r3.<init>(r4);	 Catch:{ Throwable -> 0x00b3 }
        r4 = r2.toString();	 Catch:{ Throwable -> 0x00b3 }
        r3.append(r4);	 Catch:{ Throwable -> 0x00b3 }
        r4 = " --> ";	 Catch:{ Throwable -> 0x00b3 }
        r3.append(r4);	 Catch:{ Throwable -> 0x00b3 }
        r4 = r2.c;	 Catch:{ Throwable -> 0x00b3 }
        r4 = r4.getClass();	 Catch:{ Throwable -> 0x00b3 }
        r4 = r4.getName();	 Catch:{ Throwable -> 0x00b3 }
        r3.append(r4);	 Catch:{ Throwable -> 0x00b3 }
        r4 = "-- send success";	 Catch:{ Throwable -> 0x00b3 }
        r3.append(r4);	 Catch:{ Throwable -> 0x00b3 }
        r3 = r3.toString();	 Catch:{ Throwable -> 0x00b3 }
        com.igexin.b.a.c.a.b(r3);	 Catch:{ Throwable -> 0x00b3 }
        r3 = r8.L;	 Catch:{ Throwable -> 0x00b3 }
        if (r3 == 0) goto L_0x00aa;	 Catch:{ Throwable -> 0x00b3 }
    L_0x00a1:
        r3 = r8.e;	 Catch:{ Throwable -> 0x00b3 }
        if (r3 != 0) goto L_0x00aa;	 Catch:{ Throwable -> 0x00b3 }
    L_0x00a5:
        r3 = r8.L;	 Catch:{ Throwable -> 0x00b3 }
        r3.a(r2);	 Catch:{ Throwable -> 0x00b3 }
    L_0x00aa:
        r2 = r1.a;	 Catch:{ Exception -> 0x0021 }
        r2.unlock();	 Catch:{ Exception -> 0x0021 }
        goto L_0x0021;
    L_0x00b1:
        r0 = move-exception;
        goto L_0x00c8;
    L_0x00b3:
        r2 = move-exception;
        r3 = 0;
        r8.h = r3;	 Catch:{ all -> 0x00b1 }
        r3 = r8.f;	 Catch:{ all -> 0x00b1 }
        r4 = com.igexin.b.a.b.a.a.b.INTERRUPT;	 Catch:{ all -> 0x00b1 }
        if (r3 == r4) goto L_0x00aa;	 Catch:{ all -> 0x00b1 }
    L_0x00bd:
        r3 = com.igexin.b.a.b.a.a.b.EXCEPTION;	 Catch:{ all -> 0x00b1 }
        r8.f = r3;	 Catch:{ all -> 0x00b1 }
        r2 = r2.toString();	 Catch:{ all -> 0x00b1 }
        r8.g = r2;	 Catch:{ all -> 0x00b1 }
        goto L_0x00aa;
    L_0x00c8:
        r1 = r1.a;	 Catch:{ Exception -> 0x00cd }
        r1.unlock();	 Catch:{ Exception -> 0x00cd }
    L_0x00cd:
        throw r0;
    L_0x00ce:
        r0 = 1;
        r8.e = r0;
        r0 = "S-SWT|finish ~~~~~~";
        com.igexin.b.a.c.a.b(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.b.a.a.l.b_():void");
    }

    public final void f() {
        super.f();
        a.b("S-SWT|dispose");
        if (this.L != null) {
            if (this.f != b.EXCEPTION) {
                this.L.a(this);
            } else if (!TextUtils.isEmpty(this.g)) {
                this.L.a(new Exception(this.g));
            }
        }
        this.L = null;
    }

    public final void h() {
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
        r2 = this;
        r0 = 0;
        r2.h = r0;
        r0 = com.igexin.b.a.b.a.a.b.INTERRUPT;
        r2.f = r0;
        r0 = com.igexin.b.a.b.a.a.d.a();
        r1 = r2.e;	 Catch:{ Exception -> 0x002a, all -> 0x0023 }
        if (r1 != 0) goto L_0x001d;	 Catch:{ Exception -> 0x002a, all -> 0x0023 }
    L_0x000f:
        r1 = r0.a;	 Catch:{ Exception -> 0x002a, all -> 0x0023 }
        r1.lock();	 Catch:{ Exception -> 0x002a, all -> 0x0023 }
        r1 = com.igexin.b.a.b.a.a.d.a();	 Catch:{ Exception -> 0x002a, all -> 0x0023 }
        r1 = r1.b;	 Catch:{ Exception -> 0x002a, all -> 0x0023 }
        r1.signalAll();	 Catch:{ Exception -> 0x002a, all -> 0x0023 }
    L_0x001d:
        r0 = r0.a;	 Catch:{ Exception -> 0x0022 }
        r0.unlock();	 Catch:{ Exception -> 0x0022 }
    L_0x0022:
        return;
    L_0x0023:
        r1 = move-exception;
        r0 = r0.a;	 Catch:{ Exception -> 0x0029 }
        r0.unlock();	 Catch:{ Exception -> 0x0029 }
    L_0x0029:
        throw r1;
    L_0x002a:
        r0 = r0.a;	 Catch:{ Exception -> 0x002f }
        r0.unlock();	 Catch:{ Exception -> 0x002f }
    L_0x002f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.b.a.a.l.h():void");
    }
}
