package com.xunlei.downloadprovider.download.center;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.search.a;

/* compiled from: DownloadCenterActivityFragment */
final class d implements OnClickListener {
    final /* synthetic */ DownloadCenterActivityFragment a;

    d(DownloadCenterActivityFragment downloadCenterActivityFragment) {
        this.a = downloadCenterActivityFragment;
    }

    public final void onClick(View view) {
        a.a(this.a.getActivity());
        com.xunlei.downloadprovider.download.report.a.a("search", false);
    }
}
