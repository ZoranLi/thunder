package com.xunlei.common.accelerator.utils;

import android.content.Context;
import android.net.ConnectivityManager;

public class XLNetworkUtils {
    public static final int MOBILE_2G = 2;
    public static final int MOBILE_3G = 3;
    public static final int MOBILE_4G = 4;
    public static final int NO_NETWORK = 0;
    public static final int UNKNOWN_NETWORK = -1;
    public static final int WIFI = 5;

    public static int getSpecificNetworkType(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager.getActiveNetworkInfo() != null) {
                return getNetworkClass(connectivityManager.getActiveNetworkInfo().getSubtype(), connectivityManager.getActiveNetworkInfo().getTypeName());
            }
        } catch (Context context2) {
            context2.printStackTrace();
        }
        return null;
    }

    public static int getNetworkClass(int i, String str) {
        switch (i) {
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
                return str.equals("WIFI") != 0 ? 5 : -1;
        }
    }

    public static boolean isWIFIActive(Context context) {
        return getSpecificNetworkType(context) == 5 ? true : null;
    }
}
