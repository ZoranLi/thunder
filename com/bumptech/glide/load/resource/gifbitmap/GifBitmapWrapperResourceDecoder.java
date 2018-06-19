package com.bumptech.glide.load.resource.gifbitmap;

import android.graphics.Bitmap;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.model.ImageVideoWrapper;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser.ImageType;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.util.ByteArrayPool;
import java.io.IOException;
import java.io.InputStream;

public class GifBitmapWrapperResourceDecoder implements ResourceDecoder<ImageVideoWrapper, GifBitmapWrapper> {
    private static final ImageTypeParser DEFAULT_PARSER = new ImageTypeParser();
    private static final BufferedStreamFactory DEFAULT_STREAM_FACTORY = new BufferedStreamFactory();
    static final int MARK_LIMIT_BYTES = 2048;
    private final ResourceDecoder<ImageVideoWrapper, Bitmap> bitmapDecoder;
    private final BitmapPool bitmapPool;
    private final ResourceDecoder<InputStream, GifDrawable> gifDecoder;
    private String id;
    private final ImageTypeParser parser;
    private final BufferedStreamFactory streamFactory;

    static class BufferedStreamFactory {
        BufferedStreamFactory() {
        }

        public InputStream build(InputStream inputStream, byte[] bArr) {
            return new RecyclableBufferedInputStream(inputStream, bArr);
        }
    }

    static class ImageTypeParser {
        ImageTypeParser() {
        }

        public ImageType parse(InputStream inputStream) throws IOException {
            return new ImageHeaderParser(inputStream).getType();
        }
    }

    public GifBitmapWrapperResourceDecoder(ResourceDecoder<ImageVideoWrapper, Bitmap> resourceDecoder, ResourceDecoder<InputStream, GifDrawable> resourceDecoder2, BitmapPool bitmapPool) {
        this(resourceDecoder, resourceDecoder2, bitmapPool, DEFAULT_PARSER, DEFAULT_STREAM_FACTORY);
    }

    GifBitmapWrapperResourceDecoder(ResourceDecoder<ImageVideoWrapper, Bitmap> resourceDecoder, ResourceDecoder<InputStream, GifDrawable> resourceDecoder2, BitmapPool bitmapPool, ImageTypeParser imageTypeParser, BufferedStreamFactory bufferedStreamFactory) {
        this.bitmapDecoder = resourceDecoder;
        this.gifDecoder = resourceDecoder2;
        this.bitmapPool = bitmapPool;
        this.parser = imageTypeParser;
        this.streamFactory = bufferedStreamFactory;
    }

    public Resource<GifBitmapWrapper> decode(ImageVideoWrapper imageVideoWrapper, int i, int i2) throws IOException {
        ByteArrayPool byteArrayPool = ByteArrayPool.get();
        byte[] bytes = byteArrayPool.getBytes();
        try {
            imageVideoWrapper = decode(imageVideoWrapper, i, i2, bytes);
            return imageVideoWrapper != null ? new GifBitmapWrapperResource(imageVideoWrapper) : null;
        } finally {
            byteArrayPool.releaseBytes(bytes);
        }
    }

    private GifBitmapWrapper decode(ImageVideoWrapper imageVideoWrapper, int i, int i2, byte[] bArr) throws IOException {
        if (imageVideoWrapper.getStream() != null) {
            return decodeStream(imageVideoWrapper, i, i2, bArr);
        }
        return decodeBitmapWrapper(imageVideoWrapper, i, i2);
    }

    private GifBitmapWrapper decodeStream(ImageVideoWrapper imageVideoWrapper, int i, int i2, byte[] bArr) throws IOException {
        bArr = this.streamFactory.build(imageVideoWrapper.getStream(), bArr);
        bArr.mark(2048);
        ImageType parse = this.parser.parse(bArr);
        bArr.reset();
        GifBitmapWrapper decodeGifWrapper = parse == ImageType.GIF ? decodeGifWrapper(bArr, i, i2) : null;
        return decodeGifWrapper == null ? decodeBitmapWrapper(new ImageVideoWrapper(bArr, imageVideoWrapper.getFileDescriptor()), i, i2) : decodeGifWrapper;
    }

    private GifBitmapWrapper decodeGifWrapper(InputStream inputStream, int i, int i2) throws IOException {
        inputStream = this.gifDecoder.decode(inputStream, i, i2);
        if (inputStream == null) {
            return 0;
        }
        GifDrawable gifDrawable = (GifDrawable) inputStream.get();
        if (gifDrawable.getFrameCount() > 1) {
            return new GifBitmapWrapper(null, inputStream);
        }
        return new GifBitmapWrapper(new BitmapResource(gifDrawable.getFirstFrame(), this.bitmapPool), null);
    }

    private GifBitmapWrapper decodeBitmapWrapper(ImageVideoWrapper imageVideoWrapper, int i, int i2) throws IOException {
        imageVideoWrapper = this.bitmapDecoder.decode(imageVideoWrapper, i, i2);
        if (imageVideoWrapper != null) {
            return new GifBitmapWrapper(imageVideoWrapper, null);
        }
        return null;
    }

    public String getId() {
        if (this.id == null) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(this.gifDecoder.getId());
            stringBuilder.append(this.bitmapDecoder.getId());
            this.id = stringBuilder.toString();
        }
        return this.id;
    }
}
