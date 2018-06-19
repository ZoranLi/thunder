package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.util.Log;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.io.OutputStream;

public class BitmapEncoder implements ResourceEncoder<Bitmap> {
    private static final int DEFAULT_COMPRESSION_QUALITY = 90;
    private static final String TAG = "BitmapEncoder";
    private CompressFormat compressFormat;
    private int quality;

    public String getId() {
        return "BitmapEncoder.com.bumptech.glide.load.resource.bitmap";
    }

    public BitmapEncoder() {
        this(null, 90);
    }

    public BitmapEncoder(CompressFormat compressFormat, int i) {
        this.compressFormat = compressFormat;
        this.quality = i;
    }

    public boolean encode(Resource<Bitmap> resource, OutputStream outputStream) {
        Bitmap bitmap = (Bitmap) resource.get();
        long logTime = LogTime.getLogTime();
        CompressFormat format = getFormat(bitmap);
        bitmap.compress(format, this.quality, outputStream);
        if (Log.isLoggable(TAG, 2) != null) {
            outputStream = new StringBuilder("Compressed with type: ");
            outputStream.append(format);
            outputStream.append(" of size ");
            outputStream.append(Util.getBitmapByteSize(bitmap));
            outputStream.append(" in ");
            outputStream.append(LogTime.getElapsedMillis(logTime));
        }
        return true;
    }

    private CompressFormat getFormat(Bitmap bitmap) {
        if (this.compressFormat != null) {
            return this.compressFormat;
        }
        if (bitmap.hasAlpha() != null) {
            return CompressFormat.PNG;
        }
        return CompressFormat.JPEG;
    }
}
