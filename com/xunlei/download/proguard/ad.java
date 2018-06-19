package com.xunlei.download.proguard;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import com.xiaomi.push.service.av;

/* compiled from: ContextUtils */
public class ad {
    private static final String a = "ContextUtils";

    public static String a(Context context) {
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        context = applicationInfo.loadLabel(context.getPackageManager());
        return context == null ? applicationInfo.packageName : context.toString();
    }

    public static java.lang.String b(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r3.getPackageName();
        r3 = r3.getPackageManager();
        r1 = 0;
        r3 = r3.getPackageInfo(r0, r1);	 Catch:{ NameNotFoundException -> 0x0010 }
        r3 = r3.versionName;	 Catch:{ NameNotFoundException -> 0x0010 }
        goto L_0x0024;
    L_0x0010:
        r3 = "ContextUtils";
        r1 = new java.lang.StringBuilder;
        r2 = "Exception when retrieving package:";
        r1.<init>(r2);
        r1.append(r0);
        r0 = r1.toString();
        com.xunlei.download.proguard.an.c(r3, r0);
        r3 = 0;
    L_0x0024:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.proguard.ad.b(android.content.Context):java.lang.String");
    }

    public static int c(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r3.getPackageName();
        r3 = r3.getPackageManager();
        r1 = 0;
        r3 = r3.getPackageInfo(r0, r1);	 Catch:{ NameNotFoundException -> 0x0010 }
        r3 = r3.versionCode;	 Catch:{ NameNotFoundException -> 0x0010 }
        goto L_0x0024;
    L_0x0010:
        r3 = "ContextUtils";
        r1 = new java.lang.StringBuilder;
        r2 = "Exception when retrieving package:";
        r1.<init>(r2);
        r1.append(r0);
        r0 = r1.toString();
        com.xunlei.download.proguard.an.c(r3, r0);
        r3 = -1;
    L_0x0024:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.download.proguard.ad.c(android.content.Context):int");
    }

    public static boolean a(Context context, String str, boolean z) {
        context = a(context, str);
        if (context != null) {
            context = context.toString();
            if (context != null && context.length() > 0) {
                if (!context.equals("true")) {
                    if (context.equals(av.b)) {
                        return false;
                    }
                    if (context.equals("0") != null) {
                        return false;
                    }
                }
                z = true;
            }
        }
        return z;
    }

    public static String a(Context context, String str, String str2) {
        context = a(context, str);
        return context != null ? context.toString() : str2;
    }

    public static int a(Context context, String str, int i) {
        context = a(context, str);
        return (context == null || (context instanceof Integer) == null) ? i : ((Integer) context).intValue();
    }

    public static long a(Context context, String str, long j) {
        return (long) a(context, str, (int) j);
    }

    private static Object a(Context context, String str) {
        try {
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
            if (context == null || !context.containsKey(str)) {
                return null;
            }
            return context.get(str);
        } catch (Throwable e) {
            e.printStackTrace();
            an.a(e);
            return null;
        }
    }

    public static Bundle d(Context context) {
        try {
            return context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).metaData;
        } catch (Throwable e) {
            e.printStackTrace();
            an.a(e);
            return null;
        }
    }
}
