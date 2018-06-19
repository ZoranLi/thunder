package com.igexin.push.config;

import android.text.TextUtils;
import com.igexin.b.a.c.a;
import com.igexin.push.core.g;
import java.util.ArrayList;
import java.util.List;

public class SDKUrlConfig {
    public static String[] AMP_ADDRESS_IPS = new String[]{"http://sdk.open.amp.igexin.com/api.htm"};
    public static String[] BI_ADDRESS_IPS = new String[]{"http://sdk.open.phone.igexin.com/api.php"};
    public static String[] CONFIG_ADDRESS_IPS = new String[]{"http://c-hzgt2.getui.com/api.php"};
    public static String[] INC_ADDRESS_IPS = new String[]{"http://sdk.open.inc2.igexin.com/api.php"};
    public static String[] LBS_ADDRESS_IPS = new String[]{"http://sdk.open.lbs.igexin.com/api.htm"};
    public static String[] LOG_ADDRESS_IPS = new String[]{"http://d.gt.igexin.com/api.htm"};
    public static String[] STATE_ADDRESS_IPS = new String[]{"http://s-gt.getui.com/api.php"};
    public static String[] XFR_ADDRESS_BAK = new String[]{"socket://42.62.120.14:5224"};
    private static final Object a = new Object();
    private static String[] b = null;
    private static String c = "HZ";
    private static String[] d = new String[]{"socket://sdk.open.talk.igexin.com:5224", "socket://sdk.open.talk.getui.net:5224", "socket://sdk.open.talk.gepush.com:5224"};
    private static volatile String e;

    public static String getAmpServiceUrl() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(AMP_ADDRESS_IPS[0]);
        stringBuilder.append("?format=json&t=1");
        return stringBuilder.toString();
    }

    public static String getBiUploadServiceUrl() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(BI_ADDRESS_IPS[0]);
        stringBuilder.append("?format=json&t=1");
        return stringBuilder.toString();
    }

    public static String getCmAddress() {
        return e == null ? d[0] : e;
    }

    public static String getConfigServiceUrl() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(CONFIG_ADDRESS_IPS[0]);
        stringBuilder.append("?format=json&t=1");
        return stringBuilder.toString();
    }

    public static String[] getIdcConfigUrl() {
        return b;
    }

    public static String getIncreaseServiceUrl() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(INC_ADDRESS_IPS[0]);
        stringBuilder.append("?format=json&t=1");
        return stringBuilder.toString();
    }

    public static String getLbsServiceUrl() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LBS_ADDRESS_IPS[0]);
        stringBuilder.append("?format=json&t=1");
        return stringBuilder.toString();
    }

    public static String getLocation() {
        return c;
    }

    public static String getLogServiceUrl() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(LOG_ADDRESS_IPS[0]);
        stringBuilder.append("?format=json&t=1");
        return stringBuilder.toString();
    }

    public static String getStatServiceUrl() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(STATE_ADDRESS_IPS[0]);
        stringBuilder.append("?format=json&t=1");
        return stringBuilder.toString();
    }

    public static String[] getXfrAddress() {
        String[] strArr;
        synchronized (a) {
            strArr = d;
        }
        return strArr;
    }

    public static boolean realXfrListIsOnly() {
        String[] xfrAddress = getXfrAddress();
        List arrayList = new ArrayList();
        for (Object obj : xfrAddress) {
            if (!arrayList.contains(obj)) {
                arrayList.add(obj);
            }
        }
        return arrayList.size() == 1;
    }

    public static void setCmAddress(String str) {
        StringBuilder stringBuilder = new StringBuilder("set cm address : ");
        stringBuilder.append(str);
        a.b(stringBuilder.toString());
        e = str;
    }

    public static void setIdcConfigUrl(String[] strArr) {
        b = strArr;
    }

    public static void setLocation(String str) {
        if (!TextUtils.isEmpty(str)) {
            g.d = str;
            c = str;
        }
    }

    public static void setXfrAddressIps(String[] strArr) {
        synchronized (a) {
            d = strArr;
        }
    }
}
