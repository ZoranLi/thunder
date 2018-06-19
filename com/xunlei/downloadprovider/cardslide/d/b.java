package com.xunlei.downloadprovider.cardslide.d;

/* compiled from: CardSlideSpHelper */
final class b implements Runnable {
    final /* synthetic */ a a;

    b(a aVar) {
        this.a = aVar;
    }

    public final void run() {
        this.a.c.edit().putLong("next_dawn_time_stamp", c.a()).apply();
    }
}
