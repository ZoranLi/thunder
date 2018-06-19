package com.xunlei.downloadprovider.download.tasklist.list.download;

import com.xunlei.downloadprovider.download.tasklist.list.banner.c.f$a;

/* compiled from: TaskDownloadCardViewHolder */
final class f implements f$a {
    final /* synthetic */ TaskDownloadCardViewHolder a;

    f(TaskDownloadCardViewHolder taskDownloadCardViewHolder) {
        this.a = taskDownloadCardViewHolder;
    }

    public final void a() {
        if (this.a.mFreeTrailView != null && this.a.mFreeTrailView.h() == 0) {
            this.a.mFreeTrailView.a(this.a.mTaskInfo, false);
        }
    }
}
