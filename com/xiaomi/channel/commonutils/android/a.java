package com.xiaomi.channel.commonutils.android;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.channel.commonutils.logger.b;
import com.xunlei.common.stat.base.XLStatCommandID;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class a {

    public enum a {
        UNKNOWN(0),
        ALLOWED(1),
        NOT_ALLOWED(2);
        
        private final int d;

        private a(int i) {
            this.d = i;
        }

        public final int a() {
            return this.d;
        }
    }

    public static String a(Context context) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        List arrayList = new ArrayList();
        StringBuilder stringBuilder = new StringBuilder();
        if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                String[] strArr = runningAppProcessInfo.pkgList;
                int i = 0;
                while (strArr != null && i < strArr.length) {
                    if (!arrayList.contains(strArr[i])) {
                        String str;
                        arrayList.add(strArr[i]);
                        if (arrayList.size() == 1) {
                            str = (String) arrayList.get(0);
                        } else {
                            stringBuilder.append("#");
                            str = strArr[i];
                        }
                        stringBuilder.append(str.hashCode() % XLStatCommandID.XLCID_LOGIN);
                    }
                    i++;
                }
            }
        }
        return stringBuilder.toString();
    }

    public static String a(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Throwable e) {
            b.a(e);
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.versionName : "1.0";
    }

    public static String a(String[] strArr) {
        b[] values = b.values();
        byte[] bArr = new byte[((int) Math.ceil(((double) values.length) / 8.0d))];
        if (strArr != null) {
            int i = -1;
            for (CharSequence charSequence : strArr) {
                if (!TextUtils.isEmpty(charSequence) && charSequence.startsWith("android.permission.")) {
                    int i2 = 0;
                    while (i2 < values.length) {
                        StringBuilder stringBuilder = new StringBuilder("android.permission.");
                        stringBuilder.append(values[i2].name());
                        if (TextUtils.equals(stringBuilder.toString(), charSequence)) {
                            i = 1;
                            break;
                        }
                        i2++;
                    }
                    i2 = i;
                    i = 0;
                    if (!(i == 0 || i2 == -1)) {
                        i = i2 / 8;
                        bArr[i] = (byte) (bArr[i] | (1 << (7 - (i2 % 8))));
                    }
                    i = i2;
                }
            }
            return new String(Base64.encode(bArr, 0));
        }
        b.c("AppInfoUtils.: no permissions");
        return "";
    }

    public static int b(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Throwable e) {
            b.a(e);
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.versionCode : 0;
    }

    @android.annotation.TargetApi(19)
    public static com.xiaomi.channel.commonutils.android.a.a c(android.content.Context r5, java.lang.String r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        if (r5 == 0) goto L_0x0059;
    L_0x0002:
        r0 = android.text.TextUtils.isEmpty(r6);
        if (r0 != 0) goto L_0x0059;
    L_0x0008:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 19;
        if (r0 >= r1) goto L_0x000f;
    L_0x000e:
        goto L_0x0059;
    L_0x000f:
        r0 = android.app.AppOpsManager.class;	 Catch:{ Throwable -> 0x0056 }
        r1 = "OP_POST_NOTIFICATION";	 Catch:{ Throwable -> 0x0056 }
        r0 = com.xiaomi.channel.commonutils.reflect.a.a(r0, r1);	 Catch:{ Throwable -> 0x0056 }
        r0 = (java.lang.Integer) r0;	 Catch:{ Throwable -> 0x0056 }
        if (r0 != 0) goto L_0x001e;	 Catch:{ Throwable -> 0x0056 }
    L_0x001b:
        r5 = com.xiaomi.channel.commonutils.android.a.a.UNKNOWN;	 Catch:{ Throwable -> 0x0056 }
        return r5;	 Catch:{ Throwable -> 0x0056 }
    L_0x001e:
        r1 = r5.getPackageManager();	 Catch:{ Throwable -> 0x0056 }
        r2 = 0;	 Catch:{ Throwable -> 0x0056 }
        r1 = r1.getApplicationInfo(r6, r2);	 Catch:{ Throwable -> 0x0056 }
        r3 = "appops";	 Catch:{ Throwable -> 0x0056 }
        r5 = r5.getSystemService(r3);	 Catch:{ Throwable -> 0x0056 }
        r5 = (android.app.AppOpsManager) r5;	 Catch:{ Throwable -> 0x0056 }
        r3 = "checkOpNoThrow";	 Catch:{ Throwable -> 0x0056 }
        r4 = 3;	 Catch:{ Throwable -> 0x0056 }
        r4 = new java.lang.Object[r4];	 Catch:{ Throwable -> 0x0056 }
        r4[r2] = r0;	 Catch:{ Throwable -> 0x0056 }
        r0 = 1;	 Catch:{ Throwable -> 0x0056 }
        r1 = r1.uid;	 Catch:{ Throwable -> 0x0056 }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ Throwable -> 0x0056 }
        r4[r0] = r1;	 Catch:{ Throwable -> 0x0056 }
        r0 = 2;	 Catch:{ Throwable -> 0x0056 }
        r4[r0] = r6;	 Catch:{ Throwable -> 0x0056 }
        r5 = com.xiaomi.channel.commonutils.reflect.a.a(r5, r3, r4);	 Catch:{ Throwable -> 0x0056 }
        r5 = (java.lang.Integer) r5;	 Catch:{ Throwable -> 0x0056 }
        if (r5 == 0) goto L_0x0053;	 Catch:{ Throwable -> 0x0056 }
    L_0x004a:
        r5 = r5.intValue();	 Catch:{ Throwable -> 0x0056 }
        if (r5 != 0) goto L_0x0053;	 Catch:{ Throwable -> 0x0056 }
    L_0x0050:
        r5 = com.xiaomi.channel.commonutils.android.a.a.ALLOWED;	 Catch:{ Throwable -> 0x0056 }
        return r5;	 Catch:{ Throwable -> 0x0056 }
    L_0x0053:
        r5 = com.xiaomi.channel.commonutils.android.a.a.NOT_ALLOWED;	 Catch:{ Throwable -> 0x0056 }
        return r5;
    L_0x0056:
        r5 = com.xiaomi.channel.commonutils.android.a.a.UNKNOWN;
        return r5;
    L_0x0059:
        r5 = com.xiaomi.channel.commonutils.android.a.a.UNKNOWN;
        return r5;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.android.a.c(android.content.Context, java.lang.String):com.xiaomi.channel.commonutils.android.a$a");
    }

    public static boolean d(Context context, String str) {
        List<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null) {
            for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (Arrays.asList(runningAppProcessInfo.pkgList).contains(str)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean e(android.content.Context r1, java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = r1.getPackageManager();	 Catch:{ NameNotFoundException -> 0x000a }
        r1 = r1.getPackageInfo(r2, r0);	 Catch:{ NameNotFoundException -> 0x000a }
        goto L_0x000b;
    L_0x000a:
        r1 = 0;
    L_0x000b:
        if (r1 != 0) goto L_0x000e;
    L_0x000d:
        return r0;
    L_0x000e:
        r1 = 1;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.channel.commonutils.android.a.e(android.content.Context, java.lang.String):boolean");
    }

    public static String f(Context context, String str) {
        try {
            return a(context.getPackageManager().getPackageInfo(str, 4096).requestedPermissions);
        } catch (NameNotFoundException e) {
            b.d(e.toString());
            return "";
        }
    }

    public static boolean g(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
