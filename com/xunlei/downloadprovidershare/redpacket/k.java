package com.xunlei.downloadprovidershare.redpacket;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

/* compiled from: RedPacketShareDlgView */
final class k extends GlideDrawableImageViewTarget {
    final /* synthetic */ ImageView a;
    final /* synthetic */ g b;

    k(g gVar, ImageView imageView, ImageView imageView2) {
        this.b = gVar;
        this.a = imageView2;
        super(imageView);
    }

    public final void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
        super.onResourceReady(glideDrawable, glideAnimation);
        g.a(this.b, ((GlideBitmapDrawable) glideDrawable).getBitmap(), this.a);
    }

    public final void onLoadFailed(Exception exception, Drawable drawable) {
        super.onLoadFailed(exception, drawable);
        g.a(this.b, drawable, this.a);
    }
}
