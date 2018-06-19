package com.tencent.smtt.sdk;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Message;
import android.view.KeyEvent;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase;
import com.tencent.smtt.export.external.interfaces.IX5WebViewClient;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.export.external.proxy.X5ProxyWebViewClient;

class s extends X5ProxyWebViewClient {
    private static String c;
    private WebViewClient a;
    private WebView b;

    public s(IX5WebViewClient iX5WebViewClient, WebView webView, WebViewClient webViewClient) {
        super(iX5WebViewClient);
        this.b = webView;
        this.a = webViewClient;
    }

    public void a(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(this.b.b(), 0, 0, str, bitmap);
    }

    public void a(String str) {
        Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(str));
        intent.addFlags(268435456);
        try {
            if (this.b.getContext() != null) {
                this.b.getContext().startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void countPVContentCacheCallBack(String str) {
        WebView webView = this.b;
        webView.a++;
    }

    public void doUpdateVisitedHistory(IX5WebViewBase iX5WebViewBase, String str, boolean z) {
        this.b.a(iX5WebViewBase);
        this.a.doUpdateVisitedHistory(this.b, str, z);
    }

    public void onDetectedBlankScreen(IX5WebViewBase iX5WebViewBase, String str, int i) {
        this.b.a(iX5WebViewBase);
        this.a.onDetectedBlankScreen(str, i);
    }

    public void onFormResubmission(IX5WebViewBase iX5WebViewBase, Message message, Message message2) {
        this.b.a(iX5WebViewBase);
        this.a.onFormResubmission(this.b, message, message2);
    }

    public void onLoadResource(IX5WebViewBase iX5WebViewBase, String str) {
        this.b.a(iX5WebViewBase);
        this.a.onLoadResource(this.b, str);
    }

    public void onPageFinished(com.tencent.smtt.export.external.interfaces.IX5WebViewBase r4, int r5, int r6, java.lang.String r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r3 = this;
        r0 = c;
        if (r0 != 0) goto L_0x0014;
    L_0x0004:
        r0 = com.tencent.smtt.utils.y.a();
        if (r0 == 0) goto L_0x0014;
    L_0x000a:
        r1 = 0;
        r0.a(r1);
        r0 = java.lang.Boolean.toString(r1);
        c = r0;
    L_0x0014:
        r0 = r3.b;
        r0.a(r4);
        r0 = r3.b;
        r1 = r0.a;
        r2 = 1;
        r1 = r1 + r2;
        r0.a = r1;
        r0 = r3.a;
        r1 = r3.b;
        r0.onPageFinished(r1, r7);
        r0 = "com.qzone";
        r1 = r4.getView();
        r1 = r1.getContext();
        r1 = r1.getApplicationInfo();
        r1 = r1.packageName;
        r0 = r0.equals(r1);
        if (r0 == 0) goto L_0x004b;
    L_0x003e:
        r0 = r3.b;
        r1 = r4.getView();
        r1 = r1.getContext();
        r0.a(r1);
    L_0x004b:
        r0 = "SmttWebViewClient";
        r1 = r4.getView();
        r1 = r1.getContext();
        com.tencent.smtt.utils.TbsLog.app_extra(r0, r1);
        super.onPageFinished(r4, r5, r6, r7);	 Catch:{ Exception -> 0x005b }
    L_0x005b:
        com.tencent.smtt.sdk.WebView.c();
        r4 = com.tencent.smtt.sdk.TbsShareManager.mHasQueryed;
        if (r4 != 0) goto L_0x0085;
    L_0x0062:
        r4 = r3.b;
        r4 = r4.getContext();
        if (r4 == 0) goto L_0x0085;
    L_0x006a:
        r4 = r3.b;
        r4 = r4.getContext();
        r4 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r4);
        if (r4 == 0) goto L_0x0085;
    L_0x0076:
        com.tencent.smtt.sdk.TbsShareManager.mHasQueryed = r2;
        r4 = new java.lang.Thread;
        r5 = new com.tencent.smtt.sdk.t;
        r5.<init>(r3);
        r4.<init>(r5);
        r4.start();
    L_0x0085:
        r4 = r3.b;
        r4 = r4.getContext();
        if (r4 == 0) goto L_0x00b7;
    L_0x008d:
        r4 = r3.b;
        r4 = r4.getContext();
        r4 = com.tencent.smtt.sdk.TbsLogReport.a(r4);
        r4 = r4.e();
        if (r4 != 0) goto L_0x00b7;
    L_0x009d:
        r4 = r3.b;
        r4 = r4.getContext();
        r4 = com.tencent.smtt.sdk.TbsLogReport.a(r4);
        r4.a(r2);
        r4 = r3.b;
        r4 = r4.getContext();
        r4 = com.tencent.smtt.sdk.TbsLogReport.a(r4);
        r4.b();
    L_0x00b7:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.s.onPageFinished(com.tencent.smtt.export.external.interfaces.IX5WebViewBase, int, int, java.lang.String):void");
    }

    public void onPageFinished(IX5WebViewBase iX5WebViewBase, String str) {
        onPageFinished(iX5WebViewBase, 0, 0, str);
    }

    public void onPageStarted(IX5WebViewBase iX5WebViewBase, int i, int i2, String str, Bitmap bitmap) {
        this.b.a(iX5WebViewBase);
        this.a.onPageStarted(this.b, str, bitmap);
    }

    public void onPageStarted(IX5WebViewBase iX5WebViewBase, String str, Bitmap bitmap) {
        onPageStarted(iX5WebViewBase, 0, 0, str, bitmap);
    }

    public void onReceivedClientCertRequest(IX5WebViewBase iX5WebViewBase, ClientCertRequest clientCertRequest) {
        this.b.a(iX5WebViewBase);
        this.a.onReceivedClientCertRequest(this.b, clientCertRequest);
    }

    public void onReceivedError(IX5WebViewBase iX5WebViewBase, int i, String str, String str2) {
        if (i < -15) {
            if (i == -17) {
                i = -1;
            } else {
                return;
            }
        }
        this.b.a(iX5WebViewBase);
        this.a.onReceivedError(this.b, i, str, str2);
    }

    public void onReceivedError(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        this.b.a(iX5WebViewBase);
        this.a.onReceivedError(this.b, webResourceRequest, webResourceError);
    }

    public void onReceivedHttpAuthRequest(IX5WebViewBase iX5WebViewBase, HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.b.a(iX5WebViewBase);
        this.a.onReceivedHttpAuthRequest(this.b, httpAuthHandler, str, str2);
    }

    public void onReceivedHttpError(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        this.b.a(iX5WebViewBase);
        this.a.onReceivedHttpError(this.b, webResourceRequest, webResourceResponse);
    }

    public void onReceivedLoginRequest(IX5WebViewBase iX5WebViewBase, String str, String str2, String str3) {
        this.b.a(iX5WebViewBase);
        this.a.onReceivedLoginRequest(this.b, str, str2, str3);
    }

    public void onReceivedSslError(IX5WebViewBase iX5WebViewBase, SslErrorHandler sslErrorHandler, SslError sslError) {
        this.b.a(iX5WebViewBase);
        this.a.onReceivedSslError(this.b, sslErrorHandler, sslError);
    }

    public void onScaleChanged(IX5WebViewBase iX5WebViewBase, float f, float f2) {
        this.b.a(iX5WebViewBase);
        this.a.onScaleChanged(this.b, f, f2);
    }

    public void onTooManyRedirects(IX5WebViewBase iX5WebViewBase, Message message, Message message2) {
        this.b.a(iX5WebViewBase);
        this.a.onTooManyRedirects(this.b, message, message2);
    }

    public void onUnhandledKeyEvent(IX5WebViewBase iX5WebViewBase, KeyEvent keyEvent) {
        this.b.a(iX5WebViewBase);
        this.a.onUnhandledKeyEvent(this.b, keyEvent);
    }

    public WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest) {
        this.b.a(iX5WebViewBase);
        return this.a.shouldInterceptRequest(this.b, webResourceRequest);
    }

    public WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, WebResourceRequest webResourceRequest, Bundle bundle) {
        this.b.a(iX5WebViewBase);
        return this.a.shouldInterceptRequest(this.b, webResourceRequest, bundle);
    }

    public WebResourceResponse shouldInterceptRequest(IX5WebViewBase iX5WebViewBase, String str) {
        this.b.a(iX5WebViewBase);
        return this.a.shouldInterceptRequest(this.b, str);
    }

    public boolean shouldOverrideKeyEvent(IX5WebViewBase iX5WebViewBase, KeyEvent keyEvent) {
        this.b.a(iX5WebViewBase);
        return this.a.shouldOverrideKeyEvent(this.b, keyEvent);
    }

    public boolean shouldOverrideUrlLoading(IX5WebViewBase iX5WebViewBase, String str) {
        if (str == null || this.b.showDebugView(str)) {
            return true;
        }
        this.b.a(iX5WebViewBase);
        if (com.tencent.smtt.utils.s.a().a(this.b.getContext().getApplicationContext(), str)) {
            return true;
        }
        boolean shouldOverrideUrlLoading = this.a.shouldOverrideUrlLoading(this.b, str);
        if (!shouldOverrideUrlLoading) {
            if (str.startsWith("wtai://wp/mc;")) {
                StringBuilder stringBuilder = new StringBuilder(WebView.SCHEME_TEL);
                stringBuilder.append(str.substring(13));
                this.b.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse(stringBuilder.toString())));
                return true;
            } else if (str.startsWith(WebView.SCHEME_TEL)) {
                a(str);
                return true;
            }
        }
        return shouldOverrideUrlLoading;
    }
}
