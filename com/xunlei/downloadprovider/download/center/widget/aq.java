package com.xunlei.downloadprovider.download.center.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: DownloadTitleBarView */
final class aq implements AnimationListener {
    final /* synthetic */ DownloadTitleBarView a;

    public final void onAnimationRepeat(Animation animation) {
    }

    aq(DownloadTitleBarView downloadTitleBarView) {
        this.a = downloadTitleBarView;
    }

    public final void onAnimationStart(Animation animation) {
        this.a.l = 1;
    }

    public final void onAnimationEnd(Animation animation) {
        this.a.l = 0;
    }
}
