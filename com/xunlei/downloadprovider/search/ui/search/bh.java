package com.xunlei.downloadprovider.search.ui.search;

/* compiled from: SearchOperateActivity */
final class bh implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ bg b;

    bh(bg bgVar, String str) {
        this.b = bgVar;
        this.a = str;
    }

    public final void run() {
        SearchOperateActivity.a(this.b.b, this.a);
        SearchOperateActivity.b(this.b.b).setText(this.a);
        SearchOperateActivity.c(this.b.b).setHint("你最近复制的下载链接，点击下载");
        SearchOperateActivity.d(this.b.b).setVisibility(0);
    }
}
