package mtopsdk.a;

final class e implements Runnable {
    private f a;
    private /* synthetic */ c b;

    public e(c cVar, f fVar) {
        this.b = cVar;
        this.a = fVar;
    }

    public final void run() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r4 = this;
        r0 = r4.b;	 Catch:{ CancellationException -> 0x0046, InterruptedException -> 0x003e, Exception -> 0x0030 }
        r0 = r0.a;	 Catch:{ CancellationException -> 0x0046, InterruptedException -> 0x003e, Exception -> 0x0030 }
        if (r0 == 0) goto L_0x0013;	 Catch:{ CancellationException -> 0x0046, InterruptedException -> 0x003e, Exception -> 0x0030 }
    L_0x0006:
        r0 = "call task is canceled.";	 Catch:{ CancellationException -> 0x0046, InterruptedException -> 0x003e, Exception -> 0x0030 }
        mtopsdk.common.util.j.a(r0);	 Catch:{ CancellationException -> 0x0046, InterruptedException -> 0x003e, Exception -> 0x0030 }
        r0 = r4.a;	 Catch:{ CancellationException -> 0x0046, InterruptedException -> 0x003e, Exception -> 0x0030 }
        r1 = r4.b;	 Catch:{ CancellationException -> 0x0046, InterruptedException -> 0x003e, Exception -> 0x0030 }
        r0.onCancel(r1);	 Catch:{ CancellationException -> 0x0046, InterruptedException -> 0x003e, Exception -> 0x0030 }
        return;	 Catch:{ CancellationException -> 0x0046, InterruptedException -> 0x003e, Exception -> 0x0030 }
    L_0x0013:
        r0 = r4.b;	 Catch:{ CancellationException -> 0x0046, InterruptedException -> 0x003e, Exception -> 0x0030 }
        r0 = r0.b();	 Catch:{ CancellationException -> 0x0046, InterruptedException -> 0x003e, Exception -> 0x0030 }
        if (r0 != 0) goto L_0x002a;
    L_0x001b:
        r0 = r4.a;
        r1 = r4.b;
        r2 = new java.lang.Exception;
        r3 = "response is null";
        r2.<init>(r3);
        r0.a(r1, r2);
        return;
    L_0x002a:
        r1 = r4.a;
        r1.a(r0);
        return;
    L_0x0030:
        r0 = move-exception;
        r1 = r4.a;
        r2 = r4.b;
        r1.a(r2, r0);
        r0 = "do call.execute failed.";
        mtopsdk.common.util.j.f(r0);
        return;
    L_0x003e:
        r0 = r4.a;
        r1 = r4.b;
        r0.onCancel(r1);
        return;
    L_0x0046:
        r0 = r4.a;
        r1 = r4.b;
        r0.onCancel(r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.a.e.run():void");
    }
}
