package com.xunlei.common.accelerator.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class AndroidUtil {
    private static final String DEFAULT_CHANNEL = "xunlei";

    public static String getOSModel() {
        Object obj = Build.MODEL;
        if (TextUtils.isEmpty(obj)) {
            StringBuilder stringBuilder = new StringBuilder("android-");
            stringBuilder.append(getOsVersionString());
            return stringBuilder.toString();
        }
        String replace = obj.replace(" ", "");
        StringBuilder stringBuilder2 = new StringBuilder("android-");
        stringBuilder2.append(getOsVersionString());
        stringBuilder2.append(replace);
        return stringBuilder2.toString();
    }

    public static String getOsVersionString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(VERSION.RELEASE);
        stringBuilder.append(".");
        stringBuilder.append(VERSION.SDK_INT);
        return stringBuilder.toString();
    }

    public static java.lang.String getVersionString(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "unknown";
        r1 = r3.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0012 }
        r3 = r3.getPackageName();	 Catch:{ NameNotFoundException -> 0x0012 }
        r2 = 0;	 Catch:{ NameNotFoundException -> 0x0012 }
        r3 = r1.getPackageInfo(r3, r2);	 Catch:{ NameNotFoundException -> 0x0012 }
        r3 = r3.versionName;	 Catch:{ NameNotFoundException -> 0x0012 }
        goto L_0x0013;
    L_0x0012:
        r3 = r0;
    L_0x0013:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.accelerator.utils.AndroidUtil.getVersionString(android.content.Context):java.lang.String");
    }

    public static String getChannelFromMeta(Context context) {
        String str = "";
        ZipFile zipFile = null;
        try {
            ZipFile zipFile2 = new ZipFile(context.getApplicationInfo().sourceDir);
            try {
                context = zipFile2.entries();
                while (context.hasMoreElements()) {
                    String name = ((ZipEntry) context.nextElement()).getName();
                    if (name.startsWith("META-INF") && name.contains("channel_")) {
                        str = name;
                        break;
                    }
                }
            } catch (IOException e) {
                context = e;
                zipFile = zipFile2;
                try {
                    context.printStackTrace();
                    if (zipFile != null) {
                        zipFile.close();
                    }
                    context = str.split("_");
                    if (context != null) {
                    }
                } catch (Throwable th) {
                    context = th;
                    zipFile2 = zipFile;
                    if (zipFile2 != null) {
                        try {
                            zipFile2.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw context;
                }
            } catch (Throwable th2) {
                context = th2;
                if (zipFile2 != null) {
                    zipFile2.close();
                }
                throw context;
            }
            try {
                zipFile2.close();
            } catch (Context context2) {
                context2.printStackTrace();
            }
        } catch (IOException e3) {
            context2 = e3;
            context2.printStackTrace();
            if (zipFile != null) {
                zipFile.close();
            }
            context2 = str.split("_");
            if (context2 != null) {
            }
        }
        context2 = str.split("_");
        return (context2 != null || context2.length < 2) ? DEFAULT_CHANNEL : str.substring(context2[0].length() + 1);
    }

    public static boolean isNetConnected(Context context) {
        if (context != null) {
            context = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (context != null && context.getState() == State.CONNECTED) {
                return true;
            }
        }
        return null;
    }

    public static boolean isWiFiConnected(Context context) {
        if (isNetConnected(context)) {
            context = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (context != null && context.getType() == 1) {
                return true;
            }
        }
        return null;
    }
}
