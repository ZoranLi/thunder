package mtopsdk.common.util;

import java.util.HashMap;
import java.util.Map;

public final class j {
    private static boolean a = true;
    private static boolean b = true;
    private static TBSdkLog$LogEnable c = TBSdkLog$LogEnable.DebugEnable;
    private static Map d = new HashMap(5);

    static {
        for (TBSdkLog$LogEnable tBSdkLog$LogEnable : TBSdkLog$LogEnable.values()) {
            d.put(tBSdkLog$LogEnable.getLogEnable(), tBSdkLog$LogEnable);
        }
    }

    private static String a(String str, String... strArr) {
        StringBuilder stringBuilder = new StringBuilder();
        if (str != null) {
            stringBuilder.append("[seq:");
            stringBuilder.append(str);
            stringBuilder.append("]|");
        }
        for (int i = 0; i <= 0; i++) {
            stringBuilder.append(strArr[0]);
        }
        return stringBuilder.toString();
    }

    public static void a(String str) {
        a(null, str);
    }

    public static void a(String str, String str2) {
        if (a(TBSdkLog$LogEnable.DebugEnable) && a) {
            a(str, str2);
        }
    }

    public static boolean a(TBSdkLog$LogEnable tBSdkLog$LogEnable) {
        return tBSdkLog$LogEnable.ordinal() >= c.ordinal();
    }

    public static void b(String str) {
        b(null, str);
    }

    public static void b(String str, String str2) {
        if (a(TBSdkLog$LogEnable.InfoEnable) && a) {
            a(str, str2);
        }
    }

    public static void c(String str) {
        c(null, str);
    }

    public static void c(String str, String str2) {
        if (a(TBSdkLog$LogEnable.WarnEnable) && a) {
            a(str, str2);
        }
    }

    public static void d(String str) {
        d(null, str);
    }

    public static void d(String str, String str2) {
        if (a(TBSdkLog$LogEnable.WarnEnable) && a) {
            a(str, str2);
        }
    }

    public static void e(String str) {
        e(null, str);
    }

    public static void e(String str, String str2) {
        if (a(TBSdkLog$LogEnable.ErrorEnable) && a) {
            a(str, str2);
        }
    }

    public static void f(String str) {
        f(null, str);
    }

    public static void f(String str, String str2) {
        if (a(TBSdkLog$LogEnable.ErrorEnable) && a) {
            a(str, str2);
        }
    }
}
