package com.bumptech.glide.load.engine.bitmap_recycle;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import android.util.Log;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class LruBitmapPool implements BitmapPool {
    private static final Config DEFAULT_CONFIG = Config.ARGB_8888;
    private static final String TAG = "LruBitmapPool";
    private final Set<Config> allowedConfigs;
    private int currentSize;
    private int evictions;
    private int hits;
    private final int initialMaxSize;
    private int maxSize;
    private int misses;
    private int puts;
    private final LruPoolStrategy strategy;
    private final BitmapTracker tracker;

    private interface BitmapTracker {
        void add(Bitmap bitmap);

        void remove(Bitmap bitmap);
    }

    private static class NullBitmapTracker implements BitmapTracker {
        public void add(Bitmap bitmap) {
        }

        public void remove(Bitmap bitmap) {
        }

        private NullBitmapTracker() {
        }
    }

    private static class ThrowingBitmapTracker implements BitmapTracker {
        private final Set<Bitmap> bitmaps = Collections.synchronizedSet(new HashSet());

        private ThrowingBitmapTracker() {
        }

        public void add(Bitmap bitmap) {
            if (this.bitmaps.contains(bitmap)) {
                StringBuilder stringBuilder = new StringBuilder("Can't add already added bitmap: ");
                stringBuilder.append(bitmap);
                stringBuilder.append(" [");
                stringBuilder.append(bitmap.getWidth());
                stringBuilder.append("x");
                stringBuilder.append(bitmap.getHeight());
                stringBuilder.append("]");
                throw new IllegalStateException(stringBuilder.toString());
            }
            this.bitmaps.add(bitmap);
        }

        public void remove(Bitmap bitmap) {
            if (this.bitmaps.contains(bitmap)) {
                this.bitmaps.remove(bitmap);
                return;
            }
            throw new IllegalStateException("Cannot remove bitmap not in tracker");
        }
    }

    LruBitmapPool(int i, LruPoolStrategy lruPoolStrategy, Set<Config> set) {
        this.initialMaxSize = i;
        this.maxSize = i;
        this.strategy = lruPoolStrategy;
        this.allowedConfigs = set;
        this.tracker = new NullBitmapTracker();
    }

    public LruBitmapPool(int i) {
        this(i, getDefaultStrategy(), getDefaultAllowedConfigs());
    }

    public LruBitmapPool(int i, Set<Config> set) {
        this(i, getDefaultStrategy(), set);
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public synchronized void setSizeMultiplier(float f) {
        this.maxSize = Math.round(((float) this.initialMaxSize) * f);
        evict();
    }

    public synchronized boolean put(Bitmap bitmap) {
        if (bitmap == null) {
            throw new NullPointerException("Bitmap must not be null");
        }
        if (bitmap.isMutable() && this.strategy.getSize(bitmap) <= this.maxSize) {
            if (this.allowedConfigs.contains(bitmap.getConfig())) {
                int size = this.strategy.getSize(bitmap);
                this.strategy.put(bitmap);
                this.tracker.add(bitmap);
                this.puts++;
                this.currentSize += size;
                if (Log.isLoggable(TAG, 2)) {
                    new StringBuilder("Put bitmap in pool=").append(this.strategy.logBitmap(bitmap));
                }
                dump();
                evict();
                return true;
            }
        }
        if (Log.isLoggable(TAG, 2)) {
            StringBuilder stringBuilder = new StringBuilder("Reject bitmap from pool, bitmap: ");
            stringBuilder.append(this.strategy.logBitmap(bitmap));
            stringBuilder.append(", is mutable: ");
            stringBuilder.append(bitmap.isMutable());
            stringBuilder.append(", is allowed config: ");
            stringBuilder.append(this.allowedConfigs.contains(bitmap.getConfig()));
        }
        return null;
    }

    private void evict() {
        trimToSize(this.maxSize);
    }

    public synchronized Bitmap get(int i, int i2, Config config) {
        i = getDirty(i, i2, config);
        if (i != 0) {
            i.eraseColor(0);
        }
        return i;
    }

    @TargetApi(12)
    public synchronized Bitmap getDirty(int i, int i2, Config config) {
        Bitmap bitmap;
        bitmap = this.strategy.get(i, i2, config != null ? config : DEFAULT_CONFIG);
        if (bitmap == null) {
            if (Log.isLoggable(TAG, 3)) {
                new StringBuilder("Missing bitmap=").append(this.strategy.logBitmap(i, i2, config));
            }
            this.misses++;
        } else {
            this.hits++;
            this.currentSize -= this.strategy.getSize(bitmap);
            this.tracker.remove(bitmap);
            if (VERSION.SDK_INT >= 12) {
                bitmap.setHasAlpha(true);
            }
        }
        if (Log.isLoggable(TAG, 2)) {
            new StringBuilder("Get bitmap=").append(this.strategy.logBitmap(i, i2, config));
        }
        dump();
        return bitmap;
    }

    public void clearMemory() {
        trimToSize(0);
    }

    @SuppressLint({"InlinedApi"})
    public void trimMemory(int i) {
        if (i >= 60) {
            clearMemory();
            return;
        }
        if (i >= 40) {
            trimToSize(this.maxSize / 2);
        }
    }

    private synchronized void trimToSize(int i) {
        while (this.currentSize > i) {
            Bitmap removeLast = this.strategy.removeLast();
            if (removeLast == null) {
                if (Log.isLoggable(TAG, 5) != 0) {
                    dumpUnchecked();
                }
                this.currentSize = 0;
                return;
            }
            this.tracker.remove(removeLast);
            this.currentSize -= this.strategy.getSize(removeLast);
            removeLast.recycle();
            this.evictions++;
            if (Log.isLoggable(TAG, 3)) {
                new StringBuilder("Evicting bitmap=").append(this.strategy.logBitmap(removeLast));
            }
            dump();
        }
    }

    private void dump() {
        if (Log.isLoggable(TAG, 2)) {
            dumpUnchecked();
        }
    }

    private void dumpUnchecked() {
        StringBuilder stringBuilder = new StringBuilder("Hits=");
        stringBuilder.append(this.hits);
        stringBuilder.append(", misses=");
        stringBuilder.append(this.misses);
        stringBuilder.append(", puts=");
        stringBuilder.append(this.puts);
        stringBuilder.append(", evictions=");
        stringBuilder.append(this.evictions);
        stringBuilder.append(", currentSize=");
        stringBuilder.append(this.currentSize);
        stringBuilder.append(", maxSize=");
        stringBuilder.append(this.maxSize);
        stringBuilder.append("\nStrategy=");
        stringBuilder.append(this.strategy);
    }

    private static LruPoolStrategy getDefaultStrategy() {
        if (VERSION.SDK_INT >= 19) {
            return new SizeConfigStrategy();
        }
        return new AttributeStrategy();
    }

    private static Set<Config> getDefaultAllowedConfigs() {
        Set hashSet = new HashSet();
        hashSet.addAll(Arrays.asList(Config.values()));
        if (VERSION.SDK_INT >= 19) {
            hashSet.add(null);
        }
        return Collections.unmodifiableSet(hashSet);
    }
}
