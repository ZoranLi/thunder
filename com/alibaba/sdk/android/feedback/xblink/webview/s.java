package com.alibaba.sdk.android.feedback.xblink.webview;

import android.webkit.DownloadListener;

class s implements DownloadListener {
    final /* synthetic */ XBHybridWebView a;

    s(XBHybridWebView xBHybridWebView) {
        this.a = xBHybridWebView;
    }

    public void onDownloadStart(java.lang.String r3, java.lang.String r4, java.lang.String r5, java.lang.String r6, long r7) {
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
        r4 = com.alibaba.sdk.android.feedback.xblink.i.g.a();
        if (r4 == 0) goto L_0x0031;
    L_0x0006:
        r4 = "HybridWebView";
        r0 = new java.lang.StringBuilder;
        r1 = "Download start, url: ";
        r0.<init>(r1);
        r0.append(r3);
        r1 = " contentDisposition: ";
        r0.append(r1);
        r0.append(r5);
        r5 = " mimetype: ";
        r0.append(r5);
        r0.append(r6);
        r5 = " contentLength: ";
        r0.append(r5);
        r0.append(r7);
        r5 = r0.toString();
        com.alibaba.sdk.android.feedback.xblink.i.g.a(r4, r5);
    L_0x0031:
        r4 = r2.a;
        r4 = r4.supportDownload;
        if (r4 != 0) goto L_0x003f;
    L_0x0037:
        r3 = "HybridWebView";
        r4 = "DownloadListener is not support for webview.";
        com.alibaba.sdk.android.feedback.xblink.i.g.e(r3, r4);
        return;
    L_0x003f:
        r3 = android.net.Uri.parse(r3);
        r4 = new android.content.Intent;
        r5 = "android.intent.action.VIEW";
        r4.<init>(r5, r3);
        r3 = 268435456; // 0x10000000 float:2.5243549E-29 double:1.32624737E-315;
        r4.setFlags(r3);
        r3 = r2.a;	 Catch:{ ActivityNotFoundException -> 0x0057 }
        r3 = r3.context;	 Catch:{ ActivityNotFoundException -> 0x0057 }
        r3.startActivity(r4);	 Catch:{ ActivityNotFoundException -> 0x0057 }
        return;
    L_0x0057:
        r3 = r2.a;
        r3 = r3.context;
        r4 = "对不起，您的设备找不到相应的程序";
        r5 = 1;
        r3 = android.widget.Toast.makeText(r3, r4, r5);
        r3.show();
        r3 = "HybridWebView";
        r4 = "DownloadListener not found activity to open this url.";
        com.alibaba.sdk.android.feedback.xblink.i.g.b(r3, r4);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.sdk.android.feedback.xblink.webview.s.onDownloadStart(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long):void");
    }
}
