package com.xunlei.xllib.android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import anet.channel.util.ErrorConstant;
import com.ta.utdid2.android.utils.NetworkUtils;
import com.taobao.accs.utl.UtilityImpl;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/* compiled from: NetworkHelper */
public abstract class b {

    /* compiled from: NetworkHelper */
    public static class a {
        public static String a(Context context) {
            String str = "未知";
            try {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                String subscriberId = telephonyManager.getSubscriberId();
                if (subscriberId == null) {
                    if (5 == telephonyManager.getSimState()) {
                        context = telephonyManager.getSimOperator();
                        if (context != null) {
                            if (!(context.equals("46000") || context.equals("46002"))) {
                                if (!context.equals("46007")) {
                                    if (context.equals("46001")) {
                                        return "中国联通";
                                    }
                                    if (context.equals("46003") != null) {
                                        context = "中国电信";
                                    }
                                }
                            }
                            return "中国移动";
                        }
                    }
                    return str;
                }
                if (subscriberId.startsWith("46000") == null && subscriberId.startsWith("46002") == null) {
                    if (subscriberId.startsWith("46007") == null) {
                        if (subscriberId.startsWith("46001") != null) {
                            return "中国联通";
                        }
                        if (subscriberId.startsWith("46003") != null) {
                            context = "中国电信";
                        }
                        return str;
                    }
                }
                return "中国移动";
                str = context;
            } catch (Context context2) {
                context2.printStackTrace();
            }
            return str;
        }

        public static String b(Context context) {
            context = c(context);
            String str = "未知";
            if (context == -101) {
                return NetworkUtils.WIFI;
            }
            switch (context) {
                case -1:
                    return "无";
                case null:
                    return "未知";
                case 1:
                    return "2G";
                case 2:
                    return "3G";
                case 3:
                    return "4G";
                default:
                    return str;
            }
        }

        private static int c(Context context) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.isConnected()) {
                    int type = activeNetworkInfo.getType();
                    if (type == 1) {
                        context = -101;
                    } else {
                        if (type == 0) {
                            context = ((TelephonyManager) context.getSystemService("phone")).getNetworkType();
                        }
                        context = null;
                    }
                    if (context != -101) {
                        return ErrorConstant.ERROR_EXCEPTION;
                    }
                    if (context != -1) {
                        return -1;
                    }
                    switch (context) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            return 1;
                        case 3:
                        case 5:
                        case 6:
                        case 8:
                        case 9:
                        case 10:
                        case 12:
                        case 14:
                        case 15:
                            return 2;
                        case 13:
                            return 3;
                        default:
                            return 0;
                    }
                }
                context = -1;
                if (context != -101) {
                    return ErrorConstant.ERROR_EXCEPTION;
                }
                if (context != -1) {
                    return -1;
                }
                switch (context) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        return 1;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        return 2;
                    case 13:
                        return 3;
                    default:
                        return 0;
                }
            } catch (Context context2) {
                context2.printStackTrace();
            }
        }
    }

    public static boolean a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        context = connectivityManager.getActiveNetworkInfo();
        if (context == null || !context.isConnected() || context.isAvailable() == null) {
            return false;
        }
        return true;
    }

    @SuppressLint({"DefaultLocale"})
    public static String b(Context context) {
        String str = "null";
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return str;
        }
        context = connectivityManager.getActiveNetworkInfo();
        if (context == null) {
            return str;
        }
        if (context.getTypeName() != null) {
            str = context.getTypeName().toLowerCase();
            if (!str.equals("wifi")) {
                if (context.getExtraInfo() != null) {
                    str = context.getExtraInfo().toLowerCase();
                }
                if (str.equals("#777") && context.getSubtypeName() != null) {
                    str = context.getSubtypeName();
                }
            }
        }
        return str;
    }

    public static String c(Context context) {
        String str = "null";
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return str;
        }
        NetworkInfo networkInfo = connectivityManager.getNetworkInfo(0);
        NetworkInfo networkInfo2 = connectivityManager.getNetworkInfo(1);
        if (networkInfo != null && networkInfo.isConnected()) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                switch (telephonyManager.getNetworkType()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                        str = UtilityImpl.NET_TYPE_2G;
                        break;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                        str = UtilityImpl.NET_TYPE_3G;
                        break;
                    case 13:
                        str = UtilityImpl.NET_TYPE_4G;
                        break;
                    default:
                        str = "null";
                        break;
                }
            }
        }
        if (!(networkInfo2 == null || networkInfo2.isConnected() == null)) {
            str = "wifi";
        }
        return str;
    }

    public static boolean d(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            context = connectivityManager.getActiveNetworkInfo();
            if (context != null) {
                context = context.getType();
                if (context != null) {
                    switch (context) {
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                            break;
                        default:
                            context = null;
                            break;
                    }
                }
                context = 1;
                if (context != null) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean e(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "connectivity";
        r1 = r1.getSystemService(r0);
        r1 = (android.net.ConnectivityManager) r1;
        r0 = 0;
        if (r1 == 0) goto L_0x0019;
    L_0x000b:
        r1 = r1.getNetworkInfo(r0);	 Catch:{ Exception -> 0x0019 }
        if (r1 == 0) goto L_0x0019;	 Catch:{ Exception -> 0x0019 }
    L_0x0011:
        r1 = r1.isConnectedOrConnecting();	 Catch:{ Exception -> 0x0019 }
        if (r1 == 0) goto L_0x0019;
    L_0x0017:
        r1 = 1;
        return r1;
    L_0x0019:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.xllib.android.b.e(android.content.Context):boolean");
    }

    public static boolean f(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            try {
                context = connectivityManager.getNetworkInfo(1);
                if (!(context == null || context.isConnectedOrConnecting() == null)) {
                    return true;
                }
            } catch (Context context2) {
                context2.printStackTrace();
            }
        }
        return null;
    }

    public static String g(Context context) {
        Enumeration inetAddresses;
        InetAddress inetAddress;
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager != null) {
            context = wifiManager.getDhcpInfo();
            if (context != null) {
                context = context.ipAddress;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(context & 255);
                stringBuilder.append(".");
                stringBuilder.append((context >> 8) & 255);
                stringBuilder.append(".");
                stringBuilder.append((context >> 16) & 255);
                stringBuilder.append(".");
                stringBuilder.append((context >> 24) & 255);
                context = stringBuilder.toString();
                if (!TextUtils.isEmpty(context)) {
                    return context;
                }
                context = null;
                try {
                    context = NetworkInterface.getNetworkInterfaces();
                } catch (SocketException e) {
                    e.printStackTrace();
                }
                if (context != null) {
                    while (context.hasMoreElements()) {
                        inetAddresses = ((NetworkInterface) context.nextElement()).getInetAddresses();
                        if (VERSION.SDK_INT <= 14) {
                            while (inetAddresses != null && inetAddresses.hasMoreElements()) {
                                inetAddress = (InetAddress) inetAddresses.nextElement();
                                if (inetAddress.isLoopbackAddress() && (inetAddress instanceof Inet4Address)) {
                                    return inetAddress.getHostAddress();
                                }
                            }
                        } else {
                            while (inetAddresses != null && inetAddresses.hasMoreElements()) {
                                inetAddress = (InetAddress) inetAddresses.nextElement();
                                if (!inetAddress.isLoopbackAddress()) {
                                    return inetAddress.getHostAddress();
                                }
                            }
                        }
                    }
                }
                return "";
            }
        }
        context = "";
        if (!TextUtils.isEmpty(context)) {
            return context;
        }
        context = null;
        context = NetworkInterface.getNetworkInterfaces();
        if (context != null) {
            while (context.hasMoreElements()) {
                inetAddresses = ((NetworkInterface) context.nextElement()).getInetAddresses();
                if (VERSION.SDK_INT <= 14) {
                    while (inetAddresses != null) {
                        inetAddress = (InetAddress) inetAddresses.nextElement();
                        if (inetAddress.isLoopbackAddress()) {
                            return inetAddress.getHostAddress();
                        }
                    }
                    continue;
                } else {
                    while (inetAddresses != null) {
                        inetAddress = (InetAddress) inetAddresses.nextElement();
                        if (inetAddress.isLoopbackAddress()) {
                        }
                    }
                    continue;
                }
            }
        }
        return "";
    }
}
