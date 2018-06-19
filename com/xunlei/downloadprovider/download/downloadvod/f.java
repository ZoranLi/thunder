package com.xunlei.downloadprovider.download.downloadvod;

import com.xunlei.common.commonview.XLToast;
import com.xunlei.downloadprovider.app.BrothersApplication;
import com.xunlei.downloadprovider.download.engine.task.c;
import com.xunlei.downloadprovider.download.engine.task.info.TaskInfo;

/* compiled from: DownloadVodImpl */
final class f implements c {
    final /* synthetic */ a$b a;

    public final void a(TaskInfo taskInfo, int i, int i2) {
    }

    f(a$b com_xunlei_downloadprovider_download_downloadvod_a_b) {
        this.a = com_xunlei_downloadprovider_download_downloadvod_a_b;
    }

    public final void b(TaskInfo taskInfo, int i, int i2) {
        if (this.a.a == null) {
            XLToast.showToast(BrothersApplication.getApplicationInstance(), "创建下载成功");
        }
    }
}
