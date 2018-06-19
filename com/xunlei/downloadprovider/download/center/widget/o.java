package com.xunlei.downloadprovider.download.center.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: DownloadCenterSelectFileTitleView */
final class o implements AnimationListener {
    final /* synthetic */ DownloadCenterSelectFileTitleView a;

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    o(DownloadCenterSelectFileTitleView downloadCenterSelectFileTitleView) {
        this.a = downloadCenterSelectFileTitleView;
    }

    public final void onAnimationEnd(Animation animation) {
        this.a.setVisibility(8);
        this.a.setAnimation(null);
    }
}
