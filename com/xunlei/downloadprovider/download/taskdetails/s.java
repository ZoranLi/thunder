package com.xunlei.downloadprovider.download.taskdetails;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: DownloadCenterDetailFragment */
final class s implements AnimationListener {
    final /* synthetic */ DownloadCenterDetailFragment a;

    public final void onAnimationRepeat(Animation animation) {
    }

    s(DownloadCenterDetailFragment downloadCenterDetailFragment) {
        this.a = downloadCenterDetailFragment;
    }

    public final void onAnimationStart(Animation animation) {
        this.a.o.setClickable(false);
        this.a.p.setVisibility(4);
    }

    public final void onAnimationEnd(Animation animation) {
        this.a.o.setAnimation(null);
        this.a.getView().setVisibility(8);
        this.a.o.setClickable(true);
        if (this.a.a != null) {
            this.a.a.g();
            this.a.a.f();
        }
        this.a.h = null;
    }
}
