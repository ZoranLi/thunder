package com.huawei.hms.support.log;

import android.content.Context;

/* compiled from: HMSLog */
public class a {
    private static final b a = new b();

    public static void a(Context context, int i, String str) {
        a.a(context, i, str);
        i = new StringBuilder();
        i.append("============================================================================\n");
        i.append("====== ");
        i.append(a(context));
        i.append('\n');
        i.append("============================================================================");
        a.a(str, i.toString());
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
        r0 = r2.getPackageManager();
        if (r0 == 0) goto L_0x0032;
    L_0x0006:
        r2 = r2.getPackageName();	 Catch:{ NameNotFoundException -> 0x002f }
        r1 = 0;	 Catch:{ NameNotFoundException -> 0x002f }
        r2 = r0.getPackageInfo(r2, r1);	 Catch:{ NameNotFoundException -> 0x002f }
        r0 = new java.lang.StringBuilder;	 Catch:{ NameNotFoundException -> 0x002f }
        r1 = "HMS-";	 Catch:{ NameNotFoundException -> 0x002f }
        r0.<init>(r1);	 Catch:{ NameNotFoundException -> 0x002f }
        r1 = r2.versionName;	 Catch:{ NameNotFoundException -> 0x002f }
        r0.append(r1);	 Catch:{ NameNotFoundException -> 0x002f }
        r1 = "(";	 Catch:{ NameNotFoundException -> 0x002f }
        r0.append(r1);	 Catch:{ NameNotFoundException -> 0x002f }
        r2 = r2.versionCode;	 Catch:{ NameNotFoundException -> 0x002f }
        r0.append(r2);	 Catch:{ NameNotFoundException -> 0x002f }
        r2 = ")";	 Catch:{ NameNotFoundException -> 0x002f }
        r0.append(r2);	 Catch:{ NameNotFoundException -> 0x002f }
        r2 = r0.toString();	 Catch:{ NameNotFoundException -> 0x002f }
        return r2;
    L_0x002f:
        r2 = "HMS-[unknown-version]";
        return r2;
    L_0x0032:
        r2 = "HMS-[unknown-version]";
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.support.log.a.a(android.content.Context):java.lang.String");
    }

    public static boolean a() {
        return a.a(3);
    }

    public static boolean b() {
        return a.a(4);
    }

    public static boolean c() {
        return a.a(5);
    }

    public static boolean d() {
        return a.a(6);
    }

    public static void a(String str, String str2) {
        a.a(3, str, str2);
    }

    public static void b(String str, String str2) {
        a.a(4, str, str2);
    }

    public static void c(String str, String str2) {
        a.a(5, str, str2);
    }

    public static void d(String str, String str2) {
        a.a(6, str, str2);
    }
}
