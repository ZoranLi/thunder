package com.alipay.sdk.encrypt;

public final class b {
    private static String a(String str, String str2) {
        return a(1, str, str2);
    }

    private static String b(String str, String str2) {
        return a(2, str, str2);
    }

    public static java.lang.String a(int r2, java.lang.String r3, java.lang.String r4) {
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
        r0 = new javax.crypto.spec.SecretKeySpec;	 Catch:{ Exception -> 0x0033 }
        r4 = r4.getBytes();	 Catch:{ Exception -> 0x0033 }
        r1 = "DES";	 Catch:{ Exception -> 0x0033 }
        r0.<init>(r4, r1);	 Catch:{ Exception -> 0x0033 }
        r4 = "DES";	 Catch:{ Exception -> 0x0033 }
        r4 = javax.crypto.Cipher.getInstance(r4);	 Catch:{ Exception -> 0x0033 }
        r4.init(r2, r0);	 Catch:{ Exception -> 0x0033 }
        r0 = 2;	 Catch:{ Exception -> 0x0033 }
        if (r2 != r0) goto L_0x001c;	 Catch:{ Exception -> 0x0033 }
    L_0x0017:
        r3 = com.alipay.sdk.encrypt.a.a(r3);	 Catch:{ Exception -> 0x0033 }
        goto L_0x0022;	 Catch:{ Exception -> 0x0033 }
    L_0x001c:
        r1 = "UTF-8";	 Catch:{ Exception -> 0x0033 }
        r3 = r3.getBytes(r1);	 Catch:{ Exception -> 0x0033 }
    L_0x0022:
        r3 = r4.doFinal(r3);	 Catch:{ Exception -> 0x0033 }
        if (r2 != r0) goto L_0x002e;	 Catch:{ Exception -> 0x0033 }
    L_0x0028:
        r2 = new java.lang.String;	 Catch:{ Exception -> 0x0033 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0033 }
        goto L_0x0032;	 Catch:{ Exception -> 0x0033 }
    L_0x002e:
        r2 = com.alipay.sdk.encrypt.a.a(r3);	 Catch:{ Exception -> 0x0033 }
    L_0x0032:
        return r2;
    L_0x0033:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.encrypt.b.a(int, java.lang.String, java.lang.String):java.lang.String");
    }
}
