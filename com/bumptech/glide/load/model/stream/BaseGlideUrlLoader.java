package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.text.TextUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.Headers;
import com.bumptech.glide.load.model.ModelCache;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;

public abstract class BaseGlideUrlLoader<T> implements StreamModelLoader<T> {
    private final ModelLoader<GlideUrl, InputStream> concreteLoader;
    private final ModelCache<T, GlideUrl> modelCache;

    protected abstract String getUrl(T t, int i, int i2);

    public BaseGlideUrlLoader(Context context) {
        this(context, null);
    }

    public BaseGlideUrlLoader(Context context, ModelCache<T, GlideUrl> modelCache) {
        this(Glide.buildModelLoader(GlideUrl.class, InputStream.class, context), (ModelCache) modelCache);
    }

    public BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader) {
        this((ModelLoader) modelLoader, null);
    }

    public BaseGlideUrlLoader(ModelLoader<GlideUrl, InputStream> modelLoader, ModelCache<T, GlideUrl> modelCache) {
        this.concreteLoader = modelLoader;
        this.modelCache = modelCache;
    }

    public DataFetcher<InputStream> getResourceFetcher(T t, int i, int i2) {
        Object obj = this.modelCache != null ? (GlideUrl) this.modelCache.get(t, i, i2) : null;
        if (obj == null) {
            String url = getUrl(t, i, i2);
            if (TextUtils.isEmpty(url)) {
                return null;
            }
            GlideUrl glideUrl = new GlideUrl(url, getHeaders(t, i, i2));
            if (this.modelCache != null) {
                this.modelCache.put(t, i, i2, glideUrl);
            }
            obj = glideUrl;
        }
        return this.concreteLoader.getResourceFetcher(obj, i, i2);
    }

    protected Headers getHeaders(T t, int i, int i2) {
        return Headers.DEFAULT;
    }
}
