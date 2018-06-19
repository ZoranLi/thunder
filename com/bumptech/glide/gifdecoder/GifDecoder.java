package com.bumptech.glide.gifdecoder;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Build.VERSION;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class GifDecoder {
    private static final Config BITMAP_CONFIG = Config.ARGB_8888;
    private static final int DISPOSAL_BACKGROUND = 2;
    private static final int DISPOSAL_NONE = 1;
    private static final int DISPOSAL_PREVIOUS = 3;
    private static final int DISPOSAL_UNSPECIFIED = 0;
    private static final int INITIAL_FRAME_POINTER = -1;
    private static final int MAX_STACK_SIZE = 4096;
    private static final int NULL_CODE = -1;
    public static final int STATUS_FORMAT_ERROR = 1;
    public static final int STATUS_OK = 0;
    public static final int STATUS_OPEN_ERROR = 2;
    public static final int STATUS_PARTIAL_DECODE = 3;
    private static final String TAG = "GifDecoder";
    public static final int TOTAL_ITERATION_COUNT_FOREVER = 0;
    private int[] act;
    private BitmapProvider bitmapProvider;
    private final byte[] block = new byte[256];
    private byte[] data;
    private int framePointer;
    private GifHeader header;
    private byte[] mainPixels;
    private int[] mainScratch;
    private GifHeaderParser parser;
    private final int[] pct = new int[256];
    private byte[] pixelStack;
    private short[] prefix;
    private Bitmap previousImage;
    private ByteBuffer rawData;
    private boolean savePrevious;
    private int status;
    private byte[] suffix;

    public interface BitmapProvider {
        Bitmap obtain(int i, int i2, Config config);

        void release(Bitmap bitmap);
    }

    public GifDecoder(BitmapProvider bitmapProvider) {
        this.bitmapProvider = bitmapProvider;
        this.header = new GifHeader();
    }

    public int getWidth() {
        return this.header.width;
    }

    public int getHeight() {
        return this.header.height;
    }

    public byte[] getData() {
        return this.data;
    }

    public int getStatus() {
        return this.status;
    }

    public void advance() {
        this.framePointer = (this.framePointer + 1) % this.header.frameCount;
    }

    public int getDelay(int i) {
        return (i < 0 || i >= this.header.frameCount) ? -1 : ((GifFrame) this.header.frames.get(i)).delay;
    }

    public int getNextDelay() {
        if (this.header.frameCount > 0) {
            if (this.framePointer >= 0) {
                return getDelay(this.framePointer);
            }
        }
        return -1;
    }

    public int getFrameCount() {
        return this.header.frameCount;
    }

    public int getCurrentFrameIndex() {
        return this.framePointer;
    }

    public void resetFrameIndex() {
        this.framePointer = -1;
    }

    @Deprecated
    public int getLoopCount() {
        if (this.header.loopCount == -1) {
            return 1;
        }
        return this.header.loopCount;
    }

    public int getNetscapeLoopCount() {
        return this.header.loopCount;
    }

    public int getTotalIterationCount() {
        if (this.header.loopCount == -1) {
            return 1;
        }
        if (this.header.loopCount == 0) {
            return 0;
        }
        return this.header.loopCount + 1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized android.graphics.Bitmap getNextFrame() {
        /*
        r6 = this;
        monitor-enter(r6);
        r0 = r6.header;	 Catch:{ all -> 0x00a3 }
        r0 = r0.frameCount;	 Catch:{ all -> 0x00a3 }
        r1 = 3;
        r2 = 1;
        if (r0 <= 0) goto L_0x000d;
    L_0x0009:
        r0 = r6.framePointer;	 Catch:{ all -> 0x00a3 }
        if (r0 >= 0) goto L_0x002f;
    L_0x000d:
        r0 = TAG;	 Catch:{ all -> 0x00a3 }
        r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ all -> 0x00a3 }
        if (r0 == 0) goto L_0x002d;
    L_0x0015:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00a3 }
        r3 = "unable to decode frame, frameCount=";
        r0.<init>(r3);	 Catch:{ all -> 0x00a3 }
        r3 = r6.header;	 Catch:{ all -> 0x00a3 }
        r3 = r3.frameCount;	 Catch:{ all -> 0x00a3 }
        r0.append(r3);	 Catch:{ all -> 0x00a3 }
        r3 = " framePointer=";
        r0.append(r3);	 Catch:{ all -> 0x00a3 }
        r3 = r6.framePointer;	 Catch:{ all -> 0x00a3 }
        r0.append(r3);	 Catch:{ all -> 0x00a3 }
    L_0x002d:
        r6.status = r2;	 Catch:{ all -> 0x00a3 }
    L_0x002f:
        r0 = r6.status;	 Catch:{ all -> 0x00a3 }
        r3 = 0;
        if (r0 == r2) goto L_0x008d;
    L_0x0034:
        r0 = r6.status;	 Catch:{ all -> 0x00a3 }
        r4 = 2;
        if (r0 != r4) goto L_0x003a;
    L_0x0039:
        goto L_0x008d;
    L_0x003a:
        r0 = 0;
        r6.status = r0;	 Catch:{ all -> 0x00a3 }
        r1 = r6.header;	 Catch:{ all -> 0x00a3 }
        r1 = r1.frames;	 Catch:{ all -> 0x00a3 }
        r4 = r6.framePointer;	 Catch:{ all -> 0x00a3 }
        r1 = r1.get(r4);	 Catch:{ all -> 0x00a3 }
        r1 = (com.bumptech.glide.gifdecoder.GifFrame) r1;	 Catch:{ all -> 0x00a3 }
        r4 = r6.framePointer;	 Catch:{ all -> 0x00a3 }
        r4 = r4 - r2;
        if (r4 < 0) goto L_0x0059;
    L_0x004e:
        r5 = r6.header;	 Catch:{ all -> 0x00a3 }
        r5 = r5.frames;	 Catch:{ all -> 0x00a3 }
        r4 = r5.get(r4);	 Catch:{ all -> 0x00a3 }
        r4 = (com.bumptech.glide.gifdecoder.GifFrame) r4;	 Catch:{ all -> 0x00a3 }
        goto L_0x005a;
    L_0x0059:
        r4 = r3;
    L_0x005a:
        r5 = r1.lct;	 Catch:{ all -> 0x00a3 }
        if (r5 == 0) goto L_0x0061;
    L_0x005e:
        r5 = r1.lct;	 Catch:{ all -> 0x00a3 }
        goto L_0x0065;
    L_0x0061:
        r5 = r6.header;	 Catch:{ all -> 0x00a3 }
        r5 = r5.gct;	 Catch:{ all -> 0x00a3 }
    L_0x0065:
        r6.act = r5;	 Catch:{ all -> 0x00a3 }
        r5 = r6.act;	 Catch:{ all -> 0x00a3 }
        if (r5 != 0) goto L_0x006f;
    L_0x006b:
        r6.status = r2;	 Catch:{ all -> 0x00a3 }
        monitor-exit(r6);
        return r3;
    L_0x006f:
        r2 = r1.transparency;	 Catch:{ all -> 0x00a3 }
        if (r2 == 0) goto L_0x0087;
    L_0x0073:
        r2 = r6.act;	 Catch:{ all -> 0x00a3 }
        r3 = r6.pct;	 Catch:{ all -> 0x00a3 }
        r5 = r6.act;	 Catch:{ all -> 0x00a3 }
        r5 = r5.length;	 Catch:{ all -> 0x00a3 }
        java.lang.System.arraycopy(r2, r0, r3, r0, r5);	 Catch:{ all -> 0x00a3 }
        r2 = r6.pct;	 Catch:{ all -> 0x00a3 }
        r6.act = r2;	 Catch:{ all -> 0x00a3 }
        r2 = r6.act;	 Catch:{ all -> 0x00a3 }
        r3 = r1.transIndex;	 Catch:{ all -> 0x00a3 }
        r2[r3] = r0;	 Catch:{ all -> 0x00a3 }
    L_0x0087:
        r0 = r6.setPixels(r1, r4);	 Catch:{ all -> 0x00a3 }
        monitor-exit(r6);
        return r0;
    L_0x008d:
        r0 = TAG;	 Catch:{ all -> 0x00a3 }
        r0 = android.util.Log.isLoggable(r0, r1);	 Catch:{ all -> 0x00a3 }
        if (r0 == 0) goto L_0x00a1;
    L_0x0095:
        r0 = new java.lang.StringBuilder;	 Catch:{ all -> 0x00a3 }
        r1 = "Unable to decode frame, status=";
        r0.<init>(r1);	 Catch:{ all -> 0x00a3 }
        r1 = r6.status;	 Catch:{ all -> 0x00a3 }
        r0.append(r1);	 Catch:{ all -> 0x00a3 }
    L_0x00a1:
        monitor-exit(r6);
        return r3;
    L_0x00a3:
        r0 = move-exception;
        monitor-exit(r6);
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.GifDecoder.getNextFrame():android.graphics.Bitmap");
    }

    public int read(java.io.InputStream r6, int r7) {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r5 = this;
        if (r6 == 0) goto L_0x0028;
    L_0x0002:
        r0 = 16384; // 0x4000 float:2.2959E-41 double:8.0948E-320;
        if (r7 <= 0) goto L_0x0009;
    L_0x0006:
        r7 = r7 + 4096;
        goto L_0x000a;
    L_0x0009:
        r7 = r0;
    L_0x000a:
        r1 = new java.io.ByteArrayOutputStream;	 Catch:{ IOException -> 0x002b }
        r1.<init>(r7);	 Catch:{ IOException -> 0x002b }
        r7 = new byte[r0];	 Catch:{ IOException -> 0x002b }
    L_0x0011:
        r2 = 0;	 Catch:{ IOException -> 0x002b }
        r3 = r6.read(r7, r2, r0);	 Catch:{ IOException -> 0x002b }
        r4 = -1;	 Catch:{ IOException -> 0x002b }
        if (r3 == r4) goto L_0x001d;	 Catch:{ IOException -> 0x002b }
    L_0x0019:
        r1.write(r7, r2, r3);	 Catch:{ IOException -> 0x002b }
        goto L_0x0011;	 Catch:{ IOException -> 0x002b }
    L_0x001d:
        r1.flush();	 Catch:{ IOException -> 0x002b }
        r7 = r1.toByteArray();	 Catch:{ IOException -> 0x002b }
        r5.read(r7);	 Catch:{ IOException -> 0x002b }
        goto L_0x002b;
    L_0x0028:
        r7 = 2;
        r5.status = r7;
    L_0x002b:
        if (r6 == 0) goto L_0x0030;
    L_0x002d:
        r6.close();	 Catch:{ IOException -> 0x0030 }
    L_0x0030:
        r6 = r5.status;
        return r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.GifDecoder.read(java.io.InputStream, int):int");
    }

    public void clear() {
        this.header = null;
        this.data = null;
        this.mainPixels = null;
        this.mainScratch = null;
        if (this.previousImage != null) {
            this.bitmapProvider.release(this.previousImage);
        }
        this.previousImage = null;
        this.rawData = null;
    }

    public void setData(GifHeader gifHeader, byte[] bArr) {
        this.header = gifHeader;
        this.data = bArr;
        this.status = 0;
        this.framePointer = -1;
        this.rawData = ByteBuffer.wrap(bArr);
        this.rawData.rewind();
        this.rawData.order(ByteOrder.LITTLE_ENDIAN);
        this.savePrevious = false;
        for (GifFrame gifFrame : gifHeader.frames) {
            if (gifFrame.dispose == 3) {
                this.savePrevious = 1;
                break;
            }
        }
        this.mainPixels = new byte[(gifHeader.width * gifHeader.height)];
        this.mainScratch = new int[(gifHeader.width * gifHeader.height)];
    }

    private GifHeaderParser getHeaderParser() {
        if (this.parser == null) {
            this.parser = new GifHeaderParser();
        }
        return this.parser;
    }

    public int read(byte[] bArr) {
        this.data = bArr;
        this.header = getHeaderParser().setData(bArr).parseHeader();
        if (bArr != null) {
            this.rawData = ByteBuffer.wrap(bArr);
            this.rawData.rewind();
            this.rawData.order(ByteOrder.LITTLE_ENDIAN);
            this.mainPixels = new byte[(this.header.width * this.header.height)];
            this.mainScratch = new int[(this.header.width * this.header.height)];
            this.savePrevious = null;
            for (GifFrame gifFrame : this.header.frames) {
                if (gifFrame.dispose == 3) {
                    this.savePrevious = 1;
                    break;
                }
            }
        }
        return this.status;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.Bitmap setPixels(com.bumptech.glide.gifdecoder.GifFrame r14, com.bumptech.glide.gifdecoder.GifFrame r15) {
        /*
        r13 = this;
        r0 = r13.header;
        r0 = r0.width;
        r1 = r13.header;
        r9 = r1.height;
        r10 = r13.mainScratch;
        r11 = 0;
        if (r15 != 0) goto L_0x0010;
    L_0x000d:
        java.util.Arrays.fill(r10, r11);
    L_0x0010:
        r12 = 2;
        if (r15 == 0) goto L_0x005e;
    L_0x0013:
        r1 = r15.dispose;
        if (r1 <= 0) goto L_0x005e;
    L_0x0017:
        r1 = r15.dispose;
        if (r1 != r12) goto L_0x0049;
    L_0x001b:
        r1 = r14.transparency;
        if (r1 != 0) goto L_0x002f;
    L_0x001f:
        r1 = r13.header;
        r1 = r1.bgColor;
        r2 = r14.lct;
        if (r2 == 0) goto L_0x0030;
    L_0x0027:
        r2 = r13.header;
        r2 = r2.bgIndex;
        r3 = r14.transIndex;
        if (r2 != r3) goto L_0x0030;
    L_0x002f:
        r1 = r11;
    L_0x0030:
        r2 = r15.iy;
        r2 = r2 * r0;
        r3 = r15.ix;
        r2 = r2 + r3;
        r3 = r15.ih;
        r3 = r3 * r0;
        r3 = r3 + r2;
    L_0x003a:
        if (r2 >= r3) goto L_0x005e;
    L_0x003c:
        r4 = r15.iw;
        r4 = r4 + r2;
        r5 = r2;
    L_0x0040:
        if (r5 >= r4) goto L_0x0047;
    L_0x0042:
        r10[r5] = r1;
        r5 = r5 + 1;
        goto L_0x0040;
    L_0x0047:
        r2 = r2 + r0;
        goto L_0x003a;
    L_0x0049:
        r15 = r15.dispose;
        r1 = 3;
        if (r15 != r1) goto L_0x005e;
    L_0x004e:
        r15 = r13.previousImage;
        if (r15 == 0) goto L_0x005e;
    L_0x0052:
        r1 = r13.previousImage;
        r3 = 0;
        r5 = 0;
        r6 = 0;
        r2 = r10;
        r4 = r0;
        r7 = r0;
        r8 = r9;
        r1.getPixels(r2, r3, r4, r5, r6, r7, r8);
    L_0x005e:
        r13.decodeBitmapData(r14);
        r15 = 8;
        r1 = 1;
        r3 = r15;
        r2 = r1;
        r15 = r11;
    L_0x0067:
        r4 = r14.ih;
        if (r11 >= r4) goto L_0x00c3;
    L_0x006b:
        r4 = r14.interlace;
        if (r4 == 0) goto L_0x0084;
    L_0x006f:
        r4 = r14.ih;
        r5 = 4;
        if (r15 < r4) goto L_0x0081;
    L_0x0074:
        r2 = r2 + 1;
        switch(r2) {
            case 2: goto L_0x0080;
            case 3: goto L_0x007d;
            case 4: goto L_0x007a;
            default: goto L_0x0079;
        };
    L_0x0079:
        goto L_0x0081;
    L_0x007a:
        r15 = r1;
        r3 = r12;
        goto L_0x0081;
    L_0x007d:
        r3 = r5;
        r15 = r12;
        goto L_0x0081;
    L_0x0080:
        r15 = r5;
    L_0x0081:
        r4 = r15 + r3;
        goto L_0x0086;
    L_0x0084:
        r4 = r15;
        r15 = r11;
    L_0x0086:
        r5 = r14.iy;
        r15 = r15 + r5;
        r5 = r13.header;
        r5 = r5.height;
        if (r15 >= r5) goto L_0x00bf;
    L_0x008f:
        r5 = r13.header;
        r5 = r5.width;
        r15 = r15 * r5;
        r5 = r14.ix;
        r5 = r5 + r15;
        r6 = r14.iw;
        r6 = r6 + r5;
        r7 = r13.header;
        r7 = r7.width;
        r7 = r7 + r15;
        if (r7 >= r6) goto L_0x00a6;
    L_0x00a1:
        r6 = r13.header;
        r6 = r6.width;
        r6 = r6 + r15;
    L_0x00a6:
        r15 = r14.iw;
        r15 = r15 * r11;
    L_0x00a9:
        if (r5 >= r6) goto L_0x00bf;
    L_0x00ab:
        r7 = r13.mainPixels;
        r8 = r15 + 1;
        r15 = r7[r15];
        r15 = r15 & 255;
        r7 = r13.act;
        r15 = r7[r15];
        if (r15 == 0) goto L_0x00bb;
    L_0x00b9:
        r10[r5] = r15;
    L_0x00bb:
        r5 = r5 + 1;
        r15 = r8;
        goto L_0x00a9;
    L_0x00bf:
        r11 = r11 + 1;
        r15 = r4;
        goto L_0x0067;
    L_0x00c3:
        r15 = r13.savePrevious;
        if (r15 == 0) goto L_0x00e5;
    L_0x00c7:
        r15 = r14.dispose;
        if (r15 == 0) goto L_0x00cf;
    L_0x00cb:
        r14 = r14.dispose;
        if (r14 != r1) goto L_0x00e5;
    L_0x00cf:
        r14 = r13.previousImage;
        if (r14 != 0) goto L_0x00d9;
    L_0x00d3:
        r14 = r13.getNextBitmap();
        r13.previousImage = r14;
    L_0x00d9:
        r1 = r13.previousImage;
        r3 = 0;
        r5 = 0;
        r6 = 0;
        r2 = r10;
        r4 = r0;
        r7 = r0;
        r8 = r9;
        r1.setPixels(r2, r3, r4, r5, r6, r7, r8);
    L_0x00e5:
        r14 = r13.getNextBitmap();
        r3 = 0;
        r5 = 0;
        r6 = 0;
        r1 = r14;
        r2 = r10;
        r4 = r0;
        r7 = r0;
        r8 = r9;
        r1.setPixels(r2, r3, r4, r5, r6, r7, r8);
        return r14;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.GifDecoder.setPixels(com.bumptech.glide.gifdecoder.GifFrame, com.bumptech.glide.gifdecoder.GifFrame):android.graphics.Bitmap");
    }

    private void decodeBitmapData(GifFrame gifFrame) {
        short s;
        int i;
        GifDecoder gifDecoder = this;
        GifFrame gifFrame2 = gifFrame;
        if (gifFrame2 != null) {
            gifDecoder.rawData.position(gifFrame2.bufferFrameStart);
        }
        if (gifFrame2 == null) {
            s = gifDecoder.header.width * gifDecoder.header.height;
        } else {
            s = gifFrame2.ih * gifFrame2.iw;
        }
        if (gifDecoder.mainPixels == null || gifDecoder.mainPixels.length < s) {
            gifDecoder.mainPixels = new byte[s];
        }
        if (gifDecoder.prefix == null) {
            gifDecoder.prefix = new short[4096];
        }
        if (gifDecoder.suffix == null) {
            gifDecoder.suffix = new byte[4096];
        }
        if (gifDecoder.pixelStack == null) {
            gifDecoder.pixelStack = new byte[4097];
        }
        int read = read();
        int i2 = 1;
        int i3 = 1 << read;
        int i4 = i3 + 1;
        int i5 = i3 + 2;
        read++;
        int i6 = (1 << read) - 1;
        for (i = 0; i < i3; i++) {
            gifDecoder.prefix[i] = (short) 0;
            gifDecoder.suffix[i] = (byte) i;
        }
        i = -1;
        int i7 = read;
        int i8 = i5;
        int i9 = i6;
        short s2 = (short) 0;
        int i10 = s2;
        short s3 = i10;
        int i11 = s3;
        int i12 = i11;
        int i13 = i12;
        short s4 = i13;
        int i14 = s4;
        int i15 = -1;
        while (s2 < s) {
            int i16;
            int i17 = 3;
            if (i10 == 0) {
                i10 = readBlock();
                if (i10 <= 0) {
                    gifDecoder.status = 3;
                    break;
                }
                i12 = 0;
            }
            i11 += (gifDecoder.block[i12] & 255) << i13;
            i12 += i2;
            i10 += i;
            int i18 = i13 + 8;
            short s5 = s4;
            i2 = i15;
            s4 = s2;
            short s6 = s3;
            int i19 = i8;
            int i20 = i7;
            while (i18 >= i20) {
                i = i11 & i9;
                i11 >>= i20;
                i18 -= i20;
                if (i != i3) {
                    if (i > i19) {
                        gifDecoder.status = i17;
                    } else if (i != i4) {
                        if (i2 == -1) {
                            i8 = i14 + 1;
                            gifDecoder.pixelStack[i14] = gifDecoder.suffix[i];
                            i2 = i;
                            s5 = i2;
                            i14 = i8;
                        } else {
                            int i21;
                            int i22;
                            if (i >= i19) {
                                i8 = i14 + 1;
                                i21 = read;
                                gifDecoder.pixelStack[i14] = (byte) s5;
                                read = i2;
                                i14 = i8;
                            } else {
                                i21 = read;
                                read = i;
                            }
                            while (read >= i3) {
                                i8 = i14 + 1;
                                i22 = i18;
                                gifDecoder.pixelStack[i14] = gifDecoder.suffix[read];
                                read = gifDecoder.prefix[read];
                                i14 = i8;
                                i18 = i22;
                            }
                            i22 = i18;
                            short s7 = gifDecoder.suffix[read] & 255;
                            i17 = i14 + 1;
                            i16 = i3;
                            byte b = (byte) s7;
                            gifDecoder.pixelStack[i14] = b;
                            if (i19 < 4096) {
                                gifDecoder.prefix[i19] = (short) i2;
                                gifDecoder.suffix[i19] = b;
                                i19++;
                                if ((i19 & i9) == 0) {
                                    if (i19 < 4096) {
                                        i20++;
                                        i9 += i19;
                                    }
                                }
                            }
                            i14 = i17;
                            while (i14 > 0) {
                                i14--;
                                short s8 = s6 + 1;
                                gifDecoder.mainPixels[s6] = gifDecoder.pixelStack[i14];
                                s4++;
                                s6 = s8;
                            }
                            s5 = s7;
                            i2 = i;
                            read = i21;
                            i18 = i22;
                            i3 = i16;
                        }
                        i17 = 3;
                    }
                    i15 = i2;
                    i7 = i20;
                    i8 = i19;
                    s3 = s6;
                    s2 = s4;
                    i13 = i18;
                    i3 = i3;
                    i2 = 1;
                    i = -1;
                    s4 = s5;
                    read = read;
                    break;
                }
                i20 = read;
                i19 = i5;
                i9 = i6;
                i2 = -1;
                i = -1;
            }
            i16 = i3;
            i15 = i2;
            i7 = i20;
            i8 = i19;
            s3 = s6;
            s2 = s4;
            i2 = 1;
            s4 = s5;
            i13 = i18;
            read = read;
        }
        while (s3 < s) {
            gifDecoder.mainPixels[s3] = (byte) 0;
            s3++;
        }
    }

    private int read() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r1 = this;
        r0 = r1.rawData;	 Catch:{ Exception -> 0x0009 }
        r0 = r0.get();	 Catch:{ Exception -> 0x0009 }
        r0 = r0 & 255;
        goto L_0x000d;
    L_0x0009:
        r0 = 1;
        r1.status = r0;
        r0 = 0;
    L_0x000d:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.GifDecoder.read():int");
    }

    private int readBlock() {
        /* JADX: method processing error */
/*
Error: java.lang.NullPointerException
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.searchTryCatchDominators(ProcessTryCatchRegions.java:75)
	at jadx.core.dex.visitors.regions.ProcessTryCatchRegions.process(ProcessTryCatchRegions.java:45)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.postProcessRegions(RegionMakerVisitor.java:63)
	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:58)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:31)
	at jadx.core.dex.visitors.DepthTraversal.visit(DepthTraversal.java:17)
	at jadx.core.ProcessClass.process(ProcessClass.java:37)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r5 = this;
        r0 = r5.read();
        r1 = 0;
        if (r0 <= 0) goto L_0x0017;
    L_0x0007:
        if (r1 >= r0) goto L_0x0017;
    L_0x0009:
        r2 = r0 - r1;
        r3 = r5.rawData;	 Catch:{ Exception -> 0x0014 }
        r4 = r5.block;	 Catch:{ Exception -> 0x0014 }
        r3.get(r4, r1, r2);	 Catch:{ Exception -> 0x0014 }
        r1 = r1 + r2;
        goto L_0x0007;
    L_0x0014:
        r0 = 1;
        r5.status = r0;
    L_0x0017:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.GifDecoder.readBlock():int");
    }

    private Bitmap getNextBitmap() {
        Bitmap obtain = this.bitmapProvider.obtain(this.header.width, this.header.height, BITMAP_CONFIG);
        if (obtain == null) {
            obtain = Bitmap.createBitmap(this.header.width, this.header.height, BITMAP_CONFIG);
        }
        setAlpha(obtain);
        return obtain;
    }

    @TargetApi(12)
    private static void setAlpha(Bitmap bitmap) {
        if (VERSION.SDK_INT >= 12) {
            bitmap.setHasAlpha(true);
        }
    }
}
