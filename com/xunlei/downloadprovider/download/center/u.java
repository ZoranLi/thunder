package com.xunlei.downloadprovider.download.center;

import com.xunlei.downloadprovider.member.login.LoginHelper;
import com.xunlei.downloadprovider.member.login.b.l;

/* compiled from: DownloadCenterActivityFragment */
final class u implements Runnable {
    final /* synthetic */ DownloadCenterActivityFragment a;

    u(DownloadCenterActivityFragment downloadCenterActivityFragment) {
        this.a = downloadCenterActivityFragment;
    }

    public final void run() {
        if (this.a.isVisible()) {
            LoginHelper.a();
            boolean z = l.b() && LoginHelper.a().l();
            this.a.s.a(true, z);
            this.a.s.a();
            this.a.c(true);
        }
    }
}
