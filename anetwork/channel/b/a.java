package anetwork.channel.b;

import android.content.Context;
import android.os.Build.VERSION;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import anet.channel.util.ALog;
import anet.channel.util.HttpConstant;
import anetwork.channel.http.NetworkSdkSetting;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: Taobao */
public final class a {
    private static volatile boolean a = false;
    private static CookieManager b = null;
    private static boolean c = true;

    public static synchronized void a(Context context) {
        synchronized (a.class) {
            if (a) {
                return;
            }
            try {
                if (VERSION.SDK_INT < 21) {
                    CookieSyncManager.createInstance(context);
                }
                context = CookieManager.getInstance();
                b = context;
                context.setAcceptCookie(true);
                if (VERSION.SDK_INT < 21) {
                    b.removeExpiredCookie();
                }
            } catch (Context context2) {
                c = false;
                ALog.e("anet.CookieManager", "Cookie Manager setup failed!!!", null, context2, new Object[0]);
            }
            a = true;
        }
    }

    private static boolean a() {
        if (!(a || NetworkSdkSetting.getContext() == null)) {
            a(NetworkSdkSetting.getContext());
        }
        return a;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized void a(java.lang.String r5, java.lang.String r6) {
        /*
        r0 = anetwork.channel.b.a.class;
        monitor-enter(r0);
        r1 = a();	 Catch:{ all -> 0x004d }
        if (r1 == 0) goto L_0x004b;
    L_0x0009:
        r1 = c;	 Catch:{ all -> 0x004d }
        if (r1 != 0) goto L_0x000e;
    L_0x000d:
        goto L_0x004b;
    L_0x000e:
        r1 = b;	 Catch:{ Throwable -> 0x0029 }
        r1.setCookie(r5, r6);	 Catch:{ Throwable -> 0x0029 }
        r1 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x0029 }
        r2 = 21;
        if (r1 >= r2) goto L_0x0022;
    L_0x0019:
        r1 = android.webkit.CookieSyncManager.getInstance();	 Catch:{ Throwable -> 0x0029 }
        r1.sync();	 Catch:{ Throwable -> 0x0029 }
        monitor-exit(r0);
        return;
    L_0x0022:
        r1 = b;	 Catch:{ Throwable -> 0x0029 }
        r1.flush();	 Catch:{ Throwable -> 0x0029 }
        monitor-exit(r0);
        return;
    L_0x0029:
        r1 = move-exception;
        r2 = "anet.CookieManager";
        r3 = new java.lang.StringBuilder;	 Catch:{ all -> 0x004d }
        r4 = "set cookie failed. url=";
        r3.<init>(r4);	 Catch:{ all -> 0x004d }
        r3.append(r5);	 Catch:{ all -> 0x004d }
        r5 = " cookies=";
        r3.append(r5);	 Catch:{ all -> 0x004d }
        r3.append(r6);	 Catch:{ all -> 0x004d }
        r5 = r3.toString();	 Catch:{ all -> 0x004d }
        r6 = 0;
        r3 = 0;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x004d }
        anet.channel.util.ALog.e(r2, r5, r6, r1, r3);	 Catch:{ all -> 0x004d }
        monitor-exit(r0);
        return;
    L_0x004b:
        monitor-exit(r0);
        return;
    L_0x004d:
        r5 = move-exception;
        monitor-exit(r0);
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: anetwork.channel.b.a.a(java.lang.String, java.lang.String):void");
    }

    public static void a(String str, Map<String, List<String>> map) {
        if (str != null) {
            if (map != null) {
                try {
                    for (Entry entry : map.entrySet()) {
                        String str2 = (String) entry.getKey();
                        if (str2 != null && (str2.equalsIgnoreCase(HttpConstant.SET_COOKIE) || str2.equalsIgnoreCase(HttpConstant.SET_COOKIE2))) {
                            for (String str22 : (List) entry.getValue()) {
                                a(str, str22);
                            }
                        }
                    }
                } catch (Throwable e) {
                    ALog.e("anet.CookieManager", "set cookie failed", null, e, "url", str, "\nheaders", map);
                }
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String a(java.lang.String r6) {
        /*
        r0 = anetwork.channel.b.a.class;
        monitor-enter(r0);
        r1 = a();	 Catch:{ all -> 0x0032 }
        r2 = 0;
        if (r1 == 0) goto L_0x0030;
    L_0x000a:
        r1 = c;	 Catch:{ all -> 0x0032 }
        if (r1 != 0) goto L_0x000f;
    L_0x000e:
        goto L_0x0030;
    L_0x000f:
        r1 = b;	 Catch:{ Throwable -> 0x0016 }
        r1 = r1.getCookie(r6);	 Catch:{ Throwable -> 0x0016 }
        goto L_0x002e;
    L_0x0016:
        r1 = move-exception;
        r3 = "anet.CookieManager";
        r4 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0032 }
        r5 = "get cookie failed. url=";
        r4.<init>(r5);	 Catch:{ all -> 0x0032 }
        r4.append(r6);	 Catch:{ all -> 0x0032 }
        r6 = r4.toString();	 Catch:{ all -> 0x0032 }
        r4 = 0;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x0032 }
        anet.channel.util.ALog.e(r3, r6, r2, r1, r4);	 Catch:{ all -> 0x0032 }
        r1 = r2;
    L_0x002e:
        monitor-exit(r0);
        return r1;
    L_0x0030:
        monitor-exit(r0);
        return r2;
    L_0x0032:
        r6 = move-exception;
        monitor-exit(r0);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: anetwork.channel.b.a.a(java.lang.String):java.lang.String");
    }
}
