package com.bumptech.glide.load.model.stream;

import android.content.Context;
import android.net.Uri;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.data.MediaStoreThumbFetcher;
import com.bumptech.glide.load.model.ModelLoader;
import java.io.InputStream;

public class MediaStoreStreamLoader implements StreamModelLoader<Uri> {
    private final Context context;
    private final ModelLoader<Uri, InputStream> uriLoader;

    public MediaStoreStreamLoader(Context context, ModelLoader<Uri, InputStream> modelLoader) {
        this.context = context;
        this.uriLoader = modelLoader;
    }

    public DataFetcher<InputStream> getResourceFetcher(Uri uri, int i, int i2) {
        return new MediaStoreThumbFetcher(this.context, uri, this.uriLoader.getResourceFetcher(uri, i, i2), i, i2);
    }
}
