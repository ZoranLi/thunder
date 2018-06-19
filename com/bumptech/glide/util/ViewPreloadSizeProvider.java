package com.bumptech.glide.util;

import android.view.View;
import com.bumptech.glide.ListPreloader.PreloadSizeProvider;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.ViewTarget;
import java.util.Arrays;

public class ViewPreloadSizeProvider<T> implements PreloadSizeProvider<T>, SizeReadyCallback {
    private int[] size;
    private SizeViewTarget viewTarget;

    private static final class SizeViewTarget extends ViewTarget<View, Object> {
        public final void onResourceReady(Object obj, GlideAnimation glideAnimation) {
        }

        public SizeViewTarget(View view, SizeReadyCallback sizeReadyCallback) {
            super(view);
            getSize(sizeReadyCallback);
        }
    }

    public ViewPreloadSizeProvider(View view) {
        setView(view);
    }

    public int[] getPreloadSize(T t, int i, int i2) {
        if (this.size == null) {
            return null;
        }
        return Arrays.copyOf(this.size, this.size.length);
    }

    public void onSizeReady(int i, int i2) {
        this.size = new int[]{i, i2};
        this.viewTarget = 0;
    }

    public void setView(View view) {
        if (this.size == null) {
            if (this.viewTarget == null) {
                this.viewTarget = new SizeViewTarget(view, this);
            }
        }
    }
}
