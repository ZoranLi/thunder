package org.apache.thrift.protocol;

import java.nio.ByteBuffer;
import org.apache.thrift.transport.d;

public class k extends a {
    private static int f = 10000;
    private static int g = 10000;
    private static int h = 10000;
    private static int i = 10485760;
    private static int j = 104857600;

    public k(d dVar, boolean z, boolean z2) {
        super(dVar, z, z2);
    }

    public d k() {
        byte r = r();
        byte r2 = r();
        int t = t();
        if (t <= f) {
            return new d(r, r2, t);
        }
        StringBuilder stringBuilder = new StringBuilder("Thrift map size ");
        stringBuilder.append(t);
        stringBuilder.append(" out of range!");
        throw new f(3, stringBuilder.toString());
    }

    public c m() {
        byte r = r();
        int t = t();
        if (t <= g) {
            return new c(r, t);
        }
        StringBuilder stringBuilder = new StringBuilder("Thrift list size ");
        stringBuilder.append(t);
        stringBuilder.append(" out of range!");
        throw new f(3, stringBuilder.toString());
    }

    public i o() {
        byte r = r();
        int t = t();
        if (t <= h) {
            return new i(r, t);
        }
        StringBuilder stringBuilder = new StringBuilder("Thrift set size ");
        stringBuilder.append(t);
        stringBuilder.append(" out of range!");
        throw new f(3, stringBuilder.toString());
    }

    public java.lang.String w() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = r5.t();
        r1 = i;
        if (r0 <= r1) goto L_0x0022;
    L_0x0008:
        r1 = new org.apache.thrift.protocol.f;
        r2 = 3;
        r3 = new java.lang.StringBuilder;
        r4 = "Thrift string size ";
        r3.<init>(r4);
        r3.append(r0);
        r0 = " out of range!";
        r3.append(r0);
        r0 = r3.toString();
        r1.<init>(r2, r0);
        throw r1;
    L_0x0022:
        r1 = r5.e;
        r1 = r1.c();
        if (r1 < r0) goto L_0x004b;
    L_0x002a:
        r1 = new java.lang.String;	 Catch:{ UnsupportedEncodingException -> 0x0043 }
        r2 = r5.e;	 Catch:{ UnsupportedEncodingException -> 0x0043 }
        r2 = r2.a();	 Catch:{ UnsupportedEncodingException -> 0x0043 }
        r3 = r5.e;	 Catch:{ UnsupportedEncodingException -> 0x0043 }
        r3 = r3.b();	 Catch:{ UnsupportedEncodingException -> 0x0043 }
        r4 = "UTF-8";	 Catch:{ UnsupportedEncodingException -> 0x0043 }
        r1.<init>(r2, r3, r0, r4);	 Catch:{ UnsupportedEncodingException -> 0x0043 }
        r2 = r5.e;	 Catch:{ UnsupportedEncodingException -> 0x0043 }
        r2.a(r0);	 Catch:{ UnsupportedEncodingException -> 0x0043 }
        return r1;
    L_0x0043:
        r0 = new org.apache.thrift.f;
        r1 = "JVM DOES NOT SUPPORT UTF-8";
        r0.<init>(r1);
        throw r0;
    L_0x004b:
        r0 = r5.b(r0);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.thrift.protocol.k.w():java.lang.String");
    }

    public ByteBuffer x() {
        int t = t();
        if (t > j) {
            StringBuilder stringBuilder = new StringBuilder("Thrift binary size ");
            stringBuilder.append(t);
            stringBuilder.append(" out of range!");
            throw new f(3, stringBuilder.toString());
        }
        d(t);
        if (this.e.c() >= t) {
            ByteBuffer wrap = ByteBuffer.wrap(this.e.a(), this.e.b(), t);
            this.e.a(t);
            return wrap;
        }
        byte[] bArr = new byte[t];
        this.e.d(bArr, 0, t);
        return ByteBuffer.wrap(bArr);
    }
}
