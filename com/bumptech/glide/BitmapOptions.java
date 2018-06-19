package com.bumptech.glide;

interface BitmapOptions {
    GenericRequestBuilder<?, ?, ?, ?> centerCrop();

    GenericRequestBuilder<?, ?, ?, ?> fitCenter();
}
