package com.xunlei.downloadprovider.homepage.download;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;
import com.xunlei.downloadprovider.web.website.activity.DownloadTabWebsiteActivity;

/* compiled from: DownloadBriefInfoView */
final class b implements OnClickListener {
    final /* synthetic */ DownloadBriefInfoView a;

    b(DownloadBriefInfoView downloadBriefInfoView) {
        this.a = downloadBriefInfoView;
    }

    public final void onClick(View view) {
        a.a("top_collect", this.a.B.getVisibility() == 0);
        DownloadTabWebsiteActivity.a(this.a.getContext());
        this.a.a();
    }
}
