package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

import com.xunlei.downloadprovider.homepage.choiceness.a.a.j;

/* compiled from: ChoicenessLiveStoryItemView */
final class l implements Runnable {
    final /* synthetic */ int a;
    final /* synthetic */ j b;
    final /* synthetic */ b c;

    l(b bVar, int i, j jVar) {
        this.c = bVar;
        this.a = i;
        this.b = jVar;
    }

    public final void run() {
        this.c.a(this.a, this.b);
    }
}
