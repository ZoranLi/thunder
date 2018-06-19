package com.bumptech.glide.load;

import com.bumptech.glide.load.engine.Resource;
import java.io.IOException;

public interface ResourceDecoder<T, Z> {
    Resource<Z> decode(T t, int i, int i2) throws IOException;

    String getId();
}
