package com.alibaba.mtl.log.e;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.text.TextUtils;
import com.igexin.sdk.PushConsts;

/* compiled from: NetworkUtil */
public final class l {
    private static String[] a = new String[]{"Unknown", "Unknown"};
    private static b b = new b();
    private static a c = new a();

    /* compiled from: NetworkUtil */
    private static class a implements Runnable {
        Context a;

        private a() {
        }

        public final void run() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r5 = this;
            r0 = r5.a;
            if (r0 != 0) goto L_0x0005;
        L_0x0004:
            return;
        L_0x0005:
            r0 = r5.a;	 Catch:{ Exception -> 0x006d }
            r0 = r0.getPackageManager();	 Catch:{ Exception -> 0x006d }
            r1 = "android.permission.ACCESS_NETWORK_STATE";	 Catch:{ Exception -> 0x006d }
            r2 = r5.a;	 Catch:{ Exception -> 0x006d }
            r2 = r2.getPackageName();	 Catch:{ Exception -> 0x006d }
            r0 = r0.checkPermission(r1, r2);	 Catch:{ Exception -> 0x006d }
            r1 = 0;	 Catch:{ Exception -> 0x006d }
            if (r0 == 0) goto L_0x0023;	 Catch:{ Exception -> 0x006d }
        L_0x001a:
            r0 = com.alibaba.mtl.log.e.l.a;	 Catch:{ Exception -> 0x006d }
            r2 = "Unknown";	 Catch:{ Exception -> 0x006d }
            r0[r1] = r2;	 Catch:{ Exception -> 0x006d }
            return;	 Catch:{ Exception -> 0x006d }
        L_0x0023:
            r0 = r5.a;	 Catch:{ Exception -> 0x006d }
            r2 = "connectivity";	 Catch:{ Exception -> 0x006d }
            r0 = r0.getSystemService(r2);	 Catch:{ Exception -> 0x006d }
            r0 = (android.net.ConnectivityManager) r0;	 Catch:{ Exception -> 0x006d }
            if (r0 != 0) goto L_0x0038;	 Catch:{ Exception -> 0x006d }
        L_0x002f:
            r0 = com.alibaba.mtl.log.e.l.a;	 Catch:{ Exception -> 0x006d }
            r2 = "Unknown";	 Catch:{ Exception -> 0x006d }
            r0[r1] = r2;	 Catch:{ Exception -> 0x006d }
            return;	 Catch:{ Exception -> 0x006d }
        L_0x0038:
            r0 = r0.getActiveNetworkInfo();	 Catch:{ Exception -> 0x006d }
            if (r0 == 0) goto L_0x006c;	 Catch:{ Exception -> 0x006d }
        L_0x003e:
            r2 = r0.isConnected();	 Catch:{ Exception -> 0x006d }
            if (r2 == 0) goto L_0x006c;	 Catch:{ Exception -> 0x006d }
        L_0x0044:
            r2 = r0.getType();	 Catch:{ Exception -> 0x006d }
            r3 = 1;	 Catch:{ Exception -> 0x006d }
            if (r3 != r2) goto L_0x0054;	 Catch:{ Exception -> 0x006d }
        L_0x004b:
            r0 = com.alibaba.mtl.log.e.l.a;	 Catch:{ Exception -> 0x006d }
            r2 = "Wi-Fi";	 Catch:{ Exception -> 0x006d }
            r0[r1] = r2;	 Catch:{ Exception -> 0x006d }
            return;	 Catch:{ Exception -> 0x006d }
        L_0x0054:
            r2 = r0.getType();	 Catch:{ Exception -> 0x006d }
            if (r2 != 0) goto L_0x006c;	 Catch:{ Exception -> 0x006d }
        L_0x005a:
            r2 = com.alibaba.mtl.log.e.l.a;	 Catch:{ Exception -> 0x006d }
            r4 = "2G/3G";	 Catch:{ Exception -> 0x006d }
            r2[r1] = r4;	 Catch:{ Exception -> 0x006d }
            r1 = com.alibaba.mtl.log.e.l.a;	 Catch:{ Exception -> 0x006d }
            r0 = r0.getSubtypeName();	 Catch:{ Exception -> 0x006d }
            r1[r3] = r0;	 Catch:{ Exception -> 0x006d }
        L_0x006c:
            return;
        L_0x006d:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.e.l.a.run():void");
        }
    }

    /* compiled from: NetworkUtil */
    private static class b extends BroadcastReceiver {
        private b() {
        }

        public final void onReceive(Context context, Intent intent) {
            r.a();
            Runnable d = l.c;
            d.a = context;
            r.a(d);
        }
    }

    public static java.lang.String a() {
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
        r0 = com.alibaba.mtl.log.a.c();
        if (r0 != 0) goto L_0x0009;
    L_0x0006:
        r0 = "Unknown";
        return r0;
    L_0x0009:
        r1 = r0.getPackageManager();	 Catch:{ Throwable -> 0x0057 }
        r2 = "android.permission.ACCESS_NETWORK_STATE";	 Catch:{ Throwable -> 0x0057 }
        r3 = r0.getPackageName();	 Catch:{ Throwable -> 0x0057 }
        r1 = r1.checkPermission(r2, r3);	 Catch:{ Throwable -> 0x0057 }
        if (r1 == 0) goto L_0x001c;	 Catch:{ Throwable -> 0x0057 }
    L_0x0019:
        r0 = "Unknown";	 Catch:{ Throwable -> 0x0057 }
        return r0;	 Catch:{ Throwable -> 0x0057 }
    L_0x001c:
        r1 = "connectivity";	 Catch:{ Throwable -> 0x0057 }
        r0 = r0.getSystemService(r1);	 Catch:{ Throwable -> 0x0057 }
        r0 = (android.net.ConnectivityManager) r0;	 Catch:{ Throwable -> 0x0057 }
        r0 = r0.getActiveNetworkInfo();	 Catch:{ Throwable -> 0x0057 }
        if (r0 != 0) goto L_0x002d;	 Catch:{ Throwable -> 0x0057 }
    L_0x002a:
        r0 = "Unknown";	 Catch:{ Throwable -> 0x0057 }
        return r0;	 Catch:{ Throwable -> 0x0057 }
    L_0x002d:
        r1 = r0.isConnected();	 Catch:{ Throwable -> 0x0057 }
        if (r1 == 0) goto L_0x0057;	 Catch:{ Throwable -> 0x0057 }
    L_0x0033:
        r1 = r0.getType();	 Catch:{ Throwable -> 0x0057 }
        r2 = 1;	 Catch:{ Throwable -> 0x0057 }
        if (r1 != r2) goto L_0x003d;	 Catch:{ Throwable -> 0x0057 }
    L_0x003a:
        r0 = "wifi";	 Catch:{ Throwable -> 0x0057 }
        return r0;	 Catch:{ Throwable -> 0x0057 }
    L_0x003d:
        r1 = r0.getType();	 Catch:{ Throwable -> 0x0057 }
        if (r1 != 0) goto L_0x0057;	 Catch:{ Throwable -> 0x0057 }
    L_0x0043:
        r0 = r0.getSubtype();	 Catch:{ Throwable -> 0x0057 }
        switch(r0) {
            case 1: goto L_0x0053;
            case 2: goto L_0x0053;
            case 3: goto L_0x0050;
            case 4: goto L_0x0053;
            case 5: goto L_0x0050;
            case 6: goto L_0x0050;
            case 7: goto L_0x0053;
            case 8: goto L_0x0050;
            case 9: goto L_0x0050;
            case 10: goto L_0x0050;
            case 11: goto L_0x0053;
            case 12: goto L_0x0050;
            case 13: goto L_0x004d;
            case 14: goto L_0x0050;
            case 15: goto L_0x0050;
            default: goto L_0x004a;
        };	 Catch:{ Throwable -> 0x0057 }
    L_0x004a:
        r0 = "Unknown";	 Catch:{ Throwable -> 0x0057 }
        goto L_0x0056;	 Catch:{ Throwable -> 0x0057 }
    L_0x004d:
        r0 = "4G";	 Catch:{ Throwable -> 0x0057 }
        return r0;	 Catch:{ Throwable -> 0x0057 }
    L_0x0050:
        r0 = "3G";	 Catch:{ Throwable -> 0x0057 }
        return r0;	 Catch:{ Throwable -> 0x0057 }
    L_0x0053:
        r0 = "2G";	 Catch:{ Throwable -> 0x0057 }
        return r0;
    L_0x0056:
        return r0;
    L_0x0057:
        r0 = "Unknown";
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.e.l.a():java.lang.String");
    }

    public static boolean b() {
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
        r0 = com.alibaba.mtl.log.a.c();
        if (r0 == 0) goto L_0x001d;
    L_0x0006:
        r1 = "connectivity";	 Catch:{ Exception -> 0x001d }
        r0 = r0.getSystemService(r1);	 Catch:{ Exception -> 0x001d }
        r0 = (android.net.ConnectivityManager) r0;	 Catch:{ Exception -> 0x001d }
        if (r0 == 0) goto L_0x001d;	 Catch:{ Exception -> 0x001d }
    L_0x0010:
        r0 = r0.getActiveNetworkInfo();	 Catch:{ Exception -> 0x001d }
        if (r0 == 0) goto L_0x001b;	 Catch:{ Exception -> 0x001d }
    L_0x0016:
        r0 = r0.isConnected();	 Catch:{ Exception -> 0x001d }
        return r0;
    L_0x001b:
        r0 = 0;
        return r0;
    L_0x001d:
        r0 = 1;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.mtl.log.e.l.b():boolean");
    }

    public static String[] c() {
        return a;
    }

    public static String a(Context context) {
        if (context == null) {
            return "00:00:00:00:00:00";
        }
        context = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo();
        if (context == null) {
            return "00:00:00:00:00:00";
        }
        context = context.getMacAddress();
        if (TextUtils.isEmpty(context)) {
            context = "00:00:00:00:00:00";
        }
        return context;
    }

    public static void b(Context context) {
        if (context != null) {
            context.registerReceiver(b, new IntentFilter(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE));
        }
    }

    public static void c(Context context) {
        if (context != null && b != null) {
            context.unregisterReceiver(b);
        }
    }
}
