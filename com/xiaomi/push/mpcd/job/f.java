package com.xiaomi.push.mpcd.job;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.misc.h.a;
import com.xiaomi.push.mpcd.b;
import com.xiaomi.push.mpcd.c;
import com.xiaomi.xmpush.thrift.d;
import com.xiaomi.xmpush.thrift.k;

public abstract class f extends a {
    protected int c;
    protected Context d;

    public f(Context context, int i) {
        this.c = i;
        this.d = context;
    }

    public static void a(Context context, k kVar) {
        b b = c.a().b();
        Object a = b == null ? "" : b.a();
        if (!TextUtils.isEmpty(a) && !TextUtils.isEmpty(kVar.c())) {
            a(context, kVar, a);
        }
    }

    private static void a(android.content.Context r6, com.xiaomi.xmpush.thrift.k r7, java.lang.String r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r7 = com.xiaomi.xmpush.thrift.au.a(r7);
        r7 = com.xiaomi.push.mpcd.e.b(r8, r7);
        if (r7 == 0) goto L_0x00aa;
    L_0x000a:
        r8 = r7.length;
        if (r8 != 0) goto L_0x000e;
    L_0x000d:
        return;
    L_0x000e:
        r8 = com.xiaomi.push.mpcd.f.a;
        monitor-enter(r8);
        r0 = 0;
        r1 = new java.io.File;	 Catch:{ IOException -> 0x0079, all -> 0x0075 }
        r2 = r6.getExternalFilesDir(r0);	 Catch:{ IOException -> 0x0079, all -> 0x0075 }
        r3 = "push_cdata.lock";	 Catch:{ IOException -> 0x0079, all -> 0x0075 }
        r1.<init>(r2, r3);	 Catch:{ IOException -> 0x0079, all -> 0x0075 }
        com.xiaomi.channel.commonutils.file.a.a(r1);	 Catch:{ IOException -> 0x0079, all -> 0x0075 }
        r2 = new java.io.RandomAccessFile;	 Catch:{ IOException -> 0x0079, all -> 0x0075 }
        r3 = "rw";	 Catch:{ IOException -> 0x0079, all -> 0x0075 }
        r2.<init>(r1, r3);	 Catch:{ IOException -> 0x0079, all -> 0x0075 }
        r1 = r2.getChannel();	 Catch:{ IOException -> 0x0072, all -> 0x006f }
        r1 = r1.lock();	 Catch:{ IOException -> 0x0072, all -> 0x006f }
        r3 = new java.io.File;	 Catch:{ IOException -> 0x006b, all -> 0x0069 }
        r6 = r6.getExternalFilesDir(r0);	 Catch:{ IOException -> 0x006b, all -> 0x0069 }
        r4 = "push_cdata.data";	 Catch:{ IOException -> 0x006b, all -> 0x0069 }
        r3.<init>(r6, r4);	 Catch:{ IOException -> 0x006b, all -> 0x0069 }
        r6 = new java.io.BufferedOutputStream;	 Catch:{ IOException -> 0x006b, all -> 0x0069 }
        r4 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x006b, all -> 0x0069 }
        r5 = 1;	 Catch:{ IOException -> 0x006b, all -> 0x0069 }
        r4.<init>(r3, r5);	 Catch:{ IOException -> 0x006b, all -> 0x0069 }
        r6.<init>(r4);	 Catch:{ IOException -> 0x006b, all -> 0x0069 }
        r0 = r7.length;	 Catch:{ IOException -> 0x0067, all -> 0x0065 }
        r0 = com.xiaomi.channel.commonutils.misc.b.a(r0);	 Catch:{ IOException -> 0x0067, all -> 0x0065 }
        r6.write(r0);	 Catch:{ IOException -> 0x0067, all -> 0x0065 }
        r6.write(r7);	 Catch:{ IOException -> 0x0067, all -> 0x0065 }
        r6.flush();	 Catch:{ IOException -> 0x0067, all -> 0x0065 }
        if (r1 == 0) goto L_0x005e;
    L_0x0055:
        r7 = r1.isValid();	 Catch:{ all -> 0x009f }
        if (r7 == 0) goto L_0x005e;
    L_0x005b:
        r1.release();	 Catch:{ IOException -> 0x005e }
    L_0x005e:
        com.xiaomi.channel.commonutils.file.a.a(r6);	 Catch:{ all -> 0x009f }
    L_0x0061:
        com.xiaomi.channel.commonutils.file.a.a(r2);	 Catch:{ all -> 0x009f }
        goto L_0x008e;
    L_0x0065:
        r7 = move-exception;
        goto L_0x0092;
    L_0x0067:
        r7 = move-exception;
        goto L_0x006d;
    L_0x0069:
        r7 = move-exception;
        goto L_0x0093;
    L_0x006b:
        r7 = move-exception;
        r6 = r0;
    L_0x006d:
        r0 = r1;
        goto L_0x007c;
    L_0x006f:
        r7 = move-exception;
        r1 = r0;
        goto L_0x0093;
    L_0x0072:
        r7 = move-exception;
        r6 = r0;
        goto L_0x007c;
    L_0x0075:
        r7 = move-exception;
        r1 = r0;
        r2 = r1;
        goto L_0x0093;
    L_0x0079:
        r7 = move-exception;
        r6 = r0;
        r2 = r6;
    L_0x007c:
        r7.printStackTrace();	 Catch:{ all -> 0x0090 }
        if (r0 == 0) goto L_0x008a;
    L_0x0081:
        r7 = r0.isValid();	 Catch:{ all -> 0x009f }
        if (r7 == 0) goto L_0x008a;
    L_0x0087:
        r0.release();	 Catch:{ IOException -> 0x008a }
    L_0x008a:
        com.xiaomi.channel.commonutils.file.a.a(r6);	 Catch:{ all -> 0x009f }
        goto L_0x0061;	 Catch:{ all -> 0x009f }
    L_0x008e:
        monitor-exit(r8);	 Catch:{ all -> 0x009f }
        return;	 Catch:{ all -> 0x009f }
    L_0x0090:
        r7 = move-exception;	 Catch:{ all -> 0x009f }
        r1 = r0;	 Catch:{ all -> 0x009f }
    L_0x0092:
        r0 = r6;	 Catch:{ all -> 0x009f }
    L_0x0093:
        if (r1 == 0) goto L_0x00a1;	 Catch:{ all -> 0x009f }
    L_0x0095:
        r6 = r1.isValid();	 Catch:{ all -> 0x009f }
        if (r6 == 0) goto L_0x00a1;
    L_0x009b:
        r1.release();	 Catch:{ IOException -> 0x00a1 }
        goto L_0x00a1;
    L_0x009f:
        r6 = move-exception;
        goto L_0x00a8;
    L_0x00a1:
        com.xiaomi.channel.commonutils.file.a.a(r0);	 Catch:{ all -> 0x009f }
        com.xiaomi.channel.commonutils.file.a.a(r2);	 Catch:{ all -> 0x009f }
        throw r7;	 Catch:{ all -> 0x009f }
    L_0x00a8:
        monitor-exit(r8);	 Catch:{ all -> 0x009f }
        throw r6;
    L_0x00aa:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.mpcd.job.f.a(android.content.Context, com.xiaomi.xmpush.thrift.k, java.lang.String):void");
    }

    public abstract String b();

    protected boolean c() {
        return true;
    }

    public abstract d d();

    protected boolean e() {
        return com.xiaomi.channel.commonutils.misc.f.a(this.d, String.valueOf(a()), (long) this.c);
    }

    public void run() {
        if (e()) {
            b b = c.a().b();
            Object a = b == null ? "" : b.a();
            if (!TextUtils.isEmpty(a) && c()) {
                String b2 = b();
                if (!TextUtils.isEmpty(b2)) {
                    k kVar = new k();
                    kVar.a(b2);
                    kVar.a(System.currentTimeMillis());
                    kVar.a(d());
                    a(this.d, kVar, a);
                }
            }
        }
    }
}
