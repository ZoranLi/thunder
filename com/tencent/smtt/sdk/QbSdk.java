package com.tencent.smtt.sdk;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.webkit.ValueCallback;
import anet.channel.util.ErrorConstant;
import com.tencent.smtt.export.external.DexLoader;
import com.tencent.smtt.sdk.TbsDownloadConfig.TbsConfigKey;
import com.tencent.smtt.sdk.TbsListener.ErrorCode;
import com.tencent.smtt.sdk.a.d;
import com.tencent.smtt.utils.TbsLog;
import com.tencent.smtt.utils.TbsLogClient;
import com.tencent.smtt.utils.k;
import com.tencent.smtt.utils.v;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

@SuppressLint({"NewApi"})
public class QbSdk {
    private static TbsListener A = null;
    private static boolean B = false;
    private static boolean C = false;
    public static final int EXTENSION_INIT_FAILURE = -99999;
    public static final String LOGIN_TYPE_KEY_PARTNER_CALL_POS = "PosID";
    public static final String LOGIN_TYPE_KEY_PARTNER_ID = "ChannelID";
    public static final String PARAM_KEY_FEATUREID = "param_key_featureid";
    public static final String PARAM_KEY_FUNCTIONID = "param_key_functionid";
    public static final String PARAM_KEY_POSITIONID = "param_key_positionid";
    public static final int QBMODE = 2;
    public static final String SVNVERSION = "jnizz";
    public static final int TBSMODE = 1;
    public static final String TID_QQNumber_Prefix = "QQ:";
    public static final int VERSION = 1;
    static boolean a = false;
    static boolean b = false;
    static boolean c = true;
    static String d = null;
    static boolean e = false;
    static long f = 0;
    static long g = 0;
    static Object h = new Object();
    static boolean i = true;
    static volatile boolean j = a;
    static TbsListener k = new j();
    static Map<String, Object> l = null;
    private static int m = 0;
    private static String n = "";
    private static Class<?> o = null;
    private static Object p = null;
    private static boolean q = false;
    private static String[] r = null;
    private static String s = "NULL";
    public static boolean sIsVersionPrinted = false;
    private static String t = "UNKNOWN";
    private static int u = 0;
    private static int v = 170;
    private static String w = null;
    private static String x = null;
    private static boolean y = true;
    private static TbsListener z;

    public interface PreInitCallback {
        void onCoreInitFinished();

        void onViewInitFinished(boolean z);
    }

    static Bundle a(Context context, Bundle bundle) {
        TbsLogReport a;
        String str;
        if (a(context)) {
            Object a2 = v.a(p, "incrUpdate", new Class[]{Context.class, Bundle.class}, new Object[]{context, bundle});
            if (a2 != null) {
                return (Bundle) a2;
            }
            a = TbsLogReport.a(context);
            str = "incrUpdate return null!";
        } else {
            a = TbsLogReport.a(context);
            str = "initForPatch return false!";
        }
        a.a(216, str);
        return null;
    }

    static Object a(Context context, String str, Bundle bundle) {
        if (!a(context)) {
            return Integer.valueOf(EXTENSION_INIT_FAILURE);
        }
        Object a = v.a(p, "miscCall", new Class[]{String.class, Bundle.class}, new Object[]{str, bundle});
        return a != null ? a : null;
    }

    static String a() {
        return n;
    }

    static synchronized void a(Context context, String str) {
        synchronized (QbSdk.class) {
            if (a) {
                return;
            }
            a = true;
            StringBuilder stringBuilder = new StringBuilder("forceSysWebViewInner: ");
            stringBuilder.append(str);
            t = stringBuilder.toString();
            stringBuilder = new StringBuilder("QbSdk.SysWebViewForcedInner...");
            stringBuilder.append(t);
            TbsLog.e("QbSdk", stringBuilder.toString());
            TbsCoreLoadStat.getInstance().a(context, 401, new Throwable(t));
        }
    }

    static boolean a(Context context) {
        try {
            if (o != null) {
                return true;
            }
            File m = aj.a().m(context);
            if (m == null) {
                TbsLog.e("QbSdk", "QbSdk initExtension (false) optDir == null");
                return false;
            }
            File file = new File(m, "tbs_sdk_extension_dex.jar");
            if (file.exists()) {
                Class loadClass = new DexClassLoader(file.getAbsolutePath(), m.getAbsolutePath(), file.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                o = loadClass;
                p = loadClass.getConstructor(new Class[]{Context.class, Context.class}).newInstance(new Object[]{context, context});
                return true;
            }
            TbsLog.e("QbSdk", "QbSdk initExtension (false) dexFile.exists()=false", true);
            return false;
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("initExtension sys WebView: ");
            stringBuilder.append(Log.getStackTraceString(th));
            TbsLog.e("QbSdk", stringBuilder.toString());
            return false;
        }
    }

    static boolean a(Context context, int i) {
        return a(context, i, 20000);
    }

    static boolean a(Context context, int i, int i2) {
        if (!b(context)) {
            return true;
        }
        Object a = v.a(p, "isX5Disabled", new Class[]{Integer.TYPE, Integer.TYPE, Integer.TYPE}, new Object[]{Integer.valueOf(i), Integer.valueOf(43500), Integer.valueOf(i2)});
        if (a == null) {
            a = v.a(p, "isX5Disabled", new Class[]{Integer.TYPE, Integer.TYPE}, new Object[]{Integer.valueOf(i), Integer.valueOf(43500)});
            if (a == null) {
                return true;
            }
        }
        return ((Boolean) a).booleanValue();
    }

    @SuppressLint({"NewApi"})
    private static boolean a(Context context, boolean z) {
        TbsLog.initIfNeed(context);
        if (!sIsVersionPrinted) {
            TbsLog.i("QbSdk", "svn revision: jnizz; SDK_VERSION_CODE: 43500; SDK_VERSION_NAME: 3.3.0.1004");
            sIsVersionPrinted = true;
        }
        if (a && !z) {
            StringBuilder stringBuilder = new StringBuilder("QbSdk init: ");
            stringBuilder.append(t);
            TbsLog.e("QbSdk", stringBuilder.toString(), false);
            TbsCoreLoadStat.getInstance().a(context, ErrorCode.INFO_SDKINIT_IS_SYS_FORCED, new Throwable(t));
            return false;
        } else if (b) {
            TbsLog.e("QbSdk", "QbSdk init mIsSysWebViewForcedByOuter = true", true);
            TbsCoreLoadStat.getInstance().a(context, 402, new Throwable(s));
            return false;
        } else {
            if (!y) {
                c(context);
            }
            try {
                File m = aj.a().m(context);
                if (m == null) {
                    TbsLog.e("QbSdk", "QbSdk init (false) optDir == null");
                    TbsCoreLoadStat.getInstance().a(context, 312, new Throwable("QbSdk.init (false) TbsCoreShareDir is null"));
                    return false;
                }
                StringBuilder stringBuilder2;
                if (!TbsShareManager.isThirdPartyApp(context)) {
                    int a;
                    if (m != 0) {
                        a = aj.a().a(true, context);
                        if (m != a) {
                            o = null;
                            p = null;
                            StringBuilder stringBuilder3 = new StringBuilder("QbSdk init (false) not isThirdPartyApp tbsCoreInstalledVer=");
                            stringBuilder3.append(a);
                            TbsLog.e("QbSdk", stringBuilder3.toString(), true);
                            stringBuilder3 = new StringBuilder("QbSdk init (false) not isThirdPartyApp sTbsVersion=");
                            stringBuilder3.append(m);
                            TbsLog.e("QbSdk", stringBuilder3.toString(), true);
                            TbsCoreLoadStat instance = TbsCoreLoadStat.getInstance();
                            stringBuilder2 = new StringBuilder("sTbsVersion: ");
                            stringBuilder2.append(m);
                            stringBuilder2.append("; tbsCoreInstalledVer: ");
                            stringBuilder2.append(a);
                            instance.a(context, 303, new Throwable(stringBuilder2.toString()));
                            return false;
                        }
                    }
                    a = 0;
                    m = a;
                }
                if (o != null) {
                    return true;
                }
                File file;
                if (!TbsShareManager.isThirdPartyApp(context)) {
                    file = new File(aj.a().m(context), "tbs_sdk_extension_dex.jar");
                } else if (TbsShareManager.i(context)) {
                    file = new File(TbsShareManager.c(context), "tbs_sdk_extension_dex.jar");
                } else {
                    TbsCoreLoadStat.getInstance().a(context, 304, new Throwable("isShareTbsCoreAvailable false!"));
                    return false;
                }
                if (file.exists()) {
                    Object newInstance;
                    Class loadClass = new DexClassLoader(file.getAbsolutePath(), m.getAbsolutePath(), file.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                    o = loadClass;
                    Constructor constructor = loadClass.getConstructor(new Class[]{Context.class, Context.class});
                    if (TbsShareManager.isThirdPartyApp(context)) {
                        Context e = TbsShareManager.e(context);
                        if (e == null && TbsShareManager.getHostCorePathAppDefined() == null) {
                            TbsLogReport.a(context.getApplicationContext()).b(ErrorCode.HOST_CONTEXT_IS_NULL, "host context is null!");
                            return false;
                        } else if (e == null) {
                            newInstance = o.getConstructor(new Class[]{Context.class, Context.class, String.class}).newInstance(new Object[]{context, e, TbsShareManager.getHostCorePathAppDefined()});
                        } else {
                            newInstance = constructor.newInstance(new Object[]{context, e});
                        }
                    } else {
                        newInstance = constructor.newInstance(new Object[]{context, context});
                    }
                    p = newInstance;
                    v.a(p, "setClientVersion", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(1)});
                    return true;
                }
                TbsCoreLoadStat instance2;
                int i;
                Throwable exception;
                TbsLog.e("QbSdk", "QbSdk init (false) tbs_sdk_extension_dex.jar is not exist!");
                int g = aj.a().g(context);
                if (new File(file.getParentFile(), "tbs_jars_fusion_dex.jar").exists()) {
                    if (g > 0) {
                        instance2 = TbsCoreLoadStat.getInstance();
                        i = ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITH_CORE;
                        stringBuilder2 = new StringBuilder("tbs_sdk_extension_dex not exist(with fusion dex)!");
                        stringBuilder2.append(g);
                        exception = new Exception(stringBuilder2.toString());
                    } else {
                        instance2 = TbsCoreLoadStat.getInstance();
                        i = ErrorCode.INFO_MISS_SDKEXTENSION_JAR_WITH_FUSION_DEX_WITHOUT_CORE;
                        stringBuilder2 = new StringBuilder("tbs_sdk_extension_dex not exist(with fusion dex)!");
                        stringBuilder2.append(g);
                        exception = new Exception(stringBuilder2.toString());
                    }
                } else if (g > 0) {
                    instance2 = TbsCoreLoadStat.getInstance();
                    i = ErrorCode.INFO_INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX_WITH_CORE;
                    stringBuilder2 = new StringBuilder("tbs_sdk_extension_dex not exist(without fusion dex)!");
                    stringBuilder2.append(g);
                    exception = new Exception(stringBuilder2.toString());
                } else {
                    instance2 = TbsCoreLoadStat.getInstance();
                    i = ErrorCode.INFO_INFO_MISS_SDKEXTENSION_JAR_WITHOUT_FUSION_DEX_WITHOUT_CORE;
                    stringBuilder2 = new StringBuilder("tbs_sdk_extension_dex not exist(without fusion dex)!");
                    stringBuilder2.append(g);
                    exception = new Exception(stringBuilder2.toString());
                }
                instance2.a(context, i, exception);
                return false;
            } catch (Throwable th) {
                StringBuilder stringBuilder4 = new StringBuilder("QbSdk init Throwable: ");
                stringBuilder4.append(Log.getStackTraceString(th));
                TbsLog.e("QbSdk", stringBuilder4.toString());
                TbsCoreLoadStat.getInstance().a(context, 306, th);
                return false;
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean a(android.content.Context r6, boolean r7, boolean r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r8 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r6);
        r0 = 0;
        if (r8 == 0) goto L_0x0017;
    L_0x0007:
        r8 = com.tencent.smtt.sdk.TbsShareManager.h(r6);
        if (r8 != 0) goto L_0x0017;
    L_0x000d:
        r7 = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();
        r8 = 302; // 0x12e float:4.23E-43 double:1.49E-321;
        r7.a(r6, r8);
        return r0;
    L_0x0017:
        r7 = a(r6, r7);
        if (r7 != 0) goto L_0x0025;
    L_0x001d:
        r6 = "QbSdk";
        r7 = "QbSdk.init failure!";
        com.tencent.smtt.utils.TbsLog.e(r6, r7);
        return r0;
    L_0x0025:
        r7 = p;
        r8 = "canLoadX5Core";
        r1 = 1;
        r2 = new java.lang.Class[r1];
        r3 = java.lang.Integer.TYPE;
        r2[r0] = r3;
        r3 = new java.lang.Object[r1];
        r4 = 43500; // 0xa9ec float:6.0956E-41 double:2.1492E-319;
        r4 = java.lang.Integer.valueOf(r4);
        r3[r0] = r4;
        r7 = com.tencent.smtt.utils.v.a(r7, r8, r2, r3);
        if (r7 == 0) goto L_0x0288;
    L_0x0041:
        r8 = r7 instanceof java.lang.String;
        if (r8 == 0) goto L_0x0051;
    L_0x0045:
        r8 = r7;
        r8 = (java.lang.String) r8;
        r2 = "AuthenticationFail";
        r8 = r8.equalsIgnoreCase(r2);
        if (r8 == 0) goto L_0x0051;
    L_0x0050:
        return r0;
    L_0x0051:
        r8 = r7 instanceof android.os.Bundle;
        if (r8 != 0) goto L_0x006f;
    L_0x0055:
        r8 = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();
        r1 = 330; // 0x14a float:4.62E-43 double:1.63E-321;
        r2 = new java.lang.Throwable;
        r7 = java.lang.String.valueOf(r7);
        r2.<init>(r7);
        r8.a(r6, r1, r2);
        r6 = "loaderror";
        r7 = "ret not instance of bundle";
        com.tencent.smtt.utils.TbsLog.e(r6, r7);
        return r0;
    L_0x006f:
        r8 = r7;
        r8 = (android.os.Bundle) r8;
        r2 = r8.isEmpty();
        if (r2 == 0) goto L_0x0092;
    L_0x0078:
        r8 = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();
        r1 = 331; // 0x14b float:4.64E-43 double:1.635E-321;
        r2 = new java.lang.Throwable;
        r7 = java.lang.String.valueOf(r7);
        r2.<init>(r7);
        r8.a(r6, r1, r2);
        r6 = "loaderror";
        r7 = "empty bundle";
        com.tencent.smtt.utils.TbsLog.e(r6, r7);
        return r0;
    L_0x0092:
        r7 = -1;
        r2 = "result_code";	 Catch:{ Exception -> 0x009b }
        r2 = r8.getInt(r2, r7);	 Catch:{ Exception -> 0x009b }
        r7 = r2;
        goto L_0x00b3;
    L_0x009b:
        r2 = move-exception;
        r3 = "QbSdk";
        r4 = new java.lang.StringBuilder;
        r5 = "bundle.getInt(KEY_RESULT_CODE) error : ";
        r4.<init>(r5);
        r2 = r2.toString();
        r4.append(r2);
        r2 = r4.toString();
        com.tencent.smtt.utils.TbsLog.e(r3, r2);
    L_0x00b3:
        if (r7 != 0) goto L_0x00b7;
    L_0x00b5:
        r2 = r1;
        goto L_0x00b8;
    L_0x00b7:
        r2 = r0;
    L_0x00b8:
        r3 = com.tencent.smtt.sdk.TbsShareManager.isThirdPartyApp(r6);
        r4 = 307; // 0x133 float:4.3E-43 double:1.517E-321;
        if (r3 == 0) goto L_0x00f9;
    L_0x00c0:
        r1 = com.tencent.smtt.sdk.TbsShareManager.d(r6);
        com.tencent.smtt.sdk.l.a(r1);
        r1 = com.tencent.smtt.sdk.TbsShareManager.d(r6);
        r1 = java.lang.String.valueOf(r1);
        n = r1;
        r1 = r1.length();
        r3 = 5;
        if (r1 != r3) goto L_0x00ea;
    L_0x00d8:
        r1 = new java.lang.StringBuilder;
        r3 = "0";
        r1.<init>(r3);
        r3 = n;
        r1.append(r3);
        r1 = r1.toString();
        n = r1;
    L_0x00ea:
        r1 = n;
        r1 = r1.length();
        r3 = 6;
        if (r1 == r3) goto L_0x018b;
    L_0x00f3:
        r1 = "";
        n = r1;
        goto L_0x018b;
    L_0x00f9:
        r3 = android.os.Build.VERSION.SDK_INT;
        r5 = 12;
        if (r3 < r5) goto L_0x010a;
    L_0x00ff:
        r3 = "tbs_core_version";
        r5 = "0";
        r3 = r8.getString(r3, r5);
    L_0x0107:
        n = r3;
        goto L_0x0117;
    L_0x010a:
        r3 = "tbs_core_version";
        r3 = r8.getString(r3);
        n = r3;
        if (r3 != 0) goto L_0x0117;
    L_0x0114:
        r3 = "0";
        goto L_0x0107;
    L_0x0117:
        r3 = n;	 Catch:{ NumberFormatException -> 0x0120 }
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ NumberFormatException -> 0x0120 }
        m = r3;	 Catch:{ NumberFormatException -> 0x0120 }
        goto L_0x0122;
    L_0x0120:
        m = r0;
    L_0x0122:
        r3 = m;
        com.tencent.smtt.sdk.l.a(r3);
        r3 = m;
        if (r3 != 0) goto L_0x013a;
    L_0x012b:
        r7 = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();
        r8 = new java.lang.Throwable;
        r1 = "sTbsVersion is 0";
        r8.<init>(r1);
        r7.a(r6, r4, r8);
        return r0;
    L_0x013a:
        r3 = m;
        if (r3 <= 0) goto L_0x0144;
    L_0x013e:
        r3 = m;
        r5 = 25442; // 0x6362 float:3.5652E-41 double:1.257E-319;
        if (r3 <= r5) goto L_0x014c;
    L_0x0144:
        r3 = m;
        r5 = 25472; // 0x6380 float:3.5694E-41 double:1.2585E-319;
        if (r3 != r5) goto L_0x014b;
    L_0x014a:
        goto L_0x014c;
    L_0x014b:
        r1 = r0;
    L_0x014c:
        if (r1 == 0) goto L_0x018b;
    L_0x014e:
        r7 = "TbsDownload";
        r8 = new java.lang.StringBuilder;
        r1 = "is_obsolete --> delete old core:";
        r8.<init>(r1);
        r1 = m;
        r8.append(r1);
        r8 = r8.toString();
        com.tencent.smtt.utils.TbsLog.e(r7, r8);
        r7 = com.tencent.smtt.sdk.aj.a();
        r7 = r7.m(r6);
        com.tencent.smtt.utils.k.b(r7);
        r7 = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();
        r8 = new java.lang.Throwable;
        r1 = new java.lang.StringBuilder;
        r2 = "is_obsolete --> delete old core:";
        r1.<init>(r2);
        r2 = m;
        r1.append(r2);
        r1 = r1.toString();
        r8.<init>(r1);
        r7.a(r6, r4, r8);
        return r0;
    L_0x018b:
        r1 = "tbs_jarfiles";	 Catch:{ Throwable -> 0x027d }
        r1 = r8.getStringArray(r1);	 Catch:{ Throwable -> 0x027d }
        r = r1;	 Catch:{ Throwable -> 0x027d }
        r1 = r;
        r1 = r1 instanceof java.lang.String[];
        if (r1 != 0) goto L_0x01b6;
    L_0x0199:
        r7 = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();
        r8 = new java.lang.Throwable;
        r1 = new java.lang.StringBuilder;
        r2 = "sJarFiles not instanceof String[]: ";
        r1.<init>(r2);
        r2 = r;
        r1.append(r2);
        r1 = r1.toString();
        r8.<init>(r1);
        r7.a(r6, r4, r8);
        return r0;
    L_0x01b6:
        r1 = "tbs_librarypath";
        r8 = r8.getString(r1);
        d = r8;
        r8 = 0;
        if (r7 == 0) goto L_0x01d3;
    L_0x01c1:
        r1 = p;	 Catch:{ Exception -> 0x01cf }
        r3 = "getErrorCodeForLogReport";	 Catch:{ Exception -> 0x01cf }
        r5 = new java.lang.Class[r0];	 Catch:{ Exception -> 0x01cf }
        r0 = new java.lang.Object[r0];	 Catch:{ Exception -> 0x01cf }
        r0 = com.tencent.smtt.utils.v.a(r1, r3, r5, r0);	 Catch:{ Exception -> 0x01cf }
        r8 = r0;
        goto L_0x01d3;
    L_0x01cf:
        r0 = move-exception;
        r0.printStackTrace();
    L_0x01d3:
        switch(r7) {
            case -2: goto L_0x023a;
            case -1: goto L_0x01fc;
            case 0: goto L_0x027a;
            default: goto L_0x01d6;
        };
    L_0x01d6:
        r0 = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();
        r1 = 415; // 0x19f float:5.82E-43 double:2.05E-321;
        r3 = new java.lang.Throwable;
        r4 = new java.lang.StringBuilder;
        r5 = "detail: ";
        r4.<init>(r5);
        r4.append(r8);
        r8 = "errcode";
        r4.append(r8);
        r4.append(r7);
        r7 = r4.toString();
        r3.<init>(r7);
        r0.a(r6, r1, r3);
        goto L_0x027a;
    L_0x01fc:
        r7 = r8 instanceof java.lang.Integer;
        if (r7 == 0) goto L_0x021f;
    L_0x0200:
        r7 = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();
        r0 = r8;
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        r1 = new java.lang.Throwable;
        r3 = new java.lang.StringBuilder;
        r4 = "detail: ";
        r3.<init>(r4);
        r3.append(r8);
        r8 = r3.toString();
        r1.<init>(r8);
        goto L_0x025c;
    L_0x021f:
        r7 = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();
        r0 = new java.lang.Throwable;
        r1 = new java.lang.StringBuilder;
        r3 = "detail: ";
        r1.<init>(r3);
        r1.append(r8);
        r8 = r1.toString();
        r0.<init>(r8);
        r7.a(r6, r4, r0);
        goto L_0x027a;
    L_0x023a:
        r7 = r8 instanceof java.lang.Integer;
        if (r7 == 0) goto L_0x0260;
    L_0x023e:
        r7 = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();
        r0 = r8;
        r0 = (java.lang.Integer) r0;
        r0 = r0.intValue();
        r1 = new java.lang.Throwable;
        r3 = new java.lang.StringBuilder;
        r4 = "detail: ";
        r3.<init>(r4);
        r3.append(r8);
        r8 = r3.toString();
        r1.<init>(r8);
    L_0x025c:
        r7.a(r6, r0, r1);
        goto L_0x027a;
    L_0x0260:
        r7 = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();
        r0 = 404; // 0x194 float:5.66E-43 double:1.996E-321;
        r1 = new java.lang.Throwable;
        r3 = new java.lang.StringBuilder;
        r4 = "detail: ";
        r3.<init>(r4);
        r3.append(r8);
        r8 = r3.toString();
        r1.<init>(r8);
        goto L_0x025c;
    L_0x027a:
        r0 = r2;
        goto L_0x030a;
    L_0x027d:
        r7 = move-exception;
        r8 = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();
        r1 = 329; // 0x149 float:4.61E-43 double:1.625E-321;
        r8.a(r6, r1, r7);
        return r0;
    L_0x0288:
        r7 = p;
        r8 = "canLoadX5";
        r2 = new java.lang.Class[r1];
        r3 = java.lang.Integer.TYPE;
        r2[r0] = r3;
        r3 = new java.lang.Object[r1];
        r4 = com.tencent.smtt.sdk.a.a();
        r4 = java.lang.Integer.valueOf(r4);
        r3[r0] = r4;
        r7 = com.tencent.smtt.utils.v.a(r7, r8, r2, r3);
        if (r7 == 0) goto L_0x0301;
    L_0x02a4:
        r8 = r7 instanceof java.lang.String;
        if (r8 == 0) goto L_0x02b4;
    L_0x02a8:
        r8 = r7;
        r8 = (java.lang.String) r8;
        r2 = "AuthenticationFail";
        r8 = r8.equalsIgnoreCase(r2);
        if (r8 == 0) goto L_0x02b4;
    L_0x02b3:
        return r0;
    L_0x02b4:
        r8 = r7 instanceof java.lang.Boolean;
        if (r8 == 0) goto L_0x030a;
    L_0x02b8:
        r8 = com.tencent.smtt.sdk.l.d();
        m = r8;
        r8 = com.tencent.smtt.sdk.l.d();
        r6 = a(r6, r8);
        r7 = (java.lang.Boolean) r7;
        r8 = r7.booleanValue();
        if (r8 == 0) goto L_0x02d1;
    L_0x02ce:
        if (r6 != 0) goto L_0x02d1;
    L_0x02d0:
        r0 = r1;
    L_0x02d1:
        if (r0 != 0) goto L_0x0300;
    L_0x02d3:
        r8 = "loaderror";
        r1 = "318";
        com.tencent.smtt.utils.TbsLog.e(r8, r1);
        r8 = "loaderror";
        r1 = new java.lang.StringBuilder;
        r2 = "isX5Disable:";
        r1.<init>(r2);
        r1.append(r6);
        r6 = r1.toString();
        com.tencent.smtt.utils.TbsLog.w(r8, r6);
        r6 = "loaderror";
        r8 = new java.lang.StringBuilder;
        r1 = "(Boolean) ret:";
        r8.<init>(r1);
        r8.append(r7);
        r7 = r8.toString();
        com.tencent.smtt.utils.TbsLog.w(r6, r7);
    L_0x0300:
        return r0;
    L_0x0301:
        r7 = com.tencent.smtt.sdk.TbsCoreLoadStat.getInstance();
        r8 = 308; // 0x134 float:4.32E-43 double:1.52E-321;
        r7.a(r6, r8);
    L_0x030a:
        if (r0 != 0) goto L_0x0313;
    L_0x030c:
        r6 = "loaderror";
        r7 = "319";
        com.tencent.smtt.utils.TbsLog.e(r6, r7);
    L_0x0313:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.QbSdk.a(android.content.Context, boolean, boolean):boolean");
    }

    protected static String b() {
        bk b = bk.b();
        if (b != null && b.c()) {
            Object invokeStaticMethod = b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getGUID", new Class[0], new Object[0]);
            if (invokeStaticMethod != null && (invokeStaticMethod instanceof String)) {
                return (String) invokeStaticMethod;
            }
        }
        return null;
    }

    private static boolean b(Context context) {
        try {
            if (o != null) {
                return true;
            }
            File m = aj.a().m(context);
            if (m == null) {
                TbsLog.e("QbSdk", "QbSdk initForX5DisableConfig (false) optDir == null");
                return false;
            }
            File file;
            if (!TbsShareManager.isThirdPartyApp(context)) {
                file = new File(aj.a().m(context), "tbs_sdk_extension_dex.jar");
            } else if (TbsShareManager.i(context)) {
                file = new File(TbsShareManager.c(context), "tbs_sdk_extension_dex.jar");
            } else {
                TbsCoreLoadStat.getInstance().a(context, 304);
                return false;
            }
            if (file.exists()) {
                Object newInstance;
                Class loadClass = new DexClassLoader(file.getAbsolutePath(), m.getAbsolutePath(), file.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                o = loadClass;
                Constructor constructor = loadClass.getConstructor(new Class[]{Context.class, Context.class});
                if (TbsShareManager.isThirdPartyApp(context)) {
                    Context e = TbsShareManager.e(context);
                    if (e == null && TbsShareManager.getHostCorePathAppDefined() == null) {
                        TbsLogReport.a(context.getApplicationContext()).b(ErrorCode.HOST_CONTEXT_IS_NULL, "host context is null!");
                        return false;
                    } else if (e == null) {
                        newInstance = o.getConstructor(new Class[]{Context.class, Context.class, String.class}).newInstance(new Object[]{context, e, TbsShareManager.getHostCorePathAppDefined()});
                    } else {
                        newInstance = constructor.newInstance(new Object[]{context, e});
                    }
                } else {
                    newInstance = constructor.newInstance(new Object[]{context, context});
                }
                p = newInstance;
                v.a(p, "setClientVersion", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(1)});
                return true;
            }
            TbsCoreLoadStat.getInstance().a(context, 406, new Exception("initForX5DisableConfig failure -- tbs_sdk_extension_dex.jar is not exist!"));
            return false;
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("initForX5DisableConfig sys WebView: ");
            stringBuilder.append(Log.getStackTraceString(th));
            TbsLog.e("QbSdk", stringBuilder.toString());
            return false;
        }
    }

    private static void c(Context context) {
        int i;
        int g;
        Throwable th;
        StringBuilder stringBuilder;
        StringBuilder stringBuilder2;
        int i2;
        StringBuilder stringBuilder3;
        y = true;
        int i3 = 0;
        SharedPreferences sharedPreferences = null;
        int i4;
        int i5;
        Editor edit;
        File a;
        String str;
        String stringBuilder4;
        try {
            sharedPreferences = VERSION.SDK_INT >= 11 ? context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 4) : context.getSharedPreferences("tbs_preloadx5_check_cfg_file", 0);
            i = sharedPreferences.getInt("tbs_preload_x5_recorder", -1);
            if (i >= 0) {
                i++;
                if (i <= 4) {
                    i4 = i;
                } else {
                    return;
                }
            }
            i4 = -1;
            try {
                g = aj.a().g(context);
                if (g > 0) {
                    if (i <= 4) {
                        try {
                            sharedPreferences.edit().putInt("tbs_preload_x5_recorder", i).commit();
                        } catch (Throwable th2) {
                            th = th2;
                            stringBuilder = new StringBuilder("tbs_preload_x5_counter Inc exception:");
                            stringBuilder.append(Log.getStackTraceString(th));
                            TbsLog.e("QbSdk", stringBuilder.toString());
                            i = -1;
                            if (i > 3) {
                                try {
                                    i5 = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                                    edit = sharedPreferences.edit();
                                    if (i5 == g) {
                                        k.a(aj.a().m(context), false);
                                        a = af.a(context).a();
                                        if (a != null) {
                                            k.a(a, false);
                                        }
                                        str = "QbSdk";
                                        stringBuilder2 = new StringBuilder("QbSdk - preload_x5_check: tbs core ");
                                        stringBuilder2.append(g);
                                        stringBuilder2.append(" is deleted!");
                                        stringBuilder4 = stringBuilder2.toString();
                                    } else {
                                        str = "QbSdk";
                                        stringBuilder2 = new StringBuilder("QbSdk - preload_x5_check -- reset exception core_ver:");
                                        stringBuilder2.append(g);
                                        stringBuilder2.append("; value:");
                                        stringBuilder2.append(i5);
                                        stringBuilder4 = stringBuilder2.toString();
                                    }
                                    TbsLog.e(str, stringBuilder4);
                                    edit.putInt("tbs_precheck_disable_version", i5);
                                    edit.commit();
                                } catch (Throwable th3) {
                                    stringBuilder2 = new StringBuilder("tbs_preload_x5_counter disable version exception:");
                                    stringBuilder2.append(Log.getStackTraceString(th3));
                                    TbsLog.e("QbSdk", stringBuilder2.toString());
                                    return;
                                }
                            }
                            if (i4 > 0) {
                            }
                            i3 = -1;
                            try {
                                i2 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                                if (i2 > 0) {
                                    sharedPreferences.edit().putInt("tbs_preload_x5_counter", i2 - 1).commit();
                                }
                            } catch (Throwable th32) {
                                StringBuilder stringBuilder5 = new StringBuilder("tbs_preload_x5_counter Dec exception:");
                                stringBuilder5.append(Log.getStackTraceString(th32));
                                TbsLog.e("QbSdk", stringBuilder5.toString());
                            }
                            stringBuilder3 = new StringBuilder("QbSdk -- preload_x5_check result:");
                            stringBuilder3.append(i3);
                            TbsLog.i("QbSdk", stringBuilder3.toString());
                        }
                    }
                    i = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                    if (i >= 0) {
                        i++;
                        sharedPreferences.edit().putInt("tbs_preload_x5_counter", i).commit();
                        if (i > 3) {
                            i5 = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                            edit = sharedPreferences.edit();
                            if (i5 == g) {
                                k.a(aj.a().m(context), false);
                                a = af.a(context).a();
                                if (a != null) {
                                    k.a(a, false);
                                }
                                str = "QbSdk";
                                stringBuilder2 = new StringBuilder("QbSdk - preload_x5_check: tbs core ");
                                stringBuilder2.append(g);
                                stringBuilder2.append(" is deleted!");
                                stringBuilder4 = stringBuilder2.toString();
                            } else {
                                str = "QbSdk";
                                stringBuilder2 = new StringBuilder("QbSdk - preload_x5_check -- reset exception core_ver:");
                                stringBuilder2.append(g);
                                stringBuilder2.append("; value:");
                                stringBuilder2.append(i5);
                                stringBuilder4 = stringBuilder2.toString();
                            }
                            TbsLog.e(str, stringBuilder4);
                            edit.putInt("tbs_precheck_disable_version", i5);
                            edit.commit();
                        }
                        if (i4 > 0 || i4 > 3) {
                            i3 = -1;
                        } else {
                            TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- before creation!");
                            bk.b().a(context);
                            TbsLog.i("QbSdk", "QbSdk - preload_x5_check -- after creation!");
                        }
                        i2 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                        if (i2 > 0) {
                            sharedPreferences.edit().putInt("tbs_preload_x5_counter", i2 - 1).commit();
                        }
                        stringBuilder3 = new StringBuilder("QbSdk -- preload_x5_check result:");
                        stringBuilder3.append(i3);
                        TbsLog.i("QbSdk", stringBuilder3.toString());
                    }
                    i = -1;
                    if (i > 3) {
                        if (i4 > 0) {
                        }
                        i3 = -1;
                        i2 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                        if (i2 > 0) {
                            sharedPreferences.edit().putInt("tbs_preload_x5_counter", i2 - 1).commit();
                        }
                        stringBuilder3 = new StringBuilder("QbSdk -- preload_x5_check result:");
                        stringBuilder3.append(i3);
                        TbsLog.i("QbSdk", stringBuilder3.toString());
                    }
                    i5 = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                    edit = sharedPreferences.edit();
                    if (i5 == g) {
                        str = "QbSdk";
                        stringBuilder2 = new StringBuilder("QbSdk - preload_x5_check -- reset exception core_ver:");
                        stringBuilder2.append(g);
                        stringBuilder2.append("; value:");
                        stringBuilder2.append(i5);
                        stringBuilder4 = stringBuilder2.toString();
                    } else {
                        k.a(aj.a().m(context), false);
                        a = af.a(context).a();
                        if (a != null) {
                            k.a(a, false);
                        }
                        str = "QbSdk";
                        stringBuilder2 = new StringBuilder("QbSdk - preload_x5_check: tbs core ");
                        stringBuilder2.append(g);
                        stringBuilder2.append(" is deleted!");
                        stringBuilder4 = stringBuilder2.toString();
                    }
                    TbsLog.e(str, stringBuilder4);
                    edit.putInt("tbs_precheck_disable_version", i5);
                    edit.commit();
                }
            } catch (Throwable th4) {
                th = th4;
                g = -1;
                stringBuilder = new StringBuilder("tbs_preload_x5_counter Inc exception:");
                stringBuilder.append(Log.getStackTraceString(th));
                TbsLog.e("QbSdk", stringBuilder.toString());
                i = -1;
                if (i > 3) {
                    i5 = sharedPreferences.getInt("tbs_preload_x5_version", -1);
                    edit = sharedPreferences.edit();
                    if (i5 == g) {
                        k.a(aj.a().m(context), false);
                        a = af.a(context).a();
                        if (a != null) {
                            k.a(a, false);
                        }
                        str = "QbSdk";
                        stringBuilder2 = new StringBuilder("QbSdk - preload_x5_check: tbs core ");
                        stringBuilder2.append(g);
                        stringBuilder2.append(" is deleted!");
                        stringBuilder4 = stringBuilder2.toString();
                    } else {
                        str = "QbSdk";
                        stringBuilder2 = new StringBuilder("QbSdk - preload_x5_check -- reset exception core_ver:");
                        stringBuilder2.append(g);
                        stringBuilder2.append("; value:");
                        stringBuilder2.append(i5);
                        stringBuilder4 = stringBuilder2.toString();
                    }
                    TbsLog.e(str, stringBuilder4);
                    edit.putInt("tbs_precheck_disable_version", i5);
                    edit.commit();
                }
                if (i4 > 0) {
                }
                i3 = -1;
                i2 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                if (i2 > 0) {
                    sharedPreferences.edit().putInt("tbs_preload_x5_counter", i2 - 1).commit();
                }
                stringBuilder3 = new StringBuilder("QbSdk -- preload_x5_check result:");
                stringBuilder3.append(i3);
                TbsLog.i("QbSdk", stringBuilder3.toString());
            }
        } catch (Throwable th5) {
            th = th5;
            i4 = -1;
            g = i4;
            stringBuilder = new StringBuilder("tbs_preload_x5_counter Inc exception:");
            stringBuilder.append(Log.getStackTraceString(th));
            TbsLog.e("QbSdk", stringBuilder.toString());
            i = -1;
            if (i > 3) {
                if (i4 > 0) {
                }
                i3 = -1;
                i2 = sharedPreferences.getInt("tbs_preload_x5_counter", -1);
                if (i2 > 0) {
                    sharedPreferences.edit().putInt("tbs_preload_x5_counter", i2 - 1).commit();
                }
                stringBuilder3 = new StringBuilder("QbSdk -- preload_x5_check result:");
                stringBuilder3.append(i3);
                TbsLog.i("QbSdk", stringBuilder3.toString());
            }
            i5 = sharedPreferences.getInt("tbs_preload_x5_version", -1);
            edit = sharedPreferences.edit();
            if (i5 == g) {
                str = "QbSdk";
                stringBuilder2 = new StringBuilder("QbSdk - preload_x5_check -- reset exception core_ver:");
                stringBuilder2.append(g);
                stringBuilder2.append("; value:");
                stringBuilder2.append(i5);
                stringBuilder4 = stringBuilder2.toString();
            } else {
                k.a(aj.a().m(context), false);
                a = af.a(context).a();
                if (a != null) {
                    k.a(a, false);
                }
                str = "QbSdk";
                stringBuilder2 = new StringBuilder("QbSdk - preload_x5_check: tbs core ");
                stringBuilder2.append(g);
                stringBuilder2.append(" is deleted!");
                stringBuilder4 = stringBuilder2.toString();
            }
            TbsLog.e(str, stringBuilder4);
            edit.putInt("tbs_precheck_disable_version", i5);
            edit.commit();
        }
    }

    public static boolean canLoadVideo(Context context) {
        TbsCoreLoadStat instance;
        int i;
        Object a = v.a(p, "canLoadVideo", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(0)});
        if (a != null) {
            if (!((Boolean) a).booleanValue()) {
                instance = TbsCoreLoadStat.getInstance();
                i = ErrorCode.ERROR_CANLOADVIDEO_RETURN_FALSE;
            }
            return a != null ? false : ((Boolean) a).booleanValue();
        } else {
            instance = TbsCoreLoadStat.getInstance();
            i = ErrorCode.ERROR_CANLOADVIDEO_RETURN_NULL;
        }
        instance.a(context, i);
        if (a != null) {
        }
    }

    public static boolean canLoadX5(Context context) {
        return a(context, false, false);
    }

    public static boolean canLoadX5FirstTimeThirdApp(Context context) {
        try {
            if (o == null) {
                File m = aj.a().m(context);
                if (m == null) {
                    TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) optDir == null");
                    return false;
                }
                File file = new File(TbsShareManager.c(context), "tbs_sdk_extension_dex.jar");
                if (file.exists()) {
                    o = new DexClassLoader(file.getAbsolutePath(), m.getAbsolutePath(), file.getAbsolutePath(), QbSdk.class.getClassLoader()).loadClass("com.tencent.tbs.sdk.extension.TbsSDKExtension");
                } else {
                    TbsLog.e("QbSdk", "QbSdk canLoadX5FirstTimeThirdApp (false) dexFile.exists()=false", true);
                    return false;
                }
            }
            if (p == null) {
                Context e = TbsShareManager.e(context);
                if (e == null && TbsShareManager.getHostCorePathAppDefined() == null) {
                    TbsLogReport.a(context.getApplicationContext()).b(ErrorCode.HOST_CONTEXT_IS_NULL, "host context is null!");
                    return false;
                }
                p = e == null ? o.getConstructor(new Class[]{Context.class, Context.class, String.class}).newInstance(new Object[]{context, e, TbsShareManager.getHostCorePathAppDefined()}) : o.getConstructor(new Class[]{Context.class, Context.class}).newInstance(new Object[]{context, e});
            }
            Object a = v.a(p, "canLoadX5CoreForThirdApp", new Class[0], new Object[0]);
            return (a == null || !(a instanceof Boolean)) ? false : ((Boolean) a).booleanValue();
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("canLoadX5FirstTimeThirdApp sys WebView: ");
            stringBuilder.append(Log.getStackTraceString(th));
            TbsLog.e("QbSdk", stringBuilder.toString());
            return false;
        }
    }

    public static void canOpenFile(Context context, String str, ValueCallback<Boolean> valueCallback) {
        new d(context, str, valueCallback).start();
    }

    public static boolean canOpenMimeFileType(Context context, String str) {
        return !a(context, false) ? false : false;
    }

    public static boolean canOpenWebPlus(android.content.Context r8) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = u;
        if (r0 != 0) goto L_0x000a;
    L_0x0004:
        r0 = com.tencent.smtt.sdk.a.a();
        u = r0;
    L_0x000a:
        r0 = "QbSdk";
        r1 = new java.lang.StringBuilder;
        r2 = "canOpenWebPlus - totalRAM: ";
        r1.<init>(r2);
        r2 = u;
        r1.append(r2);
        r1 = r1.toString();
        com.tencent.smtt.utils.TbsLog.i(r0, r1);
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 7;
        r2 = 0;
        if (r0 < r1) goto L_0x013a;
    L_0x0025:
        r0 = u;
        r1 = v;
        if (r0 >= r1) goto L_0x002c;
    L_0x002b:
        return r2;
    L_0x002c:
        if (r8 != 0) goto L_0x002f;
    L_0x002e:
        return r2;
    L_0x002f:
        r0 = 0;
        r1 = new java.io.File;	 Catch:{ Throwable -> 0x0123 }
        r3 = com.tencent.smtt.sdk.aj.a();	 Catch:{ Throwable -> 0x0123 }
        r3 = r3.m(r8);	 Catch:{ Throwable -> 0x0123 }
        r4 = "tbs.conf";	 Catch:{ Throwable -> 0x0123 }
        r1.<init>(r3, r4);	 Catch:{ Throwable -> 0x0123 }
        r3 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x0123 }
        r3.<init>(r1);	 Catch:{ Throwable -> 0x0123 }
        r1 = new java.io.BufferedInputStream;	 Catch:{ Throwable -> 0x0123 }
        r1.<init>(r3);	 Catch:{ Throwable -> 0x0123 }
        r3 = new java.util.Properties;	 Catch:{ Throwable -> 0x011d, all -> 0x011b }
        r3.<init>();	 Catch:{ Throwable -> 0x011d, all -> 0x011b }
        r3.load(r1);	 Catch:{ Throwable -> 0x011d, all -> 0x011b }
        r4 = "android_sdk_max_supported";	 Catch:{ Throwable -> 0x011d, all -> 0x011b }
        r4 = r3.getProperty(r4);	 Catch:{ Throwable -> 0x011d, all -> 0x011b }
        r5 = "android_sdk_min_supported";	 Catch:{ Throwable -> 0x011d, all -> 0x011b }
        r5 = r3.getProperty(r5);	 Catch:{ Throwable -> 0x011d, all -> 0x011b }
        r4 = java.lang.Integer.parseInt(r4);	 Catch:{ Throwable -> 0x011d, all -> 0x011b }
        r5 = java.lang.Integer.parseInt(r5);	 Catch:{ Throwable -> 0x011d, all -> 0x011b }
        r6 = android.os.Build.VERSION.SDK;	 Catch:{ Throwable -> 0x011d, all -> 0x011b }
        r6 = java.lang.Integer.parseInt(r6);	 Catch:{ Throwable -> 0x011d, all -> 0x011b }
        if (r6 > r4) goto L_0x0104;	 Catch:{ Throwable -> 0x011d, all -> 0x011b }
    L_0x006d:
        if (r6 >= r5) goto L_0x0071;	 Catch:{ Throwable -> 0x011d, all -> 0x011b }
    L_0x006f:
        goto L_0x0104;	 Catch:{ Throwable -> 0x011d, all -> 0x011b }
    L_0x0071:
        r4 = "tbs_core_version";	 Catch:{ Throwable -> 0x011d, all -> 0x011b }
        r3 = r3.getProperty(r4);	 Catch:{ Throwable -> 0x011d, all -> 0x011b }
        r3 = java.lang.Integer.parseInt(r3);	 Catch:{ Throwable -> 0x011d, all -> 0x011b }
        r1.close();	 Catch:{ Exception -> 0x007e }
    L_0x007e:
        r1 = 1;
        r4 = new java.io.File;	 Catch:{ Throwable -> 0x00ed }
        r5 = com.tencent.smtt.sdk.aj.o(r8);	 Catch:{ Throwable -> 0x00ed }
        r6 = "tbs_extension.conf";	 Catch:{ Throwable -> 0x00ed }
        r4.<init>(r5, r6);	 Catch:{ Throwable -> 0x00ed }
        r5 = new java.io.FileInputStream;	 Catch:{ Throwable -> 0x00ed }
        r5.<init>(r4);	 Catch:{ Throwable -> 0x00ed }
        r0 = new java.util.Properties;	 Catch:{ Throwable -> 0x00e8, all -> 0x00e6 }
        r0.<init>();	 Catch:{ Throwable -> 0x00e8, all -> 0x00e6 }
        r0.load(r5);	 Catch:{ Throwable -> 0x00e8, all -> 0x00e6 }
        r4 = "tbs_local_version";	 Catch:{ Throwable -> 0x00e8, all -> 0x00e6 }
        r4 = r0.getProperty(r4);	 Catch:{ Throwable -> 0x00e8, all -> 0x00e6 }
        r4 = java.lang.Integer.parseInt(r4);	 Catch:{ Throwable -> 0x00e8, all -> 0x00e6 }
        r6 = "app_versioncode_for_switch";	 Catch:{ Throwable -> 0x00e8, all -> 0x00e6 }
        r6 = r0.getProperty(r6);	 Catch:{ Throwable -> 0x00e8, all -> 0x00e6 }
        r6 = java.lang.Integer.parseInt(r6);	 Catch:{ Throwable -> 0x00e8, all -> 0x00e6 }
        r7 = 88888888; // 0x54c5638 float:9.60787E-36 double:4.3916946E-316;	 Catch:{ Throwable -> 0x00e8, all -> 0x00e6 }
        if (r3 == r7) goto L_0x00e1;	 Catch:{ Throwable -> 0x00e8, all -> 0x00e6 }
    L_0x00b0:
        if (r4 != r7) goto L_0x00b3;	 Catch:{ Throwable -> 0x00e8, all -> 0x00e6 }
    L_0x00b2:
        goto L_0x00e1;	 Catch:{ Throwable -> 0x00e8, all -> 0x00e6 }
    L_0x00b3:
        if (r3 <= r4) goto L_0x00b6;	 Catch:{ Throwable -> 0x00e8, all -> 0x00e6 }
    L_0x00b5:
        goto L_0x00e1;	 Catch:{ Throwable -> 0x00e8, all -> 0x00e6 }
    L_0x00b6:
        if (r3 != r4) goto L_0x00e1;	 Catch:{ Throwable -> 0x00e8, all -> 0x00e6 }
    L_0x00b8:
        if (r6 <= 0) goto L_0x00c1;	 Catch:{ Throwable -> 0x00e8, all -> 0x00e6 }
    L_0x00ba:
        r3 = com.tencent.smtt.utils.b.b(r8);	 Catch:{ Throwable -> 0x00e8, all -> 0x00e6 }
        if (r6 == r3) goto L_0x00c1;	 Catch:{ Throwable -> 0x00e8, all -> 0x00e6 }
    L_0x00c0:
        goto L_0x00e1;	 Catch:{ Throwable -> 0x00e8, all -> 0x00e6 }
    L_0x00c1:
        r3 = "x5_disabled";	 Catch:{ Throwable -> 0x00e8, all -> 0x00e6 }
        r0 = r0.getProperty(r3);	 Catch:{ Throwable -> 0x00e8, all -> 0x00e6 }
        r0 = java.lang.Boolean.parseBoolean(r0);	 Catch:{ Throwable -> 0x00e8, all -> 0x00e6 }
        if (r0 == 0) goto L_0x00e1;	 Catch:{ Throwable -> 0x00e8, all -> 0x00e6 }
    L_0x00cd:
        r8 = r8.getApplicationContext();	 Catch:{ Throwable -> 0x00e8, all -> 0x00e6 }
        r8 = com.tencent.smtt.sdk.TbsDownloadConfig.getInstance(r8);	 Catch:{ Throwable -> 0x00e8, all -> 0x00e6 }
        r8 = r8.mPreferences;	 Catch:{ Throwable -> 0x00e8, all -> 0x00e6 }
        r0 = "switch_backupcore_enable";	 Catch:{ Throwable -> 0x00e8, all -> 0x00e6 }
        r8 = r8.getBoolean(r0, r2);	 Catch:{ Throwable -> 0x00e8, all -> 0x00e6 }
        if (r8 != 0) goto L_0x00e1;
    L_0x00df:
        r8 = r1;
        goto L_0x00e2;
    L_0x00e1:
        r8 = r2;
    L_0x00e2:
        r5.close();	 Catch:{ Exception -> 0x00fa }
        goto L_0x00fa;
    L_0x00e6:
        r8 = move-exception;
        goto L_0x00fe;
    L_0x00e8:
        r0 = r5;
        goto L_0x00ed;
    L_0x00ea:
        r8 = move-exception;
        r5 = r0;
        goto L_0x00fe;
    L_0x00ed:
        r8 = "QbSdk";	 Catch:{ all -> 0x00ea }
        r3 = "canOpenWebPlus - isX5Disabled Exception";	 Catch:{ all -> 0x00ea }
        com.tencent.smtt.utils.TbsLog.i(r8, r3);	 Catch:{ all -> 0x00ea }
        if (r0 == 0) goto L_0x00f9;
    L_0x00f6:
        r0.close();	 Catch:{ Exception -> 0x00f9 }
    L_0x00f9:
        r8 = r1;
    L_0x00fa:
        if (r8 != 0) goto L_0x00fd;
    L_0x00fc:
        return r1;
    L_0x00fd:
        return r2;
    L_0x00fe:
        if (r5 == 0) goto L_0x0103;
    L_0x0100:
        r5.close();	 Catch:{ Exception -> 0x0103 }
    L_0x0103:
        throw r8;
    L_0x0104:
        r8 = "QbSdk";	 Catch:{ Throwable -> 0x011d, all -> 0x011b }
        r0 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x011d, all -> 0x011b }
        r3 = "canOpenWebPlus - sdkVersion: ";	 Catch:{ Throwable -> 0x011d, all -> 0x011b }
        r0.<init>(r3);	 Catch:{ Throwable -> 0x011d, all -> 0x011b }
        r0.append(r6);	 Catch:{ Throwable -> 0x011d, all -> 0x011b }
        r0 = r0.toString();	 Catch:{ Throwable -> 0x011d, all -> 0x011b }
        com.tencent.smtt.utils.TbsLog.i(r8, r0);	 Catch:{ Throwable -> 0x011d, all -> 0x011b }
        r1.close();	 Catch:{ Exception -> 0x011a }
    L_0x011a:
        return r2;
    L_0x011b:
        r8 = move-exception;
        goto L_0x0134;
    L_0x011d:
        r8 = move-exception;
        r0 = r1;
        goto L_0x0124;
    L_0x0120:
        r8 = move-exception;
        r1 = r0;
        goto L_0x0134;
    L_0x0123:
        r8 = move-exception;
    L_0x0124:
        r8.printStackTrace();	 Catch:{ all -> 0x0120 }
        r8 = "QbSdk";	 Catch:{ all -> 0x0120 }
        r1 = "canOpenWebPlus - canLoadX5 Exception";	 Catch:{ all -> 0x0120 }
        com.tencent.smtt.utils.TbsLog.i(r8, r1);	 Catch:{ all -> 0x0120 }
        if (r0 == 0) goto L_0x0133;
    L_0x0130:
        r0.close();	 Catch:{ Exception -> 0x0133 }
    L_0x0133:
        return r2;
    L_0x0134:
        if (r1 == 0) goto L_0x0139;
    L_0x0136:
        r1.close();	 Catch:{ Exception -> 0x0139 }
    L_0x0139:
        throw r8;
    L_0x013a:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.QbSdk.canOpenWebPlus(android.content.Context):boolean");
    }

    public static boolean canUseVideoFeatrue(Context context, int i) {
        Object a = v.a(p, "canUseVideoFeatrue", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)});
        return (a == null || !(a instanceof Boolean)) ? false : ((Boolean) a).booleanValue();
    }

    public static void clear(Context context) {
    }

    public static void clearAllWebViewCache(android.content.Context r4, boolean r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new android.webkit.WebView;	 Catch:{ Throwable -> 0x004e }
        r0.<init>(r4);	 Catch:{ Throwable -> 0x004e }
        r1 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Throwable -> 0x004e }
        r2 = 11;	 Catch:{ Throwable -> 0x004e }
        if (r1 < r2) goto L_0x001a;	 Catch:{ Throwable -> 0x004e }
    L_0x000b:
        r1 = "searchBoxJavaBridge_";	 Catch:{ Throwable -> 0x004e }
        r0.removeJavascriptInterface(r1);	 Catch:{ Throwable -> 0x004e }
        r1 = "accessibility";	 Catch:{ Throwable -> 0x004e }
        r0.removeJavascriptInterface(r1);	 Catch:{ Throwable -> 0x004e }
        r1 = "accessibilityTraversal";	 Catch:{ Throwable -> 0x004e }
        r0.removeJavascriptInterface(r1);	 Catch:{ Throwable -> 0x004e }
    L_0x001a:
        r1 = 1;	 Catch:{ Throwable -> 0x004e }
        r0.clearCache(r1);	 Catch:{ Throwable -> 0x004e }
        if (r5 == 0) goto L_0x002a;	 Catch:{ Throwable -> 0x004e }
    L_0x0020:
        android.webkit.CookieSyncManager.createInstance(r4);	 Catch:{ Throwable -> 0x004e }
        r0 = android.webkit.CookieManager.getInstance();	 Catch:{ Throwable -> 0x004e }
        r0.removeAllCookie();	 Catch:{ Throwable -> 0x004e }
    L_0x002a:
        r0 = android.webkit.WebViewDatabase.getInstance(r4);	 Catch:{ Throwable -> 0x004e }
        r0.clearUsernamePassword();	 Catch:{ Throwable -> 0x004e }
        r0 = android.webkit.WebViewDatabase.getInstance(r4);	 Catch:{ Throwable -> 0x004e }
        r0.clearHttpAuthUsernamePassword();	 Catch:{ Throwable -> 0x004e }
        r0 = android.webkit.WebViewDatabase.getInstance(r4);	 Catch:{ Throwable -> 0x004e }
        r0.clearFormData();	 Catch:{ Throwable -> 0x004e }
        r0 = android.webkit.WebStorage.getInstance();	 Catch:{ Throwable -> 0x004e }
        r0.deleteAllData();	 Catch:{ Throwable -> 0x004e }
        r0 = android.webkit.WebIconDatabase.getInstance();	 Catch:{ Throwable -> 0x004e }
        r0.removeAllIcons();	 Catch:{ Throwable -> 0x004e }
        goto L_0x0066;
    L_0x004e:
        r0 = move-exception;
        r1 = "QbSdk";
        r2 = new java.lang.StringBuilder;
        r3 = "clearAllWebViewCache exception 1 -- ";
        r2.<init>(r3);
        r0 = android.util.Log.getStackTraceString(r0);
        r2.append(r0);
        r0 = r2.toString();
        com.tencent.smtt.utils.TbsLog.e(r1, r0);
    L_0x0066:
        r0 = new com.tencent.smtt.sdk.WebView;	 Catch:{ Throwable -> 0x0084 }
        r0.<init>(r4);	 Catch:{ Throwable -> 0x0084 }
        r0 = r0.getWebViewClientExtension();	 Catch:{ Throwable -> 0x0084 }
        if (r0 == 0) goto L_0x0084;	 Catch:{ Throwable -> 0x0084 }
    L_0x0071:
        r0 = com.tencent.smtt.sdk.bk.b();	 Catch:{ Throwable -> 0x0084 }
        if (r0 == 0) goto L_0x0084;	 Catch:{ Throwable -> 0x0084 }
    L_0x0077:
        r1 = r0.c();	 Catch:{ Throwable -> 0x0084 }
        if (r1 == 0) goto L_0x0084;	 Catch:{ Throwable -> 0x0084 }
    L_0x007d:
        r0 = r0.d();	 Catch:{ Throwable -> 0x0084 }
        r0.a(r4, r5);	 Catch:{ Throwable -> 0x0084 }
    L_0x0084:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.QbSdk.clearAllWebViewCache(android.content.Context, boolean):void");
    }

    public static void closeFileReader(Context context) {
        bk b = bk.b();
        b.a(context);
        if (b.c()) {
            b.d().o();
        }
    }

    public static boolean createMiniQBShortCut(Context context, String str, String str2, Drawable drawable) {
        if (context == null || TbsDownloader.getOverSea(context) || isMiniQBShortCutExist(context, str, str2)) {
            return false;
        }
        bk b = bk.b();
        if (b != null && b.c()) {
            Bitmap bitmap = null;
            if (drawable instanceof BitmapDrawable) {
                bitmap = ((BitmapDrawable) drawable).getBitmap();
            }
            DexLoader b2 = b.d().b();
            TbsLog.e("QbSdk", "qbsdk createMiniQBShortCut");
            Object invokeStaticMethod = b2.invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "createMiniQBShortCut", new Class[]{Context.class, String.class, String.class, Bitmap.class}, new Object[]{context, str, str2, bitmap});
            StringBuilder stringBuilder = new StringBuilder("qbsdk after createMiniQBShortCut ret: ");
            stringBuilder.append(invokeStaticMethod);
            TbsLog.e("QbSdk", stringBuilder.toString());
            if (invokeStaticMethod != null) {
                return true;
            }
        }
        return false;
    }

    public static boolean deleteMiniQBShortCut(Context context, String str, String str2) {
        if (context == null || TbsDownloader.getOverSea(context)) {
            return false;
        }
        bk b = bk.b();
        if (b != null && b.c()) {
            if (b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "deleteMiniQBShortCut", new Class[]{Context.class, String.class, String.class}, new Object[]{context, str, str2}) != null) {
                return true;
            }
        }
        return false;
    }

    public static void disAllowThirdAppDownload() {
        c = false;
    }

    public static void fileInfoDetect(Context context, String str, ValueCallback<String> valueCallback) {
        bk b = bk.b();
        if (b != null && b.c()) {
            try {
                b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "fileInfoDetect", new Class[]{Context.class, String.class, ValueCallback.class}, new Object[]{context, str, valueCallback});
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void forceSysWebView() {
        b = true;
        StringBuilder stringBuilder = new StringBuilder("SysWebViewForcedByOuter: ");
        stringBuilder.append(Log.getStackTraceString(new Throwable()));
        s = stringBuilder.toString();
        TbsLog.e("QbSdk", "sys WebView: SysWebViewForcedByOuter");
    }

    public static long getApkFileSize(Context context) {
        return context != null ? TbsDownloadConfig.getInstance(context.getApplicationContext()).mPreferences.getLong(TbsConfigKey.KEY_TBSAPKFILESIZE, 0) : 0;
    }

    public static String[] getDexLoaderFileList(Context context, Context context2, String str) {
        int i = 0;
        if (r instanceof String[]) {
            int length = r.length;
            String[] strArr = new String[length];
            while (i < length) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(str);
                stringBuilder.append(r[i]);
                strArr[i] = stringBuilder.toString();
                i++;
            }
            return strArr;
        }
        Object a = v.a(p, "getJarFiles", new Class[]{Context.class, Context.class, String.class}, new Object[]{context, context2, str});
        if (!(a instanceof String[])) {
            a = new String[]{""};
        }
        return (String[]) a;
    }

    public static boolean getDownloadWithoutWifi() {
        return B;
    }

    public static boolean getIsSysWebViewForcedByOuter() {
        return b;
    }

    public static String getMiniQBVersion(Context context) {
        bk b = bk.b();
        b.a(context);
        return (b == null || !b.c()) ? null : b.d().f();
    }

    public static String getQQBuildNumber() {
        return x;
    }

    public static boolean getTBSInstalling() {
        return C;
    }

    public static String getTID() {
        return w;
    }

    public static int getTbsVersion(Context context) {
        if (TbsShareManager.isThirdPartyApp(context)) {
            return TbsShareManager.a(context, false);
        }
        int g = aj.a().g(context);
        if (g == 0 && af.a(context).c() == 3) {
            reset(context);
        }
        return g;
    }

    public static void initBuglyAsync(boolean z) {
        i = z;
    }

    public static void initTbsSettings(Map<String, Object> map) {
        if (l == null) {
            l = map;
            return;
        }
        try {
            l.putAll(map);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initX5Environment(Context context, PreInitCallback preInitCallback) {
        if (context != null) {
            A = new h(context, preInitCallback);
            if (TbsShareManager.isThirdPartyApp(context)) {
                aj.a().b(context, true);
            }
            TbsDownloader.needDownload(context, false, false, new i(context, preInitCallback));
        }
    }

    public static boolean installLocalQbApk(Context context, String str, String str2, Bundle bundle) {
        l a = l.a(true);
        a.a(context, false, false);
        return (a == null || !a.b()) ? false : a.a().a(context, str, str2, bundle);
    }

    public static boolean intentDispatch(WebView webView, Intent intent, String str, String str2) {
        if (webView == null) {
            return false;
        }
        if (str.startsWith("mttbrowser://miniqb/ch=icon?")) {
            Context context = webView.getContext();
            int indexOf = str.indexOf("url=");
            str = indexOf > 0 ? str.substring(indexOf + 4) : null;
            HashMap hashMap = new HashMap();
            Object obj = "unknown";
            try {
                obj = context.getApplicationInfo().packageName;
            } catch (Exception e) {
                e.printStackTrace();
            }
            hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, obj);
            hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, "14004");
            if (d.a(context, "miniqb://home".equals(str) ? "qb://navicard/addCard?cardId=168&cardName=168" : str, hashMap, "QbSdk.startMiniQBToLoadUrl", null) != 0) {
                bk b = bk.b();
                if (b != null && b.c() && b.d().a(context, str, null, str2, null) == 0) {
                    return true;
                }
            }
            return false;
        }
        webView.loadUrl(str);
        return false;
    }

    public static boolean isMiniQBShortCutExist(Context context, String str, String str2) {
        if (context == null || TbsDownloader.getOverSea(context)) {
            return false;
        }
        bk b = bk.b();
        if (b != null && b.c()) {
            Object invokeStaticMethod = b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "isMiniQBShortCutExist", new Class[]{Context.class, String.class}, new Object[]{context, str});
            if (invokeStaticMethod != null) {
                Boolean valueOf = Boolean.valueOf(false);
                if (invokeStaticMethod instanceof Boolean) {
                    valueOf = (Boolean) invokeStaticMethod;
                }
                return valueOf.booleanValue();
            }
        }
        return false;
    }

    public static boolean isTbsCoreInited() {
        l a = l.a(false);
        return a != null && a.g();
    }

    public static boolean isX5DisabledSync(Context context) {
        if (af.a(context).c() == 2) {
            return false;
        }
        if (!b(context)) {
            return true;
        }
        int g = aj.a().g(context);
        Object a = v.a(p, "isX5DisabledSync", new Class[]{Integer.TYPE, Integer.TYPE}, new Object[]{Integer.valueOf(g), Integer.valueOf(43500)});
        return a != null ? ((Boolean) a).booleanValue() : true;
    }

    public static synchronized void preInit(Context context) {
        synchronized (QbSdk.class) {
            preInit(context, null);
        }
    }

    public static synchronized void preInit(Context context, PreInitCallback preInitCallback) {
        synchronized (QbSdk.class) {
            TbsLog.initIfNeed(context);
            j = a;
            if (!q) {
                Thread gVar = new g(context, new f(Looper.getMainLooper(), preInitCallback, context));
                gVar.setName("tbs_preinit");
                gVar.setPriority(10);
                gVar.start();
                q = true;
            }
        }
    }

    public static void reset(Context context) {
        reset(context, false);
    }

    public static void reset(Context context, boolean z) {
        TbsLog.e("QbSdk", "QbSdk reset!", true);
        try {
            File file;
            TbsDownloader.stopDownload();
            if (z && !TbsShareManager.isThirdPartyApp(context)) {
                int f = aj.a().f(context);
                int g = aj.a().g(context);
                if (f > 43300 && f != g) {
                    z = true;
                    TbsDownloader.b(context);
                    k.a(context.getDir("tbs", 0), false, "core_share_decouple");
                    TbsLog.i("QbSdk", "delete downloaded apk success", true);
                    aj.a.set(Integer.valueOf(0));
                    file = new File(context.getFilesDir(), TbsExtensionFunctionManager.BUGLY_SWITCH_FILE_NAME);
                    if (file.exists()) {
                        file.delete();
                    }
                    if (z) {
                        k.b(aj.a().l(context), aj.a().p(context));
                        aj.a().b(context);
                    }
                }
            }
            z = false;
            TbsDownloader.b(context);
            k.a(context.getDir("tbs", 0), false, "core_share_decouple");
            TbsLog.i("QbSdk", "delete downloaded apk success", true);
            aj.a.set(Integer.valueOf(0));
            file = new File(context.getFilesDir(), TbsExtensionFunctionManager.BUGLY_SWITCH_FILE_NAME);
            if (file.exists()) {
                file.delete();
            }
            if (z) {
                k.b(aj.a().l(context), aj.a().p(context));
                aj.a().b(context);
            }
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("QbSdk reset exception:");
            stringBuilder.append(Log.getStackTraceString(th));
            TbsLog.e("QbSdk", stringBuilder.toString());
        }
    }

    public static void resetDecoupleCore(Context context) {
        TbsLog.e("QbSdk", "QbSdk resetDecoupleCore!", true);
        try {
            k.b(aj.a().l(context));
        } catch (Throwable th) {
            StringBuilder stringBuilder = new StringBuilder("QbSdk resetDecoupleCore exception:");
            stringBuilder.append(Log.getStackTraceString(th));
            TbsLog.e("QbSdk", stringBuilder.toString());
        }
    }

    public static void setCurrentID(String str) {
        if (str != null && str.startsWith(TID_QQNumber_Prefix)) {
            str = str.substring(3);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("0000000000000000".substring(str.length()));
            stringBuilder.append(str);
            w = stringBuilder.toString();
        }
    }

    public static void setDownloadWithoutWifi(boolean z) {
        B = z;
    }

    public static void setQQBuildNumber(String str) {
        x = str;
    }

    public static void setTBSInstallingStatus(boolean z) {
        C = z;
    }

    public static void setTbsListener(TbsListener tbsListener) {
        z = tbsListener;
    }

    public static void setTbsLogClient(TbsLogClient tbsLogClient) {
        TbsLog.setTbsLogClient(tbsLogClient);
    }

    public static int startMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        TbsCoreLoadStat.getInstance().a(context, 501);
        if (context == null) {
            return -100;
        }
        bk b = bk.b();
        b.a(context);
        if (!b.c()) {
            TbsCoreLoadStat.getInstance().a(context, 502);
            return ErrorConstant.ERROR_PARAM_ILLEGAL;
        } else if (context != null && context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") && getTbsVersion(context) < 25487) {
            return ErrorConstant.ERROR_EXCEPTION;
        } else {
            int a = b.d().a(context, str, hashMap, null, valueCallback);
            if (a == 0) {
                TbsCoreLoadStat.getInstance().a(context, 503);
                return a;
            }
            TbsLogReport.a(context).b(504, String.valueOf(a));
            return a;
        }
    }

    public static boolean startQBForDoc(Context context, String str, int i, int i2, String str2, Bundle bundle) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationContext().getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i));
        return d.a(context, str, i2, str2, hashMap, bundle);
    }

    public static boolean startQBForVideo(Context context, String str, int i) {
        HashMap hashMap = new HashMap();
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_ID, context.getApplicationInfo().processName);
        hashMap.put(LOGIN_TYPE_KEY_PARTNER_CALL_POS, Integer.toString(i));
        return d.a(context, str, hashMap);
    }

    public static boolean startQBToLoadurl(android.content.Context r6, java.lang.String r7, int r8, com.tencent.smtt.sdk.WebView r9) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.util.HashMap;
        r0.<init>();
        r1 = "ChannelID";
        r2 = r6.getApplicationInfo();
        r2 = r2.processName;
        r0.put(r1, r2);
        r1 = "PosID";
        r8 = java.lang.Integer.toString(r8);
        r0.put(r1, r8);
        r8 = 0;
        if (r9 != 0) goto L_0x0063;
    L_0x001c:
        r1 = r6.getPackageManager();	 Catch:{ Exception -> 0x0063 }
        r2 = r6.getPackageName();	 Catch:{ Exception -> 0x0063 }
        r1 = r1.getPackageInfo(r2, r8);	 Catch:{ Exception -> 0x0063 }
        r1 = r1.packageName;	 Catch:{ Exception -> 0x0063 }
        r2 = "com.tencent.mm";	 Catch:{ Exception -> 0x0063 }
        if (r1 == r2) goto L_0x0032;	 Catch:{ Exception -> 0x0063 }
    L_0x002e:
        r2 = "com.tencent.mobileqq";	 Catch:{ Exception -> 0x0063 }
        if (r1 != r2) goto L_0x0063;	 Catch:{ Exception -> 0x0063 }
    L_0x0032:
        r1 = com.tencent.smtt.sdk.bk.b();	 Catch:{ Exception -> 0x0063 }
        if (r1 == 0) goto L_0x0063;	 Catch:{ Exception -> 0x0063 }
    L_0x0038:
        r2 = r1.c();	 Catch:{ Exception -> 0x0063 }
        if (r2 == 0) goto L_0x0063;	 Catch:{ Exception -> 0x0063 }
    L_0x003e:
        r1 = r1.d();	 Catch:{ Exception -> 0x0063 }
        r1 = r1.b();	 Catch:{ Exception -> 0x0063 }
        r2 = "com.tencent.smtt.webkit.WebViewList";	 Catch:{ Exception -> 0x0063 }
        r3 = "getCurrentMainWebviewJustForQQandWechat";	 Catch:{ Exception -> 0x0063 }
        r4 = new java.lang.Class[r8];	 Catch:{ Exception -> 0x0063 }
        r5 = new java.lang.Object[r8];	 Catch:{ Exception -> 0x0063 }
        r1 = r1.invokeStaticMethod(r2, r3, r4, r5);	 Catch:{ Exception -> 0x0063 }
        if (r1 == 0) goto L_0x0063;	 Catch:{ Exception -> 0x0063 }
    L_0x0054:
        r1 = (com.tencent.smtt.export.external.interfaces.IX5WebViewBase) r1;	 Catch:{ Exception -> 0x0063 }
        if (r1 == 0) goto L_0x0063;	 Catch:{ Exception -> 0x0063 }
    L_0x0058:
        r1 = r1.getView();	 Catch:{ Exception -> 0x0063 }
        r1 = r1.getParent();	 Catch:{ Exception -> 0x0063 }
        r1 = (com.tencent.smtt.sdk.WebView) r1;	 Catch:{ Exception -> 0x0063 }
        r9 = r1;
    L_0x0063:
        r1 = "QbSdk.startQBToLoadurl";
        r6 = com.tencent.smtt.sdk.a.d.a(r6, r7, r0, r1, r9);
        if (r6 != 0) goto L_0x006d;
    L_0x006b:
        r6 = 1;
        return r6;
    L_0x006d:
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.smtt.sdk.QbSdk.startQBToLoadurl(android.content.Context, java.lang.String, int, com.tencent.smtt.sdk.WebView):boolean");
    }

    public static boolean startQbOrMiniQBToLoadUrl(Context context, String str, HashMap<String, String> hashMap, ValueCallback<String> valueCallback) {
        if (context == null) {
            return false;
        }
        bk b = bk.b();
        b.a(context);
        String str2 = "QbSdk.startMiniQBToLoadUrl";
        if (hashMap != null && "5".equals(hashMap.get(LOGIN_TYPE_KEY_PARTNER_CALL_POS)) && b.c()) {
            b.d().b().invokeStaticMethod("com.tencent.tbs.tbsshell.WebCoreProxy", "getAdWebViewInfoFromX5Core", new Class[0], new Object[0]);
        }
        return d.a(context, str, hashMap, str2, null) != 0 ? b.c() && ((context == null || !context.getApplicationInfo().packageName.equals("com.nd.android.pandahome2") || getTbsVersion(context) >= 25487) && b.d().a(context, str, hashMap, null, valueCallback) == 0) : true;
    }

    public static void unForceSysWebView() {
        b = false;
        TbsLog.e("QbSdk", "sys WebView: unForceSysWebView called");
    }

    public static boolean useSoftWare() {
        if (p == null) {
            return false;
        }
        Object a = v.a(p, "useSoftWare", new Class[0], new Object[0]);
        if (a == null) {
            a = v.a(p, "useSoftWare", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(a.a())});
        }
        return a == null ? false : ((Boolean) a).booleanValue();
    }
}
