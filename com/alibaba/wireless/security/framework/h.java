package com.alibaba.wireless.security.framework;

public class h {
    public static String a(ClassLoader classLoader, String str) {
        String str2;
        if (classLoader == null || str == null || "".equals(str)) {
            str2 = null;
        } else {
            str2 = a(classLoader, str, true);
            if (str2 == null) {
                return a(classLoader, str, false);
            }
        }
        return str2;
    }

    private static java.lang.String a(java.lang.ClassLoader r6, java.lang.String r7, boolean r8) {
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
        if (r6 == 0) goto L_0x0044;
    L_0x0003:
        r1 = 0;
        r2 = 1;
        if (r8 == 0) goto L_0x0018;
    L_0x0007:
        r8 = r6.getClass();	 Catch:{ NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044 }
        r3 = "findLibrary";	 Catch:{ NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044 }
        r4 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044 }
        r5 = java.lang.String.class;	 Catch:{ NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044 }
        r4[r1] = r5;	 Catch:{ NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044 }
        r8 = r8.getMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044 }
        goto L_0x0028;	 Catch:{ NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044 }
    L_0x0018:
        r8 = r6.getClass();	 Catch:{ NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044 }
        r3 = "findLibrary";	 Catch:{ NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044 }
        r4 = new java.lang.Class[r2];	 Catch:{ NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044 }
        r5 = java.lang.String.class;	 Catch:{ NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044 }
        r4[r1] = r5;	 Catch:{ NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044 }
        r8 = r8.getDeclaredMethod(r3, r4);	 Catch:{ NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044 }
    L_0x0028:
        if (r8 == 0) goto L_0x0044;	 Catch:{ NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044 }
    L_0x002a:
        r3 = r8.isAccessible();	 Catch:{ NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044 }
        if (r3 != 0) goto L_0x0033;	 Catch:{ NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044 }
    L_0x0030:
        r8.setAccessible(r2);	 Catch:{ NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044 }
    L_0x0033:
        r2 = new java.lang.Object[r2];	 Catch:{ NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044 }
        r2[r1] = r7;	 Catch:{ NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044 }
        r6 = r8.invoke(r6, r2);	 Catch:{ NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044 }
        if (r6 == 0) goto L_0x0044;	 Catch:{ NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044 }
    L_0x003d:
        r7 = r6 instanceof java.lang.String;	 Catch:{ NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044 }
        if (r7 == 0) goto L_0x0044;	 Catch:{ NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044 }
    L_0x0041:
        r6 = (java.lang.String) r6;	 Catch:{ NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044, NoSuchMethodException -> 0x0044 }
        r0 = r6;
    L_0x0044:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.h.a(java.lang.ClassLoader, java.lang.String, boolean):java.lang.String");
    }

    public static boolean a(android.content.Context r3) {
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
        r0 = r3.getPackageManager();
        r1 = 0;
        r3 = r3.getPackageName();	 Catch:{ Throwable -> 0x0020 }
        r3 = r0.getPackageInfo(r3, r1);	 Catch:{ Throwable -> 0x0020 }
        r0 = 1;	 Catch:{ Throwable -> 0x0020 }
        if (r3 == 0) goto L_0x0020;	 Catch:{ Throwable -> 0x0020 }
    L_0x0010:
        r2 = r3.applicationInfo;	 Catch:{ Throwable -> 0x0020 }
        r2 = r2.flags;	 Catch:{ Throwable -> 0x0020 }
        r2 = r2 & r0;	 Catch:{ Throwable -> 0x0020 }
        if (r2 == 0) goto L_0x0020;	 Catch:{ Throwable -> 0x0020 }
    L_0x0017:
        r3 = r3.applicationInfo;	 Catch:{ Throwable -> 0x0020 }
        r3 = r3.flags;	 Catch:{ Throwable -> 0x0020 }
        r3 = r3 & 128;
        if (r3 != 0) goto L_0x0020;
    L_0x001f:
        r1 = r0;
    L_0x0020:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.wireless.security.framework.h.a(android.content.Context):boolean");
    }
}
