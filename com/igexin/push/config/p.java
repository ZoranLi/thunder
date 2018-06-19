package com.igexin.push.config;

import android.os.Bundle;
import com.igexin.b.a.c.a;
import com.igexin.push.core.g;

public class p {
    public static void a() {
        try {
            Bundle bundle = g.f.getPackageManager().getApplicationInfo(g.f.getPackageName(), 128).metaData;
            if (bundle != null) {
                for (String str : bundle.keySet()) {
                    if (str.equals("PUSH_DOMAIN")) {
                        StringBuilder stringBuilder = new StringBuilder("PUSH_DOMAIN:");
                        stringBuilder.append(bundle.getString(str));
                        a.b(stringBuilder.toString());
                        a(bundle.getString(str));
                        break;
                    }
                }
            }
        } catch (Exception e) {
            a.b(e.toString());
        }
    }

    private static void a(String str) {
        String[] strArr = new String[1];
        StringBuilder stringBuilder = new StringBuilder("socket://xfr.");
        stringBuilder.append(str);
        stringBuilder.append(":5224");
        strArr[0] = stringBuilder.toString();
        SDKUrlConfig.setXfrAddressIps(strArr);
        StringBuilder stringBuilder2 = new StringBuilder("XFR_ADDRESS_IPS:");
        stringBuilder2.append(SDKUrlConfig.getXfrAddress()[0]);
        a.b(stringBuilder2.toString());
        strArr = new String[1];
        stringBuilder = new StringBuilder("socket://xfr_bak.");
        stringBuilder.append(str);
        stringBuilder.append(":5224");
        strArr[0] = stringBuilder.toString();
        SDKUrlConfig.XFR_ADDRESS_BAK = strArr;
        stringBuilder2 = new StringBuilder("XFR_ADDRESS_IPS_BAK:");
        stringBuilder2.append(SDKUrlConfig.XFR_ADDRESS_BAK[0]);
        a.b(stringBuilder2.toString());
        strArr = new String[1];
        stringBuilder = new StringBuilder("http://bi.");
        stringBuilder.append(str);
        stringBuilder.append("/api.php");
        strArr[0] = stringBuilder.toString();
        SDKUrlConfig.BI_ADDRESS_IPS = strArr;
        stringBuilder2 = new StringBuilder("BI_ADDRESS_IPS:");
        stringBuilder2.append(SDKUrlConfig.BI_ADDRESS_IPS[0]);
        a.b(stringBuilder2.toString());
        strArr = new String[1];
        stringBuilder = new StringBuilder("http://config.");
        stringBuilder.append(str);
        stringBuilder.append("/api.php");
        strArr[0] = stringBuilder.toString();
        SDKUrlConfig.CONFIG_ADDRESS_IPS = strArr;
        stringBuilder2 = new StringBuilder("CONFIG_ADDRESS_IPS:");
        stringBuilder2.append(SDKUrlConfig.CONFIG_ADDRESS_IPS[0]);
        a.b(stringBuilder2.toString());
        strArr = new String[1];
        stringBuilder = new StringBuilder("http://stat.");
        stringBuilder.append(str);
        stringBuilder.append("/api.php");
        strArr[0] = stringBuilder.toString();
        SDKUrlConfig.STATE_ADDRESS_IPS = strArr;
        stringBuilder2 = new StringBuilder("STATE_ADDRESS_IPS:");
        stringBuilder2.append(SDKUrlConfig.STATE_ADDRESS_IPS[0]);
        a.b(stringBuilder2.toString());
        strArr = new String[1];
        stringBuilder = new StringBuilder("http://log.");
        stringBuilder.append(str);
        stringBuilder.append("/api.php");
        strArr[0] = stringBuilder.toString();
        SDKUrlConfig.LOG_ADDRESS_IPS = strArr;
        stringBuilder2 = new StringBuilder("LOG_ADDRESS_IPS:");
        stringBuilder2.append(SDKUrlConfig.LOG_ADDRESS_IPS[0]);
        a.b(stringBuilder2.toString());
        strArr = new String[1];
        stringBuilder = new StringBuilder("http://amp.");
        stringBuilder.append(str);
        stringBuilder.append("/api.htm");
        strArr[0] = stringBuilder.toString();
        SDKUrlConfig.AMP_ADDRESS_IPS = strArr;
        stringBuilder2 = new StringBuilder("AMP_ADDRESS_IPS:");
        stringBuilder2.append(SDKUrlConfig.AMP_ADDRESS_IPS[0]);
        a.b(stringBuilder2.toString());
        strArr = new String[1];
        stringBuilder = new StringBuilder("http://lbs.");
        stringBuilder.append(str);
        stringBuilder.append("/api.htm");
        strArr[0] = stringBuilder.toString();
        SDKUrlConfig.LBS_ADDRESS_IPS = strArr;
        stringBuilder2 = new StringBuilder("LBS_ADDRESS_IPS:");
        stringBuilder2.append(SDKUrlConfig.LBS_ADDRESS_IPS[0]);
        a.b(stringBuilder2.toString());
        String[] strArr2 = new String[1];
        stringBuilder2 = new StringBuilder("http://inc.");
        stringBuilder2.append(str);
        stringBuilder2.append("/api.php");
        strArr2[0] = stringBuilder2.toString();
        SDKUrlConfig.INC_ADDRESS_IPS = strArr2;
        StringBuilder stringBuilder3 = new StringBuilder("INC_ADDRESS_IPS:");
        stringBuilder3.append(SDKUrlConfig.INC_ADDRESS_IPS[0]);
        a.b(stringBuilder3.toString());
    }
}
