package com.bumptech.glide;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapper;
import com.bumptech.glide.load.resource.gifbitmap.GifBitmapWrapperTransformation;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.manager.Lifecycle;
import com.bumptech.glide.manager.RequestTracker;
import com.bumptech.glide.provider.LoadProvider;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.DrawableCrossFadeFactory;
import com.bumptech.glide.request.animation.GlideAnimationFactory;
import com.bumptech.glide.request.animation.ViewPropertyAnimation.Animator;
import com.bumptech.glide.request.target.Target;
import java.io.File;

public class DrawableRequestBuilder<ModelType> extends GenericRequestBuilder<ModelType, ImageVideoWrapper, GifBitmapWrapper, GlideDrawable> implements BitmapOptions, DrawableOptions {
    DrawableRequestBuilder(Context context, Class<ModelType> cls, LoadProvider<ModelType, ImageVideoWrapper, GifBitmapWrapper, GlideDrawable> loadProvider, Glide glide, RequestTracker requestTracker, Lifecycle lifecycle) {
        super(context, cls, loadProvider, GlideDrawable.class, glide, requestTracker, lifecycle);
        crossFade();
    }

    public DrawableRequestBuilder<ModelType> thumbnail(DrawableRequestBuilder<?> drawableRequestBuilder) {
        super.thumbnail((GenericRequestBuilder) drawableRequestBuilder);
        return this;
    }

    public DrawableRequestBuilder<ModelType> thumbnail(GenericRequestBuilder<?, ?, ?, GlideDrawable> genericRequestBuilder) {
        super.thumbnail((GenericRequestBuilder) genericRequestBuilder);
        return this;
    }

    public DrawableRequestBuilder<ModelType> thumbnail(float f) {
        super.thumbnail(f);
        return this;
    }

    public DrawableRequestBuilder<ModelType> sizeMultiplier(float f) {
        super.sizeMultiplier(f);
        return this;
    }

    public DrawableRequestBuilder<ModelType> decoder(ResourceDecoder<ImageVideoWrapper, GifBitmapWrapper> resourceDecoder) {
        super.decoder(resourceDecoder);
        return this;
    }

    public DrawableRequestBuilder<ModelType> cacheDecoder(ResourceDecoder<File, GifBitmapWrapper> resourceDecoder) {
        super.cacheDecoder(resourceDecoder);
        return this;
    }

    public DrawableRequestBuilder<ModelType> encoder(ResourceEncoder<GifBitmapWrapper> resourceEncoder) {
        super.encoder(resourceEncoder);
        return this;
    }

    public DrawableRequestBuilder<ModelType> priority(Priority priority) {
        super.priority(priority);
        return this;
    }

    public DrawableRequestBuilder<ModelType> transform(BitmapTransformation... bitmapTransformationArr) {
        return bitmapTransform(bitmapTransformationArr);
    }

    public DrawableRequestBuilder<ModelType> centerCrop() {
        return transform(this.glide.getDrawableCenterCrop());
    }

    public DrawableRequestBuilder<ModelType> fitCenter() {
        return transform(this.glide.getDrawableFitCenter());
    }

    public DrawableRequestBuilder<ModelType> bitmapTransform(Transformation<Bitmap>... transformationArr) {
        Transformation[] transformationArr2 = new GifBitmapWrapperTransformation[transformationArr.length];
        for (int i = 0; i < transformationArr.length; i++) {
            transformationArr2[i] = new GifBitmapWrapperTransformation(this.glide.getBitmapPool(), transformationArr[i]);
        }
        return transform(transformationArr2);
    }

    public DrawableRequestBuilder<ModelType> transform(Transformation<GifBitmapWrapper>... transformationArr) {
        super.transform(transformationArr);
        return this;
    }

    public DrawableRequestBuilder<ModelType> transcoder(ResourceTranscoder<GifBitmapWrapper, GlideDrawable> resourceTranscoder) {
        super.transcoder(resourceTranscoder);
        return this;
    }

    public final DrawableRequestBuilder<ModelType> crossFade() {
        super.animate(new DrawableCrossFadeFactory());
        return this;
    }

    public DrawableRequestBuilder<ModelType> crossFade(int i) {
        super.animate(new DrawableCrossFadeFactory(i));
        return this;
    }

    @Deprecated
    public DrawableRequestBuilder<ModelType> crossFade(Animation animation, int i) {
        super.animate(new DrawableCrossFadeFactory(animation, i));
        return this;
    }

    public DrawableRequestBuilder<ModelType> crossFade(int i, int i2) {
        super.animate(new DrawableCrossFadeFactory(this.context, i, i2));
        return this;
    }

    public DrawableRequestBuilder<ModelType> dontAnimate() {
        super.dontAnimate();
        return this;
    }

    public DrawableRequestBuilder<ModelType> animate(Animator animator) {
        super.animate(animator);
        return this;
    }

    public DrawableRequestBuilder<ModelType> animate(GlideAnimationFactory<GlideDrawable> glideAnimationFactory) {
        super.animate((GlideAnimationFactory) glideAnimationFactory);
        return this;
    }

    public DrawableRequestBuilder<ModelType> animate(int i) {
        super.animate(i);
        return this;
    }

    @Deprecated
    public DrawableRequestBuilder<ModelType> animate(Animation animation) {
        super.animate(animation);
        return this;
    }

    public DrawableRequestBuilder<ModelType> placeholder(int i) {
        super.placeholder(i);
        return this;
    }

    public DrawableRequestBuilder<ModelType> placeholder(Drawable drawable) {
        super.placeholder(drawable);
        return this;
    }

    public DrawableRequestBuilder<ModelType> fallback(Drawable drawable) {
        super.fallback(drawable);
        return this;
    }

    public DrawableRequestBuilder<ModelType> fallback(int i) {
        super.fallback(i);
        return this;
    }

    public DrawableRequestBuilder<ModelType> error(int i) {
        super.error(i);
        return this;
    }

    public DrawableRequestBuilder<ModelType> error(Drawable drawable) {
        super.error(drawable);
        return this;
    }

    public DrawableRequestBuilder<ModelType> listener(RequestListener<? super ModelType, GlideDrawable> requestListener) {
        super.listener(requestListener);
        return this;
    }

    public DrawableRequestBuilder<ModelType> diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        super.diskCacheStrategy(diskCacheStrategy);
        return this;
    }

    public DrawableRequestBuilder<ModelType> skipMemoryCache(boolean z) {
        super.skipMemoryCache(z);
        return this;
    }

    public DrawableRequestBuilder<ModelType> override(int i, int i2) {
        super.override(i, i2);
        return this;
    }

    public DrawableRequestBuilder<ModelType> sourceEncoder(Encoder<ImageVideoWrapper> encoder) {
        super.sourceEncoder(encoder);
        return this;
    }

    public DrawableRequestBuilder<ModelType> dontTransform() {
        super.dontTransform();
        return this;
    }

    public DrawableRequestBuilder<ModelType> signature(Key key) {
        super.signature(key);
        return this;
    }

    public DrawableRequestBuilder<ModelType> load(ModelType modelType) {
        super.load(modelType);
        return this;
    }

    public DrawableRequestBuilder<ModelType> clone() {
        return (DrawableRequestBuilder) super.clone();
    }

    public Target<GlideDrawable> into(ImageView imageView) {
        return super.into(imageView);
    }

    void applyFitCenter() {
        fitCenter();
    }

    void applyCenterCrop() {
        centerCrop();
    }
}
