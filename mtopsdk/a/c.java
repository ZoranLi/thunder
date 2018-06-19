package mtopsdk.a;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import mtopsdk.a.b.b;
import mtopsdk.common.util.j;

public final class c implements a {
    volatile boolean a;
    private b b;
    private ExecutorService c;
    private Future d;

    public c(b bVar, ExecutorService executorService) {
        this.b = bVar;
        this.c = executorService;
    }

    private static void a(java.lang.String r3, java.util.Map r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r3 == 0) goto L_0x004b;
    L_0x0002:
        if (r4 != 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r4 = r4.entrySet();	 Catch:{ Exception -> 0x004b }
        r4 = r4.iterator();	 Catch:{ Exception -> 0x004b }
    L_0x000d:
        r0 = r4.hasNext();	 Catch:{ Exception -> 0x004b }
        if (r0 == 0) goto L_0x004b;	 Catch:{ Exception -> 0x004b }
    L_0x0013:
        r0 = r4.next();	 Catch:{ Exception -> 0x004b }
        r0 = (java.util.Map.Entry) r0;	 Catch:{ Exception -> 0x004b }
        r1 = r0.getKey();	 Catch:{ Exception -> 0x004b }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x004b }
        if (r1 == 0) goto L_0x000d;	 Catch:{ Exception -> 0x004b }
    L_0x0021:
        r2 = "Set-Cookie";	 Catch:{ Exception -> 0x004b }
        r2 = r1.equalsIgnoreCase(r2);	 Catch:{ Exception -> 0x004b }
        if (r2 != 0) goto L_0x0031;	 Catch:{ Exception -> 0x004b }
    L_0x0029:
        r2 = "Set-Cookie2";	 Catch:{ Exception -> 0x004b }
        r1 = r1.equalsIgnoreCase(r2);	 Catch:{ Exception -> 0x004b }
        if (r1 == 0) goto L_0x000d;	 Catch:{ Exception -> 0x004b }
    L_0x0031:
        r0 = r0.getValue();	 Catch:{ Exception -> 0x004b }
        r0 = (java.util.List) r0;	 Catch:{ Exception -> 0x004b }
        r0 = r0.iterator();	 Catch:{ Exception -> 0x004b }
    L_0x003b:
        r1 = r0.hasNext();	 Catch:{ Exception -> 0x004b }
        if (r1 == 0) goto L_0x000d;	 Catch:{ Exception -> 0x004b }
    L_0x0041:
        r1 = r0.next();	 Catch:{ Exception -> 0x004b }
        r1 = (java.lang.String) r1;	 Catch:{ Exception -> 0x004b }
        mtopsdk.a.a.a.a(r3, r1);	 Catch:{ Exception -> 0x004b }
        goto L_0x003b;
    L_0x004b:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.a.c.a(java.lang.String, java.util.Map):void");
    }

    public final b a() {
        return this.b;
    }

    public final void a(f fVar) {
        if (this.c != null) {
            try {
                this.d = this.c.submit(new e(this, fVar));
                return;
            } catch (Exception e) {
                fVar.a(this, e);
                return;
            }
        }
        fVar.a(this, new Exception("miss executorService in CallImpl "));
    }

    public final void c() {
        j.a("try to cancel call");
        this.a = true;
        if (this.d != null) {
            this.d.cancel(true);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final mtopsdk.a.b.e b() {
        /*
        r12 = this;
        r0 = r12.b;
        r1 = 0;
        r2 = 0;
        r3 = r1;
        r4 = r2;
    L_0x0006:
        r5 = r1 + 1;
        r6 = r0.g;
        if (r1 >= r6) goto L_0x00dd;
    L_0x000c:
        r1 = new java.net.URL;	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r6 = r0.a;	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r1.<init>(r6);	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r1 = r1.openConnection();	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r1 = (java.net.HttpURLConnection) r1;	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r6 = r0.e;	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r1.setConnectTimeout(r6);	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r6 = r0.f;	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r1.setReadTimeout(r6);	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        a(r1, r0);	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r6 = java.lang.Thread.currentThread();	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r6 = r6.isInterrupted();	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        if (r6 == 0) goto L_0x003d;
    L_0x0030:
        r1 = "[readResponse]call task is canceled.";
        mtopsdk.common.util.j.a(r1);	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r1 = new java.util.concurrent.CancellationException;	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r3 = "call canceled";
        r1.<init>(r3);	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        throw r1;	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
    L_0x003d:
        r6 = r1.getResponseCode();	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r7 = r1.getResponseMessage();	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        if (r7 != 0) goto L_0x0049;
    L_0x0047:
        r7 = "";
    L_0x0049:
        r8 = r1.getHeaderFields();	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r9 = r0.a;	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        a(r9, r8);	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r1.getContentType();	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r9 = r1.getContentLength();	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r10 = com.taobao.tao.remotebusiness.listener.c.a(r8);	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r11 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r6 < r11) goto L_0x0066;
    L_0x0061:
        r1 = r1.getErrorStream();	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        goto L_0x0077;
    L_0x0066:
        if (r10 == 0) goto L_0x0073;
    L_0x0068:
        r10 = new java.util.zip.GZIPInputStream;	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r1 = r1.getInputStream();	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r10.<init>(r1);	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r1 = r10;
        goto L_0x0077;
    L_0x0073:
        r1 = r1.getInputStream();	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
    L_0x0077:
        r10 = new mtopsdk.a.d;	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r10.<init>(r9, r1);	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r1 = java.lang.Thread.currentThread();	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r1 = r1.isInterrupted();	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        if (r1 == 0) goto L_0x0093;
    L_0x0086:
        r1 = "[readResponse]call task is canceled.";
        mtopsdk.common.util.j.a(r1);	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r1 = new java.util.concurrent.CancellationException;	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r3 = "call canceled";
        r1.<init>(r3);	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        throw r1;	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
    L_0x0093:
        r10.c();	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r1 = new mtopsdk.a.b.f;	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r1.<init>();	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r1.a = r0;	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r1.b = r6;	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r1.c = r7;	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r1.d = r8;	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r1.e = r10;	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        r1 = r1.a();	 Catch:{ UnknownHostException -> 0x00d4, SocketTimeoutException -> 0x00cd, ConnectTimeoutException -> 0x00c6, SSLHandshakeException -> 0x00bf, SSLException -> 0x00b8, ConnectException -> 0x00b1, Exception -> 0x00aa }
        goto L_0x00de;
    L_0x00aa:
        r1 = move-exception;
        r3 = -7;
        r4 = r1.getMessage();
        goto L_0x00da;
    L_0x00b1:
        r1 = move-exception;
        r3 = -6;
        r4 = r1.getMessage();
        goto L_0x00da;
    L_0x00b8:
        r1 = move-exception;
        r3 = -5;
        r4 = r1.getMessage();
        goto L_0x00da;
    L_0x00bf:
        r1 = move-exception;
        r3 = -4;
        r4 = r1.getMessage();
        goto L_0x00da;
    L_0x00c6:
        r1 = move-exception;
        r3 = -3;
        r4 = r1.getMessage();
        goto L_0x00da;
    L_0x00cd:
        r1 = move-exception;
        r3 = -2;
        r4 = r1.getMessage();
        goto L_0x00da;
    L_0x00d4:
        r1 = move-exception;
        r3 = -1;
        r4 = r1.getMessage();
    L_0x00da:
        r1 = r5;
        goto L_0x0006;
    L_0x00dd:
        r1 = r2;
    L_0x00de:
        if (r1 != 0) goto L_0x00ef;
    L_0x00e0:
        r1 = new mtopsdk.a.b.f;
        r1.<init>();
        r1.a = r0;
        r1.b = r3;
        r1.c = r4;
        r1 = r1.a();
    L_0x00ef:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.a.c.b():mtopsdk.a.b.e");
    }

    private static void a(java.net.HttpURLConnection r4, mtopsdk.a.b.b r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r5.b;
        r4.setRequestMethod(r0);
        r0 = r5.c;
        r0 = r0.entrySet();
        r0 = r0.iterator();
    L_0x000f:
        r1 = r0.hasNext();
        if (r1 == 0) goto L_0x0039;
    L_0x0015:
        r1 = r0.next();
        r1 = (java.util.Map.Entry) r1;
        r2 = r1.getKey();
        r2 = (java.lang.String) r2;
        r3 = "Cookie";
        r2 = r2.equalsIgnoreCase(r3);
        if (r2 != 0) goto L_0x000f;
    L_0x0029:
        r2 = r1.getKey();
        r2 = (java.lang.String) r2;
        r1 = r1.getValue();
        r1 = (java.lang.String) r1;
        r4.addRequestProperty(r2, r1);
        goto L_0x000f;
    L_0x0039:
        r0 = r5.a;
        r0 = mtopsdk.a.a.a.a(r0);
        r0 = mtopsdk.common.util.i.b(r0);
        if (r0 != 0) goto L_0x0050;
    L_0x0045:
        r0 = "Cookie";
        r1 = r5.a;
        r1 = mtopsdk.a.a.a.a(r1);
        r4.addRequestProperty(r0, r1);
    L_0x0050:
        r0 = "POST";
        r1 = r5.b;
        r0 = r0.equalsIgnoreCase(r1);
        r1 = 1;
        if (r0 == 0) goto L_0x005e;
    L_0x005b:
        r4.setDoOutput(r1);
    L_0x005e:
        r5 = r5.d;
        if (r5 == 0) goto L_0x0088;
    L_0x0062:
        r4.setDoOutput(r1);
        r0 = "Content-Type";
        r1 = r5.a();
        r4.addRequestProperty(r0, r1);
        r4 = r4.getOutputStream();
        r5.a(r4);	 Catch:{ Exception -> 0x007b }
        com.taobao.tao.remotebusiness.listener.c.a(r4);
        return;
    L_0x0079:
        r5 = move-exception;
        goto L_0x0084;
    L_0x007b:
        r5 = "write outputstream error.";	 Catch:{ all -> 0x0079 }
        mtopsdk.common.util.j.f(r5);	 Catch:{ all -> 0x0079 }
        com.taobao.tao.remotebusiness.listener.c.a(r4);
        return;
    L_0x0084:
        com.taobao.tao.remotebusiness.listener.c.a(r4);
        throw r5;
    L_0x0088:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.a.c.a(java.net.HttpURLConnection, mtopsdk.a.b.b):void");
    }
}
