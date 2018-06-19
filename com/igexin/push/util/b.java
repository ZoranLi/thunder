package com.igexin.push.util;

import android.content.Context;

public class b {
    public static void a(d dVar, Context context) {
        new Thread(new c(context, dVar)).start();
    }

    private static boolean c(android.content.Context r6) {
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
        r0 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x003b }
        r0.<init>();	 Catch:{ Exception -> 0x003b }
        r6 = r6.getFilesDir();	 Catch:{ Exception -> 0x003b }
        r6 = r6.getPath();	 Catch:{ Exception -> 0x003b }
        r0.append(r6);	 Catch:{ Exception -> 0x003b }
        r6 = "/init_er.pid";	 Catch:{ Exception -> 0x003b }
        r0.append(r6);	 Catch:{ Exception -> 0x003b }
        r6 = r0.toString();	 Catch:{ Exception -> 0x003b }
        r6 = com.igexin.push.util.e.a(r6);	 Catch:{ Exception -> 0x003b }
        if (r6 == 0) goto L_0x0039;	 Catch:{ Exception -> 0x003b }
    L_0x001f:
        r0 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x003b }
        r2 = new java.lang.String;	 Catch:{ Exception -> 0x003b }
        r2.<init>(r6);	 Catch:{ Exception -> 0x003b }
        r6 = java.lang.Long.valueOf(r2);	 Catch:{ Exception -> 0x003b }
        r2 = r6.longValue();	 Catch:{ Exception -> 0x003b }
        r4 = r0 - r2;
        r0 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;
        r6 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1));
        if (r6 <= 0) goto L_0x003b;
    L_0x0039:
        r6 = 1;
        return r6;
    L_0x003b:
        r6 = 0;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.b.c(android.content.Context):boolean");
    }

    private static java.lang.String d(android.content.Context r10) {
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
        r0 = r10.getPackageName();
        r1 = 0;
        r2 = r10.getPackageManager();	 Catch:{ Exception -> 0x001e }
        r3 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ Exception -> 0x001e }
        r2 = r2.getApplicationInfo(r0, r3);	 Catch:{ Exception -> 0x001e }
        if (r2 == 0) goto L_0x001e;	 Catch:{ Exception -> 0x001e }
    L_0x0011:
        r3 = r2.metaData;	 Catch:{ Exception -> 0x001e }
        if (r3 == 0) goto L_0x001e;	 Catch:{ Exception -> 0x001e }
    L_0x0015:
        r2 = r2.metaData;	 Catch:{ Exception -> 0x001e }
        r3 = "PUSH_APPID";	 Catch:{ Exception -> 0x001e }
        r2 = r2.getString(r3);	 Catch:{ Exception -> 0x001e }
        r1 = r2;
    L_0x001e:
        r2 = android.os.Build.MODEL;
        r3 = android.os.Build.VERSION.SDK;
        r4 = android.os.Build.VERSION.RELEASE;
        r5 = new java.io.File;
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = r10.getApplicationInfo();
        r7 = r7.nativeLibraryDir;
        r6.append(r7);
        r7 = java.io.File.separator;
        r6.append(r7);
        r7 = "libgetuiext2.so";
        r6.append(r7);
        r6 = r6.toString();
        r5.<init>(r6);
        r6 = new java.lang.StringBuilder;
        r6.<init>();
        r7 = new java.text.SimpleDateFormat;
        r8 = "yyyy-MM-dd HH:mm:ss";
        r9 = java.util.Locale.US;
        r7.<init>(r8, r9);
        r8 = new java.util.Date;
        r8.<init>();
        r7 = r7.format(r8);
        r6.append(r7);
        r7 = "|";
        r6.append(r7);
        r6.append(r1);
        r1 = "|";
        r6.append(r1);
        r1 = "2.11.1.0";
        r6.append(r1);
        r1 = "|";
        r6.append(r1);
        r1 = r5.exists();
        r6.append(r1);
        r1 = "|";
        r6.append(r1);
        r1 = com.igexin.push.util.l.a(r10);
        r6.append(r1);
        r1 = "|";
        r6.append(r1);
        r6.append(r2);
        r1 = "|";
        r6.append(r1);
        r6.append(r3);
        r1 = "|";
        r6.append(r1);
        r6.append(r4);
        r1 = "|";
        r6.append(r1);
        r10 = com.igexin.push.util.l.b(r10);
        r6.append(r10);
        r10 = "|";
        r6.append(r10);
        r10 = com.igexin.push.util.l.a();
        r6.append(r10);
        r10 = "|";
        r6.append(r10);
        r6.append(r0);
        r10 = com.igexin.push.util.EncryptUtils.errorMsg;
        if (r10 == 0) goto L_0x00cf;
    L_0x00c5:
        r10 = "|";
        r6.append(r10);
        r10 = com.igexin.push.util.EncryptUtils.errorMsg;
        r6.append(r10);
    L_0x00cf:
        r10 = new java.lang.StringBuilder;
        r0 = "ErrorReport|";
        r10.<init>(r0);
        r0 = r6.toString();
        r10.append(r0);
        r10 = r10.toString();
        com.igexin.b.a.c.a.b(r10);
        r10 = r6.toString();
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.igexin.push.util.b.d(android.content.Context):java.lang.String");
    }
}
