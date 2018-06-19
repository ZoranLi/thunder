package com.xunlei.downloadprovider.download.util.a.a;

import com.bumptech.glide.Priority;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: ApkIconDataFetcher */
final class a implements DataFetcher<InputStream> {
    private static Object e = new Object();
    private String a;
    private File b;
    private InputStream c;
    private boolean d = false;

    public final /* synthetic */ Object loadData(Priority priority) throws Exception {
        return a();
    }

    a(String str) {
        this.a = str;
        this.b = c.a();
    }

    private java.io.InputStream a() throws java.lang.Exception {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r6 = this;
        r0 = r6.a;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x000b;
    L_0x0008:
        r0 = r6.c;
        return r0;
    L_0x000b:
        r0 = r6.a;
        r0 = r0.getBytes();
        r0 = com.xunlei.xllib.b.g.a(r0);
        r1 = new java.io.File;
        r2 = r6.b;
        r3 = new java.lang.StringBuilder;
        r3.<init>();
        r3.append(r0);
        r0 = ".png";
        r3.append(r0);
        r0 = r3.toString();
        r1.<init>(r2, r0);
        r0 = r1.exists();
        if (r0 == 0) goto L_0x003d;
    L_0x0033:
        r0 = new java.io.FileInputStream;
        r0.<init>(r1);
        r6.c = r0;
        r0 = r6.c;
        return r0;
    L_0x003d:
        r0 = com.xunlei.downloadprovider.app.BrothersApplication.getApplicationInstance();
        r2 = r6.a;
        r0 = com.xunlei.common.androidutil.ApkHelper.getApkInfo(r0, r2);
        if (r0 == 0) goto L_0x00a6;
    L_0x0049:
        r0 = r0.getApkIcon();
        r2 = r6.b;	 Catch:{ Exception -> 0x00a6 }
        r2 = r2.exists();	 Catch:{ Exception -> 0x00a6 }
        if (r2 != 0) goto L_0x005a;	 Catch:{ Exception -> 0x00a6 }
    L_0x0055:
        r2 = r6.b;	 Catch:{ Exception -> 0x00a6 }
        r2.mkdirs();	 Catch:{ Exception -> 0x00a6 }
    L_0x005a:
        r2 = r1.getPath();	 Catch:{ Exception -> 0x00a6 }
        r0 = com.xunlei.common.androidutil.BitmapUtil.createBitmapWithDrawable(r0);	 Catch:{ Exception -> 0x00a6 }
        r3 = new java.io.File;	 Catch:{ Exception -> 0x00a6 }
        r4 = 0;	 Catch:{ Exception -> 0x00a6 }
        r5 = 47;	 Catch:{ Exception -> 0x00a6 }
        r5 = r2.lastIndexOf(r5);	 Catch:{ Exception -> 0x00a6 }
        r4 = r2.substring(r4, r5);	 Catch:{ Exception -> 0x00a6 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x00a6 }
        r4 = r3.exists();	 Catch:{ Exception -> 0x00a6 }
        if (r4 != 0) goto L_0x007b;	 Catch:{ Exception -> 0x00a6 }
    L_0x0078:
        r3.mkdirs();	 Catch:{ Exception -> 0x00a6 }
    L_0x007b:
        r3 = new java.io.File;	 Catch:{ Exception -> 0x00a6 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00a6 }
        r4.<init>();	 Catch:{ Exception -> 0x00a6 }
        r4.append(r2);	 Catch:{ Exception -> 0x00a6 }
        r5 = ".utmp";	 Catch:{ Exception -> 0x00a6 }
        r4.append(r5);	 Catch:{ Exception -> 0x00a6 }
        r4 = r4.toString();	 Catch:{ Exception -> 0x00a6 }
        r3.<init>(r4);	 Catch:{ Exception -> 0x00a6 }
        r4 = android.graphics.Bitmap.CompressFormat.PNG;	 Catch:{ Exception -> 0x00a6 }
        com.xunlei.common.androidutil.BitmapUtil.saveBitmapToFile(r3, r0, r4);	 Catch:{ Exception -> 0x00a6 }
        r0 = new java.io.File;	 Catch:{ Exception -> 0x00a6 }
        r0.<init>(r2);	 Catch:{ Exception -> 0x00a6 }
        r2 = e;	 Catch:{ Exception -> 0x00a6 }
        monitor-enter(r2);	 Catch:{ Exception -> 0x00a6 }
        r3.renameTo(r0);	 Catch:{ all -> 0x00a3 }
        monitor-exit(r2);	 Catch:{ all -> 0x00a3 }
        goto L_0x00a6;	 Catch:{ all -> 0x00a3 }
    L_0x00a3:
        r0 = move-exception;	 Catch:{ all -> 0x00a3 }
        monitor-exit(r2);	 Catch:{ all -> 0x00a3 }
        throw r0;	 Catch:{ Exception -> 0x00a6 }
    L_0x00a6:
        r0 = r1.exists();
        if (r0 == 0) goto L_0x00b7;
    L_0x00ac:
        r0 = r6.d;
        if (r0 != 0) goto L_0x00b7;
    L_0x00b0:
        r0 = new java.io.FileInputStream;
        r0.<init>(r1);
        r6.c = r0;
    L_0x00b7:
        r0 = r6.c;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadprovider.download.util.a.a.a.a():java.io.InputStream");
    }

    public final void cleanup() {
        if (this.c != null) {
            try {
                this.c.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public final String getId() {
        return this.a;
    }

    public final void cancel() {
        this.d = true;
    }
}
