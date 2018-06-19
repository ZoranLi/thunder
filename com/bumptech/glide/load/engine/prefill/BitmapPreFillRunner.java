package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.util.Util;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

final class BitmapPreFillRunner implements Runnable {
    static final int BACKOFF_RATIO = 4;
    private static final Clock DEFAULT_CLOCK = new Clock();
    static final long INITIAL_BACKOFF_MS = 40;
    static final long MAX_BACKOFF_MS = TimeUnit.SECONDS.toMillis(1);
    static final long MAX_DURATION_MS = 32;
    private static final String TAG = "PreFillRunner";
    private final BitmapPool bitmapPool;
    private final Clock clock;
    private long currentDelay;
    private final Handler handler;
    private boolean isCancelled;
    private final MemoryCache memoryCache;
    private final Set<PreFillType> seenTypes;
    private final PreFillQueue toPrefill;

    static class Clock {
        Clock() {
        }

        public long now() {
            return SystemClock.currentThreadTimeMillis();
        }
    }

    private static class UniqueKey implements Key {
        public void updateDiskCacheKey(MessageDigest messageDigest) throws UnsupportedEncodingException {
        }

        private UniqueKey() {
        }
    }

    public BitmapPreFillRunner(BitmapPool bitmapPool, MemoryCache memoryCache, PreFillQueue preFillQueue) {
        this(bitmapPool, memoryCache, preFillQueue, DEFAULT_CLOCK, new Handler(Looper.getMainLooper()));
    }

    BitmapPreFillRunner(BitmapPool bitmapPool, MemoryCache memoryCache, PreFillQueue preFillQueue, Clock clock, Handler handler) {
        this.seenTypes = new HashSet();
        this.currentDelay = INITIAL_BACKOFF_MS;
        this.bitmapPool = bitmapPool;
        this.memoryCache = memoryCache;
        this.toPrefill = preFillQueue;
        this.clock = clock;
        this.handler = handler;
    }

    public final void cancel() {
        this.isCancelled = true;
    }

    private boolean allocate() {
        long now = this.clock.now();
        while (!this.toPrefill.isEmpty() && !isGcDetected(now)) {
            PreFillType remove = this.toPrefill.remove();
            Bitmap createBitmap = Bitmap.createBitmap(remove.getWidth(), remove.getHeight(), remove.getConfig());
            if (getFreeMemoryCacheBytes() >= Util.getBitmapByteSize(createBitmap)) {
                this.memoryCache.put(new UniqueKey(), BitmapResource.obtain(createBitmap, this.bitmapPool));
            } else {
                addToBitmapPool(remove, createBitmap);
            }
            if (Log.isLoggable(TAG, 3)) {
                StringBuilder stringBuilder = new StringBuilder("allocated [");
                stringBuilder.append(remove.getWidth());
                stringBuilder.append("x");
                stringBuilder.append(remove.getHeight());
                stringBuilder.append("] ");
                stringBuilder.append(remove.getConfig());
                stringBuilder.append(" size: ");
                stringBuilder.append(Util.getBitmapByteSize(createBitmap));
            }
        }
        return (this.isCancelled || this.toPrefill.isEmpty()) ? false : true;
    }

    private boolean isGcDetected(long j) {
        return this.clock.now() - j >= 32 ? 1 : 0;
    }

    private int getFreeMemoryCacheBytes() {
        return this.memoryCache.getMaxSize() - this.memoryCache.getCurrentSize();
    }

    private void addToBitmapPool(PreFillType preFillType, Bitmap bitmap) {
        if (this.seenTypes.add(preFillType)) {
            preFillType = this.bitmapPool.get(preFillType.getWidth(), preFillType.getHeight(), preFillType.getConfig());
            if (preFillType != null) {
                this.bitmapPool.put(preFillType);
            }
        }
        this.bitmapPool.put(bitmap);
    }

    public final void run() {
        if (allocate()) {
            this.handler.postDelayed(this, getNextDelay());
        }
    }

    private long getNextDelay() {
        long j = this.currentDelay;
        this.currentDelay = Math.min(this.currentDelay * 4, MAX_BACKOFF_MS);
        return j;
    }
}
