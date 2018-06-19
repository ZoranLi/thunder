package com.baidu.mobads.production;

import dalvik.system.DexClassLoader;

public class a {
    private static DexClassLoader a;

    public static dalvik.system.DexClassLoader a(android.content.Context r6) {
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
        r0 = a;
        if (r0 != 0) goto L_0x0062;
    L_0x0004:
        r0 = 0;
        r1 = "local_vr_imageview.jar";	 Catch:{ Exception -> 0x0060 }
        r2 = "baidu_ad_sdk";	 Catch:{ Exception -> 0x0060 }
        r3 = 0;	 Catch:{ Exception -> 0x0060 }
        r2 = r6.getDir(r2, r3);	 Catch:{ Exception -> 0x0060 }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0060 }
        r3.<init>();	 Catch:{ Exception -> 0x0060 }
        r2 = r2.getAbsolutePath();	 Catch:{ Exception -> 0x0060 }
        r3.append(r2);	 Catch:{ Exception -> 0x0060 }
        r2 = "/";	 Catch:{ Exception -> 0x0060 }
        r3.append(r2);	 Catch:{ Exception -> 0x0060 }
        r2 = r3.toString();	 Catch:{ Exception -> 0x0060 }
        r3 = r6.getFilesDir();	 Catch:{ Exception -> 0x0060 }
        r3 = r3.getAbsolutePath();	 Catch:{ Exception -> 0x0060 }
        r4 = new java.io.File;	 Catch:{ Exception -> 0x0060 }
        r5 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0060 }
        r5.<init>();	 Catch:{ Exception -> 0x0060 }
        r5.append(r2);	 Catch:{ Exception -> 0x0060 }
        r5.append(r1);	 Catch:{ Exception -> 0x0060 }
        r1 = r5.toString();	 Catch:{ Exception -> 0x0060 }
        r4.<init>(r1);	 Catch:{ Exception -> 0x0060 }
        r1 = com.baidu.mobads.production.a.class;	 Catch:{ Exception -> 0x0060 }
        monitor-enter(r1);	 Catch:{ Exception -> 0x0060 }
        r2 = r4.getAbsolutePath();	 Catch:{ all -> 0x005d }
        r6 = r6.getClass();	 Catch:{ all -> 0x005d }
        r6 = r6.getClassLoader();	 Catch:{ all -> 0x005d }
        java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x005d }
        r4 = new dalvik.system.DexClassLoader;	 Catch:{ all -> 0x005d }
        r4.<init>(r2, r3, r0, r6);	 Catch:{ all -> 0x005d }
        java.lang.System.currentTimeMillis();	 Catch:{ all -> 0x005d }
        a = r4;	 Catch:{ all -> 0x005d }
        monitor-exit(r1);	 Catch:{ all -> 0x005d }
        goto L_0x0062;	 Catch:{ all -> 0x005d }
    L_0x005d:
        r6 = move-exception;	 Catch:{ all -> 0x005d }
        monitor-exit(r1);	 Catch:{ all -> 0x005d }
        throw r6;	 Catch:{ Exception -> 0x0060 }
    L_0x0060:
        a = r0;
    L_0x0062:
        r6 = a;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.production.a.a(android.content.Context):dalvik.system.DexClassLoader");
    }
}
