package com.xunlei.downloadprovider.download.taskdetails;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: DownloadCenterDetailFragment */
final class ac implements OnClickListener {
    final /* synthetic */ DownloadCenterDetailFragment a;

    ac(DownloadCenterDetailFragment downloadCenterDetailFragment) {
        this.a = downloadCenterDetailFragment;
    }

    public final void onClick(View view) {
        if (this.a.n == null && this.a.b == null) {
            this.a.a(true);
        }
    }
}
