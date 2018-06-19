package com.xunlei.downloadprovider.download.taskdetails;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.create.DownloadBtFileExplorerActivity;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: DownloadCenterDetailFragment */
final class k implements OnClickListener {
    final /* synthetic */ DownloadCenterDetailFragment a;

    k(DownloadCenterDetailFragment downloadCenterDetailFragment) {
        this.a = downloadCenterDetailFragment;
    }

    public final void onClick(View view) {
        if (this.a.h != null) {
            String str = this.a.h.mUrl;
            a.a("dl_more_bt_add", this.a.h);
            DownloadBtFileExplorerActivity.a(this.a.getActivity(), str, com.xunlei.downloadprovider.download.util.k.f(this.a.h), this.a.h.getTaskId(), 9, null, this.a.h.mRefUrl, this.a.h.mWebsiteName);
        }
    }
}
