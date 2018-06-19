package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.MemoryCache.ResourceRemovedListener;

public class MemoryCacheAdapter implements MemoryCache {
    private ResourceRemovedListener listener;

    public void clearMemory() {
    }

    public int getCurrentSize() {
        return 0;
    }

    public int getMaxSize() {
        return 0;
    }

    public Resource<?> remove(Key key) {
        return null;
    }

    public void setSizeMultiplier(float f) {
    }

    public void trimMemory(int i) {
    }

    public Resource<?> put(Key key, Resource<?> resource) {
        this.listener.onResourceRemoved(resource);
        return null;
    }

    public void setResourceRemovedListener(ResourceRemovedListener resourceRemovedListener) {
        this.listener = resourceRemovedListener;
    }
}
