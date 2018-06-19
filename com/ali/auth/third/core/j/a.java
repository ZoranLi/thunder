package com.ali.auth.third.core.j;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public final class a {
    private static String a = "\\u";
    private static String b;

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : bArr) {
            stringBuilder.append(Integer.toHexString((b >> 4) & 15));
            stringBuilder.append(Integer.toHexString(b & 15));
        }
        return stringBuilder.toString();
    }

    public static void a() {
        a("com_taobao_tae_sdk_system_exception");
    }

    public static void a(String str) {
        com.ali.auth.third.core.c.a.i.a(new f(str));
    }

    public static boolean a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo == null) {
            return false;
        }
        for (NetworkInfo networkInfo : allNetworkInfo) {
            if (networkInfo != null && (networkInfo.getState() == State.CONNECTED || networkInfo.getState() == State.CONNECTING)) {
                return true;
            }
        }
        return false;
    }

    public static boolean b() {
        return com.ali.auth.third.core.c.a.c == null ? true : a(com.ali.auth.third.core.c.a.c);
    }

    public static String c() {
        try {
            Enumeration networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration inetAddresses = ((NetworkInterface) networkInterfaces.nextElement()).getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress inetAddress = (InetAddress) inetAddresses.nextElement();
                    if (!inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException e) {
            e.toString();
        }
        return null;
    }

    public static java.lang.String d() {
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
        r0 = com.ali.auth.third.core.c.a.c;
        r1 = 0;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r0 = b;
        if (r0 == 0) goto L_0x000d;
    L_0x000a:
        r0 = b;
        return r0;
    L_0x000d:
        r0 = com.ali.auth.third.core.c.a.c;	 Catch:{ Exception -> 0x003d }
        r2 = "activity";	 Catch:{ Exception -> 0x003d }
        r0 = r0.getSystemService(r2);	 Catch:{ Exception -> 0x003d }
        r0 = (android.app.ActivityManager) r0;	 Catch:{ Exception -> 0x003d }
        r0 = r0.getRunningAppProcesses();	 Catch:{ Exception -> 0x003d }
        if (r0 != 0) goto L_0x001e;	 Catch:{ Exception -> 0x003d }
    L_0x001d:
        return r1;	 Catch:{ Exception -> 0x003d }
    L_0x001e:
        r2 = android.os.Process.myPid();	 Catch:{ Exception -> 0x003d }
        r0 = r0.iterator();	 Catch:{ Exception -> 0x003d }
    L_0x0026:
        r3 = r0.hasNext();	 Catch:{ Exception -> 0x003d }
        if (r3 == 0) goto L_0x003d;	 Catch:{ Exception -> 0x003d }
    L_0x002c:
        r3 = r0.next();	 Catch:{ Exception -> 0x003d }
        r3 = (android.app.ActivityManager.RunningAppProcessInfo) r3;	 Catch:{ Exception -> 0x003d }
        r4 = r3.pid;	 Catch:{ Exception -> 0x003d }
        if (r4 != r2) goto L_0x0026;	 Catch:{ Exception -> 0x003d }
    L_0x0036:
        r0 = r3.processName;	 Catch:{ Exception -> 0x003d }
        b = r0;	 Catch:{ Exception -> 0x003d }
        r0 = r3.processName;	 Catch:{ Exception -> 0x003d }
        return r0;
    L_0x003d:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.auth.third.core.j.a.d():java.lang.String");
    }
}
