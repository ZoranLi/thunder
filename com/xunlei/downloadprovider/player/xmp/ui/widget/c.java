package com.xunlei.downloadprovider.player.xmp.ui.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.xunlei.common.androidutil.ViewUtil;
import com.xunlei.downloadprovider.player.xmp.ui.widget.DoubleClickAnimationView.a;

/* compiled from: DoubleClickAnimationView */
public final class c extends AnimatorListenerAdapter {
    final /* synthetic */ a a = null;
    final /* synthetic */ DoubleClickAnimationView b;

    public c(DoubleClickAnimationView doubleClickAnimationView) {
        this.b = doubleClickAnimationView;
    }

    public final void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        this.b.c = false;
        ViewUtil.removeViewFromParent(this.b);
        if (this.a != null) {
            this.a.a();
        }
    }
}
