package com.bumptech.glide.load.resource.bitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.util.Util;

public class BitmapResource implements Resource<Bitmap> {
    private final Bitmap bitmap;
    private final BitmapPool bitmapPool;

    public static BitmapResource obtain(Bitmap bitmap, BitmapPool bitmapPool) {
        return bitmap == null ? null : new BitmapResource(bitmap, bitmapPool);
    }

    public BitmapResource(Bitmap bitmap, BitmapPool bitmapPool) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        } else if (bitmapPool == null) {
            throw new NullPointerException("BitmapPool must not be null");
        } else {
            this.bitmap = bitmap;
            this.bitmapPool = bitmapPool;
        }
    }

    public Bitmap get() {
        return this.bitmap;
    }

    public int getSize() {
        return Util.getBitmapByteSize(this.bitmap);
    }

    public void recycle() {
        if (!this.bitmapPool.put(this.bitmap)) {
            this.bitmap.recycle();
        }
    }
}
