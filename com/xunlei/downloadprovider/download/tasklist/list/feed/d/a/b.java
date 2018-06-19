package com.xunlei.downloadprovider.download.tasklist.list.feed.d.a;

import com.xunlei.downloadprovider.download.tasklist.list.feed.c.b.c;
import com.xunlei.downloadprovider.download.tasklist.list.feed.e.a;

/* compiled from: TouTiaoReporter */
public final class b implements a<c> {
    final /* synthetic */ a a = null;

    public final /* bridge */ /* synthetic */ void a(Object obj) {
        c cVar = (c) obj;
        if (this.a != null) {
            this.a.a(cVar);
        }
    }

    public final void a(int i, String str) {
        StringBuilder stringBuilder = new StringBuilder("reportSingleNewsClick. onFail. errorCode: ");
        stringBuilder.append(i);
        stringBuilder.append(" errorInfo: ");
        stringBuilder.append(str);
        com.xunlei.downloadprovider.download.tasklist.list.feed.b.a("news_click_report", i, str);
        if (this.a != null) {
            this.a.a(i, str);
        }
    }
}
