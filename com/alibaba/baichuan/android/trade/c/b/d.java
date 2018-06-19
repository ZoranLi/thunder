package com.alibaba.baichuan.android.trade.c.b;

import android.content.Context;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.alibaba.baichuan.android.a.b.b;
import com.alibaba.baichuan.android.a.g;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.b.a;
import com.umeng.message.proguard.k;
import java.util.HashMap;
import java.util.Map;

public class d implements g {
    private static final String e = "d";
    private static final String g;
    private static final String h;
    public WebView a;
    public HashMap b;
    public a c;
    public b d;
    private WebViewClient f;
    private String i;
    private String j;
    private boolean k;
    private WebChromeClient l;
    private Context m;

    static {
        StringBuilder stringBuilder = new StringBuilder(" AliApp(BC/");
        stringBuilder.append(AlibcContext.d);
        stringBuilder.append(k.t);
        g = stringBuilder.toString();
        stringBuilder = new StringBuilder(" tae_sdk_");
        stringBuilder.append(AlibcContext.d);
        h = stringBuilder.toString();
    }

    public d(Context context, a aVar, WebView webView, Map map) {
        this(context, aVar, webView, map, null, null, false);
    }

    public final WebView a() {
        return this.a;
    }

    public final Object a(String str) {
        return this.d == null ? null : this.d.a(str);
    }

    public final boolean b() {
        return this.a == null ? false : this.a.canGoBack();
    }

    public final Map c() {
        return (Map) this.b.get("ui_contextParams");
    }

    public final void d() {
        if (this.a != null) {
            this.a.goBack();
        }
    }

    public d(android.content.Context r3, com.alibaba.baichuan.android.trade.b.a r4, android.webkit.WebView r5, java.util.Map r6, android.webkit.WebViewClient r7, android.webkit.WebChromeClient r8, boolean r9) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r2.<init>();
        r0 = new java.util.HashMap;
        r0.<init>();
        r2.b = r0;
        r0 = 0;
        r2.d = r0;
        r2.a = r5;
        r2.f = r7;
        r2.l = r8;
        r6 = (java.util.HashMap) r6;
        r2.b = r6;
        r2.c = r4;
        r2.m = r3;
        r2.k = r9;
        r3 = r2.a;
        r4 = r3.getSettings();
        r5 = 0;
        if (r4 == 0) goto L_0x00dd;
    L_0x0026:
        r6 = 1;
        r4.setJavaScriptEnabled(r6);	 Catch:{ Exception -> 0x002a }
    L_0x002a:
        r4.setSavePassword(r5);
        r4.setUseWideViewPort(r6);
        r4.setLoadWithOverviewMode(r6);
        r4.setJavaScriptCanOpenWindowsAutomatically(r5);
        r4.setDomStorageEnabled(r6);
        r7 = r3.getContext();
        r7 = r7.getApplicationContext();
        r8 = "cache";
        r7 = r7.getDir(r8, r5);
        r7 = r7.getPath();
        r2.j = r7;
        r7 = r2.j;
        r4.setAppCachePath(r7);
        r4.setAllowFileAccess(r6);
        r4.setAppCacheEnabled(r6);
        r7 = "UTF-8";
        r4.setDefaultTextEncodingName(r7);
        r7 = r3.getContext();
        r7 = com.alibaba.baichuan.android.trade.utils.f.a(r7);
        if (r7 == 0) goto L_0x006c;
    L_0x0067:
        r7 = -1;
        r4.setCacheMode(r7);
        goto L_0x006f;
    L_0x006c:
        r4.setCacheMode(r6);
    L_0x006f:
        r4.setBuiltInZoomControls(r5);
        r7 = new java.lang.StringBuilder;
        r7.<init>();
        r8 = r4.getUserAgentString();
        r2.i = r8;
        r8 = r2.i;
        if (r8 == 0) goto L_0x0086;
    L_0x0081:
        r8 = r2.i;
        r7.append(r8);
    L_0x0086:
        r8 = com.alibaba.baichuan.android.trade.e.a.g();
        r8 = r8.c();
        if (r8 != 0) goto L_0x0095;
    L_0x0090:
        r8 = h;
        r7.append(r8);
    L_0x0095:
        r8 = g;
        r7.append(r8);
        r8 = " AliBaichuan(%s/%s)";
        r9 = 2;
        r9 = new java.lang.Object[r9];
        r0 = com.alibaba.baichuan.android.trade.e.a.g();
        r0 = r0.e();
        r9[r5] = r0;
        r0 = com.alibaba.baichuan.android.trade.e.a.g();
        r1 = "isvVersion";
        r1 = r0.a(r1);
        if (r1 == 0) goto L_0x00be;
    L_0x00b5:
        r1 = "isvVersion";
        r0 = r0.a(r1);
        r0 = (java.lang.String) r0;
        goto L_0x00c0;
    L_0x00be:
        r0 = r0.c;
    L_0x00c0:
        r9[r6] = r0;
        r8 = java.lang.String.format(r8, r9);
        r7.append(r8);
        r7 = r7.toString();
        r4.setUserAgentString(r7);
        r4 = android.os.Build.VERSION.SDK_INT;
        r7 = 21;
        if (r4 < r7) goto L_0x00dd;
    L_0x00d6:
        r4 = android.webkit.CookieManager.getInstance();
        r4.setAcceptThirdPartyCookies(r3, r6);
    L_0x00dd:
        r3 = r2.f;
        if (r3 != 0) goto L_0x00ec;
    L_0x00e1:
        r3 = r2.a;
        r4 = new com.alibaba.baichuan.android.trade.c.b.f;
        r4.<init>(r2);
        r3.setWebViewClient(r4);
        goto L_0x00f8;
    L_0x00ec:
        r3 = new com.alibaba.baichuan.android.trade.c.b.b;
        r4 = r2.f;
        r3.<init>(r4, r2);
        r4 = r2.a;
        r4.setWebViewClient(r3);
    L_0x00f8:
        r3 = r2.l;
        if (r3 != 0) goto L_0x0109;
    L_0x00fc:
        r3 = r2.a;
        r4 = new com.alibaba.baichuan.android.trade.c.b.c;
        r6 = r2.k;
        r4.<init>(r2, r6);
        r3.setWebChromeClient(r4);
        goto L_0x0115;
    L_0x0109:
        r3 = new com.alibaba.baichuan.android.trade.c.b.a;
        r4 = r2.l;
        r3.<init>(r4, r2);
        r4 = r2.a;
        r4.setWebChromeClient(r3);
    L_0x0115:
        r3 = r2.a;
        r4 = com.alibaba.baichuan.android.trade.AlibcContext.a;
        r6 = "id";
        r7 = "com_taobao_nb_sdk_webview_click";
        r4 = com.alibaba.baichuan.android.trade.utils.l.a(r4, r6, r7);
        r5 = java.lang.Boolean.valueOf(r5);
        r3.setTag(r4, r5);
        r3 = r2.a;
        r4 = new com.alibaba.baichuan.android.trade.c.b.e;
        r4.<init>(r2);
        r3.setOnTouchListener(r4);
        r3 = com.alibaba.baichuan.android.a.a.a();
        r3.b();
        r3 = com.alibaba.baichuan.android.a.a.b.a;
        r4 = com.alibaba.baichuan.android.a.a.b.class;
        com.alibaba.baichuan.android.a.b.c.a(r3, r4);
        r3 = "AliBCNetWork";
        r4 = com.alibaba.baichuan.android.a.a.c.class;
        com.alibaba.baichuan.android.a.b.c.a(r3, r4);
        r3 = com.alibaba.baichuan.android.a.a.a.a;
        r4 = com.alibaba.baichuan.android.a.a.a.class;
        com.alibaba.baichuan.android.a.b.c.a(r3, r4);
        r3 = com.alibaba.baichuan.android.a.a.e.a;
        r4 = com.alibaba.baichuan.android.a.a.e.class;
        com.alibaba.baichuan.android.a.b.c.a(r3, r4);
        r3 = new com.alibaba.baichuan.android.a.b.b;
        r4 = r2.m;
        r3.<init>(r4, r2);
        r2.d = r3;
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.android.trade.c.b.d.<init>(android.content.Context, com.alibaba.baichuan.android.trade.b.a, android.webkit.WebView, java.util.Map, android.webkit.WebViewClient, android.webkit.WebChromeClient, boolean):void");
    }
}
