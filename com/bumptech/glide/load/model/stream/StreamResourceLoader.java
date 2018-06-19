package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.ResourceLoader;
import java.io.InputStream;

public class StreamResourceLoader extends ResourceLoader<InputStream> implements StreamModelLoader<Integer> {

    public static class Factory implements ModelLoaderFactory<Integer, InputStream> {
        public void teardown() {
        }

        public ModelLoader<Integer, InputStream> build(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new StreamResourceLoader(context, genericLoaderFactory.buildModelLoader(Uri.class, InputStream.class));
        }
    }

    public StreamResourceLoader(Context context) {
        this(context, Glide.buildStreamModelLoader(Uri.class, context));
    }

    public StreamResourceLoader(Context context, ModelLoader<Uri, InputStream> modelLoader) {
        super(context, (ModelLoader) modelLoader);
    }
}
