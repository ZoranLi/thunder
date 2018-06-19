package com.xunlei.common.encrypt;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.provider.Settings.Secure;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.xiaomi.mipush.sdk.Constants;
import java.math.BigInteger;
import java.util.UUID;

public class PeerID {
    public static String getPeerId(Context context) {
        String str = "00000000";
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager != null) {
            WifiInfo connectionInfo = wifiManager.getConnectionInfo();
            if (!(connectionInfo == null || connectionInfo.getMacAddress() == null)) {
                str = str.replaceAll(Constants.COLON_SEPARATOR, "");
            }
        }
        if (new BigInteger(str, 16).longValue() == 0) {
            Object string = Secure.getString(context.getContentResolver(), SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID);
            if (string.compareToIgnoreCase("9774d56d682e549c") == 0) {
                string = "";
            }
            if (TextUtils.isEmpty(string)) {
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager != null) {
                    string = telephonyManager.getDeviceId();
                }
            }
            if (TextUtils.isEmpty(string)) {
                TelephonyManager telephonyManager2 = (TelephonyManager) context.getSystemService("phone");
                if (telephonyManager2 != null) {
                    string = telephonyManager2.getSimSerialNumber();
                }
            }
            if (TextUtils.isEmpty(string) == null) {
                int length;
                context = UUID.nameUUIDFromBytes(string.getBytes());
                Long valueOf = Long.valueOf(context.getLeastSignificantBits());
                context = Long.valueOf(context.getMostSignificantBits());
                str = Integer.toHexString(valueOf.hashCode());
                for (length = str.length(); length < 8; length++) {
                    StringBuilder stringBuilder = new StringBuilder("0");
                    stringBuilder.append(str);
                    str = stringBuilder.toString();
                }
                context = Integer.toHexString(context.hashCode());
                for (length = context.length(); length < 8; length++) {
                    StringBuilder stringBuilder2 = new StringBuilder("0");
                    stringBuilder2.append(context);
                    context = stringBuilder2.toString();
                }
                StringBuilder stringBuilder3 = new StringBuilder();
                stringBuilder3.append(context);
                stringBuilder3.append(str);
                str = stringBuilder3.toString();
            }
        }
        for (context = str.length(); context < 16; context++) {
            stringBuilder3 = new StringBuilder();
            stringBuilder3.append(str);
            stringBuilder3.append("0");
            str = stringBuilder3.toString();
        }
        return str.toUpperCase();
    }
}
