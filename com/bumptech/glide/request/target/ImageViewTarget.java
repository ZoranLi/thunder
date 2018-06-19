package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.animation.GlideAnimation.ViewAdapter;

public abstract class ImageViewTarget<Z> extends ViewTarget<ImageView, Z> implements ViewAdapter {
    public abstract void setResource(Z z);

    public ImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    public Drawable getCurrentDrawable() {
        return ((ImageView) this.view).getDrawable();
    }

    public void setDrawable(Drawable drawable) {
        ((ImageView) this.view).setImageDrawable(drawable);
    }

    public void onLoadStarted(Drawable drawable) {
        ((ImageView) this.view).setImageDrawable(drawable);
    }

    public void onLoadFailed(Exception exception, Drawable drawable) {
        ((ImageView) this.view).setImageDrawable(drawable);
    }

    public void onLoadCleared(Drawable drawable) {
        ((ImageView) this.view).setImageDrawable(drawable);
    }

    public void onResourceReady(Z z, GlideAnimation<? super Z> glideAnimation) {
        if (glideAnimation == null || glideAnimation.animate(z, this) == null) {
            setResource(z);
        }
    }
}
