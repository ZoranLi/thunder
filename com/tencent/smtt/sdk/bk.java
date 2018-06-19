package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.utils.k;
import java.io.FileOutputStream;
import java.nio.channels.FileLock;

class bk {
    private static bk a;
    private static FileLock e;
    private bl b;
    private boolean c;
    private boolean d;

    private bk() {
    }

    public static bk b() {
        if (a == null) {
            synchronized (bk.class) {
                if (a == null) {
                    a = new bk();
                }
            }
        }
        return a;
    }

    public bl a(boolean z) {
        return z ? this.b : d();
    }

    public FileLock a() {
        return e;
    }

    public synchronized void a(android.content.Context r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r9 = this;
        monitor-enter(r9);
        r0 = 1;
        r1 = com.tencent.smtt.sdk.l.a(r0);	 Catch:{ all -> 0x0178 }
        r2 = 0;	 Catch:{ all -> 0x0178 }
        r1.a(r10, r2, r2);	 Catch:{ all -> 0x0178 }
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0178 }
        r3.<init>();	 Catch:{ all -> 0x0178 }
        r4 = r1.a();	 Catch:{ all -> 0x0178 }
        r5 = r1.b();	 Catch:{ all -> 0x0178 }
        r6 = 0;	 Catch:{ all -> 0x0178 }
        if (r5 == 0) goto L_0x006c;	 Catch:{ all -> 0x0178 }
    L_0x001a:
        if (r4 == 0) goto L_0x006c;	 Catch:{ all -> 0x0178 }
    L_0x001c:
        r5 = r9.d;	 Catch:{ all -> 0x0178 }
        if (r5 != 0) goto L_0x0073;	 Catch:{ all -> 0x0178 }
    L_0x0020:
        r5 = new com.tencent.smtt.sdk.bl;	 Catch:{ all -> 0x0178 }
        r7 = r4.b();	 Catch:{ all -> 0x0178 }
        r5.<init>(r7);	 Catch:{ all -> 0x0178 }
        r9.b = r5;	 Catch:{ all -> 0x0178 }
        r5 = r9.b;	 Catch:{ NoSuchMethodException -> 0x0056, Throwable -> 0x003d }
        r5 = r5.a();	 Catch:{ NoSuchMethodException -> 0x0056, Throwable -> 0x003d }
        r9.c = r5;	 Catch:{ NoSuchMethodException -> 0x0056, Throwable -> 0x003d }
        r5 = r9.c;	 Catch:{ NoSuchMethodException -> 0x0056, Throwable -> 0x003d }
        if (r5 != 0) goto L_0x0058;	 Catch:{ NoSuchMethodException -> 0x0056, Throwable -> 0x003d }
    L_0x0037:
        r5 = "can not use X5 by x5corewizard return false";	 Catch:{ NoSuchMethodException -> 0x0056, Throwable -> 0x003d }
        r3.append(r5);	 Catch:{ NoSuchMethodException -> 0x0056, Throwable -> 0x003d }
        goto L_0x0058;
    L_0x003d:
        r5 = move-exception;
        r9.c = r2;	 Catch:{ all -> 0x0178 }
        r7 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0178 }
        r8 = "can not use x5 by throwable ";	 Catch:{ all -> 0x0178 }
        r7.<init>(r8);	 Catch:{ all -> 0x0178 }
        r8 = android.util.Log.getStackTraceString(r5);	 Catch:{ all -> 0x0178 }
        r7.append(r8);	 Catch:{ all -> 0x0178 }
        r7 = r7.toString();	 Catch:{ all -> 0x0178 }
        r3.append(r7);	 Catch:{ all -> 0x0178 }
        goto L_0x0059;	 Catch:{ all -> 0x0178 }
    L_0x0056:
        r9.c = r0;	 Catch:{ all -> 0x0178 }
    L_0x0058:
        r5 = r6;	 Catch:{ all -> 0x0178 }
    L_0x0059:
        r7 = r9.c;	 Catch:{ all -> 0x0178 }
        if (r7 == 0) goto L_0x0074;	 Catch:{ all -> 0x0178 }
    L_0x005d:
        r7 = com.tencent.smtt.sdk.CookieManager.getInstance();	 Catch:{ all -> 0x0178 }
        r7.a(r10, r0, r0);	 Catch:{ all -> 0x0178 }
        r7 = com.tencent.smtt.sdk.CookieManager.getInstance();	 Catch:{ all -> 0x0178 }
        r7.a();	 Catch:{ all -> 0x0178 }
        goto L_0x0074;	 Catch:{ all -> 0x0178 }
    L_0x006c:
        r9.c = r2;	 Catch:{ all -> 0x0178 }
        r5 = "can not use X5 by !tbs available";	 Catch:{ all -> 0x0178 }
        r3.append(r5);	 Catch:{ all -> 0x0178 }
    L_0x0073:
        r5 = r6;	 Catch:{ all -> 0x0178 }
    L_0x0074:
        r7 = r9.c;	 Catch:{ all -> 0x0178 }
        if (r7 != 0) goto L_0x016d;	 Catch:{ all -> 0x0178 }
    L_0x0078:
        r7 = "X5CoreEngine";	 Catch:{ all -> 0x0178 }
        r8 = "mCanUseX5 is false --> report";	 Catch:{ all -> 0x0178 }
        com.tencent.smtt.utils.TbsLog.e(r7, r8);	 Catch:{ all -> 0x0178 }
        r7 = r1.b();	 Catch:{ all -> 0x0178 }
        if (r7 == 0) goto L_0x0130;
    L_0x0085:
        if (r4 == 0) goto L_0x0130;
    L_0x0087:
        if (r5 != 0) goto L_0x0130;
    L_0x0089:
        r1 = r4.b();	 Catch:{ Throwable -> 0x00e1 }
        if (r1 == 0) goto L_0x009b;	 Catch:{ Throwable -> 0x00e1 }
    L_0x008f:
        r4 = "com.tencent.tbs.tbsshell.TBSShell";	 Catch:{ Throwable -> 0x00e1 }
        r5 = "getLoadFailureDetails";	 Catch:{ Throwable -> 0x00e1 }
        r6 = new java.lang.Class[r2];	 Catch:{ Throwable -> 0x00e1 }
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x00e1 }
        r6 = r1.invokeStaticMethod(r4, r5, r6, r2);	 Catch:{ Throwable -> 0x00e1 }
    L_0x009b:
        r1 = r6 instanceof java.lang.Throwable;	 Catch:{ Throwable -> 0x00e1 }
        if (r1 == 0) goto L_0x00cb;	 Catch:{ Throwable -> 0x00e1 }
    L_0x009f:
        r1 = r6;	 Catch:{ Throwable -> 0x00e1 }
        r1 = (java.lang.Throwable) r1;	 Catch:{ Throwable -> 0x00e1 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00e1 }
        r4 = "#";	 Catch:{ Throwable -> 0x00e1 }
        r2.<init>(r4);	 Catch:{ Throwable -> 0x00e1 }
        r4 = r1.getMessage();	 Catch:{ Throwable -> 0x00e1 }
        r2.append(r4);	 Catch:{ Throwable -> 0x00e1 }
        r4 = "; cause: ";	 Catch:{ Throwable -> 0x00e1 }
        r2.append(r4);	 Catch:{ Throwable -> 0x00e1 }
        r4 = r1.getCause();	 Catch:{ Throwable -> 0x00e1 }
        r2.append(r4);	 Catch:{ Throwable -> 0x00e1 }
        r4 = "; th: ";	 Catch:{ Throwable -> 0x00e1 }
        r2.append(r4);	 Catch:{ Throwable -> 0x00e1 }
        r2.append(r1);	 Catch:{ Throwable -> 0x00e1 }
        r1 = r2.toString();	 Catch:{ Throwable -> 0x00e1 }
        r3.append(r1);	 Catch:{ Throwable -> 0x00e1 }
    L_0x00cb:
        r1 = r6 instanceof java.lang.String;	 Catch:{ Throwable -> 0x00e1 }
        if (r1 == 0) goto L_0x00e5;	 Catch:{ Throwable -> 0x00e1 }
    L_0x00cf:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00e1 }
        r2 = "failure detail:";	 Catch:{ Throwable -> 0x00e1 }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x00e1 }
        r1.append(r6);	 Catch:{ Throwable -> 0x00e1 }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x00e1 }
        r3.append(r1);	 Catch:{ Throwable -> 0x00e1 }
        goto L_0x00e5;
    L_0x00e1:
        r1 = move-exception;
        r1.printStackTrace();	 Catch:{ all -> 0x0178 }
    L_0x00e5:
        r1 = r3.toString();	 Catch:{ all -> 0x0178 }
        r2 = "isPreloadX5Disabled:-10000";	 Catch:{ all -> 0x0178 }
        r1 = r1.contains(r2);	 Catch:{ all -> 0x0178 }
        if (r1 == 0) goto L_0x0112;	 Catch:{ all -> 0x0178 }
    L_0x00f1:
        r1 = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();	 Catch:{ all -> 0x0178 }
        r2 = 408; // 0x198 float:5.72E-43 double:2.016E-321;	 Catch:{ all -> 0x0178 }
        r4 = new java.lang.Throwable;	 Catch:{ all -> 0x0178 }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0178 }
        r6 = "X5CoreEngine::init, mCanUseX5=false, available true, details: ";	 Catch:{ all -> 0x0178 }
        r5.<init>(r6);	 Catch:{ all -> 0x0178 }
        r3 = r3.toString();	 Catch:{ all -> 0x0178 }
        r5.append(r3);	 Catch:{ all -> 0x0178 }
        r3 = r5.toString();	 Catch:{ all -> 0x0178 }
        r4.<init>(r3);	 Catch:{ all -> 0x0178 }
    L_0x010e:
        r1.a(r10, r2, r4);	 Catch:{ all -> 0x0178 }
        goto L_0x0174;	 Catch:{ all -> 0x0178 }
    L_0x0112:
        r1 = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();	 Catch:{ all -> 0x0178 }
        r2 = 407; // 0x197 float:5.7E-43 double:2.01E-321;	 Catch:{ all -> 0x0178 }
        r4 = new java.lang.Throwable;	 Catch:{ all -> 0x0178 }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0178 }
        r6 = "X5CoreEngine::init, mCanUseX5=false, available true, details: ";	 Catch:{ all -> 0x0178 }
        r5.<init>(r6);	 Catch:{ all -> 0x0178 }
        r3 = r3.toString();	 Catch:{ all -> 0x0178 }
        r5.append(r3);	 Catch:{ all -> 0x0178 }
        r3 = r5.toString();	 Catch:{ all -> 0x0178 }
        r4.<init>(r3);	 Catch:{ all -> 0x0178 }
        goto L_0x010e;	 Catch:{ all -> 0x0178 }
    L_0x0130:
        r1 = r1.b();	 Catch:{ all -> 0x0178 }
        if (r1 == 0) goto L_0x0153;	 Catch:{ all -> 0x0178 }
    L_0x0136:
        r1 = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();	 Catch:{ all -> 0x0178 }
        r2 = 409; // 0x199 float:5.73E-43 double:2.02E-321;	 Catch:{ all -> 0x0178 }
        r3 = new java.lang.Throwable;	 Catch:{ all -> 0x0178 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0178 }
        r6 = "mCanUseX5=false, available true, reason: ";	 Catch:{ all -> 0x0178 }
        r4.<init>(r6);	 Catch:{ all -> 0x0178 }
        r4.append(r5);	 Catch:{ all -> 0x0178 }
        r4 = r4.toString();	 Catch:{ all -> 0x0178 }
        r3.<init>(r4);	 Catch:{ all -> 0x0178 }
    L_0x014f:
        r1.a(r10, r2, r3);	 Catch:{ all -> 0x0178 }
        goto L_0x0174;	 Catch:{ all -> 0x0178 }
    L_0x0153:
        r1 = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();	 Catch:{ all -> 0x0178 }
        r2 = 410; // 0x19a float:5.75E-43 double:2.026E-321;	 Catch:{ all -> 0x0178 }
        r3 = new java.lang.Throwable;	 Catch:{ all -> 0x0178 }
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0178 }
        r6 = "mCanUseX5=false, available false, reason: ";	 Catch:{ all -> 0x0178 }
        r4.<init>(r6);	 Catch:{ all -> 0x0178 }
        r4.append(r5);	 Catch:{ all -> 0x0178 }
        r4 = r4.toString();	 Catch:{ all -> 0x0178 }
        r3.<init>(r4);	 Catch:{ all -> 0x0178 }
        goto L_0x014f;	 Catch:{ all -> 0x0178 }
    L_0x016d:
        r1 = e;	 Catch:{ all -> 0x0178 }
        if (r1 != 0) goto L_0x0174;	 Catch:{ all -> 0x0178 }
    L_0x0171:
        r9.b(r10);	 Catch:{ all -> 0x0178 }
    L_0x0174:
        r9.d = r0;	 Catch:{ all -> 0x0178 }
        monitor-exit(r9);
        return;
    L_0x0178:
        r10 = move-exception;
        monitor-exit(r9);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.bk.a(android.content.Context):void");
    }

    public synchronized FileLock b(Context context) {
        if (e != null) {
            return e;
        }
        FileOutputStream b = k.b(context, true, "tbs_rename_lock.txt");
        if (b != null) {
            e = k.a(context, b);
        }
        return e;
    }

    public boolean c() {
        return QbSdk.a ? false : this.c;
    }

    public bl d() {
        return QbSdk.a ? null : this.b;
    }

    boolean e() {
        return this.d;
    }
}
