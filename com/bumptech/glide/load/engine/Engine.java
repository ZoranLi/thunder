package com.bumptech.glide.load.engine;

import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskCache.Factory;
import com.bumptech.glide.load.engine.cache.DiskCacheAdapter;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.cache.MemoryCache.ResourceRemovedListener;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.provider.DataLoadProvider;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;

public class Engine implements EngineJobListener, ResourceListener, ResourceRemovedListener {
    private static final String TAG = "Engine";
    private final Map<Key, WeakReference<EngineResource<?>>> activeResources;
    private final MemoryCache cache;
    private final LazyDiskCacheProvider diskCacheProvider;
    private final EngineJobFactory engineJobFactory;
    private final Map<Key, EngineJob> jobs;
    private final EngineKeyFactory keyFactory;
    private final ResourceRecycler resourceRecycler;
    private ReferenceQueue<EngineResource<?>> resourceReferenceQueue;

    static class EngineJobFactory {
        private final ExecutorService diskCacheService;
        private final EngineJobListener listener;
        private final ExecutorService sourceService;

        public EngineJobFactory(ExecutorService executorService, ExecutorService executorService2, EngineJobListener engineJobListener) {
            this.diskCacheService = executorService;
            this.sourceService = executorService2;
            this.listener = engineJobListener;
        }

        public EngineJob build(Key key, boolean z) {
            return new EngineJob(key, this.diskCacheService, this.sourceService, z, this.listener);
        }
    }

    public static class LoadStatus {
        private final ResourceCallback cb;
        private final EngineJob engineJob;

        public LoadStatus(ResourceCallback resourceCallback, EngineJob engineJob) {
            this.cb = resourceCallback;
            this.engineJob = engineJob;
        }

        public void cancel() {
            this.engineJob.removeCallback(this.cb);
        }
    }

    private static class RefQueueIdleHandler implements IdleHandler {
        private final Map<Key, WeakReference<EngineResource<?>>> activeResources;
        private final ReferenceQueue<EngineResource<?>> queue;

        public RefQueueIdleHandler(Map<Key, WeakReference<EngineResource<?>>> map, ReferenceQueue<EngineResource<?>> referenceQueue) {
            this.activeResources = map;
            this.queue = referenceQueue;
        }

        public boolean queueIdle() {
            ResourceWeakReference resourceWeakReference = (ResourceWeakReference) this.queue.poll();
            if (resourceWeakReference != null) {
                this.activeResources.remove(resourceWeakReference.key);
            }
            return true;
        }
    }

    private static class ResourceWeakReference extends WeakReference<EngineResource<?>> {
        private final Key key;

        public ResourceWeakReference(Key key, EngineResource<?> engineResource, ReferenceQueue<? super EngineResource<?>> referenceQueue) {
            super(engineResource, referenceQueue);
            this.key = key;
        }
    }

    private static class LazyDiskCacheProvider implements DiskCacheProvider {
        private volatile DiskCache diskCache;
        private final Factory factory;

        public LazyDiskCacheProvider(Factory factory) {
            this.factory = factory;
        }

        public DiskCache getDiskCache() {
            if (this.diskCache == null) {
                synchronized (this) {
                    if (this.diskCache == null) {
                        this.diskCache = this.factory.build();
                    }
                    if (this.diskCache == null) {
                        this.diskCache = new DiskCacheAdapter();
                    }
                }
            }
            return this.diskCache;
        }
    }

    public Engine(MemoryCache memoryCache, Factory factory, ExecutorService executorService, ExecutorService executorService2) {
        this(memoryCache, factory, executorService, executorService2, null, null, null, null, null);
    }

    Engine(MemoryCache memoryCache, Factory factory, ExecutorService executorService, ExecutorService executorService2, Map<Key, EngineJob> map, EngineKeyFactory engineKeyFactory, Map<Key, WeakReference<EngineResource<?>>> map2, EngineJobFactory engineJobFactory, ResourceRecycler resourceRecycler) {
        this.cache = memoryCache;
        this.diskCacheProvider = new LazyDiskCacheProvider(factory);
        if (map2 == null) {
            map2 = new HashMap();
        }
        this.activeResources = map2;
        if (engineKeyFactory == null) {
            engineKeyFactory = new EngineKeyFactory();
        }
        this.keyFactory = engineKeyFactory;
        if (map == null) {
            map = new HashMap();
        }
        this.jobs = map;
        if (engineJobFactory == null) {
            engineJobFactory = new EngineJobFactory(executorService, executorService2, this);
        }
        this.engineJobFactory = engineJobFactory;
        if (resourceRecycler == null) {
            resourceRecycler = new ResourceRecycler();
        }
        this.resourceRecycler = resourceRecycler;
        memoryCache.setResourceRemovedListener(this);
    }

    public <T, Z, R> LoadStatus load(Key key, int i, int i2, DataFetcher<T> dataFetcher, DataLoadProvider<T, Z> dataLoadProvider, Transformation<Z> transformation, ResourceTranscoder<Z, R> resourceTranscoder, Priority priority, boolean z, DiskCacheStrategy diskCacheStrategy, ResourceCallback resourceCallback) {
        boolean z2 = z;
        ResourceCallback resourceCallback2 = resourceCallback;
        Util.assertMainThread();
        long logTime = LogTime.getLogTime();
        Key buildKey = this.keyFactory.buildKey(dataFetcher.getId(), key, i, i2, dataLoadProvider.getCacheDecoder(), dataLoadProvider.getSourceDecoder(), transformation, dataLoadProvider.getEncoder(), resourceTranscoder, dataLoadProvider.getSourceEncoder());
        Resource loadFromCache = loadFromCache(buildKey, z2);
        if (loadFromCache != null) {
            resourceCallback2.onResourceReady(loadFromCache);
            if (Log.isLoggable(TAG, 2)) {
                logWithTimeAndKey("Loaded resource from cache", logTime, buildKey);
            }
            return null;
        }
        loadFromCache = loadFromActiveResources(buildKey, z2);
        if (loadFromCache != null) {
            resourceCallback2.onResourceReady(loadFromCache);
            if (Log.isLoggable(TAG, 2)) {
                logWithTimeAndKey("Loaded resource from active resources", logTime, buildKey);
            }
            return null;
        }
        EngineJob engineJob = (EngineJob) r0.jobs.get(buildKey);
        if (engineJob != null) {
            engineJob.addCallback(resourceCallback2);
            if (Log.isLoggable(TAG, 2)) {
                logWithTimeAndKey("Added to existing load", logTime, buildKey);
            }
            return new LoadStatus(resourceCallback2, engineJob);
        }
        EngineJob build = r0.engineJobFactory.build(buildKey, z2);
        EngineRunnable engineRunnable = new EngineRunnable(build, new DecodeJob(buildKey, i, i2, dataFetcher, dataLoadProvider, transformation, resourceTranscoder, r0.diskCacheProvider, diskCacheStrategy, priority), priority);
        r0.jobs.put(buildKey, build);
        build.addCallback(resourceCallback2);
        build.start(engineRunnable);
        if (Log.isLoggable(TAG, 2)) {
            logWithTimeAndKey("Started new load", logTime, buildKey);
        }
        return new LoadStatus(resourceCallback2, build);
    }

    private static void logWithTimeAndKey(String str, long j, Key key) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" in ");
        stringBuilder.append(LogTime.getElapsedMillis(j));
        stringBuilder.append("ms, key: ");
        stringBuilder.append(key);
    }

    private EngineResource<?> loadFromActiveResources(Key key, boolean z) {
        EngineResource<?> engineResource = null;
        if (!z) {
            return null;
        }
        WeakReference weakReference = (WeakReference) this.activeResources.get(key);
        if (weakReference != null) {
            engineResource = (EngineResource) weakReference.get();
            if (engineResource != null) {
                engineResource.acquire();
            } else {
                this.activeResources.remove(key);
            }
        }
        return engineResource;
    }

    private EngineResource<?> loadFromCache(Key key, boolean z) {
        if (!z) {
            return null;
        }
        z = getEngineResourceFromCache(key);
        if (z) {
            z.acquire();
            this.activeResources.put(key, new ResourceWeakReference(key, z, getReferenceQueue()));
        }
        return z;
    }

    private EngineResource<?> getEngineResourceFromCache(Key key) {
        key = this.cache.remove(key);
        if (key == null) {
            return null;
        }
        if (key instanceof EngineResource) {
            return (EngineResource) key;
        }
        return new EngineResource(key, true);
    }

    public void release(Resource resource) {
        Util.assertMainThread();
        if (resource instanceof EngineResource) {
            ((EngineResource) resource).release();
            return;
        }
        throw new IllegalArgumentException("Cannot release anything but an EngineResource");
    }

    public void onEngineJobComplete(Key key, EngineResource<?> engineResource) {
        Util.assertMainThread();
        if (engineResource != null) {
            engineResource.setResourceListener(key, this);
            if (engineResource.isCacheable()) {
                this.activeResources.put(key, new ResourceWeakReference(key, engineResource, getReferenceQueue()));
            }
        }
        this.jobs.remove(key);
    }

    public void onEngineJobCancelled(EngineJob engineJob, Key key) {
        Util.assertMainThread();
        if (engineJob.equals((EngineJob) this.jobs.get(key)) != null) {
            this.jobs.remove(key);
        }
    }

    public void onResourceRemoved(Resource<?> resource) {
        Util.assertMainThread();
        this.resourceRecycler.recycle(resource);
    }

    public void onResourceReleased(Key key, EngineResource engineResource) {
        Util.assertMainThread();
        this.activeResources.remove(key);
        if (engineResource.isCacheable()) {
            this.cache.put(key, engineResource);
        } else {
            this.resourceRecycler.recycle(engineResource);
        }
    }

    public void clearDiskCache() {
        this.diskCacheProvider.getDiskCache().clear();
    }

    private ReferenceQueue<EngineResource<?>> getReferenceQueue() {
        if (this.resourceReferenceQueue == null) {
            this.resourceReferenceQueue = new ReferenceQueue();
            Looper.myQueue().addIdleHandler(new RefQueueIdleHandler(this.activeResources, this.resourceReferenceQueue));
        }
        return this.resourceReferenceQueue;
    }
}
