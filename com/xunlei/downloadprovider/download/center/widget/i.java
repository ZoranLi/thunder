package com.xunlei.downloadprovider.download.center.widget;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.xunlei.downloadprovider.R;

/* compiled from: DownloadCenterBottomView */
final class i implements AnimationListener {
    final /* synthetic */ DownloadCenterBottomView a;

    public final void onAnimationRepeat(Animation animation) {
    }

    i(DownloadCenterBottomView downloadCenterBottomView) {
        this.a = downloadCenterBottomView;
    }

    public final void onAnimationStart(Animation animation) {
        animation = ((View) this.a.getParent()).findViewById(R.id.expand_view);
        if (animation != null) {
            animation.setVisibility(8);
        }
    }

    public final void onAnimationEnd(Animation animation) {
        this.a.setVisibility(8);
        this.a.setAnimation(null);
        animation = ((View) this.a.getParent()).findViewById(R.id.expand_view);
        if (animation != null) {
            animation.setVisibility(8);
        }
    }
}
