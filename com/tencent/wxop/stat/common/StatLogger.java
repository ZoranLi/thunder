package com.tencent.wxop.stat.common;

import com.taobao.accs.AccsClientConfig;
import com.tencent.wxop.stat.StatConfig;
import com.tencent.wxop.stat.g;
import com.umeng.message.proguard.k;
import com.xiaomi.mipush.sdk.Constants;

public final class StatLogger {
    private String a = AccsClientConfig.DEFAULT_CONFIGTAG;
    private boolean b = true;
    private int c = 2;

    public StatLogger(String str) {
        this.a = str;
    }

    private String a() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null) {
            return null;
        }
        int length = stackTrace.length;
        int i = 0;
        while (i < length) {
            StackTraceElement stackTraceElement = stackTrace[i];
            if (stackTraceElement.isNativeMethod() || stackTraceElement.getClassName().equals(Thread.class.getName()) || stackTraceElement.getClassName().equals(getClass().getName())) {
                i++;
            } else {
                StringBuilder stringBuilder = new StringBuilder("[");
                stringBuilder.append(Thread.currentThread().getName());
                stringBuilder.append(k.s);
                stringBuilder.append(Thread.currentThread().getId());
                stringBuilder.append("): ");
                stringBuilder.append(stackTraceElement.getFileName());
                stringBuilder.append(Constants.COLON_SEPARATOR);
                stringBuilder.append(stackTraceElement.getLineNumber());
                stringBuilder.append("]");
                return stringBuilder.toString();
            }
        }
        return null;
    }

    public final void d(Object obj) {
        if (isDebugEnable()) {
            debug(obj);
        }
    }

    public final void debug(Object obj) {
        if (this.c <= 3) {
            String a = a();
            if (a == null) {
                obj = obj.toString();
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(a);
                stringBuilder.append(" - ");
                stringBuilder.append(obj);
                obj = stringBuilder.toString();
            }
            g customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.e(obj);
            }
        }
    }

    public final void e(Object obj) {
        if (isDebugEnable()) {
            error(obj);
        }
    }

    public final void e(Throwable th) {
        if (isDebugEnable()) {
            error(th);
        }
    }

    public final void error(Object obj) {
        if (this.c <= 6) {
            String a = a();
            if (a == null) {
                obj = obj.toString();
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(a);
                stringBuilder.append(" - ");
                stringBuilder.append(obj);
                obj = stringBuilder.toString();
            }
            g customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.d(obj);
            }
        }
    }

    public final void error(Throwable th) {
        if (this.c <= 6) {
            g customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.d(th);
            }
        }
    }

    public final int getLogLevel() {
        return this.c;
    }

    public final void i(Object obj) {
        if (isDebugEnable()) {
            info(obj);
        }
    }

    public final void info(Object obj) {
        if (this.c <= 4) {
            String a = a();
            if (a == null) {
                obj = obj.toString();
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(a);
                stringBuilder.append(" - ");
                stringBuilder.append(obj);
                obj = stringBuilder.toString();
            }
            g customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.a(obj);
            }
        }
    }

    public final boolean isDebugEnable() {
        return this.b;
    }

    public final void setDebugEnable(boolean z) {
        this.b = z;
    }

    public final void setLogLevel(int i) {
        this.c = i;
    }

    public final void setTag(String str) {
        this.a = str;
    }

    public final void v(Object obj) {
        if (isDebugEnable()) {
            verbose(obj);
        }
    }

    public final void verbose(Object obj) {
        if (this.c <= 2) {
            String a = a();
            if (a == null) {
                obj = obj.toString();
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(a);
                stringBuilder.append(" - ");
                stringBuilder.append(obj);
                obj = stringBuilder.toString();
            }
            g customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.b(obj);
            }
        }
    }

    public final void w(Object obj) {
        if (isDebugEnable()) {
            warn(obj);
        }
    }

    public final void warn(Object obj) {
        if (this.c <= 5) {
            String a = a();
            if (a == null) {
                obj = obj.toString();
            } else {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(a);
                stringBuilder.append(" - ");
                stringBuilder.append(obj);
                obj = stringBuilder.toString();
            }
            g customLogger = StatConfig.getCustomLogger();
            if (customLogger != null) {
                customLogger.c(obj);
            }
        }
    }
}
