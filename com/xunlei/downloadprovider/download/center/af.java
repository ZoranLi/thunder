package com.xunlei.downloadprovider.download.center;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: DownloadCenterActivityFragment */
final class af implements OnClickListener {
    final /* synthetic */ DownloadCenterActivityFragment a;

    af(DownloadCenterActivityFragment downloadCenterActivityFragment) {
        this.a = downloadCenterActivityFragment;
    }

    public final void onClick(View view) {
        a.a("top_act", false);
        DownloadCenterActivityFragment.i(this.a);
    }
}
