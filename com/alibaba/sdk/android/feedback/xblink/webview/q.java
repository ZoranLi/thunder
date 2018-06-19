package com.alibaba.sdk.android.feedback.xblink.webview;

import android.view.View.OnClickListener;

class q implements OnClickListener {
    final /* synthetic */ XBHybridWebView a;

    q(XBHybridWebView xBHybridWebView) {
        this.a = xBHybridWebView;
    }

    public void onClick(android.view.View r1) {
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
        r0 = this;
        r1 = r0.a;	 Catch:{ Exception -> 0x0009 }
        r1 = r1.context;	 Catch:{ Exception -> 0x0009 }
        r1 = (android.app.Activity) r1;	 Catch:{ Exception -> 0x0009 }
        r1.finish();	 Catch:{ Exception -> 0x0009 }
    L_0x0009:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.webview.q.onClick(android.view.View):void");
    }
}
