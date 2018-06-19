package com.bumptech.glide.load.engine.cache;

import android.annotation.SuppressLint;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.cache.MemoryCache.ResourceRemovedListener;
import com.bumptech.glide.util.LruCache;

public class LruResourceCache extends LruCache<Key, Resource<?>> implements MemoryCache {
    private ResourceRemovedListener listener;

    public /* bridge */ /* synthetic */ Resource put(Key key, Resource resource) {
        return (Resource) super.put(key, resource);
    }

    public /* bridge */ /* synthetic */ Resource remove(Key key) {
        return (Resource) super.remove(key);
    }

    public LruResourceCache(int i) {
        super(i);
    }

    public void setResourceRemovedListener(ResourceRemovedListener resourceRemovedListener) {
        this.listener = resourceRemovedListener;
    }

    protected void onItemEvicted(Key key, Resource<?> resource) {
        if (this.listener != null) {
            this.listener.onResourceRemoved(resource);
        }
    }

    protected int getSize(Resource<?> resource) {
        return resource.getSize();
    }

    @SuppressLint({"InlinedApi"})
    public void trimMemory(int i) {
        if (i >= 60) {
            clearMemory();
            return;
        }
        if (i >= 40) {
            trimToSize(getCurrentSize() / 2);
        }
    }
}
