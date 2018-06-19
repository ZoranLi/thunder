package com.bumptech.glide.load.resource.transcode;

import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bytes.BytesResource;
import com.bumptech.glide.load.resource.gif.GifDrawable;

public class GifDrawableBytesTranscoder implements ResourceTranscoder<GifDrawable, byte[]> {
    public String getId() {
        return "GifDrawableBytesTranscoder.com.bumptech.glide.load.resource.transcode";
    }

    public Resource<byte[]> transcode(Resource<GifDrawable> resource) {
        return new BytesResource(((GifDrawable) resource.get()).getData());
    }
}
