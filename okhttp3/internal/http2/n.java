package okhttp3.internal.http2;

import okhttp3.internal.b;

/* compiled from: Http2Connection */
final class n extends b {
    final /* synthetic */ r a;
    final /* synthetic */ c c;

    n(c cVar, String str, Object[] objArr, r rVar) {
        this.c = cVar;
        this.a = rVar;
        super(str, objArr);
    }

    public final void b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = r5.c;	 Catch:{ IOException -> 0x000c }
        r0 = r0.c;	 Catch:{ IOException -> 0x000c }
        r0 = r0.c;	 Catch:{ IOException -> 0x000c }
        r1 = r5.a;	 Catch:{ IOException -> 0x000c }
        r0.a(r1);	 Catch:{ IOException -> 0x000c }
        return;
    L_0x000c:
        r0 = move-exception;
        r1 = okhttp3.internal.e.e.b();
        r2 = 4;
        r3 = new java.lang.StringBuilder;
        r4 = "Http2Connection.Listener failure for ";
        r3.<init>(r4);
        r4 = r5.c;
        r4 = r4.c;
        r4 = r4.e;
        r3.append(r4);
        r3 = r3.toString();
        r1.a(r2, r3, r0);
        r0 = r5.a;	 Catch:{ IOException -> 0x0031 }
        r1 = okhttp3.internal.http2.ErrorCode.PROTOCOL_ERROR;	 Catch:{ IOException -> 0x0031 }
        r0.a(r1);	 Catch:{ IOException -> 0x0031 }
        return;
    L_0x0031:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.n.b():void");
    }
}
