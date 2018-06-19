package com.ali.auth.third.ui.webview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebView;
import com.ali.auth.third.core.config.a;
import com.umeng.message.proguard.k;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"SetJavaScriptEnabled"})
public class TaeWebView extends WebView {
    private static final String b = "TaeWebView";
    private static final String c;
    private static final String d;
    Map<String, Object> a = new HashMap();
    private HashMap<String, String> e = new HashMap();
    private String f;

    static {
        StringBuilder stringBuilder = new StringBuilder(" AliApp(BC/");
        stringBuilder.append(a.b.toString());
        stringBuilder.append(k.t);
        c = stringBuilder.toString();
        stringBuilder = new StringBuilder(" tae_sdk_");
        stringBuilder.append(a.c);
        d = stringBuilder.toString();
    }

    public TaeWebView(Context context) {
        super(context);
        a(context);
    }

    public TaeWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    @android.annotation.TargetApi(21)
    private void a(android.content.Context r6) {
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
        r5 = this;
        r0 = r5.getSettings();
        r1 = 1;
        r0.setJavaScriptEnabled(r1);	 Catch:{ Exception -> 0x0008 }
    L_0x0008:
        r2 = 0;
        r0.setSavePassword(r2);
        r0.setUseWideViewPort(r1);
        r0.setLoadWithOverviewMode(r1);
        r0.setJavaScriptCanOpenWindowsAutomatically(r2);
        r0.setDomStorageEnabled(r1);
        r3 = r6.getApplicationContext();
        r4 = "cache";
        r3 = r3.getDir(r4, r2);
        r3 = r3.getPath();
        r5.f = r3;
        r3 = r5.f;
        r0.setAppCachePath(r3);
        r0.setAllowFileAccess(r1);
        r0.setAppCacheEnabled(r1);
        r6 = com.ali.auth.third.core.j.a.a(r6);
        if (r6 == 0) goto L_0x003e;
    L_0x0039:
        r6 = -1;
        r0.setCacheMode(r6);
        goto L_0x0041;
    L_0x003e:
        r0.setCacheMode(r1);
    L_0x0041:
        r0.setBuiltInZoomControls(r2);
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r3 = r0.getUserAgentString();
        if (r3 == 0) goto L_0x0052;
    L_0x004f:
        r6.append(r3);
    L_0x0052:
        r3 = d;
        r6.append(r3);
        r3 = c;
        r6.append(r3);
        r6 = r6.toString();
        r0.setUserAgentString(r6);
        r6 = android.os.Build.VERSION.SDK_INT;
        r3 = 21;
        if (r6 < r3) goto L_0x0073;
    L_0x0069:
        r6 = android.webkit.CookieManager.getInstance();
        r6.setAcceptThirdPartyCookies(r5, r1);
        r0.setMixedContentMode(r2);
    L_0x0073:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.auth.third.ui.webview.TaeWebView.a(android.content.Context):void");
    }

    public final void a(String str, Object obj) {
        this.a.put(str, obj);
    }

    public final void addJavascriptInterface(Object obj, String str) {
    }

    public HashMap<String, String> getContextParameters() {
        return this.e;
    }
}
