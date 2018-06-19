package com.xunlei.downloadprovider.app.a;

import com.tencent.bugly.crashreport.CrashReport;
import com.xunlei.common.report.CrashReportProxy;

/* compiled from: ApplicationInitialization */
final class b implements CrashReportProxy {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void postCatchedException(Throwable th) {
        CrashReport.postCatchedException(th);
    }
}
