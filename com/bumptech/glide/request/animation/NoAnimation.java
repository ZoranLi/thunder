package com.bumptech.glide.request.animation;

import com.bumptech.glide.request.animation.GlideAnimation.ViewAdapter;

public class NoAnimation<R> implements GlideAnimation<R> {
    private static final NoAnimation<?> NO_ANIMATION = new NoAnimation();
    private static final GlideAnimationFactory<?> NO_ANIMATION_FACTORY = new NoAnimationFactory();

    public static class NoAnimationFactory<R> implements GlideAnimationFactory<R> {
        public GlideAnimation<R> build(boolean z, boolean z2) {
            return NoAnimation.NO_ANIMATION;
        }
    }

    public boolean animate(Object obj, ViewAdapter viewAdapter) {
        return false;
    }

    public static <R> GlideAnimationFactory<R> getFactory() {
        return NO_ANIMATION_FACTORY;
    }

    public static <R> GlideAnimation<R> get() {
        return NO_ANIMATION;
    }
}
