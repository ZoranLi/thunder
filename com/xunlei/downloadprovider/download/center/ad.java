package com.xunlei.downloadprovider.download.center;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.report.a;

/* compiled from: DownloadCenterActivityFragment */
final class ad implements OnClickListener {
    final /* synthetic */ DownloadCenterActivityFragment a;

    ad(DownloadCenterActivityFragment downloadCenterActivityFragment) {
        this.a = downloadCenterActivityFragment;
    }

    public final void onClick(View view) {
        a.a("back", false);
        this.a.getActivity().finish();
    }
}
