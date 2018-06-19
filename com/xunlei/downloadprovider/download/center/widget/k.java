package com.xunlei.downloadprovider.download.center.widget;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: DownloadCenterSelectFileTitleView */
final class k implements OnClickListener {
    final /* synthetic */ DownloadCenterSelectFileTitleView a;

    k(DownloadCenterSelectFileTitleView downloadCenterSelectFileTitleView) {
        this.a = downloadCenterSelectFileTitleView;
    }

    public final void onClick(View view) {
        if (this.a.e != null) {
            this.a.c.setVisibility(8);
            this.a.d.setVisibility(0);
            this.a.e.a(true);
        }
    }
}
