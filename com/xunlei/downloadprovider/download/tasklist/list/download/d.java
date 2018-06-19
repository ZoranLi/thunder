package com.xunlei.downloadprovider.download.tasklist.list.download;

/* compiled from: TaskDownloadCardViewHolder */
final class d implements Runnable {
    final /* synthetic */ TaskDownloadCardViewHolder a;

    d(TaskDownloadCardViewHolder taskDownloadCardViewHolder) {
        this.a = taskDownloadCardViewHolder;
    }

    public final void run() {
        this.a.refreshSelf();
    }
}
