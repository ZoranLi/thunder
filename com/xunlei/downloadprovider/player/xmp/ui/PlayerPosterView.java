package com.xunlei.downloadprovider.player.xmp.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

public class PlayerPosterView extends ImageView {
    public PlayerPosterView(Context context) {
        super(context);
    }

    public PlayerPosterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PlayerPosterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void a() {
        if (getVisibility() == 0) {
            Animation alphaAnimation = new AlphaAnimation(getAlpha(), 0.0f);
            alphaAnimation.setDuration(500);
            alphaAnimation.setAnimationListener(new bh(this));
            startAnimation(alphaAnimation);
        }
    }
}
