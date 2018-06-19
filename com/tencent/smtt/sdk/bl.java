package com.tencent.smtt.sdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.ValueCallback;
import anet.channel.util.ErrorConstant;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewClientExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebChromeClient;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.interfaces.IconListener;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Map;

class bl {
    private DexLoader a;

    public bl(DexLoader dexLoader) {
        this.a = dexLoader;
    }

    public int a(Context context, String str, Map<String, String> map, String str2, ValueCallback<String> valueCallback) {
        if (TbsDownloader.getOverSea(context)) {
            return -103;
        }
        if (str2 == null) {
            Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class, Map.class, ValueCallback.class}, context, str, map, valueCallback);
            if (invokeStaticMethod == null) {
                invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class, Map.class}, context, str, map);
            }
            if (invokeStaticMethod == null) {
                invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class}, context, str);
            }
            return invokeStaticMethod == null ? ErrorConstant.ERROR_ACCS_AUTH_PARAM_INVALID : ((Integer) invokeStaticMethod).intValue();
        } else {
            Object invokeStaticMethod2 = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "startMiniQB", new Class[]{Context.class, String.class, String.class}, context, str, str2);
            return invokeStaticMethod2 == null ? ErrorConstant.ERROR_ACCS_AUTH_PARAM_INVALID : ((Integer) invokeStaticMethod2).intValue();
        }
    }

    public IX5WebViewBase a(Context context) {
        IX5WebViewBase iX5WebViewBase;
        Exception e;
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createSDKWebview", new Class[]{Context.class}, context);
        if (invokeStaticMethod == null) {
            try {
                Object invokeStaticMethod2 = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.TBSShell", "getLoadFailureDetails", new Class[0], new Object[0]);
                if (invokeStaticMethod2 != null && (invokeStaticMethod2 instanceof Throwable)) {
                    TbsCoreLoadStat.getInstance().a(context, 325, (Throwable) invokeStaticMethod2);
                }
                if (invokeStaticMethod2 != null && (invokeStaticMethod2 instanceof String)) {
                    TbsCoreLoadStat.getInstance().a(context, 325, new Throwable((String) invokeStaticMethod2));
                }
                invokeStaticMethod = null;
                iX5WebViewBase = invokeStaticMethod;
            } catch (Exception e2) {
                e = e2;
                iX5WebViewBase = null;
                e.printStackTrace();
                return invokeStaticMethod == null ? iX5WebViewBase : null;
            }
        } else {
            iX5WebViewBase = (IX5WebViewBase) invokeStaticMethod;
            if (iX5WebViewBase != null) {
                try {
                    if (iX5WebViewBase.getView() == null) {
                        TbsCoreLoadStat.getInstance().a(context, 325, new Throwable("x5webview.getView is null!"));
                        invokeStaticMethod = null;
                    }
                } catch (Exception e3) {
                    e = e3;
                    e.printStackTrace();
                    if (invokeStaticMethod == null) {
                    }
                }
            }
        }
        if (invokeStaticMethod == null) {
        }
    }

    public InputStream a(String str, boolean z) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCacheFile", new Class[]{String.class, Boolean.TYPE}, str, Boolean.valueOf(z));
        return invokeStaticMethod == null ? null : (InputStream) invokeStaticMethod;
    }

    public String a(String str) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCookie", new Class[]{String.class}, str);
        return invokeStaticMethod == null ? null : (String) invokeStaticMethod;
    }

    public void a(android.content.Context r11, boolean r12) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r10 = this;
        r0 = "desktop";
        r1 = " tbsWizard clearAllX5Cache";
        com.tencent.smtt.utils.TbsLog.w(r0, r1);
        r0 = 1;
        r1 = 0;
        if (r12 == 0) goto L_0x001f;
    L_0x000b:
        r12 = r10.a;
        r2 = "com.tencent.tbs.tbsshell.WebCoreProxy";
        r3 = "clearAllCache";
        r4 = new java.lang.Class[r0];
        r5 = android.content.Context.class;
        r4[r1] = r5;
        r0 = new java.lang.Object[r0];
        r0[r1] = r11;
        r12.invokeStaticMethod(r2, r3, r4, r0);
        return;
    L_0x001f:
        r2 = r10.a;	 Catch:{ Exception -> 0x003e }
        r3 = "com.tencent.tbs.tbsshell.WebCoreProxy";	 Catch:{ Exception -> 0x003e }
        r4 = "clearAllCache";	 Catch:{ Exception -> 0x003e }
        r5 = 2;	 Catch:{ Exception -> 0x003e }
        r6 = new java.lang.Class[r5];	 Catch:{ Exception -> 0x003e }
        r7 = android.content.Context.class;	 Catch:{ Exception -> 0x003e }
        r6[r1] = r7;	 Catch:{ Exception -> 0x003e }
        r7 = java.lang.Boolean.TYPE;	 Catch:{ Exception -> 0x003e }
        r6[r0] = r7;	 Catch:{ Exception -> 0x003e }
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x003e }
        r5[r1] = r11;	 Catch:{ Exception -> 0x003e }
        r12 = java.lang.Boolean.valueOf(r12);	 Catch:{ Exception -> 0x003e }
        r5[r0] = r12;	 Catch:{ Exception -> 0x003e }
        r2.invokeStaticMethod(r3, r4, r6, r5);	 Catch:{ Exception -> 0x003e }
        return;
    L_0x003e:
        r12 = r10.a;
        r2 = "com.tencent.tbs.tbsshell.WebCoreProxy";
        r3 = "webViewDatabaseClearUsernamePassword";
        r4 = new java.lang.Class[r0];
        r5 = android.content.Context.class;
        r4[r1] = r5;
        r5 = new java.lang.Object[r0];
        r5[r1] = r11;
        r12.invokeStaticMethod(r2, r3, r4, r5);
        r12 = r10.a;
        r2 = "com.tencent.tbs.tbsshell.WebCoreProxy";
        r3 = "webViewDatabaseClearHttpAuthUsernamePassword";
        r4 = new java.lang.Class[r0];
        r5 = android.content.Context.class;
        r4[r1] = r5;
        r5 = new java.lang.Object[r0];
        r5[r1] = r11;
        r12.invokeStaticMethod(r2, r3, r4, r5);
        r12 = r10.a;
        r2 = "com.tencent.tbs.tbsshell.WebCoreProxy";
        r3 = "webViewDatabaseClearFormData";
        r4 = new java.lang.Class[r0];
        r5 = android.content.Context.class;
        r4[r1] = r5;
        r0 = new java.lang.Object[r0];
        r0[r1] = r11;
        r12.invokeStaticMethod(r2, r3, r4, r0);
        r11 = r10.a;
        r12 = "com.tencent.smtt.webkit.CacheManager";
        r0 = "removeAllCacheFiles";
        r2 = new java.lang.Object[r1];
        r3 = 0;
        r11.invokeStaticMethod(r12, r0, r3, r2);
        r11 = r10.a;
        r12 = "com.tencent.smtt.webkit.CacheManager";
        r0 = "clearLocalStorage";
        r2 = new java.lang.Object[r1];
        r11.invokeStaticMethod(r12, r0, r3, r2);
        r11 = r10.a;
        r12 = "com.tencent.smtt.net.http.DnsManager";
        r0 = "getInstance";
        r2 = new java.lang.Object[r1];
        r5 = r11.invokeStaticMethod(r12, r0, r3, r2);
        if (r5 == 0) goto L_0x00a8;
    L_0x009c:
        r4 = r10.a;
        r6 = "com.tencent.smtt.net.http.DnsManager";
        r7 = "removeAllDns";
        r8 = 0;
        r9 = new java.lang.Object[r1];
        r4.invokeMethod(r5, r6, r7, r8, r9);
    L_0x00a8:
        r11 = r10.a;
        r12 = "com.tencent.smtt.webkit.SmttPermanentPermissions";
        r0 = "getInstance";
        r2 = new java.lang.Object[r1];
        r5 = r11.invokeStaticMethod(r12, r0, r3, r2);
        if (r5 == 0) goto L_0x00c2;
    L_0x00b6:
        r4 = r10.a;
        r6 = "com.tencent.smtt.webkit.SmttPermanentPermissions";
        r7 = "clearAllPermanentPermission";
        r8 = 0;
        r9 = new java.lang.Object[r1];
        r4.invokeMethod(r5, r6, r7, r8, r9);
    L_0x00c2:
        r11 = r10.a;
        r12 = "com.tencent.tbs.tbsshell.WebCoreProxy";
        r0 = "removeAllIcons";
        r1 = new java.lang.Object[r1];
        r11.invokeStaticMethod(r12, r0, r3, r1);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.bl.a(android.content.Context, boolean):void");
    }

    public void a(ValueCallback<Map> valueCallback) {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetOrigins", new Class[]{ValueCallback.class}, valueCallback);
    }

    public void a(String str, long j) {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageSetQuotaForOrigin", new Class[]{String.class, Long.TYPE}, str, Long.valueOf(j));
    }

    public void a(String str, ValueCallback<Long> valueCallback) {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetUsageForOrigin", new Class[]{String.class, ValueCallback.class}, str, valueCallback);
    }

    public void a(String str, IconListener iconListener) {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "requestIconForPageUrl", new Class[]{String.class, IconListener.class}, str, iconListener);
    }

    public boolean a() {
        Method method = this.a.getClassLoader().loadClass("com.tencent.tbs.tbsshell.WebCoreProxy").getMethod("canUseX5", new Class[0]);
        method.setAccessible(true);
        Object invoke = method.invoke(null, new Object[0]);
        return invoke instanceof Boolean ? ((Boolean) invoke).booleanValue() : ((Boolean) invoke).booleanValue();
    }

    public boolean a(Context context, String str) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "canOpenFile", new Class[]{Context.class, String.class}, context, str);
        return invokeStaticMethod instanceof Boolean ? ((Boolean) invokeStaticMethod).booleanValue() : false;
    }

    public boolean a(Map<String, String[]> map) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_setCookies", new Class[]{Map.class}, map);
        return invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
    }

    public Uri[] a(int i, Intent intent) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "parseFileChooserResult", new Class[]{Integer.TYPE, Intent.class}, Integer.valueOf(i), intent);
        return invokeStaticMethod == null ? null : (Uri[]) invokeStaticMethod;
    }

    public DexLoader b() {
        return this.a;
    }

    public void b(String str) {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "openIconDB", new Class[]{String.class}, str);
    }

    public void b(String str, ValueCallback<Long> valueCallback) {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageGetQuotaForOrigin", new Class[]{String.class, ValueCallback.class}, str, valueCallback);
    }

    public boolean b(Context context) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasUsernamePassword", new Class[]{Context.class}, context);
        return invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
    }

    public Object c() {
        return this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cacheDisabled", new Class[0], new Object[0]);
    }

    public void c(Context context) {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearUsernamePassword", new Class[]{Context.class}, context);
    }

    public void c(String str) {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "retainIconForPageUrl", new Class[]{String.class}, str);
    }

    public void d(String str) {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "releaseIconForPageUrl", new Class[]{String.class}, str);
    }

    public boolean d() {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_acceptCookie", new Class[0], new Object[0]);
        return invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
    }

    public boolean d(Context context) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasHttpAuthUsernamePassword", new Class[]{Context.class}, context);
        return invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
    }

    public void e() {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_removeAllCookie", new Class[0], new Object[0]);
    }

    public void e(Context context) {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearHttpAuthUsernamePassword", new Class[]{Context.class}, context);
    }

    public void e(String str) {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteOrigin", new Class[]{String.class}, str);
    }

    public String f() {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getMiniQBVersion", new Class[0], new Object[0]);
        return invokeStaticMethod == null ? null : (String) invokeStaticMethod;
    }

    public boolean f(Context context) {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseHasFormData", new Class[]{Context.class}, context);
        return invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
    }

    public Object g() {
        return this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getCachFileBaseDir", new Class[0], new Object[0]);
    }

    public void g(Context context) {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webViewDatabaseClearFormData", new Class[]{Context.class}, context);
    }

    public boolean h() {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "cookieManager_hasCookies", new Class[0], new Object[0]);
        return invokeStaticMethod == null ? false : ((Boolean) invokeStaticMethod).booleanValue();
    }

    public IX5WebChromeClient i() {
        if (this.a == null) {
            return null;
        }
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClient", new Class[0], new Object[0]);
        return invokeStaticMethod == null ? null : (IX5WebChromeClient) invokeStaticMethod;
    }

    public IX5WebViewClient j() {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebViewClient", new Class[0], new Object[0]);
        return invokeStaticMethod == null ? null : (IX5WebViewClient) invokeStaticMethod;
    }

    public IX5WebViewClientExtension k() {
        Object invokeStaticMethod = this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createDefaultX5WebChromeClientExtension", new Class[0], new Object[0]);
        return invokeStaticMethod == null ? null : (IX5WebViewClientExtension) invokeStaticMethod;
    }

    public void l() {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "removeAllIcons", null, new Object[0]);
    }

    public void m() {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeIconDB", null, new Object[0]);
    }

    public void n() {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "webStorageDeleteAllData", null, new Object[0]);
    }

    public void o() {
        this.a.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "closeFileReader", new Class[0], new Object[0]);
    }
}
