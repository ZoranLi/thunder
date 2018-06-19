package com.tencent.tinker.commons.dexpatcher;

/* compiled from: BUGLY */
public final class DexPatcherLogger {
    private IDexPatcherLogger loggerImpl = null;

    /* compiled from: BUGLY */
    public interface IDexPatcherLogger {
        void d(String str);

        void e(String str);

        void i(String str);

        void v(String str);

        void w(String str);
    }

    public final IDexPatcherLogger getLoggerImpl() {
        return this.loggerImpl;
    }

    public final void setLoggerImpl(IDexPatcherLogger iDexPatcherLogger) {
        this.loggerImpl = iDexPatcherLogger;
    }

    public final void v(String str, String str2, Object... objArr) {
        if (this.loggerImpl != null) {
            StringBuilder stringBuilder = new StringBuilder("[V][");
            stringBuilder.append(str);
            stringBuilder.append("] ");
            stringBuilder.append(str2);
            str = stringBuilder.toString();
            str2 = this.loggerImpl;
            if (objArr != null) {
                if (objArr.length != 0) {
                    str = String.format(str, objArr);
                }
            }
            str2.v(str);
        }
    }

    public final void d(String str, String str2, Object... objArr) {
        if (this.loggerImpl != null) {
            StringBuilder stringBuilder = new StringBuilder("[D][");
            stringBuilder.append(str);
            stringBuilder.append("] ");
            stringBuilder.append(str2);
            str = stringBuilder.toString();
            str2 = this.loggerImpl;
            if (objArr != null) {
                if (objArr.length != 0) {
                    str = String.format(str, objArr);
                }
            }
            str2.d(str);
        }
    }

    public final void i(String str, String str2, Object... objArr) {
        if (this.loggerImpl != null) {
            StringBuilder stringBuilder = new StringBuilder("[I][");
            stringBuilder.append(str);
            stringBuilder.append("] ");
            stringBuilder.append(str2);
            str = stringBuilder.toString();
            str2 = this.loggerImpl;
            if (objArr != null) {
                if (objArr.length != 0) {
                    str = String.format(str, objArr);
                }
            }
            str2.i(str);
        }
    }

    public final void w(String str, String str2, Object... objArr) {
        if (this.loggerImpl != null) {
            StringBuilder stringBuilder = new StringBuilder("[W][");
            stringBuilder.append(str);
            stringBuilder.append("] ");
            stringBuilder.append(str2);
            str = stringBuilder.toString();
            str2 = this.loggerImpl;
            if (objArr != null) {
                if (objArr.length != 0) {
                    str = String.format(str, objArr);
                }
            }
            str2.w(str);
        }
    }

    public final void e(String str, String str2, Object... objArr) {
        if (this.loggerImpl != null) {
            StringBuilder stringBuilder = new StringBuilder("[E][");
            stringBuilder.append(str);
            stringBuilder.append("] ");
            stringBuilder.append(str2);
            str = stringBuilder.toString();
            str2 = this.loggerImpl;
            if (objArr != null) {
                if (objArr.length != 0) {
                    str = String.format(str, objArr);
                }
            }
            str2.e(str);
        }
    }
}
