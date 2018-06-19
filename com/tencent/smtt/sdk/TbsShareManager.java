package com.tencent.smtt.sdk;

import android.content.Context;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.utils.TbsLog;
import com.xiaomi.push.service.av;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TbsShareManager {
    private static Context a = null;
    private static boolean b = false;
    private static String c = null;
    private static String d = null;
    private static int e = 0;
    private static String f = null;
    private static boolean g = false;
    private static boolean h = false;
    private static String i = null;
    private static boolean j = false;
    private static boolean k = false;
    public static boolean mHasQueryed = false;

    static int a(Context context, boolean z) {
        b(context, z);
        return e;
    }

    static android.content.Context a(android.content.Context r2, java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 2;
        r1 = 0;
        r2 = r2.createPackageContext(r3, r0);	 Catch:{ NameNotFoundException -> 0x000b, Exception -> 0x0007 }
        return r2;
    L_0x0007:
        r2 = move-exception;
        r2.printStackTrace();
    L_0x000b:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsShareManager.a(android.content.Context, java.lang.String):android.content.Context");
    }

    static void a(Context context) {
        try {
            TbsLinuxToolsJni tbsLinuxToolsJni = new TbsLinuxToolsJni(context);
            a(context, tbsLinuxToolsJni, aj.a().m(context));
            tbsLinuxToolsJni.a(aj.a().n(context).getAbsolutePath(), "755");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void a(Context context, TbsLinuxToolsJni tbsLinuxToolsJni, File file) {
        if (file != null && file.exists() && file.isDirectory()) {
            tbsLinuxToolsJni.a(file.getAbsolutePath(), "755");
            for (File file2 : file.listFiles()) {
                if (file2.isFile()) {
                    String absolutePath;
                    String str;
                    if (file2.getAbsolutePath().indexOf(".so") > 0) {
                        absolutePath = file2.getAbsolutePath();
                        str = "755";
                    } else {
                        absolutePath = file2.getAbsolutePath();
                        str = "644";
                    }
                    tbsLinuxToolsJni.a(absolutePath, str);
                } else if (file2.isDirectory()) {
                    a(context, tbsLinuxToolsJni, file2);
                } else {
                    TbsLog.e("TbsShareManager", "unknown file type.", true);
                }
            }
        }
    }

    private static File b(Context context, String str) {
        File n = aj.a().n(context);
        if (n == null) {
            return null;
        }
        File file = new File(n, str);
        if (file.exists()) {
            return file;
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    static void b(Context context) {
        try {
            a(context, new TbsLinuxToolsJni(context), aj.a().l(context));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    static boolean b(Context context, boolean z) {
        if (h(context)) {
            return true;
        }
        if (z) {
            QbSdk.a(context, "TbsShareManager::isShareTbsCoreAvailable forceSysWebViewInner!");
        }
        return false;
    }

    static String c(Context context) {
        i(context);
        return d;
    }

    private static void c(android.content.Context r6, boolean r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = "core_info";	 Catch:{ Throwable -> 0x0075, all -> 0x0072 }
        r1 = b(r6, r1);	 Catch:{ Throwable -> 0x0075, all -> 0x0072 }
        if (r1 != 0) goto L_0x000a;	 Catch:{ Throwable -> 0x0075, all -> 0x0072 }
    L_0x0009:
        return;	 Catch:{ Throwable -> 0x0075, all -> 0x0072 }
    L_0x000a:
        r2 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x0075, all -> 0x0072 }
        r2.<init>(r1);	 Catch:{ Throwable -> 0x0075, all -> 0x0072 }
        r3 = new java.io.BufferedInputStream;	 Catch:{ Throwable -> 0x0075, all -> 0x0072 }
        r3.<init>(r2);	 Catch:{ Throwable -> 0x0075, all -> 0x0072 }
        r2 = new java.util.Properties;	 Catch:{ Throwable -> 0x006e, all -> 0x006c }
        r2.<init>();	 Catch:{ Throwable -> 0x006e, all -> 0x006c }
        r2.load(r3);	 Catch:{ Throwable -> 0x006e, all -> 0x006c }
        r4 = "core_disabled";	 Catch:{ Throwable -> 0x006e, all -> 0x006c }
        r5 = "false";	 Catch:{ Throwable -> 0x006e, all -> 0x006c }
        r2.setProperty(r4, r5);	 Catch:{ Throwable -> 0x006e, all -> 0x006c }
        if (r7 == 0) goto L_0x0050;	 Catch:{ Throwable -> 0x006e, all -> 0x006c }
    L_0x0025:
        r7 = com.tencent.smtt.sdk.aj.a();	 Catch:{ Throwable -> 0x006e, all -> 0x006c }
        r7 = r7.m(r6);	 Catch:{ Throwable -> 0x006e, all -> 0x006c }
        r7 = r7.getAbsolutePath();	 Catch:{ Throwable -> 0x006e, all -> 0x006c }
        r4 = r6.getApplicationContext();	 Catch:{ Throwable -> 0x006e, all -> 0x006c }
        r4 = r4.getPackageName();	 Catch:{ Throwable -> 0x006e, all -> 0x006c }
        r6 = com.tencent.smtt.utils.b.b(r6);	 Catch:{ Throwable -> 0x006e, all -> 0x006c }
        r5 = "core_packagename";	 Catch:{ Throwable -> 0x006e, all -> 0x006c }
        r2.setProperty(r5, r4);	 Catch:{ Throwable -> 0x006e, all -> 0x006c }
        r4 = "core_path";	 Catch:{ Throwable -> 0x006e, all -> 0x006c }
        r2.setProperty(r4, r7);	 Catch:{ Throwable -> 0x006e, all -> 0x006c }
        r7 = "app_version";	 Catch:{ Throwable -> 0x006e, all -> 0x006c }
        r6 = java.lang.String.valueOf(r6);	 Catch:{ Throwable -> 0x006e, all -> 0x006c }
        r2.setProperty(r7, r6);	 Catch:{ Throwable -> 0x006e, all -> 0x006c }
    L_0x0050:
        r6 = new java.io.FileOutputStream;	 Catch:{ Throwable -> 0x006e, all -> 0x006c }
        r6.<init>(r1);	 Catch:{ Throwable -> 0x006e, all -> 0x006c }
        r7 = new java.io.BufferedOutputStream;	 Catch:{ Throwable -> 0x006e, all -> 0x006c }
        r7.<init>(r6);	 Catch:{ Throwable -> 0x006e, all -> 0x006c }
        r2.store(r7, r0);	 Catch:{ Throwable -> 0x006a, all -> 0x0068 }
        if (r3 == 0) goto L_0x0062;
    L_0x005f:
        r3.close();	 Catch:{ Exception -> 0x0062 }
    L_0x0062:
        if (r7 == 0) goto L_0x0067;
    L_0x0064:
        r7.close();	 Catch:{ Exception -> 0x0067 }
    L_0x0067:
        return;
    L_0x0068:
        r6 = move-exception;
        goto L_0x0087;
    L_0x006a:
        r6 = move-exception;
        goto L_0x0070;
    L_0x006c:
        r6 = move-exception;
        goto L_0x0088;
    L_0x006e:
        r6 = move-exception;
        r7 = r0;
    L_0x0070:
        r0 = r3;
        goto L_0x0077;
    L_0x0072:
        r6 = move-exception;
        r3 = r0;
        goto L_0x0088;
    L_0x0075:
        r6 = move-exception;
        r7 = r0;
    L_0x0077:
        r6.printStackTrace();	 Catch:{ all -> 0x0085 }
        if (r0 == 0) goto L_0x007f;
    L_0x007c:
        r0.close();	 Catch:{ Exception -> 0x007f }
    L_0x007f:
        if (r7 == 0) goto L_0x0084;
    L_0x0081:
        r7.close();	 Catch:{ Exception -> 0x0084 }
    L_0x0084:
        return;
    L_0x0085:
        r6 = move-exception;
        r3 = r0;
    L_0x0087:
        r0 = r7;
    L_0x0088:
        if (r3 == 0) goto L_0x008d;
    L_0x008a:
        r3.close();	 Catch:{ Exception -> 0x008d }
    L_0x008d:
        if (r0 == 0) goto L_0x0092;
    L_0x008f:
        r0.close();	 Catch:{ Exception -> 0x0092 }
    L_0x0092:
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsShareManager.c(android.content.Context, boolean):void");
    }

    static int d(Context context) {
        return a(context, true);
    }

    static Context e(Context context) {
        i(context);
        Context context2 = null;
        if (f != null) {
            context = a(context, f);
            if (!aj.a().d(context)) {
                return null;
            }
            context2 = context;
        }
        return context2;
    }

    static synchronized java.lang.String f(android.content.Context r6) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.tencent.smtt.sdk.TbsShareManager.class;
        monitor-enter(r0);
        r1 = 0;
        r2 = "core_info";	 Catch:{ Throwable -> 0x0045, all -> 0x0040 }
        r6 = b(r6, r2);	 Catch:{ Throwable -> 0x0045, all -> 0x0040 }
        if (r6 != 0) goto L_0x000e;
    L_0x000c:
        monitor-exit(r0);
        return r1;
    L_0x000e:
        r2 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x0045, all -> 0x0040 }
        r2.<init>(r6);	 Catch:{ Throwable -> 0x0045, all -> 0x0040 }
        r6 = new java.io.BufferedInputStream;	 Catch:{ Throwable -> 0x0045, all -> 0x0040 }
        r6.<init>(r2);	 Catch:{ Throwable -> 0x0045, all -> 0x0040 }
        r2 = new java.util.Properties;	 Catch:{ Throwable -> 0x003e }
        r2.<init>();	 Catch:{ Throwable -> 0x003e }
        r2.load(r6);	 Catch:{ Throwable -> 0x003e }
        r3 = "core_packagename";	 Catch:{ Throwable -> 0x003e }
        r4 = "";	 Catch:{ Throwable -> 0x003e }
        r2 = r2.getProperty(r3, r4);	 Catch:{ Throwable -> 0x003e }
        r3 = "";	 Catch:{ Throwable -> 0x003e }
        r3 = r3.equals(r2);	 Catch:{ Throwable -> 0x003e }
        if (r3 != 0) goto L_0x0037;
    L_0x0030:
        if (r6 == 0) goto L_0x0035;
    L_0x0032:
        r6.close();	 Catch:{ Exception -> 0x0035 }
    L_0x0035:
        monitor-exit(r0);
        return r2;
    L_0x0037:
        if (r6 == 0) goto L_0x003c;
    L_0x0039:
        r6.close();	 Catch:{ Exception -> 0x003c }
    L_0x003c:
        monitor-exit(r0);
        return r1;
    L_0x003e:
        r2 = move-exception;
        goto L_0x0047;
    L_0x0040:
        r6 = move-exception;
        r5 = r1;
        r1 = r6;
        r6 = r5;
        goto L_0x0052;
    L_0x0045:
        r2 = move-exception;
        r6 = r1;
    L_0x0047:
        r2.printStackTrace();	 Catch:{ all -> 0x0051 }
        if (r6 == 0) goto L_0x004f;
    L_0x004c:
        r6.close();	 Catch:{ Exception -> 0x004f }
    L_0x004f:
        monitor-exit(r0);
        return r1;
    L_0x0051:
        r1 = move-exception;
    L_0x0052:
        if (r6 == 0) goto L_0x005a;
    L_0x0054:
        r6.close();	 Catch:{ Exception -> 0x005a }
        goto L_0x005a;
    L_0x0058:
        r6 = move-exception;
        goto L_0x005b;
    L_0x005a:
        throw r1;	 Catch:{ all -> 0x0058 }
    L_0x005b:
        monitor-exit(r0);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsShareManager.f(android.content.Context):java.lang.String");
    }

    public static int findCoreForThirdPartyApp(Context context) {
        String str;
        String str2;
        m(context);
        StringBuilder stringBuilder = new StringBuilder("core_info mAvailableCoreVersion is ");
        stringBuilder.append(e);
        stringBuilder.append(" mAvailableCorePath is ");
        stringBuilder.append(d);
        stringBuilder.append(" mSrcPackageName is ");
        stringBuilder.append(f);
        TbsLog.i("TbsShareManager", stringBuilder.toString());
        if (f == null) {
            TbsLog.e("TbsShareManager", "mSrcPackageName is null !!!");
        }
        if (f == null || !f.equals("AppDefined")) {
            if (!(j(context) || k(context))) {
                e = 0;
                d = null;
                f = null;
                str = "TbsShareManager";
                str2 = "core_info error checkCoreInfo is false and checkCoreInOthers is false ";
            }
            if (e > 0 && (QbSdk.a(context, e) || g)) {
                e = 0;
                d = null;
                f = null;
                TbsLog.i("TbsShareManager", "core_info error QbSdk.isX5Disabled ");
            }
            return e;
        }
        if (e != aj.a().a(c)) {
            e = 0;
            d = null;
            f = null;
            str = "TbsShareManager";
            StringBuilder stringBuilder2 = new StringBuilder("check AppDefined core is error src is ");
            stringBuilder2.append(e);
            stringBuilder2.append(" dest is ");
            stringBuilder2.append(aj.a().a(c));
            str2 = stringBuilder2.toString();
        }
        e = 0;
        d = null;
        f = null;
        TbsLog.i("TbsShareManager", "core_info error QbSdk.isX5Disabled ");
        return e;
        TbsLog.i(str, str2);
        e = 0;
        d = null;
        f = null;
        TbsLog.i("TbsShareManager", "core_info error QbSdk.isX5Disabled ");
        return e;
    }

    public static boolean forceLoadX5FromTBSDemo(Context context) {
        if (context == null || aj.a().a(context, null)) {
            return false;
        }
        int sharedTbsCoreVersion = getSharedTbsCoreVersion(context, TbsConfig.APP_DEMO);
        if (sharedTbsCoreVersion > 0) {
            writeProperties(context, Integer.toString(sharedTbsCoreVersion), TbsConfig.APP_DEMO, aj.a().m(a(context, TbsConfig.APP_DEMO)).getAbsolutePath(), "1");
            return true;
        }
        return false;
    }

    public static void forceToLoadX5ForThirdApp(android.content.Context r8, boolean r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = isThirdPartyApp(r8);	 Catch:{ Exception -> 0x00ef }
        if (r0 != 0) goto L_0x0007;	 Catch:{ Exception -> 0x00ef }
    L_0x0006:
        return;	 Catch:{ Exception -> 0x00ef }
    L_0x0007:
        r0 = com.tencent.smtt.sdk.aj.a();	 Catch:{ Exception -> 0x00ef }
        r0 = r0.n(r8);	 Catch:{ Exception -> 0x00ef }
        if (r0 != 0) goto L_0x0012;	 Catch:{ Exception -> 0x00ef }
    L_0x0011:
        return;	 Catch:{ Exception -> 0x00ef }
    L_0x0012:
        if (r9 == 0) goto L_0x0022;	 Catch:{ Exception -> 0x00ef }
    L_0x0014:
        r9 = new java.io.File;	 Catch:{ Exception -> 0x00ef }
        r1 = "core_info";	 Catch:{ Exception -> 0x00ef }
        r9.<init>(r0, r1);	 Catch:{ Exception -> 0x00ef }
        r9 = r9.exists();	 Catch:{ Exception -> 0x00ef }
        if (r9 == 0) goto L_0x0022;	 Catch:{ Exception -> 0x00ef }
    L_0x0021:
        return;	 Catch:{ Exception -> 0x00ef }
    L_0x0022:
        r9 = c;	 Catch:{ Exception -> 0x00ef }
        if (r9 == 0) goto L_0x004f;	 Catch:{ Exception -> 0x00ef }
    L_0x0026:
        r9 = com.tencent.smtt.sdk.aj.a();	 Catch:{ Exception -> 0x00ef }
        r0 = c;	 Catch:{ Exception -> 0x00ef }
        r9 = r9.a(r0);	 Catch:{ Exception -> 0x00ef }
        if (r9 <= 0) goto L_0x004f;	 Catch:{ Exception -> 0x00ef }
    L_0x0032:
        r0 = c;	 Catch:{ Exception -> 0x00ef }
        d = r0;	 Catch:{ Exception -> 0x00ef }
        r0 = "AppDefined";	 Catch:{ Exception -> 0x00ef }
        f = r0;	 Catch:{ Exception -> 0x00ef }
        e = r9;	 Catch:{ Exception -> 0x00ef }
        r9 = e;	 Catch:{ Exception -> 0x00ef }
        r9 = java.lang.Integer.toString(r9);	 Catch:{ Exception -> 0x00ef }
        r0 = f;	 Catch:{ Exception -> 0x00ef }
        r1 = d;	 Catch:{ Exception -> 0x00ef }
        r2 = 1;	 Catch:{ Exception -> 0x00ef }
        r2 = java.lang.Integer.toString(r2);	 Catch:{ Exception -> 0x00ef }
        writeProperties(r8, r9, r0, r1, r2);	 Catch:{ Exception -> 0x00ef }
        return;	 Catch:{ Exception -> 0x00ef }
    L_0x004f:
        r9 = getCoreProviderAppList();	 Catch:{ Exception -> 0x00ef }
        r0 = r9.length;	 Catch:{ Exception -> 0x00ef }
        r1 = 0;	 Catch:{ Exception -> 0x00ef }
        r2 = r1;	 Catch:{ Exception -> 0x00ef }
    L_0x0056:
        r3 = 0;	 Catch:{ Exception -> 0x00ef }
        if (r2 >= r0) goto L_0x00a8;	 Catch:{ Exception -> 0x00ef }
    L_0x0059:
        r4 = r9[r2];	 Catch:{ Exception -> 0x00ef }
        r5 = getCoreShareDecoupleCoreVersion(r8, r4);	 Catch:{ Exception -> 0x00ef }
        if (r5 <= 0) goto L_0x00a5;	 Catch:{ Exception -> 0x00ef }
    L_0x0061:
        r6 = a(r8, r4);	 Catch:{ Exception -> 0x00ef }
        r7 = com.tencent.smtt.sdk.aj.a();	 Catch:{ Exception -> 0x00ef }
        r6 = r7.c(r8, r6);	 Catch:{ Exception -> 0x00ef }
        r6 = r6.getAbsolutePath();	 Catch:{ Exception -> 0x00ef }
        d = r6;	 Catch:{ Exception -> 0x00ef }
        f = r4;	 Catch:{ Exception -> 0x00ef }
        e = r5;	 Catch:{ Exception -> 0x00ef }
        r4 = com.tencent.smtt.sdk.QbSdk.canLoadX5FirstTimeThirdApp(r8);	 Catch:{ Exception -> 0x00ef }
        if (r4 == 0) goto L_0x009f;	 Catch:{ Exception -> 0x00ef }
    L_0x007d:
        r9 = com.tencent.smtt.utils.b.b(r8);	 Catch:{ Exception -> 0x00ef }
        r0 = e;	 Catch:{ Exception -> 0x00ef }
        r0 = java.lang.Integer.toString(r0);	 Catch:{ Exception -> 0x00ef }
        r1 = f;	 Catch:{ Exception -> 0x00ef }
        r2 = d;	 Catch:{ Exception -> 0x00ef }
        r9 = java.lang.Integer.toString(r9);	 Catch:{ Exception -> 0x00ef }
        writeProperties(r8, r0, r1, r2, r9);	 Catch:{ Exception -> 0x00ef }
        r8 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00ef }
        r9 = "writeProperties is ";	 Catch:{ Exception -> 0x00ef }
        r8.<init>(r9);	 Catch:{ Exception -> 0x00ef }
        r9 = e;	 Catch:{ Exception -> 0x00ef }
        r8.append(r9);	 Catch:{ Exception -> 0x00ef }
        return;	 Catch:{ Exception -> 0x00ef }
    L_0x009f:
        e = r1;	 Catch:{ Exception -> 0x00ef }
        d = r3;	 Catch:{ Exception -> 0x00ef }
        f = r3;	 Catch:{ Exception -> 0x00ef }
    L_0x00a5:
        r2 = r2 + 1;	 Catch:{ Exception -> 0x00ef }
        goto L_0x0056;	 Catch:{ Exception -> 0x00ef }
    L_0x00a8:
        r0 = r9.length;	 Catch:{ Exception -> 0x00ef }
        r2 = r1;	 Catch:{ Exception -> 0x00ef }
    L_0x00aa:
        if (r2 >= r0) goto L_0x00ef;	 Catch:{ Exception -> 0x00ef }
    L_0x00ac:
        r4 = r9[r2];	 Catch:{ Exception -> 0x00ef }
        r5 = getSharedTbsCoreVersion(r8, r4);	 Catch:{ Exception -> 0x00ef }
        if (r5 <= 0) goto L_0x00ec;	 Catch:{ Exception -> 0x00ef }
    L_0x00b4:
        r6 = a(r8, r4);	 Catch:{ Exception -> 0x00ef }
        r7 = com.tencent.smtt.sdk.aj.a();	 Catch:{ Exception -> 0x00ef }
        r6 = r7.b(r8, r6);	 Catch:{ Exception -> 0x00ef }
        r6 = r6.getAbsolutePath();	 Catch:{ Exception -> 0x00ef }
        d = r6;	 Catch:{ Exception -> 0x00ef }
        f = r4;	 Catch:{ Exception -> 0x00ef }
        e = r5;	 Catch:{ Exception -> 0x00ef }
        r4 = com.tencent.smtt.sdk.QbSdk.canLoadX5FirstTimeThirdApp(r8);	 Catch:{ Exception -> 0x00ef }
        if (r4 == 0) goto L_0x00e6;	 Catch:{ Exception -> 0x00ef }
    L_0x00d0:
        r9 = com.tencent.smtt.utils.b.b(r8);	 Catch:{ Exception -> 0x00ef }
        r0 = e;	 Catch:{ Exception -> 0x00ef }
        r0 = java.lang.Integer.toString(r0);	 Catch:{ Exception -> 0x00ef }
        r1 = f;	 Catch:{ Exception -> 0x00ef }
        r2 = d;	 Catch:{ Exception -> 0x00ef }
        r9 = java.lang.Integer.toString(r9);	 Catch:{ Exception -> 0x00ef }
        writeProperties(r8, r0, r1, r2, r9);	 Catch:{ Exception -> 0x00ef }
        return;	 Catch:{ Exception -> 0x00ef }
    L_0x00e6:
        e = r1;	 Catch:{ Exception -> 0x00ef }
        d = r3;	 Catch:{ Exception -> 0x00ef }
        f = r3;	 Catch:{ Exception -> 0x00ef }
    L_0x00ec:
        r2 = r2 + 1;
        goto L_0x00aa;
    L_0x00ef:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsShareManager.forceToLoadX5ForThirdApp(android.content.Context, boolean):void");
    }

    static synchronized int g(Context context) {
        Throwable th;
        synchronized (TbsShareManager.class) {
            BufferedInputStream bufferedInputStream;
            try {
                File b = b(context, "core_info");
                if (b == null) {
                    return 0;
                }
                bufferedInputStream = new BufferedInputStream(new FileInputStream(b));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream);
                    String property = properties.getProperty("core_version", "");
                    if (!"".equals(property)) {
                        int max = Math.max(Integer.parseInt(property), 0);
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    } else if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e22) {
                                e22.printStackTrace();
                            }
                        }
                        return -2;
                    } catch (Throwable th3) {
                        th = th3;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e222) {
                                e222.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                throw th;
            }
        }
        return max;
        return 0;
    }

    public static boolean getCoreDisabled() {
        return g;
    }

    public static boolean getCoreFormOwn() {
        return j;
    }

    public static String[] getCoreProviderAppList() {
        return new String[]{TbsConfig.APP_DEMO, "com.tencent.mm", "com.tencent.mobileqq", "com.qzone"};
    }

    public static int getCoreShareDecoupleCoreVersion(Context context, String str) {
        context = a(context, str);
        return context != null ? aj.a().f(context) : 0;
    }

    public static String getHostCorePathAppDefined() {
        return c;
    }

    public static long getHostCoreVersions(Context context) {
        long j = 0;
        for (String str : getCoreProviderAppList()) {
            long sharedTbsCoreVersion;
            long j2;
            if (str.equalsIgnoreCase("com.tencent.mm")) {
                sharedTbsCoreVersion = (long) getSharedTbsCoreVersion(context, str);
                j2 = 10000000000L;
            } else if (str.equalsIgnoreCase("com.tencent.mobileqq")) {
                sharedTbsCoreVersion = (long) getSharedTbsCoreVersion(context, str);
                j2 = 100000;
            } else if (str.equalsIgnoreCase("com.qzone")) {
                sharedTbsCoreVersion = (long) getSharedTbsCoreVersion(context, str);
                j += sharedTbsCoreVersion;
            } else {
            }
            sharedTbsCoreVersion *= j2;
            j += sharedTbsCoreVersion;
        }
        return j;
    }

    public static int getSharedTbsCoreVersion(Context context, String str) {
        context = a(context, str);
        return context != null ? aj.a().g(context) : 0;
    }

    static boolean h(Context context) {
        try {
            if (e == 0) {
                findCoreForThirdPartyApp(context);
            }
            if (e == 0) {
                TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_NO_SHARE_X5CORE, null, new Object[0]);
                return false;
            }
            if (c == null) {
                if (e != 0 && getSharedTbsCoreVersion(context, f) == e) {
                    return true;
                }
            } else if (e != 0 && aj.a().a(c) == e) {
                return true;
            }
            if (k(context)) {
                return true;
            }
            TbsCoreLoadStat instance = TbsCoreLoadStat.getInstance();
            StringBuilder stringBuilder = new StringBuilder("mAvailableCoreVersion=");
            stringBuilder.append(e);
            stringBuilder.append("; mSrcPackageName=");
            stringBuilder.append(f);
            stringBuilder.append("; getSharedTbsCoreVersion(ctx, mSrcPackageName) is ");
            stringBuilder.append(getSharedTbsCoreVersion(context, f));
            stringBuilder.append("; getHostCoreVersions is ");
            stringBuilder.append(getHostCoreVersions(context));
            instance.a(context, ErrorCode.INFO_CORE_EXIST_NOT_LOAD, new Throwable(stringBuilder.toString()));
            d = null;
            e = 0;
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_CONFLICT_X5CORE, null, new Object[0]);
            QbSdk.a(context, "TbsShareManager::isShareTbsCoreAvailableInner forceSysWebViewInner!");
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            TbsLog.addLog(TbsLog.TBSLOG_CODE_SDK_UNAVAIL_X5CORE, null, new Object[0]);
            return false;
        }
    }

    static boolean i(Context context) {
        return b(context, true);
    }

    public static boolean isThirdPartyApp(Context context) {
        try {
            if (a != null && a.equals(context.getApplicationContext())) {
                return b;
            }
            context = context.getApplicationContext();
            a = context;
            String packageName = context.getPackageName();
            for (Object equals : getCoreProviderAppList()) {
                if (packageName.equals(equals)) {
                    b = false;
                    return false;
                }
            }
            b = true;
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static boolean j(Context context) {
        return f == null ? false : e == getSharedTbsCoreVersion(context, f) || e == getCoreShareDecoupleCoreVersion(context, f);
    }

    private static boolean k(Context context) {
        Context a;
        String[] coreProviderAppList = getCoreProviderAppList();
        for (String str : coreProviderAppList) {
            if (e > 0 && e == getSharedTbsCoreVersion(context, str)) {
                a = a(context, str);
                if (aj.a().d(context)) {
                    File b = aj.a().b(context, a);
                    break;
                }
            }
        }
        for (String str2 : coreProviderAppList) {
            if (e > 0 && e == getCoreShareDecoupleCoreVersion(context, str2)) {
                a = a(context, str2);
                if (aj.a().d(context)) {
                    b = aj.a().c(context, a);
                    d = b.getAbsolutePath();
                    f = str2;
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean l(Context context) {
        if (context == null) {
            return false;
        }
        writeProperties(context, Integer.toString(0), "", "", Integer.toString(0));
        return true;
    }

    private static synchronized void m(Context context) {
        BufferedInputStream bufferedInputStream;
        Throwable th;
        synchronized (TbsShareManager.class) {
            if (k) {
                return;
            }
            try {
                File b = b(context, "core_info");
                if (b == null) {
                    return;
                }
                bufferedInputStream = new BufferedInputStream(new FileInputStream(b));
                try {
                    Properties properties = new Properties();
                    properties.load(bufferedInputStream);
                    String property = properties.getProperty("core_version", "");
                    if (!"".equals(property)) {
                        e = Math.max(Integer.parseInt(property), 0);
                    }
                    property = properties.getProperty("core_packagename", "");
                    if (!"".equals(property)) {
                        f = property;
                    }
                    if (!(f == null || a == null)) {
                        if (f.equals(a.getPackageName())) {
                            j = true;
                        } else {
                            j = false;
                        }
                    }
                    property = properties.getProperty("core_path", "");
                    if (!"".equals(property)) {
                        d = property;
                    }
                    property = properties.getProperty("app_version", "");
                    if (!"".equals(property)) {
                        i = property;
                    }
                    g = Boolean.parseBoolean(properties.getProperty("core_disabled", av.b));
                    k = true;
                    if (bufferedInputStream != null) {
                        try {
                            bufferedInputStream.close();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        th.printStackTrace();
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                        }
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        if (bufferedInputStream != null) {
                            try {
                                bufferedInputStream.close();
                            } catch (Exception e22) {
                                e22.printStackTrace();
                            }
                        }
                        throw th;
                    }
                }
            } catch (Throwable th4) {
                th = th4;
                bufferedInputStream = null;
                if (bufferedInputStream != null) {
                    bufferedInputStream.close();
                }
                throw th;
            }
        }
    }

    public static void setHostCorePathAppDefined(String str) {
        c = str;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void writeCoreInfoForThirdPartyApp(android.content.Context r9, int r10, boolean r11) {
        /*
        r0 = com.tencent.smtt.sdk.TbsShareManager.class;
        monitor-enter(r0);
        if (r10 != 0) goto L_0x0018;
    L_0x0005:
        l(r9);	 Catch:{ all -> 0x0015 }
        r9 = a;	 Catch:{ all -> 0x0015 }
        r9 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r9);	 Catch:{ all -> 0x0015 }
        r10 = -401; // 0xfffffffffffffe6f float:NaN double:NaN;
        r9.setDownloadInterruptCode(r10);	 Catch:{ all -> 0x0015 }
        monitor-exit(r0);
        return;
    L_0x0015:
        r9 = move-exception;
        goto L_0x0298;
    L_0x0018:
        r1 = g(r9);	 Catch:{ all -> 0x0015 }
        if (r1 >= 0) goto L_0x002b;
    L_0x001e:
        r9 = a;	 Catch:{ all -> 0x0015 }
        r9 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r9);	 Catch:{ all -> 0x0015 }
        r10 = -402; // 0xfffffffffffffe6e float:NaN double:NaN;
        r9.setDownloadInterruptCode(r10);	 Catch:{ all -> 0x0015 }
        monitor-exit(r0);
        return;
    L_0x002b:
        if (r10 != r1) goto L_0x003d;
    L_0x002d:
        c(r9, r11);	 Catch:{ all -> 0x0015 }
        r9 = a;	 Catch:{ all -> 0x0015 }
        r9 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r9);	 Catch:{ all -> 0x0015 }
        r10 = -403; // 0xfffffffffffffe6d float:NaN double:NaN;
        r9.setDownloadInterruptCode(r10);	 Catch:{ all -> 0x0015 }
        monitor-exit(r0);
        return;
    L_0x003d:
        if (r10 >= r1) goto L_0x0054;
    L_0x003f:
        r1 = 43300; // 0xa924 float:6.0676E-41 double:2.1393E-319;
        if (r10 >= r1) goto L_0x0054;
    L_0x0044:
        l(r9);	 Catch:{ all -> 0x0015 }
        r9 = a;	 Catch:{ all -> 0x0015 }
        r9 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r9);	 Catch:{ all -> 0x0015 }
        r10 = -404; // 0xfffffffffffffe6c float:NaN double:NaN;
        r9.setDownloadInterruptCode(r10);	 Catch:{ all -> 0x0015 }
        monitor-exit(r0);
        return;
    L_0x0054:
        r1 = getCoreProviderAppList();	 Catch:{ all -> 0x0015 }
        r2 = 0;
        r3 = 1;
        if (r11 == 0) goto L_0x0068;
    L_0x005c:
        r1 = new java.lang.String[r3];	 Catch:{ all -> 0x0015 }
        r11 = r9.getApplicationContext();	 Catch:{ all -> 0x0015 }
        r11 = r11.getPackageName();	 Catch:{ all -> 0x0015 }
        r1[r2] = r11;	 Catch:{ all -> 0x0015 }
    L_0x0068:
        r11 = c;	 Catch:{ all -> 0x0015 }
        if (r11 == 0) goto L_0x0151;
    L_0x006c:
        r11 = com.tencent.smtt.sdk.aj.a();	 Catch:{ all -> 0x0015 }
        r4 = c;	 Catch:{ all -> 0x0015 }
        r11 = r11.a(r4);	 Catch:{ all -> 0x0015 }
        if (r10 != r11) goto L_0x00be;
    L_0x0078:
        r10 = java.lang.Integer.toString(r10);	 Catch:{ all -> 0x0015 }
        r11 = "AppDefined";
        r1 = c;	 Catch:{ all -> 0x0015 }
        r2 = java.lang.Integer.toString(r3);	 Catch:{ all -> 0x0015 }
        writeProperties(r9, r10, r11, r1, r2);	 Catch:{ all -> 0x0015 }
        r10 = "core_info";
        r10 = b(r9, r10);	 Catch:{ Throwable -> 0x00b8 }
        r11 = h;	 Catch:{ Throwable -> 0x00b8 }
        if (r11 != 0) goto L_0x00b6;
    L_0x0091:
        if (r10 == 0) goto L_0x00b6;
    L_0x0093:
        r11 = new com.tencent.smtt.sdk.TbsLinuxToolsJni;	 Catch:{ Throwable -> 0x00b8 }
        r1 = a;	 Catch:{ Throwable -> 0x00b8 }
        r11.<init>(r1);	 Catch:{ Throwable -> 0x00b8 }
        r10 = r10.getAbsolutePath();	 Catch:{ Throwable -> 0x00b8 }
        r1 = "644";
        r11.a(r10, r1);	 Catch:{ Throwable -> 0x00b8 }
        r10 = com.tencent.smtt.sdk.aj.a();	 Catch:{ Throwable -> 0x00b8 }
        r9 = r10.n(r9);	 Catch:{ Throwable -> 0x00b8 }
        r9 = r9.getAbsolutePath();	 Catch:{ Throwable -> 0x00b8 }
        r10 = "755";
        r11.a(r9, r10);	 Catch:{ Throwable -> 0x00b8 }
        h = r3;	 Catch:{ Throwable -> 0x00b8 }
    L_0x00b6:
        monitor-exit(r0);
        return;
    L_0x00b8:
        r9 = move-exception;
        r9.printStackTrace();	 Catch:{ all -> 0x0015 }
        monitor-exit(r0);
        return;
    L_0x00be:
        r11 = com.tencent.smtt.sdk.aj.a();	 Catch:{ all -> 0x0015 }
        r4 = c;	 Catch:{ all -> 0x0015 }
        r11 = r11.a(r4);	 Catch:{ all -> 0x0015 }
        if (r10 <= r11) goto L_0x0151;
    L_0x00ca:
        r11 = r1.length;	 Catch:{ all -> 0x0015 }
        r4 = r2;
    L_0x00cc:
        if (r4 >= r11) goto L_0x0151;
    L_0x00ce:
        r5 = r1[r4];	 Catch:{ all -> 0x0015 }
        r6 = getSharedTbsCoreVersion(r9, r5);	 Catch:{ all -> 0x0015 }
        if (r10 != r6) goto L_0x014d;
    L_0x00d6:
        r5 = a(r9, r5);	 Catch:{ all -> 0x0015 }
        r6 = com.tencent.smtt.sdk.aj.a();	 Catch:{ all -> 0x0015 }
        r6 = r6.m(r5);	 Catch:{ all -> 0x0015 }
        r6 = r6.getAbsolutePath();	 Catch:{ all -> 0x0015 }
        com.tencent.smtt.utils.b.b(r9);	 Catch:{ all -> 0x0015 }
        r7 = com.tencent.smtt.sdk.aj.a();	 Catch:{ all -> 0x0015 }
        r5 = r7.d(r5);	 Catch:{ all -> 0x0015 }
        if (r5 == 0) goto L_0x014d;
    L_0x00f3:
        r11 = new java.io.File;	 Catch:{ all -> 0x0015 }
        r1 = c;	 Catch:{ all -> 0x0015 }
        r11.<init>(r1);	 Catch:{ all -> 0x0015 }
        r1 = new java.io.File;	 Catch:{ all -> 0x0015 }
        r1.<init>(r6);	 Catch:{ all -> 0x0015 }
        r2 = new com.tencent.smtt.sdk.aw;	 Catch:{ all -> 0x0015 }
        r2.<init>();	 Catch:{ all -> 0x0015 }
        com.tencent.smtt.utils.k.a(r1, r11, r2);	 Catch:{ Throwable -> 0x0147 }
        r10 = java.lang.Integer.toString(r10);	 Catch:{ Throwable -> 0x0147 }
        r11 = "AppDefined";
        r1 = c;	 Catch:{ Throwable -> 0x0147 }
        r2 = java.lang.Integer.toString(r3);	 Catch:{ Throwable -> 0x0147 }
        writeProperties(r9, r10, r11, r1, r2);	 Catch:{ Throwable -> 0x0147 }
        r10 = "core_info";
        r10 = b(r9, r10);	 Catch:{ Throwable -> 0x0147 }
        r11 = h;	 Catch:{ Throwable -> 0x0147 }
        if (r11 != 0) goto L_0x0145;
    L_0x0120:
        if (r10 == 0) goto L_0x0145;
    L_0x0122:
        r11 = new com.tencent.smtt.sdk.TbsLinuxToolsJni;	 Catch:{ Throwable -> 0x0147 }
        r1 = a;	 Catch:{ Throwable -> 0x0147 }
        r11.<init>(r1);	 Catch:{ Throwable -> 0x0147 }
        r10 = r10.getAbsolutePath();	 Catch:{ Throwable -> 0x0147 }
        r1 = "644";
        r11.a(r10, r1);	 Catch:{ Throwable -> 0x0147 }
        r10 = com.tencent.smtt.sdk.aj.a();	 Catch:{ Throwable -> 0x0147 }
        r9 = r10.n(r9);	 Catch:{ Throwable -> 0x0147 }
        r9 = r9.getAbsolutePath();	 Catch:{ Throwable -> 0x0147 }
        r10 = "755";
        r11.a(r9, r10);	 Catch:{ Throwable -> 0x0147 }
        h = r3;	 Catch:{ Throwable -> 0x0147 }
    L_0x0145:
        monitor-exit(r0);
        return;
    L_0x0147:
        r9 = move-exception;
        r9.printStackTrace();	 Catch:{ all -> 0x0015 }
        monitor-exit(r0);
        return;
    L_0x014d:
        r4 = r4 + 1;
        goto L_0x00cc;
    L_0x0151:
        r11 = r1.length;	 Catch:{ all -> 0x0015 }
    L_0x0152:
        if (r2 >= r11) goto L_0x0296;
    L_0x0154:
        r4 = r1[r2];	 Catch:{ all -> 0x0015 }
        r5 = getSharedTbsCoreVersion(r9, r4);	 Catch:{ all -> 0x0015 }
        if (r10 != r5) goto L_0x01f4;
    L_0x015c:
        r5 = a(r9, r4);	 Catch:{ all -> 0x0015 }
        r6 = com.tencent.smtt.sdk.aj.a();	 Catch:{ all -> 0x0015 }
        r6 = r6.m(r5);	 Catch:{ all -> 0x0015 }
        r6 = r6.getAbsolutePath();	 Catch:{ all -> 0x0015 }
        r7 = com.tencent.smtt.utils.b.b(r9);	 Catch:{ all -> 0x0015 }
        r8 = com.tencent.smtt.sdk.aj.a();	 Catch:{ all -> 0x0015 }
        r5 = r8.d(r5);	 Catch:{ all -> 0x0015 }
        if (r5 == 0) goto L_0x0292;
    L_0x017a:
        r11 = r9.getApplicationContext();	 Catch:{ all -> 0x0015 }
        r11 = r11.getPackageName();	 Catch:{ all -> 0x0015 }
        r11 = r4.equals(r11);	 Catch:{ all -> 0x0015 }
        if (r11 != 0) goto L_0x01b2;
    L_0x0188:
        r11 = "TbsShareManager";
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0015 }
        r2 = "thirdAPP pre--> delete old core_share Directory:";
        r1.<init>(r2);	 Catch:{ all -> 0x0015 }
        r1.append(r10);	 Catch:{ all -> 0x0015 }
        r1 = r1.toString();	 Catch:{ all -> 0x0015 }
        com.tencent.smtt.utils.TbsLog.i(r11, r1);	 Catch:{ all -> 0x0015 }
        r11 = com.tencent.smtt.sdk.aj.a();	 Catch:{ all -> 0x0015 }
        r11 = r11.m(r9);	 Catch:{ all -> 0x0015 }
        com.tencent.smtt.utils.k.b(r11);	 Catch:{ Throwable -> 0x01ae }
        r11 = "TbsShareManager";
        r1 = "thirdAPP success--> delete old core_share Directory";
        com.tencent.smtt.utils.TbsLog.i(r11, r1);	 Catch:{ Throwable -> 0x01ae }
        goto L_0x01b2;
    L_0x01ae:
        r11 = move-exception;
        r11.printStackTrace();	 Catch:{ all -> 0x0015 }
    L_0x01b2:
        r10 = java.lang.Integer.toString(r10);	 Catch:{ all -> 0x0015 }
        r11 = java.lang.Integer.toString(r7);	 Catch:{ all -> 0x0015 }
        writeProperties(r9, r10, r4, r6, r11);	 Catch:{ all -> 0x0015 }
        r10 = "core_info";
        r10 = b(r9, r10);	 Catch:{ Throwable -> 0x01ee }
        r11 = h;	 Catch:{ Throwable -> 0x01ee }
        if (r11 != 0) goto L_0x01ec;
    L_0x01c7:
        if (r10 == 0) goto L_0x01ec;
    L_0x01c9:
        r11 = new com.tencent.smtt.sdk.TbsLinuxToolsJni;	 Catch:{ Throwable -> 0x01ee }
        r1 = a;	 Catch:{ Throwable -> 0x01ee }
        r11.<init>(r1);	 Catch:{ Throwable -> 0x01ee }
        r10 = r10.getAbsolutePath();	 Catch:{ Throwable -> 0x01ee }
        r1 = "644";
        r11.a(r10, r1);	 Catch:{ Throwable -> 0x01ee }
        r10 = com.tencent.smtt.sdk.aj.a();	 Catch:{ Throwable -> 0x01ee }
        r9 = r10.n(r9);	 Catch:{ Throwable -> 0x01ee }
        r9 = r9.getAbsolutePath();	 Catch:{ Throwable -> 0x01ee }
        r10 = "755";
        r11.a(r9, r10);	 Catch:{ Throwable -> 0x01ee }
        h = r3;	 Catch:{ Throwable -> 0x01ee }
    L_0x01ec:
        monitor-exit(r0);
        return;
    L_0x01ee:
        r9 = move-exception;
        r9.printStackTrace();	 Catch:{ all -> 0x0015 }
        monitor-exit(r0);
        return;
    L_0x01f4:
        r5 = getCoreShareDecoupleCoreVersion(r9, r4);	 Catch:{ all -> 0x0015 }
        if (r10 != r5) goto L_0x0292;
    L_0x01fa:
        r5 = a(r9, r4);	 Catch:{ all -> 0x0015 }
        r6 = com.tencent.smtt.sdk.aj.a();	 Catch:{ all -> 0x0015 }
        r6 = r6.l(r5);	 Catch:{ all -> 0x0015 }
        r6 = r6.getAbsolutePath();	 Catch:{ all -> 0x0015 }
        r7 = com.tencent.smtt.utils.b.b(r9);	 Catch:{ all -> 0x0015 }
        r8 = com.tencent.smtt.sdk.aj.a();	 Catch:{ all -> 0x0015 }
        r5 = r8.d(r5);	 Catch:{ all -> 0x0015 }
        if (r5 == 0) goto L_0x0292;
    L_0x0218:
        r11 = r9.getApplicationContext();	 Catch:{ all -> 0x0015 }
        r11 = r11.getPackageName();	 Catch:{ all -> 0x0015 }
        r11 = r4.equals(r11);	 Catch:{ all -> 0x0015 }
        if (r11 != 0) goto L_0x0250;
    L_0x0226:
        r11 = "TbsShareManager";
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0015 }
        r2 = "thirdAPP pre--> delete old core_share Directory:";
        r1.<init>(r2);	 Catch:{ all -> 0x0015 }
        r1.append(r10);	 Catch:{ all -> 0x0015 }
        r1 = r1.toString();	 Catch:{ all -> 0x0015 }
        com.tencent.smtt.utils.TbsLog.i(r11, r1);	 Catch:{ all -> 0x0015 }
        r11 = com.tencent.smtt.sdk.aj.a();	 Catch:{ all -> 0x0015 }
        r11 = r11.m(r9);	 Catch:{ all -> 0x0015 }
        com.tencent.smtt.utils.k.b(r11);	 Catch:{ Throwable -> 0x024c }
        r11 = "TbsShareManager";
        r1 = "thirdAPP success--> delete old core_share Directory";
        com.tencent.smtt.utils.TbsLog.i(r11, r1);	 Catch:{ Throwable -> 0x024c }
        goto L_0x0250;
    L_0x024c:
        r11 = move-exception;
        r11.printStackTrace();	 Catch:{ all -> 0x0015 }
    L_0x0250:
        r10 = java.lang.Integer.toString(r10);	 Catch:{ all -> 0x0015 }
        r11 = java.lang.Integer.toString(r7);	 Catch:{ all -> 0x0015 }
        writeProperties(r9, r10, r4, r6, r11);	 Catch:{ all -> 0x0015 }
        r10 = "core_info";
        r10 = b(r9, r10);	 Catch:{ Throwable -> 0x028c }
        r11 = h;	 Catch:{ Throwable -> 0x028c }
        if (r11 != 0) goto L_0x028a;
    L_0x0265:
        if (r10 == 0) goto L_0x028a;
    L_0x0267:
        r11 = new com.tencent.smtt.sdk.TbsLinuxToolsJni;	 Catch:{ Throwable -> 0x028c }
        r1 = a;	 Catch:{ Throwable -> 0x028c }
        r11.<init>(r1);	 Catch:{ Throwable -> 0x028c }
        r10 = r10.getAbsolutePath();	 Catch:{ Throwable -> 0x028c }
        r1 = "644";
        r11.a(r10, r1);	 Catch:{ Throwable -> 0x028c }
        r10 = com.tencent.smtt.sdk.aj.a();	 Catch:{ Throwable -> 0x028c }
        r9 = r10.n(r9);	 Catch:{ Throwable -> 0x028c }
        r9 = r9.getAbsolutePath();	 Catch:{ Throwable -> 0x028c }
        r10 = "755";
        r11.a(r9, r10);	 Catch:{ Throwable -> 0x028c }
        h = r3;	 Catch:{ Throwable -> 0x028c }
    L_0x028a:
        monitor-exit(r0);
        return;
    L_0x028c:
        r9 = move-exception;
        r9.printStackTrace();	 Catch:{ all -> 0x0015 }
        monitor-exit(r0);
        return;
    L_0x0292:
        r2 = r2 + 1;
        goto L_0x0152;
    L_0x0296:
        monitor-exit(r0);
        return;
    L_0x0298:
        monitor-exit(r0);
        throw r9;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsShareManager.writeCoreInfoForThirdPartyApp(android.content.Context, int, boolean):void");
    }

    public static void writeProperties(android.content.Context r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = "core_info";	 Catch:{ Throwable -> 0x0095, all -> 0x0092 }
        r6 = b(r6, r1);	 Catch:{ Throwable -> 0x0095, all -> 0x0092 }
        if (r6 != 0) goto L_0x0015;	 Catch:{ Throwable -> 0x0095, all -> 0x0092 }
    L_0x0009:
        r6 = a;	 Catch:{ Throwable -> 0x0095, all -> 0x0092 }
        r6 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r6);	 Catch:{ Throwable -> 0x0095, all -> 0x0092 }
        r7 = -405; // 0xfffffffffffffe6b float:NaN double:NaN;	 Catch:{ Throwable -> 0x0095, all -> 0x0092 }
        r6.setDownloadInterruptCode(r7);	 Catch:{ Throwable -> 0x0095, all -> 0x0092 }
        return;	 Catch:{ Throwable -> 0x0095, all -> 0x0092 }
    L_0x0015:
        r1 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x0095, all -> 0x0092 }
        r1.<init>(r6);	 Catch:{ Throwable -> 0x0095, all -> 0x0092 }
        r2 = new java.io.BufferedInputStream;	 Catch:{ Throwable -> 0x0095, all -> 0x0092 }
        r2.<init>(r1);	 Catch:{ Throwable -> 0x0095, all -> 0x0092 }
        r1 = new java.util.Properties;	 Catch:{ Throwable -> 0x008e, all -> 0x008c }
        r1.<init>();	 Catch:{ Throwable -> 0x008e, all -> 0x008c }
        r1.load(r2);	 Catch:{ Throwable -> 0x008e, all -> 0x008c }
        r3 = 0;
        r4 = java.lang.Integer.parseInt(r7);	 Catch:{ Exception -> 0x002d }
        goto L_0x002e;
    L_0x002d:
        r4 = r3;
    L_0x002e:
        if (r4 == 0) goto L_0x004c;
    L_0x0030:
        r4 = "core_version";	 Catch:{ Throwable -> 0x008e, all -> 0x008c }
        r1.setProperty(r4, r7);	 Catch:{ Throwable -> 0x008e, all -> 0x008c }
        r7 = "core_disabled";	 Catch:{ Throwable -> 0x008e, all -> 0x008c }
        r4 = "false";	 Catch:{ Throwable -> 0x008e, all -> 0x008c }
        r1.setProperty(r7, r4);	 Catch:{ Throwable -> 0x008e, all -> 0x008c }
        r7 = "core_packagename";	 Catch:{ Throwable -> 0x008e, all -> 0x008c }
        r1.setProperty(r7, r8);	 Catch:{ Throwable -> 0x008e, all -> 0x008c }
        r7 = "core_path";	 Catch:{ Throwable -> 0x008e, all -> 0x008c }
        r1.setProperty(r7, r9);	 Catch:{ Throwable -> 0x008e, all -> 0x008c }
        r7 = "app_version";	 Catch:{ Throwable -> 0x008e, all -> 0x008c }
        r1.setProperty(r7, r10);	 Catch:{ Throwable -> 0x008e, all -> 0x008c }
        goto L_0x0053;	 Catch:{ Throwable -> 0x008e, all -> 0x008c }
    L_0x004c:
        r7 = "core_disabled";	 Catch:{ Throwable -> 0x008e, all -> 0x008c }
        r8 = "true";	 Catch:{ Throwable -> 0x008e, all -> 0x008c }
        r1.setProperty(r7, r8);	 Catch:{ Throwable -> 0x008e, all -> 0x008c }
    L_0x0053:
        r7 = new java.io.FileOutputStream;	 Catch:{ Throwable -> 0x008e, all -> 0x008c }
        r7.<init>(r6);	 Catch:{ Throwable -> 0x008e, all -> 0x008c }
        r6 = new java.io.BufferedOutputStream;	 Catch:{ Throwable -> 0x008e, all -> 0x008c }
        r6.<init>(r7);	 Catch:{ Throwable -> 0x008e, all -> 0x008c }
        r1.store(r6, r0);	 Catch:{ Throwable -> 0x0086, all -> 0x0082 }
        k = r3;	 Catch:{ Throwable -> 0x0086, all -> 0x0082 }
        r7 = a;	 Catch:{ Throwable -> 0x0086, all -> 0x0082 }
        r7 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r7);	 Catch:{ Throwable -> 0x0086, all -> 0x0082 }
        r8 = -406; // 0xfffffffffffffe6a float:NaN double:NaN;	 Catch:{ Throwable -> 0x0086, all -> 0x0082 }
        r7.setDownloadInterruptCode(r8);	 Catch:{ Throwable -> 0x0086, all -> 0x0082 }
        if (r2 == 0) goto L_0x0077;
    L_0x006f:
        r2.close();	 Catch:{ Exception -> 0x0073 }
        goto L_0x0077;
    L_0x0073:
        r7 = move-exception;
        r7.printStackTrace();
    L_0x0077:
        if (r6 == 0) goto L_0x0081;
    L_0x0079:
        r6.close();	 Catch:{ Exception -> 0x007d }
        return;
    L_0x007d:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x0081:
        return;
    L_0x0082:
        r7 = move-exception;
        r0 = r6;
        r6 = r7;
        goto L_0x00b2;
    L_0x0086:
        r7 = move-exception;
        r0 = r2;
        r5 = r7;
        r7 = r6;
        r6 = r5;
        goto L_0x0097;
    L_0x008c:
        r6 = move-exception;
        goto L_0x00b2;
    L_0x008e:
        r6 = move-exception;
        r7 = r0;
        r0 = r2;
        goto L_0x0097;
    L_0x0092:
        r6 = move-exception;
        r2 = r0;
        goto L_0x00b2;
    L_0x0095:
        r6 = move-exception;
        r7 = r0;
    L_0x0097:
        r6.printStackTrace();	 Catch:{ all -> 0x00af }
        if (r0 == 0) goto L_0x00a4;
    L_0x009c:
        r0.close();	 Catch:{ Exception -> 0x00a0 }
        goto L_0x00a4;
    L_0x00a0:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x00a4:
        if (r7 == 0) goto L_0x00ae;
    L_0x00a6:
        r7.close();	 Catch:{ Exception -> 0x00aa }
        return;
    L_0x00aa:
        r6 = move-exception;
        r6.printStackTrace();
    L_0x00ae:
        return;
    L_0x00af:
        r6 = move-exception;
        r2 = r0;
        r0 = r7;
    L_0x00b2:
        if (r2 == 0) goto L_0x00bc;
    L_0x00b4:
        r2.close();	 Catch:{ Exception -> 0x00b8 }
        goto L_0x00bc;
    L_0x00b8:
        r7 = move-exception;
        r7.printStackTrace();
    L_0x00bc:
        if (r0 == 0) goto L_0x00c6;
    L_0x00be:
        r0.close();	 Catch:{ Exception -> 0x00c2 }
        goto L_0x00c6;
    L_0x00c2:
        r7 = move-exception;
        r7.printStackTrace();
    L_0x00c6:
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.TbsShareManager.writeProperties(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }
}
