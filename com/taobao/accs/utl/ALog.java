package com.taobao.accs.utl;

import android.text.TextUtils;
import com.taobao.tlog.adapter.AdapterForTLog;
import com.xiaomi.mipush.sdk.Constants;

/* compiled from: Taobao */
public class ALog {
    private static Object LOG_BREAK = "|";
    private static boolean isPrintLog = true;
    private static boolean isUseTlog = true;
    private static String preTag = "accs.";

    /* compiled from: Taobao */
    public enum Level {
        V,
        D,
        I,
        W,
        E,
        L
    }

    @Deprecated
    public static boolean isPrintLog() {
        return false;
    }

    public static void initALog(String str, int i) {
        preTag = str;
    }

    public static void setPrintLog(boolean z) {
        isPrintLog = z;
    }

    public static void setUseTlog(boolean z) {
        isUseTlog = z;
    }

    @Deprecated
    public static void setEnableTLog(boolean z) {
        isUseTlog = z;
    }

    public static boolean isPrintLog(Level level) {
        if (!isPrintLog) {
            return false;
        }
        if (!isUseTlog) {
            return true;
        }
        Level level2 = Level.L;
        try {
            level2 = Level.valueOf(AdapterForTLog.getLogLevel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (level.ordinal() >= level2.ordinal()) {
            return true;
        }
        return false;
    }

    public static void d(String str, String str2, Object... objArr) {
        d1(str, str2, null, objArr);
    }

    public static void d1(String str, String str2, String str3, Object... objArr) {
        if (isPrintLog(Level.D)) {
            if (isUseTlog) {
                AdapterForTLog.logd(buildLogTag(str), buildLogMsg(str2, str3, objArr));
            } else {
                buildLogTag(str);
                buildLogMsg(str2, str3, objArr);
            }
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        i1(str, str2, null, objArr);
    }

    public static void i1(String str, String str2, String str3, Object... objArr) {
        if (isPrintLog(Level.I)) {
            if (isUseTlog) {
                AdapterForTLog.logi(buildLogTag(str), buildLogMsg(str2, str3, objArr));
            } else {
                buildLogTag(str);
                buildLogMsg(str2, str3, objArr);
            }
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        w(str, str2, null, objArr);
    }

    public static void w1(String str, String str2, String str3, Object... objArr) {
        if (isPrintLog(Level.W)) {
            if (isUseTlog) {
                AdapterForTLog.logw(buildLogTag(str), buildLogMsg(str2, str3, objArr));
            } else {
                buildLogTag(str);
                buildLogMsg(str2, str3, objArr);
            }
        }
    }

    public static void w(String str, String str2, Throwable th, Object... objArr) {
        w1(str, str2, null, th, objArr);
    }

    public static void w1(String str, String str2, String str3, Throwable th, Object... objArr) {
        if (isPrintLog(Level.W)) {
            if (isUseTlog) {
                AdapterForTLog.logw(buildLogTag(str), buildLogMsg(str2, str3, objArr), th);
            } else {
                buildLogTag(str);
                buildLogMsg(str2, str3, objArr);
            }
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        e1(str, str2, null, objArr);
    }

    public static void e1(String str, String str2, String str3, Object... objArr) {
        if (isPrintLog(Level.E)) {
            if (isUseTlog) {
                AdapterForTLog.loge(buildLogTag(str), buildLogMsg(str2, str3, objArr));
            } else {
                buildLogTag(str);
                buildLogMsg(str2, str3, objArr);
            }
        }
    }

    public static void e(String str, String str2, Throwable th, Object... objArr) {
        e1(str, str2, null, th, objArr);
    }

    public static void e1(String str, String str2, String str3, Throwable th, Object... objArr) {
        if (isPrintLog(Level.E)) {
            if (isUseTlog) {
                AdapterForTLog.loge(buildLogTag(str), buildLogMsg(str2, str3, objArr), th);
            } else {
                buildLogTag(str);
                buildLogMsg(str2, str3, objArr);
            }
        }
    }

    private static String formatKv(Object obj, Object obj2) {
        StringBuilder stringBuilder = new StringBuilder();
        if (obj == null) {
            obj = "";
        }
        stringBuilder.append(obj);
        stringBuilder.append(Constants.COLON_SEPARATOR);
        if (obj2 == null) {
            obj2 = "";
        }
        stringBuilder.append(obj2);
        return stringBuilder.toString();
    }

    private static String buildLogTag(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(preTag);
        stringBuilder.append(str);
        return stringBuilder.toString();
    }

    private static String buildLogTag() {
        return preTag;
    }

    static String buildLogMsg(String str, String str2, Object... objArr) {
        if (str == null && str2 == null && objArr == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            int i = 0;
            if (!TextUtils.isEmpty(str2)) {
                stringBuilder.append(LOG_BREAK);
                stringBuilder.append(String.format("[seq:%s]", new Object[]{str2}));
            }
            if (str != null) {
                stringBuilder.append(" ");
                stringBuilder.append(str);
            }
            if (objArr != null) {
                while (true) {
                    str = i + 1;
                    if (str >= objArr.length) {
                        break;
                    }
                    stringBuilder.append(" ");
                    stringBuilder.append(formatKv(objArr[i], objArr[str]));
                    i = str + 1;
                }
                if (i > 0 && i == objArr.length - 1) {
                    stringBuilder.append(" ");
                    stringBuilder.append(objArr[i]);
                }
            }
            return stringBuilder.toString();
        } catch (String str3) {
            str3.printStackTrace();
            return "";
        }
    }
}
