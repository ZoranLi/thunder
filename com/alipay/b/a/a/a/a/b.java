package com.alipay.b.a.a.a.a;

public final class b {
    public static java.lang.String a(java.lang.String r7) {
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
        r0 = 0;
        r1 = com.alipay.b.a.a.a.a.a(r7);	 Catch:{ Exception -> 0x0041 }
        if (r1 == 0) goto L_0x0008;	 Catch:{ Exception -> 0x0041 }
    L_0x0007:
        return r0;	 Catch:{ Exception -> 0x0041 }
    L_0x0008:
        r1 = "SHA-1";	 Catch:{ Exception -> 0x0041 }
        r1 = java.security.MessageDigest.getInstance(r1);	 Catch:{ Exception -> 0x0041 }
        r2 = "UTF-8";	 Catch:{ Exception -> 0x0041 }
        r7 = r7.getBytes(r2);	 Catch:{ Exception -> 0x0041 }
        r1.update(r7);	 Catch:{ Exception -> 0x0041 }
        r7 = r1.digest();	 Catch:{ Exception -> 0x0041 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0041 }
        r1.<init>();	 Catch:{ Exception -> 0x0041 }
        r2 = 0;	 Catch:{ Exception -> 0x0041 }
        r3 = r2;	 Catch:{ Exception -> 0x0041 }
    L_0x0022:
        r4 = r7.length;	 Catch:{ Exception -> 0x0041 }
        if (r3 >= r4) goto L_0x003c;	 Catch:{ Exception -> 0x0041 }
    L_0x0025:
        r4 = "%02x";	 Catch:{ Exception -> 0x0041 }
        r5 = 1;	 Catch:{ Exception -> 0x0041 }
        r5 = new java.lang.Object[r5];	 Catch:{ Exception -> 0x0041 }
        r6 = r7[r3];	 Catch:{ Exception -> 0x0041 }
        r6 = java.lang.Byte.valueOf(r6);	 Catch:{ Exception -> 0x0041 }
        r5[r2] = r6;	 Catch:{ Exception -> 0x0041 }
        r4 = java.lang.String.format(r4, r5);	 Catch:{ Exception -> 0x0041 }
        r1.append(r4);	 Catch:{ Exception -> 0x0041 }
        r3 = r3 + 1;	 Catch:{ Exception -> 0x0041 }
        goto L_0x0022;	 Catch:{ Exception -> 0x0041 }
    L_0x003c:
        r7 = r1.toString();	 Catch:{ Exception -> 0x0041 }
        return r7;
    L_0x0041:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.a.a.b.a(java.lang.String):java.lang.String");
    }
}
