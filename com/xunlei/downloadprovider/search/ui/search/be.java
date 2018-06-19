package com.xunlei.downloadprovider.search.ui.search;

import com.xunlei.downloadprovider.search.b.i;

/* compiled from: SearchOperateActivity */
final class be implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ SearchOperateActivity c;

    be(SearchOperateActivity searchOperateActivity, String str, String str2) {
        this.c = searchOperateActivity;
        this.a = str;
        this.b = str2;
    }

    public final void run() {
        i.a().a(this.a, this.b);
    }
}
