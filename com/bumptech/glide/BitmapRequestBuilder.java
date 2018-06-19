package com.bumptech.glide;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.ParcelFileDescriptor;
import android.view.animation.Animation;
import android.widget.ImageView;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.Encoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.bitmap.Downsampler;
import com.bumptech.glide.load.resource.bitmap.FileDescriptorBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.ImageVideoBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.StreamBitmapDecoder;
import com.bumptech.glide.load.resource.bitmap.VideoBitmapDecoder;
import com.bumptech.glide.load.resource.file.FileToStreamDecoder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.provider.LoadProvider;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.BitmapCrossFadeFactory;
import com.bumptech.glide.request.animation.DrawableCrossFadeFactory;
import com.bumptech.glide.request.animation.GlideAnimationFactory;
import com.bumptech.glide.request.animation.ViewPropertyAnimation.Animator;
import com.bumptech.glide.request.target.Target;
import java.io.File;
import java.io.InputStream;

public class BitmapRequestBuilder<ModelType, TranscodeType> extends GenericRequestBuilder<ModelType, ImageVideoWrapper, Bitmap, TranscodeType> implements BitmapOptions, DrawableOptions {
    private final BitmapPool bitmapPool;
    private DecodeFormat decodeFormat;
    private Downsampler downsampler = Downsampler.AT_LEAST;
    private ResourceDecoder<InputStream, Bitmap> imageDecoder;
    private ResourceDecoder<ParcelFileDescriptor, Bitmap> videoDecoder;

    BitmapRequestBuilder(LoadProvider<ModelType, ImageVideoWrapper, Bitmap, TranscodeType> loadProvider, Class<TranscodeType> cls, GenericRequestBuilder<ModelType, ?, ?, ?> genericRequestBuilder) {
        super(loadProvider, cls, genericRequestBuilder);
        this.bitmapPool = genericRequestBuilder.glide.getBitmapPool();
        this.decodeFormat = genericRequestBuilder.glide.getDecodeFormat();
        this.imageDecoder = new StreamBitmapDecoder(this.bitmapPool, this.decodeFormat);
        this.videoDecoder = new FileDescriptorBitmapDecoder(this.bitmapPool, this.decodeFormat);
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> approximate() {
        return downsample(Downsampler.AT_LEAST);
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> asIs() {
        return downsample(Downsampler.NONE);
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> atMost() {
        return downsample(Downsampler.AT_MOST);
    }

    private BitmapRequestBuilder<ModelType, TranscodeType> downsample(Downsampler downsampler) {
        this.downsampler = downsampler;
        this.imageDecoder = new StreamBitmapDecoder(downsampler, this.bitmapPool, this.decodeFormat);
        super.decoder(new ImageVideoBitmapDecoder(this.imageDecoder, this.videoDecoder));
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> thumbnail(float f) {
        super.thumbnail(f);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> thumbnail(BitmapRequestBuilder<?, TranscodeType> bitmapRequestBuilder) {
        super.thumbnail((GenericRequestBuilder) bitmapRequestBuilder);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> sizeMultiplier(float f) {
        super.sizeMultiplier(f);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> decoder(ResourceDecoder<ImageVideoWrapper, Bitmap> resourceDecoder) {
        super.decoder(resourceDecoder);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> cacheDecoder(ResourceDecoder<File, Bitmap> resourceDecoder) {
        super.cacheDecoder(resourceDecoder);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> encoder(ResourceEncoder<Bitmap> resourceEncoder) {
        super.encoder(resourceEncoder);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> imageDecoder(ResourceDecoder<InputStream, Bitmap> resourceDecoder) {
        this.imageDecoder = resourceDecoder;
        super.decoder(new ImageVideoBitmapDecoder(resourceDecoder, this.videoDecoder));
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> videoDecoder(ResourceDecoder<ParcelFileDescriptor, Bitmap> resourceDecoder) {
        this.videoDecoder = resourceDecoder;
        super.decoder(new ImageVideoBitmapDecoder(this.imageDecoder, resourceDecoder));
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> format(DecodeFormat decodeFormat) {
        this.decodeFormat = decodeFormat;
        this.imageDecoder = new StreamBitmapDecoder(this.downsampler, this.bitmapPool, decodeFormat);
        this.videoDecoder = new FileDescriptorBitmapDecoder(new VideoBitmapDecoder(), this.bitmapPool, decodeFormat);
        super.cacheDecoder(new FileToStreamDecoder(new StreamBitmapDecoder(this.downsampler, this.bitmapPool, decodeFormat)));
        super.decoder(new ImageVideoBitmapDecoder(this.imageDecoder, this.videoDecoder));
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> priority(Priority priority) {
        super.priority(priority);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> transform(BitmapTransformation... bitmapTransformationArr) {
        super.transform(bitmapTransformationArr);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> centerCrop() {
        return transform(this.glide.getBitmapCenterCrop());
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> fitCenter() {
        return transform(this.glide.getBitmapFitCenter());
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> transform(Transformation<Bitmap>... transformationArr) {
        super.transform(transformationArr);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> transcoder(ResourceTranscoder<Bitmap, TranscodeType> resourceTranscoder) {
        super.transcoder(resourceTranscoder);
        return this;
    }

    private RuntimeException crossFadeNotSupported() {
        String canonicalName = this.transcodeClass.getCanonicalName();
        if (canonicalName == null) {
            canonicalName = this.transcodeClass.toString();
        }
        StringBuilder stringBuilder = new StringBuilder(".crossFade() is not supported for ");
        stringBuilder.append(canonicalName);
        stringBuilder.append(", use .animate() to provide a compatible animation.");
        return new UnsupportedOperationException(stringBuilder.toString());
    }

    public final BitmapRequestBuilder<ModelType, TranscodeType> crossFade() {
        if (Bitmap.class.isAssignableFrom(this.transcodeClass)) {
            return animate(new BitmapCrossFadeFactory());
        }
        if (Drawable.class.isAssignableFrom(this.transcodeClass)) {
            return animate(new DrawableCrossFadeFactory());
        }
        throw crossFadeNotSupported();
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> crossFade(int i) {
        if (Bitmap.class.isAssignableFrom(this.transcodeClass)) {
            return animate(new BitmapCrossFadeFactory(i));
        }
        if (Drawable.class.isAssignableFrom(this.transcodeClass)) {
            return animate(new DrawableCrossFadeFactory(i));
        }
        throw crossFadeNotSupported();
    }

    @Deprecated
    public BitmapRequestBuilder<ModelType, TranscodeType> crossFade(Animation animation, int i) {
        if (Bitmap.class.isAssignableFrom(this.transcodeClass)) {
            return animate(new BitmapCrossFadeFactory(animation, i));
        }
        if (Drawable.class.isAssignableFrom(this.transcodeClass)) {
            return animate(new DrawableCrossFadeFactory(animation, i));
        }
        throw crossFadeNotSupported();
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> crossFade(int i, int i2) {
        if (Bitmap.class.isAssignableFrom(this.transcodeClass)) {
            return animate(new BitmapCrossFadeFactory(this.context, i, i2));
        }
        if (Drawable.class.isAssignableFrom(this.transcodeClass)) {
            return animate(new DrawableCrossFadeFactory(this.context, i, i2));
        }
        throw crossFadeNotSupported();
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> dontAnimate() {
        super.dontAnimate();
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> animate(int i) {
        super.animate(i);
        return this;
    }

    @Deprecated
    public BitmapRequestBuilder<ModelType, TranscodeType> animate(Animation animation) {
        super.animate(animation);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> animate(Animator animator) {
        super.animate(animator);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> animate(GlideAnimationFactory<TranscodeType> glideAnimationFactory) {
        super.animate((GlideAnimationFactory) glideAnimationFactory);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> placeholder(int i) {
        super.placeholder(i);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> placeholder(Drawable drawable) {
        super.placeholder(drawable);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> fallback(Drawable drawable) {
        super.fallback(drawable);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> fallback(int i) {
        super.fallback(i);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> error(int i) {
        super.error(i);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> error(Drawable drawable) {
        super.error(drawable);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> listener(RequestListener<? super ModelType, TranscodeType> requestListener) {
        super.listener(requestListener);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> skipMemoryCache(boolean z) {
        super.skipMemoryCache(z);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> diskCacheStrategy(DiskCacheStrategy diskCacheStrategy) {
        super.diskCacheStrategy(diskCacheStrategy);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> override(int i, int i2) {
        super.override(i, i2);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> thumbnail(GenericRequestBuilder<?, ?, ?, TranscodeType> genericRequestBuilder) {
        super.thumbnail((GenericRequestBuilder) genericRequestBuilder);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> sourceEncoder(Encoder<ImageVideoWrapper> encoder) {
        super.sourceEncoder(encoder);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> dontTransform() {
        super.dontTransform();
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> signature(Key key) {
        super.signature(key);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> load(ModelType modelType) {
        super.load(modelType);
        return this;
    }

    public BitmapRequestBuilder<ModelType, TranscodeType> clone() {
        return (BitmapRequestBuilder) super.clone();
    }

    public Target<TranscodeType> into(ImageView imageView) {
        return super.into(imageView);
    }

    void applyFitCenter() {
        fitCenter();
    }

    void applyCenterCrop() {
        centerCrop();
    }
}
