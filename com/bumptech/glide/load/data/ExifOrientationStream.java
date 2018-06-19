package com.bumptech.glide.load.data;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ExifOrientationStream extends FilterInputStream {
    private static final byte[] EXIF_SEGMENT = new byte[]{(byte) -1, (byte) -31, (byte) 0, (byte) 28, (byte) 69, (byte) 120, (byte) 105, (byte) 102, (byte) 0, (byte) 0, (byte) 77, (byte) 77, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 8, (byte) 0, (byte) 1, (byte) 1, (byte) 18, (byte) 0, (byte) 2, (byte) 0, (byte) 0, (byte) 0, (byte) 1, (byte) 0};
    private static final int ORIENTATION_POSITION = 31;
    private static final int SEGMENT_LENGTH = 29;
    private static final int SEGMENT_START_POSITION = 2;
    private final byte orientation;
    private int position;

    public boolean markSupported() {
        return false;
    }

    public ExifOrientationStream(InputStream inputStream, int i) {
        super(inputStream);
        if (i >= -1) {
            if (i <= 8) {
                this.orientation = (byte) i;
                return;
            }
        }
        StringBuilder stringBuilder = new StringBuilder("Cannot add invalid orientation: ");
        stringBuilder.append(i);
        throw new IllegalArgumentException(stringBuilder.toString());
    }

    public void mark(int i) {
        throw new UnsupportedOperationException();
    }

    public int read() throws IOException {
        int i;
        if (this.position >= 2) {
            if (this.position <= ORIENTATION_POSITION) {
                if (this.position == ORIENTATION_POSITION) {
                    i = this.orientation;
                } else {
                    i = EXIF_SEGMENT[this.position - 2] & 255;
                }
                if (i != -1) {
                    this.position++;
                }
                return i;
            }
        }
        i = super.read();
        if (i != -1) {
            this.position++;
        }
        return i;
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.position > ORIENTATION_POSITION) {
            bArr = super.read(bArr, i, i2);
        } else if (this.position == ORIENTATION_POSITION) {
            bArr[i] = this.orientation;
            bArr = 1;
        } else if (this.position < 2) {
            bArr = super.read(bArr, i, 2 - this.position);
        } else {
            i2 = Math.min(ORIENTATION_POSITION - this.position, i2);
            System.arraycopy(EXIF_SEGMENT, this.position - 2, bArr, i, i2);
            bArr = i2;
        }
        if (bArr > null) {
            this.position += bArr;
        }
        return bArr;
    }

    public long skip(long j) throws IOException {
        j = super.skip(j);
        if (j > 0) {
            this.position = (int) (((long) this.position) + j);
        }
        return j;
    }

    public void reset() throws IOException {
        throw new UnsupportedOperationException();
    }
}
