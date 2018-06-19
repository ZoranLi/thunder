package com.bumptech.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.load.resource.gif.GifDrawableTransformation;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.provider.LoadProvider;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.DrawableCrossFadeFactory;
import com.bumptech.glide.request.animation.GlideAnimationFactory;
import com.bumptech.glide.request.animation.ViewPropertyAnimation.Animator;
import java.io.File;
import java.io.InputStream;

public class GifRequestBuilder<ModelType> extends GenericRequestBuilder<ModelType, InputStream, GifDrawable, GifDrawable> implements BitmapOptions, DrawableOptions {
    GifRequestBuilder(LoadProvider<ModelType, InputStream, GifDrawable, GifDrawable> loadProvider, Class<GifDrawable> cls, GenericRequestBuilder<ModelType, ?, ?, ?> genericRequestBuilder) {
        super(loadProvider, cls, genericRequestBuilder);
    }

    public GifRequestBuilder<ModelType> thumbnail(GenericRequestBuilder<?, ?, ?, GifDrawable> genericRequestBuilder) {
        super.thumbnail((GenericRequestBuilder) genericRequestBuilder);
        return this;
    }

    public GifRequestBuilder<ModelType> thumbnail(GifRequestBuilder<?> gifRequestBuilder) {
        super.thumbnail((GenericRequestBuilder) gifRequestBuilder);
        return this;
    }

    public GifRequestBuilder<ModelType> thumbnail(float f) {
        super.thumbnail(f);
        return this;
    }

    public GifRequestBuilder<ModelType> sizeMultiplier(float f) {
        super.sizeMultiplier(f);
        return this;
    }

    public GifRequestBuilder<ModelType> decoder(ResourceDecoder<InputStream, GifDrawable> resourceDecoder) {
        super.decoder(resourceDecoder);
        return this;
    }

    public GifRequestBuilder<ModelType> cacheDecoder(ResourceDecoder<File, GifDrawable> resourceDecoder) {
        super.cacheDecoder(resourceDecoder);
        return this;
    }

    public GifRequestBuilder<ModelType> encoder(ResourceEncoder<GifDrawable> resourceEncoder) {
        super.encoder(resourceEncoder);
        return this;
    }

    public GifRequestBuilder<ModelType> priority(Priority priority) {
        super.priority(priority);
        return this;
    }

    public GifRequestBuilder<ModelType> centerCrop() {
        return transformFrame(this.glide.getBitmapCenterCrop());
    }

    public GifRequestBuilder<ModelType> fitCenter() {
        return transformFrame(this.glide.getBitmapFitCenter());
    }

    public GifRequestBuilder<ModelType> transformFrame(BitmapTransformation... bitmapTransformationArr) {
        return transform(toGifTransformations(bitmapTransformationArr));
    }

    public GifRequestBuilder<ModelType> transformFrame(Transformation<Bitmap>... transformationArr) {
        return transform(toGifTransformations(transformationArr));
    }

    private GifDrawableTransformation[] toGifTransformations(Transformation<Bitmap>[] transformationArr) {
        GifDrawableTransformation[] gifDrawableTransformationArr = new GifDrawableTransformation[transformationArr.length];
        for (int i = 0; i < transformationArr.length; i++) {
            gifDrawableTransformationArr[i] = new GifDrawableTransformation(transformationArr[i], this.glide.getBitmapPool());
        }
        return gifDrawableTransformationArr;
    }

    public GifRequestBuilder<ModelType> transform(Transformation<GifDrawable>... transformationArr) {
        super.transform(transformationArr);
        return this;
    }

    public GifRequestBuilder<ModelType> transcoder(ResourceTranscoder<GifDrawable, GifDrawable> resourceTranscoder) {
        super.transcoder(resourceTranscoder);
        return this;
    }

    public GifRequestBuilder<ModelType> crossFade() {
        super.animate(new DrawableCrossFadeFactory());
        return this;
    }

    public GifRequestBuilder<ModelType> crossFade(int i) {
        super.animate(new DrawableCrossFadeFactory(i));
        return this;
    }

    @Deprecated
    public GifRequestBuilder<ModelType> crossFade(Animation animation, int i) {
        super.animate(new DrawableCrossFadeFactory(animation, i));
        return this;
    }

    public GifRequestBuilder<ModelType> crossFade(int i, int i2) {
        super.animate(new DrawableCrossFadeFactory(this.context, i, i2));
        return this;
    }

    public GifRequestBuilder<ModelType> dontAnimate() {
        super.dontAnimate();
        return this;
    }

    public GifRequestBuilder<ModelType> animate(int i) {
        super.animate(i);
        return this;
    }

    @Deprecated
    public GifRequestBuilder<ModelType> animate(Animation animation) {
        super.animate(animation);
        return this;
    }

    public GifRequestBuilder<ModelType> animate(Animator animator) {
        super.animate(animator);
        return this;
    }

    public GifRequestBuilder<ModelType> animate(GlideAnimationFactory<GifDrawable> glideAnimationFactory) {
        super.animate((GlideAnimationFactory) glideAnimationFactory);
        return this;
    }

    public GifRequestBuilder<ModelType> placeholder(int i) {
        super.placeholder(i);
        return this;
    }

    public GifRequestBuilder<ModelType> placeholder(Drawable drawable) {
        super.placeholder(drawable);
        return this;
    }

    public GifRequestBuilder<ModelType> fallback(Drawable drawable) {
        super.fallback(drawable);
        return this;
    }

    public GifRequestBuilder<ModelType> fallback(int i) {
        super.fallback(i);
        return this;
    }

    public GifRequestBuilder<ModelType> error(int i) {
        super.error(i);
        return this;
    }

    public GifRequestBuilder<ModelType> error(Drawable drawable) {
        super.error(drawable);
        return this;
    }

    public GifRequestBuilder<ModelType> listener(RequestListener<? super ModelType, GifDrawable> requestListener) {
        super.listener(requestListener);
        return this;
    }

    public GifRequestBuilder<ModelType> skipMemoryCache(boolean z) {
        super.skipMemoryCache(z);
        return this;
    }

    public GifRequestBuilder<ModelType> diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        super.diskCacheStrategy(diskCacheStrategy);
        return this;
    }

    public GifRequestBuilder<ModelType> override(int i, int i2) {
        super.override(i, i2);
        return this;
    }

    public GifRequestBuilder<ModelType> sourceEncoder(Encoder<InputStream> encoder) {
        super.sourceEncoder(encoder);
        return this;
    }

    public GifRequestBuilder<ModelType> dontTransform() {
        super.dontTransform();
        return this;
    }

    public GifRequestBuilder<ModelType> signature(Key key) {
        super.signature(key);
        return this;
    }

    public GifRequestBuilder<ModelType> load(ModelType modelType) {
        super.load(modelType);
        return this;
    }

    public GifRequestBuilder<ModelType> clone() {
        return (GifRequestBuilder) super.clone();
    }

    void applyFitCenter() {
        fitCenter();
    }

    void applyCenterCrop() {
        centerCrop();
    }
}
