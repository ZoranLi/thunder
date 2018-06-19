package com.bumptech.glide.load.model;

import android.content.Context;
import android.net.Uri;
import anet.channel.util.HttpConstant;
import com.bumptech.glide.load.data.DataFetcher;

public abstract class UriLoader<T> implements ModelLoader<Uri, T> {
    private final Context context;
    private final ModelLoader<GlideUrl, T> urlLoader;

    public abstract DataFetcher<T> getAssetPathFetcher(Context context, String str);

    public abstract DataFetcher<T> getLocalUriFetcher(Context context, Uri uri);

    public UriLoader(Context context, ModelLoader<GlideUrl, T> modelLoader) {
        this.context = context;
        this.urlLoader = modelLoader;
    }

    public final DataFetcher<T> getResourceFetcher(Uri uri, int i, int i2) {
        String scheme = uri.getScheme();
        if (!isLocalUri(scheme)) {
            return (this.urlLoader == null || !(HttpConstant.HTTP.equals(scheme) || "https".equals(scheme))) ? null : this.urlLoader.getResourceFetcher(new GlideUrl(uri.toString()), i, i2);
        } else {
            if (AssetUriParser.isAssetUri(uri) == 0) {
                return getLocalUriFetcher(this.context, uri);
            }
            return getAssetPathFetcher(this.context, AssetUriParser.toAssetPath(uri));
        }
    }

    private static boolean isLocalUri(String str) {
        if (!("file".equals(str) || "content".equals(str))) {
            if ("android.resource".equals(str) == null) {
                return null;
            }
        }
        return true;
    }
}
