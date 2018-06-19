package com.bumptech.glide.load.model;

import android.content.Context;

public interface ModelLoaderFactory<T, Y> {
    ModelLoader<T, Y> build(Context context, GenericLoaderFactory genericLoaderFactory);

    void teardown();
}
