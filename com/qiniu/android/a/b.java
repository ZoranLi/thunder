package com.qiniu.android.a;

import com.qiniu.android.c.s;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import okhttp3.ac;

/* compiled from: UploadInfoCollector */
public final class b {
    private static ExecutorService a;
    private static ac b;
    private static b c;
    private final String d;
    private final String e;
    private File f = null;
    private long g;

    /* compiled from: UploadInfoCollector */
    public static abstract class a {
        public abstract String a();
    }

    private b(String str, String str2) {
        this.e = str;
        this.d = str2;
        try {
            if (a.a != null) {
                str2 = new File(a.c);
                StringBuilder stringBuilder;
                if (str2.exists() == null) {
                    if (str2.mkdirs() == null) {
                        stringBuilder = new StringBuilder("mkdir failed: ");
                        stringBuilder.append(str2.getAbsolutePath());
                        throw new IOException(stringBuilder.toString());
                    }
                } else if (str2.isDirectory() == null) {
                    stringBuilder = new StringBuilder();
                    stringBuilder.append(str2.getAbsolutePath());
                    stringBuilder.append(" is not a dir");
                    throw new IOException(stringBuilder.toString());
                } else {
                    this.f = new File(str2, this.e);
                }
            }
            if (a.a == null && a != null) {
                a.shutdown();
            }
            if (a.a != null && (a == null || a.isShutdown() != null)) {
                a = Executors.newSingleThreadExecutor();
            }
        } catch (String str3) {
            str3.printStackTrace();
        }
    }

    public static void a(com.qiniu.android.c.s r3, com.qiniu.android.a.b.a r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.qiniu.android.a.a.a;	 Catch:{ Throwable -> 0x003e }
        if (r0 == 0) goto L_0x003d;	 Catch:{ Throwable -> 0x003e }
    L_0x0004:
        r0 = c;	 Catch:{ Throwable -> 0x003e }
        if (r0 != 0) goto L_0x0013;	 Catch:{ Throwable -> 0x003e }
    L_0x0008:
        r0 = new com.qiniu.android.a.b;	 Catch:{ Throwable -> 0x003e }
        r1 = "_qiniu_record_file_hs5z9lo7anx03";	 Catch:{ Throwable -> 0x003e }
        r2 = "https://uplog.qbox.me/log/3";	 Catch:{ Throwable -> 0x003e }
        r0.<init>(r1, r2);	 Catch:{ Throwable -> 0x003e }
        c = r0;	 Catch:{ Throwable -> 0x003e }
    L_0x0013:
        r0 = c;	 Catch:{ Throwable -> 0x003e }
        r1 = a;	 Catch:{ Throwable -> 0x003e }
        if (r1 == 0) goto L_0x003d;	 Catch:{ Throwable -> 0x003e }
    L_0x0019:
        r1 = a;	 Catch:{ Throwable -> 0x003e }
        r1 = r1.isShutdown();	 Catch:{ Throwable -> 0x003e }
        if (r1 != 0) goto L_0x003d;	 Catch:{ Throwable -> 0x003e }
    L_0x0021:
        r1 = new com.qiniu.android.a.c;	 Catch:{ Throwable -> 0x003e }
        r1.<init>(r0, r4);	 Catch:{ Throwable -> 0x003e }
        r4 = a;	 Catch:{ Throwable -> 0x003e }
        r4.submit(r1);	 Catch:{ Throwable -> 0x003e }
        r4 = com.qiniu.android.a.a.b;	 Catch:{ Throwable -> 0x003e }
        if (r4 == 0) goto L_0x003d;	 Catch:{ Throwable -> 0x003e }
    L_0x002f:
        r4 = com.qiniu.android.c.s.a;	 Catch:{ Throwable -> 0x003e }
        if (r3 == r4) goto L_0x003d;	 Catch:{ Throwable -> 0x003e }
    L_0x0033:
        r4 = new com.qiniu.android.a.d;	 Catch:{ Throwable -> 0x003e }
        r4.<init>(r0, r3);	 Catch:{ Throwable -> 0x003e }
        r3 = a;	 Catch:{ Throwable -> 0x003e }
        r3.submit(r4);	 Catch:{ Throwable -> 0x003e }
    L_0x003d:
        return;
    L_0x003e:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.a.b.a(com.qiniu.android.c.s, com.qiniu.android.a.b$a):void");
    }

    public static void b(s sVar, a aVar) {
        a(sVar, aVar);
    }

    private static void a(java.io.File r2, java.lang.String r3, boolean r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = new java.io.FileOutputStream;	 Catch:{ FileNotFoundException -> 0x002f, IOException -> 0x0025 }
        r1.<init>(r2, r4);	 Catch:{ FileNotFoundException -> 0x002f, IOException -> 0x0025 }
        r2 = "UTF-8";	 Catch:{ FileNotFoundException -> 0x001f, IOException -> 0x001c, all -> 0x001a }
        r2 = java.nio.charset.Charset.forName(r2);	 Catch:{ FileNotFoundException -> 0x001f, IOException -> 0x001c, all -> 0x001a }
        r2 = r3.getBytes(r2);	 Catch:{ FileNotFoundException -> 0x001f, IOException -> 0x001c, all -> 0x001a }
        r1.write(r2);	 Catch:{ FileNotFoundException -> 0x001f, IOException -> 0x001c, all -> 0x001a }
        r1.flush();	 Catch:{ FileNotFoundException -> 0x001f, IOException -> 0x001c, all -> 0x001a }
        r1.close();	 Catch:{ IOException -> 0x0019 }
    L_0x0019:
        return;
    L_0x001a:
        r2 = move-exception;
        goto L_0x003a;
    L_0x001c:
        r2 = move-exception;
        r0 = r1;
        goto L_0x0026;
    L_0x001f:
        r2 = move-exception;
        r0 = r1;
        goto L_0x0030;
    L_0x0022:
        r2 = move-exception;
        r1 = r0;
        goto L_0x003a;
    L_0x0025:
        r2 = move-exception;
    L_0x0026:
        r2.printStackTrace();	 Catch:{ all -> 0x0022 }
        if (r0 == 0) goto L_0x0039;
    L_0x002b:
        r0.close();	 Catch:{ IOException -> 0x002e }
    L_0x002e:
        return;
    L_0x002f:
        r2 = move-exception;
    L_0x0030:
        r2.printStackTrace();	 Catch:{ all -> 0x0022 }
        if (r0 == 0) goto L_0x0039;
    L_0x0035:
        r0.close();	 Catch:{ IOException -> 0x0038 }
    L_0x0038:
        return;
    L_0x0039:
        return;
    L_0x003a:
        if (r1 == 0) goto L_0x003f;
    L_0x003c:
        r1.close();	 Catch:{ IOException -> 0x003f }
    L_0x003f:
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.a.b.a(java.io.File, java.lang.String, boolean):void");
    }

    private boolean a(com.qiniu.android.c.s r8, java.io.File r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = this;
        r0 = 0;
        r1 = b;	 Catch:{ Exception -> 0x00a5 }
        r2 = 1;	 Catch:{ Exception -> 0x00a5 }
        if (r1 != 0) goto L_0x002e;	 Catch:{ Exception -> 0x00a5 }
    L_0x0006:
        r1 = new okhttp3.ac$a;	 Catch:{ Exception -> 0x00a5 }
        r1.<init>();	 Catch:{ Exception -> 0x00a5 }
        r3 = 10;	 Catch:{ Exception -> 0x00a5 }
        r5 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ Exception -> 0x00a5 }
        r1.a(r3, r5);	 Catch:{ Exception -> 0x00a5 }
        r3 = 15;	 Catch:{ Exception -> 0x00a5 }
        r5 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ Exception -> 0x00a5 }
        r1.b(r3, r5);	 Catch:{ Exception -> 0x00a5 }
        r3 = com.qiniu.android.a.a.f;	 Catch:{ Exception -> 0x00a5 }
        r3 = r3 / 2;	 Catch:{ Exception -> 0x00a5 }
        r3 = r3 + r2;	 Catch:{ Exception -> 0x00a5 }
        r3 = r3 * 60;	 Catch:{ Exception -> 0x00a5 }
        r3 = r3 + -10;	 Catch:{ Exception -> 0x00a5 }
        r3 = (long) r3;	 Catch:{ Exception -> 0x00a5 }
        r5 = java.util.concurrent.TimeUnit.SECONDS;	 Catch:{ Exception -> 0x00a5 }
        r1.c(r3, r5);	 Catch:{ Exception -> 0x00a5 }
        r1 = r1.a();	 Catch:{ Exception -> 0x00a5 }
        b = r1;	 Catch:{ Exception -> 0x00a5 }
    L_0x002e:
        r1 = b;	 Catch:{ Exception -> 0x00a5 }
        r3 = "text/plain";	 Catch:{ Exception -> 0x00a5 }
        r3 = okhttp3.aa.a(r3);	 Catch:{ Exception -> 0x00a5 }
        r9 = okhttp3.ag.a(r3, r9);	 Catch:{ Exception -> 0x00a5 }
        r3 = new okhttp3.af$a;	 Catch:{ Exception -> 0x00a5 }
        r3.<init>();	 Catch:{ Exception -> 0x00a5 }
        r4 = r7.d;	 Catch:{ Exception -> 0x00a5 }
        r3 = r3.a(r4);	 Catch:{ Exception -> 0x00a5 }
        r4 = "Authorization";	 Catch:{ Exception -> 0x00a5 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00a5 }
        r6 = "UpToken ";	 Catch:{ Exception -> 0x00a5 }
        r5.<init>(r6);	 Catch:{ Exception -> 0x00a5 }
        r6 = r8.b;	 Catch:{ Exception -> 0x00a5 }
        r5.append(r6);	 Catch:{ Exception -> 0x00a5 }
        r5 = r5.toString();	 Catch:{ Exception -> 0x00a5 }
        r3 = r3.b(r4, r5);	 Catch:{ Exception -> 0x00a5 }
        r4 = "User-Agent";	 Catch:{ Exception -> 0x00a5 }
        r5 = com.qiniu.android.http.r.a();	 Catch:{ Exception -> 0x00a5 }
        r8 = r8.c;	 Catch:{ Exception -> 0x00a5 }
        r8 = r5.a(r8);	 Catch:{ Exception -> 0x00a5 }
        r8 = r3.b(r4, r8);	 Catch:{ Exception -> 0x00a5 }
        r3 = "POST";	 Catch:{ Exception -> 0x00a5 }
        r8 = r8.a(r3, r9);	 Catch:{ Exception -> 0x00a5 }
        r8 = r8.a();	 Catch:{ Exception -> 0x00a5 }
        r8 = r1.a(r8);	 Catch:{ Exception -> 0x00a5 }
        r8 = r8.b();	 Catch:{ Exception -> 0x00a5 }
        r9 = r8.c;	 Catch:{ all -> 0x009e }
        r1 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;	 Catch:{ all -> 0x009e }
        if (r9 < r1) goto L_0x008b;	 Catch:{ all -> 0x009e }
    L_0x0083:
        r9 = r8.c;	 Catch:{ all -> 0x009e }
        r1 = 300; // 0x12c float:4.2E-43 double:1.48E-321;	 Catch:{ all -> 0x009e }
        if (r9 >= r1) goto L_0x008b;	 Catch:{ all -> 0x009e }
    L_0x0089:
        r9 = r2;	 Catch:{ all -> 0x009e }
        goto L_0x008c;	 Catch:{ all -> 0x009e }
    L_0x008b:
        r9 = r0;	 Catch:{ all -> 0x009e }
    L_0x008c:
        if (r9 == 0) goto L_0x0098;	 Catch:{ all -> 0x009e }
    L_0x008e:
        r9 = "X-Reqid";	 Catch:{ all -> 0x009e }
        r1 = 0;	 Catch:{ all -> 0x009e }
        r9 = r8.a(r9, r1);	 Catch:{ all -> 0x009e }
        if (r9 == 0) goto L_0x0098;
    L_0x0097:
        r0 = r2;
    L_0x0098:
        r8 = r8.g;	 Catch:{ Exception -> 0x009d }
        r8.close();	 Catch:{ Exception -> 0x009d }
    L_0x009d:
        return r0;
    L_0x009e:
        r9 = move-exception;
        r8 = r8.g;	 Catch:{ Exception -> 0x00a4 }
        r8.close();	 Catch:{ Exception -> 0x00a4 }
    L_0x00a4:
        throw r9;	 Catch:{ Exception -> 0x00a5 }
    L_0x00a5:
        r8 = move-exception;
        r8.printStackTrace();
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qiniu.android.a.b.a(com.qiniu.android.c.s, java.io.File):boolean");
    }

    static /* synthetic */ void a(String str, File file) {
        if (a.a && file.length() < ((long) a.d)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("\n");
            a(file, stringBuilder.toString(), true);
        }
    }

    static /* synthetic */ void a(b bVar, s sVar, File file) {
        if (a.b && file.length() > ((long) a.e)) {
            long time = new Date().getTime();
            if (time > bVar.g + ((long) ((a.f * 60) * 1000))) {
                bVar.g = time;
                if (bVar.a(sVar, file) != null) {
                    a(file, "", false);
                    a(file, "", false);
                }
            }
        }
    }
}
