package com.xunlei.downloadprovider.publiser.common;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.target.ImageViewTarget;

/* compiled from: AvatarActivity */
final class e extends ImageViewTarget<GlideDrawable> {
    final /* synthetic */ AvatarActivity a;

    e(AvatarActivity avatarActivity, ImageView imageView) {
        this.a = avatarActivity;
        super(imageView);
    }

    protected final /* synthetic */ void setResource(Object obj) {
        setDrawable((GlideDrawable) obj);
    }

    public final void onLoadStarted(Drawable drawable) {
        super.onLoadStarted(drawable);
        AvatarActivity.e(this.a);
    }

    public final void onLoadFailed(Exception exception, Drawable drawable) {
        super.onLoadFailed(exception, drawable);
        this.a.b();
    }

    public final void onLoadCleared(Drawable drawable) {
        super.onLoadCleared(drawable);
    }
}
