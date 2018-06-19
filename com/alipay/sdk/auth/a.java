package com.alipay.sdk.auth;

import android.webkit.DownloadListener;

final class a implements DownloadListener {
    final /* synthetic */ AuthActivity a;

    a(AuthActivity authActivity) {
        this.a = authActivity;
    }

    public final void onDownloadStart(java.lang.String r1, java.lang.String r2, java.lang.String r3, java.lang.String r4, long r5) {
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
        r1 = android.net.Uri.parse(r1);	 Catch:{ Throwable -> 0x0011 }
        r2 = new android.content.Intent;	 Catch:{ Throwable -> 0x0011 }
        r3 = "android.intent.action.VIEW";	 Catch:{ Throwable -> 0x0011 }
        r2.<init>(r3, r1);	 Catch:{ Throwable -> 0x0011 }
        r1 = r0.a;	 Catch:{ Throwable -> 0x0011 }
        r1.startActivity(r2);	 Catch:{ Throwable -> 0x0011 }
        return;
    L_0x0011:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.auth.a.onDownloadStart(java.lang.String, java.lang.String, java.lang.String, java.lang.String, long):void");
    }
}
