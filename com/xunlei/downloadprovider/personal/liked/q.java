package com.xunlei.downloadprovider.personal.liked;

import com.xunlei.common.commonview.XLToast;

/* compiled from: LikeShortVideoFragment */
final class q implements Runnable {
    final /* synthetic */ LikeShortVideoFragment a;

    q(LikeShortVideoFragment likeShortVideoFragment) {
        this.a = likeShortVideoFragment;
    }

    public final void run() {
        XLToast.showNoNetworkToast(this.a.getContext());
    }
}
