package com.bumptech.glide.load.resource.bitmap;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.os.Build.VERSION;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.ImageHeaderParser.ImageType;
import com.bumptech.glide.util.MarkEnforcingInputStream;
import com.bumptech.glide.util.Util;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.Queue;
import java.util.Set;

public abstract class Downsampler implements BitmapDecoder<InputStream> {
    public static final Downsampler AT_LEAST = new Downsampler() {
        public final String getId() {
            return "AT_LEAST.com.bumptech.glide.load.data.bitmap";
        }

        public final /* bridge */ /* synthetic */ Bitmap decode(Object obj, BitmapPool bitmapPool, int i, int i2, DecodeFormat decodeFormat) throws Exception {
            return super.decode((InputStream) obj, bitmapPool, i, i2, decodeFormat);
        }

        protected final int getSampleSize(int i, int i2, int i3, int i4) {
            return Math.min(i2 / i4, i / i3);
        }
    };
    public static final Downsampler AT_MOST = new Downsampler() {
        public final String getId() {
            return "AT_MOST.com.bumptech.glide.load.data.bitmap";
        }

        public final /* bridge */ /* synthetic */ Bitmap decode(Object obj, BitmapPool bitmapPool, int i, int i2, DecodeFormat decodeFormat) throws Exception {
            return super.decode((InputStream) obj, bitmapPool, i, i2, decodeFormat);
        }

        protected final int getSampleSize(int i, int i2, int i3, int i4) {
            i = (int) Math.ceil((double) Math.max(((float) i2) / ((float) i4), ((float) i) / ((float) i3)));
            i3 = 1;
            i2 = Math.max(1, Integer.highestOneBit(i));
            if (i2 >= i) {
                i3 = 0;
            }
            return i2 << i3;
        }
    };
    private static final int MARK_POSITION = 5242880;
    public static final Downsampler NONE = new Downsampler() {
        public final String getId() {
            return "NONE.com.bumptech.glide.load.data.bitmap";
        }

        protected final int getSampleSize(int i, int i2, int i3, int i4) {
            return 0;
        }

        public final /* bridge */ /* synthetic */ Bitmap decode(Object obj, BitmapPool bitmapPool, int i, int i2, DecodeFormat decodeFormat) throws Exception {
            return super.decode((InputStream) obj, bitmapPool, i, i2, decodeFormat);
        }
    };
    private static final Queue<Options> OPTIONS_QUEUE = Util.createQueue(0);
    private static final String TAG = "Downsampler";
    private static final Set<ImageType> TYPES_THAT_USE_POOL = EnumSet.of(ImageType.JPEG, ImageType.PNG_A, ImageType.PNG);

    protected abstract int getSampleSize(int i, int i2, int i3, int i4);

    public android.graphics.Bitmap decode(java.io.InputStream r24, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool r25, int r26, int r27, com.bumptech.glide.load.DecodeFormat r28) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r23 = this;
        r10 = r25;
        r11 = com.bumptech.glide.util.ByteArrayPool.get();
        r12 = r11.getBytes();
        r13 = r11.getBytes();
        r14 = getDefaultOptions();
        r3 = new com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
        r1 = r24;
        r3.<init>(r1, r13);
        r15 = com.bumptech.glide.util.ExceptionCatchingInputStream.obtain(r3);
        r2 = new com.bumptech.glide.util.MarkEnforcingInputStream;
        r2.<init>(r15);
        r1 = 5242880; // 0x500000 float:7.34684E-39 double:2.590327E-317;
        r15.mark(r1);	 Catch:{ all -> 0x00ad }
        r1 = 0;
        r4 = new com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;	 Catch:{ IOException -> 0x003c, all -> 0x0036 }
        r4.<init>(r15);	 Catch:{ IOException -> 0x003c, all -> 0x0036 }
        r4 = r4.getOrientation();	 Catch:{ IOException -> 0x003c, all -> 0x0036 }
        r15.reset();	 Catch:{ IOException -> 0x0034 }
    L_0x0034:
        r9 = r4;
        goto L_0x0046;
    L_0x0036:
        r0 = move-exception;
        r1 = r0;
        r15.reset();	 Catch:{ IOException -> 0x003b }
    L_0x003b:
        throw r1;	 Catch:{ all -> 0x0040 }
    L_0x003c:
        r15.reset();	 Catch:{ IOException -> 0x0045 }
        goto L_0x0045;
    L_0x0040:
        r0 = move-exception;
        r2 = r0;
        r1 = r14;
        goto L_0x00b0;
    L_0x0045:
        r9 = r1;
    L_0x0046:
        r14.inTempStorage = r12;	 Catch:{ all -> 0x00ad }
        r8 = r23;	 Catch:{ all -> 0x00ad }
        r4 = r8.getDimensions(r2, r3, r14);	 Catch:{ all -> 0x00ad }
        r6 = r4[r1];	 Catch:{ all -> 0x00ad }
        r1 = 1;	 Catch:{ all -> 0x00ad }
        r7 = r4[r1];	 Catch:{ all -> 0x00ad }
        r17 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.getExifOrientationDegrees(r9);	 Catch:{ all -> 0x00ad }
        r16 = r8;	 Catch:{ all -> 0x00ad }
        r18 = r6;	 Catch:{ all -> 0x00ad }
        r19 = r7;	 Catch:{ all -> 0x00ad }
        r20 = r26;	 Catch:{ all -> 0x00ad }
        r21 = r27;	 Catch:{ all -> 0x00ad }
        r16 = r16.getRoundedSampleSize(r17, r18, r19, r20, r21);	 Catch:{ all -> 0x00ad }
        r1 = r8;
        r4 = r14;
        r5 = r10;
        r8 = r16;
        r22 = r14;
        r14 = r9;
        r9 = r28;
        r1 = r1.downsampleWithSize(r2, r3, r4, r5, r6, r7, r8, r9);	 Catch:{ all -> 0x00a9 }
        r2 = r15.getException();	 Catch:{ all -> 0x00a9 }
        if (r2 == 0) goto L_0x0084;
    L_0x0079:
        r1 = new java.lang.RuntimeException;	 Catch:{ all -> 0x007f }
        r1.<init>(r2);	 Catch:{ all -> 0x007f }
        throw r1;	 Catch:{ all -> 0x007f }
    L_0x007f:
        r0 = move-exception;	 Catch:{ all -> 0x007f }
        r2 = r0;	 Catch:{ all -> 0x007f }
        r1 = r22;	 Catch:{ all -> 0x007f }
        goto L_0x00b0;	 Catch:{ all -> 0x007f }
    L_0x0084:
        r2 = 0;	 Catch:{ all -> 0x007f }
        if (r1 == 0) goto L_0x009a;	 Catch:{ all -> 0x007f }
    L_0x0087:
        r2 = com.bumptech.glide.load.resource.bitmap.TransformationUtils.rotateImageExif(r1, r10, r14);	 Catch:{ all -> 0x007f }
        r3 = r1.equals(r2);	 Catch:{ all -> 0x007f }
        if (r3 != 0) goto L_0x009a;	 Catch:{ all -> 0x007f }
    L_0x0091:
        r3 = r10.put(r1);	 Catch:{ all -> 0x007f }
        if (r3 != 0) goto L_0x009a;	 Catch:{ all -> 0x007f }
    L_0x0097:
        r1.recycle();	 Catch:{ all -> 0x007f }
    L_0x009a:
        r11.releaseBytes(r12);
        r11.releaseBytes(r13);
        r15.release();
        r1 = r22;
        releaseOptions(r1);
        return r2;
    L_0x00a9:
        r0 = move-exception;
        r1 = r22;
        goto L_0x00af;
    L_0x00ad:
        r0 = move-exception;
        r1 = r14;
    L_0x00af:
        r2 = r0;
    L_0x00b0:
        r11.releaseBytes(r12);
        r11.releaseBytes(r13);
        r15.release();
        releaseOptions(r1);
        throw r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.decode(java.io.InputStream, com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool, int, int, com.bumptech.glide.load.DecodeFormat):android.graphics.Bitmap");
    }

    private int getRoundedSampleSize(int i, int i2, int i3, int i4, int i5) {
        if (i5 == Integer.MIN_VALUE) {
            i5 = i3;
        }
        if (i4 == Integer.MIN_VALUE) {
            i4 = i2;
        }
        if (i != 90) {
            if (i != 270) {
                i = getSampleSize(i2, i3, i4, i5);
                if (i != 0) {
                    i = 0;
                } else {
                    i = Integer.highestOneBit(i);
                }
                return Math.max(1, i);
            }
        }
        i = getSampleSize(i3, i2, i4, i5);
        if (i != 0) {
            i = Integer.highestOneBit(i);
        } else {
            i = 0;
        }
        return Math.max(1, i);
    }

    private Bitmap downsampleWithSize(MarkEnforcingInputStream markEnforcingInputStream, RecyclableBufferedInputStream recyclableBufferedInputStream, Options options, BitmapPool bitmapPool, int i, int i2, int i3, DecodeFormat decodeFormat) {
        decodeFormat = getConfig(markEnforcingInputStream, decodeFormat);
        options.inSampleSize = i3;
        options.inPreferredConfig = decodeFormat;
        if ((options.inSampleSize == 1 || 19 <= VERSION.SDK_INT) && shouldUsePool(markEnforcingInputStream)) {
            double d = (double) i3;
            setInBitmap(options, bitmapPool.getDirty((int) Math.ceil(((double) i) / d), (int) Math.ceil(((double) i2) / d), decodeFormat));
        }
        return decodeStream(markEnforcingInputStream, recyclableBufferedInputStream, options);
    }

    private static boolean shouldUsePool(java.io.InputStream r2) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 19;
        if (r1 > r0) goto L_0x0008;
    L_0x0006:
        r2 = 1;
        return r2;
    L_0x0008:
        r0 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r2.mark(r0);
        r0 = new com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;	 Catch:{ IOException -> 0x0025, all -> 0x0020 }
        r0.<init>(r2);	 Catch:{ IOException -> 0x0025, all -> 0x0020 }
        r0 = r0.getType();	 Catch:{ IOException -> 0x0025, all -> 0x0020 }
        r1 = TYPES_THAT_USE_POOL;	 Catch:{ IOException -> 0x0025, all -> 0x0020 }
        r0 = r1.contains(r0);	 Catch:{ IOException -> 0x0025, all -> 0x0020 }
        r2.reset();	 Catch:{ IOException -> 0x001f }
    L_0x001f:
        return r0;
    L_0x0020:
        r0 = move-exception;
        r2.reset();	 Catch:{ IOException -> 0x0024 }
    L_0x0024:
        throw r0;
    L_0x0025:
        r2.reset();	 Catch:{ IOException -> 0x0028 }
    L_0x0028:
        r2 = 0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.shouldUsePool(java.io.InputStream):boolean");
    }

    private static android.graphics.Bitmap.Config getConfig(java.io.InputStream r3, com.bumptech.glide.load.DecodeFormat r4) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = com.bumptech.glide.load.DecodeFormat.ALWAYS_ARGB_8888;
        if (r4 == r0) goto L_0x0047;
    L_0x0004:
        r0 = com.bumptech.glide.load.DecodeFormat.PREFER_ARGB_8888;
        if (r4 == r0) goto L_0x0047;
    L_0x0008:
        r0 = android.os.Build.VERSION.SDK_INT;
        r1 = 16;
        if (r0 != r1) goto L_0x000f;
    L_0x000e:
        goto L_0x0047;
    L_0x000f:
        r0 = 0;
        r1 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r3.mark(r1);
        r1 = new com.bumptech.glide.load.resource.bitmap.ImageHeaderParser;	 Catch:{ IOException -> 0x0025 }
        r1.<init>(r3);	 Catch:{ IOException -> 0x0025 }
        r1 = r1.hasAlpha();	 Catch:{ IOException -> 0x0025 }
        r3.reset();	 Catch:{ IOException -> 0x0021 }
    L_0x0021:
        r0 = r1;
        goto L_0x003b;
    L_0x0023:
        r4 = move-exception;
        goto L_0x0043;
    L_0x0025:
        r1 = "Downsampler";	 Catch:{ all -> 0x0023 }
        r2 = 5;	 Catch:{ all -> 0x0023 }
        r1 = android.util.Log.isLoggable(r1, r2);	 Catch:{ all -> 0x0023 }
        if (r1 == 0) goto L_0x0038;	 Catch:{ all -> 0x0023 }
    L_0x002e:
        r1 = new java.lang.StringBuilder;	 Catch:{ all -> 0x0023 }
        r2 = "Cannot determine whether the image has alpha or not from header for format ";	 Catch:{ all -> 0x0023 }
        r1.<init>(r2);	 Catch:{ all -> 0x0023 }
        r1.append(r4);	 Catch:{ all -> 0x0023 }
    L_0x0038:
        r3.reset();	 Catch:{ IOException -> 0x003b }
    L_0x003b:
        if (r0 == 0) goto L_0x0040;
    L_0x003d:
        r3 = android.graphics.Bitmap.Config.ARGB_8888;
        return r3;
    L_0x0040:
        r3 = android.graphics.Bitmap.Config.RGB_565;
        return r3;
    L_0x0043:
        r3.reset();	 Catch:{ IOException -> 0x0046 }
    L_0x0046:
        throw r4;
    L_0x0047:
        r3 = android.graphics.Bitmap.Config.ARGB_8888;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.getConfig(java.io.InputStream, com.bumptech.glide.load.DecodeFormat):android.graphics.Bitmap$Config");
    }

    public int[] getDimensions(MarkEnforcingInputStream markEnforcingInputStream, RecyclableBufferedInputStream recyclableBufferedInputStream, Options options) {
        options.inJustDecodeBounds = true;
        decodeStream(markEnforcingInputStream, recyclableBufferedInputStream, options);
        options.inJustDecodeBounds = false;
        return new int[]{options.outWidth, options.outHeight};
    }

    private static android.graphics.Bitmap decodeStream(com.bumptech.glide.util.MarkEnforcingInputStream r1, com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream r2, android.graphics.BitmapFactory.Options r3) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
*/
        /*
        r0 = r3.inJustDecodeBounds;
        if (r0 == 0) goto L_0x000a;
    L_0x0004:
        r2 = 5242880; // 0x500000 float:7.34684E-39 double:2.590327E-317;
        r1.mark(r2);
        goto L_0x000d;
    L_0x000a:
        r2.fixMarkLimit();
    L_0x000d:
        r2 = 0;
        r2 = android.graphics.BitmapFactory.decodeStream(r1, r2, r3);
        r0 = r3.inJustDecodeBounds;	 Catch:{ IOException -> 0x001a }
        if (r0 == 0) goto L_0x0039;	 Catch:{ IOException -> 0x001a }
    L_0x0016:
        r1.reset();	 Catch:{ IOException -> 0x001a }
        goto L_0x0039;
    L_0x001a:
        r1 = "Downsampler";
        r0 = 6;
        r1 = android.util.Log.isLoggable(r1, r0);
        if (r1 == 0) goto L_0x0039;
    L_0x0023:
        r1 = new java.lang.StringBuilder;
        r0 = "Exception loading inDecodeBounds=";
        r1.<init>(r0);
        r0 = r3.inJustDecodeBounds;
        r1.append(r0);
        r0 = " sample=";
        r1.append(r0);
        r3 = r3.inSampleSize;
        r1.append(r3);
    L_0x0039:
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.Downsampler.decodeStream(com.bumptech.glide.util.MarkEnforcingInputStream, com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream, android.graphics.BitmapFactory$Options):android.graphics.Bitmap");
    }

    @TargetApi(11)
    private static void setInBitmap(Options options, Bitmap bitmap) {
        if (11 <= VERSION.SDK_INT) {
            options.inBitmap = bitmap;
        }
    }

    @TargetApi(11)
    private static synchronized Options getDefaultOptions() {
        Options options;
        synchronized (Downsampler.class) {
            synchronized (OPTIONS_QUEUE) {
                options = (Options) OPTIONS_QUEUE.poll();
            }
            if (options == null) {
                options = new Options();
                resetOptions(options);
            }
        }
        return options;
    }

    private static void releaseOptions(Options options) {
        resetOptions(options);
        synchronized (OPTIONS_QUEUE) {
            OPTIONS_QUEUE.offer(options);
        }
    }

    @TargetApi(11)
    private static void resetOptions(Options options) {
        options.inTempStorage = null;
        options.inDither = false;
        options.inScaled = false;
        options.inSampleSize = 1;
        options.inPreferredConfig = null;
        options.inJustDecodeBounds = false;
        options.outWidth = 0;
        options.outHeight = 0;
        options.outMimeType = null;
        if (11 <= VERSION.SDK_INT) {
            options.inBitmap = null;
            options.inMutable = true;
        }
    }
}
