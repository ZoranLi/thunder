package com.bumptech.glide.integration.volley;

import android.content.Context;
import com.android.volley.l;
import com.android.volley.toolbox.ab;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.model.GenericLoaderFactory;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.ModelLoader;
import com.bumptech.glide.load.model.ModelLoaderFactory;
import com.bumptech.glide.load.model.stream.StreamModelLoader;
import java.io.InputStream;

public class VolleyUrlLoader implements StreamModelLoader<GlideUrl> {
    private final VolleyRequestFactory requestFactory;
    private final l requestQueue;

    public static class Factory implements ModelLoaderFactory<GlideUrl, InputStream> {
        private static l internalQueue;
        private final VolleyRequestFactory requestFactory;
        private l requestQueue;

        public void teardown() {
        }

        private static l getInternalQueue(Context context) {
            if (internalQueue == null) {
                synchronized (Factory.class) {
                    if (internalQueue == null) {
                        internalQueue = ab.a(context);
                    }
                }
            }
            return internalQueue;
        }

        public Factory(Context context) {
            this(getInternalQueue(context));
        }

        public Factory(l lVar) {
            this(lVar, VolleyStreamFetcher.DEFAULT_REQUEST_FACTORY);
        }

        public Factory(l lVar, VolleyRequestFactory volleyRequestFactory) {
            this.requestFactory = volleyRequestFactory;
            this.requestQueue = lVar;
        }

        public ModelLoader<GlideUrl, InputStream> build(Context context, GenericLoaderFactory genericLoaderFactory) {
            return new VolleyUrlLoader(this.requestQueue, this.requestFactory);
        }
    }

    public VolleyUrlLoader(l lVar) {
        this(lVar, VolleyStreamFetcher.DEFAULT_REQUEST_FACTORY);
    }

    public VolleyUrlLoader(l lVar, VolleyRequestFactory volleyRequestFactory) {
        this.requestQueue = lVar;
        this.requestFactory = volleyRequestFactory;
    }

    public DataFetcher<InputStream> getResourceFetcher(GlideUrl glideUrl, int i, int i2) {
        return new VolleyStreamFetcher(this.requestQueue, glideUrl, new VolleyRequestFuture(), this.requestFactory);
    }
}
