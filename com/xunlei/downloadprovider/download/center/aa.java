package com.xunlei.downloadprovider.download.center;

import com.xunlei.downloadprovider.download.engine.task.info.TaskCountsStatistics;
import com.xunlei.downloadprovider.download.report.a;
import com.xunlei.downloadprovider.download.tasklist.TaskListPageFragment;
import com.xunlei.downloadprovider.download.tasklist.task.h;

/* compiled from: DownloadCenterActivityFragment */
final class aa implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ DownloadCenterTabBaseFragment b;
    final /* synthetic */ DownloadCenterActivityFragment c;

    aa(DownloadCenterActivityFragment downloadCenterActivityFragment, int i, DownloadCenterTabBaseFragment downloadCenterTabBaseFragment) {
        this.c = downloadCenterActivityFragment;
        this.a = i;
        this.b = downloadCenterTabBaseFragment;
    }

    public final void run() {
        h.e();
        TaskCountsStatistics c = h.c();
        if (this.a == 0) {
            if (this.b instanceof TaskListPageFragment) {
                a.a("total", c.mTotalCount, ((TaskListPageFragment) this.b).h.size(), "");
            }
        } else if (this.a == 1) {
            if (this.b instanceof TaskListPageFragment) {
                a.a("downloading", c.getUnfinishedTaskCount(), ((TaskListPageFragment) this.b).h.size(), "");
            }
        } else if (this.a == 2 && (this.b instanceof TaskListPageFragment)) {
            a.a("finish", c.getFinishedTaskCount(), ((TaskListPageFragment) this.b).h.size(), "");
        }
    }
}
