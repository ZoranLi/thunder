package com.bumptech.glide.load.resource.gif;

import com.bumptech.glide.load.resource.drawable.DrawableResource;
import com.bumptech.glide.util.Util;

public class GifDrawableResource extends DrawableResource<GifDrawable> {
    public GifDrawableResource(GifDrawable gifDrawable) {
        super(gifDrawable);
    }

    public int getSize() {
        return ((GifDrawable) this.drawable).getData().length + Util.getBitmapByteSize(((GifDrawable) this.drawable).getFirstFrame());
    }

    public void recycle() {
        ((GifDrawable) this.drawable).stop();
        ((GifDrawable) this.drawable).recycle();
    }
}
