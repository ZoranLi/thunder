package com.taobao.accs.utl;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.ta.utdid2.device.UTDevice;
import java.io.File;

/* compiled from: Taobao */
public class a {
    public static String a = "";
    public static String b = null;
    private static String c = "";
    public static final String channelService = "com.taobao.accs.ChannelService";
    private static String d = "";
    private static boolean e = true;
    private static boolean f = false;
    public static final String msgService = "com.taobao.accs.data.MsgDistributeService";

    public static boolean a(Context context) {
        if (f) {
            return e;
        }
        try {
            Object obj;
            if (TextUtils.isEmpty(com.taobao.accs.client.a.d)) {
                if (TextUtils.isEmpty(c)) {
                    c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.processName;
                }
                obj = c;
            } else {
                obj = com.taobao.accs.client.a.d;
            }
            if (TextUtils.isEmpty(d)) {
                d = a(context, Process.myPid());
            }
            if (TextUtils.isEmpty(obj) == null && TextUtils.isEmpty(d) == null) {
                e = obj.equalsIgnoreCase(d);
                f = true;
            }
        } catch (Context context2) {
            ALog.e("AdapterUtilityImpl", "isMainProcess", context2, new Object[0]);
        }
        return e;
    }

    public static java.lang.String a(android.content.Context r3, int r4) {
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
        r0 = com.taobao.accs.client.a.f;
        if (r0 == 0) goto L_0x000b;
    L_0x0004:
        r3 = com.taobao.accs.client.a.f;
        r3 = r3.getCurrProcessName();
        return r3;
    L_0x000b:
        r0 = "";
        r3 = com.taobao.accs.client.a.a(r3);
        r3 = r3.a();
        r3 = r3.getRunningAppProcesses();
        r3 = r3.iterator();
    L_0x001d:
        r1 = r3.hasNext();
        if (r1 == 0) goto L_0x0031;
    L_0x0023:
        r1 = r3.next();
        r1 = (android.app.ActivityManager.RunningAppProcessInfo) r1;
        r2 = r1.pid;	 Catch:{ Exception -> 0x001d }
        if (r2 != r4) goto L_0x001d;	 Catch:{ Exception -> 0x001d }
    L_0x002d:
        r1 = r1.processName;	 Catch:{ Exception -> 0x001d }
        r0 = r1;
        goto L_0x001d;
    L_0x0031:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.utl.a.a(android.content.Context, int):java.lang.String");
    }

    public static long a() {
        try {
            File dataDirectory = Environment.getDataDirectory();
            if (dataDirectory == null) {
                return -1;
            }
            if (VERSION.SDK_INT >= 9) {
                return dataDirectory.getUsableSpace();
            }
            if (!dataDirectory.exists()) {
                return -1;
            }
            StatFs statFs = new StatFs(dataDirectory.getPath());
            return ((long) statFs.getBlockSize()) * ((long) statFs.getAvailableBlocks());
        } catch (Throwable th) {
            ALog.e("AdapterUtilityImpl", "getUsableSpace", th, new Object[0]);
            return -1;
        }
    }

    public static java.lang.String a(java.lang.Throwable r4) {
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
        r0 = new java.lang.StringBuffer;
        r0.<init>();
        r4 = r4.getStackTrace();	 Catch:{ Exception -> 0x002f }
        if (r4 == 0) goto L_0x002f;	 Catch:{ Exception -> 0x002f }
    L_0x000b:
        r1 = r4.length;	 Catch:{ Exception -> 0x002f }
        if (r1 <= 0) goto L_0x002f;	 Catch:{ Exception -> 0x002f }
    L_0x000e:
        r1 = 0;	 Catch:{ Exception -> 0x002f }
    L_0x000f:
        r2 = r4.length;	 Catch:{ Exception -> 0x002f }
        if (r1 >= r2) goto L_0x002f;	 Catch:{ Exception -> 0x002f }
    L_0x0012:
        r2 = r4[r1];	 Catch:{ Exception -> 0x002f }
        r3 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x002f }
        r3.<init>();	 Catch:{ Exception -> 0x002f }
        r2 = r2.toString();	 Catch:{ Exception -> 0x002f }
        r3.append(r2);	 Catch:{ Exception -> 0x002f }
        r2 = "\n";	 Catch:{ Exception -> 0x002f }
        r3.append(r2);	 Catch:{ Exception -> 0x002f }
        r2 = r3.toString();	 Catch:{ Exception -> 0x002f }
        r0.append(r2);	 Catch:{ Exception -> 0x002f }
        r1 = r1 + 1;
        goto L_0x000f;
    L_0x002f:
        r4 = r0.toString();
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.accs.utl.a.a(java.lang.Throwable):java.lang.String");
    }

    public static String b(Context context) {
        return UTDevice.getUtdid(context);
    }

    public static boolean c(Context context) {
        if (context != null) {
            try {
                context = com.taobao.accs.client.a.a(context).b().getActiveNetworkInfo();
                if (context != null) {
                    return context.isConnected();
                }
            } catch (Context context2) {
                context2.printStackTrace();
            }
        }
        return null;
    }

    public static final boolean a(String str, int i) {
        if (str == null) {
            return false;
        }
        StatFs statFs = new StatFs(str);
        str = statFs.getBlockSize();
        long availableBlocks = (long) statFs.getAvailableBlocks();
        StringBuilder stringBuilder = new StringBuilder("st.getAvailableBlocks()=");
        stringBuilder.append(statFs.getAvailableBlocks());
        stringBuilder.append(",st.getAvailableBlocks() * blockSize=");
        long j = (long) str;
        stringBuilder.append(((long) statFs.getAvailableBlocks()) * j);
        if (statFs.getAvailableBlocks() > 10) {
            if (availableBlocks * j > ((long) i)) {
                return true;
            }
        }
        return false;
    }

    public static String d(Context context) {
        String str = "unknown";
        try {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            context = context.getApplicationContext().getPackageName();
            int i = applicationInfo.uid;
            Class cls = Class.forName(AppOpsManager.class.getName());
            r7 = new Class[3];
            boolean z = true;
            r7[1] = Integer.TYPE;
            r7[2] = String.class;
            if (((Integer) cls.getMethod("checkOpNoThrow", r7).invoke(appOpsManager, new Object[]{Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(appOpsManager)).intValue()), Integer.valueOf(i), context})).intValue() != null) {
                z = false;
            }
            return String.valueOf(z);
        } catch (Context context2) {
            ALog.e("AdapterUtilityImpl", "isNotificationEnabled", context2, new Object[0]);
            return str;
        }
    }
}
