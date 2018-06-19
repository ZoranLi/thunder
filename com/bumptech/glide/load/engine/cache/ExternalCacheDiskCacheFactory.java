package com.bumptech.glide.load.engine.cache;

import android.content.Context;
import com.bumptech.glide.load.engine.cache.DiskCache.Factory;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter;
import java.io.File;

public final class ExternalCacheDiskCacheFactory extends DiskLruCacheFactory {

    class AnonymousClass1 implements CacheDirectoryGetter {
        final /* synthetic */ Context val$context;
        final /* synthetic */ String val$diskCacheName;

        AnonymousClass1(Context context, String str) {
            this.val$context = context;
            this.val$diskCacheName = str;
        }

        public File getCacheDirectory() {
            File externalCacheDir = this.val$context.getExternalCacheDir();
            if (externalCacheDir == null) {
                return null;
            }
            return this.val$diskCacheName != null ? new File(externalCacheDir, this.val$diskCacheName) : externalCacheDir;
        }
    }

    public ExternalCacheDiskCacheFactory(Context context) {
        this(context, Factory.DEFAULT_DISK_CACHE_DIR, Factory.DEFAULT_DISK_CACHE_SIZE);
    }

    public ExternalCacheDiskCacheFactory(Context context, int i) {
        this(context, Factory.DEFAULT_DISK_CACHE_DIR, i);
    }

    public ExternalCacheDiskCacheFactory(Context context, String str, int i) {
        super(new AnonymousClass1(context, str), i);
    }
}
