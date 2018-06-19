package com.taobao.accs.utl;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager.RunningServiceInfo;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.Proxy;
import android.os.Build.VERSION;
import android.os.Process;
import android.text.TextUtils;
import anet.channel.util.HMacUtil;
import anet.channel.util.HttpConstant;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.securesignature.SecureSignatureDefine;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.client.a;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog.Level;
import java.io.File;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import org.android.spdy.SpdyProtocol;

/* compiled from: Taobao */
public class UtilityImpl {
    public static final String NET_TYPE_2G = "2g";
    public static final String NET_TYPE_3G = "3g";
    public static final String NET_TYPE_4G = "4g";
    public static final String NET_TYPE_UNKNOWN = "unknown";
    public static final String NET_TYPE_WIFI = "wifi";
    private static final String SSL_TIKET_KEY = "accs_ssl_ticket_key";
    private static final String SSL_TIKET_KEY2 = "accs_ssl_key2_";
    private static final String TAG = "UtilityImpl";
    public static final int TNET_FILE_NUM = 5;
    public static final int TNET_FILE_SIZE = 5242880;
    private static final byte[] mLock = new byte[0];

    public static boolean isAccsStatisticsOff(Context context) {
        return true;
    }

    public static boolean isChannelProcess(Context context) {
        return false;
    }

    public static String getProxyHost(Context context) {
        context = context.getSharedPreferences(Constants.SP_FILE_NAME, 4).getString(Constants.KEY_PROXY_HOST, null);
        if (!TextUtils.isEmpty(context)) {
            return context;
        }
        context = getProxyIp();
        if (TextUtils.isEmpty(context)) {
            return null;
        }
        return context;
    }

    public static int getProxyPort(android.content.Context r3) {
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
        r0 = "ACCS_SDK";
        r1 = 4;
        r0 = r3.getSharedPreferences(r0, r1);
        r1 = "proxy_port";
        r2 = -1;
        r0 = r0.getInt(r1, r2);
        if (r0 <= 0) goto L_0x0011;
    L_0x0010:
        return r0;
    L_0x0011:
        r3 = getProxyHost(r3);
        if (r3 != 0) goto L_0x0018;
    L_0x0017:
        return r2;
    L_0x0018:
        r3 = getProxyPort();	 Catch:{ NumberFormatException -> 0x001d }
        return r3;
    L_0x001d:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.utl.UtilityImpl.getProxyPort(android.content.Context):int");
    }

    public static boolean appVersionChanged(Context context) {
        synchronized (mLock) {
            int i = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getInt(Constants.KEY_APP_VERSION_CODE, -1);
            PackageInfo packageInfo = GlobalClientInfo.getInstance(context).getPackageInfo();
            if (i != (packageInfo != null ? packageInfo.versionCode : 0)) {
                saveAppVersionCode(context);
                return true;
            }
            return false;
        }
    }

    private static void saveAppVersionCode(Context context) {
        try {
            Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
            edit.putInt(Constants.KEY_APP_VERSION_CODE, GlobalClientInfo.getInstance(context).getPackageInfo().versionCode);
            edit.apply();
        } catch (Context context2) {
            ALog.e(TAG, "saveAppVersionCode", context2, new Object[0]);
        }
    }

    public static void focusDisableService(Context context) {
        try {
            synchronized (mLock) {
                Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                edit.putBoolean(Constants.KEY_FOUCE_DISABLE, true);
                edit.commit();
                disableService(context);
            }
        } catch (Context context2) {
            ALog.e(TAG, "focusDisableService", context2, new Object[0]);
        }
    }

    public static void focusEnableService(Context context) {
        try {
            synchronized (mLock) {
                Editor edit = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                edit.putBoolean(Constants.KEY_FOUCE_DISABLE, false);
                edit.commit();
                enableService(context);
            }
        } catch (Context context2) {
            ALog.e(TAG, "focusEnableService", context2, new Object[0]);
        }
    }

    public static boolean getFocusDisableStatus(Context context) {
        Throwable th;
        Throwable e;
        if (context == null) {
            return false;
        }
        try {
            synchronized (mLock) {
                try {
                    context = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getBoolean(Constants.KEY_FOUCE_DISABLE, false);
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            }
        } catch (Exception e2) {
            e = e2;
            context = null;
            ALog.e(TAG, "getFocusDisableStatus", e, new Object[0]);
            return context;
        }
    }

    public static boolean getServiceEnabled(Context context) {
        try {
            if (context.getPackageManager().getServiceInfo(new ComponentName(context, a.channelService), 128).enabled != null) {
                return true;
            }
        } catch (Context context2) {
            context2.printStackTrace();
            ALog.e(TAG, getStackMsg(context2), new Object[0]);
        }
        return false;
    }

    public static boolean getAgooServiceEnabled(android.content.Context r4) {
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
        r0 = new android.content.ComponentName;
        r1 = r4.getPackageName();
        r1 = com.taobao.accs.client.a.a(r1);
        r0.<init>(r4, r1);
        r4 = r4.getPackageManager();
        r1 = 0;
        r2 = r0.getPackageName();	 Catch:{ Exception -> 0x0044 }
        r3 = "!";	 Catch:{ Exception -> 0x0044 }
        r2 = r2.equals(r3);	 Catch:{ Exception -> 0x0044 }
        if (r2 == 0) goto L_0x0038;	 Catch:{ Exception -> 0x0044 }
    L_0x001e:
        r4 = "UtilityImpl";	 Catch:{ Exception -> 0x0044 }
        r2 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x0044 }
        r3 = "getAgooServiceEnabled,exception,comptName.getPackageName()=";	 Catch:{ Exception -> 0x0044 }
        r2.<init>(r3);	 Catch:{ Exception -> 0x0044 }
        r0 = r0.getPackageName();	 Catch:{ Exception -> 0x0044 }
        r2.append(r0);	 Catch:{ Exception -> 0x0044 }
        r0 = r2.toString();	 Catch:{ Exception -> 0x0044 }
        r2 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x0044 }
        com.taobao.accs.utl.ALog.e(r4, r0, r2);	 Catch:{ Exception -> 0x0044 }
        return r1;	 Catch:{ Exception -> 0x0044 }
    L_0x0038:
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ Exception -> 0x0044 }
        r4 = r4.getServiceInfo(r0, r2);	 Catch:{ Exception -> 0x0044 }
        r4 = r4.enabled;	 Catch:{ Exception -> 0x0044 }
        if (r4 == 0) goto L_0x0044;
    L_0x0042:
        r4 = 1;
        return r4;
    L_0x0044:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.utl.UtilityImpl.getAgooServiceEnabled(android.content.Context):boolean");
    }

    public static void enableService(android.content.Context r4) {
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
        r0 = new android.content.ComponentName;
        r1 = "com.taobao.accs.ChannelService";
        r0.<init>(r4, r1);
        r1 = "UtilityImpl";
        r2 = new java.lang.StringBuilder;
        r3 = "enableService,comptName=";
        r2.<init>(r3);
        r3 = r0.toString();
        r2.append(r3);
        r2 = r2.toString();
        r3 = 0;
        r3 = new java.lang.Object[r3];
        com.taobao.accs.utl.ALog.d(r1, r2, r3);
        r4 = r4.getPackageManager();
        r1 = 1;
        r4.setComponentEnabledSetting(r0, r1, r1);	 Catch:{ Exception -> 0x002a }
        return;
    L_0x002a:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.utl.UtilityImpl.enableService(android.content.Context):void");
    }

    public static void disableService(android.content.Context r5) {
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
        r0 = new android.content.ComponentName;
        r1 = "com.taobao.accs.ChannelService";
        r0.<init>(r5, r1);
        r1 = r5.getPackageManager();
        r2 = "UtilityImpl";	 Catch:{ NameNotFoundException -> 0x0038 }
        r3 = new java.lang.StringBuilder;	 Catch:{ NameNotFoundException -> 0x0038 }
        r4 = "disableService,comptName=";	 Catch:{ NameNotFoundException -> 0x0038 }
        r3.<init>(r4);	 Catch:{ NameNotFoundException -> 0x0038 }
        r4 = r0.toString();	 Catch:{ NameNotFoundException -> 0x0038 }
        r3.append(r4);	 Catch:{ NameNotFoundException -> 0x0038 }
        r3 = r3.toString();	 Catch:{ NameNotFoundException -> 0x0038 }
        r4 = 0;	 Catch:{ NameNotFoundException -> 0x0038 }
        r4 = new java.lang.Object[r4];	 Catch:{ NameNotFoundException -> 0x0038 }
        com.taobao.accs.utl.ALog.d(r2, r3, r4);	 Catch:{ NameNotFoundException -> 0x0038 }
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ NameNotFoundException -> 0x0038 }
        r2 = r1.getServiceInfo(r0, r2);	 Catch:{ NameNotFoundException -> 0x0038 }
        r2 = r2.enabled;	 Catch:{ NameNotFoundException -> 0x0038 }
        if (r2 == 0) goto L_0x0037;	 Catch:{ NameNotFoundException -> 0x0038 }
    L_0x002f:
        r2 = 2;	 Catch:{ NameNotFoundException -> 0x0038 }
        r3 = 1;	 Catch:{ NameNotFoundException -> 0x0038 }
        r1.setComponentEnabledSetting(r0, r2, r3);	 Catch:{ NameNotFoundException -> 0x0038 }
        killService(r5);	 Catch:{ NameNotFoundException -> 0x0038 }
    L_0x0037:
        return;
    L_0x0038:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.utl.UtilityImpl.disableService(android.content.Context):void");
    }

    public static void killService(Context context) {
        try {
            int myUid = Process.myUid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                for (RunningAppProcessInfo runningAppProcessInfo : activityManager.getRunningAppProcesses()) {
                    if (runningAppProcessInfo.uid == myUid) {
                        StringBuilder stringBuilder;
                        if (!TextUtils.isEmpty(a.e) && a.e.equals(runningAppProcessInfo.processName)) {
                            context = TAG;
                            stringBuilder = new StringBuilder("kill1 ");
                            stringBuilder.append(runningAppProcessInfo.processName);
                            ALog.e(context, stringBuilder.toString(), new Object[0]);
                            Process.killProcess(runningAppProcessInfo.pid);
                            return;
                        } else if (runningAppProcessInfo.processName.endsWith(":channel")) {
                            context = TAG;
                            stringBuilder = new StringBuilder("kill ");
                            stringBuilder.append(runningAppProcessInfo.processName);
                            ALog.e(context, stringBuilder.toString(), new Object[0]);
                            Process.killProcess(runningAppProcessInfo.pid);
                            return;
                        }
                    }
                }
                ALog.e(TAG, "kill nothing", new Object[0]);
            }
        } catch (Context context2) {
            ALog.e(TAG, "killService", context2, new Object[0]);
        }
    }

    public static String getNetworkType(Context context) {
        context = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (context == null) {
            return "unknown";
        }
        if (context.getType() == 1) {
            return "wifi";
        }
        context = context.getSubtypeName();
        String str = "";
        if (!TextUtils.isEmpty(context)) {
            str = context.replaceAll(" ", "");
        }
        return str;
    }

    public static String getNetworkTypeExt(Context context) {
        try {
            context = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (context == null) {
                return "unknown";
            }
            if (context.getType() == 1) {
                return "wifi";
            }
            switch (context.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return NET_TYPE_2G;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return NET_TYPE_3G;
                case 13:
                    return NET_TYPE_4G;
                default:
                    context = context.getSubtypeName();
                    if (TextUtils.isEmpty(context)) {
                        return "unknown";
                    }
                    if (!(context.equalsIgnoreCase("td-scdma") || context.equalsIgnoreCase("td_scdma"))) {
                        if (context.equalsIgnoreCase("tds_hsdpa") == null) {
                            return "unknown";
                        }
                    }
                    return NET_TYPE_3G;
            }
            ALog.e(TAG, "getNetworkTypeExt", context, new Object[0]);
            return null;
        } catch (Context context2) {
            ALog.e(TAG, "getNetworkTypeExt", context2, new Object[0]);
            return null;
        }
    }

    public static java.lang.String getImsi(android.content.Context r1) {
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
        r0 = "phone";	 Catch:{ Throwable -> 0x000d }
        r1 = r1.getSystemService(r0);	 Catch:{ Throwable -> 0x000d }
        r1 = (android.telephony.TelephonyManager) r1;	 Catch:{ Throwable -> 0x000d }
        r1 = r1.getSubscriberId();	 Catch:{ Throwable -> 0x000d }
        return r1;
    L_0x000d:
        r1 = 0;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.utl.UtilityImpl.getImsi(android.content.Context):java.lang.String");
    }

    public static long String2Time(java.lang.String r3) {
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
        r0 = new java.text.SimpleDateFormat;	 Catch:{ Throwable -> 0x0012 }
        r1 = "yyyy-MM-dd HH:mm:ss:SSS";	 Catch:{ Throwable -> 0x0012 }
        r2 = java.util.Locale.US;	 Catch:{ Throwable -> 0x0012 }
        r0.<init>(r1, r2);	 Catch:{ Throwable -> 0x0012 }
        r3 = r0.parse(r3);	 Catch:{ Throwable -> 0x0012 }
        r0 = r3.getTime();	 Catch:{ Throwable -> 0x0012 }
        return r0;
    L_0x0012:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.utl.UtilityImpl.String2Time(java.lang.String):long");
    }

    public static String formatTime(long j) {
        String str = "";
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.US).format(new Date(j));
        } catch (long j2) {
            ALog.e(TAG, "formatTime", j2, new Object[0]);
            return str;
        }
    }

    public static String formatDay(long j) {
        String str = "";
        try {
            return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(Long.valueOf(j));
        } catch (long j2) {
            ALog.e(TAG, "formatDay", j2, new Object[0]);
            return str;
        }
    }

    public static boolean isForeground(Context context) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Object packageName = ((RunningTaskInfo) GlobalClientInfo.getInstance(context).getActivityManager().getRunningTasks(1).get(0)).topActivity.getPackageName();
            if (!TextUtils.isEmpty(packageName) && packageName.equals(context.getPackageName()) != null) {
                return true;
            }
            if (ALog.isPrintLog(Level.D) != null) {
                context = TAG;
                StringBuilder stringBuilder = new StringBuilder("isForeground time ");
                stringBuilder.append(System.currentTimeMillis() - currentTimeMillis);
                ALog.d(context, stringBuilder.toString(), new Object[0]);
            }
            return false;
        } catch (Context context2) {
            ALog.e(TAG, "isForeground error ", context2, new Object[0]);
        }
    }

    private static boolean isSecurityOff(String str) {
        str = AccsClientConfig.getConfigByTag(str);
        if (str == null) {
            str = null;
        } else {
            str = str.getSecurity();
        }
        if (str == 2) {
            return true;
        }
        return false;
    }

    public static String getAppsign(Context context, String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            ALog.e(TAG, "getAppsign appkey null", new Object[0]);
            return null;
        }
        try {
            if (!isSecurityOff(str4)) {
                context = SecurityGuardManager.getInstance(context);
                if (context != null) {
                    ALog.d(TAG, "SecurityGuardManager not null!", new Object[0]);
                    context = context.getSecureSignatureComp();
                    str2 = new SecurityGuardParamContext();
                    str2.appKey = str;
                    Map map = str2.paramMap;
                    String str5 = SecureSignatureDefine.OPEN_KEY_SIGN_INPUT;
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(str3);
                    stringBuilder.append(str);
                    map.put(str5, stringBuilder.toString());
                    str2.requestType = 3;
                    str = AccsClientConfig.getConfigByTag(str4);
                    context = context.signRequest(str2, str != null ? str.getAuthCode() : null);
                    return context;
                }
                ALog.d(TAG, "SecurityGuardManager is null", new Object[0]);
                context = null;
                return context;
            } else if (TextUtils.isEmpty(str2) == null) {
                context = str2.getBytes();
                str2 = new StringBuilder();
                str2.append(str);
                str2.append(str3);
                context = HMacUtil.hmacSha1Hex(context, str2.toString().getBytes());
                return context;
            } else {
                ALog.e(TAG, "getAppsign secret null", new Object[0]);
                context = null;
                return context;
            }
        } catch (Context context2) {
            ALog.e(TAG, "getAppsign", context2, new Object[0]);
        }
    }

    public static byte[] staticBinarySafeDecryptNoB64(Context context, String str, String str2, byte[] bArr) {
        byte[] bArr2 = null;
        if (isSecurityOff(str)) {
            return null;
        }
        if (context != null) {
            if (bArr != null) {
                try {
                    str = AccsClientConfig.getConfigByTag(str);
                    ALog.i(TAG, "staticBinarySafeDecryptNoB64", "appkey", str2, "authcode", str != null ? str.getAuthCode() : null);
                    context = SecurityGuardManager.getInstance(context);
                    if (context != null) {
                        context = context.getStaticDataEncryptComp();
                        if (context != null) {
                            bArr2 = context.staticBinarySafeDecryptNoB64(16, SpdyProtocol.TNET_PUBKEY_SG_KEY, bArr, str);
                        }
                    }
                    if (bArr2 == null) {
                        ALog.e(TAG, "staticBinarySafeDecryptNoB64 null", new Object[0]);
                    }
                } catch (Context context2) {
                    ALog.e(TAG, "staticBinarySafeDecryptNoB64", context2, new Object[0]);
                }
                return bArr2;
            }
        }
        ALog.e(TAG, "staticBinarySafeDecryptNoB64 input null!", new Object[0]);
        return null;
    }

    public static int SecurityGuardPutSslTicket2(Context context, String str, String str2, String str3, byte[] bArr) {
        int i = -1;
        if (TextUtils.isEmpty(str2) == null && TextUtils.isEmpty(str3) == null && context != null) {
            if (bArr != null) {
                try {
                    if (isSecurityOff(str) != null) {
                        return -1;
                    }
                    context = SecurityGuardManager.getInstance(context);
                    if (context != null) {
                        context = context.getDynamicDataStoreComp();
                        if (context != null) {
                            str = new StringBuilder(SSL_TIKET_KEY2);
                            str.append(str3);
                            i = context.putByteArray(str.toString(), bArr);
                        }
                    }
                    return i;
                } catch (Context context2) {
                    ALog.e(TAG, "SecurityGuardPutSslTicket2", context2, new Object[null]);
                }
            }
        }
        return -1;
    }

    public static byte[] SecurityGuardGetSslTicket2(Context context, String str, String str2, String str3) {
        byte[] bArr = null;
        if (!(context == null || TextUtils.isEmpty(str3))) {
            if (TextUtils.isEmpty(str2) == null) {
                try {
                    if (isSecurityOff(str) != null) {
                        return null;
                    }
                    context = SecurityGuardManager.getInstance(context);
                    if (context != null) {
                        context = context.getDynamicDataStoreComp();
                        if (context != null) {
                            str = new StringBuilder(SSL_TIKET_KEY2);
                            str.append(str3);
                            bArr = context.getByteArray(str.toString());
                        }
                    }
                    return bArr;
                } catch (Context context2) {
                    ALog.e(TAG, "SecurityGuardGetSslTicket2", context2, new Object[0]);
                }
            }
        }
        ALog.i(TAG, "get sslticket input null", new Object[0]);
        return null;
    }

    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            try {
                context = GlobalClientInfo.getInstance(context).getConnectivityManager().getActiveNetworkInfo();
                if (context != null) {
                    return context.isConnected();
                }
            } catch (Context context2) {
                context2.printStackTrace();
            }
        }
        return true;
    }

    public static String getDeviceId(Context context) {
        return a.b(context);
    }

    public static boolean isServiceRunning(Context context, String str) {
        if (str != null) {
            if (str.length() != 0) {
                for (RunningServiceInfo runningServiceInfo : ((ActivityManager) context.getSystemService("activity")).getRunningServices(30)) {
                    if (runningServiceInfo.service.getPackageName().equals(str) && runningServiceInfo.service.getClassName().equals(a.channelService)) {
                        return true;
                    }
                }
                return false;
            }
        }
        return false;
    }

    public static boolean isFirstStart(Context context) {
        boolean z;
        synchronized (mLock) {
            z = false;
            if (context.getSharedPreferences(Constants.SP_FILE_NAME, 0).getInt("version", -1) != 221) {
                z = true;
            }
        }
        return z;
    }

    public static void setSdkStart(Context context) {
        try {
            synchronized (mLock) {
                context = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                context.putInt("version", 221);
                context.apply();
            }
            ALog.i(TAG, "setSdkStart", new Object[0]);
        } catch (Context context2) {
            ALog.e(TAG, "setSdkStart", context2, new Object[0]);
        }
    }

    public static boolean packageExist(android.content.Context r5, java.lang.String r6) {
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
        r0 = 1;
        r1 = 0;
        r5 = r5.getPackageManager();	 Catch:{ NameNotFoundException -> 0x000a }
        r5.getPackageInfo(r6, r1);	 Catch:{ NameNotFoundException -> 0x000a }
        return r0;
    L_0x000a:
        r5 = "UtilityImpl";
        r2 = "package not exist";
        r3 = 2;
        r3 = new java.lang.Object[r3];
        r4 = "pkg";
        r3[r1] = r4;
        r3[r0] = r6;
        com.taobao.accs.utl.ALog.e(r5, r2, r3);
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.utl.UtilityImpl.packageExist(android.content.Context, java.lang.String):boolean");
    }

    public static boolean utdidChanged(String str, Context context) {
        try {
            synchronized (mLock) {
                try {
                    String deviceId = getDeviceId(context);
                    str = context.getSharedPreferences(str, 0).getString("utdid", deviceId).equals(deviceId) ^ 1;
                } catch (Throwable th) {
                    context = th;
                    throw context;
                }
            }
        } catch (Throwable th2) {
            context = th2;
            str = null;
            ALog.e(TAG, "saveUtdid", context, new Object[0]);
            return str;
        }
    }

    public static void saveUtdid(String str, Context context) {
        try {
            synchronized (mLock) {
                str = context.getSharedPreferences(str, 0).edit();
                str.putString("utdid", getDeviceId(context));
                str.apply();
            }
        } catch (String str2) {
            ALog.e(TAG, "saveUtdid", str2, new Object[0]);
        }
    }

    public static boolean channelServiceExist(android.content.Context r3, java.lang.String r4) {
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
        r3 = r3.getPackageManager();	 Catch:{ Exception -> 0x0015 }
        r1 = new android.content.ComponentName;	 Catch:{ Exception -> 0x0015 }
        r2 = "com.taobao.accs.ChannelService";	 Catch:{ Exception -> 0x0015 }
        r1.<init>(r4, r2);	 Catch:{ Exception -> 0x0015 }
        r3 = r3.getServiceInfo(r1, r0);	 Catch:{ Exception -> 0x0015 }
        r3 = r3.isEnabled();	 Catch:{ Exception -> 0x0015 }
        return r3;
    L_0x0015:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.utl.UtilityImpl.channelServiceExist(android.content.Context, java.lang.String):boolean");
    }

    public static String getOperator(Context context) {
        context = getImsi(context);
        String str = "null";
        return (context == null || context.length() <= 5) ? str : context.substring(0, 5);
    }

    public static void setServiceTime(Context context, String str, long j) {
        try {
            context = context.getSharedPreferences(Constants.SP_CHANNEL_FILE_NAME, 0).edit();
            context.putLong(str, j);
            context.commit();
            context = TAG;
            str = new StringBuilder("setServiceTime:");
            str.append(j);
            ALog.d(context, str.toString(), new Object[0]);
        } catch (Context context2) {
            ALog.e(TAG, "setServiceTime:", context2, new Object[0]);
        }
    }

    public static long getServiceAliveTime(Context context) {
        long j;
        try {
            context = context.getSharedPreferences(Constants.SP_CHANNEL_FILE_NAME, 0);
            long j2 = context.getLong(Constants.SP_KEY_SERVICE_START, 0);
            j = j2 > 0 ? context.getLong(Constants.SP_KEY_SERVICE_END, 0) - j2 : 0;
            try {
                context = context.edit();
                context.putLong(Constants.SP_KEY_SERVICE_START, 0);
                context.putLong(Constants.SP_KEY_SERVICE_END, 0);
                context.commit();
            } catch (Throwable th) {
                context = th;
                ALog.e(TAG, "getServiceAliveTime:", context, new Object[0]);
                return j;
            }
        } catch (Throwable th2) {
            context = th2;
            j = 0;
            ALog.e(TAG, "getServiceAliveTime:", context, new Object[0]);
            return j;
        }
        return j;
    }

    public static int praseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        }
    }

    public static String getAppVersion(Context context) {
        String str = "";
        try {
            return GlobalClientInfo.getInstance(context).getPackageInfo().versionName;
        } catch (Context context2) {
            context2.printStackTrace();
            return str;
        }
    }

    public static String getProcessName(Context context, int i) {
        return a.a(context, i);
    }

    public static boolean isMainProcess(Context context) {
        return a.a(context);
    }

    public static int getByteLen(String str) {
        if (str == null) {
            return 0;
        }
        try {
            str = str.getBytes("utf-8").length;
        } catch (String str2) {
            str2.printStackTrace();
            str2 = null;
        }
        return str2;
    }

    public static String getStackMsg(Throwable th) {
        return a.a(th);
    }

    public static File getExternalFilesDir(Context context) {
        return context.getExternalFilesDir(null);
    }

    public static File getCacheFilesDir(Context context) {
        return context.getExternalCacheDir();
    }

    public static void storeCookie(Context context, String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                GlobalClientInfo.c = str;
                context = context.getSharedPreferences(Constants.SP_COOKIE_FILE_NAME, 0).edit();
                context.putString(Constants.SP_KEY_COOKIE_SEC, str);
                context.apply();
            }
        } catch (Context context2) {
            ALog.e(TAG, "storeCookie fail", context2, new Object[0]);
        }
    }

    public static String restoreCookie(Context context) {
        try {
            return context.getSharedPreferences(Constants.SP_COOKIE_FILE_NAME, 4).getString(Constants.SP_KEY_COOKIE_SEC, null);
        } catch (Context context2) {
            ALog.e(TAG, "reStoreCookie fail", context2, new Object[0]);
            return null;
        }
    }

    public static void clearCookie(Context context) {
        try {
            GlobalClientInfo.c = null;
            context = context.getSharedPreferences(Constants.SP_COOKIE_FILE_NAME, 0).edit();
            context.clear();
            context.apply();
        } catch (Context context2) {
            ALog.e(TAG, "clearCookie fail", context2, new Object[0]);
        }
    }

    public static long getUsableSpace() {
        return a.a();
    }

    public static String convertHost(String str) {
        String str2 = null;
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            StringBuilder stringBuilder;
            if (str.startsWith("//")) {
                stringBuilder = new StringBuilder("https:");
                stringBuilder.append(str);
                return stringBuilder.toString();
            }
            int indexOf = str.indexOf(HttpConstant.SCHEME_SPLIT);
            if (indexOf == -1) {
                stringBuilder = new StringBuilder("https://");
                stringBuilder.append(str);
                return stringBuilder.toString();
            }
            str = str.substring(indexOf + 3);
            if (!TextUtils.isEmpty(str)) {
                stringBuilder = new StringBuilder("https://");
                stringBuilder.append(str);
                str2 = stringBuilder.toString();
            }
            return str2;
        } catch (String str3) {
            ALog.e(TAG, "convertHost", str3, new Object[0]);
        }
    }

    public static String getProxyIp() {
        if (VERSION.SDK_INT < 11) {
            return Proxy.getDefaultHost();
        }
        return System.getProperty("http.proxyHost");
    }

    public static int getProxyPort() {
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
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 11;
        if (r0 >= r1) goto L_0x000b;
    L_0x0006:
        r0 = android.net.Proxy.getDefaultPort();
        return r0;
    L_0x000b:
        r0 = "http.proxyPort";	 Catch:{ NumberFormatException -> 0x0016 }
        r0 = java.lang.System.getProperty(r0);	 Catch:{ NumberFormatException -> 0x0016 }
        r0 = java.lang.Integer.parseInt(r0);	 Catch:{ NumberFormatException -> 0x0016 }
        return r0;
    L_0x0016:
        r0 = -1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.utl.UtilityImpl.getProxyPort():int");
    }

    public static String getProxy() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getProxyIp());
        stringBuilder.append(com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
        stringBuilder.append(getProxyPort());
        String stringBuilder2 = stringBuilder.toString();
        if (ALog.isPrintLog(Level.D)) {
            String str = TAG;
            StringBuilder stringBuilder3 = new StringBuilder("getProxy:");
            stringBuilder3.append(stringBuilder2);
            ALog.d(str, stringBuilder3.toString(), new Object[0]);
        }
        return stringBuilder2;
    }

    public static String isNotificationEnabled(Context context) {
        return a.d(context);
    }

    public static String getTnetLogFilePath(Context context, String str) {
        try {
            Object externalFilesDir = context.getExternalFilesDir("tnetlogs");
            if (!(externalFilesDir != null && externalFilesDir.exists() && externalFilesDir.canWrite())) {
                externalFilesDir = context.getDir("logs", 0);
            }
            context = TAG;
            StringBuilder stringBuilder = new StringBuilder("getTnetLogFilePath :");
            stringBuilder.append(externalFilesDir);
            ALog.d(context, stringBuilder.toString(), new Object[0]);
            context = new StringBuilder();
            context.append(externalFilesDir);
            context.append("/");
            context.append(str.toLowerCase());
            return context.toString();
        } catch (Context context2) {
            ALog.e(TAG, "getTnetLogFilePath", context2, new Object[0]);
            return null;
        }
    }

    public static String int2String(int i) {
        try {
            return String.valueOf(i);
        } catch (int i2) {
            ALog.e(TAG, "int2String", i2, new Object[0]);
            return 0;
        }
    }

    public static int String2Int(String str) {
        try {
            return Integer.valueOf(str).intValue();
        } catch (String str2) {
            ALog.e(TAG, "String2Int", str2, new Object[0]);
            return null;
        }
    }

    public static String[] getAppkey(Context context) {
        synchronized (mLock) {
            context = ACCSManager.getAppkey(context);
        }
        return context;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void saveAppKey(android.content.Context r2, java.lang.String r3, java.lang.String r4) {
        /*
        r4 = mLock;	 Catch:{ Throwable -> 0x004f }
        monitor-enter(r4);	 Catch:{ Throwable -> 0x004f }
        r0 = "ACCS_SDK";
        r1 = 0;
        r2 = r2.getSharedPreferences(r0, r1);	 Catch:{ all -> 0x004c }
        r0 = "appkey";
        r1 = "";
        r0 = r2.getString(r0, r1);	 Catch:{ all -> 0x004c }
        r1 = android.text.TextUtils.isEmpty(r3);	 Catch:{ all -> 0x004c }
        if (r1 != 0) goto L_0x004a;
    L_0x0018:
        r1 = r0.equals(r3);	 Catch:{ all -> 0x004c }
        if (r1 != 0) goto L_0x004a;
    L_0x001e:
        r1 = r0.contains(r3);	 Catch:{ all -> 0x004c }
        if (r1 == 0) goto L_0x0025;
    L_0x0024:
        goto L_0x004a;
    L_0x0025:
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ all -> 0x004c }
        if (r1 != 0) goto L_0x003c;
    L_0x002b:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x004c }
        r1.<init>(r0);	 Catch:{ all -> 0x004c }
        r0 = "|";
        r1.append(r0);	 Catch:{ all -> 0x004c }
        r1.append(r3);	 Catch:{ all -> 0x004c }
        r3 = r1.toString();	 Catch:{ all -> 0x004c }
    L_0x003c:
        r2 = r2.edit();	 Catch:{ all -> 0x004c }
        r0 = "appkey";
        r2.putString(r0, r3);	 Catch:{ all -> 0x004c }
        r2.commit();	 Catch:{ all -> 0x004c }
        monitor-exit(r4);	 Catch:{ all -> 0x004c }
        return;
    L_0x004a:
        monitor-exit(r4);	 Catch:{ all -> 0x004c }
        return;
    L_0x004c:
        r2 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x004c }
        throw r2;	 Catch:{ Throwable -> 0x004f }
    L_0x004f:
        r2 = move-exception;
        r2.printStackTrace();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.utl.UtilityImpl.saveAppKey(android.content.Context, java.lang.String, java.lang.String):void");
    }

    public static void clearSharePreferences(Context context) {
        try {
            synchronized (mLock) {
                SharedPreferences sharedPreferences = context.getSharedPreferences(Constants.SP_FILE_NAME, 0);
                Object string = sharedPreferences.getString("appkey", null);
                Object string2 = sharedPreferences.getString("app_sercet", null);
                Object string3 = sharedPreferences.getString(Constants.KEY_PROXY_HOST, null);
                int i = sharedPreferences.getInt(Constants.KEY_PROXY_PORT, -1);
                int i2 = sharedPreferences.getInt("version", -1);
                int i3 = sharedPreferences.getInt(Constants.SP_KEY_DEBUG_MODE, 0);
                context = context.getSharedPreferences(Constants.SP_FILE_NAME, 0).edit();
                context.clear();
                if (!TextUtils.isEmpty(string)) {
                    context.putString("appkey", string);
                }
                if (!TextUtils.isEmpty(string2)) {
                    context.putString("app_sercet", string2);
                }
                if (!TextUtils.isEmpty(string3)) {
                    context.putString(Constants.KEY_PROXY_HOST, string3);
                }
                if (i > 0) {
                    context.putInt(Constants.KEY_PROXY_PORT, i);
                }
                if (i2 > 0) {
                    context.putInt("version", i2);
                }
                if (i3 == 2 || i3 == 1) {
                    context.putInt(Constants.SP_KEY_DEBUG_MODE, i3);
                }
                context.commit();
            }
        } catch (Context context2) {
            ALog.e(TAG, "clearSharePreferences", context2, new Object[0]);
        }
    }

    public static String encodeQueryParams(Map<String, String> map) {
        if (map != null) {
            if (!map.isEmpty()) {
                StringBuilder stringBuilder = new StringBuilder(64);
                try {
                    map = map.entrySet().iterator();
                    while (map.hasNext()) {
                        Entry entry = (Entry) map.next();
                        if (entry.getKey() != null) {
                            stringBuilder.append(URLEncoder.encode((String) entry.getKey(), "UTF-8"));
                            stringBuilder.append("=");
                            stringBuilder.append(URLEncoder.encode(entry.getValue() == null ? "" : (String) entry.getValue(), "UTF-8"));
                            stringBuilder.append("&");
                        }
                    }
                    stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                } catch (Map<String, String> map2) {
                    ALog.e(TAG, "format params failed", null, map2);
                }
                return stringBuilder.toString();
            }
        }
        return "";
    }

    public static String getEmuiVersion() {
        String str = "";
        Class[] clsArr = new Class[]{String.class};
        Object[] objArr = new Object[]{"ro.build.version.emui"};
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            String str2 = (String) cls.getDeclaredMethod("get", clsArr).invoke(cls, objArr);
            String str3 = TAG;
            StringBuilder stringBuilder = new StringBuilder("get EMUI version is:");
            stringBuilder.append(str2);
            ALog.d(str3, stringBuilder.toString(), new Object[0]);
            if (TextUtils.isEmpty(str2)) {
                return str;
            }
            return str2;
        } catch (Throwable e) {
            ALog.e(TAG, " getEmuiVersion wrong", e, new Object[0]);
        }
    }

    public static final java.util.Map<java.lang.String, java.lang.String> getHeader(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r6) {
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
        r0 = new java.util.HashMap;
        r0.<init>();
        r6 = r6.entrySet();	 Catch:{ Throwable -> 0x0065 }
        r6 = r6.iterator();	 Catch:{ Throwable -> 0x0065 }
    L_0x000d:
        r1 = r6.hasNext();	 Catch:{ Throwable -> 0x0065 }
        if (r1 == 0) goto L_0x0065;	 Catch:{ Throwable -> 0x0065 }
    L_0x0013:
        r1 = r6.next();	 Catch:{ Throwable -> 0x0065 }
        r1 = (java.util.Map.Entry) r1;	 Catch:{ Throwable -> 0x0065 }
        r2 = r1.getKey();	 Catch:{ Throwable -> 0x0065 }
        r2 = (java.lang.String) r2;	 Catch:{ Throwable -> 0x0065 }
        r3 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Throwable -> 0x0065 }
        if (r3 != 0) goto L_0x000d;	 Catch:{ Throwable -> 0x0065 }
    L_0x0025:
        r1 = r1.getValue();	 Catch:{ Throwable -> 0x0065 }
        r1 = (java.util.List) r1;	 Catch:{ Throwable -> 0x0065 }
        r1 = list2String(r1);	 Catch:{ Throwable -> 0x0065 }
        r3 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x0065 }
        if (r3 != 0) goto L_0x000d;	 Catch:{ Throwable -> 0x0065 }
    L_0x0035:
        r3 = ":";	 Catch:{ Throwable -> 0x0065 }
        r3 = r2.startsWith(r3);	 Catch:{ Throwable -> 0x0065 }
        if (r3 != 0) goto L_0x0043;	 Catch:{ Throwable -> 0x0065 }
    L_0x003d:
        r3 = java.util.Locale.US;	 Catch:{ Throwable -> 0x0065 }
        r2 = r2.toLowerCase(r3);	 Catch:{ Throwable -> 0x0065 }
    L_0x0043:
        r0.put(r2, r1);	 Catch:{ Throwable -> 0x0065 }
        r3 = "UtilityImpl";	 Catch:{ Throwable -> 0x0065 }
        r4 = new java.lang.StringBuilder;	 Catch:{ Throwable -> 0x0065 }
        r5 = "\theader:";	 Catch:{ Throwable -> 0x0065 }
        r4.<init>(r5);	 Catch:{ Throwable -> 0x0065 }
        r4.append(r2);	 Catch:{ Throwable -> 0x0065 }
        r2 = " value:";	 Catch:{ Throwable -> 0x0065 }
        r4.append(r2);	 Catch:{ Throwable -> 0x0065 }
        r4.append(r1);	 Catch:{ Throwable -> 0x0065 }
        r1 = r4.toString();	 Catch:{ Throwable -> 0x0065 }
        r2 = 0;	 Catch:{ Throwable -> 0x0065 }
        r2 = new java.lang.Object[r2];	 Catch:{ Throwable -> 0x0065 }
        com.taobao.accs.utl.ALog.i(r3, r1, r2);	 Catch:{ Throwable -> 0x0065 }
        goto L_0x000d;
    L_0x0065:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.utl.UtilityImpl.getHeader(java.util.Map):java.util.Map<java.lang.String, java.lang.String>");
    }

    public static final String list2String(List<String> list) {
        StringBuffer stringBuffer = new StringBuffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            stringBuffer.append((String) list.get(i));
            if (i < size - 1) {
                stringBuffer.append(com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        return stringBuffer.toString();
    }
}
