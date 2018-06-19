package com.xunlei.downloadprovider.download.taskdetails;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: DownloadCenterDetailFragment */
final class p implements AnimationListener {
    final /* synthetic */ DownloadCenterDetailFragment a;

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    p(DownloadCenterDetailFragment downloadCenterDetailFragment) {
        this.a = downloadCenterDetailFragment;
    }

    public final void onAnimationEnd(Animation animation) {
        this.a.u.setAnimation(null);
    }
}
