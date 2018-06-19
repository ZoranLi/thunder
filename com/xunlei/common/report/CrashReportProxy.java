package com.xunlei.common.report;

public interface CrashReportProxy {
    void postCatchedException(Throwable th);
}
