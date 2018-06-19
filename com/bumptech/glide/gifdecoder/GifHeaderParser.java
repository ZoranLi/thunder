package com.bumptech.glide.gifdecoder;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class GifHeaderParser {
    static final int DEFAULT_FRAME_DELAY = 10;
    private static final int MAX_BLOCK_SIZE = 256;
    static final int MIN_FRAME_DELAY = 3;
    public static final String TAG = "GifHeaderParser";
    private final byte[] block = new byte[256];
    private int blockSize = 0;
    private GifHeader header;
    private ByteBuffer rawData;

    public GifHeaderParser setData(byte[] bArr) {
        reset();
        if (bArr != null) {
            this.rawData = ByteBuffer.wrap(bArr);
            this.rawData.rewind();
            this.rawData.order(ByteOrder.LITTLE_ENDIAN);
        } else {
            this.rawData = null;
            this.header.status = 2;
        }
        return this;
    }

    public void clear() {
        this.rawData = null;
        this.header = null;
    }

    private void reset() {
        this.rawData = null;
        Arrays.fill(this.block, (byte) 0);
        this.header = new GifHeader();
        this.blockSize = 0;
    }

    public GifHeader parseHeader() {
        if (this.rawData == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        } else if (err()) {
            return this.header;
        } else {
            readHeader();
            if (!err()) {
                readContents();
                if (this.header.frameCount < 0) {
                    this.header.status = 1;
                }
            }
            return this.header;
        }
    }

    private void readContents() {
        int i = 0;
        while (i == 0 && !err()) {
            int read = read();
            if (read == 33) {
                read = read();
                if (read == 1) {
                    skip();
                } else if (read != 249) {
                    switch (read) {
                        case 254:
                            skip();
                            break;
                        case 255:
                            readBlock();
                            String str = "";
                            for (read = 0; read < 11; read++) {
                                StringBuilder stringBuilder = new StringBuilder();
                                stringBuilder.append(str);
                                stringBuilder.append((char) this.block[read]);
                                str = stringBuilder.toString();
                            }
                            if (!str.equals("NETSCAPE2.0")) {
                                skip();
                                break;
                            } else {
                                readNetscapeExt();
                                break;
                            }
                        default:
                            skip();
                            break;
                    }
                } else {
                    this.header.currentFrame = new GifFrame();
                    readGraphicControlExt();
                }
            } else if (read == 44) {
                if (this.header.currentFrame == null) {
                    this.header.currentFrame = new GifFrame();
                }
                readBitmap();
            } else if (read != 59) {
                this.header.status = 1;
            } else {
                i = 1;
            }
        }
    }

    private void readGraphicControlExt() {
        read();
        int read = read();
        this.header.currentFrame.dispose = (read & 28) >> 2;
        boolean z = true;
        if (this.header.currentFrame.dispose == 0) {
            this.header.currentFrame.dispose = 1;
        }
        GifFrame gifFrame = this.header.currentFrame;
        if ((read & 1) == 0) {
            z = false;
        }
        gifFrame.transparency = z;
        read = readShort();
        if (read < 3) {
            read = 10;
        }
        this.header.currentFrame.delay = read * 10;
        this.header.currentFrame.transIndex = read();
        read();
    }

    private void readBitmap() {
        this.header.currentFrame.ix = readShort();
        this.header.currentFrame.iy = readShort();
        this.header.currentFrame.iw = readShort();
        this.header.currentFrame.ih = readShort();
        int read = read();
        boolean z = false;
        int i = (read & 128) != 0 ? 1 : false;
        int pow = (int) Math.pow(2.0d, (double) ((read & 7) + 1));
        GifFrame gifFrame = this.header.currentFrame;
        if ((read & 64) != 0) {
            z = true;
        }
        gifFrame.interlace = z;
        if (i != 0) {
            this.header.currentFrame.lct = readColorTable(pow);
        } else {
            this.header.currentFrame.lct = null;
        }
        this.header.currentFrame.bufferFrameStart = this.rawData.position();
        skipImageData();
        if (!err()) {
            GifHeader gifHeader = this.header;
            gifHeader.frameCount++;
            this.header.frames.add(this.header.currentFrame);
        }
    }

    private void readNetscapeExt() {
        do {
            readBlock();
            if (this.block[0] == (byte) 1) {
                this.header.loopCount = (this.block[1] & 255) | ((this.block[2] & 255) << 8);
            }
            if (this.blockSize <= 0) {
                return;
            }
        } while (!err());
    }

    private void readHeader() {
        String str = "";
        for (int i = 0; i < 6; i++) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append((char) read());
            str = stringBuilder.toString();
        }
        if (str.startsWith("GIF")) {
            readLSD();
            if (this.header.gctFlag && !err()) {
                this.header.gct = readColorTable(this.header.gctSize);
                this.header.bgColor = this.header.gct[this.header.bgIndex];
            }
            return;
        }
        this.header.status = 1;
    }

    private void readLSD() {
        this.header.width = readShort();
        this.header.height = readShort();
        int read = read();
        this.header.gctFlag = (read & 128) != 0;
        this.header.gctSize = 2 << (read & 7);
        this.header.bgIndex = read();
        this.header.pixelAspect = read();
    }

    private int[] readColorTable(int r10) {
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r9 = this;
        r0 = 3;
        r0 = r0 * r10;
        r0 = new byte[r0];
        r1 = r9.rawData;	 Catch:{ BufferUnderflowException -> 0x0033 }
        r1.get(r0);	 Catch:{ BufferUnderflowException -> 0x0033 }
        r1 = 256; // 0x100 float:3.59E-43 double:1.265E-321;	 Catch:{ BufferUnderflowException -> 0x0033 }
        r1 = new int[r1];	 Catch:{ BufferUnderflowException -> 0x0033 }
        r2 = 0;
        r3 = r2;
    L_0x000f:
        if (r2 >= r10) goto L_0x003a;
    L_0x0011:
        r4 = r3 + 1;
        r3 = r0[r3];	 Catch:{ BufferUnderflowException -> 0x0035 }
        r3 = r3 & 255;	 Catch:{ BufferUnderflowException -> 0x0035 }
        r5 = r4 + 1;	 Catch:{ BufferUnderflowException -> 0x0035 }
        r4 = r0[r4];	 Catch:{ BufferUnderflowException -> 0x0035 }
        r4 = r4 & 255;	 Catch:{ BufferUnderflowException -> 0x0035 }
        r6 = r5 + 1;	 Catch:{ BufferUnderflowException -> 0x0035 }
        r5 = r0[r5];	 Catch:{ BufferUnderflowException -> 0x0035 }
        r5 = r5 & 255;	 Catch:{ BufferUnderflowException -> 0x0035 }
        r7 = r2 + 1;	 Catch:{ BufferUnderflowException -> 0x0035 }
        r8 = -16777216; // 0xffffffffff000000 float:-1.7014118E38 double:NaN;	 Catch:{ BufferUnderflowException -> 0x0035 }
        r3 = r3 << 16;	 Catch:{ BufferUnderflowException -> 0x0035 }
        r3 = r3 | r8;	 Catch:{ BufferUnderflowException -> 0x0035 }
        r4 = r4 << 8;	 Catch:{ BufferUnderflowException -> 0x0035 }
        r3 = r3 | r4;	 Catch:{ BufferUnderflowException -> 0x0035 }
        r3 = r3 | r5;	 Catch:{ BufferUnderflowException -> 0x0035 }
        r1[r2] = r3;	 Catch:{ BufferUnderflowException -> 0x0035 }
        r3 = r6;
        r2 = r7;
        goto L_0x000f;
    L_0x0033:
        r10 = 0;
        r1 = r10;
    L_0x0035:
        r10 = r9.header;
        r0 = 1;
        r10.status = r0;
    L_0x003a:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.GifHeaderParser.readColorTable(int):int[]");
    }

    private void skipImageData() {
        read();
        skip();
    }

    private void skip() {
        int read;
        do {
            read = read();
            this.rawData.position(this.rawData.position() + read);
        } while (read > 0);
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r4 = this;
        r0 = r4.read();
        r4.blockSize = r0;
        r0 = r4.blockSize;
        r1 = 0;
        if (r0 <= 0) goto L_0x0047;
    L_0x000b:
        r0 = r1;
    L_0x000c:
        r2 = r4.blockSize;	 Catch:{ Exception -> 0x001d }
        if (r1 >= r2) goto L_0x0047;	 Catch:{ Exception -> 0x001d }
    L_0x0010:
        r2 = r4.blockSize;	 Catch:{ Exception -> 0x001d }
        r0 = r2 - r1;	 Catch:{ Exception -> 0x001d }
        r2 = r4.rawData;	 Catch:{ Exception -> 0x001d }
        r3 = r4.block;	 Catch:{ Exception -> 0x001d }
        r2.get(r3, r1, r0);	 Catch:{ Exception -> 0x001d }
        r1 = r1 + r0;
        goto L_0x000c;
    L_0x001d:
        r2 = "GifHeaderParser";
        r3 = 3;
        r2 = android.util.Log.isLoggable(r2, r3);
        if (r2 == 0) goto L_0x0042;
    L_0x0026:
        r2 = new java.lang.StringBuilder;
        r3 = "Error Reading Block n: ";
        r2.<init>(r3);
        r2.append(r1);
        r3 = " count: ";
        r2.append(r3);
        r2.append(r0);
        r0 = " blockSize: ";
        r2.append(r0);
        r0 = r4.blockSize;
        r2.append(r0);
    L_0x0042:
        r0 = r4.header;
        r2 = 1;
        r0.status = r2;
    L_0x0047:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.GifHeaderParser.readBlock():int");
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
	at jadx.core.ProcessClass.processDependencies(ProcessClass.java:59)
	at jadx.core.ProcessClass.process(ProcessClass.java:42)
	at jadx.api.JadxDecompiler.processClass(JadxDecompiler.java:306)
	at jadx.api.JavaClass.decompile(JavaClass.java:62)
*/
        /*
        r2 = this;
        r0 = r2.rawData;	 Catch:{ Exception -> 0x0009 }
        r0 = r0.get();	 Catch:{ Exception -> 0x0009 }
        r0 = r0 & 255;
        goto L_0x000f;
    L_0x0009:
        r0 = r2.header;
        r1 = 1;
        r0.status = r1;
        r0 = 0;
    L_0x000f:
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.gifdecoder.GifHeaderParser.read():int");
    }

    private int readShort() {
        return this.rawData.getShort();
    }

    private boolean err() {
        return this.header.status != 0;
    }
}
