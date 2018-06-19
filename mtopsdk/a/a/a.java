package mtopsdk.a.a;

import android.webkit.CookieManager;
import mtopsdk.mtop.a.d;

public final class a {
    private static volatile boolean a = false;
    private static CookieManager b;

    static {
        d.a();
        a(d.b());
    }

    public static synchronized java.lang.String a(java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = mtopsdk.a.a.a.class;
        monitor-enter(r0);
        r1 = a;	 Catch:{ all -> 0x0025 }
        r2 = 0;
        if (r1 != 0) goto L_0x000a;
    L_0x0008:
        monitor-exit(r0);
        return r2;
    L_0x000a:
        r1 = b;	 Catch:{ Throwable -> 0x0011 }
        r1 = r1.getCookie(r4);	 Catch:{ Throwable -> 0x0011 }
        goto L_0x0023;
    L_0x0011:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0025 }
        r3 = "get cookie failed. url=";	 Catch:{ all -> 0x0025 }
        r1.<init>(r3);	 Catch:{ all -> 0x0025 }
        r1.append(r4);	 Catch:{ all -> 0x0025 }
        r4 = r1.toString();	 Catch:{ all -> 0x0025 }
        mtopsdk.common.util.j.f(r4);	 Catch:{ all -> 0x0025 }
        r1 = r2;
    L_0x0023:
        monitor-exit(r0);
        return r1;
    L_0x0025:
        r4 = move-exception;
        monitor-exit(r0);
        throw r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.a.a.a.a(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void a(android.content.Context r2) {
        /*
        r0 = mtopsdk.a.a.a.class;
        monitor-enter(r0);
        r1 = a;	 Catch:{ all -> 0x0022 }
        if (r1 != 0) goto L_0x0020;
    L_0x0007:
        if (r2 != 0) goto L_0x000a;
    L_0x0009:
        goto L_0x0020;
    L_0x000a:
        android.webkit.CookieSyncManager.createInstance(r2);	 Catch:{ all -> 0x0022 }
        r2 = android.webkit.CookieManager.getInstance();	 Catch:{ all -> 0x0022 }
        b = r2;	 Catch:{ all -> 0x0022 }
        r1 = 1;
        r2.setAcceptCookie(r1);	 Catch:{ all -> 0x0022 }
        r2 = b;	 Catch:{ all -> 0x0022 }
        r2.removeExpiredCookie();	 Catch:{ all -> 0x0022 }
        a = r1;	 Catch:{ all -> 0x0022 }
        monitor-exit(r0);
        return;
    L_0x0020:
        monitor-exit(r0);
        return;
    L_0x0022:
        r2 = move-exception;
        monitor-exit(r0);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.a.a.a.a(android.content.Context):void");
    }

    public static synchronized void a(java.lang.String r3, java.lang.String r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = mtopsdk.a.a.a.class;
        monitor-enter(r0);
        r1 = a;	 Catch:{ all -> 0x0032 }
        if (r1 != 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r0);
        return;
    L_0x0009:
        r1 = b;	 Catch:{ Throwable -> 0x0017 }
        r1.setCookie(r3, r4);	 Catch:{ Throwable -> 0x0017 }
        r1 = android.webkit.CookieSyncManager.getInstance();	 Catch:{ Throwable -> 0x0017 }
        r1.sync();	 Catch:{ Throwable -> 0x0017 }
        monitor-exit(r0);
        return;
    L_0x0017:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0032 }
        r2 = "set cookie failed. url=";	 Catch:{ all -> 0x0032 }
        r1.<init>(r2);	 Catch:{ all -> 0x0032 }
        r1.append(r3);	 Catch:{ all -> 0x0032 }
        r3 = " cookies=";	 Catch:{ all -> 0x0032 }
        r1.append(r3);	 Catch:{ all -> 0x0032 }
        r1.append(r4);	 Catch:{ all -> 0x0032 }
        r3 = r1.toString();	 Catch:{ all -> 0x0032 }
        mtopsdk.common.util.j.f(r3);	 Catch:{ all -> 0x0032 }
        monitor-exit(r0);
        return;
    L_0x0032:
        r3 = move-exception;
        monitor-exit(r0);
        throw r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.a.a.a.a(java.lang.String, java.lang.String):void");
    }
}
