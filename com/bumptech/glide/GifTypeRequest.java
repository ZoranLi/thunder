package com.bumptech.glide;

import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.transcode.GifDrawableBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.provider.FixedLoadProvider;
import java.io.InputStream;

public class GifTypeRequest<ModelType> extends GifRequestBuilder<ModelType> {
    private final OptionsApplier optionsApplier;
    private final ModelLoader<ModelType, InputStream> streamModelLoader;

    private static <A, R> FixedLoadProvider<A, InputStream, GifDrawable, R> buildProvider(Glide glide, ModelLoader<A, InputStream> modelLoader, Class<R> cls, ResourceTranscoder<GifDrawable, R> resourceTranscoder) {
        if (modelLoader == null) {
            return null;
        }
        if (resourceTranscoder == null) {
            resourceTranscoder = glide.buildTranscoder(GifDrawable.class, cls);
        }
        return new FixedLoadProvider(modelLoader, resourceTranscoder, glide.buildDataProvider(InputStream.class, GifDrawable.class));
    }

    GifTypeRequest(GenericRequestBuilder<ModelType, ?, ?, ?> genericRequestBuilder, ModelLoader<ModelType, InputStream> modelLoader, OptionsApplier optionsApplier) {
        super(buildProvider(genericRequestBuilder.glide, modelLoader, GifDrawable.class, null), GifDrawable.class, genericRequestBuilder);
        this.streamModelLoader = modelLoader;
        this.optionsApplier = optionsApplier;
        crossFade();
    }

    public <R> GenericRequestBuilder<ModelType, InputStream, GifDrawable, R> transcode(ResourceTranscoder<GifDrawable, R> resourceTranscoder, Class<R> cls) {
        return this.optionsApplier.apply(new GenericRequestBuilder(buildProvider(this.glide, this.streamModelLoader, cls, resourceTranscoder), cls, this));
    }

    public GenericRequestBuilder<ModelType, InputStream, GifDrawable, byte[]> toBytes() {
        return transcode(new GifDrawableBytesTranscoder(), byte[].class);
    }
}
