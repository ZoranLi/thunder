package com.umeng.socialize.utils;

import android.content.Context;
import android.widget.Toast;
import com.umeng.socialize.Config;

public class Log {
    public static boolean LOG = true;
    private static boolean LOGNET = false;
    public static final String LOGTAG = "6.4.5umeng_tool----";
    public static final String NETTAG = "6.4.5net_test----";
    public static final String TAG = "umengsocial";

    public static void net(String str) {
    }

    public static void y(String str) {
    }

    public static void i(String str, String str2) {
        if (LOG != null) {
            str = Config.DEBUG;
        }
    }

    public static void i(String str, String str2, Exception exception) {
        if (LOG != null && Config.DEBUG != null) {
            str = new StringBuilder();
            str.append(exception.toString());
            str.append(":  [");
            str.append(str2);
            str.append("]");
        }
    }

    public static void e(String str, String str2) {
        if (LOG != null) {
            str = Config.DEBUG;
        }
    }

    public static void e(String str, String str2, Exception exception) {
        str = new StringBuilder();
        str.append(exception.toString());
        str.append(":  [");
        str.append(str2);
        str.append("]");
        for (StackTraceElement stackTraceElement : exception.getStackTrace()) {
            new StringBuilder("        at\t ").append(stackTraceElement.toString());
        }
    }

    public static void d(String str, String str2) {
        if (LOG != null) {
            str = Config.DEBUG;
        }
    }

    public static void d(String str, String str2, Exception exception) {
        if (LOG != null && Config.DEBUG != null) {
            str = new StringBuilder();
            str.append(exception.toString());
            str.append(":  [");
            str.append(str2);
            str.append("]");
        }
    }

    public static void v(String str, String str2) {
        if (LOG != null) {
            str = Config.DEBUG;
        }
    }

    public static void v(String str, String str2, Exception exception) {
        if (LOG != null && Config.DEBUG != null) {
            str = new StringBuilder();
            str.append(exception.toString());
            str.append(":  [");
            str.append(str2);
            str.append("]");
        }
    }

    public static void w(String str, String str2) {
        if (LOG != null) {
            str = Config.DEBUG;
        }
    }

    public static void w(String str, String str2, Exception exception) {
        if (LOG != null && Config.DEBUG != null) {
            str = new StringBuilder();
            str.append(exception.toString());
            str.append(":  [");
            str.append(str2);
            str.append("]");
            for (StackTraceElement stackTraceElement : exception.getStackTrace()) {
                new StringBuilder("        at\t ").append(stackTraceElement.toString());
            }
        }
    }

    public static void i(String str) {
        if (LOG != null) {
            str = Config.DEBUG;
        }
    }

    public static void e(String str) {
        if (LOG != null) {
            str = Config.DEBUG;
        }
    }

    public static void um(String str) {
        StringBuilder stringBuilder = new StringBuilder(LOGTAG);
        stringBuilder.append(str);
        e(stringBuilder.toString());
    }

    public static void umd(String str) {
        StringBuilder stringBuilder = new StringBuilder(LOGTAG);
        stringBuilder.append(str);
        d(stringBuilder.toString());
    }

    public static void d(String str) {
        if (LOG != null) {
            str = Config.DEBUG;
        }
    }

    public static void v(String str) {
        if (LOG != null) {
            str = Config.DEBUG;
        }
    }

    public static void w(String str) {
        if (LOG != null) {
            str = Config.DEBUG;
        }
    }

    public static void toast(Context context, String str) {
        if (LOG && Config.DEBUG) {
            Toast.makeText(context, str, 1).show();
        }
    }

    public static void url(String str, String str2) {
        if (Config.DEBUG) {
            d("6.4.5umeng_tool--------------------问题---------------");
            StringBuilder stringBuilder = new StringBuilder(LOGTAG);
            stringBuilder.append(str);
            d(stringBuilder.toString());
            d("6.4.5umeng_tool--------------------解决方案------------");
            str = new StringBuilder("6.4.5umeng_tool----请访问：");
            str.append(str2);
            d(str.toString());
            d("6.4.5umeng_tool----|-------------------------------|");
        }
    }

    public static void url(String str, String str2, String str3) {
        if (Config.DEBUG) {
            StringBuilder stringBuilder = new StringBuilder("6.4.5umeng_tool--------------------");
            stringBuilder.append(str);
            stringBuilder.append("---------------");
            d(stringBuilder.toString());
            str = new StringBuilder(LOGTAG);
            str.append(str2);
            d(str.toString());
            d("6.4.5umeng_tool--------------------解决方案------------");
            str = new StringBuilder("6.4.5umeng_tool----请访问：");
            str.append(str3);
            d(str.toString());
            d("6.4.5umeng_tool----|-------------------------------|");
        }
    }
}
