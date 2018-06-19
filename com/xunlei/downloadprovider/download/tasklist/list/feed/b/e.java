package com.xunlei.downloadprovider.download.tasklist.list.feed.b;

import com.xunlei.downloadprovider.download.tasklist.list.a;
import com.xunlei.downloadprovider.download.tasklist.list.feed.b;
import com.xunlei.xllib.b.d;

/* compiled from: HomeDownloadCenterFeedRefreshController */
final class e implements Runnable {
    final /* synthetic */ c a;

    e(c cVar) {
        this.a = cVar;
    }

    public final void run() {
        a c = this.a.g;
        if (!d.a(c.a.b)) {
            c.a.b.clear();
            c.g.l = false;
            c.notifyDataSetChanged();
        }
        b.a();
    }
}
