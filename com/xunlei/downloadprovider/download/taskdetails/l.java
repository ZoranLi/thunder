package com.xunlei.downloadprovider.download.taskdetails;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.openwith.d;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: DownloadCenterDetailFragment */
final class l implements OnClickListener {
    final /* synthetic */ DownloadCenterDetailFragment a;

    l(DownloadCenterDetailFragment downloadCenterDetailFragment) {
        this.a = downloadCenterDetailFragment;
    }

    public final void onClick(View view) {
        if (this.a.h != null) {
            a.a("dl_more_open_type", this.a.h);
            d.a(this.a.getActivity(), this.a.h.mLocalFileName, true);
        }
    }
}
