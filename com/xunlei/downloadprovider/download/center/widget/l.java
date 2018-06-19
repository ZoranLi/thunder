package com.xunlei.downloadprovider.download.center.widget;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: DownloadCenterSelectFileTitleView */
final class l implements OnClickListener {
    final /* synthetic */ DownloadCenterSelectFileTitleView a;

    l(DownloadCenterSelectFileTitleView downloadCenterSelectFileTitleView) {
        this.a = downloadCenterSelectFileTitleView;
    }

    public final void onClick(View view) {
        if (this.a.e != null) {
            this.a.e.a(false);
            this.a.c.setVisibility(0);
            this.a.d.setVisibility(8);
        }
    }
}
