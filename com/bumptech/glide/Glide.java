package com.bumptech.glide;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.engine.cache.DiskCache.Factory;
import com.bumptech.glide.load.engine.cache.MemoryCache;
import com.bumptech.glide.load.engine.prefill.BitmapPreFiller;
import com.bumptech.glide.load.engine.prefill.PreFillType.Builder;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.file_descriptor.FileDescriptorFileLoader;
import com.bumptech.glide.load.model.file_descriptor.FileDescriptorResourceLoader;
import com.bumptech.glide.load.model.file_descriptor.FileDescriptorStringLoader;
import com.bumptech.glide.load.model.file_descriptor.FileDescriptorUriLoader;
import com.bumptech.glide.load.model.stream.HttpUrlGlideUrlLoader;
import com.bumptech.glide.load.model.stream.StreamByteArrayLoader;
import com.bumptech.glide.load.model.stream.StreamFileLoader;
import com.bumptech.glide.load.model.stream.StreamResourceLoader;
import com.bumptech.glide.load.model.stream.StreamStringLoader;
import com.bumptech.glide.load.model.stream.StreamUriLoader;
import com.bumptech.glide.load.model.stream.StreamUrlLoader;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.FileDescriptorBitmapDataLoadProvider;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.GlideBitmapDrawable;
import com.bumptech.glide.load.resource.bitmap.ImageVideoDataLoadProvider;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDataLoadProvider;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.file.StreamFileDataLoadProvider;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableLoadProvider;
import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapper;
import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapperTransformation;
import com.bumptech.glide.load.resource.gifbitmap.ImageVideoGifDrawableLoadProvider;
import com.bumptech.glide.load.resource.transcode.GifBitmapWrapperDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.GlideBitmapDrawableTranscoder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.load.resource.transcode.TranscoderRegistry;
import com.bumptech.glide.manager.RequestManagerRetriever;
import com.bumptech.glide.module.GlideModule;
import com.bumptech.glide.module.ManifestParser;
import com.bumptech.glide.provider.DataLoadProvider;
import com.bumptech.glide.provider.DataLoadProviderRegistry;
import com.bumptech.glide.request.FutureTarget;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.ImageViewTargetFactory;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.target.ViewTarget;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.List;

public class Glide {
    private static final String TAG = "Glide";
    private static volatile Glide glide = null;
    private static boolean modulesEnabled = true;
    private final CenterCrop bitmapCenterCrop;
    private final FitCenter bitmapFitCenter;
    private final BitmapPool bitmapPool;
    private final BitmapPreFiller bitmapPreFiller;
    private final DataLoadProviderRegistry dataLoadProviderRegistry;
    private final DecodeFormat decodeFormat;
    private final GifBitmapWrapperTransformation drawableCenterCrop;
    private final GifBitmapWrapperTransformation drawableFitCenter;
    private final Engine engine;
    private final ImageViewTargetFactory imageViewTargetFactory = new ImageViewTargetFactory();
    private final GenericLoaderFactory loaderFactory;
    private final Handler mainHandler;
    private final MemoryCache memoryCache;
    private final TranscoderRegistry transcoderRegistry = new TranscoderRegistry();

    private static class ClearTarget extends ViewTarget<View, Object> {
        public void onLoadCleared(Drawable drawable) {
        }

        public void onLoadFailed(Exception exception, Drawable drawable) {
        }

        public void onLoadStarted(Drawable drawable) {
        }

        public void onResourceReady(Object obj, GlideAnimation<? super Object> glideAnimation) {
        }

        public ClearTarget(View view) {
            super(view);
        }
    }

    public static File getPhotoCacheDir(Context context) {
        return getPhotoCacheDir(context, Factory.DEFAULT_DISK_CACHE_DIR);
    }

    public static File getPhotoCacheDir(Context context, String str) {
        context = context.getCacheDir();
        if (context == null) {
            return null;
        }
        File file = new File(context, str);
        if (file.mkdirs() == null && (file.exists() == null || file.isDirectory() == null)) {
            return null;
        }
        return file;
    }

    public static void setModulesEnabled(boolean z) {
        synchronized (Glide.class) {
            if (glide != null) {
                throw new IllegalArgumentException("Glide singleton already exists.");
            }
            modulesEnabled = z;
        }
    }

    public static Glide get(Context context) {
        if (glide == null) {
            synchronized (Glide.class) {
                if (glide == null) {
                    context = context.getApplicationContext();
                    GlideBuilder glideBuilder = new GlideBuilder(context);
                    List<GlideModule> parseGlideModules = parseGlideModules(context);
                    for (GlideModule applyOptions : parseGlideModules) {
                        applyOptions.applyOptions(context, glideBuilder);
                    }
                    glide = glideBuilder.createGlide();
                    for (GlideModule registerComponents : parseGlideModules) {
                        registerComponents.registerComponents(context, glide);
                    }
                }
            }
        }
        return glide;
    }

    private static List<GlideModule> parseGlideModules(Context context) {
        if (modulesEnabled) {
            return new ManifestParser(context).parse();
        }
        return Collections.emptyList();
    }

    @Deprecated
    public static boolean isSetup() {
        return glide != null;
    }

    @Deprecated
    public static void setup(GlideBuilder glideBuilder) {
        if (isSetup()) {
            throw new IllegalArgumentException("Glide is already setup, check with isSetup() first");
        }
        glide = glideBuilder.createGlide();
    }

    static void tearDown() {
        glide = null;
        modulesEnabled = true;
    }

    Glide(Engine engine, MemoryCache memoryCache, BitmapPool bitmapPool, Context context, DecodeFormat decodeFormat) {
        this.engine = engine;
        this.bitmapPool = bitmapPool;
        this.memoryCache = memoryCache;
        this.decodeFormat = decodeFormat;
        this.loaderFactory = new GenericLoaderFactory(context);
        this.mainHandler = new Handler(Looper.getMainLooper());
        this.bitmapPreFiller = new BitmapPreFiller(memoryCache, bitmapPool, decodeFormat);
        this.dataLoadProviderRegistry = new DataLoadProviderRegistry();
        engine = new StreamBitmapDataLoadProvider(bitmapPool, decodeFormat);
        this.dataLoadProviderRegistry.register(InputStream.class, Bitmap.class, engine);
        memoryCache = new FileDescriptorBitmapDataLoadProvider(bitmapPool, decodeFormat);
        this.dataLoadProviderRegistry.register(ParcelFileDescriptor.class, Bitmap.class, memoryCache);
        decodeFormat = new ImageVideoDataLoadProvider(engine, memoryCache);
        this.dataLoadProviderRegistry.register(ImageVideoWrapper.class, Bitmap.class, decodeFormat);
        engine = new GifDrawableLoadProvider(context, bitmapPool);
        this.dataLoadProviderRegistry.register(InputStream.class, GifDrawable.class, engine);
        this.dataLoadProviderRegistry.register(ImageVideoWrapper.class, GifBitmapWrapper.class, new ImageVideoGifDrawableLoadProvider(decodeFormat, engine, bitmapPool));
        this.dataLoadProviderRegistry.register(InputStream.class, File.class, new StreamFileDataLoadProvider());
        register(File.class, ParcelFileDescriptor.class, new FileDescriptorFileLoader.Factory());
        register(File.class, InputStream.class, new StreamFileLoader.Factory());
        register(Integer.TYPE, ParcelFileDescriptor.class, new FileDescriptorResourceLoader.Factory());
        register(Integer.TYPE, InputStream.class, new StreamResourceLoader.Factory());
        register(Integer.class, ParcelFileDescriptor.class, new FileDescriptorResourceLoader.Factory());
        register(Integer.class, InputStream.class, new StreamResourceLoader.Factory());
        register(String.class, ParcelFileDescriptor.class, new FileDescriptorStringLoader.Factory());
        register(String.class, InputStream.class, new StreamStringLoader.Factory());
        register(Uri.class, ParcelFileDescriptor.class, new FileDescriptorUriLoader.Factory());
        register(Uri.class, InputStream.class, new StreamUriLoader.Factory());
        register(URL.class, InputStream.class, new StreamUrlLoader.Factory());
        register(GlideUrl.class, InputStream.class, new HttpUrlGlideUrlLoader.Factory());
        register(byte[].class, InputStream.class, new StreamByteArrayLoader.Factory());
        this.transcoderRegistry.register(Bitmap.class, GlideBitmapDrawable.class, new GlideBitmapDrawableTranscoder(context.getResources(), bitmapPool));
        this.transcoderRegistry.register(GifBitmapWrapper.class, GlideDrawable.class, new GifBitmapWrapperDrawableTranscoder(new GlideBitmapDrawableTranscoder(context.getResources(), bitmapPool)));
        this.bitmapCenterCrop = new CenterCrop(bitmapPool);
        this.drawableCenterCrop = new GifBitmapWrapperTransformation(bitmapPool, this.bitmapCenterCrop);
        this.bitmapFitCenter = new FitCenter(bitmapPool);
        this.drawableFitCenter = new GifBitmapWrapperTransformation(bitmapPool, this.bitmapFitCenter);
    }

    public BitmapPool getBitmapPool() {
        return this.bitmapPool;
    }

    <Z, R> ResourceTranscoder<Z, R> buildTranscoder(Class<Z> cls, Class<R> cls2) {
        return this.transcoderRegistry.get(cls, cls2);
    }

    <T, Z> DataLoadProvider<T, Z> buildDataProvider(Class<T> cls, Class<Z> cls2) {
        return this.dataLoadProviderRegistry.get(cls, cls2);
    }

    <R> Target<R> buildImageViewTarget(ImageView imageView, Class<R> cls) {
        return this.imageViewTargetFactory.buildTarget(imageView, cls);
    }

    Engine getEngine() {
        return this.engine;
    }

    CenterCrop getBitmapCenterCrop() {
        return this.bitmapCenterCrop;
    }

    FitCenter getBitmapFitCenter() {
        return this.bitmapFitCenter;
    }

    GifBitmapWrapperTransformation getDrawableCenterCrop() {
        return this.drawableCenterCrop;
    }

    GifBitmapWrapperTransformation getDrawableFitCenter() {
        return this.drawableFitCenter;
    }

    Handler getMainHandler() {
        return this.mainHandler;
    }

    DecodeFormat getDecodeFormat() {
        return this.decodeFormat;
    }

    private GenericLoaderFactory getLoaderFactory() {
        return this.loaderFactory;
    }

    public void preFillBitmapPool(Builder... builderArr) {
        this.bitmapPreFiller.preFill(builderArr);
    }

    public void clearMemory() {
        Util.assertMainThread();
        this.memoryCache.clearMemory();
        this.bitmapPool.clearMemory();
    }

    public void trimMemory(int i) {
        Util.assertMainThread();
        this.memoryCache.trimMemory(i);
        this.bitmapPool.trimMemory(i);
    }

    public void clearDiskCache() {
        Util.assertBackgroundThread();
        getEngine().clearDiskCache();
    }

    public void setMemoryCategory(MemoryCategory memoryCategory) {
        Util.assertMainThread();
        this.memoryCache.setSizeMultiplier(memoryCategory.getMultiplier());
        this.bitmapPool.setSizeMultiplier(memoryCategory.getMultiplier());
    }

    public static void clear(Target<?> target) {
        Util.assertMainThread();
        Request request = target.getRequest();
        if (request != null) {
            request.clear();
            target.setRequest(null);
        }
    }

    public static void clear(FutureTarget<?> futureTarget) {
        futureTarget.clear();
    }

    public static void clear(View view) {
        clear(new ClearTarget(view));
    }

    public <T, Y> void register(Class<T> cls, Class<Y> cls2, ModelLoaderFactory<T, Y> modelLoaderFactory) {
        cls = this.loaderFactory.register(cls, cls2, modelLoaderFactory);
        if (cls != null) {
            cls.teardown();
        }
    }

    @Deprecated
    public <T, Y> void unregister(Class<T> cls, Class<Y> cls2) {
        cls = this.loaderFactory.unregister(cls, cls2);
        if (cls != null) {
            cls.teardown();
        }
    }

    public static <T, Y> ModelLoader<T, Y> buildModelLoader(Class<T> cls, Class<Y> cls2, Context context) {
        return cls == null ? null : get(context).getLoaderFactory().buildModelLoader(cls, cls2);
    }

    public static <T, Y> ModelLoader<T, Y> buildModelLoader(T t, Class<Y> cls, Context context) {
        return buildModelLoader(t != null ? t.getClass() : null, (Class) cls, context);
    }

    public static <T> ModelLoader<T, InputStream> buildStreamModelLoader(Class<T> cls, Context context) {
        return buildModelLoader((Class) cls, InputStream.class, context);
    }

    public static <T> ModelLoader<T, InputStream> buildStreamModelLoader(T t, Context context) {
        return buildModelLoader((Object) t, InputStream.class, context);
    }

    public static <T> ModelLoader<T, ParcelFileDescriptor> buildFileDescriptorModelLoader(Class<T> cls, Context context) {
        return buildModelLoader((Class) cls, ParcelFileDescriptor.class, context);
    }

    public static <T> ModelLoader<T, ParcelFileDescriptor> buildFileDescriptorModelLoader(T t, Context context) {
        return buildModelLoader((Object) t, ParcelFileDescriptor.class, context);
    }

    public static RequestManager with(Context context) {
        return RequestManagerRetriever.get().get(context);
    }

    public static RequestManager with(Activity activity) {
        return RequestManagerRetriever.get().get(activity);
    }

    public static RequestManager with(FragmentActivity fragmentActivity) {
        return RequestManagerRetriever.get().get(fragmentActivity);
    }

    @TargetApi(11)
    public static RequestManager with(Fragment fragment) {
        return RequestManagerRetriever.get().get(fragment);
    }

    public static RequestManager with(android.support.v4.app.Fragment fragment) {
        return RequestManagerRetriever.get().get(fragment);
    }
}
