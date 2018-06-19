package com.xunlei.downloadprovider.download.taskdetails;

/* compiled from: DownloadCenterDetailFragment */
final class w implements Runnable {
    final /* synthetic */ DownloadCenterDetailFragment a;

    w(DownloadCenterDetailFragment downloadCenterDetailFragment) {
        this.a = downloadCenterDetailFragment;
    }

    public final void run() {
        try {
            if (this.a.g != null) {
                this.a.g.removeCallbacks(this);
                this.a.g.postDelayed(this, 1000);
            }
            this.a.f();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
