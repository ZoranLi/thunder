package com.bumptech.glide.gifencoder;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.Log;
import java.io.IOException;
import java.io.OutputStream;

public class AnimatedGifEncoder {
    private static final double MIN_TRANSPARENT_PERCENTAGE = 4.0d;
    private static final String TAG = "AnimatedGifEncoder";
    private boolean closeStream = false;
    private int colorDepth;
    private byte[] colorTab;
    private int delay = 0;
    private int dispose = -1;
    private boolean firstFrame = true;
    private boolean hasTransparentPixels;
    private int height;
    private Bitmap image;
    private byte[] indexedPixels;
    private OutputStream out;
    private int palSize = 7;
    private byte[] pixels;
    private int repeat = -1;
    private int sample = 10;
    private boolean sizeSet = false;
    private boolean started = false;
    private int transIndex;
    private Integer transparent = null;
    private boolean[] usedEntry = new boolean[256];
    private int width;

    public void setDelay(int i) {
        this.delay = Math.round(((float) i) / 1092616192);
    }

    public void setDispose(int i) {
        if (i >= 0) {
            this.dispose = i;
        }
    }

    public void setRepeat(int i) {
        if (i >= 0) {
            this.repeat = i;
        }
    }

    public void setTransparent(int i) {
        this.transparent = Integer.valueOf(i);
    }

    public boolean addFrame(android.graphics.Bitmap r5) {
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
        r4 = this;
        r0 = 0;
        if (r5 == 0) goto L_0x0045;
    L_0x0003:
        r1 = r4.started;
        if (r1 != 0) goto L_0x0008;
    L_0x0007:
        goto L_0x0045;
    L_0x0008:
        r1 = 1;
        r2 = r4.sizeSet;	 Catch:{ IOException -> 0x0044 }
        if (r2 != 0) goto L_0x0018;	 Catch:{ IOException -> 0x0044 }
    L_0x000d:
        r2 = r5.getWidth();	 Catch:{ IOException -> 0x0044 }
        r3 = r5.getHeight();	 Catch:{ IOException -> 0x0044 }
        r4.setSize(r2, r3);	 Catch:{ IOException -> 0x0044 }
    L_0x0018:
        r4.image = r5;	 Catch:{ IOException -> 0x0044 }
        r4.getImagePixels();	 Catch:{ IOException -> 0x0044 }
        r4.analyzePixels();	 Catch:{ IOException -> 0x0044 }
        r5 = r4.firstFrame;	 Catch:{ IOException -> 0x0044 }
        if (r5 == 0) goto L_0x0031;	 Catch:{ IOException -> 0x0044 }
    L_0x0024:
        r4.writeLSD();	 Catch:{ IOException -> 0x0044 }
        r4.writePalette();	 Catch:{ IOException -> 0x0044 }
        r5 = r4.repeat;	 Catch:{ IOException -> 0x0044 }
        if (r5 < 0) goto L_0x0031;	 Catch:{ IOException -> 0x0044 }
    L_0x002e:
        r4.writeNetscapeExt();	 Catch:{ IOException -> 0x0044 }
    L_0x0031:
        r4.writeGraphicCtrlExt();	 Catch:{ IOException -> 0x0044 }
        r4.writeImageDesc();	 Catch:{ IOException -> 0x0044 }
        r5 = r4.firstFrame;	 Catch:{ IOException -> 0x0044 }
        if (r5 != 0) goto L_0x003e;	 Catch:{ IOException -> 0x0044 }
    L_0x003b:
        r4.writePalette();	 Catch:{ IOException -> 0x0044 }
    L_0x003e:
        r4.writePixels();	 Catch:{ IOException -> 0x0044 }
        r4.firstFrame = r0;	 Catch:{ IOException -> 0x0044 }
        r0 = r1;
    L_0x0044:
        return r0;
    L_0x0045:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifencoder.AnimatedGifEncoder.addFrame(android.graphics.Bitmap):boolean");
    }

    public boolean finish() {
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
        r4 = this;
        r0 = r4.started;
        r1 = 0;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return r1;
    L_0x0006:
        r4.started = r1;
        r0 = 1;
        r2 = r4.out;	 Catch:{ IOException -> 0x0020 }
        r3 = 59;	 Catch:{ IOException -> 0x0020 }
        r2.write(r3);	 Catch:{ IOException -> 0x0020 }
        r2 = r4.out;	 Catch:{ IOException -> 0x0020 }
        r2.flush();	 Catch:{ IOException -> 0x0020 }
        r2 = r4.closeStream;	 Catch:{ IOException -> 0x0020 }
        if (r2 == 0) goto L_0x001e;	 Catch:{ IOException -> 0x0020 }
    L_0x0019:
        r2 = r4.out;	 Catch:{ IOException -> 0x0020 }
        r2.close();	 Catch:{ IOException -> 0x0020 }
    L_0x001e:
        r2 = r0;
        goto L_0x0021;
    L_0x0020:
        r2 = r1;
    L_0x0021:
        r4.transIndex = r1;
        r3 = 0;
        r4.out = r3;
        r4.image = r3;
        r4.pixels = r3;
        r4.indexedPixels = r3;
        r4.colorTab = r3;
        r4.closeStream = r1;
        r4.firstFrame = r0;
        return r2;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifencoder.AnimatedGifEncoder.finish():boolean");
    }

    public void setFrameRate(float f) {
        if (f != 0.0f) {
            this.delay = Math.round(100.0f / f);
        }
    }

    public void setQuality(int i) {
        if (i <= 0) {
            i = 1;
        }
        this.sample = i;
    }

    public void setSize(int i, int i2) {
        if (!this.started || this.firstFrame) {
            this.width = i;
            this.height = i2;
            if (this.width <= 0) {
                this.width = 320;
            }
            if (this.height <= 0) {
                this.height = 240;
            }
            this.sizeSet = true;
        }
    }

    public boolean start(java.io.OutputStream r3) {
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
        r2 = this;
        r0 = 0;
        if (r3 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = 1;
        r2.closeStream = r0;
        r2.out = r3;
        r3 = "GIF89a";	 Catch:{ IOException -> 0x000f }
        r2.writeString(r3);	 Catch:{ IOException -> 0x000f }
        r0 = r1;
    L_0x000f:
        r2.started = r0;
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifencoder.AnimatedGifEncoder.start(java.io.OutputStream):boolean");
    }

    public boolean start(java.lang.String r3) {
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
        r2 = this;
        r0 = new java.io.BufferedOutputStream;	 Catch:{ IOException -> 0x0016 }
        r1 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x0016 }
        r1.<init>(r3);	 Catch:{ IOException -> 0x0016 }
        r0.<init>(r1);	 Catch:{ IOException -> 0x0016 }
        r2.out = r0;	 Catch:{ IOException -> 0x0016 }
        r3 = r2.out;	 Catch:{ IOException -> 0x0016 }
        r3 = r2.start(r3);	 Catch:{ IOException -> 0x0016 }
        r0 = 1;	 Catch:{ IOException -> 0x0016 }
        r2.closeStream = r0;	 Catch:{ IOException -> 0x0016 }
        goto L_0x0017;
    L_0x0016:
        r3 = 0;
    L_0x0017:
        r2.started = r3;
        return r3;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifencoder.AnimatedGifEncoder.start(java.lang.String):boolean");
    }

    private void analyzePixels() {
        int length = this.pixels.length;
        int i = length / 3;
        this.indexedPixels = new byte[i];
        NeuQuant neuQuant = new NeuQuant(this.pixels, length, this.sample);
        this.colorTab = neuQuant.process();
        for (length = 0; length < this.colorTab.length; length += 3) {
            byte b = this.colorTab[length];
            int i2 = length + 2;
            this.colorTab[length] = this.colorTab[i2];
            this.colorTab[i2] = b;
            this.usedEntry[length / 3] = false;
        }
        length = 0;
        int i3 = length;
        while (length < i) {
            int i4 = i3 + 1;
            i2 = i4 + 1;
            int i5 = i2 + 1;
            i3 = neuQuant.map(this.pixels[i3] & 255, this.pixels[i4] & 255, this.pixels[i2] & 255);
            this.usedEntry[i3] = true;
            this.indexedPixels[length] = (byte) i3;
            length++;
            i3 = i5;
        }
        this.pixels = null;
        this.colorDepth = 8;
        this.palSize = 7;
        if (this.transparent != null) {
            this.transIndex = findClosest(this.transparent.intValue());
            return;
        }
        if (this.hasTransparentPixels) {
            this.transIndex = findClosest(0);
        }
    }

    private int findClosest(int i) {
        if (this.colorTab == null) {
            return -1;
        }
        int red = Color.red(i);
        int green = Color.green(i);
        i = Color.blue(i);
        int i2 = 0;
        int length = this.colorTab.length;
        int i3 = 16777216;
        int i4 = 0;
        while (i2 < length) {
            int i5 = i2 + 1;
            i2 = red - (this.colorTab[i2] & 255);
            int i6 = i5 + 1;
            int i7 = green - (this.colorTab[i5] & 255);
            i5 = i - (this.colorTab[i6] & 255);
            i2 = ((i2 * i2) + (i7 * i7)) + (i5 * i5);
            i7 = i6 / 3;
            if (this.usedEntry[i7] && i2 < r5) {
                i3 = i2;
                i4 = i7;
            }
            i2 = i6 + 1;
        }
        return i4;
    }

    private void getImagePixels() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        if (!(width == this.width && height == this.height)) {
            Bitmap createBitmap = Bitmap.createBitmap(this.width, this.height, Config.ARGB_8888);
            new Canvas(createBitmap).drawBitmap(createBitmap, 0.0f, 0.0f, null);
            this.image = createBitmap;
        }
        int[] iArr = new int[(width * height)];
        this.image.getPixels(iArr, 0, width, 0, 0, width, height);
        boolean z = false;
        this.pixels = new byte[(iArr.length * 3)];
        this.hasTransparentPixels = false;
        int length = iArr.length;
        int i = 0;
        int i2 = i;
        int i3 = i2;
        while (i < length) {
            width = iArr[i];
            if (width == 0) {
                i2++;
            }
            int i4 = i3 + 1;
            this.pixels[i3] = (byte) (width & 255);
            height = i4 + 1;
            this.pixels[i4] = (byte) ((width >> 8) & 255);
            i4 = height + 1;
            this.pixels[height] = (byte) ((width >> 16) & 255);
            i++;
            i3 = i4;
        }
        double d = ((double) (100 * i2)) / ((double) length);
        if (d > MIN_TRANSPARENT_PERCENTAGE) {
            z = true;
        }
        this.hasTransparentPixels = z;
        if (Log.isLoggable(TAG, 3)) {
            StringBuilder stringBuilder = new StringBuilder("got pixels for frame with ");
            stringBuilder.append(d);
            stringBuilder.append("% transparent pixels");
        }
    }

    private void writeGraphicCtrlExt() throws IOException {
        int i;
        int i2;
        this.out.write(33);
        this.out.write(249);
        this.out.write(4);
        if (this.transparent != null || this.hasTransparentPixels) {
            i = 1;
            i2 = 2;
        } else {
            i2 = 0;
            i = i2;
        }
        if (this.dispose >= 0) {
            i2 = this.dispose & 7;
        }
        this.out.write((((i2 << 2) | 0) | 0) | i);
        writeShort(this.delay);
        this.out.write(this.transIndex);
        this.out.write(0);
    }

    private void writeImageDesc() throws IOException {
        this.out.write(44);
        writeShort(0);
        writeShort(0);
        writeShort(this.width);
        writeShort(this.height);
        if (this.firstFrame) {
            this.out.write(0);
        } else {
            this.out.write(128 | this.palSize);
        }
    }

    private void writeLSD() throws IOException {
        writeShort(this.width);
        writeShort(this.height);
        this.out.write(this.palSize | 240);
        this.out.write(0);
        this.out.write(0);
    }

    private void writeNetscapeExt() throws IOException {
        this.out.write(33);
        this.out.write(255);
        this.out.write(11);
        writeString("NETSCAPE2.0");
        this.out.write(3);
        this.out.write(1);
        writeShort(this.repeat);
        this.out.write(0);
    }

    private void writePalette() throws IOException {
        this.out.write(this.colorTab, 0, this.colorTab.length);
        int length = 768 - this.colorTab.length;
        for (int i = 0; i < length; i++) {
            this.out.write(0);
        }
    }

    private void writePixels() throws IOException {
        new LZWEncoder(this.width, this.height, this.indexedPixels, this.colorDepth).encode(this.out);
    }

    private void writeShort(int i) throws IOException {
        this.out.write(i & 255);
        this.out.write((i >> 8) & 255);
    }

    private void writeString(String str) throws IOException {
        for (int i = 0; i < str.length(); i++) {
            this.out.write((byte) str.charAt(i));
        }
    }
}
