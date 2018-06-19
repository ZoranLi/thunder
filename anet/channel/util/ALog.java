package anet.channel.util;

import android.text.TextUtils;
import com.taobao.tlog.adapter.AdapterForTLog;
import com.xiaomi.mipush.sdk.Constants;

/* compiled from: Taobao */
public class ALog {
    private static Object LOG_BREAK = "|";
    private static boolean isPrintLog = true;
    private static boolean isUseTlog = true;

    /* compiled from: Taobao */
    public static class a {
        public static final int D = 1;
        public static final int E = 4;
        public static final int I = 2;
        public static final int L = 5;
        public static final int V = 0;
        public static final int W = 3;

        public static int a(String str) {
            switch (str.charAt(0)) {
                case 68:
                    return 1;
                case 69:
                    return 4;
                case 73:
                    return 2;
                case 86:
                    return 0;
                case 87:
                    return 3;
                default:
                    return 5;
            }
        }
    }

    private static String buildLogTag(String str) {
        return str;
    }

    @Deprecated
    public static boolean isPrintLog() {
        return false;
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

    public static boolean isPrintLog(int i) {
        if (!isPrintLog) {
            return false;
        }
        if (!isUseTlog || i >= a.a(AdapterForTLog.getLogLevel())) {
            return true;
        }
        return false;
    }

    public static void d(String str, String str2, String str3, Object... objArr) {
        if (isPrintLog(1)) {
            if (isUseTlog) {
                AdapterForTLog.logd(buildLogTag(str), buildLogMsg(str2, str3, objArr));
            } else {
                buildLogTag(str);
                buildLogMsg(str2, str3, objArr);
            }
        }
    }

    public static void i(String str, String str2, String str3, Object... objArr) {
        if (isPrintLog(2)) {
            if (isUseTlog) {
                AdapterForTLog.logi(buildLogTag(str), buildLogMsg(str2, str3, objArr));
            } else {
                buildLogTag(str);
                buildLogMsg(str2, str3, objArr);
            }
        }
    }

    public static void w(String str, String str2, String str3, Object... objArr) {
        if (isPrintLog(3)) {
            if (isUseTlog) {
                AdapterForTLog.logw(buildLogTag(str), buildLogMsg(str2, str3, objArr));
            } else {
                buildLogTag(str);
                buildLogMsg(str2, str3, objArr);
            }
        }
    }

    public static void w(String str, String str2, String str3, Throwable th, Object... objArr) {
        if (isPrintLog(3)) {
            if (isUseTlog) {
                AdapterForTLog.logw(buildLogTag(str), buildLogMsg(str2, str3, objArr), th);
            } else {
                buildLogTag(str);
                buildLogMsg(str2, str3, objArr);
            }
        }
    }

    public static void e(String str, String str2, String str3, Object... objArr) {
        if (isPrintLog(4)) {
            if (isUseTlog) {
                AdapterForTLog.loge(buildLogTag(str), buildLogMsg(str2, str3, objArr));
            } else {
                buildLogTag(str);
                buildLogMsg(str2, str3, objArr);
            }
        }
    }

    public static void e(String str, String str2, String str3, Throwable th, Object... objArr) {
        if (isPrintLog(4)) {
            if (isUseTlog) {
                AdapterForTLog.loge(buildLogTag(str), buildLogMsg(str2, str3, objArr), th);
            } else {
                buildLogTag(str);
                buildLogMsg(str2, str3, objArr);
            }
        }
    }

    static String buildLogMsg(String str, String str2, Object... objArr) {
        if (str == null && str2 == null && objArr == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (!TextUtils.isEmpty(str2)) {
            stringBuilder.append(LOG_BREAK);
            stringBuilder.append("[seq:");
            stringBuilder.append(str2);
            stringBuilder.append("]");
        }
        if (str != null) {
            stringBuilder.append(" ");
            stringBuilder.append(str);
        }
        if (objArr != null) {
            str = null;
            while (true) {
                str2 = str + 1;
                if (str2 >= objArr.length) {
                    break;
                }
                stringBuilder.append(" ");
                stringBuilder.append(objArr[str] != null ? objArr[str] : "");
                stringBuilder.append(Constants.COLON_SEPARATOR);
                stringBuilder.append(objArr[str2] != null ? objArr[str2] : "");
                str += 2;
            }
            if (str < objArr.length) {
                stringBuilder.append(" ");
                stringBuilder.append(objArr[str]);
            }
        }
        return stringBuilder.toString();
    }
}
