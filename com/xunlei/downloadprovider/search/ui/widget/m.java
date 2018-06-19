package com.xunlei.downloadprovider.search.ui.widget;

import com.xunlei.downloadprovider.search.b.i;

/* compiled from: SearchHistoryListView */
final class m implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ String b;
    final /* synthetic */ b c;

    m(b bVar, String str, String str2) {
        this.c = bVar;
        this.a = str;
        this.b = str2;
    }

    public final void run() {
        i.a().a(this.a, this.b);
    }
}
