package com.sina.weibo.sdk.utils;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class WbUtils {
    private static final String DEFAULT_CHARSET = "UTF-8";
    private static final String WEIBO_IDENTITY_ACTION = "com.sina.weibo.action.sdkidentity";

    public static boolean supportMixtureShare() {
        return true;
    }

    public static android.os.Bundle parseUri(java.lang.String r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.net.URI;	 Catch:{ Exception -> 0x000e }
        r0.<init>(r1);	 Catch:{ Exception -> 0x000e }
        r1 = r0.getQuery();	 Catch:{ Exception -> 0x000e }
        r1 = decodeUrl(r1);	 Catch:{ Exception -> 0x000e }
        return r1;
    L_0x000e:
        r1 = new android.os.Bundle;
        r1.<init>();
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sina.weibo.sdk.utils.WbUtils.parseUri(java.lang.String):android.os.Bundle");
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

    public static String generateUA(Context context, String str) {
        context = new StringBuilder();
        context.append(Build.MANUFACTURER);
        context.append("-");
        context.append(Build.MODEL);
        context.append("_");
        context.append(VERSION.RELEASE);
        context.append("_");
        context.append("weibosdk");
        context.append("_");
        context.append(WbSdkVersion.WEIBO_SDK_VERSION_CODE);
        context.append("_android");
        return context.toString();
    }

    public static boolean isWeiboInstall(Context context) {
        Intent intent = new Intent("com.sina.weibo.action.sdkidentity");
        intent.addCategory("android.intent.category.DEFAULT");
        context = context.getPackageManager().queryIntentServices(intent, 0);
        if (context != null) {
            if (context.isEmpty() == null) {
                return true;
            }
        }
        return false;
    }
}
