package com.xunlei.downloadprovider.vod.dlna;

import com.xunlei.downloadprovider.pushmessage.bean.PushResult;

/* compiled from: DLNAListDialog */
final class h implements Runnable {
    final /* synthetic */ b a;

    h(b bVar) {
        this.a = bVar;
    }

    public final void run() {
        this.a.n.a(this.a.e);
        this.a.v.obtainMessage(4, PushResult.UNFINISH_DOWNLOAD_NOTICE, 0).sendToTarget();
    }
}
