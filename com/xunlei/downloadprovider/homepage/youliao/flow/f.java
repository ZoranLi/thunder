package com.xunlei.downloadprovider.homepage.youliao.flow;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.ImageViewTarget;

/* compiled from: YouliaoVideoCardView */
final class f extends ImageViewTarget<Bitmap> {
    final /* synthetic */ YouliaoVideoCardView a;

    f(YouliaoVideoCardView youliaoVideoCardView, ImageView imageView) {
        this.a = youliaoVideoCardView;
        super(imageView);
    }

    public final /* synthetic */ void onResourceReady(Object obj, GlideAnimation glideAnimation) {
        super.onResourceReady((Bitmap) obj, glideAnimation);
        if (this.a.l != null) {
            this.a.l.setVisibility(null);
        }
    }

    protected final /* synthetic */ void setResource(Object obj) {
        Bitmap bitmap = (Bitmap) obj;
        ((ImageView) this.view).setImageBitmap(bitmap);
        ((ImageView) this.view).setImageMatrix(YouliaoVideoCardView.a(this.view, bitmap.getWidth(), bitmap.getHeight()));
    }

    public final void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        if (this.a.l != null) {
            this.a.l.setVisibility(4);
        }
    }

    public final void onLoadFailed(Exception exception, Drawable drawable) {
        super.onLoadFailed(exception, drawable);
        if (this.a.l != null) {
            this.a.l.setVisibility(4);
        }
    }

    public final void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
    }
}
