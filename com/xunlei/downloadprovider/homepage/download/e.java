package com.xunlei.downloadprovider.homepage.download;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: DownloadBriefInfoView */
final class e implements OnClickListener {
    final /* synthetic */ DownloadBriefInfoView a;

    e(DownloadBriefInfoView downloadBriefInfoView) {
        this.a = downloadBriefInfoView;
    }

    public final void onClick(View view) {
        if (this.a.r != null) {
            this.a.r.b();
        }
    }
}
