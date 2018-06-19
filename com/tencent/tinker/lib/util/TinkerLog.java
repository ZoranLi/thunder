package com.tencent.tinker.lib.util;

import android.util.Log;

/* compiled from: BUGLY */
public class TinkerLog {
    private static final String TAG = "Tinker.TinkerLog";
    private static TinkerLogImp debugLog;
    private static TinkerLogImp tinkerLogImp;

    /* compiled from: BUGLY */
    public interface TinkerLogImp {
        void d(String str, String str2, Object... objArr);

        void e(String str, String str2, Object... objArr);

        void i(String str, String str2, Object... objArr);

        void printErrStackTrace(String str, Throwable th, String str2, Object... objArr);

        void v(String str, String str2, Object... objArr);

        void w(String str, String str2, Object... objArr);
    }

    static {
        TinkerLogImp anonymousClass1 = new TinkerLogImp() {
            public final void v(String str, String str2, Object... objArr) {
                if (objArr != null) {
                    if (objArr.length != null) {
                        String.format(str2, objArr);
                    }
                }
            }

            public final void i(String str, String str2, Object... objArr) {
                if (objArr != null) {
                    if (objArr.length != null) {
                        String.format(str2, objArr);
                    }
                }
            }

            public final void d(String str, String str2, Object... objArr) {
                if (objArr != null) {
                    if (objArr.length != null) {
                        String.format(str2, objArr);
                    }
                }
            }

            public final void w(String str, String str2, Object... objArr) {
                if (objArr != null) {
                    if (objArr.length != null) {
                        String.format(str2, objArr);
                    }
                }
            }

            public final void e(String str, String str2, Object... objArr) {
                if (objArr != null) {
                    if (objArr.length != null) {
                        String.format(str2, objArr);
                    }
                }
            }

            public final void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
                if (objArr != null) {
                    if (objArr.length != null) {
                        str2 = String.format(str2, objArr);
                    }
                }
                if (str2 == null) {
                    str2 = "";
                }
                str = new StringBuilder();
                str.append(str2);
                str.append("  ");
                str.append(Log.getStackTraceString(th));
            }
        };
        debugLog = anonymousClass1;
        tinkerLogImp = anonymousClass1;
    }

    public static void setTinkerLogImp(TinkerLogImp tinkerLogImp) {
        tinkerLogImp = tinkerLogImp;
    }

    public static TinkerLogImp getImpl() {
        return tinkerLogImp;
    }

    public static void v(String str, String str2, Object... objArr) {
        if (tinkerLogImp != null) {
            tinkerLogImp.v(str, str2, objArr);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (tinkerLogImp != null) {
            tinkerLogImp.e(str, str2, objArr);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (tinkerLogImp != null) {
            tinkerLogImp.w(str, str2, objArr);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (tinkerLogImp != null) {
            tinkerLogImp.i(str, str2, objArr);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (tinkerLogImp != null) {
            tinkerLogImp.d(str, str2, objArr);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (tinkerLogImp != null) {
            tinkerLogImp.printErrStackTrace(str, th, str2, objArr);
        }
    }
}
