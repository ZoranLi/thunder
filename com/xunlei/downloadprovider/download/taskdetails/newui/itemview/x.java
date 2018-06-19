package com.xunlei.downloadprovider.download.taskdetails.newui.itemview;

import com.xunlei.downloadprovider.download.taskdetails.items.q;

/* compiled from: DownloadTaskNameAndIconView_New */
final class x implements Runnable {
    final /* synthetic */ DownloadTaskNameAndIconView_New a;

    x(DownloadTaskNameAndIconView_New downloadTaskNameAndIconView_New) {
        this.a = downloadTaskNameAndIconView_New;
    }

    public final void run() {
        this.a.F.setSelected(false);
        if (this.a.ae != null) {
            q qVar = this.a.ae.i;
            if (qVar != null) {
                qVar.a(false);
            }
            DownloadTaskNameAndIconView_New.l(this.a);
        }
    }
}
