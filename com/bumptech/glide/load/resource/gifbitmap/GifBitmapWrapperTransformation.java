package com.bumptech.glide.load.resource.gifbitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;

public class GifBitmapWrapperTransformation implements Transformation<GifBitmapWrapper> {
    private final Transformation<Bitmap> bitmapTransformation;
    private final Transformation<GifDrawable> gifDataTransformation;

    public GifBitmapWrapperTransformation(BitmapPool bitmapPool, Transformation<Bitmap> transformation) {
        this((Transformation) transformation, new GifDrawableTransformation(transformation, bitmapPool));
    }

    GifBitmapWrapperTransformation(Transformation<Bitmap> transformation, Transformation<GifDrawable> transformation2) {
        this.bitmapTransformation = transformation;
        this.gifDataTransformation = transformation2;
    }

    public Resource<GifBitmapWrapper> transform(Resource<GifBitmapWrapper> resource, int i, int i2) {
        Resource bitmapResource = ((GifBitmapWrapper) resource.get()).getBitmapResource();
        Resource gifResource = ((GifBitmapWrapper) resource.get()).getGifResource();
        if (bitmapResource != null && this.bitmapTransformation != null) {
            i = this.bitmapTransformation.transform(bitmapResource, i, i2);
            if (bitmapResource.equals(i) == 0) {
                return new GifBitmapWrapperResource(new GifBitmapWrapper(i, ((GifBitmapWrapper) resource.get()).getGifResource()));
            }
        } else if (!(gifResource == null || this.gifDataTransformation == null)) {
            i = this.gifDataTransformation.transform(gifResource, i, i2);
            if (gifResource.equals(i) == 0) {
                return new GifBitmapWrapperResource(new GifBitmapWrapper(((GifBitmapWrapper) resource.get()).getBitmapResource(), i));
            }
        }
        return resource;
    }

    public String getId() {
        return this.bitmapTransformation.getId();
    }
}
