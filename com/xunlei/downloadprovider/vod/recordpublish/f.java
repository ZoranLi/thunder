package com.xunlei.downloadprovider.vod.recordpublish;

/* compiled from: RecordVideoPreviewActivity */
final class f implements Runnable {
    final /* synthetic */ RecordVideoPreviewActivity a;

    f(RecordVideoPreviewActivity recordVideoPreviewActivity) {
        this.a = recordVideoPreviewActivity;
    }

    public final void run() {
        this.a.onBackPressed();
    }
}
