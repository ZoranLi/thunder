package com.xunlei.downloadprovider.homepage.download;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: DownloadTabFragment */
final class u implements OnClickListener {
    final /* synthetic */ DownloadTabFragment a;

    u(DownloadTabFragment downloadTabFragment) {
        this.a = downloadTabFragment;
    }

    public final void onClick(View view) {
        a.a("top_act", false);
        DownloadTabFragment.e(this.a);
    }
}
