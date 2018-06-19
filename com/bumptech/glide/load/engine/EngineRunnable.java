package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.executor.Prioritized;
import com.bumptech.glide.request.ResourceCallback;

class EngineRunnable implements Prioritized, Runnable {
    private static final String TAG = "EngineRunnable";
    private final DecodeJob<?, ?, ?> decodeJob;
    private volatile boolean isCancelled;
    private final EngineRunnableManager manager;
    private final Priority priority;
    private Stage stage = Stage.CACHE;

    private enum Stage {
        CACHE,
        SOURCE
    }

    interface EngineRunnableManager extends ResourceCallback {
        void submitForSource(EngineRunnable engineRunnable);
    }

    public EngineRunnable(EngineRunnableManager engineRunnableManager, DecodeJob<?, ?, ?> decodeJob, Priority priority) {
        this.manager = engineRunnableManager;
        this.decodeJob = decodeJob;
        this.priority = priority;
    }

    public void cancel() {
        this.isCancelled = true;
        this.decodeJob.cancel();
    }

    public void run() {
        if (!this.isCancelled) {
            Exception exception;
            Resource resource = null;
            try {
                exception = null;
                resource = decode();
            } catch (Error e) {
                exception = new ErrorWrappingGlideException(e);
            } catch (Exception e2) {
                exception = e2;
            }
            if (this.isCancelled) {
                if (resource != null) {
                    resource.recycle();
                }
            } else if (resource == null) {
                onLoadFailed(exception);
            } else {
                onLoadComplete(resource);
            }
        }
    }

    private boolean isDecodingFromCache() {
        return this.stage == Stage.CACHE;
    }

    private void onLoadComplete(Resource resource) {
        this.manager.onResourceReady(resource);
    }

    private void onLoadFailed(Exception exception) {
        if (isDecodingFromCache()) {
            this.stage = Stage.SOURCE;
            this.manager.submitForSource(this);
            return;
        }
        this.manager.onException(exception);
    }

    private Resource<?> decode() throws Exception {
        if (isDecodingFromCache()) {
            return decodeFromCache();
        }
        return decodeFromSource();
    }

    private Resource<?> decodeFromCache() throws Exception {
        Resource<?> decodeResultFromCache;
        try {
            decodeResultFromCache = this.decodeJob.decodeResultFromCache();
        } catch (Exception e) {
            if (Log.isLoggable(TAG, 3)) {
                new StringBuilder("Exception decoding result from cache: ").append(e);
            }
            decodeResultFromCache = null;
        }
        return decodeResultFromCache == null ? this.decodeJob.decodeSourceFromCache() : decodeResultFromCache;
    }

    private Resource<?> decodeFromSource() throws Exception {
        return this.decodeJob.decodeFromSource();
    }

    public int getPriority() {
        return this.priority.ordinal();
    }
}
