package com.xunlei.downloadprovider.download.taskdetails;

import com.xunlei.downloadprovider.download.taskdetails.ag.a;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.web.BrowserFrom;

/* compiled from: TaskDetailFragment */
final class aj implements a {
    final /* synthetic */ TaskDetailFragment a;

    public final void d() {
    }

    aj(TaskDetailFragment taskDetailFragment) {
        this.a = taskDetailFragment;
    }

    public final void a() {
        if (this.a.f != null) {
            this.a.f.a(this.a.b.a());
        }
    }

    public final void b() {
        if (this.a.f != null) {
            this.a.f.d();
        }
    }

    public final void a(DownloadTaskInfo downloadTaskInfo) {
        TaskDetailFragment.a(this.a, downloadTaskInfo);
    }

    public final void c() {
        if (this.a.d != null) {
            com.xunlei.downloadprovider.web.a.a();
            com.xunlei.downloadprovider.web.a.a(this.a.getActivity(), this.a.d.mRefUrl, this.a.d.mSniffKeyword, this.a.d.mWebsiteName, BrowserFrom.DL_CENTER_DETAIL);
        }
    }

    public final void a(boolean z) {
        this.a.c.a(z);
    }
}
