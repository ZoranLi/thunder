package com.xunlei.downloadprovider.download.center.widget;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.xunlei.downloadprovider.R;

/* compiled from: DownloadCenterBottomView */
final class h implements AnimationListener {
    final /* synthetic */ DownloadCenterBottomView a;

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    h(DownloadCenterBottomView downloadCenterBottomView) {
        this.a = downloadCenterBottomView;
    }

    public final void onAnimationEnd(Animation animation) {
        animation = ((View) this.a.getParent()).findViewById(R.id.expand_view);
        if (animation != null) {
            animation.setVisibility(0);
        }
        this.a.setAnimation(null);
    }
}
