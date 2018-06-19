package com.bumptech.glide;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.file_descriptor.FileDescriptorModelLoader;
import com.bumptech.glide.load.model.stream.MediaStoreStreamLoader;
import com.bumptech.glide.load.model.stream.StreamByteArrayLoader;
import com.bumptech.glide.load.model.stream.StreamModelLoader;
import com.bumptech.glide.manager.ConnectivityMonitor.ConnectivityListener;
import com.bumptech.glide.manager.ConnectivityMonitorFactory;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.LifecycleListener;
import com.bumptech.glide.manager.RequestManagerTreeNode;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.signature.ApplicationVersionSignature;
import com.bumptech.glide.signature.MediaStoreSignature;
import com.bumptech.glide.signature.StringSignature;
import com.bumptech.glide.util.Util;
import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.UUID;

public class RequestManager implements LifecycleListener {
    private final Context context;
    private final Glide glide;
    private final Lifecycle lifecycle;
    private DefaultOptions options;
    private final OptionsApplier optionsApplier;
    private final RequestTracker requestTracker;
    private final RequestManagerTreeNode treeNode;

    public interface DefaultOptions {
        <T> void apply(GenericRequestBuilder<T, ?, ?, ?> genericRequestBuilder);
    }

    public final class GenericModelRequest<A, T> {
        private final Class<T> dataClass;
        private final ModelLoader<A, T> modelLoader;

        public final class GenericTypeRequest {
            private final A model;
            private final Class<A> modelClass;
            private final boolean providedModel;

            GenericTypeRequest(A a) {
                this.providedModel = true;
                this.model = a;
                this.modelClass = RequestManager.getSafeClass(a);
            }

            GenericTypeRequest(Class<A> cls) {
                this.providedModel = null;
                this.model = null;
                this.modelClass = cls;
            }

            public final <Z> GenericTranscodeRequest<A, T, Z> as(Class<Z> cls) {
                GenericTranscodeRequest genericTranscodeRequest = (GenericTranscodeRequest) RequestManager.this.optionsApplier.apply(new GenericTranscodeRequest(RequestManager.this.context, RequestManager.this.glide, this.modelClass, GenericModelRequest.this.modelLoader, GenericModelRequest.this.dataClass, cls, RequestManager.this.requestTracker, RequestManager.this.lifecycle, RequestManager.this.optionsApplier));
                if (this.providedModel) {
                    genericTranscodeRequest.load(this.model);
                }
                return genericTranscodeRequest;
            }
        }

        GenericModelRequest(ModelLoader<A, T> modelLoader, Class<T> cls) {
            this.modelLoader = modelLoader;
            this.dataClass = cls;
        }

        public final GenericTypeRequest from(Class<A> cls) {
            return new GenericTypeRequest((Class) cls);
        }

        public final GenericTypeRequest load(A a) {
            return new GenericTypeRequest((Object) a);
        }
    }

    public final class ImageModelRequest<T> {
        private final ModelLoader<T, InputStream> loader;

        ImageModelRequest(ModelLoader<T, InputStream> modelLoader) {
            this.loader = modelLoader;
        }

        public final DrawableTypeRequest<T> from(Class<T> cls) {
            return (DrawableTypeRequest) RequestManager.this.optionsApplier.apply(new DrawableTypeRequest(cls, this.loader, null, RequestManager.this.context, RequestManager.this.glide, RequestManager.this.requestTracker, RequestManager.this.lifecycle, RequestManager.this.optionsApplier));
        }

        public final DrawableTypeRequest<T> load(T t) {
            return (DrawableTypeRequest) from(RequestManager.getSafeClass(t)).load((Object) t);
        }
    }

    class OptionsApplier {
        OptionsApplier() {
        }

        public <A, X extends GenericRequestBuilder<A, ?, ?, ?>> X apply(X x) {
            if (RequestManager.this.options != null) {
                RequestManager.this.options.apply(x);
            }
            return x;
        }
    }

    public final class VideoModelRequest<T> {
        private final ModelLoader<T, ParcelFileDescriptor> loader;

        VideoModelRequest(ModelLoader<T, ParcelFileDescriptor> modelLoader) {
            this.loader = modelLoader;
        }

        public final DrawableTypeRequest<T> load(T t) {
            return (DrawableTypeRequest) ((DrawableTypeRequest) RequestManager.this.optionsApplier.apply(new DrawableTypeRequest(RequestManager.getSafeClass(t), null, this.loader, RequestManager.this.context, RequestManager.this.glide, RequestManager.this.requestTracker, RequestManager.this.lifecycle, RequestManager.this.optionsApplier))).load((Object) t);
        }
    }

    private static class RequestManagerConnectivityListener implements ConnectivityListener {
        private final RequestTracker requestTracker;

        public RequestManagerConnectivityListener(RequestTracker requestTracker) {
            this.requestTracker = requestTracker;
        }

        public void onConnectivityChanged(boolean z) {
            if (z) {
                this.requestTracker.restartRequests();
            }
        }
    }

    public RequestManager(Context context, Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode) {
        this(context, lifecycle, requestManagerTreeNode, new RequestTracker(), new ConnectivityMonitorFactory());
    }

    RequestManager(Context context, final Lifecycle lifecycle, RequestManagerTreeNode requestManagerTreeNode, RequestTracker requestTracker, ConnectivityMonitorFactory connectivityMonitorFactory) {
        this.context = context.getApplicationContext();
        this.lifecycle = lifecycle;
        this.treeNode = requestManagerTreeNode;
        this.requestTracker = requestTracker;
        this.glide = Glide.get(context);
        this.optionsApplier = new OptionsApplier();
        context = connectivityMonitorFactory.build(context, new RequestManagerConnectivityListener(requestTracker));
        if (Util.isOnBackgroundThread() != null) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    lifecycle.addListener(RequestManager.this);
                }
            });
        } else {
            lifecycle.addListener(this);
        }
        lifecycle.addListener(context);
    }

    public void onTrimMemory(int i) {
        this.glide.trimMemory(i);
    }

    public void onLowMemory() {
        this.glide.clearMemory();
    }

    public void setDefaultOptions(DefaultOptions defaultOptions) {
        this.options = defaultOptions;
    }

    public boolean isPaused() {
        Util.assertMainThread();
        return this.requestTracker.isPaused();
    }

    public void pauseRequests() {
        Util.assertMainThread();
        this.requestTracker.pauseRequests();
    }

    public void pauseRequestsRecursive() {
        Util.assertMainThread();
        pauseRequests();
        for (RequestManager pauseRequests : this.treeNode.getDescendants()) {
            pauseRequests.pauseRequests();
        }
    }

    public void resumeRequests() {
        Util.assertMainThread();
        this.requestTracker.resumeRequests();
    }

    public void resumeRequestsRecursive() {
        Util.assertMainThread();
        resumeRequests();
        for (RequestManager resumeRequests : this.treeNode.getDescendants()) {
            resumeRequests.resumeRequests();
        }
    }

    public void onStart() {
        resumeRequests();
    }

    public void onStop() {
        pauseRequests();
    }

    public void onDestroy() {
        this.requestTracker.clearRequests();
    }

    public <A, T> GenericModelRequest<A, T> using(ModelLoader<A, T> modelLoader, Class<T> cls) {
        return new GenericModelRequest(modelLoader, cls);
    }

    public <T> ImageModelRequest<T> using(StreamModelLoader<T> streamModelLoader) {
        return new ImageModelRequest(streamModelLoader);
    }

    public ImageModelRequest<byte[]> using(StreamByteArrayLoader streamByteArrayLoader) {
        return new ImageModelRequest(streamByteArrayLoader);
    }

    public <T> VideoModelRequest<T> using(FileDescriptorModelLoader<T> fileDescriptorModelLoader) {
        return new VideoModelRequest(fileDescriptorModelLoader);
    }

    public DrawableTypeRequest<String> load(String str) {
        return (DrawableTypeRequest) fromString().load((Object) str);
    }

    public DrawableTypeRequest<String> fromString() {
        return loadGeneric(String.class);
    }

    public DrawableTypeRequest<Uri> load(Uri uri) {
        return (DrawableTypeRequest) fromUri().load((Object) uri);
    }

    public DrawableTypeRequest<Uri> fromUri() {
        return loadGeneric(Uri.class);
    }

    @Deprecated
    public DrawableTypeRequest<Uri> loadFromMediaStore(Uri uri, String str, long j, int i) {
        return (DrawableTypeRequest) loadFromMediaStore(uri).signature(new MediaStoreSignature(str, j, i));
    }

    public DrawableTypeRequest<Uri> loadFromMediaStore(Uri uri) {
        return (DrawableTypeRequest) fromMediaStore().load((Object) uri);
    }

    public DrawableTypeRequest<Uri> fromMediaStore() {
        return (DrawableTypeRequest) this.optionsApplier.apply(new DrawableTypeRequest(Uri.class, new MediaStoreStreamLoader(this.context, Glide.buildStreamModelLoader(Uri.class, this.context)), Glide.buildFileDescriptorModelLoader(Uri.class, this.context), this.context, this.glide, this.requestTracker, this.lifecycle, this.optionsApplier));
    }

    public DrawableTypeRequest<File> load(File file) {
        return (DrawableTypeRequest) fromFile().load((Object) file);
    }

    public DrawableTypeRequest<File> fromFile() {
        return loadGeneric(File.class);
    }

    public DrawableTypeRequest<Integer> load(Integer num) {
        return (DrawableTypeRequest) fromResource().load((Object) num);
    }

    public DrawableTypeRequest<Integer> fromResource() {
        return (DrawableTypeRequest) loadGeneric(Integer.class).signature(ApplicationVersionSignature.obtain(this.context));
    }

    @Deprecated
    public DrawableTypeRequest<URL> load(URL url) {
        return (DrawableTypeRequest) fromUrl().load((Object) url);
    }

    @Deprecated
    public DrawableTypeRequest<URL> fromUrl() {
        return loadGeneric(URL.class);
    }

    @Deprecated
    public DrawableTypeRequest<byte[]> load(byte[] bArr, String str) {
        return (DrawableTypeRequest) load(bArr).signature(new StringSignature(str));
    }

    public DrawableTypeRequest<byte[]> load(byte[] bArr) {
        return (DrawableTypeRequest) fromBytes().load((Object) bArr);
    }

    public DrawableTypeRequest<byte[]> fromBytes() {
        return (DrawableTypeRequest) loadGeneric(byte[].class).signature(new StringSignature(UUID.randomUUID().toString())).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true);
    }

    public <T> DrawableTypeRequest<T> load(T t) {
        return (DrawableTypeRequest) loadGeneric(getSafeClass(t)).load((Object) t);
    }

    public <T> DrawableTypeRequest<T> from(Class<T> cls) {
        return loadGeneric(cls);
    }

    private <T> DrawableTypeRequest<T> loadGeneric(Class<T> cls) {
        ModelLoader buildStreamModelLoader = Glide.buildStreamModelLoader((Class) cls, this.context);
        ModelLoader buildFileDescriptorModelLoader = Glide.buildFileDescriptorModelLoader((Class) cls, this.context);
        if (cls != null && buildStreamModelLoader == null && buildFileDescriptorModelLoader == null) {
            StringBuilder stringBuilder = new StringBuilder("Unknown type ");
            stringBuilder.append(cls);
            stringBuilder.append(". You must provide a Model of a type for which there is a registered ModelLoader, if you are using a custom model, you must first call Glide#register with a ModelLoaderFactory for your custom model class");
            throw new IllegalArgumentException(stringBuilder.toString());
        }
        return (DrawableTypeRequest) this.optionsApplier.apply(new DrawableTypeRequest(cls, buildStreamModelLoader, buildFileDescriptorModelLoader, this.context, this.glide, this.requestTracker, this.lifecycle, this.optionsApplier));
    }

    private static <T> Class<T> getSafeClass(T t) {
        return t != null ? t.getClass() : null;
    }
}
