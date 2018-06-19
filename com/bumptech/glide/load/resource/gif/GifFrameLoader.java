package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bumptech.glide.GenericRequestBuilder;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.NullEncoder;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.UUID;

class GifFrameLoader {
    private final FrameCallback callback;
    private DelayTarget current;
    private final GifDecoder gifDecoder;
    private final Handler handler;
    private boolean isCleared;
    private boolean isLoadPending;
    private boolean isRunning;
    private GenericRequestBuilder<GifDecoder, GifDecoder, Bitmap, Bitmap> requestBuilder;

    public interface FrameCallback {
        void onFrameReady(int i);
    }

    private class FrameLoaderCallback implements Callback {
        public static final int MSG_CLEAR = 2;
        public static final int MSG_DELAY = 1;

        private FrameLoaderCallback() {
        }

        public boolean handleMessage(Message message) {
            if (message.what == 1) {
                GifFrameLoader.this.onFrameReady((DelayTarget) message.obj);
                return true;
            }
            if (message.what == 2) {
                Glide.clear((DelayTarget) message.obj);
            }
            return null;
        }
    }

    static class FrameSignature implements Key {
        private final UUID uuid;

        public FrameSignature() {
            this(UUID.randomUUID());
        }

        FrameSignature(UUID uuid) {
            this.uuid = uuid;
        }

        public boolean equals(Object obj) {
            return obj instanceof FrameSignature ? ((FrameSignature) obj).uuid.equals(this.uuid) : null;
        }

        public int hashCode() {
            return this.uuid.hashCode();
        }

        public void updateDiskCacheKey(MessageDigest messageDigest) throws UnsupportedEncodingException {
            throw new UnsupportedOperationException("Not implemented");
        }
    }

    static class DelayTarget extends SimpleTarget<Bitmap> {
        private final Handler handler;
        private final int index;
        private Bitmap resource;
        private final long targetTime;

        public DelayTarget(Handler handler, int i, long j) {
            this.handler = handler;
            this.index = i;
            this.targetTime = j;
        }

        public Bitmap getResource() {
            return this.resource;
        }

        public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> glideAnimation) {
            this.resource = bitmap;
            this.handler.sendMessageAtTime(this.handler.obtainMessage(1, this), this.targetTime);
        }
    }

    public GifFrameLoader(Context context, FrameCallback frameCallback, GifDecoder gifDecoder, int i, int i2) {
        this(frameCallback, gifDecoder, 0, getRequestBuilder(context, gifDecoder, i, i2, Glide.get(context).getBitmapPool()));
    }

    GifFrameLoader(FrameCallback frameCallback, GifDecoder gifDecoder, Handler handler, GenericRequestBuilder<GifDecoder, GifDecoder, Bitmap, Bitmap> genericRequestBuilder) {
        this.isRunning = false;
        this.isLoadPending = false;
        if (handler == null) {
            handler = new Handler(Looper.getMainLooper(), new FrameLoaderCallback());
        }
        this.callback = frameCallback;
        this.gifDecoder = gifDecoder;
        this.handler = handler;
        this.requestBuilder = genericRequestBuilder;
    }

    public void setFrameTransformation(Transformation<Bitmap> transformation) {
        if (transformation == null) {
            throw new NullPointerException("Transformation must not be null");
        }
        this.requestBuilder = this.requestBuilder.transform(transformation);
    }

    public void start() {
        if (!this.isRunning) {
            this.isRunning = true;
            this.isCleared = false;
            loadNextFrame();
        }
    }

    public void stop() {
        this.isRunning = false;
    }

    public void clear() {
        stop();
        if (this.current != null) {
            Glide.clear(this.current);
            this.current = null;
        }
        this.isCleared = true;
    }

    public Bitmap getCurrentFrame() {
        return this.current != null ? this.current.getResource() : null;
    }

    private void loadNextFrame() {
        if (this.isRunning) {
            if (!this.isLoadPending) {
                this.isLoadPending = true;
                long uptimeMillis = SystemClock.uptimeMillis() + ((long) this.gifDecoder.getNextDelay());
                this.gifDecoder.advance();
                this.requestBuilder.signature(new FrameSignature()).into(new DelayTarget(this.handler, this.gifDecoder.getCurrentFrameIndex(), uptimeMillis));
            }
        }
    }

    void onFrameReady(DelayTarget delayTarget) {
        if (this.isCleared) {
            this.handler.obtainMessage(2, delayTarget).sendToTarget();
            return;
        }
        DelayTarget delayTarget2 = this.current;
        this.current = delayTarget;
        this.callback.onFrameReady(delayTarget.index);
        if (delayTarget2 != null) {
            this.handler.obtainMessage(2, delayTarget2).sendToTarget();
        }
        this.isLoadPending = null;
        loadNextFrame();
    }

    private static GenericRequestBuilder<GifDecoder, GifDecoder, Bitmap, Bitmap> getRequestBuilder(Context context, GifDecoder gifDecoder, int i, int i2, BitmapPool bitmapPool) {
        ResourceDecoder gifFrameResourceDecoder = new GifFrameResourceDecoder(bitmapPool);
        bitmapPool = new GifFrameModelLoader();
        return Glide.with(context).using(bitmapPool, GifDecoder.class).load(gifDecoder).as(Bitmap.class).sourceEncoder(NullEncoder.get()).decoder(gifFrameResourceDecoder).skipMemoryCache(true).diskCacheStrategy(DiskCacheStrategy.NONE).override(i, i2);
    }
}
