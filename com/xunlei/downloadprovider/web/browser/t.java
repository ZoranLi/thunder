package com.xunlei.downloadprovider.web.browser;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.smtt.export.external.interfaces.SslError;
import com.tencent.smtt.export.external.interfaces.SslErrorHandler;
import com.tencent.smtt.export.external.interfaces.WebResourceError;
import com.tencent.smtt.export.external.interfaces.WebResourceRequest;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;
import com.xunlei.common.commonview.XLToast;
import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.download.a;
import com.xunlei.downloadprovider.download.create.ad;
import com.xunlei.downloadprovider.download.report.DLCenterEntry;
import com.xunlei.downloadprovider.h.k;
import com.xunlei.downloadprovider.launch.dispatch.e;
import com.xunlei.downloadprovider.web.browser.transcode.BrowserTranscodeHelper;
import java.net.URISyntaxException;

/* compiled from: BrowserActivity */
final class t extends WebViewClient {
    final /* synthetic */ BrowserActivity b;

    t(BrowserActivity browserActivity) {
        this.b = browserActivity;
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String str2;
        Object obj;
        boolean z;
        String path;
        ad adVar;
        String str3;
        boolean z2;
        Intent parseUri;
        String str4 = BrowserActivity.a;
        str4 = BrowserActivity.a;
        StringBuilder stringBuilder = new StringBuilder("WebView - shouldOverrideUrlLoading: ");
        stringBuilder.append(str);
        stringBuilder.append(String.format(" Original(%s) Url(%s)", new Object[]{webView.getOriginalUrl(), webView.getUrl()}));
        str4 = webView.getUrl();
        if (str4 == null) {
            str4 = "";
        }
        Uri parse = Uri.parse(str);
        String a = this.b.b("browser/play_icon");
        if (parse == null || !"thunderbrowser".equals(parse.getScheme())) {
            str2 = str4;
            obj = null;
            z = false;
        } else {
            path = parse.getPath();
            if (path == null || !path.equals("/playicondown")) {
                str2 = str4;
                obj = null;
            } else {
                a = this.b.b("browser/play_icon");
                obj = parse.getQueryParameter("down");
                if (TextUtils.isEmpty(obj)) {
                    z = false;
                    if (z) {
                        return true;
                    }
                    this.b.s = false;
                    parse = Uri.parse(str);
                    a = this.b.b("browser/other");
                    if (parse != null && "xunleiapp".equals(parse.getScheme())) {
                        path = parse.getPath();
                        if (path != null) {
                            if (!path.equals("/hotResource")) {
                                if (path.equals("/resourceDetail")) {
                                    if (path.equals("/sharePage")) {
                                        adVar = new ad();
                                        e.a(parse, adVar, this.b.b("browser/thunder"));
                                        str2 = adVar.a();
                                        if (TextUtils.isEmpty(str2)) {
                                            path = adVar.c(this.b.b("manual/share_h5"));
                                            a = adVar.c();
                                            if (!TextUtils.isEmpty(str4) && str4.contains("m.sjzhushou.com")) {
                                                this.b.s = true;
                                            }
                                            String str5 = path;
                                            path = a;
                                            a = str5;
                                            if (TextUtils.isEmpty(str2)) {
                                                if (!TextUtils.isEmpty(str)) {
                                                    if (!str.startsWith("magnet:?")) {
                                                        str3 = str;
                                                    } else if (str.startsWith("http://magnet:?")) {
                                                        str3 = str.substring(7);
                                                    }
                                                    if (str3 == null) {
                                                        str2 = str3;
                                                    } else {
                                                        if (!(k.a(str) || k.d(str) || k.b(str) || str.startsWith("thunder://"))) {
                                                            if (TextUtils.isEmpty(str)) {
                                                                z = str.startsWith("ed2k://");
                                                            } else {
                                                                z = false;
                                                            }
                                                            if (!(z || k.g(str))) {
                                                                if (k.e(str)) {
                                                                    z = false;
                                                                    if (z) {
                                                                        str2 = str;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        z = true;
                                                        if (z) {
                                                            str2 = str;
                                                        }
                                                    }
                                                }
                                                str3 = null;
                                                if (str3 == null) {
                                                    if (TextUtils.isEmpty(str)) {
                                                        z = str.startsWith("ed2k://");
                                                    } else {
                                                        z = false;
                                                    }
                                                    if (k.e(str)) {
                                                        z = false;
                                                        if (z) {
                                                            str2 = str;
                                                        }
                                                    } else {
                                                        z = true;
                                                        if (z) {
                                                            str2 = str;
                                                        }
                                                    }
                                                } else {
                                                    str2 = str3;
                                                }
                                            }
                                            if (!TextUtils.isEmpty(str2)) {
                                                if (com.xunlei.xllib.b.k.b(str2)) {
                                                    str2 = com.xunlei.xllib.b.k.e(str2);
                                                }
                                                a(str2, path, str4, a);
                                                z2 = true;
                                                if (!z2) {
                                                    return true;
                                                }
                                                if (str.startsWith("ftp://")) {
                                                    return BrowserTranscodeHelper.getInstance().shouldOverrideUrlLoadingForTranscode(this.b.m, str, false);
                                                }
                                                parseUri = Intent.parseUri(str, 1);
                                                parseUri.setComponent(null);
                                                this.b.startActivity(parseUri);
                                                return true;
                                            }
                                            z2 = false;
                                            if (!z2) {
                                                return true;
                                            }
                                            if (str.startsWith("ftp://")) {
                                                return BrowserTranscodeHelper.getInstance().shouldOverrideUrlLoadingForTranscode(this.b.m, str, false);
                                            }
                                            parseUri = Intent.parseUri(str, 1);
                                            parseUri.setComponent(null);
                                            this.b.startActivity(parseUri);
                                            return true;
                                        }
                                        XLToast.showToast(this.b, "该链接已失效");
                                        if (!TextUtils.isEmpty(str4) && str4.contains("m.sjzhushou.com")) {
                                            this.b.finish();
                                        }
                                        z2 = false;
                                        if (!z2) {
                                            return true;
                                        }
                                        if (!(str.startsWith("http://") || str.startsWith("https://"))) {
                                            if (str.startsWith("ftp://")) {
                                                try {
                                                    parseUri = Intent.parseUri(str, 1);
                                                    parseUri.setComponent(null);
                                                    this.b.startActivity(parseUri);
                                                    return true;
                                                } catch (WebView webView2) {
                                                    str = BrowserActivity.a;
                                                    new StringBuilder("ActivityNotFoundException: ").append(webView2.getLocalizedMessage());
                                                    return true;
                                                } catch (URISyntaxException e) {
                                                    e.printStackTrace();
                                                    return super.shouldOverrideUrlLoading(webView2, str);
                                                }
                                            }
                                        }
                                        return BrowserTranscodeHelper.getInstance().shouldOverrideUrlLoadingForTranscode(this.b.m, str, false);
                                    }
                                }
                            }
                            a.a(this.b, DLCenterEntry.browser.toString());
                            this.b.finish();
                            z2 = true;
                            if (!z2) {
                                return true;
                            }
                            if (str.startsWith("ftp://")) {
                                return BrowserTranscodeHelper.getInstance().shouldOverrideUrlLoadingForTranscode(this.b.m, str, false);
                            }
                            parseUri = Intent.parseUri(str, 1);
                            parseUri.setComponent(null);
                            this.b.startActivity(parseUri);
                            return true;
                        }
                    }
                    str2 = null;
                    path = str2;
                    if (TextUtils.isEmpty(str2)) {
                        if (TextUtils.isEmpty(str)) {
                            if (!str.startsWith("magnet:?")) {
                                str3 = str;
                            } else if (str.startsWith("http://magnet:?")) {
                                str3 = str.substring(7);
                            }
                            if (str3 == null) {
                                str2 = str3;
                            } else {
                                if (TextUtils.isEmpty(str)) {
                                    z = false;
                                } else {
                                    z = str.startsWith("ed2k://");
                                }
                                if (k.e(str)) {
                                    z = true;
                                    if (z) {
                                        str2 = str;
                                    }
                                } else {
                                    z = false;
                                    if (z) {
                                        str2 = str;
                                    }
                                }
                            }
                        }
                        str3 = null;
                        if (str3 == null) {
                            if (TextUtils.isEmpty(str)) {
                                z = str.startsWith("ed2k://");
                            } else {
                                z = false;
                            }
                            if (k.e(str)) {
                                z = false;
                                if (z) {
                                    str2 = str;
                                }
                            } else {
                                z = true;
                                if (z) {
                                    str2 = str;
                                }
                            }
                        } else {
                            str2 = str3;
                        }
                    }
                    if (TextUtils.isEmpty(str2)) {
                        if (com.xunlei.xllib.b.k.b(str2)) {
                            str2 = com.xunlei.xllib.b.k.e(str2);
                        }
                        a(str2, path, str4, a);
                        z2 = true;
                        if (!z2) {
                            return true;
                        }
                        if (str.startsWith("ftp://")) {
                            return BrowserTranscodeHelper.getInstance().shouldOverrideUrlLoadingForTranscode(this.b.m, str, false);
                        }
                        parseUri = Intent.parseUri(str, 1);
                        parseUri.setComponent(null);
                        this.b.startActivity(parseUri);
                        return true;
                    }
                    z2 = false;
                    if (!z2) {
                        return true;
                    }
                    if (str.startsWith("ftp://")) {
                        return BrowserTranscodeHelper.getInstance().shouldOverrideUrlLoadingForTranscode(this.b.m, str, false);
                    }
                    parseUri = Intent.parseUri(str, 1);
                    parseUri.setComponent(null);
                    this.b.startActivity(parseUri);
                    return true;
                }
                str2 = parse.getQueryParameter("ref");
                if (TextUtils.isEmpty(str2)) {
                    str2 = str4;
                }
            }
            z = true;
        }
        if (!TextUtils.isEmpty(obj)) {
            a(obj, null, str2, a);
            z = true;
        }
        if (z) {
            return true;
        }
        this.b.s = false;
        parse = Uri.parse(str);
        a = this.b.b("browser/other");
        path = parse.getPath();
        if (path != null) {
            if (path.equals("/hotResource")) {
                if (path.equals("/resourceDetail")) {
                    if (path.equals("/sharePage")) {
                        adVar = new ad();
                        e.a(parse, adVar, this.b.b("browser/thunder"));
                        str2 = adVar.a();
                        if (TextUtils.isEmpty(str2)) {
                            path = adVar.c(this.b.b("manual/share_h5"));
                            a = adVar.c();
                            this.b.s = true;
                            String str52 = path;
                            path = a;
                            a = str52;
                            if (TextUtils.isEmpty(str2)) {
                                if (TextUtils.isEmpty(str)) {
                                    if (!str.startsWith("magnet:?")) {
                                        str3 = str;
                                    } else if (str.startsWith("http://magnet:?")) {
                                        str3 = str.substring(7);
                                    }
                                    if (str3 == null) {
                                        str2 = str3;
                                    } else {
                                        if (TextUtils.isEmpty(str)) {
                                            z = false;
                                        } else {
                                            z = str.startsWith("ed2k://");
                                        }
                                        if (k.e(str)) {
                                            z = true;
                                            if (z) {
                                                str2 = str;
                                            }
                                        } else {
                                            z = false;
                                            if (z) {
                                                str2 = str;
                                            }
                                        }
                                    }
                                }
                                str3 = null;
                                if (str3 == null) {
                                    if (TextUtils.isEmpty(str)) {
                                        z = str.startsWith("ed2k://");
                                    } else {
                                        z = false;
                                    }
                                    if (k.e(str)) {
                                        z = false;
                                        if (z) {
                                            str2 = str;
                                        }
                                    } else {
                                        z = true;
                                        if (z) {
                                            str2 = str;
                                        }
                                    }
                                } else {
                                    str2 = str3;
                                }
                            }
                            if (TextUtils.isEmpty(str2)) {
                                if (com.xunlei.xllib.b.k.b(str2)) {
                                    str2 = com.xunlei.xllib.b.k.e(str2);
                                }
                                a(str2, path, str4, a);
                                z2 = true;
                                if (!z2) {
                                    return true;
                                }
                                if (str.startsWith("ftp://")) {
                                    return BrowserTranscodeHelper.getInstance().shouldOverrideUrlLoadingForTranscode(this.b.m, str, false);
                                }
                                parseUri = Intent.parseUri(str, 1);
                                parseUri.setComponent(null);
                                this.b.startActivity(parseUri);
                                return true;
                            }
                            z2 = false;
                            if (!z2) {
                                return true;
                            }
                            if (str.startsWith("ftp://")) {
                                return BrowserTranscodeHelper.getInstance().shouldOverrideUrlLoadingForTranscode(this.b.m, str, false);
                            }
                            parseUri = Intent.parseUri(str, 1);
                            parseUri.setComponent(null);
                            this.b.startActivity(parseUri);
                            return true;
                        }
                        XLToast.showToast(this.b, "该链接已失效");
                        this.b.finish();
                        z2 = false;
                        if (!z2) {
                            return true;
                        }
                        if (str.startsWith("ftp://")) {
                            return BrowserTranscodeHelper.getInstance().shouldOverrideUrlLoadingForTranscode(this.b.m, str, false);
                        }
                        parseUri = Intent.parseUri(str, 1);
                        parseUri.setComponent(null);
                        this.b.startActivity(parseUri);
                        return true;
                    }
                }
            }
            a.a(this.b, DLCenterEntry.browser.toString());
            this.b.finish();
            z2 = true;
            if (!z2) {
                return true;
            }
            if (str.startsWith("ftp://")) {
                return BrowserTranscodeHelper.getInstance().shouldOverrideUrlLoadingForTranscode(this.b.m, str, false);
            }
            parseUri = Intent.parseUri(str, 1);
            parseUri.setComponent(null);
            this.b.startActivity(parseUri);
            return true;
        }
        str2 = null;
        path = str2;
        if (TextUtils.isEmpty(str2)) {
            if (TextUtils.isEmpty(str)) {
                if (!str.startsWith("magnet:?")) {
                    str3 = str;
                } else if (str.startsWith("http://magnet:?")) {
                    str3 = str.substring(7);
                }
                if (str3 == null) {
                    str2 = str3;
                } else {
                    if (TextUtils.isEmpty(str)) {
                        z = false;
                    } else {
                        z = str.startsWith("ed2k://");
                    }
                    if (k.e(str)) {
                        z = true;
                        if (z) {
                            str2 = str;
                        }
                    } else {
                        z = false;
                        if (z) {
                            str2 = str;
                        }
                    }
                }
            }
            str3 = null;
            if (str3 == null) {
                if (TextUtils.isEmpty(str)) {
                    z = str.startsWith("ed2k://");
                } else {
                    z = false;
                }
                if (k.e(str)) {
                    z = false;
                    if (z) {
                        str2 = str;
                    }
                } else {
                    z = true;
                    if (z) {
                        str2 = str;
                    }
                }
            } else {
                str2 = str3;
            }
        }
        if (TextUtils.isEmpty(str2)) {
            if (com.xunlei.xllib.b.k.b(str2)) {
                str2 = com.xunlei.xllib.b.k.e(str2);
            }
            a(str2, path, str4, a);
            z2 = true;
            if (!z2) {
                return true;
            }
            if (str.startsWith("ftp://")) {
                return BrowserTranscodeHelper.getInstance().shouldOverrideUrlLoadingForTranscode(this.b.m, str, false);
            }
            parseUri = Intent.parseUri(str, 1);
            parseUri.setComponent(null);
            this.b.startActivity(parseUri);
            return true;
        }
        z2 = false;
        if (!z2) {
            return true;
        }
        if (str.startsWith("ftp://")) {
            return BrowserTranscodeHelper.getInstance().shouldOverrideUrlLoadingForTranscode(this.b.m, str, false);
        }
        parseUri = Intent.parseUri(str, 1);
        parseUri.setComponent(null);
        this.b.startActivity(parseUri);
        return true;
    }

    @TargetApi(21)
    public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        return BrowserTranscodeHelper.getInstance().shouldInterceptRequest(this.b.m, webResourceRequest.getUrl().toString(), this.b.c);
    }

    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return BrowserTranscodeHelper.getInstance().shouldInterceptRequest(this.b.m, str, this.b.c);
    }

    private void a(String str, String str2, String str3, String str4) {
        this.b.c.post(new u(this, str, str2, str3, str4));
    }

    @SuppressLint({"NewApi"})
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        String str2 = BrowserActivity.a;
        str2 = BrowserActivity.a;
        StringBuilder stringBuilder = new StringBuilder("WebView - onPageStarted: ");
        stringBuilder.append(str);
        stringBuilder.append(String.format(" Original(%s) Url(%s)", new Object[]{webView.getOriginalUrl(), webView.getUrl()}));
        if (VERSION.SDK_INT < 17 || !this.b.isDestroyed()) {
            super.onPageStarted(webView, str, bitmap);
            this.b.p.b(true);
            this.b.a();
            this.b.f = true;
            this.b.p.a(str, true);
            this.b.p.a(true);
            BrowserActivity.j(this.b);
            this.b.q.a.a(str);
            if (VERSION.SDK_INT >= 17) {
                this.b.n.addJavascriptInterface(BrowserTranscodeHelper.getInstance(), "BrowserTranscodeHelper");
            } else {
                this.b.n.removeJavascriptInterface("searchBoxJavaBridge_");
            }
        }
    }

    @SuppressLint({"NewApi"})
    public final void onPageFinished(WebView webView, String str) {
        String originalUrl = webView.getOriginalUrl();
        String url = webView.getUrl();
        String str2 = BrowserActivity.a;
        StringBuilder stringBuilder = new StringBuilder("WebView - onPageFinished: ");
        stringBuilder.append(str);
        stringBuilder.append(String.format(" Original(%s) Url(%s)", new Object[]{originalUrl, url}));
        if (VERSION.SDK_INT < 17 || !this.b.isDestroyed()) {
            this.b.p.b(false);
            this.b.f = false;
            BrowserActivity.j(this.b);
            this.b.p.a(false);
            this.b.p.b(str);
            if (url != null) {
                this.b.w = url;
                str2 = webView.getTitle();
                if (!TextUtils.isEmpty(str2)) {
                    this.b.D = str2;
                    this.b.v = str2;
                }
                if (TextUtils.isEmpty(this.b.D)) {
                    this.b.p.a(url);
                } else {
                    this.b.p.a(this.b.D);
                }
            } else {
                this.b.p.a(this.b.e.a);
                this.b.a(-1, this.b.e.a);
            }
            super.onPageFinished(webView, str);
            if (VERSION.SDK_INT > 19) {
                webView.getSettings().setMixedContentMode(0);
            }
            webView.getSettings().setBlockNetworkImage(false);
            if (BrowserActivity.k == -1 || BrowserActivity.k == this.b.j) {
                long currentTimeMillis = System.currentTimeMillis();
                if (TextUtils.isEmpty(this.b.u) == null) {
                    if (this.b.u.equals(webView.getUrl()) != null) {
                        if (!(currentTimeMillis - this.b.x <= 500 || webView == null || this.b.i == null)) {
                            aa.a(webView.getUrl(), this.b.i.toString(), this.b.j);
                        }
                        this.b.x = currentTimeMillis;
                        if (webView != null) {
                            this.b.u = url;
                        }
                    }
                }
                if (!(webView == null || this.b.i == null)) {
                    aa.a(webView.getUrl(), this.b.i.toString(), this.b.j);
                }
                this.b.x = currentTimeMillis;
                if (webView != null) {
                    this.b.u = url;
                }
            }
            str = ay.a();
            Object url2 = webView.getUrl();
            if (!TextUtils.isEmpty(url2)) {
                Object a;
                if (str.b.matcher(url2).find()) {
                    a = ay.a(url2, str.a, 1);
                } else if (str.e.matcher(url2).find()) {
                    CharSequence a2 = ay.a(url2, str.c, 3);
                    a = TextUtils.isEmpty(a2) ? ay.a(url2, str.d, 1) : a2;
                } else {
                    a = str.g.matcher(url2).find() ? ay.a(url2, str.f, 1) : str.i.matcher(url2).find() ? ay.a(url2, str.h, 1) : null;
                }
                if (!TextUtils.isEmpty(a)) {
                    XLThreadPool.execute(new az(str, a));
                }
            }
            BrowserTranscodeHelper.getInstance().injectJsOnPageFinished(webView);
        }
    }

    public final void onLoadResource(WebView webView, String str) {
        super.onLoadResource(webView, str);
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        a(webView, i, str2);
        super.onReceivedError(webView, i, str, str2);
    }

    private void a(WebView webView, int i, String str) {
        webView.stopLoading();
        if (this.b.n != null) {
            if (VERSION.SDK_INT >= 19) {
                this.b.n.evaluateJavascript("javascript:document.body.innerHTML=\"\";", null);
            } else {
                this.b.n.loadUrl("javascript:document.body.innerHTML=\"\";");
            }
        }
        this.b.r = true;
        webView = Message.obtain(this.b.c, 10002);
        webView.obj = str;
        webView.arg1 = i;
        this.b.c.sendEmptyMessage(10002);
    }

    @TargetApi(23)
    public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (webResourceRequest.isForMainFrame()) {
            a(webView, webResourceError.getErrorCode(), webResourceRequest.getUrl().toString());
        }
        super.onReceivedError(webView, webResourceRequest, webResourceError);
    }

    public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslErrorHandler != null) {
            try {
                if (sslError.getPrimaryError() != 3) {
                    if (sslError.getPrimaryError() != 3) {
                        sslErrorHandler.cancel();
                        return;
                    }
                }
                sslErrorHandler.proceed();
            } catch (WebView webView2) {
                webView2.printStackTrace();
            }
        }
    }
}
