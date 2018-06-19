package com.huawei.hms.c;

import android.content.Context;
import android.content.ServiceConnection;
import android.text.TextUtils;
import com.huawei.hms.support.log.a;
import java.util.Locale;

/* compiled from: Util */
public class g {
    public static boolean a() {
        Object obj = "";
        Object obj2 = "";
        try {
            Object a = a("android.os.SystemProperties", "get", new Class[]{String.class}, new Object[]{"ro.product.locale.language"});
            Object a2 = a("android.os.SystemProperties", "get", new Class[]{String.class}, new Object[]{"ro.product.locale.region"});
            if (a != null) {
                obj = (String) a;
            }
            if (a2 != null) {
                obj2 = (String) a2;
            }
        } catch (Exception e) {
            StringBuilder stringBuilder = new StringBuilder("can not get language and region:");
            stringBuilder.append(e.getMessage());
            a.d("Util", stringBuilder.toString());
        }
        if (!TextUtils.isEmpty(obj)) {
            if (!TextUtils.isEmpty(obj2)) {
                return "zh".equalsIgnoreCase(obj) && "cn".equalsIgnoreCase(obj2);
            }
        }
        return b();
    }

    public static boolean b() {
        return "cn".equalsIgnoreCase(Locale.getDefault().getCountry());
    }

    public static java.lang.Object a(java.lang.String r5, java.lang.String r6, java.lang.Class<?>[] r7, java.lang.Object[] r8) {
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
        if (r7 == 0) goto L_0x0098;
    L_0x0003:
        if (r8 == 0) goto L_0x0098;
    L_0x0005:
        r1 = r7.length;
        r2 = r8.length;
        if (r1 == r2) goto L_0x000b;
    L_0x0009:
        goto L_0x0098;
    L_0x000b:
        r1 = a(r5);
        if (r1 != 0) goto L_0x0012;
    L_0x0011:
        return r0;
    L_0x0012:
        r2 = java.lang.Class.forName(r5);	 Catch:{ ClassNotFoundException -> 0x0017 }
        goto L_0x002b;
    L_0x0017:
        r2 = "Util";
        r3 = new java.lang.StringBuilder;
        r4 = "can not find class:";
        r3.<init>(r4);
        r3.append(r5);
        r5 = r3.toString();
        com.huawei.hms.support.log.a.d(r2, r5);
        r2 = r0;
    L_0x002b:
        if (r2 == 0) goto L_0x0045;
    L_0x002d:
        r5 = r2.getMethod(r6, r7);	 Catch:{ NoSuchMethodException -> 0x0032 }
        goto L_0x0046;
    L_0x0032:
        r5 = "Util";
        r7 = new java.lang.StringBuilder;
        r2 = "can not find method:";
        r7.<init>(r2);
        r7.append(r6);
        r6 = r7.toString();
        com.huawei.hms.support.log.a.d(r5, r6);
    L_0x0045:
        r5 = r0;
    L_0x0046:
        if (r5 == 0) goto L_0x0097;
    L_0x0048:
        r5 = r5.invoke(r1, r8);	 Catch:{ IllegalAccessException -> 0x007f, IllegalArgumentException -> 0x0066, InvocationTargetException -> 0x004d }
        return r5;
    L_0x004d:
        r5 = move-exception;
        r6 = "Util";
        r7 = new java.lang.StringBuilder;
        r8 = "method can not invoke:";
        r7.<init>(r8);
        r5 = r5.getMessage();
        r7.append(r5);
        r5 = r7.toString();
        com.huawei.hms.support.log.a.d(r6, r5);
        goto L_0x0097;
    L_0x0066:
        r5 = move-exception;
        r6 = "Util";
        r7 = new java.lang.StringBuilder;
        r8 = "method can not invoke:";
        r7.<init>(r8);
        r5 = r5.getMessage();
        r7.append(r5);
        r5 = r7.toString();
        com.huawei.hms.support.log.a.d(r6, r5);
        goto L_0x0097;
    L_0x007f:
        r5 = move-exception;
        r6 = "Util";
        r7 = new java.lang.StringBuilder;
        r8 = "method can not invoke:";
        r7.<init>(r8);
        r5 = r5.getMessage();
        r7.append(r5);
        r5 = r7.toString();
        com.huawei.hms.support.log.a.d(r6, r5);
    L_0x0097:
        return r0;
    L_0x0098:
        r5 = "Util";
        r6 = "invokeFun params invalid";
        com.huawei.hms.support.log.a.a(r5, r6);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.c.g.a(java.lang.String, java.lang.String, java.lang.Class[], java.lang.Object[]):java.lang.Object");
    }

    public static java.lang.Object a(java.lang.String r4) {
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
        r1 = java.lang.Class.forName(r4);	 Catch:{ ClassNotFoundException -> 0x0006 }
        goto L_0x001a;
    L_0x0006:
        r1 = "Util";
        r2 = new java.lang.StringBuilder;
        r3 = "can not find class:";
        r2.<init>(r3);
        r2.append(r4);
        r4 = r2.toString();
        com.huawei.hms.support.log.a.d(r1, r4);
        r1 = r0;
    L_0x001a:
        if (r1 == 0) goto L_0x0054;
    L_0x001c:
        r4 = r1.newInstance();	 Catch:{ InstantiationException -> 0x003a, IllegalAccessException -> 0x0021 }
        goto L_0x0053;
    L_0x0021:
        r4 = move-exception;
        r1 = "Util";
        r2 = new java.lang.StringBuilder;
        r3 = "class creat instance error :";
        r2.<init>(r3);
        r4 = r4.getMessage();
        r2.append(r4);
        r4 = r2.toString();
        com.huawei.hms.support.log.a.d(r1, r4);
        goto L_0x0052;
    L_0x003a:
        r4 = move-exception;
        r1 = "Util";
        r2 = new java.lang.StringBuilder;
        r3 = "class creat instance error :";
        r2.<init>(r3);
        r4 = r4.getMessage();
        r2.append(r4);
        r4 = r2.toString();
        com.huawei.hms.support.log.a.d(r1, r4);
    L_0x0052:
        r4 = r0;
    L_0x0053:
        return r4;
    L_0x0054:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.c.g.a(java.lang.String):java.lang.Object");
    }

    public static java.lang.String a(android.content.Context r2) {
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
        r0 = r2.getPackageManager();
        if (r0 != 0) goto L_0x0010;
    L_0x0006:
        r2 = "Util";
        r0 = "In getMetaDataAppId, Failed to get 'PackageManager' instance.";
        com.huawei.hms.support.log.a.d(r2, r0);
        r2 = "";
        return r2;
    L_0x0010:
        r2 = r2.getPackageName();	 Catch:{ NameNotFoundException -> 0x0039 }
        r1 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ NameNotFoundException -> 0x0039 }
        r2 = r0.getApplicationInfo(r2, r1);	 Catch:{ NameNotFoundException -> 0x0039 }
        if (r2 == 0) goto L_0x002f;	 Catch:{ NameNotFoundException -> 0x0039 }
    L_0x001c:
        r0 = r2.metaData;	 Catch:{ NameNotFoundException -> 0x0039 }
        if (r0 == 0) goto L_0x002f;	 Catch:{ NameNotFoundException -> 0x0039 }
    L_0x0020:
        r2 = r2.metaData;	 Catch:{ NameNotFoundException -> 0x0039 }
        r0 = "com.huawei.hms.client.appid";	 Catch:{ NameNotFoundException -> 0x0039 }
        r2 = r2.get(r0);	 Catch:{ NameNotFoundException -> 0x0039 }
        if (r2 == 0) goto L_0x002f;	 Catch:{ NameNotFoundException -> 0x0039 }
    L_0x002a:
        r2 = java.lang.String.valueOf(r2);	 Catch:{ NameNotFoundException -> 0x0039 }
        return r2;	 Catch:{ NameNotFoundException -> 0x0039 }
    L_0x002f:
        r2 = "Util";	 Catch:{ NameNotFoundException -> 0x0039 }
        r0 = "In getMetaDataAppId, Failed to read meta data for the AppID.";	 Catch:{ NameNotFoundException -> 0x0039 }
        com.huawei.hms.support.log.a.d(r2, r0);	 Catch:{ NameNotFoundException -> 0x0039 }
        r2 = "";	 Catch:{ NameNotFoundException -> 0x0039 }
        return r2;
    L_0x0039:
        r2 = "Util";
        r0 = "In getMetaDataAppId, Failed to read meta data for the AppID.";
        com.huawei.hms.support.log.a.d(r2, r0);
        r2 = "";
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.c.g.a(android.content.Context):java.lang.String");
    }

    public static java.lang.String a(android.content.Context r2, java.lang.String r3) {
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
        if (r2 != 0) goto L_0x000c;
    L_0x0002:
        r2 = "Util";
        r3 = "In getAppName, context is null.";
        com.huawei.hms.support.log.a.d(r2, r3);
        r2 = "";
        return r2;
    L_0x000c:
        r0 = r2.getPackageManager();
        if (r0 != 0) goto L_0x001c;
    L_0x0012:
        r2 = "Util";
        r3 = "In getAppName, Failed to get 'PackageManager' instance.";
        com.huawei.hms.support.log.a.d(r2, r3);
        r2 = "";
        return r2;
    L_0x001c:
        r1 = android.text.TextUtils.isEmpty(r3);	 Catch:{ NameNotFoundException -> 0x0039, NameNotFoundException -> 0x0039 }
        if (r1 == 0) goto L_0x0026;	 Catch:{ NameNotFoundException -> 0x0039, NameNotFoundException -> 0x0039 }
    L_0x0022:
        r3 = r2.getPackageName();	 Catch:{ NameNotFoundException -> 0x0039, NameNotFoundException -> 0x0039 }
    L_0x0026:
        r2 = 0;	 Catch:{ NameNotFoundException -> 0x0039, NameNotFoundException -> 0x0039 }
        r2 = r0.getApplicationInfo(r3, r2);	 Catch:{ NameNotFoundException -> 0x0039, NameNotFoundException -> 0x0039 }
        r2 = r0.getApplicationLabel(r2);	 Catch:{ NameNotFoundException -> 0x0039, NameNotFoundException -> 0x0039 }
        if (r2 != 0) goto L_0x0034;	 Catch:{ NameNotFoundException -> 0x0039, NameNotFoundException -> 0x0039 }
    L_0x0031:
        r2 = "";	 Catch:{ NameNotFoundException -> 0x0039, NameNotFoundException -> 0x0039 }
        return r2;	 Catch:{ NameNotFoundException -> 0x0039, NameNotFoundException -> 0x0039 }
    L_0x0034:
        r2 = r2.toString();	 Catch:{ NameNotFoundException -> 0x0039, NameNotFoundException -> 0x0039 }
        return r2;
    L_0x0039:
        r2 = "Util";
        r3 = "In getAppName, Failed to get app name.";
        com.huawei.hms.support.log.a.d(r2, r3);
        r2 = "";
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.c.g.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public static void a(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (Context context2) {
            StringBuilder stringBuilder = new StringBuilder("On unBindServiceException:");
            stringBuilder.append(context2.getMessage());
            a.d("Util", stringBuilder.toString());
        }
    }
}
