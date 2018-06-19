package com.tencent.tinker.loader.hotplug;

import android.content.Context;
import android.os.Handler;
import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.hotplug.interceptor.HandlerMessageInterceptor;
import com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;

/* compiled from: BUGLY */
public final class ComponentHotplug {
    private static final String TAG = "Tinker.ComponentHotplug";
    private static ServiceBinderInterceptor sAMSInterceptor = null;
    private static volatile boolean sInstalled = false;
    private static HandlerMessageInterceptor sMHMessageInterceptor;
    private static ServiceBinderInterceptor sPMSInterceptor;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void install(com.tencent.tinker.loader.app.TinkerApplication r3, com.tencent.tinker.loader.shareutil.ShareSecurityCheck r4) throws com.tencent.tinker.loader.hotplug.UnsupportedEnvironmentException {
        /*
        r0 = com.tencent.tinker.loader.hotplug.ComponentHotplug.class;
        monitor-enter(r0);
        r1 = sInstalled;	 Catch:{ all -> 0x0059 }
        if (r1 != 0) goto L_0x0057;
    L_0x0007:
        r4 = com.tencent.tinker.loader.hotplug.IncrementComponentManager.init(r3, r4);	 Catch:{ Throwable -> 0x004d }
        if (r4 == 0) goto L_0x004b;
    L_0x000d:
        r4 = new com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor;	 Catch:{ Throwable -> 0x004d }
        r1 = "activity";
        r2 = new com.tencent.tinker.loader.hotplug.handler.AMSInterceptHandler;	 Catch:{ Throwable -> 0x004d }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x004d }
        r4.<init>(r3, r1, r2);	 Catch:{ Throwable -> 0x004d }
        sAMSInterceptor = r4;	 Catch:{ Throwable -> 0x004d }
        r4 = new com.tencent.tinker.loader.hotplug.interceptor.ServiceBinderInterceptor;	 Catch:{ Throwable -> 0x004d }
        r1 = "package";
        r2 = new com.tencent.tinker.loader.hotplug.handler.PMSInterceptHandler;	 Catch:{ Throwable -> 0x004d }
        r2.<init>();	 Catch:{ Throwable -> 0x004d }
        r4.<init>(r3, r1, r2);	 Catch:{ Throwable -> 0x004d }
        sPMSInterceptor = r4;	 Catch:{ Throwable -> 0x004d }
        r4 = fetchMHInstance(r3);	 Catch:{ Throwable -> 0x004d }
        r1 = new com.tencent.tinker.loader.hotplug.interceptor.HandlerMessageInterceptor;	 Catch:{ Throwable -> 0x004d }
        r2 = new com.tencent.tinker.loader.hotplug.handler.MHMessageHandler;	 Catch:{ Throwable -> 0x004d }
        r2.<init>(r3);	 Catch:{ Throwable -> 0x004d }
        r1.<init>(r4, r2);	 Catch:{ Throwable -> 0x004d }
        sMHMessageInterceptor = r1;	 Catch:{ Throwable -> 0x004d }
        r3 = sAMSInterceptor;	 Catch:{ Throwable -> 0x004d }
        r3.install();	 Catch:{ Throwable -> 0x004d }
        r3 = sPMSInterceptor;	 Catch:{ Throwable -> 0x004d }
        r3.install();	 Catch:{ Throwable -> 0x004d }
        r3 = sMHMessageInterceptor;	 Catch:{ Throwable -> 0x004d }
        r3.install();	 Catch:{ Throwable -> 0x004d }
        r3 = 1;
        sInstalled = r3;	 Catch:{ Throwable -> 0x004d }
    L_0x004b:
        monitor-exit(r0);
        return;
    L_0x004d:
        r3 = move-exception;
        uninstall();	 Catch:{ all -> 0x0059 }
        r4 = new com.tencent.tinker.loader.hotplug.UnsupportedEnvironmentException;	 Catch:{ all -> 0x0059 }
        r4.<init>(r3);	 Catch:{ all -> 0x0059 }
        throw r4;	 Catch:{ all -> 0x0059 }
    L_0x0057:
        monitor-exit(r0);
        return;
    L_0x0059:
        r3 = move-exception;
        monitor-exit(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.hotplug.ComponentHotplug.install(com.tencent.tinker.loader.app.TinkerApplication, com.tencent.tinker.loader.shareutil.ShareSecurityCheck):void");
    }

    public static synchronized void ensureComponentHotplugInstalled(TinkerApplication tinkerApplication) throws UnsupportedEnvironmentException {
        synchronized (ComponentHotplug.class) {
            if (sInstalled) {
                try {
                    sAMSInterceptor.install();
                    sPMSInterceptor.install();
                    sMHMessageInterceptor.install();
                } catch (Throwable th) {
                    uninstall();
                    UnsupportedEnvironmentException unsupportedEnvironmentException = new UnsupportedEnvironmentException(th);
                }
            }
        }
    }

    private static Handler fetchMHInstance(Context context) {
        Object activityThread = ShareReflectUtil.getActivityThread(context, null);
        if (activityThread == null) {
            throw new IllegalStateException("failed to fetch instance of ActivityThread.");
        }
        try {
            return (Handler) ShareReflectUtil.findField(activityThread, "mH").get(activityThread);
        } catch (Context context2) {
            IllegalStateException illegalStateException = new IllegalStateException(context2);
        }
    }

    public static synchronized void uninstall() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.tencent.tinker.loader.hotplug.ComponentHotplug.class;
        monitor-enter(r0);
        r1 = sInstalled;	 Catch:{ all -> 0x001b }
        if (r1 == 0) goto L_0x0019;
    L_0x0007:
        r1 = sAMSInterceptor;	 Catch:{ Throwable -> 0x0016 }
        r1.uninstall();	 Catch:{ Throwable -> 0x0016 }
        r1 = sPMSInterceptor;	 Catch:{ Throwable -> 0x0016 }
        r1.uninstall();	 Catch:{ Throwable -> 0x0016 }
        r1 = sMHMessageInterceptor;	 Catch:{ Throwable -> 0x0016 }
        r1.uninstall();	 Catch:{ Throwable -> 0x0016 }
    L_0x0016:
        r1 = 0;
        sInstalled = r1;	 Catch:{ all -> 0x001b }
    L_0x0019:
        monitor-exit(r0);
        return;
    L_0x001b:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tinker.loader.hotplug.ComponentHotplug.uninstall():void");
    }

    private ComponentHotplug() {
        throw new UnsupportedOperationException();
    }
}
