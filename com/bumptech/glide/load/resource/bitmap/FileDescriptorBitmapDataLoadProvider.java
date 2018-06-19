package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.NullEncoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.bumptech.glide.provider.DataLoadProvider;
import java.io.File;

public class FileDescriptorBitmapDataLoadProvider implements DataLoadProvider<ParcelFileDescriptor, Bitmap> {
    private final ResourceDecoder<File, Bitmap> cacheDecoder;
    private final BitmapEncoder encoder = new BitmapEncoder();
    private final FileDescriptorBitmapDecoder sourceDecoder;
    private final Encoder<ParcelFileDescriptor> sourceEncoder = NullEncoder.get();

    public FileDescriptorBitmapDataLoadProvider(BitmapPool bitmapPool, DecodeFormat decodeFormat) {
        this.cacheDecoder = new FileToStreamDecoder(new StreamBitmapDecoder(bitmapPool, decodeFormat));
        this.sourceDecoder = new FileDescriptorBitmapDecoder(bitmapPool, decodeFormat);
    }

    public ResourceDecoder<File, Bitmap> getCacheDecoder() {
        return this.cacheDecoder;
    }

    public ResourceDecoder<ParcelFileDescriptor, Bitmap> getSourceDecoder() {
        return this.sourceDecoder;
    }

    public Encoder<ParcelFileDescriptor> getSourceEncoder() {
        return this.sourceEncoder;
    }

    public ResourceEncoder<Bitmap> getEncoder() {
        return this.encoder;
    }
}
