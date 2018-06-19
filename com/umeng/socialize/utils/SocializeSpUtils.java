package com.umeng.socialize.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.socialize.common.SocializeConstants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;

public class SocializeSpUtils {
    private static SharedPreferences getSharedPreferences(Context context) {
        return context == null ? null : context.getSharedPreferences(SocializeConstants.SOCIAL_PREFERENCE_NAME, 0);
    }

    public static String getUMId(Context context) {
        context = getSharedPreferences(context);
        if (context != null) {
            return context.getString("uid", null);
        }
        return null;
    }

    public static long getTime(Context context) {
        context = getSharedPreferences(context);
        if (context != null) {
            return context.getLong(SocializeConstants.TIME, 0);
        }
        return 0;
    }

    public static String getUMEk(Context context) {
        context = getSharedPreferences(context);
        if (context != null) {
            return context.getString(SocializeProtocolConstants.PROTOCOL_KEY_ENTITY_KEY, null);
        }
        return null;
    }

    public static String getMac(Context context) {
        context = getSharedPreferences(context);
        if (context != null) {
            return context.getString(SocializeProtocolConstants.PROTOCOL_KEY_MAC, null);
        }
        return null;
    }

    public static boolean putUMId(Context context, String str) {
        context = getSharedPreferences(context);
        if (context == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return context.edit().putString("uid", str).commit();
    }

    public static boolean putUMEk(Context context, String str) {
        context = getSharedPreferences(context);
        if (context == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return context.edit().putString(SocializeProtocolConstants.PROTOCOL_KEY_ENTITY_KEY, str).commit();
    }

    public static boolean putTime(Context context) {
        context = getSharedPreferences(context);
        return (context == null || context.edit().putLong(SocializeConstants.TIME, System.currentTimeMillis()).commit() == null) ? null : true;
    }

    public static boolean putMac(Context context, String str) {
        context = getSharedPreferences(context);
        if (context == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return context.edit().putString(SocializeProtocolConstants.PROTOCOL_KEY_MAC, str).commit();
    }

    public static String getString(Context context, String str) {
        return getSharedPreferences(context).getString(str, "");
    }

    public static void putString(Context context, String str, String str2) {
        getSharedPreferences(context).edit().putString(str, str2).commit();
    }

    public static int getInt(Context context, String str, int i) {
        return getSharedPreferences(context).getInt(str, i);
    }

    public static void putInt(Context context, String str, int i) {
        getSharedPreferences(context).edit().putInt(str, i).commit();
    }

    public static void remove(Context context, String str) {
        getSharedPreferences(context).edit().remove(str).commit();
    }

    public static synchronized boolean putShareBoardConfig(Context context, String str) {
        synchronized (SocializeSpUtils.class) {
            context = getSharedPreferences(context);
            if (context == null) {
                return null;
            }
            context = context.edit().putString("shareboardconfig", str).commit();
            return context;
        }
    }

    public static synchronized String getShareBoardConfig(Context context) {
        synchronized (SocializeSpUtils.class) {
            context = getSharedPreferences(context);
            if (context == null) {
                return null;
            }
            context = context.getString("shareboardconfig", null);
            return context;
        }
    }
}
