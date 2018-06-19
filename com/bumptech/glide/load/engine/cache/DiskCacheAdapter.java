package com.bumptech.glide.load.engine.cache;

import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.engine.cache.DiskCache.Writer;
import java.io.File;

public class DiskCacheAdapter implements DiskCache {
    public void clear() {
    }

    public void delete(Key key) {
    }

    public File get(Key key) {
        return null;
    }

    public void put(Key key, Writer writer) {
    }
}
