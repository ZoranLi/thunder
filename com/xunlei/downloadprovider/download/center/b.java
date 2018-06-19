package com.xunlei.downloadprovider.download.center;

/* compiled from: DownloadCenterActivityFragment */
final class b implements Runnable {
    final /* synthetic */ DownloadCenterActivityFragment a;

    b(DownloadCenterActivityFragment downloadCenterActivityFragment) {
        this.a = downloadCenterActivityFragment;
    }

    public final void run() {
        try {
            if (this.a.t != null) {
                this.a.t.removeCallbacks(this);
                this.a.t.postDelayed(this, 1000);
            }
            DownloadCenterActivityFragment.b(this.a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
