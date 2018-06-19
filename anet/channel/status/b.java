package anet.channel.status;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Pair;
import anet.channel.status.NetworkStatusHelper.NetworkStatus;
import anet.channel.util.ALog;
import java.lang.reflect.Method;
import java.util.Locale;

/* compiled from: Taobao */
class b {
    static Context a = null;
    static volatile NetworkStatus b = NetworkStatus.NONE;
    static volatile String c = "unknown";
    static volatile String d = "";
    static volatile String e = "";
    static volatile String f = "";
    static volatile String g = "unknown";
    static volatile String h = "";
    static volatile Pair<String, Integer> i = null;
    private static volatile boolean j = false;
    private static ConnectivityManager k;
    private static TelephonyManager l;
    private static WifiManager m;
    private static SubscriptionManager n;
    private static Method o;
    private static BroadcastReceiver p = new NetworkStatusMonitor$1();

    b() {
    }

    static void a() {
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
        r0 = j;
        if (r0 != 0) goto L_0x0032;
    L_0x0004:
        r0 = a;
        if (r0 == 0) goto L_0x0032;
    L_0x0008:
        r0 = a;
        monitor-enter(r0);
        r1 = new android.content.IntentFilter;	 Catch:{ all -> 0x002f }
        r1.<init>();	 Catch:{ all -> 0x002f }
        r2 = "android.net.conn.CONNECTIVITY_CHANGE";	 Catch:{ all -> 0x002f }
        r1.addAction(r2);	 Catch:{ all -> 0x002f }
        r2 = a;	 Catch:{ Exception -> 0x001d }
        r3 = p;	 Catch:{ Exception -> 0x001d }
        r2.registerReceiver(r3, r1);	 Catch:{ Exception -> 0x001d }
        goto L_0x0028;
    L_0x001d:
        r1 = "awcn.NetworkStatusMonitor";	 Catch:{ all -> 0x002f }
        r2 = "registerReceiver failed";	 Catch:{ all -> 0x002f }
        r3 = 0;	 Catch:{ all -> 0x002f }
        r4 = 0;	 Catch:{ all -> 0x002f }
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x002f }
        anet.channel.util.ALog.e(r1, r2, r3, r4);	 Catch:{ all -> 0x002f }
    L_0x0028:
        monitor-exit(r0);	 Catch:{ all -> 0x002f }
        r0 = a;
        b(r0);
        goto L_0x0032;
    L_0x002f:
        r1 = move-exception;
        monitor-exit(r0);
        throw r1;
    L_0x0032:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.status.b.a():void");
    }

    private static void b(Context context) {
        ALog.d("awcn.NetworkStatusMonitor", "[checkNetworkStatus]", null, new Object[0]);
        Context context2 = b;
        String str = d;
        String str2 = e;
        if (context != null) {
            try {
                context = b();
                if (context != null) {
                    if (context.isConnected()) {
                        ALog.i("awcn.NetworkStatusMonitor", "checkNetworkStatus", null, "info.isConnected", Boolean.valueOf(context.isConnected()), "info.isAvailable", Boolean.valueOf(context.isAvailable()));
                        if (context.getType() == 0) {
                            Object subtypeName = context.getSubtypeName();
                            String replace = !TextUtils.isEmpty(subtypeName) ? subtypeName.replace(" ", "") : "";
                            a(a(context.getSubtype(), replace), replace);
                            d = a(context.getExtraInfo());
                            c();
                        } else if (context.getType() == 1) {
                            a(NetworkStatus.WIFI, "wifi");
                            context = d();
                            if (context != null) {
                                f = context.getBSSID();
                                e = context.getSSID();
                            }
                            context = "wifi";
                            g = context;
                            h = context;
                            i = e();
                        } else {
                            a(NetworkStatus.NONE, "unknown");
                        }
                        if (b != context2 || d.equalsIgnoreCase(str) == null || e.equalsIgnoreCase(str2) == null) {
                            if (ALog.isPrintLog(2) != null) {
                                NetworkStatusHelper.k();
                            }
                            NetworkStatusHelper.a(b);
                        }
                    }
                }
                a(NetworkStatus.NO, "no network");
                ALog.i("awcn.NetworkStatusMonitor", "checkNetworkStatus", null, "NO NETWORK");
                if (ALog.isPrintLog(2) != null) {
                    NetworkStatusHelper.k();
                }
                NetworkStatusHelper.a(b);
            } catch (Context context3) {
                ALog.e("awcn.NetworkStatusMonitor", "checkNetworkStatus", null, context3, new Object[0]);
            }
        }
    }

    private static void a(NetworkStatus networkStatus, String str) {
        b = networkStatus;
        c = str;
        d = "";
        e = "";
        f = "";
        i = null;
        g = "";
        h = "";
    }

    private static NetworkStatus a(int i, String str) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return NetworkStatus.G2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return NetworkStatus.G3;
            case 13:
            case 18:
            case 19:
                return NetworkStatus.G4;
            default:
                if (str.equalsIgnoreCase("TD-SCDMA") == 0 && str.equalsIgnoreCase("WCDMA") == 0) {
                    if (str.equalsIgnoreCase("CDMA2000") == 0) {
                        return NetworkStatus.NONE;
                    }
                }
                return NetworkStatus.G3;
        }
    }

    private static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "unknown";
        }
        str = str.toLowerCase(Locale.US);
        if (str.contains("cmwap")) {
            return "cmwap";
        }
        if (str.contains("uniwap")) {
            return "uniwap";
        }
        if (str.contains("3gwap")) {
            return "3gwap";
        }
        if (str.contains("ctwap")) {
            return "ctwap";
        }
        if (str.contains("cmnet")) {
            return "cmnet";
        }
        if (str.contains("uninet")) {
            return "uninet";
        }
        if (str.contains("3gnet")) {
            return "3gnet";
        }
        return str.contains("ctnet") != null ? "ctnet" : "unknown";
    }

    private static void c() {
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
        r0 = l;	 Catch:{ Exception -> 0x0054 }
        if (r0 != 0) goto L_0x0010;	 Catch:{ Exception -> 0x0054 }
    L_0x0004:
        r0 = a;	 Catch:{ Exception -> 0x0054 }
        r1 = "phone";	 Catch:{ Exception -> 0x0054 }
        r0 = r0.getSystemService(r1);	 Catch:{ Exception -> 0x0054 }
        r0 = (android.telephony.TelephonyManager) r0;	 Catch:{ Exception -> 0x0054 }
        l = r0;	 Catch:{ Exception -> 0x0054 }
    L_0x0010:
        r0 = l;	 Catch:{ Exception -> 0x0054 }
        r0 = r0.getSimOperator();	 Catch:{ Exception -> 0x0054 }
        h = r0;	 Catch:{ Exception -> 0x0054 }
        r0 = android.os.Build.VERSION.SDK_INT;	 Catch:{ Exception -> 0x0054 }
        r1 = 22;	 Catch:{ Exception -> 0x0054 }
        if (r0 < r1) goto L_0x0053;	 Catch:{ Exception -> 0x0054 }
    L_0x001e:
        r0 = n;	 Catch:{ Exception -> 0x0054 }
        r1 = 0;	 Catch:{ Exception -> 0x0054 }
        if (r0 != 0) goto L_0x0039;	 Catch:{ Exception -> 0x0054 }
    L_0x0023:
        r0 = a;	 Catch:{ Exception -> 0x0054 }
        r0 = android.telephony.SubscriptionManager.from(r0);	 Catch:{ Exception -> 0x0054 }
        n = r0;	 Catch:{ Exception -> 0x0054 }
        r0 = r0.getClass();	 Catch:{ Exception -> 0x0054 }
        r2 = "getDefaultDataSubscriptionInfo";	 Catch:{ Exception -> 0x0054 }
        r3 = new java.lang.Class[r1];	 Catch:{ Exception -> 0x0054 }
        r0 = r0.getDeclaredMethod(r2, r3);	 Catch:{ Exception -> 0x0054 }
        o = r0;	 Catch:{ Exception -> 0x0054 }
    L_0x0039:
        r0 = o;	 Catch:{ Exception -> 0x0054 }
        if (r0 == 0) goto L_0x0053;	 Catch:{ Exception -> 0x0054 }
    L_0x003d:
        r0 = o;	 Catch:{ Exception -> 0x0054 }
        r2 = n;	 Catch:{ Exception -> 0x0054 }
        r1 = new java.lang.Object[r1];	 Catch:{ Exception -> 0x0054 }
        r0 = r0.invoke(r2, r1);	 Catch:{ Exception -> 0x0054 }
        r0 = (android.telephony.SubscriptionInfo) r0;	 Catch:{ Exception -> 0x0054 }
        r0 = r0.getCarrierName();	 Catch:{ Exception -> 0x0054 }
        r0 = r0.toString();	 Catch:{ Exception -> 0x0054 }
        g = r0;	 Catch:{ Exception -> 0x0054 }
    L_0x0053:
        return;
    L_0x0054:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.status.b.c():void");
    }

    static NetworkInfo b() {
        try {
            if (k == null) {
                k = (ConnectivityManager) a.getSystemService("connectivity");
            }
            return k.getActiveNetworkInfo();
        } catch (Throwable th) {
            ALog.e("awcn.NetworkStatusMonitor", "getNetworkInfo", null, th, new Object[0]);
            return null;
        }
    }

    private static WifiInfo d() {
        try {
            if (m == null) {
                m = (WifiManager) a.getSystemService("wifi");
            }
            return m.getConnectionInfo();
        } catch (Throwable th) {
            ALog.e("awcn.NetworkStatusMonitor", "getWifiInfo", null, th, new Object[0]);
            return null;
        }
    }

    private static android.util.Pair<java.lang.String, java.lang.Integer> e() {
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
        r0 = "http.proxyHost";	 Catch:{ NumberFormatException -> 0x001f }
        r0 = java.lang.System.getProperty(r0);	 Catch:{ NumberFormatException -> 0x001f }
        r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ NumberFormatException -> 0x001f }
        if (r1 != 0) goto L_0x001f;	 Catch:{ NumberFormatException -> 0x001f }
    L_0x000c:
        r1 = "http.proxyPort";	 Catch:{ NumberFormatException -> 0x001f }
        r1 = java.lang.System.getProperty(r1);	 Catch:{ NumberFormatException -> 0x001f }
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ NumberFormatException -> 0x001f }
        r1 = java.lang.Integer.valueOf(r1);	 Catch:{ NumberFormatException -> 0x001f }
        r0 = android.util.Pair.create(r0, r1);	 Catch:{ NumberFormatException -> 0x001f }
        return r0;
    L_0x001f:
        r0 = 0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.status.b.e():android.util.Pair<java.lang.String, java.lang.Integer>");
    }
}
