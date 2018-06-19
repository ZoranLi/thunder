package okhttp3.internal.http2;

import okhttp3.internal.b;

/* compiled from: Http2Connection */
final class h extends b {
    final /* synthetic */ boolean a = true;
    final /* synthetic */ int c;
    final /* synthetic */ int d;
    final /* synthetic */ u e;
    final /* synthetic */ e f;

    h(e eVar, String str, Object[] objArr, int i, int i2) {
        this.f = eVar;
        this.c = i;
        this.d = i2;
        this.e = null;
        super(str, objArr);
    }

    public final void b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r11 = this;
        r0 = r11.f;	 Catch:{ IOException -> 0x002f }
        r1 = r11.a;	 Catch:{ IOException -> 0x002f }
        r2 = r11.c;	 Catch:{ IOException -> 0x002f }
        r3 = r11.d;	 Catch:{ IOException -> 0x002f }
        r4 = r11.e;	 Catch:{ IOException -> 0x002f }
        r5 = r0.q;	 Catch:{ IOException -> 0x002f }
        monitor-enter(r5);	 Catch:{ IOException -> 0x002f }
        if (r4 == 0) goto L_0x0026;
    L_0x000f:
        r6 = r4.b;	 Catch:{ all -> 0x0024 }
        r8 = -1;	 Catch:{ all -> 0x0024 }
        r10 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));	 Catch:{ all -> 0x0024 }
        if (r10 == 0) goto L_0x001d;	 Catch:{ all -> 0x0024 }
    L_0x0017:
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x0024 }
        r0.<init>();	 Catch:{ all -> 0x0024 }
        throw r0;	 Catch:{ all -> 0x0024 }
    L_0x001d:
        r6 = java.lang.System.nanoTime();	 Catch:{ all -> 0x0024 }
        r4.b = r6;	 Catch:{ all -> 0x0024 }
        goto L_0x0026;	 Catch:{ all -> 0x0024 }
    L_0x0024:
        r0 = move-exception;	 Catch:{ all -> 0x0024 }
        goto L_0x002d;	 Catch:{ all -> 0x0024 }
    L_0x0026:
        r0 = r0.q;	 Catch:{ all -> 0x0024 }
        r0.a(r1, r2, r3);	 Catch:{ all -> 0x0024 }
        monitor-exit(r5);	 Catch:{ all -> 0x0024 }
        return;	 Catch:{ all -> 0x0024 }
    L_0x002d:
        monitor-exit(r5);	 Catch:{ all -> 0x0024 }
        throw r0;	 Catch:{ IOException -> 0x002f }
    L_0x002f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.h.b():void");
    }
}
