package com.tencent.bugly.beta.tinker;

import android.util.Log;
import com.tencent.tinker.lib.util.TinkerLog.TinkerLogImp;

/* compiled from: BUGLY */
public class TinkerLogger implements TinkerLogImp {
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_NONE = 5;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 3;
    private static final String TAG = "Tinker.TinkerLogger";
    private static int level;

    public static int getLogLevel() {
        return level;
    }

    public static void setLevel(int i) {
        level = i;
    }

    public void v(String str, String str2, Object... objArr) {
        if (level <= null && objArr != null) {
            String.format(str2, objArr);
        }
    }

    public void i(String str, String str2, Object... objArr) {
        if (level <= 2 && objArr != null) {
            String.format(str2, objArr);
        }
    }

    public void w(String str, String str2, Object... objArr) {
        if (level <= 3 && objArr != null) {
            String.format(str2, objArr);
        }
    }

    public void d(String str, String str2, Object... objArr) {
        if (level <= 1 && objArr != null) {
            String.format(str2, objArr);
        }
    }

    public void e(String str, String str2, Object... objArr) {
        if (level <= 4 && objArr != null) {
            String.format(str2, objArr);
        }
    }

    public void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (objArr != null) {
            str2 = String.format(str2, objArr);
        }
        if (str2 == null) {
            str2 = "";
        }
        str = new StringBuilder();
        str.append(str2);
        str.append("  ");
        str.append(Log.getStackTraceString(th));
    }
}
