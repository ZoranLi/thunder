package com.bumptech.glide.load.model.file_descriptor;

import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.FileDescriptorAssetPathFetcher;
import com.bumptech.glide.load.data.FileDescriptorLocalUriFetcher;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.UriLoader;

public class FileDescriptorUriLoader extends UriLoader<ParcelFileDescriptor> implements FileDescriptorModelLoader<Uri> {

    public static class Factory implements ModelLoaderFactory<Uri, ParcelFileDescriptor> {
        public void teardown() {
        }

        public ModelLoader<Uri, ParcelFileDescriptor> build(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new FileDescriptorUriLoader(context, genericLoaderFactory.buildModelLoader(GlideUrl.class, ParcelFileDescriptor.class));
        }
    }

    public FileDescriptorUriLoader(Context context) {
        this(context, Glide.buildFileDescriptorModelLoader(GlideUrl.class, context));
    }

    public FileDescriptorUriLoader(Context context, ModelLoader<GlideUrl, ParcelFileDescriptor> modelLoader) {
        super(context, modelLoader);
    }

    protected DataFetcher<ParcelFileDescriptor> getLocalUriFetcher(Context context, Uri uri) {
        return new FileDescriptorLocalUriFetcher(context, uri);
    }

    protected DataFetcher<ParcelFileDescriptor> getAssetPathFetcher(Context context, String str) {
        return new FileDescriptorAssetPathFetcher(context.getApplicationContext().getAssets(), str);
    }
}
