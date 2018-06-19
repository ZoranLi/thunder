package org.android.agoo.common;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.utl.ALog;

/* compiled from: Taobao */
public class Config {
    public static final String AGOO_CLEAR_TIME = "agoo_clear_time";
    public static final String AGOO_ENABLE_DAEMONSERVER = "agoo_enable_daemonserver";
    public static final String AGOO_UNREPORT_TIMES = "agoo_UnReport_times";
    public static final String KEY_DEVICE_TOKEN = "deviceId";
    public static final String PREFERENCES = "Agoo_AppStore";
    public static final String PROPERTY_AGOO_SERVICE_MODE = "agoo_service_mode";
    public static final String PROPERTY_APP_KEY = "agoo_app_key";
    public static final String PROPERTY_APP_VERSION = "app_version";
    public static final String PROPERTY_DEVICE_TOKEN = "app_device_token";
    public static final String PROPERTY_PUSH_USER_TOKEN = "app_push_user_token";
    public static final String PROPERTY_TT_ID = "app_tt_id";
    public static final String TAG = "Config";
    public static String a;
    private static String b;
    private static String c;

    public static void setAgooAppKey(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                ALog.e(TAG, "setAgooAppKey appkey null", new Object[0]);
                return;
            }
            b = str;
            context = context.getSharedPreferences(PREFERENCES, 4).edit();
            context.putString(PROPERTY_APP_KEY, str);
            context.apply();
            ALog.i(TAG, "setAgooAppKey", "appkey", str);
        } catch (Context context2) {
            ALog.e(TAG, "setAgooAppKey", context2, new Object[0]);
        }
    }

    public static String a(Context context) {
        String str = b;
        try {
            context = context.getSharedPreferences(PREFERENCES, 4).getString(PROPERTY_APP_KEY, b);
        } catch (Context context2) {
            ALog.e(TAG, "getAgooAppKey", context2, new Object[0]);
            context2 = str;
        }
        if (TextUtils.isEmpty(context2)) {
            ALog.e(TAG, "getAgooAppKey null!!", new Object[0]);
        }
        ALog.i(TAG, "getAgooAppKey", "appkey", context2);
        return context2;
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(a)) {
            return ACCSManager.getDefaultConfig(context);
        }
        return a;
    }

    public static void a(Context context, String str) {
        ALog.i(TAG, "setDeviceToken", "token", str);
        if (!TextUtils.isEmpty(str)) {
            c = str;
            try {
                context = context.getSharedPreferences(PREFERENCES, 4).edit();
                context.putString("deviceId", str);
                context.apply();
            } catch (Context context2) {
                ALog.e(TAG, "setDeviceToken", context2, new Object[0]);
            }
        }
    }

    public static String g(Context context) {
        String str = c;
        try {
            context = context.getSharedPreferences(PREFERENCES, 4).getString("deviceId", c);
        } catch (Context context2) {
            ALog.e(TAG, "getDeviceToken", context2, new Object[0]);
            context2 = str;
        }
        ALog.i(TAG, "getDeviceToken", "token", context2);
        return context2;
    }

    public static void a(android.content.Context r3, int r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = "Agoo_AppStore";	 Catch:{ Throwable -> 0x001c }
        r1 = 4;	 Catch:{ Throwable -> 0x001c }
        r3 = r3.getSharedPreferences(r0, r1);	 Catch:{ Throwable -> 0x001c }
        r0 = r3.edit();	 Catch:{ Throwable -> 0x001c }
        r1 = "agoo_UnReport_times";	 Catch:{ Throwable -> 0x001c }
        r2 = 0;	 Catch:{ Throwable -> 0x001c }
        r3 = r3.getInt(r1, r2);	 Catch:{ Throwable -> 0x001c }
        r3 = r3 + r4;	 Catch:{ Throwable -> 0x001c }
        r4 = "agoo_UnReport_times";	 Catch:{ Throwable -> 0x001c }
        r0.putInt(r4, r3);	 Catch:{ Throwable -> 0x001c }
        r0.apply();	 Catch:{ Throwable -> 0x001c }
        return;
    L_0x001c:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.common.Config.a(android.content.Context, int):void");
    }

    public static boolean c(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = 0;
        r1 = "Agoo_AppStore";	 Catch:{ Throwable -> 0x0012 }
        r2 = 4;	 Catch:{ Throwable -> 0x0012 }
        r3 = r3.getSharedPreferences(r1, r2);	 Catch:{ Throwable -> 0x0012 }
        r1 = "agoo_UnReport_times";	 Catch:{ Throwable -> 0x0012 }
        r3 = r3.getInt(r1, r0);	 Catch:{ Throwable -> 0x0012 }
        if (r3 <= 0) goto L_0x0012;
    L_0x0010:
        r3 = 1;
        r0 = r3;
    L_0x0012:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.common.Config.c(android.content.Context):boolean");
    }

    public static void d(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = "Agoo_AppStore";	 Catch:{ Throwable -> 0x0015 }
        r1 = 4;	 Catch:{ Throwable -> 0x0015 }
        r2 = r2.getSharedPreferences(r0, r1);	 Catch:{ Throwable -> 0x0015 }
        r2 = r2.edit();	 Catch:{ Throwable -> 0x0015 }
        r0 = "agoo_UnReport_times";	 Catch:{ Throwable -> 0x0015 }
        r1 = 0;	 Catch:{ Throwable -> 0x0015 }
        r2.putInt(r0, r1);	 Catch:{ Throwable -> 0x0015 }
        r2.apply();	 Catch:{ Throwable -> 0x0015 }
        return;
    L_0x0015:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.common.Config.d(android.content.Context):void");
    }

    public static int e(android.content.Context r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = 0;
        r1 = "Agoo_AppStore";	 Catch:{ Throwable -> 0x000f }
        r2 = 4;	 Catch:{ Throwable -> 0x000f }
        r3 = r3.getSharedPreferences(r1, r2);	 Catch:{ Throwable -> 0x000f }
        r1 = "agoo_UnReport_times";	 Catch:{ Throwable -> 0x000f }
        r3 = r3.getInt(r1, r0);	 Catch:{ Throwable -> 0x000f }
        goto L_0x0010;
    L_0x000f:
        r3 = r0;
    L_0x0010:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.common.Config.e(android.content.Context):int");
    }

    public static void a(android.content.Context r2, long r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = "Agoo_AppStore";	 Catch:{ Throwable -> 0x0014 }
        r1 = 4;	 Catch:{ Throwable -> 0x0014 }
        r2 = r2.getSharedPreferences(r0, r1);	 Catch:{ Throwable -> 0x0014 }
        r2 = r2.edit();	 Catch:{ Throwable -> 0x0014 }
        r0 = "agoo_clear_time";	 Catch:{ Throwable -> 0x0014 }
        r2.putLong(r0, r3);	 Catch:{ Throwable -> 0x0014 }
        r2.apply();	 Catch:{ Throwable -> 0x0014 }
        return;
    L_0x0014:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.common.Config.a(android.content.Context, long):void");
    }

    public static boolean b(android.content.Context r10, long r11) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = 0;
        r1 = "Agoo_AppStore";	 Catch:{ Throwable -> 0x004c }
        r2 = 4;	 Catch:{ Throwable -> 0x004c }
        r10 = r10.getSharedPreferences(r1, r2);	 Catch:{ Throwable -> 0x004c }
        r1 = "agoo_clear_time";	 Catch:{ Throwable -> 0x004c }
        r2 = 0;	 Catch:{ Throwable -> 0x004c }
        r4 = r10.getLong(r1, r2);	 Catch:{ Throwable -> 0x004c }
        r10 = "isClearTime";	 Catch:{ Throwable -> 0x004c }
        r1 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x004c }
        r6 = "now=";	 Catch:{ Throwable -> 0x004c }
        r1.<init>(r6);	 Catch:{ Throwable -> 0x004c }
        r1.append(r11);	 Catch:{ Throwable -> 0x004c }
        r6 = ",now - lastTime=";	 Catch:{ Throwable -> 0x004c }
        r1.append(r6);	 Catch:{ Throwable -> 0x004c }
        r6 = r11 - r4;	 Catch:{ Throwable -> 0x004c }
        r1.append(r6);	 Catch:{ Throwable -> 0x004c }
        r4 = ",istrue=";	 Catch:{ Throwable -> 0x004c }
        r1.append(r4);	 Catch:{ Throwable -> 0x004c }
        r4 = 86400000; // 0x5265c00 float:7.82218E-36 double:4.2687272E-316;	 Catch:{ Throwable -> 0x004c }
        r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));	 Catch:{ Throwable -> 0x004c }
        r9 = 1;	 Catch:{ Throwable -> 0x004c }
        if (r8 <= 0) goto L_0x0035;	 Catch:{ Throwable -> 0x004c }
    L_0x0033:
        r8 = r9;	 Catch:{ Throwable -> 0x004c }
        goto L_0x0036;	 Catch:{ Throwable -> 0x004c }
    L_0x0035:
        r8 = r0;	 Catch:{ Throwable -> 0x004c }
    L_0x0036:
        r1.append(r8);	 Catch:{ Throwable -> 0x004c }
        r1 = r1.toString();	 Catch:{ Throwable -> 0x004c }
        r8 = new java.lang.Object[r0];	 Catch:{ Throwable -> 0x004c }
        com.taobao.accs.utl.ALog.d(r10, r1, r8);	 Catch:{ Throwable -> 0x004c }
        r10 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1));
        if (r10 == 0) goto L_0x004b;
    L_0x0046:
        r10 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1));
        if (r10 <= 0) goto L_0x004b;
    L_0x004a:
        return r9;
    L_0x004b:
        return r0;
    L_0x004c:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.common.Config.b(android.content.Context, long):boolean");
    }

    public static void a(android.content.Context r2, boolean r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = "Agoo_AppStore";	 Catch:{ Throwable -> 0x0014 }
        r1 = 4;	 Catch:{ Throwable -> 0x0014 }
        r2 = r2.getSharedPreferences(r0, r1);	 Catch:{ Throwable -> 0x0014 }
        r2 = r2.edit();	 Catch:{ Throwable -> 0x0014 }
        r0 = "agoo_enable_daemonserver";	 Catch:{ Throwable -> 0x0014 }
        r2.putBoolean(r0, r3);	 Catch:{ Throwable -> 0x0014 }
        r2.apply();	 Catch:{ Throwable -> 0x0014 }
        return;
    L_0x0014:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.common.Config.a(android.content.Context, boolean):void");
    }

    public static boolean f(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = "Agoo_AppStore";	 Catch:{ Throwable -> 0x000f }
        r1 = 4;	 Catch:{ Throwable -> 0x000f }
        r2 = r2.getSharedPreferences(r0, r1);	 Catch:{ Throwable -> 0x000f }
        r0 = "agoo_enable_daemonserver";	 Catch:{ Throwable -> 0x000f }
        r1 = 1;	 Catch:{ Throwable -> 0x000f }
        r2 = r2.getBoolean(r0, r1);	 Catch:{ Throwable -> 0x000f }
        goto L_0x0010;
    L_0x000f:
        r2 = 0;
    L_0x0010:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.common.Config.f(android.content.Context):boolean");
    }

    public static java.lang.String h(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = "Agoo_AppStore";	 Catch:{ Throwable -> 0x0010 }
        r1 = 4;	 Catch:{ Throwable -> 0x0010 }
        r2 = r2.getSharedPreferences(r0, r1);	 Catch:{ Throwable -> 0x0010 }
        r0 = "app_push_user_token";	 Catch:{ Throwable -> 0x0010 }
        r1 = "";	 Catch:{ Throwable -> 0x0010 }
        r2 = r2.getString(r0, r1);	 Catch:{ Throwable -> 0x0010 }
        goto L_0x0011;
    L_0x0010:
        r2 = 0;
    L_0x0011:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.common.Config.h(android.content.Context):java.lang.String");
    }

    public static void b(android.content.Context r2, java.lang.String r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r0 = "Agoo_AppStore";	 Catch:{ Throwable -> 0x001a }
        r1 = 4;	 Catch:{ Throwable -> 0x001a }
        r2 = r2.getSharedPreferences(r0, r1);	 Catch:{ Throwable -> 0x001a }
        r2 = r2.edit();	 Catch:{ Throwable -> 0x001a }
        r0 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Throwable -> 0x001a }
        if (r0 != 0) goto L_0x0016;	 Catch:{ Throwable -> 0x001a }
    L_0x0011:
        r0 = "app_push_user_token";	 Catch:{ Throwable -> 0x001a }
        r2.putString(r0, r3);	 Catch:{ Throwable -> 0x001a }
    L_0x0016:
        r2.apply();	 Catch:{ Throwable -> 0x001a }
        return;
    L_0x001a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.android.agoo.common.Config.b(android.content.Context, java.lang.String):void");
    }
}
