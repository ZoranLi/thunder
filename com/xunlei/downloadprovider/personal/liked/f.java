package com.xunlei.downloadprovider.personal.liked;

import com.xunlei.common.commonview.XLToast;

/* compiled from: LikeCinecismFragment */
final class f implements Runnable {
    final /* synthetic */ LikeCinecismFragment a;

    f(LikeCinecismFragment likeCinecismFragment) {
        this.a = likeCinecismFragment;
    }

    public final void run() {
        XLToast.showNoNetworkToast(this.a.getContext());
    }
}
