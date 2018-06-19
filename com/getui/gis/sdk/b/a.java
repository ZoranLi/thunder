package com.getui.gis.sdk.b;

import com.getui.gis.sdk.a.b;

public class a {
    public static String a = "GISDK";

    private static java.lang.String a() {
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
        r0 = java.lang.Thread.currentThread();	 Catch:{ Throwable -> 0x0058 }
        r0 = r0.getStackTrace();	 Catch:{ Throwable -> 0x0058 }
        r1 = 4;	 Catch:{ Throwable -> 0x0058 }
        r0 = r0[r1];	 Catch:{ Throwable -> 0x0058 }
        r1 = "%s.%s(L:%d)";	 Catch:{ Throwable -> 0x0058 }
        r2 = r0.getClassName();	 Catch:{ Throwable -> 0x0058 }
        r3 = ".";	 Catch:{ Throwable -> 0x0058 }
        r3 = r2.lastIndexOf(r3);	 Catch:{ Throwable -> 0x0058 }
        r4 = 1;	 Catch:{ Throwable -> 0x0058 }
        r3 = r3 + r4;	 Catch:{ Throwable -> 0x0058 }
        r2 = r2.substring(r3);	 Catch:{ Throwable -> 0x0058 }
        r3 = 3;	 Catch:{ Throwable -> 0x0058 }
        r3 = new java.lang.Object[r3];	 Catch:{ Throwable -> 0x0058 }
        r5 = 0;	 Catch:{ Throwable -> 0x0058 }
        r3[r5] = r2;	 Catch:{ Throwable -> 0x0058 }
        r2 = r0.getMethodName();	 Catch:{ Throwable -> 0x0058 }
        r3[r4] = r2;	 Catch:{ Throwable -> 0x0058 }
        r2 = 2;	 Catch:{ Throwable -> 0x0058 }
        r0 = r0.getLineNumber();	 Catch:{ Throwable -> 0x0058 }
        r0 = java.lang.Integer.valueOf(r0);	 Catch:{ Throwable -> 0x0058 }
        r3[r2] = r0;	 Catch:{ Throwable -> 0x0058 }
        r0 = java.lang.String.format(r1, r3);	 Catch:{ Throwable -> 0x0058 }
        r1 = a;	 Catch:{ Throwable -> 0x0058 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x0058 }
        if (r1 == 0) goto L_0x0041;	 Catch:{ Throwable -> 0x0058 }
    L_0x0040:
        return r0;	 Catch:{ Throwable -> 0x0058 }
    L_0x0041:
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0058 }
        r1.<init>();	 Catch:{ Throwable -> 0x0058 }
        r2 = a;	 Catch:{ Throwable -> 0x0058 }
        r1.append(r2);	 Catch:{ Throwable -> 0x0058 }
        r2 = "-";	 Catch:{ Throwable -> 0x0058 }
        r1.append(r2);	 Catch:{ Throwable -> 0x0058 }
        r1.append(r0);	 Catch:{ Throwable -> 0x0058 }
        r0 = r1.toString();	 Catch:{ Throwable -> 0x0058 }
        return r0;
    L_0x0058:
        r0 = "";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gis.sdk.b.a.a():java.lang.String");
    }

    public static void a(Object obj) {
        if (b.b) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a());
            stringBuilder.append(": ");
            stringBuilder.append(obj);
            a(stringBuilder.toString());
        }
    }

    private static synchronized void a(java.lang.String r6) {
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
        r0 = com.getui.gis.sdk.b.a.class;
        monitor-enter(r0);
        r1 = com.getui.gis.sdk.a.b.a;	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        if (r1 != 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r0);
        return;
    L_0x0009:
        r1 = new java.text.SimpleDateFormat;	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        r2 = "yyyy-MM-dd";	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        r1.<init>(r2);	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        r2 = new java.util.Date;	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        r2.<init>();	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        r1 = r1.format(r2);	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        r2.<init>();	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        r3 = com.getui.gis.sdk.a.b.a;	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        r3 = r3.getPackageName();	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        r2.append(r3);	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        r3 = ".gtc";	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        r2.append(r3);	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        r2 = r2.toString();	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        if (r2 == 0) goto L_0x00d0;	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
    L_0x0032:
        r3 = "";	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        r3 = r3.equals(r2);	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        if (r3 == 0) goto L_0x003c;	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
    L_0x003a:
        goto L_0x00d0;	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
    L_0x003c:
        r3 = android.os.Environment.getExternalStorageState();	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        r4 = "mounted";	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        r3 = r3.equals(r4);	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        if (r3 == 0) goto L_0x00ce;	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
    L_0x0048:
        r3 = "/sdcard/libs/";	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        r4 = new java.io.File;	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        r4.<init>(r3);	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        r5 = r4.exists();	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
        if (r5 != 0) goto L_0x0058;	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
    L_0x0055:
        r4.mkdir();	 Catch:{ Throwable -> 0x00d5, all -> 0x00d2 }
    L_0x0058:
        r4 = new java.io.File;	 Catch:{ Exception -> 0x00ce }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ce }
        r5.<init>();	 Catch:{ Exception -> 0x00ce }
        r5.append(r3);	 Catch:{ Exception -> 0x00ce }
        r5.append(r2);	 Catch:{ Exception -> 0x00ce }
        r2 = ".";	 Catch:{ Exception -> 0x00ce }
        r5.append(r2);	 Catch:{ Exception -> 0x00ce }
        r5.append(r1);	 Catch:{ Exception -> 0x00ce }
        r1 = ".log";	 Catch:{ Exception -> 0x00ce }
        r5.append(r1);	 Catch:{ Exception -> 0x00ce }
        r1 = r5.toString();	 Catch:{ Exception -> 0x00ce }
        r4.<init>(r1);	 Catch:{ Exception -> 0x00ce }
        r1 = r4.exists();	 Catch:{ Exception -> 0x00ce }
        if (r1 != 0) goto L_0x0087;	 Catch:{ Exception -> 0x00ce }
    L_0x007f:
        r1 = r4.createNewFile();	 Catch:{ Exception -> 0x00ce }
        if (r1 != 0) goto L_0x0087;
    L_0x0085:
        monitor-exit(r0);
        return;
    L_0x0087:
        r1 = new java.io.FileOutputStream;	 Catch:{ Exception -> 0x00ce }
        r2 = 1;	 Catch:{ Exception -> 0x00ce }
        r1.<init>(r4, r2);	 Catch:{ Exception -> 0x00ce }
        r2 = new java.text.SimpleDateFormat;	 Catch:{ Exception -> 0x00ce }
        r3 = "yyyy-MM-dd HH:mm:ss";	 Catch:{ Exception -> 0x00ce }
        r2.<init>(r3);	 Catch:{ Exception -> 0x00ce }
        r3 = new java.util.Date;	 Catch:{ Exception -> 0x00ce }
        r3.<init>();	 Catch:{ Exception -> 0x00ce }
        r2 = r2.format(r3);	 Catch:{ Exception -> 0x00ce }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ce }
        r3.<init>();	 Catch:{ Exception -> 0x00ce }
        r3.append(r2);	 Catch:{ Exception -> 0x00ce }
        r2 = "|";	 Catch:{ Exception -> 0x00ce }
        r3.append(r2);	 Catch:{ Exception -> 0x00ce }
        r3.append(r6);	 Catch:{ Exception -> 0x00ce }
        r6 = r3.toString();	 Catch:{ Exception -> 0x00ce }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ce }
        r2.<init>();	 Catch:{ Exception -> 0x00ce }
        r2.append(r6);	 Catch:{ Exception -> 0x00ce }
        r6 = "\r\n";	 Catch:{ Exception -> 0x00ce }
        r2.append(r6);	 Catch:{ Exception -> 0x00ce }
        r6 = r2.toString();	 Catch:{ Exception -> 0x00ce }
        r6 = r6.getBytes();	 Catch:{ Exception -> 0x00ce }
        r1.write(r6);	 Catch:{ Exception -> 0x00ce }
        r1.close();	 Catch:{ Exception -> 0x00ce }
        monitor-exit(r0);
        return;
    L_0x00ce:
        monitor-exit(r0);
        return;
    L_0x00d0:
        monitor-exit(r0);
        return;
    L_0x00d2:
        r6 = move-exception;
        monitor-exit(r0);
        throw r6;
    L_0x00d5:
        monitor-exit(r0);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getui.gis.sdk.b.a.a(java.lang.String):void");
    }

    public static void a(Throwable th) {
        if (b.b) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a());
            stringBuilder.append(": ");
            stringBuilder.append(th.toString());
            a(stringBuilder.toString());
        }
    }
}
