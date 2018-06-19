package com.getui.gtc.e;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public final class h {
    public static boolean a(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.getType() == 1) {
                return true;
            }
        } catch (Throwable th) {
            new String[1][0] = th.toString();
        }
        return false;
    }

    public static boolean b(Context context) {
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.isAvailable();
                }
            } catch (Throwable th) {
                new String[1][0] = th.toString();
            }
        }
        return false;
    }
}
