package anet.channel.status;

import android.content.Context;
import android.net.NetworkInfo;
import android.util.Pair;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.a.c;
import java.util.concurrent.CopyOnWriteArraySet;

/* compiled from: Taobao */
public class NetworkStatusHelper {
    private static CopyOnWriteArraySet<INetworkStatusChangeListener> a = new CopyOnWriteArraySet();

    /* compiled from: Taobao */
    public interface INetworkStatusChangeListener {
        void onNetworkStatusChanged(NetworkStatus networkStatus);
    }

    /* compiled from: Taobao */
    public enum NetworkStatus {
        NONE,
        NO,
        G2,
        G3,
        G4,
        WIFI;

        public final boolean isMobile() {
            if (!(this == G2 || this == G3)) {
                if (this != G4) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isWifi() {
            return this == WIFI;
        }

        public final String getType() {
            if (this == G2) {
                return "2G";
            }
            if (this == G3) {
                return "3G";
            }
            if (this == G4) {
                return "4G";
            }
            return toString();
        }
    }

    public static synchronized void a(Context context) {
        synchronized (NetworkStatusHelper.class) {
            b.a = context;
            b.a();
        }
    }

    public static void a(INetworkStatusChangeListener iNetworkStatusChangeListener) {
        a.add(iNetworkStatusChangeListener);
    }

    public static void b(INetworkStatusChangeListener iNetworkStatusChangeListener) {
        a.remove(iNetworkStatusChangeListener);
    }

    static void a(NetworkStatus networkStatus) {
        c.a(new a(networkStatus));
    }

    public static NetworkStatus a() {
        return b.b;
    }

    public static String b() {
        return b.c;
    }

    public static String c() {
        return b.d;
    }

    public static String d() {
        return b.g;
    }

    public static String e() {
        return b.h;
    }

    public static String f() {
        return b.f;
    }

    public static boolean g() {
        if (b.b != NetworkStatus.NO) {
            return true;
        }
        NetworkInfo b = b.b();
        if (b == null || !b.isConnected()) {
            return false;
        }
        return true;
    }

    public static boolean h() {
        NetworkStatus networkStatus = b.b;
        return (networkStatus == NetworkStatus.WIFI && j() != null) || (networkStatus.isMobile() && (b.d.contains("wap") || GlobalAppRuntimeInfo.getProxySetting() != null));
    }

    public static String i() {
        NetworkStatus networkStatus = b.b;
        if (networkStatus == NetworkStatus.WIFI && j() != null) {
            return "proxy";
        }
        if (networkStatus.isMobile() && b.d.contains("wap")) {
            return "wap";
        }
        return (!networkStatus.isMobile() || GlobalAppRuntimeInfo.getProxySetting() == null) ? "" : "auth";
    }

    public static Pair<String, Integer> j() {
        if (b.b != NetworkStatus.WIFI) {
            return null;
        }
        return b.i;
    }

    public static void k() {
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
        r0 = anet.channel.status.b.b;	 Catch:{ Exception -> 0x00b5 }
        r1 = new java.lang.StringBuilder;	 Catch:{ Exception -> 0x00b5 }
        r2 = 128; // 0x80 float:1.794E-43 double:6.32E-322;	 Catch:{ Exception -> 0x00b5 }
        r1.<init>(r2);	 Catch:{ Exception -> 0x00b5 }
        r2 = "\nNetwork detail*******************************\n";	 Catch:{ Exception -> 0x00b5 }
        r1.append(r2);	 Catch:{ Exception -> 0x00b5 }
        r2 = "Status: ";	 Catch:{ Exception -> 0x00b5 }
        r1.append(r2);	 Catch:{ Exception -> 0x00b5 }
        r2 = r0.getType();	 Catch:{ Exception -> 0x00b5 }
        r1.append(r2);	 Catch:{ Exception -> 0x00b5 }
        r2 = 10;	 Catch:{ Exception -> 0x00b5 }
        r1.append(r2);	 Catch:{ Exception -> 0x00b5 }
        r3 = "Subtype: ";	 Catch:{ Exception -> 0x00b5 }
        r1.append(r3);	 Catch:{ Exception -> 0x00b5 }
        r3 = anet.channel.status.b.c;	 Catch:{ Exception -> 0x00b5 }
        r1.append(r3);	 Catch:{ Exception -> 0x00b5 }
        r1.append(r2);	 Catch:{ Exception -> 0x00b5 }
        r3 = anet.channel.status.NetworkStatusHelper.NetworkStatus.NO;	 Catch:{ Exception -> 0x00b5 }
        if (r0 == r3) goto L_0x006b;	 Catch:{ Exception -> 0x00b5 }
    L_0x0030:
        r0 = r0.isMobile();	 Catch:{ Exception -> 0x00b5 }
        if (r0 == 0) goto L_0x0051;	 Catch:{ Exception -> 0x00b5 }
    L_0x0036:
        r0 = "Apn: ";	 Catch:{ Exception -> 0x00b5 }
        r1.append(r0);	 Catch:{ Exception -> 0x00b5 }
        r0 = anet.channel.status.b.d;	 Catch:{ Exception -> 0x00b5 }
        r1.append(r0);	 Catch:{ Exception -> 0x00b5 }
        r1.append(r2);	 Catch:{ Exception -> 0x00b5 }
        r0 = "Carrier: ";	 Catch:{ Exception -> 0x00b5 }
        r1.append(r0);	 Catch:{ Exception -> 0x00b5 }
        r0 = anet.channel.status.b.g;	 Catch:{ Exception -> 0x00b5 }
        r1.append(r0);	 Catch:{ Exception -> 0x00b5 }
        r1.append(r2);	 Catch:{ Exception -> 0x00b5 }
        goto L_0x006b;	 Catch:{ Exception -> 0x00b5 }
    L_0x0051:
        r0 = "BSSID: ";	 Catch:{ Exception -> 0x00b5 }
        r1.append(r0);	 Catch:{ Exception -> 0x00b5 }
        r0 = anet.channel.status.b.f;	 Catch:{ Exception -> 0x00b5 }
        r1.append(r0);	 Catch:{ Exception -> 0x00b5 }
        r1.append(r2);	 Catch:{ Exception -> 0x00b5 }
        r0 = "SSID: ";	 Catch:{ Exception -> 0x00b5 }
        r1.append(r0);	 Catch:{ Exception -> 0x00b5 }
        r0 = anet.channel.status.b.e;	 Catch:{ Exception -> 0x00b5 }
        r1.append(r0);	 Catch:{ Exception -> 0x00b5 }
        r1.append(r2);	 Catch:{ Exception -> 0x00b5 }
    L_0x006b:
        r0 = h();	 Catch:{ Exception -> 0x00b5 }
        if (r0 == 0) goto L_0x00a2;	 Catch:{ Exception -> 0x00b5 }
    L_0x0071:
        r0 = "Proxy: ";	 Catch:{ Exception -> 0x00b5 }
        r1.append(r0);	 Catch:{ Exception -> 0x00b5 }
        r0 = i();	 Catch:{ Exception -> 0x00b5 }
        r1.append(r0);	 Catch:{ Exception -> 0x00b5 }
        r1.append(r2);	 Catch:{ Exception -> 0x00b5 }
        r0 = j();	 Catch:{ Exception -> 0x00b5 }
        if (r0 == 0) goto L_0x00a2;	 Catch:{ Exception -> 0x00b5 }
    L_0x0086:
        r3 = "ProxyHost: ";	 Catch:{ Exception -> 0x00b5 }
        r1.append(r3);	 Catch:{ Exception -> 0x00b5 }
        r3 = r0.first;	 Catch:{ Exception -> 0x00b5 }
        r3 = (java.lang.String) r3;	 Catch:{ Exception -> 0x00b5 }
        r1.append(r3);	 Catch:{ Exception -> 0x00b5 }
        r1.append(r2);	 Catch:{ Exception -> 0x00b5 }
        r3 = "ProxyPort: ";	 Catch:{ Exception -> 0x00b5 }
        r1.append(r3);	 Catch:{ Exception -> 0x00b5 }
        r0 = r0.second;	 Catch:{ Exception -> 0x00b5 }
        r1.append(r0);	 Catch:{ Exception -> 0x00b5 }
        r1.append(r2);	 Catch:{ Exception -> 0x00b5 }
    L_0x00a2:
        r0 = "*********************************************";	 Catch:{ Exception -> 0x00b5 }
        r1.append(r0);	 Catch:{ Exception -> 0x00b5 }
        r0 = "awcn.NetworkStatusHelper";	 Catch:{ Exception -> 0x00b5 }
        r1 = r1.toString();	 Catch:{ Exception -> 0x00b5 }
        r2 = 0;	 Catch:{ Exception -> 0x00b5 }
        r3 = 0;	 Catch:{ Exception -> 0x00b5 }
        r3 = new java.lang.Object[r3];	 Catch:{ Exception -> 0x00b5 }
        anet.channel.util.ALog.i(r0, r1, r2, r3);	 Catch:{ Exception -> 0x00b5 }
        return;
    L_0x00b5:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: anet.channel.status.NetworkStatusHelper.k():void");
    }
}
