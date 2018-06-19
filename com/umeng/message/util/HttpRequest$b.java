package com.umeng.message.util;

import java.io.Closeable;

protected abstract class HttpRequest$b<V> extends HttpRequest$d<V> {
    private final Closeable a;
    private final boolean b;

    protected HttpRequest$b(Closeable closeable, boolean z) {
        this.a = closeable;
        this.b = z;
    }

    protected void c() throws java.io.IOException {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = this;
        r0 = r1.a;
        r0 = r0 instanceof java.io.Flushable;
        if (r0 == 0) goto L_0x000d;
    L_0x0006:
        r0 = r1.a;
        r0 = (java.io.Flushable) r0;
        r0.flush();
    L_0x000d:
        r0 = r1.b;
        if (r0 == 0) goto L_0x0017;
    L_0x0011:
        r0 = r1.a;	 Catch:{ IOException -> 0x0016 }
        r0.close();	 Catch:{ IOException -> 0x0016 }
    L_0x0016:
        return;
    L_0x0017:
        r0 = r1.a;
        r0.close();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.util.HttpRequest$b.c():void");
    }
}
