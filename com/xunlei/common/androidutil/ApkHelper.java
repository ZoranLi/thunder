package com.xunlei.common.androidutil;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import java.io.File;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

public class ApkHelper {
    public static final String APK_PATH_PREF = "apk_path";
    public static final String AUTHORITIES = "com.xunlei.downloadprovider.XLFileProvider";
    public static final int INNER_EQUAL_VERSION = 4;
    public static final int INNER_INVALID_PARAM = 1;
    public static final int INNER_NEWER_VERSION = 5;
    public static final int INNER_NOT_INSTALL = 2;
    public static final int INNER_OLDER_VERSION = 3;
    public static final String MIME_TYPE_APK = "application/vnd.android.package-archive";
    private static final String TAG = "AppHelper";
    private static Map<String, SoftReference<ApkInfo>> mApkInfoCache = new HashMap();
    private static Pattern mPattern = Pattern.compile("\\d+(\\.\\d+)?");

    private static ApkInfo getApkInfoByPath(Context context, String str) {
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 5);
        if (packageArchiveInfo == null || packageArchiveInfo.applicationInfo == null) {
            return null;
        }
        try {
            Class cls = Class.forName("android.content.res.AssetManager");
            Object newInstance = cls.getConstructor(null).newInstance(null);
            cls.getDeclaredMethod("addAssetPath", new Class[]{String.class}).invoke(newInstance, new Object[]{str});
            context = context.getResources();
            try {
                context = (Resources) Resources.class.getConstructor(new Class[]{cls, DisplayMetrics.class, Configuration.class}).newInstance(new Object[]{newInstance, context.getDisplayMetrics(), context.getConfiguration()});
            } catch (Exception e) {
                str = e;
                str.printStackTrace();
                if (context != null) {
                    return null;
                }
                return new ApkInfo(packageArchiveInfo, context);
            }
        } catch (Exception e2) {
            str = e2;
            context = null;
            str.printStackTrace();
            if (context != null) {
                return new ApkInfo(packageArchiveInfo, context);
            }
            return null;
        }
        if (context != null) {
            return new ApkInfo(packageArchiveInfo, context);
        }
        return null;
    }

    private static ApkInfo addApkInfo(Context context, String str) {
        try {
            context = getApkInfoByPath(context, str);
        } catch (Context context2) {
            context2.printStackTrace();
            context2 = null;
        }
        if (context2 == null) {
            return null;
        }
        mApkInfoCache.put(str, new SoftReference(context2));
        return context2;
    }

    public static ApkInfo getApkInfo(Context context, String str) {
        if (mApkInfoCache.get(str) == null) {
            return addApkInfo(context, str);
        }
        SoftReference softReference = (SoftReference) mApkInfoCache.get(str);
        if (softReference.get() == null) {
            return addApkInfo(context, str);
        }
        return (ApkInfo) softReference.get();
    }

    public static int compareLocalApp(android.content.Context r5, com.xunlei.common.androidutil.ApkHelper.ApkInfo r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 3;
        r1 = 5;
        r2 = 1;
        if (r6 == 0) goto L_0x004e;
    L_0x0005:
        r3 = com.xunlei.common.androidutil.ApkHelper.ApkInfo.access$000(r6);
        if (r3 == 0) goto L_0x004e;
    L_0x000b:
        r5 = r5.getPackageManager();	 Catch:{ NameNotFoundException -> 0x004c }
        r3 = r6.getPackageName();	 Catch:{ NameNotFoundException -> 0x004c }
        r4 = 0;	 Catch:{ NameNotFoundException -> 0x004c }
        r5 = r5.getPackageInfo(r3, r4);	 Catch:{ NameNotFoundException -> 0x004c }
        if (r5 == 0) goto L_0x004e;	 Catch:{ NameNotFoundException -> 0x004c }
    L_0x001a:
        r2 = r5.versionCode;	 Catch:{ NameNotFoundException -> 0x004c }
        r3 = com.xunlei.common.androidutil.ApkHelper.ApkInfo.access$000(r6);	 Catch:{ NameNotFoundException -> 0x004c }
        r3 = r3.versionCode;	 Catch:{ NameNotFoundException -> 0x004c }
        if (r2 <= r3) goto L_0x0026;	 Catch:{ NameNotFoundException -> 0x004c }
    L_0x0024:
        r0 = r1;	 Catch:{ NameNotFoundException -> 0x004c }
        goto L_0x004f;	 Catch:{ NameNotFoundException -> 0x004c }
    L_0x0026:
        r2 = r5.versionCode;	 Catch:{ NameNotFoundException -> 0x004c }
        r3 = com.xunlei.common.androidutil.ApkHelper.ApkInfo.access$000(r6);	 Catch:{ NameNotFoundException -> 0x004c }
        r3 = r3.versionCode;	 Catch:{ NameNotFoundException -> 0x004c }
        if (r2 >= r3) goto L_0x0031;	 Catch:{ NameNotFoundException -> 0x004c }
    L_0x0030:
        goto L_0x004f;	 Catch:{ NameNotFoundException -> 0x004c }
    L_0x0031:
        r5 = r5.versionName;	 Catch:{ NameNotFoundException -> 0x004c }
        r6 = com.xunlei.common.androidutil.ApkHelper.ApkInfo.access$000(r6);	 Catch:{ NameNotFoundException -> 0x004c }
        r6 = r6.versionName;	 Catch:{ NameNotFoundException -> 0x004c }
        r5 = compareVerName(r5, r6);	 Catch:{ NameNotFoundException -> 0x004c }
        r2 = 0;
        r4 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1));
        if (r4 <= 0) goto L_0x0044;
    L_0x0043:
        goto L_0x0024;
    L_0x0044:
        r1 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1));
        if (r1 >= 0) goto L_0x0049;
    L_0x0048:
        goto L_0x004f;
    L_0x0049:
        r5 = 4;
        r0 = r5;
        goto L_0x004f;
    L_0x004c:
        r0 = 2;
        goto L_0x004f;
    L_0x004e:
        r0 = r2;
    L_0x004f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.androidutil.ApkHelper.compareLocalApp(android.content.Context, com.xunlei.common.androidutil.ApkHelper$ApkInfo):int");
    }

    private static long compareVerName(String str, String str2) {
        if (str != null) {
            if (str2 != null) {
                str = str.split("\\.");
                str2 = str2.split("\\.");
                int length = str.length;
                int length2 = str2.length;
                int i = length < length2 ? length : length2;
                for (int i2 = 0; i2 < i; i2++) {
                    long parseLong = Long.parseLong(getMainVerName(str[i2]));
                    long parseLong2 = Long.parseLong(getMainVerName(str2[i2]));
                    if (parseLong != parseLong2) {
                        str = parseLong - parseLong2;
                        break;
                    }
                }
                str = null;
                if (str == null) {
                    str = (long) (length - length2);
                }
                return str;
            }
        }
        return 0;
    }

    public static String getMainVerName(String str) {
        String str2 = "0";
        if (str == null) {
            return str2;
        }
        str = mPattern.matcher(str);
        return str.find() ? str.group() : str2;
    }

    public static boolean isApkPackageFileInstalled(android.content.Context r6, java.lang.String r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r6 = r6.getPackageManager();	 Catch:{ Exception -> 0x0049 }
        r1 = 1;	 Catch:{ Exception -> 0x0049 }
        r7 = r6.getPackageArchiveInfo(r7, r1);	 Catch:{ Exception -> 0x0049 }
        if (r7 != 0) goto L_0x000d;	 Catch:{ Exception -> 0x0049 }
    L_0x000c:
        return r0;	 Catch:{ Exception -> 0x0049 }
    L_0x000d:
        r2 = r7.applicationInfo;	 Catch:{ Exception -> 0x0049 }
        r2 = r2.packageName;	 Catch:{ Exception -> 0x0049 }
        r3 = r7.versionName;	 Catch:{ Exception -> 0x0049 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0049 }
        r5 = " packageName = ";	 Catch:{ Exception -> 0x0049 }
        r4.<init>(r5);	 Catch:{ Exception -> 0x0049 }
        r4.append(r2);	 Catch:{ Exception -> 0x0049 }
        r5 = ", version = ";	 Catch:{ Exception -> 0x0049 }
        r4.append(r5);	 Catch:{ Exception -> 0x0049 }
        r4.append(r3);	 Catch:{ Exception -> 0x0049 }
        r6 = r6.getPackageInfo(r2, r1);	 Catch:{ Exception -> 0x0049 }
        if (r6 != 0) goto L_0x002c;	 Catch:{ Exception -> 0x0049 }
    L_0x002b:
        return r0;	 Catch:{ Exception -> 0x0049 }
    L_0x002c:
        r2 = r6.versionCode;	 Catch:{ Exception -> 0x0049 }
        r3 = r7.versionCode;	 Catch:{ Exception -> 0x0049 }
        if (r2 != r3) goto L_0x0033;	 Catch:{ Exception -> 0x0049 }
    L_0x0032:
        return r1;	 Catch:{ Exception -> 0x0049 }
    L_0x0033:
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0049 }
        r2 = "version not match, installed version = ";	 Catch:{ Exception -> 0x0049 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x0049 }
        r6 = r6.versionCode;	 Catch:{ Exception -> 0x0049 }
        r1.append(r6);	 Catch:{ Exception -> 0x0049 }
        r6 = ", apk version = ";	 Catch:{ Exception -> 0x0049 }
        r1.append(r6);	 Catch:{ Exception -> 0x0049 }
        r6 = r7.versionCode;	 Catch:{ Exception -> 0x0049 }
        r1.append(r6);	 Catch:{ Exception -> 0x0049 }
    L_0x0049:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.androidutil.ApkHelper.isApkPackageFileInstalled(android.content.Context, java.lang.String):boolean");
    }

    public static boolean isApkPackageInstalled(android.content.Context r2, java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.text.TextUtils.isEmpty(r3);
        r1 = 0;
        if (r0 == 0) goto L_0x0008;
    L_0x0007:
        return r1;
    L_0x0008:
        r2 = r2.getPackageManager();
        r2 = r2.getPackageInfo(r3, r1);	 Catch:{ NameNotFoundException -> 0x0015 }
        if (r2 == 0) goto L_0x0014;
    L_0x0012:
        r2 = 1;
        return r2;
    L_0x0014:
        return r1;
    L_0x0015:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.common.androidutil.ApkHelper.isApkPackageInstalled(android.content.Context, java.lang.String):boolean");
    }

    public static boolean launchAppByPackageName(Context context, String str) {
        str = context.getPackageManager().getLaunchIntentForPackage(str);
        if (str == null) {
            return false;
        }
        context.startActivity(str);
        return true;
    }

    public static void installApk(Context context, String str) {
        installApk(context, new File(str));
    }

    public static void installApk(Context context, File file) {
        Intent intent = new Intent("android.intent.action.VIEW");
        if (VERSION.SDK_INT >= 24) {
            intent.setFlags(1);
            intent.setDataAndType(FileProvider.getUriForFile(context, AUTHORITIES, file), MIME_TYPE_APK);
        } else {
            intent.setDataAndType(Uri.fromFile(file), MIME_TYPE_APK);
            intent.setFlags(805306368);
        }
        context.startActivity(intent);
    }

    public static void openWebUrlByTargetBrowser(Context context, String str, String str2) {
        if (context != null) {
            if (!TextUtils.isEmpty(str)) {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager != null) {
                    str = packageManager.getLaunchIntentForPackage(str);
                    if (str != null) {
                        str.setAction("android.intent.action.VIEW");
                        str.addCategory("android.intent.category.DEFAULT");
                        if (!TextUtils.isEmpty(str2)) {
                            str.setData(Uri.parse(str2));
                        }
                        context.startActivity(str);
                    }
                }
            }
        }
    }
}
