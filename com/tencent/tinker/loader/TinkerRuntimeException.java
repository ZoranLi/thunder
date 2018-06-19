package com.tencent.tinker.loader;

/* compiled from: BUGLY */
public class TinkerRuntimeException extends RuntimeException {
    private static final String TINKER_RUNTIME_EXCEPTION_PREFIX = "Tinker Exception:";
    private static final long serialVersionUID = 1;

    public TinkerRuntimeException(String str) {
        StringBuilder stringBuilder = new StringBuilder(TINKER_RUNTIME_EXCEPTION_PREFIX);
        stringBuilder.append(str);
        super(stringBuilder.toString());
    }

    public TinkerRuntimeException(String str, Throwable th) {
        StringBuilder stringBuilder = new StringBuilder(TINKER_RUNTIME_EXCEPTION_PREFIX);
        stringBuilder.append(str);
        super(stringBuilder.toString(), th);
    }
}
