package com.xunlei.downloadprovider.download.engine.task.a;

import com.xunlei.downloadprovider.download.engine.task.w;

/* compiled from: CoreTaskListBridge */
public abstract class b {
    public final a b = new a(this, (byte) 0);
    protected aa c = new aa();
    public c d;
    public z e = null;

    public final void a(w wVar) {
        try {
            this.c.registerObserver(wVar);
        } catch (w wVar2) {
            wVar2.printStackTrace();
        }
    }

    public final void a(z zVar) {
        if (this.d != null) {
            this.e = null;
            this.d.v.a(zVar);
            q();
            return;
        }
        this.e = zVar;
    }

    public final void q() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.d;
        if (r0 == 0) goto L_0x0019;
    L_0x0004:
        r0 = r3.d;
        r1 = r0.w;	 Catch:{ RejectedExecutionException -> 0x0011 }
        r2 = new com.xunlei.downloadprovider.download.engine.task.a.i;	 Catch:{ RejectedExecutionException -> 0x0011 }
        r2.<init>(r0);	 Catch:{ RejectedExecutionException -> 0x0011 }
        r1.execute(r2);	 Catch:{ RejectedExecutionException -> 0x0011 }
        return;
    L_0x0011:
        r1 = new com.xunlei.downloadprovider.download.engine.task.a.j;
        r1.<init>(r0);
        com.xunlei.common.concurrent.XLThreadPool.execute(r1);
    L_0x0019:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.engine.task.a.b.q():void");
    }
}
