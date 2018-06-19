package com.xunlei.downloadprovider.search.ui.widget;

/* compiled from: SearchHistoryListView */
final class i implements Runnable {
    final /* synthetic */ SearchHistoryListView a;

    i(SearchHistoryListView searchHistoryListView) {
        this.a = searchHistoryListView;
    }

    public final void run() {
        com.xunlei.downloadprovider.search.b.i.a().c();
        this.a.post(new j(this));
    }
}
