package com.ali.auth.third.ui.webview;

import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import com.ali.auth.third.ui.a.b;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.reflect.Method;

public class c extends WebChromeClient {
    private static final String a = "c";
    private static boolean b = (VERSION.SDK_INT >= 19);

    private static class a implements Runnable {
        public WebView a;
        public String b;

        public a(WebView webView, String str) {
            this.a = webView;
            this.b = str;
        }

        @android.annotation.TargetApi(19)
        public final void run() {
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
            r0 = com.ali.auth.third.ui.webview.c.b;	 Catch:{ Exception -> 0x0043 }
            if (r0 == 0) goto L_0x0020;
        L_0x0006:
            r0 = r3.a;	 Catch:{ Exception -> 0x000f }
            r1 = r3.b;	 Catch:{ Exception -> 0x000f }
            r2 = 0;	 Catch:{ Exception -> 0x000f }
            r0.evaluateJavascript(r1, r2);	 Catch:{ Exception -> 0x000f }
            return;
        L_0x000f:
            r0 = move-exception;
            r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0043 }
            r2 = "fail to evaluate the script ";	 Catch:{ Exception -> 0x0043 }
            r1.<init>(r2);	 Catch:{ Exception -> 0x0043 }
            r0 = r0.getMessage();	 Catch:{ Exception -> 0x0043 }
            r1.append(r0);	 Catch:{ Exception -> 0x0043 }
            r0 = com.ali.auth.third.core.config.a.a;	 Catch:{ Exception -> 0x0043 }
        L_0x0020:
            r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0043 }
            r1 = "javascript:";	 Catch:{ Exception -> 0x0043 }
            r0.<init>(r1);	 Catch:{ Exception -> 0x0043 }
            r1 = r3.b;	 Catch:{ Exception -> 0x0043 }
            r0.append(r1);	 Catch:{ Exception -> 0x0043 }
            r0 = r0.toString();	 Catch:{ Exception -> 0x0043 }
            r1 = r3.a;	 Catch:{ Exception -> 0x0043 }
            r1 = r1 instanceof com.ali.auth.third.ui.webview.TaeWebView;	 Catch:{ Exception -> 0x0043 }
            if (r1 == 0) goto L_0x003e;	 Catch:{ Exception -> 0x0043 }
        L_0x0036:
            r1 = r3.a;	 Catch:{ Exception -> 0x0043 }
            r1 = (com.ali.auth.third.ui.webview.TaeWebView) r1;	 Catch:{ Exception -> 0x0043 }
            r1.loadUrl(r0);	 Catch:{ Exception -> 0x0043 }
            return;	 Catch:{ Exception -> 0x0043 }
        L_0x003e:
            r1 = r3.a;	 Catch:{ Exception -> 0x0043 }
            r1.loadUrl(r0);	 Catch:{ Exception -> 0x0043 }
        L_0x0043:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ali.auth.third.ui.webview.c.a.run():void");
        }
    }

    public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
        return false;
    }

    public final boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
        if (str3 == null) {
            return false;
        }
        if (str3.equals("wv_hybrid:")) {
            try {
                str3 = str2.indexOf(58, 9);
                str2 = str2.substring(str3 + 1, str2.indexOf(47, str3));
                webView.post(new a(webView, String.format("window.WindVane&&window.WindVane.onFailure(%s,'{\"ret\":\"HY_NO_HANDLER\"');", new Object[]{str2})));
            } catch (WebView webView2) {
                new StringBuilder("fail to handler windvane request, the error message is ").append(webView2.getMessage());
                webView2 = com.ali.auth.third.core.config.a.a;
            }
            jsPromptResult.confirm("");
            return true;
        } else if (TextUtils.equals(str3, "hv_hybrid:") == null || (webView2 instanceof TaeWebView) == null) {
            return false;
        } else {
            TaeWebView taeWebView = (TaeWebView) webView2;
            str3 = Uri.parse(str2);
            String host = str3.getHost();
            int port = str3.getPort();
            String lastPathSegment = str3.getLastPathSegment();
            str3.getQuery();
            str3 = str2.indexOf("?");
            str2 = str3 == -1 ? null : str2.substring(str3 + 1);
            str3 = new g();
            str3.b = lastPathSegment;
            str3.a = host;
            str3.c = str2;
            str3.d = port;
            str2 = new b();
            str2.b = str3.d;
            str2.a = taeWebView;
            webView2 = taeWebView.a.get(str3.a);
            if (webView2 == null) {
                webView2 = com.ali.auth.third.core.e.b.a(10000, str3.a);
                webView2.toString();
                str = com.ali.auth.third.core.config.a.a;
                str2.a(webView2.a, webView2.c);
                jsPromptResult.confirm("");
                return true;
            }
            try {
                Method method = webView2.getClass().getMethod(str3.b, new Class[]{b.class, String.class});
                if (method.isAnnotationPresent(b.class)) {
                    try {
                        Object[] objArr = new Object[2];
                        objArr[0] = str2;
                        objArr[1] = TextUtils.isEmpty(str3.c) ? "{}" : str3.c;
                        method.invoke(webView2, objArr);
                    } catch (WebView webView22) {
                        str = com.ali.auth.third.core.e.b.a(10010, webView22.getMessage());
                        str3 = new StringBuilder();
                        str3.append(str.toString());
                        str3.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        str3.append(webView22.toString());
                        webView22 = com.ali.auth.third.core.config.a.a;
                        str2.a(str.a, str.c);
                    }
                } else {
                    webView22 = com.ali.auth.third.core.e.b.a(952, str3.a, str3.b);
                    webView22.toString();
                    str = com.ali.auth.third.core.config.a.a;
                    str2.a(webView22.a, webView22.c);
                }
                jsPromptResult.confirm("");
                return true;
            } catch (WebView webView222) {
                str = com.ali.auth.third.core.e.b.a(951, str3.a, str3.b);
                str3 = new StringBuilder();
                str3.append(str);
                str3.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                str3.append(webView222.toString());
                webView222 = com.ali.auth.third.core.config.a.a;
                str2.a(str.a, str.c);
                jsPromptResult.confirm("");
                return true;
            }
        }
    }
}
