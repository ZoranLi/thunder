package com.alipay.b.a.a.d;

import android.os.Environment;

public final class b {
    public static java.lang.String a(java.lang.String r2) {
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
        r0 = a();	 Catch:{ Exception -> 0x001e }
        if (r0 == 0) goto L_0x001e;	 Catch:{ Exception -> 0x001e }
    L_0x0006:
        r0 = android.os.Environment.getExternalStorageDirectory();	 Catch:{ Exception -> 0x001e }
        r0 = r0.getAbsolutePath();	 Catch:{ Exception -> 0x001e }
        r1 = new java.io.File;	 Catch:{ Exception -> 0x001e }
        r1.<init>(r0, r2);	 Catch:{ Exception -> 0x001e }
        r1 = r1.exists();	 Catch:{ Exception -> 0x001e }
        if (r1 == 0) goto L_0x001e;	 Catch:{ Exception -> 0x001e }
    L_0x0019:
        r2 = com.alipay.b.a.a.a.b.a(r0, r2);	 Catch:{ Exception -> 0x001e }
        return r2;
    L_0x001e:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.b.a.a.d.b.a(java.lang.String):java.lang.String");
    }

    public static boolean a() {
        String externalStorageState = Environment.getExternalStorageState();
        return externalStorageState != null && externalStorageState.length() > 0 && ((externalStorageState.equals("mounted") || externalStorageState.equals("mounted_ro")) && Environment.getExternalStorageDirectory() != null);
    }
}
