package com.xunlei.downloadprovider.download.downloadvod;

import com.xunlei.common.concurrent.XLThreadPool;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;
import com.xunlei.downloadprovider.download.engine.task.x.a;

/* compiled from: DownloadVodImpl */
final class d implements a<TaskInfo> {
    final /* synthetic */ a$b a;

    d(a$b com_xunlei_downloadprovider_download_downloadvod_a_b) {
        this.a = com_xunlei_downloadprovider_download_downloadvod_a_b;
    }

    public final /* synthetic */ void a(Object obj) {
        XLThreadPool.execute(new e(this, (TaskInfo) obj));
    }
}
