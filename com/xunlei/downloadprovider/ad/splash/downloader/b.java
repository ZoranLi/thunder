package com.xunlei.downloadprovider.ad.splash.downloader;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Timer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;

/* compiled from: DownloadDispatcher */
final class b extends Thread {
    volatile boolean a = false;
    private final BlockingQueue<DownloadRequest> b;
    private a c;
    private final int d = 4096;
    private int e = 0;
    private final int f = 5;
    private final int g = 416;
    private final int h = 307;
    private long i;
    private long j;
    private boolean k = true;
    private Timer l;

    b(BlockingQueue<DownloadRequest> blockingQueue, a aVar) {
        this.b = blockingQueue;
        this.c = aVar;
    }

    public final void run() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = 10;
        android.os.Process.setThreadPriority(r0);
        r0 = new java.util.Timer;
        r0.<init>();
        r3.l = r0;
    L_0x000c:
        r0 = 0;
        r1 = r3.b;	 Catch:{ InterruptedException -> 0x0035 }
        r1 = r1.take();	 Catch:{ InterruptedException -> 0x0035 }
        r1 = (com.xunlei.downloadprovider.ad.splash.downloader.DownloadRequest) r1;	 Catch:{ InterruptedException -> 0x0035 }
        r0 = 0;
        r3.e = r0;	 Catch:{ InterruptedException -> 0x0034 }
        r0 = 1;	 Catch:{ InterruptedException -> 0x0034 }
        r3.k = r0;	 Catch:{ InterruptedException -> 0x0034 }
        r0 = new java.lang.StringBuilder;	 Catch:{ InterruptedException -> 0x0034 }
        r2 = "Download initiated for ";	 Catch:{ InterruptedException -> 0x0034 }
        r0.<init>(r2);	 Catch:{ InterruptedException -> 0x0034 }
        r2 = r1.b;	 Catch:{ InterruptedException -> 0x0034 }
        r0.append(r2);	 Catch:{ InterruptedException -> 0x0034 }
        r0 = 2;	 Catch:{ InterruptedException -> 0x0034 }
        r1.a = r0;	 Catch:{ InterruptedException -> 0x0034 }
        r0 = r1.c;	 Catch:{ InterruptedException -> 0x0034 }
        r0 = r0.toString();	 Catch:{ InterruptedException -> 0x0034 }
        r3.a(r1, r0);	 Catch:{ InterruptedException -> 0x0034 }
        goto L_0x000c;
    L_0x0034:
        r0 = r1;
    L_0x0035:
        r1 = r3.a;
        if (r1 == 0) goto L_0x000c;
    L_0x0039:
        if (r0 == 0) goto L_0x004b;
    L_0x003b:
        r0.b();
        r1 = r0.a;
        r2 = 16;
        if (r1 == r2) goto L_0x004b;
    L_0x0044:
        r1 = 1008; // 0x3f0 float:1.413E-42 double:4.98E-321;
        r2 = "Download cancelled";
        r3.a(r0, r1, r2);
    L_0x004b:
        r0 = r3.l;
        r0.cancel();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.ad.splash.downloader.b.run():void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.xunlei.downloadprovider.ad.splash.downloader.DownloadRequest r11, java.lang.String r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r10 = this;
        r0 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x027a }
        r0.<init>(r12);	 Catch:{ MalformedURLException -> 0x027a }
        r12 = 0;
        r0 = r0.openConnection();	 Catch:{ SocketTimeoutException -> 0x0262, ConnectTimeoutException -> 0x0252, IOException -> 0x023e, all -> 0x023b }
        r0 = (java.net.HttpURLConnection) r0;	 Catch:{ SocketTimeoutException -> 0x0262, ConnectTimeoutException -> 0x0252, IOException -> 0x023e, all -> 0x023b }
        r1 = 0;
        r0.setInstanceFollowRedirects(r1);	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r2 = r11.a();	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r2 = r2.a();	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r0.setConnectTimeout(r2);	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r2 = r11.a();	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r2 = r2.a();	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r0.setReadTimeout(r2);	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r2 = r11.j;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        if (r2 == 0) goto L_0x0048;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x002a:
        r3 = r2.keySet();	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r3 = r3.iterator();	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x0032:
        r4 = r3.hasNext();	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        if (r4 == 0) goto L_0x0048;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x0038:
        r4 = r3.next();	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r4 = (java.lang.String) r4;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r5 = r2.get(r4);	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r5 = (java.lang.String) r5;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r0.addRequestProperty(r4, r5);	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        goto L_0x0032;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x0048:
        r2 = 4;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r11.a = r2;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r2 = r0.getResponseCode();	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r3 = new java.lang.StringBuilder;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r4 = "Response code obtained for downloaded Id ";	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r3.<init>(r4);	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r4 = r11.b;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r3.append(r4);	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r4 = " : httpResponse Code ";	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r3.append(r4);	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r3.append(r2);	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r3 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r4 = 1;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        if (r2 == r3) goto L_0x00f6;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x0068:
        r3 = 206; // 0xce float:2.89E-43 double:1.02E-321;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        if (r2 == r3) goto L_0x00f6;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x006c:
        r12 = 307; // 0x133 float:4.3E-43 double:1.517E-321;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        if (r2 == r12) goto L_0x00b7;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x0070:
        r12 = 416; // 0x1a0 float:5.83E-43 double:2.055E-321;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        if (r2 == r12) goto L_0x00af;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x0074:
        r12 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        if (r2 == r12) goto L_0x00a7;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x0078:
        r12 = 503; // 0x1f7 float:7.05E-43 double:2.485E-321;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        if (r2 == r12) goto L_0x009f;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x007c:
        switch(r2) {
            case 301: goto L_0x00b7;
            case 302: goto L_0x00b7;
            case 303: goto L_0x00b7;
            default: goto L_0x007f;
        };	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x007f:
        r12 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r1 = new java.lang.StringBuilder;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r3 = "Unhandled HTTP response:";	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r1.<init>(r3);	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r1.append(r2);	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r2 = " message:";	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r1.append(r2);	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r2 = r0.getResponseMessage();	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r1.append(r2);	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r1 = r1.toString();	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r10.a(r11, r12, r1);	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        goto L_0x00f0;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x009f:
        r1 = r0.getResponseMessage();	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r10.a(r11, r12, r1);	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        goto L_0x00f0;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x00a7:
        r1 = r0.getResponseMessage();	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r10.a(r11, r12, r1);	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        goto L_0x00f0;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x00af:
        r1 = r0.getResponseMessage();	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r10.a(r11, r12, r1);	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        goto L_0x00f0;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x00b7:
        r12 = r10.e;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r1 = 5;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        if (r12 >= r1) goto L_0x00db;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x00bc:
        r12 = r10.k;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        if (r12 == 0) goto L_0x00db;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x00c0:
        r12 = r10.e;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r12 = r12 + r4;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r10.e = r12;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r12 = new java.lang.StringBuilder;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r1 = "Redirect for downloaded Id ";	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r12.<init>(r1);	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r1 = r11.b;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r12.append(r1);	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r12 = "Location";	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r12 = r0.getHeaderField(r12);	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r10.a(r11, r12);	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        goto L_0x00b7;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x00db:
        r12 = r10.e;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        if (r12 <= r1) goto L_0x00f0;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x00df:
        r12 = r10.k;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        if (r12 == 0) goto L_0x00f0;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x00e3:
        r12 = 1005; // 0x3ed float:1.408E-42 double:4.965E-321;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r1 = "Too many redirects, giving up";	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r10.a(r11, r12, r1);	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        if (r0 == 0) goto L_0x00ef;
    L_0x00ec:
        r0.disconnect();
    L_0x00ef:
        return;
    L_0x00f0:
        if (r0 == 0) goto L_0x0272;
    L_0x00f2:
        r0.disconnect();
        return;
    L_0x00f6:
        r10.k = r1;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r2 = "Transfer-Encoding";	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r2 = r0.getHeaderField(r2);	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r5 = -1;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r10.i = r5;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        if (r2 != 0) goto L_0x010d;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x0104:
        r3 = "Content-Length";	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r7 = a(r0, r3);	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r10.i = r7;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        goto L_0x0119;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x010d:
        r3 = new java.lang.StringBuilder;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r7 = "Ignoring Content-Length since Transfer-Encoding is also defined for Downloaded Id ";	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r3.<init>(r7);	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r7 = r11.b;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r3.append(r7);	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x0119:
        r7 = r10.i;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r3 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1));	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        if (r3 != 0) goto L_0x012b;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x011f:
        if (r2 == 0) goto L_0x0129;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x0121:
        r3 = "chunked";	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r2 = r2.equalsIgnoreCase(r3);	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        if (r2 != 0) goto L_0x012b;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x0129:
        r2 = -1;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        goto L_0x012c;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x012b:
        r2 = r4;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x012c:
        if (r2 != r4) goto L_0x0228;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x012e:
        b(r11);	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r2 = r0.getInputStream();	 Catch:{ IOException -> 0x013b }
        goto L_0x0140;
    L_0x0136:
        r1 = move-exception;
        r2 = r12;
        r3 = r2;
        goto L_0x01ec;
    L_0x013b:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ all -> 0x0136 }
        r2 = r12;
    L_0x0140:
        r3 = new java.io.File;	 Catch:{ all -> 0x01ea }
        r5 = r11.d;	 Catch:{ all -> 0x01ea }
        r5 = r5.getPath();	 Catch:{ all -> 0x01ea }
        r3.<init>(r5);	 Catch:{ all -> 0x01ea }
        r5 = r3.exists();	 Catch:{ all -> 0x01ea }
        r6 = 1001; // 0x3e9 float:1.403E-42 double:4.946E-321;
        if (r5 != 0) goto L_0x0178;
    L_0x0153:
        r5 = r3.getParentFile();	 Catch:{ IOException -> 0x016e }
        if (r5 == 0) goto L_0x0162;	 Catch:{ IOException -> 0x016e }
    L_0x0159:
        r7 = r5.exists();	 Catch:{ IOException -> 0x016e }
        if (r7 != 0) goto L_0x0162;	 Catch:{ IOException -> 0x016e }
    L_0x015f:
        r5.mkdirs();	 Catch:{ IOException -> 0x016e }
    L_0x0162:
        r5 = r3.createNewFile();	 Catch:{ IOException -> 0x016e }
        if (r5 != 0) goto L_0x0178;	 Catch:{ IOException -> 0x016e }
    L_0x0168:
        r1 = "Error in creating destination file";	 Catch:{ IOException -> 0x016e }
        r10.a(r11, r6, r1);	 Catch:{ IOException -> 0x016e }
        goto L_0x0177;
    L_0x016e:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ all -> 0x01ea }
        r1 = "Error in creating destination file";	 Catch:{ all -> 0x01ea }
        r10.a(r11, r6, r1);	 Catch:{ all -> 0x01ea }
    L_0x0177:
        r1 = r4;
    L_0x0178:
        if (r1 != 0) goto L_0x01ad;
    L_0x017a:
        r1 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x0189 }
        r1.<init>(r3, r4);	 Catch:{ IOException -> 0x0189 }
        r3 = r1;	 Catch:{ IOException -> 0x0187 }
        r3 = (java.io.FileOutputStream) r3;	 Catch:{ IOException -> 0x0187 }
        r3 = r3.getFD();	 Catch:{ IOException -> 0x0187 }
        goto L_0x018f;
    L_0x0187:
        r3 = move-exception;
        goto L_0x018b;
    L_0x0189:
        r3 = move-exception;
        r1 = r12;
    L_0x018b:
        r3.printStackTrace();	 Catch:{ all -> 0x01a7 }
        r3 = r12;
    L_0x018f:
        r12 = r1;
        if (r2 != 0) goto L_0x019b;
    L_0x0192:
        r1 = "Error in creating input stream";	 Catch:{ all -> 0x0198 }
        r10.a(r11, r6, r1);	 Catch:{ all -> 0x0198 }
        goto L_0x01ae;	 Catch:{ all -> 0x0198 }
    L_0x0198:
        r1 = move-exception;	 Catch:{ all -> 0x0198 }
        goto L_0x01ec;	 Catch:{ all -> 0x0198 }
    L_0x019b:
        if (r12 != 0) goto L_0x01a3;	 Catch:{ all -> 0x0198 }
    L_0x019d:
        r1 = "Error in writing download contents to the destination file";	 Catch:{ all -> 0x0198 }
        r10.a(r11, r6, r1);	 Catch:{ all -> 0x0198 }
        goto L_0x01ae;	 Catch:{ all -> 0x0198 }
    L_0x01a3:
        r10.a(r11, r2, r12);	 Catch:{ all -> 0x0198 }
        goto L_0x01ae;
    L_0x01a7:
        r3 = move-exception;
        r9 = r3;
        r3 = r12;
        r12 = r1;
        r1 = r9;
        goto L_0x01ec;
    L_0x01ad:
        r3 = r12;
    L_0x01ae:
        if (r2 == 0) goto L_0x01b8;
    L_0x01b0:
        r2.close();	 Catch:{ IOException -> 0x01b4, SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237 }
        goto L_0x01b8;
    L_0x01b4:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x01b8:
        if (r12 == 0) goto L_0x01c2;
    L_0x01ba:
        r12.flush();	 Catch:{ IOException -> 0x01c0 }
        goto L_0x01c2;	 Catch:{ IOException -> 0x01c0 }
    L_0x01be:
        r1 = move-exception;	 Catch:{ IOException -> 0x01c0 }
        goto L_0x01d7;	 Catch:{ IOException -> 0x01c0 }
    L_0x01c0:
        r1 = move-exception;	 Catch:{ IOException -> 0x01c0 }
        goto L_0x01c8;	 Catch:{ IOException -> 0x01c0 }
    L_0x01c2:
        if (r3 == 0) goto L_0x01e2;	 Catch:{ IOException -> 0x01c0 }
    L_0x01c4:
        r3.sync();	 Catch:{ IOException -> 0x01c0 }
        goto L_0x01e2;
    L_0x01c8:
        r1.printStackTrace();	 Catch:{ all -> 0x01be }
        if (r12 == 0) goto L_0x022f;
    L_0x01cd:
        r12.close();	 Catch:{ IOException -> 0x01d2, SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237 }
        goto L_0x022f;
    L_0x01d2:
        r12 = move-exception;
    L_0x01d3:
        r12.printStackTrace();	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        goto L_0x022f;
    L_0x01d7:
        if (r12 == 0) goto L_0x01e1;
    L_0x01d9:
        r12.close();	 Catch:{ IOException -> 0x01dd, SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237 }
        goto L_0x01e1;
    L_0x01dd:
        r12 = move-exception;
        r12.printStackTrace();	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x01e1:
        throw r1;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x01e2:
        if (r12 == 0) goto L_0x022f;
    L_0x01e4:
        r12.close();	 Catch:{ IOException -> 0x01e8, SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237 }
        goto L_0x022f;
    L_0x01e8:
        r12 = move-exception;
        goto L_0x01d3;
    L_0x01ea:
        r1 = move-exception;
        r3 = r12;
    L_0x01ec:
        if (r2 == 0) goto L_0x01f6;
    L_0x01ee:
        r2.close();	 Catch:{ IOException -> 0x01f2, SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237 }
        goto L_0x01f6;
    L_0x01f2:
        r2 = move-exception;
        r2.printStackTrace();	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x01f6:
        if (r12 == 0) goto L_0x0200;
    L_0x01f8:
        r12.flush();	 Catch:{ IOException -> 0x01fe }
        goto L_0x0200;	 Catch:{ IOException -> 0x01fe }
    L_0x01fc:
        r1 = move-exception;	 Catch:{ IOException -> 0x01fe }
        goto L_0x0214;	 Catch:{ IOException -> 0x01fe }
    L_0x01fe:
        r2 = move-exception;	 Catch:{ IOException -> 0x01fe }
        goto L_0x0206;	 Catch:{ IOException -> 0x01fe }
    L_0x0200:
        if (r3 == 0) goto L_0x021f;	 Catch:{ IOException -> 0x01fe }
    L_0x0202:
        r3.sync();	 Catch:{ IOException -> 0x01fe }
        goto L_0x021f;
    L_0x0206:
        r2.printStackTrace();	 Catch:{ all -> 0x01fc }
        if (r12 == 0) goto L_0x0227;
    L_0x020b:
        r12.close();	 Catch:{ IOException -> 0x020f, SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237 }
        goto L_0x0227;
    L_0x020f:
        r12 = move-exception;
    L_0x0210:
        r12.printStackTrace();	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        goto L_0x0227;
    L_0x0214:
        if (r12 == 0) goto L_0x021e;
    L_0x0216:
        r12.close();	 Catch:{ IOException -> 0x021a, SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237 }
        goto L_0x021e;
    L_0x021a:
        r12 = move-exception;
        r12.printStackTrace();	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x021e:
        throw r1;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x021f:
        if (r12 == 0) goto L_0x0227;
    L_0x0221:
        r12.close();	 Catch:{ IOException -> 0x0225, SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237 }
        goto L_0x0227;
    L_0x0225:
        r12 = move-exception;
        goto L_0x0210;
    L_0x0227:
        throw r1;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x0228:
        r12 = 1006; // 0x3ee float:1.41E-42 double:4.97E-321;	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r1 = "Transfer-Encoding not found as well as can't know size of download, giving up";	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
        r10.a(r11, r12, r1);	 Catch:{ SocketTimeoutException -> 0x0239, ConnectTimeoutException -> 0x0237, IOException -> 0x0235 }
    L_0x022f:
        if (r0 == 0) goto L_0x0234;
    L_0x0231:
        r0.disconnect();
    L_0x0234:
        return;
    L_0x0235:
        r12 = move-exception;
        goto L_0x0242;
    L_0x0237:
        r12 = move-exception;
        goto L_0x0256;
    L_0x0239:
        r12 = move-exception;
        goto L_0x0266;
    L_0x023b:
        r11 = move-exception;
        r0 = r12;
        goto L_0x0274;
    L_0x023e:
        r0 = move-exception;
        r9 = r0;
        r0 = r12;
        r12 = r9;
    L_0x0242:
        r12.printStackTrace();	 Catch:{ all -> 0x0273 }
        r12 = 1004; // 0x3ec float:1.407E-42 double:4.96E-321;	 Catch:{ all -> 0x0273 }
        r1 = "Trouble with low-level sockets";	 Catch:{ all -> 0x0273 }
        r10.a(r11, r12, r1);	 Catch:{ all -> 0x0273 }
        if (r0 == 0) goto L_0x0272;
    L_0x024e:
        r0.disconnect();
        return;
    L_0x0252:
        r0 = move-exception;
        r9 = r0;
        r0 = r12;
        r12 = r9;
    L_0x0256:
        r12.printStackTrace();	 Catch:{ all -> 0x0273 }
        r10.a(r11);	 Catch:{ all -> 0x0273 }
        if (r0 == 0) goto L_0x0272;
    L_0x025e:
        r0.disconnect();
        return;
    L_0x0262:
        r0 = move-exception;
        r9 = r0;
        r0 = r12;
        r12 = r9;
    L_0x0266:
        r12.printStackTrace();	 Catch:{ all -> 0x0273 }
        r10.a(r11);	 Catch:{ all -> 0x0273 }
        if (r0 == 0) goto L_0x0272;
    L_0x026e:
        r0.disconnect();
        return;
    L_0x0272:
        return;
    L_0x0273:
        r11 = move-exception;
    L_0x0274:
        if (r0 == 0) goto L_0x0279;
    L_0x0276:
        r0.disconnect();
    L_0x0279:
        throw r11;
    L_0x027a:
        r12 = 1007; // 0x3ef float:1.411E-42 double:4.975E-321;
        r0 = "MalformedURLException: URI passed is malformed.";
        r10.a(r11, r12, r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.ad.splash.downloader.b.a(com.xunlei.downloadprovider.ad.splash.downloader.DownloadRequest, java.lang.String):void");
    }

    private void a(DownloadRequest downloadRequest, InputStream inputStream, OutputStream outputStream) {
        DownloadRequest downloadRequest2 = downloadRequest;
        byte[] bArr = new byte[4096];
        long j = 0;
        this.j = 0;
        downloadRequest2.a = 8;
        StringBuilder stringBuilder = new StringBuilder("Content Length: ");
        stringBuilder.append(this.i);
        stringBuilder.append(" for Download Id ");
        stringBuilder.append(downloadRequest2.b);
        while (!downloadRequest2.f) {
            int a = a(downloadRequest2, bArr, inputStream);
            if (r0.i != -1 && r0.i > r11) {
                int i = (int) ((r0.j * 100) / r0.i);
                long j2 = r0.j;
                a aVar = r0.c;
                long j3 = r0.i;
                Executor executor = aVar.a;
                h hVar = r1;
                h hVar2 = new h(aVar, downloadRequest2, j3, j2, i);
                executor.execute(hVar);
            }
            if (a == -1) {
                a aVar2 = r0.c;
                aVar2.a.execute(new f(aVar2, downloadRequest2));
                downloadRequest2.a = 16;
                downloadRequest.b();
                return;
            } else if (a != Integer.MIN_VALUE) {
                if (a(downloadRequest2, bArr, a, outputStream)) {
                    r0.j += (long) a;
                    j = 0;
                } else {
                    downloadRequest.b();
                    a(downloadRequest2, 1001, "Failed writing file");
                    return;
                }
            } else {
                return;
            }
        }
        new StringBuilder("Stopping the download as Download Request is cancelled for Downloaded Id ").append(downloadRequest2.b);
        downloadRequest.b();
        a(downloadRequest2, 1008, "Download cancelled");
    }

    private int a(DownloadRequest downloadRequest, byte[] bArr, InputStream inputStream) {
        try {
            return inputStream.read(bArr);
        } catch (byte[] bArr2) {
            if ("unexpected end of stream".equals(bArr2.getMessage()) != null) {
                return -1;
            }
            a(downloadRequest, (int) 1004, "IOException: Failed reading response");
            return Integer.MIN_VALUE;
        }
    }

    private boolean a(com.xunlei.downloadprovider.ad.splash.downloader.DownloadRequest r3, byte[] r4, int r5, java.io.OutputStream r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = this;
        r0 = 1001; // 0x3e9 float:1.403E-42 double:4.946E-321;
        r1 = 0;
        r6.write(r4, r1, r5);	 Catch:{ IOException -> 0x000e, Exception -> 0x0008 }
        r1 = 1;
        goto L_0x0013;
    L_0x0008:
        r4 = "Exception when writing download contents to the destination file";
        r2.a(r3, r0, r4);
        goto L_0x0013;
    L_0x000e:
        r4 = "IOException when writing download contents to the destination file";
        r2.a(r3, r0, r4);
    L_0x0013:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.ad.splash.downloader.b.a(com.xunlei.downloadprovider.ad.splash.downloader.DownloadRequest, byte[], int, java.io.OutputStream):boolean");
    }

    private static long a(java.net.URLConnection r0, java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r0.getHeaderField(r1);	 Catch:{ NumberFormatException -> 0x0009 }
        r0 = java.lang.Long.parseLong(r0);	 Catch:{ NumberFormatException -> 0x0009 }
        return r0;
    L_0x0009:
        r0 = -1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.ad.splash.downloader.b.a(java.net.URLConnection, java.lang.String):long");
    }

    private static void b(DownloadRequest downloadRequest) {
        new StringBuilder("cleanupDestination() deleting ").append(downloadRequest.d.getPath());
        File file = new File(downloadRequest.d.getPath());
        if (file.exists() != null) {
            file.delete();
        }
    }

    private void a(DownloadRequest downloadRequest, int i, String str) {
        this.k = false;
        downloadRequest.a = 32;
        if (downloadRequest.g) {
            b(downloadRequest);
        }
        a aVar = this.c;
        aVar.a.execute(new g(aVar, downloadRequest, i, str));
        downloadRequest.b();
    }

    private void a(com.xunlei.downloadprovider.ad.splash.downloader.DownloadRequest r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = 128; // 0x80 float:1.794E-43 double:6.32E-322;
        r6.a = r0;
        r0 = r6.a();
        r0.b();	 Catch:{ RetryError -> 0x001b }
        r1 = r5.l;	 Catch:{ RetryError -> 0x001b }
        r2 = new com.xunlei.downloadprovider.ad.splash.downloader.c;	 Catch:{ RetryError -> 0x001b }
        r2.<init>(r5, r6);	 Catch:{ RetryError -> 0x001b }
        r0 = r0.a();	 Catch:{ RetryError -> 0x001b }
        r3 = (long) r0;	 Catch:{ RetryError -> 0x001b }
        r1.schedule(r2, r3);	 Catch:{ RetryError -> 0x001b }
        return;
    L_0x001b:
        r0 = 1009; // 0x3f1 float:1.414E-42 double:4.985E-321;
        r1 = "Connection time out after maximum retires attempted";
        r5.a(r6, r0, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.ad.splash.downloader.b.a(com.xunlei.downloadprovider.ad.splash.downloader.DownloadRequest):void");
    }
}
