package anet.channel.util;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import anet.channel.appmonitor.AppMonitor;
import anet.channel.monitor.NetworkSpeed;
import anet.channel.statist.ExceptionStatistic;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.status.NetworkStatusHelper.NetworkStatus;
import com.ta.utdid2.device.UTDevice;
import com.taobao.accs.utl.a;

/* compiled from: Taobao */
public class Utils {
    private static final String TAG = "awcn.Utils";
    public static int accsVersion;
    public static Context context;

    public static boolean isDebugMode(Context context) {
        return false;
    }

    public static String getDeviceId(Context context) {
        return UTDevice.getUtdid(context);
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
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.util.Utils.getImsi(android.content.Context):java.lang.String");
    }

    public static String getOperator(Context context) {
        context = getImsi(context);
        String str = "null";
        return (context == null || context.length() <= 5) ? str : context.substring(0, 5);
    }

    public static java.lang.String getMainProcessName(android.content.Context r3) {
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
        r0 = "";
        if (r3 != 0) goto L_0x0005;
    L_0x0004:
        return r0;
    L_0x0005:
        r1 = r3.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0017 }
        r3 = r3.getPackageName();	 Catch:{ NameNotFoundException -> 0x0017 }
        r2 = 0;	 Catch:{ NameNotFoundException -> 0x0017 }
        r3 = r1.getPackageInfo(r3, r2);	 Catch:{ NameNotFoundException -> 0x0017 }
        r3 = r3.applicationInfo;	 Catch:{ NameNotFoundException -> 0x0017 }
        r3 = r3.processName;	 Catch:{ NameNotFoundException -> 0x0017 }
        goto L_0x0018;
    L_0x0017:
        r3 = r0;
    L_0x0018:
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.util.Utils.getMainProcessName(android.content.Context):java.lang.String");
    }

    public static String getProcessName(Context context, int i) {
        String str = "";
        try {
            Context<RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses == null || runningAppProcesses.size() <= 0) {
                context = new StringBuilder("BuildVersion=");
                context.append(String.valueOf(VERSION.SDK_INT));
                AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_GET_PROCESS_NULL, ErrorConstant.formatMsg(ErrorConstant.ERROR_GET_PROCESS_NULL, context.toString()), "rt"));
                context = str;
                return TextUtils.isEmpty(context) ? getProcessNameNew(i) : context;
            } else {
                for (RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                    if (runningAppProcessInfo.pid == i) {
                        context = runningAppProcessInfo.processName;
                        break;
                    }
                }
                context = str;
                if (TextUtils.isEmpty(context)) {
                }
            }
        } catch (Context context2) {
            AppMonitor.getInstance().commitStat(new ExceptionStatistic(ErrorConstant.ERROR_GET_PROCESS_NULL, context2.toString(), "rt"));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String getProcessNameNew(int r7) {
        /*
        r0 = new java.lang.StringBuilder;
        r1 = "ps  |  grep  ";
        r0.<init>(r1);
        r0.append(r7);
        r0 = r0.toString();
        r1 = 0;
        r2 = 0;
        r3 = java.lang.Runtime.getRuntime();	 Catch:{ Exception -> 0x00ab, all -> 0x00a7 }
        r4 = "sh";
        r3 = r3.exec(r4);	 Catch:{ Exception -> 0x00ab, all -> 0x00a7 }
        r4 = new java.io.BufferedReader;	 Catch:{ Exception -> 0x00ab, all -> 0x00a7 }
        r5 = new java.io.InputStreamReader;	 Catch:{ Exception -> 0x00ab, all -> 0x00a7 }
        r6 = r3.getInputStream();	 Catch:{ Exception -> 0x00ab, all -> 0x00a7 }
        r5.<init>(r6);	 Catch:{ Exception -> 0x00ab, all -> 0x00a7 }
        r4.<init>(r5);	 Catch:{ Exception -> 0x00ab, all -> 0x00a7 }
        r5 = new java.io.DataOutputStream;	 Catch:{ Exception -> 0x00a4, all -> 0x00a1 }
        r6 = r3.getOutputStream();	 Catch:{ Exception -> 0x00a4, all -> 0x00a1 }
        r5.<init>(r6);	 Catch:{ Exception -> 0x00a4, all -> 0x00a1 }
        r6 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x009f }
        r6.<init>();	 Catch:{ Exception -> 0x009f }
        r6.append(r0);	 Catch:{ Exception -> 0x009f }
        r0 = "  &\n";
        r6.append(r0);	 Catch:{ Exception -> 0x009f }
        r0 = r6.toString();	 Catch:{ Exception -> 0x009f }
        r5.writeBytes(r0);	 Catch:{ Exception -> 0x009f }
        r5.flush();	 Catch:{ Exception -> 0x009f }
        r0 = "exit\n";
        r5.writeBytes(r0);	 Catch:{ Exception -> 0x009f }
        r3.waitFor();	 Catch:{ Exception -> 0x009f }
    L_0x0050:
        r0 = r4.readLine();	 Catch:{ Exception -> 0x009f }
        if (r0 == 0) goto L_0x0098;
    L_0x0056:
        r3 = "\\s+";
        r6 = "  ";
        r0 = r0.replaceAll(r3, r6);	 Catch:{ Exception -> 0x009f }
        r3 = "  ";
        r0 = r0.split(r3);	 Catch:{ Exception -> 0x009f }
        r3 = r0.length;	 Catch:{ Exception -> 0x009f }
        r6 = 9;
        if (r3 < r6) goto L_0x0050;
    L_0x0069:
        r3 = 1;
        r6 = r0[r3];	 Catch:{ Exception -> 0x009f }
        r6 = android.text.TextUtils.isEmpty(r6);	 Catch:{ Exception -> 0x009f }
        if (r6 != 0) goto L_0x0050;
    L_0x0072:
        r3 = r0[r3];	 Catch:{ Exception -> 0x009f }
        r3 = r3.trim();	 Catch:{ Exception -> 0x009f }
        r6 = java.lang.String.valueOf(r7);	 Catch:{ Exception -> 0x009f }
        r3 = r3.equals(r6);	 Catch:{ Exception -> 0x009f }
        if (r3 == 0) goto L_0x0050;
    L_0x0082:
        r7 = 8;
        r7 = r0[r7];	 Catch:{ Exception -> 0x009f }
        r4.close();	 Catch:{ IOException -> 0x008d }
        r5.close();	 Catch:{ IOException -> 0x008d }
        goto L_0x0097;
    L_0x008d:
        r0 = move-exception;
        r3 = "awcn.Utils";
        r4 = "getProcessNameNew ";
        r1 = new java.lang.Object[r1];
        anet.channel.util.ALog.e(r3, r4, r2, r0, r1);
    L_0x0097:
        return r7;
    L_0x0098:
        r4.close();	 Catch:{ IOException -> 0x00bd }
        r5.close();	 Catch:{ IOException -> 0x00bd }
        goto L_0x00ce;
    L_0x009f:
        r7 = move-exception;
        goto L_0x00ae;
    L_0x00a1:
        r7 = move-exception;
        r5 = r2;
        goto L_0x00d2;
    L_0x00a4:
        r7 = move-exception;
        r5 = r2;
        goto L_0x00ae;
    L_0x00a7:
        r7 = move-exception;
        r4 = r2;
        r5 = r4;
        goto L_0x00d2;
    L_0x00ab:
        r7 = move-exception;
        r4 = r2;
        r5 = r4;
    L_0x00ae:
        r0 = "awcn.Utils";
        r3 = "getProcessNameNew ";
        r6 = new java.lang.Object[r1];	 Catch:{ all -> 0x00d1 }
        anet.channel.util.ALog.e(r0, r3, r2, r7, r6);	 Catch:{ all -> 0x00d1 }
        if (r4 == 0) goto L_0x00bf;
    L_0x00b9:
        r4.close();	 Catch:{ IOException -> 0x00bd }
        goto L_0x00bf;
    L_0x00bd:
        r7 = move-exception;
        goto L_0x00c5;
    L_0x00bf:
        if (r5 == 0) goto L_0x00ce;
    L_0x00c1:
        r5.close();	 Catch:{ IOException -> 0x00bd }
        goto L_0x00ce;
    L_0x00c5:
        r0 = "awcn.Utils";
        r3 = "getProcessNameNew ";
        r1 = new java.lang.Object[r1];
        anet.channel.util.ALog.e(r0, r3, r2, r7, r1);
    L_0x00ce:
        r7 = "";
        return r7;
    L_0x00d1:
        r7 = move-exception;
    L_0x00d2:
        if (r4 == 0) goto L_0x00da;
    L_0x00d4:
        r4.close();	 Catch:{ IOException -> 0x00d8 }
        goto L_0x00da;
    L_0x00d8:
        r0 = move-exception;
        goto L_0x00e0;
    L_0x00da:
        if (r5 == 0) goto L_0x00e9;
    L_0x00dc:
        r5.close();	 Catch:{ IOException -> 0x00d8 }
        goto L_0x00e9;
    L_0x00e0:
        r3 = "awcn.Utils";
        r4 = "getProcessNameNew ";
        r1 = new java.lang.Object[r1];
        anet.channel.util.ALog.e(r3, r4, r2, r0, r1);
    L_0x00e9:
        throw r7;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.util.Utils.getProcessNameNew(int):java.lang.String");
    }

    public static String getAppVersion(Context context) {
        String str = "";
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Context context2) {
            ALog.w(TAG, "getAppVersion", null, context2, new Object[0]);
            return str;
        }
    }

    public static Context getAppContext() {
        if (context != null) {
            return context;
        }
        synchronized (Utils.class) {
            if (context != null) {
                Context context = context;
                return context;
            }
            try {
                Class cls = Class.forName("android.app.ActivityThread");
                Object invoke = cls.getMethod("currentActivityThread", new Class[0]).invoke(cls, new Object[0]);
                context = (Context) invoke.getClass().getMethod("getApplication", new Class[0]).invoke(invoke, new Object[0]);
            } catch (Throwable e) {
                ALog.w(TAG, "getAppContext", null, e, new Object[0]);
            }
            context = context;
            return context;
        }
    }

    public static int getAccsVersion() {
        if (accsVersion != 0) {
            return accsVersion;
        }
        try {
            accsVersion = ((Integer) Utils.class.getClassLoader().loadClass(a.channelService).getDeclaredField("SDK_VERSION_CODE").get(null)).intValue();
        } catch (Throwable e) {
            ALog.w(TAG, "getAccsVersion", null, e, new Object[0]);
        }
        return accsVersion;
    }

    public static String getStackMsg(Throwable th) {
        StringBuffer stringBuffer = new StringBuffer();
        try {
            th = th.getStackTrace();
            if (th != null && th.length > 0) {
                for (StackTraceElement stackTraceElement : th) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(stackTraceElement.toString());
                    stringBuilder.append("\n");
                    stringBuffer.append(stringBuilder.toString());
                }
            }
        } catch (Throwable th2) {
            ALog.e(TAG, "getStackMsg", null, th2, new Object[0]);
        }
        return stringBuffer.toString();
    }

    public static Object invokeStaticMethodThrowException(String str, String str2, Class<?>[] clsArr, Object... objArr) throws Exception {
        Object obj = null;
        if (str != null) {
            if (str2 != null) {
                str = Class.forName(str);
                if (clsArr != null) {
                    str2 = str.getDeclaredMethod(str2, clsArr);
                } else {
                    str2 = str.getDeclaredMethod(str2, new Class[0]);
                }
                if (str2 != null) {
                    str2.setAccessible(1);
                    if (objArr != null) {
                        obj = str2.invoke(str, objArr);
                    } else {
                        obj = str2.invoke(str, new Object[0]);
                    }
                }
                return obj;
            }
        }
        return null;
    }

    public static float getNetworkTimeFactor() {
        float f;
        NetworkStatus a = NetworkStatusHelper.a();
        if (a != NetworkStatus.G4) {
            if (a != NetworkStatus.WIFI) {
                f = 1.0f;
                return anetwork.channel.monitor.a.b() != NetworkSpeed.Fast ? f * 0.75f : f;
            }
        }
        f = 0.8f;
        if (anetwork.channel.monitor.a.b() != NetworkSpeed.Fast) {
        }
    }
}
