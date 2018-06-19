package com.tencent.smtt.sdk;

import android.content.Context;

public class CookieSyncManager {
    private static android.webkit.CookieSyncManager a = null;
    private static CookieSyncManager b = null;
    private static boolean c = false;

    private CookieSyncManager(Context context) {
        bk b = bk.b();
        if (b != null && b.c()) {
            b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_createInstance", new Class[]{Context.class}, context);
            c = true;
        }
    }

    public static synchronized CookieSyncManager createInstance(Context context) {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            a = android.webkit.CookieSyncManager.createInstance(context);
            if (b == null || !c) {
                b = new CookieSyncManager(context.getApplicationContext());
            }
            cookieSyncManager = b;
        }
        return cookieSyncManager;
    }

    public static synchronized CookieSyncManager getInstance() {
        CookieSyncManager cookieSyncManager;
        synchronized (CookieSyncManager.class) {
            if (b == null) {
                throw new IllegalStateException("CookieSyncManager::createInstance() needs to be called before CookieSyncManager::getInstance()");
            }
            cookieSyncManager = b;
        }
        return cookieSyncManager;
    }

    public void startSync() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r5 = this;
        r0 = com.tencent.smtt.sdk.bk.b();
        if (r0 == 0) goto L_0x0021;
    L_0x0006:
        r1 = r0.c();
        if (r1 == 0) goto L_0x0021;
    L_0x000c:
        r0 = r0.d();
        r0 = r0.b();
        r1 = "com.tencent.tbs.tbsshell.WebCoreProxy";
        r2 = "cookieSyncManager_startSync";
        r3 = 0;
        r4 = new java.lang.Class[r3];
        r3 = new java.lang.Object[r3];
        r0.invokeStaticMethod(r1, r2, r4, r3);
        return;
    L_0x0021:
        r0 = a;
        r0.startSync();
        r0 = "android.webkit.WebSyncManager";	 Catch:{ Exception -> 0x0046 }
        r0 = java.lang.Class.forName(r0);	 Catch:{ Exception -> 0x0046 }
        r1 = "mSyncThread";	 Catch:{ Exception -> 0x0046 }
        r0 = r0.getDeclaredField(r1);	 Catch:{ Exception -> 0x0046 }
        r1 = 1;	 Catch:{ Exception -> 0x0046 }
        r0.setAccessible(r1);	 Catch:{ Exception -> 0x0046 }
        r1 = a;	 Catch:{ Exception -> 0x0046 }
        r0 = r0.get(r1);	 Catch:{ Exception -> 0x0046 }
        r0 = (java.lang.Thread) r0;	 Catch:{ Exception -> 0x0046 }
        r1 = new com.tencent.smtt.sdk.m;	 Catch:{ Exception -> 0x0046 }
        r1.<init>();	 Catch:{ Exception -> 0x0046 }
        r0.setUncaughtExceptionHandler(r1);	 Catch:{ Exception -> 0x0046 }
    L_0x0046:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.CookieSyncManager.startSync():void");
    }

    public void stopSync() {
        bk b = bk.b();
        if (b == null || !b.c()) {
            a.stopSync();
        } else {
            b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_stopSync", new Class[0], new Object[0]);
        }
    }

    public void sync() {
        bk b = bk.b();
        if (b == null || !b.c()) {
            a.sync();
        } else {
            b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieSyncManager_Sync", new Class[0], new Object[0]);
        }
    }
}
