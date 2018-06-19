package com.tencent.open.utils;

import android.content.Context;
import android.content.Intent;
import com.tencent.connect.common.Constants;
import com.tencent.open.a.f;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.MessageDigest;

/* compiled from: ProGuard */
public class g {
    public static String a(int i) {
        return i == 10103 ? "shareToQQ" : i == 10104 ? "shareToQzone" : i == Constants.REQUEST_QQ_FAVORITES ? "addToQQFavorites" : i == Constants.REQUEST_SEND_TO_MY_COMPUTER ? "sendToMyComputer" : i == Constants.REQUEST_SHARE_TO_TROOP_BAR ? "shareToTroopBar" : i == 11101 ? "action_login" : i == Constants.REQUEST_API ? "action_request" : null;
    }

    public static java.lang.String a(android.content.Context r1, java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r1 = r1.getPackageManager();
        r0 = 0;
        r1 = r1.getPackageInfo(r2, r0);	 Catch:{ NameNotFoundException -> 0x000c }
        r1 = r1.versionName;	 Catch:{ NameNotFoundException -> 0x000c }
        return r1;
    L_0x000c:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.g.a(android.content.Context, java.lang.String):java.lang.String");
    }

    public static int a(java.lang.String r8, java.lang.String r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r8 != 0) goto L_0x0006;
    L_0x0003:
        if (r9 != 0) goto L_0x0006;
    L_0x0005:
        return r0;
    L_0x0006:
        r1 = 1;
        if (r8 == 0) goto L_0x000c;
    L_0x0009:
        if (r9 != 0) goto L_0x000c;
    L_0x000b:
        return r1;
    L_0x000c:
        r2 = -1;
        if (r8 != 0) goto L_0x0012;
    L_0x000f:
        if (r9 == 0) goto L_0x0012;
    L_0x0011:
        return r2;
    L_0x0012:
        r3 = "\\.";
        r3 = r8.split(r3);
        r4 = "\\.";
        r4 = r9.split(r4);
        r5 = r0;
    L_0x001f:
        r6 = r3.length;	 Catch:{ NumberFormatException -> 0x0043 }
        if (r5 >= r6) goto L_0x003a;	 Catch:{ NumberFormatException -> 0x0043 }
    L_0x0022:
        r6 = r4.length;	 Catch:{ NumberFormatException -> 0x0043 }
        if (r5 >= r6) goto L_0x003a;	 Catch:{ NumberFormatException -> 0x0043 }
    L_0x0025:
        r6 = r3[r5];	 Catch:{ NumberFormatException -> 0x0043 }
        r6 = java.lang.Integer.parseInt(r6);	 Catch:{ NumberFormatException -> 0x0043 }
        r7 = r4[r5];	 Catch:{ NumberFormatException -> 0x0043 }
        r7 = java.lang.Integer.parseInt(r7);	 Catch:{ NumberFormatException -> 0x0043 }
        if (r6 >= r7) goto L_0x0034;	 Catch:{ NumberFormatException -> 0x0043 }
    L_0x0033:
        return r2;	 Catch:{ NumberFormatException -> 0x0043 }
    L_0x0034:
        if (r6 <= r7) goto L_0x0037;	 Catch:{ NumberFormatException -> 0x0043 }
    L_0x0036:
        return r1;	 Catch:{ NumberFormatException -> 0x0043 }
    L_0x0037:
        r5 = r5 + 1;	 Catch:{ NumberFormatException -> 0x0043 }
        goto L_0x001f;	 Catch:{ NumberFormatException -> 0x0043 }
    L_0x003a:
        r3 = r3.length;	 Catch:{ NumberFormatException -> 0x0043 }
        if (r3 <= r5) goto L_0x003e;	 Catch:{ NumberFormatException -> 0x0043 }
    L_0x003d:
        return r1;	 Catch:{ NumberFormatException -> 0x0043 }
    L_0x003e:
        r1 = r4.length;	 Catch:{ NumberFormatException -> 0x0043 }
        if (r1 <= r5) goto L_0x0042;
    L_0x0041:
        return r2;
    L_0x0042:
        return r0;
    L_0x0043:
        r8 = r8.compareTo(r9);
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.g.a(java.lang.String, java.lang.String):int");
    }

    public static boolean a(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "openSDK_LOG.SystemUtils";
        r1 = "OpenUi, validateAppSignatureForPackage";
        com.tencent.open.a.f.a(r0, r1);
        r0 = 0;
        r3 = r3.getPackageManager();	 Catch:{ NameNotFoundException -> 0x002e }
        r1 = 64;	 Catch:{ NameNotFoundException -> 0x002e }
        r3 = r3.getPackageInfo(r4, r1);	 Catch:{ NameNotFoundException -> 0x002e }
        r3 = r3.signatures;
        r4 = r3.length;
        r1 = r0;
    L_0x0016:
        if (r1 >= r4) goto L_0x002d;
    L_0x0018:
        r2 = r3[r1];
        r2 = r2.toCharsString();
        r2 = com.tencent.open.utils.i.f(r2);
        r2 = r2.equals(r5);
        if (r2 == 0) goto L_0x002a;
    L_0x0028:
        r3 = 1;
        return r3;
    L_0x002a:
        r1 = r1 + 1;
        goto L_0x0016;
    L_0x002d:
        return r0;
    L_0x002e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.g.a(android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    public static String b(Context context, String str) {
        f.a("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString");
        String str2 = "";
        try {
            String packageName = context.getPackageName();
            context = context.getPackageManager().getPackageInfo(packageName, 64).signatures;
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(context[0].toByteArray());
            context = i.a(instance.digest());
            instance.reset();
            StringBuilder stringBuilder = new StringBuilder("-->sign: ");
            stringBuilder.append(context);
            f.a("openSDK_LOG.SystemUtils", stringBuilder.toString());
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append(packageName);
            stringBuilder2.append("_");
            stringBuilder2.append(context);
            stringBuilder2.append("_");
            stringBuilder2.append(str);
            instance.update(i.i(stringBuilder2.toString()));
            context = i.a(instance.digest());
            try {
                instance.reset();
                StringBuilder stringBuilder3 = new StringBuilder("-->signEncryped: ");
                stringBuilder3.append(context);
                f.a("openSDK_LOG.SystemUtils", stringBuilder3.toString());
            } catch (Exception e) {
                str = e;
                str.printStackTrace();
                f.b("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString error", str);
                return context;
            }
        } catch (Exception e2) {
            str = e2;
            context = str2;
            str.printStackTrace();
            f.b("openSDK_LOG.SystemUtils", "OpenUi, getSignValidString error", str);
            return context;
        }
        return context;
    }

    public static boolean a(Context context, Intent intent) {
        if (context != null) {
            if (intent != null) {
                if (context.getPackageManager().queryIntentActivities(intent, 0).size() != null) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    public static String a(Context context) {
        return context.getApplicationInfo().loadLabel(context.getPackageManager()).toString();
    }

    public static int c(Context context, String str) {
        return a(a(context, "com.tencent.mobileqq"), str);
    }

    public static int d(Context context, String str) {
        return a(a(context, Constants.PACKAGE_TIM), str);
    }

    @android.annotation.SuppressLint({"SdCardPath"})
    public static boolean a(java.lang.String r8, java.lang.String r9, int r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "openSDK_LOG.SystemUtils";
        r1 = new java.lang.StringBuilder;
        r2 = "-->extractSecureLib, libName: ";
        r1.<init>(r2);
        r1.append(r8);
        r1 = r1.toString();
        com.tencent.open.a.f.c(r0, r1);
        r0 = com.tencent.open.utils.d.a();
        r1 = 0;
        if (r0 != 0) goto L_0x0022;
    L_0x001a:
        r8 = "openSDK_LOG.SystemUtils";
        r9 = "-->extractSecureLib, global context is null. ";
        com.tencent.open.a.f.c(r8, r9);
        return r1;
    L_0x0022:
        r2 = "secure_lib";
        r2 = r0.getSharedPreferences(r2, r1);
        r3 = new java.io.File;
        r4 = r0.getFilesDir();
        r3.<init>(r4, r9);
        r4 = r3.exists();
        r5 = 1;
        if (r4 != 0) goto L_0x004d;
    L_0x0038:
        r4 = r3.getParentFile();
        if (r4 == 0) goto L_0x0071;
    L_0x003e:
        r4 = r4.mkdirs();
        if (r4 == 0) goto L_0x0071;
    L_0x0044:
        r3.createNewFile();	 Catch:{ IOException -> 0x0048 }
        goto L_0x0071;
    L_0x0048:
        r3 = move-exception;
        r3.printStackTrace();
        goto L_0x0071;
    L_0x004d:
        r3 = "version";
        r3 = r2.getInt(r3, r1);
        r4 = "openSDK_LOG.SystemUtils";
        r6 = new java.lang.StringBuilder;
        r7 = "-->extractSecureLib, libVersion: ";
        r6.<init>(r7);
        r6.append(r10);
        r7 = " | oldVersion: ";
        r6.append(r7);
        r6.append(r3);
        r6 = r6.toString();
        com.tencent.open.a.f.c(r4, r6);
        if (r10 != r3) goto L_0x0071;
    L_0x0070:
        return r5;
    L_0x0071:
        r3 = 0;
        r4 = r0.getAssets();	 Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
        r8 = r4.open(r8);	 Catch:{ Exception -> 0x00a7, all -> 0x00a3 }
        r9 = r0.openFileOutput(r9, r1);	 Catch:{ Exception -> 0x009f, all -> 0x009c }
        a(r8, r9);	 Catch:{ Exception -> 0x009a, all -> 0x0098 }
        r0 = r2.edit();	 Catch:{ Exception -> 0x009a, all -> 0x0098 }
        r2 = "version";	 Catch:{ Exception -> 0x009a, all -> 0x0098 }
        r0.putInt(r2, r10);	 Catch:{ Exception -> 0x009a, all -> 0x0098 }
        r0.commit();	 Catch:{ Exception -> 0x009a, all -> 0x0098 }
        if (r8 == 0) goto L_0x0092;
    L_0x008f:
        r8.close();	 Catch:{ IOException -> 0x0092 }
    L_0x0092:
        if (r9 == 0) goto L_0x0097;
    L_0x0094:
        r9.close();	 Catch:{ IOException -> 0x0097 }
    L_0x0097:
        return r5;
    L_0x0098:
        r10 = move-exception;
        goto L_0x00bd;
    L_0x009a:
        r10 = move-exception;
        goto L_0x00a1;
    L_0x009c:
        r10 = move-exception;
        r9 = r3;
        goto L_0x00bd;
    L_0x009f:
        r10 = move-exception;
        r9 = r3;
    L_0x00a1:
        r3 = r8;
        goto L_0x00a9;
    L_0x00a3:
        r10 = move-exception;
        r8 = r3;
        r9 = r8;
        goto L_0x00bd;
    L_0x00a7:
        r10 = move-exception;
        r9 = r3;
    L_0x00a9:
        r8 = "openSDK_LOG.SystemUtils";	 Catch:{ all -> 0x00bb }
        r0 = "-->extractSecureLib, when copy lib execption.";	 Catch:{ all -> 0x00bb }
        com.tencent.open.a.f.b(r8, r0, r10);	 Catch:{ all -> 0x00bb }
        if (r3 == 0) goto L_0x00b5;
    L_0x00b2:
        r3.close();	 Catch:{ IOException -> 0x00b5 }
    L_0x00b5:
        if (r9 == 0) goto L_0x00ba;
    L_0x00b7:
        r9.close();	 Catch:{ IOException -> 0x00ba }
    L_0x00ba:
        return r1;
    L_0x00bb:
        r10 = move-exception;
        r8 = r3;
    L_0x00bd:
        if (r8 == 0) goto L_0x00c2;
    L_0x00bf:
        r8.close();	 Catch:{ IOException -> 0x00c2 }
    L_0x00c2:
        if (r9 == 0) goto L_0x00c7;
    L_0x00c4:
        r9.close();	 Catch:{ IOException -> 0x00c7 }
    L_0x00c7:
        throw r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.utils.g.a(java.lang.String, java.lang.String, int):boolean");
    }

    private static long a(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[8192];
        long j = 0;
        while (true) {
            int read = inputStream.read(bArr, 0, 8192);
            if (read != -1) {
                outputStream.write(bArr, 0, read);
                j += (long) read;
            } else {
                outputStream = new StringBuilder("-->copy, copyed size is: ");
                outputStream.append(j);
                f.c("openSDK_LOG.SystemUtils", outputStream.toString());
                return j;
            }
        }
    }

    public static int a(String str) {
        if ("shareToQQ".equals(str)) {
            return 10103;
        }
        if ("shareToQzone".equals(str)) {
            return 10104;
        }
        if ("addToQQFavorites".equals(str)) {
            return Constants.REQUEST_QQ_FAVORITES;
        }
        if ("sendToMyComputer".equals(str)) {
            return Constants.REQUEST_SEND_TO_MY_COMPUTER;
        }
        if ("shareToTroopBar".equals(str)) {
            return Constants.REQUEST_SHARE_TO_TROOP_BAR;
        }
        if ("action_login".equals(str)) {
            return 11101;
        }
        return "action_request".equals(str) != null ? Constants.REQUEST_API : -1;
    }
}
