package com.bumptech.glide;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.MultiTransformation;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.provider.ChildLoadProvider;
import com.bumptech.glide.provider.LoadProvider;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.GenericRequest;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.RequestCoordinator;
import com.bumptech.glide.request.RequestFutureTarget;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.ThumbnailRequestCoordinator;
import com.bumptech.glide.request.animation.GlideAnimationFactory;
import com.bumptech.glide.request.animation.NoAnimation;
import com.bumptech.glide.request.animation.ViewAnimationFactory;
import com.bumptech.glide.request.animation.ViewPropertyAnimation.Animator;
import com.bumptech.glide.request.animation.ViewPropertyAnimationFactory;
import com.bumptech.glide.request.target.PreloadTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.signature.EmptySignature;
import com.bumptech.glide.util.Util;
import java.io.File;

public class GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> implements Cloneable {
    private GlideAnimationFactory<TranscodeType> animationFactory;
    protected final Context context;
    private DiskCacheStrategy diskCacheStrategy;
    private int errorId;
    private Drawable errorPlaceholder;
    private Drawable fallbackDrawable;
    private int fallbackResource;
    protected final Glide glide;
    private boolean isCacheable;
    private boolean isModelSet;
    private boolean isThumbnailBuilt;
    private boolean isTransformationSet;
    protected final Lifecycle lifecycle;
    private ChildLoadProvider<ModelType, DataType, ResourceType, TranscodeType> loadProvider;
    private ModelType model;
    protected final Class<ModelType> modelClass;
    private int overrideHeight;
    private int overrideWidth;
    private Drawable placeholderDrawable;
    private int placeholderId;
    private Priority priority;
    private RequestListener<? super ModelType, TranscodeType> requestListener;
    protected final RequestTracker requestTracker;
    private Key signature;
    private Float sizeMultiplier;
    private Float thumbSizeMultiplier;
    private GenericRequestBuilder<?, ?, ?, TranscodeType> thumbnailRequestBuilder;
    protected final Class<TranscodeType> transcodeClass;
    private Transformation<ResourceType> transformation;

    /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$android$widget$ImageView$ScaleType = new int[ScaleType.values().length];

        static {
            /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:14)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
            /*
            r0 = android.widget.ImageView.ScaleType.values();
            r0 = r0.length;
            r0 = new int[r0];
            $SwitchMap$android$widget$ImageView$ScaleType = r0;
            r0 = $SwitchMap$android$widget$ImageView$ScaleType;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = android.widget.ImageView.ScaleType.CENTER_CROP;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0014 }
            r2 = 1;	 Catch:{ NoSuchFieldError -> 0x0014 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0014 }
        L_0x0014:
            r0 = $SwitchMap$android$widget$ImageView$ScaleType;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = android.widget.ImageView.ScaleType.FIT_CENTER;	 Catch:{ NoSuchFieldError -> 0x001f }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x001f }
            r2 = 2;	 Catch:{ NoSuchFieldError -> 0x001f }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x001f }
        L_0x001f:
            r0 = $SwitchMap$android$widget$ImageView$ScaleType;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = android.widget.ImageView.ScaleType.FIT_START;	 Catch:{ NoSuchFieldError -> 0x002a }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x002a }
            r2 = 3;	 Catch:{ NoSuchFieldError -> 0x002a }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x002a }
        L_0x002a:
            r0 = $SwitchMap$android$widget$ImageView$ScaleType;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = android.widget.ImageView.ScaleType.FIT_END;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r1 = r1.ordinal();	 Catch:{ NoSuchFieldError -> 0x0035 }
            r2 = 4;	 Catch:{ NoSuchFieldError -> 0x0035 }
            r0[r1] = r2;	 Catch:{ NoSuchFieldError -> 0x0035 }
        L_0x0035:
            return;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.GenericRequestBuilder.2.<clinit>():void");
        }
    }

    void applyCenterCrop() {
    }

    void applyFitCenter() {
    }

    GenericRequestBuilder(LoadProvider<ModelType, DataType, ResourceType, TranscodeType> loadProvider, Class<TranscodeType> cls, GenericRequestBuilder<ModelType, ?, ?, ?> genericRequestBuilder) {
        this(genericRequestBuilder.context, genericRequestBuilder.modelClass, loadProvider, cls, genericRequestBuilder.glide, genericRequestBuilder.requestTracker, genericRequestBuilder.lifecycle);
        this.model = genericRequestBuilder.model;
        this.isModelSet = genericRequestBuilder.isModelSet;
        this.signature = genericRequestBuilder.signature;
        this.diskCacheStrategy = genericRequestBuilder.diskCacheStrategy;
        this.isCacheable = genericRequestBuilder.isCacheable;
    }

    GenericRequestBuilder(Context context, Class<ModelType> cls, LoadProvider<ModelType, DataType, ResourceType, TranscodeType> loadProvider, Class<TranscodeType> cls2, Glide glide, RequestTracker requestTracker, Lifecycle lifecycle) {
        this.signature = EmptySignature.obtain();
        this.sizeMultiplier = Float.valueOf(1.0f);
        ChildLoadProvider childLoadProvider = null;
        this.priority = null;
        this.isCacheable = true;
        this.animationFactory = NoAnimation.getFactory();
        this.overrideHeight = -1;
        this.overrideWidth = -1;
        this.diskCacheStrategy = DiskCacheStrategy.RESULT;
        this.transformation = UnitTransformation.get();
        this.context = context;
        this.modelClass = cls;
        this.transcodeClass = cls2;
        this.glide = glide;
        this.requestTracker = requestTracker;
        this.lifecycle = lifecycle;
        if (loadProvider != null) {
            childLoadProvider = new ChildLoadProvider(loadProvider);
        }
        this.loadProvider = childLoadProvider;
        if (context == null) {
            throw new NullPointerException("Context can't be null");
        } else if (cls != null && loadProvider == null) {
            throw new NullPointerException("LoadProvider must not be null");
        }
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> thumbnail(GenericRequestBuilder<?, ?, ?, TranscodeType> genericRequestBuilder) {
        if (equals(genericRequestBuilder)) {
            throw new IllegalArgumentException("You cannot set a request as a thumbnail for itself. Consider using clone() on the request you are passing to thumbnail()");
        }
        this.thumbnailRequestBuilder = genericRequestBuilder;
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> thumbnail(float f) {
        if (f >= 0.0f) {
            if (f <= 1.0f) {
                this.thumbSizeMultiplier = Float.valueOf(f);
                return this;
            }
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> sizeMultiplier(float f) {
        if (f >= 0.0f) {
            if (f <= 1.0f) {
                this.sizeMultiplier = Float.valueOf(f);
                return this;
            }
        }
        throw new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> decoder(ResourceDecoder<DataType, ResourceType> resourceDecoder) {
        if (this.loadProvider != null) {
            this.loadProvider.setSourceDecoder(resourceDecoder);
        }
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> cacheDecoder(ResourceDecoder<File, ResourceType> resourceDecoder) {
        if (this.loadProvider != null) {
            this.loadProvider.setCacheDecoder(resourceDecoder);
        }
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> sourceEncoder(Encoder<DataType> encoder) {
        if (this.loadProvider != null) {
            this.loadProvider.setSourceEncoder(encoder);
        }
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        this.diskCacheStrategy = diskCacheStrategy;
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> encoder(ResourceEncoder<ResourceType> resourceEncoder) {
        if (this.loadProvider != null) {
            this.loadProvider.setEncoder(resourceEncoder);
        }
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> priority(Priority priority) {
        this.priority = priority;
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> transform(Transformation<ResourceType>... transformationArr) {
        this.isTransformationSet = true;
        if (transformationArr.length == 1) {
            this.transformation = transformationArr[0];
        } else {
            this.transformation = new MultiTransformation((Transformation[]) transformationArr);
        }
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> dontTransform() {
        return transform(UnitTransformation.get());
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> transcoder(ResourceTranscoder<ResourceType, TranscodeType> resourceTranscoder) {
        if (this.loadProvider != null) {
            this.loadProvider.setTranscoder(resourceTranscoder);
        }
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> dontAnimate() {
        return animate(NoAnimation.getFactory());
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> animate(int i) {
        return animate(new ViewAnimationFactory(this.context, i));
    }

    @Deprecated
    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> animate(Animation animation) {
        return animate(new ViewAnimationFactory(animation));
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> animate(Animator animator) {
        return animate(new ViewPropertyAnimationFactory(animator));
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> animate(GlideAnimationFactory<TranscodeType> glideAnimationFactory) {
        if (glideAnimationFactory == null) {
            throw new NullPointerException("Animation factory must not be null!");
        }
        this.animationFactory = glideAnimationFactory;
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> placeholder(int i) {
        this.placeholderId = i;
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> placeholder(Drawable drawable) {
        this.placeholderDrawable = drawable;
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> fallback(Drawable drawable) {
        this.fallbackDrawable = drawable;
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> fallback(int i) {
        this.fallbackResource = i;
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> error(int i) {
        this.errorId = i;
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> error(Drawable drawable) {
        this.errorPlaceholder = drawable;
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> listener(RequestListener<? super ModelType, TranscodeType> requestListener) {
        this.requestListener = requestListener;
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> skipMemoryCache(boolean z) {
        this.isCacheable = z ^ 1;
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> override(int i, int i2) {
        if (Util.isValidDimensions(i, i2)) {
            this.overrideWidth = i;
            this.overrideHeight = i2;
            return this;
        }
        throw new IllegalArgumentException("Width and height must be Target#SIZE_ORIGINAL or > 0");
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> signature(Key key) {
        if (key == null) {
            throw new NullPointerException("Signature must not be null");
        }
        this.signature = key;
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> load(ModelType modelType) {
        this.model = modelType;
        this.isModelSet = true;
        return this;
    }

    public GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> clone() {
        try {
            GenericRequestBuilder<ModelType, DataType, ResourceType, TranscodeType> genericRequestBuilder = (GenericRequestBuilder) super.clone();
            genericRequestBuilder.loadProvider = this.loadProvider != null ? this.loadProvider.clone() : null;
            return genericRequestBuilder;
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    public <Y extends Target<TranscodeType>> Y into(Y y) {
        Util.assertMainThread();
        if (y == null) {
            throw new IllegalArgumentException("You must pass in a non null Target");
        } else if (this.isModelSet) {
            Request request = y.getRequest();
            if (request != null) {
                request.clear();
                this.requestTracker.removeRequest(request);
                request.recycle();
            }
            request = buildRequest(y);
            y.setRequest(request);
            this.lifecycle.addListener(y);
            this.requestTracker.runRequest(request);
            return y;
        } else {
            throw new IllegalArgumentException("You must first set a model (try #load())");
        }
    }

    public Target<TranscodeType> into(ImageView imageView) {
        Util.assertMainThread();
        if (imageView == null) {
            throw new IllegalArgumentException("You must pass in a non null View");
        }
        if (!(this.isTransformationSet || imageView.getScaleType() == null)) {
            switch (AnonymousClass2.$SwitchMap$android$widget$ImageView$ScaleType[imageView.getScaleType().ordinal()]) {
                case 1:
                    applyCenterCrop();
                    break;
                case 2:
                case 3:
                case 4:
                    applyFitCenter();
                    break;
                default:
                    break;
            }
        }
        return into(this.glide.buildImageViewTarget(imageView, this.transcodeClass));
    }

    public FutureTarget<TranscodeType> into(int i, int i2) {
        final FutureTarget requestFutureTarget = new RequestFutureTarget(this.glide.getMainHandler(), i, i2);
        this.glide.getMainHandler().post(new Runnable() {
            public void run() {
                if (!requestFutureTarget.isCancelled()) {
                    GenericRequestBuilder.this.into(requestFutureTarget);
                }
            }
        });
        return requestFutureTarget;
    }

    public Target<TranscodeType> preload(int i, int i2) {
        return into(PreloadTarget.obtain(i, i2));
    }

    public Target<TranscodeType> preload() {
        return preload(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    private Priority getThumbnailPriority() {
        if (this.priority == Priority.LOW) {
            return Priority.NORMAL;
        }
        if (this.priority == Priority.NORMAL) {
            return Priority.HIGH;
        }
        return Priority.IMMEDIATE;
    }

    private Request buildRequest(Target<TranscodeType> target) {
        if (this.priority == null) {
            this.priority = Priority.NORMAL;
        }
        return buildRequestRecursive(target, null);
    }

    private Request buildRequestRecursive(Target<TranscodeType> target, ThumbnailRequestCoordinator thumbnailRequestCoordinator) {
        Request thumbnailRequestCoordinator2;
        if (this.thumbnailRequestBuilder != null) {
            if (this.isThumbnailBuilt) {
                throw new IllegalStateException("You cannot use a request as both the main request and a thumbnail, consider using clone() on the request(s) passed to thumbnail()");
            }
            if (this.thumbnailRequestBuilder.animationFactory.equals(NoAnimation.getFactory())) {
                this.thumbnailRequestBuilder.animationFactory = this.animationFactory;
            }
            if (this.thumbnailRequestBuilder.priority == null) {
                this.thumbnailRequestBuilder.priority = getThumbnailPriority();
            }
            if (Util.isValidDimensions(this.overrideWidth, this.overrideHeight) && !Util.isValidDimensions(this.thumbnailRequestBuilder.overrideWidth, this.thumbnailRequestBuilder.overrideHeight)) {
                this.thumbnailRequestBuilder.override(this.overrideWidth, this.overrideHeight);
            }
            thumbnailRequestCoordinator2 = new ThumbnailRequestCoordinator(thumbnailRequestCoordinator);
            thumbnailRequestCoordinator = obtainRequest(target, this.sizeMultiplier.floatValue(), this.priority, thumbnailRequestCoordinator2);
            this.isThumbnailBuilt = true;
            target = this.thumbnailRequestBuilder.buildRequestRecursive(target, thumbnailRequestCoordinator2);
            this.isThumbnailBuilt = false;
            thumbnailRequestCoordinator2.setRequests(thumbnailRequestCoordinator, target);
            return thumbnailRequestCoordinator2;
        } else if (this.thumbSizeMultiplier == null) {
            return obtainRequest(target, this.sizeMultiplier.floatValue(), this.priority, thumbnailRequestCoordinator);
        } else {
            thumbnailRequestCoordinator2 = new ThumbnailRequestCoordinator(thumbnailRequestCoordinator);
            thumbnailRequestCoordinator2.setRequests(obtainRequest(target, this.sizeMultiplier.floatValue(), this.priority, thumbnailRequestCoordinator2), obtainRequest(target, this.thumbSizeMultiplier.floatValue(), getThumbnailPriority(), thumbnailRequestCoordinator2));
            return thumbnailRequestCoordinator2;
        }
    }

    private Request obtainRequest(Target<TranscodeType> target, float f, Priority priority, RequestCoordinator requestCoordinator) {
        LoadProvider loadProvider = this.loadProvider;
        Object obj = this.model;
        Key key = this.signature;
        Context context = this.context;
        Drawable drawable = this.placeholderDrawable;
        int i = this.placeholderId;
        Drawable drawable2 = this.errorPlaceholder;
        int i2 = this.errorId;
        Drawable drawable3 = this.fallbackDrawable;
        int i3 = this.fallbackResource;
        RequestListener requestListener = this.requestListener;
        Engine engine = this.glide.getEngine();
        Transformation transformation = this.transformation;
        Class cls = this.transcodeClass;
        boolean z = this.isCacheable;
        GlideAnimationFactory glideAnimationFactory = this.animationFactory;
        Transformation transformation2 = transformation;
        return GenericRequest.obtain(loadProvider, obj, key, context, priority, target, f, drawable, i, drawable2, i2, drawable3, i3, requestListener, requestCoordinator, engine, transformation2, cls, z, glideAnimationFactory, this.overrideWidth, this.overrideHeight, this.diskCacheStrategy);
    }
}
