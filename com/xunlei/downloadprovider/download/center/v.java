package com.xunlei.downloadprovider.download.center;

/* compiled from: DownloadCenterActivityFragment */
final class v implements Runnable {
    final /* synthetic */ DownloadCenterActivityFragment a;

    v(DownloadCenterActivityFragment downloadCenterActivityFragment) {
        this.a = downloadCenterActivityFragment;
    }

    public final void run() {
        if (this.a.isVisible()) {
            this.a.s.a(false, false);
            this.a.s.a();
        }
    }
}
