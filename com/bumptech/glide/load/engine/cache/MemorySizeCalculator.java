package com.bumptech.glide.load.engine.cache;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;

public class MemorySizeCalculator {
    static final int BITMAP_POOL_TARGET_SCREENS = 4;
    static final int BYTES_PER_ARGB_8888_PIXEL = 4;
    static final float LOW_MEMORY_MAX_SIZE_MULTIPLIER = 0.33f;
    static final float MAX_SIZE_MULTIPLIER = 0.4f;
    static final int MEMORY_CACHE_TARGET_SCREENS = 2;
    private static final String TAG = "MemorySizeCalculator";
    private final int bitmapPoolSize;
    private final Context context;
    private final int memoryCacheSize;

    interface ScreenDimensions {
        int getHeightPixels();

        int getWidthPixels();
    }

    private static class DisplayMetricsScreenDimensions implements ScreenDimensions {
        private final DisplayMetrics displayMetrics;

        public DisplayMetricsScreenDimensions(DisplayMetrics displayMetrics) {
            this.displayMetrics = displayMetrics;
        }

        public int getWidthPixels() {
            return this.displayMetrics.widthPixels;
        }

        public int getHeightPixels() {
            return this.displayMetrics.heightPixels;
        }
    }

    public MemorySizeCalculator(Context context) {
        this(context, (ActivityManager) context.getSystemService("activity"), new DisplayMetricsScreenDimensions(context.getResources().getDisplayMetrics()));
    }

    MemorySizeCalculator(Context context, ActivityManager activityManager, ScreenDimensions screenDimensions) {
        this.context = context;
        context = getMaxSize(activityManager);
        int widthPixels = (screenDimensions.getWidthPixels() * screenDimensions.getHeightPixels()) * 4;
        screenDimensions = widthPixels * 4;
        widthPixels *= 2;
        int i = widthPixels + screenDimensions;
        if (i <= context) {
            this.memoryCacheSize = widthPixels;
            this.bitmapPoolSize = screenDimensions;
        } else {
            screenDimensions = Math.round(((float) context) / 6.0f);
            this.memoryCacheSize = screenDimensions * 2;
            this.bitmapPoolSize = screenDimensions * 4;
        }
        if (Log.isLoggable(TAG, 3) != null) {
            screenDimensions = new StringBuilder("Calculated memory cache size: ");
            screenDimensions.append(toMb(this.memoryCacheSize));
            screenDimensions.append(" pool size: ");
            screenDimensions.append(toMb(this.bitmapPoolSize));
            screenDimensions.append(" memory class limited? ");
            screenDimensions.append(i > context);
            screenDimensions.append(" max size: ");
            screenDimensions.append(toMb(context));
            screenDimensions.append(" memoryClass: ");
            screenDimensions.append(activityManager.getMemoryClass());
            screenDimensions.append(" isLowMemoryDevice: ");
            screenDimensions.append(isLowMemoryDevice(activityManager));
        }
    }

    public int getMemoryCacheSize() {
        return this.memoryCacheSize;
    }

    public int getBitmapPoolSize() {
        return this.bitmapPoolSize;
    }

    private static int getMaxSize(ActivityManager activityManager) {
        return Math.round(((float) ((activityManager.getMemoryClass() * 1024) * 1024)) * (isLowMemoryDevice(activityManager) != null ? 1051260355 : 1053609165));
    }

    private String toMb(int i) {
        return Formatter.formatFileSize(this.context, (long) i);
    }

    @TargetApi(19)
    private static boolean isLowMemoryDevice(ActivityManager activityManager) {
        if (VERSION.SDK_INT >= 19) {
            return activityManager.isLowRamDevice();
        }
        return VERSION.SDK_INT < 11 ? true : null;
    }
}
