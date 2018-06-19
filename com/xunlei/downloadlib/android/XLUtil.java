package com.xunlei.downloadlib.android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Base64;
import java.net.NetworkInterface;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.json.JSONObject;

public class XLUtil {
    private static final String a = "XLUtil";
    private static final int b = 15;
    private static final a c = new a();

    public enum GUID_TYPE {
        DEFAULT,
        JUST_IMEI,
        JUST_MAC,
        d
    }

    public static class GuidInfo {
        public GUID_TYPE a = GUID_TYPE.DEFAULT;
        public String b = null;
    }

    public enum NetWorkCarrier {
        a,
        CMCC,
        CU,
        d
    }

    static class a {
        private static final String a = "Identify.txt";
        private Map<String, String> b;
        private ReadWriteLock c;

        private a() {
            this.b = new HashMap();
            this.c = new ReentrantReadWriteLock();
        }

        String a(Context context, String str, String str2) {
            this.c.readLock().lock();
            String str3 = (String) this.b.get(str);
            if (str3 == null) {
                a(context);
                str3 = (String) this.b.get(str);
            }
            this.c.readLock().unlock();
            return str3 != null ? str3 : str2;
        }

        void b(Context context, String str, String str2) {
            this.c.writeLock().lock();
            this.b.put(str, str2);
            b(context);
            this.c.writeLock().unlock();
            context = XLUtil.a;
            StringBuilder stringBuilder = new StringBuilder("ConfigFile set key=");
            stringBuilder.append(str);
            stringBuilder.append(" value=");
            stringBuilder.append(str2);
            XLLog.i(context, stringBuilder.toString());
        }

        private void a(Context context) {
            XLLog.i(XLUtil.a, "loadAndParseFile start");
            if (context != null) {
                if (a != null) {
                    context = a(context, a);
                    if (context == null) {
                        XLLog.i(XLUtil.a, "loadAndParseFile end, fileContext is empty");
                        return;
                    }
                    this.b.clear();
                    context = context.split("\n");
                    for (String split : context) {
                        String[] split2 = split.split("=");
                        if (split2.length == 2) {
                            this.b.put(split2[0], split2[1]);
                            String str = XLUtil.a;
                            StringBuilder stringBuilder = new StringBuilder("ConfigFile loadFile key=");
                            stringBuilder.append(split2[0]);
                            stringBuilder.append(" value=");
                            stringBuilder.append(split2[1]);
                            XLLog.i(str, stringBuilder.toString());
                        }
                    }
                    XLLog.i(XLUtil.a, "loadAndParseFile end");
                    return;
                }
            }
            XLLog.e(XLUtil.a, "loadAndParseFile end, parameter invalid, fileName:Identify.txt");
        }

        private void b(Context context) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Entry entry : this.b.entrySet()) {
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append((String) entry.getKey());
                stringBuilder2.append("=");
                stringBuilder2.append((String) entry.getValue());
                stringBuilder2.append("\n");
                stringBuilder.append(stringBuilder2.toString());
            }
            c(context, stringBuilder.toString(), a);
        }

        private void c(Context context, String str, String str2) {
            if (!(context == null || str == null)) {
                if (str2 != null) {
                    try {
                        context = context.openFileOutput(str2, 0);
                        try {
                            context.write(str.getBytes("utf-8"));
                            context.close();
                            return;
                        } catch (Context context2) {
                            context2.printStackTrace();
                            return;
                        } catch (Context context22) {
                            context22.printStackTrace();
                            return;
                        }
                    } catch (Context context222) {
                        context222.printStackTrace();
                        return;
                    }
                }
            }
            context222 = XLUtil.a;
            str = new StringBuilder("writeToFile, Parameter invalid, fileName:");
            str.append(str2);
            XLLog.e(context222, str.toString());
        }

        private java.lang.String a(android.content.Context r7, java.lang.String r8) {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r6 = this;
            r0 = 0;
            if (r7 == 0) goto L_0x003d;
        L_0x0003:
            if (r8 != 0) goto L_0x0006;
        L_0x0005:
            goto L_0x003d;
        L_0x0006:
            r7 = r7.openFileInput(r8);	 Catch:{ FileNotFoundException -> 0x0026 }
            r1 = 256; // 0x100 float:3.59E-43 double:1.265E-321;	 Catch:{ FileNotFoundException -> 0x0026 }
            r1 = new byte[r1];	 Catch:{ FileNotFoundException -> 0x0026 }
            r2 = r7.read(r1);	 Catch:{ IOException -> 0x0021 }
            if (r2 <= 0) goto L_0x001d;	 Catch:{ IOException -> 0x0021 }
        L_0x0014:
            r3 = new java.lang.String;	 Catch:{ IOException -> 0x0021 }
            r4 = 0;	 Catch:{ IOException -> 0x0021 }
            r5 = "utf-8";	 Catch:{ IOException -> 0x0021 }
            r3.<init>(r1, r4, r2, r5);	 Catch:{ IOException -> 0x0021 }
            r0 = r3;	 Catch:{ IOException -> 0x0021 }
        L_0x001d:
            r7.close();	 Catch:{ IOException -> 0x0021 }
            goto L_0x003c;
        L_0x0021:
            r7 = move-exception;
            r7.printStackTrace();	 Catch:{ FileNotFoundException -> 0x0026 }
            goto L_0x003c;
        L_0x0026:
            r7 = "XLUtil";
            r1 = new java.lang.StringBuilder;
            r1.<init>();
            r1.append(r8);
            r8 = " File Not Found";
            r1.append(r8);
            r8 = r1.toString();
            com.xunlei.downloadlib.android.XLLog.i(r7, r8);
        L_0x003c:
            return r0;
        L_0x003d:
            r7 = "XLUtil";
            r1 = new java.lang.StringBuilder;
            r2 = "readFromFile, parameter invalid, fileName:";
            r1.<init>(r2);
            r1.append(r8);
            r8 = r1.toString();
            com.xunlei.downloadlib.android.XLLog.e(r7, r8);
            return r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadlib.android.XLUtil.a.a(android.content.Context, java.lang.String):java.lang.String");
        }
    }

    public static long getCurrentUnixTime() {
        return System.currentTimeMillis() / 1000;
    }

    public static String getPeerid(Context context) {
        if (context == null) {
            return null;
        }
        String a = c.a(context, "peerid", null);
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        Object mac = getMAC(context);
        StringBuilder stringBuilder;
        if (TextUtils.isEmpty(mac)) {
            mac = getIMEI(context);
            if (!TextUtils.isEmpty(mac)) {
                stringBuilder = new StringBuilder();
                stringBuilder.append(mac);
                stringBuilder.append("V");
                a = stringBuilder.toString();
            }
        } else {
            stringBuilder = new StringBuilder();
            stringBuilder.append(mac);
            stringBuilder.append("004V");
            a = stringBuilder.toString();
        }
        if (TextUtils.isEmpty(a)) {
            return null;
        }
        c.b(context, "peerid", a);
        return a;
    }

    public static String getMAC(Context context) {
        if (context == null) {
            return null;
        }
        Object a = c.a(context, "MAC", null);
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        String wifiMacAddress = getWifiMacAddress();
        if (!TextUtils.isEmpty(wifiMacAddress)) {
            c.b(context, "MAC", wifiMacAddress);
        }
        return wifiMacAddress;
    }

    @SuppressLint({"NewApi"})
    public static String getWifiMacAddress() {
        try {
            String str = "wlan0";
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase(str)) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return null;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(hardwareAddress[i])}));
                    }
                    return stringBuilder.toString();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getIMEI(Context context) {
        if (context == null) {
            return null;
        }
        String a = c.a(context, "IMEI", null);
        if (!TextUtils.isEmpty(a)) {
            return a;
        }
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            try {
                String deviceId = telephonyManager.getDeviceId();
                if (deviceId != null) {
                    try {
                        if (deviceId.length() < 15) {
                            int length = 15 - deviceId.length();
                            while (true) {
                                int i = length - 1;
                                if (length <= 0) {
                                    break;
                                }
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(deviceId);
                                stringBuilder.append("M");
                                deviceId = stringBuilder.toString();
                                length = i;
                            }
                        }
                        c.b(context, "IMEI", deviceId);
                    } catch (Exception e) {
                        context = e;
                        a = deviceId;
                        context.printStackTrace();
                        return a;
                    }
                }
                a = deviceId;
            } catch (Exception e2) {
                context = e2;
                context.printStackTrace();
                return a;
            }
        }
        return a;
    }

    public static GuidInfo generateGuid(Context context) {
        GuidInfo guidInfo = new GuidInfo();
        GUID_TYPE guid_type = GUID_TYPE.DEFAULT;
        String imei = getIMEI(context);
        if (TextUtils.isEmpty(imei)) {
            imei = "000000000000000";
        } else {
            guid_type = GUID_TYPE.JUST_IMEI;
        }
        context = getMAC(context);
        if (TextUtils.isEmpty(context)) {
            context = "000000000000";
        } else if (guid_type == GUID_TYPE.JUST_IMEI) {
            guid_type = GUID_TYPE.d;
        } else {
            guid_type = GUID_TYPE.JUST_MAC;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(imei);
        stringBuilder.append("_");
        stringBuilder.append(context);
        guidInfo.b = stringBuilder.toString();
        guidInfo.a = guid_type;
        return guidInfo;
    }

    public static String getOSVersion(Context context) {
        context = new StringBuilder();
        StringBuilder stringBuilder = new StringBuilder("SDKV = ");
        stringBuilder.append(VERSION.RELEASE);
        context.append(stringBuilder.toString());
        stringBuilder = new StringBuilder("_MANUFACTURER = ");
        stringBuilder.append(Build.MANUFACTURER);
        context.append(stringBuilder.toString());
        stringBuilder = new StringBuilder("_MODEL = ");
        stringBuilder.append(Build.MODEL);
        context.append(stringBuilder.toString());
        stringBuilder = new StringBuilder("_PRODUCT = ");
        stringBuilder.append(Build.PRODUCT);
        context.append(stringBuilder.toString());
        stringBuilder = new StringBuilder("_FINGERPRINT = ");
        stringBuilder.append(Build.FINGERPRINT);
        context.append(stringBuilder.toString());
        stringBuilder = new StringBuilder("_CPU_ABI = ");
        stringBuilder.append(Build.CPU_ABI);
        context.append(stringBuilder.toString());
        stringBuilder = new StringBuilder("_ID = ");
        stringBuilder.append(Build.ID);
        context.append(stringBuilder.toString());
        return context.toString();
    }

    public static String getAPNName(Context context) {
        if (context == null) {
            return null;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return null;
        }
        context = connectivityManager.getNetworkInfo(0);
        if (context == null) {
            return null;
        }
        return context.getExtraInfo();
    }

    public static String getSSID(Context context) {
        if (context == null) {
            XLLog.e(a, "getSSID, context invalid");
            return null;
        }
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager != null) {
            context = wifiManager.getConnectionInfo();
            if (context != null) {
                return context.getSSID();
            }
        }
        return null;
    }

    public static java.lang.String getBSSID(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        if (r2 != 0) goto L_0x000b;
    L_0x0003:
        r2 = "XLUtil";
        r1 = "getBSSID, context invalid";
        com.xunlei.downloadlib.android.XLLog.e(r2, r1);
        return r0;
    L_0x000b:
        r1 = "wifi";
        r2 = r2.getSystemService(r1);
        r2 = (android.net.wifi.WifiManager) r2;
        if (r2 == 0) goto L_0x0020;
    L_0x0015:
        r2 = r2.getConnectionInfo();	 Catch:{ Exception -> 0x0020 }
        if (r2 == 0) goto L_0x0020;	 Catch:{ Exception -> 0x0020 }
    L_0x001b:
        r2 = r2.getBSSID();	 Catch:{ Exception -> 0x0020 }
        return r2;
    L_0x0020:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xunlei.downloadlib.android.XLUtil.getBSSID(android.content.Context):java.lang.String");
    }

    public static int getNetworkTypeComplete(Context context) {
        int i = 0;
        if (context == null) {
            XLLog.e(a, "getNetworkTypeComplete, context invalid");
            return 0;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager != null) {
            context = connectivityManager.getActiveNetworkInfo();
            if (context != null) {
                int type = context.getType();
                if (type == 1) {
                    i = 9;
                } else if (type == 0) {
                    switch (context.getSubtype()) {
                        case 1:
                        case 2:
                        case 4:
                        case 7:
                        case 11:
                            i = 2;
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
                            i = 3;
                            break;
                        case 13:
                            i = 4;
                            break;
                        default:
                            break;
                    }
                } else {
                    i = 5;
                }
            }
        }
        return i;
    }

    public static int getNetworkTypeSimple(Context context) {
        if (context == null) {
            XLLog.e(a, "getNetworkTypeSimple, context invalid");
            return null;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        int i = 1;
        if (connectivityManager != null) {
            context = connectivityManager.getActiveNetworkInfo();
            if (context != null) {
                int type = context.getType();
                if (type != 1) {
                    if (type == 0) {
                        switch (context.getSubtype()) {
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                            case 10:
                            case 11:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                                i = 3;
                                break;
                            default:
                                break;
                        }
                    }
                }
                i = 2;
            }
        }
        return i;
    }

    public static String getMd5(String str) {
        if (str == null) {
            XLLog.e(a, "getMd5, key invalid");
            return null;
        }
        try {
            char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
            MessageDigest instance = MessageDigest.getInstance("MD5");
            byte[] bytes = str.getBytes();
            int i = 0;
            instance.update(bytes, 0, bytes.length);
            byte[] digest = instance.digest();
            StringBuilder stringBuilder = new StringBuilder(32);
            int length = digest.length;
            while (i < length) {
                byte b = digest[i];
                stringBuilder.append(cArr[(b >> 4) & 15]);
                stringBuilder.append(cArr[(b >> 0) & 15]);
                i++;
            }
            str = stringBuilder.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return str;
    }

    public static String generateAppKey(String str, short s, byte b) {
        if (str == null) {
            XLLog.e(a, "generateAppKey, appName invalid");
            return null;
        }
        int length = str.length();
        int i = length + 1;
        byte[] bArr = new byte[((i + 2) + 1)];
        str = str.getBytes();
        for (int i2 = 0; i2 < str.length; i2++) {
            bArr[i2] = str[i2];
        }
        bArr[length] = (byte) 0;
        bArr[i] = (byte) (s & 255);
        bArr[length + 2] = (byte) ((s >> 8) & 255);
        bArr[length + 3] = b;
        return new String(Base64.encode(bArr, 0)).trim();
    }

    public static Map<String, Object> parseJSONString(String str) {
        if (str == null) {
            XLLog.e(a, "parseJSONString, JSONString invalid");
            return null;
        }
        Map<String, Object> hashMap = new HashMap();
        try {
            JSONObject jSONObject = new JSONObject(str);
            str = jSONObject.keys();
            while (str.hasNext()) {
                String str2 = (String) str.next();
                hashMap.put(str2, jSONObject.getString(str2));
            }
        } catch (String str3) {
            str3.printStackTrace();
        }
        return hashMap;
    }

    public static NetWorkCarrier getNetWorkCarrier(Context context) {
        if (context != null) {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager != null) {
                try {
                    context = telephonyManager.getSubscriberId();
                    if (!context.startsWith("46000")) {
                        if (!context.startsWith("46002")) {
                            if (context.startsWith("46001")) {
                                return NetWorkCarrier.CU;
                            }
                            if (context.startsWith("46003") != null) {
                                return NetWorkCarrier.d;
                            }
                        }
                    }
                    return NetWorkCarrier.CMCC;
                } catch (Context context2) {
                    context2.printStackTrace();
                }
            }
        }
        return NetWorkCarrier.a;
    }
}
