package com.alibaba.baichuan.android.trade.c.a.a;

import java.util.regex.Pattern;

public final class a {
    private static Pattern a = Pattern.compile("\\$\\{([\\d\\w\\._\\-]+)\\}");

    public static java.lang.String a(java.lang.String r3, java.util.Map r4) {
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
        r0 = a;	 Catch:{ Exception -> 0x0081 }
        r3 = r0.matcher(r3);	 Catch:{ Exception -> 0x0081 }
        r0 = new java.lang.StringBuffer;	 Catch:{ Exception -> 0x0081 }
        r0.<init>();	 Catch:{ Exception -> 0x0081 }
    L_0x000b:
        r1 = r3.find();	 Catch:{ Exception -> 0x0081 }
        if (r1 == 0) goto L_0x0079;	 Catch:{ Exception -> 0x0081 }
    L_0x0011:
        r1 = 1;	 Catch:{ Exception -> 0x0081 }
        r1 = r3.group(r1);	 Catch:{ Exception -> 0x0081 }
        r2 = r4.get(r1);	 Catch:{ Exception -> 0x0081 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0081 }
        if (r2 == 0) goto L_0x001f;	 Catch:{ Exception -> 0x0081 }
    L_0x001e:
        goto L_0x0071;	 Catch:{ Exception -> 0x0081 }
    L_0x001f:
        r2 = "ttid";	 Catch:{ Exception -> 0x0081 }
        r2 = r2.equals(r1);	 Catch:{ Exception -> 0x0081 }
        if (r2 == 0) goto L_0x0030;	 Catch:{ Exception -> 0x0081 }
    L_0x0027:
        r1 = com.alibaba.baichuan.android.trade.e.a.g();	 Catch:{ Exception -> 0x0081 }
        r2 = r1.e();	 Catch:{ Exception -> 0x0081 }
        goto L_0x0071;	 Catch:{ Exception -> 0x0081 }
    L_0x0030:
        r2 = "appKey";	 Catch:{ Exception -> 0x0081 }
        r2 = r2.equals(r1);	 Catch:{ Exception -> 0x0081 }
        if (r2 == 0) goto L_0x003d;	 Catch:{ Exception -> 0x0081 }
    L_0x0038:
        r2 = com.alibaba.baichuan.android.trade.AlibcContext.c();	 Catch:{ Exception -> 0x0081 }
        goto L_0x0071;	 Catch:{ Exception -> 0x0081 }
    L_0x003d:
        r2 = "sdkVersion";	 Catch:{ Exception -> 0x0081 }
        r2 = r2.equals(r1);	 Catch:{ Exception -> 0x0081 }
        if (r2 == 0) goto L_0x0048;	 Catch:{ Exception -> 0x0081 }
    L_0x0045:
        r2 = com.alibaba.baichuan.android.trade.AlibcContext.d;	 Catch:{ Exception -> 0x0081 }
        goto L_0x0071;	 Catch:{ Exception -> 0x0081 }
    L_0x0048:
        r2 = "timestamp";	 Catch:{ Exception -> 0x0081 }
        r2 = r2.equals(r1);	 Catch:{ Exception -> 0x0081 }
        if (r2 == 0) goto L_0x0059;	 Catch:{ Exception -> 0x0081 }
    L_0x0050:
        r1 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0081 }
        r2 = java.lang.String.valueOf(r1);	 Catch:{ Exception -> 0x0081 }
        goto L_0x0071;	 Catch:{ Exception -> 0x0081 }
    L_0x0059:
        r2 = "utdid";	 Catch:{ Exception -> 0x0081 }
        r2 = r2.equals(r1);	 Catch:{ Exception -> 0x0081 }
        if (r2 == 0) goto L_0x0066;	 Catch:{ Exception -> 0x0081 }
    L_0x0061:
        r2 = com.alibaba.baichuan.android.trade.AlibcContext.a();	 Catch:{ Exception -> 0x0081 }
        goto L_0x0071;	 Catch:{ Exception -> 0x0081 }
    L_0x0066:
        r2 = com.alibaba.baichuan.android.trade.e.a.g();	 Catch:{ Exception -> 0x0081 }
        r1 = r2.a(r1);	 Catch:{ Exception -> 0x0081 }
        r2 = r1;	 Catch:{ Exception -> 0x0081 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0081 }
    L_0x0071:
        if (r2 != 0) goto L_0x0075;	 Catch:{ Exception -> 0x0081 }
    L_0x0073:
        r2 = "";	 Catch:{ Exception -> 0x0081 }
    L_0x0075:
        r3.appendReplacement(r0, r2);	 Catch:{ Exception -> 0x0081 }
        goto L_0x000b;	 Catch:{ Exception -> 0x0081 }
    L_0x0079:
        r3.appendTail(r0);	 Catch:{ Exception -> 0x0081 }
        r3 = r0.toString();	 Catch:{ Exception -> 0x0081 }
        return r3;
    L_0x0081:
        com.alibaba.baichuan.android.trade.utils.g.a.a();
        r3 = "";
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.baichuan.android.trade.c.a.a.a.a(java.lang.String, java.util.Map):java.lang.String");
    }
}
