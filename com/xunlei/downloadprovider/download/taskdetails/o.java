package com.xunlei.downloadprovider.download.taskdetails;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

/* compiled from: DownloadCenterDetailFragment */
final class o implements AnimationListener {
    final /* synthetic */ DownloadCenterDetailFragment a;

    public final void onAnimationRepeat(Animation animation) {
    }

    o(DownloadCenterDetailFragment downloadCenterDetailFragment) {
        this.a = downloadCenterDetailFragment;
    }

    public final void onAnimationStart(Animation animation) {
        this.a.o.setClickable(false);
    }

    public final void onAnimationEnd(Animation animation) {
        this.a.o.setAnimation(null);
        this.a.o.setClickable(true);
        if (this.a.a != null) {
            this.a.a;
            TaskDetailFragment.e();
        }
    }
}
