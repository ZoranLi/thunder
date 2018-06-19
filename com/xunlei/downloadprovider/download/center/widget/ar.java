package com.xunlei.downloadprovider.download.center.widget;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: DownloadTitleBarView */
final class ar implements AnimationListener {
    final /* synthetic */ int a;
    final /* synthetic */ DownloadTitleBarView b;

    public final void onAnimationRepeat(Animation animation) {
    }

    ar(DownloadTitleBarView downloadTitleBarView, int i) {
        this.b = downloadTitleBarView;
        this.a = i;
    }

    public final void onAnimationStart(Animation animation) {
        this.b.l = 2;
    }

    public final void onAnimationEnd(Animation animation) {
        this.b.l = 0;
        this.b.d.setVisibility(this.a);
    }
}
