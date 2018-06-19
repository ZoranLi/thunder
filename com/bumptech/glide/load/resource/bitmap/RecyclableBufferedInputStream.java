package com.bumptech.glide.load.resource.bitmap;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class RecyclableBufferedInputStream extends FilterInputStream {
    private static final String TAG = "BufferedIs";
    private volatile byte[] buf;
    private int count;
    private int marklimit;
    private int markpos = -1;
    private int pos;

    public static class InvalidMarkException extends RuntimeException {
        private static final long serialVersionUID = -4338378848813561757L;

        public InvalidMarkException(String str) {
            super(str);
        }
    }

    public boolean markSupported() {
        return true;
    }

    public RecyclableBufferedInputStream(InputStream inputStream, byte[] bArr) {
        super(inputStream);
        if (bArr != null) {
            if (bArr.length != null) {
                this.buf = bArr;
                return;
            }
        }
        throw new IllegalArgumentException("buffer is null or empty");
    }

    public synchronized int available() throws IOException {
        InputStream inputStream;
        inputStream = this.in;
        if (this.buf != null) {
            if (inputStream != null) {
            }
        }
        throw streamClosed();
        return (this.count - this.pos) + inputStream.available();
    }

    private static IOException streamClosed() throws IOException {
        throw new IOException("BufferedInputStream is closed");
    }

    public synchronized void fixMarkLimit() {
        this.marklimit = this.buf.length;
    }

    public void close() throws IOException {
        this.buf = null;
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    private int fillbuf(InputStream inputStream, byte[] bArr) throws IOException {
        if (this.markpos != -1) {
            if (this.pos - this.markpos < this.marklimit) {
                if (this.markpos == 0 && this.marklimit > bArr.length && this.count == bArr.length) {
                    int length = bArr.length * 2;
                    if (length > this.marklimit) {
                        length = this.marklimit;
                    }
                    Object obj = new byte[length];
                    System.arraycopy(bArr, 0, obj, 0, bArr.length);
                    this.buf = obj;
                    bArr = obj;
                } else if (this.markpos > 0) {
                    System.arraycopy(bArr, this.markpos, bArr, 0, bArr.length - this.markpos);
                }
                this.pos -= this.markpos;
                this.markpos = 0;
                this.count = 0;
                inputStream = inputStream.read(bArr, this.pos, bArr.length - this.pos);
                if (inputStream <= null) {
                    bArr = this.pos;
                } else {
                    bArr = this.pos + inputStream;
                }
                this.count = bArr;
                return inputStream;
            }
        }
        inputStream = inputStream.read(bArr);
        if (inputStream > null) {
            this.markpos = -1;
            this.pos = 0;
            this.count = inputStream;
        }
        return inputStream;
    }

    public synchronized void mark(int i) {
        this.marklimit = Math.max(this.marklimit, i);
        this.markpos = this.pos;
    }

    public synchronized int read() throws IOException {
        byte[] bArr = this.buf;
        InputStream inputStream = this.in;
        if (bArr != null) {
            if (inputStream != null) {
                if (this.pos >= this.count && fillbuf(inputStream, bArr) == -1) {
                    return -1;
                }
                if (bArr != this.buf) {
                    bArr = this.buf;
                    if (bArr == null) {
                        throw streamClosed();
                    }
                }
                if (this.count - this.pos <= 0) {
                    return -1;
                }
                int i = this.pos;
                this.pos = i + 1;
                return bArr[i] & 255;
            }
        }
        throw streamClosed();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized int read(byte[] r6, int r7, int r8) throws java.io.IOException {
        /*
        r5 = this;
        monitor-enter(r5);
        r0 = r5.buf;	 Catch:{ all -> 0x009d }
        if (r0 != 0) goto L_0x000a;
    L_0x0005:
        r6 = streamClosed();	 Catch:{ all -> 0x009d }
        throw r6;	 Catch:{ all -> 0x009d }
    L_0x000a:
        if (r8 != 0) goto L_0x000f;
    L_0x000c:
        r6 = 0;
        monitor-exit(r5);
        return r6;
    L_0x000f:
        r1 = r5.in;	 Catch:{ all -> 0x009d }
        if (r1 != 0) goto L_0x0018;
    L_0x0013:
        r6 = streamClosed();	 Catch:{ all -> 0x009d }
        throw r6;	 Catch:{ all -> 0x009d }
    L_0x0018:
        r2 = r5.pos;	 Catch:{ all -> 0x009d }
        r3 = r5.count;	 Catch:{ all -> 0x009d }
        if (r2 >= r3) goto L_0x0045;
    L_0x001e:
        r2 = r5.count;	 Catch:{ all -> 0x009d }
        r3 = r5.pos;	 Catch:{ all -> 0x009d }
        r2 = r2 - r3;
        if (r2 < r8) goto L_0x0027;
    L_0x0025:
        r2 = r8;
        goto L_0x002c;
    L_0x0027:
        r2 = r5.count;	 Catch:{ all -> 0x009d }
        r3 = r5.pos;	 Catch:{ all -> 0x009d }
        r2 = r2 - r3;
    L_0x002c:
        r3 = r5.pos;	 Catch:{ all -> 0x009d }
        java.lang.System.arraycopy(r0, r3, r6, r7, r2);	 Catch:{ all -> 0x009d }
        r3 = r5.pos;	 Catch:{ all -> 0x009d }
        r3 = r3 + r2;
        r5.pos = r3;	 Catch:{ all -> 0x009d }
        if (r2 == r8) goto L_0x0043;
    L_0x0038:
        r3 = r1.available();	 Catch:{ all -> 0x009d }
        if (r3 != 0) goto L_0x003f;
    L_0x003e:
        goto L_0x0043;
    L_0x003f:
        r7 = r7 + r2;
        r2 = r8 - r2;
        goto L_0x0046;
    L_0x0043:
        monitor-exit(r5);
        return r2;
    L_0x0045:
        r2 = r8;
    L_0x0046:
        r3 = r5.markpos;	 Catch:{ all -> 0x009d }
        r4 = -1;
        if (r3 != r4) goto L_0x005b;
    L_0x004b:
        r3 = r0.length;	 Catch:{ all -> 0x009d }
        if (r2 < r3) goto L_0x005b;
    L_0x004e:
        r3 = r1.read(r6, r7, r2);	 Catch:{ all -> 0x009d }
        if (r3 != r4) goto L_0x008d;
    L_0x0054:
        if (r2 != r8) goto L_0x0058;
    L_0x0056:
        monitor-exit(r5);
        return r4;
    L_0x0058:
        r8 = r8 - r2;
        monitor-exit(r5);
        return r8;
    L_0x005b:
        r3 = r5.fillbuf(r1, r0);	 Catch:{ all -> 0x009d }
        if (r3 != r4) goto L_0x0068;
    L_0x0061:
        if (r2 != r8) goto L_0x0065;
    L_0x0063:
        monitor-exit(r5);
        return r4;
    L_0x0065:
        r8 = r8 - r2;
        monitor-exit(r5);
        return r8;
    L_0x0068:
        r3 = r5.buf;	 Catch:{ all -> 0x009d }
        if (r0 == r3) goto L_0x0075;
    L_0x006c:
        r0 = r5.buf;	 Catch:{ all -> 0x009d }
        if (r0 != 0) goto L_0x0075;
    L_0x0070:
        r6 = streamClosed();	 Catch:{ all -> 0x009d }
        throw r6;	 Catch:{ all -> 0x009d }
    L_0x0075:
        r3 = r5.count;	 Catch:{ all -> 0x009d }
        r4 = r5.pos;	 Catch:{ all -> 0x009d }
        r3 = r3 - r4;
        if (r3 < r2) goto L_0x007e;
    L_0x007c:
        r3 = r2;
        goto L_0x0083;
    L_0x007e:
        r3 = r5.count;	 Catch:{ all -> 0x009d }
        r4 = r5.pos;	 Catch:{ all -> 0x009d }
        r3 = r3 - r4;
    L_0x0083:
        r4 = r5.pos;	 Catch:{ all -> 0x009d }
        java.lang.System.arraycopy(r0, r4, r6, r7, r3);	 Catch:{ all -> 0x009d }
        r4 = r5.pos;	 Catch:{ all -> 0x009d }
        r4 = r4 + r3;
        r5.pos = r4;	 Catch:{ all -> 0x009d }
    L_0x008d:
        r2 = r2 - r3;
        if (r2 != 0) goto L_0x0092;
    L_0x0090:
        monitor-exit(r5);
        return r8;
    L_0x0092:
        r4 = r1.available();	 Catch:{ all -> 0x009d }
        if (r4 != 0) goto L_0x009b;
    L_0x0098:
        r8 = r8 - r2;
        monitor-exit(r5);
        return r8;
    L_0x009b:
        r7 = r7 + r3;
        goto L_0x0046;
    L_0x009d:
        r6 = move-exception;
        monitor-exit(r5);
        throw r6;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream.read(byte[], int, int):int");
    }

    public synchronized void reset() throws IOException {
        if (this.buf == null) {
            throw new IOException("Stream is closed");
        } else if (-1 == this.markpos) {
            throw new InvalidMarkException("Mark has been invalidated");
        } else {
            this.pos = this.markpos;
        }
    }

    public synchronized long skip(long j) throws IOException {
        byte[] bArr = this.buf;
        InputStream inputStream = this.in;
        if (bArr == null) {
            throw streamClosed();
        } else if (j < 1) {
            return 0;
        } else {
            if (inputStream == null) {
                throw streamClosed();
            } else if (((long) (this.count - this.pos)) >= j) {
                this.pos = (int) (((long) this.pos) + j);
                return j;
            } else {
                long j2 = (long) (this.count - this.pos);
                this.pos = this.count;
                if (this.markpos == -1 || j > ((long) this.marklimit)) {
                    return j2 + inputStream.skip(j - j2);
                } else if (fillbuf(inputStream, bArr) == -1) {
                    return j2;
                } else {
                    long j3 = j - j2;
                    if (((long) (this.count - this.pos)) >= j3) {
                        this.pos = (int) (((long) this.pos) + j3);
                        return j;
                    }
                    j2 = (j2 + ((long) this.count)) - ((long) this.pos);
                    this.pos = this.count;
                    return j2;
                }
            }
        }
    }
}
