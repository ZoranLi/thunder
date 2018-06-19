package com.xunlei.downloadprovider.download.taskdetails;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: DownloadCenterDetailFragment */
final class ab implements OnClickListener {
    final /* synthetic */ DownloadCenterDetailFragment a;

    ab(DownloadCenterDetailFragment downloadCenterDetailFragment) {
        this.a = downloadCenterDetailFragment;
    }

    public final void onClick(View view) {
        this.a.g();
        a.a("share", this.a.h);
    }
}
