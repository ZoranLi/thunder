package com.duiba.maila.sdk.util;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import com.duiba.maila.sdk.s;
import com.umeng.message.MsgConstant;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class i {
    public String a;

    public i(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        this.a = b.a(context, h.a, "device_id");
        if (this.a == null || this.a.length() == 0) {
            String a = a(telephonyManager, context);
            b.a(context, h.a, "device_id", a);
            context = a;
        } else {
            context = this.a;
        }
        this.a = context;
    }

    private static String a(TelephonyManager telephonyManager, Context context) {
        String macAddress = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getMacAddress();
        String str = "";
        context.getPackageManager();
        if (s.a(context, MsgConstant.PERMISSION_READ_PHONE_STATE)) {
            str = telephonyManager.getDeviceId();
        }
        telephonyManager = new StringBuilder();
        telephonyManager.append(str);
        StringBuilder stringBuilder = new StringBuilder("35");
        stringBuilder.append(Build.BOARD.length() % 10);
        stringBuilder.append(Build.BRAND.length() % 10);
        stringBuilder.append(Build.CPU_ABI.length() % 10);
        stringBuilder.append(Build.DEVICE.length() % 10);
        stringBuilder.append(Build.DISPLAY.length() % 10);
        stringBuilder.append(Build.HOST.length() % 10);
        stringBuilder.append(Build.ID.length() % 10);
        stringBuilder.append(Build.MANUFACTURER.length() % 10);
        stringBuilder.append(Build.MODEL.length() % 10);
        stringBuilder.append(Build.PRODUCT.length() % 10);
        stringBuilder.append(Build.TAGS.length() % 10);
        stringBuilder.append(Build.TYPE.length() % 10);
        stringBuilder.append(Build.USER.length() % 10);
        telephonyManager.append(stringBuilder.toString());
        telephonyManager.append(Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID));
        telephonyManager.append(macAddress);
        telephonyManager = telephonyManager.toString();
        context = null;
        try {
            context = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        int i = 0;
        context.update(telephonyManager.getBytes(), 0, telephonyManager.length());
        telephonyManager = context.digest();
        context = new String();
        while (i < telephonyManager.length) {
            StringBuilder stringBuilder2;
            int i2 = 255 & telephonyManager[i];
            if (i2 <= 15) {
                stringBuilder2 = new StringBuilder();
                stringBuilder2.append(context);
                stringBuilder2.append("0");
                context = stringBuilder2.toString();
            }
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append(context);
            stringBuilder2.append(Integer.toHexString(i2));
            context = stringBuilder2.toString();
            i++;
        }
        return context.toUpperCase();
    }
}
