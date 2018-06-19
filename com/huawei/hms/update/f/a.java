package com.huawei.hms.update.f;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Locale;

/* compiled from: UpdateUtils */
public abstract class a {
    public static String a(Context context) {
        context = context.getResources().getConfiguration();
        if (context.locale != null) {
            String language = context.locale.getLanguage();
            context = context.locale.getCountry();
            if (!(language == null || context == null)) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(language.toLowerCase(Locale.getDefault()));
                stringBuilder.append('_');
                stringBuilder.append(context.toUpperCase(Locale.getDefault()));
                return stringBuilder.toString();
            }
        }
        return "";
    }

    public static String b(Context context) {
        Object a = a("ro.product.locale.region");
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        context = d(context);
        return !TextUtils.isEmpty(context) ? context : "";
    }

    private static String d(Context context) {
        context = context.getResources().getConfiguration();
        if (context.locale != null) {
            context = context.locale.getCountry();
            if (context != null) {
                return context;
            }
        }
        return "";
    }

    private static java.lang.String a(java.lang.String r6) {
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
        r0 = "android.os.SystemProperties";	 Catch:{ ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f }
        r0 = java.lang.Class.forName(r0);	 Catch:{ ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f }
        r1 = "get";	 Catch:{ ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f }
        r2 = 1;	 Catch:{ ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f }
        r3 = new java.lang.Class[r2];	 Catch:{ ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f }
        r4 = java.lang.String.class;	 Catch:{ ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f }
        r5 = 0;	 Catch:{ ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f }
        r3[r5] = r4;	 Catch:{ ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f }
        r1 = r0.getDeclaredMethod(r1, r3);	 Catch:{ ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f }
        r2 = new java.lang.Object[r2];	 Catch:{ ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f }
        r2[r5] = r6;	 Catch:{ ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f }
        r0 = r1.invoke(r0, r2);	 Catch:{ ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f }
        r0 = (java.lang.String) r0;	 Catch:{ ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f, ClassNotFoundException -> 0x001f }
        return r0;
    L_0x001f:
        r0 = "UpdateUtils";
        r1 = new java.lang.StringBuilder;
        r2 = "An exception occurred while reading: ";
        r1.<init>(r2);
        r1.append(r6);
        r6 = r1.toString();
        com.huawei.hms.support.log.a.d(r0, r6);
        r6 = "";
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.update.f.a.a(java.lang.String):java.lang.String");
    }

    public static boolean c(Context context) {
        Object a = a("ro.product.locale.region");
        if (!TextUtils.isEmpty(a)) {
            return "cn".equalsIgnoreCase(a) != null;
        } else {
            a = d(context);
            return !TextUtils.isEmpty(a) ? "cn".equalsIgnoreCase(a) != null : e(context).startsWith("460") != null ? true : true;
        }
    }

    private static String e(Context context) {
        Object obj = "";
        com.huawei.hms.update.f.a.a a = com.huawei.hms.update.f.a.a.a();
        if (a != null) {
            context = a.b();
            if (context == -1 || 5 == a.b(context)) {
                obj = a.a(context);
                if (TextUtils.isEmpty(obj)) {
                    obj = a.c(context);
                }
            }
        } else {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null && 5 == telephonyManager.getSimState()) {
                obj = telephonyManager.getSimOperator();
                if (TextUtils.isEmpty(obj)) {
                    obj = telephonyManager.getSubscriberId();
                }
            }
        }
        if (TextUtils.isEmpty(obj) != null) {
            return "00000";
        }
        return obj.substring(null, 5);
    }
}
