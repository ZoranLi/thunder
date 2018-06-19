package com.xunlei.tdlive.route.util;

import android.net.Uri;

public class UriUtil {
    public static boolean hasKey(Uri uri, String str) {
        return uri.getQueryParameterNames().contains(str);
    }

    public static java.lang.String getParam(android.net.Uri r0, java.lang.String r1, java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r0.getQueryParameter(r1);	 Catch:{ Throwable -> 0x0008 }
        if (r0 != 0) goto L_0x0007;
    L_0x0006:
        goto L_0x0008;
    L_0x0007:
        r2 = r0;
    L_0x0008:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.route.util.UriUtil.getParam(android.net.Uri, java.lang.String, java.lang.String):java.lang.String");
    }

    public static long getParam(android.net.Uri r0, java.lang.String r1, long r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r0.getQueryParameter(r1);	 Catch:{ Throwable -> 0x0009 }
        r0 = java.lang.Long.parseLong(r0);	 Catch:{ Throwable -> 0x0009 }
        goto L_0x000a;
    L_0x0009:
        r0 = r2;
    L_0x000a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.route.util.UriUtil.getParam(android.net.Uri, java.lang.String, long):long");
    }

    public static int getParam(android.net.Uri r0, java.lang.String r1, int r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r0.getQueryParameter(r1);	 Catch:{ Throwable -> 0x0009 }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ Throwable -> 0x0009 }
        goto L_0x000a;
    L_0x0009:
        r0 = r2;
    L_0x000a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.route.util.UriUtil.getParam(android.net.Uri, java.lang.String, int):int");
    }

    public static double getParam(android.net.Uri r0, java.lang.String r1, double r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r0.getQueryParameter(r1);	 Catch:{ Throwable -> 0x0009 }
        r0 = java.lang.Double.parseDouble(r0);	 Catch:{ Throwable -> 0x0009 }
        goto L_0x000a;
    L_0x0009:
        r0 = r2;
    L_0x000a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.route.util.UriUtil.getParam(android.net.Uri, java.lang.String, double):double");
    }

    public static float getParam(android.net.Uri r0, java.lang.String r1, float r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r0.getQueryParameter(r1);	 Catch:{ Throwable -> 0x0009 }
        r0 = java.lang.Float.parseFloat(r0);	 Catch:{ Throwable -> 0x0009 }
        goto L_0x000a;
    L_0x0009:
        r0 = r2;
    L_0x000a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.route.util.UriUtil.getParam(android.net.Uri, java.lang.String, float):float");
    }

    public static boolean getParam(android.net.Uri r4, java.lang.String r5, boolean r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = 1;
        r2 = r4.getQueryParameter(r5);	 Catch:{ Throwable -> 0x001c }
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x001c }
        if (r3 != 0) goto L_0x001a;
    L_0x000c:
        r3 = java.lang.Integer.parseInt(r2);	 Catch:{ Throwable -> 0x0014 }
        if (r3 == 0) goto L_0x0023;
    L_0x0012:
        r0 = r1;
        goto L_0x0023;
    L_0x0014:
        r2 = java.lang.Boolean.parseBoolean(r2);	 Catch:{ Throwable -> 0x001c }
        r0 = r2;
        goto L_0x0023;
    L_0x001a:
        r0 = r6;
        goto L_0x0023;
    L_0x001c:
        r4 = getParam(r4, r5, r6);
        if (r4 == 0) goto L_0x0023;
    L_0x0022:
        goto L_0x0012;
    L_0x0023:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.tdlive.route.util.UriUtil.getParam(android.net.Uri, java.lang.String, boolean):boolean");
    }
}
