package com.xunlei.downloadprovider.search.ui.search;

import com.xunlei.downloadprovider.search.b.i;

/* compiled from: SearchOperateActivity */
final class bn implements Runnable {
    final /* synthetic */ SearchOperateActivity a;

    bn(SearchOperateActivity searchOperateActivity) {
        this.a = searchOperateActivity;
    }

    public final void run() {
        this.a.runOnUiThread(new bo(this, i.a().b()));
    }
}
