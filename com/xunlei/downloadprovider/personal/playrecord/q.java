package com.xunlei.downloadprovider.personal.playrecord;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.handmark.pulltorefresh.library.PullToRefreshBase.Mode;

/* compiled from: PlayRecordActivity */
final class q implements AnimationListener {
    final /* synthetic */ PlayRecordActivity a;

    public final void onAnimationRepeat(Animation animation) {
    }

    public final void onAnimationStart(Animation animation) {
    }

    q(PlayRecordActivity playRecordActivity) {
        this.a = playRecordActivity;
    }

    public final void onAnimationEnd(Animation animation) {
        this.a.a(Mode.PULL_FROM_START);
    }
}
