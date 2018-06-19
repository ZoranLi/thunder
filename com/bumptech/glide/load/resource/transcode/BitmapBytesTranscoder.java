package com.bumptech.glide.load.resource.transcode;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.bytes.BytesResource;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public class BitmapBytesTranscoder implements ResourceTranscoder<Bitmap, byte[]> {
    private final CompressFormat compressFormat;
    private final int quality;

    public String getId() {
        return "BitmapBytesTranscoder.com.bumptech.glide.load.resource.transcode";
    }

    public BitmapBytesTranscoder() {
        this(CompressFormat.JPEG, 100);
    }

    public BitmapBytesTranscoder(CompressFormat compressFormat, int i) {
        this.compressFormat = compressFormat;
        this.quality = i;
    }

    public Resource<byte[]> transcode(Resource<Bitmap> resource) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((Bitmap) resource.get()).compress(this.compressFormat, this.quality, byteArrayOutputStream);
        resource.recycle();
        return new BytesResource(byteArrayOutputStream.toByteArray());
    }
}
