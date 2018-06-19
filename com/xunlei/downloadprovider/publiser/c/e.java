package com.xunlei.downloadprovider.publiser.c;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.bumptech.glide.request.target.ImageViewTarget;
import com.xunlei.common.androidutil.BitmapUtil;

/* compiled from: RadLivingInfoViewHolder */
final class e extends ImageViewTarget<Bitmap> {
    final /* synthetic */ a a;

    e(a aVar, ImageView imageView) {
        this.a = aVar;
        super(imageView);
    }

    protected final /* synthetic */ void setResource(Object obj) {
        obj = (Bitmap) obj;
        int width = obj.getWidth();
        int width2 = this.a.m.getWidth();
        if (width < width2) {
            obj = BitmapUtil.scaleBitmap(obj, (float) Math.round((float) (width2 / width)));
        }
        this.a.m.setImageBitmap(obj);
        this.a.m.getMovingAnimator().start();
    }
}
