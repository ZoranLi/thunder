package com.bumptech.glide.load.engine;

import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.request.ResourceCallback;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

class EngineJob implements EngineRunnableManager {
    private static final EngineResourceFactory DEFAULT_FACTORY = new EngineResourceFactory();
    private static final Handler MAIN_THREAD_HANDLER = new Handler(Looper.getMainLooper(), new MainThreadCallback());
    private static final int MSG_COMPLETE = 1;
    private static final int MSG_EXCEPTION = 2;
    private final List<ResourceCallback> cbs;
    private final ExecutorService diskCacheService;
    private EngineResource<?> engineResource;
    private final EngineResourceFactory engineResourceFactory;
    private EngineRunnable engineRunnable;
    private Exception exception;
    private volatile Future<?> future;
    private boolean hasException;
    private boolean hasResource;
    private Set<ResourceCallback> ignoredCallbacks;
    private final boolean isCacheable;
    private boolean isCancelled;
    private final Key key;
    private final EngineJobListener listener;
    private Resource<?> resource;
    private final ExecutorService sourceService;

    static class EngineResourceFactory {
        EngineResourceFactory() {
        }

        public <R> EngineResource<R> build(Resource<R> resource, boolean z) {
            return new EngineResource(resource, z);
        }
    }

    private static class MainThreadCallback implements Callback {
        private MainThreadCallback() {
        }

        public boolean handleMessage(Message message) {
            if (1 != message.what) {
                if (2 != message.what) {
                    return null;
                }
            }
            EngineJob engineJob = (EngineJob) message.obj;
            if (1 == message.what) {
                engineJob.handleResultOnMainThread();
            } else {
                engineJob.handleExceptionOnMainThread();
            }
            return true;
        }
    }

    public EngineJob(Key key, ExecutorService executorService, ExecutorService executorService2, boolean z, EngineJobListener engineJobListener) {
        this(key, executorService, executorService2, z, engineJobListener, DEFAULT_FACTORY);
    }

    public EngineJob(Key key, ExecutorService executorService, ExecutorService executorService2, boolean z, EngineJobListener engineJobListener, EngineResourceFactory engineResourceFactory) {
        this.cbs = new ArrayList();
        this.key = key;
        this.diskCacheService = executorService;
        this.sourceService = executorService2;
        this.isCacheable = z;
        this.listener = engineJobListener;
        this.engineResourceFactory = engineResourceFactory;
    }

    public void start(EngineRunnable engineRunnable) {
        this.engineRunnable = engineRunnable;
        this.future = this.diskCacheService.submit(engineRunnable);
    }

    public void submitForSource(EngineRunnable engineRunnable) {
        this.future = this.sourceService.submit(engineRunnable);
    }

    public void addCallback(ResourceCallback resourceCallback) {
        Util.assertMainThread();
        if (this.hasResource) {
            resourceCallback.onResourceReady(this.engineResource);
        } else if (this.hasException) {
            resourceCallback.onException(this.exception);
        } else {
            this.cbs.add(resourceCallback);
        }
    }

    public void removeCallback(ResourceCallback resourceCallback) {
        Util.assertMainThread();
        if (!this.hasResource) {
            if (!this.hasException) {
                this.cbs.remove(resourceCallback);
                if (this.cbs.isEmpty() != null) {
                    cancel();
                }
                return;
            }
        }
        addIgnoredCallback(resourceCallback);
    }

    private void addIgnoredCallback(ResourceCallback resourceCallback) {
        if (this.ignoredCallbacks == null) {
            this.ignoredCallbacks = new HashSet();
        }
        this.ignoredCallbacks.add(resourceCallback);
    }

    private boolean isInIgnoredCallbacks(ResourceCallback resourceCallback) {
        return (this.ignoredCallbacks == null || this.ignoredCallbacks.contains(resourceCallback) == null) ? null : true;
    }

    void cancel() {
        if (!(this.hasException || this.hasResource)) {
            if (!this.isCancelled) {
                this.engineRunnable.cancel();
                Future future = this.future;
                if (future != null) {
                    future.cancel(true);
                }
                this.isCancelled = true;
                this.listener.onEngineJobCancelled(this, this.key);
            }
        }
    }

    boolean isCancelled() {
        return this.isCancelled;
    }

    public void onResourceReady(Resource<?> resource) {
        this.resource = resource;
        MAIN_THREAD_HANDLER.obtainMessage(1, this).sendToTarget();
    }

    private void handleResultOnMainThread() {
        if (this.isCancelled) {
            this.resource.recycle();
        } else if (this.cbs.isEmpty()) {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        } else {
            this.engineResource = this.engineResourceFactory.build(this.resource, this.isCacheable);
            this.hasResource = true;
            this.engineResource.acquire();
            this.listener.onEngineJobComplete(this.key, this.engineResource);
            for (ResourceCallback resourceCallback : this.cbs) {
                if (!isInIgnoredCallbacks(resourceCallback)) {
                    this.engineResource.acquire();
                    resourceCallback.onResourceReady(this.engineResource);
                }
            }
            this.engineResource.release();
        }
    }

    public void onException(Exception exception) {
        this.exception = exception;
        MAIN_THREAD_HANDLER.obtainMessage(2, this).sendToTarget();
    }

    private void handleExceptionOnMainThread() {
        if (!this.isCancelled) {
            if (this.cbs.isEmpty()) {
                throw new IllegalStateException("Received an exception without any callbacks to notify");
            }
            this.hasException = true;
            this.listener.onEngineJobComplete(this.key, null);
            for (ResourceCallback resourceCallback : this.cbs) {
                if (!isInIgnoredCallbacks(resourceCallback)) {
                    resourceCallback.onException(this.exception);
                }
            }
        }
    }
}
