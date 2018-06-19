package com.xunlei.downloadprovider.homepage.download;

/* compiled from: DownloadTabFragment */
final class j implements Runnable {
    final /* synthetic */ DownloadTabFragment a;

    j(DownloadTabFragment downloadTabFragment) {
        this.a = downloadTabFragment;
    }

    public final void run() {
        if (this.a.isVisible()) {
            this.a.e.a(false, false);
            this.a.e.b();
        }
    }
}
