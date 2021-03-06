package com.ta.utdid2.android.utils;

import java.lang.reflect.Method;

public class DebugUtils {
    public static boolean DBG = false;
    private static final String PROPERTY_DEBUG = "alidebug";
    private static Class<?> mClassType;
    private static Method mGetIntMethod;
    private static Method mGetMethod;

    public static String get(String str) {
        init();
        try {
            return (String) mGetMethod.invoke(mClassType, new Object[]{str});
        } catch (String str2) {
            str2.printStackTrace();
            return null;
        }
    }

    public static int getInt(String str, int i) {
        init();
        try {
            return ((Integer) mGetIntMethod.invoke(mClassType, new Object[]{str, Integer.valueOf(i)})).intValue();
        } catch (String str2) {
            str2.printStackTrace();
            return i;
        }
    }

    static {
        boolean z = false;
        if (getInt(PROPERTY_DEBUG, 0) == 1) {
            z = true;
        }
        DBG = z;
    }

    private static void init() {
        try {
            if (mClassType == null) {
                Class cls = Class.forName("android.os.SystemProperties");
                mClassType = cls;
                mGetMethod = cls.getDeclaredMethod("get", new Class[]{String.class});
                mGetIntMethod = mClassType.getDeclaredMethod("getInt", new Class[]{String.class, Integer.TYPE});
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
