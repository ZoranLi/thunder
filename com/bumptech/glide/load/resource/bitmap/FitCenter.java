package com.bumptech.glide.load.resource.bitmap;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;

public class FitCenter extends BitmapTransformation {
    public String getId() {
        return "FitCenter.com.bumptech.glide.load.resource.bitmap";
    }

    public FitCenter(Context context) {
        super(context);
    }

    public FitCenter(BitmapPool bitmapPool) {
        super(bitmapPool);
    }

    protected Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        return TransformationUtils.fitCenter(bitmap, bitmapPool, i, i2);
    }
}
