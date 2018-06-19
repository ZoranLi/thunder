package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.model.StreamEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.bumptech.glide.provider.DataLoadProvider;
import java.io.File;
import java.io.InputStream;

public class GifDrawableLoadProvider implements DataLoadProvider<InputStream, GifDrawable> {
    private final FileToStreamDecoder<GifDrawable> cacheDecoder = new FileToStreamDecoder(this.decoder);
    private final GifResourceDecoder decoder;
    private final GifResourceEncoder encoder;
    private final StreamEncoder sourceEncoder;

    public GifDrawableLoadProvider(Context context, BitmapPool bitmapPool) {
        this.decoder = new GifResourceDecoder(context, bitmapPool);
        this.encoder = new GifResourceEncoder(bitmapPool);
        this.sourceEncoder = new StreamEncoder();
    }

    public ResourceDecoder<File, GifDrawable> getCacheDecoder() {
        return this.cacheDecoder;
    }

    public ResourceDecoder<InputStream, GifDrawable> getSourceDecoder() {
        return this.decoder;
    }

    public Encoder<InputStream> getSourceEncoder() {
        return this.sourceEncoder;
    }

    public ResourceEncoder<GifDrawable> getEncoder() {
        return this.encoder;
    }
}
