package com.xunlei.downloadprovidershare.redpacket;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

/* compiled from: RedPacketShareDlgView */
final class m extends GlideDrawableImageViewTarget {
    final /* synthetic */ g a;

    m(g gVar, ImageView imageView) {
        this.a = gVar;
        super(imageView);
    }

    public final void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
        super.onResourceReady(glideDrawable, glideAnimation);
        this.a.e = true;
        this.a.a();
    }

    public final void onLoadFailed(Exception exception, Drawable drawable) {
        this.a.a();
    }
}
