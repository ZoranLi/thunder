package com.xunlei.downloadprovider.download.center.widget;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: DownloadBriefInfoHeaderView */
final class c implements OnClickListener {
    final /* synthetic */ DownloadBriefInfoHeaderView a;

    c(DownloadBriefInfoHeaderView downloadBriefInfoHeaderView) {
        this.a = downloadBriefInfoHeaderView;
    }

    public final void onClick(View view) {
        if (this.a.J != null) {
            this.a.J.b();
        }
    }
}
