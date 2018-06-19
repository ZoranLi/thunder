package com.umeng.message.common;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.provider.Settings.Secure;
import android.provider.Settings.System;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.qihoo360.replugin.RePlugin;
import com.ta.utdid2.device.UTDevice;
import com.tencent.tinker.loader.shareutil.ShareConstants;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.proguard.h;
import com.umeng.message.util.a;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.net.NetworkInterface;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import javax.microedition.khronos.opengles.GL10;

public class UmengMessageDeviceConfig {
    public static final int DEFAULT_TIMEZONE = 8;
    protected static final String a = "Unknown";
    private static final String b = "UmengMessageDeviceConfig";
    private static final String c = "2G/3G";
    private static final String d = "Wi-Fi";
    private static boolean e = false;

    final class AnonymousClass1 implements Runnable {
        final /* synthetic */ Context a;

        AnonymousClass1(Context context) {
            this.a = context;
        }

        public final void run() {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
            /*
            r6 = this;
            r0 = r6.a;	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
            r1 = "exid.dat";	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
            r0 = r0.openFileInput(r1);	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
            r1 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
            r1.<init>();	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
            r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
            r3 = new byte[r2];	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
        L_0x0011:
            r4 = r0.read(r3);	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
            r5 = -1;	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
            if (r4 == r5) goto L_0x001d;	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
        L_0x0018:
            r4 = 0;	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
            r1.write(r3, r4, r2);	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
            goto L_0x0011;	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
        L_0x001d:
            r2 = new java.lang.String;	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
            r3 = r1.toByteArray();	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
            r2.<init>(r3);	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
            r0.close();	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
            r1.close();	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
            r0 = new org.json.JSONObject;	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
            r0.<init>(r2);	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
            r1 = "umid";	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
            r2 = "";	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
            r0 = r0.optString(r1, r2);	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
            r1 = android.text.TextUtils.isEmpty(r0);	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
            if (r1 != 0) goto L_0x0051;	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
        L_0x003f:
            r1 = r6.a;	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
            r1 = com.umeng.message.MessageSharedPrefs.getInstance(r1);	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
            r1.setUmid(r0);	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
            r0 = r6.a;	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
            r0 = com.umeng.message.UTrack.getInstance(r0);	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
            r0.updateHeader();	 Catch:{ IOException -> 0x0052, IOException -> 0x0052 }
        L_0x0051:
            return;
        L_0x0052:
            r0 = com.umeng.message.common.UmengMessageDeviceConfig.b;
            r1 = "no umid";
            com.umeng.message.common.UmLog.i(r0, r1);
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.common.UmengMessageDeviceConfig.1.run():void");
        }
    }

    public static boolean isAppInstalled(java.lang.String r1, android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r2 = r2.getPackageManager();
        r0 = 1;
        r2.getPackageInfo(r1, r0);	 Catch:{ NameNotFoundException -> 0x0009 }
        goto L_0x000a;
    L_0x0009:
        r0 = 0;
    L_0x000a:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.common.UmengMessageDeviceConfig.isAppInstalled(java.lang.String, android.content.Context):boolean");
    }

    public static boolean isChinese(Context context) {
        return context.getResources().getConfiguration().locale.toString().equals(Locale.CHINA.toString());
    }

    public static boolean isScreenPortrait(Context context) {
        return context.getResources().getConfiguration().orientation == 1 ? true : null;
    }

    public static java.lang.String getAppVersionCode(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0014 }
        r2 = r2.getPackageName();	 Catch:{ NameNotFoundException -> 0x0014 }
        r1 = 0;	 Catch:{ NameNotFoundException -> 0x0014 }
        r2 = r0.getPackageInfo(r2, r1);	 Catch:{ NameNotFoundException -> 0x0014 }
        r2 = r2.versionCode;	 Catch:{ NameNotFoundException -> 0x0014 }
        r2 = java.lang.String.valueOf(r2);	 Catch:{ NameNotFoundException -> 0x0014 }
        return r2;
    L_0x0014:
        r2 = "Unknown";
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.common.UmengMessageDeviceConfig.getAppVersionCode(android.content.Context):java.lang.String");
    }

    public static java.lang.String getAppVersionName(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r2.getPackageManager();	 Catch:{ NameNotFoundException -> 0x0010 }
        r2 = r2.getPackageName();	 Catch:{ NameNotFoundException -> 0x0010 }
        r1 = 0;	 Catch:{ NameNotFoundException -> 0x0010 }
        r2 = r0.getPackageInfo(r2, r1);	 Catch:{ NameNotFoundException -> 0x0010 }
        r2 = r2.versionName;	 Catch:{ NameNotFoundException -> 0x0010 }
        return r2;
    L_0x0010:
        r2 = "Unknown";
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.common.UmengMessageDeviceConfig.getAppVersionName(android.content.Context):java.lang.String");
    }

    public static boolean checkPermission(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) != null ? null : true;
    }

    public static java.lang.String getAppLabel(android.content.Context r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r2.getPackageManager();
        r2 = r2.getPackageName();	 Catch:{ NameNotFoundException -> 0x000e }
        r1 = 0;	 Catch:{ NameNotFoundException -> 0x000e }
        r2 = r0.getApplicationInfo(r2, r1);	 Catch:{ NameNotFoundException -> 0x000e }
        goto L_0x000f;
    L_0x000e:
        r2 = 0;
    L_0x000f:
        if (r2 == 0) goto L_0x0016;
    L_0x0011:
        r2 = r0.getApplicationLabel(r2);
        goto L_0x0018;
    L_0x0016:
        r2 = "";
    L_0x0018:
        r2 = (java.lang.String) r2;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.common.UmengMessageDeviceConfig.getAppLabel(android.content.Context):java.lang.String");
    }

    public static String[] getGPU(GL10 gl10) {
        try {
            String[] strArr = new String[2];
            String glGetString = gl10.glGetString(7936);
            gl10 = gl10.glGetString(7937);
            strArr[0] = glGetString;
            strArr[1] = gl10;
            return strArr;
        } catch (GL10 gl102) {
            UmLog.e(b, "Could not read gpu infor:", gl102);
            return new String[0];
        }
    }

    public static String getCPU() {
        String readLine;
        Exception exception;
        String str = null;
        try {
            Reader fileReader = new FileReader("/proc/cpuinfo");
            try {
                BufferedReader bufferedReader = new BufferedReader(fileReader, 1024);
                readLine = bufferedReader.readLine();
                try {
                    bufferedReader.close();
                    fileReader.close();
                } catch (Exception e) {
                    exception = e;
                    str = readLine;
                    UmLog.e(b, "Could not read from file /proc/cpuinfo", exception);
                    readLine = str;
                    return readLine != null ? readLine : readLine.substring(readLine.indexOf(58) + 1).trim();
                } catch (Exception e2) {
                    exception = e2;
                    UmLog.e(b, "Could not open file /proc/cpuinfo", exception);
                    if (readLine != null) {
                    }
                }
            } catch (IOException e3) {
                exception = e3;
                UmLog.e(b, "Could not read from file /proc/cpuinfo", exception);
                readLine = str;
                if (readLine != null) {
                }
            }
        } catch (FileNotFoundException e4) {
            exception = e4;
            readLine = str;
            UmLog.e(b, "Could not open file /proc/cpuinfo", exception);
            if (readLine != null) {
            }
        }
        if (readLine != null) {
        }
    }

    public static String getDeviceId(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            UmLog.w(b, "No IMEI.");
        }
        String str = "";
        try {
            if (checkPermission(context, MsgConstant.PERMISSION_READ_PHONE_STATE)) {
                str = telephonyManager.getDeviceId();
            }
        } catch (Exception e) {
            UmLog.w(b, "No IMEI.", e);
        }
        if (TextUtils.isEmpty(str)) {
            UmLog.w(b, "No IMEI.");
            str = getMac(context);
            if (TextUtils.isEmpty(str)) {
                UmLog.w(b, "Failed to take mac as IMEI. Try to use Secure.ANDROID_ID instead.");
                str = Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
                context = b;
                StringBuilder stringBuilder = new StringBuilder("getDeviceId: Secure.ANDROID_ID: ");
                stringBuilder.append(str);
                UmLog.i(context, stringBuilder.toString());
                if (TextUtils.isEmpty(str) != null) {
                    UmLog.w(b, "Failed to take Secure.ANDROID_ID as IMEI. Try to use Serial_number instead.");
                    context = getSerial_number();
                    String str2 = b;
                    StringBuilder stringBuilder2 = new StringBuilder("getDeviceId: Serial_number: ");
                    stringBuilder2.append(context);
                    UmLog.i(str2, stringBuilder2.toString());
                    return context;
                }
            }
        }
        return str;
    }

    public static String getDIN(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            UmLog.w(b, "No IMEI.");
        }
        try {
            if (checkPermission(context, MsgConstant.PERMISSION_READ_PHONE_STATE) != null) {
                context = telephonyManager.getDeviceId();
                if (!TextUtils.isEmpty(context)) {
                    return context;
                }
            }
        } catch (Context context2) {
            UmLog.w(b, "No IMEI.", context2);
        }
        return "";
    }

    public static String getAndroidId(Context context) {
        context = System.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
        return context == null ? "" : context;
    }

    public static String getSerial_number() {
        String str = Build.SERIAL;
        return str == null ? "" : str;
    }

    public static String getDeviceIdUmengMD5(Context context) {
        return h.b(getDeviceId(context));
    }

    public static String getDeviceIdMD5(Context context) {
        return h.a(getDeviceId(context));
    }

    public static String getNetworkOperatorName(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return a;
            }
            return telephonyManager.getNetworkOperatorName();
        } catch (Context context2) {
            context2.printStackTrace();
            return a;
        }
    }

    public static String getDisplayResolution(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            context = displayMetrics.widthPixels;
            int i = displayMetrics.heightPixels;
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(String.valueOf(i));
            stringBuilder.append("*");
            stringBuilder.append(String.valueOf(context));
            return stringBuilder.toString();
        } catch (Context context2) {
            context2.printStackTrace();
            return a;
        }
    }

    public static java.lang.String[] getNetworkAccessMode(android.content.Context r5) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 2;
        r0 = new java.lang.String[r0];
        r1 = "Unknown";
        r2 = 0;
        r0[r2] = r1;
        r1 = "Unknown";
        r3 = 1;
        r0[r3] = r1;
        r1 = "connectivity";	 Catch:{ Exception -> 0x0044 }
        r5 = r5.getSystemService(r1);	 Catch:{ Exception -> 0x0044 }
        r5 = (android.net.ConnectivityManager) r5;	 Catch:{ Exception -> 0x0044 }
        if (r5 != 0) goto L_0x0018;	 Catch:{ Exception -> 0x0044 }
    L_0x0017:
        return r0;	 Catch:{ Exception -> 0x0044 }
    L_0x0018:
        r1 = r5.getNetworkInfo(r3);	 Catch:{ Exception -> 0x0044 }
        if (r1 == 0) goto L_0x002b;	 Catch:{ Exception -> 0x0044 }
    L_0x001e:
        r1 = r1.getState();	 Catch:{ Exception -> 0x0044 }
        r4 = android.net.NetworkInfo.State.CONNECTED;	 Catch:{ Exception -> 0x0044 }
        if (r1 != r4) goto L_0x002b;	 Catch:{ Exception -> 0x0044 }
    L_0x0026:
        r5 = "Wi-Fi";	 Catch:{ Exception -> 0x0044 }
        r0[r2] = r5;	 Catch:{ Exception -> 0x0044 }
        return r0;	 Catch:{ Exception -> 0x0044 }
    L_0x002b:
        r5 = r5.getNetworkInfo(r2);	 Catch:{ Exception -> 0x0044 }
        if (r5 == 0) goto L_0x0044;	 Catch:{ Exception -> 0x0044 }
    L_0x0031:
        r1 = r5.getState();	 Catch:{ Exception -> 0x0044 }
        r4 = android.net.NetworkInfo.State.CONNECTED;	 Catch:{ Exception -> 0x0044 }
        if (r1 != r4) goto L_0x0044;	 Catch:{ Exception -> 0x0044 }
    L_0x0039:
        r1 = "2G/3G";	 Catch:{ Exception -> 0x0044 }
        r0[r2] = r1;	 Catch:{ Exception -> 0x0044 }
        r5 = r5.getSubtypeName();	 Catch:{ Exception -> 0x0044 }
        r0[r3] = r5;	 Catch:{ Exception -> 0x0044 }
        return r0;
    L_0x0044:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.common.UmengMessageDeviceConfig.getNetworkAccessMode(android.content.Context):java.lang.String[]");
    }

    public static boolean isWiFiAvailable(Context context) {
        return "Wi-Fi".equals(getNetworkAccessMode(context)[0]);
    }

    public static Location getLocation(Context context) {
        try {
            LocationManager locationManager = (LocationManager) context.getSystemService("location");
            if (checkPermission(context, "android.permission.ACCESS_FINE_LOCATION")) {
                Location lastKnownLocation = locationManager.getLastKnownLocation("gps");
                if (lastKnownLocation != null) {
                    context = b;
                    StringBuilder stringBuilder = new StringBuilder("get location from gps:");
                    stringBuilder.append(lastKnownLocation.getLatitude());
                    stringBuilder.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    stringBuilder.append(lastKnownLocation.getLongitude());
                    UmLog.d(context, stringBuilder.toString());
                    return lastKnownLocation;
                }
            }
            if (checkPermission(context, "android.permission.ACCESS_COARSE_LOCATION") != null) {
                context = locationManager.getLastKnownLocation("network");
                if (context != null) {
                    String str = b;
                    StringBuilder stringBuilder2 = new StringBuilder("get location from network:");
                    stringBuilder2.append(context.getLatitude());
                    stringBuilder2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    stringBuilder2.append(context.getLongitude());
                    UmLog.d(str, stringBuilder2.toString());
                    return context;
                }
            }
            UmLog.d(b, "Could not get location from GPS or Cell-id, lack ACCESS_COARSE_LOCATION or ACCESS_COARSE_LOCATION permission?");
            return null;
        } catch (Context context2) {
            UmLog.e(b, context2.getMessage());
            return null;
        }
    }

    public static boolean isOnline(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = "connectivity";	 Catch:{ Exception -> 0x0015 }
        r1 = r1.getSystemService(r0);	 Catch:{ Exception -> 0x0015 }
        r1 = (android.net.ConnectivityManager) r1;	 Catch:{ Exception -> 0x0015 }
        r1 = r1.getActiveNetworkInfo();	 Catch:{ Exception -> 0x0015 }
        if (r1 == 0) goto L_0x0013;	 Catch:{ Exception -> 0x0015 }
    L_0x000e:
        r1 = r1.isConnectedOrConnecting();	 Catch:{ Exception -> 0x0015 }
        return r1;
    L_0x0013:
        r1 = 0;
        return r1;
    L_0x0015:
        r1 = 1;
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.common.UmengMessageDeviceConfig.isOnline(android.content.Context):boolean");
    }

    public static boolean isSdCardWrittenable() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static int getTimeZone(Context context) {
        try {
            context = Calendar.getInstance(a(context));
            if (context != null) {
                return context.getTimeZone().getRawOffset() / 3600000;
            }
        } catch (Context context2) {
            UmLog.i(b, "error in getTimeZone", context2);
        }
        return 8;
    }

    public static String[] getLocaleInfo(Context context) {
        String[] strArr = new String[2];
        try {
            context = a(context);
            if (context != null) {
                strArr[0] = context.getCountry();
                strArr[1] = context.getLanguage();
            }
            if (TextUtils.isEmpty(strArr[0]) != null) {
                strArr[0] = a;
            }
            if (TextUtils.isEmpty(strArr[1]) != null) {
                strArr[1] = a;
            }
            return strArr;
        } catch (Context context2) {
            UmLog.e(b, "error in getLocaleInfo", context2);
            return strArr;
        }
    }

    private static java.util.Locale a(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new android.content.res.Configuration;	 Catch:{ Exception -> 0x000f }
        r0.<init>();	 Catch:{ Exception -> 0x000f }
        r1 = r1.getContentResolver();	 Catch:{ Exception -> 0x000f }
        android.provider.Settings.System.getConfiguration(r1, r0);	 Catch:{ Exception -> 0x000f }
        r1 = r0.locale;	 Catch:{ Exception -> 0x000f }
        goto L_0x0017;
    L_0x000f:
        r1 = b;
        r0 = "fail to read user config locale";
        com.umeng.message.common.UmLog.e(r1, r0);
        r1 = 0;
    L_0x0017:
        if (r1 != 0) goto L_0x001d;
    L_0x0019:
        r1 = java.util.Locale.getDefault();
    L_0x001d:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.common.UmengMessageDeviceConfig.a(android.content.Context):java.util.Locale");
    }

    public static String getAppkey(Context context) {
        return getMetaData(context, "UMENG_APPKEY");
    }

    public static String getMetaData(Context context, String str) {
        try {
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (context != null) {
                context = context.metaData.getString(str);
                if (context != null) {
                    return context.trim();
                }
            }
        } catch (Context context2) {
            context2.printStackTrace();
        }
        UmLog.e(b, String.format("Could not read meta-data %s from AndroidManifest.xml.", new Object[]{str}));
        return null;
    }

    public static String getMac(Context context) {
        if (VERSION.SDK_INT <= 22) {
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (checkPermission(context, MsgConstant.PERMISSION_ACCESS_WIFI_STATE) != null) {
                    return wifiManager.getConnectionInfo().getMacAddress();
                }
                UmLog.w(b, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
            } catch (Context context2) {
                String str = b;
                StringBuilder stringBuilder = new StringBuilder("Could not get mac address.");
                stringBuilder.append(context2.toString());
                UmLog.w(str, stringBuilder.toString());
            }
        } else {
            try {
                for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                    if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                        context2 = networkInterface.getHardwareAddress();
                        if (context2 == null) {
                            return "";
                        }
                        StringBuilder stringBuilder2 = new StringBuilder();
                        int length = context2.length;
                        for (int i = 0; i < length; i++) {
                            stringBuilder2.append(String.format("%02X:", new Object[]{Byte.valueOf(context2[i])}));
                        }
                        if (stringBuilder2.length() > null) {
                            stringBuilder2.deleteCharAt(stringBuilder2.length() - 1);
                        }
                        return stringBuilder2.toString();
                    }
                }
            } catch (Context context22) {
                context22.printStackTrace();
            }
        }
        return "";
    }

    public static String getUmid(Context context) {
        Object umid = MessageSharedPrefs.getInstance(context).getUmid();
        if (!TextUtils.isEmpty(umid)) {
            return umid;
        }
        if (!e) {
            e = true;
            new Thread(new AnonymousClass1(context)).start();
        }
        return "";
    }

    public static String getResolution(Context context) {
        try {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
            int i = 0;
            if ((context.getApplicationInfo().flags & 8192) == null) {
                context = a(displayMetrics, "noncompatWidthPixels");
                i = a(displayMetrics, "noncompatHeightPixels");
            } else {
                context = -1;
            }
            if (context == -1 || r1 == -1) {
                context = displayMetrics.widthPixels;
                i = displayMetrics.heightPixels;
            }
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(context);
            stringBuffer.append("*");
            stringBuffer.append(i);
            return stringBuffer.toString();
        } catch (Context context2) {
            UmLog.e(b, "read resolution fail", context2);
            return a;
        }
    }

    private static int a(Object obj, String str) {
        try {
            str = DisplayMetrics.class.getDeclaredField(str);
            if (str != null) {
                str.setAccessible(true);
                return str.getInt(obj);
            }
        } catch (Object obj2) {
            obj2.printStackTrace();
        }
        return -1;
    }

    public static String getOperator(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getNetworkOperatorName();
        } catch (Context context2) {
            UmLog.i(b, "read carrier fail", context2);
            return a;
        }
    }

    public static String getTimeString(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US).format(date);
    }

    public static String getToday() {
        return new SimpleDateFormat("yyyy-MM-dd", Locale.US).format(new Date());
    }

    public static java.util.Date toTime(java.lang.String r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.text.SimpleDateFormat;	 Catch:{ Exception -> 0x000c }
        r1 = "yyyy-MM-dd HH:mm:ss";	 Catch:{ Exception -> 0x000c }
        r0.<init>(r1);	 Catch:{ Exception -> 0x000c }
        r2 = r0.parse(r2);	 Catch:{ Exception -> 0x000c }
        return r2;
    L_0x000c:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.common.UmengMessageDeviceConfig.toTime(java.lang.String):java.util.Date");
    }

    public static int getIntervalSeconds(Date date, Date date2) {
        if (date.after(date2)) {
            Date date3 = date2;
            date2 = date;
            date = date3;
        }
        return (int) ((date2.getTime() - date.getTime()) / 1000);
    }

    public static String getChannel(Context context) {
        String str = a;
        try {
            context = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (!(context == null || context.metaData == null)) {
                context = context.metaData.get("UMENG_CHANNEL");
                if (context != null) {
                    context = context.toString();
                    if (context != null) {
                        return context;
                    }
                    UmLog.i(b, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
                }
            }
        } catch (Context context2) {
            UmLog.i(b, "Could not read UMENG_CHANNEL meta-data from AndroidManifest.xml.");
            context2.printStackTrace();
        }
        return str;
    }

    public static String getPackageName(Context context) {
        return context.getPackageName();
    }

    public static String getApplicationLable(Context context) {
        return context.getPackageManager().getApplicationLabel(context.getApplicationInfo()).toString();
    }

    public static boolean isDebug(android.content.Context r1) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = r1.getApplicationInfo();	 Catch:{ Exception -> 0x000e }
        r1 = r1.flags;	 Catch:{ Exception -> 0x000e }
        r1 = r1 & 2;
        if (r1 == 0) goto L_0x000d;
    L_0x000b:
        r1 = 1;
        return r1;
    L_0x000d:
        return r0;
    L_0x000e:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.common.UmengMessageDeviceConfig.isDebug(android.content.Context):boolean");
    }

    public static String getUtdid(Context context) {
        try {
            return UTDevice.getUtdid(context);
        } catch (Context context2) {
            String str = b;
            StringBuilder stringBuilder = new StringBuilder("fail to get utdid. ");
            stringBuilder.append(context2.getMessage());
            UmLog.e(str, stringBuilder.toString());
            return "";
        }
    }

    public static boolean isServiceWork(Context context, String str, String str2) {
        context = ((ActivityManager) context.getSystemService("activity")).getRunningServices(Integer.MAX_VALUE);
        boolean z = false;
        if (context.size() <= 0) {
            return false;
        }
        for (int i = 0; i < context.size(); i++) {
            String str3 = ((RunningServiceInfo) context.get(i)).service.getClassName().toString();
            String str4 = ((RunningServiceInfo) context.get(i)).service.getPackageName().toString();
            if (str3.equals(str) && str4.equals(str2)) {
                z = true;
                break;
            }
        }
        return z;
    }

    public static boolean isIntentExist(Context context, String str, String str2) {
        context = context.getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(str)), 0);
        if (context.isEmpty()) {
            return false;
        }
        for (int i = 0; i < context.size(); i++) {
            if (((ResolveInfo) context.get(i)).activityInfo.packageName.equalsIgnoreCase(str2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean getDataData(String str) {
        StringBuilder stringBuilder = new StringBuilder("/data/app/");
        stringBuilder.append(str);
        stringBuilder.append("-1.apk");
        boolean exists = new File(stringBuilder.toString()).exists();
        if (!exists) {
            stringBuilder = new StringBuilder("/data/app/");
            stringBuilder.append(str);
            stringBuilder.append("-2.apk");
            exists = new File(stringBuilder.toString()).exists();
        }
        if (!exists) {
            stringBuilder = new StringBuilder("/data/app/");
            stringBuilder.append(str);
            stringBuilder.append(ShareConstants.PATCH_SUFFIX);
            exists = new File(stringBuilder.toString()).exists();
        }
        if (!exists) {
            stringBuilder = new StringBuilder("/data/app/");
            stringBuilder.append(str);
            stringBuilder.append(RePlugin.PROCESS_UI);
            exists = new File(stringBuilder.toString()).exists();
        }
        if (exists) {
            return exists;
        }
        stringBuilder = new StringBuilder("/data/app/");
        stringBuilder.append(str);
        stringBuilder.append(RePlugin.PROCESS_PERSIST);
        return new File(stringBuilder.toString()).exists();
    }

    public static boolean isMIUI() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = 0;
        r1 = com.umeng.message.util.a.g();	 Catch:{ IOException -> 0x0022 }
        r2 = "ro.miui.ui.version.code";	 Catch:{ IOException -> 0x0022 }
        r3 = 0;	 Catch:{ IOException -> 0x0022 }
        r2 = r1.a(r2, r3);	 Catch:{ IOException -> 0x0022 }
        if (r2 != 0) goto L_0x0020;	 Catch:{ IOException -> 0x0022 }
    L_0x000e:
        r2 = "ro.miui.ui.version.name";	 Catch:{ IOException -> 0x0022 }
        r2 = r1.a(r2, r3);	 Catch:{ IOException -> 0x0022 }
        if (r2 != 0) goto L_0x0020;	 Catch:{ IOException -> 0x0022 }
    L_0x0016:
        r2 = "ro.miui.internal.storage";	 Catch:{ IOException -> 0x0022 }
        r1 = r1.a(r2, r3);	 Catch:{ IOException -> 0x0022 }
        if (r1 == 0) goto L_0x001f;
    L_0x001e:
        goto L_0x0020;
    L_0x001f:
        return r0;
    L_0x0020:
        r0 = 1;
        return r0;
    L_0x0022:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.message.common.UmengMessageDeviceConfig.isMIUI():boolean");
    }

    public static boolean isMiui8() {
        try {
            String a = a.g().a("ro.miui.ui.version.name");
            if (a == null || !a.contains("8")) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
