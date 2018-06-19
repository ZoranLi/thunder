package com.xunlei.downloadprovider.homepage.choiceness.ui.items;

/* compiled from: ChoicenessLiveStoryItemView */
final class o implements Runnable {
    final /* synthetic */ b a;

    o(b bVar) {
        this.a = bVar;
    }

    public final void run() {
        this.a.l.setVisibility(8);
        this.a.e.setSelected(true);
        this.a.e.setVisibility(0);
        this.a.j.setVisibility(8);
        this.a.k.stop();
    }
}
