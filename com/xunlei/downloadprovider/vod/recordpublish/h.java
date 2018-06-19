package com.xunlei.downloadprovider.vod.recordpublish;

/* compiled from: VodPlayerPublishActivity */
final class h implements Runnable {
    final /* synthetic */ VodPlayerPublishActivity a;

    h(VodPlayerPublishActivity vodPlayerPublishActivity) {
        this.a = vodPlayerPublishActivity;
    }

    public final void run() {
        this.a.onBackPressed();
    }
}
