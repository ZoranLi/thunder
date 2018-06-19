package com.xunlei.downloadprovider.download.taskdetails;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: DownloadCenterDetailFragment */
final class ad implements OnClickListener {
    final /* synthetic */ DownloadCenterDetailFragment a;

    ad(DownloadCenterDetailFragment downloadCenterDetailFragment) {
        this.a = downloadCenterDetailFragment;
    }

    public final void onClick(View view) {
        a.a("dl_delete", this.a.h);
        this.a.a(true);
    }
}
