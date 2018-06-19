package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.PreFillType.Builder;
import com.bumptech.glide.util.Util;
import java.util.HashMap;
import java.util.Map;

public final class BitmapPreFiller {
    private final BitmapPool bitmapPool;
    private BitmapPreFillRunner current;
    private final DecodeFormat defaultFormat;
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final MemoryCache memoryCache;

    public BitmapPreFiller(MemoryCache memoryCache, BitmapPool bitmapPool, DecodeFormat decodeFormat) {
        this.memoryCache = memoryCache;
        this.bitmapPool = bitmapPool;
        this.defaultFormat = decodeFormat;
    }

    public final void preFill(Builder... builderArr) {
        if (this.current != null) {
            this.current.cancel();
        }
        PreFillType[] preFillTypeArr = new PreFillType[builderArr.length];
        for (int i = 0; i < builderArr.length; i++) {
            Builder builder = builderArr[i];
            if (builder.getConfig() == null) {
                Config config;
                if (this.defaultFormat != DecodeFormat.ALWAYS_ARGB_8888) {
                    if (this.defaultFormat != DecodeFormat.PREFER_ARGB_8888) {
                        config = Config.RGB_565;
                        builder.setConfig(config);
                    }
                }
                config = Config.ARGB_8888;
                builder.setConfig(config);
            }
            preFillTypeArr[i] = builder.build();
        }
        this.current = new BitmapPreFillRunner(this.bitmapPool, this.memoryCache, generateAllocationOrder(preFillTypeArr));
        this.handler.post(this.current);
    }

    final PreFillQueue generateAllocationOrder(PreFillType[] preFillTypeArr) {
        int maxSize = (this.memoryCache.getMaxSize() - this.memoryCache.getCurrentSize()) + this.bitmapPool.getMaxSize();
        int i = 0;
        int i2 = 0;
        int i3 = i2;
        while (i2 < preFillTypeArr.length) {
            i3 += preFillTypeArr[i2].getWeight();
            i2++;
        }
        float f = ((float) maxSize) / ((float) i3);
        Map hashMap = new HashMap();
        i2 = preFillTypeArr.length;
        while (i < i2) {
            PreFillType preFillType = preFillTypeArr[i];
            hashMap.put(preFillType, Integer.valueOf(Math.round(((float) preFillType.getWeight()) * f) / getSizeInBytes(preFillType)));
            i++;
        }
        return new PreFillQueue(hashMap);
    }

    private static int getSizeInBytes(PreFillType preFillType) {
        return Util.getBitmapByteSize(preFillType.getWidth(), preFillType.getHeight(), preFillType.getConfig());
    }
}
