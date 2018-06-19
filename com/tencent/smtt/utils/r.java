package com.tencent.smtt.utils;

import android.text.TextUtils;
import java.lang.reflect.Method;

public class r {
    private static Class a;
    private static Method b;

    static {
        try {
            Class cls = Class.forName("android.os.SystemProperties");
            a = cls;
            b = cls.getDeclaredMethod("get", new Class[]{String.class, String.class});
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String a(String str, String str2) {
        return TextUtils.isEmpty(str) ? str2 : b(str, str2);
    }

    private static String b(String str, String str2) {
        if (a == null || b == null) {
            return str2;
        }
        try {
            return (String) b.invoke(a, new Object[]{str, str2});
        } catch (Throwable th) {
            th.printStackTrace();
            return str2;
        }
    }
}
