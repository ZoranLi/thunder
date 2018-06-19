package com.alibaba.mtl.log.e;

import android.os.Process;
import com.xiaomi.mipush.sdk.Constants;

/* compiled from: Logger */
public final class i {
    private static String a = "UTAnalytics:";
    private static boolean b = false;
    private static boolean c = false;

    public static boolean a() {
        return c;
    }

    public static void a(boolean z) {
        c = z;
    }

    public static void a(String str, Object... objArr) {
        if (c) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(str);
            str = new StringBuilder();
            str.append("pid:");
            str.append(Process.myPid());
            str.append(" ");
            for (int i = 0; i < objArr.length; i++) {
                if (objArr[i] != null) {
                    String obj = objArr[i].toString();
                    if (!obj.endsWith(Constants.COLON_SEPARATOR)) {
                        if (!obj.endsWith(": ")) {
                            str.append(obj);
                            str.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                    }
                    str.append(obj);
                }
            }
        }
    }

    public static void a(String str, String... strArr) {
        if (c) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(a);
            stringBuilder.append(str);
            str = new StringBuilder();
            str.append("pid:");
            str.append(Process.myPid());
            str.append(" ");
            for (int i = 0; i < strArr.length; i++) {
                if (strArr[i] != null) {
                    String str2 = strArr[i];
                    if (!str2.endsWith(Constants.COLON_SEPARATOR)) {
                        if (!str2.endsWith(": ")) {
                            str.append(str2);
                            str.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                        }
                    }
                    str.append(str2);
                }
            }
        }
    }

    public static void a(String str, Object obj) {
        if (c || b) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(a);
            new StringBuilder().append(obj);
        }
    }

    public static void b(String str, Object obj) {
        if (c || b) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append(a);
            new StringBuilder().append(obj);
        }
    }
}
