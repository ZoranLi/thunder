package com.bumptech.glide.load;

import java.io.OutputStream;

public interface Encoder<T> {
    boolean encode(T t, OutputStream outputStream);

    String getId();
}
