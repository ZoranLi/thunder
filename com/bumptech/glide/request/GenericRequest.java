package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.Engine.LoadStatus;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.provider.LoadProvider;
import com.bumptech.glide.request.animation.GlideAnimationFactory;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import java.util.Queue;

public final class GenericRequest<A, T, Z, R> implements Request, ResourceCallback, SizeReadyCallback {
    private static final Queue<GenericRequest<?, ?, ?, ?>> REQUEST_POOL = Util.createQueue(0);
    private static final String TAG = "GenericRequest";
    private static final double TO_MEGABYTE = 9.5367431640625E-7d;
    private GlideAnimationFactory<R> animationFactory;
    private Context context;
    private DiskCacheStrategy diskCacheStrategy;
    private Engine engine;
    private Drawable errorDrawable;
    private int errorResourceId;
    private Drawable fallbackDrawable;
    private int fallbackResourceId;
    private boolean isMemoryCacheable;
    private LoadProvider<A, T, Z, R> loadProvider;
    private LoadStatus loadStatus;
    private boolean loadedFromMemoryCache;
    private A model;
    private int overrideHeight;
    private int overrideWidth;
    private Drawable placeholderDrawable;
    private int placeholderResourceId;
    private Priority priority;
    private RequestCoordinator requestCoordinator;
    private RequestListener<? super A, R> requestListener;
    private Resource<?> resource;
    private Key signature;
    private float sizeMultiplier;
    private long startTime;
    private Status status;
    private final String tag = String.valueOf(hashCode());
    private Target<R> target;
    private Class<R> transcodeClass;
    private Transformation<Z> transformation;

    private enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CANCELLED,
        CLEARED,
        PAUSED
    }

    public static <A, T, Z, R> GenericRequest<A, T, Z, R> obtain(LoadProvider<A, T, Z, R> loadProvider, A a, Key key, Context context, Priority priority, Target<R> target, float f, Drawable drawable, int i, Drawable drawable2, int i2, Drawable drawable3, int i3, RequestListener<? super A, R> requestListener, RequestCoordinator requestCoordinator, Engine engine, Transformation<Z> transformation, Class<R> cls, boolean z, GlideAnimationFactory<R> glideAnimationFactory, int i4, int i5, DiskCacheStrategy diskCacheStrategy) {
        GenericRequest<A, T, Z, R> genericRequest = (GenericRequest) REQUEST_POOL.poll();
        if (genericRequest == null) {
            genericRequest = new GenericRequest();
        }
        genericRequest.init(loadProvider, a, key, context, priority, target, f, drawable, i, drawable2, i2, drawable3, i3, requestListener, requestCoordinator, engine, transformation, cls, z, glideAnimationFactory, i4, i5, diskCacheStrategy);
        return genericRequest;
    }

    private GenericRequest() {
    }

    public final void recycle() {
        this.loadProvider = null;
        this.model = null;
        this.context = null;
        this.target = null;
        this.placeholderDrawable = null;
        this.errorDrawable = null;
        this.fallbackDrawable = null;
        this.requestListener = null;
        this.requestCoordinator = null;
        this.transformation = null;
        this.animationFactory = null;
        this.loadedFromMemoryCache = false;
        this.loadStatus = null;
        REQUEST_POOL.offer(this);
    }

    private void init(LoadProvider<A, T, Z, R> loadProvider, A a, Key key, Context context, Priority priority, Target<R> target, float f, Drawable drawable, int i, Drawable drawable2, int i2, Drawable drawable3, int i3, RequestListener<? super A, R> requestListener, RequestCoordinator requestCoordinator, Engine engine, Transformation<Z> transformation, Class<R> cls, boolean z, GlideAnimationFactory<R> glideAnimationFactory, int i4, int i5, DiskCacheStrategy diskCacheStrategy) {
        A a2 = a;
        Transformation<Z> transformation2 = transformation;
        LoadProvider<A, T, Z, R> loadProvider2 = loadProvider;
        this.loadProvider = loadProvider2;
        this.model = a2;
        this.signature = key;
        this.fallbackDrawable = drawable3;
        this.fallbackResourceId = i3;
        this.context = context.getApplicationContext();
        this.priority = priority;
        this.target = target;
        this.sizeMultiplier = f;
        this.placeholderDrawable = drawable;
        this.placeholderResourceId = i;
        this.errorDrawable = drawable2;
        this.errorResourceId = i2;
        this.requestListener = requestListener;
        this.requestCoordinator = requestCoordinator;
        this.engine = engine;
        this.transformation = transformation2;
        this.transcodeClass = cls;
        this.isMemoryCacheable = z;
        this.animationFactory = glideAnimationFactory;
        this.overrideWidth = i4;
        this.overrideHeight = i5;
        this.diskCacheStrategy = diskCacheStrategy;
        this.status = Status.PENDING;
        if (a2 != null) {
            check("ModelLoader", loadProvider2.getModelLoader(), "try .using(ModelLoader)");
            check("Transcoder", loadProvider2.getTranscoder(), "try .as*(Class).transcode(ResourceTranscoder)");
            check("Transformation", transformation2, "try .transform(UnitTransformation.get())");
            if (diskCacheStrategy.cacheSource()) {
                check("SourceEncoder", loadProvider2.getSourceEncoder(), "try .sourceEncoder(Encoder) or .diskCacheStrategy(NONE/RESULT)");
            } else {
                check("SourceDecoder", loadProvider2.getSourceDecoder(), "try .decoder/.imageDecoder/.videoDecoder(ResourceDecoder) or .diskCacheStrategy(ALL/SOURCE)");
            }
            if (diskCacheStrategy.cacheSource() || diskCacheStrategy.cacheResult()) {
                check("CacheDecoder", loadProvider2.getCacheDecoder(), "try .cacheDecoder(ResouceDecoder) or .diskCacheStrategy(NONE)");
            }
            if (diskCacheStrategy.cacheResult()) {
                check("Encoder", loadProvider2.getEncoder(), "try .encode(ResourceEncoder) or .diskCacheStrategy(NONE/SOURCE)");
            }
        }
    }

    private static void check(String str, Object obj, String str2) {
        if (obj == null) {
            obj = new StringBuilder(str);
            obj.append(" must not be null");
            if (str2 != null) {
                obj.append(", ");
                obj.append(str2);
            }
            throw new NullPointerException(obj.toString());
        }
    }

    public final void begin() {
        this.startTime = LogTime.getLogTime();
        if (this.model == null) {
            onException(null);
            return;
        }
        this.status = Status.WAITING_FOR_SIZE;
        if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight)) {
            onSizeReady(this.overrideWidth, this.overrideHeight);
        } else {
            this.target.getSize(this);
        }
        if (!(isComplete() || isFailed() || !canNotifyStatusChanged())) {
            this.target.onLoadStarted(getPlaceholderDrawable());
        }
        if (Log.isLoggable(TAG, 2)) {
            StringBuilder stringBuilder = new StringBuilder("finished run method in ");
            stringBuilder.append(LogTime.getElapsedMillis(this.startTime));
            logV(stringBuilder.toString());
        }
    }

    final void cancel() {
        this.status = Status.CANCELLED;
        if (this.loadStatus != null) {
            this.loadStatus.cancel();
            this.loadStatus = null;
        }
    }

    public final void clear() {
        Util.assertMainThread();
        if (this.status != Status.CLEARED) {
            cancel();
            if (this.resource != null) {
                releaseResource(this.resource);
            }
            if (canNotifyStatusChanged()) {
                this.target.onLoadCleared(getPlaceholderDrawable());
            }
            this.status = Status.CLEARED;
        }
    }

    public final boolean isPaused() {
        return this.status == Status.PAUSED;
    }

    public final void pause() {
        clear();
        this.status = Status.PAUSED;
    }

    private void releaseResource(Resource resource) {
        this.engine.release(resource);
        this.resource = null;
    }

    public final boolean isRunning() {
        if (this.status != Status.RUNNING) {
            if (this.status != Status.WAITING_FOR_SIZE) {
                return false;
            }
        }
        return true;
    }

    public final boolean isComplete() {
        return this.status == Status.COMPLETE;
    }

    public final boolean isResourceSet() {
        return isComplete();
    }

    public final boolean isCancelled() {
        if (this.status != Status.CANCELLED) {
            if (this.status != Status.CLEARED) {
                return false;
            }
        }
        return true;
    }

    public final boolean isFailed() {
        return this.status == Status.FAILED;
    }

    private Drawable getFallbackDrawable() {
        if (this.fallbackDrawable == null && this.fallbackResourceId > 0) {
            this.fallbackDrawable = this.context.getResources().getDrawable(this.fallbackResourceId);
        }
        return this.fallbackDrawable;
    }

    private void setErrorPlaceholder(Exception exception) {
        if (canNotifyStatusChanged()) {
            Drawable fallbackDrawable = this.model == null ? getFallbackDrawable() : null;
            if (fallbackDrawable == null) {
                fallbackDrawable = getErrorDrawable();
            }
            if (fallbackDrawable == null) {
                fallbackDrawable = getPlaceholderDrawable();
            }
            this.target.onLoadFailed(exception, fallbackDrawable);
        }
    }

    private Drawable getErrorDrawable() {
        if (this.errorDrawable == null && this.errorResourceId > 0) {
            this.errorDrawable = this.context.getResources().getDrawable(this.errorResourceId);
        }
        return this.errorDrawable;
    }

    private Drawable getPlaceholderDrawable() {
        if (this.placeholderDrawable == null && this.placeholderResourceId > 0) {
            this.placeholderDrawable = this.context.getResources().getDrawable(this.placeholderResourceId);
        }
        return this.placeholderDrawable;
    }

    public final void onSizeReady(int i, int i2) {
        GenericRequest genericRequest = this;
        if (Log.isLoggable(TAG, 2)) {
            StringBuilder stringBuilder = new StringBuilder("Got onSizeReady in ");
            stringBuilder.append(LogTime.getElapsedMillis(genericRequest.startTime));
            logV(stringBuilder.toString());
        }
        if (genericRequest.status == Status.WAITING_FOR_SIZE) {
            genericRequest.status = Status.RUNNING;
            int round = Math.round(genericRequest.sizeMultiplier * ((float) i));
            int round2 = Math.round(genericRequest.sizeMultiplier * ((float) i2));
            DataFetcher resourceFetcher = genericRequest.loadProvider.getModelLoader().getResourceFetcher(genericRequest.model, round, round2);
            if (resourceFetcher == null) {
                StringBuilder stringBuilder2 = new StringBuilder("Failed to load model: '");
                stringBuilder2.append(genericRequest.model);
                stringBuilder2.append("'");
                onException(new Exception(stringBuilder2.toString()));
                return;
            }
            ResourceTranscoder transcoder = genericRequest.loadProvider.getTranscoder();
            if (Log.isLoggable(TAG, 2)) {
                stringBuilder = new StringBuilder("finished setup for calling load in ");
                stringBuilder.append(LogTime.getElapsedMillis(genericRequest.startTime));
                logV(stringBuilder.toString());
            }
            boolean z = true;
            genericRequest.loadedFromMemoryCache = true;
            genericRequest.loadStatus = genericRequest.engine.load(genericRequest.signature, round, round2, resourceFetcher, genericRequest.loadProvider, genericRequest.transformation, transcoder, genericRequest.priority, genericRequest.isMemoryCacheable, genericRequest.diskCacheStrategy, genericRequest);
            if (genericRequest.resource == null) {
                z = false;
            }
            genericRequest.loadedFromMemoryCache = z;
            if (Log.isLoggable(TAG, 2)) {
                stringBuilder = new StringBuilder("finished onSizeReady in ");
                stringBuilder.append(LogTime.getElapsedMillis(genericRequest.startTime));
                logV(stringBuilder.toString());
            }
        }
    }

    private boolean canSetResource() {
        if (this.requestCoordinator != null) {
            if (!this.requestCoordinator.canSetImage(this)) {
                return false;
            }
        }
        return true;
    }

    private boolean canNotifyStatusChanged() {
        if (this.requestCoordinator != null) {
            if (!this.requestCoordinator.canNotifyStatusChanged(this)) {
                return false;
            }
        }
        return true;
    }

    private boolean isFirstReadyResource() {
        if (this.requestCoordinator != null) {
            if (this.requestCoordinator.isAnyResourceSet()) {
                return false;
            }
        }
        return true;
    }

    private void notifyLoadSuccess() {
        if (this.requestCoordinator != null) {
            this.requestCoordinator.onRequestSuccess(this);
        }
    }

    public final void onResourceReady(Resource<?> resource) {
        if (resource == null) {
            StringBuilder stringBuilder = new StringBuilder("Expected to receive a Resource<R> with an object of ");
            stringBuilder.append(this.transcodeClass);
            stringBuilder.append(" inside, but instead got null.");
            onException(new Exception(stringBuilder.toString()));
            return;
        }
        Object obj = resource.get();
        if (obj != null) {
            if (this.transcodeClass.isAssignableFrom(obj.getClass())) {
                if (canSetResource()) {
                    onResourceReady(resource, obj);
                    return;
                }
                releaseResource(resource);
                this.status = Status.COMPLETE;
                return;
            }
        }
        releaseResource(resource);
        StringBuilder stringBuilder2 = new StringBuilder("Expected to receive an object of ");
        stringBuilder2.append(this.transcodeClass);
        stringBuilder2.append(" but instead got ");
        stringBuilder2.append(obj != null ? obj.getClass() : "");
        stringBuilder2.append("{");
        stringBuilder2.append(obj);
        stringBuilder2.append("} inside Resource{");
        stringBuilder2.append(resource);
        stringBuilder2.append("}.");
        stringBuilder2.append(obj != null ? "" : " To indicate failure return a null Resource object, rather than a Resource object containing null data.");
        onException(new Exception(stringBuilder2.toString()));
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onResourceReady(com.bumptech.glide.load.engine.Resource<?> r8, R r9) {
        /*
        r7 = this;
        r6 = r7.isFirstReadyResource();
        r0 = com.bumptech.glide.request.GenericRequest.Status.COMPLETE;
        r7.status = r0;
        r7.resource = r8;
        r0 = r7.requestListener;
        if (r0 == 0) goto L_0x001e;
    L_0x000e:
        r0 = r7.requestListener;
        r2 = r7.model;
        r3 = r7.target;
        r4 = r7.loadedFromMemoryCache;
        r1 = r9;
        r5 = r6;
        r0 = r0.onResourceReady(r1, r2, r3, r4, r5);
        if (r0 != 0) goto L_0x002b;
    L_0x001e:
        r0 = r7.animationFactory;
        r1 = r7.loadedFromMemoryCache;
        r0 = r0.build(r1, r6);
        r1 = r7.target;
        r1.onResourceReady(r9, r0);
    L_0x002b:
        r7.notifyLoadSuccess();
        r9 = "GenericRequest";
        r0 = 2;
        r9 = android.util.Log.isLoggable(r9, r0);
        if (r9 == 0) goto L_0x0068;
    L_0x0037:
        r9 = new java.lang.StringBuilder;
        r0 = "Resource ready in ";
        r9.<init>(r0);
        r0 = r7.startTime;
        r0 = com.bumptech.glide.util.LogTime.getElapsedMillis(r0);
        r9.append(r0);
        r0 = " size: ";
        r9.append(r0);
        r8 = r8.getSize();
        r0 = (double) r8;
        r2 = 4517110426252607488; // 0x3eb0000000000000 float:0.0 double:9.5367431640625E-7;
        r0 = r0 * r2;
        r9.append(r0);
        r8 = " fromCache: ";
        r9.append(r8);
        r8 = r7.loadedFromMemoryCache;
        r9.append(r8);
        r8 = r9.toString();
        r7.logV(r8);
    L_0x0068:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.GenericRequest.onResourceReady(com.bumptech.glide.load.engine.Resource, java.lang.Object):void");
    }

    public final void onException(Exception exception) {
        this.status = Status.FAILED;
        if (this.requestListener == null || !this.requestListener.onException(exception, this.model, this.target, isFirstReadyResource())) {
            setErrorPlaceholder(exception);
        }
    }

    private void logV(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(str);
        stringBuilder.append(" this: ");
        stringBuilder.append(this.tag);
    }
}
