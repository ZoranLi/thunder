package com.xunlei.downloadprovider.download.taskdetails.items.views;

import com.xunlei.downloadprovider.download.taskdetails.items.q;

/* compiled from: DownloadTaskNameAndIconView */
final class l implements Runnable {
    final /* synthetic */ DownloadTaskNameAndIconView a;

    l(DownloadTaskNameAndIconView downloadTaskNameAndIconView) {
        this.a = downloadTaskNameAndIconView;
    }

    public final void run() {
        this.a.I.setSelected(true);
        if (this.a.af != null) {
            q qVar = this.a.af.i;
            if (qVar != null) {
                qVar.a(true);
            }
            DownloadTaskNameAndIconView.l(this.a);
        }
    }
}
