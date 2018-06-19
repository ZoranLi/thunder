package com.xunlei.downloadprovider.download.tasklist.list.feed.b;

import android.os.Handler.Callback;
import android.os.Message;

/* compiled from: HomeDownloadCenterFeedRefreshController */
final class d implements Callback {
    final /* synthetic */ c a;

    d(c cVar) {
        this.a = cVar;
    }

    public final boolean handleMessage(Message message) {
        if (message.what == 1000) {
            this.a.e = true;
            this.a.b.post(new e(this.a));
        }
        return true;
    }
}
