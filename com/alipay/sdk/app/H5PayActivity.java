package com.alipay.sdk.app;

import android.app.Activity;
import android.content.res.Configuration;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class H5PayActivity extends Activity {
    private WebView a;
    private WebViewClient b;

    protected void onCreate(android.os.Bundle r3) {
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
        super.onCreate(r3);
        r3 = r2.getIntent();	 Catch:{ Exception -> 0x003a }
        r3 = r3.getExtras();	 Catch:{ Exception -> 0x003a }
        r0 = "url";	 Catch:{ Exception -> 0x003a }
        r0 = r3.getString(r0);	 Catch:{ Exception -> 0x003a }
        r1 = com.alipay.sdk.util.k.b(r0);	 Catch:{ Exception -> 0x003a }
        if (r1 != 0) goto L_0x001b;	 Catch:{ Exception -> 0x003a }
    L_0x0017:
        r2.finish();	 Catch:{ Exception -> 0x003a }
        return;	 Catch:{ Exception -> 0x003a }
    L_0x001b:
        r1 = "cookie";	 Catch:{ Exception -> 0x003a }
        r3 = r3.getString(r1);	 Catch:{ Exception -> 0x003a }
        r1 = 1;
        super.requestWindowFeature(r1);
        r3 = com.alipay.sdk.util.k.a(r2, r0, r3);
        r2.a = r3;
        r3 = new com.alipay.sdk.app.b;
        r3.<init>(r2);
        r2.b = r3;
        r3 = r2.a;
        r0 = r2.b;
        r3.setWebViewClient(r0);
        return;
    L_0x003a:
        r2.finish();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.H5PayActivity.onCreate(android.os.Bundle):void");
    }

    public void onBackPressed() {
        if (!this.a.canGoBack()) {
            h.a = h.a();
            finish();
        } else if (((b) this.b).a) {
            i a = i.a(i.NETWORK_ERROR.h);
            h.a = h.a(a.h, a.i, "");
            finish();
        }
    }

    public void finish() {
        a();
        super.finish();
    }

    public void a() {
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
        r0 = com.alipay.sdk.app.PayTask.a;
        monitor-enter(r0);
        r0.notify();	 Catch:{ Exception -> 0x0009 }
        goto L_0x0009;
    L_0x0007:
        r1 = move-exception;
        goto L_0x000b;
    L_0x0009:
        monitor-exit(r0);	 Catch:{ all -> 0x0007 }
        return;
    L_0x000b:
        monitor-exit(r0);
        throw r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.H5PayActivity.a():void");
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
        r0 = r1.a;
        if (r0 == 0) goto L_0x0014;
    L_0x0007:
        r0 = r1.a;
        r0.removeAllViews();
        r0 = r1.a;	 Catch:{ Throwable -> 0x0011 }
        r0.destroy();	 Catch:{ Throwable -> 0x0011 }
    L_0x0011:
        r0 = 0;
        r1.a = r0;
    L_0x0014:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.app.H5PayActivity.onDestroy():void");
    }
}
