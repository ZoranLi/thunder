package com.xunlei.downloadprovider.download.player.views;

/* compiled from: DownloadVodPlayerView */
final class a implements Runnable {
    final /* synthetic */ DownloadVodPlayerView a;

    a(DownloadVodPlayerView downloadVodPlayerView) {
        this.a = downloadVodPlayerView;
    }

    public final void run() {
        if (this.a.i()) {
            this.a.getPlayerLeftViewGroup().a();
            return;
        }
        if (this.a.g()) {
            this.a.e();
        }
    }
}
