package com.xunlei.downloadprovider.frame;

/* compiled from: BaseViewPagerFragment */
final class b implements Runnable {
    final /* synthetic */ BaseViewPagerFragment a;

    b(BaseViewPagerFragment baseViewPagerFragment) {
        this.a = baseViewPagerFragment;
    }

    public final void run() {
        if (this.a.b != null) {
            this.a.b.setOffscreenPageLimit(this.a.g().length);
        }
    }
}
