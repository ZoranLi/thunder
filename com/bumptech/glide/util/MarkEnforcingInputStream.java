package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MarkEnforcingInputStream extends FilterInputStream {
    private static final int END_OF_STREAM = -1;
    private static final int UNSET = Integer.MIN_VALUE;
    private int availableBytes = Integer.MIN_VALUE;

    public MarkEnforcingInputStream(InputStream inputStream) {
        super(inputStream);
    }

    public void mark(int i) {
        super.mark(i);
        this.availableBytes = i;
    }

    public int read() throws IOException {
        if (getBytesToRead(1) == -1) {
            return -1;
        }
        int read = super.read();
        updateAvailableBytesAfterRead(1);
        return read;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        i2 = (int) getBytesToRead((long) i2);
        if (i2 == -1) {
            return -1;
        }
        bArr = super.read(bArr, i, i2);
        updateAvailableBytesAfterRead((long) bArr);
        return bArr;
    }

    public void reset() throws IOException {
        super.reset();
        this.availableBytes = Integer.MIN_VALUE;
    }

    public long skip(long j) throws IOException {
        j = getBytesToRead(j);
        if (j == -1) {
            return -1;
        }
        j = super.skip(j);
        updateAvailableBytesAfterRead(j);
        return j;
    }

    public int available() throws IOException {
        return this.availableBytes == Integer.MIN_VALUE ? super.available() : Math.min(this.availableBytes, super.available());
    }

    private long getBytesToRead(long j) {
        if (this.availableBytes == 0) {
            return -1;
        }
        return (this.availableBytes == Integer.MIN_VALUE || j <= ((long) this.availableBytes)) ? j : (long) this.availableBytes;
    }

    private void updateAvailableBytesAfterRead(long j) {
        if (this.availableBytes != Integer.MIN_VALUE && j != -1) {
            this.availableBytes = (int) (((long) this.availableBytes) - j);
        }
    }
}
