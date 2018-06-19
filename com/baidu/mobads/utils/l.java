package com.baidu.mobads.utils;

import com.baidu.mobads.a.a;
import com.baidu.mobads.interfaces.utils.IXAdLogger;

public class l implements IXAdLogger {
    private static volatile l a;

    public static l a() {
        if (a == null) {
            synchronized (l.class) {
                if (a == null) {
                    a = new l();
                }
            }
        }
        return a;
    }

    public boolean isLoggable(String str, int i) {
        return i >= a.b ? true : null;
    }

    public boolean isLoggable(int i) {
        return isLoggable(IXAdLogger.TAG, i);
    }

    private String a(Object[] objArr) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Object append : objArr) {
            stringBuilder.append(append);
            stringBuilder.append(' ');
        }
        return stringBuilder.toString();
    }

    public int d(Object... objArr) {
        if (isLoggable(3)) {
            return d(a(objArr));
        }
        return -1;
    }

    public int d(String str) {
        return d(IXAdLogger.TAG, str);
    }

    public int d(java.lang.String r3, java.lang.String r4) {
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
        r2 = this;
        r0 = 3;
        r0 = r2.isLoggable(r0);
        r1 = -1;
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return r1;
    L_0x0009:
        r3 = android.util.Log.d(r3, r4);	 Catch:{ Exception -> 0x000e }
        return r3;
    L_0x000e:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.l.d(java.lang.String, java.lang.String):int");
    }

    public int d(Throwable th) {
        return d("", th);
    }

    public int d(java.lang.String r3, java.lang.Throwable r4) {
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
        r2 = this;
        r0 = 3;
        r0 = r2.isLoggable(r0);
        r1 = -1;
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return r1;
    L_0x0009:
        r0 = "BaiduXAdSDK";	 Catch:{ Exception -> 0x0010 }
        r3 = android.util.Log.d(r0, r3, r4);	 Catch:{ Exception -> 0x0010 }
        return r3;
    L_0x0010:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.l.d(java.lang.String, java.lang.Throwable):int");
    }

    public int w(java.lang.String r3) {
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
        r2 = this;
        r0 = 5;
        r0 = r2.isLoggable(r0);
        r1 = -1;
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return r1;
    L_0x0009:
        r0 = "BaiduXAdSDK";	 Catch:{ Exception -> 0x0010 }
        r3 = android.util.Log.w(r0, r3);	 Catch:{ Exception -> 0x0010 }
        return r3;
    L_0x0010:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.l.w(java.lang.String):int");
    }

    public int w(Object... objArr) {
        if (isLoggable(5)) {
            return w(a(objArr));
        }
        return -1;
    }

    public int w(java.lang.String r3, java.lang.Throwable r4) {
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
        r2 = this;
        r0 = 5;
        r0 = r2.isLoggable(r0);
        r1 = -1;
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return r1;
    L_0x0009:
        r0 = "BaiduXAdSDK";	 Catch:{ Exception -> 0x0010 }
        r3 = android.util.Log.w(r0, r3, r4);	 Catch:{ Exception -> 0x0010 }
        return r3;
    L_0x0010:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.l.w(java.lang.String, java.lang.Throwable):int");
    }

    public int w(Throwable th) {
        return w("", th);
    }

    public int e(Object... objArr) {
        if (isLoggable(6)) {
            return e(a(objArr));
        }
        return -1;
    }

    public int e(java.lang.String r3) {
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
        r2 = this;
        r0 = 6;
        r0 = r2.isLoggable(r0);
        r1 = -1;
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return r1;
    L_0x0009:
        r0 = "BaiduXAdSDK";	 Catch:{ Exception -> 0x0010 }
        r3 = android.util.Log.e(r0, r3);	 Catch:{ Exception -> 0x0010 }
        return r3;
    L_0x0010:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.l.e(java.lang.String):int");
    }

    public int e(Throwable th) {
        return e("", th);
    }

    public int e(java.lang.String r3, java.lang.Throwable r4) {
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
        r2 = this;
        r0 = 6;
        r0 = r2.isLoggable(r0);
        r1 = -1;
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return r1;
    L_0x0009:
        r0 = "BaiduXAdSDK";	 Catch:{ Exception -> 0x0010 }
        r3 = android.util.Log.e(r0, r3, r4);	 Catch:{ Exception -> 0x0010 }
        return r3;
    L_0x0010:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.l.e(java.lang.String, java.lang.Throwable):int");
    }

    public int i(String str) {
        return i(IXAdLogger.TAG, str);
    }

    public int i(java.lang.String r3, java.lang.String r4) {
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
        r2 = this;
        r0 = 4;
        r0 = r2.isLoggable(r0);
        r1 = -1;
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return r1;
    L_0x0009:
        r3 = android.util.Log.i(r3, r4);	 Catch:{ Exception -> 0x000e }
        return r3;
    L_0x000e:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.l.i(java.lang.String, java.lang.String):int");
    }

    public int i(Object... objArr) {
        if (isLoggable(4)) {
            return i(a(objArr));
        }
        return -1;
    }

    public int i(java.lang.String r3, java.lang.Throwable r4) {
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
        r2 = this;
        r0 = 4;
        r0 = r2.isLoggable(r0);
        r1 = -1;
        if (r0 != 0) goto L_0x0009;
    L_0x0008:
        return r1;
    L_0x0009:
        r0 = "BaiduXAdSDK";	 Catch:{ Exception -> 0x0010 }
        r3 = android.util.Log.i(r0, r3, r4);	 Catch:{ Exception -> 0x0010 }
        return r3;
    L_0x0010:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.utils.l.i(java.lang.String, java.lang.Throwable):int");
    }
}
