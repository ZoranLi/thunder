package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.UUID;

public class Utility {
    private static final String DEFAULT_CHARSET = "UTF-8";

    public static android.os.Bundle parseUrl(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.net.URL;	 Catch:{ MalformedURLException -> 0x0019 }
        r0.<init>(r1);	 Catch:{ MalformedURLException -> 0x0019 }
        r1 = r0.getQuery();	 Catch:{ MalformedURLException -> 0x0019 }
        r1 = decodeUrl(r1);	 Catch:{ MalformedURLException -> 0x0019 }
        r0 = r0.getRef();	 Catch:{ MalformedURLException -> 0x0019 }
        r0 = decodeUrl(r0);	 Catch:{ MalformedURLException -> 0x0019 }
        r1.putAll(r0);	 Catch:{ MalformedURLException -> 0x0019 }
        return r1;
    L_0x0019:
        r1 = new android.os.Bundle;
        r1.<init>();
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.Utility.parseUrl(java.lang.String):android.os.Bundle");
    }

    public static Bundle decodeUrl(String str) {
        Bundle bundle = new Bundle();
        if (str != null) {
            for (String split : str.split("&")) {
                String[] split2 = split.split("=");
                try {
                    bundle.putString(URLDecoder.decode(split2[0], "UTF-8"), URLDecoder.decode(split2[1], "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        return bundle;
    }

    public static boolean isChineseLocale(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 1;
        r2 = r2.getResources();	 Catch:{ Exception -> 0x002f }
        r2 = r2.getConfiguration();	 Catch:{ Exception -> 0x002f }
        r2 = r2.locale;	 Catch:{ Exception -> 0x002f }
        r1 = java.util.Locale.CHINA;	 Catch:{ Exception -> 0x002f }
        r1 = r1.equals(r2);	 Catch:{ Exception -> 0x002f }
        if (r1 != 0) goto L_0x002e;	 Catch:{ Exception -> 0x002f }
    L_0x0013:
        r1 = java.util.Locale.CHINESE;	 Catch:{ Exception -> 0x002f }
        r1 = r1.equals(r2);	 Catch:{ Exception -> 0x002f }
        if (r1 != 0) goto L_0x002e;	 Catch:{ Exception -> 0x002f }
    L_0x001b:
        r1 = java.util.Locale.SIMPLIFIED_CHINESE;	 Catch:{ Exception -> 0x002f }
        r1 = r1.equals(r2);	 Catch:{ Exception -> 0x002f }
        if (r1 != 0) goto L_0x002e;	 Catch:{ Exception -> 0x002f }
    L_0x0023:
        r1 = java.util.Locale.TAIWAN;	 Catch:{ Exception -> 0x002f }
        r2 = r1.equals(r2);	 Catch:{ Exception -> 0x002f }
        if (r2 == 0) goto L_0x002c;
    L_0x002b:
        goto L_0x002e;
    L_0x002c:
        r2 = 0;
        return r2;
    L_0x002e:
        return r0;
    L_0x002f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.Utility.isChineseLocale(android.content.Context):boolean");
    }

    public static String generateGUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public static java.lang.String getSign(android.content.Context r2, java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r2 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0025, Exception -> 0x0024 }
        r1 = 64;	 Catch:{ NameNotFoundException -> 0x0025, Exception -> 0x0024 }
        r2 = r2.getPackageInfo(r3, r1);	 Catch:{ NameNotFoundException -> 0x0025, Exception -> 0x0024 }
        r3 = 0;	 Catch:{ NameNotFoundException -> 0x0025, Exception -> 0x0024 }
    L_0x000c:
        r1 = r2.signatures;	 Catch:{ NameNotFoundException -> 0x0025, Exception -> 0x0024 }
        r1 = r1.length;	 Catch:{ NameNotFoundException -> 0x0025, Exception -> 0x0024 }
        if (r3 >= r1) goto L_0x0023;	 Catch:{ NameNotFoundException -> 0x0025, Exception -> 0x0024 }
    L_0x0011:
        r1 = r2.signatures;	 Catch:{ NameNotFoundException -> 0x0025, Exception -> 0x0024 }
        r1 = r1[r3];	 Catch:{ NameNotFoundException -> 0x0025, Exception -> 0x0024 }
        r1 = r1.toByteArray();	 Catch:{ NameNotFoundException -> 0x0025, Exception -> 0x0024 }
        if (r1 == 0) goto L_0x0020;	 Catch:{ NameNotFoundException -> 0x0025, Exception -> 0x0024 }
    L_0x001b:
        r2 = com.sina.weibo.sdk.utils.MD5.hexdigest(r1);	 Catch:{ NameNotFoundException -> 0x0025, Exception -> 0x0024 }
        return r2;
    L_0x0020:
        r3 = r3 + 1;
        goto L_0x000c;
    L_0x0023:
        return r0;
    L_0x0024:
        return r0;
    L_0x0025:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.Utility.getSign(android.content.Context, java.lang.String):java.lang.String");
    }

    public static String safeString(String str) {
        return TextUtils.isEmpty(str) ? "" : str;
    }

    public static String getAid(Context context, String str) {
        if (context == null) {
            return "";
        }
        context = AidTask.getInstance(context);
        Object loadAidFromCache = context.loadAidFromCache();
        if (!TextUtils.isEmpty(loadAidFromCache)) {
            return loadAidFromCache;
        }
        context.aidTaskInit(str);
        return "";
    }

    public static java.lang.String generateUAAid(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.lang.StringBuilder;
        r0.<init>();
        r3 = r3.getPackageName();
        r1 = "weibosdk";
        r2 = android.text.TextUtils.isEmpty(r3);
        if (r2 != 0) goto L_0x001b;
    L_0x0011:
        r2 = "com.sina.weibo";
        r3 = r3.contains(r2);
        if (r3 == 0) goto L_0x001b;
    L_0x0019:
        r1 = "weibo";
    L_0x001b:
        r3 = android.os.Build.MANUFACTURER;
        r0.append(r3);
        r3 = "-";
        r0.append(r3);
        r3 = android.os.Build.MODEL;
        r0.append(r3);
        r3 = "__";
        r0.append(r3);
        r0.append(r1);
        r3 = "__";
        r0.append(r3);
        r3 = "0041005000";	 Catch:{ Exception -> 0x0045 }
        r1 = "\\s+";	 Catch:{ Exception -> 0x0045 }
        r2 = "_";	 Catch:{ Exception -> 0x0045 }
        r3 = r3.replaceAll(r1, r2);	 Catch:{ Exception -> 0x0045 }
        r0.append(r3);	 Catch:{ Exception -> 0x0045 }
        goto L_0x004a;
    L_0x0045:
        r3 = "unknown";
        r0.append(r3);
    L_0x004a:
        r3 = "__android__android";
        r0.append(r3);
        r3 = android.os.Build.VERSION.RELEASE;
        r0.append(r3);
        r3 = r0.toString();
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.Utility.generateUAAid(android.content.Context):java.lang.String");
    }

    public static String getWeiBoVersion(Context context) throws NameNotFoundException {
        context = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
        if (context == null) {
            return null;
        }
        return context.versionName;
    }
}
