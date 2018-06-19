package com.xunlei.downloadprovider.homepage.download;

import com.xunlei.downloadprovider.download.engine.task.info.TaskCountsStatistics;
import com.xunlei.downloadprovider.download.report.a;
import com.xunlei.downloadprovider.download.tasklist.TaskListPageFragment;
import com.xunlei.downloadprovider.download.tasklist.task.h;

/* compiled from: DownloadTabFragment */
final class t implements Runnable {
    final /* synthetic */ DownloadTabFragment a;

    t(DownloadTabFragment downloadTabFragment) {
        this.a = downloadTabFragment;
    }

    public final void run() {
        TaskListPageFragment taskListPageFragment = this.a.d.a;
        h.e();
        TaskCountsStatistics c = h.c();
        if (taskListPageFragment != null) {
            a.a("total", c.mTotalCount, taskListPageFragment.h.size(), "");
        }
    }
}
