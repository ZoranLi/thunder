package com.tencent.tinker.android.dx.instruction;

/* compiled from: BUGLY */
public final class ShortArrayCodeOutput extends CodeCursor {
    private short[] array;

    public ShortArrayCodeOutput(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("initSize < 0");
        }
        this.array = new short[i];
    }

    public ShortArrayCodeOutput(short[] sArr) {
        if (sArr == null) {
            throw new IllegalArgumentException("array is null.");
        }
        this.array = sArr;
    }

    public final short[] getArray() {
        int cursor = cursor();
        if (cursor == this.array.length) {
            return this.array;
        }
        Object obj = new short[cursor];
        System.arraycopy(this.array, 0, obj, 0, cursor);
        return obj;
    }

    public final void write(short s) {
        ensureArrayLength(1);
        this.array[cursor()] = s;
        advance(1);
    }

    public final void write(short s, short s2) {
        write(s);
        write(s2);
    }

    public final void write(short s, short s2, short s3) {
        write(s);
        write(s2);
        write(s3);
    }

    public final void write(short s, short s2, short s3, short s4) {
        write(s);
        write(s2);
        write(s3);
        write(s4);
    }

    public final void write(short s, short s2, short s3, short s4, short s5) {
        write(s);
        write(s2);
        write(s3);
        write(s4);
        write(s5);
    }

    public final void writeInt(int i) {
        write((short) i);
        write((short) (i >> 16));
    }

    public final void writeLong(long j) {
        write((short) ((int) j));
        write((short) ((int) (j >> 16)));
        write((short) ((int) (j >> 32)));
        write((short) ((int) (j >> 48)));
    }

    public final void write(byte[] bArr) {
        int length = bArr.length;
        Object obj = 1;
        int i = 0;
        int i2 = i;
        while (i < length) {
            byte b = bArr[i];
            if (obj != null) {
                i2 = b & 255;
                obj = null;
            } else {
                int i3 = (b << 8) | i2;
                write((short) i3);
                i2 = i3;
                obj = 1;
            }
            i++;
        }
        if (obj == null) {
            write((short) i2);
        }
    }

    public final void write(short[] sArr) {
        for (short write : sArr) {
            write(write);
        }
    }

    public final void write(int[] iArr) {
        for (int writeInt : iArr) {
            writeInt(writeInt);
        }
    }

    public final void write(long[] jArr) {
        for (long writeLong : jArr) {
            writeLong(writeLong);
        }
    }

    private void ensureArrayLength(int i) {
        int cursor = cursor();
        if (this.array.length - cursor < i) {
            i = new short[(this.array.length + (this.array.length >> 1))];
            System.arraycopy(this.array, 0, i, 0, cursor);
            this.array = i;
        }
    }
}
