package com.bumptech.glide.request.animation;

import com.bumptech.glide.request.animation.ViewPropertyAnimation.Animator;

public class ViewPropertyAnimationFactory<R> implements GlideAnimationFactory<R> {
    private ViewPropertyAnimation<R> animation;
    private final Animator animator;

    public ViewPropertyAnimationFactory(Animator animator) {
        this.animator = animator;
    }

    public GlideAnimation<R> build(boolean z, boolean z2) {
        if (!z) {
            if (z2) {
                if (!this.animation) {
                    this.animation = new ViewPropertyAnimation(this.animator);
                }
                return this.animation;
            }
        }
        return NoAnimation.get();
    }
}
