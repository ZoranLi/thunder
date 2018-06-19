package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.engine.Resource;

public class SimpleResource<T> implements Resource<T> {
    protected final T data;

    public final int getSize() {
        return 1;
    }

    public void recycle() {
    }

    public SimpleResource(T t) {
        if (t == null) {
            throw new NullPointerException("Data must not be null");
        }
        this.data = t;
    }

    public final T get() {
        return this.data;
    }
}
