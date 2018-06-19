package com.alibaba.baichuan.android.trade.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import com.alibaba.baichuan.android.trade.AlibcContext;
import com.alibaba.baichuan.android.trade.callback.AlibcFailureCallback;
import com.alibaba.baichuan.android.trade.utils.a.a;

public class f {
    private static final String a = "f";
    private static String b = "\\u";

    public static void a(AlibcFailureCallback alibcFailureCallback, int i, String str) {
        if (alibcFailureCallback != null) {
            AlibcContext.b.b(new h(alibcFailureCallback, i, str));
        }
    }

    public static void a(AlibcFailureCallback alibcFailureCallback, a aVar) {
        if (alibcFailureCallback != null) {
            AlibcContext.b.b(new g(alibcFailureCallback, aVar));
        }
    }

    public static boolean a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
        if (allNetworkInfo == null) {
            return false;
        }
        for (NetworkInfo networkInfo : allNetworkInfo) {
            if (networkInfo != null && (networkInfo.getState() == State.CONNECTED || networkInfo.getState() == State.CONNECTING)) {
                return true;
            }
        }
        return false;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    public static String b(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(packageInfo.versionName);
            stringBuilder.append(".");
            stringBuilder.append(packageInfo.versionCode);
            String stringBuilder2 = stringBuilder.toString();
            if (stringBuilder2 != null) {
                if (stringBuilder2.length() > 0) {
                    return stringBuilder2;
                }
            }
            c.a(a, "getVersion", "获取版本号失败");
            return "";
        } catch (Exception e) {
            c.a(a, "getVersion", e.getMessage());
            e.getMessage();
            com.alibaba.baichuan.android.trade.utils.g.a.b();
            e.printStackTrace();
            return "";
        }
    }
}
