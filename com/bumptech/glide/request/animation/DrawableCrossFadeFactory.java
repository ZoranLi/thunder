package com.bumptech.glide.request.animation;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;

public class DrawableCrossFadeFactory<T extends Drawable> implements GlideAnimationFactory<T> {
    private static final int DEFAULT_DURATION_MS = 300;
    private final ViewAnimationFactory<T> animationFactory;
    private final int duration;
    private DrawableCrossFadeViewAnimation<T> firstResourceAnimation;
    private DrawableCrossFadeViewAnimation<T> secondResourceAnimation;

    private static class DefaultAnimationFactory implements AnimationFactory {
        private final int duration;

        DefaultAnimationFactory(int i) {
            this.duration = i;
        }

        public Animation build() {
            Animation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
            alphaAnimation.setDuration((long) this.duration);
            return alphaAnimation;
        }
    }

    public DrawableCrossFadeFactory() {
        this(300);
    }

    public DrawableCrossFadeFactory(int i) {
        this(new ViewAnimationFactory(new DefaultAnimationFactory(i)), i);
    }

    public DrawableCrossFadeFactory(Context context, int i, int i2) {
        this(new ViewAnimationFactory(context, i), i2);
    }

    public DrawableCrossFadeFactory(Animation animation, int i) {
        this(new ViewAnimationFactory(animation), i);
    }

    DrawableCrossFadeFactory(ViewAnimationFactory<T> viewAnimationFactory, int i) {
        this.animationFactory = viewAnimationFactory;
        this.duration = i;
    }

    public GlideAnimation<T> build(boolean z, boolean z2) {
        if (z) {
            return NoAnimation.get();
        }
        if (z2) {
            return getFirstResourceAnimation();
        }
        return getSecondResourceAnimation();
    }

    private GlideAnimation<T> getFirstResourceAnimation() {
        if (this.firstResourceAnimation == null) {
            this.firstResourceAnimation = new DrawableCrossFadeViewAnimation(this.animationFactory.build(false, true), this.duration);
        }
        return this.firstResourceAnimation;
    }

    private GlideAnimation<T> getSecondResourceAnimation() {
        if (this.secondResourceAnimation == null) {
            this.secondResourceAnimation = new DrawableCrossFadeViewAnimation(this.animationFactory.build(false, false), this.duration);
        }
        return this.secondResourceAnimation;
    }
}
