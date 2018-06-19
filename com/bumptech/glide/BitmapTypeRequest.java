package com.bumptech.glide;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.load.model.ImageVideoModelLoader;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.resource.transcode.BitmapBytesTranscoder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.provider.FixedLoadProvider;
import java.io.InputStream;

public class BitmapTypeRequest<ModelType> extends BitmapRequestBuilder<ModelType, Bitmap> {
    private final ModelLoader<ModelType, ParcelFileDescriptor> fileDescriptorModelLoader;
    private final Glide glide;
    private final OptionsApplier optionsApplier;
    private final ModelLoader<ModelType, InputStream> streamModelLoader;

    private static <A, R> FixedLoadProvider<A, ImageVideoWrapper, Bitmap, R> buildProvider(Glide glide, ModelLoader<A, InputStream> modelLoader, ModelLoader<A, ParcelFileDescriptor> modelLoader2, Class<R> cls, ResourceTranscoder<Bitmap, R> resourceTranscoder) {
        if (modelLoader == null && modelLoader2 == null) {
            return null;
        }
        if (resourceTranscoder == null) {
            resourceTranscoder = glide.buildTranscoder(Bitmap.class, cls);
        }
        return new FixedLoadProvider(new ImageVideoModelLoader(modelLoader, modelLoader2), resourceTranscoder, glide.buildDataProvider(ImageVideoWrapper.class, Bitmap.class));
    }

    BitmapTypeRequest(GenericRequestBuilder<ModelType, ?, ?, ?> genericRequestBuilder, ModelLoader<ModelType, InputStream> modelLoader, ModelLoader<ModelType, ParcelFileDescriptor> modelLoader2, OptionsApplier optionsApplier) {
        super(buildProvider(genericRequestBuilder.glide, modelLoader, modelLoader2, Bitmap.class, null), Bitmap.class, genericRequestBuilder);
        this.streamModelLoader = modelLoader;
        this.fileDescriptorModelLoader = modelLoader2;
        this.glide = genericRequestBuilder.glide;
        this.optionsApplier = optionsApplier;
    }

    public <R> BitmapRequestBuilder<ModelType, R> transcode(ResourceTranscoder<Bitmap, R> resourceTranscoder, Class<R> cls) {
        return (BitmapRequestBuilder) this.optionsApplier.apply(new BitmapRequestBuilder(buildProvider(this.glide, this.streamModelLoader, this.fileDescriptorModelLoader, cls, resourceTranscoder), cls, this));
    }

    public BitmapRequestBuilder<ModelType, byte[]> toBytes() {
        return transcode(new BitmapBytesTranscoder(), byte[].class);
    }

    public BitmapRequestBuilder<ModelType, byte[]> toBytes(CompressFormat compressFormat, int i) {
        return transcode(new BitmapBytesTranscoder(compressFormat, i), byte[].class);
    }
}
