package com.xunlei.downloadprovider.homepage.choiceness;

import android.widget.ImageView;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.xunlei.common.androidutil.ViewUtil;
import com.xunlei.downloadprovider.homepage.choiceness.b.b;

/* compiled from: ChoicenessImageUtil */
final class c extends GlideDrawableImageViewTarget {
    final /* synthetic */ b a;
    final /* synthetic */ ImageView b;
    final /* synthetic */ String c;
    final /* synthetic */ b d;

    c(b bVar, ImageView imageView, b bVar2, ImageView imageView2, String str) {
        this.d = bVar;
        this.a = bVar2;
        this.b = imageView2;
        this.c = str;
        super(imageView);
    }

    public final void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
        super.onResourceReady(glideDrawable, glideAnimation);
        if (this.a != null) {
            glideAnimation = glideDrawable.getIntrinsicWidth();
            int intrinsicHeight = glideDrawable.getIntrinsicHeight();
            if (glideDrawable instanceof GlideBitmapDrawable) {
                glideDrawable = ((GlideBitmapDrawable) glideDrawable).getBitmap();
                if (glideDrawable != null) {
                    glideAnimation = glideDrawable.getWidth();
                    intrinsicHeight = glideDrawable.getHeight();
                    glideDrawable = new StringBuilder("displayPosterImage--onResourceReady--posterW=");
                    glideDrawable.append(glideAnimation);
                    glideDrawable.append("|posterH=");
                    glideDrawable.append(intrinsicHeight);
                }
            }
            glideDrawable = new StringBuilder("displayPosterImage--onResourceReady--view=");
            glideDrawable.append(ViewUtil.getViewAddress(this.b));
            glideDrawable.append("|posterWidth=");
            glideDrawable.append(glideAnimation);
            glideDrawable.append("|posterHeight=");
            glideDrawable.append(intrinsicHeight);
            glideDrawable.append("|url=");
            glideDrawable.append(this.c);
            this.a.a(glideAnimation, intrinsicHeight);
        }
    }
}
