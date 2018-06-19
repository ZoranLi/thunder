package com.bumptech.glide.load.model;

import com.bumptech.glide.load.data.DataFetcher;

public interface ModelLoader<T, Y> {
    DataFetcher<Y> getResourceFetcher(T t, int i, int i2);
}
