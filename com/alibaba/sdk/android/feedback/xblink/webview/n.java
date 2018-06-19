package com.alibaba.sdk.android.feedback.xblink.webview;

import android.view.View.OnLongClickListener;

class n implements OnLongClickListener {
    final /* synthetic */ XBHybridWebView a;

    n(XBHybridWebView xBHybridWebView) {
        this.a = xBHybridWebView;
    }

    public boolean onLongClick(android.view.View r4) {
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
        r4 = r3.a;	 Catch:{ Exception -> 0x0007 }
        r4 = r4.getHitTestResult();	 Catch:{ Exception -> 0x0007 }
        goto L_0x0008;
    L_0x0007:
        r4 = 0;
    L_0x0008:
        if (r4 != 0) goto L_0x000c;
    L_0x000a:
        r4 = 0;
        return r4;
    L_0x000c:
        r0 = com.alibaba.sdk.android.feedback.xblink.i.g.a();
        if (r0 == 0) goto L_0x0029;
    L_0x0012:
        r0 = "HybridWebView";
        r1 = new java.lang.StringBuilder;
        r2 = "Long click on WebView, ";
        r1.<init>(r2);
        r4 = r4.getExtra();
        r1.append(r4);
        r4 = r1.toString();
        com.alibaba.sdk.android.feedback.xblink.i.g.a(r0, r4);
    L_0x0029:
        r4 = 1;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.webview.n.onLongClick(android.view.View):boolean");
    }
}
