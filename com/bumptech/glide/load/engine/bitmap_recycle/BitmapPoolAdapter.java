package com.bumptech.glide.load.engine.bitmap_recycle;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;

public class BitmapPoolAdapter implements BitmapPool {
    public void clearMemory() {
    }

    public Bitmap get(int i, int i2, Config config) {
        return null;
    }

    public Bitmap getDirty(int i, int i2, Config config) {
        return null;
    }

    public int getMaxSize() {
        return 0;
    }

    public boolean put(Bitmap bitmap) {
        return false;
    }

    public void setSizeMultiplier(float f) {
    }

    public void trimMemory(int i) {
    }
}
