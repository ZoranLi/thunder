package com.xunlei.downloadprovider.download.center.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: DownloadCenterSelectFileTitleView */
final class n implements AnimationListener {
    final /* synthetic */ DownloadCenterSelectFileTitleView a;

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    n(DownloadCenterSelectFileTitleView downloadCenterSelectFileTitleView) {
        this.a = downloadCenterSelectFileTitleView;
    }

    public final void onAnimationEnd(Animation animation) {
        this.a.setAnimation(null);
        if (this.a.f != null) {
            this.a.f.a();
        }
    }
}
