package mtopsdk.a.b;

import java.io.InputStream;

public abstract class g {
    private byte[] a = null;

    private byte[] d() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = this;
        r0 = r8.a();
        r2 = 2147483647; // 0x7fffffff float:NaN double:1.060997895E-314;
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r4 <= 0) goto L_0x001f;
    L_0x000b:
        r2 = new java.io.IOException;
        r3 = new java.lang.StringBuilder;
        r4 = "Cannot buffer entire body for content length: ";
        r3.<init>(r4);
        r3.append(r0);
        r0 = r3.toString();
        r2.<init>(r0);
        throw r2;
    L_0x001f:
        r2 = r8.b();
        r3 = 0;
        r4 = new java.io.DataInputStream;	 Catch:{ Exception -> 0x0055, all -> 0x0051 }
        r4.<init>(r2);	 Catch:{ Exception -> 0x0055, all -> 0x0051 }
        r2 = new java.io.ByteArrayOutputStream;	 Catch:{ Exception -> 0x004f, all -> 0x004c }
        r2.<init>();	 Catch:{ Exception -> 0x004f, all -> 0x004c }
        r5 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r5 = new byte[r5];	 Catch:{ Exception -> 0x0057 }
    L_0x0032:
        r6 = r4.read(r5);	 Catch:{ Exception -> 0x0057 }
        r7 = -1;	 Catch:{ Exception -> 0x0057 }
        if (r6 == r7) goto L_0x003e;	 Catch:{ Exception -> 0x0057 }
    L_0x0039:
        r7 = 0;	 Catch:{ Exception -> 0x0057 }
        r2.write(r5, r7, r6);	 Catch:{ Exception -> 0x0057 }
        goto L_0x0032;	 Catch:{ Exception -> 0x0057 }
    L_0x003e:
        r2.flush();	 Catch:{ Exception -> 0x0057 }
        r5 = r2.toByteArray();	 Catch:{ Exception -> 0x0057 }
        com.taobao.tao.remotebusiness.listener.c.a(r4);
        com.taobao.tao.remotebusiness.listener.c.a(r2);
        goto L_0x0063;
    L_0x004c:
        r0 = move-exception;
        r2 = r3;
        goto L_0x007c;
    L_0x004f:
        r2 = r3;
        goto L_0x0057;
    L_0x0051:
        r0 = move-exception;
        r2 = r3;
        r4 = r2;
        goto L_0x007c;
    L_0x0055:
        r2 = r3;
        r4 = r2;
    L_0x0057:
        r5 = "[readBytes] read bytes from byteStream error.";	 Catch:{ all -> 0x007b }
        mtopsdk.common.util.j.f(r5);	 Catch:{ all -> 0x007b }
        com.taobao.tao.remotebusiness.listener.c.a(r4);
        com.taobao.tao.remotebusiness.listener.c.a(r2);
        r5 = r3;
    L_0x0063:
        if (r5 != 0) goto L_0x0066;
    L_0x0065:
        return r3;
    L_0x0066:
        r2 = -1;
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r4 == 0) goto L_0x007a;
    L_0x006c:
        r2 = r5.length;
        r2 = (long) r2;
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r4 == 0) goto L_0x007a;
    L_0x0072:
        r0 = new java.io.IOException;
        r1 = "Content-Length and stream length disagree";
        r0.<init>(r1);
        throw r0;
    L_0x007a:
        return r5;
    L_0x007b:
        r0 = move-exception;
    L_0x007c:
        com.taobao.tao.remotebusiness.listener.c.a(r4);
        com.taobao.tao.remotebusiness.listener.c.a(r2);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.a.b.g.d():byte[]");
    }

    public abstract long a();

    public abstract InputStream b();

    public final byte[] c() {
        if (this.a == null) {
            this.a = d();
        }
        return this.a;
    }
}
