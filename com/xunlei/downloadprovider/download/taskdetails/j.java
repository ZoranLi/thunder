package com.xunlei.downloadprovider.download.taskdetails;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: DownloadCenterDetailFragment */
final class j implements OnClickListener {
    final /* synthetic */ DownloadCenterDetailFragment a;

    j(DownloadCenterDetailFragment downloadCenterDetailFragment) {
        this.a = downloadCenterDetailFragment;
    }

    public final void onClick(View view) {
        this.a.b(true);
        a.a("dl_more_bt_delete", this.a.h);
    }
}
