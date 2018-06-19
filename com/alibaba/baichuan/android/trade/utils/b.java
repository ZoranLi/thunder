package com.alibaba.baichuan.android.trade.utils;

import java.util.Map;

public final class b {
    public static Long b(Object obj) {
        try {
            return Long.valueOf(Long.parseLong(obj.toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return new Long(-1);
        }
    }

    public static String c(Object obj) {
        return obj == null ? "" : obj.toString();
    }

    public static Map d(Object obj) {
        try {
            return (Map) obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Map e(Object obj) {
        try {
            return (Map) obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean a(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj instanceof Boolean) {
            return ((Boolean) obj).booleanValue();
        }
        if (!(obj instanceof String)) {
            return false;
        }
        String str = (String) obj;
        if (!("true".equals(str.toLowerCase()) || "1".equals(str))) {
            if ("YES".equals(str) == null) {
                return false;
            }
        }
        return true;
    }
}
