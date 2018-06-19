package com.bumptech.glide.load.resource.gifbitmap;

import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import java.io.IOException;
import java.io.InputStream;

public class GifBitmapWrapperStreamResourceDecoder implements ResourceDecoder<InputStream, GifBitmapWrapper> {
    private final ResourceDecoder<ImageVideoWrapper, GifBitmapWrapper> gifBitmapDecoder;

    public GifBitmapWrapperStreamResourceDecoder(ResourceDecoder<ImageVideoWrapper, GifBitmapWrapper> resourceDecoder) {
        this.gifBitmapDecoder = resourceDecoder;
    }

    public Resource<GifBitmapWrapper> decode(InputStream inputStream, int i, int i2) throws IOException {
        return this.gifBitmapDecoder.decode(new ImageVideoWrapper(inputStream, null), i, i2);
    }

    public String getId() {
        return this.gifBitmapDecoder.getId();
    }
}
