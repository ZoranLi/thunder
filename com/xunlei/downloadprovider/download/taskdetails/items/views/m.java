package com.xunlei.downloadprovider.download.taskdetails.items.views;

import com.xunlei.downloadprovider.download.taskdetails.items.q;

/* compiled from: DownloadTaskNameAndIconView */
final class m implements Runnable {
    final /* synthetic */ DownloadTaskNameAndIconView a;

    m(DownloadTaskNameAndIconView downloadTaskNameAndIconView) {
        this.a = downloadTaskNameAndIconView;
    }

    public final void run() {
        this.a.I.setSelected(false);
        if (this.a.af != null) {
            q qVar = this.a.af.i;
            if (qVar != null) {
                qVar.a(false);
            }
            DownloadTaskNameAndIconView.l(this.a);
        }
    }
}
