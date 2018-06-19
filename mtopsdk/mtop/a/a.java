package mtopsdk.mtop.a;

import android.content.Context;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.common.util.TBSdkLog$LogEnable;
import mtopsdk.common.util.i;
import mtopsdk.common.util.j;
import mtopsdk.mtop.util.e;

public final class a {
    private static d a = d.a();
    private static volatile boolean b = false;
    private static AtomicBoolean c = new AtomicBoolean(true);
    private static Object d = new Object();

    public static void a() {
        if (!b) {
            synchronized (d) {
                try {
                    if (!b) {
                        d.wait(60000);
                        if (!b) {
                            j.e("[checkMtopSDKInit]Didn't call MtopSDK.init(...),please execute global init.");
                        }
                    }
                } catch (Exception e) {
                    StringBuilder stringBuilder = new StringBuilder("[checkMtopSDKInit] wait MtopSDK initLock failed---");
                    stringBuilder.append(e.toString());
                    j.e(stringBuilder.toString());
                }
            }
        }
    }

    public static synchronized void a(Context context, String str) {
        synchronized (a.class) {
            if (j.a(TBSdkLog$LogEnable.InfoEnable)) {
                StringBuilder stringBuilder = new StringBuilder("[init]ttid=");
                stringBuilder.append(str);
                j.b(stringBuilder.toString());
            }
            b(context, str);
        }
    }

    private static synchronized void b(Context context, String str) {
        synchronized (a.class) {
            if (i.a(str)) {
                a.a(str);
            }
            if (!b) {
                a.a(context);
                e.a(new b(context, str));
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(android.content.Context r3, com.taobao.tao.remotebusiness.listener.c r4, java.lang.String r5) {
        /*
        r0 = d;
        monitor-enter(r0);
        r1 = b;	 Catch:{ all -> 0x009e }
        if (r1 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r0);	 Catch:{ all -> 0x009e }
        return;
    L_0x0009:
        r1 = mtopsdk.common.util.TBSdkLog$LogEnable.InfoEnable;	 Catch:{ all -> 0x009e }
        r1 = mtopsdk.common.util.j.a(r1);	 Catch:{ all -> 0x009e }
        if (r1 == 0) goto L_0x0022;
    L_0x0011:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x009e }
        r2 = "[executeInitCoreTask]MtopSDK initcore start. ttid=";
        r1.<init>(r2);	 Catch:{ all -> 0x009e }
        r1.append(r5);	 Catch:{ all -> 0x009e }
        r1 = r1.toString();	 Catch:{ all -> 0x009e }
        mtopsdk.common.util.j.b(r1);	 Catch:{ all -> 0x009e }
    L_0x0022:
        r1 = 1;
        r2 = a;	 Catch:{ Throwable -> 0x0064 }
        r2.a(r3);	 Catch:{ Throwable -> 0x0064 }
        mtopsdk.xstate.a.a(r3);	 Catch:{ Throwable -> 0x0064 }
        r2 = mtopsdk.common.util.i.a(r5);	 Catch:{ Throwable -> 0x0064 }
        if (r2 == 0) goto L_0x0036;
    L_0x0031:
        r2 = a;	 Catch:{ Throwable -> 0x0064 }
        r2.a(r5);	 Catch:{ Throwable -> 0x0064 }
    L_0x0036:
        if (r4 != 0) goto L_0x003d;
    L_0x0038:
        r4 = new com.taobao.tao.remotebusiness.listener.c;	 Catch:{ Throwable -> 0x0064 }
        r4.<init>();	 Catch:{ Throwable -> 0x0064 }
    L_0x003d:
        r5 = mtopsdk.mtop.a.d.d();	 Catch:{ Throwable -> 0x0064 }
        r4.a(r3, r5);	 Catch:{ Throwable -> 0x0064 }
        mtopsdk.mtop.a.d.a = r4;	 Catch:{ Throwable -> 0x0064 }
        r5 = new mtopsdk.b.a;	 Catch:{ Throwable -> 0x0064 }
        r2 = mtopsdk.mtop.a.d.d();	 Catch:{ Throwable -> 0x0064 }
        r5.<init>(r2);	 Catch:{ Throwable -> 0x0064 }
        r4 = r4.a(r5);	 Catch:{ Throwable -> 0x0064 }
        mtopsdk.mtop.a.d.b = r4;	 Catch:{ Throwable -> 0x0064 }
        r5 = "appKey";
        mtopsdk.xstate.a.a(r5, r4);	 Catch:{ Throwable -> 0x0064 }
        b = r1;	 Catch:{ all -> 0x009e }
        r4 = d;	 Catch:{ all -> 0x009e }
    L_0x005e:
        r4.notifyAll();	 Catch:{ all -> 0x009e }
        goto L_0x007f;
    L_0x0062:
        r3 = move-exception;
        goto L_0x0096;
    L_0x0064:
        r4 = move-exception;
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0062 }
        r2 = "[executeInitCoreTask]MtopSDK initcore error---";
        r5.<init>(r2);	 Catch:{ all -> 0x0062 }
        r4 = r4.toString();	 Catch:{ all -> 0x0062 }
        r5.append(r4);	 Catch:{ all -> 0x0062 }
        r4 = r5.toString();	 Catch:{ all -> 0x0062 }
        mtopsdk.common.util.j.e(r4);	 Catch:{ all -> 0x0062 }
        b = r1;	 Catch:{ all -> 0x009e }
        r4 = d;	 Catch:{ all -> 0x009e }
        goto L_0x005e;
    L_0x007f:
        r4 = mtopsdk.common.util.TBSdkLog$LogEnable.InfoEnable;	 Catch:{ all -> 0x009e }
        r4 = mtopsdk.common.util.j.a(r4);	 Catch:{ all -> 0x009e }
        if (r4 == 0) goto L_0x008c;
    L_0x0087:
        r4 = "[executeInitCoreTask]MtopSDK initcore end";
        mtopsdk.common.util.j.b(r4);	 Catch:{ all -> 0x009e }
    L_0x008c:
        monitor-exit(r0);	 Catch:{ all -> 0x009e }
        r4 = new mtopsdk.mtop.a.c;
        r4.<init>(r3);
        mtopsdk.mtop.util.e.a(r4);
        return;
    L_0x0096:
        b = r1;	 Catch:{ all -> 0x009e }
        r4 = d;	 Catch:{ all -> 0x009e }
        r4.notifyAll();	 Catch:{ all -> 0x009e }
        throw r3;	 Catch:{ all -> 0x009e }
    L_0x009e:
        r3 = move-exception;
        monitor-exit(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.mtop.a.a.a(android.content.Context, com.taobao.tao.remotebusiness.listener.c, java.lang.String):void");
    }

    static /* synthetic */ void b() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = mtopsdk.common.util.TBSdkLog$LogEnable.InfoEnable;
        r0 = mtopsdk.common.util.j.a(r0);
        if (r0 == 0) goto L_0x000d;
    L_0x0008:
        r0 = "[executeInitExtraTask]MtopSDK initextra start";
        mtopsdk.common.util.j.b(r0);
    L_0x000d:
        mtopsdk.mtop.a.g.a();	 Catch:{ Throwable -> 0x0014 }
        mtopsdk.mtop.a.g.b();	 Catch:{ Throwable -> 0x0014 }
        goto L_0x0019;
    L_0x0014:
        r0 = "[executeInitExtraTask] execute MtopSDK initExtraTask error.---";
        mtopsdk.common.util.j.f(r0);
    L_0x0019:
        r0 = mtopsdk.common.util.TBSdkLog$LogEnable.InfoEnable;
        r0 = mtopsdk.common.util.j.a(r0);
        if (r0 == 0) goto L_0x0026;
    L_0x0021:
        r0 = "[executeInitExtraTask]MtopSDK initextra end";
        mtopsdk.common.util.j.b(r0);
    L_0x0026:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.mtop.a.a.b():void");
    }
}
