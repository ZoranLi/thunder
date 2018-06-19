package com.alipay.b.a.a.a;

public final class b {
    public static java.lang.String a(java.lang.String r4, java.lang.String r5) {
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
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r1 = 0;
        r2 = new java.io.File;	 Catch:{ IOException -> 0x003b, all -> 0x0034 }
        r2.<init>(r4, r5);	 Catch:{ IOException -> 0x003b, all -> 0x0034 }
        r4 = r2.exists();	 Catch:{ IOException -> 0x003b, all -> 0x0034 }
        if (r4 != 0) goto L_0x0012;	 Catch:{ IOException -> 0x003b, all -> 0x0034 }
    L_0x0011:
        return r1;	 Catch:{ IOException -> 0x003b, all -> 0x0034 }
    L_0x0012:
        r4 = new java.io.BufferedReader;	 Catch:{ IOException -> 0x003b, all -> 0x0034 }
        r5 = new java.io.InputStreamReader;	 Catch:{ IOException -> 0x003b, all -> 0x0034 }
        r3 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x003b, all -> 0x0034 }
        r3.<init>(r2);	 Catch:{ IOException -> 0x003b, all -> 0x0034 }
        r2 = "UTF-8";	 Catch:{ IOException -> 0x003b, all -> 0x0034 }
        r5.<init>(r3, r2);	 Catch:{ IOException -> 0x003b, all -> 0x0034 }
        r4.<init>(r5);	 Catch:{ IOException -> 0x003b, all -> 0x0034 }
    L_0x0023:
        r5 = r4.readLine();	 Catch:{ IOException -> 0x003c, all -> 0x0031 }
        if (r5 == 0) goto L_0x002d;	 Catch:{ IOException -> 0x003c, all -> 0x0031 }
    L_0x0029:
        r0.append(r5);	 Catch:{ IOException -> 0x003c, all -> 0x0031 }
        goto L_0x0023;
    L_0x002d:
        r4.close();	 Catch:{ Throwable -> 0x003f }
        goto L_0x003f;
    L_0x0031:
        r5 = move-exception;
        r1 = r4;
        goto L_0x0035;
    L_0x0034:
        r5 = move-exception;
    L_0x0035:
        if (r1 == 0) goto L_0x003a;
    L_0x0037:
        r1.close();	 Catch:{ Throwable -> 0x003a }
    L_0x003a:
        throw r5;
    L_0x003b:
        r4 = r1;
    L_0x003c:
        if (r4 == 0) goto L_0x003f;
    L_0x003e:
        goto L_0x002d;
    L_0x003f:
        r4 = r0.toString();
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.a.b.a(java.lang.String, java.lang.String):java.lang.String");
    }
}
