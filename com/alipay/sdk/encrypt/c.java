package com.alipay.sdk.encrypt;

public final class c {
    public static byte[] a(byte[] r6) throws java.io.IOException {
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
        r0 = 0;
        r1 = new java.io.ByteArrayInputStream;	 Catch:{ all -> 0x003e }
        r1.<init>(r6);	 Catch:{ all -> 0x003e }
        r6 = new java.io.ByteArrayOutputStream;	 Catch:{ all -> 0x003b }
        r6.<init>();	 Catch:{ all -> 0x003b }
        r2 = new java.util.zip.GZIPOutputStream;	 Catch:{ all -> 0x0036 }
        r2.<init>(r6);	 Catch:{ all -> 0x0036 }
        r0 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r0 = new byte[r0];	 Catch:{ all -> 0x0034 }
    L_0x0014:
        r3 = r1.read(r0);	 Catch:{ all -> 0x0034 }
        r4 = -1;	 Catch:{ all -> 0x0034 }
        if (r3 == r4) goto L_0x0020;	 Catch:{ all -> 0x0034 }
    L_0x001b:
        r4 = 0;	 Catch:{ all -> 0x0034 }
        r2.write(r0, r4, r3);	 Catch:{ all -> 0x0034 }
        goto L_0x0014;	 Catch:{ all -> 0x0034 }
    L_0x0020:
        r2.flush();	 Catch:{ all -> 0x0034 }
        r2.finish();	 Catch:{ all -> 0x0034 }
        r0 = r6.toByteArray();	 Catch:{ all -> 0x0034 }
        r1.close();	 Catch:{ Exception -> 0x002d }
    L_0x002d:
        r6.close();	 Catch:{ Exception -> 0x0030 }
    L_0x0030:
        r2.close();	 Catch:{ Exception -> 0x0033 }
    L_0x0033:
        return r0;
    L_0x0034:
        r0 = move-exception;
        goto L_0x0043;
    L_0x0036:
        r2 = move-exception;
        r5 = r2;
        r2 = r0;
        r0 = r5;
        goto L_0x0043;
    L_0x003b:
        r6 = move-exception;
        r2 = r0;
        goto L_0x0041;
    L_0x003e:
        r6 = move-exception;
        r1 = r0;
        r2 = r1;
    L_0x0041:
        r0 = r6;
        r6 = r2;
    L_0x0043:
        if (r1 == 0) goto L_0x0048;
    L_0x0045:
        r1.close();	 Catch:{ Exception -> 0x0048 }
    L_0x0048:
        if (r6 == 0) goto L_0x004d;
    L_0x004a:
        r6.close();	 Catch:{ Exception -> 0x004d }
    L_0x004d:
        if (r2 == 0) goto L_0x0052;
    L_0x004f:
        r2.close();	 Catch:{ Exception -> 0x0052 }
    L_0x0052:
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.encrypt.c.a(byte[]):byte[]");
    }

    public static byte[] b(byte[] r8) throws java.io.IOException {
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
        r0 = 0;
        r1 = new java.io.ByteArrayInputStream;	 Catch:{ all -> 0x0041 }
        r1.<init>(r8);	 Catch:{ all -> 0x0041 }
        r8 = new java.util.zip.GZIPInputStream;	 Catch:{ all -> 0x003d }
        r8.<init>(r1);	 Catch:{ all -> 0x003d }
        r2 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r3 = new byte[r2];	 Catch:{ all -> 0x0037 }
        r4 = new java.io.ByteArrayOutputStream;	 Catch:{ all -> 0x0037 }
        r4.<init>();	 Catch:{ all -> 0x0037 }
    L_0x0014:
        r0 = 0;
        r5 = r8.read(r3, r0, r2);	 Catch:{ all -> 0x0031 }
        r6 = -1;	 Catch:{ all -> 0x0031 }
        if (r5 == r6) goto L_0x0020;	 Catch:{ all -> 0x0031 }
    L_0x001c:
        r4.write(r3, r0, r5);	 Catch:{ all -> 0x0031 }
        goto L_0x0014;	 Catch:{ all -> 0x0031 }
    L_0x0020:
        r4.flush();	 Catch:{ all -> 0x0031 }
        r0 = r4.toByteArray();	 Catch:{ all -> 0x0031 }
        r4.close();	 Catch:{ Exception -> 0x002a }
    L_0x002a:
        r8.close();	 Catch:{ Exception -> 0x002d }
    L_0x002d:
        r1.close();	 Catch:{ Exception -> 0x0030 }
    L_0x0030:
        return r0;
    L_0x0031:
        r0 = move-exception;
        r2 = r1;
        r1 = r8;
        r8 = r0;
        r0 = r4;
        goto L_0x0044;
    L_0x0037:
        r2 = move-exception;
        r7 = r1;
        r1 = r8;
        r8 = r2;
        r2 = r7;
        goto L_0x0044;
    L_0x003d:
        r8 = move-exception;
        r2 = r1;
        r1 = r0;
        goto L_0x0044;
    L_0x0041:
        r8 = move-exception;
        r1 = r0;
        r2 = r1;
    L_0x0044:
        r0.close();	 Catch:{ Exception -> 0x0047 }
    L_0x0047:
        r1.close();	 Catch:{ Exception -> 0x004a }
    L_0x004a:
        r2.close();	 Catch:{ Exception -> 0x004d }
    L_0x004d:
        throw r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.encrypt.c.b(byte[]):byte[]");
    }
}
