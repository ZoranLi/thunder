package com.xunlei.downloadprovider.download.taskdetails.newui;

import com.xunlei.downloadprovider.download.taskdetails.ag.a;
import com.xunlei.downloadprovider.download.tasklist.task.DownloadTaskInfo;
import com.xunlei.downloadprovider.web.BrowserFrom;

/* compiled from: DownloadDetailsActivityFragment */
final class o implements a {
    final /* synthetic */ DownloadDetailsActivityFragment a;

    o(DownloadDetailsActivityFragment downloadDetailsActivityFragment) {
        this.a = downloadDetailsActivityFragment;
    }

    public final void a() {
        this.a.n();
    }

    public final void b() {
        this.a.k();
    }

    public final void a(DownloadTaskInfo downloadTaskInfo) {
        DownloadDetailsActivityFragment.a(this.a, downloadTaskInfo);
    }

    public final void c() {
        if (!(this.a.f == null || this.a.getActivity() == null)) {
            com.xunlei.downloadprovider.web.a.a();
            com.xunlei.downloadprovider.web.a.a(this.a.getActivity(), this.a.f.mRefUrl, this.a.f.mSniffKeyword, this.a.f.mWebsiteName, BrowserFrom.DL_CENTER_DETAIL);
        }
    }

    public final void d() {
        this.a.I.postDelayed(new p(this), 500);
    }

    public final void a(boolean z) {
        this.a.d.a(z);
    }
}
