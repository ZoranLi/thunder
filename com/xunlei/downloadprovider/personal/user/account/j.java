package com.xunlei.downloadprovider.personal.user.account;

import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.widget.ImageView;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.xunlei.downloadprovider.member.login.LoginHelper;

/* compiled from: SetAccountPortraitHelper */
final class j extends ImageViewTarget<Bitmap> {
    final /* synthetic */ boolean a;
    final /* synthetic */ h b;

    j(h hVar, ImageView imageView, boolean z) {
        this.b = hVar;
        this.a = z;
        super(imageView);
    }

    public final /* synthetic */ void onResourceReady(Object obj, GlideAnimation glideAnimation) {
        Bitmap bitmap = (Bitmap) obj;
        super.onResourceReady(bitmap, glideAnimation);
        if (this.a != null) {
            LoginHelper.a().a(bitmap, this.b.d);
        }
    }

    protected final /* synthetic */ void setResource(Object obj) {
        obj = RoundedBitmapDrawableFactory.create(((ImageView) this.view).getResources(), (Bitmap) obj);
        obj.setCircular(true);
        setDrawable(obj);
    }
}
