package com.taobao.applink.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Random;

@TargetApi(9)
public class d {
    private static String a = "";
    private static String b = "";
    private static String c = "";

    private static String a() {
        StringBuffer stringBuffer = new StringBuffer();
        long currentTimeMillis = System.currentTimeMillis();
        String l = Long.toString(currentTimeMillis);
        stringBuffer.append(l.substring(l.length() - 5));
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(Build.MODEL.replaceAll(" ", ""));
        while (stringBuffer2.length() < 6) {
            stringBuffer2.append('0');
        }
        stringBuffer.append(stringBuffer2.substring(0, 6));
        Random random = new Random(currentTimeMillis);
        currentTimeMillis = 0;
        while (currentTimeMillis < 4096) {
            currentTimeMillis = random.nextLong();
        }
        stringBuffer.append(Long.toHexString(currentTimeMillis).substring(0, 4));
        return stringBuffer.toString();
    }

    public static String a(Context context) {
        Throwable th;
        if (!TextUtils.isEmpty(a) && !"unknow".equals(a)) {
            return a;
        }
        String deviceId;
        SharedPreferences sharedPreferences = context.getSharedPreferences("imei", 0);
        String string = sharedPreferences.getString("imei", null);
        if (string == null || string.length() == 0) {
            try {
                StringBuilder stringBuilder;
                Editor edit;
                deviceId = ((TelephonyManager) context.getSystemService("phone")).getDeviceId();
                if (deviceId != null) {
                    try {
                        if (deviceId.length() == 0) {
                        }
                        string = deviceId.replaceAll(" ", "").trim();
                        while (string.length() < 15) {
                            stringBuilder = new StringBuilder("0");
                            stringBuilder.append(string);
                            string = stringBuilder.toString();
                        }
                        edit = sharedPreferences.edit();
                        edit.putString("imei", string);
                        if (VERSION.SDK_INT < 9) {
                            edit.apply();
                        } else {
                            edit.commit();
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        string = deviceId;
                        th.toString();
                        if (string == null) {
                            string = "unknow";
                        }
                        deviceId = string.trim();
                        a = deviceId;
                        return deviceId;
                    }
                }
                deviceId = a();
                string = deviceId.replaceAll(" ", "").trim();
                while (string.length() < 15) {
                    stringBuilder = new StringBuilder("0");
                    stringBuilder.append(string);
                    string = stringBuilder.toString();
                }
                edit = sharedPreferences.edit();
                edit.putString("imei", string);
                if (VERSION.SDK_INT < 9) {
                    edit.commit();
                } else {
                    edit.apply();
                }
            } catch (Throwable th3) {
                th = th3;
            }
        }
        if (string == null) {
            string = "unknow";
        }
        deviceId = string.trim();
        a = deviceId;
        return deviceId;
    }
}
