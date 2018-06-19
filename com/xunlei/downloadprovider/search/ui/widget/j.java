package com.xunlei.downloadprovider.search.ui.widget;

/* compiled from: SearchHistoryListView */
final class j implements Runnable {
    final /* synthetic */ i a;

    j(i iVar) {
        this.a = iVar;
    }

    public final void run() {
        if (this.a.a.a != null && this.a.a.a.getCount() != 0) {
            b b = this.a.a.a;
            if (b.a != null) {
                b.a.clear();
            }
            this.a.a.a.notifyDataSetChanged();
            if (this.a.a.b != null) {
                this.a.a.b.c();
            }
        }
    }
}
