package com.huawei.hms.support.api.push.a;

import android.content.Context;
import android.content.Intent;
import anet.channel.strategy.dispatch.DispatchConstants;
import java.io.File;

/* compiled from: CommFun */
public abstract class a {
    private static int a = -1;
    private static final Object b = new Object();

    private static boolean c(Context context) {
        if (com.huawei.hms.support.log.a.a()) {
            StringBuilder stringBuilder = new StringBuilder("existFrameworkPush:");
            stringBuilder.append(a);
            com.huawei.hms.support.log.a.a("CommFun", stringBuilder.toString());
        }
        try {
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("/system/framework/");
            stringBuilder2.append("hwpush.jar");
            if (!new File(stringBuilder2.toString()).isFile()) {
                return false;
            }
            if (com.huawei.hms.support.log.a.a()) {
                com.huawei.hms.support.log.a.a("CommFun", "push jarFile is exist");
            }
            context = context.getPackageManager().queryIntentServices(new Intent().setClassName(DispatchConstants.ANDROID, "com.huawei.android.pushagentproxy.PushService"), 128);
            if (context != null) {
                if (context.isEmpty() == null) {
                    if (com.huawei.hms.support.log.a.b() != null) {
                        com.huawei.hms.support.log.a.b("CommFun", "framework push exist, use framework push first");
                    }
                    return true;
                }
            }
            if (com.huawei.hms.support.log.a.b() != null) {
                com.huawei.hms.support.log.a.b("CommFun", "framework push not exist, need vote apk or sdk to support pushservice");
            }
            return false;
        } catch (Context context2) {
            if (com.huawei.hms.support.log.a.a()) {
                StringBuilder stringBuilder3 = new StringBuilder("get Apk version faild ,Exception e= ");
                stringBuilder3.append(context2.toString());
                com.huawei.hms.support.log.a.d("CommFun", stringBuilder3.toString());
            }
            return false;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(android.content.Context r5) {
        /*
        r0 = com.huawei.hms.support.log.a.a();
        if (r0 == 0) goto L_0x001b;
    L_0x0006:
        r0 = "CommFun";
        r1 = new java.lang.StringBuilder;
        r2 = "existFrameworkPush:";
        r1.<init>(r2);
        r2 = a;
        r1.append(r2);
        r1 = r1.toString();
        com.huawei.hms.support.log.a.a(r0, r1);
    L_0x001b:
        r0 = b;
        monitor-enter(r0);
        r1 = -1;
        r2 = a;	 Catch:{ all -> 0x003e }
        r3 = 0;
        r4 = 1;
        if (r1 == r2) goto L_0x002c;
    L_0x0025:
        r5 = a;	 Catch:{ all -> 0x003e }
        if (r4 != r5) goto L_0x002a;
    L_0x0029:
        r3 = r4;
    L_0x002a:
        monitor-exit(r0);	 Catch:{ all -> 0x003e }
        return r3;
    L_0x002c:
        r5 = c(r5);	 Catch:{ all -> 0x003e }
        if (r5 == 0) goto L_0x0035;
    L_0x0032:
        a = r4;	 Catch:{ all -> 0x003e }
        goto L_0x0037;
    L_0x0035:
        a = r3;	 Catch:{ all -> 0x003e }
    L_0x0037:
        monitor-exit(r0);	 Catch:{ all -> 0x003e }
        r5 = a;
        if (r4 != r5) goto L_0x003d;
    L_0x003c:
        return r4;
    L_0x003d:
        return r3;
    L_0x003e:
        r5 = move-exception;
        monitor-exit(r0);	 Catch:{ all -> 0x003e }
        throw r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.support.api.push.a.a.a(android.content.Context):boolean");
    }

    public static boolean a(android.content.Context r2, java.lang.String r3) {
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
        if (r2 == 0) goto L_0x0034;
    L_0x0003:
        r1 = android.text.TextUtils.isEmpty(r3);
        if (r1 == 0) goto L_0x000a;
    L_0x0009:
        goto L_0x0034;
    L_0x000a:
        r2 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0033 }
        r2 = r2.getApplicationInfo(r3, r0);	 Catch:{ NameNotFoundException -> 0x0033 }
        if (r2 != 0) goto L_0x0015;	 Catch:{ NameNotFoundException -> 0x0033 }
    L_0x0014:
        return r0;	 Catch:{ NameNotFoundException -> 0x0033 }
    L_0x0015:
        r2 = com.huawei.hms.support.log.a.a();	 Catch:{ NameNotFoundException -> 0x0033 }
        if (r2 == 0) goto L_0x0031;	 Catch:{ NameNotFoundException -> 0x0033 }
    L_0x001b:
        r2 = "CommFun";	 Catch:{ NameNotFoundException -> 0x0033 }
        r1 = new java.lang.StringBuilder;	 Catch:{ NameNotFoundException -> 0x0033 }
        r1.<init>();	 Catch:{ NameNotFoundException -> 0x0033 }
        r1.append(r3);	 Catch:{ NameNotFoundException -> 0x0033 }
        r3 = " is installed";	 Catch:{ NameNotFoundException -> 0x0033 }
        r1.append(r3);	 Catch:{ NameNotFoundException -> 0x0033 }
        r3 = r1.toString();	 Catch:{ NameNotFoundException -> 0x0033 }
        com.huawei.hms.support.log.a.a(r2, r3);	 Catch:{ NameNotFoundException -> 0x0033 }
    L_0x0031:
        r2 = 1;
        return r2;
    L_0x0033:
        return r0;
    L_0x0034:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.support.api.push.a.a.a(android.content.Context, java.lang.String):boolean");
    }

    public static java.lang.String b(android.content.Context r4) {
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
        r0 = "0.0";
        r1 = r4.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0031, Exception -> 0x0012 }
        r4 = r4.getPackageName();	 Catch:{ NameNotFoundException -> 0x0031, Exception -> 0x0012 }
        r2 = 0;	 Catch:{ NameNotFoundException -> 0x0031, Exception -> 0x0012 }
        r4 = r1.getPackageInfo(r4, r2);	 Catch:{ NameNotFoundException -> 0x0031, Exception -> 0x0012 }
        r4 = r4.versionName;	 Catch:{ NameNotFoundException -> 0x0031, Exception -> 0x0012 }
        goto L_0x003f;
    L_0x0012:
        r4 = move-exception;
        r1 = com.huawei.hms.support.log.a.a();
        if (r1 == 0) goto L_0x003e;
    L_0x0019:
        r1 = "CommFun";
        r2 = new java.lang.StringBuilder;
        r3 = "getApkVersionName error";
        r2.<init>(r3);
        r4 = r4.getMessage();
        r2.append(r4);
        r4 = r2.toString();
        com.huawei.hms.support.log.a.d(r1, r4);
        goto L_0x003e;
    L_0x0031:
        r4 = com.huawei.hms.support.log.a.a();
        if (r4 == 0) goto L_0x003e;
    L_0x0037:
        r4 = "CommFun";
        r1 = "package not exist";
        com.huawei.hms.support.log.a.a(r4, r1);
    L_0x003e:
        r4 = r0;
    L_0x003f:
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.support.api.push.a.a.b(android.content.Context):java.lang.String");
    }
}
