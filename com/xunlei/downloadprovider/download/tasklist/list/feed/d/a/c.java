package com.xunlei.downloadprovider.download.tasklist.list.feed.d.a;

import com.xunlei.downloadprovider.download.tasklist.list.feed.b;
import com.xunlei.downloadprovider.download.tasklist.list.feed.e.a;

/* compiled from: TouTiaoReporter */
public final class c implements a<com.xunlei.downloadprovider.download.tasklist.list.feed.c.b.c> {
    final /* synthetic */ a a = null;

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        com.xunlei.downloadprovider.download.tasklist.list.feed.c.b.c cVar = (com.xunlei.downloadprovider.download.tasklist.list.feed.c.b.c) obj;
        if (this.a != null) {
            this.a.a(cVar);
        }
    }

    public final void a(int i, String str) {
        StringBuilder stringBuilder = new StringBuilder("reportADShow. onFail. errorCode: ");
        stringBuilder.append(i);
        stringBuilder.append(" errorInfo: ");
        stringBuilder.append(str);
        b.a("ad_show_report", i, str);
        if (this.a != null) {
            this.a.a(i, str);
        }
    }
}
