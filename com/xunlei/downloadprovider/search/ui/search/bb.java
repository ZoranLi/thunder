package com.xunlei.downloadprovider.search.ui.search;

import com.xunlei.downloadprovider.search.b.i;

/* compiled from: SearchOperateActivity */
final class bb implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ SearchOperateActivity b;

    bb(SearchOperateActivity searchOperateActivity, String str) {
        this.b = searchOperateActivity;
        this.a = str;
    }

    public final void run() {
        i.a().a(this.a, 0);
    }
}
