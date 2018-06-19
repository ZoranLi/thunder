package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;

public class GifDrawableTransformation implements Transformation<GifDrawable> {
    private final BitmapPool bitmapPool;
    private final Transformation<Bitmap> wrapped;

    public GifDrawableTransformation(Transformation<Bitmap> transformation, BitmapPool bitmapPool) {
        this.wrapped = transformation;
        this.bitmapPool = bitmapPool;
    }

    public Resource<GifDrawable> transform(Resource<GifDrawable> resource, int i, int i2) {
        GifDrawable gifDrawable = (GifDrawable) resource.get();
        Bitmap firstFrame = ((GifDrawable) resource.get()).getFirstFrame();
        Bitmap bitmap = (Bitmap) this.wrapped.transform(new BitmapResource(firstFrame, this.bitmapPool), i, i2).get();
        return bitmap.equals(firstFrame) == 0 ? new GifDrawableResource(new GifDrawable(gifDrawable, bitmap, this.wrapped)) : resource;
    }

    public String getId() {
        return this.wrapped.getId();
    }
}
