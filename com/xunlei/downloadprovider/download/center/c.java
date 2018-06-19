package com.xunlei.downloadprovider.download.center;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr;

/* compiled from: DownloadCenterActivityFragment */
final class c implements OnClickListener {
    final /* synthetic */ DownloadCenterActivityFragment a;

    c(DownloadCenterActivityFragment downloadCenterActivityFragment) {
        this.a = downloadCenterActivityFragment;
    }

    public final void onClick(View view) {
        PrivateSpaceMgr.a().a(this.a.getActivity());
    }
}
