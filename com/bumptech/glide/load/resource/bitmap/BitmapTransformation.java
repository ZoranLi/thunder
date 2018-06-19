package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;

public abstract class BitmapTransformation implements Transformation<Bitmap> {
    private BitmapPool bitmapPool;

    public abstract Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2);

    public BitmapTransformation(Context context) {
        this(Glide.get(context).getBitmapPool());
    }

    public BitmapTransformation(BitmapPool bitmapPool) {
        this.bitmapPool = bitmapPool;
    }

    public final Resource<Bitmap> transform(Resource<Bitmap> resource, int i, int i2) {
        if (Util.isValidDimensions(i, i2)) {
            Bitmap bitmap = (Bitmap) resource.get();
            if (i == Integer.MIN_VALUE) {
                i = bitmap.getWidth();
            }
            if (i2 == Integer.MIN_VALUE) {
                i2 = bitmap.getHeight();
            }
            i = transform(this.bitmapPool, bitmap, i, i2);
            return bitmap.equals(i) == 0 ? BitmapResource.obtain(i, this.bitmapPool) : resource;
        } else {
            StringBuilder stringBuilder = new StringBuilder("Cannot apply transformation on width: ");
            stringBuilder.append(i);
            stringBuilder.append(" or height: ");
            stringBuilder.append(i2);
            stringBuilder.append(" less than or equal to zero and not Target.SIZE_ORIGINAL");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
    }
}
