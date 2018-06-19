package com.xunlei.downloadprovider.homepage.download;

import android.view.View;
import android.view.View.OnClickListener;
import com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr;

/* compiled from: DownloadTabFragment */
final class p implements OnClickListener {
    final /* synthetic */ DownloadTabFragment a;

    p(DownloadTabFragment downloadTabFragment) {
        this.a = downloadTabFragment;
    }

    public final void onClick(View view) {
        DownloadTabFragment.l(this.a);
        PrivateSpaceMgr.a().a(this.a.getActivity());
    }
}
