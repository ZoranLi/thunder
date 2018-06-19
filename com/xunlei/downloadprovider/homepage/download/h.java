package com.xunlei.downloadprovider.homepage.download;

/* compiled from: DownloadTabFragment */
final class h implements Runnable {
    final /* synthetic */ DownloadTabFragment a;

    h(DownloadTabFragment downloadTabFragment) {
        this.a = downloadTabFragment;
    }

    public final void run() {
        try {
            if (this.a.p != null) {
                this.a.p.removeCallbacks(this);
                this.a.p.postDelayed(this, 1000);
            }
            DownloadTabFragment downloadTabFragment = this.a;
            if (downloadTabFragment.a) {
                downloadTabFragment.a();
            } else {
                downloadTabFragment.b();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
