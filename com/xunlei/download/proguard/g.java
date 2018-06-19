package com.xunlei.download.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.umeng.message.util.HttpRequest;
import com.xunlei.download.Downloads.Impl;
import com.xunlei.download.proguard.d.c;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: DownloadThread */
public class g implements Runnable {
    private static final int a = 416;
    private static final int b = 307;
    private static final int c = 20000;
    private final Context d;
    private final d e;
    private final r f;
    private final q g;
    private final e h;
    private ContentValues i;
    private boolean j = false;
    private volatile boolean k;
    private boolean l = false;
    private boolean m = true;
    private long n = 0;
    private long o = 0;

    /* compiled from: DownloadThread */
    static class a {
        public String a;
        public String b;
        public int c = 0;
        public boolean d = false;
        public String e;
        public long f = -1;
        public long g = 0;
        public String h;
        public boolean i = false;
        public long j = 0;
        public long k = 0;
        public int l = -1;
        public long m;
        public long n;
        public long o;
        public long p = -1;
        public String q;
        public String r;
        public int s;
        public URL t;

        public a(d dVar) {
            this.b = am.a(dVar.h);
            this.e = dVar.d;
            this.a = dVar.g;
            this.f = dVar.v;
            this.g = dVar.w;
        }

        public void a() {
            this.p = -1;
            this.q = null;
            this.r = null;
            this.s = 0;
        }
    }

    public static boolean a(int i) {
        return i == Impl.STATUS_FILE_ERROR || i == Impl.STATUS_HTTP_DATA_ERROR || i == 500 || i == 503;
    }

    private void b(a aVar) {
    }

    private boolean f(a aVar) {
        return false;
    }

    public g(Context context, r rVar, d dVar, q qVar, e eVar) {
        this.d = context;
        this.f = rVar;
        this.e = dVar;
        this.g = qVar;
        this.h = eVar;
    }

    private String b() {
        String str = this.e.t;
        return str == null ? c.t : str;
    }

    public synchronized boolean a() {
        if (!this.m) {
            this.l = true;
        }
        return this.m;
    }

    private synchronized void a(boolean z) {
        this.m = z;
    }

    private synchronized boolean c() {
        return this.l;
    }

    public void run() {
        Process.setThreadPriority(10);
        try {
            d();
        } finally {
            this.h.a(this.e.c, 0);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void d() {
        /*
        r12 = this;
        r0 = r12.d;
        r1 = r12.e;
        r1 = r1.c;
        r0 = com.xunlei.download.proguard.d.a(r0, r1);
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r0 != r1) goto L_0x0029;
    L_0x000e:
        r0 = new java.lang.StringBuilder;
        r1 = "Download ";
        r0.<init>(r1);
        r1 = r12.e;
        r1 = r1.c;
        r0.append(r1);
        r1 = " already finished; skipping";
        r0.append(r1);
        r0 = r0.toString();
        r12.a(r0);
        return;
    L_0x0029:
        r0 = r12.e;
        r2 = r0.X;
        r12.n = r2;
        r2 = android.os.SystemClock.elapsedRealtime();
        r12.o = r2;
        r0 = 1;
        r12.a(r0);
        r2 = new com.xunlei.download.proguard.g$a;
        r3 = r12.e;
        r2.<init>(r3);
        r3 = r12.e;
        r3 = r3.m;
        r4 = r12.d;
        r5 = "power";
        r4 = r4.getSystemService(r5);
        r4 = (android.os.PowerManager) r4;
        r5 = r12.d;
        r6 = "wifi";
        r5 = r5.getSystemService(r6);
        r5 = (android.net.wifi.WifiManager) r5;
        r6 = 0;
        r7 = 491; // 0x1eb float:6.88E-43 double:2.426E-321;
        r8 = 0;
        r9 = "DownloadManager";
        r4 = r4.newWakeLock(r0, r9);	 Catch:{ p -> 0x0196, Throwable -> 0x011a, all -> 0x0115 }
        r4.acquire();	 Catch:{ p -> 0x0111, Throwable -> 0x010e, all -> 0x010a }
        r9 = 3;
        r10 = "DownloadManager";
        r5 = r5.createWifiLock(r9, r10);	 Catch:{ p -> 0x0111, Throwable -> 0x010e, all -> 0x010a }
        r5.acquire();	 Catch:{ p -> 0x0107, Throwable -> 0x0105 }
        r9 = new java.lang.StringBuilder;	 Catch:{ p -> 0x0107, Throwable -> 0x0105 }
        r10 = "Download ";
        r9.<init>(r10);	 Catch:{ p -> 0x0107, Throwable -> 0x0105 }
        r10 = r12.e;	 Catch:{ p -> 0x0107, Throwable -> 0x0105 }
        r10 = r10.c;	 Catch:{ p -> 0x0107, Throwable -> 0x0105 }
        r9.append(r10);	 Catch:{ p -> 0x0107, Throwable -> 0x0105 }
        r10 = " starting";
        r9.append(r10);	 Catch:{ p -> 0x0107, Throwable -> 0x0105 }
        r9 = r9.toString();	 Catch:{ p -> 0x0107, Throwable -> 0x0105 }
        r12.a(r9);	 Catch:{ p -> 0x0107, Throwable -> 0x0105 }
        r9 = r12.f;	 Catch:{ p -> 0x0107, Throwable -> 0x0105 }
        r10 = r12.e;	 Catch:{ p -> 0x0107, Throwable -> 0x0105 }
        r10 = r10.y;	 Catch:{ p -> 0x0107, Throwable -> 0x0105 }
        r9 = r9.a(r10);	 Catch:{ p -> 0x0107, Throwable -> 0x0105 }
        if (r9 == 0) goto L_0x009b;
    L_0x0095:
        r9 = r9.getType();	 Catch:{ p -> 0x0107, Throwable -> 0x0105 }
        r2.l = r9;	 Catch:{ p -> 0x0107, Throwable -> 0x0105 }
    L_0x009b:
        r9 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x00fc }
        r10 = r2.e;	 Catch:{ MalformedURLException -> 0x00fc }
        r9.<init>(r10);	 Catch:{ MalformedURLException -> 0x00fc }
        r2.t = r9;	 Catch:{ MalformedURLException -> 0x00fc }
        r12.a(r2);	 Catch:{ p -> 0x0107, Throwable -> 0x0105 }
        r12.b(r2);	 Catch:{ p -> 0x0107, Throwable -> 0x0105 }
        r0 = r2.a;
        android.text.TextUtils.isEmpty(r0);
        r12.a(r2, r1);
        r0 = r12.c();
        if (r0 != 0) goto L_0x00bb;
    L_0x00b8:
        r12.a(r2, r1, r8, r3);
    L_0x00bb:
        r0 = new java.lang.StringBuilder;
        r2 = "Download ";
        r0.<init>(r2);
        r2 = r12.e;
        r2 = r2.c;
        r0.append(r2);
        r2 = " finished with status ";
        r0.append(r2);
        r1 = com.xunlei.download.Downloads.Impl.statusToString(r1);
        r0.append(r1);
        r1 = ", errorMsg = ";
        r0.append(r1);
        r0.append(r8);
        r1 = ", title = ";
        r0.append(r1);
        r1 = r12.e;
        r1 = r1.G;
        r0.append(r1);
        r0 = r0.toString();
        r12.a(r0);
        if (r4 == 0) goto L_0x00f5;
    L_0x00f2:
        r4.release();
    L_0x00f5:
        if (r5 == 0) goto L_0x026b;
    L_0x00f7:
        r5.release();
        goto L_0x026b;
    L_0x00fc:
        r1 = move-exception;
        r9 = new com.xunlei.download.proguard.p;	 Catch:{ p -> 0x0107, Throwable -> 0x0105 }
        r10 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        r9.<init>(r10, r1);	 Catch:{ p -> 0x0107, Throwable -> 0x0105 }
        throw r9;	 Catch:{ p -> 0x0107, Throwable -> 0x0105 }
    L_0x0105:
        r0 = move-exception;
        goto L_0x011d;
    L_0x0107:
        r1 = move-exception;
        goto L_0x0199;
    L_0x010a:
        r0 = move-exception;
        r5 = r8;
        goto L_0x027a;
    L_0x010e:
        r0 = move-exception;
        r5 = r8;
        goto L_0x011d;
    L_0x0111:
        r1 = move-exception;
        r5 = r8;
        goto L_0x0199;
    L_0x0115:
        r0 = move-exception;
        r4 = r8;
        r5 = r4;
        goto L_0x027a;
    L_0x011a:
        r0 = move-exception;
        r4 = r8;
        r5 = r4;
    L_0x011d:
        r12.a(r6);	 Catch:{ all -> 0x0279 }
        r1 = r0.getMessage();	 Catch:{ all -> 0x0279 }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0192 }
        r8 = "Exception for id ";
        r6.<init>(r8);	 Catch:{ all -> 0x0192 }
        r8 = r12.e;	 Catch:{ all -> 0x0192 }
        r8 = r8.c;	 Catch:{ all -> 0x0192 }
        r6.append(r8);	 Catch:{ all -> 0x0192 }
        r8 = ": ";
        r6.append(r8);	 Catch:{ all -> 0x0192 }
        r6.append(r1);	 Catch:{ all -> 0x0192 }
        r6 = r6.toString();	 Catch:{ all -> 0x0192 }
        r8 = "DownloadManager";
        com.xunlei.download.proguard.an.a(r8, r6, r0);	 Catch:{ all -> 0x0192 }
        r0 = r2.a;
        android.text.TextUtils.isEmpty(r0);
        r12.a(r2, r7);
        r0 = r12.c();
        if (r0 != 0) goto L_0x0154;
    L_0x0151:
        r12.a(r2, r7, r1, r3);
    L_0x0154:
        r0 = new java.lang.StringBuilder;
        r2 = "Download ";
        r0.<init>(r2);
        r2 = r12.e;
        r2 = r2.c;
        r0.append(r2);
        r2 = " finished with status ";
        r0.append(r2);
        r2 = com.xunlei.download.Downloads.Impl.statusToString(r7);
        r0.append(r2);
        r2 = ", errorMsg = ";
        r0.append(r2);
        r0.append(r1);
        r1 = ", title = ";
        r0.append(r1);
        r1 = r12.e;
        r1 = r1.G;
        r0.append(r1);
        r0 = r0.toString();
        r12.a(r0);
        if (r4 == 0) goto L_0x018e;
    L_0x018b:
        r4.release();
    L_0x018e:
        if (r5 == 0) goto L_0x026b;
    L_0x0190:
        goto L_0x00f7;
    L_0x0192:
        r0 = move-exception;
        r8 = r1;
        goto L_0x027a;
    L_0x0196:
        r1 = move-exception;
        r4 = r8;
        r5 = r4;
    L_0x0199:
        r12.a(r6);	 Catch:{ all -> 0x0279 }
        r6 = r1.getMessage();	 Catch:{ all -> 0x0279 }
        r8 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0276 }
        r9 = "Aborting request for download ";
        r8.<init>(r9);	 Catch:{ all -> 0x0276 }
        r9 = r12.e;	 Catch:{ all -> 0x0276 }
        r9 = r9.c;	 Catch:{ all -> 0x0276 }
        r8.append(r9);	 Catch:{ all -> 0x0276 }
        r9 = ": ";
        r8.append(r9);	 Catch:{ all -> 0x0276 }
        r8.append(r6);	 Catch:{ all -> 0x0276 }
        r8 = r8.toString();	 Catch:{ all -> 0x0276 }
        r12.a(r8);	 Catch:{ all -> 0x0276 }
        r1 = r1.getFinalStatus();	 Catch:{ all -> 0x0276 }
        r7 = 194; // 0xc2 float:2.72E-43 double:9.6E-322;
        if (r1 != r7) goto L_0x01d1;
    L_0x01c5:
        r0 = new java.lang.IllegalStateException;	 Catch:{ all -> 0x01cd }
        r7 = "Execution should always throw final error codes";
        r0.<init>(r7);	 Catch:{ all -> 0x01cd }
        throw r0;	 Catch:{ all -> 0x01cd }
    L_0x01cd:
        r0 = move-exception;
        r7 = r1;
        goto L_0x0277;
    L_0x01d1:
        r8 = a(r1);	 Catch:{ all -> 0x01cd }
        if (r8 == 0) goto L_0x0202;
    L_0x01d7:
        r8 = r2.d;	 Catch:{ all -> 0x01cd }
        if (r8 == 0) goto L_0x01dd;
    L_0x01db:
        r3 = r0;
        goto L_0x01e0;
    L_0x01dd:
        r0 = r3 + 1;
        goto L_0x01db;
    L_0x01e0:
        r0 = 5;
        if (r3 >= r0) goto L_0x021c;
    L_0x01e3:
        r0 = r12.f;	 Catch:{ all -> 0x01cd }
        r8 = r12.e;	 Catch:{ all -> 0x01cd }
        r8 = r8.y;	 Catch:{ all -> 0x01cd }
        r0 = r0.a(r8);	 Catch:{ all -> 0x01cd }
        if (r0 == 0) goto L_0x01ff;
    L_0x01ef:
        r8 = r0.getType();	 Catch:{ all -> 0x01cd }
        r9 = r2.l;	 Catch:{ all -> 0x01cd }
        if (r8 != r9) goto L_0x01ff;
    L_0x01f7:
        r0 = r0.isConnected();	 Catch:{ all -> 0x01cd }
        if (r0 == 0) goto L_0x01ff;
    L_0x01fd:
        r1 = r7;
        goto L_0x021c;
    L_0x01ff:
        r1 = 195; // 0xc3 float:2.73E-43 double:9.63E-322;
        goto L_0x021c;
    L_0x0202:
        r0 = 489; // 0x1e9 float:6.85E-43 double:2.416E-321;
        if (r1 != r0) goto L_0x021c;
    L_0x0206:
        r0 = com.android.providers.downloads.XlTaskHelper.a();	 Catch:{ all -> 0x01cd }
        r7 = r12.f;	 Catch:{ all -> 0x01cd }
        r8 = r12.e;	 Catch:{ all -> 0x01cd }
        r8 = r8.y;	 Catch:{ all -> 0x01cd }
        r7 = r7.a(r8);	 Catch:{ all -> 0x01cd }
        r0 = r0.a(r7);	 Catch:{ all -> 0x01cd }
        if (r0 == 0) goto L_0x021c;
    L_0x021a:
        r1 = 193; // 0xc1 float:2.7E-43 double:9.54E-322;
    L_0x021c:
        r0 = r2.a;
        android.text.TextUtils.isEmpty(r0);
        r12.a(r2, r1);
        r0 = r12.c();
        if (r0 != 0) goto L_0x022d;
    L_0x022a:
        r12.a(r2, r1, r6, r3);
    L_0x022d:
        r0 = new java.lang.StringBuilder;
        r2 = "Download ";
        r0.<init>(r2);
        r2 = r12.e;
        r2 = r2.c;
        r0.append(r2);
        r2 = " finished with status ";
        r0.append(r2);
        r1 = com.xunlei.download.Downloads.Impl.statusToString(r1);
        r0.append(r1);
        r1 = ", errorMsg = ";
        r0.append(r1);
        r0.append(r6);
        r1 = ", title = ";
        r0.append(r1);
        r1 = r12.e;
        r1 = r1.G;
        r0.append(r1);
        r0 = r0.toString();
        r12.a(r0);
        if (r4 == 0) goto L_0x0267;
    L_0x0264:
        r4.release();
    L_0x0267:
        if (r5 == 0) goto L_0x026b;
    L_0x0269:
        goto L_0x00f7;
    L_0x026b:
        r0 = r12.g;
        r0.a();
        r0 = "download thread exit.";
        r12.a(r0);
        return;
    L_0x0276:
        r0 = move-exception;
    L_0x0277:
        r8 = r6;
        goto L_0x027a;
    L_0x0279:
        r0 = move-exception;
    L_0x027a:
        r1 = r2.a;
        android.text.TextUtils.isEmpty(r1);
        r12.a(r2, r7);
        r1 = r12.c();
        if (r1 != 0) goto L_0x028b;
    L_0x0288:
        r12.a(r2, r7, r8, r3);
    L_0x028b:
        r1 = new java.lang.StringBuilder;
        r2 = "Download ";
        r1.<init>(r2);
        r2 = r12.e;
        r2 = r2.c;
        r1.append(r2);
        r2 = " finished with status ";
        r1.append(r2);
        r2 = com.xunlei.download.Downloads.Impl.statusToString(r7);
        r1.append(r2);
        r2 = ", errorMsg = ";
        r1.append(r2);
        r1.append(r8);
        r2 = ", title = ";
        r1.append(r2);
        r2 = r12.e;
        r2 = r2.G;
        r1.append(r2);
        r1 = r1.toString();
        r12.a(r1);
        if (r4 == 0) goto L_0x02c5;
    L_0x02c2:
        r4.release();
    L_0x02c5:
        if (r5 == 0) goto L_0x02ca;
    L_0x02c7:
        r5.release();
    L_0x02ca:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.proguard.g.d():void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(com.xunlei.download.proguard.g.a r6) throws com.xunlei.download.proguard.p {
        /*
        r5 = this;
        r6.a();
        r5.h(r6);
        r0 = r6.g;
        r2 = r6.f;
        r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
        if (r4 != 0) goto L_0x0029;
    L_0x000e:
        r6 = new java.lang.StringBuilder;
        r0 = "Skipping initiating request for download ";
        r6.<init>(r0);
        r0 = r5.e;
        r0 = r0.c;
        r6.append(r0);
        r0 = "; already completed";
        r6.append(r0);
        r6 = r6.toString();
        r5.a(r6);
        return;
    L_0x0029:
        r0 = r6.s;
        r1 = r0 + 1;
        r6.s = r1;
        r1 = 5;
        if (r0 >= r1) goto L_0x011a;
    L_0x0032:
        r0 = 0;
        r1 = r6.f;	 Catch:{ IOException -> 0x010b }
        r5.a(r1);	 Catch:{ IOException -> 0x010b }
        r1 = "begin to get data from server.";
        r5.a(r1);	 Catch:{ IOException -> 0x010b }
        r1 = r6.t;	 Catch:{ IOException -> 0x010b }
        r1 = r1.openConnection();	 Catch:{ IOException -> 0x010b }
        r1 = (java.net.HttpURLConnection) r1;	 Catch:{ IOException -> 0x010b }
        r0 = 0;
        r1.setInstanceFollowRedirects(r0);	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        r0 = 20000; // 0x4e20 float:2.8026E-41 double:9.8813E-320;
        r1.setConnectTimeout(r0);	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        r1.setReadTimeout(r0);	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        r5.e(r6, r1);	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        r0 = r1.getResponseCode();	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        r2 = new java.lang.StringBuilder;	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        r3 = "server response: ";
        r2.<init>(r3);	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        r2.append(r0);	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        r2 = r2.toString();	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        r5.a(r2);	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        r5.c(r6);	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        r2 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        r3 = 489; // 0x1e9 float:6.85E-43 double:2.416E-321;
        if (r0 == r2) goto L_0x00eb;
    L_0x0072:
        r2 = 206; // 0xce float:2.89E-43 double:1.02E-321;
        if (r0 == r2) goto L_0x00d6;
    L_0x0076:
        r2 = 307; // 0x133 float:4.3E-43 double:1.517E-321;
        if (r0 == r2) goto L_0x00b5;
    L_0x007a:
        r2 = 416; // 0x1a0 float:5.83E-43 double:2.055E-321;
        if (r0 == r2) goto L_0x00ad;
    L_0x007e:
        r2 = 500; // 0x1f4 float:7.0E-43 double:2.47E-321;
        if (r0 == r2) goto L_0x00a3;
    L_0x0082:
        r2 = 503; // 0x1f7 float:7.05E-43 double:2.485E-321;
        if (r0 == r2) goto L_0x0096;
    L_0x0086:
        switch(r0) {
            case 301: goto L_0x00b5;
            case 302: goto L_0x00b5;
            case 303: goto L_0x00b5;
            default: goto L_0x0089;
        };	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
    L_0x0089:
        r2 = r1.getResponseMessage();	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        com.xunlei.download.proguard.p.throwUnhandledHttpError(r0, r2);	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        if (r1 == 0) goto L_0x0029;
    L_0x0092:
        r1.disconnect();
        goto L_0x0029;
    L_0x0096:
        r5.d(r6, r1);	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        r6 = new com.xunlei.download.proguard.p;	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        r0 = r1.getResponseMessage();	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        r6.<init>(r2, r0);	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        throw r6;	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
    L_0x00a3:
        r6 = new com.xunlei.download.proguard.p;	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        r0 = r1.getResponseMessage();	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        r6.<init>(r2, r0);	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        throw r6;	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
    L_0x00ad:
        r6 = new com.xunlei.download.proguard.p;	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        r0 = "Requested range not satisfiable";
        r6.<init>(r3, r0);	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        throw r6;	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
    L_0x00b5:
        r2 = "Location";
        r2 = r1.getHeaderField(r2);	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        r3 = new java.net.URL;	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        r4 = r6.t;	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        r3.<init>(r4, r2);	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        r6.t = r3;	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        r2 = 1;
        r5.j = r2;	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        r2 = 301; // 0x12d float:4.22E-43 double:1.487E-321;
        if (r0 != r2) goto L_0x00d3;
    L_0x00cb:
        r0 = r6.t;	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        r0 = r0.toString();	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        r6.e = r0;	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
    L_0x00d3:
        if (r1 == 0) goto L_0x0029;
    L_0x00d5:
        goto L_0x0092;
    L_0x00d6:
        r0 = r6.i;	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        if (r0 != 0) goto L_0x00e2;
    L_0x00da:
        r6 = new com.xunlei.download.proguard.p;	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        r0 = "Expected OK, but received partial";
        r6.<init>(r3, r0);	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        throw r6;	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
    L_0x00e2:
        r5.a(r6, r1);	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        if (r1 == 0) goto L_0x00ea;
    L_0x00e7:
        r1.disconnect();
    L_0x00ea:
        return;
    L_0x00eb:
        r0 = r6.i;	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        if (r0 == 0) goto L_0x00f7;
    L_0x00ef:
        r6 = new com.xunlei.download.proguard.p;	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        r0 = "Expected partial, but received OK";
        r6.<init>(r3, r0);	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        throw r6;	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
    L_0x00f7:
        r5.b(r6, r1);	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        r5.a(r6, r1);	 Catch:{ IOException -> 0x0105, all -> 0x0103 }
        if (r1 == 0) goto L_0x0102;
    L_0x00ff:
        r1.disconnect();
    L_0x0102:
        return;
    L_0x0103:
        r6 = move-exception;
        goto L_0x0114;
    L_0x0105:
        r6 = move-exception;
        r0 = r1;
        goto L_0x010c;
    L_0x0108:
        r6 = move-exception;
        r1 = r0;
        goto L_0x0114;
    L_0x010b:
        r6 = move-exception;
    L_0x010c:
        r1 = new com.xunlei.download.proguard.p;	 Catch:{ all -> 0x0108 }
        r2 = 495; // 0x1ef float:6.94E-43 double:2.446E-321;
        r1.<init>(r2, r6);	 Catch:{ all -> 0x0108 }
        throw r1;	 Catch:{ all -> 0x0108 }
    L_0x0114:
        if (r1 == 0) goto L_0x0119;
    L_0x0116:
        r1.disconnect();
    L_0x0119:
        throw r6;
    L_0x011a:
        r6 = new com.xunlei.download.proguard.p;
        r0 = 497; // 0x1f1 float:6.96E-43 double:2.456E-321;
        r1 = "Too many redirects";
        r6.<init>(r0, r1);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.proguard.g.a(com.xunlei.download.proguard.g$a):void");
    }

    private void a(com.xunlei.download.proguard.g.a r7, java.net.HttpURLConnection r8) throws com.xunlei.download.proguard.p {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = 0;
        r8 = r8.getInputStream();	 Catch:{ IOException -> 0x0053 }
        r1 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x0039, p -> 0x0036, all -> 0x0033 }
        r2 = r7.a;	 Catch:{ IOException -> 0x0039, p -> 0x0036, all -> 0x0033 }
        r3 = 1;	 Catch:{ IOException -> 0x0039, p -> 0x0036, all -> 0x0033 }
        r1.<init>(r2, r3);	 Catch:{ IOException -> 0x0039, p -> 0x0036, all -> 0x0033 }
        r2 = r1;	 Catch:{ IOException -> 0x0031 }
        r2 = (java.io.FileOutputStream) r2;	 Catch:{ IOException -> 0x0031 }
        r2 = r2.getFD();	 Catch:{ IOException -> 0x0031 }
        r6.a(r7, r8, r1);	 Catch:{ p -> 0x002f }
        com.xunlei.download.proguard.ab.a(r8);
        r1.flush();	 Catch:{ IOException -> 0x002b, all -> 0x0026 }
        if (r2 == 0) goto L_0x0022;	 Catch:{ IOException -> 0x002b, all -> 0x0026 }
    L_0x001f:
        r2.sync();	 Catch:{ IOException -> 0x002b, all -> 0x0026 }
    L_0x0022:
        com.xunlei.download.proguard.ab.a(r1);
        return;
    L_0x0026:
        r7 = move-exception;
        com.xunlei.download.proguard.ab.a(r1);
        throw r7;
    L_0x002b:
        com.xunlei.download.proguard.ab.a(r1);
        return;
    L_0x002f:
        r7 = move-exception;
        goto L_0x005c;
    L_0x0031:
        r7 = move-exception;
        goto L_0x003b;
    L_0x0033:
        r7 = move-exception;
        r1 = r0;
        goto L_0x004c;
    L_0x0036:
        r7 = move-exception;
        r1 = r0;
        goto L_0x0051;
    L_0x0039:
        r7 = move-exception;
        r1 = r0;
    L_0x003b:
        r2 = new com.xunlei.download.proguard.p;	 Catch:{ p -> 0x0046, all -> 0x0043 }
        r3 = 492; // 0x1ec float:6.9E-43 double:2.43E-321;	 Catch:{ p -> 0x0046, all -> 0x0043 }
        r2.<init>(r3, r7);	 Catch:{ p -> 0x0046, all -> 0x0043 }
        throw r2;	 Catch:{ p -> 0x0046, all -> 0x0043 }
    L_0x0043:
        r7 = move-exception;
        r2 = r0;
        goto L_0x0094;
    L_0x0046:
        r7 = move-exception;
        r2 = r0;
        goto L_0x005c;
    L_0x0049:
        r7 = move-exception;
        r8 = r0;
        r1 = r8;
    L_0x004c:
        r2 = r1;
        goto L_0x0094;
    L_0x004e:
        r7 = move-exception;
        r8 = r0;
        r1 = r8;
    L_0x0051:
        r2 = r1;
        goto L_0x005c;
    L_0x0053:
        r7 = move-exception;
        r8 = new com.xunlei.download.proguard.p;	 Catch:{ p -> 0x004e, all -> 0x0049 }
        r1 = 495; // 0x1ef float:6.94E-43 double:2.446E-321;	 Catch:{ p -> 0x004e, all -> 0x0049 }
        r8.<init>(r1, r7);	 Catch:{ p -> 0x004e, all -> 0x0049 }
        throw r8;	 Catch:{ p -> 0x004e, all -> 0x0049 }
    L_0x005c:
        r3 = r7.getFinalStatus();	 Catch:{ all -> 0x0093 }
        r4 = 193; // 0xc1 float:2.7E-43 double:9.54E-322;	 Catch:{ all -> 0x0093 }
        if (r3 != r4) goto L_0x0092;	 Catch:{ all -> 0x0093 }
    L_0x0064:
        r3 = 0;	 Catch:{ all -> 0x0093 }
        r6.a(r3);	 Catch:{ all -> 0x0093 }
        r3 = new android.content.ContentValues;	 Catch:{ all -> 0x0093 }
        r3.<init>();	 Catch:{ all -> 0x0093 }
        r4 = "status";	 Catch:{ all -> 0x0093 }
        r5 = r7.getFinalStatus();	 Catch:{ all -> 0x0093 }
        r5 = java.lang.Integer.valueOf(r5);	 Catch:{ all -> 0x0093 }
        r3.put(r4, r5);	 Catch:{ all -> 0x0093 }
        r4 = "errorMsg";	 Catch:{ all -> 0x0093 }
        r5 = r7.getMessage();	 Catch:{ all -> 0x0093 }
        r3.put(r4, r5);	 Catch:{ all -> 0x0093 }
        r4 = r6.d;	 Catch:{ all -> 0x0093 }
        r4 = r4.getContentResolver();	 Catch:{ all -> 0x0093 }
        r5 = r6.e;	 Catch:{ all -> 0x0093 }
        r5 = r5.j();	 Catch:{ all -> 0x0093 }
        r4.update(r5, r3, r0, r0);	 Catch:{ all -> 0x0093 }
    L_0x0092:
        throw r7;	 Catch:{ all -> 0x0093 }
    L_0x0093:
        r7 = move-exception;
    L_0x0094:
        com.xunlei.download.proguard.ab.a(r8);
        if (r1 == 0) goto L_0x009f;
    L_0x0099:
        r1.flush();	 Catch:{ IOException -> 0x00a9, all -> 0x009d }
        goto L_0x009f;	 Catch:{ IOException -> 0x00a9, all -> 0x009d }
    L_0x009d:
        r7 = move-exception;	 Catch:{ IOException -> 0x00a9, all -> 0x009d }
        goto L_0x00a5;	 Catch:{ IOException -> 0x00a9, all -> 0x009d }
    L_0x009f:
        if (r2 == 0) goto L_0x00a9;	 Catch:{ IOException -> 0x00a9, all -> 0x009d }
    L_0x00a1:
        r2.sync();	 Catch:{ IOException -> 0x00a9, all -> 0x009d }
        goto L_0x00a9;
    L_0x00a5:
        com.xunlei.download.proguard.ab.a(r1);
        throw r7;
    L_0x00a9:
        com.xunlei.download.proguard.ab.a(r1);
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.proguard.g.a(com.xunlei.download.proguard.g$a, java.net.HttpURLConnection):void");
    }

    private void a(long j) throws p {
        this.k = false;
        c c = this.e.c(j);
        StringBuilder stringBuilder = new StringBuilder("checkConnectivity() state = ");
        stringBuilder.append(c);
        a(stringBuilder.toString());
        if (c != c.OK) {
            int i = 196;
            if (c == c.UNUSABLE_DUE_TO_SIZE) {
                this.e.a(true, j);
            } else if (c == c.RECOMMENDED_UNUSABLE_DUE_TO_SIZE) {
                this.e.a(false, j);
            } else {
                i = 195;
            }
            throw new p(i, c.name());
        }
    }

    private void a(a aVar, InputStream inputStream, OutputStream outputStream) throws p {
        byte[] bArr = new byte[4096];
        while (true) {
            int a = a(aVar, bArr, inputStream);
            if (a == -1) {
                e(aVar);
                return;
            }
            aVar.d = true;
            a(aVar, bArr, a, outputStream);
            aVar.g += (long) a;
            d(aVar);
            c(aVar);
        }
    }

    private void a(a aVar, int i) {
        if (aVar.a != null && Impl.isStatusError(i) != 0) {
            new File(aVar.a).delete();
            aVar.a = 0;
        }
    }

    private void c(a aVar) throws p {
        synchronized (this.e) {
            if (this.e.k == 1) {
                throw new p(193, "download paused by owner");
            } else if (this.e.k == 10) {
                throw new p(190, "greater than max downloading num");
            } else {
                if (this.e.l != Impl.STATUS_CANCELED) {
                    if (!this.e.A) {
                    }
                }
                throw new p(Impl.STATUS_CANCELED, "download canceled");
            }
        }
        if (this.k) {
            a(aVar.f);
        }
    }

    private void d(a aVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = elapsedRealtime - aVar.n;
        if (j > 500) {
            long j2 = ((aVar.g - aVar.o) * 1000) / j;
            if (aVar.m == 0) {
                aVar.m = j2;
            } else {
                aVar.m = ((aVar.m * 3) + j2) / 4;
            }
            if (aVar.n != 0) {
                this.h.a(this.e.c, aVar.m);
            }
            aVar.n = elapsedRealtime;
            aVar.o = aVar.g;
            StringBuilder stringBuilder = new StringBuilder("speed: ");
            stringBuilder.append(aVar.m);
            stringBuilder.append(", mCurrentBytes = ");
            stringBuilder.append(aVar.g);
            a(stringBuilder.toString());
        }
        if (aVar.g - aVar.j > 4096 && elapsedRealtime - aVar.k > c.x) {
            ContentValues contentValues = new ContentValues();
            contentValues.put(Impl.COLUMN_CURRENT_BYTES, Long.valueOf(aVar.g));
            contentValues.put("download_speed", Long.valueOf(aVar.m));
            contentValues.put("origin_speed", Long.valueOf(aVar.m));
            contentValues.put("download_duration", Long.valueOf((SystemClock.elapsedRealtime() - this.o) + this.n));
            this.d.getContentResolver().update(this.e.j(), contentValues, null, null);
            aVar.j = aVar.g;
            aVar.k = elapsedRealtime;
        }
    }

    private void a(a aVar, byte[] bArr, int i, OutputStream outputStream) throws p {
        long j = (long) i;
        this.g.a(this.e.i, aVar.a, j);
        int i2 = 0;
        while (true) {
            try {
                outputStream.write(bArr, 0, i);
                break;
            } catch (IOException e) {
                if (i2 == 0) {
                    this.g.b(this.e.i, aVar.a, j);
                    i2 = 1;
                } else {
                    i = new StringBuilder("Failed to write data: ");
                    i.append(e);
                    throw new p(492, i.toString());
                }
            }
        }
    }

    private void e(a aVar) throws p {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Impl.COLUMN_CURRENT_BYTES, Long.valueOf(aVar.g));
        if (aVar.p == -1) {
            contentValues.put("total_bytes", Long.valueOf(aVar.g));
        }
        contentValues.put("download_duration", Long.valueOf((SystemClock.elapsedRealtime() - this.o) + this.n));
        this.d.getContentResolver().update(this.e.j(), contentValues, null, null);
        Object obj = (aVar.p == -1 || aVar.g == aVar.p) ? null : 1;
        if (obj == null) {
            return;
        }
        if (f(aVar) != null) {
            throw new p(Impl.STATUS_CANNOT_RESUME, "mismatched content length; unable to resume");
        }
        throw new p(Impl.STATUS_HTTP_DATA_ERROR, "closed socket before end of file");
    }

    private int a(a aVar, byte[] bArr, InputStream inputStream) throws p {
        try {
            return inputStream.read(bArr);
        } catch (byte[] bArr2) {
            if ("unexpected end of stream".equals(bArr2.getMessage()) != null) {
                return -1;
            }
            inputStream = new ContentValues();
            inputStream.put(Impl.COLUMN_CURRENT_BYTES, Long.valueOf(aVar.g));
            inputStream.put("download_duration", Long.valueOf((SystemClock.elapsedRealtime() - this.o) + this.n));
            this.d.getContentResolver().update(this.e.j(), inputStream, null, null);
            StringBuilder stringBuilder;
            if (f(aVar) != null) {
                stringBuilder = new StringBuilder("Failed reading response: ");
                stringBuilder.append(bArr2);
                stringBuilder.append("; unable to resume");
                throw new p(Impl.STATUS_CANNOT_RESUME, stringBuilder.toString(), bArr2);
            }
            stringBuilder = new StringBuilder("Failed reading response: ");
            stringBuilder.append(bArr2);
            throw new p(Impl.STATUS_HTTP_DATA_ERROR, stringBuilder.toString(), bArr2);
        }
    }

    private void b(a aVar, HttpURLConnection httpURLConnection) throws p {
        c(aVar, httpURLConnection);
        aVar.a = k.a(this.d, this.e.d, this.e.f, aVar.q, aVar.r, aVar.b, this.e.i, aVar.p, this.g, "");
        g(aVar);
        a(aVar.f);
    }

    private void g(a aVar) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(Impl._DATA, aVar.a);
        if (aVar.h != null) {
            contentValues.put("etag", aVar.h);
        }
        if (aVar.b != null) {
            contentValues.put("mimetype", aVar.b);
        }
        contentValues.put("total_bytes", Long.valueOf(aVar.f));
        this.d.getContentResolver().update(this.e.j(), contentValues, null, null);
        StringBuilder stringBuilder = new StringBuilder("get header info: fileName = ");
        stringBuilder.append(aVar.a);
        stringBuilder.append(", mMimeType = ");
        stringBuilder.append(aVar.b);
        stringBuilder.append(", mTotalBytes = ");
        stringBuilder.append(this.e.v);
        a(stringBuilder.toString());
    }

    private boolean b(int i) {
        i = this.f.a(i);
        if (i != 0) {
            if (i.isConnected()) {
                return ak.a(i.getType());
            }
        }
        return false;
    }

    private void c(a aVar, HttpURLConnection httpURLConnection) throws p {
        aVar.q = httpURLConnection.getHeaderField("Content-Disposition");
        aVar.r = httpURLConnection.getHeaderField("Content-Location");
        if (aVar.b == null) {
            aVar.b = am.a(httpURLConnection.getContentType());
        }
        aVar.h = httpURLConnection.getHeaderField(HttpRequest.HEADER_ETAG);
        String headerField = httpURLConnection.getHeaderField("Transfer-Encoding");
        if (headerField == null) {
            aVar.p = a((URLConnection) httpURLConnection, "Content-Length", -1);
        } else {
            a("Ignoring Content-Length since Transfer-Encoding is also defined");
            aVar.p = -1;
        }
        aVar.f = aVar.p;
        httpURLConnection = (aVar.p == -1 && (headerField == null || headerField.equalsIgnoreCase("chunked") == null)) ? true : null;
        if (httpURLConnection != null && this.e.e == null) {
            throw new p(Impl.STATUS_CANNOT_RESUME, "can't know size of download, giving up");
        } else if (aVar.f == -1 && b(this.e.y) != null) {
            if (this.i == null) {
                this.i = new ContentValues();
            }
            this.i.put(Impl.COLUMN_ALLOWED_NETWORK_TYPES, Integer.valueOf(this.e.D & -2));
            throw new p(196, "can't know size of download, giving up on mobile network.");
        }
    }

    private void d(a aVar, HttpURLConnection httpURLConnection) {
        aVar.c = httpURLConnection.getHeaderFieldInt("Retry-After", -1);
        if (aVar.c < null) {
            aVar.c = null;
            return;
        }
        if (aVar.c < 30) {
            aVar.c = 30;
        } else if (aVar.c > 86400) {
            aVar.c = 86400;
        }
        aVar.c += k.a.nextInt(31);
        aVar.c *= 1000;
    }

    private void h(a aVar) throws p {
        if (!TextUtils.isEmpty(aVar.a)) {
            StringBuilder stringBuilder = new StringBuilder("have run thread before for id: ");
            stringBuilder.append(this.e.c);
            stringBuilder.append(", and state.mFilename: ");
            stringBuilder.append(aVar.a);
            a(stringBuilder.toString());
            if (k.a(aVar.a, this.g.b())) {
                File file = new File(aVar.a);
                if (file.exists()) {
                    StringBuilder stringBuilder2 = new StringBuilder("resuming download for id: ");
                    stringBuilder2.append(this.e.c);
                    stringBuilder2.append(", and state.mFilename: ");
                    stringBuilder2.append(aVar.a);
                    a(stringBuilder2.toString());
                    long length = file.length();
                    if (length == 0) {
                        file.delete();
                        aVar.a = null;
                        aVar = new StringBuilder("resuming download for id: ");
                        aVar.append(this.e.c);
                        aVar.append(", BUT starting from scratch again: ");
                        a(aVar.toString());
                        return;
                    }
                    stringBuilder = new StringBuilder("resuming download for id: ");
                    stringBuilder.append(this.e.c);
                    stringBuilder.append(", and starting with file of length: ");
                    stringBuilder.append(length);
                    a(stringBuilder.toString());
                    aVar.g = (long) ((int) length);
                    if (this.e.v != -1) {
                        aVar.p = this.e.v;
                    }
                    aVar.h = this.e.x;
                    aVar.i = true;
                    stringBuilder = new StringBuilder("resuming download for id: ");
                    stringBuilder.append(this.e.c);
                    stringBuilder.append(", state.mCurrentBytes: ");
                    stringBuilder.append(aVar.g);
                    stringBuilder.append(", and setting mContinuingDownload to true: ");
                    a(stringBuilder.toString());
                    return;
                }
                this.e.w = 0;
                aVar.g = 0;
            } else {
                throw new p(Impl.STATUS_FILE_ERROR, "found invalid internal destination filename");
            }
        }
    }

    private void e(a aVar, HttpURLConnection httpURLConnection) {
        for (Pair pair : this.e.b()) {
            httpURLConnection.addRequestProperty((String) pair.first, (String) pair.second);
        }
        if (httpURLConnection.getRequestProperty(HttpRequest.HEADER_USER_AGENT) == null) {
            httpURLConnection.addRequestProperty(HttpRequest.HEADER_USER_AGENT, b());
        }
        httpURLConnection.setRequestProperty("Accept-Encoding", "identity");
        if (aVar.i) {
            if (aVar.h != null) {
                httpURLConnection.addRequestProperty("If-Match", aVar.h);
            }
            StringBuilder stringBuilder = new StringBuilder("bytes=");
            stringBuilder.append(aVar.g);
            stringBuilder.append("-");
            httpURLConnection.addRequestProperty("Range", stringBuilder.toString());
        }
    }

    private void a(a aVar, int i, String str, int i2) {
        b(aVar, i, str, i2);
        if (Impl.isStatusCompleted(i) != null) {
            this.e.c();
        }
        this.e.a(i);
    }

    private void b(a aVar, int i, String str, int i2) {
        ContentValues contentValues;
        if (this.i != null) {
            contentValues = new ContentValues(this.i);
        } else {
            contentValues = new ContentValues();
        }
        if (i != 192) {
            contentValues.put("status", Integer.valueOf(i));
        }
        if (TextUtils.isEmpty(aVar.a) == 0) {
            contentValues.put(Impl._DATA, aVar.a);
        }
        contentValues.put("mimetype", aVar.b);
        contentValues.put(Impl.COLUMN_LAST_MODIFICATION, Long.valueOf(this.f.a()));
        contentValues.put(Impl.COLUMN_FAILED_CONNECTIONS, Integer.valueOf(i2));
        contentValues.put("method", Integer.valueOf(aVar.c));
        contentValues.put("download_speed", Integer.valueOf(0));
        if (TextUtils.equals(this.e.d, aVar.e) == 0) {
            contentValues.put("uri", aVar.e);
        }
        if (str == null) {
            str = "";
        }
        contentValues.put("errorMsg", str);
        this.d.getContentResolver().update(this.e.j(), contentValues, null, null);
    }

    public static long a(java.net.URLConnection r0, java.lang.String r1, long r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r0.getHeaderField(r1);	 Catch:{ NumberFormatException -> 0x0009 }
        r0 = java.lang.Long.parseLong(r0);	 Catch:{ NumberFormatException -> 0x0009 }
        return r0;
    L_0x0009:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.proguard.g.a(java.net.URLConnection, java.lang.String, long):long");
    }

    private void a(String str) {
        StringBuilder stringBuilder = new StringBuilder("[");
        stringBuilder.append(this.e.c);
        stringBuilder.append("] ");
        stringBuilder.append(str);
        an.b("DownloadManager", stringBuilder.toString());
    }
}
