package com.xunlei.downloadprovider.download.taskdetails;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: DownloadCenterDetailFragment */
final class aa implements OnClickListener {
    final /* synthetic */ DownloadCenterDetailFragment a;

    aa(DownloadCenterDetailFragment downloadCenterDetailFragment) {
        this.a = downloadCenterDetailFragment;
    }

    public final void onClick(View view) {
        DownloadCenterDetailFragment.c(this.a);
        a.a("dl_more", this.a.h);
    }
}
