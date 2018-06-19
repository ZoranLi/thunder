package okhttp3.internal.http2;

import okhttp3.internal.b;

/* compiled from: Http2Connection */
final class f extends b {
    final /* synthetic */ int a;
    final /* synthetic */ ErrorCode c;
    final /* synthetic */ e d;

    f(e eVar, String str, Object[] objArr, int i, ErrorCode errorCode) {
        this.d = eVar;
        this.a = i;
        this.c = errorCode;
        super(str, objArr);
    }

    public final void b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.d;	 Catch:{ IOException -> 0x000a }
        r1 = r3.a;	 Catch:{ IOException -> 0x000a }
        r2 = r3.c;	 Catch:{ IOException -> 0x000a }
        r0.b(r1, r2);	 Catch:{ IOException -> 0x000a }
        return;
    L_0x000a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.f.b():void");
    }
}
