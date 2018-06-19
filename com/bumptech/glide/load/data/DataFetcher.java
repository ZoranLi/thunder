package com.bumptech.glide.load.data;

import com.bumptech.glide.Priority;

public interface DataFetcher<T> {
    void cancel();

    void cleanup();

    String getId();

    T loadData(Priority priority) throws Exception;
}
