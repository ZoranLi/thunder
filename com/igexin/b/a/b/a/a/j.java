package com.igexin.b.a.b.a.a;

import android.text.TextUtils;
import com.igexin.b.a.b.a.a.a.b;
import com.igexin.b.a.b.d;
import com.igexin.b.a.c.a;

public final class j extends a {
    private b L;
    private byte[] M;
    private d N;
    m i;
    com.igexin.b.a.b.b j;

    public j(m mVar, com.igexin.b.a.b.b bVar, d dVar) {
        super(-2035, null, bVar);
        this.j = bVar;
        this.i = mVar;
        this.N = dVar;
    }

    public final void a(b bVar) {
        this.L = bVar;
    }

    public final int b() {
        return -2035;
    }

    public final void b_() {
        super.b_();
        Thread currentThread = Thread.currentThread();
        StringBuilder stringBuilder = new StringBuilder("S-SRT|");
        stringBuilder.append(currentThread);
        stringBuilder.append(" running");
        a.b(stringBuilder.toString());
        while (this.h && !currentThread.isInterrupted() && !this.e) {
            try {
                this.j.c(null, this.N, this.i);
                this.f = b.NORMAL;
            } catch (Throwable th) {
                this.h = false;
                if (this.f != b.INTERRUPT) {
                    this.f = b.EXCEPTION;
                    String th2 = (th.getMessage() == null || !th.getMessage().equals("read = -1, end of stream !")) ? th.toString() : "end of stream";
                    this.g = th2;
                }
            }
        }
        this.e = true;
        a.b("S-SRT|finish ~~~~~~");
    }

    public final void f() {
        super.f();
        a.b("S-SRT|dispose");
        if (this.L != null) {
            if (this.f != b.EXCEPTION) {
                this.L.a(this);
            } else if (!TextUtils.isEmpty(this.g)) {
                this.L.a(new Exception(this.g));
            }
        }
        if (this.M != null) {
            this.M = null;
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
        r1 = this;
        r0 = 0;
        r1.h = r0;
        r0 = com.igexin.b.a.b.a.a.b.INTERRUPT;
        r1.f = r0;
        r0 = r1.e;	 Catch:{ Exception -> 0x0018 }
        if (r0 != 0) goto L_0x0018;	 Catch:{ Exception -> 0x0018 }
    L_0x000b:
        r0 = r1.i;	 Catch:{ Exception -> 0x0018 }
        r0 = r0.a;	 Catch:{ Exception -> 0x0018 }
        if (r0 == 0) goto L_0x0018;	 Catch:{ Exception -> 0x0018 }
    L_0x0011:
        r0 = r1.i;	 Catch:{ Exception -> 0x0018 }
        r0 = r0.a;	 Catch:{ Exception -> 0x0018 }
        r0.notifyAll();	 Catch:{ Exception -> 0x0018 }
    L_0x0018:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.b.a.b.a.a.j.h():void");
    }
}
