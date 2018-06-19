package com.xunlei.downloadprovider.personal.lixianspace.ui;

import android.os.Message;
import com.xunlei.downloadlib.parameter.TorrentFileInfo;
import com.xunlei.downloadlib.parameter.TorrentInfo;

/* compiled from: LXSpaceCreateTaskByMagnetUrlActivity */
final class r implements Runnable {
    final /* synthetic */ TorrentFileInfo[] a;
    final /* synthetic */ TorrentInfo b;
    final /* synthetic */ q c;

    r(q qVar, TorrentFileInfo[] torrentFileInfoArr, TorrentInfo torrentInfo) {
        this.c = qVar;
        this.a = torrentFileInfoArr;
        this.b = torrentInfo;
    }

    public final void run() {
        if (this.a != null && this.a.length > 0) {
            for (TorrentFileInfo a : this.a) {
                c a2 = LXSpaceCreateTaskByMagnetUrlActivity.a(a);
                LXSpaceCreateTaskByMagnetUrlActivity.a(a2);
                this.c.a.i.add(a2);
            }
        }
        Message obtainMessage = this.c.a.n.obtainMessage();
        obtainMessage.what = 2;
        obtainMessage.obj = this.b;
        this.c.a.n.sendMessage(obtainMessage);
    }
}
