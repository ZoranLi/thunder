package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.StringLoader;
import java.io.InputStream;

public class StreamStringLoader extends StringLoader<InputStream> implements StreamModelLoader<String> {

    public static class Factory implements ModelLoaderFactory<String, InputStream> {
        public void teardown() {
        }

        public ModelLoader<String, InputStream> build(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new StreamStringLoader(genericLoaderFactory.buildModelLoader(Uri.class, InputStream.class));
        }
    }

    public StreamStringLoader(Context context) {
        this(Glide.buildStreamModelLoader(Uri.class, context));
    }

    public StreamStringLoader(ModelLoader<Uri, InputStream> modelLoader) {
        super(modelLoader);
    }
}
