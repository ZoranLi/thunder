package com.tencent.open.b;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import com.alipay.sdk.app.statistic.c;
import com.tencent.open.a.f;

/* compiled from: ProGuard */
public class a {
    protected static final Uri a = Uri.parse("content://telephony/carriers/preferapn");

    public static String a(Context context) {
        int d = d(context);
        if (d == 2) {
            return "wifi";
        }
        if (d == 1) {
            return "cmwap";
        }
        if (d == 4) {
            return "cmnet";
        }
        if (d == 16) {
            return "uniwap";
        }
        if (d == 8) {
            return "uninet";
        }
        if (d == 64) {
            return "wap";
        }
        if (d == 32) {
            return c.a;
        }
        if (d == 512) {
            return "ctwap";
        }
        if (d == 256) {
            return "ctnet";
        }
        if (d == 2048) {
            return "3gnet";
        }
        if (d == 1024) {
            return "3gwap";
        }
        context = b(context);
        if (context != null) {
            if (context.length() != 0) {
                return context;
            }
        }
        return "none";
    }

    public static String b(Context context) {
        StringBuilder stringBuilder;
        try {
            context = context.getContentResolver().query(a, null, null, null, null);
            if (context == null) {
                return null;
            }
            context.moveToFirst();
            if (context.isAfterLast()) {
                if (context != null) {
                    context.close();
                }
                return null;
            }
            String string = context.getString(context.getColumnIndex("apn"));
            if (context != null) {
                context.close();
            }
            return string;
        } catch (Context context2) {
            stringBuilder = new StringBuilder("getApn has exception: ");
            stringBuilder.append(context2.getMessage());
            f.e("openSDK_LOG.APNUtil", stringBuilder.toString());
            return "";
        } catch (Context context22) {
            stringBuilder = new StringBuilder("getApn has exception: ");
            stringBuilder.append(context22.getMessage());
            f.e("openSDK_LOG.APNUtil", stringBuilder.toString());
            return "";
        }
    }

    public static String c(Context context) {
        try {
            context = context.getContentResolver().query(a, null, null, null, null);
            if (context == null) {
                return null;
            }
            context.moveToFirst();
            if (context.isAfterLast()) {
                if (context != null) {
                    context.close();
                }
                return null;
            }
            String string = context.getString(context.getColumnIndex("proxy"));
            if (context != null) {
                context.close();
            }
            return string;
        } catch (Context context2) {
            StringBuilder stringBuilder = new StringBuilder("getApnProxy has exception: ");
            stringBuilder.append(context2.getMessage());
            f.e("openSDK_LOG.APNUtil", stringBuilder.toString());
            return "";
        }
    }

    public static int d(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return 128;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null) {
                return 128;
            }
            if (activeNetworkInfo.getTypeName().toUpperCase().equals("WIFI")) {
                return 2;
            }
            String toLowerCase = activeNetworkInfo.getExtraInfo().toLowerCase();
            if (toLowerCase.startsWith("cmwap")) {
                return 1;
            }
            if (!toLowerCase.startsWith("cmnet")) {
                if (!toLowerCase.startsWith("epc.tmobile.com")) {
                    if (toLowerCase.startsWith("uniwap")) {
                        return 16;
                    }
                    if (toLowerCase.startsWith("uninet")) {
                        return 8;
                    }
                    if (toLowerCase.startsWith("wap")) {
                        return 64;
                    }
                    if (toLowerCase.startsWith(c.a)) {
                        return 32;
                    }
                    if (toLowerCase.startsWith("ctwap")) {
                        return 512;
                    }
                    if (toLowerCase.startsWith("ctnet")) {
                        return 256;
                    }
                    if (toLowerCase.startsWith("3gwap")) {
                        return 1024;
                    }
                    if (toLowerCase.startsWith("3gnet")) {
                        return 2048;
                    }
                    if (toLowerCase.startsWith("#777")) {
                        context = c(context);
                        if (context == null || context.length() <= null) {
                            return 256;
                        }
                        return 512;
                    }
                    return 128;
                }
            }
            return 4;
        } catch (Context context2) {
            StringBuilder stringBuilder = new StringBuilder("getMProxyType has exception: ");
            stringBuilder.append(context2.getMessage());
            f.e("openSDK_LOG.APNUtil", stringBuilder.toString());
        }
    }

    public static String e(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            return "MOBILE";
        }
        context = connectivityManager.getActiveNetworkInfo();
        return context != null ? context.getTypeName() : "MOBILE";
    }
}
