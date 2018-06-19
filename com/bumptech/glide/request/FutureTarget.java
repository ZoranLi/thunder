package com.bumptech.glide.request;

import com.bumptech.glide.request.target.Target;
import java.util.concurrent.Future;

public interface FutureTarget<R> extends Target<R>, Future<R> {
    void clear();
}
