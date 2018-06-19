package com.xunlei.downloadprovider.download.taskdetails.newui.itemview;

import com.xunlei.downloadprovider.download.taskdetails.items.q;

/* compiled from: DownloadTaskNameAndIconView_New */
final class w implements Runnable {
    final /* synthetic */ DownloadTaskNameAndIconView_New a;

    w(DownloadTaskNameAndIconView_New downloadTaskNameAndIconView_New) {
        this.a = downloadTaskNameAndIconView_New;
    }

    public final void run() {
        this.a.F.setSelected(true);
        if (this.a.ae != null) {
            q qVar = this.a.ae.i;
            if (qVar != null) {
                qVar.a(true);
            }
            DownloadTaskNameAndIconView_New.l(this.a);
        }
    }
}
