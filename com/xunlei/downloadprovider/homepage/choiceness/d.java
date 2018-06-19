package com.xunlei.downloadprovider.homepage.choiceness;

import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.xunlei.common.androidutil.ViewUtil;

/* compiled from: ChoicenessImageUtil */
public final class d extends GlideDrawableImageViewTarget {
    final /* synthetic */ ImageView a;
    final /* synthetic */ int b;
    final /* synthetic */ int c;
    final /* synthetic */ String d;
    final /* synthetic */ b e;

    public d(b bVar, ImageView imageView, ImageView imageView2, int i, int i2, String str) {
        this.e = bVar;
        this.a = imageView2;
        this.b = i;
        this.c = i2;
        this.d = str;
        super(imageView);
    }

    public final void onResourceReady(GlideDrawable glideDrawable, GlideAnimation<? super GlideDrawable> glideAnimation) {
        super.onResourceReady(glideDrawable, glideAnimation);
        glideAnimation = glideDrawable.getIntrinsicWidth();
        int intrinsicHeight = glideDrawable.getIntrinsicHeight();
        StringBuilder stringBuilder = new StringBuilder("displayGaussBlurPosterImage--onResourceReady--view=");
        stringBuilder.append(ViewUtil.getViewAddress(this.a));
        stringBuilder.append("|imageWidth=");
        stringBuilder.append(this.a.getWidth());
        stringBuilder.append("|imageHeight=");
        stringBuilder.append(this.a.getHeight());
        stringBuilder.append("|resourceWidth=");
        stringBuilder.append(glideAnimation);
        stringBuilder.append("|resourceHeight=");
        stringBuilder.append(intrinsicHeight);
        stringBuilder.append("|posterWidth=");
        stringBuilder.append(this.b);
        stringBuilder.append("|posterHeight=");
        stringBuilder.append(this.c);
        stringBuilder.append("|url=");
        stringBuilder.append(this.d);
        if (this.b <= 0 || this.c <= 0) {
            this.e.a(a.a(this.d, glideAnimation, intrinsicHeight, this.a), this.a, null);
            return;
        }
        if (((double) Math.abs((((float) this.a.getWidth()) / ((float) this.a.getHeight())) - (((float) this.b) / ((float) this.c)))) < 0.02d) {
            this.a.setScaleType(ScaleType.FIT_XY);
        }
        this.a.setImageDrawable(glideDrawable);
    }
}
