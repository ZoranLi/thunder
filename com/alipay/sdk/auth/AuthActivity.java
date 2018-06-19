package com.alipay.sdk.auth;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.text.TextUtils;
import android.webkit.ConsoleMessage;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.sina.weibo.sdk.statistic.StatisticConfig;

@SuppressLint({"SetJavaScriptEnabled", "DefaultLocale"})
public class AuthActivity extends Activity {
    static final String a = "params";
    static final String b = "redirectUri";
    private WebView c;
    private String d;
    private com.alipay.sdk.widget.a e;
    private Handler f;
    private boolean g;
    private boolean h;
    private Runnable i = new d(this);

    private class a extends WebChromeClient {
        final /* synthetic */ AuthActivity a;

        private a(AuthActivity authActivity) {
            this.a = authActivity;
        }

        public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            String message = consoleMessage.message();
            if (TextUtils.isEmpty(message)) {
                return super.onConsoleMessage(consoleMessage);
            }
            Object obj = null;
            if (message.startsWith("h5container.message: ")) {
                obj = message.replaceFirst("h5container.message: ", "");
            }
            if (TextUtils.isEmpty(obj)) {
                return super.onConsoleMessage(consoleMessage);
            }
            AuthActivity.b(this.a, obj);
            return super.onConsoleMessage(consoleMessage);
        }
    }

    private class b extends WebViewClient {
        final /* synthetic */ AuthActivity a;

        private b(AuthActivity authActivity) {
            this.a = authActivity;
        }

        public final void onReceivedError(WebView webView, int i, String str, String str2) {
            this.a.h = true;
            super.onReceivedError(webView, i, str, str2);
        }

        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (this.a.g != null) {
                sslErrorHandler.proceed();
                this.a.g = null;
                return;
            }
            this.a.runOnUiThread(new e(this, sslErrorHandler));
        }

        public final boolean shouldOverrideUrlLoading(android.webkit.WebView r4, java.lang.String r5) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r3 = this;
            r0 = r5.toLowerCase();
            r1 = "alipays://platformapi/startApp?";
            r1 = r1.toLowerCase();
            r0 = r0.startsWith(r1);
            r1 = 1;
            if (r0 != 0) goto L_0x0033;
        L_0x0011:
            r0 = r5.toLowerCase();
            r2 = "intent://platformapi/startapp?";
            r2 = r2.toLowerCase();
            r0 = r0.startsWith(r2);
            if (r0 == 0) goto L_0x0022;
        L_0x0021:
            goto L_0x0033;
        L_0x0022:
            r0 = r3.a;
            r0 = com.alipay.sdk.auth.AuthActivity.a(r0, r5);
            if (r0 == 0) goto L_0x002e;
        L_0x002a:
            r4.stopLoading();
            return r1;
        L_0x002e:
            r4 = super.shouldOverrideUrlLoading(r4, r5);
            return r4;
        L_0x0033:
            r4 = r3.a;	 Catch:{ Throwable -> 0x0066 }
            r0 = "com.eg.android.AlipayGphone";	 Catch:{ Throwable -> 0x0066 }
            r4 = com.alipay.sdk.util.k.a(r4, r0);	 Catch:{ Throwable -> 0x0066 }
            if (r4 == 0) goto L_0x0065;	 Catch:{ Throwable -> 0x0066 }
        L_0x003d:
            r4 = r4.a();	 Catch:{ Throwable -> 0x0066 }
            if (r4 == 0) goto L_0x0044;	 Catch:{ Throwable -> 0x0066 }
        L_0x0043:
            goto L_0x0065;	 Catch:{ Throwable -> 0x0066 }
        L_0x0044:
            r4 = "intent://platformapi/startapp";	 Catch:{ Throwable -> 0x0066 }
            r4 = r5.startsWith(r4);	 Catch:{ Throwable -> 0x0066 }
            if (r4 == 0) goto L_0x0054;	 Catch:{ Throwable -> 0x0066 }
        L_0x004c:
            r4 = "intent://platformapi/startapp?";	 Catch:{ Throwable -> 0x0066 }
            r0 = "alipays://platformapi/startApp?";	 Catch:{ Throwable -> 0x0066 }
            r5 = r5.replaceFirst(r4, r0);	 Catch:{ Throwable -> 0x0066 }
        L_0x0054:
            r4 = new android.content.Intent;	 Catch:{ Throwable -> 0x0066 }
            r0 = "android.intent.action.VIEW";	 Catch:{ Throwable -> 0x0066 }
            r5 = android.net.Uri.parse(r5);	 Catch:{ Throwable -> 0x0066 }
            r4.<init>(r0, r5);	 Catch:{ Throwable -> 0x0066 }
            r5 = r3.a;	 Catch:{ Throwable -> 0x0066 }
            r5.startActivity(r4);	 Catch:{ Throwable -> 0x0066 }
            goto L_0x0066;
        L_0x0065:
            return r1;
        L_0x0066:
            return r1;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.auth.AuthActivity.b.shouldOverrideUrlLoading(android.webkit.WebView, java.lang.String):boolean");
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            AuthActivity.d(this.a);
            this.a.f.postDelayed(this.a.i, StatisticConfig.MIN_UPLOAD_INTERVAL);
            super.onPageStarted(webView, str, bitmap);
        }

        public final void onPageFinished(WebView webView, String str) {
            AuthActivity.g(this.a);
            this.a.f.removeCallbacks(this.a.i);
        }
    }

    static /* synthetic */ void a(com.alipay.sdk.auth.AuthActivity r3, com.alipay.sdk.authjs.a r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = r3.c;
        if (r0 == 0) goto L_0x0040;
    L_0x0004:
        if (r4 != 0) goto L_0x0007;
    L_0x0006:
        goto L_0x0040;
    L_0x0007:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0040 }
        r0.<init>();	 Catch:{ JSONException -> 0x0040 }
        r1 = "clientId";	 Catch:{ JSONException -> 0x0040 }
        r2 = r4.i;	 Catch:{ JSONException -> 0x0040 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0040 }
        r1 = "func";	 Catch:{ JSONException -> 0x0040 }
        r2 = r4.k;	 Catch:{ JSONException -> 0x0040 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0040 }
        r1 = "param";	 Catch:{ JSONException -> 0x0040 }
        r2 = r4.m;	 Catch:{ JSONException -> 0x0040 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0040 }
        r1 = "msgType";	 Catch:{ JSONException -> 0x0040 }
        r4 = r4.l;	 Catch:{ JSONException -> 0x0040 }
        r0.put(r1, r4);	 Catch:{ JSONException -> 0x0040 }
        r4 = r0.toString();	 Catch:{ JSONException -> 0x0040 }
        r0 = "AlipayJSBridge._invokeJS(%s)";	 Catch:{ JSONException -> 0x0040 }
        r1 = 1;	 Catch:{ JSONException -> 0x0040 }
        r1 = new java.lang.Object[r1];	 Catch:{ JSONException -> 0x0040 }
        r2 = 0;	 Catch:{ JSONException -> 0x0040 }
        r1[r2] = r4;	 Catch:{ JSONException -> 0x0040 }
        r4 = java.lang.String.format(r0, r1);	 Catch:{ JSONException -> 0x0040 }
        r0 = new com.alipay.sdk.auth.c;	 Catch:{ JSONException -> 0x0040 }
        r0.<init>(r3, r4);	 Catch:{ JSONException -> 0x0040 }
        r3.runOnUiThread(r0);	 Catch:{ JSONException -> 0x0040 }
    L_0x0040:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.auth.AuthActivity.a(com.alipay.sdk.auth.AuthActivity, com.alipay.sdk.authjs.a):void");
    }

    static /* synthetic */ boolean a(AuthActivity authActivity, String str) {
        if (!(TextUtils.isEmpty(str) || str.startsWith("http://"))) {
            if (!str.startsWith("https://")) {
                if (!"SDKLite://h5quit".equalsIgnoreCase(str)) {
                    if (TextUtils.equals(str, authActivity.d)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append("?resultCode=150");
                        str = stringBuilder.toString();
                    }
                    h.a((Activity) authActivity, str);
                }
                authActivity.finish();
                return true;
            }
        }
        return false;
    }

    static /* synthetic */ void b(com.alipay.sdk.auth.AuthActivity r5, java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = new com.alipay.sdk.authjs.c;
        r1 = r5.getApplicationContext();
        r2 = new com.alipay.sdk.auth.b;
        r2.<init>(r5);
        r0.<init>(r1, r2);
        r5 = 0;
        r1 = new org.json.JSONObject;	 Catch:{ Exception -> 0x004e }
        r1.<init>(r6);	 Catch:{ Exception -> 0x004e }
        r6 = "clientId";	 Catch:{ Exception -> 0x004e }
        r6 = r1.getString(r6);	 Catch:{ Exception -> 0x004e }
        r2 = android.text.TextUtils.isEmpty(r6);	 Catch:{ Exception -> 0x004d }
        if (r2 == 0) goto L_0x0021;	 Catch:{ Exception -> 0x004d }
    L_0x0020:
        return;	 Catch:{ Exception -> 0x004d }
    L_0x0021:
        r2 = "param";	 Catch:{ Exception -> 0x004d }
        r2 = r1.getJSONObject(r2);	 Catch:{ Exception -> 0x004d }
        r3 = r2 instanceof org.json.JSONObject;	 Catch:{ Exception -> 0x004d }
        if (r3 == 0) goto L_0x002e;	 Catch:{ Exception -> 0x004d }
    L_0x002b:
        r5 = r2;	 Catch:{ Exception -> 0x004d }
        r5 = (org.json.JSONObject) r5;	 Catch:{ Exception -> 0x004d }
    L_0x002e:
        r2 = "func";	 Catch:{ Exception -> 0x004d }
        r2 = r1.getString(r2);	 Catch:{ Exception -> 0x004d }
        r3 = "bundleName";	 Catch:{ Exception -> 0x004d }
        r1 = r1.getString(r3);	 Catch:{ Exception -> 0x004d }
        r3 = new com.alipay.sdk.authjs.a;	 Catch:{ Exception -> 0x004d }
        r4 = "call";	 Catch:{ Exception -> 0x004d }
        r3.<init>(r4);	 Catch:{ Exception -> 0x004d }
        r3.j = r1;	 Catch:{ Exception -> 0x004d }
        r3.k = r2;	 Catch:{ Exception -> 0x004d }
        r3.m = r5;	 Catch:{ Exception -> 0x004d }
        r3.i = r6;	 Catch:{ Exception -> 0x004d }
        r0.a(r3);	 Catch:{ Exception -> 0x004d }
        return;
    L_0x004d:
        r5 = r6;
    L_0x004e:
        r6 = android.text.TextUtils.isEmpty(r5);
        if (r6 != 0) goto L_0x0059;
    L_0x0054:
        r6 = com.alipay.sdk.authjs.a.a.d;	 Catch:{ JSONException -> 0x0059 }
        r0.a(r5, r6);	 Catch:{ JSONException -> 0x0059 }
    L_0x0059:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.auth.AuthActivity.b(com.alipay.sdk.auth.AuthActivity, java.lang.String):void");
    }

    static /* synthetic */ void d(com.alipay.sdk.auth.AuthActivity r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = r2.e;	 Catch:{ Exception -> 0x0013 }
        if (r0 != 0) goto L_0x000d;	 Catch:{ Exception -> 0x0013 }
    L_0x0004:
        r0 = new com.alipay.sdk.widget.a;	 Catch:{ Exception -> 0x0013 }
        r1 = "正在加载";	 Catch:{ Exception -> 0x0013 }
        r0.<init>(r2, r1);	 Catch:{ Exception -> 0x0013 }
        r2.e = r0;	 Catch:{ Exception -> 0x0013 }
    L_0x000d:
        r0 = r2.e;	 Catch:{ Exception -> 0x0013 }
        r0.a();	 Catch:{ Exception -> 0x0013 }
        return;
    L_0x0013:
        r0 = 0;
        r2.e = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.auth.AuthActivity.d(com.alipay.sdk.auth.AuthActivity):void");
    }

    static /* synthetic */ void g(AuthActivity authActivity) {
        if (authActivity.e != null) {
            authActivity.e.b();
        }
        authActivity.e = null;
    }

    protected void onCreate(android.os.Bundle r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r5 = this;
        super.onCreate(r6);
        r6 = r5.getIntent();	 Catch:{ Exception -> 0x0156 }
        r6 = r6.getExtras();	 Catch:{ Exception -> 0x0156 }
        if (r6 != 0) goto L_0x0011;
    L_0x000d:
        r5.finish();
        return;
    L_0x0011:
        r0 = "redirectUri";	 Catch:{ Exception -> 0x0152 }
        r0 = r6.getString(r0);	 Catch:{ Exception -> 0x0152 }
        r5.d = r0;	 Catch:{ Exception -> 0x0152 }
        r0 = "params";	 Catch:{ Exception -> 0x0152 }
        r6 = r6.getString(r0);	 Catch:{ Exception -> 0x0152 }
        r0 = com.alipay.sdk.util.k.b(r6);
        if (r0 != 0) goto L_0x0029;
    L_0x0025:
        r5.finish();
        return;
    L_0x0029:
        r0 = 1;
        super.requestWindowFeature(r0);
        r1 = new android.os.Handler;
        r2 = r5.getMainLooper();
        r1.<init>(r2);
        r5.f = r1;
        r1 = new android.widget.LinearLayout;
        r1.<init>(r5);
        r2 = new android.widget.LinearLayout$LayoutParams;
        r3 = -1;
        r2.<init>(r3, r3);
        r1.setOrientation(r0);
        r5.setContentView(r1, r2);
        r3 = new android.webkit.WebView;
        r3.<init>(r5);
        r5.c = r3;
        r3 = 1065353216; // 0x3f800000 float:1.0 double:5.263544247E-315;
        r2.weight = r3;
        r3 = r5.c;
        r4 = 0;
        r3.setVisibility(r4);
        r3 = r5.c;
        r1.addView(r3, r2);
        r1 = r5.c;
        r1 = r1.getSettings();
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = r1.getUserAgentString();
        r2.append(r3);
        r3 = r5.getApplicationContext();
        r3 = com.alipay.sdk.util.k.d(r3);
        r2.append(r3);
        r2 = r2.toString();
        r1.setUserAgentString(r2);
        r2 = android.webkit.WebSettings.RenderPriority.HIGH;
        r1.setRenderPriority(r2);
        r1.setSupportMultipleWindows(r0);
        r1.setJavaScriptEnabled(r0);
        r1.setSavePassword(r4);
        r1.setJavaScriptCanOpenWindowsAutomatically(r0);
        r2 = r1.getMinimumFontSize();
        r2 = r2 + 8;
        r1.setMinimumFontSize(r2);
        r1.setAllowFileAccess(r4);
        r2 = android.webkit.WebSettings.TextSize.NORMAL;
        r1.setTextSize(r2);
        r1 = r5.c;
        r1.setVerticalScrollbarOverlay(r0);
        r1 = r5.c;
        r2 = new com.alipay.sdk.auth.AuthActivity$b;
        r2.<init>();
        r1.setWebViewClient(r2);
        r1 = r5.c;
        r2 = new com.alipay.sdk.auth.AuthActivity$a;
        r2.<init>();
        r1.setWebChromeClient(r2);
        r1 = r5.c;
        r2 = new com.alipay.sdk.auth.a;
        r2.<init>(r5);
        r1.setDownloadListener(r2);
        r1 = r5.c;
        r1.loadUrl(r6);
        r6 = android.os.Build.VERSION.SDK_INT;
        r1 = 7;
        if (r6 < r1) goto L_0x00fb;
    L_0x00d2:
        r6 = r5.c;	 Catch:{ Exception -> 0x00fb }
        r6 = r6.getSettings();	 Catch:{ Exception -> 0x00fb }
        r6 = r6.getClass();	 Catch:{ Exception -> 0x00fb }
        r1 = "setDomStorageEnabled";	 Catch:{ Exception -> 0x00fb }
        r2 = new java.lang.Class[r0];	 Catch:{ Exception -> 0x00fb }
        r3 = java.lang.Boolean.TYPE;	 Catch:{ Exception -> 0x00fb }
        r2[r4] = r3;	 Catch:{ Exception -> 0x00fb }
        r6 = r6.getMethod(r1, r2);	 Catch:{ Exception -> 0x00fb }
        if (r6 == 0) goto L_0x00fb;	 Catch:{ Exception -> 0x00fb }
    L_0x00ea:
        r1 = r5.c;	 Catch:{ Exception -> 0x00fb }
        r1 = r1.getSettings();	 Catch:{ Exception -> 0x00fb }
        r2 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x00fb }
        r3 = java.lang.Boolean.valueOf(r0);	 Catch:{ Exception -> 0x00fb }
        r2[r4] = r3;	 Catch:{ Exception -> 0x00fb }
        r6.invoke(r1, r2);	 Catch:{ Exception -> 0x00fb }
    L_0x00fb:
        r6 = r5.c;	 Catch:{ Throwable -> 0x0111 }
        r1 = "searchBoxJavaBridge_";	 Catch:{ Throwable -> 0x0111 }
        r6.removeJavascriptInterface(r1);	 Catch:{ Throwable -> 0x0111 }
        r6 = r5.c;	 Catch:{ Throwable -> 0x0111 }
        r1 = "accessibility";	 Catch:{ Throwable -> 0x0111 }
        r6.removeJavascriptInterface(r1);	 Catch:{ Throwable -> 0x0111 }
        r6 = r5.c;	 Catch:{ Throwable -> 0x0111 }
        r1 = "accessibilityTraversal";	 Catch:{ Throwable -> 0x0111 }
        r6.removeJavascriptInterface(r1);	 Catch:{ Throwable -> 0x0111 }
        goto L_0x0142;
    L_0x0111:
        r6 = r5.c;	 Catch:{ Throwable -> 0x0142 }
        r6 = r6.getClass();	 Catch:{ Throwable -> 0x0142 }
        r1 = "removeJavascriptInterface";	 Catch:{ Throwable -> 0x0142 }
        r2 = new java.lang.Class[r4];	 Catch:{ Throwable -> 0x0142 }
        r6 = r6.getMethod(r1, r2);	 Catch:{ Throwable -> 0x0142 }
        if (r6 == 0) goto L_0x0142;	 Catch:{ Throwable -> 0x0142 }
    L_0x0121:
        r1 = r5.c;	 Catch:{ Throwable -> 0x0142 }
        r2 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x0142 }
        r3 = "searchBoxJavaBridge_";	 Catch:{ Throwable -> 0x0142 }
        r2[r4] = r3;	 Catch:{ Throwable -> 0x0142 }
        r6.invoke(r1, r2);	 Catch:{ Throwable -> 0x0142 }
        r1 = r5.c;	 Catch:{ Throwable -> 0x0142 }
        r2 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x0142 }
        r3 = "accessibility";	 Catch:{ Throwable -> 0x0142 }
        r2[r4] = r3;	 Catch:{ Throwable -> 0x0142 }
        r6.invoke(r1, r2);	 Catch:{ Throwable -> 0x0142 }
        r1 = r5.c;	 Catch:{ Throwable -> 0x0142 }
        r2 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x0142 }
        r3 = "accessibilityTraversal";	 Catch:{ Throwable -> 0x0142 }
        r2[r4] = r3;	 Catch:{ Throwable -> 0x0142 }
        r6.invoke(r1, r2);	 Catch:{ Throwable -> 0x0142 }
    L_0x0142:
        r6 = android.os.Build.VERSION.SDK_INT;
        r1 = 19;
        if (r6 < r1) goto L_0x0151;
    L_0x0148:
        r6 = r5.c;
        r6 = r6.getSettings();
        r6.setCacheMode(r0);
    L_0x0151:
        return;
    L_0x0152:
        r5.finish();
        return;
    L_0x0156:
        r5.finish();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.auth.AuthActivity.onCreate(android.os.Bundle):void");
    }

    public void onBackPressed() {
        StringBuilder stringBuilder;
        if (!this.c.canGoBack()) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.d);
            stringBuilder.append("?resultCode=150");
            h.a((Activity) this, stringBuilder.toString());
            finish();
        } else if (this.h) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(this.d);
            stringBuilder.append("?resultCode=150");
            h.a((Activity) this, stringBuilder.toString());
            finish();
        }
    }

    private boolean a(String str) {
        if (!(TextUtils.isEmpty(str) || str.startsWith("http://"))) {
            if (!str.startsWith("https://")) {
                if (!"SDKLite://h5quit".equalsIgnoreCase(str)) {
                    if (TextUtils.equals(str, this.d)) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(str);
                        stringBuilder.append("?resultCode=150");
                        str = stringBuilder.toString();
                    }
                    h.a((Activity) this, str);
                }
                finish();
                return true;
            }
        }
        return false;
    }

    private void b(java.lang.String r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r6 = this;
        r0 = new com.alipay.sdk.authjs.c;
        r1 = r6.getApplicationContext();
        r2 = new com.alipay.sdk.auth.b;
        r2.<init>(r6);
        r0.<init>(r1, r2);
        r1 = 0;
        r2 = new org.json.JSONObject;	 Catch:{ Exception -> 0x004d }
        r2.<init>(r7);	 Catch:{ Exception -> 0x004d }
        r7 = "clientId";	 Catch:{ Exception -> 0x004d }
        r7 = r2.getString(r7);	 Catch:{ Exception -> 0x004d }
        r3 = android.text.TextUtils.isEmpty(r7);	 Catch:{ Exception -> 0x004e }
        if (r3 == 0) goto L_0x0021;	 Catch:{ Exception -> 0x004e }
    L_0x0020:
        return;	 Catch:{ Exception -> 0x004e }
    L_0x0021:
        r3 = "param";	 Catch:{ Exception -> 0x004e }
        r3 = r2.getJSONObject(r3);	 Catch:{ Exception -> 0x004e }
        r4 = r3 instanceof org.json.JSONObject;	 Catch:{ Exception -> 0x004e }
        if (r4 == 0) goto L_0x002e;	 Catch:{ Exception -> 0x004e }
    L_0x002b:
        r1 = r3;	 Catch:{ Exception -> 0x004e }
        r1 = (org.json.JSONObject) r1;	 Catch:{ Exception -> 0x004e }
    L_0x002e:
        r3 = "func";	 Catch:{ Exception -> 0x004e }
        r3 = r2.getString(r3);	 Catch:{ Exception -> 0x004e }
        r4 = "bundleName";	 Catch:{ Exception -> 0x004e }
        r2 = r2.getString(r4);	 Catch:{ Exception -> 0x004e }
        r4 = new com.alipay.sdk.authjs.a;	 Catch:{ Exception -> 0x004e }
        r5 = "call";	 Catch:{ Exception -> 0x004e }
        r4.<init>(r5);	 Catch:{ Exception -> 0x004e }
        r4.j = r2;	 Catch:{ Exception -> 0x004e }
        r4.k = r3;	 Catch:{ Exception -> 0x004e }
        r4.m = r1;	 Catch:{ Exception -> 0x004e }
        r4.i = r7;	 Catch:{ Exception -> 0x004e }
        r0.a(r4);	 Catch:{ Exception -> 0x004e }
        return;
    L_0x004d:
        r7 = r1;
    L_0x004e:
        r1 = android.text.TextUtils.isEmpty(r7);
        if (r1 != 0) goto L_0x005a;
    L_0x0054:
        r1 = com.alipay.sdk.authjs.a.a.d;	 Catch:{ JSONException -> 0x005a }
        r0.a(r7, r1);	 Catch:{ JSONException -> 0x005a }
        return;
    L_0x005a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.auth.AuthActivity.b(java.lang.String):void");
    }

    private void a(com.alipay.sdk.authjs.a r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r3 = this;
        r0 = r3.c;
        if (r0 == 0) goto L_0x0042;
    L_0x0004:
        if (r4 != 0) goto L_0x0007;
    L_0x0006:
        goto L_0x0042;
    L_0x0007:
        r0 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0041 }
        r0.<init>();	 Catch:{ JSONException -> 0x0041 }
        r1 = "clientId";	 Catch:{ JSONException -> 0x0041 }
        r2 = r4.i;	 Catch:{ JSONException -> 0x0041 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0041 }
        r1 = "func";	 Catch:{ JSONException -> 0x0041 }
        r2 = r4.k;	 Catch:{ JSONException -> 0x0041 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0041 }
        r1 = "param";	 Catch:{ JSONException -> 0x0041 }
        r2 = r4.m;	 Catch:{ JSONException -> 0x0041 }
        r0.put(r1, r2);	 Catch:{ JSONException -> 0x0041 }
        r1 = "msgType";	 Catch:{ JSONException -> 0x0041 }
        r4 = r4.l;	 Catch:{ JSONException -> 0x0041 }
        r0.put(r1, r4);	 Catch:{ JSONException -> 0x0041 }
        r4 = r0.toString();	 Catch:{ JSONException -> 0x0041 }
        r0 = "AlipayJSBridge._invokeJS(%s)";	 Catch:{ JSONException -> 0x0041 }
        r1 = 1;	 Catch:{ JSONException -> 0x0041 }
        r1 = new java.lang.Object[r1];	 Catch:{ JSONException -> 0x0041 }
        r2 = 0;	 Catch:{ JSONException -> 0x0041 }
        r1[r2] = r4;	 Catch:{ JSONException -> 0x0041 }
        r4 = java.lang.String.format(r0, r1);	 Catch:{ JSONException -> 0x0041 }
        r0 = new com.alipay.sdk.auth.c;	 Catch:{ JSONException -> 0x0041 }
        r0.<init>(r3, r4);	 Catch:{ JSONException -> 0x0041 }
        r3.runOnUiThread(r0);	 Catch:{ JSONException -> 0x0041 }
        return;
    L_0x0041:
        return;
    L_0x0042:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.auth.AuthActivity.a(com.alipay.sdk.authjs.a):void");
    }

    private void a() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r0 = r2.e;	 Catch:{ Exception -> 0x0013 }
        if (r0 != 0) goto L_0x000d;	 Catch:{ Exception -> 0x0013 }
    L_0x0004:
        r0 = new com.alipay.sdk.widget.a;	 Catch:{ Exception -> 0x0013 }
        r1 = "正在加载";	 Catch:{ Exception -> 0x0013 }
        r0.<init>(r2, r1);	 Catch:{ Exception -> 0x0013 }
        r2.e = r0;	 Catch:{ Exception -> 0x0013 }
    L_0x000d:
        r0 = r2.e;	 Catch:{ Exception -> 0x0013 }
        r0.a();	 Catch:{ Exception -> 0x0013 }
        return;
    L_0x0013:
        r0 = 0;
        r2.e = r0;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.auth.AuthActivity.a():void");
    }

    private void b() {
        if (this.e != null) {
            this.e.b();
        }
        this.e = null;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    protected void onDestroy() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = this;
        super.onDestroy();
        r0 = r1.c;
        if (r0 == 0) goto L_0x0014;
    L_0x0007:
        r0 = r1.c;
        r0.removeAllViews();
        r0 = r1.c;	 Catch:{ Throwable -> 0x0011 }
        r0.destroy();	 Catch:{ Throwable -> 0x0011 }
    L_0x0011:
        r0 = 0;
        r1.c = r0;
    L_0x0014:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.auth.AuthActivity.onDestroy():void");
    }
}
