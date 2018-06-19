package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ContentLengthInputStream extends FilterInputStream {
    private static final String TAG = "ContentLengthStream";
    private static final int UNKNOWN = -1;
    private final long contentLength;
    private int readSoFar;

    public static InputStream obtain(InputStream inputStream, String str) {
        return obtain(inputStream, (long) parseContentLength(str));
    }

    public static InputStream obtain(InputStream inputStream, long j) {
        return new ContentLengthInputStream(inputStream, j);
    }

    private static int parseContentLength(java.lang.String r1) {
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
        r0 = android.text.TextUtils.isEmpty(r1);
        if (r0 != 0) goto L_0x000b;
    L_0x0006:
        r1 = java.lang.Integer.parseInt(r1);	 Catch:{ NumberFormatException -> 0x000b }
        goto L_0x000c;
    L_0x000b:
        r1 = -1;
    L_0x000c:
        return r1;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.util.ContentLengthInputStream.parseContentLength(java.lang.String):int");
    }

    ContentLengthInputStream(InputStream inputStream, long j) {
        super(inputStream);
        this.contentLength = j;
    }

    public final synchronized int available() throws IOException {
        return (int) Math.max(this.contentLength - ((long) this.readSoFar), (long) this.in.available());
    }

    public final synchronized int read() throws IOException {
        return checkReadSoFarOrThrow(super.read());
    }

    public final int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public final synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        return checkReadSoFarOrThrow(super.read(bArr, i, i2));
    }

    private int checkReadSoFarOrThrow(int i) throws IOException {
        if (i >= 0) {
            this.readSoFar += i;
        } else if (this.contentLength - ((long) this.readSoFar) > 0) {
            StringBuilder stringBuilder = new StringBuilder("Failed to read all expected data, expected: ");
            stringBuilder.append(this.contentLength);
            stringBuilder.append(", but read: ");
            stringBuilder.append(this.readSoFar);
            throw new IOException(stringBuilder.toString());
        }
        return i;
    }
}
