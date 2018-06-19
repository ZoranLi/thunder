package com.bumptech.glide.load.model;

import android.net.Uri;
import com.bumptech.glide.load.data.DataFetcher;
import java.io.File;

public class FileLoader<T> implements ModelLoader<File, T> {
    private final ModelLoader<Uri, T> uriLoader;

    public FileLoader(ModelLoader<Uri, T> modelLoader) {
        this.uriLoader = modelLoader;
    }

    public DataFetcher<T> getResourceFetcher(File file, int i, int i2) {
        return this.uriLoader.getResourceFetcher(Uri.fromFile(file), i, i2);
    }
}
