package com.xunlei.downloadprovider.search.ui.search;

import com.xunlei.downloadprovider.search.b.i;

/* compiled from: SearchOperateActivity */
final class ba implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ SearchOperateActivity b;

    ba(SearchOperateActivity searchOperateActivity, String str) {
        this.b = searchOperateActivity;
        this.a = str;
    }

    public final void run() {
        i.a().a(this.a);
    }
}
