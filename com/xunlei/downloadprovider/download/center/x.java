package com.xunlei.downloadprovider.download.center;

import com.xunlei.downloadprovider.download.privatespace.PrivateSpaceMgr;
import com.xunlei.downloadprovider.member.login.b.d;

/* compiled from: DownloadCenterActivityFragment */
final class x implements d {
    final /* synthetic */ DownloadCenterActivityFragment a;

    x(DownloadCenterActivityFragment downloadCenterActivityFragment) {
        this.a = downloadCenterActivityFragment;
    }

    public final void onLoginCompleted(boolean z, int i, boolean z2) {
        PrivateSpaceMgr.a();
        PrivateSpaceMgr.j();
        this.a.h();
    }
}
