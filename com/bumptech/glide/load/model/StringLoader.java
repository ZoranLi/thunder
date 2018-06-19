package com.bumptech.glide.load.model;

import android.net.Uri;
import android.text.TextUtils;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.File;

public class StringLoader<T> implements ModelLoader<String, T> {
    private final ModelLoader<Uri, T> uriLoader;

    public StringLoader(ModelLoader<Uri, T> modelLoader) {
        this.uriLoader = modelLoader;
    }

    public DataFetcher<T> getResourceFetcher(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.startsWith("/")) {
            str = toFileUri(str);
        } else {
            Uri parse = Uri.parse(str);
            str = parse.getScheme() == null ? toFileUri(str) : parse;
        }
        return this.uriLoader.getResourceFetcher(str, i, i2);
    }

    private static Uri toFileUri(String str) {
        return Uri.fromFile(new File(str));
    }
}
