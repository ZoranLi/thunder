package com.hianalytics.android.a.a;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import com.xiaomi.mipush.sdk.Constants;

public final class a {
    public static String a(Context context) {
        StringBuffer stringBuffer = new StringBuffer("1.0");
        String a = com.hianalytics.android.b.a.a.a(context);
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager == null) {
            com.hianalytics.android.b.a.a.h();
            return null;
        }
        String b;
        String b2;
        Configuration configuration = context.getResources().getConfiguration();
        String str = "";
        if (!(configuration == null || configuration.locale == null)) {
            str = configuration.locale.toString();
        }
        String str2 = "";
        try {
            b = com.hianalytics.android.b.a.a.b(telephonyManager.getDeviceId());
        } catch (SecurityException e) {
            e.printStackTrace();
            b = str2;
        }
        str2 = com.hianalytics.android.b.a.a.e(context);
        if (com.hianalytics.android.b.a.a.f(context)) {
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            StringBuilder stringBuilder = new StringBuilder("Android");
            stringBuilder.append(VERSION.RELEASE);
            stringBuffer.append(stringBuilder.toString());
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuffer.append(str);
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuffer.append(Build.MODEL);
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuffer.append(Build.DISPLAY);
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuffer.append(str2);
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuffer.append(b);
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuffer.append(a);
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            b2 = com.hianalytics.android.b.a.a.b(context);
        } else {
            stringBuffer.append(",,,,,");
            stringBuffer.append(str2);
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuffer.append(b);
            stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            stringBuffer.append(a);
            b2 = Constants.ACCEPT_TIME_SEPARATOR_SP;
        }
        stringBuffer.append(b2);
        com.hianalytics.android.b.a.a.h();
        return stringBuffer.toString();
    }
}
