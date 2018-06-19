package com.xunlei.downloadprovider.download.engine.task;

import com.xunlei.downloadprovider.download.engine.report.TaskStatInfo;
import com.xunlei.downloadprovider.download.engine.report.a;
import com.xunlei.downloadprovider.service.DownloadService;
import com.xunlei.downloadprovider.service.DownloadService.c;

/* compiled from: DownloadTaskManager */
final class u implements c {
    final /* synthetic */ m a;
    final /* synthetic */ n b;

    u(n nVar, m mVar) {
        this.b = nVar;
        this.a = mVar;
    }

    public final void a(DownloadService downloadService) {
        if (DownloadService.a() != null) {
            DownloadService.a().b().a(this.a);
            return;
        }
        if (!(this.a == null || this.a.a == null)) {
            downloadService = this.a.b;
            if (downloadService == null) {
                downloadService = new TaskStatInfo(this.a.a.mCreateOrigin, this.a.a.mDownloadUrl, this.a.a.mRefUrl);
            }
            a.a(this.a.a.mCreateOrigin, this.a.a.mDownloadUrl, 1, downloadService);
        }
    }
}
