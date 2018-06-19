package com.bumptech.glide.request.animation;

import android.view.View;
import com.bumptech.glide.request.animation.GlideAnimation.ViewAdapter;

public class ViewPropertyAnimation<R> implements GlideAnimation<R> {
    private final Animator animator;

    public interface Animator {
        void animate(View view);
    }

    public ViewPropertyAnimation(Animator animator) {
        this.animator = animator;
    }

    public boolean animate(R r, ViewAdapter viewAdapter) {
        if (viewAdapter.getView() != null) {
            this.animator.animate(viewAdapter.getView());
        }
        return null;
    }
}
