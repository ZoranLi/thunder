package com.bumptech.glide.request.animation;

import android.view.animation.Animation;
import com.bumptech.glide.request.animation.GlideAnimation.ViewAdapter;

public class ViewAnimation<R> implements GlideAnimation<R> {
    private final AnimationFactory animationFactory;

    interface AnimationFactory {
        Animation build();
    }

    ViewAnimation(AnimationFactory animationFactory) {
        this.animationFactory = animationFactory;
    }

    public boolean animate(R r, ViewAdapter viewAdapter) {
        r = viewAdapter.getView();
        if (r != null) {
            r.clearAnimation();
            r.startAnimation(this.animationFactory.build());
        }
        return null;
    }
}
