package com.bumptech.glide.load.resource.gif;

import android.content.Context;
import android.graphics.Bitmap;
import com.bumptech.glide.Glide;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.UnitTransformation;
import com.bumptech.glide.util.Util;
import java.io.InputStream;
import java.util.Queue;

public class GifResourceDecoder implements ResourceDecoder<InputStream, GifDrawable> {
    private static final GifDecoderPool DECODER_POOL = new GifDecoderPool();
    private static final GifHeaderParserPool PARSER_POOL = new GifHeaderParserPool();
    private static final String TAG = "GifResourceDecoder";
    private final BitmapPool bitmapPool;
    private final Context context;
    private final GifDecoderPool decoderPool;
    private final GifHeaderParserPool parserPool;
    private final GifBitmapProvider provider;

    static class GifDecoderPool {
        private final Queue<GifDecoder> pool = Util.createQueue(0);

        GifDecoderPool() {
        }

        public synchronized GifDecoder obtain(BitmapProvider bitmapProvider) {
            GifDecoder gifDecoder;
            gifDecoder = (GifDecoder) this.pool.poll();
            if (gifDecoder == null) {
                gifDecoder = new GifDecoder(bitmapProvider);
            }
            return gifDecoder;
        }

        public synchronized void release(GifDecoder gifDecoder) {
            gifDecoder.clear();
            this.pool.offer(gifDecoder);
        }
    }

    static class GifHeaderParserPool {
        private final Queue<GifHeaderParser> pool = Util.createQueue(0);

        GifHeaderParserPool() {
        }

        public synchronized GifHeaderParser obtain(byte[] bArr) {
            GifHeaderParser gifHeaderParser;
            gifHeaderParser = (GifHeaderParser) this.pool.poll();
            if (gifHeaderParser == null) {
                gifHeaderParser = new GifHeaderParser();
            }
            return gifHeaderParser.setData(bArr);
        }

        public synchronized void release(GifHeaderParser gifHeaderParser) {
            gifHeaderParser.clear();
            this.pool.offer(gifHeaderParser);
        }
    }

    public String getId() {
        return "";
    }

    public GifResourceDecoder(Context context) {
        this(context, Glide.get(context).getBitmapPool());
    }

    public GifResourceDecoder(Context context, BitmapPool bitmapPool) {
        this(context, bitmapPool, PARSER_POOL, DECODER_POOL);
    }

    GifResourceDecoder(Context context, BitmapPool bitmapPool, GifHeaderParserPool gifHeaderParserPool, GifDecoderPool gifDecoderPool) {
        this.context = context.getApplicationContext();
        this.bitmapPool = bitmapPool;
        this.decoderPool = gifDecoderPool;
        this.provider = new GifBitmapProvider(bitmapPool);
        this.parserPool = gifHeaderParserPool;
    }

    public GifDrawableResource decode(InputStream inputStream, int i, int i2) {
        byte[] inputStreamToBytes = inputStreamToBytes(inputStream);
        inputStream = this.parserPool.obtain(inputStreamToBytes);
        GifDecoder obtain = this.decoderPool.obtain(this.provider);
        try {
            i = decode(inputStreamToBytes, i, i2, inputStream, obtain);
            return i;
        } finally {
            this.parserPool.release(inputStream);
            this.decoderPool.release(obtain);
        }
    }

    private GifDrawableResource decode(byte[] bArr, int i, int i2, GifHeaderParser gifHeaderParser, GifDecoder gifDecoder) {
        GifHeader parseHeader = gifHeaderParser.parseHeader();
        if (parseHeader.getNumFrames() > null) {
            if (parseHeader.getStatus() == null) {
                Bitmap decodeFirstFrame = decodeFirstFrame(gifDecoder, parseHeader, bArr);
                if (decodeFirstFrame == null) {
                    return null;
                }
                return new GifDrawableResource(new GifDrawable(this.context, this.provider, this.bitmapPool, UnitTransformation.get(), i, i2, parseHeader, bArr, decodeFirstFrame));
            }
        }
        return null;
    }

    private Bitmap decodeFirstFrame(GifDecoder gifDecoder, GifHeader gifHeader, byte[] bArr) {
        gifDecoder.setData(gifHeader, bArr);
        gifDecoder.advance();
        return gifDecoder.getNextFrame();
    }

    private static byte[] inputStreamToBytes(java.io.InputStream r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = new java.io.ByteArrayOutputStream;
        r1 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
        r0.<init>(r1);
        r1 = new byte[r1];	 Catch:{ IOException -> 0x0018 }
    L_0x0009:
        r2 = r4.read(r1);	 Catch:{ IOException -> 0x0018 }
        r3 = -1;	 Catch:{ IOException -> 0x0018 }
        if (r2 == r3) goto L_0x0015;	 Catch:{ IOException -> 0x0018 }
    L_0x0010:
        r3 = 0;	 Catch:{ IOException -> 0x0018 }
        r0.write(r1, r3, r2);	 Catch:{ IOException -> 0x0018 }
        goto L_0x0009;	 Catch:{ IOException -> 0x0018 }
    L_0x0015:
        r0.flush();	 Catch:{ IOException -> 0x0018 }
    L_0x0018:
        r4 = r0.toByteArray();
        return r4;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.gif.GifResourceDecoder.inputStreamToBytes(java.io.InputStream):byte[]");
    }
}
