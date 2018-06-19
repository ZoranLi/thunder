package com.igexin.assist.util;

public class AssistUtils {
    public static void startGetuiService(android.content.Context r3) {
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
        if (r3 == 0) goto L_0x001f;
    L_0x0002:
        r0 = "us";	 Catch:{ Throwable -> 0x001f }
        r1 = "";	 Catch:{ Throwable -> 0x001f }
        r0 = com.igexin.push.util.p.b(r3, r0, r1);	 Catch:{ Throwable -> 0x001f }
        r0 = (java.lang.String) r0;	 Catch:{ Throwable -> 0x001f }
        r1 = 0;	 Catch:{ Throwable -> 0x001f }
        r2 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x001f }
        if (r2 != 0) goto L_0x0017;	 Catch:{ Throwable -> 0x001f }
    L_0x0013:
        r1 = java.lang.Class.forName(r0);	 Catch:{ Throwable -> 0x001f }
    L_0x0017:
        r0 = com.igexin.sdk.PushManager.getInstance();	 Catch:{ Throwable -> 0x001f }
        r0.initialize(r3, r1);	 Catch:{ Throwable -> 0x001f }
        return;
    L_0x001f:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.assist.util.AssistUtils.startGetuiService(android.content.Context):void");
    }
}
