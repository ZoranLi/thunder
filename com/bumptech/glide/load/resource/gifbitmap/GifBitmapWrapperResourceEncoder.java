package com.bumptech.glide.load.resource.gifbitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import java.io.OutputStream;

public class GifBitmapWrapperResourceEncoder implements ResourceEncoder<GifBitmapWrapper> {
    private final ResourceEncoder<Bitmap> bitmapEncoder;
    private final ResourceEncoder<GifDrawable> gifEncoder;
    private String id;

    public GifBitmapWrapperResourceEncoder(ResourceEncoder<Bitmap> resourceEncoder, ResourceEncoder<GifDrawable> resourceEncoder2) {
        this.bitmapEncoder = resourceEncoder;
        this.gifEncoder = resourceEncoder2;
    }

    public boolean encode(Resource<GifBitmapWrapper> resource, OutputStream outputStream) {
        GifBitmapWrapper gifBitmapWrapper = (GifBitmapWrapper) resource.get();
        Resource bitmapResource = gifBitmapWrapper.getBitmapResource();
        if (bitmapResource != null) {
            return this.bitmapEncoder.encode(bitmapResource, outputStream);
        }
        return this.gifEncoder.encode(gifBitmapWrapper.getGifResource(), outputStream);
    }

    public String getId() {
        if (this.id == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.bitmapEncoder.getId());
            stringBuilder.append(this.gifEncoder.getId());
            this.id = stringBuilder.toString();
        }
        return this.id;
    }
}
