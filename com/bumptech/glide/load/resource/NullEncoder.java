package com.bumptech.glide.load.resource;

import com.bumptech.glide.load.Encoder;
import java.io.OutputStream;

public class NullEncoder<T> implements Encoder<T> {
    private static final NullEncoder<?> NULL_ENCODER = new NullEncoder();

    public boolean encode(T t, OutputStream outputStream) {
        return false;
    }

    public String getId() {
        return "";
    }

    public static <T> Encoder<T> get() {
        return NULL_ENCODER;
    }
}
