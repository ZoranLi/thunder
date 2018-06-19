package com.bumptech.glide.load.resource.gif;

import android.graphics.Bitmap;
import com.bumptech.glide.gifdecoder.GifDecoder;
import com.bumptech.glide.gifdecoder.GifDecoder.BitmapProvider;
import com.bumptech.glide.gifdecoder.GifHeader;
import com.bumptech.glide.gifdecoder.GifHeaderParser;
import com.bumptech.glide.gifencoder.AnimatedGifEncoder;
import com.bumptech.glide.load.ResourceEncoder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapResource;

public class GifResourceEncoder implements ResourceEncoder<GifDrawable> {
    private static final Factory FACTORY = new Factory();
    private static final String TAG = "GifEncoder";
    private final BitmapPool bitmapPool;
    private final Factory factory;
    private final BitmapProvider provider;

    static class Factory {
        Factory() {
        }

        public GifDecoder buildDecoder(BitmapProvider bitmapProvider) {
            return new GifDecoder(bitmapProvider);
        }

        public GifHeaderParser buildParser() {
            return new GifHeaderParser();
        }

        public AnimatedGifEncoder buildEncoder() {
            return new AnimatedGifEncoder();
        }

        public Resource<Bitmap> buildFrameResource(Bitmap bitmap, BitmapPool bitmapPool) {
            return new BitmapResource(bitmap, bitmapPool);
        }
    }

    public boolean encode(com.bumptech.glide.load.engine.Resource<com.bumptech.glide.load.resource.gif.GifDrawable> r9, java.io.OutputStream r10) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.ssa.SSATransform.placePhi(SSATransform.java:82)
	at jadx.core.dex.visitors.ssa.SSATransform.process(SSATransform.java:50)
	at jadx.core.dex.visitors.ssa.SSATransform.visit(SSATransform.java:42)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r8 = this;
        r0 = com.bumptech.glide.util.LogTime.getLogTime();
        r9 = r9.get();
        r9 = (com.bumptech.glide.load.resource.gif.GifDrawable) r9;
        r2 = r9.getFrameTransformation();
        r3 = r2 instanceof com.bumptech.glide.load.resource.UnitTransformation;
        if (r3 == 0) goto L_0x001b;
    L_0x0012:
        r9 = r9.getData();
        r9 = r8.writeDataDirect(r9, r10);
        return r9;
    L_0x001b:
        r3 = r9.getData();
        r3 = r8.decodeHeaders(r3);
        r4 = r8.factory;
        r4 = r4.buildEncoder();
        r10 = r4.start(r10);
        r5 = 0;
        if (r10 != 0) goto L_0x0031;
    L_0x0030:
        return r5;
    L_0x0031:
        r10 = r5;
    L_0x0032:
        r6 = r3.getFrameCount();
        if (r10 >= r6) goto L_0x0069;
    L_0x0038:
        r6 = r3.getNextFrame();
        r6 = r8.getTransformedFrame(r6, r2, r9);
        r7 = r6.get();	 Catch:{ all -> 0x0064 }
        r7 = (android.graphics.Bitmap) r7;	 Catch:{ all -> 0x0064 }
        r7 = r4.addFrame(r7);	 Catch:{ all -> 0x0064 }
        if (r7 != 0) goto L_0x0050;
    L_0x004c:
        r6.recycle();
        return r5;
    L_0x0050:
        r7 = r3.getCurrentFrameIndex();	 Catch:{ all -> 0x0064 }
        r7 = r3.getDelay(r7);	 Catch:{ all -> 0x0064 }
        r4.setDelay(r7);	 Catch:{ all -> 0x0064 }
        r3.advance();	 Catch:{ all -> 0x0064 }
        r6.recycle();
        r10 = r10 + 1;
        goto L_0x0032;
    L_0x0064:
        r9 = move-exception;
        r6.recycle();
        throw r9;
    L_0x0069:
        r10 = r4.finish();
        r2 = "GifEncoder";
        r4 = 2;
        r2 = android.util.Log.isLoggable(r2, r4);
        if (r2 == 0) goto L_0x00a2;
    L_0x0076:
        r2 = new java.lang.StringBuilder;
        r4 = "Encoded gif with ";
        r2.<init>(r4);
        r3 = r3.getFrameCount();
        r2.append(r3);
        r3 = " frames and ";
        r2.append(r3);
        r9 = r9.getData();
        r9 = r9.length;
        r2.append(r9);
        r9 = " bytes in ";
        r2.append(r9);
        r0 = com.bumptech.glide.util.LogTime.getElapsedMillis(r0);
        r2.append(r0);
        r9 = " ms";
        r2.append(r9);
    L_0x00a2:
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.gif.GifResourceEncoder.encode(com.bumptech.glide.load.engine.Resource, java.io.OutputStream):boolean");
    }

    public String getId() {
        return "";
    }

    public GifResourceEncoder(BitmapPool bitmapPool) {
        this(bitmapPool, FACTORY);
    }

    GifResourceEncoder(BitmapPool bitmapPool, Factory factory) {
        this.bitmapPool = bitmapPool;
        this.provider = new GifBitmapProvider(bitmapPool);
        this.factory = factory;
    }

    private boolean writeDataDirect(byte[] r1, java.io.OutputStream r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = this;
        r2.write(r1);	 Catch:{ IOException -> 0x0005 }
        r1 = 1;
        goto L_0x0006;
    L_0x0005:
        r1 = 0;
    L_0x0006:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.gif.GifResourceEncoder.writeDataDirect(byte[], java.io.OutputStream):boolean");
    }

    private GifDecoder decodeHeaders(byte[] bArr) {
        GifHeaderParser buildParser = this.factory.buildParser();
        buildParser.setData(bArr);
        GifHeader parseHeader = buildParser.parseHeader();
        GifDecoder buildDecoder = this.factory.buildDecoder(this.provider);
        buildDecoder.setData(parseHeader, bArr);
        buildDecoder.advance();
        return buildDecoder;
    }

    private Resource<Bitmap> getTransformedFrame(Bitmap bitmap, Transformation<Bitmap> transformation, GifDrawable gifDrawable) {
        bitmap = this.factory.buildFrameResource(bitmap, this.bitmapPool);
        transformation = transformation.transform(bitmap, gifDrawable.getIntrinsicWidth(), gifDrawable.getIntrinsicHeight());
        if (bitmap.equals(transformation) == null) {
            bitmap.recycle();
        }
        return transformation;
    }
}
