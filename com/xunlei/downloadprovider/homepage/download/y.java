package com.xunlei.downloadprovider.homepage.download;

import com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr;
import com.xunlei.downloadprovider.member.login.b.d;

/* compiled from: DownloadTabFragment */
final class y implements d {
    final /* synthetic */ DownloadTabFragment a;

    y(DownloadTabFragment downloadTabFragment) {
        this.a = downloadTabFragment;
    }

    public final void onLoginCompleted(boolean z, int i, boolean z2) {
        PrivateSpaceMgr.a();
        PrivateSpaceMgr.j();
        if (z) {
            this.a.d.a.p = false;
        }
        this.a.a(new z(this), 0);
    }
}
