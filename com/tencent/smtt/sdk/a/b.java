package com.tencent.smtt.sdk.a;

import a.a;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.text.TextUtils;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.TbsShareManager;
import com.tencent.smtt.utils.w;
import com.tencent.smtt.utils.x;
import com.xiaomi.mipush.sdk.Constants;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class b {
    public static byte[] a;

    static {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "65dRa93L";	 Catch:{ UnsupportedEncodingException -> 0x000a }
        r1 = "utf-8";	 Catch:{ UnsupportedEncodingException -> 0x000a }
        r0 = r0.getBytes(r1);	 Catch:{ UnsupportedEncodingException -> 0x000a }
        a = r0;	 Catch:{ UnsupportedEncodingException -> 0x000a }
    L_0x000a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.a.b.<clinit>():void");
    }

    private static String a(Context context) {
        try {
            byte[] toByteArray = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures[0].toByteArray();
            if (toByteArray != null) {
                MessageDigest instance = MessageDigest.getInstance("SHA-1");
                instance.update(toByteArray);
                toByteArray = instance.digest();
                if (toByteArray != null) {
                    StringBuilder stringBuilder = new StringBuilder("");
                    if (toByteArray == null || toByteArray.length <= 0) {
                        return null;
                    }
                    for (int i = 0; i < toByteArray.length; i++) {
                        String toUpperCase = Integer.toHexString(toByteArray[i] & 255).toUpperCase();
                        if (i > 0) {
                            stringBuilder.append(Constants.COLON_SEPARATOR);
                        }
                        if (toUpperCase.length() < 2) {
                            stringBuilder.append(0);
                        }
                        stringBuilder.append(toUpperCase);
                    }
                    return stringBuilder.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void a(a aVar, Context context) {
        new c("HttpUtils", context, aVar).start();
    }

    public static void a(Context context, String str, String str2, String str3, int i, boolean z, long j) {
        String str4;
        Exception e;
        a aVar;
        SimpleDateFormat simpleDateFormat;
        Object f;
        int i2;
        String str5 = "";
        int i3 = 0;
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if ("com.tencent.mobileqq".equals(applicationInfo.packageName)) {
                str4 = context.getPackageManager().getPackageInfo(applicationInfo.packageName, 0).versionName;
                try {
                    if (!TextUtils.isEmpty(QbSdk.getQQBuildNumber())) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(str4);
                        stringBuilder.append(".");
                        stringBuilder.append(QbSdk.getQQBuildNumber());
                        str5 = stringBuilder.toString();
                    }
                } catch (Exception e2) {
                    e = e2;
                    e.printStackTrace();
                    str5 = str4;
                    aVar = new a();
                    aVar.a = context.getApplicationContext().getApplicationInfo().packageName;
                    x.a(context);
                    simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
                    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
                    aVar.b = simpleDateFormat.format(Calendar.getInstance().getTime());
                    aVar.e = str;
                    if (z) {
                        aVar.c = str2;
                    } else {
                        aVar.c = w.a(context);
                    }
                    aVar.d = str3;
                    str = com.tencent.smtt.utils.b.e(context);
                    str2 = com.tencent.smtt.utils.b.c(context);
                    str3 = com.tencent.smtt.utils.b.d(context);
                    f = com.tencent.smtt.utils.b.f(context);
                    aVar.f = str2;
                    aVar.g = str3;
                    if (!TextUtils.isEmpty(f)) {
                        aVar.m = f;
                    }
                    aVar.h = str;
                    aVar.i = (long) i;
                    i2 = 1;
                    if (TbsShareManager.isThirdPartyApp(context)) {
                        if (z) {
                            if (TbsShareManager.getCoreFormOwn()) {
                                i3 = 2;
                            }
                            aVar.j = i2;
                            aVar.k = str5;
                            aVar.l = a(context);
                            if (!z) {
                                aVar.n = j;
                                aVar.o = QbSdk.getTbsVersion(context);
                            }
                            a(aVar, context.getApplicationContext());
                        }
                    } else if (z) {
                        aVar.j = i2;
                        aVar.k = str5;
                        aVar.l = a(context);
                        if (z) {
                            aVar.n = j;
                            aVar.o = QbSdk.getTbsVersion(context);
                        }
                        a(aVar, context.getApplicationContext());
                    }
                    i2 = i3;
                    aVar.j = i2;
                    aVar.k = str5;
                    aVar.l = a(context);
                    if (z) {
                        aVar.n = j;
                        aVar.o = QbSdk.getTbsVersion(context);
                    }
                    a(aVar, context.getApplicationContext());
                }
                str5 = str4;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            str4 = str5;
            e = exception;
            e.printStackTrace();
            str5 = str4;
            aVar = new a();
            aVar.a = context.getApplicationContext().getApplicationInfo().packageName;
            x.a(context);
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
            aVar.b = simpleDateFormat.format(Calendar.getInstance().getTime());
            aVar.e = str;
            if (z) {
                aVar.c = w.a(context);
            } else {
                aVar.c = str2;
            }
            aVar.d = str3;
            str = com.tencent.smtt.utils.b.e(context);
            str2 = com.tencent.smtt.utils.b.c(context);
            str3 = com.tencent.smtt.utils.b.d(context);
            f = com.tencent.smtt.utils.b.f(context);
            aVar.f = str2;
            aVar.g = str3;
            if (TextUtils.isEmpty(f)) {
                aVar.m = f;
            }
            aVar.h = str;
            aVar.i = (long) i;
            i2 = 1;
            if (TbsShareManager.isThirdPartyApp(context)) {
                if (z) {
                    aVar.j = i2;
                    aVar.k = str5;
                    aVar.l = a(context);
                    if (z) {
                        aVar.n = j;
                        aVar.o = QbSdk.getTbsVersion(context);
                    }
                    a(aVar, context.getApplicationContext());
                }
            } else if (z) {
                if (TbsShareManager.getCoreFormOwn()) {
                    i3 = 2;
                }
                aVar.j = i2;
                aVar.k = str5;
                aVar.l = a(context);
                if (z) {
                    aVar.n = j;
                    aVar.o = QbSdk.getTbsVersion(context);
                }
                a(aVar, context.getApplicationContext());
            }
            i2 = i3;
            aVar.j = i2;
            aVar.k = str5;
            aVar.l = a(context);
            if (z) {
                aVar.n = j;
                aVar.o = QbSdk.getTbsVersion(context);
            }
            a(aVar, context.getApplicationContext());
        }
        try {
            aVar = new a();
            aVar.a = context.getApplicationContext().getApplicationInfo().packageName;
            x.a(context);
            simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+08"));
            aVar.b = simpleDateFormat.format(Calendar.getInstance().getTime());
            aVar.e = str;
            if (z) {
                aVar.c = str2;
            } else {
                aVar.c = w.a(context);
            }
            aVar.d = str3;
            str = com.tencent.smtt.utils.b.e(context);
            str2 = com.tencent.smtt.utils.b.c(context);
            str3 = com.tencent.smtt.utils.b.d(context);
            f = com.tencent.smtt.utils.b.f(context);
            if (!(str2 == null || "".equals(str2))) {
                aVar.f = str2;
            }
            if (!(str3 == null || "".equals(str3))) {
                aVar.g = str3;
            }
            if (TextUtils.isEmpty(f)) {
                aVar.m = f;
            }
            if (!(str == null || "".equals(str))) {
                aVar.h = str;
            }
            aVar.i = (long) i;
            i2 = 1;
            if (TbsShareManager.isThirdPartyApp(context)) {
                if (z) {
                    if (TbsShareManager.getCoreFormOwn()) {
                        i3 = 2;
                    }
                    aVar.j = i2;
                    aVar.k = str5;
                    aVar.l = a(context);
                    if (z) {
                        aVar.n = j;
                        aVar.o = QbSdk.getTbsVersion(context);
                    }
                    a(aVar, context.getApplicationContext());
                }
            } else if (z) {
                aVar.j = i2;
                aVar.k = str5;
                aVar.l = a(context);
                if (z) {
                    aVar.n = j;
                    aVar.o = QbSdk.getTbsVersion(context);
                }
                a(aVar, context.getApplicationContext());
            }
            i2 = i3;
            aVar.j = i2;
            aVar.k = str5;
            aVar.l = a(context);
            if (z) {
                aVar.n = j;
                aVar.o = QbSdk.getTbsVersion(context);
            }
            a(aVar, context.getApplicationContext());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static org.json.JSONObject c(a.a r4, android.content.Context r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new org.json.JSONObject;	 Catch:{ Exception -> 0x0107 }
        r0.<init>();	 Catch:{ Exception -> 0x0107 }
        r1 = "APPNAME";	 Catch:{ Exception -> 0x0107 }
        r2 = r4.a;	 Catch:{ Exception -> 0x0107 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0107 }
        r1 = "TIME";	 Catch:{ Exception -> 0x0107 }
        r2 = r4.b;	 Catch:{ Exception -> 0x0107 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0107 }
        r1 = "QUA2";	 Catch:{ Exception -> 0x0107 }
        r2 = r4.c;	 Catch:{ Exception -> 0x0107 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0107 }
        r1 = "LC";	 Catch:{ Exception -> 0x0107 }
        r2 = r4.d;	 Catch:{ Exception -> 0x0107 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0107 }
        r1 = "GUID";	 Catch:{ Exception -> 0x0107 }
        r2 = r4.e;	 Catch:{ Exception -> 0x0107 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0107 }
        r1 = "IMEI";	 Catch:{ Exception -> 0x0107 }
        r2 = r4.f;	 Catch:{ Exception -> 0x0107 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0107 }
        r1 = "IMSI";	 Catch:{ Exception -> 0x0107 }
        r2 = r4.g;	 Catch:{ Exception -> 0x0107 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0107 }
        r1 = "MAC";	 Catch:{ Exception -> 0x0107 }
        r2 = r4.h;	 Catch:{ Exception -> 0x0107 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0107 }
        r1 = "PV";	 Catch:{ Exception -> 0x0107 }
        r2 = r4.i;	 Catch:{ Exception -> 0x0107 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0107 }
        r1 = "CORETYPE";	 Catch:{ Exception -> 0x0107 }
        r2 = r4.j;	 Catch:{ Exception -> 0x0107 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0107 }
        r1 = "APPVN";	 Catch:{ Exception -> 0x0107 }
        r2 = r4.k;	 Catch:{ Exception -> 0x0107 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0107 }
        r1 = r4.l;	 Catch:{ Exception -> 0x0107 }
        if (r1 != 0) goto L_0x005e;	 Catch:{ Exception -> 0x0107 }
    L_0x0056:
        r1 = "SIGNATURE";	 Catch:{ Exception -> 0x0107 }
        r2 = "0";	 Catch:{ Exception -> 0x0107 }
    L_0x005a:
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0107 }
        goto L_0x0063;	 Catch:{ Exception -> 0x0107 }
    L_0x005e:
        r1 = "SIGNATURE";	 Catch:{ Exception -> 0x0107 }
        r2 = r4.l;	 Catch:{ Exception -> 0x0107 }
        goto L_0x005a;	 Catch:{ Exception -> 0x0107 }
    L_0x0063:
        r1 = "PROTOCOL_VERSION";	 Catch:{ Exception -> 0x0107 }
        r2 = 3;	 Catch:{ Exception -> 0x0107 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0107 }
        r1 = "ANDROID_ID";	 Catch:{ Exception -> 0x0107 }
        r2 = r4.m;	 Catch:{ Exception -> 0x0107 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0107 }
        r1 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r5);	 Catch:{ Exception -> 0x0107 }
        if (r1 == 0) goto L_0x0080;	 Catch:{ Exception -> 0x0107 }
    L_0x0076:
        r1 = "HOST_COREVERSION";	 Catch:{ Exception -> 0x0107 }
        r2 = com.tencent.smtt.sdk.TbsShareManager.getHostCoreVersions(r5);	 Catch:{ Exception -> 0x0107 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0107 }
        goto L_0x0092;	 Catch:{ Exception -> 0x0107 }
    L_0x0080:
        r1 = "HOST_COREVERSION";	 Catch:{ Exception -> 0x0107 }
        r2 = com.tencent.smtt.sdk.TbsDownloader.getCoreShareDecoupleCoreVersion();	 Catch:{ Exception -> 0x0107 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0107 }
        r1 = "DECOUPLE_COREVERSION";	 Catch:{ Exception -> 0x0107 }
        r2 = com.tencent.smtt.sdk.TbsDownloader.getCoreShareDecoupleCoreVersion();	 Catch:{ Exception -> 0x0107 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0107 }
    L_0x0092:
        r1 = r4.j;	 Catch:{ Exception -> 0x0107 }
        if (r1 != 0) goto L_0x00c7;	 Catch:{ Exception -> 0x0107 }
    L_0x0096:
        r1 = "WIFICONNECTEDTIME";	 Catch:{ Exception -> 0x0107 }
        r2 = r4.n;	 Catch:{ Exception -> 0x0107 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0107 }
        r1 = "CORE_EXIST";	 Catch:{ Exception -> 0x0107 }
        r2 = r4.o;	 Catch:{ Exception -> 0x0107 }
        r0.put(r1, r2);	 Catch:{ Exception -> 0x0107 }
        r1 = com.tencent.smtt.sdk.TbsCoreLoadStat.mLoadErrorCode;	 Catch:{ Exception -> 0x0107 }
        r2 = r4.o;	 Catch:{ Exception -> 0x0107 }
        if (r2 > 0) goto L_0x00b8;	 Catch:{ Exception -> 0x0107 }
    L_0x00aa:
        r2 = "TBS_ERROR_CODE";	 Catch:{ Exception -> 0x0107 }
        r5 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r5);	 Catch:{ Exception -> 0x0107 }
        r5 = r5.getDownloadInterruptCode();	 Catch:{ Exception -> 0x0107 }
        r0.put(r2, r5);	 Catch:{ Exception -> 0x0107 }
        goto L_0x00bd;	 Catch:{ Exception -> 0x0107 }
    L_0x00b8:
        r5 = "TBS_ERROR_CODE";	 Catch:{ Exception -> 0x0107 }
        r0.put(r5, r1);	 Catch:{ Exception -> 0x0107 }
    L_0x00bd:
        r5 = -1;	 Catch:{ Exception -> 0x0107 }
        if (r1 != r5) goto L_0x00c7;	 Catch:{ Exception -> 0x0107 }
    L_0x00c0:
        r5 = "sdkreport";	 Catch:{ Exception -> 0x0107 }
        r1 = "ATTENTION: Load errorCode missed!";	 Catch:{ Exception -> 0x0107 }
        com.tencent.smtt.utils.TbsLog.e(r5, r1);	 Catch:{ Exception -> 0x0107 }
    L_0x00c7:
        r5 = com.tencent.smtt.sdk.QbSdk.getTID();	 Catch:{ Exception -> 0x0106 }
        if (r5 == 0) goto L_0x0106;	 Catch:{ Exception -> 0x0106 }
    L_0x00cd:
        r5 = r4.a;	 Catch:{ Exception -> 0x0106 }
        r1 = "com.tencent.mobileqq";	 Catch:{ Exception -> 0x0106 }
        r5 = r5.equals(r1);	 Catch:{ Exception -> 0x0106 }
        if (r5 == 0) goto L_0x00ef;	 Catch:{ Exception -> 0x0106 }
    L_0x00d7:
        r4 = "TID";	 Catch:{ Exception -> 0x0106 }
        r5 = com.tencent.smtt.utils.q.a();	 Catch:{ Exception -> 0x0106 }
        r1 = com.tencent.smtt.sdk.QbSdk.getTID();	 Catch:{ Exception -> 0x0106 }
        r5 = r5.a(r1);	 Catch:{ Exception -> 0x0106 }
        r0.put(r4, r5);	 Catch:{ Exception -> 0x0106 }
        r4 = "TIDTYPE";	 Catch:{ Exception -> 0x0106 }
        r5 = 1;	 Catch:{ Exception -> 0x0106 }
    L_0x00eb:
        r0.put(r4, r5);	 Catch:{ Exception -> 0x0106 }
        return r0;	 Catch:{ Exception -> 0x0106 }
    L_0x00ef:
        r4 = r4.a;	 Catch:{ Exception -> 0x0106 }
        r5 = "com.tencent.mm";	 Catch:{ Exception -> 0x0106 }
        r4 = r4.equals(r5);	 Catch:{ Exception -> 0x0106 }
        if (r4 == 0) goto L_0x0106;	 Catch:{ Exception -> 0x0106 }
    L_0x00f9:
        r4 = "TID";	 Catch:{ Exception -> 0x0106 }
        r5 = com.tencent.smtt.sdk.QbSdk.getTID();	 Catch:{ Exception -> 0x0106 }
        r0.put(r4, r5);	 Catch:{ Exception -> 0x0106 }
        r4 = "TIDTYPE";	 Catch:{ Exception -> 0x0106 }
        r5 = 0;
        goto L_0x00eb;
    L_0x0106:
        return r0;
    L_0x0107:
        r4 = "sdkreport";
        r5 = "getPostData exception!";
        com.tencent.smtt.utils.TbsLog.e(r4, r5);
        r4 = 0;
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.a.b.c(a.a, android.content.Context):org.json.JSONObject");
    }
}
