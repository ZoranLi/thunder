package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapper;

public class GifBitmapWrapperDrawableTranscoder implements ResourceTranscoder<GifBitmapWrapper, GlideDrawable> {
    private final ResourceTranscoder<Bitmap, GlideBitmapDrawable> bitmapDrawableResourceTranscoder;

    public String getId() {
        return "GifBitmapWrapperDrawableTranscoder.com.bumptech.glide.load.resource.transcode";
    }

    public GifBitmapWrapperDrawableTranscoder(ResourceTranscoder<Bitmap, GlideBitmapDrawable> resourceTranscoder) {
        this.bitmapDrawableResourceTranscoder = resourceTranscoder;
    }

    public Resource<GlideDrawable> transcode(Resource<GifBitmapWrapper> resource) {
        GifBitmapWrapper gifBitmapWrapper = (GifBitmapWrapper) resource.get();
        Resource bitmapResource = gifBitmapWrapper.getBitmapResource();
        if (bitmapResource != null) {
            return this.bitmapDrawableResourceTranscoder.transcode(bitmapResource);
        }
        return gifBitmapWrapper.getGifResource();
    }
}
