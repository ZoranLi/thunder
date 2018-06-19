package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.tencent.smtt.utils.v;
import java.util.ArrayList;
import java.util.Map;

public class CookieManager {
    public static String LOGTAG = "CookieManager";
    private static CookieManager d;
    ArrayList<b> a;
    String b;
    a c = a.MODE_NONE;
    private boolean e = false;
    private boolean f = false;

    public enum a {
        MODE_NONE,
        MODE_KEYS,
        MODE_ALL
    }

    class b {
        int a;
        String b;
        String c;
        ValueCallback<Boolean> d;
        final /* synthetic */ CookieManager e;

        b(CookieManager cookieManager) {
            this.e = cookieManager;
        }
    }

    private CookieManager() {
    }

    public static CookieManager getInstance() {
        if (d == null) {
            synchronized (CookieManager.class) {
                if (d == null) {
                    d = new CookieManager();
                }
            }
        }
        return d;
    }

    public static int getROMCookieDBVersion(Context context) {
        String str;
        int i;
        if (VERSION.SDK_INT >= 11) {
            str = "cookiedb_info";
            i = 4;
        } else {
            str = "cookiedb_info";
            i = 0;
        }
        return context.getSharedPreferences(str, i).getInt("db_version", -1);
    }

    public static void setROMCookieDBVersion(Context context, int i) {
        String str;
        int i2;
        if (VERSION.SDK_INT >= 11) {
            str = "cookiedb_info";
            i2 = 4;
        } else {
            str = "cookiedb_info";
            i2 = 0;
        }
        Editor edit = context.getSharedPreferences(str, i2).edit();
        edit.putInt("db_version", i);
        edit.commit();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    synchronized void a() {
        /*
        r10 = this;
        monitor-enter(r10);
        r0 = 1;
        r10.f = r0;	 Catch:{ all -> 0x00a4 }
        r1 = r10.a;	 Catch:{ all -> 0x00a4 }
        if (r1 == 0) goto L_0x00a2;
    L_0x0008:
        r1 = r10.a;	 Catch:{ all -> 0x00a4 }
        r1 = r1.size();	 Catch:{ all -> 0x00a4 }
        if (r1 != 0) goto L_0x0012;
    L_0x0010:
        goto L_0x00a2;
    L_0x0012:
        r1 = com.tencent.smtt.sdk.bk.b();	 Catch:{ all -> 0x00a4 }
        if (r1 == 0) goto L_0x0048;
    L_0x0018:
        r1 = r1.c();	 Catch:{ all -> 0x00a4 }
        if (r1 == 0) goto L_0x0048;
    L_0x001e:
        r0 = r10.a;	 Catch:{ all -> 0x00a4 }
        r0 = r0.iterator();	 Catch:{ all -> 0x00a4 }
    L_0x0024:
        r1 = r0.hasNext();	 Catch:{ all -> 0x00a4 }
        if (r1 == 0) goto L_0x009b;
    L_0x002a:
        r1 = r0.next();	 Catch:{ all -> 0x00a4 }
        r1 = (com.tencent.smtt.sdk.CookieManager.b) r1;	 Catch:{ all -> 0x00a4 }
        r2 = r1.a;	 Catch:{ all -> 0x00a4 }
        switch(r2) {
            case 1: goto L_0x003e;
            case 2: goto L_0x0036;
            default: goto L_0x0035;
        };	 Catch:{ all -> 0x00a4 }
    L_0x0035:
        goto L_0x0024;
    L_0x0036:
        r2 = r1.b;	 Catch:{ all -> 0x00a4 }
        r1 = r1.c;	 Catch:{ all -> 0x00a4 }
        r10.setCookie(r2, r1);	 Catch:{ all -> 0x00a4 }
        goto L_0x0024;
    L_0x003e:
        r2 = r1.b;	 Catch:{ all -> 0x00a4 }
        r3 = r1.c;	 Catch:{ all -> 0x00a4 }
        r1 = r1.d;	 Catch:{ all -> 0x00a4 }
        r10.setCookie(r2, r3, r1);	 Catch:{ all -> 0x00a4 }
        goto L_0x0024;
    L_0x0048:
        r1 = r10.a;	 Catch:{ all -> 0x00a4 }
        r1 = r1.iterator();	 Catch:{ all -> 0x00a4 }
    L_0x004e:
        r2 = r1.hasNext();	 Catch:{ all -> 0x00a4 }
        if (r2 == 0) goto L_0x009b;
    L_0x0054:
        r2 = r1.next();	 Catch:{ all -> 0x00a4 }
        r2 = (com.tencent.smtt.sdk.CookieManager.b) r2;	 Catch:{ all -> 0x00a4 }
        r3 = r2.a;	 Catch:{ all -> 0x00a4 }
        switch(r3) {
            case 1: goto L_0x006c;
            case 2: goto L_0x0060;
            default: goto L_0x005f;
        };	 Catch:{ all -> 0x00a4 }
    L_0x005f:
        goto L_0x004e;
    L_0x0060:
        r3 = android.webkit.CookieManager.getInstance();	 Catch:{ all -> 0x00a4 }
        r4 = r2.b;	 Catch:{ all -> 0x00a4 }
        r2 = r2.c;	 Catch:{ all -> 0x00a4 }
        r3.setCookie(r4, r2);	 Catch:{ all -> 0x00a4 }
        goto L_0x004e;
    L_0x006c:
        r3 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x00a4 }
        r4 = 21;
        if (r3 < r4) goto L_0x004e;
    L_0x0072:
        r3 = android.webkit.CookieManager.getInstance();	 Catch:{ all -> 0x00a4 }
        r4 = "setCookie";
        r5 = 3;
        r6 = new java.lang.Class[r5];	 Catch:{ all -> 0x00a4 }
        r7 = java.lang.String.class;
        r8 = 0;
        r6[r8] = r7;	 Catch:{ all -> 0x00a4 }
        r7 = java.lang.String.class;
        r6[r0] = r7;	 Catch:{ all -> 0x00a4 }
        r7 = android.webkit.ValueCallback.class;
        r9 = 2;
        r6[r9] = r7;	 Catch:{ all -> 0x00a4 }
        r5 = new java.lang.Object[r5];	 Catch:{ all -> 0x00a4 }
        r7 = r2.b;	 Catch:{ all -> 0x00a4 }
        r5[r8] = r7;	 Catch:{ all -> 0x00a4 }
        r7 = r2.c;	 Catch:{ all -> 0x00a4 }
        r5[r0] = r7;	 Catch:{ all -> 0x00a4 }
        r2 = r2.d;	 Catch:{ all -> 0x00a4 }
        r5[r9] = r2;	 Catch:{ all -> 0x00a4 }
        com.tencent.smtt.utils.v.a(r3, r4, r6, r5);	 Catch:{ all -> 0x00a4 }
        goto L_0x004e;
    L_0x009b:
        r0 = r10.a;	 Catch:{ all -> 0x00a4 }
        r0.clear();	 Catch:{ all -> 0x00a4 }
        monitor-exit(r10);
        return;
    L_0x00a2:
        monitor-exit(r10);
        return;
    L_0x00a4:
        r0 = move-exception;
        monitor-exit(r10);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.CookieManager.a():void");
    }

    protected synchronized void a(android.content.Context r11, boolean r12, boolean r13) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r10 = this;
        monitor-enter(r10);
        r0 = r10.c;	 Catch:{ all -> 0x014a }
        r1 = com.tencent.smtt.sdk.CookieManager.a.MODE_NONE;	 Catch:{ all -> 0x014a }
        if (r0 == r1) goto L_0x0148;	 Catch:{ all -> 0x014a }
    L_0x0007:
        if (r11 == 0) goto L_0x0148;	 Catch:{ all -> 0x014a }
    L_0x0009:
        r0 = com.tencent.smtt.sdk.TbsExtensionFunctionManager.getInstance();	 Catch:{ all -> 0x014a }
        r1 = "cookie_switch.txt";	 Catch:{ all -> 0x014a }
        r0 = r0.canUseFunction(r11, r1);	 Catch:{ all -> 0x014a }
        if (r0 == 0) goto L_0x0148;	 Catch:{ all -> 0x014a }
    L_0x0015:
        r0 = r10.e;	 Catch:{ all -> 0x014a }
        if (r0 == 0) goto L_0x001b;	 Catch:{ all -> 0x014a }
    L_0x0019:
        goto L_0x0148;	 Catch:{ all -> 0x014a }
    L_0x001b:
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x014a }
        r2 = 0;	 Catch:{ all -> 0x014a }
        r4 = LOGTAG;	 Catch:{ all -> 0x014a }
        r5 = new java.lang.StringBuilder;	 Catch:{ all -> 0x014a }
        r6 = "compatiableCookieDatabaseIfNeed,isX5Inited:";	 Catch:{ all -> 0x014a }
        r5.<init>(r6);	 Catch:{ all -> 0x014a }
        r5.append(r12);	 Catch:{ all -> 0x014a }
        r6 = ",useX5:";	 Catch:{ all -> 0x014a }
        r5.append(r6);	 Catch:{ all -> 0x014a }
        r5.append(r13);	 Catch:{ all -> 0x014a }
        r5 = r5.toString();	 Catch:{ all -> 0x014a }
        com.tencent.smtt.utils.TbsLog.i(r4, r5);	 Catch:{ all -> 0x014a }
        if (r12 != 0) goto L_0x0052;	 Catch:{ all -> 0x014a }
    L_0x003e:
        r12 = com.tencent.smtt.sdk.QbSdk.getIsSysWebViewForcedByOuter();	 Catch:{ all -> 0x014a }
        if (r12 != 0) goto L_0x0052;	 Catch:{ all -> 0x014a }
    L_0x0044:
        r12 = com.tencent.smtt.sdk.QbSdk.a;	 Catch:{ all -> 0x014a }
        if (r12 == 0) goto L_0x0049;	 Catch:{ all -> 0x014a }
    L_0x0048:
        goto L_0x0052;	 Catch:{ all -> 0x014a }
    L_0x0049:
        r12 = com.tencent.smtt.sdk.bk.b();	 Catch:{ all -> 0x014a }
        r12.a(r11);	 Catch:{ all -> 0x014a }
        monitor-exit(r10);
        return;
    L_0x0052:
        r12 = com.tencent.smtt.sdk.QbSdk.getIsSysWebViewForcedByOuter();	 Catch:{ all -> 0x014a }
        r4 = 0;	 Catch:{ all -> 0x014a }
        if (r12 != 0) goto L_0x005d;	 Catch:{ all -> 0x014a }
    L_0x0059:
        r12 = com.tencent.smtt.sdk.QbSdk.a;	 Catch:{ all -> 0x014a }
        if (r12 == 0) goto L_0x005e;	 Catch:{ all -> 0x014a }
    L_0x005d:
        r13 = r4;	 Catch:{ all -> 0x014a }
    L_0x005e:
        r12 = com.tencent.smtt.sdk.TbsExtensionFunctionManager.getInstance();	 Catch:{ all -> 0x014a }
        r5 = "usex5.txt";	 Catch:{ all -> 0x014a }
        r12 = r12.canUseFunction(r11, r5);	 Catch:{ all -> 0x014a }
        r5 = LOGTAG;	 Catch:{ all -> 0x014a }
        r6 = new java.lang.StringBuilder;	 Catch:{ all -> 0x014a }
        r7 = "usex5 : mUseX5LastProcess->";	 Catch:{ all -> 0x014a }
        r6.<init>(r7);	 Catch:{ all -> 0x014a }
        r6.append(r12);	 Catch:{ all -> 0x014a }
        r7 = ",useX5:";	 Catch:{ all -> 0x014a }
        r6.append(r7);	 Catch:{ all -> 0x014a }
        r6.append(r13);	 Catch:{ all -> 0x014a }
        r6 = r6.toString();	 Catch:{ all -> 0x014a }
        com.tencent.smtt.utils.TbsLog.i(r5, r6);	 Catch:{ all -> 0x014a }
        r5 = com.tencent.smtt.sdk.TbsExtensionFunctionManager.getInstance();	 Catch:{ all -> 0x014a }
        r6 = "usex5.txt";	 Catch:{ all -> 0x014a }
        r5.setFunctionEnable(r11, r6, r13);	 Catch:{ all -> 0x014a }
        if (r12 != r13) goto L_0x0090;
    L_0x008e:
        monitor-exit(r10);
        return;
    L_0x0090:
        r5 = com.tencent.smtt.sdk.TbsLogReport.a(r11);	 Catch:{ all -> 0x014a }
        r5 = r5.a();	 Catch:{ all -> 0x014a }
        r6 = r10.b;	 Catch:{ all -> 0x014a }
        r6 = android.text.TextUtils.isEmpty(r6);	 Catch:{ all -> 0x014a }
        if (r6 != 0) goto L_0x010d;	 Catch:{ all -> 0x014a }
    L_0x00a0:
        r6 = com.tencent.smtt.sdk.aj.a();	 Catch:{ all -> 0x014a }
        r6 = r6.i(r11);	 Catch:{ all -> 0x014a }
        if (r6 <= 0) goto L_0x00b9;	 Catch:{ all -> 0x014a }
    L_0x00aa:
        r6 = com.tencent.smtt.sdk.aj.a();	 Catch:{ all -> 0x014a }
        r6 = r6.i(r11);	 Catch:{ all -> 0x014a }
        r7 = 36001; // 0x8ca1 float:5.0448E-41 double:1.7787E-319;
        if (r6 >= r7) goto L_0x00b9;
    L_0x00b7:
        monitor-exit(r10);
        return;
    L_0x00b9:
        if (r12 == 0) goto L_0x00cb;
    L_0x00bb:
        r6 = com.tencent.smtt.sdk.u.d(r11);	 Catch:{ all -> 0x014a }
        if (r6 <= 0) goto L_0x00c9;	 Catch:{ all -> 0x014a }
    L_0x00c1:
        r7 = getROMCookieDBVersion(r11);	 Catch:{ all -> 0x014a }
        if (r7 > 0) goto L_0x00e5;	 Catch:{ all -> 0x014a }
    L_0x00c7:
        r4 = 1;	 Catch:{ all -> 0x014a }
        goto L_0x00e5;	 Catch:{ all -> 0x014a }
    L_0x00c9:
        r7 = r4;	 Catch:{ all -> 0x014a }
        goto L_0x00e5;	 Catch:{ all -> 0x014a }
    L_0x00cb:
        r6 = com.tencent.smtt.sdk.u.d(r11);	 Catch:{ all -> 0x014a }
        if (r6 <= 0) goto L_0x00c9;	 Catch:{ all -> 0x014a }
    L_0x00d1:
        r7 = com.tencent.smtt.sdk.aj.a();	 Catch:{ all -> 0x014a }
        r8 = "cookies_database_version";	 Catch:{ all -> 0x014a }
        r7 = r7.c(r11, r8);	 Catch:{ all -> 0x014a }
        r8 = android.text.TextUtils.isEmpty(r7);	 Catch:{ all -> 0x014a }
        if (r8 != 0) goto L_0x00c9;
    L_0x00e1:
        r7 = java.lang.Integer.parseInt(r7);	 Catch:{ Exception -> 0x00c9 }
    L_0x00e5:
        if (r4 != 0) goto L_0x00f1;
    L_0x00e7:
        if (r6 <= 0) goto L_0x00eb;
    L_0x00e9:
        if (r7 > 0) goto L_0x00f1;
    L_0x00eb:
        r13 = 702; // 0x2be float:9.84E-43 double:3.47E-321;
        r5.setErrorCode(r13);	 Catch:{ all -> 0x014a }
        goto L_0x0114;	 Catch:{ all -> 0x014a }
    L_0x00f1:
        if (r7 < r6) goto L_0x00f9;	 Catch:{ all -> 0x014a }
    L_0x00f3:
        r13 = 703; // 0x2bf float:9.85E-43 double:3.473E-321;	 Catch:{ all -> 0x014a }
        r5.setErrorCode(r13);	 Catch:{ all -> 0x014a }
        goto L_0x0114;	 Catch:{ all -> 0x014a }
    L_0x00f9:
        r2 = r10.c;	 Catch:{ all -> 0x014a }
        r3 = r10.b;	 Catch:{ all -> 0x014a }
        com.tencent.smtt.sdk.u.a(r11, r2, r3, r4, r13);	 Catch:{ all -> 0x014a }
        r13 = 704; // 0x2c0 float:9.87E-43 double:3.48E-321;	 Catch:{ all -> 0x014a }
        r5.setErrorCode(r13);	 Catch:{ all -> 0x014a }
        r2 = java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x014a }
        r8 = r2 - r0;	 Catch:{ all -> 0x014a }
        r2 = r8;	 Catch:{ all -> 0x014a }
        goto L_0x0114;	 Catch:{ all -> 0x014a }
    L_0x010d:
        r13 = 701; // 0x2bd float:9.82E-43 double:3.463E-321;	 Catch:{ all -> 0x014a }
        r5.setErrorCode(r13);	 Catch:{ all -> 0x014a }
        r6 = r4;	 Catch:{ all -> 0x014a }
        r7 = r6;	 Catch:{ all -> 0x014a }
    L_0x0114:
        r13 = new java.lang.StringBuilder;	 Catch:{ all -> 0x014a }
        r0 = "x5->sys:";	 Catch:{ all -> 0x014a }
        r13.<init>(r0);	 Catch:{ all -> 0x014a }
        r13.append(r12);	 Catch:{ all -> 0x014a }
        r12 = " from:";	 Catch:{ all -> 0x014a }
        r13.append(r12);	 Catch:{ all -> 0x014a }
        r13.append(r6);	 Catch:{ all -> 0x014a }
        r12 = " to:";	 Catch:{ all -> 0x014a }
        r13.append(r12);	 Catch:{ all -> 0x014a }
        r13.append(r7);	 Catch:{ all -> 0x014a }
        r12 = ",timeused:";	 Catch:{ all -> 0x014a }
        r13.append(r12);	 Catch:{ all -> 0x014a }
        r13.append(r2);	 Catch:{ all -> 0x014a }
        r12 = r13.toString();	 Catch:{ all -> 0x014a }
        r5.setFailDetail(r12);	 Catch:{ all -> 0x014a }
        r11 = com.tencent.smtt.sdk.TbsLogReport.a(r11);	 Catch:{ all -> 0x014a }
        r12 = com.tencent.smtt.sdk.TbsLogReport.EventType.TYPE_COOKIE_DB_SWITCH;	 Catch:{ all -> 0x014a }
        r11.a(r12, r5);	 Catch:{ all -> 0x014a }
        monitor-exit(r10);
        return;
    L_0x0148:
        monitor-exit(r10);
        return;
    L_0x014a:
        r11 = move-exception;
        monitor-exit(r10);
        throw r11;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.CookieManager.a(android.content.Context, boolean, boolean):void");
    }

    public boolean acceptCookie() {
        bk b = bk.b();
        return (b == null || !b.c()) ? android.webkit.CookieManager.getInstance().acceptCookie() : b.d().d();
    }

    public synchronized boolean acceptThirdPartyCookies(WebView webView) {
        bk b = bk.b();
        Object invokeStaticMethod;
        if (b != null && b.c()) {
            invokeStaticMethod = b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptThirdPartyCookies", new Class[]{Object.class}, webView.getView());
            if (invokeStaticMethod == null) {
                return true;
            }
            return ((Boolean) invokeStaticMethod).booleanValue();
        } else if (VERSION.SDK_INT < 21) {
            return true;
        } else {
            invokeStaticMethod = v.a(android.webkit.CookieManager.getInstance(), "acceptThirdPartyCookies", new Class[]{WebView.class}, webView.getView());
            if (invokeStaticMethod == null) {
                return false;
            }
            return ((Boolean) invokeStaticMethod).booleanValue();
        }
    }

    public void flush() {
        bk b = bk.b();
        if (b != null && b.c()) {
            b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_flush", new Class[0], new Object[0]);
        } else if (VERSION.SDK_INT >= 21) {
            v.a(android.webkit.CookieManager.getInstance(), "flush", new Class[0], new Object[0]);
        }
    }

    public String getCookie(String str) {
        bk b = bk.b();
        if (b != null && b.c()) {
            return b.d().a(str);
        }
        try {
            return android.webkit.CookieManager.getInstance().getCookie(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public boolean hasCookies() {
        bk b = bk.b();
        return (b == null || !b.c()) ? android.webkit.CookieManager.getInstance().hasCookies() : b.d().h();
    }

    public void removeAllCookie() {
        if (this.a != null) {
            this.a.clear();
        }
        bk b = bk.b();
        if (b == null || !b.c()) {
            android.webkit.CookieManager.getInstance().removeAllCookie();
        } else {
            b.d().e();
        }
    }

    public void removeAllCookies(ValueCallback<Boolean> valueCallback) {
        if (this.a != null) {
            this.a.clear();
        }
        bk b = bk.b();
        if (b != null && b.c()) {
            b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookies", new Class[]{ValueCallback.class}, valueCallback);
        } else if (VERSION.SDK_INT >= 21) {
            v.a(android.webkit.CookieManager.getInstance(), "removeAllCookies", new Class[]{ValueCallback.class}, valueCallback);
        }
    }

    public void removeExpiredCookie() {
        bk b = bk.b();
        if (b == null || !b.c()) {
            android.webkit.CookieManager.getInstance().removeExpiredCookie();
        } else {
            b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeExpiredCookie", new Class[0], new Object[0]);
        }
    }

    public void removeSessionCookie() {
        bk b = bk.b();
        if (b == null || !b.c()) {
            android.webkit.CookieManager.getInstance().removeSessionCookie();
        } else {
            b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookie", new Class[0], new Object[0]);
        }
    }

    public void removeSessionCookies(ValueCallback<Boolean> valueCallback) {
        bk b = bk.b();
        if (b != null && b.c()) {
            b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeSessionCookies", new Class[]{ValueCallback.class}, valueCallback);
        } else if (VERSION.SDK_INT >= 21) {
            v.a(android.webkit.CookieManager.getInstance(), "removeSessionCookies", new Class[]{ValueCallback.class}, valueCallback);
        }
    }

    public synchronized void setAcceptCookie(boolean z) {
        bk b = bk.b();
        if (b == null || !b.c()) {
            try {
                android.webkit.CookieManager.getInstance().setAcceptCookie(z);
                return;
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptCookie", new Class[]{Boolean.TYPE}, Boolean.valueOf(z));
    }

    public synchronized void setAcceptThirdPartyCookies(WebView webView, boolean z) {
        bk b = bk.b();
        if (b != null && b.c()) {
            b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setAcceptThirdPartyCookies", new Class[]{Object.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z));
        } else if (VERSION.SDK_INT >= 21) {
            v.a(android.webkit.CookieManager.getInstance(), "setAcceptThirdPartyCookies", new Class[]{WebView.class, Boolean.TYPE}, webView.getView(), Boolean.valueOf(z));
        }
    }

    public synchronized void setCookie(String str, String str2) {
        setCookie(str, str2, false);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setCookie(java.lang.String r10, java.lang.String r11, com.tencent.smtt.sdk.ValueCallback<java.lang.Boolean> r12) {
        /*
        r9 = this;
        monitor-enter(r9);
        r0 = com.tencent.smtt.sdk.bk.b();	 Catch:{ all -> 0x008c }
        r1 = 2;
        r2 = 0;
        r3 = 3;
        r4 = 1;
        if (r0 == 0) goto L_0x0038;
    L_0x000b:
        r5 = r0.c();	 Catch:{ all -> 0x008c }
        if (r5 == 0) goto L_0x0038;
    L_0x0011:
        r0 = r0.d();	 Catch:{ all -> 0x008c }
        r0 = r0.b();	 Catch:{ all -> 0x008c }
        r5 = "com.tencent.tbs.tbsshell.WebCoreProxy";
        r6 = "cookieManager_setCookie";
        r7 = new java.lang.Class[r3];	 Catch:{ all -> 0x008c }
        r8 = java.lang.String.class;
        r7[r2] = r8;	 Catch:{ all -> 0x008c }
        r8 = java.lang.String.class;
        r7[r4] = r8;	 Catch:{ all -> 0x008c }
        r8 = android.webkit.ValueCallback.class;
        r7[r1] = r8;	 Catch:{ all -> 0x008c }
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x008c }
        r3[r2] = r10;	 Catch:{ all -> 0x008c }
        r3[r4] = r11;	 Catch:{ all -> 0x008c }
        r3[r1] = r12;	 Catch:{ all -> 0x008c }
        r0.invokeStaticMethod(r5, r6, r7, r3);	 Catch:{ all -> 0x008c }
        monitor-exit(r9);
        return;
    L_0x0038:
        r0 = com.tencent.smtt.sdk.bk.b();	 Catch:{ all -> 0x008c }
        r0 = r0.e();	 Catch:{ all -> 0x008c }
        if (r0 != 0) goto L_0x005f;
    L_0x0042:
        r0 = new com.tencent.smtt.sdk.CookieManager$b;	 Catch:{ all -> 0x008c }
        r0.<init>(r9);	 Catch:{ all -> 0x008c }
        r0.a = r4;	 Catch:{ all -> 0x008c }
        r0.b = r10;	 Catch:{ all -> 0x008c }
        r0.c = r11;	 Catch:{ all -> 0x008c }
        r0.d = r12;	 Catch:{ all -> 0x008c }
        r5 = r9.a;	 Catch:{ all -> 0x008c }
        if (r5 != 0) goto L_0x005a;
    L_0x0053:
        r5 = new java.util.ArrayList;	 Catch:{ all -> 0x008c }
        r5.<init>();	 Catch:{ all -> 0x008c }
        r9.a = r5;	 Catch:{ all -> 0x008c }
    L_0x005a:
        r5 = r9.a;	 Catch:{ all -> 0x008c }
        r5.add(r0);	 Catch:{ all -> 0x008c }
    L_0x005f:
        r0 = r9.f;	 Catch:{ all -> 0x008c }
        if (r0 == 0) goto L_0x008a;
    L_0x0063:
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ all -> 0x008c }
        r5 = 21;
        if (r0 >= r5) goto L_0x006b;
    L_0x0069:
        monitor-exit(r9);
        return;
    L_0x006b:
        r0 = android.webkit.CookieManager.getInstance();	 Catch:{ all -> 0x008c }
        r5 = "setCookie";
        r6 = new java.lang.Class[r3];	 Catch:{ all -> 0x008c }
        r7 = java.lang.String.class;
        r6[r2] = r7;	 Catch:{ all -> 0x008c }
        r7 = java.lang.String.class;
        r6[r4] = r7;	 Catch:{ all -> 0x008c }
        r7 = android.webkit.ValueCallback.class;
        r6[r1] = r7;	 Catch:{ all -> 0x008c }
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x008c }
        r3[r2] = r10;	 Catch:{ all -> 0x008c }
        r3[r4] = r11;	 Catch:{ all -> 0x008c }
        r3[r1] = r12;	 Catch:{ all -> 0x008c }
        com.tencent.smtt.utils.v.a(r0, r5, r6, r3);	 Catch:{ all -> 0x008c }
    L_0x008a:
        monitor-exit(r9);
        return;
    L_0x008c:
        r10 = move-exception;
        monitor-exit(r9);
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.CookieManager.setCookie(java.lang.String, java.lang.String, com.tencent.smtt.sdk.ValueCallback):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setCookie(java.lang.String r8, java.lang.String r9, boolean r10) {
        /*
        r7 = this;
        monitor-enter(r7);
        r0 = com.tencent.smtt.sdk.bk.b();	 Catch:{ all -> 0x0068 }
        r1 = 2;
        if (r0 == 0) goto L_0x0031;
    L_0x0008:
        r2 = r0.c();	 Catch:{ all -> 0x0068 }
        if (r2 == 0) goto L_0x0031;
    L_0x000e:
        r10 = r0.d();	 Catch:{ all -> 0x0068 }
        r10 = r10.b();	 Catch:{ all -> 0x0068 }
        r0 = "com.tencent.tbs.tbsshell.WebCoreProxy";
        r2 = "cookieManager_setCookie";
        r3 = new java.lang.Class[r1];	 Catch:{ all -> 0x0068 }
        r4 = java.lang.String.class;
        r5 = 0;
        r3[r5] = r4;	 Catch:{ all -> 0x0068 }
        r4 = java.lang.String.class;
        r6 = 1;
        r3[r6] = r4;	 Catch:{ all -> 0x0068 }
        r1 = new java.lang.Object[r1];	 Catch:{ all -> 0x0068 }
        r1[r5] = r8;	 Catch:{ all -> 0x0068 }
        r1[r6] = r9;	 Catch:{ all -> 0x0068 }
        r10.invokeStaticMethod(r0, r2, r3, r1);	 Catch:{ all -> 0x0068 }
        monitor-exit(r7);
        return;
    L_0x0031:
        r0 = r7.f;	 Catch:{ all -> 0x0068 }
        if (r0 != 0) goto L_0x0037;
    L_0x0035:
        if (r10 == 0) goto L_0x003e;
    L_0x0037:
        r10 = android.webkit.CookieManager.getInstance();	 Catch:{ all -> 0x0068 }
        r10.setCookie(r8, r9);	 Catch:{ all -> 0x0068 }
    L_0x003e:
        r10 = com.tencent.smtt.sdk.bk.b();	 Catch:{ all -> 0x0068 }
        r10 = r10.e();	 Catch:{ all -> 0x0068 }
        if (r10 != 0) goto L_0x0066;
    L_0x0048:
        r10 = new com.tencent.smtt.sdk.CookieManager$b;	 Catch:{ all -> 0x0068 }
        r10.<init>(r7);	 Catch:{ all -> 0x0068 }
        r10.a = r1;	 Catch:{ all -> 0x0068 }
        r10.b = r8;	 Catch:{ all -> 0x0068 }
        r10.c = r9;	 Catch:{ all -> 0x0068 }
        r8 = 0;
        r10.d = r8;	 Catch:{ all -> 0x0068 }
        r8 = r7.a;	 Catch:{ all -> 0x0068 }
        if (r8 != 0) goto L_0x0061;
    L_0x005a:
        r8 = new java.util.ArrayList;	 Catch:{ all -> 0x0068 }
        r8.<init>();	 Catch:{ all -> 0x0068 }
        r7.a = r8;	 Catch:{ all -> 0x0068 }
    L_0x0061:
        r8 = r7.a;	 Catch:{ all -> 0x0068 }
        r8.add(r10);	 Catch:{ all -> 0x0068 }
    L_0x0066:
        monitor-exit(r7);
        return;
    L_0x0068:
        r8 = move-exception;
        monitor-exit(r7);
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.CookieManager.setCookie(java.lang.String, java.lang.String, boolean):void");
    }

    public boolean setCookieCompatialbeMode(Context context, a aVar, String str, boolean z) {
        System.currentTimeMillis();
        if (context != null) {
            if (TbsExtensionFunctionManager.getInstance().canUseFunction(context, TbsExtensionFunctionManager.COOKIE_SWITCH_FILE_NAME)) {
                this.c = aVar;
                if (str != null) {
                    this.b = str;
                }
                if (!(this.c == a.MODE_NONE || !z || bk.b().e())) {
                    bk.b().a(context);
                }
                return true;
            }
        }
        return false;
    }

    public void setCookies(Map<String, String[]> map) {
        bk b = bk.b();
        boolean a = (b == null || !b.c()) ? false : b.d().a((Map) map);
        if (!a) {
            for (String str : map.keySet()) {
                for (String cookie : (String[]) map.get(str)) {
                    setCookie(str, cookie);
                }
            }
        }
    }
}
