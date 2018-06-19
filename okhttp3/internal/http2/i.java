package okhttp3.internal.http2;

import java.util.List;
import okhttp3.internal.b;

/* compiled from: Http2Connection */
final class i extends b {
    final /* synthetic */ int a;
    final /* synthetic */ List c;
    final /* synthetic */ e d;

    i(e eVar, String str, Object[] objArr, int i, List list) {
        this.d = eVar;
        this.a = i;
        this.c = list;
        super(str, objArr);
    }

    public final void b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = r3.d;
        r0 = r0.j;
        r0.a();
        r0 = r3.d;	 Catch:{ IOException -> 0x0027 }
        r0 = r0.q;	 Catch:{ IOException -> 0x0027 }
        r1 = r3.a;	 Catch:{ IOException -> 0x0027 }
        r2 = okhttp3.internal.http2.ErrorCode.CANCEL;	 Catch:{ IOException -> 0x0027 }
        r0.a(r1, r2);	 Catch:{ IOException -> 0x0027 }
        r0 = r3.d;	 Catch:{ IOException -> 0x0027 }
        monitor-enter(r0);	 Catch:{ IOException -> 0x0027 }
        r1 = r3.d;	 Catch:{ all -> 0x0024 }
        r1 = r1.s;	 Catch:{ all -> 0x0024 }
        r2 = r3.a;	 Catch:{ all -> 0x0024 }
        r2 = java.lang.Integer.valueOf(r2);	 Catch:{ all -> 0x0024 }
        r1.remove(r2);	 Catch:{ all -> 0x0024 }
        monitor-exit(r0);	 Catch:{ all -> 0x0024 }
        return;	 Catch:{ all -> 0x0024 }
    L_0x0024:
        r1 = move-exception;	 Catch:{ all -> 0x0024 }
        monitor-exit(r0);	 Catch:{ all -> 0x0024 }
        throw r1;	 Catch:{ IOException -> 0x0027 }
    L_0x0027:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http2.i.b():void");
    }
}
