package com.xunlei.common.base;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import android.support.v4.content.ContextCompat;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.umeng.message.MsgConstant;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;

public final class XLPhoneInfo {
    public static int getProvidersName(Context context) {
        if (ContextCompat.checkSelfPermission(context, MsgConstant.PERMISSION_READ_PHONE_STATE) == 0) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return 5;
            }
            String subscriberId = telephonyManager.getSubscriberId();
            if (VERSION.SDK_INT >= 24) {
                int defaultDataSubscriptionId = SubscriptionManager.getDefaultDataSubscriptionId();
                if (defaultDataSubscriptionId != -1) {
                    subscriberId = telephonyManager.createForSubscriptionId(defaultDataSubscriptionId).getSubscriberId();
                }
            } else {
                subscriberId = telephonyManager.getSubscriberId();
            }
            if (subscriberId != null) {
                if (subscriberId.startsWith("46000") == null && subscriberId.startsWith("46002") == null && subscriberId.startsWith("46004") == null) {
                    if (subscriberId.startsWith("46007") == null) {
                        if (subscriberId.startsWith("46001") == null && subscriberId.startsWith("46006") == null) {
                            if (subscriberId.startsWith("46009") == null) {
                                if (subscriberId.startsWith("46003") == null) {
                                    if (subscriberId.startsWith("46005") == null) {
                                        return 4;
                                    }
                                }
                                return 3;
                            }
                        }
                        return 2;
                    }
                }
                return null;
            }
        }
        return 5;
    }

    public static int getNetworkType(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return 0;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            if (activeNetworkInfo.isAvailable()) {
                NetworkInfo networkInfo = connectivityManager.getNetworkInfo(1);
                if (networkInfo != null) {
                    State state = networkInfo.getState();
                    if (state != null && (state == State.CONNECTED || state == State.CONNECTING)) {
                        return 1;
                    }
                }
                context = connectivityManager.getNetworkInfo(0);
                if (context != null) {
                    State state2 = context.getState();
                    context = context.getSubtypeName();
                    if (state2 != null && (state2 == State.CONNECTED || state2 == State.CONNECTING)) {
                        switch (activeNetworkInfo.getSubtype()) {
                            case 1:
                            case 2:
                            case 4:
                            case 7:
                            case 11:
                                return 2;
                            case 3:
                            case 5:
                            case 6:
                            case 8:
                            case 9:
                            case 10:
                            case 12:
                            case 14:
                            case 15:
                                return 3;
                            case 13:
                                return 4;
                            default:
                                if (!(context.equalsIgnoreCase("TD-SCDMA") || context.equalsIgnoreCase("WCDMA"))) {
                                    if (context.equalsIgnoreCase("CDMA2000") == null) {
                                        return 5;
                                    }
                                }
                                return 3;
                        }
                    }
                }
                return 0;
            }
        }
        return 0;
    }

    public static String getMacAddress() {
        String str = "";
        String str2 = "02:00:00:00:00:00";
        try {
            LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(Runtime.getRuntime().exec("cat /sys/class/net/wlan0/address ").getInputStream()));
            while (str != null) {
                str = lineNumberReader.readLine();
                if (str != null) {
                    str2 = str.trim();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (str2 == null || "".equals(str2)) {
            try {
                return loadFileAsString("/sys/class/net/eth0/address").toUpperCase().substring(0, 17);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return str2;
    }

    private static String loadFileAsString(String str) throws Exception {
        Reader fileReader = new FileReader(str);
        str = loadReaderAsString(fileReader);
        fileReader.close();
        return str;
    }

    private static String loadReaderAsString(Reader reader) throws Exception {
        StringBuilder stringBuilder = new StringBuilder();
        char[] cArr = new char[4096];
        int read = reader.read(cArr);
        while (read >= 0) {
            stringBuilder.append(cArr, 0, read);
            read = reader.read(cArr);
        }
        return stringBuilder.toString();
    }

    public static String getDeviceMacInfo(Context context) {
        String str = "02:00:00:00:00:00";
        try {
            if (VERSION.SDK_INT < 23) {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager == null) {
                    return str;
                }
                context = wifiManager.getConnectionInfo().getMacAddress();
            } else {
                context = getMacAddress();
            }
            return context;
        } catch (Context context2) {
            context2.printStackTrace();
            return str;
        }
    }

    private static String getDeviceIMEIInfo(Context context) throws Exception {
        String str = "imei";
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (ContextCompat.checkSelfPermission(context, MsgConstant.PERMISSION_READ_PHONE_STATE) == null) {
                return telephonyManager.getDeviceId();
            }
            return str;
        } catch (Context context2) {
            context2.printStackTrace();
            return str;
        }
    }

    private static String getDeviceSerialInfo(Context context) {
        context = "sn";
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod("get", new Class[]{String.class}).invoke(cls, new Object[]{"ro.serialno"});
        } catch (Exception e) {
            e.printStackTrace();
            return context;
        }
    }

    private static String getDeviceAndroidIdInfo(Context context) {
        return Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
    }

    private static String getDeviceBuildInfo(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        context = context.getApplicationContext().getResources().getDisplayMetrics();
        stringBuilder.append(Build.FINGERPRINT);
        stringBuilder.append("|");
        stringBuilder.append(context.widthPixels);
        stringBuilder.append("#");
        stringBuilder.append(context.heightPixels);
        stringBuilder.append("#");
        stringBuilder.append(context.density);
        stringBuilder.append("#");
        stringBuilder.append(context.xdpi);
        stringBuilder.append("#");
        stringBuilder.append(context.ydpi);
        stringBuilder.append("#");
        return stringBuilder.toString();
    }
}
