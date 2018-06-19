package com.bumptech.glide;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.BaseTarget;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.util.Util;
import java.util.List;
import java.util.Queue;

public class ListPreloader<T> implements OnScrollListener {
    private boolean isIncreasing;
    private int lastEnd;
    private int lastFirstVisible;
    private int lastStart;
    private final int maxPreload;
    private final PreloadSizeProvider<T> preloadDimensionProvider;
    private final PreloadModelProvider<T> preloadModelProvider;
    private final PreloadTargetQueue preloadTargetQueue;
    private int totalItemCount;

    public interface PreloadModelProvider<U> {
        List<U> getPreloadItems(int i);

        GenericRequestBuilder getPreloadRequestBuilder(U u);
    }

    public interface PreloadSizeProvider<T> {
        int[] getPreloadSize(T t, int i, int i2);
    }

    private static final class PreloadTargetQueue {
        private final Queue<PreloadTarget> queue;

        public PreloadTargetQueue(int i) {
            this.queue = Util.createQueue(i);
            for (int i2 = 0; i2 < i; i2++) {
                this.queue.offer(new PreloadTarget());
            }
        }

        public final PreloadTarget next(int i, int i2) {
            PreloadTarget preloadTarget = (PreloadTarget) this.queue.poll();
            this.queue.offer(preloadTarget);
            preloadTarget.photoWidth = i;
            preloadTarget.photoHeight = i2;
            return preloadTarget;
        }
    }

    private static class PreloadTarget extends BaseTarget<Object> {
        private int photoHeight;
        private int photoWidth;

        public void onResourceReady(Object obj, GlideAnimation<? super Object> glideAnimation) {
        }

        private PreloadTarget() {
        }

        public void getSize(SizeReadyCallback sizeReadyCallback) {
            sizeReadyCallback.onSizeReady(this.photoWidth, this.photoHeight);
        }
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Deprecated
    public ListPreloader(int i) {
        this.isIncreasing = true;
        this.preloadModelProvider = new PreloadModelProvider<T>() {
            public List<T> getPreloadItems(int i) {
                return ListPreloader.this.getItems(i, i + 1);
            }

            public GenericRequestBuilder getPreloadRequestBuilder(T t) {
                return ListPreloader.this.getRequestBuilder(t);
            }
        };
        this.preloadDimensionProvider = new PreloadSizeProvider<T>() {
            public int[] getPreloadSize(T t, int i, int i2) {
                return ListPreloader.this.getDimensions(t);
            }
        };
        this.maxPreload = i;
        this.preloadTargetQueue = new PreloadTargetQueue(i + 1);
    }

    public ListPreloader(PreloadModelProvider<T> preloadModelProvider, PreloadSizeProvider<T> preloadSizeProvider, int i) {
        this.isIncreasing = true;
        this.preloadModelProvider = preloadModelProvider;
        this.preloadDimensionProvider = preloadSizeProvider;
        this.maxPreload = i;
        this.preloadTargetQueue = new PreloadTargetQueue(i + 1);
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        this.totalItemCount = i3;
        if (i > this.lastFirstVisible) {
            preload(i2 + i, true);
        } else if (i < this.lastFirstVisible) {
            preload(i, (boolean) null);
        }
        this.lastFirstVisible = i;
    }

    @Deprecated
    protected int[] getDimensions(T t) {
        throw new IllegalStateException("You must either provide a PreloadDimensionProvider or override getDimensions()");
    }

    @Deprecated
    protected List<T> getItems(int i, int i2) {
        throw new IllegalStateException("You must either provide a PreloadModelProvider or override getItems()");
    }

    @Deprecated
    protected GenericRequestBuilder getRequestBuilder(T t) {
        throw new IllegalStateException("You must either provide a PreloadModelProvider, or override getRequestBuilder()");
    }

    private void preload(int i, boolean z) {
        if (this.isIncreasing != z) {
            this.isIncreasing = z;
            cancelAll();
        }
        preload(i, (z ? this.maxPreload : -this.maxPreload) + i);
    }

    private void preload(int i, int i2) {
        int max;
        int i3;
        if (i < i2) {
            max = Math.max(this.lastEnd, i);
            i3 = i2;
        } else {
            i3 = Math.min(this.lastStart, i);
            max = i2;
        }
        i3 = Math.min(this.totalItemCount, i3);
        max = Math.min(this.totalItemCount, Math.max(0, max));
        if (i < i2) {
            for (i = max; i < i3; i++) {
                preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(i), i, true);
            }
        } else {
            for (i = i3 - 1; i >= max; i--) {
                preloadAdapterPosition(this.preloadModelProvider.getPreloadItems(i), i, false);
            }
        }
        this.lastStart = max;
        this.lastEnd = i3;
    }

    private void preloadAdapterPosition(List<T> list, int i, boolean z) {
        boolean size = list.size();
        if (z) {
            for (z = false; z < size; z++) {
                preloadItem(list.get(z), i, z);
            }
            return;
        }
        for (int i2 = size - 1; i2 >= 0; i2--) {
            preloadItem(list.get(i2), i, i2);
        }
    }

    private void preloadItem(T t, int i, int i2) {
        i = this.preloadDimensionProvider.getPreloadSize(t, i, i2);
        if (i != 0) {
            this.preloadModelProvider.getPreloadRequestBuilder(t).into(this.preloadTargetQueue.next(i[0], i[1]));
        }
    }

    private void cancelAll() {
        for (int i = 0; i < this.maxPreload; i++) {
            Glide.clear(this.preloadTargetQueue.next(0, 0));
        }
    }
}
