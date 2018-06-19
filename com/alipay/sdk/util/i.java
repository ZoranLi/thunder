package com.alipay.sdk.util;

public final class i {
    private static String a;

    private static boolean b(android.content.Context r0, java.lang.String r1) {
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
        r0 = android.preference.PreferenceManager.getDefaultSharedPreferences(r0);	 Catch:{ Throwable -> 0x0009 }
        r0 = r0.contains(r1);	 Catch:{ Throwable -> 0x0009 }
        goto L_0x000a;
    L_0x0009:
        r0 = 0;
    L_0x000a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.i.b(android.content.Context, java.lang.String):boolean");
    }

    public static void a(android.content.Context r0, java.lang.String r1) {
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
        r0 = android.preference.PreferenceManager.getDefaultSharedPreferences(r0);	 Catch:{ Throwable -> 0x0010 }
        r0 = r0.edit();	 Catch:{ Throwable -> 0x0010 }
        r0 = r0.remove(r1);	 Catch:{ Throwable -> 0x0010 }
        r0.commit();	 Catch:{ Throwable -> 0x0010 }
        return;
    L_0x0010:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.i.a(android.content.Context, java.lang.String):void");
    }

    public static void a(android.content.Context r4, java.lang.String r5, java.lang.String r6) {
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
        r0 = a(r4);	 Catch:{ Throwable -> 0x003a }
        r0 = com.alipay.sdk.encrypt.e.a(r0, r6);	 Catch:{ Throwable -> 0x003a }
        r1 = android.text.TextUtils.isEmpty(r6);	 Catch:{ Throwable -> 0x003a }
        if (r1 != 0) goto L_0x002a;	 Catch:{ Throwable -> 0x003a }
    L_0x000e:
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Throwable -> 0x003a }
        if (r1 == 0) goto L_0x002a;	 Catch:{ Throwable -> 0x003a }
    L_0x0014:
        r1 = "%s,%s";	 Catch:{ Throwable -> 0x003a }
        r2 = 2;	 Catch:{ Throwable -> 0x003a }
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x003a }
        r3 = 0;	 Catch:{ Throwable -> 0x003a }
        r2[r3] = r5;	 Catch:{ Throwable -> 0x003a }
        r3 = 1;	 Catch:{ Throwable -> 0x003a }
        r2[r3] = r6;	 Catch:{ Throwable -> 0x003a }
        r6 = java.lang.String.format(r1, r2);	 Catch:{ Throwable -> 0x003a }
        r1 = "cp";	 Catch:{ Throwable -> 0x003a }
        r2 = "TriDesDecryptError";	 Catch:{ Throwable -> 0x003a }
        com.alipay.sdk.app.statistic.a.a(r1, r2, r6);	 Catch:{ Throwable -> 0x003a }
    L_0x002a:
        r4 = android.preference.PreferenceManager.getDefaultSharedPreferences(r4);	 Catch:{ Throwable -> 0x003a }
        r4 = r4.edit();	 Catch:{ Throwable -> 0x003a }
        r4 = r4.putString(r5, r0);	 Catch:{ Throwable -> 0x003a }
        r4.commit();	 Catch:{ Throwable -> 0x003a }
        return;
    L_0x003a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.i.a(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static java.lang.String b(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
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
        r1 = android.preference.PreferenceManager.getDefaultSharedPreferences(r3);	 Catch:{ Exception -> 0x003a }
        r5 = r1.getString(r4, r5);	 Catch:{ Exception -> 0x003a }
        r1 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Exception -> 0x003a }
        if (r1 != 0) goto L_0x0018;	 Catch:{ Exception -> 0x003a }
    L_0x000f:
        r3 = a(r3);	 Catch:{ Exception -> 0x003a }
        r3 = com.alipay.sdk.encrypt.e.b(r3, r5);	 Catch:{ Exception -> 0x003a }
        r0 = r3;	 Catch:{ Exception -> 0x003a }
    L_0x0018:
        r3 = android.text.TextUtils.isEmpty(r5);	 Catch:{ Exception -> 0x003a }
        if (r3 != 0) goto L_0x003a;	 Catch:{ Exception -> 0x003a }
    L_0x001e:
        r3 = android.text.TextUtils.isEmpty(r0);	 Catch:{ Exception -> 0x003a }
        if (r3 == 0) goto L_0x003a;	 Catch:{ Exception -> 0x003a }
    L_0x0024:
        r3 = "%s,%s";	 Catch:{ Exception -> 0x003a }
        r1 = 2;	 Catch:{ Exception -> 0x003a }
        r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x003a }
        r2 = 0;	 Catch:{ Exception -> 0x003a }
        r1[r2] = r4;	 Catch:{ Exception -> 0x003a }
        r4 = 1;	 Catch:{ Exception -> 0x003a }
        r1[r4] = r5;	 Catch:{ Exception -> 0x003a }
        r3 = java.lang.String.format(r3, r1);	 Catch:{ Exception -> 0x003a }
        r4 = "cp";	 Catch:{ Exception -> 0x003a }
        r5 = "TriDesEncryptError";	 Catch:{ Exception -> 0x003a }
        com.alipay.sdk.app.statistic.a.a(r4, r5, r3);	 Catch:{ Exception -> 0x003a }
    L_0x003a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.i.b(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    private static java.lang.String a(android.content.Context r2) {
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
        r0 = a;
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x002e;
    L_0x0008:
        r0 = "";
        r2 = r2.getApplicationContext();	 Catch:{ Throwable -> 0x0013 }
        r2 = r2.getPackageName();	 Catch:{ Throwable -> 0x0013 }
        goto L_0x0014;
    L_0x0013:
        r2 = r0;
    L_0x0014:
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r0.append(r2);
        r2 = "0000000000000000000000000000";
        r0.append(r2);
        r2 = r0.toString();
        r0 = 0;
        r1 = 24;
        r2 = r2.substring(r0, r1);
        a = r2;
    L_0x002e:
        r2 = a;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.sdk.util.i.a(android.content.Context):java.lang.String");
    }
}
