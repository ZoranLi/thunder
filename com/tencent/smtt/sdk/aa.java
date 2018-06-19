package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.os.Build.VERSION;
import android.os.Message;
import android.view.KeyEvent;
import android.webkit.WebResourceError;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.tencent.smtt.export.external.interfaces.ClientCertRequest;
import com.tencent.smtt.export.external.interfaces.HttpAuthHandler;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.s;
import com.tencent.smtt.utils.y;
import java.io.InputStream;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Map;

@SuppressLint({"NewApi", "Override"})
class aa extends WebViewClient {
    private static String c;
    private WebViewClient a;
    private WebView b;

    private static class a extends ClientCertRequest {
        private android.webkit.ClientCertRequest a;

        public a(android.webkit.ClientCertRequest clientCertRequest) {
            this.a = clientCertRequest;
        }

        public void cancel() {
            this.a.cancel();
        }

        public String getHost() {
            return this.a.getHost();
        }

        public String[] getKeyTypes() {
            return this.a.getKeyTypes();
        }

        public int getPort() {
            return this.a.getPort();
        }

        public Principal[] getPrincipals() {
            return this.a.getPrincipals();
        }

        public void ignore() {
            this.a.ignore();
        }

        public void proceed(PrivateKey privateKey, X509Certificate[] x509CertificateArr) {
            this.a.proceed(privateKey, x509CertificateArr);
        }
    }

    private static class b implements HttpAuthHandler {
        private android.webkit.HttpAuthHandler a;

        b(android.webkit.HttpAuthHandler httpAuthHandler) {
            this.a = httpAuthHandler;
        }

        public void cancel() {
            this.a.cancel();
        }

        public void proceed(String str, String str2) {
            this.a.proceed(str, str2);
        }

        public boolean useHttpAuthUsernamePassword() {
            return this.a.useHttpAuthUsernamePassword();
        }
    }

    private static class c implements SslErrorHandler {
        android.webkit.SslErrorHandler a;

        c(android.webkit.SslErrorHandler sslErrorHandler) {
            this.a = sslErrorHandler;
        }

        public void cancel() {
            this.a.cancel();
        }

        public void proceed() {
            this.a.proceed();
        }
    }

    private static class d implements SslError {
        android.net.http.SslError a;

        d(android.net.http.SslError sslError) {
            this.a = sslError;
        }

        public boolean addError(int i) {
            return this.a.addError(i);
        }

        public SslCertificate getCertificate() {
            return this.a.getCertificate();
        }

        public int getPrimaryError() {
            return this.a.getPrimaryError();
        }

        public boolean hasError(int i) {
            return this.a.hasError(i);
        }
    }

    private class e implements WebResourceRequest {
        final /* synthetic */ aa a;
        private String b;
        private boolean c;
        private boolean d;
        private String e;
        private Map<String, String> f;

        public e(aa aaVar, String str, boolean z, boolean z2, String str2, Map<String, String> map) {
            this.a = aaVar;
            this.b = str;
            this.c = z;
            this.d = z2;
            this.e = str2;
            this.f = map;
        }

        public String getMethod() {
            return this.e;
        }

        public Map<String, String> getRequestHeaders() {
            return this.f;
        }

        public Uri getUrl() {
            return Uri.parse(this.b);
        }

        public boolean hasGesture() {
            return this.d;
        }

        public boolean isForMainFrame() {
            return this.c;
        }
    }

    private static class f implements WebResourceRequest {
        android.webkit.WebResourceRequest a;

        f(android.webkit.WebResourceRequest webResourceRequest) {
            this.a = webResourceRequest;
        }

        public String getMethod() {
            return this.a.getMethod();
        }

        public Map<String, String> getRequestHeaders() {
            return this.a.getRequestHeaders();
        }

        public Uri getUrl() {
            return this.a.getUrl();
        }

        public boolean hasGesture() {
            return this.a.hasGesture();
        }

        public boolean isForMainFrame() {
            return this.a.isForMainFrame();
        }
    }

    private static class g extends WebResourceResponse {
        android.webkit.WebResourceResponse a;

        public g(android.webkit.WebResourceResponse webResourceResponse) {
            this.a = webResourceResponse;
        }

        public InputStream getData() {
            return this.a.getData();
        }

        public String getEncoding() {
            return this.a.getEncoding();
        }

        public String getMimeType() {
            return this.a.getMimeType();
        }

        public String getReasonPhrase() {
            return this.a.getReasonPhrase();
        }

        public Map<String, String> getResponseHeaders() {
            return this.a.getResponseHeaders();
        }

        public int getStatusCode() {
            return this.a.getStatusCode();
        }

        public void setData(InputStream inputStream) {
            this.a.setData(inputStream);
        }

        public void setEncoding(String str) {
            this.a.setEncoding(str);
        }

        public void setMimeType(String str) {
            this.a.setMimeType(str);
        }

        public void setResponseHeaders(Map<String, String> map) {
            this.a.setResponseHeaders(map);
        }

        public void setStatusCodeAndReasonPhrase(int i, String str) {
            this.a.setStatusCodeAndReasonPhrase(i, str);
        }
    }

    aa(WebView webView, WebViewClient webViewClient) {
        this.b = webView;
        this.a = webViewClient;
    }

    public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
        this.b.a(webView);
        this.a.doUpdateVisitedHistory(this.b, str, z);
    }

    public void onFormResubmission(WebView webView, Message message, Message message2) {
        this.b.a(webView);
        this.a.onFormResubmission(this.b, message, message2);
    }

    public void onLoadResource(WebView webView, String str) {
        this.b.a(webView);
        this.a.onLoadResource(this.b, str);
    }

    public void onPageFinished(WebView webView, String str) {
        if (c == null) {
            y a = y.a();
            if (a != null) {
                a.a(true);
                c = Boolean.toString(true);
            }
        }
        this.b.a(webView);
        WebView webView2 = this.b;
        webView2.a++;
        this.a.onPageFinished(this.b, str);
        if ("com.qzone".equals(webView.getContext().getApplicationInfo().packageName)) {
            this.b.a(webView.getContext());
        }
        TbsLog.app_extra("SystemWebViewClient", webView.getContext());
        WebView.c();
        if (!(TbsShareManager.mHasQueryed || this.b.getContext() == null || !TbsShareManager.isThirdPartyApp(this.b.getContext()))) {
            TbsShareManager.mHasQueryed = true;
            new Thread(new ab(this)).start();
        }
        if (this.b.getContext() != null && !TbsLogReport.a(this.b.getContext()).e()) {
            TbsLogReport.a(this.b.getContext()).a(true);
            TbsLogReport.a(this.b.getContext()).b();
        }
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        this.b.a(webView);
        this.a.onPageStarted(this.b, str, bitmap);
    }

    public void onReceivedClientCertRequest(WebView webView, android.webkit.ClientCertRequest clientCertRequest) {
        if (VERSION.SDK_INT >= 21) {
            this.b.a(webView);
            this.a.onReceivedClientCertRequest(this.b, new a(clientCertRequest));
        }
    }

    public void onReceivedError(WebView webView, int i, String str, String str2) {
        this.b.a(webView);
        this.a.onReceivedError(this.b, i, str, str2);
    }

    public void onReceivedError(WebView webView, android.webkit.WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        this.b.a(webView);
        com.tencent.smtt.export.external.interfaces.WebResourceError webResourceError2 = null;
        WebResourceRequest fVar = webResourceRequest != null ? new f(webResourceRequest) : null;
        if (webResourceError != null) {
            webResourceError2 = new ac(this, webResourceError);
        }
        this.a.onReceivedError(this.b, fVar, webResourceError2);
    }

    public void onReceivedHttpAuthRequest(WebView webView, android.webkit.HttpAuthHandler httpAuthHandler, String str, String str2) {
        this.b.a(webView);
        this.a.onReceivedHttpAuthRequest(this.b, new b(httpAuthHandler), str, str2);
    }

    public void onReceivedHttpError(WebView webView, android.webkit.WebResourceRequest webResourceRequest, android.webkit.WebResourceResponse webResourceResponse) {
        this.b.a(webView);
        this.a.onReceivedHttpError(this.b, new f(webResourceRequest), new g(webResourceResponse));
    }

    @TargetApi(12)
    public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        if (VERSION.SDK_INT >= 12) {
            this.b.a(webView);
            this.a.onReceivedLoginRequest(this.b, str, str2, str3);
        }
    }

    @TargetApi(8)
    public void onReceivedSslError(WebView webView, android.webkit.SslErrorHandler sslErrorHandler, android.net.http.SslError sslError) {
        if (VERSION.SDK_INT >= 8) {
            this.b.a(webView);
            this.a.onReceivedSslError(this.b, new c(sslErrorHandler), new d(sslError));
        }
    }

    public void onScaleChanged(WebView webView, float f, float f2) {
        this.b.a(webView);
        this.a.onScaleChanged(this.b, f, f2);
    }

    public void onTooManyRedirects(WebView webView, Message message, Message message2) {
        this.b.a(webView);
        this.a.onTooManyRedirects(this.b, message, message2);
    }

    public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
        this.b.a(webView);
        this.a.onUnhandledKeyEvent(this.b, keyEvent);
    }

    public android.webkit.WebResourceResponse shouldInterceptRequest(WebView webView, android.webkit.WebResourceRequest webResourceRequest) {
        if (VERSION.SDK_INT < 21 || webResourceRequest == null) {
            return null;
        }
        WebResourceResponse shouldInterceptRequest = this.a.shouldInterceptRequest(this.b, new e(this, webResourceRequest.getUrl().toString(), webResourceRequest.isForMainFrame(), webResourceRequest.hasGesture(), webResourceRequest.getMethod(), webResourceRequest.getRequestHeaders()));
        if (shouldInterceptRequest == null) {
            return null;
        }
        android.webkit.WebResourceResponse webResourceResponse = new android.webkit.WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData());
        webResourceResponse.setResponseHeaders(shouldInterceptRequest.getResponseHeaders());
        int statusCode = shouldInterceptRequest.getStatusCode();
        String reasonPhrase = shouldInterceptRequest.getReasonPhrase();
        if (!(statusCode == webResourceResponse.getStatusCode() && (reasonPhrase == null || reasonPhrase.equals(webResourceResponse.getReasonPhrase())))) {
            webResourceResponse.setStatusCodeAndReasonPhrase(statusCode, reasonPhrase);
        }
        return webResourceResponse;
    }

    @TargetApi(11)
    public android.webkit.WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        if (VERSION.SDK_INT < 11) {
            return null;
        }
        WebResourceResponse shouldInterceptRequest = this.a.shouldInterceptRequest(this.b, str);
        return shouldInterceptRequest == null ? null : new android.webkit.WebResourceResponse(shouldInterceptRequest.getMimeType(), shouldInterceptRequest.getEncoding(), shouldInterceptRequest.getData());
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        this.b.a(webView);
        return this.a.shouldOverrideKeyEvent(this.b, keyEvent);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str == null || this.b.showDebugView(str)) {
            return true;
        }
        this.b.a(webView);
        return s.a().a(this.b.getContext().getApplicationContext(), str) ? true : this.a.shouldOverrideUrlLoading(this.b, str);
    }
}
