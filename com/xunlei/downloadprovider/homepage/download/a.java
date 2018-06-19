package com.xunlei.downloadprovider.homepage.download;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: DownloadBriefInfoView */
final class a implements OnClickListener {
    final /* synthetic */ DownloadBriefInfoView a;

    a(DownloadBriefInfoView downloadBriefInfoView) {
        this.a = downloadBriefInfoView;
    }

    public final void onClick(View view) {
        com.xunlei.downloadprovider.download.report.a.a("top_manual", false);
        DownloadBriefInfoView.a(this.a);
    }
}
